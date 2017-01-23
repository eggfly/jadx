package com.google.android.gms.p146b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.google.android.gms.ads.internal.C2798f;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.b.ci */
public final class ci implements cb {
    private final cd f10446a;
    private final C2798f f10447b;
    private final el f10448c;

    /* renamed from: com.google.android.gms.b.ci.a */
    public static class C3073a extends he {
        private final String f10440a;
        private final String f10441b;
        private final int f10442c;
        private final String f10443d;
        private final ii f10444e;

        public C3073a(ii iiVar, String str) {
            this.f10440a = "play.google.com";
            this.f10441b = "market";
            this.f10442c = 10;
            this.f10444e = iiVar;
            this.f10443d = str;
        }

        public Intent m12049a(String str) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(parse);
            return intent;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m12050a() {
            /*
            r8 = this;
            r0 = 0;
            r2 = r8.f10443d;
        L_0x0003:
            r1 = 10;
            if (r0 >= r1) goto L_0x0119;
        L_0x0007:
            r4 = r0 + 1;
            r0 = new java.net.URL;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r0.<init>(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r1 = "play.google.com";
            r3 = r0.getHost();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r1 = r1.equalsIgnoreCase(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            if (r1 == 0) goto L_0x002d;
        L_0x001a:
            r0 = r2;
        L_0x001b:
            r0 = r8.m12049a(r0);
            r1 = com.google.android.gms.ads.internal.C2968s.m11525e();
            r2 = r8.f10444e;
            r2 = r2.getContext();
            r1.m13033a(r2, r0);
            return;
        L_0x002d:
            r1 = "market";
            r3 = r0.getProtocol();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r1 = r1.equalsIgnoreCase(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            if (r1 == 0) goto L_0x003b;
        L_0x0039:
            r0 = r2;
            goto L_0x001b;
        L_0x003b:
            r0 = r0.openConnection();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r1 = com.google.android.gms.ads.internal.C2968s.m11525e();	 Catch:{ all -> 0x00b1 }
            r3 = r8.f10444e;	 Catch:{ all -> 0x00b1 }
            r3 = r3.getContext();	 Catch:{ all -> 0x00b1 }
            r5 = r8.f10444e;	 Catch:{ all -> 0x00b1 }
            r5 = r5.m13252o();	 Catch:{ all -> 0x00b1 }
            r5 = r5.f10081b;	 Catch:{ all -> 0x00b1 }
            r6 = 0;
            r1.m13039a(r3, r5, r6, r0);	 Catch:{ all -> 0x00b1 }
            r1 = r0.getResponseCode();	 Catch:{ all -> 0x00b1 }
            r5 = r0.getHeaderFields();	 Catch:{ all -> 0x00b1 }
            r3 = "";
            r6 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
            if (r1 < r6) goto L_0x0116;
        L_0x0065:
            r6 = 399; // 0x18f float:5.59E-43 double:1.97E-321;
            if (r1 > r6) goto L_0x0116;
        L_0x0069:
            r1 = 0;
            r6 = "Location";
            r6 = r5.containsKey(r6);	 Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x0099;
        L_0x0072:
            r1 = "Location";
            r1 = r5.get(r1);	 Catch:{ all -> 0x00b1 }
            r1 = (java.util.List) r1;	 Catch:{ all -> 0x00b1 }
        L_0x007a:
            if (r1 == 0) goto L_0x0116;
        L_0x007c:
            r5 = r1.size();	 Catch:{ all -> 0x00b1 }
            if (r5 <= 0) goto L_0x0116;
        L_0x0082:
            r3 = 0;
            r1 = r1.get(r3);	 Catch:{ all -> 0x00b1 }
            r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00b1 }
        L_0x0089:
            r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x00aa;
        L_0x008f:
            r1 = "Arrived at landing page, this ideally should not happen. Will open it in browser.";
            com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r1);	 Catch:{ all -> 0x00b1 }
            r0.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            r0 = r2;
            goto L_0x001b;
        L_0x0099:
            r6 = "location";
            r6 = r5.containsKey(r6);	 Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x007a;
        L_0x00a1:
            r1 = "location";
            r1 = r5.get(r1);	 Catch:{ all -> 0x00b1 }
            r1 = (java.util.List) r1;	 Catch:{ all -> 0x00b1 }
            goto L_0x007a;
        L_0x00aa:
            r0.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x0111, IOException -> 0x010c, RuntimeException -> 0x0107 }
            r0 = r4;
            r2 = r1;
            goto L_0x0003;
        L_0x00b1:
            r1 = move-exception;
            r0.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
            throw r1;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        L_0x00b6:
            r0 = move-exception;
            r1 = r0;
            r0 = r2;
        L_0x00b9:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Error while parsing ping URL: ";
            r2 = r2.append(r3);
            r2 = r2.append(r0);
            r2 = r2.toString();
            com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r2, r1);
            goto L_0x001b;
        L_0x00d1:
            r0 = move-exception;
            r1 = r0;
            r0 = r2;
        L_0x00d4:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Error while pinging URL: ";
            r2 = r2.append(r3);
            r2 = r2.append(r0);
            r2 = r2.toString();
            com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r2, r1);
            goto L_0x001b;
        L_0x00ec:
            r0 = move-exception;
            r1 = r0;
            r0 = r2;
        L_0x00ef:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Error while pinging URL: ";
            r2 = r2.append(r3);
            r2 = r2.append(r0);
            r2 = r2.toString();
            com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r2, r1);
            goto L_0x001b;
        L_0x0107:
            r0 = move-exception;
            r7 = r0;
            r0 = r1;
            r1 = r7;
            goto L_0x00ef;
        L_0x010c:
            r0 = move-exception;
            r7 = r0;
            r0 = r1;
            r1 = r7;
            goto L_0x00d4;
        L_0x0111:
            r0 = move-exception;
            r7 = r0;
            r0 = r1;
            r1 = r7;
            goto L_0x00b9;
        L_0x0116:
            r1 = r3;
            goto L_0x0089;
        L_0x0119:
            r0 = r2;
            goto L_0x001b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ci.a.a():void");
        }

        public void m12051b() {
        }
    }

    /* renamed from: com.google.android.gms.b.ci.b */
    public static class C3074b {
        private final ii f10445a;

        public C3074b(ii iiVar) {
            this.f10445a = iiVar;
        }

        public Intent m12052a(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.f10445a != null) {
                str = C2968s.m11525e().m13025a(this.f10445a, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = HttpConstant.HTTP.equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme(HttpConstant.HTTPS).build() : HttpConstant.HTTPS.equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme(HttpConstant.HTTP).build() : null;
            ArrayList arrayList = new ArrayList();
            Intent a = m12054a(parse);
            Intent a2 = m12054a(build);
            ResolveInfo a3 = m12056a(context, a, arrayList);
            if (a3 != null) {
                return m12053a(a, a3);
            }
            if (a2 != null) {
                ResolveInfo a4 = m12055a(context, a2);
                if (a4 != null) {
                    Intent a5 = m12053a(a, a4);
                    if (m12055a(context, a5) != null) {
                        return a5;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return a;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return m12053a(a, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? m12053a(a, (ResolveInfo) arrayList.get(0)) : a;
        }

        public Intent m12053a(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public Intent m12054a(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }

        public ResolveInfo m12055a(Context context, Intent intent) {
            return m12056a(context, intent, new ArrayList());
        }

        public ResolveInfo m12056a(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }
    }

    public ci(cd cdVar, C2798f c2798f, el elVar) {
        this.f10446a = cdVar;
        this.f10447b = c2798f;
        this.f10448c = elVar;
    }

    private void m12057a(boolean z) {
        if (this.f10448c != null) {
            this.f10448c.m12603a(z);
        }
    }

    private static boolean m12058a(Map<String, String> map) {
        return MessageService.MSG_DB_NOTIFY_REACHED.equals(map.get("custom_close"));
    }

    private static int m12059b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return C2968s.m11527g().m13089b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return C2968s.m11527g().m13075a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return C2968s.m11527g().m13092c();
            }
        }
        return -1;
    }

    private static void m12060b(ii iiVar, Map<String, String> map) {
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            C2972b.m11583d("Destination url cannot be empty.");
        } else {
            new C3073a(iiVar, str).m10975g();
        }
    }

    private static void m12061c(ii iiVar, Map<String, String> map) {
        Context context = iiVar.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            C2972b.m11583d("Destination url cannot be empty.");
            return;
        }
        try {
            iiVar.m13249l().m13282a(new AdLauncherIntentInfoParcel(new C3074b(iiVar).m12052a(context, (Map) map)));
        } catch (ActivityNotFoundException e) {
            C2972b.m11583d(e.getMessage());
        }
    }

    public void m12062a(ii iiVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            C2972b.m11583d("Action missing from an open GMSG.");
        } else if (this.f10447b == null || this.f10447b.m10777b()) {
            ij l = iiVar.m13249l();
            if ("expand".equalsIgnoreCase(str)) {
                if (iiVar.m13253p()) {
                    C2972b.m11583d("Cannot expand WebView that is already expanded.");
                    return;
                }
                m12057a(false);
                l.m13289a(ci.m12058a((Map) map), ci.m12059b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                m12057a(false);
                if (str != null) {
                    l.m13290a(ci.m12058a((Map) map), ci.m12059b(map), str);
                } else {
                    l.m13291a(ci.m12058a((Map) map), ci.m12059b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.f10446a == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.f10446a.m10467a(str, new ArrayList());
                } else {
                    this.f10446a.m10467a(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("play_store"))) {
                ci.m12060b(iiVar, map);
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m12057a(true);
                ci.m12061c(iiVar, map);
            } else {
                m12057a(true);
                str = (String) map.get("u");
                l.m13282a(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str) ? C2968s.m11525e().m13025a(iiVar, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.f10447b.m10776a((String) map.get("u"));
        }
    }
}
