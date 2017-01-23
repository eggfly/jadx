package com.facebook.ads.internal.p123a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import anet.channel.strategy.dispatch.C0714a;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2494f;
import com.facebook.ads.internal.util.C2500i;
import com.facebook.ads.internal.util.C2510r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.a.c */
public class C2297c extends C2295a {
    private static final String f7952a;
    private final Context f7953b;
    private final Uri f7954c;

    static {
        f7952a = C2297c.class.getSimpleName();
    }

    public C2297c(Context context, Uri uri) {
        this.f7953b = context;
        this.f7954c = uri;
    }

    private Intent m8709a(C2500i c2500i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!(C2510r.m9516a(c2500i.m9496a()) || C2510r.m9516a(c2500i.m9497b()))) {
            intent.setComponent(new ComponentName(c2500i.m9496a(), c2500i.m9497b()));
        }
        if (!C2510r.m9516a(c2500i.m9498c())) {
            intent.setData(Uri.parse(c2500i.m9498c()));
        }
        return intent;
    }

    private Intent m8710b(C2500i c2500i) {
        if (C2510r.m9516a(c2500i.m9496a())) {
            return null;
        }
        if (!C2494f.m9467a(this.f7953b, c2500i.m9496a())) {
            return null;
        }
        String c = c2500i.m9498c();
        if (!C2510r.m9516a(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        PackageManager packageManager = this.f7953b.getPackageManager();
        if (C2510r.m9516a(c2500i.m9497b()) && C2510r.m9516a(c)) {
            return packageManager.getLaunchIntentForPackage(c2500i.m9496a());
        }
        Intent a = m8709a(c2500i);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, AccessibilityNodeInfoCompat.ACTION_CUT);
        if (a.getComponent() == null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(c2500i.m9496a())) {
                    a.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        return (queryIntentActivities.isEmpty() || a.getComponent() == null) ? null : a;
    }

    private List<C2500i> m8711f() {
        String queryParameter = this.f7954c.getQueryParameter("appsite_data");
        if (C2510r.m9516a(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        List<C2500i> arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray(C0714a.ANDROID);
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                C2500i a = C2500i.m9495a(optJSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            Log.w(f7952a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    public C2487a m8712a() {
        return C2487a.OPEN_STORE;
    }

    public void m8713b() {
        m8706a(this.f7953b, this.f7954c);
        List<Intent> d = m8715d();
        if (d != null) {
            for (Intent startActivity : d) {
                try {
                    this.f7953b.startActivity(startActivity);
                    return;
                } catch (Throwable e) {
                    Log.d(f7952a, "Failed to open app intent, falling back", e);
                }
            }
        }
        m8716e();
    }

    protected Uri m8714c() {
        String queryParameter = this.f7954c.getQueryParameter("store_url");
        if (!C2510r.m9516a(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        queryParameter = this.f7954c.getQueryParameter("store_id");
        return Uri.parse(String.format("market://details?id=%s", new Object[]{queryParameter}));
    }

    protected List<Intent> m8715d() {
        List<C2500i> f = m8711f();
        List<Intent> arrayList = new ArrayList();
        if (f != null) {
            for (C2500i b : f) {
                Intent b2 = m8710b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    public void m8716e() {
        Intent intent = new Intent("android.intent.action.VIEW", m8714c());
        intent.addFlags(268435456);
        try {
            this.f7953b.startActivity(intent);
        } catch (Throwable e) {
            Log.d(f7952a, "Failed to open market url: " + this.f7954c.toString(), e);
            String queryParameter = this.f7954c.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
                intent2.addFlags(268435456);
                try {
                    this.f7953b.startActivity(intent2);
                } catch (Throwable e2) {
                    Log.d(f7952a, "Failed to open fallback url: " + queryParameter, e2);
                }
            }
        }
    }
}
