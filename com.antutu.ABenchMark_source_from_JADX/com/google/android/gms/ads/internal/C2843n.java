package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.C2826g.C2825a;
import com.google.android.gms.ads.internal.formats.C2805d;
import com.google.android.gms.ads.internal.formats.C2807e;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bf;
import com.google.android.gms.p146b.bf.C2801a;
import com.google.android.gms.p146b.cb;
import com.google.android.gms.p146b.dp;
import com.google.android.gms.p146b.dz;
import com.google.android.gms.p146b.ea;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p146b.ij.C2813a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import com.igexin.download.Downloads;
import com.umeng.analytics.C4156a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.ads.internal.n */
public class C2843n {

    /* renamed from: com.google.android.gms.ads.internal.n.1 */
    static class C28381 implements C2813a {
        final /* synthetic */ C2805d f9620a;
        final /* synthetic */ String f9621b;
        final /* synthetic */ ii f9622c;

        C28381(C2805d c2805d, String str, ii iiVar) {
            this.f9620a = c2805d;
            this.f9621b = str;
            this.f9622c = iiVar;
        }

        public void m11003a(ii iiVar, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f9620a.m10808a());
                jSONObject.put(C4156a.f13961w, this.f9620a.m10811c());
                jSONObject.put("call_to_action", this.f9620a.m10813e());
                jSONObject.put("price", this.f9620a.m10816h());
                jSONObject.put("star_rating", String.valueOf(this.f9620a.m10814f()));
                jSONObject.put("store", this.f9620a.m10815g());
                jSONObject.put("icon", C2843n.m11015a(this.f9620a.m10812d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f9620a.m10810b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(C2843n.m11015a(C2843n.m11023b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put(Downloads.COLUMN_EXTRAS, C2843n.m11026b(this.f9620a.m10821m(), this.f9621b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", MessageService.MSG_DB_NOTIFY_CLICK);
                this.f9622c.m13231a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                C2972b.m11584d("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.n.2 */
    static class C28392 implements C2813a {
        final /* synthetic */ C2807e f9623a;
        final /* synthetic */ String f9624b;
        final /* synthetic */ ii f9625c;

        C28392(C2807e c2807e, String str, ii iiVar) {
            this.f9623a = c2807e;
            this.f9624b = str;
            this.f9625c = iiVar;
        }

        public void m11004a(ii iiVar, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f9623a.m10833a());
                jSONObject.put(C4156a.f13961w, this.f9623a.m10836c());
                jSONObject.put("call_to_action", this.f9623a.m10838e());
                jSONObject.put("advertiser", this.f9623a.m10839f());
                jSONObject.put("logo", C2843n.m11015a(this.f9623a.m10837d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f9623a.m10835b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(C2843n.m11015a(C2843n.m11023b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put(Downloads.COLUMN_EXTRAS, C2843n.m11026b(this.f9623a.m10841h(), this.f9624b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", MessageService.MSG_DB_NOTIFY_REACHED);
                this.f9625c.m13231a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                C2972b.m11584d("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.n.3 */
    static class C28403 implements cb {
        final /* synthetic */ CountDownLatch f9626a;

        C28403(CountDownLatch countDownLatch) {
            this.f9626a = countDownLatch;
        }

        public void m11005a(ii iiVar, Map<String, String> map) {
            this.f9626a.countDown();
            View b = iiVar.m13233b();
            if (b != null) {
                b.setVisibility(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.n.4 */
    static class C28414 implements cb {
        final /* synthetic */ CountDownLatch f9627a;

        C28414(CountDownLatch countDownLatch) {
            this.f9627a = countDownLatch;
        }

        public void m11006a(ii iiVar, Map<String, String> map) {
            C2972b.m11583d("Adapter returned an ad, but assets substitution failed");
            this.f9627a.countDown();
            iiVar.destroy();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.n.5 */
    static class C28425 implements cb {
        final /* synthetic */ dz f9628a;
        final /* synthetic */ C2825a f9629b;
        final /* synthetic */ ea f9630c;

        C28425(dz dzVar, C2825a c2825a, ea eaVar) {
            this.f9628a = dzVar;
            this.f9629b = c2825a;
            this.f9630c = eaVar;
        }

        public void m11007a(ii iiVar, Map<String, String> map) {
            Object b = iiVar.m13233b();
            if (b != null) {
                try {
                    if (this.f9628a != null) {
                        if (this.f9628a.m12429k()) {
                            C2843n.m11027b(iiVar);
                            return;
                        }
                        this.f9628a.m12418a(C2690b.m10262a(b));
                        this.f9629b.m10919a();
                    } else if (this.f9630c == null) {
                    } else {
                        if (this.f9630c.m12460i()) {
                            C2843n.m11027b(iiVar);
                            return;
                        }
                        this.f9630c.m12451a(C2690b.m10262a(b));
                        this.f9629b.m10919a();
                    }
                } catch (Throwable e) {
                    C2972b.m11584d("Unable to call handleClick on mapper", e);
                }
            }
        }
    }

    public static View m11008a(gx gxVar) {
        if (gxVar == null) {
            C2972b.m11579b("AdState is null");
            return null;
        } else if (C2843n.m11028b(gxVar)) {
            return gxVar.f11179b.m13233b();
        } else {
            try {
                C2687a a = gxVar.f11192o.m12367a();
                if (a != null) {
                    return (View) C2690b.m10263a(a);
                }
                C2972b.m11583d("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                C2972b.m11584d("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    private static C2805d m11009a(dz dzVar) {
        return new C2805d(dzVar.m12417a(), dzVar.m12419b(), dzVar.m12421c(), dzVar.m12422d(), dzVar.m12423e(), dzVar.m12424f(), dzVar.m12425g(), dzVar.m12426h(), null, dzVar.m12430l());
    }

    private static C2807e m11010a(ea eaVar) {
        return new C2807e(eaVar.m12450a(), eaVar.m12452b(), eaVar.m12454c(), eaVar.m12455d(), eaVar.m12456e(), eaVar.m12457f(), null, eaVar.m12461j());
    }

    static cb m11012a(dz dzVar, ea eaVar, C2825a c2825a) {
        return new C28425(dzVar, c2825a, eaVar);
    }

    static cb m11013a(CountDownLatch countDownLatch) {
        return new C28403(countDownLatch);
    }

    private static String m11014a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            C2972b.m11583d("Bitmap is null. Returning empty string");
            return BuildConfig.FLAVOR;
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    static String m11015a(bf bfVar) {
        if (bfVar == null) {
            C2972b.m11583d("Image is null. Returning empty string");
            return BuildConfig.FLAVOR;
        }
        try {
            Uri b = bfVar.m10786b();
            if (b != null) {
                return b.toString();
            }
        } catch (RemoteException e) {
            C2972b.m11583d("Unable to get image uri. Trying data uri next");
        }
        return C2843n.m11025b(bfVar);
    }

    public static void m11017a(gx gxVar, C2825a c2825a) {
        if (C2843n.m11028b(gxVar)) {
            ii iiVar = gxVar.f11179b;
            Object b = iiVar.m13233b();
            if (b == null) {
                C2972b.m11583d("AdWebView is null");
                return;
            }
            try {
                List list = gxVar.f11191n.f10648n;
                if (list == null || list.isEmpty()) {
                    C2972b.m11583d("No template ids present in mediation response");
                    return;
                }
                dz h = gxVar.f11192o.m12382h();
                ea i = gxVar.f11192o.m12383i();
                if (list.contains(MessageService.MSG_DB_NOTIFY_CLICK) && h != null) {
                    h.m12420b(C2690b.m10262a(b));
                    if (!h.m12428j()) {
                        h.m12427i();
                    }
                    iiVar.m13249l().m13287a("/nativeExpressViewClicked", C2843n.m11012a(h, null, c2825a));
                } else if (!list.contains(MessageService.MSG_DB_NOTIFY_REACHED) || i == null) {
                    C2972b.m11583d("No matching template id and mapper");
                } else {
                    i.m12453b(C2690b.m10262a(b));
                    if (!i.m12459h()) {
                        i.m12458g();
                    }
                    iiVar.m13249l().m13287a("/nativeExpressViewClicked", C2843n.m11012a(null, i, c2825a));
                }
            } catch (Throwable e) {
                C2972b.m11584d("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    private static void m11019a(ii iiVar, C2805d c2805d, String str) {
        iiVar.m13249l().m13285a(new C28381(c2805d, str, iiVar));
    }

    private static void m11020a(ii iiVar, C2807e c2807e, String str) {
        iiVar.m13249l().m13285a(new C28392(c2807e, str, iiVar));
    }

    private static void m11021a(ii iiVar, CountDownLatch countDownLatch) {
        iiVar.m13249l().m13287a("/nativeExpressAssetsLoaded", C2843n.m11013a(countDownLatch));
        iiVar.m13249l().m13287a("/nativeExpressAssetsLoadingFailed", C2843n.m11024b(countDownLatch));
    }

    public static boolean m11022a(ii iiVar, dp dpVar, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = C2843n.m11029b(iiVar, dpVar, countDownLatch);
        } catch (Throwable e) {
            C2972b.m11584d("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    private static bf m11023b(Object obj) {
        return obj instanceof IBinder ? C2801a.m10788a((IBinder) obj) : null;
    }

    static cb m11024b(CountDownLatch countDownLatch) {
        return new C28414(countDownLatch);
    }

    private static String m11025b(bf bfVar) {
        try {
            C2687a a = bfVar.m10785a();
            if (a == null) {
                C2972b.m11583d("Drawable is null. Returning empty string");
                return BuildConfig.FLAVOR;
            }
            Drawable drawable = (Drawable) C2690b.m10263a(a);
            if (drawable instanceof BitmapDrawable) {
                return C2843n.m11014a(((BitmapDrawable) drawable).getBitmap());
            }
            C2972b.m11583d("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return BuildConfig.FLAVOR;
        } catch (RemoteException e) {
            C2972b.m11583d("Unable to get drawable. Returning empty string");
            return BuildConfig.FLAVOR;
        }
    }

    private static JSONObject m11026b(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, C2843n.m11014a((Bitmap) obj));
                    } else {
                        C2972b.m11583d("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    C2972b.m11583d("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    private static void m11027b(ii iiVar) {
        OnClickListener A = iiVar.m13219A();
        if (A != null) {
            A.onClick(iiVar.m13233b());
        }
    }

    public static boolean m11028b(gx gxVar) {
        return (gxVar == null || !gxVar.f11190m || gxVar.f11191n == null || gxVar.f11191n.f10645k == null) ? false : true;
    }

    private static boolean m11029b(ii iiVar, dp dpVar, CountDownLatch countDownLatch) {
        View b = iiVar.m13233b();
        if (b == null) {
            C2972b.m11583d("AdWebView is null");
            return false;
        }
        b.setVisibility(4);
        List list = dpVar.f10687b.f10648n;
        if (list == null || list.isEmpty()) {
            C2972b.m11583d("No template ids present in mediation response");
            return false;
        }
        C2843n.m11021a(iiVar, countDownLatch);
        dz h = dpVar.f10688c.m12382h();
        ea i = dpVar.f10688c.m12383i();
        if (list.contains(MessageService.MSG_DB_NOTIFY_CLICK) && h != null) {
            C2843n.m11019a(iiVar, C2843n.m11009a(h), dpVar.f10687b.f10647m);
        } else if (!list.contains(MessageService.MSG_DB_NOTIFY_REACHED) || i == null) {
            C2972b.m11583d("No matching template id and mapper");
            return false;
        } else {
            C2843n.m11020a(iiVar, C2843n.m11010a(i), dpVar.f10687b.f10647m);
        }
        String str = dpVar.f10687b.f10645k;
        String str2 = dpVar.f10687b.f10646l;
        if (str2 != null) {
            iiVar.loadDataWithBaseURL(str2, str, "text/html", HttpRequest.f14548a, null);
        } else {
            iiVar.loadData(str, "text/html", HttpRequest.f14548a);
        }
        return true;
    }
}
