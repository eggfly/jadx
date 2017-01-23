package com.igexin.push.p173b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.igexin.push.core.p175b.C3799f;

/* renamed from: com.igexin.push.b.b */
public class C3719b extends SQLiteOpenHelper {
    private SQLiteDatabase f12539a;

    public C3719b(Context context) {
        super(context, "pushsdk.db", null, 3);
        this.f12539a = null;
    }

    private String m15240a(String[] strArr, String[] strArr2, int i) {
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder(" ");
        if (strArr.length == 1) {
            for (int i3 = 0; i3 < i; i3++) {
                stringBuilder.append(strArr[0]).append(" = '").append(strArr2[i3]).append("'");
                if (i3 < i - 1) {
                    stringBuilder.append(" or ");
                }
            }
        } else {
            while (i2 < i) {
                stringBuilder.append(strArr[i2]).append(" = '").append(strArr2[i2]).append("'");
                if (i2 < i - 1) {
                    stringBuilder.append(" and ");
                }
                i2++;
            }
        }
        return stringBuilder.toString();
    }

    private String m15241b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor m15242a(java.lang.String r10, java.lang.String[] r11, java.lang.String[] r12, java.lang.String[] r13, java.lang.String r14) {
        /*
        r9 = this;
        r1 = 1;
        r8 = 0;
        r0 = r9.getReadableDatabase();
        r9.f12539a = r0;
        r0 = r9.f12539a;
        r0.beginTransaction();
        if (r11 != 0) goto L_0x0027;
    L_0x000f:
        r0 = r9.f12539a;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r2 = r13;
        r7 = r14;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
    L_0x001c:
        r1 = r9.f12539a;	 Catch:{ Exception -> 0x0083, all -> 0x007c }
        r1.setTransactionSuccessful();	 Catch:{ Exception -> 0x0083, all -> 0x007c }
        r1 = r9.f12539a;
        r1.endTransaction();
    L_0x0026:
        return r0;
    L_0x0027:
        r0 = r11.length;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        if (r0 != r1) goto L_0x0062;
    L_0x002a:
        r0 = r12.length;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        if (r0 != r1) goto L_0x0050;
    L_0x002d:
        r0 = r9.f12539a;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r1.<init>();	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r2 = 0;
        r2 = r11[r2];	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r2 = "= ?";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r3 = r1.toString();	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r2 = r13;
        r4 = r12;
        r7 = r14;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        goto L_0x001c;
    L_0x0050:
        r0 = r9.f12539a;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r1 = r12.length;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r3 = r9.m15240a(r11, r12, r1);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r2 = r13;
        r7 = r14;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        goto L_0x001c;
    L_0x0062:
        r0 = r9.f12539a;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r1 = r11.length;	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r3 = r9.m15240a(r11, r12, r1);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r2 = r13;
        r7 = r14;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0074, all -> 0x007c }
        goto L_0x001c;
    L_0x0074:
        r0 = move-exception;
        r0 = r8;
    L_0x0076:
        r1 = r9.f12539a;
        r1.endTransaction();
        goto L_0x0026;
    L_0x007c:
        r0 = move-exception;
        r1 = r9.f12539a;
        r1.endTransaction();
        throw r0;
    L_0x0083:
        r1 = move-exception;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public void m15243a(String str, ContentValues contentValues) {
        this.f12539a = getWritableDatabase();
        this.f12539a.beginTransaction();
        try {
            this.f12539a.insert(str, null, contentValues);
            this.f12539a.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f12539a.endTransaction();
        }
    }

    public void m15244a(String str, ContentValues contentValues, String[] strArr, String[] strArr2) {
        this.f12539a = getWritableDatabase();
        this.f12539a.beginTransaction();
        if (strArr == null) {
            try {
                this.f12539a.update(str, contentValues, null, null);
            } catch (Exception e) {
                this.f12539a.endTransaction();
                return;
            } catch (Throwable th) {
                this.f12539a.endTransaction();
            }
        } else if (strArr.length != 1) {
            this.f12539a.update(str, contentValues, m15240a(strArr, strArr2, strArr.length), null);
        } else if (strArr2.length == 1) {
            this.f12539a.update(str, contentValues, strArr[0] + "='" + strArr2[0] + "'", null);
        } else {
            this.f12539a.update(str, contentValues, m15240a(strArr, strArr2, strArr2.length), null);
        }
        this.f12539a.setTransactionSuccessful();
        this.f12539a.endTransaction();
    }

    public void m15245a(String str, String str2) {
        this.f12539a = getWritableDatabase();
        this.f12539a.beginTransaction();
        try {
            this.f12539a.delete(str, str2, null);
            this.f12539a.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f12539a.endTransaction();
        }
    }

    public void m15246a(String str, String[] strArr, String[] strArr2) {
        this.f12539a = getWritableDatabase();
        this.f12539a.beginTransaction();
        if (strArr == null) {
            try {
                this.f12539a.delete(str, null, null);
            } catch (Exception e) {
                this.f12539a.endTransaction();
                return;
            } catch (Throwable th) {
                this.f12539a.endTransaction();
            }
        } else if (strArr.length != 1) {
            this.f12539a.execSQL(m15241b(str, m15240a(strArr, strArr2, strArr.length)));
        } else if (strArr2.length == 1) {
            this.f12539a.delete(str, strArr[0] + " = ?", strArr2);
        } else {
            this.f12539a.execSQL(m15241b(str, m15240a(strArr, strArr2, strArr2.length)));
        }
        this.f12539a.setTransactionSuccessful();
        this.f12539a.endTransaction();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("create table if not exists config (id integer primary key,value text)");
            sQLiteDatabase.execSQL("create table if not exists runtime (id integer primary key,value text)");
            sQLiteDatabase.execSQL("create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer)");
            sQLiteDatabase.execSQL("create table if not exists ral (id integer primary key,data text,type integer,time integer)");
            sQLiteDatabase.execSQL("create table if not exists ca (pkgname text primary key,signature text,permissions text, accesstoken blob, expire integer)");
            sQLiteDatabase.execSQL("create table if not exists bi(id integer primary key autoincrement, start_service_count integer, login_count integer, loginerror_nonetwork_count integer, loginerror_timeout_count integer, loginerror_connecterror_count integer, loginerror_other_count integer, online_time long, network_time long, running_time long, create_time text, type integer)");
            sQLiteDatabase.execSQL("create table if not exists st(id integer primary key autoincrement,type integer,value blob,time integer)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C3799f.m15623a().m15659d(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL("drop table if exists config");
        } catch (Exception e) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists runtime");
        } catch (Exception e2) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists message");
        } catch (Exception e3) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ral");
        } catch (Exception e4) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ca");
        } catch (Exception e5) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists bi");
        } catch (Exception e6) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists st");
        } catch (Exception e7) {
        }
        onCreate(sQLiteDatabase);
    }
}
