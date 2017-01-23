package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.AdError;
import com.google.android.gms.common.api.C3304d;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3000a.C3387b;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.iw;
import com.google.android.gms.p146b.ix;
import com.google.android.gms.p146b.jg;
import com.google.android.gms.p146b.ji;
import com.google.android.gms.p146b.kq.C3339d;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.clearcut.b */
public final class C3383b {
    public static final C3388d<ix> f11796a;
    public static final C3327b<ix, C3387b> f11797b;
    public static final C3444a<C3387b> f11798c;
    public static final C3313c f11799d;
    private final Context f11800e;
    private final String f11801f;
    private final int f11802g;
    private String f11803h;
    private int f11804i;
    private String f11805j;
    private String f11806k;
    private final boolean f11807l;
    private int f11808m;
    private final C3313c f11809n;
    private final jg f11810o;
    private final C3378a f11811p;
    private C3382c f11812q;

    /* renamed from: com.google.android.gms.clearcut.b.1 */
    static class C33791 extends C3327b<ix, C3387b> {
        C33791() {
        }

        public ix m13920a(Context context, Looper looper, C3477g c3477g, C3387b c3387b, C2921b c2921b, C2922c c2922c) {
            return new ix(context, looper, c3477g, c2921b, c2922c);
        }

        public /* synthetic */ C2924c m13921a(Context context, Looper looper, C3477g c3477g, Object obj, C2921b c2921b, C2922c c2922c) {
            return m13920a(context, looper, c3477g, (C3387b) obj, c2921b, c2922c);
        }
    }

    /* renamed from: com.google.android.gms.clearcut.b.a */
    public class C3380a {
        final /* synthetic */ C3383b f11785a;
        private int f11786b;
        private String f11787c;
        private String f11788d;
        private String f11789e;
        private int f11790f;
        private final C3381b f11791g;
        private C3381b f11792h;
        private ArrayList<Integer> f11793i;
        private final C3339d f11794j;
        private boolean f11795k;

        private C3380a(C3383b c3383b, byte[] bArr) {
            this(c3383b, bArr, null);
        }

        private C3380a(C3383b c3383b, byte[] bArr, C3381b c3381b) {
            this.f11785a = c3383b;
            this.f11786b = this.f11785a.f11804i;
            this.f11787c = this.f11785a.f11803h;
            this.f11788d = this.f11785a.f11805j;
            this.f11789e = this.f11785a.f11806k;
            this.f11790f = this.f11785a.f11808m;
            this.f11793i = null;
            this.f11794j = new C3339d();
            this.f11795k = false;
            this.f11788d = c3383b.f11805j;
            this.f11789e = c3383b.f11806k;
            this.f11794j.f11648b = c3383b.f11810o.m13543a();
            this.f11794j.f11649c = c3383b.f11810o.m13544b();
            this.f11794j.f11667u = (long) c3383b.f11811p.m13919a(c3383b.f11800e);
            this.f11794j.f11662p = c3383b.f11812q.m13927a(this.f11794j.f11648b);
            if (bArr != null) {
                this.f11794j.f11657k = bArr;
            }
            this.f11791g = c3381b;
        }

        public LogEventParcelable m13922a() {
            return new LogEventParcelable(new PlayLoggerContext(this.f11785a.f11801f, this.f11785a.f11802g, this.f11786b, this.f11787c, this.f11788d, this.f11789e, this.f11785a.f11807l, this.f11790f), this.f11794j, this.f11791g, this.f11792h, C3383b.m13932b(this.f11793i));
        }

        public C3380a m13923a(int i) {
            this.f11794j.f11652f = i;
            return this;
        }

        public C3304d<Status> m13924a(C3427c c3427c) {
            if (this.f11795k) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f11795k = true;
            return this.f11785a.f11809n.m13480a(c3427c, m13922a());
        }

        public C3380a m13925b(int i) {
            this.f11794j.f11653g = i;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.clearcut.b.b */
    public interface C3381b {
        byte[] m13926a();
    }

    /* renamed from: com.google.android.gms.clearcut.b.c */
    public static class C3382c {
        public long m13927a(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / AdError.NETWORK_ERROR_CODE);
        }
    }

    static {
        f11796a = new C3388d();
        f11797b = new C33791();
        f11798c = new C3444a("ClearcutLogger.API", f11797b, f11796a);
        f11799d = new iw();
    }

    public C3383b(Context context, int i, String str, String str2, String str3, boolean z, C3313c c3313c, jg jgVar, C3382c c3382c, C3378a c3378a) {
        this.f11804i = -1;
        this.f11808m = 0;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.f11800e = applicationContext;
        this.f11801f = context.getPackageName();
        this.f11802g = m13928a(context);
        this.f11804i = i;
        this.f11803h = str;
        this.f11805j = str2;
        this.f11806k = str3;
        this.f11807l = z;
        this.f11809n = c3313c;
        this.f11810o = jgVar;
        if (c3382c == null) {
            c3382c = new C3382c();
        }
        this.f11812q = c3382c;
        this.f11811p = c3378a;
        this.f11808m = 0;
        if (this.f11807l) {
            C3512u.m14589b(this.f11805j == null, "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public C3383b(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, f11799d, ji.m13553d(), null, C3378a.f11783a);
    }

    private int m13928a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] m13932b(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    public C3380a m13944a(byte[] bArr) {
        return new C3380a(bArr, null);
    }

    public boolean m13945a(C3427c c3427c, long j, TimeUnit timeUnit) {
        return this.f11809n.m13481a(c3427c, j, timeUnit);
    }
}
