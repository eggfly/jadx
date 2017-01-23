package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.da.C3110a;
import java.util.concurrent.Future;

@gb
/* renamed from: com.google.android.gms.b.db */
public class db {

    /* renamed from: com.google.android.gms.b.db.1 */
    class C31111 implements Runnable {
        final /* synthetic */ Context f10555a;
        final /* synthetic */ VersionInfoParcel f10556b;
        final /* synthetic */ C3113a f10557c;
        final /* synthetic */ C3326k f10558d;
        final /* synthetic */ String f10559e;
        final /* synthetic */ db f10560f;

        C31111(db dbVar, Context context, VersionInfoParcel versionInfoParcel, C3113a c3113a, C3326k c3326k, String str) {
            this.f10560f = dbVar;
            this.f10555a = context;
            this.f10556b = versionInfoParcel;
            this.f10557c = c3113a;
            this.f10558d = c3326k;
            this.f10559e = str;
        }

        public void run() {
            this.f10560f.m12219a(this.f10555a, this.f10556b, this.f10557c, this.f10558d).m12212b(this.f10559e);
        }
    }

    /* renamed from: com.google.android.gms.b.db.2 */
    class C31122 implements C3110a {
        final /* synthetic */ C3113a f10561a;
        final /* synthetic */ db f10562b;

        C31122(db dbVar, C3113a c3113a) {
            this.f10562b = dbVar;
            this.f10561a = c3113a;
        }

        public void m12214a() {
            this.f10561a.m12217b(this.f10561a.f10568a);
        }
    }

    /* renamed from: com.google.android.gms.b.db.a */
    private static class C3113a<JavascriptEngine> extends hw<JavascriptEngine> {
        JavascriptEngine f10568a;

        private C3113a() {
        }
    }

    private da m12219a(Context context, VersionInfoParcel versionInfoParcel, C3113a<da> c3113a, C3326k c3326k) {
        da dcVar = new dc(context, versionInfoParcel, c3326k);
        c3113a.f10568a = dcVar;
        dcVar.m12209a(new C31122(this, c3113a));
        return dcVar;
    }

    public Future<da> m12221a(Context context, VersionInfoParcel versionInfoParcel, String str, C3326k c3326k) {
        Future c3113a = new C3113a();
        hj.f11297a.post(new C31111(this, context, versionInfoParcel, c3113a, c3326k, str));
        return c3113a;
    }
}
