package com.aide.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

public class l {
    private Activity DW;
    private int FH;
    private boolean j6;

    class 1 implements AnimationListener {
        final /* synthetic */ l DW;
        final /* synthetic */ View j6;

        1(l lVar, View view) {
            this.DW = lVar;
            this.j6 = view;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.j6.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public l(Activity activity, int i) {
        this.j6 = false;
        this.DW = activity;
        this.FH = i;
        j6().setVisibility(8);
    }

    public void j6(boolean z) {
        View j6 = j6();
        if (z != this.j6) {
            this.j6 = z;
            Animation translateAnimation;
            if (this.j6) {
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.DW.getResources().getDisplayMetrics().density * 60.0f, 0.0f);
                translateAnimation.setDuration(300);
                j6.startAnimation(translateAnimation);
                j6.setVisibility(0);
                return;
            }
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.DW.getResources().getDisplayMetrics().density * 60.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setAnimationListener(new 1(this, j6));
            j6.startAnimation(translateAnimation);
        }
    }

    private View j6() {
        return this.DW.findViewById(this.FH);
    }

    public void j6(OnClickListener onClickListener) {
        j6().setOnClickListener(onClickListener);
    }
}
