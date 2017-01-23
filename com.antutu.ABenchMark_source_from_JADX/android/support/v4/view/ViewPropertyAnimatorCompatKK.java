package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompatKK {

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatKK.1 */
    static class C02951 implements AnimatorUpdateListener {
        final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
        final /* synthetic */ View val$view;

        C02951(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
            this.val$listener = viewPropertyAnimatorUpdateListener;
            this.val$view = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$listener.onAnimationUpdate(this.val$view);
        }
    }

    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (viewPropertyAnimatorUpdateListener != null) {
            animatorUpdateListener = new C02951(viewPropertyAnimatorUpdateListener, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
