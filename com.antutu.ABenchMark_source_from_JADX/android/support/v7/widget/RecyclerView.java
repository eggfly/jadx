package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.recyclerview.C0421R;
import android.support.v7.widget.C0605e.C0507a;
import android.support.v7.widget.C0605e.C0604b;
import android.support.v7.widget.ag.C0505b;
import android.support.v7.widget.bk.C0503b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.facebook.ads.AdError;
import com.qq.p035e.comm.constants.Constants.PLUGIN;
import com.taobao.accs.data.Message;
import com.umeng.message.proguard.C4233j;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.spdy.SpdyProtocol;

public class RecyclerView extends ViewGroup implements NestedScrollingChild, ScrollingView {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    private static final boolean DEBUG = false;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    private static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator;
    private at mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private C0522k mActiveOnItemTouchListener;
    private C0510a mAdapter;
    C0605e mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private EdgeEffectCompat mBottomGlow;
    private C0513d mChildDrawingOrderCallback;
    ag mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    private int mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    C0517e mItemAnimator;
    private C0515b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList<C0519g> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    C0493h mLayout;
    private boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    private boolean mLayoutRequestEaten;
    private EdgeEffectCompat mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C0527p mObserver;
    private List<C0521j> mOnChildAttachStateListeners;
    private final ArrayList<C0522k> mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final C0525n mRecycler;
    private C0526o mRecyclerListener;
    private EdgeEffectCompat mRightGlow;
    private final int[] mScrollConsumed;
    private float mScrollFactor;
    private C0523l mScrollListener;
    private List<C0523l> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final C0529r mState;
    private final Rect mTempRect;
    private EdgeEffectCompat mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final C0531t mViewFlinger;
    private final C0503b mViewInfoProcessCallback;
    final bk mViewInfoStore;

    /* renamed from: android.support.v7.widget.RecyclerView.i */
    public static class C0491i extends MarginLayoutParams {
        C0532u f1466a;
        final Rect f1467b;
        boolean f1468c;
        boolean f1469d;

        public C0491i(int i, int i2) {
            super(i, i2);
            this.f1467b = new Rect();
            this.f1468c = true;
            this.f1469d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0491i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1467b = new Rect();
            this.f1468c = true;
            this.f1469d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0491i(C0491i c0491i) {
            super(c0491i);
            this.f1467b = new Rect();
            this.f1468c = true;
            this.f1469d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0491i(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1467b = new Rect();
            this.f1468c = true;
            this.f1469d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0491i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1467b = new Rect();
            this.f1468c = true;
            this.f1469d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean m1701c() {
            return this.f1466a.isRemoved();
        }

        public boolean m1702d() {
            return this.f1466a.isUpdated();
        }

        public int m1703e() {
            return this.f1466a.getLayoutPosition();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.h */
    public static abstract class C0493h {
        private boolean mAutoMeasure;
        ag mChildHelper;
        private int mHeight;
        private int mHeightMode;
        boolean mIsAttachedToWindow;
        private boolean mMeasurementCacheEnabled;
        RecyclerView mRecyclerView;
        private boolean mRequestedSimpleAnimations;
        C0494q mSmoothScroller;
        private int mWidth;
        private int mWidthMode;

        /* renamed from: android.support.v7.widget.RecyclerView.h.a */
        public static class C0520a {
            public int f1521a;
            public int f1522b;
            public boolean f1523c;
            public boolean f1524d;
        }

        public C0493h() {
            this.mRequestedSimpleAnimations = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mIsAttachedToWindow = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mAutoMeasure = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mMeasurementCacheEnabled = true;
        }

        private void addViewInt(View view, int i, boolean z) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m2585e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m2586f(childViewHolderInt);
            }
            C0491i c0491i = (C0491i) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.m2220a(view, i, view.getLayoutParams(), RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            } else if (view.getParent() == this.mRecyclerView) {
                int b = this.mChildHelper.m2224b(view);
                if (i == RecyclerView.NO_POSITION) {
                    i = this.mChildHelper.m2223b();
                }
                if (b == RecyclerView.NO_POSITION) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view));
                } else if (b != i) {
                    this.mRecyclerView.mLayout.moveView(b, i);
                }
            } else {
                this.mChildHelper.m2221a(view, i, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                c0491i.f1468c = true;
                if (this.mSmoothScroller != null && this.mSmoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (c0491i.f1469d) {
                childViewHolderInt.itemView.invalidate();
                c0491i.f1469d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.m2229d(i);
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int i5 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int max = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == RecyclerView.NO_POSITION) {
                    switch (i2) {
                        case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
                        case 1073741824:
                            i5 = max;
                            break;
                        case RecyclerView.TOUCH_SLOP_DEFAULT /*0*/:
                            i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                            break;
                        default:
                            i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = RecyclerView.TOUCH_SLOP_DEFAULT;
                    }
                    max = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == RecyclerView.NO_POSITION) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == LinearLayoutManager.INVALID_OFFSET || i2 == 1073741824) {
                        i5 = LinearLayoutManager.INVALID_OFFSET;
                    }
                }
                max = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        @Deprecated
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = 1073741824;
            int max = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, i - i2);
            if (z) {
                if (i3 < 0) {
                    i4 = RecyclerView.TOUCH_SLOP_DEFAULT;
                    i3 = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            } else if (i3 < 0) {
                if (i3 == RecyclerView.NO_POSITION) {
                    i3 = max;
                } else if (i3 == -2) {
                    i4 = LinearLayoutManager.INVALID_OFFSET;
                    i3 = max;
                } else {
                    i4 = RecyclerView.TOUCH_SLOP_DEFAULT;
                    i3 = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            }
            return MeasureSpec.makeMeasureSpec(i3, i4);
        }

        public static C0520a getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            C0520a c0520a = new C0520a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0421R.styleable.RecyclerView, i, i2);
            c0520a.f1521a = obtainStyledAttributes.getInt(C0421R.styleable.RecyclerView_android_orientation, RecyclerView.VERTICAL);
            c0520a.f1522b = obtainStyledAttributes.getInt(C0421R.styleable.RecyclerView_spanCount, RecyclerView.VERTICAL);
            c0520a.f1523c = obtainStyledAttributes.getBoolean(C0421R.styleable.RecyclerView_reverseLayout, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            c0520a.f1524d = obtainStyledAttributes.getBoolean(C0421R.styleable.RecyclerView_stackFromEnd, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            obtainStyledAttributes.recycle();
            return c0520a;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            switch (mode) {
                case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
                    return size < i ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
                case RecyclerView.TOUCH_SLOP_DEFAULT /*0*/:
                    return true;
                case 1073741824:
                    return size != i ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
                default:
                    return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        private void onSmoothScrollerStopped(C0494q c0494q) {
            if (this.mSmoothScroller == c0494q) {
                this.mSmoothScroller = null;
            }
        }

        private void scrapOrRecycleView(C0525n c0525n, int i, View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    c0525n.m1881c(view);
                    this.mRecyclerView.mViewInfoStore.m2588h(childViewHolderInt);
                    return;
                }
                removeViewAt(i);
                c0525n.m1875b(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, RecyclerView.NO_POSITION);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, RecyclerView.NO_POSITION);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        public void assertInLayoutOrScroll(String str) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view) {
            attachView(view, RecyclerView.NO_POSITION);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (C0491i) view.getLayoutParams());
        }

        public void attachView(View view, int i, C0491i c0491i) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m2585e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m2586f(childViewHolderInt);
            }
            this.mChildHelper.m2220a(view, i, c0491i, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            if (this.mRecyclerView == null) {
                rect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
            } else {
                rect.set(this.mRecyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean canScrollVertically() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean checkLayoutParams(C0491i c0491i) {
            return c0491i != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int computeHorizontalScrollExtent(C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeHorizontalScrollOffset(C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeHorizontalScrollRange(C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeVerticalScrollExtent(C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeVerticalScrollOffset(C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeVerticalScrollRange(C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void detachAndScrapAttachedViews(C0525n c0525n) {
            for (int childCount = getChildCount() + RecyclerView.NO_POSITION; childCount >= 0; childCount += RecyclerView.NO_POSITION) {
                scrapOrRecycleView(c0525n, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, C0525n c0525n) {
            scrapOrRecycleView(c0525n, this.mChildHelper.m2224b(view), view);
        }

        public void detachAndScrapViewAt(int i, C0525n c0525n) {
            scrapOrRecycleView(c0525n, i, getChildAt(i));
        }

        public void detachView(View view) {
            int b = this.mChildHelper.m2224b(view);
            if (b >= 0) {
                detachViewInternal(b, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, C0525n c0525n) {
            this.mIsAttachedToWindow = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            onDetachedFromWindow(recyclerView, c0525n);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.m1823c(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            if (this.mRecyclerView == null) {
                return null;
            }
            View findContainingItemView = this.mRecyclerView.findContainingItemView(view);
            return (findContainingItemView == null || this.mChildHelper.m2228c(findContainingItemView)) ? null : findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = RecyclerView.TOUCH_SLOP_DEFAULT; i2 < childCount; i2 += RecyclerView.VERTICAL) {
                View childAt = getChildAt(i2);
                C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.m1925a() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract C0491i generateDefaultLayoutParams();

        public C0491i generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new C0491i(context, attributeSet);
        }

        public C0491i generateLayoutParams(LayoutParams layoutParams) {
            return layoutParams instanceof C0491i ? new C0491i((C0491i) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0491i((MarginLayoutParams) layoutParams) : new C0491i(layoutParams);
        }

        public int getBaseline() {
            return RecyclerView.NO_POSITION;
        }

        public int getBottomDecorationHeight(View view) {
            return ((C0491i) view.getLayoutParams()).f1467b.bottom;
        }

        public View getChildAt(int i) {
            return this.mChildHelper != null ? this.mChildHelper.m2225b(i) : null;
        }

        public int getChildCount() {
            return this.mChildHelper != null ? this.mChildHelper.m2223b() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public boolean getClipToPadding() {
            return (this.mRecyclerView == null || !this.mRecyclerView.mClipToPadding) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public int getColumnCountForAccessibility(C0525n c0525n, C0529r c0529r) {
            return (this.mRecyclerView == null || this.mRecyclerView.mAdapter == null || !canScrollHorizontally()) ? RecyclerView.VERTICAL : this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((C0491i) view.getLayoutParams()).f1467b;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((C0491i) view.getLayoutParams()).f1467b;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            if (this.mRecyclerView == null) {
                return null;
            }
            View focusedChild = this.mRecyclerView.getFocusedChild();
            return (focusedChild == null || this.mChildHelper.m2228c(focusedChild)) ? null : focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            C0510a adapter = this.mRecyclerView != null ? this.mRecyclerView.getAdapter() : null;
            return adapter != null ? adapter.getItemCount() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((C0491i) view.getLayoutParams()).f1467b.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingBottom() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingEnd() {
            return this.mRecyclerView != null ? ViewCompat.getPaddingEnd(this.mRecyclerView) : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingLeft() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingLeft() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingRight() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingRight() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingStart() {
            return this.mRecyclerView != null ? ViewCompat.getPaddingStart(this.mRecyclerView) : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingTop() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingTop() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPosition(View view) {
            return ((C0491i) view.getLayoutParams()).m1703e();
        }

        public int getRightDecorationWidth(View view) {
            return ((C0491i) view.getLayoutParams()).f1467b.right;
        }

        public int getRowCountForAccessibility(C0525n c0525n, C0529r c0529r) {
            return (this.mRecyclerView == null || this.mRecyclerView.mAdapter == null || !canScrollVertically()) ? RecyclerView.VERTICAL : this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(C0525n c0525n, C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getTopDecorationHeight(View view) {
            return ((C0491i) view.getLayoutParams()).f1467b.top;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < childCount; i += RecyclerView.VERTICAL) {
                LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean hasFocus() {
            return (this.mRecyclerView == null || !this.mRecyclerView.hasFocus()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.mRecyclerView || this.mRecyclerView.indexOfChild(view) == RecyclerView.NO_POSITION) {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            }
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(SpdyProtocol.SLIGHTSSLV2);
            this.mRecyclerView.mViewInfoStore.m2587g(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            return (this.mRecyclerView == null || !this.mRecyclerView.isFocused()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public boolean isLayoutHierarchical(C0525n c0525n, C0529r c0529r) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            return (this.mSmoothScroller == null || !this.mSmoothScroller.isRunning()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((C0491i) view.getLayoutParams()).f1467b;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public void measureChild(View view, int i, int i2) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right) + i;
            int i4 = (itemDecorInsetsForChild.bottom + itemDecorInsetsForChild.top) + i2;
            i3 = C0493h.getChildMeasureSpec(getWidth(), getWidthMode(), i3 + (getPaddingLeft() + getPaddingRight()), c0491i.width, canScrollHorizontally());
            i4 = C0493h.getChildMeasureSpec(getHeight(), getHeightMode(), i4 + (getPaddingTop() + getPaddingBottom()), c0491i.height, canScrollVertically());
            if (shouldMeasureChild(view, i3, i4, c0491i)) {
                view.measure(i3, i4);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right) + i;
            int i4 = (itemDecorInsetsForChild.bottom + itemDecorInsetsForChild.top) + i2;
            i3 = C0493h.getChildMeasureSpec(getWidth(), getWidthMode(), i3 + (((getPaddingLeft() + getPaddingRight()) + c0491i.leftMargin) + c0491i.rightMargin), c0491i.width, canScrollHorizontally());
            i4 = C0493h.getChildMeasureSpec(getHeight(), getHeightMode(), i4 + (((getPaddingTop() + getPaddingBottom()) + c0491i.topMargin) + c0491i.bottomMargin), c0491i.height, canScrollVertically());
            if (shouldMeasureChild(view, i3, i4, c0491i)) {
                view.measure(i3, i4);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            detachViewAt(i);
            attachView(childAt, i2);
        }

        public void offsetChildrenHorizontal(int i) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(C0510a c0510a, C0510a c0510a2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, C0525n c0525n) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, C0525n c0525n, C0529r c0529r) {
            return null;
        }

        public void onInitializeAccessibilityEvent(C0525n c0525n, C0529r c0529r, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            if (this.mRecyclerView != null && asRecord != null) {
                if (!(ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.VERTICAL) || ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.NO_POSITION) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.NO_POSITION) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.VERTICAL))) {
                    z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                }
                asRecord.setScrollable(z);
                if (this.mRecyclerView.mAdapter != null) {
                    asRecord.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(C0525n c0525n, C0529r c0529r, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.NO_POSITION) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.NO_POSITION)) {
                accessibilityNodeInfoCompat.addAction((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.VERTICAL) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.VERTICAL)) {
                accessibilityNodeInfoCompat.addAction((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(CollectionInfoCompat.obtain(getRowCountForAccessibility(c0525n, c0529r), getColumnCountForAccessibility(c0525n, c0529r), isLayoutHierarchical(c0525n, c0529r), getSelectionModeForAccessibility(c0525n, c0529r)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(C0525n c0525n, C0529r c0529r, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.VERTICAL, canScrollHorizontally() ? getPosition(view) : RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.VERTICAL, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST));
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.m2228c(childViewHolderInt.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(C0525n c0525n, C0529r c0529r) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(C0525n c0525n, C0529r c0529r, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C0529r c0529r, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return (isSmoothScrolling() || recyclerView.isComputingLayout()) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(android.support.v7.widget.RecyclerView.C0525n r7, android.support.v7.widget.RecyclerView.C0529r r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.mRecyclerView;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.mRecyclerView;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.mRecyclerView;
            r0 = android.support.v4.view.ViewCompat.canScrollVertically(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.getHeight();
            r3 = r6.getPaddingTop();
            r0 = r0 - r3;
            r3 = r6.getPaddingBottom();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.mRecyclerView;
            r3 = android.support.v4.view.ViewCompat.canScrollHorizontally(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.getWidth();
            r4 = r6.getPaddingLeft();
            r3 = r3 - r4;
            r4 = r6.getPaddingRight();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.mRecyclerView;
            r0 = android.support.v4.view.ViewCompat.canScrollVertically(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.getHeight();
            r3 = r6.getPaddingTop();
            r0 = r0 - r3;
            r3 = r6.getPaddingBottom();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.mRecyclerView;
            r3 = android.support.v4.view.ViewCompat.canScrollHorizontally(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.getWidth();
            r4 = r6.getPaddingLeft();
            r3 = r3 - r4;
            r4 = r6.getPaddingRight();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.performAccessibilityAction(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$r, int, android.os.Bundle):boolean");
        }

        public boolean performAccessibilityActionForItem(C0525n c0525n, C0529r c0529r, View view, int i, Bundle bundle) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public void postOnAnimation(Runnable runnable) {
            if (this.mRecyclerView != null) {
                ViewCompat.postOnAnimation(this.mRecyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() + RecyclerView.NO_POSITION; childCount >= 0; childCount += RecyclerView.NO_POSITION) {
                this.mChildHelper.m2218a(childCount);
            }
        }

        public void removeAndRecycleAllViews(C0525n c0525n) {
            for (int childCount = getChildCount() + RecyclerView.NO_POSITION; childCount >= 0; childCount += RecyclerView.NO_POSITION) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, c0525n);
                }
            }
        }

        void removeAndRecycleScrapInt(C0525n c0525n) {
            int d = c0525n.m1882d();
            for (int i = d + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                View e = c0525n.m1885e(i);
                C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(e, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.m1823c(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    c0525n.m1876b(e);
                }
            }
            c0525n.m1886e();
            if (d > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, C0525n c0525n) {
            removeView(view);
            c0525n.m1868a(view);
        }

        public void removeAndRecycleViewAt(int i, C0525n c0525n) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            c0525n.m1868a(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            return this.mRecyclerView != null ? this.mRecyclerView.removeCallbacks(runnable) : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        public void removeView(View view) {
            this.mChildHelper.m2219a(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.m2218a(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = left + rect.width();
            int height2 = top + rect.height();
            int min = Math.min(RecyclerView.TOUCH_SLOP_DEFAULT, left - paddingLeft);
            int min2 = Math.min(RecyclerView.TOUCH_SLOP_DEFAULT, top - paddingTop);
            int max = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, width2 - width);
            height = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, height2 - height);
            if (getLayoutDirection() == RecyclerView.VERTICAL) {
                if (max == 0) {
                    max = Math.max(min, width2 - width);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - paddingLeft, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - paddingTop, height);
            if (min == 0 && max == 0) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.smoothScrollBy(min, max);
            }
            return true;
        }

        public void requestLayout() {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, C0525n c0525n, C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, C0525n c0525n, C0529r c0529r) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        void setMeasureSpecs(int i, int i2) {
            this.mWidth = MeasureSpec.getSize(i);
            this.mWidthMode = MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
            this.mHeight = MeasureSpec.getSize(i2);
            this.mHeightMode = MeasureSpec.getMode(i2);
            if (this.mHeightMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(C0493h.chooseSize(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), getMinimumWidth()), C0493h.chooseSize(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), getMinimumHeight()));
        }

        void setMeasuredDimensionFromChildren(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = LinearLayoutManager.INVALID_OFFSET;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i5 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int i6 = LinearLayoutManager.INVALID_OFFSET;
            int i7 = Integer.MAX_VALUE;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                C0491i c0491i = (C0491i) childAt.getLayoutParams();
                int decoratedLeft = getDecoratedLeft(childAt) - c0491i.leftMargin;
                int decoratedRight = c0491i.rightMargin + getDecoratedRight(childAt);
                int decoratedTop = getDecoratedTop(childAt) - c0491i.topMargin;
                int decoratedBottom = c0491i.bottomMargin + getDecoratedBottom(childAt);
                if (decoratedLeft >= i7) {
                    decoratedLeft = i7;
                }
                if (decoratedRight <= i6) {
                    decoratedRight = i6;
                }
                if (decoratedTop >= i3) {
                    decoratedTop = i3;
                }
                if (decoratedBottom <= i4) {
                    decoratedBottom = i4;
                }
                i5 += RecyclerView.VERTICAL;
                i6 = decoratedRight;
                i3 = decoratedTop;
                i7 = decoratedLeft;
                i4 = decoratedBottom;
            }
            this.mRecyclerView.mTempRect.set(i7, i3, i6, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.mHeight = RecyclerView.TOUCH_SLOP_DEFAULT;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        boolean shouldMeasureChild(View view, int i, int i2, C0491i c0491i) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && C0493h.isMeasurementUpToDate(view.getWidth(), i, c0491i.width) && C0493h.isMeasurementUpToDate(view.getHeight(), i2, c0491i.height)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        boolean shouldMeasureTwice() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean shouldReMeasureChild(View view, int i, int i2, C0491i c0491i) {
            return (this.mMeasurementCacheEnabled && C0493h.isMeasurementUpToDate(view.getMeasuredWidth(), i, c0491i.width) && C0493h.isMeasurementUpToDate(view.getMeasuredHeight(), i2, c0491i.height)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C0529r c0529r, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(C0494q c0494q) {
            if (!(this.mSmoothScroller == null || c0494q == this.mSmoothScroller || !this.mSmoothScroller.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = c0494q;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        void stopSmoothScroller() {
            if (this.mSmoothScroller != null) {
                this.mSmoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.q */
    public static abstract class C0494q {
        private C0493h mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final C0528a mRecyclingAction;
        private boolean mRunning;
        private int mTargetPosition;
        private View mTargetView;

        /* renamed from: android.support.v7.widget.RecyclerView.q.a */
        public static class C0528a {
            private int f1537a;
            private int f1538b;
            private int f1539c;
            private int f1540d;
            private Interpolator f1541e;
            private boolean f1542f;
            private int f1543g;

            public C0528a(int i, int i2) {
                this(i, i2, LinearLayoutManager.INVALID_OFFSET, null);
            }

            public C0528a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1540d = RecyclerView.NO_POSITION;
                this.f1542f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.f1543g = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.f1537a = i;
                this.f1538b = i2;
                this.f1539c = i3;
                this.f1541e = interpolator;
            }

            private void m1902a(RecyclerView recyclerView) {
                if (this.f1540d >= 0) {
                    int i = this.f1540d;
                    this.f1540d = RecyclerView.NO_POSITION;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f1542f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                } else if (this.f1542f) {
                    m1903b();
                    if (this.f1541e != null) {
                        recyclerView.mViewFlinger.m1939a(this.f1537a, this.f1538b, this.f1539c, this.f1541e);
                    } else if (this.f1539c == LinearLayoutManager.INVALID_OFFSET) {
                        recyclerView.mViewFlinger.m1941b(this.f1537a, this.f1538b);
                    } else {
                        recyclerView.mViewFlinger.m1937a(this.f1537a, this.f1538b, this.f1539c);
                    }
                    this.f1543g += RecyclerView.VERTICAL;
                    if (this.f1543g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1542f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                } else {
                    this.f1543g = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            }

            private void m1903b() {
                if (this.f1541e != null && this.f1539c < RecyclerView.VERTICAL) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f1539c < RecyclerView.VERTICAL) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void m1904a(int i) {
                this.f1540d = i;
            }

            public void m1905a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1537a = i;
                this.f1538b = i2;
                this.f1539c = i3;
                this.f1541e = interpolator;
                this.f1542f = true;
            }

            boolean m1906a() {
                return this.f1540d >= 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        public C0494q() {
            this.mTargetPosition = RecyclerView.NO_POSITION;
            this.mRecyclingAction = new C0528a(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        private void onAnimation(int i, int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (!this.mRunning || this.mTargetPosition == RecyclerView.NO_POSITION || recyclerView == null) {
                stop();
            }
            this.mPendingInitialRun = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.mTargetView != null) {
                if (getChildPosition(this.mTargetView) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.m1902a(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean a = this.mRecyclingAction.m1906a();
                this.mRecyclingAction.m1902a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.m1935a();
                    return;
                }
                stop();
            }
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public C0493h getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        protected void normalize(PointF pointF) {
            double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x = (float) (((double) pointF.x) / sqrt);
            pointF.y = (float) (((double) pointF.y) / sqrt);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(int i, int i2, C0529r c0529r, C0528a c0528a);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, C0529r c0529r, C0528a c0528a);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        void start(RecyclerView recyclerView, C0493h c0493h) {
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = c0493h;
            if (this.mTargetPosition == RecyclerView.NO_POSITION) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.mState.f1545b = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.m1935a();
        }

        protected final void stop() {
            if (this.mRunning) {
                onStop();
                this.mRecyclerView.mState.f1545b = RecyclerView.NO_POSITION;
                this.mTargetView = null;
                this.mTargetPosition = RecyclerView.NO_POSITION;
                this.mPendingInitialRun = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.mRunning = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.1 */
    class C05001 implements Runnable {
        final /* synthetic */ RecyclerView f1504a;

        C05001(RecyclerView recyclerView) {
            this.f1504a = recyclerView;
        }

        public void run() {
            if (this.f1504a.mFirstLayoutComplete && !this.f1504a.isLayoutRequested()) {
                if (this.f1504a.mLayoutFrozen) {
                    this.f1504a.mLayoutRequestEaten = true;
                } else {
                    this.f1504a.consumePendingUpdateOperations();
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.2 */
    class C05012 implements Runnable {
        final /* synthetic */ RecyclerView f1505a;

        C05012(RecyclerView recyclerView) {
            this.f1505a = recyclerView;
        }

        public void run() {
            if (this.f1505a.mItemAnimator != null) {
                this.f1505a.mItemAnimator.m1815a();
            }
            this.f1505a.mPostedAnimatorRunner = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.3 */
    static class C05023 implements Interpolator {
        C05023() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.4 */
    class C05044 implements C0503b {
        final /* synthetic */ RecyclerView f1506a;

        C05044(RecyclerView recyclerView) {
            this.f1506a = recyclerView;
        }

        public void m1747a(C0532u c0532u) {
            this.f1506a.mLayout.removeAndRecycleView(c0532u.itemView, this.f1506a.mRecycler);
        }

        public void m1748a(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
            this.f1506a.mRecycler.m1884d(c0532u);
            this.f1506a.animateDisappearance(c0532u, c0516c, c0516c2);
        }

        public void m1749b(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
            this.f1506a.animateAppearance(c0532u, c0516c, c0516c2);
        }

        public void m1750c(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
            c0532u.setIsRecyclable(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            if (this.f1506a.mDataSetHasChangedAfterLayout) {
                if (this.f1506a.mItemAnimator.m1818a(c0532u, c0532u, c0516c, c0516c2)) {
                    this.f1506a.postAnimationRunner();
                }
            } else if (this.f1506a.mItemAnimator.m1824c(c0532u, c0516c, c0516c2)) {
                this.f1506a.postAnimationRunner();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.5 */
    class C05065 implements C0505b {
        final /* synthetic */ RecyclerView f1507a;

        C05065(RecyclerView recyclerView) {
            this.f1507a = recyclerView;
        }

        public int m1762a() {
            return this.f1507a.getChildCount();
        }

        public int m1763a(View view) {
            return this.f1507a.indexOfChild(view);
        }

        public void m1764a(int i) {
            View childAt = this.f1507a.getChildAt(i);
            if (childAt != null) {
                this.f1507a.dispatchChildDetached(childAt);
            }
            this.f1507a.removeViewAt(i);
        }

        public void m1765a(View view, int i) {
            this.f1507a.addView(view, i);
            this.f1507a.dispatchChildAttached(view);
        }

        public void m1766a(View view, int i, LayoutParams layoutParams) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt);
                }
            }
            this.f1507a.attachViewToParent(view, i, layoutParams);
        }

        public C0532u m1767b(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        public View m1768b(int i) {
            return this.f1507a.getChildAt(i);
        }

        public void m1769b() {
            int a = m1762a();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < a; i += RecyclerView.VERTICAL) {
                this.f1507a.dispatchChildDetached(m1768b(i));
            }
            this.f1507a.removeAllViews();
        }

        public void m1770c(int i) {
            View b = m1768b(i);
            if (b != null) {
                C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(b);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt);
                    }
                }
            }
            this.f1507a.detachViewFromParent(i);
        }

        public void m1771c(View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState();
            }
        }

        public void m1772d(View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.6 */
    class C05086 implements C0507a {
        final /* synthetic */ RecyclerView f1508a;

        C05086(RecyclerView recyclerView) {
            this.f1508a = recyclerView;
        }

        public C0532u m1781a(int i) {
            C0532u findViewHolderForPosition = this.f1508a.findViewHolderForPosition(i, true);
            return (findViewHolderForPosition == null || this.f1508a.mChildHelper.m2228c(findViewHolderForPosition.itemView)) ? null : findViewHolderForPosition;
        }

        public void m1782a(int i, int i2) {
            this.f1508a.offsetPositionRecordsForRemove(i, i2, true);
            this.f1508a.mItemsAddedOrRemoved = true;
            C0529r.m1908a(this.f1508a.mState, i2);
        }

        public void m1783a(int i, int i2, Object obj) {
            this.f1508a.viewRangeUpdate(i, i2, obj);
            this.f1508a.mItemsChanged = true;
        }

        public void m1784a(C0604b c0604b) {
            m1788c(c0604b);
        }

        public void m1785b(int i, int i2) {
            this.f1508a.offsetPositionRecordsForRemove(i, i2, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            this.f1508a.mItemsAddedOrRemoved = true;
        }

        public void m1786b(C0604b c0604b) {
            m1788c(c0604b);
        }

        public void m1787c(int i, int i2) {
            this.f1508a.offsetPositionRecordsForInsert(i, i2);
            this.f1508a.mItemsAddedOrRemoved = true;
        }

        void m1788c(C0604b c0604b) {
            switch (c0604b.f2043a) {
                case RecyclerView.VERTICAL /*1*/:
                    this.f1508a.mLayout.onItemsAdded(this.f1508a, c0604b.f2044b, c0604b.f2046d);
                case RecyclerView.SCROLL_STATE_SETTLING /*2*/:
                    this.f1508a.mLayout.onItemsRemoved(this.f1508a, c0604b.f2044b, c0604b.f2046d);
                case SpdyProtocol.QUIC /*4*/:
                    this.f1508a.mLayout.onItemsUpdated(this.f1508a, c0604b.f2044b, c0604b.f2046d, c0604b.f2045c);
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    this.f1508a.mLayout.onItemsMoved(this.f1508a, c0604b.f2044b, c0604b.f2046d, RecyclerView.VERTICAL);
                default:
            }
        }

        public void m1789d(int i, int i2) {
            this.f1508a.offsetPositionRecordsForMove(i, i2);
            this.f1508a.mItemsAddedOrRemoved = true;
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        Parcelable f1509a;

        /* renamed from: android.support.v7.widget.RecyclerView.SavedState.1 */
        static class C05091 implements Creator<SavedState> {
            C05091() {
            }

            public SavedState m1790a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1791a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1790a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1791a(i);
            }
        }

        static {
            CREATOR = new C05091();
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1509a = parcel.readParcelable(C0493h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void m1792a(SavedState savedState) {
            this.f1509a = savedState.f1509a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1509a, RecyclerView.TOUCH_SLOP_DEFAULT);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.a */
    public static abstract class C0510a<VH extends C0532u> {
        private boolean mHasStableIds;
        private final C0511b mObservable;

        public C0510a() {
            this.mObservable = new C0511b();
            this.mHasStableIds = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(RecyclerView.VERTICAL, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            TraceCompat.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
            onCreateViewHolder.mItemViewType = i;
            TraceCompat.endSection();
            return onCreateViewHolder;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return RecyclerView.NO_ID;
        }

        public int getItemViewType(int i) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public final boolean hasObservers() {
            return this.mObservable.m1796a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.m1797b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.m1794a(i, RecyclerView.VERTICAL);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.m1795a(i, RecyclerView.VERTICAL, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.m1798b(i, RecyclerView.VERTICAL);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.m1800d(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.m1794a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.m1795a(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.m1798b(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.m1799c(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.m1799c(i, RecyclerView.VERTICAL);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(C0512c c0512c) {
            this.mObservable.registerObserver(c0512c);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void unregisterAdapterDataObserver(C0512c c0512c) {
            this.mObservable.unregisterObserver(c0512c);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.b */
    static class C0511b extends Observable<C0512c> {
        C0511b() {
        }

        public void m1794a(int i, int i2) {
            m1795a(i, i2, null);
        }

        public void m1795a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0512c) this.mObservers.get(size)).m1804a(i, i2, obj);
            }
        }

        public boolean m1796a() {
            return !this.mObservers.isEmpty() ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void m1797b() {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0512c) this.mObservers.get(size)).m1801a();
            }
        }

        public void m1798b(int i, int i2) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0512c) this.mObservers.get(size)).m1805b(i, i2);
            }
        }

        public void m1799c(int i, int i2) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0512c) this.mObservers.get(size)).m1806c(i, i2);
            }
        }

        public void m1800d(int i, int i2) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0512c) this.mObservers.get(size)).m1803a(i, i2, (int) RecyclerView.VERTICAL);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.c */
    public static abstract class C0512c {
        public void m1801a() {
        }

        public void m1802a(int i, int i2) {
        }

        public void m1803a(int i, int i2, int i3) {
        }

        public void m1804a(int i, int i2, Object obj) {
            m1802a(i, i2);
        }

        public void m1805b(int i, int i2) {
        }

        public void m1806c(int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.d */
    public interface C0513d {
        int m1807a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.e */
    public static abstract class C0517e {
        private C0515b f1514a;
        private ArrayList<C0514a> f1515b;
        private long f1516c;
        private long f1517d;
        private long f1518e;
        private long f1519f;

        /* renamed from: android.support.v7.widget.RecyclerView.e.a */
        public interface C0514a {
            void m1808a();
        }

        /* renamed from: android.support.v7.widget.RecyclerView.e.b */
        interface C0515b {
            void m1809a(C0532u c0532u);
        }

        /* renamed from: android.support.v7.widget.RecyclerView.e.c */
        public static class C0516c {
            public int f1510a;
            public int f1511b;
            public int f1512c;
            public int f1513d;

            public C0516c m1810a(C0532u c0532u) {
                return m1811a(c0532u, RecyclerView.TOUCH_SLOP_DEFAULT);
            }

            public C0516c m1811a(C0532u c0532u, int i) {
                View view = c0532u.itemView;
                this.f1510a = view.getLeft();
                this.f1511b = view.getTop();
                this.f1512c = view.getRight();
                this.f1513d = view.getBottom();
                return this;
            }
        }

        public C0517e() {
            this.f1514a = null;
            this.f1515b = new ArrayList();
            this.f1516c = 120;
            this.f1517d = 120;
            this.f1518e = 250;
            this.f1519f = 250;
        }

        static int m1812d(C0532u c0532u) {
            int access$6500 = c0532u.mFlags & 14;
            if (c0532u.isInvalid()) {
                return 4;
            }
            if ((access$6500 & 4) != 0) {
                return access$6500;
            }
            int oldPosition = c0532u.getOldPosition();
            int adapterPosition = c0532u.getAdapterPosition();
            return (oldPosition == RecyclerView.NO_POSITION || adapterPosition == RecyclerView.NO_POSITION || oldPosition == adapterPosition) ? access$6500 : access$6500 | Message.FLAG_RET;
        }

        public C0516c m1813a(C0529r c0529r, C0532u c0532u) {
            return m1833i().m1810a(c0532u);
        }

        public C0516c m1814a(C0529r c0529r, C0532u c0532u, int i, List<Object> list) {
            return m1833i().m1810a(c0532u);
        }

        public abstract void m1815a();

        void m1816a(C0515b c0515b) {
            this.f1514a = c0515b;
        }

        public abstract boolean m1817a(C0532u c0532u, C0516c c0516c, C0516c c0516c2);

        public abstract boolean m1818a(C0532u c0532u, C0532u c0532u2, C0516c c0516c, C0516c c0516c2);

        public boolean m1819a(C0532u c0532u, List<Object> list) {
            return m1831g(c0532u);
        }

        public abstract boolean m1820b();

        public abstract boolean m1821b(C0532u c0532u, C0516c c0516c, C0516c c0516c2);

        public abstract void m1822c();

        public abstract void m1823c(C0532u c0532u);

        public abstract boolean m1824c(C0532u c0532u, C0516c c0516c, C0516c c0516c2);

        public long m1825d() {
            return this.f1518e;
        }

        public long m1826e() {
            return this.f1516c;
        }

        public final void m1827e(C0532u c0532u) {
            m1829f(c0532u);
            if (this.f1514a != null) {
                this.f1514a.m1809a(c0532u);
            }
        }

        public long m1828f() {
            return this.f1517d;
        }

        public void m1829f(C0532u c0532u) {
        }

        public long m1830g() {
            return this.f1519f;
        }

        public boolean m1831g(C0532u c0532u) {
            return true;
        }

        public final void m1832h() {
            int size = this.f1515b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                ((C0514a) this.f1515b.get(i)).m1808a();
            }
            this.f1515b.clear();
        }

        public C0516c m1833i() {
            return new C0516c();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.f */
    private class C0518f implements C0515b {
        final /* synthetic */ RecyclerView f1520a;

        private C0518f(RecyclerView recyclerView) {
            this.f1520a = recyclerView;
        }

        public void m1834a(C0532u c0532u) {
            c0532u.setIsRecyclable(true);
            if (c0532u.mShadowedHolder != null && c0532u.mShadowingHolder == null) {
                c0532u.mShadowedHolder = null;
            }
            c0532u.mShadowingHolder = null;
            if (!c0532u.shouldBeKeptAsChild() && !this.f1520a.removeAnimatingView(c0532u.itemView) && c0532u.isTmpDetached()) {
                this.f1520a.removeDetachedView(c0532u.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.g */
    public static abstract class C0519g {
        @Deprecated
        public void m1835a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m1836a(Canvas canvas, RecyclerView recyclerView, C0529r c0529r) {
            m1835a(canvas, recyclerView);
        }

        @Deprecated
        public void m1837a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        public void m1838a(Rect rect, View view, RecyclerView recyclerView, C0529r c0529r) {
            m1837a(rect, ((C0491i) view.getLayoutParams()).m1703e(), recyclerView);
        }

        @Deprecated
        public void m1839b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m1840b(Canvas canvas, RecyclerView recyclerView, C0529r c0529r) {
            m1839b(canvas, recyclerView);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.j */
    public interface C0521j {
        void m1841a(View view);

        void m1842b(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.k */
    public interface C0522k {
        void m1843a(boolean z);

        boolean m1844a(RecyclerView recyclerView, MotionEvent motionEvent);

        void m1845b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.l */
    public static abstract class C0523l {
        public void m1846a(RecyclerView recyclerView, int i) {
        }

        public void m1847a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.m */
    public static class C0524m {
        private SparseArray<ArrayList<C0532u>> f1525a;
        private SparseIntArray f1526b;
        private int f1527c;

        public C0524m() {
            this.f1525a = new SparseArray();
            this.f1526b = new SparseIntArray();
            this.f1527c = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        private ArrayList<C0532u> m1848b(int i) {
            ArrayList<C0532u> arrayList = (ArrayList) this.f1525a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1525a.put(i, arrayList);
                if (this.f1526b.indexOfKey(i) < 0) {
                    this.f1526b.put(i, 5);
                }
            }
            return arrayList;
        }

        public C0532u m1849a(int i) {
            ArrayList arrayList = (ArrayList) this.f1525a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() + RecyclerView.NO_POSITION;
            C0532u c0532u = (C0532u) arrayList.get(size);
            arrayList.remove(size);
            return c0532u;
        }

        public void m1850a() {
            this.f1525a.clear();
        }

        void m1851a(C0510a c0510a) {
            this.f1527c += RecyclerView.VERTICAL;
        }

        void m1852a(C0510a c0510a, C0510a c0510a2, boolean z) {
            if (c0510a != null) {
                m1854b();
            }
            if (!z && this.f1527c == 0) {
                m1850a();
            }
            if (c0510a2 != null) {
                m1851a(c0510a2);
            }
        }

        public void m1853a(C0532u c0532u) {
            int itemViewType = c0532u.getItemViewType();
            ArrayList b = m1848b(itemViewType);
            if (this.f1526b.get(itemViewType) > b.size()) {
                c0532u.resetInternal();
                b.add(c0532u);
            }
        }

        void m1854b() {
            this.f1527c += RecyclerView.NO_POSITION;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.n */
    public final class C0525n {
        final ArrayList<C0532u> f1528a;
        final ArrayList<C0532u> f1529b;
        final /* synthetic */ RecyclerView f1530c;
        private ArrayList<C0532u> f1531d;
        private final List<C0532u> f1532e;
        private int f1533f;
        private C0524m f1534g;
        private C0530s f1535h;

        public C0525n(RecyclerView recyclerView) {
            this.f1530c = recyclerView;
            this.f1528a = new ArrayList();
            this.f1531d = null;
            this.f1529b = new ArrayList();
            this.f1532e = Collections.unmodifiableList(this.f1528a);
            this.f1533f = RecyclerView.SCROLL_STATE_SETTLING;
        }

        private void m1856a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() + RecyclerView.NO_POSITION; childCount >= 0; childCount += RecyclerView.NO_POSITION) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m1856a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(RecyclerView.TOUCH_SLOP_DEFAULT);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private void m1857d(View view) {
            if (this.f1530c.isAccessibilityEnabled()) {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, RecyclerView.VERTICAL);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    ViewCompat.setAccessibilityDelegate(view, this.f1530c.mAccessibilityDelegate.m2426a());
                }
            }
        }

        private void m1858f(C0532u c0532u) {
            if (c0532u.itemView instanceof ViewGroup) {
                m1856a((ViewGroup) c0532u.itemView, (boolean) RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
        }

        C0532u m1859a(int i, int i2, boolean z) {
            int i3 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int size = this.f1528a.size();
            int i4 = RecyclerView.TOUCH_SLOP_DEFAULT;
            while (i4 < size) {
                View a;
                C0532u c0532u = (C0532u) this.f1528a.get(i4);
                if (c0532u.wasReturnedFromScrap() || c0532u.getLayoutPosition() != i || c0532u.isInvalid() || (!this.f1530c.mState.f1551h && c0532u.isRemoved())) {
                    i4 += RecyclerView.VERTICAL;
                } else if (i2 == RecyclerView.NO_POSITION || c0532u.getItemViewType() == i2) {
                    c0532u.addFlags(32);
                    return c0532u;
                } else {
                    Log.e(RecyclerView.TAG, "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + c0532u.getItemViewType() + " but expected " + i2 + C4233j.f14397t);
                    if (!z) {
                        a = this.f1530c.mChildHelper.m2216a(i, i2);
                        if (a != null) {
                            c0532u = RecyclerView.getChildViewHolderInt(a);
                            this.f1530c.mChildHelper.m2231e(a);
                            i3 = this.f1530c.mChildHelper.m2224b(a);
                            if (i3 != RecyclerView.NO_POSITION) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0532u);
                            }
                            this.f1530c.mChildHelper.m2229d(i3);
                            m1881c(a);
                            c0532u.addFlags(8224);
                            return c0532u;
                        }
                    }
                    i4 = this.f1529b.size();
                    while (i3 < i4) {
                        c0532u = (C0532u) this.f1529b.get(i3);
                        if (c0532u.isInvalid() || c0532u.getLayoutPosition() != i) {
                            i3 += RecyclerView.VERTICAL;
                        } else if (z) {
                            return c0532u;
                        } else {
                            this.f1529b.remove(i3);
                            return c0532u;
                        }
                    }
                    return null;
                }
            }
            if (z) {
                a = this.f1530c.mChildHelper.m2216a(i, i2);
                if (a != null) {
                    c0532u = RecyclerView.getChildViewHolderInt(a);
                    this.f1530c.mChildHelper.m2231e(a);
                    i3 = this.f1530c.mChildHelper.m2224b(a);
                    if (i3 != RecyclerView.NO_POSITION) {
                        this.f1530c.mChildHelper.m2229d(i3);
                        m1881c(a);
                        c0532u.addFlags(8224);
                        return c0532u;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0532u);
                }
            }
            i4 = this.f1529b.size();
            while (i3 < i4) {
                c0532u = (C0532u) this.f1529b.get(i3);
                if (c0532u.isInvalid()) {
                }
                i3 += RecyclerView.VERTICAL;
            }
            return null;
        }

        C0532u m1860a(long j, int i, boolean z) {
            int size;
            for (size = this.f1528a.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                C0532u c0532u = (C0532u) this.f1528a.get(size);
                if (c0532u.getItemId() == j && !c0532u.wasReturnedFromScrap()) {
                    if (i == c0532u.getItemViewType()) {
                        c0532u.addFlags(32);
                        if (!c0532u.isRemoved() || this.f1530c.mState.m1925a()) {
                            return c0532u;
                        }
                        c0532u.setFlags(RecyclerView.SCROLL_STATE_SETTLING, 14);
                        return c0532u;
                    } else if (!z) {
                        this.f1528a.remove(size);
                        this.f1530c.removeDetachedView(c0532u.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                        m1876b(c0532u.itemView);
                    }
                }
            }
            for (size = this.f1529b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                c0532u = (C0532u) this.f1529b.get(size);
                if (c0532u.getItemId() == j) {
                    if (i == c0532u.getItemViewType()) {
                        if (z) {
                            return c0532u;
                        }
                        this.f1529b.remove(size);
                        return c0532u;
                    } else if (!z) {
                        m1883d(size);
                    }
                }
            }
            return null;
        }

        View m1861a(int i, boolean z) {
            boolean z2 = true;
            if (i < 0 || i >= this.f1530c.mState.m1929e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + C4233j.f14396s + i + "). Item count:" + this.f1530c.mState.m1929e());
            }
            C0532u f;
            boolean z3;
            C0532u c0532u;
            boolean z4;
            int b;
            boolean z5;
            int b2;
            LayoutParams layoutParams;
            C0491i c0491i;
            if (this.f1530c.mState.m1925a()) {
                f = m1889f(i);
                C0532u c0532u2 = f;
                z3 = f != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                c0532u = c0532u2;
            } else {
                c0532u = null;
                z3 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            if (c0532u == null) {
                c0532u = m1859a(i, (int) RecyclerView.NO_POSITION, z);
                if (c0532u != null) {
                    if (m1870a(c0532u)) {
                        z4 = true;
                    } else {
                        if (!z) {
                            c0532u.addFlags(4);
                            if (c0532u.isScrap()) {
                                this.f1530c.removeDetachedView(c0532u.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                                c0532u.unScrap();
                            } else if (c0532u.wasReturnedFromScrap()) {
                                c0532u.clearReturnedFromScrapFlag();
                            }
                            m1875b(c0532u);
                        }
                        c0532u = null;
                        z4 = z3;
                    }
                    if (c0532u == null) {
                        b = this.f1530c.mAdapterHelper.m2633b(i);
                        if (b >= 0 || b >= this.f1530c.mAdapter.getItemCount()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1530c.mState.m1929e());
                        }
                        int itemViewType = this.f1530c.mAdapter.getItemViewType(b);
                        if (this.f1530c.mAdapter.hasStableIds()) {
                            c0532u = m1860a(this.f1530c.mAdapter.getItemId(b), itemViewType, z);
                            if (c0532u != null) {
                                c0532u.mPosition = b;
                                z4 = true;
                            }
                        }
                        if (c0532u == null && this.f1535h != null) {
                            View a = this.f1535h.m1930a(this, i, itemViewType);
                            if (a != null) {
                                c0532u = this.f1530c.getChildViewHolder(a);
                                if (c0532u == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (c0532u.shouldIgnore()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (c0532u == null) {
                            c0532u = m1888f().m1849a(itemViewType);
                            if (c0532u != null) {
                                c0532u.resetInternal();
                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    m1858f(c0532u);
                                }
                            }
                        }
                        if (c0532u == null) {
                            f = this.f1530c.mAdapter.createViewHolder(this.f1530c, itemViewType);
                            z5 = z4;
                            if (z5 && !this.f1530c.mState.m1925a() && f.hasAnyOfTheFlags(SpdyProtocol.SLIGHTSSL_1_RTT_MODE)) {
                                f.setFlags(RecyclerView.TOUCH_SLOP_DEFAULT, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                                if (this.f1530c.mState.f1552i) {
                                    this.f1530c.recordAnimationInfoIfBouncedHiddenView(f, this.f1530c.mItemAnimator.m1814a(this.f1530c.mState, f, C0517e.m1812d(f) | SpdyProtocol.SLIGHTSSL_0_RTT_MODE, f.getUnmodifiedPayloads()));
                                }
                            }
                            if (!this.f1530c.mState.m1925a() && f.isBound()) {
                                f.mPreLayoutPosition = i;
                                z4 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                            } else if (f.isBound() || f.needsUpdate() || f.isInvalid()) {
                                b2 = this.f1530c.mAdapterHelper.m2633b(i);
                                f.mOwnerRecyclerView = this.f1530c;
                                this.f1530c.mAdapter.bindViewHolder(f, b2);
                                m1857d(f.itemView);
                                if (this.f1530c.mState.m1925a()) {
                                    f.mPreLayoutPosition = i;
                                }
                                z4 = true;
                            } else {
                                z4 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                            }
                            layoutParams = f.itemView.getLayoutParams();
                            if (layoutParams != null) {
                                c0491i = (C0491i) this.f1530c.generateDefaultLayoutParams();
                                f.itemView.setLayoutParams(c0491i);
                            } else if (this.f1530c.checkLayoutParams(layoutParams)) {
                                c0491i = (C0491i) layoutParams;
                            } else {
                                c0491i = (C0491i) this.f1530c.generateLayoutParams(layoutParams);
                                f.itemView.setLayoutParams(c0491i);
                            }
                            c0491i.f1466a = f;
                            if (!(z5 && r3)) {
                                z2 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                            }
                            c0491i.f1469d = z2;
                            return f.itemView;
                        }
                    }
                    f = c0532u;
                    z5 = z4;
                    f.setFlags(RecyclerView.TOUCH_SLOP_DEFAULT, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                    if (this.f1530c.mState.f1552i) {
                        this.f1530c.recordAnimationInfoIfBouncedHiddenView(f, this.f1530c.mItemAnimator.m1814a(this.f1530c.mState, f, C0517e.m1812d(f) | SpdyProtocol.SLIGHTSSL_0_RTT_MODE, f.getUnmodifiedPayloads()));
                    }
                    if (!this.f1530c.mState.m1925a()) {
                    }
                    if (f.isBound()) {
                    }
                    b2 = this.f1530c.mAdapterHelper.m2633b(i);
                    f.mOwnerRecyclerView = this.f1530c;
                    this.f1530c.mAdapter.bindViewHolder(f, b2);
                    m1857d(f.itemView);
                    if (this.f1530c.mState.m1925a()) {
                        f.mPreLayoutPosition = i;
                    }
                    z4 = true;
                    layoutParams = f.itemView.getLayoutParams();
                    if (layoutParams != null) {
                        c0491i = (C0491i) this.f1530c.generateDefaultLayoutParams();
                        f.itemView.setLayoutParams(c0491i);
                    } else if (this.f1530c.checkLayoutParams(layoutParams)) {
                        c0491i = (C0491i) layoutParams;
                    } else {
                        c0491i = (C0491i) this.f1530c.generateLayoutParams(layoutParams);
                        f.itemView.setLayoutParams(c0491i);
                    }
                    c0491i.f1466a = f;
                    z2 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                    c0491i.f1469d = z2;
                    return f.itemView;
                }
            }
            z4 = z3;
            if (c0532u == null) {
                b = this.f1530c.mAdapterHelper.m2633b(i);
                if (b >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1530c.mState.m1929e());
            }
            f = c0532u;
            z5 = z4;
            f.setFlags(RecyclerView.TOUCH_SLOP_DEFAULT, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            if (this.f1530c.mState.f1552i) {
                this.f1530c.recordAnimationInfoIfBouncedHiddenView(f, this.f1530c.mItemAnimator.m1814a(this.f1530c.mState, f, C0517e.m1812d(f) | SpdyProtocol.SLIGHTSSL_0_RTT_MODE, f.getUnmodifiedPayloads()));
            }
            if (!this.f1530c.mState.m1925a()) {
            }
            if (f.isBound()) {
            }
            b2 = this.f1530c.mAdapterHelper.m2633b(i);
            f.mOwnerRecyclerView = this.f1530c;
            this.f1530c.mAdapter.bindViewHolder(f, b2);
            m1857d(f.itemView);
            if (this.f1530c.mState.m1925a()) {
                f.mPreLayoutPosition = i;
            }
            z4 = true;
            layoutParams = f.itemView.getLayoutParams();
            if (layoutParams != null) {
                c0491i = (C0491i) this.f1530c.generateDefaultLayoutParams();
                f.itemView.setLayoutParams(c0491i);
            } else if (this.f1530c.checkLayoutParams(layoutParams)) {
                c0491i = (C0491i) this.f1530c.generateLayoutParams(layoutParams);
                f.itemView.setLayoutParams(c0491i);
            } else {
                c0491i = (C0491i) layoutParams;
            }
            c0491i.f1466a = f;
            z2 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            c0491i.f1469d = z2;
            return f.itemView;
        }

        public void m1862a() {
            this.f1528a.clear();
            m1878c();
        }

        public void m1863a(int i) {
            this.f1533f = i;
            for (int size = this.f1529b.size() + RecyclerView.NO_POSITION; size >= 0 && this.f1529b.size() > i; size += RecyclerView.NO_POSITION) {
                m1883d(size);
            }
        }

        void m1864a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = RecyclerView.NO_POSITION;
                i4 = i2;
                i5 = i;
            } else {
                i3 = RecyclerView.VERTICAL;
                i4 = i;
                i5 = i2;
            }
            int size = this.f1529b.size();
            for (int i6 = RecyclerView.TOUCH_SLOP_DEFAULT; i6 < size; i6 += RecyclerView.VERTICAL) {
                C0532u c0532u = (C0532u) this.f1529b.get(i6);
                if (c0532u != null && c0532u.mPosition >= r3 && c0532u.mPosition <= r2) {
                    if (c0532u.mPosition == i) {
                        c0532u.offsetPosition(i2 - i, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    } else {
                        c0532u.offsetPosition(i3, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    }
                }
            }
        }

        void m1865a(C0510a c0510a, C0510a c0510a2, boolean z) {
            m1862a();
            m1888f().m1852a(c0510a, c0510a2, z);
        }

        void m1866a(C0524m c0524m) {
            if (this.f1534g != null) {
                this.f1534g.m1854b();
            }
            this.f1534g = c0524m;
            if (c0524m != null) {
                this.f1534g.m1851a(this.f1530c.getAdapter());
            }
        }

        void m1867a(C0530s c0530s) {
            this.f1535h = c0530s;
        }

        public void m1868a(View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                this.f1530c.removeDetachedView(view, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            m1875b(childViewHolderInt);
        }

        public void m1869a(View view, int i) {
            boolean z = true;
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int b = this.f1530c.mAdapterHelper.m2633b(i);
            if (b < 0 || b >= this.f1530c.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1530c.mState.m1929e());
            }
            C0491i c0491i;
            childViewHolderInt.mOwnerRecyclerView = this.f1530c;
            this.f1530c.mAdapter.bindViewHolder(childViewHolderInt, b);
            m1857d(view);
            if (this.f1530c.mState.m1925a()) {
                childViewHolderInt.mPreLayoutPosition = i;
            }
            LayoutParams layoutParams = childViewHolderInt.itemView.getLayoutParams();
            if (layoutParams == null) {
                c0491i = (C0491i) this.f1530c.generateDefaultLayoutParams();
                childViewHolderInt.itemView.setLayoutParams(c0491i);
            } else if (this.f1530c.checkLayoutParams(layoutParams)) {
                c0491i = (C0491i) layoutParams;
            } else {
                c0491i = (C0491i) this.f1530c.generateLayoutParams(layoutParams);
                childViewHolderInt.itemView.setLayoutParams(c0491i);
            }
            c0491i.f1468c = true;
            c0491i.f1466a = childViewHolderInt;
            if (childViewHolderInt.itemView.getParent() != null) {
                z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            c0491i.f1469d = z;
        }

        boolean m1870a(C0532u c0532u) {
            if (c0532u.isRemoved()) {
                return this.f1530c.mState.m1925a();
            }
            if (c0532u.mPosition >= 0 && c0532u.mPosition < this.f1530c.mAdapter.getItemCount()) {
                return (this.f1530c.mState.m1925a() || this.f1530c.mAdapter.getItemViewType(c0532u.mPosition) == c0532u.getItemViewType()) ? (!this.f1530c.mAdapter.hasStableIds() || c0532u.getItemId() == this.f1530c.mAdapter.getItemId(c0532u.mPosition)) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            } else {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0532u);
            }
        }

        public int m1871b(int i) {
            if (i >= 0 && i < this.f1530c.mState.m1929e()) {
                return !this.f1530c.mState.m1925a() ? i : this.f1530c.mAdapterHelper.m2633b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f1530c.mState.m1929e());
            }
        }

        public List<C0532u> m1872b() {
            return this.f1532e;
        }

        void m1873b(int i, int i2) {
            int size = this.f1529b.size();
            for (int i3 = RecyclerView.TOUCH_SLOP_DEFAULT; i3 < size; i3 += RecyclerView.VERTICAL) {
                C0532u c0532u = (C0532u) this.f1529b.get(i3);
                if (c0532u != null && c0532u.mPosition >= i) {
                    c0532u.offsetPosition(i2, true);
                }
            }
        }

        void m1874b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1529b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                C0532u c0532u = (C0532u) this.f1529b.get(size);
                if (c0532u != null) {
                    if (c0532u.mPosition >= i3) {
                        c0532u.offsetPosition(-i2, z);
                    } else if (c0532u.mPosition >= i) {
                        c0532u.addFlags(8);
                        m1883d(size);
                    }
                }
            }
        }

        void m1875b(C0532u c0532u) {
            boolean z = true;
            int i = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (c0532u.isScrap() || c0532u.itemView.getParent() != null) {
                StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(c0532u.isScrap()).append(" isAttached:");
                if (c0532u.itemView.getParent() == null) {
                    z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (c0532u.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0532u);
            } else if (c0532u.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int i2;
                boolean access$4900 = c0532u.doesTransientStatePreventRecycling();
                boolean z2 = (this.f1530c.mAdapter != null && access$4900 && this.f1530c.mAdapter.onFailedToRecycleView(c0532u)) ? true : RecyclerView.TOUCH_SLOP_DEFAULT;
                if (z2 || c0532u.isRecyclable()) {
                    if (!c0532u.hasAnyOfTheFlags(14)) {
                        int size = this.f1529b.size();
                        if (size == this.f1533f && size > 0) {
                            m1883d((int) RecyclerView.TOUCH_SLOP_DEFAULT);
                        }
                        if (size < this.f1533f) {
                            this.f1529b.add(c0532u);
                            z2 = true;
                            if (z2) {
                                m1880c(c0532u);
                                i = RecyclerView.VERTICAL;
                                i2 = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                    if (z2) {
                        z = z2;
                    } else {
                        m1880c(c0532u);
                        i = RecyclerView.VERTICAL;
                        i2 = z2;
                    }
                } else {
                    i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
                this.f1530c.mViewInfoStore.m2587g(c0532u);
                if (i2 == 0 && r1 == 0 && access$4900) {
                    c0532u.mOwnerRecyclerView = null;
                }
            }
        }

        void m1876b(View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            childViewHolderInt.clearReturnedFromScrapFlag();
            m1875b(childViewHolderInt);
        }

        public View m1877c(int i) {
            return m1861a(i, (boolean) RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        void m1878c() {
            for (int size = this.f1529b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                m1883d(size);
            }
            this.f1529b.clear();
        }

        void m1879c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.f1529b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                C0532u c0532u = (C0532u) this.f1529b.get(size);
                if (c0532u != null) {
                    int layoutPosition = c0532u.getLayoutPosition();
                    if (layoutPosition >= i && layoutPosition < i3) {
                        c0532u.addFlags(RecyclerView.SCROLL_STATE_SETTLING);
                        m1883d(size);
                    }
                }
            }
        }

        void m1880c(C0532u c0532u) {
            ViewCompat.setAccessibilityDelegate(c0532u.itemView, null);
            m1887e(c0532u);
            c0532u.mOwnerRecyclerView = null;
            m1888f().m1853a(c0532u);
        }

        void m1881c(View view) {
            C0532u childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !this.f1530c.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f1531d == null) {
                    this.f1531d = new ArrayList();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f1531d.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.f1530c.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                this.f1528a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        int m1882d() {
            return this.f1528a.size();
        }

        void m1883d(int i) {
            m1880c((C0532u) this.f1529b.get(i));
            this.f1529b.remove(i);
        }

        void m1884d(C0532u c0532u) {
            if (c0532u.mInChangeScrap) {
                this.f1531d.remove(c0532u);
            } else {
                this.f1528a.remove(c0532u);
            }
            c0532u.mScrapContainer = null;
            c0532u.mInChangeScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            c0532u.clearReturnedFromScrapFlag();
        }

        View m1885e(int i) {
            return ((C0532u) this.f1528a.get(i)).itemView;
        }

        void m1886e() {
            this.f1528a.clear();
            if (this.f1531d != null) {
                this.f1531d.clear();
            }
        }

        void m1887e(C0532u c0532u) {
            if (this.f1530c.mRecyclerListener != null) {
                this.f1530c.mRecyclerListener.m1894a(c0532u);
            }
            if (this.f1530c.mAdapter != null) {
                this.f1530c.mAdapter.onViewRecycled(c0532u);
            }
            if (this.f1530c.mState != null) {
                this.f1530c.mViewInfoStore.m2587g(c0532u);
            }
        }

        C0524m m1888f() {
            if (this.f1534g == null) {
                this.f1534g = new C0524m();
            }
            return this.f1534g;
        }

        C0532u m1889f(int i) {
            int i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (this.f1531d != null) {
                int size = this.f1531d.size();
                if (size != 0) {
                    C0532u c0532u;
                    int i3 = RecyclerView.TOUCH_SLOP_DEFAULT;
                    while (i3 < size) {
                        c0532u = (C0532u) this.f1531d.get(i3);
                        if (c0532u.wasReturnedFromScrap() || c0532u.getLayoutPosition() != i) {
                            i3 += RecyclerView.VERTICAL;
                        } else {
                            c0532u.addFlags(32);
                            return c0532u;
                        }
                    }
                    if (this.f1530c.mAdapter.hasStableIds()) {
                        int b = this.f1530c.mAdapterHelper.m2633b(i);
                        if (b > 0 && b < this.f1530c.mAdapter.getItemCount()) {
                            long itemId = this.f1530c.mAdapter.getItemId(b);
                            while (i2 < size) {
                                c0532u = (C0532u) this.f1531d.get(i2);
                                if (c0532u.wasReturnedFromScrap() || c0532u.getItemId() != itemId) {
                                    i2 += RecyclerView.VERTICAL;
                                } else {
                                    c0532u.addFlags(32);
                                    return c0532u;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        void m1890g() {
            int size = this.f1529b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                C0532u c0532u = (C0532u) this.f1529b.get(i);
                if (c0532u != null) {
                    c0532u.addFlags(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY);
                }
            }
        }

        void m1891h() {
            if (this.f1530c.mAdapter == null || !this.f1530c.mAdapter.hasStableIds()) {
                m1878c();
                return;
            }
            int size = this.f1529b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                C0532u c0532u = (C0532u) this.f1529b.get(i);
                if (c0532u != null) {
                    c0532u.addFlags(6);
                    c0532u.addChangePayload(null);
                }
            }
        }

        void m1892i() {
            int i;
            int i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int size = this.f1529b.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                ((C0532u) this.f1529b.get(i)).clearOldPosition();
            }
            size = this.f1528a.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                ((C0532u) this.f1528a.get(i)).clearOldPosition();
            }
            if (this.f1531d != null) {
                i = this.f1531d.size();
                while (i2 < i) {
                    ((C0532u) this.f1531d.get(i2)).clearOldPosition();
                    i2 += RecyclerView.VERTICAL;
                }
            }
        }

        void m1893j() {
            int size = this.f1529b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                C0491i c0491i = (C0491i) ((C0532u) this.f1529b.get(i)).itemView.getLayoutParams();
                if (c0491i != null) {
                    c0491i.f1468c = true;
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.o */
    public interface C0526o {
        void m1894a(C0532u c0532u);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.p */
    private class C0527p extends C0512c {
        final /* synthetic */ RecyclerView f1536a;

        private C0527p(RecyclerView recyclerView) {
            this.f1536a = recyclerView;
        }

        public void m1895a() {
            this.f1536a.assertNotInLayoutOrScroll(null);
            if (this.f1536a.mAdapter.hasStableIds()) {
                this.f1536a.mState.f1550g = true;
                this.f1536a.setDataSetChangedAfterLayout();
            } else {
                this.f1536a.mState.f1550g = true;
                this.f1536a.setDataSetChangedAfterLayout();
            }
            if (!this.f1536a.mAdapterHelper.m2639d()) {
                this.f1536a.requestLayout();
            }
        }

        public void m1896a(int i, int i2, int i3) {
            this.f1536a.assertNotInLayoutOrScroll(null);
            if (this.f1536a.mAdapterHelper.m2631a(i, i2, i3)) {
                m1898b();
            }
        }

        public void m1897a(int i, int i2, Object obj) {
            this.f1536a.assertNotInLayoutOrScroll(null);
            if (this.f1536a.mAdapterHelper.m2632a(i, i2, obj)) {
                m1898b();
            }
        }

        void m1898b() {
            if (this.f1536a.mPostUpdatesOnAnimation && this.f1536a.mHasFixedSize && this.f1536a.mIsAttached) {
                ViewCompat.postOnAnimation(this.f1536a, this.f1536a.mUpdateChildViewsRunnable);
                return;
            }
            this.f1536a.mAdapterUpdateDuringMeasure = true;
            this.f1536a.requestLayout();
        }

        public void m1899b(int i, int i2) {
            this.f1536a.assertNotInLayoutOrScroll(null);
            if (this.f1536a.mAdapterHelper.m2635b(i, i2)) {
                m1898b();
            }
        }

        public void m1900c(int i, int i2) {
            this.f1536a.assertNotInLayoutOrScroll(null);
            if (this.f1536a.mAdapterHelper.m2638c(i, i2)) {
                m1898b();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.r */
    public static class C0529r {
        int f1544a;
        private int f1545b;
        private int f1546c;
        private SparseArray<Object> f1547d;
        private int f1548e;
        private int f1549f;
        private boolean f1550g;
        private boolean f1551h;
        private boolean f1552i;
        private boolean f1553j;
        private boolean f1554k;
        private boolean f1555l;

        public C0529r() {
            this.f1545b = RecyclerView.NO_POSITION;
            this.f1546c = RecyclerView.VERTICAL;
            this.f1544a = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1548e = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1549f = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1550g = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1551h = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1552i = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1553j = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1554k = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1555l = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        static /* synthetic */ int m1908a(C0529r c0529r, int i) {
            int i2 = c0529r.f1549f + i;
            c0529r.f1549f = i2;
            return i2;
        }

        void m1924a(int i) {
            if ((this.f1546c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1546c));
            }
        }

        public boolean m1925a() {
            return this.f1551h;
        }

        public boolean m1926b() {
            return this.f1553j;
        }

        public int m1927c() {
            return this.f1545b;
        }

        public boolean m1928d() {
            return this.f1545b != RecyclerView.NO_POSITION ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m1929e() {
            return this.f1551h ? this.f1548e - this.f1549f : this.f1544a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1545b + ", mData=" + this.f1547d + ", mItemCount=" + this.f1544a + ", mPreviousLayoutItemCount=" + this.f1548e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1549f + ", mStructureChanged=" + this.f1550g + ", mInPreLayout=" + this.f1551h + ", mRunSimpleAnimations=" + this.f1552i + ", mRunPredictiveAnimations=" + this.f1553j + '}';
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.s */
    public static abstract class C0530s {
        public abstract View m1930a(C0525n c0525n, int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.t */
    private class C0531t implements Runnable {
        final /* synthetic */ RecyclerView f1556a;
        private int f1557b;
        private int f1558c;
        private ScrollerCompat f1559d;
        private Interpolator f1560e;
        private boolean f1561f;
        private boolean f1562g;

        public C0531t(RecyclerView recyclerView) {
            this.f1556a = recyclerView;
            this.f1560e = RecyclerView.sQuinticInterpolator;
            this.f1561f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1562g = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1559d = ScrollerCompat.create(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private float m1931a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m1932b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? RecyclerView.VERTICAL : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.f1556a.getWidth() : this.f1556a.getHeight();
            int i5 = width / RecyclerView.SCROLL_STATE_SETTLING;
            float a = (m1931a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, RecyclerView.MAX_SCROLL_DURATION);
        }

        private void m1933c() {
            this.f1562g = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1561f = true;
        }

        private void m1934d() {
            this.f1561f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.f1562g) {
                m1935a();
            }
        }

        void m1935a() {
            if (this.f1561f) {
                this.f1562g = true;
                return;
            }
            this.f1556a.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.f1556a, this);
        }

        public void m1936a(int i, int i2) {
            this.f1556a.setScrollState(RecyclerView.SCROLL_STATE_SETTLING);
            this.f1558c = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1557b = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1559d.fling(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, i, i2, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
            m1935a();
        }

        public void m1937a(int i, int i2, int i3) {
            m1939a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        public void m1938a(int i, int i2, int i3, int i4) {
            m1937a(i, i2, m1932b(i, i2, i3, i4));
        }

        public void m1939a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1560e != interpolator) {
                this.f1560e = interpolator;
                this.f1559d = ScrollerCompat.create(this.f1556a.getContext(), interpolator);
            }
            this.f1556a.setScrollState(RecyclerView.SCROLL_STATE_SETTLING);
            this.f1558c = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1557b = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1559d.startScroll(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, i, i2, i3);
            m1935a();
        }

        public void m1940b() {
            this.f1556a.removeCallbacks(this);
            this.f1559d.abortAnimation();
        }

        public void m1941b(int i, int i2) {
            m1938a(i, i2, (int) RecyclerView.TOUCH_SLOP_DEFAULT, (int) RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        public void run() {
            if (this.f1556a.mLayout == null) {
                m1940b();
                return;
            }
            m1933c();
            this.f1556a.consumePendingUpdateOperations();
            ScrollerCompat scrollerCompat = this.f1559d;
            C0494q c0494q = this.f1556a.mLayout.mSmoothScroller;
            if (scrollerCompat.computeScrollOffset()) {
                int e;
                int i;
                int currVelocity;
                int i2;
                Object obj;
                Object obj2;
                int currX = scrollerCompat.getCurrX();
                int currY = scrollerCompat.getCurrY();
                int i3 = currX - this.f1557b;
                int i4 = currY - this.f1558c;
                int i5 = RecyclerView.TOUCH_SLOP_DEFAULT;
                int i6 = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.f1557b = currX;
                this.f1558c = currY;
                int i7 = RecyclerView.TOUCH_SLOP_DEFAULT;
                int i8 = RecyclerView.TOUCH_SLOP_DEFAULT;
                if (this.f1556a.mAdapter != null) {
                    this.f1556a.eatRequestLayout();
                    this.f1556a.onEnterLayoutOrScroll();
                    TraceCompat.beginSection(RecyclerView.TRACE_SCROLL_TAG);
                    if (i3 != 0) {
                        i5 = this.f1556a.mLayout.scrollHorizontallyBy(i3, this.f1556a.mRecycler, this.f1556a.mState);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.f1556a.mLayout.scrollVerticallyBy(i4, this.f1556a.mRecycler, this.f1556a.mState);
                        i8 = i4 - i6;
                    }
                    TraceCompat.endSection();
                    this.f1556a.repositionShadowingViews();
                    this.f1556a.onExitLayoutOrScroll();
                    this.f1556a.resumeRequestLayout(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    if (!(c0494q == null || c0494q.isPendingInitialRun() || !c0494q.isRunning())) {
                        e = this.f1556a.mState.m1929e();
                        if (e == 0) {
                            c0494q.stop();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (c0494q.getTargetPosition() >= e) {
                            c0494q.setTargetPosition(e + RecyclerView.NO_POSITION);
                            c0494q.onAnimation(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            c0494q.onAnimation(i3 - i7, i4 - i8);
                        }
                        if (!this.f1556a.mItemDecorations.isEmpty()) {
                            this.f1556a.invalidate();
                        }
                        if (ViewCompat.getOverScrollMode(this.f1556a) != RecyclerView.SCROLL_STATE_SETTLING) {
                            this.f1556a.considerReleasingGlowsOnScroll(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            currVelocity = (int) scrollerCompat.getCurrVelocity();
                            if (i6 == currX) {
                                e = i6 >= 0 ? -currVelocity : i6 <= 0 ? currVelocity : RecyclerView.TOUCH_SLOP_DEFAULT;
                                i2 = e;
                            } else {
                                i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                            }
                            if (i8 != currY) {
                                currVelocity = RecyclerView.TOUCH_SLOP_DEFAULT;
                            } else if (i8 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i8 <= 0) {
                                currVelocity = RecyclerView.TOUCH_SLOP_DEFAULT;
                            }
                            if (ViewCompat.getOverScrollMode(this.f1556a) != RecyclerView.SCROLL_STATE_SETTLING) {
                                this.f1556a.absorbGlows(i2, currVelocity);
                            }
                            if ((i2 != 0 || i6 == currX || scrollerCompat.getFinalX() == 0) && (currVelocity != 0 || i8 == currY || scrollerCompat.getFinalY() == 0)) {
                                scrollerCompat.abortAnimation();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.f1556a.dispatchOnScrolled(i5, i7);
                        }
                        if (!this.f1556a.awakenScrollBars()) {
                            this.f1556a.invalidate();
                        }
                        obj = (i4 == 0 && this.f1556a.mLayout.canScrollVertically() && i7 == i4) ? RecyclerView.VERTICAL : RecyclerView.TOUCH_SLOP_DEFAULT;
                        obj2 = (i3 == 0 && this.f1556a.mLayout.canScrollHorizontally() && i5 == i3) ? RecyclerView.VERTICAL : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : RecyclerView.VERTICAL;
                        if (!scrollerCompat.isFinished() || obj2 == null) {
                            this.f1556a.setScrollState(RecyclerView.TOUCH_SLOP_DEFAULT);
                        } else {
                            m1935a();
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.f1556a.mItemDecorations.isEmpty()) {
                    this.f1556a.invalidate();
                }
                if (ViewCompat.getOverScrollMode(this.f1556a) != RecyclerView.SCROLL_STATE_SETTLING) {
                    this.f1556a.considerReleasingGlowsOnScroll(i3, i4);
                }
                currVelocity = (int) scrollerCompat.getCurrVelocity();
                if (i6 == currX) {
                    i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = e;
                }
                if (i8 != currY) {
                    currVelocity = RecyclerView.TOUCH_SLOP_DEFAULT;
                } else if (i8 < 0) {
                    currVelocity = -currVelocity;
                } else if (i8 <= 0) {
                    currVelocity = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
                if (ViewCompat.getOverScrollMode(this.f1556a) != RecyclerView.SCROLL_STATE_SETTLING) {
                    this.f1556a.absorbGlows(i2, currVelocity);
                }
                scrollerCompat.abortAnimation();
                this.f1556a.dispatchOnScrolled(i5, i7);
                if (this.f1556a.awakenScrollBars()) {
                    this.f1556a.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (scrollerCompat.isFinished()) {
                }
                this.f1556a.setScrollState(RecyclerView.TOUCH_SLOP_DEFAULT);
            }
            if (c0494q != null) {
                if (c0494q.isPendingInitialRun()) {
                    c0494q.onAnimation(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
                }
                if (!this.f1562g) {
                    c0494q.stop();
                }
            }
            m1934d();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.u */
    public static abstract class C0532u {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS;
        public final View itemView;
        private int mFlags;
        private boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;
        int mPosition;
        int mPreLayoutPosition;
        private C0525n mScrapContainer;
        C0532u mShadowedHolder;
        C0532u mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        static {
            FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        }

        public C0532u(View view) {
            this.mPosition = RecyclerView.NO_POSITION;
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mItemId = RecyclerView.NO_ID;
            this.mItemViewType = RecyclerView.NO_POSITION;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mScrapContainer = null;
            this.mInChangeScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mWasImportantForAccessibilityBeforeHidden = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        private boolean doesTransientStatePreventRecycling() {
            return ((this.mFlags & FLAG_NOT_RECYCLABLE) == 0 && ViewCompat.hasTransientState(this.itemView)) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        private void onEnteredHiddenState() {
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            ViewCompat.setImportantForAccessibility(this.itemView, FLAG_INVALID);
        }

        private void onLeftHiddenState() {
            ViewCompat.setImportantForAccessibility(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        private boolean shouldBeKeptAsChild() {
            return (this.mFlags & FLAG_NOT_RECYCLABLE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i) {
            this.mFlags |= i;
        }

        void clearOldPosition() {
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
        }

        void clearPayload() {
            if (this.mPayloads != null) {
                this.mPayloads.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(FLAG_REMOVED);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            return this.mOwnerRecyclerView == null ? RecyclerView.NO_POSITION : this.mOwnerRecyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            return this.mPreLayoutPosition == RecyclerView.NO_POSITION ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            return this.mPreLayoutPosition == RecyclerView.NO_POSITION ? this.mPosition : this.mPreLayoutPosition;
        }

        List<Object> getUnmodifiedPayloads() {
            return (this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0 ? (this.mPayloads == null || this.mPayloads.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads : FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (this.mFlags & i) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isAdapterPositionUnknown() {
            return ((this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid()) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isBound() {
            return (this.mFlags & FLAG_BOUND) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isInvalid() {
            return (this.mFlags & FLAG_INVALID) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public final boolean isRecyclable() {
            return ((this.mFlags & FLAG_NOT_RECYCLABLE) != 0 || ViewCompat.hasTransientState(this.itemView)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        boolean isRemoved() {
            return (this.mFlags & FLAG_REMOVED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isScrap() {
            return this.mScrapContainer != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isUpdated() {
            return (this.mFlags & FLAG_UPDATE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean needsUpdate() {
            return (this.mFlags & FLAG_UPDATE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == RecyclerView.NO_POSITION) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == RecyclerView.NO_POSITION) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((C0491i) this.itemView.getLayoutParams()).f1468c = true;
            }
        }

        void resetInternal() {
            this.mFlags = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mPosition = RecyclerView.NO_POSITION;
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mItemId = RecyclerView.NO_ID;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
            this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        void saveOldPosition() {
            if (this.mOldPosition == RecyclerView.NO_POSITION) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i, int i2) {
            this.mFlags = (this.mFlags & (i2 ^ RecyclerView.NO_POSITION)) | (i & i2);
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount + RecyclerView.NO_POSITION : this.mIsRecyclableCount + FLAG_BOUND;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.mIsRecyclableCount == FLAG_BOUND) {
                this.mFlags |= FLAG_NOT_RECYCLABLE;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(C0525n c0525n, boolean z) {
            this.mScrapContainer = c0525n;
            this.mInChangeScrap = z;
        }

        boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                stringBuilder.append(" scrap ").append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (needsUpdate()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (shouldIgnore()) {
                stringBuilder.append(" ignored");
            }
            if (isTmpDetached()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                stringBuilder.append(" not recyclable(" + this.mIsRecyclableCount + C4233j.f14397t);
            }
            if (isAdapterPositionUnknown()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        void unScrap() {
            this.mScrapContainer.m1884d(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & FLAG_RETURNED_FROM_SCRAP) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    static {
        int[] iArr = new int[VERTICAL];
        iArr[TOUCH_SLOP_DEFAULT] = 16843830;
        NESTED_SCROLLING_ATTRS = iArr;
        boolean z = (VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        FORCE_INVALIDATE_DISPLAY_LIST = z;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = VERSION.SDK_INT >= 23 ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new C05023();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TOUCH_SLOP_DEFAULT);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.mObserver = new C0527p();
        this.mRecycler = new C0525n(this);
        this.mViewInfoStore = new bk();
        this.mUpdateChildViewsRunnable = new C05001(this);
        this.mTempRect = new Rect();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mEatRequestLayout = TOUCH_SLOP_DEFAULT;
        this.mDataSetHasChangedAfterLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayoutOrScrollCounter = TOUCH_SLOP_DEFAULT;
        this.mItemAnimator = new aj();
        this.mScrollState = TOUCH_SLOP_DEFAULT;
        this.mScrollPointerId = NO_POSITION;
        this.mScrollFactor = Float.MIN_VALUE;
        this.mViewFlinger = new C0531t(this);
        this.mState = new C0529r();
        this.mItemsAddedOrRemoved = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemsChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemAnimatorListener = new C0518f();
        this.mPostedAnimatorRunner = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mMinMaxLayoutPositions = new int[SCROLL_STATE_SETTLING];
        this.mScrollOffset = new int[SCROLL_STATE_SETTLING];
        this.mScrollConsumed = new int[SCROLL_STATE_SETTLING];
        this.mNestedOffsets = new int[SCROLL_STATE_SETTLING];
        this.mItemAnimatorRunner = new C05012(this);
        this.mViewInfoProcessCallback = new C05044(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.mPostUpdatesOnAnimation = VERSION.SDK_INT >= 16 ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(ViewCompat.getOverScrollMode(this) == SCROLL_STATE_SETTLING ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        this.mItemAnimator.m1816a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, VERTICAL);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new at(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0421R.styleable.RecyclerView, i, TOUCH_SLOP_DEFAULT);
            String string = obtainStyledAttributes.getString(C0421R.styleable.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            createLayoutManager(context, string, attributeSet, i, TOUCH_SLOP_DEFAULT);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, TOUCH_SLOP_DEFAULT);
                z = obtainStyledAttributes.getBoolean(TOUCH_SLOP_DEFAULT, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z);
    }

    private void addAnimatingView(C0532u c0532u) {
        View view = c0532u.itemView;
        boolean z = view.getParent() == this ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        this.mRecycler.m1884d(getChildViewHolder(view));
        if (c0532u.isTmpDetached()) {
            this.mChildHelper.m2220a(view, NO_POSITION, view.getLayoutParams(), true);
        } else if (z) {
            this.mChildHelper.m2230d(view);
        } else {
            this.mChildHelper.m2222a(view, true);
        }
    }

    private void animateAppearance(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
        c0532u.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (this.mItemAnimator.m1821b(c0532u, c0516c, c0516c2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(C0532u c0532u, C0532u c0532u2, C0516c c0516c, C0516c c0516c2, boolean z, boolean z2) {
        c0532u.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (z) {
            addAnimatingView(c0532u);
        }
        if (c0532u != c0532u2) {
            if (z2) {
                addAnimatingView(c0532u2);
            }
            c0532u.mShadowedHolder = c0532u2;
            addAnimatingView(c0532u);
            this.mRecycler.m1884d(c0532u);
            c0532u2.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
            c0532u2.mShadowingHolder = c0532u;
        }
        if (this.mItemAnimator.m1818a(c0532u, c0532u2, c0516c, c0516c2)) {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
        addAnimatingView(c0532u);
        c0532u.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (this.mItemAnimator.m1817a(c0532u, c0516c, c0516c2)) {
            postAnimationRunner();
        }
    }

    private boolean canReuseUpdatedViewHolder(C0532u c0532u) {
        return (this.mItemAnimator == null || this.mItemAnimator.m1819a(c0532u, c0532u.getUnmodifiedPayloads())) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(TOUCH_SLOP_DEFAULT);
    }

    private void considerReleasingGlowsOnScroll(int i, int i2) {
        int i3 = TOUCH_SLOP_DEFAULT;
        if (!(this.mLeftGlow == null || this.mLeftGlow.isFinished() || i <= 0)) {
            i3 = this.mLeftGlow.onRelease();
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished() || i >= 0)) {
            i3 |= this.mRightGlow.onRelease();
        }
        if (!(this.mTopGlow == null || this.mTopGlow.isFinished() || i2 <= 0)) {
            i3 |= this.mTopGlow.onRelease();
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.isFinished() || i2 >= 0)) {
            i3 |= this.mBottomGlow.onRelease();
        }
        if (i3 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete) {
            return;
        }
        if (this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
        } else if (!this.mAdapterHelper.m2639d()) {
        } else {
            if (this.mAdapterHelper.m2630a(4) && !this.mAdapterHelper.m2630a(11)) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                eatRequestLayout();
                this.mAdapterHelper.m2634b();
                if (!this.mLayoutRequestEaten) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.m2637c();
                    }
                }
                resumeRequestLayout(true);
                TraceCompat.endSection();
            } else if (this.mAdapterHelper.m2639d()) {
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.endSection();
            }
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(fullClassName).asSubclass(C0493h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[TOUCH_SLOP_DEFAULT]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0493h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e32222);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        if (this.mChildHelper.m2223b() == 0) {
            return (i == 0 && i2 == 0) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        } else {
            findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
            return (this.mMinMaxLayoutPositions[TOUCH_SLOP_DEFAULT] == i && this.mMinMaxLayoutPositions[VERTICAL] == i2) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        }
    }

    private void dispatchChildAttached(View view) {
        C0532u childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() + NO_POSITION; size >= 0; size += NO_POSITION) {
                ((C0521j) this.mOnChildAttachStateListeners.get(size)).m1841a(view);
            }
        }
    }

    private void dispatchChildDetached(View view) {
        C0532u childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() + NO_POSITION; size >= 0; size += NO_POSITION) {
                ((C0521j) this.mOnChildAttachStateListeners.get(size)).m1842b(view);
            }
        }
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = TOUCH_SLOP_DEFAULT;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(Message.FLAG_RET);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        int b;
        int i;
        C0532u childViewHolderInt;
        boolean z = true;
        this.mState.m1924a((int) VERTICAL);
        this.mState.f1555l = FORCE_INVALIDATE_DISPLAY_LIST;
        eatRequestLayout();
        this.mViewInfoStore.m2574a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        C0529r c0529r = this.mState;
        if (!(this.mState.f1552i && this.mItemsChanged)) {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        c0529r.f1554k = z;
        this.mItemsChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemsAddedOrRemoved = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.f1551h = this.mState.f1553j;
        this.mState.f1544a = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f1552i) {
            b = this.mChildHelper.m2223b();
            for (i = TOUCH_SLOP_DEFAULT; i < b; i += VERTICAL) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2225b(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.m2576a(childViewHolderInt, this.mItemAnimator.m1814a(this.mState, childViewHolderInt, C0517e.m1812d(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (!(!this.mState.f1554k || !childViewHolderInt.isUpdated() || childViewHolderInt.isRemoved() || childViewHolderInt.shouldIgnore() || childViewHolderInt.isInvalid())) {
                        this.mViewInfoStore.m2575a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f1553j) {
            saveOldPositions();
            z = this.mState.f1550g;
            this.mState.f1550g = FORCE_INVALIDATE_DISPLAY_LIST;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.f1550g = z;
            for (i = TOUCH_SLOP_DEFAULT; i < this.mChildHelper.m2223b(); i += VERTICAL) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2225b(i));
                if (!(childViewHolderInt.shouldIgnore() || this.mViewInfoStore.m2584d(childViewHolderInt))) {
                    b = C0517e.m1812d(childViewHolderInt);
                    boolean hasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                    if (!hasAnyOfTheFlags) {
                        b |= SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
                    }
                    C0516c a = this.mItemAnimator.m1814a(this.mState, childViewHolderInt, b, childViewHolderInt.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt, a);
                    } else {
                        this.mViewInfoStore.m2581b(childViewHolderInt, a);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        this.mState.f1546c = SCROLL_STATE_SETTLING;
    }

    private void dispatchLayoutStep2() {
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m1924a(6);
        this.mAdapterHelper.m2640e();
        this.mState.f1544a = this.mAdapter.getItemCount();
        this.mState.f1549f = TOUCH_SLOP_DEFAULT;
        this.mState.f1551h = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.f1550g = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mPendingSavedState = null;
        C0529r c0529r = this.mState;
        boolean z = (!this.mState.f1552i || this.mItemAnimator == null) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        c0529r.f1552i = z;
        this.mState.f1546c = 4;
        onExitLayoutOrScroll();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
    }

    private void dispatchLayoutStep3() {
        this.mState.m1924a(4);
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f1546c = VERTICAL;
        if (this.mState.f1552i) {
            for (int b = this.mChildHelper.m2223b() + NO_POSITION; b >= 0; b += NO_POSITION) {
                C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2225b(b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    C0516c a = this.mItemAnimator.m1813a(this.mState, childViewHolderInt);
                    C0532u a2 = this.mViewInfoStore.m2573a(changedHolderKey);
                    if (a2 == null || a2.shouldIgnore()) {
                        this.mViewInfoStore.m2583c(childViewHolderInt, a);
                    } else {
                        boolean a3 = this.mViewInfoStore.m2578a(a2);
                        boolean a4 = this.mViewInfoStore.m2578a(childViewHolderInt);
                        if (a3 && a2 == childViewHolderInt) {
                            this.mViewInfoStore.m2583c(childViewHolderInt, a);
                        } else {
                            C0516c b2 = this.mViewInfoStore.m2579b(a2);
                            this.mViewInfoStore.m2583c(childViewHolderInt, a);
                            C0516c c = this.mViewInfoStore.m2582c(childViewHolderInt);
                            if (b2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a2);
                            } else {
                                animateChange(a2, childViewHolderInt, b2, c, a3, a4);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.m2577a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mState.f1548e = this.mState.f1544a;
        this.mDataSetHasChangedAfterLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.f1552i = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.f1553j = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayout.mRequestedSimpleAnimations = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mRecycler.f1531d != null) {
            this.mRecycler.f1531d.clear();
        }
        onExitLayoutOrScroll();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        this.mViewInfoStore.m2574a();
        if (didChildRangeChange(this.mMinMaxLayoutPositions[TOUCH_SLOP_DEFAULT], this.mMinMaxLayoutPositions[VERTICAL])) {
            dispatchOnScrolled(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
        }
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.m1845b(this, motionEvent);
                if (action == 3 || action == VERTICAL) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
                C0522k c0522k = (C0522k) this.mOnItemTouchListeners.get(i);
                if (c0522k.m1844a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = c0522k;
                    return true;
                }
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        int i = TOUCH_SLOP_DEFAULT;
        while (i < size) {
            C0522k c0522k = (C0522k) this.mOnItemTouchListeners.get(i);
            if (!c0522k.m1844a(this, motionEvent) || action == 3) {
                i += VERTICAL;
            } else {
                this.mActiveOnItemTouchListener = c0522k;
                return true;
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b = this.mChildHelper.m2223b();
        if (b == 0) {
            iArr[TOUCH_SLOP_DEFAULT] = TOUCH_SLOP_DEFAULT;
            iArr[VERTICAL] = TOUCH_SLOP_DEFAULT;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        int i3 = TOUCH_SLOP_DEFAULT;
        while (i3 < b) {
            int i4;
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2225b(i3));
            if (childViewHolderInt.shouldIgnore()) {
                i4 = i;
            } else {
                i4 = childViewHolderInt.getLayoutPosition();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3 += VERTICAL;
            i = i4;
        }
        iArr[TOUCH_SLOP_DEFAULT] = i;
        iArr[VERTICAL] = i2;
    }

    private int getAdapterPositionFor(C0532u c0532u) {
        return (c0532u.hasAnyOfTheFlags(PLUGIN.ASSET_PLUGIN_VERSION) || !c0532u.isBound()) ? NO_POSITION : this.mAdapterHelper.m2636c(c0532u.mPosition);
    }

    static C0532u getChildViewHolderInt(View view) {
        return view == null ? null : ((C0491i) view.getLayoutParams()).f1466a;
    }

    private String getFullClassName(Context context, String str) {
        return str.charAt(TOUCH_SLOP_DEFAULT) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private float getScrollFactor() {
        if (this.mScrollFactor == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.mScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.mScrollFactor;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, C0532u c0532u, C0532u c0532u2) {
        int b = this.mChildHelper.m2223b();
        int i = TOUCH_SLOP_DEFAULT;
        while (i < b) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2225b(i));
            if (childViewHolderInt == c0532u || getChangedHolderKey(childViewHolderInt) != j) {
                i += VERTICAL;
            } else if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + c0532u);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + c0532u);
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0532u2 + " cannot be found but it is necessary for " + c0532u);
    }

    private boolean hasUpdatedView() {
        int b = this.mChildHelper.m2223b();
        for (int i = TOUCH_SLOP_DEFAULT; i < b; i += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2225b(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ag(new C05065(this));
    }

    private void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    private void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter += VERTICAL;
    }

    private void onExitLayoutOrScroll() {
        this.mLayoutOrScrollCounter += NO_POSITION;
        if (this.mLayoutOrScrollCounter < VERTICAL) {
            this.mLayoutOrScrollCounter = TOUCH_SLOP_DEFAULT;
            dispatchContentChangedIfNecessary();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mScrollPointerId) {
            actionIndex = actionIndex == 0 ? VERTICAL : TOUCH_SLOP_DEFAULT;
            this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            int x = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            actionIndex = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            this.mLastTouchY = actionIndex;
            this.mInitialTouchY = actionIndex;
        }
    }

    private void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z = true;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m2626a();
            markKnownViewsInvalid();
            this.mLayout.onItemsChanged(this);
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m2634b();
        } else {
            this.mAdapterHelper.m2640e();
        }
        boolean z2 = (this.mItemsAddedOrRemoved || this.mItemsChanged) ? true : TOUCH_SLOP_DEFAULT;
        C0529r c0529r = this.mState;
        boolean z3 = (!this.mFirstLayoutComplete || this.mItemAnimator == null || (!(this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) || (this.mDataSetHasChangedAfterLayout && !this.mAdapter.hasStableIds()))) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        c0529r.f1552i = z3;
        C0529r c0529r2 = this.mState;
        if (!(this.mState.f1552i && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())) {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        c0529r2.f1553j = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.ensureLeftGlow();
        r2 = r7.mLeftGlow;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.onPull(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.ensureTopGlow();
        r2 = r7.mTopGlow;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.onPull(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.ensureRightGlow();
        r2 = r7.mRightGlow;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.onPull(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.ensureBottomGlow();
        r2 = r7.mBottomGlow;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.onPull(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recordAnimationInfoIfBouncedHiddenView(C0532u c0532u, C0516c c0516c) {
        c0532u.setFlags(TOUCH_SLOP_DEFAULT, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        if (this.mState.f1554k && c0532u.isUpdated() && !c0532u.isRemoved() && !c0532u.shouldIgnore()) {
            this.mViewInfoStore.m2575a(getChangedHolderKey(c0532u), c0532u);
        }
        this.mViewInfoStore.m2576a(c0532u, c0516c);
    }

    private void releaseGlows() {
        int i = TOUCH_SLOP_DEFAULT;
        if (this.mLeftGlow != null) {
            i = this.mLeftGlow.onRelease();
        }
        if (this.mTopGlow != null) {
            i |= this.mTopGlow.onRelease();
        }
        if (this.mRightGlow != null) {
            i |= this.mRightGlow.onRelease();
        }
        if (this.mBottomGlow != null) {
            i |= this.mBottomGlow.onRelease();
        }
        if (i != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private boolean removeAnimatingView(View view) {
        eatRequestLayout();
        boolean f = this.mChildHelper.m2232f(view);
        if (f) {
            C0532u childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m1884d(childViewHolderInt);
            this.mRecycler.m1875b(childViewHolderInt);
        }
        resumeRequestLayout(!f ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        return f;
    }

    private void repositionShadowingViews() {
        int b = this.mChildHelper.m2223b();
        for (int i = TOUCH_SLOP_DEFAULT; i < b; i += VERTICAL) {
            View b2 = this.mChildHelper.m2225b(i);
            C0532u childViewHolder = getChildViewHolder(b2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void resetTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll();
        releaseGlows();
    }

    private void setAdapterInternal(C0510a c0510a, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            if (this.mItemAnimator != null) {
                this.mItemAnimator.m1822c();
            }
            if (this.mLayout != null) {
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            }
            this.mRecycler.m1862a();
        }
        this.mAdapterHelper.m2626a();
        C0510a c0510a2 = this.mAdapter;
        this.mAdapter = c0510a;
        if (c0510a != null) {
            c0510a.registerAdapterDataObserver(this.mObserver);
            c0510a.onAttachedToRecyclerView(this);
        }
        if (this.mLayout != null) {
            this.mLayout.onAdapterChanged(c0510a2, this.mAdapter);
        }
        this.mRecycler.m1865a(c0510a2, this.mAdapter, z);
        this.mState.f1550g = true;
        markKnownViewsInvalid();
    }

    private void setDataSetChangedAfterLayout() {
        if (!this.mDataSetHasChangedAfterLayout) {
            this.mDataSetHasChangedAfterLayout = true;
            int c = this.mChildHelper.m2226c();
            for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
                C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i));
                if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                    childViewHolderInt.addFlags(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY);
                }
            }
            this.mRecycler.m1890g();
        }
    }

    private void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != SCROLL_STATE_SETTLING) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m1940b();
        if (this.mLayout != null) {
            this.mLayout.stopSmoothScroller();
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.mLayout == null || !this.mLayout.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(C0519g c0519g) {
        addItemDecoration(c0519g, NO_POSITION);
    }

    public void addItemDecoration(C0519g c0519g, int i) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        if (i < 0) {
            this.mItemDecorations.add(c0519g);
        } else {
            this.mItemDecorations.add(i, c0519g);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(C0521j c0521j) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(c0521j);
    }

    public void addOnItemTouchListener(C0522k c0522k) {
        this.mOnItemTouchListeners.add(c0522k);
    }

    public void addOnScrollListener(C0523l c0523l) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(c0523l);
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return ((layoutParams instanceof C0491i) && this.mLayout.checkLayoutParams((C0491i) layoutParams)) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    void clearOldPositions() {
        int c = this.mChildHelper.m2226c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.m1892i();
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.clear();
        }
    }

    public void clearOnScrollListeners() {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        return (this.mLayout != null && this.mLayout.canScrollHorizontally()) ? this.mLayout.computeHorizontalScrollExtent(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeHorizontalScrollOffset() {
        return (this.mLayout != null && this.mLayout.canScrollHorizontally()) ? this.mLayout.computeHorizontalScrollOffset(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeHorizontalScrollRange() {
        return (this.mLayout != null && this.mLayout.canScrollHorizontally()) ? this.mLayout.computeHorizontalScrollRange(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeVerticalScrollExtent() {
        return (this.mLayout != null && this.mLayout.canScrollVertically()) ? this.mLayout.computeVerticalScrollExtent(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeVerticalScrollOffset() {
        return (this.mLayout != null && this.mLayout.canScrollVertically()) ? this.mLayout.computeVerticalScrollOffset(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeVerticalScrollRange() {
        return (this.mLayout != null && this.mLayout.canScrollVertically()) ? this.mLayout.computeVerticalScrollRange(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(C0493h.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), C0493h.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.f1555l = FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.mState.f1546c == VERTICAL) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.m2641f() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.mLayout != null) {
            this.mLayout.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        if (this.mScrollListener != null) {
            this.mScrollListener.m1846a(this, i);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() + NO_POSITION; size >= 0; size += NO_POSITION) {
                ((C0523l) this.mScrollListeners.get(size)).m1846a(this, i);
            }
        }
    }

    void dispatchOnScrolled(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.mScrollListener != null) {
            this.mScrollListener.m1847a(this, i, i2);
        }
        if (this.mScrollListeners != null) {
            for (scrollY = this.mScrollListeners.size() + NO_POSITION; scrollY >= 0; scrollY += NO_POSITION) {
                ((C0523l) this.mScrollListeners.get(scrollY)).m1847a(this, i, i2);
            }
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = VERTICAL;
        int i4 = TOUCH_SLOP_DEFAULT;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        for (i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            ((C0519g) this.mItemDecorations.get(i)).m1840b(canvas, this, this.mState);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished()) {
            i2 = TOUCH_SLOP_DEFAULT;
        } else {
            i = canvas.save();
            i2 = this.mClipToPadding ? getPaddingBottom() : TOUCH_SLOP_DEFAULT;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.mLeftGlow == null || !this.mLeftGlow.draw(canvas)) ? TOUCH_SLOP_DEFAULT : VERTICAL;
            canvas.restoreToCount(i);
        }
        if (!(this.mTopGlow == null || this.mTopGlow.isFinished())) {
            size = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.mTopGlow == null || !this.mTopGlow.draw(canvas)) ? TOUCH_SLOP_DEFAULT : VERTICAL;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            i = this.mClipToPadding ? getPaddingTop() : TOUCH_SLOP_DEFAULT;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.mRightGlow == null || !this.mRightGlow.draw(canvas)) ? TOUCH_SLOP_DEFAULT : VERTICAL;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow != null && this.mBottomGlow.draw(canvas)) {
                i4 = VERTICAL;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.m1820b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void eatRequestLayout() {
        this.mEatRequestLayout += VERTICAL;
        if (this.mEatRequestLayout == VERTICAL && !this.mLayoutFrozen) {
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.mChildHelper.m2223b() + NO_POSITION; b >= 0; b += NO_POSITION) {
            View b2 = this.mChildHelper.m2225b(b);
            float translationX = ViewCompat.getTranslationX(b2);
            float translationY = ViewCompat.getTranslationY(b2);
            if (f >= ((float) b2.getLeft()) + translationX && f <= translationX + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + translationY && f2 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    public C0532u findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        return findContainingItemView == null ? null : getChildViewHolder(findContainingItemView);
    }

    public C0532u findViewHolderForAdapterPosition(int i) {
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c = this.mChildHelper.m2226c();
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < c; i2 += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                return childViewHolderInt;
            }
        }
        return null;
    }

    public C0532u findViewHolderForItemId(long j) {
        int c = this.mChildHelper.m2226c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i));
            if (childViewHolderInt != null && childViewHolderInt.getItemId() == j) {
                return childViewHolderInt;
            }
        }
        return null;
    }

    public C0532u findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, FORCE_INVALIDATE_DISPLAY_LIST);
    }

    @Deprecated
    public C0532u findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, FORCE_INVALIDATE_DISPLAY_LIST);
    }

    C0532u findViewHolderForPosition(int i, boolean z) {
        int c = this.mChildHelper.m2226c();
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < c; i2 += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.isRemoved())) {
                if (z) {
                    if (childViewHolderInt.mPosition == i) {
                        return childViewHolderInt;
                    }
                } else if (childViewHolderInt.getLayoutPosition() == i) {
                    return childViewHolderInt;
                }
            }
        }
        return null;
    }

    public boolean fling(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else if (this.mLayoutFrozen) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) {
                i = TOUCH_SLOP_DEFAULT;
            }
            if (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = TOUCH_SLOP_DEFAULT;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return FORCE_INVALIDATE_DISPLAY_LIST;
            }
            canScrollHorizontally = (canScrollHorizontally || canScrollVertically) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
            dispatchNestedFling((float) i, (float) i2, canScrollHorizontally);
            if (!canScrollHorizontally) {
                return FORCE_INVALIDATE_DISPLAY_LIST;
            }
            this.mViewFlinger.m1936a(Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity)));
            return true;
        }
    }

    public View focusSearch(View view, int i) {
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        onInterceptFocusSearch = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(onInterceptFocusSearch != null || this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen)) {
            eatRequestLayout();
            onInterceptFocusSearch = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        return onInterceptFocusSearch == null ? super.focusSearch(view, i) : onInterceptFocusSearch;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public C0510a getAdapter() {
        return this.mAdapter;
    }

    public int getBaseline() {
        return this.mLayout != null ? this.mLayout.getBaseline() : super.getBaseline();
    }

    long getChangedHolderKey(C0532u c0532u) {
        return this.mAdapter.hasStableIds() ? c0532u.getItemId() : (long) c0532u.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        C0532u childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.getAdapterPosition() : NO_POSITION;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.mChildDrawingOrderCallback == null ? super.getChildDrawingOrder(i, i2) : this.mChildDrawingOrderCallback.m1807a(i, i2);
    }

    public long getChildItemId(View view) {
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return NO_ID;
        }
        C0532u childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.getItemId() : NO_ID;
    }

    public int getChildLayoutPosition(View view) {
        C0532u childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.getLayoutPosition() : NO_POSITION;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public C0532u getChildViewHolder(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public at getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public C0517e getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        C0491i c0491i = (C0491i) view.getLayoutParams();
        if (!c0491i.f1468c) {
            return c0491i.f1467b;
        }
        Rect rect = c0491i.f1467b;
        rect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
        int size = this.mItemDecorations.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
            ((C0519g) this.mItemDecorations.get(i)).m1838a(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        c0491i.f1468c = FORCE_INVALIDATE_DISPLAY_LIST;
        return rect;
    }

    public C0493h getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public C0524m getRecycledViewPool() {
        return this.mRecycler.m1888f();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m2639d()) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new C0605e(new C05086(this));
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    boolean isAccessibilityEnabled() {
        return (this.mAccessibilityManager == null || !this.mAccessibilityManager.isEnabled()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    public boolean isAnimating() {
        return (this.mItemAnimator == null || !this.mItemAnimator.m1820b()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0 ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void markItemDecorInsetsDirty() {
        int c = this.mChildHelper.m2226c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            ((C0491i) this.mChildHelper.m2227c(i).getLayoutParams()).f1468c = true;
        }
        this.mRecycler.m1893j();
    }

    void markKnownViewsInvalid() {
        int c = this.mChildHelper.m2226c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m1891h();
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.mChildHelper.m2223b();
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < b; i2 += VERTICAL) {
            this.mChildHelper.m2225b(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int b = this.mChildHelper.m2223b();
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < b; i2 += VERTICAL) {
            this.mChildHelper.m2225b(i2).offsetTopAndBottom(i);
        }
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int c = this.mChildHelper.m2226c();
        for (int i3 = TOUCH_SLOP_DEFAULT; i3 < c; i3 += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i3));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore() || childViewHolderInt.mPosition < i)) {
                childViewHolderInt.offsetPosition(i2, FORCE_INVALIDATE_DISPLAY_LIST);
                this.mState.f1550g = true;
            }
        }
        this.mRecycler.m1873b(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int c = this.mChildHelper.m2226c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = NO_POSITION;
            i4 = i2;
            i5 = i;
        } else {
            i3 = VERTICAL;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = TOUCH_SLOP_DEFAULT; i6 < c; i6 += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= r3 && childViewHolderInt.mPosition <= r2) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, FORCE_INVALIDATE_DISPLAY_LIST);
                } else {
                    childViewHolderInt.offsetPosition(i3, FORCE_INVALIDATE_DISPLAY_LIST);
                }
                this.mState.f1550g = true;
            }
        }
        this.mRecycler.m1864a(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.mChildHelper.m2226c();
        for (int i4 = TOUCH_SLOP_DEFAULT; i4 < c; i4 += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i4));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f1550g = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i + NO_POSITION, -i2, z);
                    this.mState.f1550g = true;
                }
            }
        }
        this.mRecycler.m1874b(i, i2, z);
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = TOUCH_SLOP_DEFAULT;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout != null) {
            this.mLayout.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m1822c();
        }
        this.mFirstLayoutComplete = FORCE_INVALIDATE_DISPLAY_LIST;
        stopScroll();
        this.mIsAttached = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout != null) {
            this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m2580b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            ((C0519g) this.mItemDecorations.get(i)).m1836a(canvas, this, this.mState);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.mLayout == null || this.mLayoutFrozen || (MotionEventCompat.getSource(motionEvent) & SCROLL_STATE_SETTLING) == 0 || motionEvent.getAction() != 8)) {
            float f = this.mLayout.canScrollVertically() ? -MotionEventCompat.getAxisValue(motionEvent, 9) : 0.0f;
            float axisValue = this.mLayout.canScrollHorizontally() ? MotionEventCompat.getAxisValue(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && axisValue == 0.0f)) {
                float scrollFactor = getScrollFactor();
                scrollByInternal((int) (axisValue * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = NO_POSITION;
        boolean z = true;
        if (this.mLayoutFrozen) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            int i2;
            switch (actionMasked) {
                case TOUCH_SLOP_DEFAULT /*0*/:
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = FORCE_INVALIDATE_DISPLAY_LIST;
                    }
                    this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, TOUCH_SLOP_DEFAULT);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = i;
                    this.mInitialTouchX = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = i;
                    this.mInitialTouchY = i;
                    if (this.mScrollState == SCROLL_STATE_SETTLING) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(VERTICAL);
                    }
                    int[] iArr = this.mNestedOffsets;
                    this.mNestedOffsets[VERTICAL] = TOUCH_SLOP_DEFAULT;
                    iArr[TOUCH_SLOP_DEFAULT] = TOUCH_SLOP_DEFAULT;
                    i2 = canScrollHorizontally ? VERTICAL : TOUCH_SLOP_DEFAULT;
                    if (canScrollVertically) {
                        i2 |= SCROLL_STATE_SETTLING;
                    }
                    startNestedScroll(i2);
                    break;
                case VERTICAL /*1*/:
                    this.mVelocityTracker.clear();
                    stopNestedScroll();
                    break;
                case SCROLL_STATE_SETTLING /*2*/:
                    actionMasked = MotionEventCompat.findPointerIndex(motionEvent, this.mScrollPointerId);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (MotionEventCompat.getX(motionEvent, actionMasked) + 0.5f);
                        actionMasked = (int) (MotionEventCompat.getY(motionEvent, actionMasked) + 0.5f);
                        if (this.mScrollState != VERTICAL) {
                            actionIndex -= this.mInitialTouchX;
                            actionMasked -= this.mInitialTouchY;
                            if (!canScrollHorizontally || Math.abs(actionIndex) <= this.mTouchSlop) {
                                canScrollHorizontally = FORCE_INVALIDATE_DISPLAY_LIST;
                            } else {
                                this.mLastTouchX = ((actionIndex < 0 ? NO_POSITION : VERTICAL) * this.mTouchSlop) + this.mInitialTouchX;
                                canScrollHorizontally = true;
                            }
                            if (canScrollVertically && Math.abs(actionMasked) > this.mTouchSlop) {
                                i2 = this.mInitialTouchY;
                                int i3 = this.mTouchSlop;
                                if (actionMasked >= 0) {
                                    i = VERTICAL;
                                }
                                this.mLastTouchY = i2 + (i * i3);
                                canScrollHorizontally = true;
                            }
                            if (canScrollHorizontally) {
                                setScrollState(VERTICAL);
                                break;
                            }
                        }
                    }
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return FORCE_INVALIDATE_DISPLAY_LIST;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    cancelTouch();
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    i2 = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                    this.mLastTouchX = i2;
                    this.mInitialTouchX = i2;
                    i2 = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                    this.mLastTouchY = i2;
                    this.mInitialTouchY = i2;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    onPointerUp(motionEvent);
                    break;
            }
            if (this.mScrollState != VERTICAL) {
                z = FORCE_INVALIDATE_DISPLAY_LIST;
            }
            return z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
        } else if (this.mLayout.mAutoMeasure) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (!z && this.mAdapter != null) {
                if (this.mState.f1546c == VERTICAL) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.f1555l = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f1555l = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                eatRequestLayout();
                processAdapterUpdatesAndSetAnimationFlags();
                if (this.mState.f1553j) {
                    this.mState.f1551h = true;
                } else {
                    this.mAdapterHelper.m2640e();
                    this.mState.f1551h = FORCE_INVALIDATE_DISPLAY_LIST;
                }
                this.mAdapterUpdateDuringMeasure = FORCE_INVALIDATE_DISPLAY_LIST;
                resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            }
            if (this.mAdapter != null) {
                this.mState.f1544a = this.mAdapter.getItemCount();
            } else {
                this.mState.f1544a = TOUCH_SLOP_DEFAULT;
            }
            eatRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            this.mState.f1551h = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
            if (this.mLayout != null && this.mPendingSavedState.f1509a != null) {
                this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f1509a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            savedState.m1792a(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            savedState.f1509a = this.mLayout.onSaveInstanceState();
        } else {
            savedState.f1509a = null;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayoutFrozen || this.mIgnoreMotionEventTillDown) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.mNestedOffsets;
                this.mNestedOffsets[VERTICAL] = TOUCH_SLOP_DEFAULT;
                iArr[TOUCH_SLOP_DEFAULT] = TOUCH_SLOP_DEFAULT;
            }
            obtain.offsetLocation((float) this.mNestedOffsets[TOUCH_SLOP_DEFAULT], (float) this.mNestedOffsets[VERTICAL]);
            switch (actionMasked) {
                case TOUCH_SLOP_DEFAULT /*0*/:
                    this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, TOUCH_SLOP_DEFAULT);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = actionMasked;
                    this.mInitialTouchX = actionMasked;
                    actionMasked = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = actionMasked;
                    this.mInitialTouchY = actionMasked;
                    actionMasked = canScrollHorizontally ? VERTICAL : TOUCH_SLOP_DEFAULT;
                    if (canScrollVertically) {
                        actionMasked |= SCROLL_STATE_SETTLING;
                    }
                    startNestedScroll(actionMasked);
                    break;
                case VERTICAL /*1*/:
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE, (float) this.mMaxFlingVelocity);
                    float f = canScrollHorizontally ? -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                    float f2 = canScrollVertically ? -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                        setScrollState(TOUCH_SLOP_DEFAULT);
                    }
                    resetTouch();
                    z = true;
                    break;
                case SCROLL_STATE_SETTLING /*2*/:
                    actionMasked = MotionEventCompat.findPointerIndex(motionEvent, this.mScrollPointerId);
                    if (actionMasked >= 0) {
                        int x = (int) (MotionEventCompat.getX(motionEvent, actionMasked) + 0.5f);
                        int y = (int) (MotionEventCompat.getY(motionEvent, actionMasked) + 0.5f);
                        int i = this.mLastTouchX - x;
                        actionMasked = this.mLastTouchY - y;
                        if (dispatchNestedPreScroll(i, actionMasked, this.mScrollConsumed, this.mScrollOffset)) {
                            i -= this.mScrollConsumed[TOUCH_SLOP_DEFAULT];
                            actionMasked -= this.mScrollConsumed[VERTICAL];
                            obtain.offsetLocation((float) this.mScrollOffset[TOUCH_SLOP_DEFAULT], (float) this.mScrollOffset[VERTICAL]);
                            int[] iArr2 = this.mNestedOffsets;
                            iArr2[TOUCH_SLOP_DEFAULT] = iArr2[TOUCH_SLOP_DEFAULT] + this.mScrollOffset[TOUCH_SLOP_DEFAULT];
                            iArr2 = this.mNestedOffsets;
                            iArr2[VERTICAL] = iArr2[VERTICAL] + this.mScrollOffset[VERTICAL];
                        }
                        if (this.mScrollState != VERTICAL) {
                            boolean z2;
                            if (!canScrollHorizontally || Math.abs(i) <= this.mTouchSlop) {
                                z2 = FORCE_INVALIDATE_DISPLAY_LIST;
                            } else {
                                i = i > 0 ? i - this.mTouchSlop : i + this.mTouchSlop;
                                z2 = true;
                            }
                            if (canScrollVertically && Math.abs(actionMasked) > this.mTouchSlop) {
                                actionMasked = actionMasked > 0 ? actionMasked - this.mTouchSlop : actionMasked + this.mTouchSlop;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(VERTICAL);
                            }
                        }
                        if (this.mScrollState == VERTICAL) {
                            this.mLastTouchX = x - this.mScrollOffset[TOUCH_SLOP_DEFAULT];
                            this.mLastTouchY = y - this.mScrollOffset[VERTICAL];
                            if (!canScrollHorizontally) {
                                i = TOUCH_SLOP_DEFAULT;
                            }
                            if (!canScrollVertically) {
                                actionMasked = TOUCH_SLOP_DEFAULT;
                            }
                            if (scrollByInternal(i, actionMasked, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return FORCE_INVALIDATE_DISPLAY_LIST;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    cancelTouch();
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    actionMasked = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                    this.mLastTouchX = actionMasked;
                    this.mInitialTouchX = actionMasked;
                    actionMasked = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                    this.mLastTouchY = actionMasked;
                    this.mInitialTouchY = actionMasked;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    onPointerUp(motionEvent);
                    break;
            }
            if (!z) {
                this.mVelocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        C0532u childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt);
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(C0519g c0519g) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(c0519g);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(ViewCompat.getOverScrollMode(this) == SCROLL_STATE_SETTLING ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeOnChildAttachStateChangeListener(C0521j c0521j) {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.remove(c0521j);
        }
    }

    public void removeOnItemTouchListener(C0522k c0522k) {
        this.mOnItemTouchListeners.remove(c0522k);
        if (this.mActiveOnItemTouchListener == c0522k) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(C0523l c0523l) {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.remove(c0523l);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.mLayout.onRequestChildFocus(this, this.mState, view, view2) || view2 == null)) {
            this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof C0491i) {
                C0491i c0491i = (C0491i) layoutParams;
                if (!c0491i.f1468c) {
                    Rect rect = c0491i.f1467b;
                    Rect rect2 = this.mTempRect;
                    rect2.left -= rect.left;
                    rect2 = this.mTempRect;
                    rect2.right += rect.right;
                    rect2 = this.mTempRect;
                    rect2.top -= rect.top;
                    rect2 = this.mTempRect;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            requestChildRectangleOnScreen(view, this.mTempRect, !this.mFirstLayoutComplete ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            ((C0522k) this.mOnItemTouchListeners.get(i)).m1843a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.mEatRequestLayout != 0 || this.mLayoutFrozen) {
            this.mLayoutRequestEaten = true;
        } else {
            super.requestLayout();
        }
    }

    void resumeRequestLayout(boolean z) {
        if (this.mEatRequestLayout < VERTICAL) {
            this.mEatRequestLayout = VERTICAL;
        }
        if (!z) {
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (this.mEatRequestLayout == VERTICAL) {
            if (!(!z || !this.mLayoutRequestEaten || this.mLayoutFrozen || this.mLayout == null || this.mAdapter == null)) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }
        this.mEatRequestLayout += NO_POSITION;
    }

    void saveOldPositions() {
        int c = this.mChildHelper.m2226c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0532u childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2227c(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = TOUCH_SLOP_DEFAULT;
                }
                if (!canScrollVertically) {
                    i2 = TOUCH_SLOP_DEFAULT;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int scrollHorizontallyBy;
        int i3;
        int i4;
        int i5;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int scrollVerticallyBy;
            eatRequestLayout();
            onEnterLayoutOrScroll();
            TraceCompat.beginSection(TRACE_SCROLL_TAG);
            if (i != 0) {
                scrollHorizontallyBy = this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState);
                i3 = i - scrollHorizontallyBy;
            } else {
                scrollHorizontallyBy = TOUCH_SLOP_DEFAULT;
                i3 = TOUCH_SLOP_DEFAULT;
            }
            if (i2 != 0) {
                scrollVerticallyBy = this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState);
                i4 = i2 - scrollVerticallyBy;
            } else {
                scrollVerticallyBy = TOUCH_SLOP_DEFAULT;
                i4 = TOUCH_SLOP_DEFAULT;
            }
            TraceCompat.endSection();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            i5 = i4;
            i4 = scrollHorizontallyBy;
            scrollHorizontallyBy = scrollVerticallyBy;
        } else {
            scrollHorizontallyBy = TOUCH_SLOP_DEFAULT;
            i4 = TOUCH_SLOP_DEFAULT;
            i5 = TOUCH_SLOP_DEFAULT;
            i3 = TOUCH_SLOP_DEFAULT;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, scrollHorizontallyBy, i3, i5, this.mScrollOffset)) {
            this.mLastTouchX -= this.mScrollOffset[TOUCH_SLOP_DEFAULT];
            this.mLastTouchY -= this.mScrollOffset[VERTICAL];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.mScrollOffset[TOUCH_SLOP_DEFAULT], (float) this.mScrollOffset[VERTICAL]);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[TOUCH_SLOP_DEFAULT] = iArr[TOUCH_SLOP_DEFAULT] + this.mScrollOffset[TOUCH_SLOP_DEFAULT];
            iArr = this.mNestedOffsets;
            iArr[VERTICAL] = iArr[VERTICAL] + this.mScrollOffset[VERTICAL];
        } else if (ViewCompat.getOverScrollMode(this) != SCROLL_STATE_SETTLING) {
            if (motionEvent != null) {
                pullGlows(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (!(i4 == 0 && scrollHorizontallyBy == 0)) {
            dispatchOnScrolled(i4, scrollHorizontallyBy);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && scrollHorizontallyBy == 0) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            stopScroll();
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(at atVar) {
        this.mAccessibilityDelegate = atVar;
        ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
    }

    public void setAdapter(C0510a c0510a) {
        setLayoutFrozen(FORCE_INVALIDATE_DISPLAY_LIST);
        setAdapterInternal(c0510a, FORCE_INVALIDATE_DISPLAY_LIST, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C0513d c0513d) {
        if (c0513d != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = c0513d;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(C0517e c0517e) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m1822c();
            this.mItemAnimator.m1816a(null);
        }
        this.mItemAnimator = c0517e;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m1816a(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.m1863a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, TOUCH_SLOP_DEFAULT));
                this.mLayoutFrozen = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutFrozen = FORCE_INVALIDATE_DISPLAY_LIST;
            if (!(!this.mLayoutRequestEaten || this.mLayout == null || this.mAdapter == null)) {
                requestLayout();
            }
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    public void setLayoutManager(C0493h c0493h) {
        if (c0493h != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
            }
            this.mRecycler.m1862a();
            this.mChildHelper.m2217a();
            this.mLayout = c0493h;
            if (c0493h != null) {
                if (c0493h.mRecyclerView != null) {
                    throw new IllegalArgumentException("LayoutManager " + c0493h + " is already attached to a RecyclerView: " + c0493h.mRecyclerView);
                }
                this.mLayout.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            }
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    @Deprecated
    public void setOnScrollListener(C0523l c0523l) {
        this.mScrollListener = c0523l;
    }

    public void setRecycledViewPool(C0524m c0524m) {
        this.mRecycler.m1866a(c0524m);
    }

    public void setRecyclerListener(C0526o c0526o) {
        this.mRecyclerListener = c0526o;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case TOUCH_SLOP_DEFAULT /*0*/:
                break;
            case VERTICAL /*1*/:
                this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
                return;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(C0530s c0530s) {
        this.mRecycler.m1867a(c0530s);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i = TOUCH_SLOP_DEFAULT;
        if (!isComputingLayout()) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : TOUCH_SLOP_DEFAULT;
        if (contentChangeTypes != 0) {
            i = contentChangeTypes;
        }
        this.mEatenAccessibilityChangeFlags = i | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void smoothScrollBy(int i, int i2) {
        int i3 = TOUCH_SLOP_DEFAULT;
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            if (!this.mLayout.canScrollHorizontally()) {
                i = TOUCH_SLOP_DEFAULT;
            }
            if (this.mLayout.canScrollVertically()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.mViewFlinger.m1941b(i, i3);
            }
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(TOUCH_SLOP_DEFAULT);
        stopScrollersInternal();
    }

    public void swapAdapter(C0510a c0510a, boolean z) {
        setLayoutFrozen(FORCE_INVALIDATE_DISPLAY_LIST);
        setAdapterInternal(c0510a, true, z);
        setDataSetChangedAfterLayout();
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2, Object obj) {
        int c = this.mChildHelper.m2226c();
        int i3 = i + i2;
        for (int i4 = TOUCH_SLOP_DEFAULT; i4 < c; i4 += VERTICAL) {
            View c2 = this.mChildHelper.m2227c(i4);
            C0532u childViewHolderInt = getChildViewHolderInt(c2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(SCROLL_STATE_SETTLING);
                childViewHolderInt.addChangePayload(obj);
                ((C0491i) c2.getLayoutParams()).f1468c = true;
            }
        }
        this.mRecycler.m1879c(i, i2);
    }
}
