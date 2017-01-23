package com.google.android.gms.p146b;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gn.C3231a;
import com.igexin.download.Downloads;
import com.igexin.sdk.PushBuildConfig;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.ge */
public final class ge {
    private static final SimpleDateFormat f11054a;

    static {
        f11054a = new SimpleDateFormat("yyyyMMdd", Locale.US);
    }

    public static AdResponseParcel m12826a(Context context, AdRequestInfoParcel adRequestInfoParcel, String str) {
        try {
            String str2;
            long j;
            String optString;
            String str3;
            boolean optBoolean;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            boolean z = (adRequestInfoParcel == null || adRequestInfoParcel.f9863m == 0) ? false : true;
            CharSequence optString5 = z ? jSONObject.optString("ad_json", null) : jSONObject.optString("ad_html", null);
            long j2 = -1;
            String optString6 = jSONObject.optString("debug_dialog", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString7 = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString7)) {
                i = C2968s.m11527g().m13089b();
            } else if ("landscape".equals(optString7)) {
                i = C2968s.m11527g().m13075a();
            }
            AdResponseParcel adResponseParcel = null;
            if (TextUtils.isEmpty(optString5)) {
                if (TextUtils.isEmpty(optString3)) {
                    C2972b.m11583d("Could not parse the mediation config: Missing required " + (z ? "ad_json" : "ad_html") + " or " + "ad_url" + " field.");
                    return new AdResponseParcel(0);
                }
                adResponseParcel = gd.m12819a(adRequestInfoParcel, context, adRequestInfoParcel.f9861k.f10081b, optString3, null, null, null, null, null);
                optString2 = adResponseParcel.f9886b;
                str2 = adResponseParcel.f9887c;
                j2 = adResponseParcel.f9898n;
            } else if (TextUtils.isEmpty(optString2)) {
                C2972b.m11583d("Could not parse the mediation config: Missing required ad_base_url field");
                return new AdResponseParcel(0);
            } else {
                CharSequence charSequence = optString5;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list = adResponseParcel == null ? null : adResponseParcel.f9888d;
            if (optJSONArray != null) {
                list = ge.m12830a(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            List list2 = adResponseParcel == null ? null : adResponseParcel.f9890f;
            if (optJSONArray != null) {
                list2 = ge.m12830a(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            List list3 = adResponseParcel == null ? null : adResponseParcel.f9894j;
            if (optJSONArray != null) {
                list3 = ge.m12830a(optJSONArray, list3);
            }
            if (adResponseParcel != null) {
                if (adResponseParcel.f9896l != -1) {
                    i = adResponseParcel.f9896l;
                }
                if (adResponseParcel.f9891g > 0) {
                    j = adResponseParcel.f9891g;
                    optString = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j2, optString6, optBoolean, str3, optString, jSONObject.optBoolean("custom_render_allowed", false), z, adRequestInfoParcel.f9866p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optInt("oauth2_token_status", 0), jSONObject.optString("gws_query_id", BuildConfig.FLAVOR), "height".equals(jSONObject.optString("fluid", BuildConfig.FLAVOR)), jSONObject.optBoolean("native_express", false), RewardItemParcel.m11487a(jSONObject.optJSONArray("rewards")), ge.m12830a(jSONObject.optJSONArray("video_start_urls"), null), ge.m12830a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false));
                }
            }
            j = j3;
            optString = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j2, optString6, optBoolean, str3, optString, jSONObject.optBoolean("custom_render_allowed", false), z, adRequestInfoParcel.f9866p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optInt("oauth2_token_status", 0), jSONObject.optString("gws_query_id", BuildConfig.FLAVOR), "height".equals(jSONObject.optString("fluid", BuildConfig.FLAVOR)), jSONObject.optBoolean("native_express", false), RewardItemParcel.m11487a(jSONObject.optJSONArray("rewards")), ge.m12830a(jSONObject.optJSONArray("video_start_urls"), null), ge.m12830a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false));
        } catch (JSONException e) {
            C2972b.m11583d("Could not parse the mediation config: " + e.getMessage());
            return new AdResponseParcel(0);
        }
    }

    private static Integer m12827a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m12828a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }

    private static String m12829a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.f9487c : 0) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "portrait";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "landscape";
            default:
                return "any";
        }
    }

    private static List<String> m12830a(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    public static JSONObject m12831a(Context context, AdRequestInfoParcel adRequestInfoParcel, gj gjVar, C3231a c3231a, Location location, aj ajVar, String str, String str2, List<String> list, Bundle bundle) {
        try {
            Map hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list));
            }
            if (adRequestInfoParcel.f9852b != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.f9852b);
            }
            ge.m12833a((HashMap) hashMap, adRequestInfoParcel.f9853c);
            hashMap.put("format", adRequestInfoParcel.f9854d.f9326b);
            if (adRequestInfoParcel.f9854d.f9330f == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.f9854d.f9327c == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.f9854d.f9334j) {
                hashMap.put("fluid", "height");
            }
            if (adRequestInfoParcel.f9854d.f9332h != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.f9854d.f9332h) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(adSizeParcel.f9330f == -1 ? (int) (((float) adSizeParcel.f9331g) / gjVar.f11144r) : adSizeParcel.f9330f);
                    stringBuilder.append("x");
                    stringBuilder.append(adSizeParcel.f9327c == -2 ? (int) (((float) adSizeParcel.f9328d) / gjVar.f11144r) : adSizeParcel.f9327c);
                }
                hashMap.put("sz", stringBuilder);
            }
            if (adRequestInfoParcel.f9863m != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.f9863m));
                if (!adRequestInfoParcel.f9854d.f9335k) {
                    hashMap.put("native_templates", adRequestInfoParcel.f9864n);
                    hashMap.put("native_image_orientation", ge.m12829a(adRequestInfoParcel.f9876z));
                    if (!adRequestInfoParcel.f9844A.isEmpty()) {
                        hashMap.put("native_custom_templates", adRequestInfoParcel.f9844A);
                    }
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.f9855e);
            hashMap.put("pn", adRequestInfoParcel.f9856f.packageName);
            if (adRequestInfoParcel.f9857g != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.f9857g.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.f9859i);
            hashMap.put("session_id", adRequestInfoParcel.f9860j);
            hashMap.put("js", adRequestInfoParcel.f9861k.f10081b);
            ge.m12835a((HashMap) hashMap, gjVar, c3231a);
            hashMap.put(C0714a.PLATFORM, Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.f9853c.f9307a >= 2 && adRequestInfoParcel.f9853c.f9317k != null) {
                ge.m12832a((HashMap) hashMap, adRequestInfoParcel.f9853c.f9317k);
            }
            if (adRequestInfoParcel.f9851a >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.f9862l);
            }
            if (adRequestInfoParcel.f9851a >= 4 && adRequestInfoParcel.f9866p) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.f9866p));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.f9851a >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.f9870t));
                hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, Integer.valueOf(adRequestInfoParcel.f9869s));
                hashMap.put(IXAdRequestInfo.SCREEN_WIDTH, Integer.valueOf(adRequestInfoParcel.f9868r));
            } else {
                hashMap.put("u_sd", Float.valueOf(gjVar.f11144r));
                hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, Integer.valueOf(gjVar.f11146t));
                hashMap.put(IXAdRequestInfo.SCREEN_WIDTH, Integer.valueOf(gjVar.f11145s));
            }
            if (adRequestInfoParcel.f9851a >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.f9871u)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.f9871u));
                    } catch (Throwable e) {
                        C2972b.m11584d("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.f9872v));
            }
            if (adRequestInfoParcel.f9851a >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.f9873w);
            }
            if (adRequestInfoParcel.f9851a >= 11 && adRequestInfoParcel.f9846C != null) {
                hashMap.put("capability", adRequestInfoParcel.f9846C.m11298a());
            }
            ge.m12836a((HashMap) hashMap, str);
            if (adRequestInfoParcel.f9851a >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.f9847D)) {
                hashMap.put("anchor", adRequestInfoParcel.f9847D);
            }
            if (adRequestInfoParcel.f9851a >= 13) {
                hashMap.put("avol", Float.valueOf(adRequestInfoParcel.f9848E));
            }
            if (adRequestInfoParcel.f9851a >= 14 && adRequestInfoParcel.f9849F > 0) {
                hashMap.put("target_api", Integer.valueOf(adRequestInfoParcel.f9849F));
            }
            if (adRequestInfoParcel.f9851a >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(adRequestInfoParcel.f9850G == -1 ? -1 : adRequestInfoParcel.f9850G));
            }
            if (C2972b.m11578a(2)) {
                hf.m12982e("Ad Request JSON: " + C2968s.m11525e().m13030a(hashMap).toString(2));
            }
            return C2968s.m11525e().m13030a(hashMap);
        } catch (JSONException e2) {
            C2972b.m11583d("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void m12832a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put(C0714a.LATITUDE, valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put(C4233j.f14377D, valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m12833a(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String a = hd.m12977a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (adRequestParcel.f9308b != -1) {
            hashMap.put("cust_age", f11054a.format(new Date(adRequestParcel.f9308b)));
        }
        if (adRequestParcel.f9309c != null) {
            hashMap.put(Downloads.COLUMN_EXTRAS, adRequestParcel.f9309c);
        }
        if (adRequestParcel.f9310d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.f9310d));
        }
        if (adRequestParcel.f9311e != null) {
            hashMap.put("kw", adRequestParcel.f9311e);
        }
        if (adRequestParcel.f9313g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.f9313g));
        }
        if (adRequestParcel.f9312f) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.f9307a >= 2) {
            if (adRequestParcel.f9314h) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(adRequestParcel.f9315i)) {
                hashMap.put("ppid", adRequestParcel.f9315i);
            }
            if (adRequestParcel.f9316j != null) {
                ge.m12834a((HashMap) hashMap, adRequestParcel.f9316j);
            }
        }
        if (adRequestParcel.f9307a >= 3 && adRequestParcel.f9318l != null) {
            hashMap.put("url", adRequestParcel.f9318l);
        }
        if (adRequestParcel.f9307a >= 5) {
            if (adRequestParcel.f9320n != null) {
                hashMap.put("custom_targeting", adRequestParcel.f9320n);
            }
            if (adRequestParcel.f9321o != null) {
                hashMap.put("category_exclusions", adRequestParcel.f9321o);
            }
            if (adRequestParcel.f9322p != null) {
                hashMap.put("request_agent", adRequestParcel.f9322p);
            }
        }
        if (adRequestParcel.f9307a >= 6 && adRequestParcel.f9323q != null) {
            hashMap.put("request_pkg", adRequestParcel.f9323q);
        }
        if (adRequestParcel.f9307a >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.f9324r));
        }
    }

    private static void m12834a(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(searchAdRequestParcel.f9337b) != 0) {
            hashMap.put("acolor", ge.m12828a(searchAdRequestParcel.f9337b));
        }
        if (Color.alpha(searchAdRequestParcel.f9338c) != 0) {
            hashMap.put("bgcolor", ge.m12828a(searchAdRequestParcel.f9338c));
        }
        if (!(Color.alpha(searchAdRequestParcel.f9339d) == 0 || Color.alpha(searchAdRequestParcel.f9340e) == 0)) {
            hashMap.put("gradientto", ge.m12828a(searchAdRequestParcel.f9339d));
            hashMap.put("gradientfrom", ge.m12828a(searchAdRequestParcel.f9340e));
        }
        if (Color.alpha(searchAdRequestParcel.f9341f) != 0) {
            hashMap.put("bcolor", ge.m12828a(searchAdRequestParcel.f9341f));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.f9342g));
        switch (searchAdRequestParcel.f9343h) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                obj = PushBuildConfig.sdk_conf_debug_level;
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                obj = "dashed";
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                obj = "dotted";
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (searchAdRequestParcel.f9344i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                obj2 = "light";
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                obj2 = "medium";
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (searchAdRequestParcel.f9345j != null) {
            hashMap.put(C4209a.f14201d, searchAdRequestParcel.f9345j);
        }
        if (Color.alpha(searchAdRequestParcel.f9346k) != 0) {
            hashMap.put("dcolor", ge.m12828a(searchAdRequestParcel.f9346k));
        }
        if (searchAdRequestParcel.f9347l != null) {
            hashMap.put("font", searchAdRequestParcel.f9347l);
        }
        if (Color.alpha(searchAdRequestParcel.f9348m) != 0) {
            hashMap.put("hcolor", ge.m12828a(searchAdRequestParcel.f9348m));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.f9349n));
        if (searchAdRequestParcel.f9350o != null) {
            hashMap.put(IXAdRequestInfo.COST_NAME, searchAdRequestParcel.f9350o);
        }
    }

    private static void m12835a(HashMap<String, Object> hashMap, gj gjVar, C3231a c3231a) {
        hashMap.put("am", Integer.valueOf(gjVar.f11127a));
        hashMap.put("cog", ge.m12827a(gjVar.f11128b));
        hashMap.put("coh", ge.m12827a(gjVar.f11129c));
        if (!TextUtils.isEmpty(gjVar.f11130d)) {
            hashMap.put("carrier", gjVar.f11130d);
        }
        hashMap.put("gl", gjVar.f11131e);
        if (gjVar.f11132f) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (gjVar.f11133g) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", ge.m12827a(gjVar.f11134h));
        hashMap.put("sp", ge.m12827a(gjVar.f11135i));
        hashMap.put("hl", gjVar.f11136j);
        if (!TextUtils.isEmpty(gjVar.f11137k)) {
            hashMap.put("mv", gjVar.f11137k);
        }
        hashMap.put("muv", Integer.valueOf(gjVar.f11138l));
        if (gjVar.f11139m != -2) {
            hashMap.put("cnt", Integer.valueOf(gjVar.f11139m));
        }
        hashMap.put("gnt", Integer.valueOf(gjVar.f11140n));
        hashMap.put("pt", Integer.valueOf(gjVar.f11141o));
        hashMap.put("rm", Integer.valueOf(gjVar.f11142p));
        hashMap.put("riv", Integer.valueOf(gjVar.f11143q));
        Bundle bundle = new Bundle();
        bundle.putString("build", gjVar.f11151y);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", gjVar.f11148v);
        bundle2.putDouble("battery_level", gjVar.f11147u);
        bundle.putBundle("battery", bundle2);
        bundle2 = new Bundle();
        bundle2.putInt("active_network_state", gjVar.f11150x);
        bundle2.putBoolean("active_network_metered", gjVar.f11149w);
        if (c3231a != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("predicted_latency_micros", c3231a.f11156a);
            bundle3.putLong("predicted_down_throughput_bps", c3231a.f11157b);
            bundle3.putLong("predicted_up_throughput_bps", c3231a.f11158c);
            bundle2.putBundle("predictions", bundle3);
        }
        bundle.putBundle("network", bundle2);
        hashMap.put("device", bundle);
    }

    private static void m12836a(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            Map hashMap2 = new HashMap();
            hashMap2.put(Constants.EXTRA_KEY_TOKEN, str);
            hashMap.put("pan", hashMap2);
        }
    }
}
