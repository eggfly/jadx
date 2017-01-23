package com.google.android.gms.p146b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.overlay.C2869k;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.igexin.download.Downloads;
import com.igexin.sdk.PushConsts;
import com.umeng.message.proguard.C4233j;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.ck */
public final class ck implements cb {
    private final Map<ii, Integer> f10450a;

    public ck() {
        this.f10450a = new WeakHashMap();
    }

    private static int m12067a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = C2784w.m10741a().m11560a(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                C2972b.m11583d("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void m12068a(ii iiVar, Map<String, String> map) {
        String str = (String) map.get(PushConsts.CMD_ACTION);
        if (str == null) {
            C2972b.m11583d("Action missing from video GMSG.");
            return;
        }
        if (C2972b.m11578a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            C2972b.m11576a("Video GMSG: " + str + " " + jSONObject.toString());
        }
        String str2;
        if ("background".equals(str)) {
            str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                C2972b.m11583d("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                ih v = iiVar.m13259v();
                if (v != null) {
                    C2869k a = v.m13213a();
                    if (a != null) {
                        a.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.f10450a.put(iiVar, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                C2972b.m11583d("Invalid color parameter in video GMSG.");
                return;
            }
        }
        ih v2 = iiVar.m13259v();
        if (v2 == null) {
            C2972b.m11583d("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int a2;
        int a3;
        if (equals || equals2) {
            int parseInt;
            Context context = iiVar.getContext();
            int a4 = ck.m12067a(context, map, "x", 0);
            a2 = ck.m12067a(context, map, "y", 0);
            a3 = ck.m12067a(context, map, IXAdRequestInfo.WIDTH, -1);
            int a5 = ck.m12067a(context, map, IXAdRequestInfo.HEIGHT, -1);
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                parseInt = 0;
            }
            if (equals && v2.m13213a() == null) {
                v2.m13215a(a4, a2, a3, a5, parseInt);
                if (this.f10450a.containsKey(iiVar)) {
                    a4 = ((Integer) this.f10450a.get(iiVar)).intValue();
                    C2869k a6 = v2.m13213a();
                    a6.setBackgroundColor(a4);
                    a6.m11160l();
                    return;
                }
                return;
            }
            v2.m13214a(a4, a2, a3, a5);
            return;
        }
        C2869k a7 = v2.m13213a();
        if (a7 == null) {
            C2869k.m11136a(iiVar);
        } else if ("click".equals(str)) {
            Context context2 = iiVar.getContext();
            a2 = ck.m12067a(context2, map, "x", 0);
            a3 = ck.m12067a(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a2, (float) a3, 0);
            a7.m11147a(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            str2 = (String) map.get(C4233j.f14377D);
            if (str2 == null) {
                C2972b.m11583d("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                a7.m11145a((int) (Float.parseFloat(str2) * 1000.0f));
            } catch (NumberFormatException e3) {
                C2972b.m11583d("Could not parse time parameter from currentTime video GMSG: " + str2);
            }
        } else if ("hide".equals(str)) {
            a7.setVisibility(4);
        } else if ("load".equals(str)) {
            a7.m11155g();
        } else if (Downloads.COLUMN_MIME_TYPE.equals(str)) {
            a7.setMimeType((String) map.get(Downloads.COLUMN_MIME_TYPE));
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                a7.m11158j();
            } else {
                a7.m11159k();
            }
        } else if ("pause".equals(str)) {
            a7.m11156h();
        } else if ("play".equals(str)) {
            a7.m11157i();
        } else if ("show".equals(str)) {
            a7.setVisibility(0);
        } else if ("src".equals(str)) {
            a7.m11148a((String) map.get("src"));
        } else if ("volume".equals(str)) {
            str2 = (String) map.get("volume");
            if (str2 == null) {
                C2972b.m11583d("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                a7.m11144a(Float.parseFloat(str2));
            } catch (NumberFormatException e4) {
                C2972b.m11583d("Could not parse volume parameter from volume video GMSG: " + str2);
            }
        } else if ("watermark".equals(str)) {
            a7.m11160l();
        } else {
            C2972b.m11583d("Unknown video action: " + str);
        }
    }
}
