package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0494q;
import android.support.v7.widget.RecyclerView.C0494q.C0528a;
import android.support.v7.widget.RecyclerView.C0529r;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class ao extends C0494q {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final String TAG = "LinearSmoothScroller";
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    private final float MILLISECONDS_PER_PX;
    protected final DecelerateInterpolator mDecelerateInterpolator;
    protected int mInterimTargetDx;
    protected int mInterimTargetDy;
    protected final LinearInterpolator mLinearInterpolator;
    protected PointF mTargetVector;

    public ao(Context context) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mInterimTargetDx = SNAP_TO_ANY;
        this.mInterimTargetDy = SNAP_TO_ANY;
        this.MILLISECONDS_PER_PX = calculateSpeedPerPixel(context.getResources().getDisplayMetrics());
    }

    private int clampApplyScroll(int i, int i2) {
        int i3 = i - i2;
        return i * i3 <= 0 ? SNAP_TO_ANY : i3;
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case SNAP_TO_START /*-1*/:
                return i3 - i;
            case SNAP_TO_ANY /*0*/:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? SNAP_TO_ANY : i6;
            case SNAP_TO_END /*1*/:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int calculateDxToMakeVisible(View view, int i) {
        C0493h layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return SNAP_TO_ANY;
        }
        C0491i c0491i = (C0491i) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedLeft(view) - c0491i.leftMargin, layoutManager.getDecoratedRight(view) + c0491i.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
    }

    public int calculateDyToMakeVisible(View view, int i) {
        C0493h layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return SNAP_TO_ANY;
        }
        C0491i c0491i = (C0491i) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedTop(view) - c0491i.topMargin, layoutManager.getDecoratedBottom(view) + c0491i.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
    }

    protected int calculateTimeForDeceleration(int i) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(i)) / 0.3356d);
    }

    protected int calculateTimeForScrolling(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.MILLISECONDS_PER_PX));
    }

    public abstract PointF computeScrollVectorForPosition(int i);

    protected int getHorizontalSnapPreference() {
        return (this.mTargetVector == null || this.mTargetVector.x == 0.0f) ? SNAP_TO_ANY : this.mTargetVector.x > 0.0f ? SNAP_TO_END : SNAP_TO_START;
    }

    protected int getVerticalSnapPreference() {
        return (this.mTargetVector == null || this.mTargetVector.y == 0.0f) ? SNAP_TO_ANY : this.mTargetVector.y > 0.0f ? SNAP_TO_END : SNAP_TO_START;
    }

    protected void onSeekTargetStep(int i, int i2, C0529r c0529r, C0528a c0528a) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i);
        this.mInterimTargetDy = clampApplyScroll(this.mInterimTargetDy, i2);
        if (this.mInterimTargetDx == 0 && this.mInterimTargetDy == 0) {
            updateActionForInterimTarget(c0528a);
        }
    }

    protected void onStart() {
    }

    protected void onStop() {
        this.mInterimTargetDy = SNAP_TO_ANY;
        this.mInterimTargetDx = SNAP_TO_ANY;
        this.mTargetVector = null;
    }

    protected void onTargetFound(View view, C0529r c0529r, C0528a c0528a) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((double) ((calculateDxToMakeVisible * calculateDxToMakeVisible) + (calculateDyToMakeVisible * calculateDyToMakeVisible))));
        if (calculateTimeForDeceleration > 0) {
            c0528a.m1905a(-calculateDxToMakeVisible, -calculateDyToMakeVisible, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    protected void updateActionForInterimTarget(C0528a c0528a) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f)) {
            Log.e(TAG, "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
            c0528a.m1904a(getTargetPosition());
            stop();
            return;
        }
        normalize(computeScrollVectorForPosition);
        this.mTargetVector = computeScrollVectorForPosition;
        this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
        this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
        c0528a.m1905a((int) (((float) this.mInterimTargetDx) * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (((float) this.mInterimTargetDy) * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (((float) calculateTimeForScrolling(TARGET_SEEK_SCROLL_DISTANCE_PX)) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
    }
}
