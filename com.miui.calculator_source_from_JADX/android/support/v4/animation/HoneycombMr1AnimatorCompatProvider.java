package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {

    static class AnimatorListenerCompatWrapper implements AnimatorListener {
        final AnimatorListenerCompat f30a;
        final ValueAnimatorCompat f31b;

        public void onAnimationStart(Animator animator) {
            this.f30a.m29a(this.f31b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f30a.m30b(this.f31b);
        }

        public void onAnimationCancel(Animator animator) {
            this.f30a.m31c(this.f31b);
        }

        public void onAnimationRepeat(Animator animator) {
            this.f30a.m32d(this.f31b);
        }
    }

    static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {

        /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.1 */
        class C00041 implements AnimatorUpdateListener {
            final /* synthetic */ AnimatorUpdateListenerCompat f32a;
            final /* synthetic */ HoneycombValueAnimatorCompat f33b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f32a.m33a(this.f33b);
            }
        }
    }

    HoneycombMr1AnimatorCompatProvider() {
    }
}
