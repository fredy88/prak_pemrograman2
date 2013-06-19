package com.p2.belajardate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class LatihanTanggal {
    public static void main(String[] args){
        showDateFormat();
        showSimpleDateFormat();
    }
	
    public static void showDateFormat(){
        Date now=new Date();
        System.out.println("Date toString() format: "+now.toString());

        DateFormat datFor = DateFormat.getInstance();
        System.out.println("Default DateFormat : "+datFor.format(now));

        datFor.setTimeZone(TimeZone.getTimeZone("America/los_Angles"));
        System.out.println("Default Dateformat in west coaast: "+datFor.format(now));

        datFor = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.US);
        System.out.println("Short date time in US : "+datFor.format(now));

        datFor = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM,Locale.US);
        System.out.println("Medium date time in US : "+datFor.format(now));	

        datFor = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.FRENCH);
        System.out.println("Short date time in French : "+datFor.format(now));

        datFor = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.FRENCH);
        System.out.println("Long date time in French : "+datFor.format(now));

    }
	
    public static void showSimpleDateFormat(){
        Date now = new Date();
        System.out.println("Date toString() format : "+now.toString());

        SimpleDateFormat simDatFor = new SimpleDateFormat();
        System.out.println("Default SimpleDateFormat : "+simDatFor.format(now));

        simDatFor = new SimpleDateFormat("dd-MMM-YYYY");
        System.out.println("the FDA standart format : "+simDatFor.format(now));

        simDatFor = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        System.out.println("Date format : "+simDatFor.format(now));

        simDatFor = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.FRENCH);
        System.out.println("Date format french: "+simDatFor.format(now));
    }	
}
