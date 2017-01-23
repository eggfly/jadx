package com.umeng.message.proguard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.umeng.message.MsgConstant;
import com.umeng.message.entity.UMessage;
import com.umeng.message.provider.C4243a;

/* renamed from: com.umeng.message.proguard.j */
public class C4233j {
    public static final String f14374A = "exclusive";
    public static final String f14375B = "error";
    public static final String f14376C = "message";
    public static final String f14377D = "time";
    public static C4233j f14378a = null;
    public static final String f14379b = "MessageStore.db";
    public static final String f14380c = "MessageStore";
    public static final String f14381d = "MsgTemp";
    public static final String f14382e = "MsgAlias";
    public static final int f14383f = 2;
    public static final String f14384g = "_id";
    public static final String f14385h = "MsdId";
    public static final String f14386i = "Json";
    public static final String f14387j = "SdkVersion";
    public static final String f14388k = "ArrivalTime";
    public static final String f14389l = "ActionType";
    public static final String f14390m = " PRIMARY KEY ";
    public static final String f14391n = " AUTOINCREMENT ";
    public static final String f14392o = "CREATE TABLE IF NOT EXISTS ";
    public static final String f14393p = " Integer ";
    public static final String f14394q = " Long ";
    public static final String f14395r = " Varchar ";
    public static final String f14396s = "(";
    public static final String f14397t = ")";
    public static final String f14398u = " , ";
    public static final String f14399v = " And ";
    public static final String f14400w = " desc ";
    public static final String f14401x = " asc ";
    public static final String f14402y = "type";
    public static final String f14403z = "alias";
    private Context f14404E;

    private C4233j(Context context) {
        this.f14404E = context.getApplicationContext();
    }

    public static C4233j m17292a(Context context) {
        if (f14378a == null) {
            f14378a = new C4233j(context);
        }
        return f14378a;
    }

    boolean m17293a(UMessage uMessage) {
        boolean z = false;
        if (uMessage != null) {
            synchronized (f14378a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f14385h, uMessage.msg_id);
                contentValues.put(f14386i, uMessage.getRaw().toString());
                contentValues.put(f14387j, MsgConstant.SDK_VERSION);
                contentValues.put(f14388k, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(f14389l, Integer.valueOf(0));
                ContentResolver contentResolver = this.f14404E.getContentResolver();
                C4243a.m17332a(this.f14404E);
                if (contentResolver.insert(C4243a.f14475b, contentValues) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    boolean m17294a(String str) {
        return m17295a(str, 1);
    }

    boolean m17295a(String str, int i) {
        boolean z = true;
        synchronized (f14378a) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f14389l, Integer.valueOf(i));
            String[] strArr = new String[]{str};
            ContentResolver contentResolver = this.f14404E.getContentResolver();
            C4243a.m17332a(this.f14404E);
            if (contentResolver.update(C4243a.f14475b, contentValues, "MsdId=?", strArr) != 1) {
                z = false;
            }
        }
        return z;
    }

    boolean m17296b(String str) {
        return m17295a(str, f14383f);
    }
}
