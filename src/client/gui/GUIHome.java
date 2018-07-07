package client.gui;

import client.clientEnumerations.CalendarAction;
import client.proxy.Proxy;
import server.Assignment;
import enumeration.CalendarState;
import server.dateTime.WeekDays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import static client.Calendar.getNDayofMonth;

public abstract class GUIHome extends JFrame{
    final int WIDTH = 1024;
    final int HEIGHT = 600;
    final int NDAYMONTH = 31;
    final int NDAYWEEK = 7;
    final int NEMPTYLABEL = 11;
    final int NCALENDARCELLS = 49;
    final int MAXVISIBLETODAYASSIGNMENT = 5;

    private Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
    protected JMenuBar menuBar = new JMenuBar();
    protected JMenu menuFile = new JMenu("Canibau");
    protected JMenuItem menuItemExit = new JMenuItem("Quit");
    protected JMenuItem menuItemLogout = new JMenuItem("Logout");
    protected JMenu menuAssignment = new JMenu("Assignment");
    protected JMenuItem menuItemShowAssignments = new JMenuItem("Show all assignments");
    protected JMenu menuReview = new JMenu("Review");
    protected JMenuItem menuItemShowReviews = new JMenuItem("Show all reviews");
    protected JMenu menuSettings = new JMenu("Settings");
    protected JMenuItem menuItemAccount = new JMenuItem("Account");
    protected JMenuItem menuItemChangePassword = new JMenuItem("Change Password");
    protected JMenu menuExtra = new JMenu("?");
    protected JMenuItem menuItemInfo = new JMenuItem("Info");
    protected JMenuItem menuItemAwards = new JMenuItem("Credits");

    protected JPanel panelToday = new JPanel();
    protected JLabel labelTodayAssignments = new JLabel("Today's assignments");
    protected JButton buttonTodayAssignment[];
    protected JButton buttonShowMoreTodayAssignments = new JButton("Show more");
    protected JLabel labelEmptyTodayAssignments[];
    protected int nTodayAssignments = 0;

    protected JPanel calendar = new JPanel();
    protected JPanel panelDateCalendar = new JPanel();
    protected JPanel panelGridCalendar = new JPanel();
    protected JLabel labelDay[];
    protected JButton buttonDay[];
    protected JLabel labelEmpty[];
    /*protected JButton buttonPreviousYear = new JButton("<<");
    protected JButton buttonPreviousMonth = new JButton("<");
    protected JButton buttonNextYear = new JButton(">>");
    protected JButton buttonNextMonth = new JButton(">");*/
    protected JButton buttonPreviousYear = new JButton("Previous year");
    protected JButton buttonPreviousMonth = new JButton("Previous month");
    protected JButton buttonNextYear = new JButton("Next year");
    protected JButton buttonNextMonth = new JButton("Next Month");
    protected JLabel labelDateMonthYear = new JLabel("08/2019", SwingConstants.CENTER);
    protected CalendarState calendarState = CalendarState.NORMAL;

    private String email;
    protected HashSet<Integer> codeFirstFiveAssignmentsList = new HashSet<Integer>();


    public GUIHome(String email) throws ParseException {
        setTitle("CaniBau");
        setSize(WIDTH, HEIGHT);
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        this.email = email;
    }

    protected void startCalendar(ActionListener cal, ActionListener ctrlCal, Proxy proxy) throws ParseException {
        calendar.setLayout(new BorderLayout());
        panelDateCalendar.setLayout(new GridLayout(1, 5));
        panelDateCalendar.add(buttonPreviousYear);
        panelDateCalendar.add(buttonPreviousMonth);
        panelDateCalendar.add(labelDateMonthYear);
        panelDateCalendar.add(buttonNextMonth);
        panelDateCalendar.add(buttonNextYear);
        calendar.add(panelDateCalendar, BorderLayout.NORTH);
        panelGridCalendar.setLayout((new GridLayout(7, 7, 5, 5)));
        calendar.add(panelGridCalendar, BorderLayout.CENTER);
        labelDay = new JLabel[NDAYWEEK];
        int i = 0;
        for (WeekDays wd: WeekDays.values()) {
            labelDay[i] = new JLabel(wd.toString(), SwingConstants.CENTER);
            panelGridCalendar.add(labelDay[i]);
            i++;
        }

        //ottiene informazioni sul sistema operativo utilizzato
        String os = System.getProperty("os.name");

        buttonDay = new JButton[NDAYMONTH];
        for (i = 0; i < NDAYMONTH; i++){
            buttonDay[i] = new JButton(Integer.toString(i + 1));
            buttonDay[i].setBackground(new Color(204, 230, 255));
            buttonDay[i].addActionListener(cal);
            if (os.equals("Mac OS X")){
                buttonDay[i].setOpaque(true);
                buttonDay[i].setBorderPainted(false);
            }
        }

        add(calendar, BorderLayout.CENTER);
        initializeCalendar(proxy);

        buttonPreviousMonth.addActionListener(ctrlCal);
        buttonNextMonth.addActionListener(ctrlCal);
        buttonPreviousYear.addActionListener(ctrlCal);
        buttonNextYear.addActionListener(ctrlCal);
    }

    protected void initializeCalendar(Proxy proxy) throws ParseException {
        SimpleDateFormat dateMonth = new SimpleDateFormat("MM");
        Date currentMonth = new Date();
        int monthNumber = Integer.parseInt(dateMonth.format(currentMonth));
        SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
        Date currentYear = new Date();
        labelDateMonthYear.setText(dateMonth.format(currentMonth) + "/" + dateYear.format(currentYear));
        updateCalendar(monthNumber, proxy);
    }

    protected void goBackMonthCalendar(Proxy proxy) throws ParseException {
        panelGridCalendar.removeAll();
        panelGridCalendar.revalidate();
        panelGridCalendar.repaint();
        int i = 0;
        for (WeekDays wd: WeekDays.values()) {
            labelDay[i] = new JLabel(wd.toString(), SwingConstants.CENTER);
            panelGridCalendar.add(labelDay[i]);
            i++;
        }

        SimpleDateFormat dateMonthYear = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat dateMonth = new SimpleDateFormat("M");
        SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
        Date date = dateMonthYear.parse(labelDateMonthYear.getText());
        String strMonthNumber = dateMonth.format(date);
        String strYear = dateYear.format(date);
        int monthNumber = Integer.parseInt(strMonthNumber) - 1;
        if (monthNumber == 0){
            monthNumber = 12;
            Integer newYear = Integer.parseInt(strYear) - 1;
            strYear = newYear.toString();
        }
        if (monthNumber < 10){
            labelDateMonthYear.setText("0" + monthNumber + "/" + strYear);
        } else {
            labelDateMonthYear.setText(monthNumber + "/" + strYear);
        }

        updateCalendar(monthNumber, proxy);
    }

    protected void goBackYearCalendar(Proxy proxy) throws ParseException {
        panelGridCalendar.removeAll();
        panelGridCalendar.revalidate();
        panelGridCalendar.repaint();
        int i = 0;
        for (WeekDays wd: WeekDays.values()) {
            labelDay[i] = new JLabel(wd.toString(), SwingConstants.CENTER);
            panelGridCalendar.add(labelDay[i]);
            i++;
        }

        SimpleDateFormat dateMonthYear = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat dateMonth = new SimpleDateFormat("M");
        SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
        Date date = dateMonthYear.parse(labelDateMonthYear.getText());
        String strMonthNumber = dateMonth.format(date);
        String strYear = dateYear.format(date);
        int monthNumber = Integer.parseInt(strMonthNumber);
        Integer newYear = Integer.parseInt(strYear) - 1;
        strYear = newYear.toString();
        if (monthNumber < 10){
            labelDateMonthYear.setText("0" + monthNumber + "/" + strYear);
        } else {
            labelDateMonthYear.setText(monthNumber + "/" + strYear);
        }

        updateCalendar(monthNumber, proxy);
    }

    protected void goForwardMonthCalendar(Proxy proxy) throws ParseException {
        panelGridCalendar.removeAll();
        panelGridCalendar.revalidate();
        panelGridCalendar.repaint();
        int i = 0;
        for (WeekDays wd: WeekDays.values()) {
            labelDay[i] = new JLabel(wd.toString(), SwingConstants.CENTER);
            panelGridCalendar.add(labelDay[i]);
            i++;
        }

        SimpleDateFormat dateMonthYear = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat dateMonth = new SimpleDateFormat("M");
        SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
        Date date = dateMonthYear.parse(labelDateMonthYear.getText());
        String strMonthNumber = dateMonth.format(date);
        String strYear = dateYear.format(date);
        int monthNumber = Integer.parseInt(strMonthNumber) + 1;
        if (monthNumber == 13){
            monthNumber = 1;
            Integer newYear = Integer.parseInt(strYear) + 1;
            strYear = newYear.toString();
        }
        if (monthNumber < 10){
            labelDateMonthYear.setText("0" + monthNumber + "/" + strYear);
        } else {
            labelDateMonthYear.setText(monthNumber + "/" + strYear);
        }

        updateCalendar(monthNumber, proxy);
    }

    protected void goForwardYearCalendar(Proxy proxy) throws ParseException {
        panelGridCalendar.removeAll();
        panelGridCalendar.revalidate();
        panelGridCalendar.repaint();
        int i = 0;
        for (WeekDays wd: WeekDays.values()) {
            labelDay[i] = new JLabel(wd.toString(), SwingConstants.CENTER);
            panelGridCalendar.add(labelDay[i]);
            i++;
        }

        SimpleDateFormat dateMonthYear = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat dateMonth = new SimpleDateFormat("M");
        SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
        Date date = dateMonthYear.parse(labelDateMonthYear.getText());
        String strMonthNumber = dateMonth.format(date);
        String strYear = dateYear.format(date);
        int monthNumber = Integer.parseInt(strMonthNumber);
        Integer newYear = Integer.parseInt(strYear) + 1;
        strYear = newYear.toString();
        if (monthNumber < 10){
            labelDateMonthYear.setText("0" + monthNumber + "/" + strYear);
        } else {
            labelDateMonthYear.setText(monthNumber + "/" + strYear);
        }

        updateCalendar(monthNumber, proxy);
    }

    protected void updateCalendar(int monthNumber, Proxy proxy) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = "01/" + labelDateMonthYear.getText();
        Date currentDate = date.parse(strDate);
        SimpleDateFormat dateDayNumber = new SimpleDateFormat("u");
        dateDayNumber.setLenient(false);
        String stringDayNumber = dateDayNumber.format(currentDate);
        int dayNumber = Integer.parseInt(stringDayNumber);
        int i;
        int ie;
        int ne = 0;
        int cc = NDAYWEEK;
        labelEmpty= new JLabel[NEMPTYLABEL];
        switch (dayNumber){
            case 1:
                ne = 0;
                break;
            case 2:
                ne = 1;
                break;
            case 3:
                ne = 2;
                break;
            case 4:
                ne = 3;
                break;
            case 5:
                ne = 4;
                break;
            case 6:
                ne = 5;
                break;
            case 7:
                ne = 6;
                break;
        }
        for (ie = 0; ie < ne; ie++){
            labelEmpty[ie] = new JLabel();
            panelGridCalendar.add(labelEmpty[ie]);
            cc++;
        }

        i = 0;
        int nd = getNDayofMonth(monthNumber, currentDate);

        for (i = 0; i < nd; i++){
            panelGridCalendar.add(buttonDay[i]);
            cc++;
        }

        while (cc < NCALENDARCELLS){
            labelEmpty[ie] = new JLabel();
            panelGridCalendar.add(labelEmpty[ie]);
            cc++;
        }

        if ((calendarState.equals(CalendarState.ADDING)) || (calendarState.equals(CalendarState.REMOVING))){
            enableDisableDateButtonAssignment();
        }

        for (i = 0; i < NDAYMONTH; i++){
            if (!(calendarState.equals(CalendarState.ADDING)) && !(calendarState.equals(CalendarState.REMOVING))){
                buttonDay[i].setBackground(new Color(204, 230, 255));
            }

            String strCurrentDate = date.format(new Date());
            String dateButton;
            int nDay = Integer.parseInt(buttonDay[i].getText());
            if (nDay < 10){
                dateButton = "0" + buttonDay[i].getText() + "/" + labelDateMonthYear.getText();
            } else {
                dateButton = buttonDay[i].getText() + "/" + labelDateMonthYear.getText();
            }
            if (dateButton.equals(strCurrentDate)){
                buttonDay[i].setForeground(new Color(255, 0, 0));
            } else {
                buttonDay[i].setForeground(new Color(0, 0, 0));
            }
        }

        if (!(calendarState.equals(CalendarState.ADDING)) && !(calendarState.equals(CalendarState.REMOVING))){
            showAssignmentOnCalendar(email, proxy);
        }
    }

    protected void openListAssignment(Proxy proxy){
        GUIListAssignments guiListAssignments = new GUIListAssignments(calendarState, proxy.getAssignmentList(), email, this);
        guiListAssignments.setVisible(true);

    }

    public void setCalendarState(CalendarState cs){
        calendarState = cs;
    }

    protected void enableDisableDateButtonAssignment() throws ParseException {
        int i;
        String strDay;
        String strSelectedDate;
        Date selectedDate;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        for (i = 0; i < NDAYMONTH; i++){
            Integer day = Integer.parseInt(buttonDay[i].getText());
            if (day < 10){
                strDay = "0" + day;
            } else {
                strDay = day.toString();
            }
            strSelectedDate = strDay + "/" + labelDateMonthYear.getText();
            selectedDate = formatDate.parse(strSelectedDate);
            if (selectedDate.before(currentDate)){
                buttonDay[i].setEnabled(false);
            } else {
                buttonDay[i].setEnabled(true);
            }
        }
    }

    protected void showAssignmentOnCalendar(String email, Proxy proxy){
        HashMap<Integer, Assignment> listAssignment = proxy.getAssignmentList();
        boolean included = false;
        for (Integer key : listAssignment.keySet()) {
            Assignment a = listAssignment.get(key);
            Date dateStart = a.getDateStart();
            Date dateEnd = a.getDateEnd();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            String strDateStart = date.format(dateStart);
            String strDateEnd = date.format(dateEnd);
            int i;
            String strButtonDate;
            for (i = 0; i < NDAYMONTH; i++){
                int day = i + 1;
                if (day < 10){
                    strButtonDate = "0" + buttonDay[i].getText() + "/" + labelDateMonthYear.getText();
                } else {
                    strButtonDate = buttonDay[i].getText() + "/" + labelDateMonthYear.getText();
                }
                if (strButtonDate.equals(strDateStart) ){
                    buttonDay[i].setBackground(Color.ORANGE);
                    included = true;
                }
                if (strButtonDate.equals(strDateEnd) ){
                    buttonDay[i].setBackground(Color.ORANGE);
                    included = false;
                }
                if (included){
                    buttonDay[i].setBackground(Color.ORANGE);
                }
            }
        }
    }

    protected int getNDailyAssignments(Proxy proxy){
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        int nAssignments = 0;
        HashMap<Integer, Assignment> listAssignment = proxy.getAssignmentList();
        for (Integer key : listAssignment.keySet()) {
            Assignment a = listAssignment.get(key);
            String strDateStart = date.format(a.getDateStart());
            String strTodayDate = date.format(todayDate);
            String strDateEnd = date.format(a.getDateEnd());
            try {
                Date dayStart = date.parse(strDateStart);
                Date dayEnd = date.parse(strDateEnd);
                Date today = date.parse(strTodayDate);

                if ((today.after(dayStart) || today.equals(dayStart)) && (today.before(dayEnd)) || today.equals(dayEnd)){
                    nAssignments++;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return nAssignments;
    }

    protected int disposeTodayAssignmentList(){
        int i;
        int nShownTodayAssignments = 0;
        if (nTodayAssignments <= MAXVISIBLETODAYASSIGNMENT){
            buttonTodayAssignment = new JButton[nTodayAssignments];
            for (i = 0; i < nTodayAssignments; i++){
                disposeButtonsTodayAssignment(i);
            }
        } else {
            buttonTodayAssignment = new JButton[MAXVISIBLETODAYASSIGNMENT];
            for (i = 0; i < MAXVISIBLETODAYASSIGNMENT; i++){
                disposeButtonsTodayAssignment(i);
            }
        }

        if ((nTodayAssignments > 0) && (nTodayAssignments <= MAXVISIBLETODAYASSIGNMENT)){
            labelEmptyTodayAssignments = new JLabel[MAXVISIBLETODAYASSIGNMENT - nTodayAssignments + 1];
            for (i = 0; i < MAXVISIBLETODAYASSIGNMENT - nTodayAssignments + 1; i++){
                labelEmptyTodayAssignments[i] = new JLabel();
                panelToday.add(labelEmptyTodayAssignments[i]);
                nShownTodayAssignments = nTodayAssignments;
            }
        } else if (nTodayAssignments > MAXVISIBLETODAYASSIGNMENT){
            panelToday.add(buttonShowMoreTodayAssignments);
            nShownTodayAssignments = MAXVISIBLETODAYASSIGNMENT;
        } else {
            labelEmptyTodayAssignments = new JLabel[1];
            labelEmptyTodayAssignments[0] = new JLabel("No assignment to show", SwingConstants.CENTER);
            panelToday.add(labelEmptyTodayAssignments[0]);
            nShownTodayAssignments = 0;
        }
        return nShownTodayAssignments;
    }


    private void disposeButtonsTodayAssignment(int i){
        buttonTodayAssignment[i] = new JButton(" ");
        buttonTodayAssignment[i].setBackground(new Color(179, 237, 255));
        buttonTodayAssignment[i].setOpaque(true);
        buttonTodayAssignment[i].setBorderPainted(false);
        //buttonTodayAssignment[i].setDisplayedMnemonicIndex(i);
        panelToday.add(buttonTodayAssignment[i]);
    }

    protected void execCalendarAction(String cmd, Proxy proxy){
        try {
            cmd = cmd.toUpperCase();
            cmd = cmd.replace(" ", "");
            CalendarAction calendarAction = CalendarAction.valueOf(cmd);
            switch (calendarAction){
                case NEXTYEAR:
                    goForwardYearCalendar(proxy);
                    break;
                case NEXTMONTH:
                    goForwardMonthCalendar(proxy);
                    break;
                case PREVIOUSYEAR:
                    goBackYearCalendar(proxy);
                    break;
                case PREVIOUSMONTH:
                    goBackMonthCalendar(proxy);
                    break;
                case SHOWMORE:
                    String strTodayDate;
                    Date todayDate = new Date();
                    GUIDailyAssignments guiDailyAssignments = new GUIDailyAssignments(calendarState, email, todayDate);
                    guiDailyAssignments.setVisible(true);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected abstract void disposeMenuBar();

    protected int disposeTodayPanel(Proxy proxy){
        panelToday.setLayout(new GridLayout(7, 1, 5, 5));
        panelToday.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        labelTodayAssignments.setForeground(new Color(0,0, 255));
        labelTodayAssignments.setFont(new Font("Serif", Font.BOLD, 24));
        panelToday.add(labelTodayAssignments);

        //restituisce il numero di appuntamenti del giorno
        nTodayAssignments = getNDailyAssignments(proxy);

        int nShownTodayAssignments = disposeTodayAssignmentList();

        //carica i primi 5 appuntamenti del giorno
        loadTheFirstFiveAssignments(nShownTodayAssignments);


        add(panelToday, BorderLayout.EAST);
        return nShownTodayAssignments;
    }

    protected abstract void loadTheFirstFiveAssignments(int nShownTodayAssignments);

    protected abstract void clickOnCalendarButton(ActionEvent cae);

    protected void clickOnCtrlCalendarButton(ActionEvent ctrlAe, Proxy proxy){
        if (!(ctrlAe.getActionCommand().equals(""))){
            JButton pressedButton = (JButton) ctrlAe.getSource();
            execCalendarAction(pressedButton.getText(), proxy);
        }
    }

    public abstract void showAllAssignments();

    public abstract void showAllReviews();

    public abstract void accountSettings();

    public abstract void changePassword();

    public void info(){
        GUIInfo info = new GUIInfo();
        info.setVisible(true);
    }

    public void credits(){
        GUIAwards credits = new GUIAwards();
        credits.setVisible(true);
    }

}


