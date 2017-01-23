package com.miui.support.hybrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.hybrid.HybridManager;
import com.miui.support.internal.hybrid.HybridProgressView;
import com.miui.support.internal.hybrid.WebContainerView;
import com.miui.support.internal.hybrid.provider.AbsWebView;
import com.miui.support.internal.hybrid.provider.WebViewFactory;
import com.miui.support.internal.hybrid.provider.WebViewFactoryProvider;
import com.miui.support.widget.ProgressBar;

public class HybridView extends FrameLayout {
    private AbsWebView f2047a;
    private ProgressBar f2048b;
    private HybridProgressView f2049c;
    private ViewGroup f2050d;
    private Button f2051e;
    private TextView f2052f;
    private WebContainerView f2053g;
    private WebViewFactoryProvider f2054h;
    private HybridSettings f2055i;
    private HybridManager f2056j;
    private int f2057k;
    private boolean f2058l;
    private boolean f2059m;
    private boolean f2060n;

    /* renamed from: com.miui.support.hybrid.HybridView.1 */
    class C02581 implements OnClickListener {
        final /* synthetic */ HybridView f2046a;

        C02581(HybridView hybridView) {
            this.f2046a = hybridView;
        }

        public void onClick(View view) {
            this.f2046a.m3522b();
            this.f2046a.setReloadContentVisibility(8);
        }
    }

    public HybridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.HybridViewStyle, 0, 0);
        this.f2057k = obtainStyledAttributes.getInt(C0234R.styleable.HybridViewStyle_hybridProgressBar, 0);
        this.f2058l = obtainStyledAttributes.getBoolean(C0234R.styleable.HybridViewStyle_hybridErrorPage, true);
        this.f2059m = obtainStyledAttributes.getBoolean(C0234R.styleable.HybridViewStyle_hybridPullable, true);
        obtainStyledAttributes.recycle();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C0264R.layout.hybrid_view_layout, this, true);
        this.f2054h = WebViewFactory.m4134a(context);
        this.f2047a = this.f2054h.m4136a(context, this);
        this.f2053g = (WebContainerView) findViewById(C0264R.id.webContainer);
        this.f2053g.setWebView(this.f2047a.m4108a());
        if (this.f2057k == 1) {
            this.f2048b = (ProgressBar) findViewById(C0264R.id.progress_circular);
        } else if (this.f2057k == 2) {
            this.f2049c = (HybridProgressView) findViewById(C0264R.id.progress_horizontal);
        }
        this.f2052f = (TextView) findViewById(C0264R.id.hybrid_provider);
        if (this.f2059m) {
            this.f2052f.setVisibility(0);
        }
    }

    HybridManager getHybridManager() {
        return this.f2056j;
    }

    void setHybridManager(HybridManager hybridManager) {
        this.f2056j = hybridManager;
    }

    AbsWebView getWebView() {
        return this.f2047a;
    }

    public void setHybridViewClient(HybridViewClient hybridViewClient) {
        hybridViewClient.m3532a(this.f2056j);
        this.f2047a.m4111a(this.f2054h.m4137a(hybridViewClient, this));
    }

    public void setHybridChromeClient(HybridChromeClient hybridChromeClient) {
        hybridChromeClient.m3500a(this.f2056j);
        this.f2047a.m4110a(this.f2054h.m4135a(hybridChromeClient, this));
    }

    public void m3521a(String str) {
        this.f2047a.m4113a(str);
    }

    public void m3520a(Object obj, String str) {
        this.f2047a.m4112a(obj, str);
    }

    public HybridSettings getSettings() {
        if (this.f2055i == null) {
            this.f2055i = this.f2047a.m4114b();
        }
        return this.f2055i;
    }

    public void m3519a() {
        this.f2047a.m4115c();
    }

    public void m3522b() {
        this.f2047a.m4116d();
    }

    public boolean m3523c() {
        return this.f2047a.m4117e();
    }

    public void m3524d() {
        this.f2047a.m4119g();
    }

    public String getUrl() {
        return this.f2047a.m4120h();
    }

    public String getTitle() {
        return this.f2047a.m4121i();
    }

    void setProgress(int i) {
        if (i > 80 && !this.f2060n) {
            m3526f();
        }
        if (i == 100) {
            this.f2053g.setBackground(null);
        }
        if (this.f2048b != null || this.f2049c != null) {
            if (this.f2057k == 1) {
                if (this.f2048b != null) {
                    if (this.f2048b.getVisibility() == 8) {
                        this.f2048b.setVisibility(0);
                    }
                    this.f2048b.setProgress(i);
                    if (i == this.f2048b.getMax()) {
                        this.f2048b.setVisibility(8);
                    }
                }
            } else if (this.f2057k == 2 && this.f2049c != null) {
                if (this.f2049c.getVisibility() == 8) {
                    this.f2049c.setVisibility(0);
                }
                this.f2049c.setProgress(i);
                if (i == this.f2049c.getMax()) {
                    this.f2049c.setVisibility(8);
                }
            }
        }
    }

    void setLoadingError(boolean z) {
        this.f2060n = z;
    }

    void m3525e() {
        if (this.f2058l) {
            if (this.f2050d == null) {
                this.f2050d = (ViewGroup) ((ViewStub) findViewById(C0264R.id.webview_reload_stub)).inflate();
                this.f2051e = (Button) this.f2050d.findViewById(C0264R.id.reload);
                this.f2051e.setOnClickListener(new C02581(this));
            }
            this.f2050d.setVisibility(0);
            setReloadContentVisibility(0);
            this.f2047a.m4109a(8);
        }
    }

    void m3526f() {
        if (this.f2058l) {
            if (this.f2050d != null) {
                this.f2050d.setVisibility(8);
            }
            this.f2047a.m4109a(0);
        }
    }

    private void setReloadContentVisibility(int i) {
        int childCount = this.f2050d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.f2050d.getChildAt(i2).setVisibility(i);
        }
    }

    void setWebProvider(String str) {
        if (TextUtils.isEmpty(Uri.parse(str).getHost())) {
            this.f2052f.setText("");
            return;
        }
        this.f2052f.setText(String.format(getContext().getString(C0264R.string.hybrid_provider), new Object[]{r0}));
    }

    public int getContentHeight() {
        return this.f2047a.m4122j();
    }

    public float getScale() {
        return this.f2047a.m4123k();
    }
}
