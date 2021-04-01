package comp3350.goodhabits.Logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class HabitAlertReceiver extends BroadcastReceiver {
    //Name tags
    private String habit_Name="Habit Name";
    private String habit_Msg="Habit Msg";
    private String habit_Id="Habit ID";

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper alarm=new NotificationHelper(context);
        String title=intent.getStringExtra(habit_Name);
        String content=intent.getStringExtra(habit_Msg);
        int id=intent.getIntExtra(habit_Id,0);
        if(HabitManager.checkHabit(id))
        {
            NotificationCompat.Builder nb=alarm.createHabitNotification(title,content);
            alarm.getManager().notify(id,nb.build());
        }
        else
        {
            Notifier nt= new Notifier(context);
            nt.cancelAlarm(context,id);
        }
    }
}