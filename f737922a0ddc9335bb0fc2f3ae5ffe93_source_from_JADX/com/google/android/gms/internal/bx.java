package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@eh
public final class bx {
    public static final by DW;
    public static final by EQ;
    public static final by FH;
    public static final by Hw;
    public static final by J0;
    public static final by J8;
    public static final by QX;
    public static final by VH;
    public static final by Ws;
    public static final by Zo;
    public static final by gn;
    public static final by j6;
    public static final by tp;
    public static final by u7;
    public static final by v5;
    public static final by we;

    class 10 implements by {
        10() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                b.Hw("URL missing from click GMSG.");
                return;
            }
            Uri j6;
            Future future;
            Uri parse = Uri.parse(str);
            try {
                y Ws = fjVar.Ws();
                if (Ws != null && Ws.DW(parse)) {
                    j6 = Ws.j6(parse, fjVar.getContext());
                    future = (Future) new ex(fjVar.getContext(), fjVar.QX().DW, j6.toString()).FH();
                }
            } catch (z e) {
                String str2 = "Unable to append parameter to URL: ";
                str = String.valueOf(str);
                b.Hw(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            j6 = parse;
            future = (Future) new ex(fjVar.getContext(), fjVar.QX().DW, j6.toString()).FH();
        }
    }

    class 11 implements by {
        11() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            c tp = fjVar.tp();
            if (tp != null) {
                tp.j6();
                return;
            }
            tp = fjVar.EQ();
            if (tp != null) {
                tp.j6();
            } else {
                b.Hw("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    class 12 implements by {
        12() {
        }

        private void j6(fj fjVar) {
            b.FH("Received support message, responding.");
            boolean z = false;
            a u7 = fjVar.u7();
            if (u7 != null) {
                k kVar = u7.FH;
                if (kVar != null) {
                    z = kVar.j6();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", z);
                fjVar.j6("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void j6(fj fjVar, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                j6(fjVar);
                return;
            }
            c tp = fjVar.tp();
            if (tp != null) {
                tp.j6(fjVar, (Map) map);
            }
        }
    }

    class 1 implements by {
        1() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
        }
    }

    class 2 implements by {
        2() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            fjVar.DW("1".equals(map.get("custom_close")));
        }
    }

    class 3 implements by {
        3() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                b.Hw("URL missing from httpTrack GMSG.");
            } else {
                Future future = (Future) new ex(fjVar.getContext(), fjVar.QX().DW, str).FH();
            }
        }
    }

    class 4 implements by {
        4() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            String str = "Received log message: ";
            String valueOf = String.valueOf((String) map.get("string"));
            b.FH(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    class 5 implements by {
        5() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                y Ws = fjVar.Ws();
                if (Ws != null) {
                    Ws.j6().j6(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                b.Hw("Could not parse touch parameters from gmsg.");
            }
        }
    }

    class 6 implements by {
        6() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            if (((Boolean) aq.hK.FH()).booleanValue()) {
                fjVar.FH(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    class 7 implements by {
        7() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            String str = (String) map.get("action");
            if ("pause".equals(str)) {
                fjVar.j6();
            } else if ("resume".equals(str)) {
                fjVar.DW();
            }
        }
    }

    class 8 implements by {
        8() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                b.Hw("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = fjVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            fjVar.j6("openableURLs", hashMap);
        }
    }

    class 9 implements by {
        9() {
        }

        public void j6(fj fjVar, Map<String, String> map) {
            PackageManager packageManager = fjVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                b.DW("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            b.DW("Error parsing the intent data.", e2);
                        }
                    }
                    fjVar.j6("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    fjVar.j6("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                fjVar.j6("openableIntents", new JSONObject());
            }
        }
    }

    static {
        j6 = new 1();
        DW = new 8();
        FH = new 9();
        Hw = new 10();
        v5 = new 11();
        Zo = new 12();
        VH = new 2();
        gn = new 3();
        u7 = new 4();
        tp = new 5();
        EQ = new 6();
        we = new 7();
        J0 = new ce();
        J8 = new cf();
        Ws = new cj();
        QX = new bw();
    }
}
