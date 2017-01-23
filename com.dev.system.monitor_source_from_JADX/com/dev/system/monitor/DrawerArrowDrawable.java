package com.dev.system.monitor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class DrawerArrowDrawable extends Drawable {
    private static final float ARROW_HEAD_ANGLE;
    protected Context context;
    protected float mBarGap;
    protected float mBarSize;
    protected float mBarThickness;
    protected float mMiddleArrowSize;
    protected final Paint mPaint;
    protected final Path mPath;
    protected float mProgress;
    protected int mSize;
    protected float mTopBottomArrowSize;
    protected float mVerticalMirror;

    public abstract boolean isLayoutRtl();

    static {
        ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    }

    public DrawerArrowDrawable(Context context) {
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mVerticalMirror = 1.0f;
        this.context = context;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(context.getResources().getColor(C0133R.color.ldrawer_color));
        this.mSize = context.getResources().getDimensionPixelSize(C0133R.dimen.ldrawer_drawableSize);
        this.mBarSize = (float) context.getResources().getDimensionPixelSize(C0133R.dimen.ldrawer_barSize);
        this.mTopBottomArrowSize = (float) context.getResources().getDimensionPixelSize(C0133R.dimen.ldrawer_topBottomBarArrowSize);
        this.mBarThickness = (float) context.getResources().getDimensionPixelSize(C0133R.dimen.ldrawer_thickness);
        this.mBarGap = (float) context.getResources().getDimensionPixelSize(C0133R.dimen.ldrawer_gapBetweenBars);
        this.mMiddleArrowSize = (float) context.getResources().getDimensionPixelSize(C0133R.dimen.ldrawer_middleBarArrowSize);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeJoin(Join.ROUND);
        this.mPaint.setStrokeCap(Cap.SQUARE);
        this.mPaint.setStrokeWidth(this.mBarThickness);
    }

    protected float lerp(float paramFloat1, float paramFloat2, float paramFloat3) {
        return ((paramFloat2 - paramFloat1) * paramFloat3) + paramFloat1;
    }

    public void draw(Canvas canvas) {
        Rect localRect = getBounds();
        float f1 = lerp(this.mBarSize, this.mTopBottomArrowSize, this.mProgress);
        float f2 = lerp(this.mBarSize, this.mMiddleArrowSize, this.mProgress);
        float f3 = lerp(0.0f, this.mBarThickness / 2.0f, this.mProgress);
        float f4 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        float f7 = lerp(0.0f, 180.0f, this.mProgress);
        float f8 = lerp(this.mBarGap + this.mBarThickness, 0.0f, this.mProgress);
        this.mPath.rewind();
        float f9 = (-f2) / 2.0f;
        this.mPath.moveTo(f9 + f3, 0.0f);
        this.mPath.rLineTo(f2 - f3, 0.0f);
        float f10 = (float) Math.round(((double) f1) * Math.cos((double) f4));
        float f11 = (float) Math.round(((double) f1) * Math.sin((double) f4));
        this.mPath.moveTo(f9, f8);
        this.mPath.rLineTo(f10, f11);
        this.mPath.moveTo(f9, -f8);
        this.mPath.rLineTo(f10, -f11);
        this.mPath.moveTo(0.0f, 0.0f);
        this.mPath.close();
        canvas.save();
        if (!isLayoutRtl()) {
            canvas.rotate(180.0f, (float) localRect.centerX(), (float) localRect.centerY());
        }
        canvas.rotate(this.mVerticalMirror * f7, (float) localRect.centerX(), (float) localRect.centerY());
        canvas.translate((float) localRect.centerX(), (float) localRect.centerY());
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    public int getOpacity() {
        return -3;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setVerticalMirror(boolean mVerticalMirror) {
        this.mVerticalMirror = mVerticalMirror ? 1.0f : -1.0f;
    }

    public void setProgress(float paramFloat) {
        this.mProgress = paramFloat;
        invalidateSelf();
    }

    public void setColor(int resourceId) {
        this.mPaint.setColor(this.context.getResources().getColor(resourceId));
    }
}
