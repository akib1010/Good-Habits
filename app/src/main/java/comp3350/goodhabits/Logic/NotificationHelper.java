package comp3350.goodhabits.Logic;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Presentation.AddActivity;
import comp3350.goodhabits.Presentation.AllHabitsActivity;
import comp3350.goodhabits.Presentation.MainActivity;
import comp3350.goodhabits.R;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper{
    //Id of the notification channels
    public final String habitChannelID= "HabitChannel";
    public final String quoteChannelID= "QuoteChannel";

    //Name of the notification channels
    public final String habitChannelName="Habit Notification";
    public final String quoteChannelName="Motivational Quotes";

    //

    //A Notifier Variable used to handle the notifications
    public NotificationManager nManager;


    //Constructor
    public NotificationHelper(Context context)
    {
        super(context);
        //Check android version to determine if channels need to be created
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            createNotificationChannels();
        }

    }


    //This method initializes and returns the Notifier
    public NotificationManager getManager()
    {
        //Initialize nManager if it has not been initialized
        if(nManager==null)
        {
            nManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return nManager;
    }

    //This method creates the notification channels required for android version greater than equal "oreo"
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createNotificationChannels()
    {
        //Create Notification channel for Habit and add features
        NotificationChannel habitChannel=new NotificationChannel(habitChannelID,habitChannelName, NotificationManager.IMPORTANCE_HIGH);
        habitChannel.enableLights(true);
        habitChannel.enableVibration(true);
        habitChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(habitChannel);

        //Create Notification channel for Motivational Quotes
        NotificationChannel quoteChannel=new NotificationChannel(quoteChannelID,quoteChannelName, NotificationManager.IMPORTANCE_DEFAULT);
        quoteChannel.enableLights(true);
        quoteChannel.enableVibration(true);
        quoteChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(quoteChannel);
    }

    //This method creates a notification for a Habit Reminder
    public NotificationCompat.Builder createHabitNotification(String habitName, String habitMsg)
    {
        Intent intent=new Intent(this, AllHabitsActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        return new NotificationCompat.Builder(getApplicationContext(),habitChannelID)
                .setContentTitle(habitName)
                .setContentText(habitMsg)
                .setSmallIcon(R.drawable.ic_habit)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

    }

    //This method creates a notification for Motivational Quotes
    public NotificationCompat.Builder createQuoteNotification(String quote)
    {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,2,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        return new NotificationCompat.Builder(getApplicationContext(),quoteChannelID)
                .setContentTitle("Good Habits")
                .setContentText(quote)
                .setSmallIcon(R.drawable.ic_fire)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
    }
}
