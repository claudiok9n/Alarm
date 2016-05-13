package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by csantamaria on 11/05/2016.
 */
public class DataBaseIni {
    private Context context;
    private static SQLiteDatabase db = null;

    public DataBaseIni(Context _context){
        context = _context;
        iniDataBase();
    }

    private void iniDataBase(){
        DataBase dbCreate = new DataBase(context, DataBase.DB_NAME, null, 1);
        db = dbCreate.getWritableDatabase();
    }

    public SQLiteDatabase getDataBase(){
        return db;
    }

    public void closeDataBase(){
        db.close();
    }
}
