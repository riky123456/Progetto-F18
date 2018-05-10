package engine;

import database.DBConnector;
import engine.DogSitter;
import enumeration.DogSize;
import staticClasses.dateTime.DateTimeDHMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import static staticClasses.ObjectCreator.createDogSitterFromDB;
import static staticClasses.dateTime.DateTimeTools.dateTimeDiff;

public class PlatformEngine {
    private HashSet<DogSitter> dogSitterList;
    private final int NDAYOFWEEK = 7;
    private final int NRANGE = 4;

    public PlatformEngine() {
        dogSitterList = new HashSet<DogSitter>();
        DBConnector dbConnector = new DBConnector();
        try {
            ResultSet rs = dbConnector.askDB("SELECT EMAIL FROM DOGSITTERS");
            while (rs.next()){
                DogSitter ds = createDogSitterFromDB(rs.getString("EMAIL"));
                dogSitterList.add(ds);
            }
            dbConnector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashSet<DogSitter> search(Date dateStart, Date dateEnd, Address meetingPoint, HashSet<Dog> dogList, boolean cash){
        //funzione da completare
        //al termine, rimuovere le System.out utili per il debug
        SimpleDateFormat dateNumDayOfWeek = new SimpleDateFormat("u");
        int nStartDay = Integer.parseInt(dateNumDayOfWeek.format(dateStart));
        int nEndDay = Integer.parseInt(dateNumDayOfWeek.format(dateEnd));

        searchStep0(meetingPoint);
        searchStep1(dateStart, dateEnd, nStartDay, nEndDay);
        searchStep2(dateStart, dateEnd, nStartDay, nEndDay);
        searchStep3(dogList);
        searchStep4(dogList);
        searchStep5(dateStart, dateEnd, dogList);
        searchStep6(cash);

        System.out.println("Dog sitters available:");
        for (DogSitter ds : dogSitterList) {
            System.out.println(ds.getEmail());
        }

        return dogSitterList;
    }

    private void searchStep0(Address meetingPoint){
        //funzione che filtra i dog sitter in base al meeting point
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        for (DogSitter ds : dogSitterList) {
            Area dogSitterArea = ds.getArea();
            if (!(dogSitterArea.contains(meetingPoint.getCity()))){
                toRemove.add(ds);
            }
        }
        for (DogSitter ds : toRemove) {
            dogSitterList.remove(ds);
        }
    }

    private void searchStep1(Date dateStart, Date dateEnd, int nStartDay, int nEndDay){
        //rimuove i dogsitter che non lavorano nei giorni richiesti dal cliente
        int i;
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        for (DogSitter ds : dogSitterList) {
            WorkingTime availability[] = ds.getDateTimeAvailability().getArrayDays();
            for (i = nStartDay - 1; i < nEndDay; i++){
                if ((availability[i].getStart() == null) && (availability[i].getEnd() == null)){
                    toRemove.add(ds);
                }
            }
        }
        for (DogSitter ds : toRemove) {
            dogSitterList.remove(ds);
        }
    }

    private void searchStep2(Date dateStart, Date dateEnd, int nStartDay, int nEndDay){
        //esclude i dog sitter che non lavorano negli orari di lavoro impostati dal cliente
        int i;
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        Time timeStart = new Time(dateStart.getTime());
        Time timeEnd = new Time(dateEnd.getTime());
        for (DogSitter ds : dogSitterList) {
            WorkingTime availability[] = ds.getDateTimeAvailability().getArrayDays();
            for (i = nStartDay - 1; i < nEndDay; i++){
                Time ts = availability[i].getStart();
                Time te = availability[i].getEnd();
                if ((timeStart.after(ts) || timeStart.equals(ts)) && (timeEnd.before(te) || timeEnd.equals(te))){
                    toRemove.add(ds);
                }
            }
        }

        for (DogSitter ds : toRemove) {
            dogSitterList.remove(ds);
        }
    }

    private void searchStep3(HashSet<Dog> dogList){
        //funzione che escude i dogsitter che non danno disponibilità
        //per il numero di cani richiesto dall'utente
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        for (DogSitter ds : dogSitterList) {
            if (ds.getDogNumber() < dogList.size()){
                toRemove.add(ds);
            }
        }
        for (DogSitter ds : toRemove) {
            dogSitterList.remove(ds);
        }
    }

    private void searchStep4(HashSet<Dog> dogList){
        //funzione che esclude i dogsitter che non danno dispobilità
        //per le taglie indicate dal cliente
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        for (DogSitter ds : dogSitterList) {
            HashSet<DogSize> listDogSize = ds.getListDogSize();
            for (Dog dog : dogList) {
                if (!(listDogSize.contains(dog.getSize()))){
                    toRemove.add(ds);
                }
            }
        }
        for (DogSitter ds : toRemove) {
            dogSitterList.remove(ds);
        }
    }

    private void searchStep5(Date dateStart, Date dateEnd, HashSet<Dog> dogList){
        //funzione che esclude i dog sitter che non lavorano negli orari di lavoro impostati dal cliente
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        for (DogSitter ds : dogSitterList) {
            HashMap<Integer, Assignment> listAssignment = ds.getListAssignment();
            for (Integer key : listAssignment.keySet()) {
                Assignment a = listAssignment.get(key);
                if (((dateStart.after(a.getDateStart()) || dateStart.equals(a.getDateStart())) && (dateStart.before(a.getDateStart()) || dateStart.equals(a.getDateStart()))) || ((dateEnd.after(a.getDateEnd()) || dateEnd.equals(a.getDateEnd())) && (dateEnd.before(a.getDateEnd()) || dateEnd.equals(a.getDateEnd())))){
                    toRemove.add(ds);
                }
            }
        }

        for (DogSitter ds : toRemove) {
            dogSitterList.remove(ds);
        }
    }

    private void searchStep6(boolean cash){
        //nel caso in cui il cliente vuole pagare in contanti,
        //esclude i dog sitter che accettano il pagamento solo con carta di credito
        HashSet<DogSitter> toRemove = new HashSet<DogSitter>();
        if (cash){
            for (DogSitter ds : dogSitterList) {
                if(ds.isAcceptingCash() == false){
                    toRemove.add(ds);
                }
            }
            for (DogSitter ds : toRemove) {
                dogSitterList.remove(ds);
            }
        }
    }

    public double estimatePriceAssignment(HashSet<Dog> dogList, Date dateStart, Date dateEnd){
        //funzione da completare
        DBConnector dbConnector = new DBConnector();
        double priceArray[] = new double[4];

        try {
            ResultSet rs = dbConnector.askDB("SELECT H_RANGE, PERC FROM PERC_PRICE");
            double hRange[] = new double[NRANGE];
            while (rs.next()){
                int n = rs.getInt("H_RANGE") - 1;
                hRange[n] = rs.getDouble("PERC");
            }
            dbConnector.closeConnection();
            rs = dbConnector.askDB("SELECT SIZE, PRICE FROM PRICE_LIST");
            while (rs.next()){
                if (rs.getString("SIZE").equals("SMALL")){
                    priceArray[0] = rs.getDouble("PRICE");
                } else if (rs.getString("SIZE").equals("MEDIUM")){
                    priceArray[1] = rs.getDouble("PRICE");
                } else if (rs.getString("SIZE").equals("BIG")){
                    priceArray[2] = rs.getDouble("PRICE");
                } else if (rs.getString("SIZE").equals("GIANT")){
                    priceArray[3] = rs.getDouble("PRICE");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        double price = 0;
        DateTimeDHMS workTime = dateTimeDiff(dateEnd, dateStart);

        for (Dog d : dogList) {
            if (workTime.getDays() > 0){
                //metodo da implementare
            }
        }
        return price;
    }

}