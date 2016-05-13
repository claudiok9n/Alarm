package model.model.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import model.DataBase;
import model.model.entity.Alarm;
import presenter.presenter.dao.AlarmDAOI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csantamaria on 11/05/2016.
 */
public class AlarmDAO implements AlarmDAOI {
    private SQLiteDatabase db = null;
    public AlarmDAO(SQLiteDatabase _db){
        db = _db;
    }

    @Override
    public List<Alarm> selectAllAlarms() {
        List<Alarm> Alarms = new ArrayList<>();

        String[] columns = {"code", "name", "hour", "days", "week_repeat", "sound", "repeat", "leave_alarm_type", "active", "state_id"};
        Cursor cursor = db.query(DataBase.TABLE_ALARMS, columns, COLUMN_STATE_ID + "=" + 1, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Alarms.add(getEntity(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return Alarms;
    }

    @Override
    public void addAlarm(ContentValues cv) {
        db.insert(DataBase.TABLE_ALARMS, null, cv);
    }

    @Override
    public void updateAlarm(int code, ContentValues valuesToUpdate){
        db.update(DataBase.TABLE_ALARMS, valuesToUpdate, COLUMN_CODE + "=" + code, null);
    }

    @Override
    public void deleteAlarm (int code){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_STATE_ID, 0);
        db.update(DataBase.TABLE_ALARMS, cv, COLUMN_CODE + "=" + code, null);
    }

    @Override
    public void stateAlarm(int code, int state){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ACTIVE, state);
        db.update(DataBase.TABLE_ALARMS, cv, COLUMN_CODE + "=" + code, null);
    }

    private Alarm getEntity(Cursor c){
        Alarm alarm = new Alarm();
        alarm.setName(c.getString(c.getColumnIndex(AlarmDAOI.COLUMN_CODE)));
        alarm.setName(c.getString(c.getColumnIndex(AlarmDAOI.COLUMN_NAME)));
        alarm.setHour(c.getString(c.getColumnIndex(AlarmDAOI.COLUMN_HOUR)));
        alarm.setDays(c.getString(c.getColumnIndex(AlarmDAOI.COLUMN_DAYS)));
        alarm.setWeek_repeat( (c.getInt(c.getColumnIndex(AlarmDAOI.COLUMN_WEEK_REPEAT)) == 1) );
        alarm.setSound(c.getString(c.getColumnIndex(AlarmDAOI.COLUMN_SOUND)));
        alarm.setRepeat(c.getString(c.getColumnIndex(AlarmDAOI.COLUMN_REPEAT)));
        alarm.setLeave_alarm_type(c.getInt(c.getColumnIndex(AlarmDAOI.COLUMN_LEAVE_ALARM_TYPE)));
        alarm.setActive( (c.getInt(c.getColumnIndex(AlarmDAOI.COLUMN_ACTIVE)) == 1) );
        alarm.setState_id(c.getInt(c.getColumnIndex(AlarmDAOI.COLUMN_STATE_ID)));
        return alarm;
    }

}
