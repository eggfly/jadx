package com.echo.holographlibrary;

import android.animation.Animator.AnimatorListener;
import android.view.animation.Interpolator;

public interface HoloGraphAnimate {
    public static final int ANIMATE_DELETE = 2;
    public static final int ANIMATE_INSERT = 1;
    public static final int ANIMATE_NORMAL = 0;

    void animateToGoalValues();

    boolean cancelAnimating();

    int getDuration();

    Interpolator getInterpolator();

    boolean isAnimating();

    void setAnimationListener(AnimatorListener animatorListener);

    void setDuration(int i);

    void setInterpolator(Interpolator interpolator);
}
