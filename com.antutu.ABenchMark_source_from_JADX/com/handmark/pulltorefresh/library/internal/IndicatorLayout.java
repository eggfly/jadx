package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.C3628R;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import org.android.spdy.SpdyProtocol;

@SuppressLint({"ViewConstructor"})
public class IndicatorLayout extends FrameLayout implements AnimationListener {
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private ImageView mArrowImageView;
    private Animation mInAnim;
    private Animation mOutAnim;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* renamed from: com.handmark.pulltorefresh.library.internal.IndicatorLayout.1 */
    static /* synthetic */ class C36301 {
        static final /* synthetic */ int[] f12293x9a7fbd92;

        static {
            f12293x9a7fbd92 = new int[Mode.values().length];
            try {
                f12293x9a7fbd92[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12293x9a7fbd92[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public IndicatorLayout(Context context, Mode mode) {
        int i;
        super(context);
        this.mArrowImageView = new ImageView(context);
        Drawable drawable = getResources().getDrawable(C3628R.drawable.indicator_arrow);
        this.mArrowImageView.setImageDrawable(drawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C3628R.dimen.indicator_internal_padding);
        this.mArrowImageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.mArrowImageView);
        switch (C36301.f12293x9a7fbd92[mode.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                i = C3628R.anim.slide_in_from_bottom;
                dimensionPixelSize = C3628R.anim.slide_out_to_bottom;
                setBackgroundResource(C3628R.drawable.indicator_bg_bottom);
                this.mArrowImageView.setScaleType(ScaleType.MATRIX);
                Matrix matrix = new Matrix();
                matrix.setRotate(180.0f, ((float) drawable.getIntrinsicWidth()) / 2.0f, ((float) drawable.getIntrinsicHeight()) / 2.0f);
                this.mArrowImageView.setImageMatrix(matrix);
                break;
            default:
                i = C3628R.anim.slide_in_from_top;
                dimensionPixelSize = C3628R.anim.slide_out_to_top;
                setBackgroundResource(C3628R.drawable.indicator_bg_top);
                break;
        }
        this.mInAnim = AnimationUtils.loadAnimation(context, i);
        this.mInAnim.setAnimationListener(this);
        this.mOutAnim = AnimationUtils.loadAnimation(context, dimensionPixelSize);
        this.mOutAnim.setAnimationListener(this);
        Interpolator linearInterpolator = new LinearInterpolator();
        this.mRotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(linearInterpolator);
        this.mRotateAnimation.setDuration(150);
        this.mRotateAnimation.setFillAfter(true);
        this.mResetRotateAnimation = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation.setInterpolator(linearInterpolator);
        this.mResetRotateAnimation.setDuration(150);
        this.mResetRotateAnimation.setFillAfter(true);
    }

    public void hide() {
        startAnimation(this.mOutAnim);
    }

    public final boolean isVisible() {
        Animation animation = getAnimation();
        return animation != null ? this.mInAnim == animation : getVisibility() == 0;
    }

    public void onAnimationEnd(Animation animation) {
        if (animation == this.mOutAnim) {
            this.mArrowImageView.clearAnimation();
            setVisibility(8);
        } else if (animation == this.mInAnim) {
            setVisibility(0);
        }
        clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        setVisibility(0);
    }

    public void pullToRefresh() {
        this.mArrowImageView.startAnimation(this.mResetRotateAnimation);
    }

    public void releaseToRefresh() {
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
    }

    public void show() {
        this.mArrowImageView.clearAnimation();
        startAnimation(this.mInAnim);
    }
}
