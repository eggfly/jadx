package com.baidu.mobads.production.p102e;

import android.content.Context;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.C2028a;
import com.baidu.mobads.production.C2066q;
import com.baidu.mobads.vo.C2031d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.e.a */
public class C2048a extends C2028a {
    protected final IXAdLogger f7153w;
    private C2051d f7154x;
    private Context f7155y;

    public C2048a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2) {
        super(context);
        this.f7153w = C1991m.m7449a().m7457f();
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_SPLASH;
        this.f7155y = context;
        this.f7154x = new C2051d(getApplicationContext(), this.p);
        this.f7154x.m7615a(z);
        IXAdConstants p = C1991m.m7449a().m7467p();
        this.f7154x.m7618b(z ? p.getSupportedActionType4RequestingNone() + Constants.ACCEPT_TIME_SEPARATOR_SP + p.getSupportedActionType4RequestingLandingPage() + Constants.ACCEPT_TIME_SEPARATOR_SP + p.getSupportedActionType4RequestingDownload() : p.getSupportedActionType4RequestingNone());
        this.f7154x.m7613a(i);
        this.f7154x.m7617b(i2);
        this.f7154x.m7625e(0);
        this.f7154x.m7623d(str);
        this.f7154x.m7619c(8);
        this.f7154x.m7622d(1);
        this.f7154x.m7627f(p.getAdCreativeTypeImage());
        m7584c(str);
    }

    protected void m7714a(C2024d c2024d, C2066q c2066q, int i) {
        c2066q.m7546a(c2024d, (double) i);
    }

    public void m7715b() {
        if (this.h != null) {
            this.h.load();
        } else {
            this.f7153w.m7397e("container is null");
        }
    }

    protected void m7716c() {
        this.f7085n = 4200;
    }

    protected void m7717c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
        Handler handler = new Handler(this.f7155y.getMainLooper());
        handler.post(new C2049b(this));
        handler.postDelayed(new C2050c(this), 5000);
    }

    protected void m7718d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m7719l();
    }

    public C2031d m7719l() {
        return this.f7154x;
    }

    public void request() {
        m7591h();
        m7575a(this.f7154x);
    }
}
