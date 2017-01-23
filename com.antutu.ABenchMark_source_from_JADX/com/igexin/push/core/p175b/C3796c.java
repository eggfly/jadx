package com.igexin.push.core.p175b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.core.bean.C3830j;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.core.b.c */
public class C3796c implements C3741a {
    private static C3796c f12742a;
    private List f12743b;

    private C3796c() {
        this.f12743b = new CopyOnWriteArrayList();
    }

    private int m15611a(int i) {
        int i2 = 0;
        for (C3830j c : this.f12743b) {
            i2 = c.m15756c() == i ? i2 + 1 : i2;
        }
        return i2;
    }

    public static C3796c m15612a() {
        if (f12742a == null) {
            f12742a = new C3796c();
        }
        return f12742a;
    }

    private static ContentValues m15613b(C3830j c3830j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Long.valueOf(c3830j.m15753a()));
        contentValues.put(Constants.KEY_DATA, C3700a.m15135b(c3830j.m15755b().getBytes()));
        contentValues.put(C4233j.f14402y, Byte.valueOf(c3830j.m15756c()));
        contentValues.put(C4233j.f14377D, Long.valueOf(c3830j.m15757d()));
        return contentValues;
    }

    private C3830j m15614b(long j) {
        for (C3830j c3830j : this.f12743b) {
            if (c3830j.m15753a() == j) {
                return c3830j;
            }
        }
        return null;
    }

    public void m15615a(SQLiteDatabase sQLiteDatabase) {
    }

    public void m15616a(C3830j c3830j) {
        if (this.f12743b.size() < 47 && c3830j != null) {
            switch (c3830j.m15756c()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (m15611a(1) >= 1) {
                        return;
                    }
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (m15611a(2) >= 3) {
                        return;
                    }
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (m15611a(3) >= 30) {
                        return;
                    }
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (m15611a(5) >= 3) {
                        return;
                    }
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (m15611a(6) >= 10) {
                        return;
                    }
                    break;
            }
            this.f12743b.add(c3830j);
            C3685c.m15060b().m15053a(new C3797d(this, C3796c.m15613b(c3830j)), true, false);
        }
    }

    public boolean m15617a(long j) {
        C3830j b = m15614b(j);
        if (b == null) {
            return false;
        }
        this.f12743b.remove(b);
        C3685c.m15060b().m15053a(new C3798e(this, C3796c.m15613b(b), j), true, false);
        return true;
    }

    public List m15618b() {
        return this.f12743b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15619b(android.database.sqlite.SQLiteDatabase r14) {
        /*
        r13 = this;
        r0 = 0;
        r1 = "select id,data,type,time from ral";
        r2 = 0;
        r0 = r14.rawQuery(r1, r2);	 Catch:{ Exception -> 0x0049, all -> 0x0056 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r0 == 0) goto L_0x0050;
    L_0x000e:
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        if (r1 == 0) goto L_0x0050;
    L_0x0014:
        r1 = 0;
        r2 = r0.getLong(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r1 = 2;
        r1 = r0.getInt(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r5 = (byte) r1;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r1 = 3;
        r6 = r0.getLong(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r10 = r13.f12743b;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r1 = new com.igexin.push.core.bean.j;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r11 = 1;
        r11 = r0.getBlob(r11);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r11 = com.igexin.p158b.p168b.C3700a.m15136c(r11);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4.<init>(r11);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r1.<init>(r2, r4, r5, r6);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r10.add(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        r4 = r8 - r6;
        r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x000e;
    L_0x0045:
        r13.m15617a(r2);	 Catch:{ Exception -> 0x0049, all -> 0x0060 }
        goto L_0x000e;
    L_0x0049:
        r1 = move-exception;
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        r0.close();
    L_0x004f:
        return;
    L_0x0050:
        if (r0 == 0) goto L_0x004f;
    L_0x0052:
        r0.close();
        goto L_0x004f;
    L_0x0056:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x005a:
        if (r1 == 0) goto L_0x005f;
    L_0x005c:
        r1.close();
    L_0x005f:
        throw r0;
    L_0x0060:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void m15620c(SQLiteDatabase sQLiteDatabase) {
    }
}
