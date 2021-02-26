package com.example.goodhabits;

import com.example.goodhabits.Logic.TimeParser;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    @Test
    public void checkTimeIn12Hr() {
        TimeParser time = new TimeParser();
        String result = time.getTime(0, 0);
        assertEquals("12:00 AM", result);
    }
}
