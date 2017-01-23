package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.ht.e;
import com.google.android.gms.internal.ht.f;
import com.google.android.gms.internal.m;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import l;

class p extends b {
    private static final Map<String, String> j6;
    private final c DW;
    private final h FH;

    interface b {
        void j6(e eVar);

        boolean j6(long j, com.google.android.gms.internal.ht.b bVar);
    }

    public static class a {
        long DW;
        long FH;
        long Hw;
        long j6;
    }

    private class c extends SQLiteOpenHelper {
        final /* synthetic */ p j6;

        c(p pVar, Context context, String str) {
            this.j6 = pVar;
            super(context, str, null, 1);
        }

        private Set<String> DW(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void j6(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
            if (!j6(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                j6(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.j6.lg().Zo().j6("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        private void j6(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
            Set DW = DW(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (DW.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!DW.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!DW.isEmpty()) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
            }
        }

        private boolean j6(SQLiteDatabase sQLiteDatabase, String str) {
            Cursor query;
            Object e;
            Throwable th;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.j6.lg().yS().j6("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.j6.lg().yS().j6("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.j6.FH.j6(this.j6.er().KD())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.j6.FH.j6();
                    this.j6.lg().Zo().j6("Opening the database failed, dropping and recreating it");
                    this.j6.XL().getDatabasePath(this.j6.BT()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.j6.FH.DW();
                    } catch (SQLiteException e2) {
                        this.j6.lg().Zo().j6("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            j6(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            j6(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            j6(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", p.j6);
            j6(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            j6(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            j6(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            j6(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            j6(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            j6(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        j6 = new l(16);
        j6.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        j6.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        j6.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        j6.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        j6.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        j6.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        j6.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        j6.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        j6.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        j6.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        j6.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        j6.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        j6.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        j6.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        j6.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        j6.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    p(ai aiVar) {
        super(aiVar);
        this.FH = new h(QX());
        this.DW = new c(this, XL(), BT());
    }

    private boolean cn() {
        return XL().getDatabasePath(BT()).exists();
    }

    @TargetApi(11)
    static int j6(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long j6(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = gW().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            lg().Zo().j6("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long j6(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = gW().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            lg().Zo().j6("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void j6(String str, com.google.android.gms.internal.hr.a aVar) {
        Object obj = null;
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6((Object) aVar);
        com.google.android.gms.common.internal.b.j6(aVar.FH);
        com.google.android.gms.common.internal.b.j6(aVar.DW);
        if (aVar.j6 == null) {
            lg().yS().j6("Audience with no ID");
            return;
        }
        int intValue = aVar.j6.intValue();
        for (com.google.android.gms.internal.hr.b bVar : aVar.FH) {
            if (bVar.j6 == null) {
                lg().yS().j6("Event filter with no ID. Audience definition ignored. appId, audienceId", str, aVar.j6);
                return;
            }
        }
        for (hr.e eVar : aVar.DW) {
            if (eVar.j6 == null) {
                lg().yS().j6("Property filter with no ID. Audience definition ignored. appId, audienceId", str, aVar.j6);
                return;
            }
        }
        Object obj2 = 1;
        for (com.google.android.gms.internal.hr.b j6 : aVar.FH) {
            if (!j6(str, intValue, j6)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (hr.e j62 : aVar.DW) {
                if (!j6(str, intValue, j62)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            DW(str, intValue);
        }
    }

    private boolean j6(String str, int i, com.google.android.gms.internal.hr.b bVar) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6((Object) bVar);
        if (TextUtils.isEmpty(bVar.DW)) {
            lg().yS().j6("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(bVar.j6));
            return false;
        }
        try {
            byte[] bArr = new byte[bVar.VH()];
            m j6 = m.j6(bArr);
            bVar.j6(j6);
            j6.DW();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", bVar.j6);
            contentValues.put("event_name", bVar.DW);
            contentValues.put("data", bArr);
            try {
                if (gW().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    lg().Zo().j6("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                lg().Zo().j6("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            lg().Zo().j6("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean j6(String str, int i, hr.e eVar) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6((Object) eVar);
        if (TextUtils.isEmpty(eVar.DW)) {
            lg().yS().j6("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(eVar.j6));
            return false;
        }
        try {
            byte[] bArr = new byte[eVar.VH()];
            m j6 = m.j6(bArr);
            eVar.j6(j6);
            j6.DW();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", eVar.j6);
            contentValues.put("property_name", eVar.DW);
            contentValues.put("data", bArr);
            try {
                if (gW().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                lg().Zo().j6("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                lg().Zo().j6("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            lg().Zo().j6("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    String BT() {
        if (!er().ef()) {
            return er().cb();
        }
        if (er().Sf()) {
            return er().cb();
        }
        lg().gW().j6("Using secondary database");
        return er().dx();
    }

    public long DW(e eVar) {
        tp();
        FH();
        com.google.android.gms.common.internal.b.j6((Object) eVar);
        com.google.android.gms.common.internal.b.j6(eVar.QX);
        try {
            byte[] bArr = new byte[eVar.VH()];
            m j6 = m.j6(bArr);
            eVar.j6(j6);
            j6.DW();
            long Hw = j3().Hw(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", eVar.QX);
            contentValues.put("metadata_fingerprint", Long.valueOf(Hw));
            contentValues.put("metadata", bArr);
            try {
                gW().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return Hw;
            } catch (SQLiteException e) {
                lg().Zo().j6("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            lg().Zo().j6("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public a DW(String str) {
        Object e;
        Throwable th;
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        Cursor query;
        try {
            query = gW().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    a aVar = new a(this.J8, str);
                    aVar.j6(query.getString(0));
                    aVar.DW(query.getString(1));
                    aVar.FH(query.getString(2));
                    aVar.Zo(query.getLong(3));
                    aVar.j6(query.getLong(4));
                    aVar.DW(query.getLong(5));
                    aVar.v5(query.getString(6));
                    aVar.Zo(query.getString(7));
                    aVar.Hw(query.getLong(8));
                    aVar.v5(query.getLong(9));
                    aVar.j6((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    aVar.u7(query.getLong(11));
                    aVar.tp(query.getLong(12));
                    aVar.EQ(query.getLong(13));
                    aVar.we(query.getLong(14));
                    aVar.VH(query.getLong(15));
                    aVar.gn(query.getLong(16));
                    aVar.FH(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    aVar.Hw(query.getString(18));
                    aVar.J0(query.getLong(19));
                    aVar.j6();
                    if (query.moveToNext()) {
                        lg().Zo().j6("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return aVar;
                    }
                    query.close();
                    return aVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    lg().Zo().j6("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            lg().Zo().j6("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Object DW(Cursor cursor, int i) {
        int j6 = j6(cursor, i);
        switch (j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                lg().Zo().j6("Loaded invalid null value from database");
                return null;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return Long.valueOf(cursor.getLong(i));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return Double.valueOf(cursor.getDouble(i));
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return cursor.getString(i);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                lg().Zo().j6("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                lg().Zo().j6("Loaded invalid unknown value type, ignoring it", Integer.valueOf(j6));
                return null;
        }
    }

    public String DW(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        tp();
        FH();
        try {
            rawQuery = gW().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    lg().ei().j6("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    lg().Zo().j6("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            lg().Zo().j6("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void DW(String str, int i) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        SQLiteDatabase gW = gW();
        gW.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        gW.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    public void DW(String str, String str2) {
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        tp();
        FH();
        try {
            lg().ei().j6("Deleted user attribute rows:", Integer.valueOf(gW().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            lg().Zo().j6("Error deleting user attribute", str, str2, e);
        }
    }

    public long FH(String str) {
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        try {
            SQLiteDatabase gW = gW();
            String valueOf = String.valueOf(er().Zo(str));
            return (long) gW.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            lg().Zo().j6("Error deleting over the limit events", e);
            return 0;
        }
    }

    public k FH(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        tp();
        FH();
        try {
            Cursor query = gW().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    k kVar = new k(str, str2, query.getLong(0), DW(query, 1));
                    if (query.moveToNext()) {
                        lg().Zo().j6("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return kVar;
                    }
                    query.close();
                    return kVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    lg().Zo().j6("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            lg().Zo().j6("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    Map<Integer, List<com.google.android.gms.internal.hr.b>> Hw(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        Map<Integer, List<com.google.android.gms.internal.hr.b>> lVar = new l();
        try {
            query = gW().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    com.google.android.gms.internal.l j6 = com.google.android.gms.internal.l.j6(query.getBlob(1));
                    com.google.android.gms.internal.hr.b bVar = new com.google.android.gms.internal.hr.b();
                    try {
                        com.google.android.gms.internal.hr.b bVar2 = (com.google.android.gms.internal.hr.b) bVar.DW(j6);
                    } catch (IOException e2) {
                        lg().Zo().j6("Failed to merge filter", str, e2);
                    }
                    try {
                        int i = query.getInt(0);
                        List list = (List) lVar.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            lVar.put(Integer.valueOf(i), list);
                        }
                        list.add(bVar);
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return lVar;
            }
            Map<Integer, List<com.google.android.gms.internal.hr.b>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                lg().Zo().j6("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public byte[] Hw(String str) {
        Object e;
        Throwable th;
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        Cursor query;
        try {
            query = gW().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        lg().Zo().j6("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    lg().Zo().j6("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            lg().Zo().j6("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public boolean KD() {
        return j6("select count(1) > 0 from raw_events", null) != 0;
    }

    void P8() {
        tp();
        FH();
        if (cn()) {
            long j6 = rN().Zo.j6();
            long DW = QX().DW();
            if (Math.abs(DW - j6) > er().ca()) {
                rN().Zo.j6(DW);
                ei();
            }
        }
    }

    public long SI() {
        return j6("select max(timestamp) from raw_events", null, 0);
    }

    public void VH() {
        FH();
        gW().setTransactionSuccessful();
    }

    void VH(String str) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        try {
            SQLiteDatabase gW = gW();
            String[] strArr = new String[]{str};
            int delete = gW.delete("audience_filter_values", "app_id=?", strArr) + (((((((gW.delete("events", "app_id=?", strArr) + 0) + gW.delete("user_attributes", "app_id=?", strArr)) + gW.delete("apps", "app_id=?", strArr)) + gW.delete("raw_events", "app_id=?", strArr)) + gW.delete("raw_events_metadata", "app_id=?", strArr)) + gW.delete("event_filters", "app_id=?", strArr)) + gW.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                lg().ei().j6("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            lg().Zo().j6("Error deleting application data. appId, error", str, e);
        }
    }

    Map<Integer, f> Zo(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        Cursor query;
        try {
            query = gW().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, f> lVar = new l();
                    do {
                        int i = query.getInt(0);
                        com.google.android.gms.internal.l j6 = com.google.android.gms.internal.l.j6(query.getBlob(1));
                        f fVar = new f();
                        try {
                            f fVar2 = (f) fVar.DW(j6);
                            lVar.put(Integer.valueOf(i), fVar);
                        } catch (IOException e2) {
                            lg().Zo().j6("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return lVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                lg().Zo().j6("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void Zo() {
        FH();
        gW().beginTransaction();
    }

    void ei() {
        tp();
        FH();
        if (cn()) {
            int delete = gW().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(QX().j6()), String.valueOf(er().I())});
            if (delete > 0) {
                lg().ei().j6("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    SQLiteDatabase gW() {
        tp();
        try {
            return this.DW.getWritableDatabase();
        } catch (SQLiteException e) {
            lg().yS().j6("Error opening database", e);
            throw e;
        }
    }

    public void gn(String str) {
        try {
            gW().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            lg().Zo().j6("Failed to remove unused event metadata", e);
        }
    }

    public a j6(long j, String str, boolean z, boolean z2, boolean z3) {
        Object e;
        Throwable th;
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        String[] strArr = new String[]{str};
        a aVar = new a();
        Cursor query;
        try {
            SQLiteDatabase gW = gW();
            query = gW.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        aVar.DW = query.getLong(1);
                        aVar.j6 = query.getLong(2);
                        aVar.FH = query.getLong(3);
                        aVar.Hw = query.getLong(4);
                    }
                    aVar.DW++;
                    if (z) {
                        aVar.j6++;
                    }
                    if (z2) {
                        aVar.FH++;
                    }
                    if (z3) {
                        aVar.Hw++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(aVar.j6));
                    contentValues.put("daily_events_count", Long.valueOf(aVar.DW));
                    contentValues.put("daily_conversions_count", Long.valueOf(aVar.FH));
                    contentValues.put("daily_error_events_count", Long.valueOf(aVar.Hw));
                    gW.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return aVar;
                }
                lg().yS().j6("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return aVar;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    lg().Zo().j6("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            lg().Zo().j6("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public t j6(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        tp();
        FH();
        try {
            Cursor query = gW().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    t tVar = new t(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        lg().Zo().j6("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return tVar;
                    }
                    query.close();
                    return tVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    lg().Zo().j6("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            lg().Zo().j6("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<k> j6(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        List<k> arrayList = new ArrayList();
        try {
            Cursor query = gW().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(er().SI()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object DW = DW(query, 2);
                        if (DW == null) {
                            lg().Zo().j6("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new k(str, string, j, DW));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                lg().Zo().j6("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Pair<com.google.android.gms.internal.ht.e, java.lang.Long>> j6(java.lang.String r12, int r13, int r14) {
        /*
        r11 = this;
        r10 = 0;
        r1 = 1;
        r9 = 0;
        r11.tp();
        r11.FH();
        if (r13 <= 0) goto L_0x0053;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        com.google.android.gms.common.internal.b.DW(r0);
        if (r14 <= 0) goto L_0x0055;
    L_0x0011:
        com.google.android.gms.common.internal.b.DW(r1);
        com.google.android.gms.common.internal.b.j6(r12);
        r0 = r11.gW();	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r1 = "queue";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r3 = 0;
        r4 = "rowid";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r3 = 1;
        r4 = "data";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r5 = 0;
        r6 = 0;
        r7 = "rowid";
        r8 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00ef, all -> 0x00e2 }
        r0 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        if (r0 != 0) goto L_0x0057;
    L_0x0049:
        r0 = java.util.Collections.emptyList();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        if (r2 == 0) goto L_0x0052;
    L_0x004f:
        r2.close();
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = r9;
        goto L_0x000c;
    L_0x0055:
        r1 = r9;
        goto L_0x0011;
    L_0x0057:
        r1 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r1.<init>();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r3 = r9;
    L_0x005d:
        r0 = 0;
        r4 = r2.getLong(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r0 = 1;
        r0 = r2.getBlob(r0);	 Catch:{ IOException -> 0x0080 }
        r6 = r11.j3();	 Catch:{ IOException -> 0x0080 }
        r6 = r6.DW(r0);	 Catch:{ IOException -> 0x0080 }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        if (r0 != 0) goto L_0x009a;
    L_0x0075:
        r0 = r6.length;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r0 = r0 + r3;
        if (r0 <= r14) goto L_0x009a;
    L_0x0079:
        if (r2 == 0) goto L_0x007e;
    L_0x007b:
        r2.close();
    L_0x007e:
        r0 = r1;
        goto L_0x0052;
    L_0x0080:
        r0 = move-exception;
        r4 = r11.lg();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r4 = r4.Zo();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r5 = "Failed to unzip queued bundle";
        r4.j6(r5, r12, r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r0 = r3;
    L_0x0090:
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        if (r3 == 0) goto L_0x0079;
    L_0x0096:
        if (r0 > r14) goto L_0x0079;
    L_0x0098:
        r3 = r0;
        goto L_0x005d;
    L_0x009a:
        r0 = com.google.android.gms.internal.l.j6(r6);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r7 = new com.google.android.gms.internal.ht$e;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r7.<init>();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r0 = r7.DW(r0);	 Catch:{ IOException -> 0x00d1 }
        r0 = (com.google.android.gms.internal.ht.e) r0;	 Catch:{ IOException -> 0x00d1 }
        r0 = r6.length;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r0 = r0 + r3;
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r3 = android.util.Pair.create(r7, r3);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r1.add(r3);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        goto L_0x0090;
    L_0x00b7:
        r0 = move-exception;
        r1 = r2;
    L_0x00b9:
        r2 = r11.lg();	 Catch:{ all -> 0x00ec }
        r2 = r2.Zo();	 Catch:{ all -> 0x00ec }
        r3 = "Error querying bundles";
        r2.j6(r3, r12, r0);	 Catch:{ all -> 0x00ec }
        r0 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00ec }
        if (r1 == 0) goto L_0x0052;
    L_0x00cd:
        r1.close();
        goto L_0x0052;
    L_0x00d1:
        r0 = move-exception;
        r4 = r11.lg();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r4 = r4.Zo();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r5 = "Failed to merge queued bundle";
        r4.j6(r5, r12, r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00ea }
        r0 = r3;
        goto L_0x0090;
    L_0x00e2:
        r0 = move-exception;
        r2 = r10;
    L_0x00e4:
        if (r2 == 0) goto L_0x00e9;
    L_0x00e6:
        r2.close();
    L_0x00e9:
        throw r0;
    L_0x00ea:
        r0 = move-exception;
        goto L_0x00e4;
    L_0x00ec:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00e4;
    L_0x00ef:
        r0 = move-exception;
        r1 = r10;
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.p.j6(java.lang.String, int, int):java.util.List<android.util.Pair<com.google.android.gms.internal.ht$e, java.lang.Long>>");
    }

    public void j6(long j) {
        tp();
        FH();
        if (gW().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            lg().Zo().j6("Deleted fewer rows from queue than expected");
        }
    }

    void j6(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void j6(e eVar) {
        tp();
        FH();
        com.google.android.gms.common.internal.b.j6((Object) eVar);
        com.google.android.gms.common.internal.b.j6(eVar.QX);
        com.google.android.gms.common.internal.b.j6(eVar.Zo);
        P8();
        long j6 = QX().j6();
        if (eVar.Zo.longValue() < j6 - er().I() || eVar.Zo.longValue() > er().I() + j6) {
            lg().yS().j6("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(j6), eVar.Zo);
        }
        try {
            byte[] bArr = new byte[eVar.VH()];
            m j62 = m.j6(bArr);
            eVar.j6(j62);
            j62.DW();
            bArr = j3().j6(bArr);
            lg().ei().j6("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", eVar.QX);
            contentValues.put("bundle_end_timestamp", eVar.Zo);
            contentValues.put("data", bArr);
            try {
                if (gW().insert("queue", null, contentValues) == -1) {
                    lg().Zo().j6("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                lg().Zo().j6("Error storing bundle", e);
            }
        } catch (IOException e2) {
            lg().Zo().j6("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void j6(a aVar) {
        com.google.android.gms.common.internal.b.j6((Object) aVar);
        tp();
        FH();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", aVar.DW());
        contentValues.put("app_instance_id", aVar.FH());
        contentValues.put("gmp_app_id", aVar.Hw());
        contentValues.put("resettable_device_id_hash", aVar.v5());
        contentValues.put("last_bundle_index", Long.valueOf(aVar.Ws()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(aVar.VH()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(aVar.gn()));
        contentValues.put("app_version", aVar.u7());
        contentValues.put("app_store", aVar.EQ());
        contentValues.put("gmp_version", Long.valueOf(aVar.we()));
        contentValues.put("dev_cert_hash", Long.valueOf(aVar.J0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(aVar.J8()));
        contentValues.put("day", Long.valueOf(aVar.j3()));
        contentValues.put("daily_public_events_count", Long.valueOf(aVar.Mr()));
        contentValues.put("daily_events_count", Long.valueOf(aVar.U2()));
        contentValues.put("daily_conversions_count", Long.valueOf(aVar.a8()));
        contentValues.put("config_fetched_time", Long.valueOf(aVar.QX()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(aVar.XL()));
        contentValues.put("app_version_int", Long.valueOf(aVar.tp()));
        contentValues.put("firebase_instance_id", aVar.Zo());
        contentValues.put("daily_error_events_count", Long.valueOf(aVar.lg()));
        try {
            if (gW().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                lg().Zo().j6("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            lg().Zo().j6("Error storing app", e);
        }
    }

    public void j6(s sVar, long j) {
        tp();
        FH();
        com.google.android.gms.common.internal.b.j6((Object) sVar);
        com.google.android.gms.common.internal.b.j6(sVar.j6);
        com.google.android.gms.internal.ht.b bVar = new com.google.android.gms.internal.ht.b();
        bVar.Hw = Long.valueOf(sVar.v5);
        bVar.j6 = new com.google.android.gms.internal.ht.c[sVar.Zo.j6()];
        Iterator it = sVar.Zo.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            com.google.android.gms.internal.ht.c cVar = new com.google.android.gms.internal.ht.c();
            int i2 = i + 1;
            bVar.j6[i] = cVar;
            cVar.j6 = str;
            j3().j6(cVar, sVar.Zo.j6(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[bVar.VH()];
            m j6 = m.j6(bArr);
            bVar.j6(j6);
            j6.DW();
            lg().ei().j6("Saving event, name, data size", sVar.DW, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", sVar.j6);
            contentValues.put("name", sVar.DW);
            contentValues.put("timestamp", Long.valueOf(sVar.Hw));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (gW().insert("raw_events", null, contentValues) == -1) {
                    lg().Zo().j6("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                lg().Zo().j6("Error storing raw event", e);
            }
        } catch (IOException e2) {
            lg().Zo().j6("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void j6(t tVar) {
        com.google.android.gms.common.internal.b.j6((Object) tVar);
        tp();
        FH();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", tVar.j6);
        contentValues.put("name", tVar.DW);
        contentValues.put("lifetime_count", Long.valueOf(tVar.FH));
        contentValues.put("current_bundle_count", Long.valueOf(tVar.Hw));
        contentValues.put("last_fire_timestamp", Long.valueOf(tVar.v5));
        try {
            if (gW().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                lg().Zo().j6("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            lg().Zo().j6("Error storing event aggregates", e);
        }
    }

    public void j6(String str, int i) {
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        try {
            gW().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            lg().Zo().j6("Error pruning currencies", str, e);
        }
    }

    void j6(String str, int i, f fVar) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6((Object) fVar);
        try {
            byte[] bArr = new byte[fVar.VH()];
            m j6 = m.j6(bArr);
            fVar.j6(j6);
            j6.DW();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (gW().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    lg().Zo().j6("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                lg().Zo().j6("Error storing filter results", e);
            }
        } catch (IOException e2) {
            lg().Zo().j6("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    public void j6(String str, long j, b bVar) {
        Object string;
        Cursor cursor;
        Object e;
        Throwable th;
        Cursor cursor2 = null;
        com.google.android.gms.common.internal.b.j6((Object) bVar);
        tp();
        FH();
        try {
            String str2;
            SQLiteDatabase gW = gW();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor2 = gW.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(0);
                    string2 = cursor2.getString(1);
                    cursor2.close();
                    str2 = string2;
                    cursor = cursor2;
                } else if (cursor2 != null) {
                    cursor2.close();
                    return;
                } else {
                    return;
                }
            }
            cursor2 = gW.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor2.moveToFirst()) {
                string2 = cursor2.getString(0);
                cursor2.close();
                str2 = string2;
                cursor = cursor2;
            } else if (cursor2 != null) {
                cursor2.close();
                return;
            } else {
                return;
            }
            try {
                cursor = gW.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor.moveToFirst()) {
                    com.google.android.gms.internal.l j6 = com.google.android.gms.internal.l.j6(cursor.getBlob(0));
                    e eVar = new e();
                    try {
                        e eVar2 = (e) eVar.DW(j6);
                        if (cursor.moveToNext()) {
                            lg().yS().j6("Get multiple raw event metadata records, expected one");
                        }
                        cursor.close();
                        bVar.j6(eVar);
                        cursor2 = gW.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor2.moveToFirst()) {
                            do {
                                long j2 = cursor2.getLong(0);
                                com.google.android.gms.internal.l j62 = com.google.android.gms.internal.l.j6(cursor2.getBlob(3));
                                com.google.android.gms.internal.ht.b bVar2 = new com.google.android.gms.internal.ht.b();
                                try {
                                    com.google.android.gms.internal.ht.b bVar3 = (com.google.android.gms.internal.ht.b) bVar2.DW(j62);
                                } catch (IOException e2) {
                                    lg().Zo().j6("Data loss. Failed to merge raw event", string, e2);
                                }
                                try {
                                    bVar2.DW = cursor2.getString(1);
                                    bVar2.FH = Long.valueOf(cursor2.getLong(2));
                                    if (!bVar.j6(j2, bVar2)) {
                                        if (cursor2 != null) {
                                            cursor2.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                }
                            } while (cursor2.moveToNext());
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                        lg().yS().j6("Raw event data disappeared while in transaction");
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        lg().Zo().j6("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                lg().Zo().j6("Raw event metadata record is missing");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor2 = cursor;
                try {
                    lg().Zo().j6("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void j6(String str, byte[] bArr) {
        com.google.android.gms.common.internal.b.j6(str);
        tp();
        FH();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) gW().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                lg().Zo().j6("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            lg().Zo().j6("Error storing remote config", e);
        }
    }

    void j6(String str, com.google.android.gms.internal.hr.a[] aVarArr) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6((Object) aVarArr);
        SQLiteDatabase gW = gW();
        gW.beginTransaction();
        try {
            v5(str);
            for (com.google.android.gms.internal.hr.a j6 : aVarArr) {
                j6(str, j6);
            }
            gW.setTransactionSuccessful();
        } finally {
            gW.endTransaction();
        }
    }

    public void j6(List<Long> list) {
        com.google.android.gms.common.internal.b.j6((Object) list);
        tp();
        FH();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = gW().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            lg().Zo().j6("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean j6(k kVar) {
        com.google.android.gms.common.internal.b.j6((Object) kVar);
        tp();
        FH();
        if (FH(kVar.j6, kVar.DW) == null) {
            if (l.j6(kVar.DW)) {
                if (j6("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{kVar.j6}) >= ((long) er().nw())) {
                    return false;
                }
            }
            if (j6("select count(1) from user_attributes where app_id=?", new String[]{kVar.j6}) >= ((long) er().SI())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", kVar.j6);
        contentValues.put("name", kVar.DW);
        contentValues.put("set_timestamp", Long.valueOf(kVar.FH));
        j6(contentValues, "value", kVar.Hw);
        try {
            if (gW().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                lg().Zo().j6("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            lg().Zo().j6("Error storing user property", e);
        }
        return true;
    }

    public long nw() {
        return j6("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long u7(String str) {
        com.google.android.gms.common.internal.b.j6(str);
        return j6("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    Map<Integer, List<hr.e>> v5(String str, String str2) {
        Object e;
        Throwable th;
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        Map<Integer, List<hr.e>> lVar = new l();
        Cursor query;
        try {
            query = gW().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    com.google.android.gms.internal.l j6 = com.google.android.gms.internal.l.j6(query.getBlob(1));
                    hr.e eVar = new hr.e();
                    try {
                        hr.e eVar2 = (hr.e) eVar.DW(j6);
                    } catch (IOException e2) {
                        lg().Zo().j6("Failed to merge filter", str, e2);
                    }
                    try {
                        int i = query.getInt(0);
                        List list = (List) lVar.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            lVar.put(Integer.valueOf(i), list);
                        }
                        list.add(eVar);
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return lVar;
            }
            Map<Integer, List<hr.e>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                lg().Zo().j6("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void v5() {
    }

    void v5(String str) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        SQLiteDatabase gW = gW();
        gW.delete("property_filters", "app_id=?", new String[]{str});
        gW.delete("event_filters", "app_id=?", new String[]{str});
    }

    public String vy() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = gW().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    lg().Zo().j6("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            lg().Zo().j6("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public void yS() {
        FH();
        gW().endTransaction();
    }
}
