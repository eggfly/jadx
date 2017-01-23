package com.xiaomi.mistatistic.sdk.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.i */
public class C0567i extends SQLiteOpenHelper {
    public static final Object f4744a;

    static {
        f4744a = new Object();
    }

    public C0567i(Context context) {
        super(context, "mistat.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f4744a) {
            sQLiteDatabase.execSQL(String.format("create table %s(_id integer primary key autoincrement, category text, ts integer, key text, value text, type text, extra text)", new Object[]{"mistat_event"}));
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    protected void finalize() {
        close();
        super.finalize();
    }
}
