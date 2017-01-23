package com.cmcm.p074a.p075a.p115d;

import android.content.ContentValues;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.util.UUID;

/* renamed from: com.cmcm.a.a.d.i */
public class C2168i {
    private final int f7532a;
    private final String f7533b;
    private final String f7534c;
    private final int f7535d;

    public C2168i(int i, String str, String str2) {
        this(i, str, str2, System.currentTimeMillis());
    }

    public C2168i(int i, String str, String str2, long j) {
        this.f7532a = i;
        this.f7533b = str;
        this.f7534c = str2;
        this.f7535d = (int) (j / 1000);
    }

    public void m8168a(ContentValues contentValues) {
        String b = TextUtils.isEmpty(this.f7534c) ? null : C2164e.m8157a().m8161b(this.f7534c.getBytes());
        contentValues.put("mode", Integer.valueOf(this.f7532a));
        contentValues.put(C4233j.f14402y, this.f7533b);
        contentValues.put("timestamp", Integer.valueOf(this.f7535d));
        contentValues.put(Constants.KEY_DATA, b);
        contentValues.put("ver", Integer.valueOf(1060001));
        contentValues.put("proto", Integer.valueOf(1000000));
        contentValues.put("guid", UUID.randomUUID().toString());
    }

    public String toString() {
        return String.format("mode: %s\ntype: %s\ntimestamp: %s\ndata: %s", new Object[]{Integer.valueOf(this.f7532a), this.f7533b, Integer.valueOf(this.f7535d), this.f7534c});
    }
}
