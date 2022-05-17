package com.teigocoding.a99drivercontroller.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.teigocoding.a99drivercontroller.Models.RunsModel;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final int DATABASE_VERSION = 1;

    //Tabela Corridas
    private static final String DATABASE_NAME = "runs.db";
    private static final String RUNS_TABLENAME = "runs";
    private static final String RUNS_ID = "runs_id";
    private static final String RUNS_DATA = "runs_data";
    private static final String RUNS_VALOR = "runs_valor";
    private static final String RUNS_TIPO = "runs_tipo";


    public MyDatabaseHelper (@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String query =
                    "CREATE TABLE " + RUNS_TABLENAME +
                            " (" + RUNS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            RUNS_DATA + " TEXT, "+
                            RUNS_VALOR + " TEXT, "+
                            RUNS_TIPO + " TEXT);";
            db.execSQL(query);
        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + RUNS_TABLENAME);
        onCreate(db);

    }

    public boolean addOne (RunsModel runsModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RUNS_DATA, runsModel.get_data());
        cv.put(RUNS_VALOR, runsModel.get_valor());
        cv.put(RUNS_TIPO, runsModel.get_tipo());


        long insert = db.insert(RUNS_TABLENAME, null, cv);

        if (insert == -1) {
            return false;
        }else
            return true;
    }


    public  Cursor runsList(){
        String query = "SELECT " + "* " + "FROM " +
                RUNS_TABLENAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


}
