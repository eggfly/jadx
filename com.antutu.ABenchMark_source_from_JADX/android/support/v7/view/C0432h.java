package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.view.h */
public class C0432h {
    private final ArrayList<ViewPropertyAnimatorCompat> f1117a;
    private long f1118b;
    private Interpolator f1119c;
    private ViewPropertyAnimatorListener f1120d;
    private boolean f1121e;
    private final ViewPropertyAnimatorListenerAdapter f1122f;

    /* renamed from: android.support.v7.view.h.1 */
    class C04311 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ C0432h f1114a;
        private boolean f1115b;
        private int f1116c;

        C04311(C0432h c0432h) {
            this.f1114a = c0432h;
            this.f1115b = false;
            this.f1116c = 0;
        }

        void m1283a() {
            this.f1116c = 0;
            this.f1115b = false;
            this.f1114a.m1287c();
        }

        public void onAnimationEnd(View view) {
            int i = this.f1116c + 1;
            this.f1116c = i;
            if (i == this.f1114a.f1117a.size()) {
                if (this.f1114a.f1120d != null) {
                    this.f1114a.f1120d.onAnimationEnd(null);
                }
                m1283a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.f1115b) {
                this.f1115b = true;
                if (this.f1114a.f1120d != null) {
                    this.f1114a.f1120d.onAnimationStart(null);
                }
            }
        }
    }

    public C0432h() {
        this.f1118b = -1;
        this.f1122f = new C04311(this);
        this.f1117a = new ArrayList();
    }

    private void m1287c() {
        this.f1121e = false;
    }

    public C0432h m1288a(long j) {
        if (!this.f1121e) {
            this.f1118b = j;
        }
        return this;
    }

    public C0432h m1289a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f1121e) {
            this.f1117a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public C0432h m1290a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f1117a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f1117a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public C0432h m1291a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f1121e) {
            this.f1120d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public C0432h m1292a(Interpolator interpolator) {
        if (!this.f1121e) {
            this.f1119c = interpolator;
        }
        return this;
    }

    public void m1293a() {
        if (!this.f1121e) {
            Iterator it = this.f1117a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
                if (this.f1118b >= 0) {
                    viewPropertyAnimatorCompat.setDuration(this.f1118b);
                }
                if (this.f1119c != null) {
                    viewPropertyAnimatorCompat.setInterpolator(this.f1119c);
                }
                if (this.f1120d != null) {
                    viewPropertyAnimatorCompat.setListener(this.f1122f);
                }
                viewPropertyAnimatorCompat.start();
            }
            this.f1121e = true;
        }
    }

    public void m1294b() {
        if (this.f1121e) {
            Iterator it = this.f1117a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).cancel();
            }
            this.f1121e = false;
        }
    }
}
