package com.google.android.gms.p146b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.analytics.tracking.android.ModelFields;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.overlay.C2871m;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.ii;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.ca */
public final class ca {
    public static final cb f10400a;
    public static final cb f10401b;
    public static final cb f10402c;
    public static final cb f10403d;
    public static final cb f10404e;
    public static final cb f10405f;
    public static final cb f10406g;
    public static final cb f10407h;
    public static final cb f10408i;
    public static final cb f10409j;
    public static final cb f10410k;
    public static final cb f10411l;
    public static final cb f10412m;
    public static final cb f10413n;

    /* renamed from: com.google.android.gms.b.ca.1 */
    static class C30581 implements cb {
        C30581() {
        }

        public void m12016a(ii iiVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.b.ca.2 */
    static class C30592 implements cb {
        C30592() {
        }

        public void m12017a(ii iiVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                C2972b.m11583d("URL missing from httpTrack GMSG.");
            } else {
                new hq(iiVar.getContext(), iiVar.m13252o().f10081b, str).m10975g();
            }
        }
    }

    /* renamed from: com.google.android.gms.b.ca.3 */
    static class C30603 implements cb {
        C30603() {
        }

        public void m12018a(ii iiVar, Map<String, String> map) {
            C2972b.m11581c("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.b.ca.4 */
    static class C30614 implements cb {
        C30614() {
        }

        public void m12019a(ii iiVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C3326k n = iiVar.m13251n();
                if (n != null) {
                    n.m13586a().m10934a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                C2972b.m11583d("Could not parse touch parameters from gmsg.");
            }
        }
    }

    /* renamed from: com.google.android.gms.b.ca.5 */
    static class C30625 implements cb {
        C30625() {
        }

        public void m12020a(ii iiVar, Map<String, String> map) {
            if (((Boolean) aq.at.m11794c()).booleanValue()) {
                iiVar.m13239c(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.b.ca.6 */
    static class C30636 implements cb {
        C30636() {
        }

        public void m12021a(ii iiVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                C2972b.m11583d("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            Map hashMap = new HashMap();
            PackageManager packageManager = iiVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), AccessibilityNodeInfoCompat.ACTION_CUT) != null));
            }
            iiVar.m13230a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.b.ca.7 */
    static class C30647 implements cb {
        C30647() {
        }

        public void m12022a(ii iiVar, Map<String, String> map) {
            PackageManager packageManager = iiVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get(com.taobao.accs.common.Constants.KEY_DATA)).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString(AgooConstants.MESSAGE_ID);
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
                                jSONObject.put(optString, packageManager.resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT) != null);
                            } catch (Throwable e) {
                                C2972b.m11580b("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            C2972b.m11580b("Error parsing the intent data.", e2);
                        }
                    }
                    iiVar.m12206b("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    iiVar.m12206b("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                iiVar.m12206b("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.b.ca.8 */
    static class C30658 implements cb {
        C30658() {
        }

        public void m12023a(ii iiVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                C2972b.m11583d("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C3326k n = iiVar.m13251n();
                if (n != null && n.m13589b(parse)) {
                    a = n.m13585a(parse, iiVar.getContext());
                    new hq(iiVar.getContext(), iiVar.m13252o().f10081b, a.toString()).m10975g();
                }
            } catch (C3348l e) {
                C2972b.m11583d("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new hq(iiVar.getContext(), iiVar.m13252o().f10081b, a.toString()).m10975g();
        }
    }

    /* renamed from: com.google.android.gms.b.ca.9 */
    static class C30669 implements cb {
        C30669() {
        }

        public void m12024a(ii iiVar, Map<String, String> map) {
            C2864d i = iiVar.m13246i();
            if (i != null) {
                i.m11097a();
                return;
            }
            i = iiVar.m13247j();
            if (i != null) {
                i.m11097a();
            } else {
                C2972b.m11583d("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    static {
        f10400a = new C30581();
        f10401b = new C30636();
        f10402c = new C30647();
        f10403d = new C30658();
        f10404e = new C30669();
        f10405f = new cb() {
            private void m12013a(ii iiVar) {
                C2972b.m11581c("Received support message, responding.");
                boolean z = false;
                C2795e h = iiVar.m13245h();
                if (h != null) {
                    C2871m c2871m = h.f9479c;
                    if (c2871m != null) {
                        z = c2871m.m11169a();
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ModelFields.EVENT, "checkSupport");
                    jSONObject.put("supports", z);
                    iiVar.m12206b("appStreaming", jSONObject);
                } catch (Throwable th) {
                }
            }

            public void m12014a(ii iiVar, Map<String, String> map) {
                if ("checkSupport".equals(map.get(PushConsts.CMD_ACTION))) {
                    m12013a(iiVar);
                    return;
                }
                C2864d i = iiVar.m13246i();
                if (i != null) {
                    i.m11101a(iiVar, (Map) map);
                }
            }
        };
        f10406g = new cb() {
            public void m12015a(ii iiVar, Map<String, String> map) {
                iiVar.m13237b(MessageService.MSG_DB_NOTIFY_REACHED.equals(map.get("custom_close")));
            }
        };
        f10407h = new C30592();
        f10408i = new C30603();
        f10409j = new C30614();
        f10410k = new C30625();
        f10411l = new ck();
        f10412m = new co();
        f10413n = new bz();
    }
}
