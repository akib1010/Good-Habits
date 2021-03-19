package comp3350.goodhabits.Objects;

import java.io.Serializable;

// This is a Class for the Habit object
public class Habit implements Serializable {
    private int id;
    private String name; // Name of Habit
    private boolean type; // Type of Habit, If true then it is a "Good Habit" else it is a "Bad Habit"
    private String msg; // A message that the user writes inorder to engage in an activity
    private int hour; // Used to handle the hour of the day for the Habit
    private int minute; // Used to handle the minute of the hour for the Habit
    private String startDate;
    private String endDate;
    private int daysCheckedIn;

    public Habit(int id, String name, boolean type, String msg, int hour, int minute, String startDate, String endDate, int daysCheckedIn)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.msg = msg;
        this.hour = hour;
        this.minute = minute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysCheckedIn = daysCheckedIn;
    }

    public int getId() { return this.id; }

    public String getHabitName(){
        return this.name;
    }

    public boolean getHabitType() {
        return this.type;
    }

    public String getHabitMsg() {
        return this.msg;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public int getDaysCheckedIn() {
        return this.daysCheckedIn;
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void increaseCheckIn(){
        this.daysCheckedIn += 1;
    }
}
