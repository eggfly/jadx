package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class SQLiteHelper {

    public static class SingleTableDB {
        private SQLiteDatabase db;
        private HashMap<String, Boolean> fieldLimits;
        private LinkedHashMap<String, String> fieldTypes;
        private String name;
        private String path;
        private String primary;
        private boolean primaryAutoincrement;

        private SingleTableDB(String str, String str2) {
            this.path = str;
            this.name = str2;
            this.fieldTypes = new LinkedHashMap();
            this.fieldLimits = new HashMap();
        }

        private void close() {
            if (this.db != null) {
                this.db.close();
                this.db = null;
            }
        }

        private String getName() {
            return this.name;
        }

        private void open() {
            if (this.db == null) {
                this.db = SQLiteDatabase.openOrCreateDatabase(new File(this.path), null);
                Cursor rawQuery = this.db.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + this.name + "' ", null);
                int i = 1;
                if (rawQuery != null) {
                    if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                        i = 0;
                    }
                    rawQuery.close();
                }
                if (i != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("create table  ").append(this.name).append(C4233j.f14396s);
                    for (Entry entry : this.fieldTypes.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        boolean booleanValue = ((Boolean) this.fieldLimits.get(str)).booleanValue();
                        boolean equals = str.equals(this.primary);
                        boolean z = equals ? this.primaryAutoincrement : false;
                        stringBuilder.append(str).append(" ").append(str2);
                        stringBuilder.append(booleanValue ? " not null" : BuildConfig.FLAVOR);
                        stringBuilder.append(equals ? " primary key" : BuildConfig.FLAVOR);
                        stringBuilder.append(z ? " autoincrement," : Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ");");
                    this.db.execSQL(stringBuilder.toString());
                }
            }
        }

        public void addField(String str, String str2, boolean z) {
            if (this.db == null) {
                this.fieldTypes.put(str, str2);
                this.fieldLimits.put(str, Boolean.valueOf(z));
            }
        }

        public void setPrimary(String str, boolean z) {
            this.primary = str;
            this.primaryAutoincrement = z;
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.close();
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.db.delete(singleTableDB.getName(), str, strArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void execSQL(com.mob.tools.utils.SQLiteHelper.SingleTableDB r2, java.lang.String r3) {
        /*
        r2.open();
        r0 = r2.db;
        r0.beginTransaction();
        r0 = r2.db;	 Catch:{ Throwable -> 0x0020 }
        r0.execSQL(r3);	 Catch:{ Throwable -> 0x0020 }
        r0 = r2.db;	 Catch:{ Throwable -> 0x0020 }
        r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0020 }
        r0 = r2.db;
        r0.endTransaction();
        return;
    L_0x0020:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0022 }
    L_0x0022:
        r0 = move-exception;
        r1 = r2.db;
        r1.endTransaction();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.SQLiteHelper.execSQL(com.mob.tools.utils.SQLiteHelper$SingleTableDB, java.lang.String):void");
    }

    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context.getDatabasePath(str).getPath(), str);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str2, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getSize(com.mob.tools.utils.SQLiteHelper.SingleTableDB r5) {
        /*
        r1 = 0;
        r0 = 0;
        r5.open();
        r2 = r5.db;	 Catch:{ Throwable -> 0x0034 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0034 }
        r3.<init>();	 Catch:{ Throwable -> 0x0034 }
        r4 = "select count(*) from ";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0034 }
        r4 = r5.getName();	 Catch:{ Throwable -> 0x0034 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0034 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0034 }
        r4 = 0;
        r1 = r2.rawQuery(r3, r4);	 Catch:{ Throwable -> 0x0034 }
        r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x0034 }
        if (r2 == 0) goto L_0x0030;
    L_0x002b:
        r0 = 0;
        r0 = r1.getInt(r0);	 Catch:{ Throwable -> 0x0034 }
    L_0x0030:
        r1.close();
        return r0;
    L_0x0034:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0036 }
    L_0x0036:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.SQLiteHelper.getSize(com.mob.tools.utils.SQLiteHelper$SingleTableDB):int");
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) {
        singleTableDB.open();
        return singleTableDB.db.replace(singleTableDB.getName(), null, contentValues);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) {
        singleTableDB.open();
        return singleTableDB.db.query(singleTableDB.getName(), strArr, str, strArr2, null, null, str2);
    }

    public static Cursor rawQuery(SingleTableDB singleTableDB, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.db.rawQuery(str, strArr);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.db.update(singleTableDB.getName(), contentValues, str, strArr);
    }
}
