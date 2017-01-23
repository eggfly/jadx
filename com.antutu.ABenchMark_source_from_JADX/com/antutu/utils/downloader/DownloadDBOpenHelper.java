package com.antutu.utils.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DownloadDBOpenHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "down.db";
    private static final int VERSION = 5;
    private static DownloadDBOpenHelper mHelper;

    static {
        mHelper = null;
    }

    private DownloadDBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    public static DownloadDBOpenHelper getInstance(Context context) {
        if (mHelper == null) {
            synchronized (DownloadDBOpenHelper.class) {
                if (mHelper == null) {
                    mHelper = new DownloadDBOpenHelper(context);
                }
            }
        }
        return mHelper;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownlog (id integer primary key autoincrement, downpath varchar(100), modify LONG, times INTEGER, threadid INTEGER, downlength INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownloading (id integer primary key autoincrement, downpath varchar(127),uid INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS filedownlog");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS filedownloading");
        onCreate(sQLiteDatabase);
    }
}
