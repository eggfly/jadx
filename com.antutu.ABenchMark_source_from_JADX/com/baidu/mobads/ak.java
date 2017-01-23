package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.openad.p079d.C1899b;
import com.baidu.mobads.openad.p079d.C1912c;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.openad.p097f.C2025a;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;

public class ak extends C1912c implements IXAdContainerContext {
    public IXAdContainerEventListener f6689a;
    private Context f6690b;
    private Activity f6691d;
    private RelativeLayout f6692e;
    private IXAdResponseInfo f6693f;
    private IXAdInstanceInfo f6694g;
    private View f6695h;
    private IXAdProdInfo f6696i;
    private long f6697j;
    private HashMap<String, Integer> f6698k;

    /* renamed from: com.baidu.mobads.ak.a */
    public class C1911a extends C1899b {
        final /* synthetic */ ak f6684a;
        private String f6685b;
        private HashMap<String, Object> f6686c;

        public C1911a(ak akVar, String str, String str2, HashMap<String, Object> hashMap) {
            this.f6684a = akVar;
            super(str);
            this.f6685b = str2;
            this.f6686c = hashMap;
        }

        public HashMap<String, Object> getData() {
            return this.f6686c;
        }
    }

    public ak(Context context, Activity activity, IXAdProdInfo iXAdProdInfo, RelativeLayout relativeLayout, IXAdContainerEventListener iXAdContainerEventListener, IXAdResponseInfo iXAdResponseInfo, View view) {
        this.f6697j = 0;
        this.f6698k = new HashMap();
        this.f6690b = context;
        this.f6691d = activity;
        this.f6696i = iXAdProdInfo;
        this.f6692e = relativeLayout;
        this.f6689a = iXAdContainerEventListener;
        this.f6693f = iXAdResponseInfo;
        this.f6694g = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        this.f6695h = view;
    }

    public IOAdTimer createOAdTimer(int i) {
        return new C2025a(i);
    }

    public IOAdTimer createOAdTimer(int i, int i2) {
        return new C2025a(i, i2);
    }

    public void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        String addParameters = C1991m.m7449a().m7460i().addParameters(str, hashMap);
        C2021a c2021a = new C2021a();
        C2024d c2024d = new C2024d(addParameters, BuildConfig.FLAVOR);
        c2024d.f7057e = 1;
        c2021a.m7547a(c2024d, Boolean.valueOf(true));
    }

    public Activity getActivity() {
        if (this.f6691d == null && this.f6692e != null) {
            this.f6691d = (Activity) this.f6692e.getContext();
        }
        return this.f6691d;
    }

    public IXAdConstants getAdConstants() {
        return C1991m.m7449a().m7467p();
    }

    public IXAdContainerEventListener getAdContainerListener() {
        return this.f6689a;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.f6694g;
    }

    public View getAdLeadingView() {
        return this.f6695h;
    }

    public IXAdLogger getAdLogger() {
        return C1991m.m7449a().m7457f();
    }

    public RelativeLayout getAdProdBase() {
        return this.f6692e;
    }

    public IXAdProdInfo getAdProdInfo() {
        return this.f6696i;
    }

    public IXAdResource getAdResource() {
        return C1991m.m7449a().m7458g();
    }

    public IXAdResponseInfo getAdResponseInfo() {
        return this.f6693f;
    }

    public IXAdURIUitls getAdUitls4URI() {
        return C1991m.m7449a().m7460i();
    }

    public IXAdActivityUtils getAdUtils4Activity() {
        return C1991m.m7449a().m7466o();
    }

    public IXAdBitmapUtils getAdUtils4Bitmap() {
        return C1991m.m7449a().m7459h();
    }

    public IXAdCommonUtils getAdUtils4Common() {
        return C1991m.m7449a().m7464m();
    }

    public IXAdIOUtils getAdUtils4IO() {
        return C1991m.m7449a().m7462k();
    }

    public IXAdPackageUtils getAdUtils4Package() {
        return C1991m.m7449a().m7463l();
    }

    public IXAdSystemUtils getAdUtils4System() {
        return C1991m.m7449a().m7465n();
    }

    public IXAdViewUtils getAdUtils4View() {
        return C1991m.m7449a().m7461j();
    }

    public Context getApplicationContext() {
        return this.f6690b;
    }

    public IBase64 getBase64() {
        return C1991m.m7449a().m7456e();
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return C1991m.m7449a().m7453b(context);
    }

    public IXAdErrorCode getErrorCode() {
        return C1991m.m7449a().m7468q();
    }

    public String getProxyVersion() {
        return "8.8";
    }

    public void processCommand(String str, HashMap<String, Object> hashMap) {
        if (System.currentTimeMillis() - this.f6697j > 1000) {
            this.f6697j = System.currentTimeMillis();
            dispatchEvent(new C1911a(this, "process_command", str, hashMap));
        }
    }

    public void registerAdService(String str, HashMap<String, Object> hashMap) {
        if (!this.f6698k.containsKey(str)) {
            this.f6698k.put(str, Integer.valueOf(1));
            dispatchEvent(new C1911a(this, "regsiter_adservice", str, hashMap));
        }
    }

    public void unregisterAdService(String str) {
        if (this.f6698k.containsKey(str)) {
            this.f6698k.remove(str);
            dispatchEvent(new C1911a(this, "unregsiter_adservice", str, new HashMap()));
        }
    }
}
