package com.example.goodhabits.Objects;

//This class is a Data structure for "Habit"
public class Habit {
    private String name;//Name of Habit
    private boolean type;//Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    private String msg;//A message that the user writes inorder to engage in an activity
    private int hour;//Used to handle the hour of the day for the activity
    private int minute;//Used to handle the minute of the hour for the activity

    public Habit(String name,boolean type,String msg,int hour,int minute)
    {
        this.name=name;
        this.type=type;
        this.msg=msg;
        this.hour=hour;
        this.minute=minute;
    }

    //Returns name of Habit
    public String getHabitName(){
        return this.name;
    }

    //Returns Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    public boolean getHabitType() {
        return this.type;
    }

    //Returns the Users message
    public String getHabitMsg() {
        return this.msg;
    }

    //Returns the Time set for the Habit in an array format{Hour,Minute}
    public int[] getHabitTime() {
        return new int[]{hour,minute};
    }

    public void setHabitName(String name) {
        this.name = name;
    }

    public void setHabitType(boolean type) {
        this.type = type;
    }

    public void setHabitMsg(String msg) {
        this.msg = msg;
    }

    public void setHabitTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
