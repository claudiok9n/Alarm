package presenter;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import model.model.dao.AlarmDAO;


/**
 * Created by csantamaria on 12/05/2016.
 */
public class NewAlarmPresenter {
    public NewAlarmPresenter(){

    }
    public void SaveNewAlarm(SQLiteDatabase db, ContentValues cv){
        AlarmDAO alarmDAO = new AlarmDAO(db);
        alarmDAO.addAlarm(cv);
    }

    public void UpdateAlarm(SQLiteDatabase db, ContentValues cv){
        AlarmDAO alarmDAO = new AlarmDAO(db);
        int code = (int) cv.get("code");
        alarmDAO.updateAlarm(code, cv);
    }

    public int getMaxCode(SQLiteDatabase db) {
        AlarmDAO alarmDAO = new AlarmDAO(db);
        return alarmDAO.getMaxCode();
    }
}
