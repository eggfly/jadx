package cn.sharesdk.framework.p026b.p027a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.C0979d;

/* renamed from: cn.sharesdk.framework.b.a.b */
public class C0944b {
    private static C0944b f3205c;
    private Context f3206a;
    private C0943a f3207b;

    static {
        f3205c = null;
    }

    private C0944b(Context context) {
        this.f3206a = context.getApplicationContext();
        this.f3207b = new C0943a(this.f3206a);
    }

    public static synchronized C0944b m4125a(Context context) {
        C0944b c0944b;
        synchronized (C0944b.class) {
            if (f3205c == null) {
                f3205c = new C0944b(context);
            }
            c0944b = f3205c;
        }
        return c0944b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m4126a(java.lang.String r6) {
        /*
        r5 = this;
        r2 = 0;
        r0 = 0;
        r1 = r5.f3207b;
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
        r3 = cn.sharesdk.framework.utils.C0979d.m4390a();	 Catch:{ all -> 0x003b }
        r3.m4388w(r1);	 Catch:{ all -> 0x003b }
        r2.close();
        goto L_0x002e;
    L_0x003b:
        r0 = move-exception;
        r2.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.b.a.b.a(java.lang.String):int");
    }

    public int m4127a(String str, String str2, String[] strArr) {
        int delete;
        Throwable e;
        try {
            delete = this.f3207b.getWritableDatabase().delete(str, str2, strArr);
            try {
                C0979d.m4390a().m4375d("Deleted %d rows from table: %s", Integer.valueOf(delete), str);
            } catch (Exception e2) {
                e = e2;
                C0979d.m4390a().m4389w(e, "when delete database occur error table:%s,", str);
                return delete;
            }
        } catch (Throwable e3) {
            e = e3;
            delete = 0;
            C0979d.m4390a().m4389w(e, "when delete database occur error table:%s,", str);
            return delete;
        }
        return delete;
    }

    public long m4128a(String str, ContentValues contentValues) {
        long j = -1;
        try {
            j = this.f3207b.getWritableDatabase().replace(str, null, contentValues);
        } catch (Throwable e) {
            C0979d.m4390a().m4389w(e, "when insert database occur error table:%s,", str);
        }
        return j;
    }

    public Cursor m4129a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.f3207b.getWritableDatabase();
        C0979d.m4390a().m4375d("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
        } catch (Throwable e) {
            C0979d.m4390a().m4389w(e, "when query database occur error table:%s,", str);
            return null;
        }
    }
}
