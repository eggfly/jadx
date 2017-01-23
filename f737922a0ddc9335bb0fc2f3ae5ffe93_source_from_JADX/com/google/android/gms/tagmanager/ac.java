package com.google.android.gms.tagmanager;

import afq;
import afs;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ac implements o {
    private static final String j6;
    private final b DW;
    private volatile f FH;
    private final p Hw;
    private long VH;
    private final String Zo;
    private afq gn;
    private final int u7;
    private final Context v5;

    class a implements com.google.android.gms.tagmanager.ap.a {
        final /* synthetic */ ac j6;

        a(ac acVar) {
            this.j6 = acVar;
        }

        public void DW(k kVar) {
            this.j6.j6(kVar.j6());
            r.Hw("Permanent failure dispatching hitId: " + kVar.j6());
        }

        public void FH(k kVar) {
            long DW = kVar.DW();
            if (DW == 0) {
                this.j6.j6(kVar.j6(), this.j6.gn.j6());
            } else if (DW + 14400000 < this.j6.gn.j6()) {
                this.j6.j6(kVar.j6());
                r.Hw("Giving up on failed hitId: " + kVar.j6());
            }
        }

        public void j6(k kVar) {
            this.j6.j6(kVar.j6());
        }
    }

    class b extends SQLiteOpenHelper {
        private boolean DW;
        private long FH;
        final /* synthetic */ ac j6;

        b(ac acVar, Context context, String str) {
            this.j6 = acVar;
            super(context, str, null, 1);
            this.FH = 0;
        }

        private void j6(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean j6(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            String str2;
            String valueOf;
            Throwable th;
            Cursor cursor2 = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        str2 = "Error querying for table ";
                        valueOf = String.valueOf(str);
                        r.DW(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
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
            } catch (SQLiteException e2) {
                cursor = null;
                str2 = "Error querying for table ";
                valueOf = String.valueOf(str);
                if (valueOf.length() == 0) {
                }
                r.DW(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.DW || this.FH + 3600000 <= this.j6.gn.j6()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.DW = true;
                this.FH = this.j6.gn.j6();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.j6.v5.getDatabasePath(this.j6.Zo).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.DW = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            j.j6(sQLiteDatabase.getPath());
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
            if (j6("gtm_hits", sQLiteDatabase)) {
                j6(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(ac.j6);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        j6 = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    }

    ac(p pVar, Context context) {
        this(pVar, context, "gtm_urls.db", 2000);
    }

    ac(p pVar, Context context, String str, int i) {
        this.v5 = context.getApplicationContext();
        this.Zo = str;
        this.Hw = pVar;
        this.gn = afs.Hw();
        this.DW = new b(this, this.v5, this.Zo);
        this.FH = new ap(this.v5, new a(this));
        this.VH = 0;
        this.u7 = i;
    }

    private void DW(long j, String str) {
        SQLiteDatabase j6 = j6("Error opening database for putHit");
        if (j6 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                j6.insert("gtm_hits", null, contentValues);
                this.Hw.j6(false);
            } catch (SQLiteException e) {
                r.DW("Error storing hit");
            }
        }
    }

    private void Zo() {
        int FH = (FH() - this.u7) + 1;
        if (FH > 0) {
            List j6 = j6(FH);
            r.Hw("Store full, deleting " + j6.size() + " hits to make room.");
            j6((String[]) j6.toArray(new String[0]));
        }
    }

    private SQLiteDatabase j6(String str) {
        try {
            return this.DW.getWritableDatabase();
        } catch (SQLiteException e) {
            r.DW(str);
            return null;
        }
    }

    private void j6(long j) {
        j6(new String[]{String.valueOf(j)});
    }

    private void j6(long j, long j2) {
        SQLiteDatabase j6 = j6("Error opening database for getNumStoredHits.");
        if (j6 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                j6.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                r.DW("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                j6(j);
            }
        }
    }

    int DW() {
        boolean z = true;
        long j6 = this.gn.j6();
        if (j6 <= this.VH + 86400000) {
            return 0;
        }
        this.VH = j6;
        SQLiteDatabase j62 = j6("Error opening database for deleteStaleHits.");
        if (j62 == null) {
            return 0;
        }
        int delete = j62.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.gn.j6() - 2592000000L)});
        p pVar = this.Hw;
        if (FH() != 0) {
            z = false;
        }
        pVar.j6(z);
        return delete;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.k> DW(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.j6(r2);
        if (r2 != 0) goto L_0x0012;
    L_0x0010:
        r2 = r11;
    L_0x0011:
        return r2;
    L_0x0012:
        r12 = 0;
        r3 = "gtm_hits";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r5 = 2;
        r6 = "hit_first_send_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00d6, all -> 0x0181 }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0188, all -> 0x0184 }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0188, all -> 0x0184 }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        if (r3 == 0) goto L_0x006f;
    L_0x0052:
        r3 = new com.google.android.gms.tagmanager.k;	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        r4 = 0;
        r4 = r13.getLong(r4);	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        r6 = 1;
        r6 = r13.getLong(r6);	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        r8 = 2;
        r8 = r13.getLong(r8);	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        r3.<init>(r4, r6, r8);	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        r12.add(r3);	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x018e, all -> 0x0184 }
        if (r3 != 0) goto L_0x0052;
    L_0x006f:
        if (r13 == 0) goto L_0x0074;
    L_0x0071:
        r13.close();
    L_0x0074:
        r11 = 0;
        r3 = "gtm_hits";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x017f }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x017f }
        r5 = 1;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x017f }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x017f }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x017f }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x017f }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x017f }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x017f }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        if (r2 == 0) goto L_0x00ce;
    L_0x00a9:
        r4 = r11;
    L_0x00aa:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        if (r2 <= 0) goto L_0x0107;
    L_0x00b8:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2 = (com.google.android.gms.tagmanager.k) r2;	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2.j6(r5);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
    L_0x00c6:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        if (r4 != 0) goto L_0x0194;
    L_0x00ce:
        if (r3 == 0) goto L_0x00d3;
    L_0x00d0:
        r3.close();
    L_0x00d3:
        r2 = r12;
        goto L_0x0011;
    L_0x00d6:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00da:
        r5 = "Error in peekHits fetching hitIds: ";
        r3 = r3.getMessage();	 Catch:{ all -> 0x00ff }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ all -> 0x00ff }
        r6 = r3.length();	 Catch:{ all -> 0x00ff }
        if (r6 == 0) goto L_0x00f9;
    L_0x00eb:
        r3 = r5.concat(r3);	 Catch:{ all -> 0x00ff }
    L_0x00ef:
        com.google.android.gms.tagmanager.r.DW(r3);	 Catch:{ all -> 0x00ff }
        if (r4 == 0) goto L_0x0011;
    L_0x00f4:
        r4.close();
        goto L_0x0011;
    L_0x00f9:
        r3 = new java.lang.String;	 Catch:{ all -> 0x00ff }
        r3.<init>(r5);	 Catch:{ all -> 0x00ff }
        goto L_0x00ef;
    L_0x00ff:
        r2 = move-exception;
        r12 = r4;
    L_0x0101:
        if (r12 == 0) goto L_0x0106;
    L_0x0103:
        r12.close();
    L_0x0106:
        throw r2;
    L_0x0107:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2 = (com.google.android.gms.tagmanager.k) r2;	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r8 = r2.j6();	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        com.google.android.gms.tagmanager.r.DW(r2);	 Catch:{ SQLiteException -> 0x0126, all -> 0x017c }
        goto L_0x00c6;
    L_0x0126:
        r2 = move-exception;
        r13 = r3;
    L_0x0128:
        r3 = "Error in peekHits fetching hit url: ";
        r2 = r2.getMessage();	 Catch:{ all -> 0x0170 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0170 }
        r4 = r2.length();	 Catch:{ all -> 0x0170 }
        if (r4 == 0) goto L_0x016a;
    L_0x0139:
        r2 = r3.concat(r2);	 Catch:{ all -> 0x0170 }
    L_0x013d:
        com.google.android.gms.tagmanager.r.DW(r2);	 Catch:{ all -> 0x0170 }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x0170 }
        r3.<init>();	 Catch:{ all -> 0x0170 }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x0170 }
    L_0x014a:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0170 }
        if (r2 == 0) goto L_0x0162;
    L_0x0150:
        r2 = r5.next();	 Catch:{ all -> 0x0170 }
        r2 = (com.google.android.gms.tagmanager.k) r2;	 Catch:{ all -> 0x0170 }
        r6 = r2.FH();	 Catch:{ all -> 0x0170 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0170 }
        if (r6 == 0) goto L_0x0178;
    L_0x0160:
        if (r4 == 0) goto L_0x0177;
    L_0x0162:
        if (r13 == 0) goto L_0x0167;
    L_0x0164:
        r13.close();
    L_0x0167:
        r2 = r3;
        goto L_0x0011;
    L_0x016a:
        r2 = new java.lang.String;	 Catch:{ all -> 0x0170 }
        r2.<init>(r3);	 Catch:{ all -> 0x0170 }
        goto L_0x013d;
    L_0x0170:
        r2 = move-exception;
    L_0x0171:
        if (r13 == 0) goto L_0x0176;
    L_0x0173:
        r13.close();
    L_0x0176:
        throw r2;
    L_0x0177:
        r4 = 1;
    L_0x0178:
        r3.add(r2);	 Catch:{ all -> 0x0170 }
        goto L_0x014a;
    L_0x017c:
        r2 = move-exception;
        r13 = r3;
        goto L_0x0171;
    L_0x017f:
        r2 = move-exception;
        goto L_0x0128;
    L_0x0181:
        r2 = move-exception;
        goto L_0x0101;
    L_0x0184:
        r2 = move-exception;
        r12 = r13;
        goto L_0x0101;
    L_0x0188:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00da;
    L_0x018e:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00da;
    L_0x0194:
        r4 = r2;
        goto L_0x00aa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ac.DW(int):java.util.List<com.google.android.gms.tagmanager.k>");
    }

    int FH() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase j6 = j6("Error opening database for getNumStoredHits.");
        if (j6 != null) {
            try {
                cursor = j6.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                r.DW("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    int Hw() {
        int count;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        SQLiteDatabase j6 = j6("Error opening database for getNumStoredHits.");
        if (j6 == null) {
            return 0;
        }
        try {
            Cursor query = j6.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    r.DW("Error getting num untried hits");
                    if (cursor == null) {
                        count = 0;
                    } else {
                        cursor.close();
                        count = 0;
                    }
                    return count;
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
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
        } catch (SQLiteException e2) {
            cursor = null;
            r.DW("Error getting num untried hits");
            if (cursor == null) {
                cursor.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return count;
    }

    List<String> j6(int i) {
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            r.DW("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase j6 = j6("Error opening database for peekHitIds.");
        if (j6 == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = j6.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error in peekHits fetching hitIds: ";
                    valueOf = String.valueOf(e.getMessage());
                    r.DW(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
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
            str = "Error in peekHits fetching hitIds: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            r.DW(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void j6() {
        r.Hw("GTM Dispatch running...");
        if (this.FH.j6()) {
            List DW = DW(40);
            if (DW.isEmpty()) {
                r.Hw("...nothing to dispatch");
                this.Hw.j6(true);
                return;
            }
            this.FH.j6(DW);
            if (Hw() > 0) {
                an.FH().j6();
            }
        }
    }

    public void j6(long j, String str) {
        DW();
        Zo();
        DW(j, str);
    }

    void j6(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase j6 = j6("Error opening database for deleteHits.");
            if (j6 != null) {
                try {
                    j6.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    p pVar = this.Hw;
                    if (FH() != 0) {
                        z = false;
                    }
                    pVar.j6(z);
                } catch (SQLiteException e) {
                    r.DW("Error deleting hits");
                }
            }
        }
    }
}
