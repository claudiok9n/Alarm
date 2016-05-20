package com.example.claudio_pc.alarm;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Date;

import model.DataBaseIni;
import presenter.NewAlarmPresenter;

public class NewAlarmActivity extends AppCompatActivity {
    private CheckBox checkBoxD, checkBoxL, checkBoxM, checkBoxX, checkBoxJ, checkBoxV, checkBoxS;
    private static Boolean isNewAlarm = false;
    private int code = 0;
    private String name = null;
    private String days = null;
    private String hour = null;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);

        final NewAlarmPresenter newAlarmPresenter = new NewAlarmPresenter();
        final AlarmReceiver alarmReceiver = new AlarmReceiver();
        final DataBaseIni db = new DataBaseIni(getApplicationContext());
        final EditText editTextName = (EditText) findViewById(R.id.editTextName);
        final TimePicker timePickerHour = (TimePicker) findViewById(R.id.timePickerHour);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
        timePickerHour.setIs24HourView(true);

        Calendar cal = Calendar.getInstance();
        timePickerHour.setCurrentHour(cal.get(Calendar.HOUR));
        timePickerHour.setCurrentMinute(cal.get(Calendar.MINUTE));

        ini();
        if (name != null)
            editTextName.setText(name);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name", editTextName.getText().toString());
                cv.put("hour", timePickerHour.getCurrentHour().toString() + ":" + timePickerHour.getCurrentMinute().toString());
                cv.put("days", getDays());
                cv.put("state_id", 1);
                if (isNewAlarm) {
                    newAlarmPresenter.SaveNewAlarm(db.getDataBase(), cv);
                    cv.put("code", newAlarmPresenter.getMaxCode(db.getDataBase()));
                    alarmReceiver.setAlarm(getApplicationContext(), cv);
                } else {
                    cv.put("code", code);
                    newAlarmPresenter.UpdateAlarm(db.getDataBase(), cv);
                }
                finish();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = 0;
                name = null;
                days = null;
                hour = null;
                finish();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void ini() {
        code = getIntent().getIntExtra("code", -1);
        name = getIntent().getStringExtra("name");
        days = getIntent().getStringExtra("days");
        hour = getIntent().getStringExtra("hour");
        if (code == -1)
            isNewAlarm = true;

        if(days != null)
            setCheckDays(days);
    }

    private String getDays() {
        viewCheck();
        String resu = String.valueOf(checkBoxD.isChecked()) + "-" + String.valueOf(checkBoxL.isChecked())
                + "-" + String.valueOf(checkBoxM.isChecked()) + "-" + String.valueOf(checkBoxX.isChecked())
                + "-" + String.valueOf(checkBoxJ.isChecked()) + "-" + String.valueOf(checkBoxV.isChecked())
                + "-" + String.valueOf(checkBoxS.isChecked());
        return resu.replace("true", "1").replace("false", "0");
    }

    private void setCheckDays(String days){
        viewCheck();
        days = days.replace("1", "true").replace("0", "false");
        String[] values = days.split("-");
        checkBoxD.setChecked(Boolean.valueOf(values[0]));
        checkBoxL.setChecked(Boolean.valueOf(values[1]));
        checkBoxM.setChecked(Boolean.valueOf(values[2]));
        checkBoxX.setChecked(Boolean.valueOf(values[3]));
        checkBoxJ.setChecked(Boolean.valueOf(values[4]));
        checkBoxV.setChecked(Boolean.valueOf(values[5]));
        checkBoxS.setChecked(Boolean.valueOf(values[6]));
    }

    private void viewCheck(){
        checkBoxD = (CheckBox) findViewById(R.id.checkBoxD);
        checkBoxL = (CheckBox) findViewById(R.id.checkBoxL);
        checkBoxM = (CheckBox) findViewById(R.id.checkBoxM);
        checkBoxX = (CheckBox) findViewById(R.id.checkBoxX);
        checkBoxJ = (CheckBox) findViewById(R.id.checkBoxJ);
        checkBoxV = (CheckBox) findViewById(R.id.checkBoxV);
        checkBoxS = (CheckBox) findViewById(R.id.checkBoxS);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NewAlarm Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.claudio_pc.alarm/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NewAlarm Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.claudio_pc.alarm/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
