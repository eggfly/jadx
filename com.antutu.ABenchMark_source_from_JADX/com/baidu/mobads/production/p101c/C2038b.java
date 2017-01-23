package com.baidu.mobads.production.p101c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.C2028a;
import com.baidu.mobads.production.C2066q;
import com.baidu.mobads.vo.C2031d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.c.b */
public class C2038b extends C2028a implements C2037a {
    private CountDownTimer f7125A;
    private C2042f f7126B;
    private boolean f7127C;
    private boolean f7128D;
    private Activity f7129E;
    private Boolean f7130F;
    public final String f7131w;
    protected final IXAdLogger f7132x;
    private RelativeLayout f7133y;
    private TextView f7134z;

    public C2038b(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        super(context);
        this.f7131w = "html5_intersitial";
        this.f7127C = false;
        this.f7128D = false;
        this.f7132x = C1991m.m7449a().m7457f();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.f7130F = bool;
        this.f7126B = new C2042f(getApplicationContext(), getActivity(), this.p, Boolean.valueOf(true));
        this.f7126B.m7620c(SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
        this.f7126B.m7619c(adSize.getValue());
        this.f7126B.m7623d(str);
        m7584c(str);
    }

    private boolean m7669r() {
        return m7685n();
    }

    private View m7670s() {
        if (this.f7133y == null) {
            this.f7133y = new RelativeLayout(this.f);
            this.f7133y.setBackgroundColor(Color.argb(42, 0, 0, 0));
            this.f7134z = new TextView(this.f);
            this.f7134z.setTextColor(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f7133y.addView(this.f7134z, layoutParams);
        }
        this.f7125A = new C2041e(this, 6000, 1000).start();
        return this.f7133y;
    }

    private void m7671t() {
        if (!(this.f7133y == null || this.f7133y.getParent() == null)) {
            ((ViewGroup) this.f7133y.getParent()).removeView(this.f7133y);
        }
        if (this.f7125A != null) {
            this.f7132x.m7392d("cancel countDownTimer before it finished");
            try {
                this.f7125A.cancel();
            } catch (Throwable e) {
                this.f7132x.m7395d(e);
            }
        }
    }

    private RelativeLayout.LayoutParams m7672u() {
        int screenDensity = (int) (20.0f * C1991m.m7449a().m7464m().getScreenDensity(this.f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenDensity, screenDensity);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        return layoutParams;
    }

    public void m7673a(int i, int i2) {
        if (!this.f7127C && !this.f7128D) {
            this.f7126B.m7613a(i);
            this.f7126B.m7617b(i2);
            load();
        }
    }

    public void m7674a(Activity activity) {
    }

    public void m7675a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.f7132x.m7392d("showInterstitialAdInit");
            if (this.f7127C && !this.f7128D) {
                this.f7128D = true;
                this.f7127C = false;
                this.f7129E = activity;
                start();
                m7687p();
                this.e.setBackgroundColor(0);
                View relativeLayout2 = new RelativeLayout(activity);
                relativeLayout2.setBackgroundColor(0);
                relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
                this.e.addView(this.h.getAdView(), new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout2.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
                this.h.getAdView().setVisibility(4);
            } else if (this.f7128D) {
                this.f7132x.m7405w("interstitial ad is showing now");
            } else if (!this.f7127C) {
                this.f7132x.m7405w("interstitial ad is not ready");
            }
        } catch (Throwable e) {
            this.f7132x.m7395d(e);
        }
    }

    protected void m7676a(C2024d c2024d, C2066q c2066q, int i) {
        c2066q.m7745a(c2024d, "{'ad':[{'id':99999999,'url':'" + this.f7126B.m7690b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    public boolean m7677a(int i, KeyEvent keyEvent) {
        return true;
    }

    public void m7678b() {
    }

    protected void m7679c() {
        this.f7085n = 8000;
    }

    protected void m7680c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f7127C = true;
    }

    protected void m7681d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        m7684m();
    }

    protected void m7682e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        m7687p();
        this.f7128D = false;
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m7686o();
    }

    public void m7683l() {
    }

    public void m7684m() {
        new Handler(Looper.getMainLooper()).post(new C2039c(this));
    }

    protected boolean m7685n() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == this.f7126B.getApt();
    }

    public C2031d m7686o() {
        return this.f7126B;
    }

    protected void m7687p() {
        if (this.f7129E != null) {
            this.f7129E.runOnUiThread(new C2040d(this));
        }
    }

    public boolean m7688q() {
        return this.f7127C;
    }

    public void request() {
        super.m7575a(this.f7126B);
    }

    public void start() {
        super.start();
    }
}
