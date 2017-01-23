package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ScreenSizeMode;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p079d.C1899b;
import com.baidu.mobads.openad.p079d.C1912c;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.p103f.C2054b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XAdContext implements IXAdContext {
    public static final String TAG = "XAdContext";
    int f6521a;
    int f6522b;
    private HashMap<String, Object> f6523c;
    private ScreenSizeMode f6524d;
    private VideoState f6525e;
    private ActivityState f6526f;
    private VisitorAction f6527g;
    private double f6528h;
    private int f6529i;
    private int f6530j;
    private Context f6531k;
    private String f6532l;
    private Location f6533m;
    protected IXAdLogger mAdLogger;
    private Activity f6534n;
    private RelativeLayout f6535o;
    private final IOAdEventDispatcher f6536p;
    private final XAdSlotManager f6537q;

    /* renamed from: com.baidu.mobad.video.XAdContext.1 */
    class C18951 implements Runnable {
        final /* synthetic */ XAdContext f6513a;

        C18951(XAdContext xAdContext) {
            this.f6513a = xAdContext;
        }

        public void run() {
            IXAdProd retrievePrerollAdSlot = this.f6513a.f6537q.retrievePrerollAdSlot();
            if (retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
                retrievePrerollAdSlot.resize();
            }
        }
    }

    class AdSlotEventListener implements IOAdEventListener {
        public static final String TAG = "AdSlotEventListener";
        final /* synthetic */ XAdContext f6517a;
        private final Context f6518b;
        private final IXAdProd f6519c;
        private final IOAdEventDispatcher f6520d;

        /* renamed from: com.baidu.mobad.video.XAdContext.AdSlotEventListener.1 */
        class C18961 implements Runnable {
            final /* synthetic */ AdSlotEventListener f6514a;

            C18961(AdSlotEventListener adSlotEventListener) {
                this.f6514a = adSlotEventListener;
            }

            public void run() {
                this.f6514a.f6519c.getProdBase().setVisibility(0);
            }
        }

        /* renamed from: com.baidu.mobad.video.XAdContext.AdSlotEventListener.2 */
        class C18972 implements Runnable {
            final /* synthetic */ AdSlotEventListener f6515a;

            C18972(AdSlotEventListener adSlotEventListener) {
                this.f6515a = adSlotEventListener;
            }

            public void run() {
                this.f6515a.f6519c.getProdBase().setVisibility(4);
            }
        }

        /* renamed from: com.baidu.mobad.video.XAdContext.AdSlotEventListener.3 */
        class C18983 implements Runnable {
            final /* synthetic */ AdSlotEventListener f6516a;

            C18983(AdSlotEventListener adSlotEventListener) {
                this.f6516a = adSlotEventListener;
            }

            public void run() {
                this.f6516a.f6519c.getProdBase().setVisibility(4);
            }
        }

        public AdSlotEventListener(XAdContext xAdContext, Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.f6517a = xAdContext;
            this.f6518b = context;
            this.f6519c = iXAdProd;
            this.f6520d = iOAdEventDispatcher;
        }

        public void run(IOAdEvent iOAdEvent) {
            C1991m.m7449a().m7457f().m7402i(TAG, iOAdEvent.getType());
            if (iOAdEvent.getType().equals(C1899b.COMPLETE)) {
                this.f6520d.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, this.f6519c));
            }
            if (iOAdEvent.getType().equals(IXAdEvent.AD_STARTED)) {
                new Handler(this.f6518b.getMainLooper()).post(new C18961(this));
                this.f6520d.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_STARTED, this.f6519c));
            }
            if (iOAdEvent.getType().equals(IXAdEvent.AD_STOPPED)) {
                new Handler(this.f6518b.getMainLooper()).post(new C18972(this));
                this.f6520d.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_ENDED, this.f6519c));
            }
            if (iOAdEvent.getType().equals(IXAdEvent.AD_ERROR)) {
                new Handler(this.f6518b.getMainLooper()).post(new C18983(this));
                this.f6520d.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_ERROR, this.f6519c));
            }
        }
    }

    public XAdContext(Context context, String str, Location location) {
        this.f6523c = new HashMap();
        this.f6524d = ScreenSizeMode.FULL_SCREEN;
        this.f6525e = VideoState.IDLE;
        this.f6526f = ActivityState.CREATE;
        this.f6521a = 0;
        this.f6522b = 0;
        this.f6531k = context;
        this.f6532l = str;
        this.f6533m = location;
        this.f6536p = new C1912c();
        this.f6537q = new XAdSlotManager();
        this.mAdLogger = C1991m.m7449a().m7457f();
    }

    private void m7175a(Set<String> set) {
        C2021a c2021a = new C2021a();
        for (String c2024d : set) {
            C2024d c2024d2 = new C2024d(c2024d, BuildConfig.FLAVOR);
            c2024d2.f7057e = 1;
            c2021a.m7547a(c2024d2, Boolean.valueOf(true));
        }
    }

    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.f6536p.addEventListener(str, iOAdEventListener);
    }

    public void dispatchEvent(IOAdEvent iOAdEvent) {
    }

    public void dispose() {
    }

    public Activity getActivity() {
        return this.f6534n;
    }

    public Object getParameter(String str) {
        return this.f6523c.get(str);
    }

    public IXAdProd getSlotById(String str) {
        return this.f6537q.retrieveAdSlotById(str);
    }

    public IXAdManager getXAdManager() {
        return null;
    }

    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.f6537q.containsAdSlot(str).booleanValue()) {
            IXAdProd c2054b = new C2054b(this.f6534n, str);
            c2054b.setActivity(this.f6534n);
            c2054b.setAdSlotBase(this.f6535o);
            c2054b.setId(str);
            IOAdEventListener adSlotEventListener = new AdSlotEventListener(this, this.f6531k, c2054b, this.f6536p);
            c2054b.removeAllListeners();
            c2054b.addEventListener(C1899b.COMPLETE, adSlotEventListener);
            c2054b.addEventListener(IXAdEvent.AD_STARTED, adSlotEventListener);
            c2054b.addEventListener(IXAdEvent.AD_STOPPED, adSlotEventListener);
            c2054b.addEventListener(IXAdEvent.AD_ERROR, adSlotEventListener);
            this.f6537q.addAdSlot(c2054b);
        }
        return this.f6537q.retrievePrerollAdSlot();
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
        this.f6527g = visitorAction;
    }

    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.f6536p.removeEventListener(str, iOAdEventListener);
    }

    public void setActivity(Activity activity) {
        if (activity != null && this.f6534n == null) {
            this.f6534n = activity;
            if (this.f6531k == null) {
                this.f6531k = this.f6534n.getApplicationContext();
            }
        }
    }

    public void setActivityState(ActivityState activityState) {
        this.f6526f = activityState;
        this.mAdLogger.m7402i(TAG, activityState.getValue());
        IXAdProd retrievePrerollAdSlot = this.f6537q.retrievePrerollAdSlot();
        if (retrievePrerollAdSlot != null) {
            if (activityState == ActivityState.PAUSE) {
                retrievePrerollAdSlot.pause();
            }
            if (activityState == ActivityState.RESUME) {
                retrievePrerollAdSlot.resume();
            }
        }
    }

    public void setAdCreativeLoadingTimeout(int i) {
        this.f6530j = i;
    }

    public void setAdServerRequestingTimeout(int i) {
        this.f6529i = i;
    }

    public void setContentVideoPlayheadTime(double d) {
        this.f6528h = d;
    }

    public void setContentVideoScreenMode(ScreenSizeMode screenSizeMode) {
        this.f6524d = screenSizeMode;
        IXAdProd retrievePrerollAdSlot = this.f6537q.retrievePrerollAdSlot();
        if (this.f6524d == ScreenSizeMode.FULL_SCREEN && retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
            IXAdInstanceInfo currentAdInstance = retrievePrerollAdSlot.getCurrentAdInstance();
            if (currentAdInstance != null) {
                int playheadTime = (int) retrievePrerollAdSlot.getCurrentXAdContainer().getPlayheadTime();
                IXAdURIUitls i = C1991m.m7449a().m7460i();
                List arrayList = new ArrayList();
                List fullScreenTrackers = currentAdInstance.getFullScreenTrackers();
                for (int i2 = 0; i2 < fullScreenTrackers.size(); i2++) {
                    arrayList.add(i.addParameter((String) fullScreenTrackers.get(i2), NotificationCompatApi21.CATEGORY_PROGRESS, BuildConfig.FLAVOR + playheadTime));
                }
                currentAdInstance.setFullScreenTrackers(arrayList);
                Set hashSet = new HashSet();
                hashSet.addAll(currentAdInstance.getFullScreenTrackers());
                m7175a(hashSet);
            }
        }
    }

    public void setContentVideoState(VideoState videoState) {
        this.f6525e = videoState;
    }

    public void setParameter(String str, Object obj) {
        this.f6523c.put(str, obj);
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.f6535o = relativeLayout;
        setActivity((Activity) this.f6535o.getContext());
        new Handler(getActivity().getMainLooper()).post(new C18951(this));
    }

    public void setVideoDisplayBaseHeight(int i) {
        this.f6522b = i;
    }

    public void setVideoDisplayBaseWidth(int i) {
        this.f6521a = i;
    }

    public void submitRequest() {
        IXAdProd retrievePrerollAdSlot = this.f6537q.retrievePrerollAdSlot();
        if (this.f6529i > 0 && this.f6530j > 0) {
            HashMap parameter = retrievePrerollAdSlot.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, BuildConfig.FLAVOR + this.f6529i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, BuildConfig.FLAVOR + this.f6530j);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_WIDTH, BuildConfig.FLAVOR + this.f6521a);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_HEIGHT, BuildConfig.FLAVOR + this.f6522b);
            retrievePrerollAdSlot.setParameter(parameter);
        }
        retrievePrerollAdSlot.request();
    }
}
