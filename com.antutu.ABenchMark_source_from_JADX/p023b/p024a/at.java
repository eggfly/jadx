package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.C0714a;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.json.JSONArray;
import org.json.JSONObject;
import p023b.p024a.C0909w.C0897d;
import p023b.p024a.C0909w.C0898e;
import p023b.p024a.C0909w.C0900g;
import p023b.p024a.C0909w.C0901h;
import p023b.p024a.C0909w.C0902i;
import p023b.p024a.C0909w.C0904k;
import p023b.p024a.C0909w.C0907n;

/* renamed from: b.a.at */
public final class at {
    private static at f2716a;
    private static Context f2717b;
    private static String f2718c;
    private static long f2719e;
    private static long f2720f;
    private C0835a f2721d;

    /* renamed from: b.a.at.1 */
    class C08301 extends cd {
        final /* synthetic */ at f2703a;

        C08301(at atVar) {
            this.f2703a = atVar;
        }

        public void m3417a(Object obj, boolean z) {
            if (!obj.equals(MsgConstant.KEY_SUCCESS)) {
            }
        }
    }

    /* renamed from: b.a.at.2 */
    class C08312 extends JSONObject {
        final /* synthetic */ C0909w f2704a;
        final /* synthetic */ JSONObject f2705b;
        final /* synthetic */ at f2706c;

        C08312(at atVar, C0909w c0909w, JSONObject jSONObject) {
            this.f2706c = atVar;
            this.f2704a = c0909w;
            this.f2705b = jSONObject;
            this.f2706c.m3426a(this.f2704a, this, this.f2705b);
        }
    }

    /* renamed from: b.a.at.3 */
    class C08323 extends JSONObject {
        final /* synthetic */ C0909w f2707a;
        final /* synthetic */ JSONObject f2708b;
        final /* synthetic */ at f2709c;

        C08323(at atVar, C0909w c0909w, JSONObject jSONObject) {
            this.f2709c = atVar;
            this.f2707a = c0909w;
            this.f2708b = jSONObject;
            this.f2709c.m3429b(this.f2707a, this, this.f2708b);
        }
    }

    /* renamed from: b.a.at.a */
    public static class C0835a {
        private final int f2713a;
        private File f2714b;
        private FilenameFilter f2715c;

        /* renamed from: b.a.at.a.1 */
        class C08331 implements Runnable {
            final /* synthetic */ int f2710a;
            final /* synthetic */ C0835a f2711b;

            C08331(C0835a c0835a, int i) {
                this.f2711b = c0835a;
                this.f2710a = i;
            }

            public void run() {
                if (this.f2710a > 0) {
                    ci.m3705a(at.f2717b).m3731a((long) this.f2710a, System.currentTimeMillis(), C4156a.f13958t);
                }
            }
        }

        /* renamed from: b.a.at.a.2 */
        class C08342 implements FilenameFilter {
            final /* synthetic */ C0835a f2712a;

            C08342(C0835a c0835a) {
                this.f2712a = c0835a;
            }

            public boolean accept(File file, String str) {
                return str.startsWith("um");
            }
        }

        public C0835a(Context context) {
            this(context, ".um");
        }

        public C0835a(Context context, String str) {
            this.f2713a = 10;
            this.f2715c = new C08342(this);
            this.f2714b = new File(context.getFilesDir(), str);
            if (!this.f2714b.exists() || !this.f2714b.isDirectory()) {
                this.f2714b.mkdir();
            }
        }

        public void m3418a(C0836b c0836b) {
            int i;
            int i2 = 0;
            File[] listFiles = this.f2714b.listFiles(this.f2715c);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                aq.m3396b(new C08331(this, length));
                for (i = 0; i < length; i++) {
                    listFiles[i].delete();
                }
            }
            if (listFiles != null && listFiles.length > 0) {
                c0836b.m3421a(this.f2714b);
                i = listFiles.length;
                while (i2 < i) {
                    try {
                        if (c0836b.m3422b(listFiles[i2])) {
                            listFiles[i2].delete();
                        }
                    } catch (Throwable th) {
                        listFiles[i2].delete();
                    }
                    i2++;
                }
                c0836b.m3423c(this.f2714b);
            }
        }

        public void m3419a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                try {
                    an.m3373a(new File(this.f2714b, String.format(Locale.US, "um_cache_%d.env", new Object[]{Long.valueOf(System.currentTimeMillis())})), bArr);
                } catch (Exception e) {
                }
            }
        }

        public boolean m3420a() {
            File[] listFiles = this.f2714b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }
    }

    /* renamed from: b.a.at.b */
    public interface C0836b {
        void m3421a(File file);

        boolean m3422b(File file);

        void m3423c(File file);
    }

    static {
        f2716a = null;
        f2719e = 1209600000;
        f2720f = 2097152;
    }

    public at(Context context) {
        this.f2721d = new C0835a(context);
    }

    public static synchronized at m3424a(Context context) {
        at atVar;
        synchronized (at.class) {
            f2717b = context.getApplicationContext();
            f2718c = context.getPackageName();
            if (f2716a == null) {
                f2716a = new at(context);
            }
            atVar = f2716a;
        }
        return atVar;
    }

    private void m3426a(C0909w c0909w, JSONObject jSONObject, JSONObject jSONObject2) {
        jSONObject.put(C4209a.f14204g, c0909w.f3094a.f3055a);
        jSONObject.put(C4209a.f14201d, c0909w.f3094a.f3056b);
        if (c0909w.f3094a.f3057c != null) {
            jSONObject.put("secret", c0909w.f3094a.f3057c);
        }
        jSONObject.put(C4575b.PROPERTY_APP_VERSION, c0909w.f3094a.f3058d);
        jSONObject.put("display_name", c0909w.f3094a.f3061g);
        jSONObject.put("package_name", c0909w.f3094a.f3059e);
        jSONObject.put("app_signature", c0909w.f3094a.f3060f);
        jSONObject.put(C4209a.f14203f, c0909w.f3094a.f3062h);
        jSONObject.put("wrapper_type", c0909w.f3094a.f3063i);
        jSONObject.put("wrapper_version", c0909w.f3094a.f3064j);
        jSONObject.put("sdk_type", c0909w.f3094a.f3065k);
        jSONObject.put(C4209a.f14205h, c0909w.f3094a.f3066l);
        jSONObject.put("vertical_type", c0909w.f3094a.f3067m);
        jSONObject.put(C4209a.f14202e, c0909w.f3094a.f3073s);
        jSONObject.put("cpu", c0909w.f3094a.f3074t);
        jSONObject.put(Constants.KEY_OS_VERSION, c0909w.f3094a.f3075u);
        jSONObject.put("os_version", c0909w.f3094a.f3076v);
        jSONObject.put("resolution", c0909w.f3094a.f3077w);
        jSONObject.put("mc", c0909w.f3094a.f3078x);
        jSONObject.put("device_id", c0909w.f3094a.f3079y);
        jSONObject.put("device_model", c0909w.f3094a.f3080z);
        jSONObject.put("device_board", c0909w.f3094a.f3035A);
        jSONObject.put("device_brand", c0909w.f3094a.f3036B);
        jSONObject.put("device_manutime", c0909w.f3094a.f3037C);
        jSONObject.put("device_manufacturer", c0909w.f3094a.f3038D);
        jSONObject.put("device_manuid", c0909w.f3094a.f3039E);
        jSONObject.put("device_name", c0909w.f3094a.f3040F);
        if (c0909w.f3094a.f3041G != null) {
            jSONObject.put("sub_os_name", c0909w.f3094a.f3041G);
        }
        if (c0909w.f3094a.f3042H != null) {
            jSONObject.put("sub_os_version", c0909w.f3094a.f3042H);
        }
        jSONObject.put("timezone", c0909w.f3094a.f3043I);
        jSONObject.put(ModelFields.LANGUAGE, c0909w.f3094a.f3044J);
        jSONObject.put("country", c0909w.f3094a.f3045K);
        jSONObject.put("carrier", c0909w.f3094a.f3046L);
        jSONObject.put("access", c0909w.f3094a.f3047M);
        jSONObject.put("access_subtype", c0909w.f3094a.f3048N);
        jSONObject.put("mccmnc", c0909w.f3094a.f3049O == null ? BuildConfig.FLAVOR : c0909w.f3094a.f3049O);
        jSONObject.put("successful_requests", c0909w.f3094a.f3050P);
        jSONObject.put("failed_requests", c0909w.f3094a.f3051Q);
        jSONObject.put("req_time", c0909w.f3094a.f3052R);
        jSONObject.put("imprint", c0909w.f3094a.f3053S);
        jSONObject.put("id_tracking", c0909w.f3094a.f3054T);
        jSONObject2.put(C4209a.f14205h, c0909w.f3094a.f3066l).put("device_id", c0909w.f3094a.f3079y).put("device_model", c0909w.f3094a.f3080z).put(Constants.SP_KEY_VERSION, c0909w.f3094a.f3076v).put(C4209a.f14204g, c0909w.f3094a.f3055a).put(C4209a.f14201d, c0909w.f3094a.f3056b);
    }

    private static boolean m3427a(File file) {
        long length = file.length();
        if (!file.exists() || length <= f2720f) {
            return false;
        }
        ci.m3705a(f2717b).m3731a(length, System.currentTimeMillis(), C4156a.f13957s);
        return true;
    }

    private void m3429b(C0909w c0909w, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        List list;
        JSONArray jSONArray;
        int i;
        JSONArray jSONArray2;
        int i2;
        C0900g c0900g;
        int i3;
        JSONArray jSONArray3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6 = new JSONObject();
        if (!(c0909w.f3095b.f3032h == null || c0909w.f3095b.f3032h.f2993a == null || c0909w.f3095b.f3032h.f2993a.size() <= 0)) {
            jSONObject3 = new JSONObject();
            for (Entry entry : c0909w.f3095b.f3032h.f2993a.entrySet()) {
                String str = (String) entry.getKey();
                list = (List) entry.getValue();
                jSONArray = new JSONArray();
                for (i = 0; i < list.size(); i++) {
                    C0897d c0897d = (C0897d) list.get(i);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("v_sum", c0897d.f2995a);
                    jSONObject7.put("ts_sum", c0897d.f2996b);
                    jSONObject7.put("tw_num", c0897d.f2997c);
                    jSONObject7.put("count", c0897d.f2998d);
                    jSONObject7.put("labels", new JSONArray(c0897d.f2999e));
                    jSONArray.put(jSONObject7);
                }
                jSONObject3.put(str, jSONArray);
            }
            jSONObject6.put("ag", jSONObject3);
        }
        if (!(c0909w.f3095b.f3032h == null || c0909w.f3095b.f3032h.f2994b == null || c0909w.f3095b.f3032h.f2994b.size() <= 0)) {
            jSONObject3 = new JSONObject();
            for (Entry entry2 : c0909w.f3095b.f3032h.f2994b.entrySet()) {
                str = (String) entry2.getKey();
                list = (List) entry2.getValue();
                jSONArray = new JSONArray();
                for (i = 0; i < list.size(); i++) {
                    C0898e c0898e = (C0898e) list.get(i);
                    jSONObject7 = new JSONObject();
                    jSONObject7.put("value", c0898e.f3000a);
                    jSONObject7.put(MsgConstant.KEY_TS, c0898e.f3001b);
                    jSONObject7.put("label", c0898e.f3002c);
                    jSONArray.put(jSONObject7);
                }
                jSONObject3.put(str, jSONArray);
            }
            jSONObject6.put("ve_meta", jSONObject3);
        }
        if (jSONObject6 != null && jSONObject6.length() > 0) {
            jSONObject.put("cc", jSONObject6);
            jSONObject2.put("Categorical Counter", jSONObject6);
        }
        if (c0909w.f3095b.f3025a != null && c0909w.f3095b.f3025a.size() > 0) {
            jSONArray2 = new JSONArray();
            for (i2 = 0; i2 < c0909w.f3095b.f3025a.size(); i2++) {
                c0900g = (C0900g) c0909w.f3095b.f3025a.get(i2);
                jSONArray = new JSONArray();
                for (int i4 = 0; i4 < c0900g.f3007b.size(); i4++) {
                    jSONObject7 = new JSONObject();
                    C0902i c0902i = (C0902i) c0900g.f3007b.get(i4);
                    jSONObject7.put(AgooConstants.MESSAGE_ID, c0902i.f3013c);
                    jSONObject7.put(MsgConstant.KEY_TS, c0902i.f3014d);
                    jSONObject7.put("du", c0902i.f3015e);
                    for (Entry entry3 : c0902i.f3017g.entrySet()) {
                        Object value = entry3.getValue();
                        if (value instanceof Map) {
                            JSONObject jSONObject8 = new JSONObject();
                            for (Entry entry4 : ((Map) value).entrySet()) {
                                jSONObject8.put((String) entry4.getKey(), entry4.getValue());
                            }
                            jSONObject7.put((String) entry3.getKey(), jSONObject8);
                        } else if (value instanceof List) {
                            ArrayList arrayList = (ArrayList) value;
                            JSONArray jSONArray4 = new JSONArray();
                            for (i3 = 0; i3 < arrayList.size(); i3++) {
                                jSONArray4.put(arrayList.get(i3));
                            }
                            jSONObject7.put((String) entry3.getKey(), jSONArray4);
                        } else {
                            jSONObject7.put((String) entry3.getKey(), entry3.getValue());
                        }
                    }
                    jSONArray.put(jSONObject7);
                }
                if (!(c0900g.f3006a == null || jSONArray == null || jSONArray.length() <= 0)) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put(c0900g.f3006a, jSONArray);
                    jSONArray2.put(jSONObject9);
                }
            }
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jSONObject.put("ekv", jSONArray2);
                jSONObject2.put(ModelFields.EVENT, jSONArray2);
            }
        }
        if (c0909w.f3095b.f3026b != null && c0909w.f3095b.f3026b.size() > 0) {
            jSONArray3 = new JSONArray();
            for (i = 0; i < c0909w.f3095b.f3026b.size(); i++) {
                c0900g = (C0900g) c0909w.f3095b.f3026b.get(i);
                jSONArray2 = new JSONArray();
                for (i2 = 0; i2 < c0900g.f3007b.size(); i2++) {
                    c0902i = (C0902i) c0900g.f3007b.get(i2);
                    jSONObject4 = new JSONObject();
                    jSONObject4.put(AgooConstants.MESSAGE_ID, c0902i.f3013c);
                    jSONObject4.put(MsgConstant.KEY_TS, c0902i.f3014d);
                    jSONObject4.put("du", c0902i.f3015e);
                    for (Entry entry5 : c0902i.f3017g.entrySet()) {
                        Object value2 = entry5.getValue();
                        if ((value2 instanceof String) || (value2 instanceof Integer) || (value2 instanceof Long)) {
                            jSONObject4.put((String) entry5.getKey(), entry5.getValue());
                        }
                    }
                    jSONArray2.put(jSONObject4);
                }
                if (!(c0900g.f3006a == null || jSONArray2 == null || jSONArray2.length() <= 0)) {
                    jSONObject9 = new JSONObject();
                    jSONObject9.put(c0900g.f3006a, jSONArray2);
                    jSONArray3.put(jSONObject9);
                }
            }
            if (jSONArray3 != null && jSONArray3.length() > 0) {
                jSONObject.put("gkv", jSONArray3);
                jSONObject2.put("game event", jSONArray3);
            }
        }
        if (c0909w.f3095b.f3033i != null && c0909w.f3095b.f3033i.size() > 0) {
            JSONArray jSONArray5 = new JSONArray();
            for (int i5 = 0; i5 < c0909w.f3095b.f3033i.size(); i5++) {
                C0901h c0901h = (C0901h) c0909w.f3095b.f3033i.get(i5);
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put(MsgConstant.KEY_TS, c0901h.f3008a);
                jSONObject10.put("error_source", c0901h.f3009b);
                jSONObject10.put("context", c0901h.f3010c);
                jSONArray5.put(jSONObject10);
            }
            jSONObject.put(C4233j.f14375B, jSONArray5);
        }
        if (c0909w.f3095b.f3027c != null && c0909w.f3095b.f3027c.size() > 0) {
            JSONArray jSONArray6 = new JSONArray();
            for (i3 = 0; i3 < c0909w.f3095b.f3027c.size(); i3++) {
                C0907n c0907n = (C0907n) c0909w.f3095b.f3027c.get(i3);
                jSONObject6 = new JSONObject();
                jSONObject6.put(AgooConstants.MESSAGE_ID, c0907n.f3082b);
                jSONObject6.put("start_time", c0907n.f3083c);
                jSONObject6.put("end_time", c0907n.f3084d);
                jSONObject6.put("duration", c0907n.f3085e);
                if (!(c0907n.f3089i.f3091a == 0 && c0907n.f3089i.f3092b == 0)) {
                    jSONObject9 = new JSONObject();
                    jSONObject9.put("download_traffic", c0907n.f3089i.f3091a);
                    jSONObject9.put("upload_traffic", c0907n.f3089i.f3092b);
                    jSONObject6.put("traffic", jSONObject9);
                }
                if (c0907n.f3087g.size() > 0) {
                    jSONArray3 = new JSONArray();
                    for (C0904k c0904k : c0907n.f3087g) {
                        jSONObject4 = new JSONObject();
                        jSONObject4.put("page_name", c0904k.f3021a);
                        jSONObject4.put("duration", c0904k.f3022b);
                        jSONArray3.put(jSONObject4);
                    }
                    jSONObject6.put("pages", jSONArray3);
                }
                if (c0907n.f3088h.size() > 0) {
                    jSONArray3 = new JSONArray();
                    for (C0904k c0904k2 : c0907n.f3088h) {
                        jSONObject4 = new JSONObject();
                        jSONObject4.put("page_name", c0904k2.f3021a);
                        jSONObject4.put("duration", c0904k2.f3022b);
                        jSONArray3.put(jSONObject4);
                    }
                    jSONObject6.put("autopages", jSONArray3);
                }
                if (c0907n.f3090j.f3020c != 0) {
                    JSONArray jSONArray7 = new JSONArray();
                    jSONObject3 = new JSONObject();
                    jSONObject3.put(C0714a.LATITUDE, c0907n.f3090j.f3018a);
                    jSONObject3.put(C0714a.OTHER, c0907n.f3090j.f3019b);
                    jSONObject3.put(MsgConstant.KEY_TS, c0907n.f3090j.f3020c);
                    jSONArray7.put(jSONObject3);
                    jSONObject6.put("locations", jSONArray7);
                }
                jSONArray6.put(jSONObject6);
            }
            if (jSONArray6 != null && jSONArray6.length() > 0) {
                jSONObject.put("sessions", jSONArray6);
                jSONObject2.put("session", jSONArray6);
            }
        }
        if (c0909w.f3095b.f3028d.f2990a != 0) {
            jSONObject5 = new JSONObject();
            jSONObject5.put(MsgConstant.KEY_TS, c0909w.f3095b.f3028d.f2990a);
            if (jSONObject5.length() > 0) {
                jSONObject.put("activate_msg", jSONObject5);
                jSONObject2.put("active_msg", c0909w.f3095b.f3028d.f2990a);
            }
        }
        if (c0909w.f3095b.f3029e.f3005c) {
            jSONObject5 = new JSONObject();
            jSONObject9 = new JSONObject();
            jSONObject9.put(MsgConstant.KEY_LOCATION_INTERVAL, c0909w.f3095b.f3029e.f3004b);
            jSONObject9.put("latency", c0909w.f3095b.f3029e.f3003a);
            jSONObject5.put("latent", jSONObject9);
            if (jSONObject5.length() > 0) {
                jSONObject.put("control_policy", jSONObject5);
            }
        }
        if (c0909w.f3095b.f3030f.size() > 0) {
            JSONObject jSONObject11 = new JSONObject();
            for (Entry entry22 : c0909w.f3095b.f3030f.entrySet()) {
                jSONObject11.put((String) entry22.getKey(), entry22.getValue());
            }
            jSONObject.put("group_info", jSONObject11);
        }
        if (!(c0909w.f3095b.f3031g.f2991a == null && c0909w.f3095b.f3031g.f2992b == null)) {
            jSONObject5 = new JSONObject();
            jSONObject5.put("provider", c0909w.f3095b.f3031g.f2991a);
            jSONObject5.put("puid", c0909w.f3095b.f3031g.f2992b);
            if (jSONObject5.length() > 0) {
                jSONObject.put("active_user", jSONObject5);
                jSONObject2.put("active_user", jSONObject5);
            }
        }
        if (c0909w.f3095b.f3034j != null) {
            jSONObject.put(C4156a.f13938A, c0909w.f3095b.f3034j);
        }
    }

    private SharedPreferences m3431k() {
        return f2717b.getSharedPreferences("mobclick_agent_user_" + f2718c, 0);
    }

    private String m3432l() {
        return "mobclick_agent_header_" + f2718c;
    }

    private String m3433m() {
        SharedPreferences a = C0888r.m3932a(f2717b);
        if (a == null) {
            return "mobclick_agent_cached_" + f2718c + am.m3332a(f2717b);
        }
        int i = a.getInt(C4156a.f13963y, 0);
        return (i == 0 || Integer.parseInt(am.m3332a(f2717b)) == i) ? "mobclick_agent_cached_" + f2718c + am.m3332a(f2717b) : "mobclick_agent_cached_" + f2718c + i;
    }

    public void m3434a(int i) {
        SharedPreferences a = C0888r.m3932a(f2717b);
        if (a != null) {
            a.edit().putInt("vt", i).commit();
        }
    }

    public void m3435a(C0909w c0909w) {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(new File(f2717b.getApplicationContext().getFilesDir().getAbsolutePath(), m3433m()));
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream2);
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
                fileOutputStream = fileOutputStream2;
                try {
                    ap.m3385a(e);
                    e.printStackTrace();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    fileOutputStream2 = fileOutputStream;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e42) {
                            e42.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e;
            }
            try {
                objectOutputStream.writeObject(c0909w);
                objectOutputStream.flush();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e322) {
                        e322.printStackTrace();
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3222) {
                        e3222.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = fileOutputStream2;
                ap.m3385a(e);
                e.printStackTrace();
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            objectOutputStream = null;
            ap.m3385a(e);
            e.printStackTrace();
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            objectOutputStream = null;
            fileOutputStream2 = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw e;
        }
    }

    public void m3436a(String str) {
        SharedPreferences a = C0888r.m3932a(f2717b);
        if (a != null) {
            a.edit().putString(C4209a.f14204g, str).commit();
        }
    }

    public void m3437a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Editor edit = m3431k().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    public void m3438a(byte[] bArr) {
        this.f2721d.m3419a(bArr);
    }

    public String[] m3439a() {
        SharedPreferences k = m3431k();
        String string = k.getString("au_p", null);
        String string2 = k.getString("au_u", null);
        if (string == null || string2 == null) {
            return null;
        }
        return new String[]{string, string2};
    }

    public void m3440b() {
        m3431k().edit().remove("au_p").remove("au_u").commit();
    }

    public void m3441b(String str) {
        SharedPreferences a = C0888r.m3932a(f2717b);
        if (a != null) {
            a.edit().putString("st", str).commit();
        }
    }

    public byte[] m3442b(C0909w c0909w) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(MsgConstant.KEY_HEADER, new C08312(this, c0909w, jSONObject2));
            JSONObject c08323 = new C08323(this, c0909w, jSONObject2);
            if (c08323.length() > 0) {
                jSONObject.put(C4156a.f13961w, c08323);
            }
            ap.m3381a("serialize entry:" + String.valueOf(jSONObject2));
            return String.valueOf(jSONObject).getBytes();
        } catch (Throwable e) {
            ap.m3383a("Fail to serialize log ...", e);
            return null;
        }
    }

    public String m3443c() {
        SharedPreferences a = C0888r.m3932a(f2717b);
        return a != null ? a.getString(C4209a.f14204g, null) : null;
    }

    public String m3444d() {
        SharedPreferences a = C0888r.m3932a(f2717b);
        return a != null ? a.getString("st", null) : null;
    }

    public int m3445e() {
        SharedPreferences a = C0888r.m3932a(f2717b);
        return a != null ? a.getInt("vt", 0) : 0;
    }

    public C0909w m3446f() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Exception e;
        C0909w c0909w;
        Throwable th;
        Throwable e2;
        try {
            File file = new File(f2717b.getApplicationContext().getFilesDir().getAbsolutePath(), m3433m());
            if (at.m3427a(file)) {
                file.delete();
                return null;
            } else if (!file.exists()) {
                return null;
            } else {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                    } catch (Exception e3) {
                        e = e3;
                        objectInputStream = null;
                        try {
                            e.printStackTrace();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    c0909w = null;
                                } catch (IOException e42) {
                                    e42.printStackTrace();
                                    c0909w = null;
                                }
                            } else {
                                c0909w = null;
                            }
                            return c0909w;
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e52) {
                                    e52.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectInputStream = null;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    try {
                        c0909w = (C0909w) objectInputStream.readObject();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e6) {
                                try {
                                    e6.printStackTrace();
                                } catch (Exception e7) {
                                    e2 = e7;
                                    if (ap.f2680a) {
                                        ap.m3385a(e2);
                                    }
                                    return c0909w;
                                }
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e62) {
                                e62.printStackTrace();
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            c0909w = null;
                        } else {
                            fileInputStream.close();
                            c0909w = null;
                        }
                        return c0909w;
                    }
                } catch (Exception e9) {
                    e = e9;
                    objectInputStream = null;
                    fileInputStream = null;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        c0909w = null;
                    } else {
                        c0909w = null;
                    }
                    return c0909w;
                } catch (Throwable th4) {
                    th = th4;
                    objectInputStream = null;
                    fileInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
                return c0909w;
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            c0909w = null;
            e2 = th6;
            if (ap.f2680a) {
                ap.m3385a(e2);
            }
            return c0909w;
        }
    }

    public void m3447g() {
        f2717b.deleteFile(m3432l());
        f2717b.deleteFile(m3433m());
        ci.m3705a(f2717b).m3739d(new C08301(this));
    }

    public boolean m3448h() {
        return this.f2721d.m3420a();
    }

    public C0835a m3449i() {
        return this.f2721d;
    }
}
