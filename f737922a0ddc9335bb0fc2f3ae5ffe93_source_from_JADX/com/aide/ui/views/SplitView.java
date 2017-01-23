package com.aide.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.aide.common.d;

public class SplitView extends ViewGroup {
    private int animationPosition;
    private float dividerSpeed;
    private int dividerTouchSize;
    private int dragPosition;
    private float horizontalSplitRatio;
    private boolean isDragging;
    private boolean isHorizontal;
    private boolean isSplit;
    private boolean isSwipeEnabled;
    private a listener;
    private float verticalSplitRatio;

    public interface a {
        void j6(boolean z);
    }

    class 1 extends AnimatorListenerAdapter {
        final /* synthetic */ SplitView j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                if (this.j6.j6.listener != null) {
                    this.j6.j6.listener.j6(this.j6.j6.isSplit);
                }
            }
        }

        1(SplitView splitView) {
            this.j6 = splitView;
        }

        public void onAnimationEnd(Animator animator) {
            this.j6.animationPosition = -1;
            this.j6.postDelayed(new 1(this), 50);
        }
    }

    class 2 extends AnimatorListenerAdapter {
        final /* synthetic */ SplitView DW;
        final /* synthetic */ Runnable j6;

        2(SplitView splitView, Runnable runnable) {
            this.DW = splitView;
            this.j6 = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            this.DW.isSplit = false;
            this.DW.updateChildVisibilities();
            if (this.DW.listener != null) {
                this.DW.listener.j6(this.DW.isSplit);
            }
            if (this.j6 != null) {
                this.j6.run();
            }
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ SplitView DW;
        final /* synthetic */ boolean j6;

        3(SplitView splitView, boolean z) {
            this.DW = splitView;
            this.j6 = z;
        }

        public void run() {
            this.DW.openSplit(this.j6, true);
        }
    }

    public SplitView(Context context) {
        super(context);
        this.horizontalSplitRatio = 0.33f;
        this.verticalSplitRatio = 0.5f;
        this.dividerTouchSize = 30;
        this.dividerSpeed = 1.0f;
        this.isSplit = false;
        this.isHorizontal = false;
        this.isSwipeEnabled = false;
        this.isDragging = false;
    }

    public SplitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.horizontalSplitRatio = 0.33f;
        this.verticalSplitRatio = 0.5f;
        this.dividerTouchSize = 30;
        this.dividerSpeed = 1.0f;
        this.isSplit = false;
        this.isHorizontal = false;
        this.isSwipeEnabled = false;
        this.isDragging = false;
    }

    public SplitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.horizontalSplitRatio = 0.33f;
        this.verticalSplitRatio = 0.5f;
        this.dividerTouchSize = 30;
        this.dividerSpeed = 1.0f;
        this.isSplit = false;
        this.isHorizontal = false;
        this.isSwipeEnabled = false;
        this.isDragging = false;
    }

    public void setOnSplitChangeListener(a aVar) {
        this.listener = aVar;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        updateChildVisibilities();
        this.isHorizontal = splitHorizontalByDefault();
    }

    public void setSwipeEnabled(boolean z) {
        this.isSwipeEnabled = z;
    }

    public boolean isSplit() {
        return this.isSplit;
    }

    public boolean splitHorizontalByDefault() {
        return d.u7(getContext()) >= 650.0f;
    }

    private boolean isVertical() {
        return !isHorizontal();
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public View getBottomView() {
        return getChildAt(2);
    }

    public View getTopView() {
        return getChildAt(0);
    }

    public View getSeparatorView() {
        return getChildAt(1);
    }

    public void openSplit(boolean z) {
        openSplit(this.isHorizontal, z);
    }

    public void openSplit(boolean z, boolean z2) {
        this.isHorizontal = z;
        if (z2) {
            if (!this.isSplit || this.isDragging) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "animationPosition", new int[]{getDragPosition(), getDividerPosition()});
                ofInt.setDuration(getAnimationDuration(getDragPosition(), getDividerPosition()));
                ofInt.start();
                ofInt.addListener(new 1(this));
                this.isSplit = true;
                updateChildVisibilities();
            }
        } else if (!this.isSplit) {
            this.isSplit = true;
            this.animationPosition = -1;
            updateChildVisibilities();
            if (this.listener != null) {
                this.listener.j6(this.isSplit);
            }
        }
        this.isDragging = false;
    }

    private long getAnimationDuration(int i, int i2) {
        return (long) ((((float) Math.abs(i - i2)) / getResources().getDisplayMetrics().density) / this.dividerSpeed);
    }

    public void closeSplit(boolean z) {
        closeSplit(z, null);
    }

    public void closeSplit(boolean z, Runnable runnable) {
        if (z) {
            if (this.isSplit || this.isDragging) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "animationPosition", new int[]{getDragPosition(), 0});
                ofInt.setDuration(getAnimationDuration(getDragPosition(), 0));
                ofInt.start();
                ofInt.addListener(new 2(this, runnable));
            }
        } else if (this.isSplit) {
            this.isSplit = false;
            updateChildVisibilities();
            if (this.listener != null) {
                this.listener.j6(this.isSplit);
            }
        }
        this.isDragging = false;
    }

    public void toggleSplit(Runnable runnable) {
        if (isSplit() && isVertical()) {
            closeSplit(true, runnable);
        } else if (isSplit() && isHorizontal()) {
            setOrientation(false, true);
        } else {
            openSplit(splitHorizontalByDefault(), true);
        }
    }

    private void setOrientation(boolean z, boolean z2) {
        if (this.isHorizontal == z) {
            return;
        }
        if (z2 && this.isSplit) {
            closeSplit(true, new 3(this, z));
            return;
        }
        this.isHorizontal = z;
        requestLayout();
        if (this.listener != null) {
            this.listener.j6(this.isSplit);
        }
    }

    private void updateChildVisibilities() {
        int i;
        int i2 = 8;
        View bottomView = getBottomView();
        if (this.isSplit || this.isDragging) {
            i = 0;
        } else {
            i = 8;
        }
        bottomView.setVisibility(i);
        View separatorView = getSeparatorView();
        if (this.isSplit || this.isDragging) {
            i2 = 0;
        }
        separatorView.setVisibility(i2);
    }

    public void setAnimationPosition(int i) {
        this.animationPosition = i;
        requestLayout();
    }

    private int getDividerPosition() {
        return getDividerPosition(getWidth(), getHeight());
    }

    private int getDividerPosition(int i, int i2) {
        if (this.isHorizontal) {
            return (int) (this.horizontalSplitRatio * ((float) i));
        }
        return (int) (this.verticalSplitRatio * ((float) i2));
    }

    private int getCurrentDividerPosition(int i, int i2) {
        if (this.isDragging) {
            return getDragPosition();
        }
        if (this.animationPosition < 0) {
            return getDividerPosition(i, i2);
        }
        return this.animationPosition;
    }

    private int getDragPosition() {
        if (this.isDragging) {
            return Math.min(this.dragPosition, getDividerPosition());
        }
        return this.isSplit ? getDividerPosition() : 0;
    }

    private int getDragDistance() {
        if (this.isSplit) {
            return getDividerPosition() - getDragPosition();
        }
        return getDragPosition();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View topView = getTopView();
        View bottomView = getBottomView();
        View separatorView = getSeparatorView();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (bottomView.getVisibility() == 8) {
            topView.layout(0, 0, i5, i6);
        } else if (this.isHorizontal) {
            r5 = bottomView.getMeasuredWidth();
            r6 = separatorView.getMeasuredWidth();
            topView.layout(r5 + r6, 0, i5, i6);
            separatorView.layout(r5, 0, r5 + r6, i6);
            bottomView.layout(0, 0, r5, i6);
        } else {
            r5 = topView.getMeasuredHeight();
            r6 = separatorView.getMeasuredHeight();
            topView.layout(0, 0, i5, r5);
            separatorView.layout(0, r5, i5, r5 + r6);
            bottomView.layout(0, r5 + r6, i5, i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        View topView = getTopView();
        View bottomView = getBottomView();
        View separatorView = getSeparatorView();
        MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i);
        if (bottomView.getVisibility() == 8) {
            topView.measure(i, i2);
        } else if (this.isHorizontal) {
            bottomView.measure(MeasureSpec.makeMeasureSpec(getCurrentDividerPosition(size2, size), 1073741824), i2);
            topView.measure(MeasureSpec.makeMeasureSpec(size2 - bottomView.getMeasuredWidth(), 1073741824), i2);
            separatorView.measure(-2, i2);
        } else {
            bottomView.measure(i, MeasureSpec.makeMeasureSpec(getCurrentDividerPosition(size2, size), 1073741824));
            topView.measure(i, MeasureSpec.makeMeasureSpec(size - bottomView.getMeasuredHeight(), 1073741824));
            separatorView.measure(i, -2);
        }
        setMeasuredDimension(size2, size);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getDragStartOrientation(motionEvent) != null) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Boolean dragStartOrientation = getDragStartOrientation(motionEvent);
        if (dragStartOrientation != null) {
            startDragging(motionEvent, dragStartOrientation.booleanValue());
            return true;
        } else if (!this.isDragging) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (motionEvent.getAction() == 2) {
                updateDragging(motionEvent);
            }
            if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                return true;
            }
            stopDragging(motionEvent);
            return true;
        }
    }

    private Boolean getDragStartOrientation(MotionEvent motionEvent) {
        if (this.isSwipeEnabled && !this.isSplit && motionEvent.getAction() == 0 && motionEvent.getPointerCount() == 1 && motionEvent.getX() < ((float) this.dividerTouchSize) * getResources().getDisplayMetrics().density && splitHorizontalByDefault()) {
            return Boolean.valueOf(true);
        }
        if (this.isSwipeEnabled && this.isSplit && this.isHorizontal && motionEvent.getAction() == 0 && motionEvent.getPointerCount() == 1 && motionEvent.getY() > getResources().getDisplayMetrics().density * 50.0f && motionEvent.getY() < ((float) getHeight()) - (getResources().getDisplayMetrics().density * 50.0f) && Math.abs(motionEvent.getX() - (((float) getWidth()) * this.horizontalSplitRatio)) < ((float) this.dividerTouchSize) * getResources().getDisplayMetrics().density) {
            return Boolean.valueOf(true);
        }
        if (this.isSwipeEnabled && !this.isSplit && motionEvent.getAction() == 0 && motionEvent.getPointerCount() == 1 && motionEvent.getY() > ((float) getHeight()) - (((float) this.dividerTouchSize) * getResources().getDisplayMetrics().density) && ((float) getHeight()) > 150.0f * getResources().getDisplayMetrics().density) {
            return Boolean.valueOf(false);
        }
        if (!this.isSwipeEnabled || !this.isSplit || this.isHorizontal || motionEvent.getAction() != 0 || motionEvent.getPointerCount() != 1 || motionEvent.getX() >= ((float) getWidth()) - (getResources().getDisplayMetrics().density * 50.0f) || motionEvent.getX() <= getResources().getDisplayMetrics().density * 50.0f || Math.abs(motionEvent.getY() - (((float) getHeight()) * this.verticalSplitRatio)) >= ((float) this.dividerTouchSize) * getResources().getDisplayMetrics().density) {
            return null;
        }
        return Boolean.valueOf(false);
    }

    private void stopDragging(MotionEvent motionEvent) {
        if (this.isSplit == (((float) getDragDistance()) > ((float) (this.dividerTouchSize * 2)) * getResources().getDisplayMetrics().density)) {
            closeSplit(true);
        } else {
            openSplit(true);
        }
    }

    private void startDragging(MotionEvent motionEvent, boolean z) {
        this.isHorizontal = z;
        this.isDragging = true;
        updateDragging(motionEvent);
        updateChildVisibilities();
    }

    private void updateDragging(MotionEvent motionEvent) {
        this.dragPosition = this.isHorizontal ? (int) motionEvent.getX() : (int) (((float) getHeight()) - motionEvent.getY());
        requestLayout();
    }
}
