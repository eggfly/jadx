package com.antutu.utils.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Scroller;
import com.antutu.ABenchMark.C1082R;
import com.taobao.accs.flowcontrol.FlowControl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.android.spdy.SpdyProtocol;

public class ViewFlow extends AdapterView<Adapter> {
    private static final int INVALID_SCREEN = -1;
    private static final int SNAP_VELOCITY = 1000;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private Adapter mAdapter;
    private int mCurrentAdapterIndex;
    private int mCurrentBufferIndex;
    private int mCurrentScreen;
    private AdapterDataSetObserver mDataSetObserver;
    private boolean mFirstLayout;
    private FlowIndicator mIndicator;
    private float mLastMotionX;
    private int mLastOrientation;
    private int mLastScrollDirection;
    private LinkedList<View> mLoadedViews;
    private int mMaximumVelocity;
    private int mNextScreen;
    private Scroller mScroller;
    private int mSideBuffer;
    private int mTouchSlop;
    private int mTouchState;
    private VelocityTracker mVelocityTracker;
    private ViewSwitchListener mViewSwitchListener;
    private OnGlobalLayoutListener orientationChangeListener;

    public interface ViewSwitchListener {
        void onSwitched(View view, int i);
    }

    /* renamed from: com.antutu.utils.widget.ViewFlow.1 */
    class C18381 implements OnGlobalLayoutListener {
        C18381() {
        }

        public void onGlobalLayout() {
            ViewFlow.this.getViewTreeObserver().removeGlobalOnLayoutListener(ViewFlow.this.orientationChangeListener);
            ViewFlow.this.setSelection(ViewFlow.this.mCurrentAdapterIndex);
        }
    }

    class AdapterDataSetObserver extends DataSetObserver {
        AdapterDataSetObserver() {
        }

        public void onChanged() {
            View childAt = ViewFlow.this.getChildAt(ViewFlow.this.mCurrentBufferIndex);
            if (childAt != null) {
                for (int i = ViewFlow.TOUCH_STATE_REST; i < ViewFlow.this.mAdapter.getCount(); i += ViewFlow.TOUCH_STATE_SCROLLING) {
                    if (childAt.equals(ViewFlow.this.mAdapter.getItem(i))) {
                        ViewFlow.this.mCurrentAdapterIndex = i;
                        break;
                    }
                }
            }
            ViewFlow.this.resetFocus();
        }

        public void onInvalidated() {
        }
    }

    public ViewFlow(Context context) {
        super(context);
        this.mSideBuffer = 2;
        this.mTouchState = TOUCH_STATE_REST;
        this.mNextScreen = INVALID_SCREEN;
        this.mFirstLayout = true;
        this.mLastOrientation = INVALID_SCREEN;
        this.orientationChangeListener = new C18381();
        this.mSideBuffer = 3;
        init();
    }

    public ViewFlow(Context context, int i) {
        super(context);
        this.mSideBuffer = 2;
        this.mTouchState = TOUCH_STATE_REST;
        this.mNextScreen = INVALID_SCREEN;
        this.mFirstLayout = true;
        this.mLastOrientation = INVALID_SCREEN;
        this.orientationChangeListener = new C18381();
        this.mSideBuffer = i;
        init();
    }

    public ViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSideBuffer = 2;
        this.mTouchState = TOUCH_STATE_REST;
        this.mNextScreen = INVALID_SCREEN;
        this.mFirstLayout = true;
        this.mLastOrientation = INVALID_SCREEN;
        this.orientationChangeListener = new C18381();
        this.mSideBuffer = context.obtainStyledAttributes(attributeSet, C1082R.styleable.ViewFlow).getInt(TOUCH_STATE_REST, 3);
        init();
    }

    private void init() {
        this.mLoadedViews = new LinkedList();
        this.mScroller = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void logBuffer() {
    }

    private View makeAndAddView(int i, boolean z, View view) {
        return setupChild(this.mAdapter.getView(i, view, this), z, view != null);
    }

    private void postViewSwitched(int i) {
        View view = null;
        if (i != 0) {
            int i2;
            if (i > 0) {
                this.mCurrentAdapterIndex += TOUCH_STATE_SCROLLING;
                this.mCurrentBufferIndex += TOUCH_STATE_SCROLLING;
                if (this.mCurrentAdapterIndex > this.mSideBuffer) {
                    view = (View) this.mLoadedViews.removeFirst();
                    detachViewFromParent(view);
                    this.mCurrentBufferIndex += INVALID_SCREEN;
                }
                i2 = this.mCurrentAdapterIndex + this.mSideBuffer;
                if (i2 < this.mAdapter.getCount()) {
                    this.mLoadedViews.addLast(makeAndAddView(i2, true, view));
                }
            } else {
                this.mCurrentAdapterIndex += INVALID_SCREEN;
                this.mCurrentBufferIndex += INVALID_SCREEN;
                if ((this.mAdapter.getCount() + INVALID_SCREEN) - this.mCurrentAdapterIndex > this.mSideBuffer) {
                    view = (View) this.mLoadedViews.removeLast();
                    detachViewFromParent(view);
                }
                i2 = this.mCurrentAdapterIndex - this.mSideBuffer;
                if (i2 > INVALID_SCREEN) {
                    this.mLoadedViews.addFirst(makeAndAddView(i2, false, view));
                    this.mCurrentBufferIndex += TOUCH_STATE_SCROLLING;
                }
            }
            requestLayout();
            setVisibleView(this.mCurrentBufferIndex, true);
            if (this.mIndicator != null) {
                this.mIndicator.onSwitched((View) this.mLoadedViews.get(this.mCurrentBufferIndex), this.mCurrentAdapterIndex);
            }
            if (this.mViewSwitchListener != null) {
                this.mViewSwitchListener.onSwitched((View) this.mLoadedViews.get(this.mCurrentBufferIndex), this.mCurrentAdapterIndex);
            }
            logBuffer();
        }
    }

    private void resetFocus() {
        logBuffer();
        this.mLoadedViews.clear();
        removeAllViewsInLayout();
        for (int max = Math.max(TOUCH_STATE_REST, this.mCurrentAdapterIndex - this.mSideBuffer); max < Math.min(this.mAdapter.getCount(), (this.mCurrentAdapterIndex + this.mSideBuffer) + TOUCH_STATE_SCROLLING); max += TOUCH_STATE_SCROLLING) {
            this.mLoadedViews.addLast(makeAndAddView(max, true, null));
            if (max == this.mCurrentAdapterIndex) {
                this.mCurrentBufferIndex = this.mLoadedViews.size() + INVALID_SCREEN;
            }
        }
        logBuffer();
        requestLayout();
    }

    private void setVisibleView(int i, boolean z) {
        this.mCurrentScreen = Math.max(TOUCH_STATE_REST, Math.min(i, getChildCount() + INVALID_SCREEN));
        int width = (this.mCurrentScreen * getWidth()) - this.mScroller.getCurrX();
        this.mScroller.startScroll(this.mScroller.getCurrX(), this.mScroller.getCurrY(), width, TOUCH_STATE_REST, TOUCH_STATE_REST);
        if (width == 0) {
            onScrollChanged(this.mScroller.getCurrX() + width, this.mScroller.getCurrY(), this.mScroller.getCurrX() + width, this.mScroller.getCurrY());
        }
        if (z) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    private View setupChild(View view, boolean z, boolean z2) {
        int i = INVALID_SCREEN;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(INVALID_SCREEN, -2, TOUCH_STATE_REST);
        }
        if (z2) {
            if (!z) {
                i = TOUCH_STATE_REST;
            }
            attachViewToParent(view, i, layoutParams);
        } else {
            if (!z) {
                i = TOUCH_STATE_REST;
            }
            addViewInLayout(view, i, layoutParams, true);
        }
        return view;
    }

    private void snapToDestination() {
        int width = getWidth();
        snapToScreen((getScrollX() + (width / 2)) / width);
    }

    private void snapToScreen(int i) {
        this.mLastScrollDirection = i - this.mCurrentScreen;
        if (this.mScroller.isFinished()) {
            int max = Math.max(TOUCH_STATE_REST, Math.min(i, getChildCount() + INVALID_SCREEN));
            this.mNextScreen = max;
            int width = (max * getWidth()) - getScrollX();
            this.mScroller.startScroll(getScrollX(), TOUCH_STATE_REST, width, TOUCH_STATE_REST, Math.abs(width) * 2);
            invalidate();
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        } else if (this.mNextScreen != INVALID_SCREEN) {
            this.mCurrentScreen = Math.max(TOUCH_STATE_REST, Math.min(this.mNextScreen, getChildCount() + INVALID_SCREEN));
            this.mNextScreen = INVALID_SCREEN;
            postViewSwitched(this.mLastScrollDirection);
        }
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getSelectedItemPosition() {
        return this.mCurrentAdapterIndex;
    }

    public View getSelectedView() {
        return this.mCurrentBufferIndex < this.mLoadedViews.size() ? (View) this.mLoadedViews.get(this.mCurrentBufferIndex) : null;
    }

    public int getViewsCount() {
        return this.mAdapter.getCount();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation != this.mLastOrientation) {
            this.mLastOrientation = configuration.orientation;
            getViewTreeObserver().addOnGlobalLayoutListener(this.orientationChangeListener);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = TOUCH_STATE_SCROLLING;
        if (getChildCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case TOUCH_STATE_REST /*0*/:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = x;
                if (this.mScroller.isFinished()) {
                    i = TOUCH_STATE_REST;
                }
                this.mTouchState = i;
                return false;
            case TOUCH_STATE_SCROLLING /*1*/:
                if (this.mTouchState == TOUCH_STATE_SCROLLING) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(SNAP_VELOCITY, (float) this.mMaximumVelocity);
                    i = (int) velocityTracker.getXVelocity();
                    if (i > SNAP_VELOCITY && this.mCurrentScreen > 0) {
                        snapToScreen(this.mCurrentScreen + INVALID_SCREEN);
                    } else if (i >= FlowControl.DELAY_MAX_BRUSH || this.mCurrentScreen >= getChildCount() + INVALID_SCREEN) {
                        snapToDestination();
                    } else {
                        snapToScreen(this.mCurrentScreen + TOUCH_STATE_SCROLLING);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                }
                this.mTouchState = TOUCH_STATE_REST;
                return false;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (((int) Math.abs(x - this.mLastMotionX)) > this.mTouchSlop) {
                    action = TOUCH_STATE_SCROLLING;
                } else {
                    boolean z = false;
                }
                if (action != 0) {
                    this.mTouchState = TOUCH_STATE_SCROLLING;
                }
                if (this.mTouchState != TOUCH_STATE_SCROLLING) {
                    return false;
                }
                action = (int) (this.mLastMotionX - x);
                this.mLastMotionX = x;
                int scrollX = getScrollX();
                if (action < 0) {
                    if (scrollX > 0) {
                        scrollBy(Math.max(-scrollX, action), TOUCH_STATE_REST);
                    }
                } else if (action > 0) {
                    scrollX = (getChildAt(getChildCount() + INVALID_SCREEN).getRight() - scrollX) - getWidth();
                    if (scrollX > 0) {
                        scrollBy(Math.min(scrollX, action), TOUCH_STATE_REST);
                    }
                }
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.mTouchState = TOUCH_STATE_REST;
                return false;
            default:
                return false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = TOUCH_STATE_REST;
        for (int i6 = TOUCH_STATE_REST; i6 < childCount; i6 += TOUCH_STATE_SCROLLING) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, TOUCH_STATE_REST, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 1073741824 && !isInEditMode()) {
            throw new IllegalStateException("ViewFlow can only be used in EXACTLY mode.");
        } else if (MeasureSpec.getMode(i2) == 1073741824 || isInEditMode()) {
            int childCount = getChildCount();
            for (int i3 = TOUCH_STATE_REST; i3 < childCount; i3 += TOUCH_STATE_SCROLLING) {
                getChildAt(i3).measure(i, i2);
            }
            if (this.mFirstLayout) {
                this.mScroller.startScroll(TOUCH_STATE_REST, TOUCH_STATE_REST, this.mCurrentScreen * size, TOUCH_STATE_REST, TOUCH_STATE_REST);
                this.mFirstLayout = false;
            }
        } else {
            throw new IllegalStateException("ViewFlow can only be used in EXACTLY mode.");
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mIndicator != null) {
            this.mIndicator.onScrolled(((this.mCurrentAdapterIndex - this.mCurrentBufferIndex) * getWidth()) + i, i2, i3, i4);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = TOUCH_STATE_REST;
        if (getChildCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case TOUCH_STATE_REST /*0*/:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = x;
                if (!this.mScroller.isFinished()) {
                    i = TOUCH_STATE_SCROLLING;
                }
                this.mTouchState = i;
                return true;
            case TOUCH_STATE_SCROLLING /*1*/:
                if (this.mTouchState == TOUCH_STATE_SCROLLING) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(SNAP_VELOCITY, (float) this.mMaximumVelocity);
                    action = (int) velocityTracker.getXVelocity();
                    if (action > SNAP_VELOCITY && this.mCurrentScreen > 0) {
                        snapToScreen(this.mCurrentScreen + INVALID_SCREEN);
                    } else if (action >= FlowControl.DELAY_MAX_BRUSH || this.mCurrentScreen >= getChildCount() + INVALID_SCREEN) {
                        snapToDestination();
                    } else {
                        snapToScreen(this.mCurrentScreen + TOUCH_STATE_SCROLLING);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                }
                this.mTouchState = TOUCH_STATE_REST;
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (((int) Math.abs(x - this.mLastMotionX)) > this.mTouchSlop ? true : TOUCH_STATE_REST) {
                    this.mTouchState = TOUCH_STATE_SCROLLING;
                }
                if (this.mTouchState != TOUCH_STATE_SCROLLING) {
                    return true;
                }
                action = (int) (this.mLastMotionX - x);
                this.mLastMotionX = x;
                int scrollX = getScrollX();
                if (action < 0) {
                    if (scrollX <= 0) {
                        return true;
                    }
                    scrollBy(Math.max(-scrollX, action), TOUCH_STATE_REST);
                    return true;
                } else if (action <= 0) {
                    return true;
                } else {
                    scrollX = (getChildAt(getChildCount() + INVALID_SCREEN).getRight() - scrollX) - getWidth();
                    if (scrollX <= 0) {
                        return true;
                    }
                    scrollBy(Math.min(scrollX, action), TOUCH_STATE_REST);
                    return true;
                }
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                snapToDestination();
                this.mTouchState = TOUCH_STATE_REST;
                return true;
            default:
                return true;
        }
    }

    public void setAdapter(Adapter adapter) {
        setAdapter(adapter, TOUCH_STATE_REST);
    }

    public void setAdapter(Adapter adapter, int i) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            this.mDataSetObserver = new AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
        }
        if (this.mAdapter != null && this.mAdapter.getCount() != 0) {
            setSelection(i);
        }
    }

    public void setFlowIndicator(FlowIndicator flowIndicator) {
        this.mIndicator = flowIndicator;
        this.mIndicator.setViewFlow(this);
    }

    public void setOnViewSwitchListener(ViewSwitchListener viewSwitchListener) {
        this.mViewSwitchListener = viewSwitchListener;
    }

    public void setSelection(int i) {
        this.mNextScreen = INVALID_SCREEN;
        this.mScroller.forceFinished(true);
        if (this.mAdapter != null) {
            int min = Math.min(Math.max(i, TOUCH_STATE_REST), this.mAdapter.getCount() + INVALID_SCREEN);
            ArrayList arrayList = new ArrayList();
            while (!this.mLoadedViews.isEmpty()) {
                View view = (View) this.mLoadedViews.remove();
                arrayList.add(view);
                detachViewFromParent(view);
            }
            View makeAndAddView = makeAndAddView(min, true, arrayList.isEmpty() ? null : (View) arrayList.remove(TOUCH_STATE_REST));
            this.mLoadedViews.addLast(makeAndAddView);
            for (int i2 = TOUCH_STATE_SCROLLING; this.mSideBuffer - i2 >= 0; i2 += TOUCH_STATE_SCROLLING) {
                int i3 = min - i2;
                int i4 = min + i2;
                if (i3 >= 0) {
                    this.mLoadedViews.addFirst(makeAndAddView(i3, false, arrayList.isEmpty() ? null : (View) arrayList.remove(TOUCH_STATE_REST)));
                }
                if (i4 < this.mAdapter.getCount()) {
                    this.mLoadedViews.addLast(makeAndAddView(i4, true, arrayList.isEmpty() ? null : (View) arrayList.remove(TOUCH_STATE_REST)));
                }
            }
            this.mCurrentBufferIndex = this.mLoadedViews.indexOf(makeAndAddView);
            this.mCurrentAdapterIndex = min;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                removeDetachedView((View) it.next(), false);
            }
            requestLayout();
            setVisibleView(this.mCurrentBufferIndex, false);
            if (this.mIndicator != null) {
                this.mIndicator.onSwitched((View) this.mLoadedViews.get(this.mCurrentBufferIndex), this.mCurrentAdapterIndex);
            }
            if (this.mViewSwitchListener != null) {
                this.mViewSwitchListener.onSwitched((View) this.mLoadedViews.get(this.mCurrentBufferIndex), this.mCurrentAdapterIndex);
            }
        }
    }
}
