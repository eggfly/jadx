package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c extends h {
    private static List<Runnable> DW;
    private boolean FH;
    private Set<a> Hw;
    private volatile boolean VH;
    private boolean Zo;
    private boolean v5;

    interface a {
        void DW(Activity activity);

        void j6(Activity activity);
    }

    @TargetApi(14)
    class b implements ActivityLifecycleCallbacks {
        final /* synthetic */ c j6;

        b(c cVar) {
            this.j6 = cVar;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.j6.DW(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.j6.Hw(activity);
        }
    }

    static {
        DW = new ArrayList();
    }

    public c(v vVar) {
        super(vVar);
        this.Hw = new HashSet();
    }

    public static void Hw() {
        synchronized (c.class) {
            if (DW != null) {
                for (Runnable run : DW) {
                    run.run();
                }
                DW = null;
            }
        }
    }

    private r QX() {
        return EQ().u7();
    }

    private q XL() {
        return EQ().we();
    }

    public static c j6(Context context) {
        return v.j6(context).EQ();
    }

    void DW() {
        q XL = XL();
        if (XL.Hw()) {
            VH().j6(XL.v5());
        }
        if (XL.gn()) {
            j6(XL.u7());
        }
        if (XL.Hw()) {
            e j6 = f.j6();
            if (j6 != null) {
                j6.j6(XL.v5());
            }
        }
    }

    void DW(Activity activity) {
        for (a j6 : this.Hw) {
            j6.j6(activity);
        }
    }

    void DW(a aVar) {
        this.Hw.remove(aVar);
    }

    public void DW(boolean z) {
        this.VH = z;
        if (this.VH) {
            QX().FH();
        }
    }

    public void FH(Activity activity) {
        if (!this.v5) {
            Hw(activity);
        }
    }

    public boolean FH() {
        return this.FH;
    }

    void Hw(Activity activity) {
        for (a DW : this.Hw) {
            DW.DW(activity);
        }
    }

    @Deprecated
    public e VH() {
        return f.j6();
    }

    public boolean Zo() {
        return this.VH;
    }

    public String gn() {
        com.google.android.gms.common.internal.b.FH("getClientId can not be called from the main thread");
        return EQ().QX().DW();
    }

    public g j6(int i) {
        g gVar;
        synchronized (this) {
            gVar = new g(EQ(), null, null);
            if (i > 0) {
                o oVar = (o) new n(EQ()).j6(i);
                if (oVar != null) {
                    gVar.j6(oVar);
                }
            }
            gVar.ei();
        }
        return gVar;
    }

    public void j6() {
        DW();
        this.FH = true;
    }

    public void j6(Activity activity) {
        if (!this.v5) {
            DW(activity);
        }
    }

    @TargetApi(14)
    public void j6(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.v5) {
            application.registerActivityLifecycleCallbacks(new b(this));
            this.v5 = true;
        }
    }

    void j6(a aVar) {
        this.Hw.add(aVar);
        Context DW = EQ().DW();
        if (DW instanceof Application) {
            j6((Application) DW);
        }
    }

    public void j6(boolean z) {
        this.Zo = z;
    }

    void tp() {
        QX().v5();
    }

    public void u7() {
        QX().Hw();
    }

    public boolean v5() {
        return this.Zo;
    }
}
