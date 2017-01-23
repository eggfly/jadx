package com.xiaomi.market.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class SDKDatabaseHelper extends SQLiteOpenHelper {
    private static SDKDatabaseHelper f4601a;

    public static SDKDatabaseHelper m6194a(Context context) {
        if (f4601a == null) {
            f4601a = new SDKDatabaseHelper(context);
        }
        return f4601a;
    }

    private SDKDatabaseHelper(Context context) {
        super(context, "xiaomi_market_sdk_update.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.d("MarketSDKDatabaseHelper", "create database");
        m6195a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private void m6195a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));");
    }

    public long m6196a(ContentValues contentValues) {
        SQLiteStatement compileStatement = getWritableDatabase().compileStatement("INSERT OR REPLACE INTO update_download(package_name,download_id,version_code,apk_url,apk_hash,diff_url,diff_hash,apk_path) VALUES(?,?,?,?,?,?,?,?)");
        compileStatement.bindString(1, contentValues.getAsString("package_name"));
        compileStatement.bindLong(2, contentValues.getAsLong("download_id").longValue());
        compileStatement.bindLong(3, (long) contentValues.getAsInteger("version_code").intValue());
        compileStatement.bindString(4, contentValues.getAsString("apk_url"));
        compileStatement.bindString(5, contentValues.getAsString("apk_hash"));
        compileStatement.bindString(6, contentValues.getAsString("diff_url"));
        compileStatement.bindString(7, contentValues.getAsString("diff_hash"));
        compileStatement.bindString(8, contentValues.getAsString("apk_path"));
        compileStatement.execute();
        return 1;
    }

    public Cursor m6197a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
    }
}
