package presenter;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import model.model.entity.Alarm;
import model.model.dao.AlarmDAO;

import java.util.List;

/**
 * Created by csantamaria on 12/05/2016.
 */
public class AlarmActivityPresenter extends Activity {
    private static View view;
    private static SQLiteDatabase db = null;

    public AlarmActivityPresenter(View v, SQLiteDatabase _db){
        this.view = v;
        this.db = _db;
    }

    public void refreshAlarmList(){
        AlarmDAO alarmDAO = new AlarmDAO(db);
        List<Alarm> alarms = alarmDAO.selectAllAlarms();
        if (alarms.size() > 0){

            view.updateAlarmList(alarms);
        }
    }

    public interface View {
        void updateAlarmList(List<Alarm> alarms);
    }
}
