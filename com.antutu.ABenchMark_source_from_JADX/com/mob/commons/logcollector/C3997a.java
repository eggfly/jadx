package com.mob.commons.logcollector;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.mob.commons.logcollector.a */
public class C3997a extends SQLiteOpenHelper {
    public C3997a(Context context) {
        super(context.getApplicationContext(), "ThrowalbeLog.db", null, 1);
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" create table  table_exception(_id integer primary key autoincrement,exception_level integer not null, exception_msg text not null,exception_time timestamp not null, exception_md5 text not null, exception_counts integer DEFAULT 1, exception_sending bit);");
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
