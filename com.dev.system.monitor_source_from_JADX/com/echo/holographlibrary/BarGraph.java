package com.echo.holographlibrary;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class BarGraph extends View implements HoloGraphAnimate {
    private static final int AXIS_LABEL_FONT_SIZE = 15;
    private static final float LABEL_PADDING_MULTIPLIER = 1.6f;
    private static final int ORIENTATION_HORIZONTAL = 0;
    private static final int ORIENTATION_VERTICAL = 1;
    private static final int VALUE_FONT_SIZE = 30;
    private AnimatorListener mAnimationListener;
    private int mAxisColor;
    private ArrayList<Bar> mBars;
    private Rect mBoundsRect;
    private int mDuration;
    private float mGoalMaxValue;
    private Interpolator mInterpolator;
    private long mLastTimeValueStringsUpdated;
    private OnBarClickedListener mListener;
    private float mMaxValue;
    private float mOldMaxValue;
    private final int mOrientation;
    private Paint mPaint;
    private int mSelectedIndex;
    private boolean mShowAxis;
    private boolean mShowAxisLabel;
    private boolean mShowBarText;
    private boolean mShowPopup;
    private Rect mTextRect;
    private ValueAnimator mValueAnimator;
    private int mValueStringPrecision;
    private long mValueStringUpdateInterval;

    /* renamed from: com.echo.holographlibrary.BarGraph.1 */
    class C01451 implements AnimatorUpdateListener {
        C01451() {
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            float f = animation.getAnimatedFraction();
            Iterator it = BarGraph.this.mBars.iterator();
            while (it.hasNext()) {
                Bar b = (Bar) it.next();
                b.setValue(b.getOldValue() + ((b.getGoalValue() - b.getOldValue()) * f));
                BarGraph.this.mMaxValue = BarGraph.this.mOldMaxValue + ((BarGraph.this.mGoalMaxValue - BarGraph.this.mOldMaxValue) * f);
            }
            long now = System.currentTimeMillis();
            if (BarGraph.this.mLastTimeValueStringsUpdated + BarGraph.this.mValueStringUpdateInterval < now || f == 1.0f) {
                it = BarGraph.this.mBars.iterator();
                while (it.hasNext()) {
                    ((Bar) it.next()).makeValueString(BarGraph.this.mValueStringPrecision);
                }
                BarGraph.this.mLastTimeValueStringsUpdated = now;
            }
            BarGraph.this.postInvalidate();
        }
    }

    public interface OnBarClickedListener {
        void onClick(int i);
    }

    public BarGraph(Context context) {
        this(context, null);
    }

    public BarGraph(Context context, AttributeSet attrs) {
        this(context, attrs, ORIENTATION_HORIZONTAL);
    }

    public BarGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBars = new ArrayList();
        this.mPaint = new Paint();
        this.mBoundsRect = new Rect();
        this.mTextRect = new Rect();
        this.mSelectedIndex = -1;
        this.mDuration = 300;
        this.mValueStringUpdateInterval = 200;
        this.mValueStringPrecision = ORIENTATION_HORIZONTAL;
        TypedArray a = getContext().obtainStyledAttributes(attrs, C0147R.styleable.BarGraph);
        this.mOrientation = a.getInt(C0147R.styleable.BarGraph_orientation, ORIENTATION_VERTICAL);
        this.mAxisColor = a.getColor(C0147R.styleable.BarGraph_barAxisColor, -3355444);
        this.mShowAxis = a.getBoolean(C0147R.styleable.BarGraph_barShowAxis, true);
        this.mShowAxisLabel = a.getBoolean(C0147R.styleable.BarGraph_barShowAxisLabel, true);
        this.mShowBarText = a.getBoolean(C0147R.styleable.BarGraph_barShowText, true);
        this.mShowPopup = a.getBoolean(C0147R.styleable.BarGraph_barShowPopup, true);
    }

    public void setShowAxis(boolean show) {
        this.mShowAxis = show;
    }

    public void setShowAxisLabel(boolean show) {
        this.mShowAxisLabel = show;
    }

    public void setShowBarText(boolean show) {
        this.mShowBarText = show;
    }

    public void setShowPopup(boolean show) {
        this.mShowPopup = show;
    }

    public void setBars(ArrayList<Bar> points) {
        this.mBars = points;
        postInvalidate();
    }

    public ArrayList<Bar> getBars() {
        return this.mBars;
    }

    public void setAxisColor(int axisColor) {
        this.mAxisColor = axisColor;
    }

    public void onDraw(Canvas canvas) {
        float usableHeight;
        Resources resources = getContext().getResources();
        canvas.drawColor(ORIENTATION_HORIZONTAL);
        NinePatchDrawable popup = (NinePatchDrawable) resources.getDrawable(C0147R.drawable.popup_black);
        float maxValue = 0.0f;
        float padding = 7.0f * resources.getDisplayMetrics().density;
        float bottomPadding = 30.0f * resources.getDisplayMetrics().density;
        if (this.mShowBarText) {
            this.mPaint.setTextSize(30.0f * resources.getDisplayMetrics().scaledDensity);
            this.mPaint.getTextBounds("$", ORIENTATION_HORIZONTAL, ORIENTATION_VERTICAL, this.mTextRect);
            if (this.mShowPopup) {
                usableHeight = ((((float) getHeight()) - bottomPadding) - ((float) Math.abs(this.mTextRect.top - this.mTextRect.bottom))) - (24.0f * resources.getDisplayMetrics().density);
            } else {
                usableHeight = ((((float) getHeight()) - bottomPadding) - ((float) Math.abs(this.mTextRect.top - this.mTextRect.bottom))) - (18.0f * resources.getDisplayMetrics().density);
            }
        } else {
            usableHeight = ((float) getHeight()) - bottomPadding;
        }
        if (this.mShowAxis) {
            this.mPaint.setColor(this.mAxisColor);
            this.mPaint.setStrokeWidth(2.0f * resources.getDisplayMetrics().density);
            this.mPaint.setAntiAlias(true);
            Canvas canvas2 = canvas;
            canvas2.drawLine(0.0f, (((float) getHeight()) - bottomPadding) + (10.0f * resources.getDisplayMetrics().density), (float) getWidth(), (((float) getHeight()) - bottomPadding) + (10.0f * resources.getDisplayMetrics().density), this.mPaint);
        }
        int insertCount = ORIENTATION_HORIZONTAL;
        int deleteCount = ORIENTATION_HORIZONTAL;
        Iterator it = this.mBars.iterator();
        while (it.hasNext()) {
            Bar bar = (Bar) it.next();
            if (bar.mAnimateSpecial == ORIENTATION_VERTICAL) {
                insertCount += ORIENTATION_VERTICAL;
            }
            if (bar.mAnimateSpecial == 2) {
                deleteCount += ORIENTATION_VERTICAL;
            }
        }
        int specialCount = insertCount + deleteCount;
        float barWidthHelper = (((float) getWidth()) - ((2.0f * padding) * ((float) (this.mBars.size() - insertCount)))) / ((float) (this.mBars.size() - insertCount));
        float insertHelper = (((float) getWidth()) - ((2.0f * padding) * ((float) (this.mBars.size() - deleteCount)))) / ((float) (this.mBars.size() - deleteCount));
        float specialWidthTotal = 0.0f;
        int count = ORIENTATION_HORIZONTAL;
        float[] barWidths = new float[this.mBars.size()];
        it = this.mBars.iterator();
        while (it.hasNext()) {
            bar = (Bar) it.next();
            if (bar.mAnimateSpecial == ORIENTATION_VERTICAL) {
                barWidths[count] = (float) ((int) (getAnimatedFractionSafe() * insertHelper));
                specialWidthTotal += barWidths[count];
            } else if (bar.mAnimateSpecial == 2) {
                barWidths[count] = (float) ((int) ((1.0f - getAnimatedFractionSafe()) * barWidthHelper));
                specialWidthTotal += barWidths[count];
            }
            count += ORIENTATION_VERTICAL;
        }
        int normalCount = this.mBars.size() - specialCount;
        float barWidth = ((((float) getWidth()) - ((specialWidthTotal + (((float) deleteCount) * ((2.0f * padding) * (1.0f - getAnimationFraction())))) + (((float) insertCount) * ((2.0f * padding) * getAnimationFraction())))) - ((2.0f * padding) * ((float) normalCount))) / ((float) normalCount);
        float defaultBarWidth = barWidth;
        for (int i = ORIENTATION_HORIZONTAL; i < this.mBars.size(); i += ORIENTATION_VERTICAL) {
            if (((Bar) this.mBars.get(i)).mAnimateSpecial == 0) {
                barWidths[i] = defaultBarWidth;
            }
        }
        if (isAnimating()) {
            maxValue = this.mMaxValue;
        } else {
            it = this.mBars.iterator();
            while (it.hasNext()) {
                bar = (Bar) it.next();
                if (bar.getValue() > maxValue) {
                    maxValue = bar.getValue();
                }
            }
            if (maxValue == 0.0f) {
                maxValue = 1.0f;
            }
        }
        count = ORIENTATION_HORIZONTAL;
        this.mPaint.setTextSize(15.0f * resources.getDisplayMetrics().scaledDensity);
        it = this.mBars.iterator();
        while (it.hasNext()) {
            bar = (Bar) it.next();
            int left = (int) ((((2.0f * padding) * ((float) count)) + padding) + (((float) count) * barWidth));
            int right = (int) ((((2.0f * padding) * ((float) count)) + padding) + (((float) (count + ORIENTATION_VERTICAL)) * barWidth));
            int width = (int) ((2.0f * padding) + defaultBarWidth);
            float textWidth = this.mPaint.measureText(bar.getName());
            while (((float) (right - left)) + (LABEL_PADDING_MULTIPLIER * padding) < textWidth) {
                this.mPaint.setTextSize(this.mPaint.getTextSize() - 1.0f);
                float newTextWidth = this.mPaint.measureText(bar.getName());
                if (textWidth == newTextWidth) {
                    break;
                }
                textWidth = newTextWidth;
            }
            count += ORIENTATION_VERTICAL;
        }
        float labelTextSize = this.mPaint.getTextSize();
        count = ORIENTATION_HORIZONTAL;
        int oldright = (int) (-1.0f * padding);
        int alpha = MotionEventCompat.ACTION_MASK;
        SparseArray<Float> valueTextSizes = new SparseArray();
        Iterator it2 = this.mBars.iterator();
        while (it2.hasNext()) {
            int popupAlpha;
            float animationFraction;
            bar = (Bar) it2.next();
            if (!isAnimating()) {
                this.mPaint.setAlpha(bar.getColorAlpha());
                popupAlpha = MotionEventCompat.ACTION_MASK;
            } else if (bar.mAnimateSpecial == ORIENTATION_VERTICAL) {
                alpha = (int) (getAnimatedFractionSafe() * ((float) bar.getColorAlpha()));
                popupAlpha = (int) (getAnimatedFractionSafe() * 255.0f);
            } else if (bar.mAnimateSpecial == 2) {
                alpha = (int) ((1.0f - getAnimatedFractionSafe()) * ((float) bar.getColorAlpha()));
                popupAlpha = (int) ((1.0f - getAnimatedFractionSafe()) * 255.0f);
            } else {
                alpha = bar.getColorAlpha();
                popupAlpha = MotionEventCompat.ACTION_MASK;
            }
            barWidth = barWidths[count];
            float f = (float) oldright;
            float f2 = padding * 2.0f;
            if (bar.mAnimateSpecial == 2) {
                animationFraction = 1.0f - getAnimationFraction();
            } else if (bar.mAnimateSpecial == ORIENTATION_VERTICAL) {
                animationFraction = getAnimationFraction();
            } else {
                animationFraction = 1.0f;
            }
            left = (int) ((animationFraction * f2) + f);
            right = (int) (((float) left) + barWidth);
            oldright = right;
            this.mBoundsRect.set(left, (int) ((((float) getHeight()) - bottomPadding) - ((bar.getValue() / maxValue) * usableHeight)), right, (int) (((float) getHeight()) - bottomPadding));
            if (count != this.mSelectedIndex || this.mListener == null) {
                this.mPaint.setColor(bar.getColor());
            } else {
                this.mPaint.setColor(bar.getSelectedColor());
            }
            if (isAnimating()) {
                this.mPaint.setAlpha(alpha);
            }
            canvas.drawRect(this.mBoundsRect, this.mPaint);
            Path p = bar.getPath();
            p.reset();
            p.addRect((float) this.mBoundsRect.left, (float) this.mBoundsRect.top, (float) this.mBoundsRect.right, (float) this.mBoundsRect.bottom, Direction.CW);
            bar.getRegion().set(this.mBoundsRect.left, this.mBoundsRect.top, this.mBoundsRect.right, this.mBoundsRect.bottom);
            if (this.mShowAxisLabel) {
                this.mPaint.setColor(bar.getLabelColor());
                this.mPaint.setTextSize(labelTextSize);
                if (isAnimating()) {
                    this.mPaint.setAlpha(alpha);
                }
                int x = (int) (((float) ((this.mBoundsRect.left + this.mBoundsRect.right) / 2)) - (this.mPaint.measureText(bar.getName()) / 2.0f));
                int y = (int) (((float) getHeight()) - (3.0f * resources.getDisplayMetrics().scaledDensity));
                canvas.drawText(bar.getName(), (float) x, (float) y, this.mPaint);
            }
            if (this.mShowBarText) {
                this.mPaint.setTextSize(30.0f * resources.getDisplayMetrics().scaledDensity);
                this.mPaint.setColor(bar.getValueColor());
                if (isAnimating()) {
                    this.mPaint.setAlpha(popupAlpha);
                }
                this.mPaint.getTextBounds(bar.getValueString(), ORIENTATION_HORIZONTAL, ORIENTATION_VERTICAL, this.mTextRect);
                int boundLeft = (int) ((((float) ((this.mBoundsRect.left + this.mBoundsRect.right) / 2)) - (this.mPaint.measureText(bar.getValueString()) / 2.0f)) - (10.0f * resources.getDisplayMetrics().density));
                int boundTop = (int) (((float) (this.mBoundsRect.top + (this.mTextRect.top - this.mTextRect.bottom))) - (18.0f * resources.getDisplayMetrics().density));
                int boundRight = (int) ((((float) ((this.mBoundsRect.left + this.mBoundsRect.right) / 2)) + (this.mPaint.measureText(bar.getValueString()) / 2.0f)) + (10.0f * resources.getDisplayMetrics().density));
                if (boundLeft < this.mBoundsRect.left) {
                    boundLeft = this.mBoundsRect.left - (((int) padding) / 2);
                }
                if (boundRight > this.mBoundsRect.right) {
                    boundRight = this.mBoundsRect.right + (((int) padding) / 2);
                }
                if (this.mShowPopup) {
                    if (isAnimating()) {
                        popup.setAlpha(popupAlpha);
                    }
                    popup.setBounds(boundLeft, boundTop, boundRight, this.mBoundsRect.top);
                    popup.draw(canvas);
                }
                if (bar.mAnimateSpecial == 0) {
                    if (valueTextSizes.indexOfKey(bar.getValueString().length()) < 0) {
                        while (this.mPaint.measureText(bar.getValueString()) > ((float) (boundRight - boundLeft))) {
                            this.mPaint.setTextSize(this.mPaint.getTextSize() - 1.0f);
                        }
                        valueTextSizes.put(bar.getValueString().length(), Float.valueOf(this.mPaint.getTextSize()));
                    } else {
                        this.mPaint.setTextSize(((Float) valueTextSizes.get(bar.getValueString().length())).floatValue());
                    }
                } else {
                    while (this.mPaint.measureText(bar.getValueString()) > ((float) (boundRight - boundLeft))) {
                        this.mPaint.setTextSize(this.mPaint.getTextSize() - 1.0f);
                    }
                }
                if (isAnimating()) {
                    this.mPaint.setAlpha(popupAlpha);
                }
                canvas.drawText(bar.getValueString(), (float) ((int) (((float) ((this.mBoundsRect.left + this.mBoundsRect.right) / 2)) - (this.mPaint.measureText(bar.getValueString()) / 2.0f))), (((float) this.mBoundsRect.top) - (((float) (this.mBoundsRect.top - boundTop)) / 2.0f)) + ((((float) Math.abs(this.mTextRect.top - this.mTextRect.bottom)) / 2.0f) * 0.7f), this.mPaint);
            }
            count += ORIENTATION_VERTICAL;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();
        int count = ORIENTATION_HORIZONTAL;
        Region r = new Region();
        Iterator it = this.mBars.iterator();
        while (it.hasNext()) {
            Bar bar = (Bar) it.next();
            r.setPath(bar.getPath(), bar.getRegion());
            switch (event.getAction()) {
                case ORIENTATION_HORIZONTAL /*0*/:
                    if (!r.contains(point.x, point.y)) {
                        break;
                    }
                    this.mSelectedIndex = count;
                    postInvalidate();
                    break;
                case ORIENTATION_VERTICAL /*1*/:
                    if (count == this.mSelectedIndex && this.mListener != null && r.contains(point.x, point.y)) {
                        this.mListener.onClick(this.mSelectedIndex);
                        break;
                    }
                default:
                    break;
            }
            count += ORIENTATION_VERTICAL;
        }
        if (ORIENTATION_VERTICAL == event.getAction() || 3 == event.getAction()) {
            this.mSelectedIndex = -1;
            postInvalidate();
        }
        return true;
    }

    public void setOnBarClickedListener(OnBarClickedListener listener) {
        this.mListener = listener;
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

    public int getmValueStringPrecision() {
        return this.mValueStringPrecision;
    }

    public void setValueStringPrecision(int valueStringPrecision) {
        this.mValueStringPrecision = valueStringPrecision;
    }

    public long getValueStringUpdateInterval() {
        return this.mValueStringUpdateInterval;
    }

    public void setValueStringUpdateInterval(long valueStringUpdateInterval) {
        this.mValueStringUpdateInterval = valueStringUpdateInterval;
    }

    @TargetApi(12)
    public boolean isAnimating() {
        if (this.mValueAnimator != null) {
            return this.mValueAnimator.isRunning();
        }
        return false;
    }

    @TargetApi(12)
    private float getAnimationFraction() {
        if (this.mValueAnimator == null || !isAnimating()) {
            return 1.0f;
        }
        return this.mValueAnimator.getAnimatedFraction();
    }

    private float getAnimatedFractionSafe() {
        float f = getAnimationFraction();
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
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
            Log.e("HoloGraphLibrary compatibility error", "Animation not supported on api level 11 and below. Returning without animating.");
            return;
        }
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
        this.mOldMaxValue = 0.0f;
        this.mGoalMaxValue = 0.0f;
        Iterator it = this.mBars.iterator();
        while (it.hasNext()) {
            Bar b = (Bar) it.next();
            b.setOldValue(b.getValue());
            this.mOldMaxValue = Math.max(this.mOldMaxValue, b.getValue());
            this.mGoalMaxValue = Math.max(this.mGoalMaxValue, b.getGoalValue());
        }
        this.mMaxValue = this.mOldMaxValue;
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
        this.mLastTimeValueStringsUpdated = System.currentTimeMillis();
        va.addUpdateListener(new C01451());
        va.start();
    }

    public void setAnimationListener(AnimatorListener animationListener) {
        this.mAnimationListener = animationListener;
    }
}
