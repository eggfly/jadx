package com.baidu.mobads.p082b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p083a.C1915d;
import com.baidu.mobads.p080j.C1991m;
import com.umeng.message.common.C4209a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;

/* renamed from: com.baidu.mobads.b.b */
public class C1916b extends C1915d {
    protected final IXAdLogger f6703a;
    private C1913a f6704d;
    private String f6705e;
    private File f6706f;
    private Boolean f6707g;

    public C1916b(Context context, String str, File file, boolean z) {
        super(context);
        this.f6703a = C1991m.m7449a().m7457f();
        this.f6705e = str;
        this.f6706f = file;
        this.f6707g = Boolean.valueOf(z);
    }

    public void m7215a() {
        try {
            if (this.f6707g.booleanValue() && this.f6705e != null) {
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme(C4209a.f14200c);
                this.b.registerReceiver(this.f6704d, intentFilter);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(this.f6706f), "application/vnd.android.package-archive");
            this.b.startActivity(intent);
        } catch (Exception e) {
            this.f6703a.m7400e("XAdInstallController", BuildConfig.FLAVOR);
        }
    }

    public void m7216a(BroadcastReceiver broadcastReceiver) {
        this.f6704d = (C1913a) broadcastReceiver;
    }
}
