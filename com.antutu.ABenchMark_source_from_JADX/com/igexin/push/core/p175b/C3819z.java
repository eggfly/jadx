package com.igexin.push.core.p175b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.bean.C3831k;
import com.igexin.push.core.p180c.C3848l;
import com.igexin.push.p169f.p179a.C3913c;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.igexin.push.core.b.z */
public class C3819z implements C3741a {
    private static final String f12776a;
    private static int f12777b;
    private static int f12778c;
    private static C3819z f12779f;
    private int f12780d;
    private ArrayList f12781e;

    static {
        f12776a = C3819z.class.getName();
        f12777b = Constants.COMMAND_HANDSHAKE;
        f12778c = 50;
    }

    private C3819z() {
        this.f12781e = null;
    }

    public static C3819z m15684a() {
        if (f12779f == null) {
            f12779f = new C3819z();
        }
        return f12779f;
    }

    public ArrayList m15685a(String str) {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        Cursor a;
        try {
            a = C3854f.m15859a().m15881k().m15242a("st", new String[]{C4233j.f14402y}, new String[]{str}, null, null);
            if (a != null) {
                try {
                    if (a.getCount() > 0) {
                        while (a.moveToNext()) {
                            byte[] c = C3700a.m15136c(a.getBlob(2));
                            C3831k c3831k = new C3831k();
                            c3831k.m15759a(a.getInt(0));
                            c3831k.m15763b(a.getInt(1));
                            c3831k.m15761a(new String(c));
                            c3831k.m15760a(a.getLong(3));
                            arrayList.add(c3831k);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C3688a.m15097b(f12776a + "|getThirdGuardData exception:" + th.toString());
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Throwable th4) {
            th = th4;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void m15686a(SQLiteDatabase sQLiteDatabase) {
        Cursor a;
        Throwable th;
        Cursor cursor = null;
        try {
            a = C3854f.m15859a().m15881k().m15242a("st", null, null, null, null);
            if (a != null) {
                try {
                    this.f12780d = a.getCount();
                } catch (Throwable th2) {
                    cursor = a;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void m15687a(String str, String str2) {
        if (this.f12780d >= f12777b) {
            C3688a.m15097b(f12776a + "|rowCount >= 200 can not insert");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(C4233j.f14402y, str);
        contentValues.put("value", C3700a.m15135b(str2.getBytes()));
        contentValues.put(C4233j.f14377D, Long.valueOf(System.currentTimeMillis()));
        C3685c.m15060b().m15053a(new aa(this, contentValues), false, true);
    }

    public void m15688a(String str, ArrayList arrayList) {
        try {
            String[] strArr = new String[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                C3831k c3831k = (C3831k) it.next();
                int i2 = i + 1;
                strArr[i] = String.valueOf(c3831k.m15758a());
                this.f12781e.remove(c3831k);
                i = i2;
            }
            C3854f.m15859a().m15881k().m15246a("st", new String[]{AgooConstants.MESSAGE_ID}, strArr);
            if (this.f12781e.size() > 0) {
                m15692c(str);
            }
        } catch (Throwable th) {
            C3688a.m15097b(f12776a + "|onReportResult exception:" + th.toString());
        }
    }

    public void m15689b(SQLiteDatabase sQLiteDatabase) {
    }

    public void m15690b(String str) {
        this.f12781e = m15685a(str);
        m15692c(str);
    }

    public void m15691c(SQLiteDatabase sQLiteDatabase) {
    }

    public void m15692c(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f12781e.iterator();
            while (it.hasNext()) {
                C3831k c3831k = (C3831k) it.next();
                if (arrayList.size() < f12778c) {
                    arrayList.add(c3831k);
                    stringBuilder.append(c3831k.m15762b());
                    stringBuilder.append("\n");
                }
            }
            break;
            Object stringBuilder2 = stringBuilder.toString();
            if (!TextUtils.isEmpty(stringBuilder2)) {
                C3685c.m15060b().m15053a(new C3913c(new C3848l(stringBuilder2.getBytes(), str, arrayList)), false, true);
            }
        } catch (Throwable th) {
            C3688a.m15097b(f12776a + "|doSTReport exception:" + th.toString());
        }
    }
}
