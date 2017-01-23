package com.antutu.utils.library;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.animation.LinearInterpolator;
import com.antutu.utils.library.TitanicTextView.AnimationSetupCallback;

public class Titanic {
    private AnimatorListener animatorListener;
    private AnimatorSet animatorSet;

    /* renamed from: com.antutu.utils.library.Titanic.1 */
    class C18231 implements Runnable {
        final /* synthetic */ TitanicTextView val$textView;

        /* renamed from: com.antutu.utils.library.Titanic.1.1 */
        class C18221 implements AnimatorListener {
            C18221() {
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                C18231.this.val$textView.setSinking(false);
                if (VERSION.SDK_INT < 16) {
                    C18231.this.val$textView.postInvalidate();
                } else {
                    C18231.this.val$textView.postInvalidateOnAnimation();
                }
                Titanic.this.animatorSet = null;
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        }

        C18231(TitanicTextView titanicTextView) {
            this.val$textView = titanicTextView;
        }

        public void run() {
            this.val$textView.setSinking(true);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.val$textView, "maskX", new float[]{0.0f, 200.0f});
            ofFloat.setRepeatCount(-1);
            ofFloat.setDuration(1000);
            ofFloat.setStartDelay(0);
            int height = this.val$textView.getHeight();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.val$textView, "maskY", new float[]{(float) (height / 2), (float) ((-height) / 2)});
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(2);
            ofFloat2.setDuration(10000);
            ofFloat2.setStartDelay(0);
            Titanic.this.animatorSet = new AnimatorSet();
            Titanic.this.animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            Titanic.this.animatorSet.setInterpolator(new LinearInterpolator());
            Titanic.this.animatorSet.addListener(new C18221());
            if (Titanic.this.animatorListener != null) {
                Titanic.this.animatorSet.addListener(Titanic.this.animatorListener);
            }
            Titanic.this.animatorSet.start();
        }
    }

    /* renamed from: com.antutu.utils.library.Titanic.2 */
    class C18242 implements AnimationSetupCallback {
        final /* synthetic */ Runnable val$animate;

        C18242(Runnable runnable) {
            this.val$animate = runnable;
        }

        public void onSetupAnimation(TitanicTextView titanicTextView) {
            this.val$animate.run();
        }
    }

    public void cancel() {
        if (this.animatorSet != null) {
            this.animatorSet.cancel();
        }
    }

    public AnimatorListener getAnimatorListener() {
        return this.animatorListener;
    }

    public void setAnimatorListener(AnimatorListener animatorListener) {
        this.animatorListener = animatorListener;
    }

    public void start(TitanicTextView titanicTextView) {
        Runnable c18231 = new C18231(titanicTextView);
        if (titanicTextView.isSetUp()) {
            c18231.run();
        } else {
            titanicTextView.setAnimationSetupCallback(new C18242(c18231));
        }
    }
}
