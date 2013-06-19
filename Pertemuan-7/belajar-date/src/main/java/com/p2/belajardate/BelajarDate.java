package com.p2.belajardate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BelajarDate {
    public static void main(String[] args){
        System.out.println("Waktu sekarang");
        DateFormat datFor = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dat= new Date();
        System.out.println(datFor.format(dat));

        Calendar cal = Calendar.getInstance();
        System.out.println(datFor.format(cal.getTime()));
    }
}
