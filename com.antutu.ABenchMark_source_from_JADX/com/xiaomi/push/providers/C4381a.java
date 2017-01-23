package com.xiaomi.push.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.xiaomi.channel.commonutils.logger.C4302b;

/* renamed from: com.xiaomi.push.providers.a */
public class C4381a extends SQLiteOpenHelper {
    public static final Object f14927a;
    private static int f14928b;
    private static final String[] f14929c;

    static {
        f14928b = 1;
        f14927a = new Object();
        f14929c = new String[]{"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", Constants.KEY_IMSI, "TEXT"};
    }

    public C4381a(Context context) {
        super(context, "traffic.db", null, f14928b);
    }

    private void m18014a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < f14929c.length - 1; i += 2) {
            if (i != 0) {
                stringBuilder.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(f14929c[i]).append(" ").append(f14929c[i + 1]);
        }
        stringBuilder.append(");");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f14927a) {
            try {
                m18014a(sQLiteDatabase);
            } catch (Throwable e) {
                C4302b.m17651a(e);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
