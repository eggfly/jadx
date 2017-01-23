package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.mob.tools.MobLog;

/* renamed from: com.mob.commons.logcollector.b */
public class C3998b {
    private static C3998b f13363c;
    private Context f13364a;
    private C3997a f13365b;

    static {
        f13363c = null;
    }

    private C3998b(Context context) {
        this.f13364a = context.getApplicationContext();
        this.f13365b = new C3997a(this.f13364a);
    }

    public static synchronized C3998b m16467a(Context context) {
        C3998b c3998b;
        synchronized (C3998b.class) {
            if (f13363c == null) {
                f13363c = new C3998b(context);
            }
            c3998b = f13363c;
        }
        return c3998b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m16468a(java.lang.String r6) {
        /*
        r5 = this;
        r2 = 0;
        r0 = 0;
        r1 = r5.f13365b;
        r1 = r1.getWritableDatabase();
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002f }
        r3.<init>();	 Catch:{ Exception -> 0x002f }
        r4 = "select count(*) from ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x002f }
        r3 = r3.append(r6);	 Catch:{ Exception -> 0x002f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x002f }
        r4 = 0;
        r2 = r1.rawQuery(r3, r4);	 Catch:{ Exception -> 0x002f }
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x002f }
        if (r1 == 0) goto L_0x002b;
    L_0x0026:
        r1 = 0;
        r0 = r2.getInt(r1);	 Catch:{ Exception -> 0x002f }
    L_0x002b:
        r2.close();
    L_0x002e:
        return r0;
    L_0x002f:
        r1 = move-exception;
        r3 = com.mob.tools.MobLog.getInstance();	 Catch:{ all -> 0x003b }
        r3.m4388w(r1);	 Catch:{ all -> 0x003b }
        r2.close();
        goto L_0x002e;
    L_0x003b:
        r0 = move-exception;
        r2.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.logcollector.b.a(java.lang.String):int");
    }

    public int m16469a(String str, String str2, String[] strArr) {
        int delete;
        Throwable e;
        try {
            delete = this.f13365b.getWritableDatabase().delete(str, str2, strArr);
            try {
                MobLog.getInstance().m4375d("Deleted %d rows from table: %s", Integer.valueOf(delete), str);
            } catch (Exception e2) {
                e = e2;
                MobLog.getInstance().m4389w(e, "when delete database occur error table:%s,", str);
                return delete;
            }
        } catch (Throwable e3) {
            e = e3;
            delete = 0;
            MobLog.getInstance().m4389w(e, "when delete database occur error table:%s,", str);
            return delete;
        }
        return delete;
    }

    public long m16470a(String str, ContentValues contentValues) {
        long j = -1;
        try {
            j = this.f13365b.getWritableDatabase().replace(str, null, contentValues);
        } catch (Throwable e) {
            MobLog.getInstance().m4389w(e, "when insert database occur error table:%s,", str);
        }
        return j;
    }

    public Cursor m16471a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = this.f13365b.getWritableDatabase().rawQuery(str, strArr);
        } catch (Throwable e) {
            MobLog.getInstance().m4388w(e);
        }
        return cursor;
    }
}
