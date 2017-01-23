package com.facebook.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
import com.facebook.ads.InterstitialAdActivity;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

/* renamed from: com.facebook.ads.internal.util.t */
public class C2512t {
    public static float m9519a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume > 0) {
                return (((float) streamVolume) * 1.0f) / ((float) streamMaxVolume);
            }
        }
        return 0.0f;
    }

    public static HashMap<String, String> m9520a(Context context, boolean z, boolean z2) {
        String valueOf = String.valueOf(C2512t.m9519a(context));
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("inline", z2 ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
        hashMap.put(InterstitialAdActivity.AUTOPLAY, z ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
        hashMap.put("vlm", valueOf);
        hashMap.put("vla", valueOf);
        return hashMap;
    }
}
