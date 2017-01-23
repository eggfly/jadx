package com.xiaomi.network;

import android.content.Context;
import com.xiaomi.channel.commonutils.network.C4316c;
import java.util.List;

public abstract class HttpProcessor {
    private int f14859a;

    public HttpProcessor(int i) {
        this.f14859a = i;
    }

    public int m17923a() {
        return this.f14859a;
    }

    public boolean m17924a(Context context, String str, List<C4316c> list) {
        return true;
    }

    public abstract String m17925b(Context context, String str, List<C4316c> list);
}
