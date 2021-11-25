package xyz.javaee.myapplication.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteUtil extends SQLiteOpenHelper {

    public SQLiteUtil(@Nullable Context context) {
        super(context, "ciec.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student" +
                "(stuNum CHAR(11) PRIMARY KEY NOT NULL," +
                "name VARCHAR(10)," +
                "sex INTEGER," +
                "classRoom VARCHAR(20)" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
