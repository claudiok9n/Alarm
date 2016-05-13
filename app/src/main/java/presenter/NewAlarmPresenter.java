package presenter;

import android.content.ContentValues;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import model.model.dao.AlarmDAO;


/**
 * Created by csantamaria on 12/05/2016.
 */
public class NewAlarmPresenter extends Activity {
    public NewAlarmPresenter(){

    }
    public void SaveNewAlarm(SQLiteDatabase db, ContentValues cv){
        AlarmDAO alarmDAO = new AlarmDAO(db);
        alarmDAO.addAlarm(cv);
    }


}
