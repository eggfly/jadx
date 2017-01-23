package com.baidu.mobads.production.p103f;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.p079d.C1899b;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.production.C2028a;
import com.baidu.mobads.production.C2066q;
import com.baidu.mobads.vo.C2031d;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.baidu.mobads.production.f.b */
public class C2054b extends C2028a implements IXLinearAdSlot, IOAdEventDispatcher {
    private C2053a f7160w;

    public C2054b(Context context, String str) {
        super(context);
        setId(str);
        this.p = SlotType.SLOT_TYPE_PREROLL;
    }

    private void m7724a(Set<String> set) {
        C2021a c2021a = new C2021a();
        for (String c2024d : set) {
            C2024d c2024d2 = new C2024d(c2024d, BuildConfig.FLAVOR);
            c2024d2.f7057e = 1;
            c2021a.m7547a(c2024d2, Boolean.valueOf(true));
        }
    }

    protected void m7725a(C2024d c2024d, C2066q c2066q, int i) {
        String str = (String) getParameter().get(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT);
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
            }
        }
        c2066q.m7546a(c2024d, (double) i);
    }

    public void m7726b() {
        this.s.m7402i("XPrerollAdSlot", "afterAdContainerInit()");
        dispatchEvent(new C1899b(C1899b.COMPLETE));
    }

    protected void m7727c() {
        this.f7085n = 8000;
    }

    protected void m7728c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == CreativeType.STATIC_IMAGE) {
            start();
        }
    }

    protected void m7729d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        Set hashSet = new HashSet();
        hashSet.addAll(iXAdContainer.getAdContainerContext().getAdInstanceInfo().getStartTrackers());
        m7724a(hashSet);
    }

    protected void m7730e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.m7588e(iXAdContainer, hashMap);
        this.m = SlotState.COMPLETED;
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m7731l();
    }

    public int getDuration() {
        return this.f7079h == null ? super.getDuration() : (int) this.h.getDuration();
    }

    public Object getParameter(String str) {
        return null;
    }

    public int getPlayheadTime() {
        return this.f7079h == null ? super.getPlayheadTime() : (int) this.h.getPlayheadTime();
    }

    public C2031d m7731l() {
        return this.f7160w;
    }

    public void load() {
        this.f7089r.set(true);
        super.load();
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
    }

    public void pause() {
        this.s.m7402i("XPrerollAdSlot", "pause()" + getSlotState().getValue());
        if (getSlotState() == SlotState.PLAYING) {
            super.pause();
        }
    }

    public void request() {
        int parseInt;
        int parseInt2;
        this.f7160w = new C2053a(getApplicationContext(), getActivity(), this.p, this);
        this.f7160w.m7623d(getId());
        HashMap parameter = getParameter();
        String str = (String) parameter.get(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_WIDTH);
        String str2 = (String) parameter.get(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_HEIGHT);
        if (str != null) {
            try {
                parseInt = Integer.parseInt(str);
            } catch (Exception e) {
                parseInt = 0;
            }
        } else {
            parseInt = 0;
        }
        if (str2 != null) {
            try {
                parseInt2 = Integer.parseInt(str2);
            } catch (Exception e2) {
                parseInt2 = 0;
            }
        } else {
            parseInt2 = 0;
        }
        this.f7160w.m7613a(parseInt);
        this.f7160w.m7617b(parseInt2);
        super.m7575a(this.f7160w);
    }

    public void resume() {
        this.s.m7402i("XPrerollAdSlot", "resume()" + getSlotState().getValue());
        if (getSlotState() == SlotState.PAUSED) {
            super.resume();
        }
    }

    public void setActivityState(ActivityState activityState) {
    }

    public void setContentVideoAssetCurrentTimePosition(double d) {
    }

    public void setMaxAdNum(int i) {
    }

    public void setMaxDuration(int i) {
    }

    public void setParameter(String str, Object obj) {
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.e = relativeLayout;
    }

    public void setVideoState(VideoState videoState) {
    }

    public void start() {
        if (this.f7089r.get()) {
            super.start();
        } else {
            load();
        }
    }

    public void stop() {
        this.s.m7402i("XPrerollAdSlot", "stop()" + getSlotState().getValue());
        super.stop();
    }
}
