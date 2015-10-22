package com.ingdanielpadilla.ejemplo_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Laboratorio on 01/10/2015.
 */
public class UniversityDBHelper extends SQLiteOpenHelper {
    String a;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "University.db";

    public UniversityDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTIRES =
            "CREATE TABLE " + University.StudentEntry.TABLE_NAME + " (" +
                    University.StudentEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    University.StudentEntry.COLUMN_NAME_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    University.StudentEntry.COLUMN_NAME_LAST_NAME + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS "+ University.StudentEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTIRES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
