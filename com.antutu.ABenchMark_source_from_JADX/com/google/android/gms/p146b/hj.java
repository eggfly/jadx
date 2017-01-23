package com.google.android.gms.p146b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import anet.channel.security.ISecurity;
import anet.channel.util.HttpConstant;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.google.android.gms.ads.internal.C2844o;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.common.internal.C3512u;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.hj */
public class hj {
    public static final Handler f11297a;
    private final Object f11298b;
    private boolean f11299c;
    private String f11300d;
    private boolean f11301e;

    /* renamed from: com.google.android.gms.b.hj.1 */
    class C32511 implements Runnable {
        final /* synthetic */ Context f11294a;
        final /* synthetic */ hj f11295b;

        C32511(hj hjVar, Context context) {
            this.f11295b = hjVar;
            this.f11294a = context;
        }

        public void run() {
            synchronized (this.f11295b.f11298b) {
                this.f11295b.f11300d = this.f11295b.m13059c(this.f11294a);
                this.f11295b.f11298b.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.b.hj.a */
    private final class C3252a extends BroadcastReceiver {
        final /* synthetic */ hj f11296a;

        private C3252a(hj hjVar) {
            this.f11296a = hjVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(intent.getAction())) {
                this.f11296a.f11299c = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f11296a.f11299c = false;
            }
        }
    }

    static {
        f11297a = new hg(Looper.getMainLooper());
    }

    public hj() {
        this.f11298b = new Object();
        this.f11299c = true;
        this.f11301e = false;
    }

    private JSONArray m13010a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m13013a(jSONArray, a);
        }
        return jSONArray;
    }

    private JSONObject m13011a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m13014a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m13012a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f11297a.post(runnable);
        }
    }

    private void m13013a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m13011a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m13030a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m13010a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m13029a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void m13014a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m13011a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m13030a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m13010a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m13010a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private boolean m13015a(KeyguardManager keyguardManager) {
        return keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode();
    }

    private boolean m13016a(PowerManager powerManager) {
        return powerManager == null || powerManager.isScreenOn();
    }

    private boolean m13018k(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    public Bitmap m13019a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public DisplayMetrics m13020a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow m13021a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String m13022a(Context context, View view, AdSizeParcel adSizeParcel) {
        String str = null;
        if (((Boolean) aq.f10286Z.m11794c()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", adSizeParcel.f9330f);
                jSONObject2.put("height", adSizeParcel.f9327c);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", m13069f(context));
                if (!adSizeParcel.f9329e) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(C4233j.f14402y, parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                C2972b.m11584d("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String m13023a(Context context, C3326k c3326k, String str) {
        if (c3326k != null) {
            try {
                Uri parse = Uri.parse(str);
                if (c3326k.m13590c(parse)) {
                    parse = c3326k.m13585a(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m13024a(android.content.Context r4, java.lang.String r5) {
        /*
        r3 = this;
        r1 = r3.f11298b;
        monitor-enter(r1);
        r0 = r3.f11300d;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.f11300d;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = com.google.android.gms.ads.internal.C2968s.m11527g();	 Catch:{ Exception -> 0x0095 }
        r0 = r0.m13078a(r4);	 Catch:{ Exception -> 0x0095 }
        r3.f11300d = r0;	 Catch:{ Exception -> 0x0095 }
    L_0x0015:
        r0 = r3.f11300d;	 Catch:{ all -> 0x005e }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0067;
    L_0x001d:
        r0 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ all -> 0x005e }
        r0 = r0.m11571b();	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x0061;
    L_0x0027:
        r0 = 0;
        r3.f11300d = r0;	 Catch:{ all -> 0x005e }
        r0 = f11297a;	 Catch:{ all -> 0x005e }
        r2 = new com.google.android.gms.b.hj$1;	 Catch:{ all -> 0x005e }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x005e }
        r0.post(r2);	 Catch:{ all -> 0x005e }
    L_0x0034:
        r0 = r3.f11300d;	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x0067;
    L_0x0038:
        r0 = r3.f11298b;	 Catch:{ InterruptedException -> 0x003e }
        r0.wait();	 Catch:{ InterruptedException -> 0x003e }
        goto L_0x0034;
    L_0x003e:
        r0 = move-exception;
        r0 = r3.m13053b();	 Catch:{ all -> 0x005e }
        r3.f11300d = r0;	 Catch:{ all -> 0x005e }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r0.<init>();	 Catch:{ all -> 0x005e }
        r2 = "Interrupted, use default user agent: ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r2 = r3.f11300d;	 Catch:{ all -> 0x005e }
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.toString();	 Catch:{ all -> 0x005e }
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r0);	 Catch:{ all -> 0x005e }
        goto L_0x0034;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        throw r0;
    L_0x0061:
        r0 = r3.m13059c(r4);	 Catch:{ Exception -> 0x008d }
        r3.f11300d = r0;	 Catch:{ Exception -> 0x008d }
    L_0x0067:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r0.<init>();	 Catch:{ all -> 0x005e }
        r2 = r3.f11300d;	 Catch:{ all -> 0x005e }
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.append(r5);	 Catch:{ all -> 0x005e }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.toString();	 Catch:{ all -> 0x005e }
        r3.f11300d = r0;	 Catch:{ all -> 0x005e }
        r0 = r3.f11300d;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        goto L_0x000a;
    L_0x008d:
        r0 = move-exception;
        r0 = r3.m13053b();	 Catch:{ all -> 0x005e }
        r3.f11300d = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0067;
    L_0x0095:
        r0 = move-exception;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.hj.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public String m13025a(ii iiVar, String str) {
        return m13023a(iiVar.getContext(), iiVar.m13251n(), str);
    }

    public String m13026a(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        char[] cArr = new char[Message.FLAG_RET];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public String m13027a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public Map<String, String> m13028a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : C2968s.m11527g().m13080a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    JSONArray m13029a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m13013a(jSONArray, a);
        }
        return jSONArray;
    }

    public JSONObject m13030a(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m13014a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public void m13031a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void m13032a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m13033a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void m13034a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m13024a(context, str));
    }

    public void m13035a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m13037a(context, str, arrayList);
    }

    public void m13036a(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString(Constants.KEY_OS_VERSION, VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("device", C2968s.m11525e().m13064d());
            bundle.putString(ACTD.APPID_KEY, applicationContext.getPackageName());
            bundle.putString("eids", TextUtils.join(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP, aq.m11813a()));
            if (str != null) {
                bundle.putString("js", str);
            } else {
                bundle.putString("gmscore_version", Integer.toString(C3465h.m14300e(context)));
            }
        }
        Builder appendQueryParameter = new Builder().scheme(HttpConstant.HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(AgooConstants.MESSAGE_ID, str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        C2968s.m11525e().m13035a(context, str, appendQueryParameter.toString());
    }

    public void m13037a(Context context, String str, List<String> list) {
        for (String hqVar : list) {
            new hq(context, str, hqVar).m10975g();
        }
    }

    public void m13038a(Context context, String str, List<String> list, String str2) {
        for (String hqVar : list) {
            new hq(context, str, hqVar, str2).m10975g();
        }
    }

    public void m13039a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m13041a(context, str, z, httpURLConnection, false);
    }

    public void m13040a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(HttpRequest.f14569v, str2);
        httpURLConnection.setUseCaches(false);
    }

    public void m13041a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(HttpRequest.f14569v, m13024a(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean m13042a() {
        return this.f11299c;
    }

    public boolean m13043a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C2972b.m11583d("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            C2972b.m11583d(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            C2972b.m11583d(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & SpdyProtocol.SLIGHTSSLV2) == 0) {
            C2972b.m11583d(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) == 0) {
            C2972b.m11583d(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) == 0) {
            C2972b.m11583d(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & IXAdIOUtils.BUFFER_SIZE) == 0) {
            C2972b.m11583d(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & Message.FLAG_RET) != 0) {
            return z;
        }
        C2972b.m11583d(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean m13044a(Context context, Bitmap bitmap, String str) {
        C3512u.m14590c("saveImageToFile must not be called on the main UI thread.");
        try {
            OutputStream openFileOutput = context.openFileOutput(str, 0);
            bitmap.compress(CompressFormat.PNG, 100, openFileOutput);
            openFileOutput.close();
            bitmap.recycle();
            return true;
        } catch (Throwable e) {
            C2972b.m11580b("Fail to save file", e);
            return false;
        }
    }

    public boolean m13045a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean m13046a(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return m13047a(view, powerManager, keyguardManager);
    }

    public boolean m13047a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        return view.getVisibility() == 0 && view.isShown() && m13016a(powerManager) && (C2968s.m11525e().m13042a() || !m13015a(keyguardManager));
    }

    public boolean m13048a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public int[] m13049a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m13067e();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public int m13050b(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    public int m13051b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C2972b.m11583d("Could not parse value:" + e);
            return 0;
        }
    }

    public Bitmap m13052b(Context context, String str) {
        C3512u.m14590c("getBackgroundImage must not be called on the main UI thread.");
        try {
            InputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            return decodeStream;
        } catch (Exception e) {
            C2972b.m11579b("Fail to get background image");
            return null;
        }
    }

    String m13053b() {
        StringBuffer stringBuffer = new StringBuffer(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public void m13054b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m13055b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) aq.an.m11794c()).booleanValue()) {
            m13036a(context, str, str2, bundle, z);
        }
    }

    public boolean m13056b(Context context) {
        if (this.f11301e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new C3252a(), intentFilter);
        this.f11301e = true;
        return true;
    }

    public int[] m13057b(Activity activity) {
        int[] a = m13049a(activity);
        return new int[]{C2784w.m10741a().m11569b((Context) activity, a[0]), C2784w.m10741a().m11569b((Context) activity, a[1])};
    }

    public String m13058c() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    protected String m13059c(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public void m13060c(Context context, String str) {
        C3512u.m14590c("deleteFile must not be called on the main UI thread.");
        context.deleteFile(str);
    }

    public boolean m13061c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] m13062c(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m13067e();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public AlertDialog.Builder m13063d(Context context) {
        return new AlertDialog.Builder(context);
    }

    public String m13064d() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    public int[] m13065d(Activity activity) {
        int[] c = m13062c(activity);
        return new int[]{C2784w.m10741a().m11569b((Context) activity, c[0]), C2784w.m10741a().m11569b((Context) activity, c[1])};
    }

    public ai m13066e(Context context) {
        return new ai(context);
    }

    protected int[] m13067e() {
        return new int[]{0, 0};
    }

    public float m13068f() {
        C2844o a = C2968s.m11539s().m11190a();
        return (a == null || !a.m11034d()) ? 1.0f : a.m11033c();
    }

    public String m13069f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    public boolean m13070g(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && m13018k(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap m13071h(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            View decorView = ((Activity) context).getWindow().getDecorView();
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            decorView.layout(0, 0, decorView.getWidth(), decorView.getHeight());
            decorView.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            C2972b.m11580b("Fail to capture screen shot", e);
            return null;
        }
    }

    public float m13072i(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        return streamMaxVolume == 0 ? 0.0f : ((float) audioManager.getStreamVolume(3)) / ((float) streamMaxVolume);
    }

    public int m13073j(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }
}
