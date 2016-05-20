package presenter.presenter.dao;

import android.content.ContentValues;

import model.model.entity.Alarm;

import java.util.List;

/**
 * Created by csantamaria on 11/05/2016.
 */
public interface AlarmDAOI {
    String TABLE_NAME = "alarms";

    String COLUMN_CODE = "code";
    String COLUMN_NAME = "name";
    String COLUMN_HOUR = "hour";
    String COLUMN_DAYS = "days";
    String COLUMN_WEEK_REPEAT = "week_repeat";
    String COLUMN_SOUND = "sound";
    String COLUMN_REPEAT = "repeat";
    String COLUMN_LEAVE_ALARM_TYPE = "leave_alarm_type";
    String COLUMN_ACTIVE = "active";
    String COLUMN_STATE_ID = "state_id";

    List<Alarm> selectAllAlarms();
    void addAlarm(ContentValues cv);
    void updateAlarm(int code, ContentValues valuesToUpdate);
    void deleteAlarm(int code);
    void stateAlarm(int code, int state);
    int getMaxCode();
}
