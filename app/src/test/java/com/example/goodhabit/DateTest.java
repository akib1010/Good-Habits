package com.example.goodhabit;

import com.example.goodhabit.Logic.DateParser;
import com.example.goodhabit.Logic.TimeParser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    private DateParser dateParser;
    private String startDate;
    private String currDate;

    @Before
    public void setUp(){
        dateParser = new DateParser();
        startDate = "05/03/2021";
        currDate = "17/03/2021";
    }

    @Test
    public void checkEndDate(){
        try {
            String date = dateParser.getEndDate(startDate);
            assertEquals("10/05/2021", date);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void checkDaysPassed(){
        try {
            int days = dateParser.getDaysPassed(startDate, currDate);
            assertEquals("12", String.valueOf(days));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
