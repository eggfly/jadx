package com.antutu.benchmark.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.xiaomi.pushsdk.BuildConfig;

public class CommonTitleView extends RelativeLayout {
    private ImageView f5748a;
    private TextView f5749b;
    private View f5750c;
    private TextView f5751d;
    private View f5752e;
    private View f5753f;
    private Context f5754g;
    private LinearLayout f5755h;
    private ImageView f5756i;
    private ImageView f5757j;

    /* renamed from: com.antutu.benchmark.view.CommonTitleView.a */
    public static class C1624a {
        public int f5733a;
        public Drawable f5734b;
        public int f5735c;
        public Drawable f5736d;
        public String f5737e;
        public boolean f5738f;
        public boolean f5739g;
        public OnClickListener f5740h;
        public OnClickListener f5741i;
        public OnClickListener f5742j;
        public String f5743k;
        public boolean f5744l;
        public boolean f5745m;
        public boolean f5746n;

        public C1624a() {
            this.f5745m = false;
            this.f5746n = true;
            this.f5733a = C1082R.drawable.main_title_icon_back;
            this.f5737e = BuildConfig.FLAVOR;
            this.f5739g = true;
            this.f5738f = false;
            this.f5740h = null;
            this.f5742j = null;
            this.f5741i = null;
            this.f5744l = false;
        }

        public C1624a(int i, String str, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f5745m = false;
            this.f5746n = true;
            this.f5733a = i;
            this.f5737e = str;
            this.f5739g = true;
            this.f5738f = z;
            this.f5740h = onClickListener;
            this.f5742j = onClickListener2;
        }
    }

    /* renamed from: com.antutu.benchmark.view.CommonTitleView.b */
    public static class C1625b {
        private C1624a f5747a;

        public C1625b() {
            this.f5747a = new C1624a();
        }

        public C1624a m6411a() {
            return this.f5747a;
        }

        public C1625b m6412a(int i) {
            this.f5747a.f5733a = i;
            return this;
        }

        public C1625b m6413a(OnClickListener onClickListener) {
            this.f5747a.f5740h = onClickListener;
            return this;
        }

        public C1625b m6414a(String str) {
            this.f5747a.f5737e = str;
            return this;
        }

        public C1625b m6415a(boolean z) {
            this.f5747a.f5739g = z;
            return this;
        }

        public C1625b m6416b(int i) {
            this.f5747a.f5735c = i;
            return this;
        }

        public C1625b m6417b(OnClickListener onClickListener) {
            this.f5747a.f5742j = onClickListener;
            return this;
        }

        public C1625b m6418b(boolean z) {
            this.f5747a.f5738f = z;
            return this;
        }

        public C1625b m6419c(boolean z) {
            this.f5747a.f5745m = z;
            return this;
        }

        public C1625b m6420d(boolean z) {
            this.f5747a.f5746n = z;
            return this;
        }
    }

    public CommonTitleView(Context context) {
        super(context);
        this.f5754g = context;
    }

    public CommonTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5754g = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5752e = findViewById(C1082R.id.v_top_left);
        this.f5748a = (ImageView) findViewById(C1082R.id.menu_back_img);
        this.f5749b = (TextView) findViewById(C1082R.id.title_text);
        this.f5751d = (TextView) findViewById(C1082R.id.action);
        this.f5750c = findViewById(C1082R.id.right_action_layout);
        this.f5753f = findViewById(C1082R.id.action_lottery);
        this.f5755h = (LinearLayout) findViewById(C1082R.id.title_layout);
        this.f5756i = (ImageView) findViewById(C1082R.id.iv_red_point);
        this.f5757j = (ImageView) findViewById(C1082R.id.iv_red_point_right);
    }

    public void setMode(C1624a c1624a) {
        if (c1624a == null) {
            c1624a = new C1624a();
        }
        if (c1624a.f5737e != null) {
            this.f5749b.setText(c1624a.f5737e);
        }
        if (c1624a.f5739g) {
            if (c1624a.f5734b != null) {
                this.f5748a.setImageDrawable(c1624a.f5734b);
            } else if (c1624a.f5733a > 0) {
                this.f5748a.setImageResource(c1624a.f5733a);
            }
            this.f5752e.setOnClickListener(c1624a.f5740h);
            this.f5748a.setVisibility(0);
        } else {
            this.f5748a.setVisibility(8);
        }
        if (c1624a.f5745m) {
            this.f5752e.setVisibility(8);
        } else {
            this.f5752e.setVisibility(0);
        }
        if (c1624a.f5746n) {
            this.f5750c.setVisibility(8);
        } else {
            this.f5750c.setVisibility(0);
        }
        if (c1624a.f5738f) {
            if (c1624a.f5736d != null) {
                this.f5751d.setCompoundDrawables(null, null, c1624a.f5736d, null);
            } else if (c1624a.f5735c > 0) {
                this.f5751d.setCompoundDrawablesWithIntrinsicBounds(0, 0, c1624a.f5735c, 0);
            }
            if (TextUtils.isEmpty(c1624a.f5743k)) {
                this.f5751d.setText(null);
            } else {
                this.f5751d.setText(c1624a.f5743k);
            }
            this.f5750c.setOnClickListener(c1624a.f5742j);
            this.f5751d.setVisibility(0);
        } else {
            this.f5751d.setVisibility(8);
            this.f5750c.setOnClickListener(null);
        }
        if (c1624a.f5744l) {
            this.f5753f.setVisibility(0);
        } else {
            this.f5753f.setVisibility(8);
        }
    }

    public void setShowLeftRedPoint(boolean z) {
        if (z) {
            this.f5756i.setVisibility(0);
        } else {
            this.f5756i.setVisibility(8);
        }
    }

    public void setShowRightRedPoint(boolean z) {
        if (z) {
            this.f5757j.setVisibility(0);
        } else {
            this.f5757j.setVisibility(8);
        }
    }
}
