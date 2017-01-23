package com.baidu.mobads.production;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.ak;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p079d.C1912c;
import com.baidu.mobads.openad.p095b.C2007b;
import com.baidu.mobads.openad.p095b.C2009d;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.openad.p097f.C2025a;
import com.baidu.mobads.p080j.C1982d;
import com.baidu.mobads.p080j.C1986g;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p081a.C1907a;
import com.baidu.mobads.p084c.C1918a;
import com.baidu.mobads.p091f.C1933a;
import com.baidu.mobads.p093h.C1960g;
import com.baidu.mobads.p093h.C1971q;
import com.baidu.mobads.vo.C2031d;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.production.a */
public abstract class C2028a extends C1912c implements IXNonLinearAdSlot {
    protected static IXAdContainerFactory f7072a;
    private static final String[] f7073w;
    protected Boolean f7074b;
    public IXAdInstanceInfo f7075d;
    protected RelativeLayout f7076e;
    protected Context f7077f;
    protected int f7078g;
    public IXAdContainer f7079h;
    protected String f7080i;
    protected C2066q f7081j;
    protected C2025a f7082k;
    protected C2031d f7083l;
    protected SlotState f7084m;
    protected int f7085n;
    protected int f7086o;
    protected SlotType f7087p;
    protected HashMap<String, String> f7088q;
    protected AtomicBoolean f7089r;
    protected final IXAdLogger f7090s;
    protected long f7091t;
    protected long f7092u;
    protected long f7093v;
    private IXAdResponseInfo f7094x;
    private String f7095y;
    private IOAdEventListener f7096z;

    static {
        f7073w = new String[]{MsgConstant.PERMISSION_READ_PHONE_STATE, "android.permission.ACCESS_COARSE_LOCATION"};
    }

    public C2028a(Context context) {
        this.f7074b = Boolean.valueOf(false);
        this.f7075d = null;
        this.f7078g = 0;
        this.f7084m = SlotState.IDEL;
        this.f7085n = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f7086o = 0;
        this.f7088q = new HashMap();
        this.f7089r = new AtomicBoolean();
        this.f7096z = new C2035b(this);
        this.f7090s = C1991m.m7449a().m7457f();
        new Thread(new C2047d(this, context)).start();
    }

    private void m7559a(XAdErrorCode xAdErrorCode, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(XAdErrorCode.ERROR_CODE_MESSAGE, xAdErrorCode);
        dispatchEvent(new C1933a(IXAdEvent.AD_ERROR, hashMap));
        C1991m.m7449a().m7468q().printErrorMessage(xAdErrorCode, str);
    }

    private IXAdContainer m7561b(IXAdContainerContext iXAdContainerContext) {
        IXAdContainer iXAdContainer = null;
        this.f7090s.m7402i("XAbstractAdProdTemplate", "createAdContainer");
        if (f7072a != null) {
            iXAdContainer = f7072a.createXAdContainer(iXAdContainerContext, null);
            if (iXAdContainer != null) {
                this.f7090s.m7402i("XAbstractAdProdTemplate", "createAdContainer() apk.version=" + f7072a.getRemoteVersion());
            }
        }
        return iXAdContainer;
    }

    private void m7562b(IXAdResponseInfo iXAdResponseInfo) {
        this.f7090s.m7402i("XAbstractAdProdTemplate", "try2CachingVideoAdCreativeAsset");
        IXAdURIUitls i = C1991m.m7449a().m7460i();
        IXAdInstanceInfo primaryAdInstanceInfo = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        String videoUrl = primaryAdInstanceInfo.getVideoUrl();
        Boolean isHttpProtocol = i.isHttpProtocol(videoUrl);
        this.f7090s.m7402i("XAbstractAdProdTemplate", "try2CachingVideoAdCreativeAsset, should cache=" + isHttpProtocol);
        if (isHttpProtocol.booleanValue()) {
            primaryAdInstanceInfo.setLocalCreativeURL(null);
            String str = getApplicationContext().getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
            String adId = primaryAdInstanceInfo.getAdId();
            C1986g b = C1991m.m7449a().m7452b();
            b.m7428a(str);
            b.m7429a(videoUrl, str, adId, new C2056g(this, Looper.getMainLooper(), primaryAdInstanceInfo));
        }
    }

    protected void m7563a() {
    }

    public void m7564a(int i) {
        if (this.f7079h != null) {
            this.f7079h.onWindowVisibilityChanged(i);
        }
    }

    protected void m7565a(Context context) {
        if (BaiduXAdSDKContext.mApkLoader == null) {
            synchronized (C1960g.class) {
                if (BaiduXAdSDKContext.mApkLoader == null) {
                    BaiduXAdSDKContext.mApkLoader = new C1960g(context.getApplicationContext());
                }
            }
        }
        BaiduXAdSDKContext.mApkLoader.m7346a(new C2055f(this));
    }

    public void m7566a(Context context, String str) {
        if (!C1991m.m7449a().m7464m().hasPermission(context, str)) {
            String str2 = "Cannot request an ad without necessary permissions!  Open manifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />";
            this.f7090s.m7400e("BaiduMobAds SDK", str2);
            throw new SecurityException(str2);
        }
    }

    protected void m7567a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        m7590g();
        m7583c(iXAdContainer, hashMap);
        dispatchEvent(new C1933a(IXAdEvent.AD_LOADED));
    }

    protected void m7568a(IXAdContainerContext iXAdContainerContext) {
        try {
            this.f7090s.m7402i("XAbstractAdProdTemplate", "processAllReadyOnUIThread()");
            this.f7092u = System.currentTimeMillis();
            this.f7079h = m7561b(iXAdContainerContext);
            this.f7093v = System.currentTimeMillis();
            if (this.f7079h == null) {
                this.f7090s.m7400e("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer is null");
                dispatchEvent(new C1933a(IXAdEvent.AD_STOPPED));
                return;
            }
            this.f7090s.m7402i("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created");
            this.f7088q.put("start", BuildConfig.FLAVOR + this.f7091t);
            this.f7088q.put("container_before_created", BuildConfig.FLAVOR + this.f7092u);
            this.f7088q.put("container_after_created", BuildConfig.FLAVOR + this.f7093v);
            this.f7079h.setParameters(this.f7088q);
            C1907a.f6655c = this.f7079h.getRemoteVersion();
            this.f7090s.m7402i("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created, hasCalledLoadAtAppSide=" + this.f7089r.get());
            if (this.f7089r.get()) {
                this.f7079h.load();
            }
            m7576b();
        } catch (Exception e) {
            this.f7090s.m7397e(C1991m.m7449a().m7468q().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e.getMessage()));
        }
    }

    protected void m7569a(IXAdResponseInfo iXAdResponseInfo) {
        this.f7090s.m7402i("XAbstractAdProdTemplate", "handleAllReady");
        this.f7078g++;
        this.f7075d = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        Context applicationContext = getApplicationContext();
        IXAdContainerContext akVar = new ak(applicationContext, getActivity(), this.f7083l.m7621d(), this.f7076e, new C2061l(applicationContext, this), iXAdResponseInfo, null);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m7568a(akVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new C2058i(this, akVar));
        }
    }

    protected void m7570a(IXAdResponseInfo iXAdResponseInfo, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f7075d = iXAdInstanceInfo;
    }

    protected abstract void m7571a(C2024d c2024d, C2066q c2066q, int i);

    protected void m7572a(String str) {
        this.f7090s.m7402i("XAbstractAdProdTemplate", "doubleCheck:" + str + ", bfp=" + this.f7074b + ", apk=" + BaiduXAdSDKContext.isRemoteLoadSuccess);
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue()) {
            C1991m.m7449a().m7451a(getAdContainerFactory());
        }
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue() && this.f7074b.booleanValue()) {
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            if (adResponseInfo != null) {
                m7562b(adResponseInfo);
            }
            m7569a(getAdResponseInfo());
        }
    }

    public void m7573a(boolean z) {
        if (this.f7079h != null) {
            this.f7079h.onWindowFocusChanged(z);
        }
    }

    public boolean m7574a(int i, KeyEvent keyEvent) {
        return this.f7079h != null ? this.f7079h.processKeyEvent(i, keyEvent).booleanValue() : false;
    }

    protected boolean m7575a(C2031d c2031d) {
        this.f7090s.m7402i("XAbstractAdProdTemplate", "doRequest()");
        new Thread(new C2057h(this, c2031d)).start();
        m7577b(this.f7077f);
        return true;
    }

    public abstract void m7576b();

    protected void m7577b(Context context) {
    }

    protected void m7578b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f7084m = SlotState.PLAYING;
        m7586d(iXAdContainer, hashMap);
        dispatchEvent(new C1933a(IXAdEvent.AD_STARTED));
    }

    protected void m7579b(C2031d c2031d) {
        this.f7083l = c2031d;
        m7589f();
        this.f7074b = Boolean.valueOf(false);
        String b = this.f7080i == null ? c2031d.m7616b() : this.f7080i;
        this.f7081j = new C2066q();
        try {
            this.f7081j.m7544a(new C2007b());
        } catch (ClassNotFoundException e) {
            this.f7081j.m7544a(new C2009d());
        }
        C2024d c2024d = new C2024d(b, BuildConfig.FLAVOR);
        c2024d.f7057e = 1;
        this.f7081j.addEventListener("URLLoader.Load.Complete", this.f7096z);
        this.f7081j.addEventListener("URLLoader.Load.Error", this.f7096z);
        m7571a(c2024d, this.f7081j, this.f7085n);
    }

    protected void m7580b(String str) {
        C1918a.m7217a().m7226a(str);
        dispatchEvent(new C1933a(IXAdEvent.AD_ERROR));
    }

    protected abstract void m7581c();

    public void m7582c(Context context) {
        try {
            C1982d m = C1991m.m7449a().m7464m();
            m7566a(context, MsgConstant.PERMISSION_INTERNET);
            m7566a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE);
            if (m.isOldPermissionModel()) {
                m7566a(context, MsgConstant.PERMISSION_READ_PHONE_STATE);
                m7566a(context, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE);
                return;
            }
            int i;
            ArrayList arrayList = new ArrayList();
            for (i = 0; i < f7073w.length; i++) {
                if (!m.checkSelfPermission(context, f7073w[i])) {
                    arrayList.add(f7073w[i]);
                }
            }
            i = arrayList.size();
            if (i > 0) {
                m.m7419a(context, (String[]) arrayList.toArray(new String[i]), 1234323329);
            }
        } catch (Exception e) {
            this.f7090s.m7397e(C1991m.m7449a().m7468q().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e.getMessage()));
        }
    }

    protected abstract void m7583c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    protected void m7584c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f7090s.m7397e("\u4ee3\u7801\u4f4did(adPlaceId)\u4e0d\u53ef\u4ee5\u4e3a\u7a7a");
        }
    }

    protected void m7585d() {
        if (this.f7079h != null && getApplicationContext() != null) {
            this.f7084m = SlotState.PAUSED;
            new Handler(getApplicationContext().getMainLooper()).post(new C2060k(this));
        }
    }

    protected abstract void m7586d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    protected void m7587e() {
        if (this.f7079h != null && getApplicationContext() != null) {
            this.f7084m = SlotState.PLAYING;
            new Handler(getApplicationContext().getMainLooper()).post(new C2043c(this));
        }
    }

    protected void m7588e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    protected void m7589f() {
        if (this.f7081j != null) {
            this.f7081j.removeAllListeners();
            this.f7081j.m7543a();
        }
    }

    protected void m7590g() {
        if (this.f7082k != null) {
            this.f7082k.stop();
        }
        this.f7082k = null;
    }

    public Activity getActivity() {
        return this.f7077f instanceof Activity ? (Activity) this.f7077f : (this.f7076e == null || !(this.f7076e.getContext() instanceof Activity)) ? null : (Activity) this.f7076e.getContext();
    }

    public IXAdContainerFactory getAdContainerFactory() {
        return f7072a;
    }

    public IXAdResponseInfo getAdResponseInfo() {
        return this.f7094x;
    }

    public Context getApplicationContext() {
        Activity activity = getActivity();
        return activity == null ? this.f7077f : activity.getApplicationContext();
    }

    public IXAdInstanceInfo getCurrentAdInstance() {
        return this.f7075d;
    }

    public IXAdContainer getCurrentXAdContainer() {
        return this.f7079h;
    }

    public int getDuration() {
        return -1;
    }

    public String getId() {
        return this.f7095y;
    }

    public HashMap<String, String> getParameter() {
        return this.f7088q;
    }

    public int getPlayheadTime() {
        return -1;
    }

    public ViewGroup getProdBase() {
        return this.f7076e;
    }

    public IXAdProdInfo getProdInfo() {
        return this.f7083l.m7621d();
    }

    public SlotState getSlotState() {
        return this.f7084m;
    }

    public SlotType getType() {
        return this.f7087p;
    }

    protected void m7591h() {
        if (this.f7082k != null) {
            this.f7082k.start();
        }
    }

    public void m7592i() {
        if (this.f7079h != null) {
            this.f7079h.onAttachedToWindow();
        }
    }

    public Boolean isAdServerRequestingSuccess() {
        return this.f7074b;
    }

    @SuppressLint({"MissingSuperCall"})
    public void m7593j() {
        if (this.f7079h != null) {
            this.f7079h.onDetachedFromWindow();
        }
    }

    public void m7594k() {
        if (this.f7079h != null) {
            this.f7079h.destroy();
        }
    }

    public void load() {
        if (this.f7079h != null) {
            this.f7079h.load();
        } else {
            this.f7089r.set(true);
        }
    }

    public void pause() {
        m7585d();
    }

    public void resize() {
        if (this.f7079h != null && getApplicationContext() != null) {
            new Handler(getApplicationContext().getMainLooper()).post(new C2059j(this));
        }
    }

    public void resume() {
        m7587e();
    }

    public void setActivity(Context context) {
        this.f7077f = context;
        this.f7091t = System.currentTimeMillis();
        m7563a();
        this.f7089r.set(false);
        m7581c();
        C2007b.m7486a(getApplicationContext());
        C1918a.m7217a().m7223a(getApplicationContext());
        C1991m.m7449a().m7450a(getApplicationContext());
        this.f7082k = new C2025a(this.f7085n);
        this.f7082k.setEventHandler(new C2052e(this));
        m7582c(this.f7077f);
        C1971q.m7360a(this.f7077f).m7369a();
    }

    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        this.f7094x = iXAdResponseInfo;
    }

    public void setAdSlotBase(RelativeLayout relativeLayout) {
        this.f7076e = relativeLayout;
    }

    public void setId(String str) {
        this.f7095y = str;
    }

    public void setParameter(HashMap<String, String> hashMap) {
        this.f7088q = hashMap;
    }

    public void start() {
        if (this.f7079h != null) {
            this.f7079h.start();
        }
    }

    public void stop() {
        C1991m.m7449a().m7457f().m7402i("XAbstractAdProdTemplate", "stop");
        if (this.f7079h != null) {
            this.f7079h.stop();
            this.f7079h = null;
        }
    }
}
