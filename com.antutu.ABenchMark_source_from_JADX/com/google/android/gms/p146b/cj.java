package com.google.android.gms.p146b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.igexin.sdk.PushConsts;
import com.umeng.message.proguard.C4233j;
import java.util.Map;

/* renamed from: com.google.android.gms.b.cj */
public class cj implements cb {
    private final C2835a f10449a;

    /* renamed from: com.google.android.gms.b.cj.a */
    public interface C2835a {
        void m10982E();

        void m10983b(RewardItemParcel rewardItemParcel);
    }

    public cj(C2835a c2835a) {
        this.f10449a = c2835a;
    }

    public static void m12063a(ii iiVar, C2835a c2835a) {
        iiVar.m13249l().m13287a("/reward", new cj(c2835a));
    }

    private void m12064a(Map<String, String> map) {
        RewardItemParcel rewardItemParcel;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get(C4233j.f14402y);
            if (!TextUtils.isEmpty(str)) {
                rewardItemParcel = new RewardItemParcel(str, parseInt);
                this.f10449a.m10983b(rewardItemParcel);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Unable to parse reward amount.", e);
        }
        rewardItemParcel = null;
        this.f10449a.m10983b(rewardItemParcel);
    }

    private void m12065b(Map<String, String> map) {
        this.f10449a.m10982E();
    }

    public void m12066a(ii iiVar, Map<String, String> map) {
        String str = (String) map.get(PushConsts.CMD_ACTION);
        if ("grant".equals(str)) {
            m12064a(map);
        } else if ("video_start".equals(str)) {
            m12065b(map);
        }
    }
}
