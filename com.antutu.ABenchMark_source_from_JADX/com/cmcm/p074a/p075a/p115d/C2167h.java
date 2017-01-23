package com.cmcm.p074a.p075a.p115d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.cmcm.a.a.d.h */
public class C2167h extends SQLiteOpenHelper {
    public C2167h(Context context) {
        super(context, "dmc_report", null, 1);
    }

    public Cursor m8163a(int i) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(String.format("SELECT * FROM %s WHERE %s != 1 AND %s >= %s ORDER BY %s DESC, %s DESC LIMIT 100", new Object[]{"report_list", AgooConstants.MESSAGE_REPORT, "mode", Integer.valueOf(i), "mode", "timestamp"}), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursor;
    }

    public void m8164a() {
        try {
            String str = "UPDATE report_list SET report = ? WHERE report = ?";
            getWritableDatabase().execSQL("UPDATE report_list SET report = ? WHERE report = ?", new Object[]{Boolean.valueOf(false), Boolean.valueOf(true)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m8165a(C2168i c2168i) {
        try {
            ContentValues contentValues = new ContentValues();
            c2168i.m8168a(contentValues);
            getWritableDatabase().insert("report_list", null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m8166a(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String str = "DELETE FROM report_list WHERE guid = ?";
            Iterator it = list.iterator();
            while (it.hasNext()) {
                writableDatabase.execSQL("DELETE FROM report_list WHERE guid = ?", new Object[]{(String) it.next()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m8167a(List list, boolean z) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String str = "UPDATE report_list SET report = ? WHERE guid = ?";
            for (String str2 : list) {
                writableDatabase.execSQL("UPDATE report_list SET report = ? WHERE guid = ?", new Object[]{Boolean.valueOf(z), str2});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table report_list(guid varchar primary key,ver integer,proto integer,mode integer,timestamp integer,type varchar,data varchar,report tinyint default 0)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
