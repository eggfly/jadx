package com.baidu.mobads.production.p100d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
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
import com.umeng.message.proguard.C4233j;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.d.b */
public class C2044b extends C2028a implements C2036a {
    private boolean f7140A;
    private boolean f7141B;
    private Activity f7142C;
    private RelativeLayout f7143D;
    private Boolean f7144E;
    public final String f7145w;
    protected final IXAdLogger f7146x;
    private C2046d f7147y;
    private AdSize f7148z;

    public C2044b(Context context, RelativeLayout relativeLayout, Boolean bool, String str) {
        super(context);
        this.f7145w = "html5_intersitial";
        this.f7140A = false;
        this.f7141B = false;
        this.f7146x = C1991m.m7449a().m7457f();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.f7144E = bool;
        this.f7148z = AdSize.InterstitialGame;
        C1991m.m7449a().m7467p();
        this.f7147y = new C2046d(getApplicationContext(), getActivity(), this.p, Boolean.valueOf(true));
        this.f7147y.m7623d(str);
        this.f7147y.m7619c(AdSize.InterstitialGame.getValue());
        m7584c(str);
    }

    private ViewGroup m7697d(Context context) {
        return (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    public void m7698a(int i, int i2) {
    }

    public void m7699a(Activity activity) {
        if (this.f7140A && !this.f7141B) {
            this.f7141B = true;
            this.f7140A = false;
            this.f7142C = activity;
            start();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.e.setBackgroundColor(0);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = rect.top;
            ViewGroup d = m7697d(activity);
            this.f7143D = new RelativeLayout(activity);
            this.f7143D.addView(this.e, layoutParams);
            d.addView(this.f7143D, new RelativeLayout.LayoutParams(-1, -1));
            this.e.setFocusableInTouchMode(true);
            this.e.setFocusable(true);
            this.e.requestFocus();
        } else if (this.f7141B) {
            this.f7146x.m7405w("interstitial ad is showing now");
        } else if (!this.f7140A) {
            this.f7146x.m7405w("interstitial ad is not ready");
        }
    }

    public void m7700a(Activity activity, RelativeLayout relativeLayout) {
    }

    protected void m7701a(C2024d c2024d, C2066q c2066q, int i) {
        c2066q.m7745a(c2024d, "{'ad':[{'id':99999999,'url':'" + this.f7147y.m7712b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    public void m7702b() {
    }

    protected void m7703c() {
        this.f7085n = 8000;
    }

    protected void m7704c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f7140A = true;
        if (hashMap != null) {
            Object obj = hashMap.get(C4233j.f14402y);
            if (obj != null && !((String) obj).equals("video")) {
            }
        }
    }

    protected void m7705d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    protected void m7706e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        m7709n();
        this.f7141B = false;
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m7708m();
    }

    public void m7707l() {
        load();
    }

    public C2031d m7708m() {
        return this.f7147y;
    }

    public void m7709n() {
        if (this.f7142C != null) {
            this.f7142C.runOnUiThread(new C2045c(this));
        }
    }

    public boolean m7710q() {
        return this.f7140A;
    }

    public void request() {
        super.m7575a(this.f7147y);
    }

    public void start() {
        super.start();
    }
}
