package comp3350.goodhabits.Logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class QuoteAlertReceiver extends BroadcastReceiver {

    private final String QUOTE_NAME="Quote of the day";
    private final int QUOTE_ID=99;


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper alarm= new NotificationHelper(context);
        String content=intent.getStringExtra(QUOTE_NAME);
        NotificationCompat.Builder nb=alarm.createQuoteNotification(content);
        alarm.getManager().notify(QUOTE_ID,nb.build());


    }
}
