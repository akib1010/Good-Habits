package com.example.goodhabits.Objects;

import java.io.Serializable;
import java.util.Date;

// This is a Class for the Habit object
public class Habit implements Serializable {
    private String name; // Name of Habit
    private boolean type; // Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    private String msg; // A message that the user writes inorder to engage in an activity
    private int hour; // Used to handle the hour of the day for the Habit
    private int minute; // Used to handle the minute of the hour for the Habit
    private String startDate;
    private String endDate;
    private String currDate;
    private int daysCheckedIn;

    public Habit(String name,boolean type,String msg,int hour,int minute)
    {
        this.name = name;
        this.type = type;
        this.msg = msg;
        this.hour = hour;
        this.minute = minute;
//        this.startDate = startDate;
//        this.endDate = endDate;
        this.daysCheckedIn = 0;
    }

    // Returns name of Habit
    public String getHabitName(){
        return this.name;
    }

    // Returns Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    public boolean getHabitType() {
        return this.type;
    }

    // Returns the user's message
    public String getHabitMsg() {
        return this.msg;
    }

    // Returns the Time set for the Habit in an integer array format: {Hour,Minute}
    public int[] getHabitTime() {
        return new int[]{hour,minute};
    }

    // Setter function to change the Habit name
    public void setHabitName(String name) {
        this.name = name;
    }

    // Setter function to change the Habit type
    public void setHabitType(boolean type) {
        this.type = type;
    }

    // Setter function to change the Habit message
    public void setHabitMsg(String msg) {
        this.msg = msg;
    }

    // Setter function to change the Habit time
    public void setHabitTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
