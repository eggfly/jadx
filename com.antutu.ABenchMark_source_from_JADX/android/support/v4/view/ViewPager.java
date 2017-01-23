package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.AutoScrollHelper;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.antutu.redacc.C1692R;
import com.facebook.ads.AdError;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.android.spdy.SpdyProtocol;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    interface Decor {
    }

    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager.1 */
    static class C02871 implements Comparator<ItemInfo> {
        C02871() {
        }

        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.2 */
    static class C02882 implements Interpolator {
        C02882() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.3 */
    class C02893 implements Runnable {
        C02893() {
        }

        public void run() {
            ViewPager.this.setScrollState(ViewPager.SCROLL_STATE_IDLE);
            ViewPager.this.populate();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.4 */
    class C02904 implements OnApplyWindowInsetsListener {
        private final Rect mTempRect;

        C02904() {
            this.mTempRect = new Rect();
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.mTempRect;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i = ViewPager.SCROLL_STATE_IDLE; i < childCount; i += ViewPager.SCROLL_STATE_DRAGGING) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(ViewPager.INVALID_POINTER, ViewPager.INVALID_POINTER);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.widthFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(ViewPager.SCROLL_STATE_IDLE, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            return (ViewPager.this.mAdapter == null || ViewPager.this.mAdapter.getCount() <= ViewPager.SCROLL_STATE_DRAGGING) ? ViewPager.DEBUG : true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == SpdyProtocol.SLIGHTSSL_0_RTT_MODE && ViewPager.this.mAdapter != null) {
                asRecord.setItemCount(ViewPager.this.mAdapter.getCount());
                asRecord.setFromIndex(ViewPager.this.mCurItem);
                asRecord.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (ViewPager.this.canScrollHorizontally(ViewPager.SCROLL_STATE_DRAGGING)) {
                accessibilityNodeInfoCompat.addAction((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
            }
            if (ViewPager.this.canScrollHorizontally(ViewPager.INVALID_POINTER)) {
                accessibilityNodeInfoCompat.addAction((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                    if (!ViewPager.this.canScrollHorizontally(ViewPager.SCROLL_STATE_DRAGGING)) {
                        return ViewPager.DEBUG;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + ViewPager.SCROLL_STATE_DRAGGING);
                    return true;
                case SpdyProtocol.SLIGHTSSL_1_RTT_MODE /*8192*/:
                    if (!ViewPager.this.canScrollHorizontally(ViewPager.INVALID_POINTER)) {
                        return ViewPager.DEBUG;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + ViewPager.INVALID_POINTER);
                    return true;
                default:
                    return ViewPager.DEBUG;
            }
        }
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    private class PagerObserver extends DataSetObserver {
        private PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        /* renamed from: android.support.v4.view.ViewPager.SavedState.1 */
        static class C02911 implements ParcelableCompatCreatorCallbacks<SavedState> {
            C02911() {
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new C02911());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            return layoutParams.isDecor != layoutParams2.isDecor ? layoutParams.isDecor ? ViewPager.SCROLL_STATE_DRAGGING : ViewPager.INVALID_POINTER : layoutParams.position - layoutParams2.position;
        }
    }

    static {
        int[] iArr = new int[SCROLL_STATE_DRAGGING];
        iArr[SCROLL_STATE_IDLE] = 16842931;
        LAYOUT_ATTRS = iArr;
        COMPARATOR = new C02871();
        sInterpolator = new C02882();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = INVALID_POINTER;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = AutoScrollHelper.NO_MAX;
        this.mOffscreenPageLimit = SCROLL_STATE_DRAGGING;
        this.mActivePointerId = INVALID_POINTER;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = DEBUG;
        this.mEndScrollRunnable = new C02893();
        this.mScrollState = SCROLL_STATE_IDLE;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = INVALID_POINTER;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = AutoScrollHelper.NO_MAX;
        this.mOffscreenPageLimit = SCROLL_STATE_DRAGGING;
        this.mActivePointerId = INVALID_POINTER;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = DEBUG;
        this.mEndScrollRunnable = new C02893();
        this.mScrollState = SCROLL_STATE_IDLE;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        float f;
        int i2;
        ItemInfo itemInfo3;
        int i3;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            clientWidth = itemInfo2.position;
            int i4;
            if (clientWidth < itemInfo.position) {
                f = (itemInfo2.offset + itemInfo2.widthFactor) + f2;
                i4 = clientWidth + SCROLL_STATE_DRAGGING;
                i2 = SCROLL_STATE_IDLE;
                while (i4 <= itemInfo.position && i2 < this.mItems.size()) {
                    itemInfo3 = (ItemInfo) this.mItems.get(i2);
                    while (i4 > itemInfo3.position && i2 < this.mItems.size() + INVALID_POINTER) {
                        i2 += SCROLL_STATE_DRAGGING;
                        itemInfo3 = (ItemInfo) this.mItems.get(i2);
                    }
                    while (i4 < itemInfo3.position) {
                        f += this.mAdapter.getPageWidth(i4) + f2;
                        i4 += SCROLL_STATE_DRAGGING;
                    }
                    itemInfo3.offset = f;
                    f += itemInfo3.widthFactor + f2;
                    i4 += SCROLL_STATE_DRAGGING;
                }
            } else if (clientWidth > itemInfo.position) {
                i2 = this.mItems.size() + INVALID_POINTER;
                f = itemInfo2.offset;
                i4 = clientWidth + INVALID_POINTER;
                while (i4 >= itemInfo.position && i2 >= 0) {
                    itemInfo3 = (ItemInfo) this.mItems.get(i2);
                    while (i4 < itemInfo3.position && i2 > 0) {
                        i2 += INVALID_POINTER;
                        itemInfo3 = (ItemInfo) this.mItems.get(i2);
                    }
                    while (i4 > itemInfo3.position) {
                        f -= this.mAdapter.getPageWidth(i4) + f2;
                        i4 += INVALID_POINTER;
                    }
                    f -= itemInfo3.widthFactor + f2;
                    itemInfo3.offset = f;
                    i4 += INVALID_POINTER;
                }
            }
        }
        int size = this.mItems.size();
        float f3 = itemInfo.offset;
        i2 = itemInfo.position + INVALID_POINTER;
        this.mFirstOffset = itemInfo.position == 0 ? itemInfo.offset : -3.4028235E38f;
        this.mLastOffset = itemInfo.position == count + INVALID_POINTER ? (itemInfo.offset + itemInfo.widthFactor) - 1.0f : AutoScrollHelper.NO_MAX;
        for (i3 = i + INVALID_POINTER; i3 >= 0; i3 += INVALID_POINTER) {
            itemInfo3 = (ItemInfo) this.mItems.get(i3);
            f = f3;
            while (i2 > itemInfo3.position) {
                f -= this.mAdapter.getPageWidth(i2) + f2;
                i2 += INVALID_POINTER;
            }
            f3 = f - (itemInfo3.widthFactor + f2);
            itemInfo3.offset = f3;
            if (itemInfo3.position == 0) {
                this.mFirstOffset = f3;
            }
            i2 += INVALID_POINTER;
        }
        f3 = (itemInfo.offset + itemInfo.widthFactor) + f2;
        i2 = itemInfo.position + SCROLL_STATE_DRAGGING;
        for (i3 = i + SCROLL_STATE_DRAGGING; i3 < size; i3 += SCROLL_STATE_DRAGGING) {
            itemInfo3 = (ItemInfo) this.mItems.get(i3);
            f = f3;
            while (i2 < itemInfo3.position) {
                f = (this.mAdapter.getPageWidth(i2) + f2) + f;
                i2 += SCROLL_STATE_DRAGGING;
            }
            if (itemInfo3.position == count + INVALID_POINTER) {
                this.mLastOffset = (itemInfo3.widthFactor + f) - 1.0f;
            }
            itemInfo3.offset = f;
            f3 = f + (itemInfo3.widthFactor + f2);
            i2 += SCROLL_STATE_DRAGGING;
        }
        this.mNeedCalculatePageOffsets = DEBUG;
    }

    private void completeScroll(boolean z) {
        int scrollX;
        boolean z2 = this.mScrollState == SCROLL_STATE_SETTLING ? SCROLL_STATE_DRAGGING : DEBUG;
        if (z2) {
            setScrollingCacheEnabled(DEBUG);
            if (!this.mScroller.isFinished() ? SCROLL_STATE_DRAGGING : DEBUG) {
                this.mScroller.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = DEBUG;
        boolean z3 = z2;
        for (scrollX = SCROLL_STATE_IDLE; scrollX < this.mItems.size(); scrollX += SCROLL_STATE_DRAGGING) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(scrollX);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = DEBUG;
                z3 = SCROLL_STATE_DRAGGING;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i = (int) ((i >= this.mCurItem ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i += SCROLL_STATE_DRAGGING;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        return Math.max(((ItemInfo) this.mItems.get(SCROLL_STATE_IDLE)).position, Math.min(i, ((ItemInfo) this.mItems.get(this.mItems.size() + INVALID_POINTER)).position));
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = SCROLL_STATE_IDLE; i3 < size; i3 += SCROLL_STATE_DRAGGING) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = SCROLL_STATE_IDLE; i2 < size; i2 += SCROLL_STATE_DRAGGING) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = SCROLL_STATE_IDLE; i2 < size; i2 += SCROLL_STATE_DRAGGING) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = SCROLL_STATE_IDLE; i < childCount; i += SCROLL_STATE_DRAGGING) {
            ViewCompat.setLayerType(getChildAt(i), z ? SCROLL_STATE_SETTLING : SCROLL_STATE_IDLE, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = DEBUG;
        this.mIsUnableToDrag = DEBUG;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(SCROLL_STATE_IDLE, SCROLL_STATE_IDLE, SCROLL_STATE_IDLE, SCROLL_STATE_IDLE);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = INVALID_POINTER;
        int i2 = SCROLL_STATE_IDLE;
        Object obj = SCROLL_STATE_DRAGGING;
        ItemInfo itemInfo = null;
        while (i2 < this.mItems.size()) {
            int i3;
            ItemInfo itemInfo2;
            ItemInfo itemInfo3 = (ItemInfo) this.mItems.get(i2);
            ItemInfo itemInfo4;
            if (obj != null || itemInfo3.position == i + SCROLL_STATE_DRAGGING) {
                itemInfo4 = itemInfo3;
                i3 = i2;
                itemInfo2 = itemInfo4;
            } else {
                itemInfo3 = this.mTempItem;
                itemInfo3.offset = (f2 + f3) + f;
                itemInfo3.position = i + SCROLL_STATE_DRAGGING;
                itemInfo3.widthFactor = this.mAdapter.getPageWidth(itemInfo3.position);
                itemInfo4 = itemInfo3;
                i3 = i2 + INVALID_POINTER;
                itemInfo2 = itemInfo4;
            }
            f2 = itemInfo2.offset;
            f3 = (itemInfo2.widthFactor + f2) + f;
            if (obj == null && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f3 || i3 == this.mItems.size() + INVALID_POINTER) {
                return itemInfo2;
            }
            f3 = f2;
            i = itemInfo2.position;
            obj = SCROLL_STATE_IDLE;
            f2 = itemInfo2.widthFactor;
            itemInfo = itemInfo2;
            i2 = i3 + SCROLL_STATE_DRAGGING;
        }
        return itemInfo;
    }

    private boolean isGutterDrag(float f, float f2) {
        return ((f >= ((float) this.mGutterSize) || f2 <= 0.0f) && (f <= ((float) (getWidth() - this.mGutterSize)) || f2 >= 0.0f)) ? DEBUG : true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
            this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin + clientWidth;
            float f = ((float) this.mPageMargin) / ((float) clientWidth);
            int i3 = infoForCurrentScrollPosition.position;
            float f2 = ((((float) i) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + f);
            clientWidth = (int) (((float) i2) * f2);
            this.mCalledSuper = DEBUG;
            onPageScrolled(i3, f2, clientWidth);
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return DEBUG;
        } else {
            this.mCalledSuper = DEBUG;
            onPageScrolled(SCROLL_STATE_IDLE, 0.0f, SCROLL_STATE_IDLE);
            if (this.mCalledSuper) {
                return DEBUG;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = DEBUG;
        float f3 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(SCROLL_STATE_IDLE);
        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() + INVALID_POINTER);
        if (itemInfo.position != 0) {
            f4 = itemInfo.offset * ((float) clientWidth);
            z = DEBUG;
        } else {
            z = SCROLL_STATE_DRAGGING;
        }
        if (itemInfo2.position != this.mAdapter.getCount() + INVALID_POINTER) {
            f2 = itemInfo2.offset * ((float) clientWidth);
            z2 = DEBUG;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.mLeftEdge.onPull(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.mRightEdge.onPull(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.mLastMotionX += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        pageScrolled((int) f4);
        return z3;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(DEBUG);
                scrollTo(min, getScrollY());
            }
        } else if (this.mScroller.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void removeNonDecorViews() {
        int i = SCROLL_STATE_IDLE;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i += INVALID_POINTER;
            }
            i += SCROLL_STATE_DRAGGING;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = INVALID_POINTER;
        endDrag();
        return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int max;
        ItemInfo infoForPosition = infoForPosition(i);
        if (infoForPosition != null) {
            max = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            max = SCROLL_STATE_IDLE;
        }
        if (z) {
            smoothScrollTo(max, SCROLL_STATE_IDLE, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(DEBUG);
        scrollTo(max, SCROLL_STATE_IDLE);
        pageScrolled(max);
    }

    private void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0 ? true : DEBUG);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = SCROLL_STATE_IDLE; i < childCount; i += SCROLL_STATE_DRAGGING) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = SCROLL_STATE_IDLE; i3 < getChildCount(); i3 += SCROLL_STATE_DRAGGING) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == AccessibilityNodeInfoCompat.ACTION_EXPAND && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & SCROLL_STATE_DRAGGING) != SCROLL_STATE_DRAGGING || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i2, itemInfo);
        }
        return itemInfo;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = SCROLL_STATE_IDLE; i < getChildCount(); i += SCROLL_STATE_DRAGGING) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.isDecor |= view instanceof Decor;
        if (!this.mInLayout) {
            super.addView(view, i, generateLayoutParams);
        } else if (layoutParams2 == null || !layoutParams2.isDecor) {
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean arrowScroll(int i) {
        View view;
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = SCROLL_STATE_DRAGGING;
                        break;
                    }
                }
                obj = SCROLL_STATE_IDLE;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == SCROLL_STATE_DRAGGING) {
                pageLeft = pageLeft();
            } else {
                if (i == 66 || i == SCROLL_STATE_SETTLING) {
                    pageLeft = pageRight();
                }
                pageLeft = DEBUG;
            }
        } else if (i == 17) {
            pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left < getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageLeft();
        } else {
            if (i == 66) {
                pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left > getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageRight();
            }
            pageLeft = DEBUG;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return pageLeft;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return DEBUG;
        }
        this.mFakeDragging = true;
        setScrollState(SCROLL_STATE_DRAGGING);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, SCROLL_STATE_IDLE, 0.0f, 0.0f, SCROLL_STATE_IDLE);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() + INVALID_POINTER; childCount >= 0; childCount += INVALID_POINTER) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return (z && ViewCompat.canScrollHorizontally(view, -i)) ? true : DEBUG;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.mAdapter == null) {
            return DEBUG;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.mFirstOffset))) {
                z = DEBUG;
            }
            return z;
        } else if (i <= 0) {
            return DEBUG;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
                z = DEBUG;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) ? true : DEBUG;
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(SCROLL_STATE_IDLE, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = (this.mItems.size() >= (this.mOffscreenPageLimit * SCROLL_STATE_SETTLING) + SCROLL_STATE_DRAGGING || this.mItems.size() >= count) ? DEBUG : true;
        boolean z2 = DEBUG;
        int i = this.mCurItem;
        boolean z3 = z;
        int i2 = SCROLL_STATE_IDLE;
        while (i2 < this.mItems.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition == INVALID_POINTER) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (itemPosition == -2) {
                this.mItems.remove(i2);
                i2 += INVALID_POINTER;
                if (!z2) {
                    this.mAdapter.startUpdate((ViewGroup) this);
                    z2 = true;
                }
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                if (this.mCurItem == itemInfo.position) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(SCROLL_STATE_IDLE, Math.min(this.mCurItem, count + INVALID_POINTER));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (itemInfo.position != itemPosition) {
                if (itemInfo.position == this.mCurItem) {
                    i = itemPosition;
                }
                itemInfo.position = itemPosition;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + SCROLL_STATE_DRAGGING;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z3) {
            i4 = getChildCount();
            for (i2 = SCROLL_STATE_IDLE; i2 < i4; i2 += SCROLL_STATE_DRAGGING) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, DEBUG, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) ? true : DEBUG;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = SCROLL_STATE_IDLE; i < childCount; i += SCROLL_STATE_DRAGGING) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return DEBUG;
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = SCROLL_STATE_IDLE;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == SCROLL_STATE_DRAGGING && this.mAdapter != null && this.mAdapter.getCount() > SCROLL_STATE_DRAGGING)) {
            int height;
            int width;
            if (!this.mLeftEdge.isFinished()) {
                overScrollMode = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                i = SCROLL_STATE_IDLE | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
            if (!this.mRightEdge.isFinished()) {
                overScrollMode = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
                this.mRightEdge.setSize(width, height);
                i |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (i != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE, (float) this.mMaximumVelocity);
                int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = DEBUG;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return DEBUG;
        }
        switch (keyEvent.getKeyCode()) {
            case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                return arrowScroll(17);
            case C4209a.f14215r /*22*/:
                return arrowScroll(66);
            case C1692R.styleable.AppCompatTheme_popupWindowStyle /*61*/:
                return VERSION.SDK_INT >= 11 ? KeyEventCompat.hasNoModifiers(keyEvent) ? arrowScroll(SCROLL_STATE_SETTLING) : KeyEventCompat.hasModifiers(keyEvent, SCROLL_STATE_DRAGGING) ? arrowScroll(SCROLL_STATE_DRAGGING) : DEBUG : DEBUG;
            default:
                return DEBUG;
        }
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f2 = ((float) clientWidth) * this.mLastOffset;
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(SCROLL_STATE_IDLE);
            ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() + INVALID_POINTER);
            float f3 = itemInfo.position != 0 ? itemInfo.offset * ((float) clientWidth) : ((float) clientWidth) * this.mFirstOffset;
            float f4 = itemInfo2.position != this.mAdapter.getCount() + INVALID_POINTER ? itemInfo2.offset * ((float) clientWidth) : f2;
            if (scrollX >= f3) {
                f3 = scrollX > f4 ? f4 : scrollX;
            }
            this.mLastMotionX += f3 - ((float) ((int) f3));
            scrollTo((int) f3, getScrollY());
            pageScrolled((int) f3);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), SCROLL_STATE_SETTLING, this.mLastMotionX, 0.0f, SCROLL_STATE_IDLE);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == SCROLL_STATE_SETTLING) {
            i2 = (i + INVALID_POINTER) - i2;
        }
        return ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.view.ViewPager.ItemInfo infoForAnyChild(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = (android.view.View) r0;
        r3 = r0;
        goto L_0x0000;
    L_0x0012:
        r0 = r2.infoForChild(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.infoForAnyChild(android.view.View):android.support.v4.view.ViewPager$ItemInfo");
    }

    ItemInfo infoForChild(View view) {
        for (int i = SCROLL_STATE_IDLE; i < this.mItems.size(); i += SCROLL_STATE_DRAGGING) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i) {
        for (int i2 = SCROLL_STATE_IDLE; i2 < this.mItems.size(); i2 += SCROLL_STATE_DRAGGING) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            if (itemInfo.position == i) {
                return itemInfo;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(DEBUG);
        setDescendantFocusability(AccessibilityNodeInfoCompat.ACTION_EXPAND);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(context);
        this.mRightEdge = new EdgeEffectCompat(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, SCROLL_STATE_DRAGGING);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new C02904());
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        if (!(this.mScroller == null || this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.mPageMargin) / ((float) width);
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(SCROLL_STATE_IDLE);
            float f2 = itemInfo.offset;
            int size = this.mItems.size();
            int i = itemInfo.position;
            int i2 = ((ItemInfo) this.mItems.get(size + INVALID_POINTER)).position;
            int i3 = SCROLL_STATE_IDLE;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > itemInfo.position && i3 < size) {
                    i3 += SCROLL_STATE_DRAGGING;
                    itemInfo = (ItemInfo) this.mItems.get(i3);
                }
                if (i4 == itemInfo.position) {
                    f3 = (itemInfo.offset + itemInfo.widthFactor) * ((float) width);
                    f2 = (itemInfo.offset + itemInfo.widthFactor) + f;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i4);
                    f3 = (f2 + pageWidth) * ((float) width);
                    f2 += pageWidth + f;
                }
                if (((float) this.mPageMargin) + f3 > ((float) scrollX)) {
                    this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f3), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4 += SCROLL_STATE_DRAGGING;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 3 || action == SCROLL_STATE_DRAGGING) {
            resetTouch();
            return DEBUG;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return DEBUG;
            }
        }
        switch (action) {
            case SCROLL_STATE_IDLE /*0*/:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, SCROLL_STATE_IDLE);
                this.mIsUnableToDrag = DEBUG;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == SCROLL_STATE_SETTLING && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = DEBUG;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(SCROLL_STATE_DRAGGING);
                    break;
                }
                completeScroll(DEBUG);
                this.mIsBeingDragged = DEBUG;
                break;
            case SCROLL_STATE_SETTLING /*2*/:
                action = this.mActivePointerId;
                if (action != INVALID_POINTER) {
                    action = MotionEventCompat.findPointerIndex(motionEvent, action);
                    float x2 = MotionEventCompat.getX(motionEvent, action);
                    float f = x2 - this.mLastMotionX;
                    float abs = Math.abs(f);
                    float y = MotionEventCompat.getY(motionEvent, action);
                    float abs2 = Math.abs(y - this.mInitialMotionY);
                    if (f == 0.0f || isGutterDrag(this.mLastMotionX, f) || !canScroll(this, DEBUG, (int) f, (int) x2, (int) y)) {
                        if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            setScrollState(SCROLL_STATE_DRAGGING);
                            this.mLastMotionX = f > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                            this.mLastMotionY = y;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.mTouchSlop)) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && performDrag(x2)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                            break;
                        }
                    }
                    this.mLastMotionX = x2;
                    this.mLastMotionY = y;
                    this.mIsUnableToDrag = true;
                    return DEBUG;
                }
                break;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = SCROLL_STATE_IDLE;
        int i8 = SCROLL_STATE_IDLE;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i9 = layoutParams.gravity & 112;
                    switch (layoutParams.gravity & 7) {
                        case SCROLL_STATE_DRAGGING /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / SCROLL_STATE_SETTLING, paddingLeft);
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case DEFAULT_GUTTER_SIZE /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / SCROLL_STATE_SETTLING, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case C1692R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + SCROLL_STATE_DRAGGING;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8 += SCROLL_STATE_DRAGGING;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8 += SCROLL_STATE_DRAGGING;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = SCROLL_STATE_IDLE; paddingRight < childCount; paddingRight += SCROLL_STATE_DRAGGING) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.isDecor) {
                    ItemInfo infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        i5 = ((int) (infoForChild.offset * ((float) max))) + paddingLeft;
                        if (layoutParams.needsMeasure) {
                            layoutParams.needsMeasure = DEBUG;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.widthFactor * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i6 - paddingBottom;
        this.mDecorChildCount = i7;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, DEBUG, SCROLL_STATE_IDLE, DEBUG);
        }
        this.mFirstLayout = DEBUG;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(SCROLL_STATE_IDLE, i), getDefaultSize(SCROLL_STATE_IDLE, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = SCROLL_STATE_IDLE; i4 < childCount; i4 += SCROLL_STATE_DRAGGING) {
            LayoutParams layoutParams;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.isDecor) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & 112;
                    i3 = LinearLayoutManager.INVALID_OFFSET;
                    i5 = LinearLayoutManager.INVALID_OFFSET;
                    Object obj = (i7 == 48 || i7 == 80) ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
                    Object obj2 = (i6 == 3 || i6 == 5) ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != INVALID_POINTER ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != INVALID_POINTER) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = DEBUG;
        i3 = getChildCount();
        for (i5 = SCROLL_STATE_IDLE; i5 < i3; i5 += SCROLL_STATE_DRAGGING) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.isDecor) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.widthFactor * ((float) paddingLeft)), 1073741824), this.mChildHeightMeasureSpec);
                }
            }
        }
    }

    protected void onPageScrolled(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = SCROLL_STATE_IDLE;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case SCROLL_STATE_DRAGGING /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / SCROLL_STATE_SETTLING, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3 += SCROLL_STATE_DRAGGING;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = SCROLL_STATE_IDLE; paddingLeft < i3; paddingLeft += SCROLL_STATE_DRAGGING) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = INVALID_POINTER;
        int childCount = getChildCount();
        if ((i & SCROLL_STATE_SETTLING) != 0) {
            i3 = SCROLL_STATE_DRAGGING;
            i2 = SCROLL_STATE_IDLE;
        } else {
            i2 = childCount + INVALID_POINTER;
            childCount = INVALID_POINTER;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return DEBUG;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
                setCurrentItemInternal(savedState.position, DEBUG, true);
                return;
            }
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.adapterState = this.mAdapter.saveState();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = DEBUG;
        if (this.mFakeDragging) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return DEBUG;
        }
        if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            return DEBUG;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        int xVelocity;
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case SCROLL_STATE_IDLE /*0*/:
                this.mScroller.abortAnimation();
                this.mPopulatePending = DEBUG;
                populate();
                x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, SCROLL_STATE_IDLE);
                break;
            case SCROLL_STATE_DRAGGING /*1*/:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE, (float) this.mMaximumVelocity);
                    xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                    this.mPopulatePending = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (((float) this.mPageMargin) / ((float) clientWidth))), xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                    z = resetTouch();
                    break;
                }
                break;
            case SCROLL_STATE_SETTLING /*2*/:
                if (!this.mIsBeingDragged) {
                    xVelocity = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (xVelocity == INVALID_POINTER) {
                        z = resetTouch();
                        break;
                    }
                    float x2 = MotionEventCompat.getX(motionEvent, xVelocity);
                    float abs = Math.abs(x2 - this.mLastMotionX);
                    float y = MotionEventCompat.getY(motionEvent, xVelocity);
                    x = Math.abs(y - this.mLastMotionY);
                    if (abs > ((float) this.mTouchSlop) && abs > x) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        this.mLastMotionX = x2 - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                        this.mLastMotionY = y;
                        setScrollState(SCROLL_STATE_DRAGGING);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = DEBUG | performDrag(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)));
                    break;
                }
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, SCROLL_STATE_IDLE, DEBUG);
                    z = resetTouch();
                    break;
                }
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                xVelocity = MotionEventCompat.getActionIndex(motionEvent);
                this.mLastMotionX = MotionEventCompat.getX(motionEvent, xVelocity);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, xVelocity);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                break;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + INVALID_POINTER, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() + INVALID_POINTER) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + SCROLL_STATE_DRAGGING, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void populate(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.mCurItem;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.mCurItem;
        r0 = r17;
        r2 = r0.infoForPosition(r2);
        r0 = r18;
        r1 = r17;
        r1.mCurItem = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.mAdapter;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.sortChildDrawingOrder();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.mPopulatePending;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.sortChildDrawingOrder();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.mAdapter;
        r0 = r17;
        r2.startUpdate(r0);
        r0 = r17;
        r2 = r0.mOffscreenPageLimit;
        r4 = 0;
        r0 = r17;
        r5 = r0.mCurItem;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.mAdapter;
        r11 = r4.getCount();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.mCurItem;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.mExpectedAdapterCount;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.mExpectedAdapterCount;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.mAdapter;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        r6 = r2.position;
        r0 = r17;
        r7 = r0.mCurItem;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.position;
        r0 = r17;
        r7 = r0.mCurItem;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.mCurItem;
        r0 = r17;
        r2 = r0.addNewItem(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.mCurItem;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.widthFactor;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.mCurItem;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.calculatePageOffsets(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.mAdapter;
        r0 = r17;
        r4 = r0.mCurItem;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.object;
    L_0x0179:
        r0 = r17;
        r3.setPrimaryItem(r0, r4, r2);
        r0 = r17;
        r2 = r0.mAdapter;
        r0 = r17;
        r2.finishUpdate(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.childIndex = r3;
        r6 = r2.isDecor;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.widthFactor;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.infoForChild(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.widthFactor;
        r2.widthFactor = r6;
        r5 = r5.position;
        r2.position = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.widthFactor;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.position;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.scrolling;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.mItems;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.mAdapter;
        r2 = r2.object;
        r0 = r17;
        r14.destroyItem(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.position;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.widthFactor;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.addNewItem(r8, r2);
        r2 = r2.widthFactor;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.position;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.scrolling;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.mItems;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.mAdapter;
        r2 = r2.object;
        r0 = r17;
        r10.destroyItem(r0, r8, r2);
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.position;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.widthFactor;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.addNewItem(r8, r6);
        r6 = r6 + 1;
        r2 = r2.widthFactor;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.sortChildDrawingOrder();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.infoForAnyChild(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.position;
        r0 = r17;
        r3 = r0.mCurItem;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.infoForChild(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.position;
        r0 = r17;
        r5 = r0.mCurItem;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = SCROLL_STATE_IDLE; i < this.mItems.size(); i += SCROLL_STATE_DRAGGING) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = SCROLL_STATE_IDLE;
            scrollTo(SCROLL_STATE_IDLE, SCROLL_STATE_IDLE);
        }
        PagerAdapter pagerAdapter2 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = SCROLL_STATE_IDLE;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = DEBUG;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, DEBUG, true);
                this.mRestoredCurItem = INVALID_POINTER;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListener != null && pagerAdapter2 != pagerAdapter) {
            this.mAdapterChangeListener.onAdapterChanged(pagerAdapter2, pagerAdapter);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    Class[] clsArr = new Class[SCROLL_STATE_DRAGGING];
                    clsArr[SCROLL_STATE_IDLE] = Boolean.TYPE;
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", clsArr);
                } catch (Throwable e) {
                    Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                Method method = this.mSetChildrenDrawingOrderEnabled;
                Object[] objArr = new Object[SCROLL_STATE_DRAGGING];
                objArr[SCROLL_STATE_IDLE] = Boolean.valueOf(z);
                method.invoke(this, objArr);
            } catch (Throwable e2) {
                Log.e(TAG, "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(i, !this.mFirstLayout ? true : DEBUG, DEBUG);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(i, z, DEBUG);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, SCROLL_STATE_IDLE);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        boolean z3 = DEBUG;
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(DEBUG);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = SCROLL_STATE_IDLE;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() + INVALID_POINTER;
            }
            int i3 = this.mOffscreenPageLimit;
            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                for (int i4 = SCROLL_STATE_IDLE; i4 < this.mItems.size(); i4 += SCROLL_STATE_DRAGGING) {
                    ((ItemInfo) this.mItems.get(i4)).scrolling = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(DEBUG);
        }
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < SCROLL_STATE_DRAGGING) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to " + SCROLL_STATE_DRAGGING);
            i = SCROLL_STATE_DRAGGING;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.mAdapterChangeListener = onAdapterChangeListener;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : DEBUG);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        int i = SCROLL_STATE_DRAGGING;
        if (VERSION.SDK_INT >= 11) {
            boolean z2 = pageTransformer != null ? true : DEBUG;
            int i2 = z2 != (this.mPageTransformer != null ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE) ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
            this.mPageTransformer = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = SCROLL_STATE_SETTLING;
                }
                this.mDrawingOrder = i;
            } else {
                this.mDrawingOrder = SCROLL_STATE_IDLE;
            }
            if (i2 != 0) {
                populate();
            }
        }
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, SCROLL_STATE_IDLE);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        int i4;
        boolean z = (this.mScroller == null || this.mScroller.isFinished()) ? DEBUG : true;
        if (z) {
            int currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(DEBUG);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(DEBUG);
            populate();
            setScrollState(SCROLL_STATE_IDLE);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(SCROLL_STATE_SETTLING);
        currX = getClientWidth();
        int i7 = currX / SCROLL_STATE_SETTLING;
        float distanceInfluenceForSnapDuration = (((float) i7) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        i7 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f), MAX_SETTLE_DURATION);
        this.mIsScrollStarted = DEBUG;
        this.mScroller.startScroll(i4, scrollY, i5, i6, i7);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) ? true : DEBUG;
    }
}
