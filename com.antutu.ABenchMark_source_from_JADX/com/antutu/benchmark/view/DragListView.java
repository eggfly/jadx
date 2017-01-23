package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.utils.MLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class DragListView extends ListView implements OnScrollListener {
    private LayoutInflater f5763a;
    private LinearLayout f5764b;
    private TextView f5765c;
    private TextView f5766d;
    private ImageView f5767e;
    private ProgressBar f5768f;
    private RotateAnimation f5769g;
    private RotateAnimation f5770h;
    private boolean f5771i;
    private int f5772j;
    private int f5773k;
    private int f5774l;
    private int f5775m;
    private int f5776n;
    private boolean f5777o;
    private C1385a f5778p;
    private boolean f5779q;

    /* renamed from: com.antutu.benchmark.view.DragListView.a */
    public interface C1385a {
        void m5463a();
    }

    public DragListView(Context context) {
        super(context);
        m6421a(context);
    }

    public DragListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6421a(context);
    }

    private void m6421a(Context context) {
        this.f5763a = LayoutInflater.from(context);
        this.f5764b = (LinearLayout) this.f5763a.inflate(C1082R.layout.head, null);
        this.f5767e = (ImageView) this.f5764b.findViewById(C1082R.id.head_arrowImageView);
        this.f5767e.setMinimumWidth(70);
        this.f5767e.setMinimumHeight(50);
        this.f5768f = (ProgressBar) this.f5764b.findViewById(C1082R.id.head_progressBar);
        this.f5765c = (TextView) this.f5764b.findViewById(C1082R.id.head_tipsTextView);
        this.f5766d = (TextView) this.f5764b.findViewById(C1082R.id.head_lastUpdatedTextView);
        m6422a(this.f5764b);
        this.f5773k = this.f5764b.getMeasuredHeight();
        this.f5772j = this.f5764b.getMeasuredWidth();
        this.f5764b.setPadding(0, this.f5773k * -1, 0, 0);
        this.f5764b.invalidate();
        MLog.m6874v("size", "width:" + this.f5772j + " height:" + this.f5773k);
        addHeaderView(this.f5764b, null, false);
        setOnScrollListener(this);
        this.f5769g = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f5769g.setInterpolator(new LinearInterpolator());
        this.f5769g.setDuration(250);
        this.f5769g.setFillAfter(true);
        this.f5770h = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f5770h.setInterpolator(new LinearInterpolator());
        this.f5770h.setDuration(200);
        this.f5770h.setFillAfter(true);
        this.f5776n = 3;
        this.f5779q = false;
    }

    private void m6422a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? MeasureSpec.makeMeasureSpec(i, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void m6423b() {
        switch (this.f5776n) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f5767e.setVisibility(0);
                this.f5768f.setVisibility(8);
                this.f5765c.setVisibility(0);
                this.f5766d.setVisibility(0);
                this.f5767e.clearAnimation();
                this.f5767e.startAnimation(this.f5769g);
                this.f5765c.setText(getContext().getString(C1082R.string.list_songkai));
                MLog.m6874v("listview", "\u5f53\u524d\u72b6\u6001\uff0c\u677e\u5f00\u5237\u65b0");
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f5768f.setVisibility(8);
                this.f5765c.setVisibility(0);
                this.f5766d.setVisibility(0);
                this.f5767e.clearAnimation();
                this.f5767e.setVisibility(0);
                if (this.f5777o) {
                    this.f5777o = false;
                    this.f5767e.clearAnimation();
                    this.f5767e.startAnimation(this.f5770h);
                    this.f5765c.setText(getContext().getString(C1082R.string.list_drag));
                } else {
                    this.f5765c.setText(getContext().getString(C1082R.string.list_drag));
                }
                MLog.m6874v("listview", "\u5f53\u524d\u72b6\u6001\uff0c\u4e0b\u62c9\u5237\u65b0");
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f5764b.setPadding(0, 0, 0, 0);
                this.f5768f.setVisibility(0);
                this.f5767e.clearAnimation();
                this.f5767e.setVisibility(8);
                this.f5765c.setText(getContext().getString(C1082R.string.list_refreshing));
                this.f5766d.setVisibility(0);
                MLog.m6874v("listview", "\u5f53\u524d\u72b6\u6001,\u6b63\u5728\u5237\u65b0...");
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.f5764b.setPadding(0, this.f5773k * -1, 0, 0);
                this.f5768f.setVisibility(8);
                this.f5767e.clearAnimation();
                this.f5767e.setImageResource(C1082R.drawable.arrow_down_head);
                this.f5765c.setText(getContext().getString(C1082R.string.list_drag));
                this.f5766d.setVisibility(0);
                MLog.m6874v("listview", "\u5f53\u524d\u72b6\u6001\uff0cdone");
            default:
        }
    }

    private void m6424c() {
        if (this.f5778p != null) {
            this.f5778p.m5463a();
        }
    }

    public void m6425a() {
        this.f5776n = 3;
        this.f5766d.setText(getContext().getString(C1082R.string.list_recent) + new SimpleDateFormat("yyyy-MM-dd  HH:mm").format(new Date()));
        m6423b();
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f5775m = i;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5779q) {
            switch (motionEvent.getAction()) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    if (this.f5775m == 0 && !this.f5771i) {
                        this.f5771i = true;
                        this.f5774l = (int) motionEvent.getY();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (!(this.f5776n == 2 || this.f5776n == 4)) {
                        if (this.f5776n == 3) {
                        }
                        if (this.f5776n == 1) {
                            this.f5776n = 3;
                            m6423b();
                        }
                        if (this.f5776n == 0) {
                            this.f5776n = 2;
                            m6423b();
                            m6424c();
                        }
                    }
                    this.f5771i = false;
                    this.f5777o = false;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    int y = (int) motionEvent.getY();
                    if (!this.f5771i && this.f5775m == 0) {
                        MLog.m6874v("listview", "\u5728move\u65f6\u5019\u8bb0\u5f55\u4e0b\u4f4d\u7f6e");
                        this.f5771i = true;
                        this.f5774l = y;
                    }
                    if (!(this.f5776n == 2 || !this.f5771i || this.f5776n == 4)) {
                        if (this.f5776n == 0) {
                            setSelection(0);
                            if ((y - this.f5774l) / 3 < this.f5773k && y - this.f5774l > 0) {
                                this.f5776n = 1;
                                m6423b();
                                MLog.m6874v("listview", "\u7531\u677e\u5f00\u5237\u65b0\u72b6\u6001\u8f6c\u53d8\u5230\u4e0b\u62c9\u5237\u65b0\u72b6\u6001");
                            } else if (y - this.f5774l <= 0) {
                                this.f5776n = 3;
                                m6423b();
                                MLog.m6874v("listview", "\u7531\u677e\u5f00\u5237\u65b0\u72b6\u6001\u8f6c\u53d8\u5230done\u72b6\u6001");
                            }
                        }
                        if (this.f5776n == 1) {
                            if ((y - this.f5774l) / 3 >= this.f5773k) {
                                this.f5776n = 0;
                                this.f5777o = true;
                                m6423b();
                            } else if (y - this.f5774l <= 0) {
                                this.f5776n = 3;
                                m6423b();
                            }
                        }
                        if (this.f5776n == 3 && y - this.f5774l > 0) {
                            this.f5776n = 1;
                            m6423b();
                        }
                        if (this.f5776n == 1) {
                            this.f5764b.setPadding(0, (this.f5773k * -1) + ((y - this.f5774l) / 3), 0, 0);
                        }
                        if (this.f5776n == 0) {
                            this.f5764b.setPadding(0, ((y - this.f5774l) / 3) - this.f5773k, 0, 0);
                            break;
                        }
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.f5766d.setText(getContext().getString(C1082R.string.list_recent) + new SimpleDateFormat("yyyy-MM-dd  HH:mm").format(new Date()));
        super.setAdapter(baseAdapter);
    }

    public void setonRefreshListener(C1385a c1385a) {
        this.f5778p = c1385a;
        this.f5779q = true;
    }
}
