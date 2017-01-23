package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewPropertyAnimatorCompatJB {

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatJB.1 */
    final class C00951 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimatorListener f913a;
        final /* synthetic */ View f914b;

        public void onAnimationCancel(Animator animator) {
            this.f913a.m1619c(this.f914b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f913a.m1618b(this.f914b);
        }

        public void onAnimationStart(Animator animator) {
            this.f913a.m1617a(this.f914b);
        }
    }

    ViewPropertyAnimatorCompatJB() {
    }
}
