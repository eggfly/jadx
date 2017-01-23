package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.C3628R;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class RotateLoadingLayout extends LoadingLayout {
    static final int ROTATION_ANIMATION_DURATION = 1200;
    private final Matrix mHeaderImageMatrix;
    private final Animation mRotateAnimation;
    private final boolean mRotateDrawableWhilePulling;
    private float mRotationPivotX;
    private float mRotationPivotY;

    public RotateLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.mRotateDrawableWhilePulling = typedArray.getBoolean(C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ScaleType.MATRIX);
        this.mHeaderImageMatrix = new Matrix();
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        this.mRotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(1200);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
    }

    private void resetImageRotation() {
        if (this.mHeaderImageMatrix != null) {
            this.mHeaderImageMatrix.reset();
            this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        }
    }

    protected int getDefaultDrawableResId() {
        return C3628R.drawable.default_ptr_rotate;
    }

    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.mRotationPivotX = (float) Math.round(((float) drawable.getIntrinsicWidth()) / 2.0f);
            this.mRotationPivotY = (float) Math.round(((float) drawable.getIntrinsicHeight()) / 2.0f);
        }
    }

    protected void onPullImpl(float f) {
        this.mHeaderImageMatrix.setRotate(this.mRotateDrawableWhilePulling ? 90.0f * f : Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f)), this.mRotationPivotX, this.mRotationPivotY);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    protected void pullToRefreshImpl() {
    }

    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    protected void releaseToRefreshImpl() {
    }

    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        resetImageRotation();
    }
}
