package com.github.amlcurran.showcaseview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.github.amlcurran.showcaseview.AnimationFactory.AnimationEndListener;
import com.github.amlcurran.showcaseview.AnimationFactory.AnimationStartListener;

class AnimatorAnimationFactory implements AnimationFactory {
    private static final String ALPHA = "alpha";
    private static final float INVISIBLE = 0.0f;
    private static final float VISIBLE = 1.0f;
    private final AccelerateDecelerateInterpolator interpolator;

    /* renamed from: com.github.amlcurran.showcaseview.AnimatorAnimationFactory.1 */
    class C01561 implements AnimatorListener {
        final /* synthetic */ AnimationStartListener val$listener;

        C01561(AnimationStartListener animationStartListener) {
            this.val$listener = animationStartListener;
        }

        public void onAnimationStart(Animator animator) {
            this.val$listener.onAnimationStart();
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.github.amlcurran.showcaseview.AnimatorAnimationFactory.2 */
    class C01572 implements AnimatorListener {
        final /* synthetic */ AnimationEndListener val$listener;

        C01572(AnimationEndListener animationEndListener) {
            this.val$listener = animationEndListener;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.val$listener.onAnimationEnd();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public AnimatorAnimationFactory() {
        this.interpolator = new AccelerateDecelerateInterpolator();
    }

    public void fadeInView(View target, long duration, AnimationStartListener listener) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(target, ALPHA, new float[]{INVISIBLE, VISIBLE});
        oa.setDuration(duration).addListener(new C01561(listener));
        oa.start();
    }

    public void fadeOutView(View target, long duration, AnimationEndListener listener) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(target, ALPHA, new float[]{INVISIBLE});
        oa.setDuration(duration).addListener(new C01572(listener));
        oa.start();
    }

    public void animateTargetToPoint(ShowcaseView showcaseView, Point point) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator xAnimator = ObjectAnimator.ofInt(showcaseView, "showcaseX", new int[]{point.x});
        ObjectAnimator yAnimator = ObjectAnimator.ofInt(showcaseView, "showcaseY", new int[]{point.y});
        set.playTogether(new Animator[]{xAnimator, yAnimator});
        set.setInterpolator(this.interpolator);
        set.start();
    }
}
