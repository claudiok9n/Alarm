package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by csantamaria on 10/05/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    public static final String DB_NAME = "alarm";
    public static final String TABLE_ALARMS = "alarms";
    public static final String CREATE_TABLE_ALARMS = "CREATE TABLE [alarms] (\n" +
                                                "  [code] INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                                                "  [name] TEXT(100) NOT NULL, \n" +
                                                "  [hour] TIME NOT NULL, \n" +
                                                "  [days] TEXT(20) NOT NULL, \n" +
                                                "  [week_repeat] BOOL, \n" +
                                                "  [sound] TEXT(200), \n" +
                                                "  [repeat] TEXT(200),\n" +
                                                "  [leave_alarm_type] INT(2),\n" +
                                                "  [active] BOOL,\n" +
                                                "  [state_id] INT(2))\n";

    public DataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALARMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_ALARMS);
        db.execSQL(CREATE_TABLE_ALARMS);
    }
}
