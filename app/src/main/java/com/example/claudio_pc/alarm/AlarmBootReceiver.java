package com.example.claudio_pc.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Claudio_pc on 02/05/2016.
 */
public class AlarmBootReceiver extends BroadcastReceiver {
    //AlarmReceiver alarm = new AlarmReceiver();
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            //TODO:
            //alarm.setAlarm(context);
        }
    }
}
