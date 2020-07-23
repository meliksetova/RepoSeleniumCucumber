package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static Date getDateUsingMMMDDYYYY(String dateString) {
        SimpleDateFormat makeDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Date date = null; // creates Date object using String
        try {
            date = makeDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateUsingMMMMDD(String dateString) {
        SimpleDateFormat makeDateFormat = new SimpleDateFormat("MMMM dd");
        Date date = null; // creates Date object using String
        try {
            date = makeDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

  public static Date getDateUsingMMMMDDYYYY(String dateString) {
        SimpleDateFormat makeDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Date date = null; // creates Date object using String
        try {
            date = makeDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getCurrentDateValue() {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(now);
    }

    public static String getTomorrowDateValue() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(cal.getTime());
    }

    public static String getYesterdayDateValue() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(cal.getTime());
    }

    public static String getDateValue(String date){
        Calendar cal = Calendar.getInstance();
        Date checkInDate=getDateUsingMMMMDD(date);
        cal.setTime(checkInDate);
        cal.add(Calendar.YEAR,50);
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(cal.getTime());


    }
     public static String getDateValueXDaysFromToday(int count) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, count);
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(cal.getTime());
    }

    public static String getDateValueXDaysFromTomorrow(int count) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        cal.add(Calendar.DATE,count);
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(cal.getTime());
    }

    public static String getDateValueXDaysFromDate(String date,int count) {
        Calendar cal = Calendar.getInstance();
        Date checkInDate=getDateUsingMMMMDD(date);
        cal.setTime(checkInDate);
        cal.add(Calendar.DATE,count);
        cal.add(Calendar.YEAR,50);
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(cal.getTime());
    }


    public static String getCurrentMonthValue() {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(now);
    }

    public static String getTomorrowMonthValue() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(cal.getTime());
    }

    public static String getYesterdayMonthValue() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(cal.getTime());
    }

    public static String getMonthValue(String date){
        Calendar cal = Calendar.getInstance();
        Date checkInDate=getDateUsingMMMMDD(date);
        cal.setTime(checkInDate);
        cal.add(Calendar.YEAR,50);
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(cal.getTime());


    }
    public static String getMonthValueXDaysFromToday(int count) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, count);
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(cal.getTime());
    }

    public static String getMonthValueXDaysFromTomorrow(int count) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        cal.add(Calendar.DATE,count);
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(cal.getTime());
    }

    public static String getMonthValueXDaysFromDate(String date,int count) {
        Calendar cal = Calendar.getInstance();
        Date checkInDate=getDateUsingMMMMDD(date);
        cal.setTime(checkInDate);
        cal.add(Calendar.DATE,count);
        SimpleDateFormat df = new SimpleDateFormat("MMMM");
        return df.format(cal.getTime());
    }

}

