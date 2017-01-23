package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.a.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.math.BigInteger;
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
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@eh
public class et {
    public static final Handler j6;
    private final Object DW;
    private boolean FH;
    private String Hw;
    private boolean v5;

    class 1 implements Runnable {
        final /* synthetic */ et DW;
        final /* synthetic */ Context j6;

        1(et etVar, Context context) {
            this.DW = etVar;
            this.j6 = context;
        }

        public void run() {
            synchronized (this.DW.DW) {
                this.DW.Hw = this.DW.j6(this.j6);
                this.DW.DW.notifyAll();
            }
        }
    }

    class 2 implements a {
        final /* synthetic */ String DW;
        final /* synthetic */ et FH;
        final /* synthetic */ Context j6;

        2(et etVar, Context context, String str) {
            this.FH = etVar;
            this.j6 = context;
            this.DW = str;
        }

        public void j6(String str) {
            f.FH().j6(this.j6, this.DW, str);
        }
    }

    static {
        j6 = new ep(Looper.getMainLooper());
    }

    public et() {
        this.DW = new Object();
        this.FH = true;
        this.v5 = false;
    }

    private JSONArray j6(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object j6 : collection) {
            j6(jSONArray, j6);
        }
        return jSONArray;
    }

    private JSONObject j6(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            j6(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private void j6(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(j6((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(j6((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(j6((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(j6((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void j6(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, j6((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, j6((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, j6((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, j6(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public Builder DW(Context context) {
        return new Builder(context);
    }

    public String DW() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
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

    public void DW(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public boolean DW(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] DW(Activity activity) {
        int[] j6 = j6(activity);
        return new int[]{w.j6().DW((Context) activity, j6[0]), w.j6().DW((Context) activity, j6[1])};
    }

    public zzcm FH(Context context) {
        return new zzcm(context);
    }

    public String FH() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    public int[] FH(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return Hw();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public AudioManager Hw(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    protected int[] Hw() {
        return new int[]{0, 0};
    }

    public int[] Hw(Activity activity) {
        int[] FH = FH(activity);
        return new int[]{w.j6().DW((Context) activity, FH[0]), w.j6().DW((Context) activity, FH[1])};
    }

    public int j6(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            b.Hw(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    public Bitmap j6(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public DisplayMetrics j6(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow j6(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    String j6() {
        StringBuffer stringBuffer = new StringBuffer(256);
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

    protected String j6(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public String j6(Context context, y yVar, String str) {
        if (yVar != null) {
            try {
                Uri parse = Uri.parse(str);
                if (yVar.FH(parse)) {
                    parse = yVar.j6(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String j6(android.content.Context r6, java.lang.String r7) {
        /*
        r5 = this;
        r1 = r5.DW;
        monitor-enter(r1);
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = com.google.android.gms.ads.internal.f.v5();	 Catch:{ Exception -> 0x00b2 }
        r0 = r0.j6(r6);	 Catch:{ Exception -> 0x00b2 }
        r5.Hw = r0;	 Catch:{ Exception -> 0x00b2 }
    L_0x0015:
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x006b;
    L_0x001d:
        r0 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ all -> 0x005c }
        r0 = r0.DW();	 Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x0065;
    L_0x0027:
        r0 = 0;
        r5.Hw = r0;	 Catch:{ all -> 0x005c }
        r0 = j6;	 Catch:{ all -> 0x005c }
        r2 = new com.google.android.gms.internal.et$1;	 Catch:{ all -> 0x005c }
        r2.<init>(r5, r6);	 Catch:{ all -> 0x005c }
        r0.post(r2);	 Catch:{ all -> 0x005c }
    L_0x0034:
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x006b;
    L_0x0038:
        r0 = r5.DW;	 Catch:{ InterruptedException -> 0x003e }
        r0.wait();	 Catch:{ InterruptedException -> 0x003e }
        goto L_0x0034;
    L_0x003e:
        r0 = move-exception;
        r0 = r5.j6();	 Catch:{ all -> 0x005c }
        r5.Hw = r0;	 Catch:{ all -> 0x005c }
        r2 = "Interrupted, use default user agent: ";
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x005c }
        r3 = r0.length();	 Catch:{ all -> 0x005c }
        if (r3 == 0) goto L_0x005f;
    L_0x0054:
        r0 = r2.concat(r0);	 Catch:{ all -> 0x005c }
    L_0x0058:
        com.google.android.gms.ads.internal.util.client.b.Hw(r0);	 Catch:{ all -> 0x005c }
        goto L_0x0034;
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        throw r0;
    L_0x005f:
        r0 = new java.lang.String;	 Catch:{ all -> 0x005c }
        r0.<init>(r2);	 Catch:{ all -> 0x005c }
        goto L_0x0058;
    L_0x0065:
        r0 = r5.j6(r6);	 Catch:{ Exception -> 0x00aa }
        r5.Hw = r0;	 Catch:{ Exception -> 0x00aa }
    L_0x006b:
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x005c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005c }
        r3 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x005c }
        r3 = r3.length();	 Catch:{ all -> 0x005c }
        r3 = r3 + 11;
        r4 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x005c }
        r4 = r4.length();	 Catch:{ all -> 0x005c }
        r3 = r3 + r4;
        r2.<init>(r3);	 Catch:{ all -> 0x005c }
        r0 = r2.append(r0);	 Catch:{ all -> 0x005c }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005c }
        r0 = r0.append(r7);	 Catch:{ all -> 0x005c }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005c }
        r0 = r0.toString();	 Catch:{ all -> 0x005c }
        r5.Hw = r0;	 Catch:{ all -> 0x005c }
        r0 = r5.Hw;	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        goto L_0x000a;
    L_0x00aa:
        r0 = move-exception;
        r0 = r5.j6();	 Catch:{ all -> 0x005c }
        r5.Hw = r0;	 Catch:{ all -> 0x005c }
        goto L_0x006b;
    L_0x00b2:
        r0 = move-exception;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.et.j6(android.content.Context, java.lang.String):java.lang.String");
    }

    public String j6(fj fjVar, String str) {
        return j6(fjVar.getContext(), fjVar.Ws(), str);
    }

    public Map<String, String> j6(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : f.v5().j6(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    JSONArray j6(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object j6 : objArr) {
            j6(jSONArray, j6);
        }
        return jSONArray;
    }

    public JSONObject j6(Map<String, ?> map) {
        String valueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String valueOf2 : map.keySet()) {
                j6(jSONObject, valueOf2, map.get(valueOf2));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str = "Could not convert map to JSON: ";
            valueOf2 = String.valueOf(e.getMessage());
            throw new JSONException(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public void j6(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void j6(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void j6(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void j6(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(j6(context, str));
    }

    public void j6(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        j6(context, str, arrayList);
    }

    public void j6(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            bundle.putString("device", f.FH().FH());
            bundle.putString("eids", TextUtils.join(",", aq.j6()));
        }
        w.j6().j6(context, str, str2, bundle, z, new 2(this, context, str));
    }

    public void j6(Context context, String str, List<String> list) {
        for (String exVar : list) {
            Future future = (Future) new ex(context, str, exVar).FH();
        }
    }

    public void j6(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            j6.post(runnable);
        }
    }

    public void j6(List<String> list, String str) {
        for (String exVar : list) {
            Future future = (Future) new ex(exVar, str).FH();
        }
    }

    public boolean j6(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public int[] j6(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return Hw();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }
}
