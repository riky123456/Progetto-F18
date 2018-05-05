package test;

import engine.Customer;
import engine.Dog;
import engine.DogSitter;
import engine.SearchEngine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import static staticClasses.ObjectCreator.createCustomerFromDB;
import static staticClasses.ObjectCreator.createDogSitterFromDB;

public class TestSearchEngine {
    public static void main(String[] args) {
        SearchEngine se = new SearchEngine();
        Customer c = createCustomerFromDB("RICCARDOGIURA@GMAIL.COM");
        DogSitter ds = createDogSitterFromDB("MARCO.CARTA@GMAIL.COM");
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = date.parse("07/05/2018 13:00");
            endDate = date.parse("07/05/2018 15:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HashSet<DogSitter> dogSitterList = se.search(startDate,endDate, ds.getAddress(), c.getDogList(), true);
    }
}
