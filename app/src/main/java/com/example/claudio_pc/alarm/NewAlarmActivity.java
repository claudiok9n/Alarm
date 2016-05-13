package com.example.claudio_pc.alarm;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;

import model.DataBaseIni;
import presenter.NewAlarmPresenter;

public class NewAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);

        final NewAlarmPresenter newAlarmPresenter = new NewAlarmPresenter();
        final DataBaseIni db = new DataBaseIni(getApplicationContext());
        final EditText editTextName = (EditText)findViewById(R.id.editTextName);
        final TimePicker timePickerHour = (TimePicker)findViewById(R.id.timePickerHour);
        Button buttonSave = (Button)findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name", editTextName.getText().toString());
                cv.put("hour", timePickerHour.getCurrentHour().toString() + ":" + timePickerHour.getCurrentMinute().toString());
                cv.put("days", getDays());
                cv.put("state_id", 1);
                newAlarmPresenter.SaveNewAlarm(db.getDataBase(), cv);
            }
        });

    }

    private String getDays(){
        String resu = null;
        CheckBox checkBoxD, checkBoxL, checkBoxM, checkBoxX, checkBoxJ, checkBoxV, checkBoxS;
        checkBoxD = (CheckBox) findViewById(R.id.checkBoxD);
        checkBoxL = (CheckBox) findViewById(R.id.checkBoxL);
        checkBoxM = (CheckBox) findViewById(R.id.checkBoxM);
        checkBoxX = (CheckBox) findViewById(R.id.checkBoxX);
        checkBoxJ = (CheckBox) findViewById(R.id.checkBoxJ);
        checkBoxV = (CheckBox) findViewById(R.id.checkBoxV);
        checkBoxS = (CheckBox) findViewById(R.id.checkBoxS);
        resu = String.valueOf(checkBoxD.isChecked()) + "|" + String.valueOf(checkBoxL.isChecked())
                + "|" + String.valueOf(checkBoxM.isChecked()) + "|" + String.valueOf(checkBoxX.isChecked())
                + "|" + String.valueOf(checkBoxJ.isChecked()) + "|" + String.valueOf(checkBoxV.isChecked())
                + "|" + String.valueOf(checkBoxS.isChecked());
        return resu;
    }
}
