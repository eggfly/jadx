package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.spdy.SpdyProtocol;

class NoopDispatcher implements Dispatcher {
    NoopDispatcher() {
    }

    public int dispatchHits(List<Hit> list) {
        if (list == null) {
            return 0;
        }
        Log.iDebug("Hits not actually being sent as dispatch is false...");
        int min = Math.min(list.size(), 40);
        for (int i = 0; i < min; i++) {
            if (Log.isDebugEnabled()) {
                String postProcessHit = TextUtils.isEmpty(((Hit) list.get(i)).getHitParams()) ? BuildConfig.FLAVOR : HitBuilder.postProcessHit((Hit) list.get(i), System.currentTimeMillis());
                String str = TextUtils.isEmpty(postProcessHit) ? "Hit couldn't be read, wouldn't be sent:" : postProcessHit.length() <= 2036 ? "GET would be sent:" : postProcessHit.length() > SpdyProtocol.SLIGHTSSL_1_RTT_MODE ? "Would be too big:" : "POST would be sent:";
                Log.iDebug(str + postProcessHit);
            }
        }
        return min;
    }

    public boolean okToDispatch() {
        return true;
    }
}
