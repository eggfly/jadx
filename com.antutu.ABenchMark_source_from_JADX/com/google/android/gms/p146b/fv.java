package com.google.android.gms.p146b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.C2900q;
import com.google.android.gms.ads.internal.formats.C2799a;
import com.google.android.gms.ads.internal.formats.C2802c;
import com.google.android.gms.ads.internal.formats.C2809f;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.ads.internal.formats.C2811i;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.ho.C3214a;
import com.google.android.gms.p146b.hy.C3212a;
import com.google.android.gms.p151a.C2690b;
import com.umeng.message.MsgConstant;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.fv */
public class fv implements Callable<gx> {
    private static final long f10988a;
    private final Context f10989b;
    private final ho f10990c;
    private final C2900q f10991d;
    private final C3326k f10992e;
    private final db f10993f;
    private final Object f10994g;
    private final C3232a f10995h;
    private boolean f10996i;
    private int f10997j;
    private List<String> f10998k;
    private JSONObject f10999l;

    /* renamed from: com.google.android.gms.b.fv.1 */
    class C32091 implements cb {
        final /* synthetic */ da f10966a;
        final /* synthetic */ C3217b f10967b;
        final /* synthetic */ hw f10968c;
        final /* synthetic */ fv f10969d;

        C32091(fv fvVar, da daVar, C3217b c3217b, hw hwVar) {
            this.f10969d = fvVar;
            this.f10966a = daVar;
            this.f10967b = c3217b;
            this.f10968c = hwVar;
        }

        public void m12759a(ii iiVar, Map<String, String> map) {
            this.f10966a.m12205b("/nativeAdPreProcess", this.f10967b.f10986a);
            try {
                String str = (String) map.get(MsgConstant.KEY_SUCCESS);
                if (!TextUtils.isEmpty(str)) {
                    this.f10968c.m12217b(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                    return;
                }
            } catch (Throwable e) {
                C2972b.m11580b("Malformed native JSON response.", e);
            }
            this.f10969d.m12789a(0);
            C3512u.m14585a(this.f10969d.m12792b(), (Object) "Unable to set the ad state error!");
            this.f10968c.m12217b(null);
        }
    }

    /* renamed from: com.google.android.gms.b.fv.2 */
    class C32102 implements Runnable {
        final /* synthetic */ hw f10970a;
        final /* synthetic */ String f10971b;
        final /* synthetic */ fv f10972c;

        C32102(fv fvVar, hw hwVar, String str) {
            this.f10972c = fvVar;
            this.f10970a = hwVar;
            this.f10971b = str;
        }

        public void run() {
            this.f10970a.m12217b(this.f10972c.f10991d.m11287z().get(this.f10971b));
        }
    }

    /* renamed from: com.google.android.gms.b.fv.3 */
    class C32113 implements cb {
        final /* synthetic */ C2809f f10973a;
        final /* synthetic */ fv f10974b;

        C32113(fv fvVar, C2809f c2809f) {
            this.f10974b = fvVar;
            this.f10973a = c2809f;
        }

        public void m12760a(ii iiVar, Map<String, String> map) {
            this.f10974b.m12779a(this.f10973a, (String) map.get("asset"));
        }
    }

    /* renamed from: com.google.android.gms.b.fv.4 */
    class C32134 implements C3212a<List<C2802c>, C2799a> {
        final /* synthetic */ String f10975a;
        final /* synthetic */ Integer f10976b;
        final /* synthetic */ Integer f10977c;
        final /* synthetic */ int f10978d;
        final /* synthetic */ int f10979e;
        final /* synthetic */ int f10980f;
        final /* synthetic */ fv f10981g;

        C32134(fv fvVar, String str, Integer num, Integer num2, int i, int i2, int i3) {
            this.f10981g = fvVar;
            this.f10975a = str;
            this.f10976b = num;
            this.f10977c = num2;
            this.f10978d = i;
            this.f10979e = i2;
            this.f10980f = i3;
        }

        public C2799a m12762a(List<C2802c> list) {
            C2799a c2799a;
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        c2799a = new C2799a(this.f10975a, fv.m12781b((List) list), this.f10976b, this.f10977c, this.f10978d > 0 ? Integer.valueOf(this.f10978d) : null, this.f10979e + this.f10980f);
                        return c2799a;
                    }
                } catch (Throwable e) {
                    C2972b.m11580b("Could not get attribution icon", e);
                    return null;
                }
            }
            c2799a = null;
            return c2799a;
        }

        public /* synthetic */ Object m12763a(Object obj) {
            return m12762a((List) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.fv.5 */
    class C32155 implements C3214a<C2802c> {
        final /* synthetic */ boolean f10982a;
        final /* synthetic */ double f10983b;
        final /* synthetic */ String f10984c;
        final /* synthetic */ fv f10985d;

        C32155(fv fvVar, boolean z, double d, String str) {
            this.f10985d = fvVar;
            this.f10982a = z;
            this.f10983b = d;
            this.f10984c = str;
        }

        public C2802c m12766a() {
            this.f10985d.m12790a(2, this.f10982a);
            return null;
        }

        public C2802c m12767a(InputStream inputStream) {
            byte[] a;
            try {
                a = jm.m13562a(inputStream);
            } catch (IOException e) {
                a = null;
            }
            if (a == null) {
                this.f10985d.m12790a(2, this.f10982a);
                return null;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a, 0, a.length);
            if (decodeByteArray == null) {
                this.f10985d.m12790a(2, this.f10982a);
                return null;
            }
            decodeByteArray.setDensity((int) (160.0d * this.f10983b));
            return new C2802c(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(this.f10984c), this.f10983b);
        }

        public /* synthetic */ Object m12768b() {
            return m12766a();
        }

        public /* synthetic */ Object m12769b(InputStream inputStream) {
            return m12767a(inputStream);
        }
    }

    /* renamed from: com.google.android.gms.b.fv.a */
    public interface C3216a<T extends C2804a> {
        T m12770a(fv fvVar, JSONObject jSONObject);
    }

    /* renamed from: com.google.android.gms.b.fv.b */
    class C3217b {
        public cb f10986a;
        final /* synthetic */ fv f10987b;

        C3217b(fv fvVar) {
            this.f10987b = fvVar;
        }
    }

    static {
        f10988a = TimeUnit.SECONDS.toMillis(60);
    }

    public fv(Context context, C2900q c2900q, db dbVar, ho hoVar, C3326k c3326k, C3232a c3232a) {
        this.f10994g = new Object();
        this.f10989b = context;
        this.f10991d = c2900q;
        this.f10990c = hoVar;
        this.f10993f = dbVar;
        this.f10995h = c3232a;
        this.f10992e = c3326k;
        this.f10996i = false;
        this.f10997j = -2;
        this.f10998k = null;
    }

    private C2804a m12771a(da daVar, C3216a c3216a, JSONObject jSONObject) {
        if (m12792b()) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] b = m12782b(jSONObject2, "impression_tracking_urls");
        this.f10998k = b == null ? null : Arrays.asList(b);
        this.f10999l = jSONObject2.optJSONObject("active_view");
        C2804a a = c3216a.m12770a(this, jSONObject);
        if (a == null) {
            C2972b.m11579b("Failed to retrieve ad assets.");
            return null;
        }
        a.m10804a(new C2811i(this.f10989b, this.f10991d, daVar, this.f10992e, jSONObject, a, this.f10995h.f11166a.f9861k));
        return a;
    }

    private gx m12773a(C2804a c2804a) {
        int i;
        synchronized (this.f10994g) {
            i = this.f10997j;
            if (c2804a == null && this.f10997j == -2) {
                i = 0;
            }
        }
        return new gx(this.f10995h.f11166a.f9853c, null, this.f10995h.f11167b.f9888d, i, this.f10995h.f11167b.f9890f, this.f10998k, this.f10995h.f11167b.f9896l, this.f10995h.f11167b.f9895k, this.f10995h.f11166a.f9859i, false, null, null, null, null, null, 0, this.f10995h.f11169d, this.f10995h.f11167b.f9891g, this.f10995h.f11171f, this.f10995h.f11172g, this.f10995h.f11167b.f9899o, this.f10999l, i != -2 ? null : c2804a, null, null, null, this.f10995h.f11167b.f9883G);
    }

    private hz<C2802c> m12774a(JSONObject jSONObject, boolean z, boolean z2) {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new hx(new C2802c(null, Uri.parse(string), optDouble)) : this.f10990c.m13149a(string, new C32155(this, z, optDouble, string));
        } else {
            m12790a(0, z);
            return new hx(null);
        }
    }

    private Integer m12775a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt(IXAdRequestInfo.GPS), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject m12777a(da daVar) {
        if (m12792b()) {
            return null;
        }
        hw hwVar = new hw();
        C3217b c3217b = new C3217b(this);
        cb c32091 = new C32091(this, daVar, c3217b, hwVar);
        c3217b.f10986a = c32091;
        daVar.m12202a("/nativeAdPreProcess", c32091);
        daVar.m12204a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.f10995h.f11167b.f9887c));
        return (JSONObject) hwVar.get(f10988a, TimeUnit.MILLISECONDS);
    }

    private void m12778a(C2804a c2804a, da daVar) {
        if (c2804a instanceof C2809f) {
            C2809f c2809f = (C2809f) c2804a;
            C3217b c3217b = new C3217b(this);
            cb c32113 = new C32113(this, c2809f);
            c3217b.f10986a = c32113;
            daVar.m12202a("/nativeAdCustomClick", c32113);
        }
    }

    private void m12779a(bn bnVar, String str) {
        try {
            bq c = this.f10991d.m11283c(bnVar.m10851k());
            if (c != null) {
                c.m11946a(bnVar, str);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private static List<Drawable> m12781b(List<C2802c> list) {
        List<Drawable> arrayList = new ArrayList();
        for (C2802c a : list) {
            arrayList.add((Drawable) C2690b.m10263a(a.m10789a()));
        }
        return arrayList;
    }

    private String[] m12782b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private da m12783c() {
        if (m12792b()) {
            return null;
        }
        da daVar = (da) this.f10993f.m12221a(this.f10989b, this.f10995h.f11166a.f9861k, (this.f10995h.f11167b.f9886b.indexOf(HttpConstant.HTTPS) == 0 ? "https:" : "http:") + ((String) aq.ac.m11794c()), this.f10992e).get(f10988a, TimeUnit.MILLISECONDS);
        daVar.m12208a(this.f10991d, this.f10991d, this.f10991d, this.f10991d, false, null, null, null, null);
        return daVar;
    }

    protected C3216a m12784a(JSONObject jSONObject) {
        if (m12792b()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.f10995h.f11166a.f9876z != null ? this.f10995h.f11166a.f9876z.f9486b : false;
        boolean z2 = this.f10995h.f11166a.f9876z != null ? this.f10995h.f11166a.f9876z.f9488d : false;
        if (MessageService.MSG_DB_NOTIFY_CLICK.equals(string)) {
            return new fw(z, z2);
        }
        if (MessageService.MSG_DB_NOTIFY_REACHED.equals(string)) {
            return new fx(z, z2);
        }
        if (MessageService.MSG_DB_NOTIFY_DISMISS.equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            hw hwVar = new hw();
            hj.f11297a.post(new C32102(this, hwVar, string2));
            if (hwVar.get(f10988a, TimeUnit.MILLISECONDS) != null) {
                return new fy(z);
            }
            C2972b.m11579b("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            m12789a(0);
        }
        return null;
    }

    public gx m12785a() {
        try {
            da c = m12783c();
            JSONObject a = m12777a(c);
            C2804a a2 = m12771a(c, m12784a(a), a);
            m12778a(a2, c);
            return m12773a(a2);
        } catch (CancellationException e) {
            if (!this.f10996i) {
                m12789a(0);
            }
            return m12773a(null);
        } catch (ExecutionException e2) {
            if (this.f10996i) {
                m12789a(0);
            }
            return m12773a(null);
        } catch (InterruptedException e3) {
            if (this.f10996i) {
                m12789a(0);
            }
            return m12773a(null);
        } catch (Throwable e4) {
            C2972b.m11584d("Malformed native JSON response.", e4);
            if (this.f10996i) {
                m12789a(0);
            }
            return m12773a(null);
        } catch (Throwable e42) {
            C2972b.m11584d("Timeout when loading native ad.", e42);
            if (this.f10996i) {
                m12789a(0);
            }
            return m12773a(null);
        }
    }

    public hz<C2802c> m12786a(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m12774a(jSONObject2, z, z2);
    }

    public List<hz<C2802c>> m12787a(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<hz<C2802c>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            m12790a(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(m12774a(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<C2802c> m12788a(JSONObject jSONObject, String str, boolean z) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m12774a(jSONObject2, optBoolean, z);
    }

    public void m12789a(int i) {
        synchronized (this.f10994g) {
            this.f10996i = true;
            this.f10997j = i;
        }
    }

    public void m12790a(int i, boolean z) {
        if (z) {
            m12789a(i);
        }
    }

    public hz<C2799a> m12791b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new hx(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer a = m12775a(optJSONObject, "text_color");
        Integer a2 = m12775a(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", AdError.NETWORK_ERROR_CODE);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = m12787a(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(m12786a(optJSONObject, "image", false, false));
        }
        return hy.m13169a(hy.m13170a(arrayList), new C32134(this, optString, a2, a, optInt, optInt3, optInt2));
    }

    public boolean m12792b() {
        boolean z;
        synchronized (this.f10994g) {
            z = this.f10996i;
        }
        return z;
    }

    public /* synthetic */ Object call() {
        return m12785a();
    }
}
