package com.example.claudio_pc.alarm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;

/**
 * Created by Claudio_pc on 02/05/2016.
 */
public class AlarmService extends IntentService {
    private NotificationManager mNotificationManager;
    public static final int NOTIFICATION_ID = 1;

    public AlarmService() {
        super("SchedulingService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        activeAlarm("test");
        AlarmReceiver.completeWakefulIntent(intent);
    }

    private void activeAlarm(String text){
        Intent i = new Intent(getApplicationContext(), AlarmActiveActivity.class);
        //i.putExtra("text", text);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

}
