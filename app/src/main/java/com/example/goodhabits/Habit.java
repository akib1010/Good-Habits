package com.example.goodhabits;
//This class is a Data structure for "Habit"
public class Habit {
    private String name;//Name of Habit
    private boolean type;//Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    private String msg;//A message that the user writes inorder to engage in an activity
    private int hour;//Used to handle the hour of the day for the activity
    private int minute;//Used to handle the minute of the hour for the activity

    public Habit(String Name,boolean Type,String Msg,int Hour,int Minute)
    {
        name=Name;
        type=Type;
        msg=Msg;
        hour=Hour;
        minute=Minute;
    }
    //Returns name of Habit
    public String getHabitName()
    {
        return this.name;
    }
    //Returns Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    public boolean HabitType()
    {
        return this.type;
    }
    //Returns the Users message
    public String HabitMsg()
    {
        return this.msg;
    }
    //Returns the Time set for the Habit in an array format{Hour,Minute}
    public int[] getHabitTime()
    {
        int[] arr={hour,minute};
        return arr;
    }
}
