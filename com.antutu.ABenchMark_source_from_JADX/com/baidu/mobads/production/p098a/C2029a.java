package com.baidu.mobads.production.p098a;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.C2028a;
import com.baidu.mobads.production.C2066q;
import com.baidu.mobads.vo.C2031d;
import com.baidu.mobads.vo.C2077b;
import com.baidu.mobads.vo.C2078c;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.util.HashMap;
import org.json.JSONException;

/* renamed from: com.baidu.mobads.production.a.a */
public class C2029a extends C2028a implements IXNonLinearAdSlot {
    private C2032c f7097w;

    public C2029a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_BANNER;
        C1991m.m7449a().m7467p();
        this.f7097w = new C2032c(getApplicationContext(), getActivity(), this.p);
        this.f7097w.m7619c(AdSize.Banner.getValue());
        this.f7097w.m7623d(str);
        ((C2077b) this.f7097w.m7621d()).m7762a(z);
        m7584c(str);
    }

    protected void m7603a() {
        new Thread(new C2030b(this)).start();
    }

    protected void m7604a(C2024d c2024d, C2066q c2066q, int i) {
        String str = "{'ad':[{'id':99999999,'url':'" + this.f7097w.m7629b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}";
        this.b = Boolean.valueOf(true);
        try {
            setAdResponseInfo(new C2078c(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m7572a("XAdMouldeLoader ad-server requesting success");
    }

    public void m7605b() {
        load();
    }

    protected void m7606b(Context context) {
        try {
            WebView webView = new WebView(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void m7607b(C2031d c2031d) {
        this.l = c2031d;
        m7589f();
        m7604a(null, null, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
    }

    protected void m7608c() {
        this.f7085n = 10000;
    }

    protected void m7609c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    protected void m7610d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m7611l();
    }

    public C2031d m7611l() {
        return this.f7097w;
    }

    public void request() {
        m7575a(this.f7097w);
    }
}
