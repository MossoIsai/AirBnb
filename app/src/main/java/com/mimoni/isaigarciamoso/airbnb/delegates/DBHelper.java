package com.mimoni.isaigarciamoso.airbnb.delegates;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by isaigarciamoso on 04/02/17.
 */

public class DBHelper  extends SQLiteOpenHelper{

    private static final int VERSION = 1;
    private static final String NOMBRE_DB = "MIMONIDB4";
    private QuerysDB querysDB;

    public  DBHelper(Context context){

        super(context, NOMBRE_DB, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Ejecucion de los Querys
        querysDB = new QuerysDB();
        db.execSQL(querysDB.createTableUsuario());
        Log.e("ERROR","ERROR::::::::::::::::");
        db.execSQL(querysDB.createTableDepartamento());
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
