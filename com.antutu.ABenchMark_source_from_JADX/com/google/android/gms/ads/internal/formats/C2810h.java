package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.formats.h */
public interface C2810h {

    /* renamed from: com.google.android.gms.ads.internal.formats.h.a */
    public interface C2804a {
        void m10804a(C2810h c2810h);

        String m10805j();

        String m10806k();

        C2799a m10807l();
    }

    void m10862a();

    void m10863a(MotionEvent motionEvent);

    void m10864a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void m10865a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void m10866b(View view);

    void m10867c(View view);

    View m10868e();

    Context m10869f();
}
