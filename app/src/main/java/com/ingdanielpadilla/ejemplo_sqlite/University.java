package com.ingdanielpadilla.ejemplo_sqlite;

import android.provider.BaseColumns;


/**
 * Created by Laboratorio on 01/10/2015.
 */
public class University {
    public University(){}

    public static abstract class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME="student";
        public static final String COLUMN_NAME_ENTRY_ID ="studentid";
        public static final String COLUMN_NAME_FIRST_NAME="firstname";
        public static final String COLUMN_NAME_LAST_NAME="lastname";
    }

}
