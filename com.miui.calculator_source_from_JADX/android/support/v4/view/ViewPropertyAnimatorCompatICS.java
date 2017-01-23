package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewPropertyAnimatorCompatICS {

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatICS.1 */
    final class C00941 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimatorListener f911a;
        final /* synthetic */ View f912b;

        public void onAnimationCancel(Animator animator) {
            this.f911a.m1619c(this.f912b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f911a.m1618b(this.f912b);
        }

        public void onAnimationStart(Animator animator) {
            this.f911a.m1617a(this.f912b);
        }
    }

    ViewPropertyAnimatorCompatICS() {
    }
}
