package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class DonutAnimatorCompatProvider implements AnimatorProvider {

    private static class DonutFloatValueAnimator implements ValueAnimatorCompat {
        List<AnimatorListenerCompat> f21a;
        List<AnimatorUpdateListenerCompat> f22b;
        View f23c;
        private long f24d;
        private long f25e;
        private float f26f;
        private boolean f27g;
        private boolean f28h;
        private Runnable f29i;

        /* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider.DonutFloatValueAnimator.1 */
        class C00031 implements Runnable {
            final /* synthetic */ DonutFloatValueAnimator f20a;

            C00031(DonutFloatValueAnimator donutFloatValueAnimator) {
                this.f20a = donutFloatValueAnimator;
            }

            public void run() {
                float a = (((float) (this.f20a.m37b() - this.f20a.f24d)) * 1.0f) / ((float) this.f20a.f25e);
                if (a > 1.0f || this.f20a.f23c.getParent() == null) {
                    a = 1.0f;
                }
                this.f20a.f26f = a;
                this.f20a.m36a();
                if (this.f20a.f26f >= 1.0f) {
                    this.f20a.m40c();
                } else {
                    this.f20a.f23c.postDelayed(this.f20a.f29i, 16);
                }
            }
        }

        public DonutFloatValueAnimator() {
            this.f21a = new ArrayList();
            this.f22b = new ArrayList();
            this.f25e = 200;
            this.f26f = 0.0f;
            this.f27g = false;
            this.f28h = false;
            this.f29i = new C00031(this);
        }

        private void m36a() {
            for (int size = this.f22b.size() - 1; size >= 0; size--) {
                ((AnimatorUpdateListenerCompat) this.f22b.get(size)).m33a(this);
            }
        }

        private long m37b() {
            return this.f23c.getDrawingTime();
        }

        private void m40c() {
            for (int size = this.f21a.size() - 1; size >= 0; size--) {
                ((AnimatorListenerCompat) this.f21a.get(size)).m30b(this);
            }
        }
    }

    DonutAnimatorCompatProvider() {
    }
}
