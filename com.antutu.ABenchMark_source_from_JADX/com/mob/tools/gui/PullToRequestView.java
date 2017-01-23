package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class PullToRequestView extends RelativeLayout {
    private static final long MIN_REF_TIME = 1000;
    private PullToRequestAdatper adapter;
    private View bodyView;
    private float downY;
    private int footerHeight;
    private View footerView;
    private int headerHeight;
    private View headerView;
    private long pullTime;
    private boolean pullingDownLock;
    private boolean pullingUpLock;
    private int state;
    private Runnable stopAct;
    private int top;

    /* renamed from: com.mob.tools.gui.PullToRequestView.1 */
    class C40121 implements Runnable {
        C40121() {
        }

        public void run() {
            PullToRequestView.this.reversePulling();
        }
    }

    public PullToRequestView(Context context) {
        super(context);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private boolean canPullDown() {
        return !this.pullingDownLock && this.adapter.isPullDownReady() && this.state == 0;
    }

    private boolean canPullUp() {
        return !this.pullingUpLock && this.adapter.isPullUpReady() && this.state == 0;
    }

    private MotionEvent getCancelEvent(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    private void init() {
        this.stopAct = new C40121();
    }

    private void performFresh() {
        this.pullTime = System.currentTimeMillis();
        this.state = 1;
        if (this.adapter != null) {
            this.adapter.onRefresh();
        }
    }

    private void performRequestNext() {
        this.pullTime = System.currentTimeMillis();
        this.state = -1;
        if (this.adapter != null) {
            this.adapter.onRequestNext();
        }
    }

    private void reversePulling() {
        this.top = 0;
        scrollTo(0, 0);
        this.state = 0;
        if (this.adapter != null) {
            this.adapter.onReversed();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.downY = motionEvent.getY();
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                switch (this.state) {
                    case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                        this.top = -this.footerHeight;
                        scrollTo(0, -this.top);
                        break;
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        if (this.top <= this.headerHeight) {
                            if (this.top >= (-this.footerHeight)) {
                                if (this.top != 0) {
                                    scrollTo(0, 0);
                                    if (this.adapter != null) {
                                        if (this.top > 0) {
                                            this.adapter.onPullDown(0);
                                        } else {
                                            this.adapter.onPullUp(0);
                                        }
                                    }
                                    this.top = 0;
                                    break;
                                }
                            }
                            this.top = -this.footerHeight;
                            scrollTo(0, -this.top);
                            if (this.adapter != null) {
                                this.adapter.onPullUp(100);
                            }
                            performRequestNext();
                            motionEvent = getCancelEvent(motionEvent);
                            break;
                        }
                        this.top = this.headerHeight;
                        scrollTo(0, -this.top);
                        if (this.adapter != null) {
                            this.adapter.onPullDown(100);
                        }
                        performFresh();
                        motionEvent = getCancelEvent(motionEvent);
                        break;
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        this.top = this.headerHeight;
                        scrollTo(0, -this.top);
                        break;
                    default:
                        break;
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                float y = motionEvent.getY();
                switch (this.state) {
                    case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                        this.top = (int) (((float) this.top) + ((y - this.downY) / 2.0f));
                        if (this.top > 0) {
                            this.top = 0;
                        }
                        scrollTo(0, -this.top);
                        motionEvent = getCancelEvent(motionEvent);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        this.top = (int) (((float) this.top) + ((y - this.downY) / 2.0f));
                        if (this.top < 0) {
                            this.top = 0;
                        }
                        scrollTo(0, -this.top);
                        motionEvent = getCancelEvent(motionEvent);
                        break;
                    default:
                        if (this.top <= 0) {
                            if (this.top >= 0) {
                                if (y <= this.downY) {
                                    if (y < this.downY && canPullUp()) {
                                        this.top = (int) (((float) this.top) + ((y - this.downY) / 2.0f));
                                        scrollTo(0, -this.top);
                                        if (!(this.adapter == null || this.footerHeight == 0)) {
                                            this.adapter.onPullUp(((-this.top) * 100) / this.footerHeight);
                                        }
                                        motionEvent = getCancelEvent(motionEvent);
                                        break;
                                    }
                                } else if (canPullDown()) {
                                    this.top = (int) (((float) this.top) + ((y - this.downY) / 2.0f));
                                    scrollTo(0, -this.top);
                                    if (!(this.adapter == null || this.headerHeight == 0)) {
                                        this.adapter.onPullUp(((-this.top) * 100) / this.headerHeight);
                                    }
                                    motionEvent = getCancelEvent(motionEvent);
                                    break;
                                }
                            }
                            this.top = (int) (((float) this.top) + ((y - this.downY) / 2.0f));
                            if (this.top > 0) {
                                this.top = 0;
                            }
                            scrollTo(0, -this.top);
                            if (!(this.adapter == null || this.footerHeight == 0)) {
                                this.adapter.onPullUp(((-this.top) * 100) / this.footerHeight);
                            }
                            motionEvent = getCancelEvent(motionEvent);
                            break;
                        }
                        this.top = (int) (((float) this.top) + ((y - this.downY) / 2.0f));
                        if (this.top < 0) {
                            this.top = 0;
                        }
                        scrollTo(0, -this.top);
                        if (!(this.adapter == null || this.headerHeight == 0)) {
                            this.adapter.onPullDown((this.top * 100) / this.headerHeight);
                        }
                        motionEvent = getCancelEvent(motionEvent);
                        break;
                        break;
                }
                this.downY = y;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void lockPullingDown() {
        this.pullingDownLock = true;
    }

    public void lockPullingUp() {
        this.pullingUpLock = true;
    }

    public void performPullingDown(boolean z) {
        this.top = this.headerHeight;
        scrollTo(0, -this.top);
        if (z) {
            performFresh();
        }
    }

    public void performPullingUp(boolean z) {
        this.top = -this.footerHeight;
        scrollTo(0, -this.top);
        if (z) {
            performRequestNext();
        }
    }

    public void releasePullingDownLock() {
        this.pullingDownLock = false;
    }

    public void releasePullingUpLock() {
        this.pullingUpLock = false;
    }

    public void setAdapter(PullToRequestAdatper pullToRequestAdatper) {
        this.adapter = pullToRequestAdatper;
        removeAllViews();
        this.bodyView = (View) pullToRequestAdatper.getBodyView();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        addView(this.bodyView, layoutParams);
        this.headerView = pullToRequestAdatper.getHeaderView();
        this.headerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.headerView.measure(0, 0);
        this.headerHeight = this.headerView.getMeasuredHeight();
        layoutParams = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.headerHeight;
        addView(this.headerView, layoutParams);
        this.footerView = pullToRequestAdatper.getFooterView();
        this.footerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.footerView.measure(0, 0);
        this.footerHeight = this.footerView.getMeasuredHeight();
        layoutParams = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = -this.headerHeight;
        addView(this.footerView, layoutParams);
    }

    public void stopPulling() {
        long currentTimeMillis = System.currentTimeMillis() - this.pullTime;
        if (currentTimeMillis < MIN_REF_TIME) {
            postDelayed(this.stopAct, MIN_REF_TIME - currentTimeMillis);
        } else {
            post(this.stopAct);
        }
    }
}
