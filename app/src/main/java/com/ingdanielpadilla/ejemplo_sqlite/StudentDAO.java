package com.ingdanielpadilla.ejemplo_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laboratorio on 01/10/2015.
 */
public class StudentDAO {
    private static final String TAG = "AndroidDataBase";
    private SQLiteDatabase mDatabase;
    private UniversityDBHelper mDbHelper;

    public StudentDAO(Context context) {
        mDbHelper = new UniversityDBHelper(context);
        try {
            open();
        } catch (Exception e) {
            Log.e(TAG, "SQLException on opening database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws Exception {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public Long addEntry(String s, String s1,String s2){
        Long index;
        ContentValues values= new ContentValues();
        values.put(University.StudentEntry.COLUMN_NAME_ENTRY_ID,s);
        values.put(University.StudentEntry.COLUMN_NAME_FIRST_NAME,s1);
        values.put(University.StudentEntry.COLUMN_NAME_LAST_NAME,s2);

        index= mDatabase.insert(University.StudentEntry.TABLE_NAME,null,values);

        Log.d(TAG,"addDataEntry returned index "+index);
        return index;
    }

    public List<String> getAllEntries(){
        Log.d(TAG,"getAllEntries");
        List<String> entryList = new ArrayList<String>();
        String selectQuery="SELECT * FROM "+University.StudentEntry.TABLE_NAME;
        Cursor cursor=mDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                String entry="ID "+cursor.getString(0)+" Name "+cursor.getString(1)+" LastName "+cursor.getString(2);
                entryList.add(entry);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return entryList;
    }

    public void close() {
        mDbHelper.close();
    }
}
