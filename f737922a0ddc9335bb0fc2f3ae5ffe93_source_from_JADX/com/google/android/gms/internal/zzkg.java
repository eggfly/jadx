package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

@eh
public class zzkg {
    private static fi DW;
    private static final Object FH;
    public static final a<Void> j6;

    public interface a<T> {
    }

    class 1 implements a<Void> {
        1() {
        }
    }

    class 2 implements com.google.android.gms.internal.gh.a {
        final /* synthetic */ b DW;
        final /* synthetic */ zzkg FH;
        final /* synthetic */ String j6;

        2(zzkg com_google_android_gms_internal_zzkg, String str, b bVar) {
            this.FH = com_google_android_gms_internal_zzkg;
            this.j6 = str;
            this.DW = bVar;
        }

        public void j6(hp hpVar) {
            String str = this.j6;
            String valueOf = String.valueOf(hpVar.toString());
            com.google.android.gms.ads.internal.util.client.b.Hw(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
            this.DW.j6(null);
        }
    }

    class 3 extends c {
        final /* synthetic */ Map DW;
        final /* synthetic */ zzkg FH;
        final /* synthetic */ byte[] j6;

        3(zzkg com_google_android_gms_internal_zzkg, int i, String str, com.google.android.gms.internal.gh.b bVar, com.google.android.gms.internal.gh.a aVar, byte[] bArr, Map map) {
            this.FH = com_google_android_gms_internal_zzkg;
            this.j6 = bArr;
            this.DW = map;
            super(i, str, bVar, aVar);
        }

        public Map<String, String> VH() {
            return this.DW == null ? super.VH() : this.DW;
        }

        public byte[] Ws() {
            return this.j6 == null ? super.Ws() : this.j6;
        }
    }

    private class b<T> extends fa<T> implements com.google.android.gms.internal.gh.b<T> {
        final /* synthetic */ zzkg j6;

        private b(zzkg com_google_android_gms_internal_zzkg) {
            this.j6 = com_google_android_gms_internal_zzkg;
        }

        public void j6(T t) {
            super.DW(t);
        }
    }

    static {
        FH = new Object();
        j6 = new 1();
    }

    public zzkg(Context context) {
        j6(context);
    }

    private static fi j6(Context context) {
        fi fiVar;
        synchronized (FH) {
            if (DW == null) {
                DW = e.j6(context.getApplicationContext());
            }
            fiVar = DW;
        }
        return fiVar;
    }

    public fb<String> j6(int i, String str, Map<String, String> map, byte[] bArr) {
        Object bVar = new b();
        DW.j6(new 3(this, i, str, bVar, new 2(this, str, bVar), bArr, map));
        return bVar;
    }

    public fb<String> j6(String str, Map<String, String> map) {
        return j6(0, str, map, null);
    }
}
