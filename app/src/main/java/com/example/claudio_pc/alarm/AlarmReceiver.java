package com.example.claudio_pc.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Claudio_pc on 02/05/2016.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, AlarmService.class);
        startWakefulService(context, service);
    }

    public void setAlarm(Context context, ContentValues cv){
        int code = (int) cv.get("code");
        String hour = (String) cv.get("hour");
        String[] hourValue = hour.split(":");
        String days = (String) cv.get("days");
        String[] daysValue = days.split("-");

        for(int i=0; i<daysValue.length; i++) {
            if(daysValue[i].toString().equals("1")){
                alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(context, AlarmReceiver.class);
                intent.setData(Uri.parse("|code|" + code + "|day|" + (i + 1)));
                alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.DAY_OF_WEEK, i + 1);
                calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hourValue[0]));
                calendar.set(Calendar.MINUTE, Integer.valueOf(hourValue[1]));
                Toast.makeText(context, "Alarm active...", Toast.LENGTH_LONG).show();
                alarmMgr.set(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(), alarmIntent);
            }
        }

        // Enable {@code SampleBootReceiver} to automatically restart the alarm when the device is rebooted.
        ComponentName receiver = new ComponentName(context, AlarmBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }
    public void cancelAlarm(Context context){
        // If the alarm has been set, cancel it.
        if (alarmMgr!= null) {
            alarmMgr.cancel(alarmIntent);
        }

        // Disable {@code SampleBootReceiver} so that it doesn't automatically restart the
        // alarm when the device is rebooted.
        ComponentName receiver = new ComponentName(context, AlarmBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
    // END_INCLUDE(cancel_alarm)

}
