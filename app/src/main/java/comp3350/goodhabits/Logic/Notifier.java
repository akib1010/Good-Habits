package comp3350.goodhabits.Logic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

import comp3350.goodhabits.Objects.Habit;

public class Notifier {
    //Name Tags to pass to new Intent
    private final String HABIT_NAME="Habit Name";
    private final String HABIT_MSG="Habit Msg";
    private final String HABIT_ID="Habit ID";
    private final String QUOTE_NAME="Quote of the day";
    private final int QUOTE_ID=99;
    Context context;

    public Notifier(Context c)
    {
        context=c;
    }

    public void setHabitNotification(Habit habit)
    {
        Calendar c=setTime(habit.getHour(),habit.getMinute());
        AlarmManager alarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, HabitAlertReceiver.class);
        intent.putExtra(HABIT_NAME,habit.getHabitName());
        intent.putExtra(HABIT_MSG,habit.getHabitMsg());
        intent.putExtra(HABIT_ID,habit.getId());
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,habit.getId(),intent,0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
    }

    public void cancelAlarm(Habit habit)
    {
        AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(context, HabitAlertReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,habit.getId(),intent,0);
        alarmManager.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void setQuoteNotification(String quote)
    {
        //Calendar c = setTime(2,40);
        Calendar c=Calendar.getInstance();
        AlarmManager alarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,QuoteAlertReceiver.class);
        intent.putExtra(QUOTE_NAME,quote);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,QUOTE_ID,intent,0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
    }

    //This method sets the time during which the notification will be active
    public Calendar setTime(int hour,int min)
    {
        //Set the time for the notification
        Calendar c= Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,hour);
        c.set(Calendar.MINUTE,min);
        c.set(Calendar.SECOND,0);
        if(c.before(Calendar.getInstance()))
        {
            c.add(Calendar.DATE,1);
        }
        return c;
    }
}
