package com.antutu.redacc.p072e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.antutu.redacc.e.d */
public class C1741d {
    private final ReentrantLock f6172a;
    private SQLiteDatabase f6173b;
    private C1740a f6174c;

    /* renamed from: com.antutu.redacc.e.d.a */
    private static class C1740a extends SQLiteOpenHelper {
        public C1740a(Context context) {
            super(context, "applist.db", null, 6);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apps (id INTEGER PRIMARY KEY AUTOINCREMENT, pkg TEXT UNIQUE ON CONFLICT REPLACE, checked INTEGER, name TEXT);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS apps;");
            onCreate(sQLiteDatabase);
        }
    }

    public C1741d(Context context) {
        this.f6172a = new ReentrantLock();
        this.f6174c = new C1740a(context);
    }

    public int m6730a(String str) {
        int i = -1;
        try {
            Cursor rawQuery = this.f6173b.rawQuery("select checked from apps where pkg=?", new String[]{str});
            if (rawQuery != null && rawQuery.getCount() > 0) {
                if (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(0);
                }
                rawQuery.close();
            }
        } catch (Exception e) {
        }
        return i;
    }

    public C1741d m6731a() {
        this.f6173b = this.f6174c.getWritableDatabase();
        return this;
    }

    public void m6732a(String str, String str2, int i) {
        this.f6172a.lock();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.KEY_ELECTION_PKG, str);
            contentValues.put("checked", Integer.valueOf(i));
            contentValues.put("name", str2);
            this.f6173b.beginTransaction();
            this.f6173b.replace(Constants.KEY_APPS, null, contentValues);
            this.f6173b.setTransactionSuccessful();
            this.f6173b.endTransaction();
        } catch (Exception e) {
        }
        this.f6172a.unlock();
    }

    public void m6733b() {
        this.f6173b.close();
    }
}
