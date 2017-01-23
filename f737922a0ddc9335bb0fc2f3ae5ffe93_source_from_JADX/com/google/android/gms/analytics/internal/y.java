package com.google.android.gms.analytics.internal;

import afw;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class y extends t implements Closeable {
    private static final String DW;
    private static final String j6;
    private final a FH;
    private final m Hw;
    private final m v5;

    class a extends SQLiteOpenHelper {
        final /* synthetic */ y j6;

        a(y yVar, Context context, String str) {
            this.j6 = yVar;
            super(context, str, null, 1);
        }

        private Set<String> DW(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void DW(SQLiteDatabase sQLiteDatabase) {
            int i = 0;
            Set DW = DW(sQLiteDatabase, "properties");
            String[] strArr = new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            while (i < 6) {
                Object obj = strArr[i];
                if (DW.remove(obj)) {
                    i++;
                } else {
                    String str = "Database properties is missing required column: ";
                    String valueOf = String.valueOf(obj);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            if (!DW.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        private void j6(SQLiteDatabase sQLiteDatabase) {
            int i = 1;
            Set DW = DW(sQLiteDatabase, "hits2");
            String[] strArr = new String[]{"hit_id", "hit_string", "hit_time", "hit_url"};
            int i2 = 0;
            while (i2 < 4) {
                Object obj = strArr[i2];
                if (DW.remove(obj)) {
                    i2++;
                } else {
                    String str = "Database hits2 is missing required column: ";
                    String valueOf = String.valueOf(obj);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            if (DW.remove("hit_app_id")) {
                i = 0;
            }
            if (!DW.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (i != 0) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
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
                        this.j6.FH("Error querying for table", str, e);
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
                this.j6.FH("Error querying for table", str, e);
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
            if (this.j6.v5.j6(3600000)) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.j6.v5.j6();
                    this.j6.Zo("Opening the database failed, dropping the table and recreating it");
                    this.j6.Ws().getDatabasePath(this.j6.ro()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.j6.v5.DW();
                    } catch (SQLiteException e2) {
                        this.j6.v5("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            am.j6(sQLiteDatabase.getPath());
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
            if (j6(sQLiteDatabase, "hits2")) {
                j6(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(y.j6);
            }
            if (j6(sQLiteDatabase, "properties")) {
                DW(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        j6 = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
        DW = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    }

    y(v vVar) {
        super(vVar);
        this.Hw = new m(J8());
        this.v5 = new m(J8());
        this.FH = new a(this, vVar.DW(), ro());
    }

    private String DW(c cVar) {
        return cVar.Zo() ? XL().Ws() : XL().QX();
    }

    private static String FH(c cVar) {
        b.j6((Object) cVar);
        Builder builder = new Builder();
        for (Entry entry : cVar.DW().entrySet()) {
            String str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private void KD() {
        int er = XL().er();
        long VH = VH();
        if (VH > ((long) (er - 1))) {
            List j6 = j6((VH - ((long) er)) + 1);
            Hw("Store full, deleting hits to make room, count", Integer.valueOf(j6.size()));
            j6(j6);
        }
    }

    private long j6(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = nw().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            Hw("Database error", str, e);
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
            cursor = nw().rawQuery(str, strArr);
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
            Hw("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String j6(Map<String, String> map) {
        b.j6((Object) map);
        Builder builder = new Builder();
        for (Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private String ro() {
        return !XL().j6() ? XL().gW() : XL().DW() ? XL().gW() : XL().BT();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.c> DW(long r14) {
        /*
        r13 = this;
        r0 = 1;
        r1 = 0;
        r9 = 0;
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0097;
    L_0x0009:
        com.google.android.gms.common.internal.b.DW(r0);
        r13.J0();
        r13.P8();
        r0 = r13.nw();
        r1 = "hits2";
        r2 = 5;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 1;
        r4 = "hit_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 2;
        r4 = "hit_string";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 3;
        r4 = "hit_url";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 4;
        r4 = "hit_app_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r10 = 0;
        r11 = "hit_id";
        r8[r10] = r11;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r10 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r10.<init>();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        if (r0 == 0) goto L_0x0091;
    L_0x0061:
        r0 = 0;
        r6 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = 1;
        r3 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = 2;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r1 = 3;
        r1 = r9.getString(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r2 = 4;
        r8 = r9.getInt(r2);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r2 = r13.j6(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r5 = com.google.android.gms.analytics.internal.p.Hw(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = new com.google.android.gms.analytics.internal.c;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r1 = r13;
        r0.<init>(r1, r2, r3, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r10.add(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        if (r0 != 0) goto L_0x0061;
    L_0x0091:
        if (r9 == 0) goto L_0x0096;
    L_0x0093:
        r9.close();
    L_0x0096:
        return r10;
    L_0x0097:
        r0 = r1;
        goto L_0x0009;
    L_0x009a:
        r0 = move-exception;
        r1 = r9;
    L_0x009c:
        r2 = "Error loading hits from the database";
        r13.v5(r2, r0);	 Catch:{ all -> 0x00a3 }
        throw r0;	 Catch:{ all -> 0x00a3 }
    L_0x00a3:
        r0 = move-exception;
        r9 = r1;
    L_0x00a5:
        if (r9 == 0) goto L_0x00aa;
    L_0x00a7:
        r9.close();
    L_0x00aa:
        throw r0;
    L_0x00ab:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x00ad:
        r0 = move-exception;
        r1 = r9;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.y.DW(long):java.util.List<com.google.android.gms.analytics.internal.c>");
    }

    public void DW() {
        P8();
        nw().beginTransaction();
    }

    public void FH() {
        P8();
        nw().setTransactionSuccessful();
    }

    public void FH(long j) {
        J0();
        P8();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        j6("Deleting hit, id", Long.valueOf(j));
        j6(arrayList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.w> Hw(long r14) {
        /*
        r13 = this;
        r13.P8();
        r13.J0();
        r0 = r13.nw();
        r9 = 0;
        r1 = 5;
        r2 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = 0;
        r3 = "cid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = 1;
        r3 = "tid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = 2;
        r3 = "adid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = 3;
        r3 = "hits_count";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = 4;
        r3 = "params";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = r13.XL();	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r10 = r1.yS();	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r8 = java.lang.String.valueOf(r10);	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r3 = "app_uid=?";
        r1 = 1;
        r4 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = 0;
        r5 = java.lang.String.valueOf(r14);	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r4[r1] = r5;	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r1 = "properties";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00c4, all -> 0x00c2 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        if (r0 == 0) goto L_0x0093;
    L_0x005a:
        r0 = 0;
        r3 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r0 = 1;
        r4 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r0 = 2;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        if (r0 == 0) goto L_0x00a5;
    L_0x006b:
        r5 = 1;
    L_0x006c:
        r0 = 3;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r6 = (long) r0;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r0 = 4;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r8 = r13.VH(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        if (r0 != 0) goto L_0x0087;
    L_0x0081:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        if (r0 == 0) goto L_0x00a7;
    L_0x0087:
        r0 = "Read property with empty client id or tracker id";
        r13.FH(r0, r3, r4);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
    L_0x008d:
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        if (r0 != 0) goto L_0x005a;
    L_0x0093:
        r0 = r11.size();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        if (r0 < r10) goto L_0x009f;
    L_0x0099:
        r0 = "Sending hits to too many properties. Campaign report might be incorrect";
        r13.v5(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
    L_0x009f:
        if (r9 == 0) goto L_0x00a4;
    L_0x00a1:
        r9.close();
    L_0x00a4:
        return r11;
    L_0x00a5:
        r5 = 0;
        goto L_0x006c;
    L_0x00a7:
        r0 = new com.google.android.gms.analytics.internal.w;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r1 = r14;
        r0.<init>(r1, r3, r4, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        r11.add(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00c2 }
        goto L_0x008d;
    L_0x00b1:
        r0 = move-exception;
        r1 = r9;
    L_0x00b3:
        r2 = "Error loading hits from the database";
        r13.v5(r2, r0);	 Catch:{ all -> 0x00ba }
        throw r0;	 Catch:{ all -> 0x00ba }
    L_0x00ba:
        r0 = move-exception;
        r9 = r1;
    L_0x00bc:
        if (r9 == 0) goto L_0x00c1;
    L_0x00be:
        r9.close();
    L_0x00c1:
        throw r0;
    L_0x00c2:
        r0 = move-exception;
        goto L_0x00bc;
    L_0x00c4:
        r0 = move-exception;
        r1 = r9;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.y.Hw(long):java.util.List<com.google.android.gms.analytics.internal.w>");
    }

    public void Hw() {
        P8();
        nw().endTransaction();
    }

    public long VH() {
        J0();
        P8();
        return j6("SELECT COUNT(*) FROM hits2", null);
    }

    Map<String, String> VH(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String str2 = "?";
            String valueOf = String.valueOf(str);
            return afw.j6(new URI(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2)), "UTF-8");
        } catch (URISyntaxException e) {
            v5("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public void Zo() {
        J0();
        P8();
        nw().delete("properties", null, null);
    }

    public void close() {
        try {
            this.FH.close();
        } catch (SQLiteException e) {
            v5("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            v5("Error closing database", e2);
        }
    }

    boolean gn() {
        return VH() == 0;
    }

    public long j6(long j, String str, String str2) {
        b.j6(str);
        b.j6(str2);
        P8();
        J0();
        return j6("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public List<Long> j6(long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        J0();
        P8();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase nw = nw();
        List<Long> arrayList = new ArrayList();
        Cursor query;
        try {
            query = nw.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Hw("Error selecting hit ids", e);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
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
            Hw("Error selecting hit ids", e);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    Map<String, String> j6(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String str2 = "?";
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            return afw.j6(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            v5("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    protected void j6() {
    }

    public void j6(long j, String str) {
        b.j6(str);
        P8();
        J0();
        int delete = nw().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            j6("Deleted property records", Integer.valueOf(delete));
        }
    }

    public void j6(c cVar) {
        b.j6((Object) cVar);
        J0();
        P8();
        String FH = FH(cVar);
        if (FH.length() > 8192) {
            QX().j6(cVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        KD();
        SQLiteDatabase nw = nw();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", FH);
        contentValues.put("hit_time", Long.valueOf(cVar.Hw()));
        contentValues.put("hit_app_id", Integer.valueOf(cVar.j6()));
        contentValues.put("hit_url", DW(cVar));
        try {
            long insert = nw.insert("hits2", null, contentValues);
            if (insert == -1) {
                Zo("Failed to insert a hit (got -1)");
            } else {
                DW("Hit saved to database. db-id, hit", Long.valueOf(insert), cVar);
            }
        } catch (SQLiteException e) {
            v5("Error storing a hit", e);
        }
    }

    public void j6(w wVar) {
        b.j6((Object) wVar);
        P8();
        J0();
        SQLiteDatabase nw = nw();
        String j6 = j6(wVar.Zo());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(wVar.j6()));
        contentValues.put("cid", wVar.DW());
        contentValues.put("tid", wVar.FH());
        contentValues.put("adid", Integer.valueOf(wVar.Hw() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(wVar.v5()));
        contentValues.put("params", j6);
        try {
            if (nw.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                Zo("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            v5("Error storing a property", e);
        }
    }

    public void j6(List<Long> list) {
        b.j6((Object) list);
        J0();
        P8();
        if (!list.isEmpty()) {
            int i;
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            for (i = 0; i < list.size(); i++) {
                Long l = (Long) list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(l);
            }
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            try {
                SQLiteDatabase nw = nw();
                j6("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                i = nw.delete("hits2", stringBuilder2, null);
                if (i != list.size()) {
                    DW("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i), stringBuilder2);
                }
            } catch (SQLiteException e) {
                v5("Error deleting hits", e);
                throw e;
            }
        }
    }

    SQLiteDatabase nw() {
        try {
            return this.FH.getWritableDatabase();
        } catch (SQLiteException e) {
            Hw("Error opening database", e);
            throw e;
        }
    }

    public long tp() {
        J0();
        P8();
        return j6(DW, null, 0);
    }

    public int u7() {
        J0();
        P8();
        if (!this.Hw.j6(86400000)) {
            return 0;
        }
        this.Hw.j6();
        DW("Deleting stale hits (if any)");
        int delete = nw().delete("hits2", "hit_time < ?", new String[]{Long.toString(J8().j6() - 2592000000L)});
        j6("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public void v5() {
        J0();
        P8();
        nw().delete("hits2", null, null);
    }
}
