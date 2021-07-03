package com.example.carmaintenance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqliteDB_helper extends SQLiteOpenHelper {

    private Context mainContext;
    private static String DATABASE_NAME = "ServiceRecords.db";
    private static int DATABASE_VERSION = 1;
    private static String TABLE_NAME = "ServiceInfo";
    private String query_create = "create table " + TABLE_NAME + " (service_date TEXT primary key, " +
            "service_distance TEXT, service_type TEXT, service_cost TEXT)";

    public SqliteDB_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mainContext = context;
        Toast.makeText(context, "Database Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query_create);
        Toast.makeText(mainContext, "Table Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insertServiceData(String s_date, String s_distance, String s_type, String s_cost){
        SQLiteDatabase sql_db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("service_date", s_date);
        contentValues.put("service_distance", s_distance);
        contentValues.put("service_type", s_type);
        contentValues.put("service_cost", s_cost);
        long insertCheck = sql_db.insert(TABLE_NAME, null, contentValues);
        if(insertCheck == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getServiceData(){
        SQLiteDatabase sql_db = this.getWritableDatabase();
        Cursor cursor = sql_db.rawQuery("select * from " + TABLE_NAME, null);
        return cursor;
    }

}