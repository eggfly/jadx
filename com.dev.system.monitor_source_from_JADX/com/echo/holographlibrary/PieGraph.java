package com.echo.holographlibrary;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import it.gmariotti.cardslib.library.internal.Card;
import java.util.ArrayList;
import java.util.Iterator;

public class PieGraph extends View implements HoloGraphAnimate {
    private AnimatorListener mAnimationListener;
    private Bitmap mBackgroundImage;
    private Point mBackgroundImageAnchor;
    private boolean mBackgroundImageCenter;
    private boolean mDrawCompleted;
    private int mDuration;
    private int mInnerCircleRatio;
    private Interpolator mInterpolator;
    private OnSliceClickedListener mListener;
    private int mPadding;
    private Paint mPaint;
    private RectF mRectF;
    private int mSelectedIndex;
    private ArrayList<PieSlice> mSlices;
    private ValueAnimator mValueAnimator;

    /* renamed from: com.echo.holographlibrary.PieGraph.1 */
    class C01461 implements AnimatorUpdateListener {
        C01461() {
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            float f = Math.max(animation.getAnimatedFraction(), 0.01f);
            Iterator it = PieGraph.this.mSlices.iterator();
            while (it.hasNext()) {
                PieSlice s = (PieSlice) it.next();
                s.setValue(s.getOldValue() + ((s.getGoalValue() - s.getOldValue()) * f));
            }
            PieGraph.this.postInvalidate();
        }
    }

    public interface OnSliceClickedListener {
        void onClick(int i);
    }

    public PieGraph(Context context) {
        this(context, null);
    }

    public PieGraph(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieGraph(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        this.mSlices = new ArrayList();
        this.mPaint = new Paint();
        this.mSelectedIndex = -1;
        this.mDrawCompleted = false;
        this.mRectF = new RectF();
        this.mBackgroundImage = null;
        this.mBackgroundImageAnchor = new Point(0, 0);
        this.mBackgroundImageCenter = false;
        this.mDuration = 300;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C0147R.styleable.PieGraph, 0, 0);
        this.mInnerCircleRatio = a.getInt(C0147R.styleable.PieGraph_pieInnerCircleRatio, 0);
        this.mPadding = a.getDimensionPixelSize(C0147R.styleable.PieGraph_pieSlicePadding, 0);
    }

    public void onDraw(Canvas canvas) {
        float radius;
        canvas.drawColor(0);
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        if (this.mBackgroundImage != null) {
            if (this.mBackgroundImageCenter) {
                this.mBackgroundImageAnchor.set((getWidth() / 2) - (this.mBackgroundImage.getWidth() / 2), (getHeight() / 2) - (this.mBackgroundImage.getHeight() / 2));
            }
            canvas.drawBitmap(this.mBackgroundImage, (float) this.mBackgroundImageAnchor.x, (float) this.mBackgroundImageAnchor.y, this.mPaint);
        }
        float currentAngle = 270.0f;
        float totalValue = 0.0f;
        float midX = (float) (getWidth() / 2);
        float midY = (float) (getHeight() / 2);
        if (midX < midY) {
            radius = midX;
        } else {
            radius = midY;
        }
        radius -= (float) this.mPadding;
        float innerRadius = (((float) this.mInnerCircleRatio) * radius) / 255.0f;
        Iterator it = this.mSlices.iterator();
        while (it.hasNext()) {
            totalValue += ((PieSlice) it.next()).getValue();
        }
        int count = 0;
        it = this.mSlices.iterator();
        while (it.hasNext()) {
            PieSlice slice = (PieSlice) it.next();
            Path p = slice.getPath();
            p.reset();
            if (this.mSelectedIndex != count || this.mListener == null) {
                this.mPaint.setColor(slice.getColor());
            } else {
                this.mPaint.setColor(slice.getSelectedColor());
            }
            float currentSweep = (slice.getValue() / totalValue) * 360.0f;
            this.mRectF.set(midX - radius, midY - radius, midX + radius, midY + radius);
            p.arcTo(this.mRectF, ((float) this.mPadding) + currentAngle, currentSweep - ((float) this.mPadding));
            this.mRectF.set(midX - innerRadius, midY - innerRadius, midX + innerRadius, midY + innerRadius);
            p.arcTo(this.mRectF, (((float) this.mPadding) + currentAngle) + (currentSweep - ((float) this.mPadding)), -(currentSweep - ((float) this.mPadding)));
            p.close();
            slice.getRegion().set((int) (midX - radius), (int) (midY - radius), (int) (midX + radius), (int) (midY + radius));
            canvas.drawPath(p, this.mPaint);
            currentAngle += currentSweep;
            count++;
        }
        this.mDrawCompleted = true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDrawCompleted) {
            Point point = new Point();
            point.x = (int) event.getX();
            point.y = (int) event.getY();
            int count = 0;
            Region r = new Region();
            Iterator it = this.mSlices.iterator();
            while (it.hasNext()) {
                PieSlice slice = (PieSlice) it.next();
                r.setPath(slice.getPath(), slice.getRegion());
                switch (event.getAction()) {
                    case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                        if (!r.contains(point.x, point.y)) {
                            break;
                        }
                        this.mSelectedIndex = count;
                        postInvalidate();
                        break;
                    case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                        if (count == this.mSelectedIndex && this.mListener != null && r.contains(point.x, point.y)) {
                            this.mListener.onClick(this.mSelectedIndex);
                            break;
                        }
                    default:
                        break;
                }
                count++;
            }
        }
        if (1 == event.getAction() && this.mSelectedIndex == -1 && this.mListener != null) {
            this.mListener.onClick(this.mSelectedIndex);
        }
        if (1 == event.getAction() || 3 == event.getAction()) {
            this.mSelectedIndex = -1;
            postInvalidate();
        }
        return true;
    }

    public Bitmap getBackgroundBitmap() {
        return this.mBackgroundImage;
    }

    public void setBackgroundBitmap(Bitmap backgroundBitmap, int pos_x, int pos_y) {
        this.mBackgroundImage = backgroundBitmap;
        this.mBackgroundImageAnchor.set(pos_x, pos_y);
        postInvalidate();
    }

    public void setBackgroundBitmap(Bitmap backgroundBitmap) {
        this.mBackgroundImageCenter = true;
        this.mBackgroundImage = backgroundBitmap;
        postInvalidate();
    }

    public void setPadding(int padding) {
        this.mPadding = padding;
        postInvalidate();
    }

    public void setInnerCircleRatio(int innerCircleRatio) {
        this.mInnerCircleRatio = innerCircleRatio;
        postInvalidate();
    }

    public ArrayList<PieSlice> getSlices() {
        return this.mSlices;
    }

    public void setSlices(ArrayList<PieSlice> slices) {
        this.mSlices = slices;
        postInvalidate();
    }

    public PieSlice getSlice(int index) {
        return (PieSlice) this.mSlices.get(index);
    }

    public void addSlice(PieSlice slice) {
        this.mSlices.add(slice);
        postInvalidate();
    }

    public void setOnSliceClickedListener(OnSliceClickedListener listener) {
        this.mListener = listener;
    }

    public void removeSlices() {
        this.mSlices.clear();
        postInvalidate();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    @TargetApi(12)
    public boolean isAnimating() {
        if (this.mValueAnimator != null) {
            return this.mValueAnimator.isRunning();
        }
        return false;
    }

    @TargetApi(12)
    public boolean cancelAnimating() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
        return false;
    }

    @TargetApi(12)
    public void animateToGoalValues() {
        if (VERSION.SDK_INT < 12) {
            Log.e("HoloGraphLibrary compatibility error", "Animation not supported on api level 12 and below. Returning without animating.");
            return;
        }
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
        Iterator it = this.mSlices.iterator();
        while (it.hasNext()) {
            PieSlice s = (PieSlice) it.next();
            s.setOldValue(s.getValue());
        }
        ValueAnimator va = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mValueAnimator = va;
        va.setDuration((long) getDuration());
        if (this.mInterpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
        va.setInterpolator(this.mInterpolator);
        if (this.mAnimationListener != null) {
            va.addListener(this.mAnimationListener);
        }
        va.addUpdateListener(new C01461());
        va.start();
    }

    public void setAnimationListener(AnimatorListener animationListener) {
        this.mAnimationListener = animationListener;
    }
}
