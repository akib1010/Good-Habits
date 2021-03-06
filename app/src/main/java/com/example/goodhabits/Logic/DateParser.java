package com.example.goodhabits.Logic;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateParser {

    @SuppressLint("SimpleDateFormat")
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public DateParser(){

    }

    public String getStartDate(){
        Date startDate = new Date();
        return dateFormat.format(startDate);
    }

    public String getEndDate(String startDate) throws ParseException{
        Date date = dateFormat.parse(startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 66);
        Date endDate = calendar.getTime();
        return dateFormat.format(endDate);
    }

    public boolean habitLastDay(String startDate, String endDate){
        return startDate.equals(endDate);
    }

    public int daysPassed(String startDate, String currDate) throws ParseException {
        Date date1 = dateFormat.parse(startDate);
        Date date2 = dateFormat.parse(currDate);

        long difference = date2.getTime() - date1.getTime();
        float days = (float)(difference / (1000 *60*60*24));
        return (int)days;
    }
}
