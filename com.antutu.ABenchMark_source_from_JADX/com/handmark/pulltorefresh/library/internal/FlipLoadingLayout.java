package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.C3628R;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import org.android.spdy.SpdyProtocol;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout extends LoadingLayout {
    static final int FLIP_ANIMATION_DURATION = 150;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* renamed from: com.handmark.pulltorefresh.library.internal.FlipLoadingLayout.1 */
    static /* synthetic */ class C36291 {
        static final /* synthetic */ int[] f12292x9a7fbd92;

        static {
            f12292x9a7fbd92 = new int[Mode.values().length];
            try {
                f12292x9a7fbd92[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12292x9a7fbd92[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public FlipLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == Mode.PULL_FROM_START ? -180 : 180;
        this.mRotateAnimation = new RotateAnimation(0.0f, (float) i, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(150);
        this.mRotateAnimation.setFillAfter(true);
        this.mResetRotateAnimation = new RotateAnimation((float) i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mResetRotateAnimation.setDuration(150);
        this.mResetRotateAnimation.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        switch (C36291.f12292x9a7fbd92[this.mMode.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return this.mScrollDirection == Orientation.HORIZONTAL ? 90.0f : 180.0f;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return this.mScrollDirection == Orientation.HORIZONTAL ? 270.0f : 0.0f;
            default:
                return 0.0f;
        }
    }

    protected int getDefaultDrawableResId() {
        return C3628R.drawable.default_ptr_flip;
    }

    protected void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(((float) (layoutParams.width - intrinsicWidth)) / 2.0f, ((float) (layoutParams.height - intrinsicHeight)) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), ((float) layoutParams.width) / 2.0f, ((float) layoutParams.height) / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    protected void onPullImpl(float f) {
    }

    protected void pullToRefreshImpl() {
        if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
        }
    }

    protected void refreshingImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(4);
        this.mHeaderProgress.setVisibility(0);
    }

    protected void releaseToRefreshImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
    }
}
