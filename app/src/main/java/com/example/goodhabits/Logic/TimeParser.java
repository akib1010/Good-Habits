package com.example.goodhabits.Logic;

public class TimeParser {
    private String time;

    public TimeParser(){
        time = "";
    }

    public String getTime(int hourOfDay, int minuteOfHour){
        String result = "";
        String tempHour = "";
        String tempMin = "";
        String flag = "";

        if(hourOfDay == 12) {
            tempHour = Integer.toString(hourOfDay);
            flag = " PM";
        }
        else if(hourOfDay >= 12) {
            tempHour = Integer.toString(hourOfDay - 12);
            flag = " PM";
        }
        else{
            if(hourOfDay == 0)
                tempHour = Integer.toString(12);
            else
                tempHour = Integer.toString(hourOfDay);
            flag = " AM";
        }

        if(minuteOfHour == 0)
            tempMin = "00";
        else if(Integer.toString(minuteOfHour).length() == 1)
            tempMin = "0"+ minuteOfHour;
        else
            tempMin = Integer.toString(minuteOfHour);

        result = tempHour+":"+tempMin+flag;
        return result;
    }
}
