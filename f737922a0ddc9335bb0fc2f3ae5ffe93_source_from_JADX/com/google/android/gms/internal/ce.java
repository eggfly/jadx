package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.overlay.i;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@eh
public final class ce implements by {
    private boolean DW;
    private final Map<fj, Integer> j6;

    public ce() {
        this.j6 = new WeakHashMap();
    }

    private static int j6(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = w.j6().j6(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                b.Hw(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            }
        }
        return i;
    }

    public void j6(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            b.Hw("Action missing from video GMSG.");
            return;
        }
        if (b.j6(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            b.j6(new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            valueOf = (String) map.get("color");
            if (TextUtils.isEmpty(valueOf)) {
                b.Hw("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(valueOf);
                fh U2 = fjVar.U2();
                if (U2 != null) {
                    i j6 = U2.j6();
                    if (j6 != null) {
                        j6.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.j6.put(fjVar, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                b.Hw("Invalid color parameter in video GMSG.");
                return;
            }
        }
        fh U22 = fjVar.U2();
        if (U22 == null) {
            b.Hw("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int j62;
        int j63;
        if (equals || equals2) {
            int parseInt;
            Context context = fjVar.getContext();
            int j64 = j6(context, map, "x", 0);
            j62 = j6(context, map, "y", 0);
            j63 = j6(context, map, "w", -1);
            int j65 = j6(context, map, "h", -1);
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                parseInt = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && U22.j6() == null) {
                U22.j6(j64, j62, j63, j65, parseInt, parseBoolean);
                if (this.j6.containsKey(fjVar)) {
                    U22.j6().setBackgroundColor(((Integer) this.j6.get(fjVar)).intValue());
                    return;
                }
                return;
            }
            U22.j6(j64, j62, j63, j65);
            return;
        }
        i j66 = U22.j6();
        if (j66 == null) {
            i.j6(fjVar);
        } else if ("click".equals(str)) {
            r0 = fjVar.getContext();
            j62 = j6(r0, map, "x", 0);
            j63 = j6(r0, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) j62, (float) j63, 0);
            j66.j6(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            valueOf = (String) map.get("time");
            if (valueOf == null) {
                b.Hw("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                j66.j6((int) (Float.parseFloat(valueOf) * 1000.0f));
            } catch (NumberFormatException e3) {
                str = "Could not parse time parameter from currentTime video GMSG: ";
                valueOf = String.valueOf(valueOf);
                b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("hide".equals(str)) {
            j66.setVisibility(4);
        } else if ("load".equals(str)) {
            j66.j6();
        } else if ("mimetype".equals(str)) {
            j66.setMimeType((String) map.get("mimetype"));
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                j66.Hw();
            } else {
                j66.v5();
            }
        } else if ("pause".equals(str)) {
            j66.DW();
        } else if ("play".equals(str)) {
            j66.FH();
        } else if ("show".equals(str)) {
            j66.setVisibility(0);
        } else if ("src".equals(str)) {
            j66.j6((String) map.get("src"));
        } else if ("touchMove".equals(str)) {
            r0 = fjVar.getContext();
            j66.j6((float) j6(r0, map, "dx", 0), (float) j6(r0, map, "dy", 0));
            if (!this.DW) {
                fjVar.tp().XL();
                this.DW = true;
            }
        } else if ("volume".equals(str)) {
            valueOf = (String) map.get("volume");
            if (valueOf == null) {
                b.Hw("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                j66.j6(Float.parseFloat(valueOf));
            } catch (NumberFormatException e4) {
                str = "Could not parse volume parameter from volume video GMSG: ";
                valueOf = String.valueOf(valueOf);
                b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("watermark".equals(str)) {
            j66.Zo();
        } else {
            String str2 = "Unknown video action: ";
            valueOf = String.valueOf(str);
            b.Hw(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
