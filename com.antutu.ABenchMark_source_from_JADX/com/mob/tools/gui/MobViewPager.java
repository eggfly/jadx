package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.ads.AdError;
import org.android.spdy.SpdyProtocol;

public class MobViewPager extends ViewGroup {
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private float lastMotionX;
    private float lastMotionY;
    private int mMaximumVelocity;
    private VelocityTracker mVelocityTracker;
    private View nextPage;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private int touchSlop;
    private int touchState;

    /* renamed from: com.mob.tools.gui.MobViewPager.1 */
    class C40091 implements Interpolator {
        float[] values;

        C40091() {
            this.values = new float[]{0.0f, 0.0157073f, 0.0314108f, 0.0471065f, 0.0627905f, 0.0784591f, 0.0941083f, 0.109734f, 0.125333f, 0.140901f, 0.156434f, 0.171929f, 0.187381f, 0.202787f, 0.218143f, 0.233445f, 0.24869f, 0.263873f, 0.278991f, 0.29404f, 0.309017f, 0.323917f, 0.338738f, 0.353475f, 0.368125f, 0.382683f, 0.397148f, 0.411514f, 0.425779f, 0.439939f, 0.45399f, 0.46793f, 0.481754f, 0.495459f, 0.509041f, 0.522499f, 0.535827f, 0.549023f, 0.562083f, 0.575005f, 0.587785f, 0.60042f, 0.612907f, 0.625243f, 0.637424f, 0.649448f, 0.661312f, 0.673013f, 0.684547f, 0.695913f, 0.707107f, 0.718126f, 0.728969f, 0.739631f, 0.750111f, 0.760406f, 0.770513f, 0.78043f, 0.790155f, 0.799685f, 0.809017f, 0.81815f, 0.827081f, 0.835807f, 0.844328f, 0.85264f, 0.860742f, 0.868632f, 0.876307f, 0.883766f, 0.891007f, 0.898028f, 0.904827f, 0.911403f, 0.917755f, 0.92388f, 0.929776f, 0.935444f, 0.940881f, 0.946085f, 0.951057f, 0.955793f, 0.960294f, 0.964557f, 0.968583f, 0.97237f, 0.975917f, 0.979223f, 0.982287f, 0.985109f, 0.987688f, 0.990024f, 0.992115f, 0.993961f, 0.995562f, 0.996917f, 0.998027f, 0.99889f, 0.999507f, 0.999877f, 1.0f};
        }

        public float getInterpolation(float f) {
            return this.values[(int) (100.0f * f)];
        }
    }

    public MobViewPager(Context context) {
        this(context, null);
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TOUCH_STATE_REST);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.touchState = TOUCH_STATE_REST;
        init(context);
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int abs = (int) Math.abs(x - this.lastMotionX);
        if (((int) Math.abs(motionEvent.getY() - this.lastMotionY)) < abs && abs > this.touchSlop) {
            this.touchState = TOUCH_STATE_SCROLLING;
            this.lastMotionX = x;
        }
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        if (this.adapter != null) {
            float x = motionEvent.getX();
            int i = (int) (this.lastMotionX - x);
            this.lastMotionX = x;
            if (i < 0) {
                if (getScrollX() > 0) {
                    scrollBy(Math.max(-getScrollX(), i), TOUCH_STATE_REST);
                }
            } else if (i > 0 && getChildCount() != 0) {
                int right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth();
                if (right > 0) {
                    scrollBy(Math.min(right, i), TOUCH_STATE_REST);
                }
            }
        }
    }

    private void init(Context context) {
        this.scroller = new Scroller(getContext(), new C40091());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void onScreenChange(int i) {
        if (this.adapter != null) {
            int i2;
            int i3;
            View view;
            if (this.currentScreen > i) {
                for (i2 = TOUCH_STATE_REST; i2 < this.currentScreen - i; i2 += TOUCH_STATE_SCROLLING) {
                    i3 = (i + i2) + TOUCH_STATE_SCROLLING;
                    view = this.previousPage;
                    this.previousPage = this.currentPage;
                    this.currentPage = this.nextPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(TOUCH_STATE_REST);
                    }
                    if (i3 < this.screenCount - 1) {
                        this.nextPage = this.adapter.getView(i3 + TOUCH_STATE_SCROLLING, view, this);
                        addView(this.nextPage);
                    } else {
                        this.nextPage = view;
                    }
                }
            } else {
                for (i2 = TOUCH_STATE_REST; i2 < i - this.currentScreen; i2 += TOUCH_STATE_SCROLLING) {
                    i3 = (i - i2) - 1;
                    view = this.nextPage;
                    this.nextPage = this.currentPage;
                    this.currentPage = this.previousPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(2);
                    }
                    if (i3 > 0) {
                        this.previousPage = this.adapter.getView(i3 - 1, view, this);
                        addView(this.previousPage, TOUCH_STATE_REST);
                    } else {
                        this.previousPage = view;
                    }
                }
            }
            this.adapter.onScreenChange(this.currentScreen, i);
        }
    }

    public void computeScroll() {
        if (this.adapter != null && this.screenCount > 0) {
            if (this.scroller.computeScrollOffset()) {
                scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
                postInvalidate();
                return;
            }
            int i = this.currentScreen;
            int currX = this.scroller.getCurrX();
            int width = getWidth();
            int i2 = currX / width;
            if (currX % width > width / 2) {
                i2 += TOUCH_STATE_SCROLLING;
            }
            this.currentScreen = Math.max(TOUCH_STATE_REST, Math.min(i2, this.screenCount - 1));
            if (i != this.currentScreen) {
                onScreenChange(i);
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.adapter != null && this.screenCount > 0) {
            long drawingTime = getDrawingTime();
            if (this.currentScreen > 0) {
                drawChild(canvas, this.previousPage, drawingTime);
            }
            drawChild(canvas, this.currentPage, drawingTime);
            if (this.currentScreen < this.screenCount - 1) {
                drawChild(canvas, this.nextPage, drawingTime);
            }
        }
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        if (this.adapter == null) {
            return super.dispatchUnhandledMove(view, i);
        }
        if (i == 17) {
            if (this.currentScreen > 0) {
                scrollToScreen(this.currentScreen - 1, false);
                return true;
            }
        } else if (i == 66 && this.currentScreen < this.screenCount - 1) {
            scrollToScreen(this.currentScreen + TOUCH_STATE_SCROLLING, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.touchState != 0) {
            return true;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (action) {
            case TOUCH_STATE_REST /*0*/:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.lastMotionX = x;
                this.lastMotionY = y;
                this.touchState = this.scroller.isFinished() ? TOUCH_STATE_REST : TOUCH_STATE_SCROLLING;
                break;
            case TOUCH_STATE_SCROLLING /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.touchState = TOUCH_STATE_REST;
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                handleInterceptMove(motionEvent);
                break;
        }
        return this.touchState != 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.adapter != null && this.screenCount > 0) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            int i7 = this.currentScreen * i5;
            if (this.currentScreen > 0) {
                this.previousPage.layout(i7 - i5, TOUCH_STATE_REST, i7, i6);
            }
            this.currentPage.layout(i7, TOUCH_STATE_REST, i7 + i5, i6);
            if (this.currentScreen < this.screenCount - 1) {
                this.nextPage.layout(i7 + i5, TOUCH_STATE_REST, i5 + (i7 + i5), i6);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.adapter != null && this.screenCount > 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            measuredHeight = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            for (measuredWidth = TOUCH_STATE_REST; measuredWidth < getChildCount(); measuredWidth += TOUCH_STATE_SCROLLING) {
                getChildAt(measuredWidth).measure(makeMeasureSpec, measuredHeight);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adapter == null) {
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
                if (this.touchState != 0) {
                    if (!this.scroller.isFinished()) {
                        this.scroller.abortAnimation();
                    }
                    this.lastMotionX = x;
                    break;
                }
                break;
            case TOUCH_STATE_SCROLLING /*1*/:
                if (this.touchState == TOUCH_STATE_SCROLLING) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE, (float) this.mMaximumVelocity);
                    action = (int) velocityTracker.getXVelocity();
                    if (action > SNAP_VELOCITY && this.currentScreen > 0) {
                        scrollToScreen(this.currentScreen - 1, false);
                    } else if (action >= -500 || this.currentScreen >= this.screenCount - 1) {
                        action = getWidth();
                        scrollToScreen((getScrollX() + (action / 2)) / action, false);
                    } else {
                        scrollToScreen(this.currentScreen + TOUCH_STATE_SCROLLING, false);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                }
                this.touchState = TOUCH_STATE_REST;
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (this.touchState != TOUCH_STATE_SCROLLING) {
                    if (onInterceptTouchEvent(motionEvent) && this.touchState == TOUCH_STATE_SCROLLING) {
                        handleScrollMove(motionEvent);
                        break;
                    }
                }
                handleScrollMove(motionEvent);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.touchState = TOUCH_STATE_REST;
                break;
        }
        return true;
    }

    public void scrollLeft(boolean z) {
        if (this.currentScreen > 0) {
            scrollToScreen(this.currentScreen - 1, z);
        }
    }

    public void scrollRight(boolean z) {
        if (this.currentScreen < this.screenCount - 1) {
            scrollToScreen(this.currentScreen + TOUCH_STATE_SCROLLING, z);
        }
    }

    public void scrollToScreen(int i, boolean z) {
        if (this.currentPage != null && getFocusedChild() == this.currentPage) {
            this.currentPage.clearFocus();
        }
        int width = (getWidth() * i) - getScrollX();
        this.scroller.abortAnimation();
        this.scroller.startScroll(getScrollX(), TOUCH_STATE_REST, width, TOUCH_STATE_REST, z ? TOUCH_STATE_REST : Math.abs(getWidth()) / 2);
        invalidate();
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        if (this.adapter != null) {
            this.adapter.setMobViewPager(null);
        }
        this.adapter = viewPagerAdapter;
        if (this.adapter != null) {
            this.adapter.setMobViewPager(this);
        }
        if (viewPagerAdapter == null) {
            this.currentScreen = TOUCH_STATE_REST;
            removeAllViews();
            return;
        }
        this.screenCount = viewPagerAdapter.getCount();
        if (this.screenCount <= 0) {
            this.currentScreen = TOUCH_STATE_REST;
            removeAllViews();
        } else if (this.screenCount <= this.currentScreen) {
            scrollToScreen(this.screenCount - 1, true);
        } else {
            removeAllViews();
            if (this.currentScreen > 0) {
                this.previousPage = viewPagerAdapter.getView(this.currentScreen - 1, this.previousPage, this);
                addView(this.previousPage);
            }
            this.currentPage = viewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
            addView(this.currentPage);
            if (this.currentScreen < this.screenCount - 1) {
                this.nextPage = viewPagerAdapter.getView(this.currentScreen + TOUCH_STATE_SCROLLING, this.nextPage, this);
                addView(this.nextPage);
            }
        }
    }
}
