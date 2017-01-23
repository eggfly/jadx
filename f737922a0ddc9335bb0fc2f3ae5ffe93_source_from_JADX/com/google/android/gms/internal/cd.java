package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.ads.internal.zze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@eh
public final class cd implements by {
    private final zze DW;
    private final dh FH;
    private final bz j6;

    public static class a {
        private final fj j6;

        public a(fj fjVar) {
            this.j6 = fjVar;
        }

        public Intent j6(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.j6 != null) {
                str = f.FH().j6(this.j6, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent j6 = j6(parse);
            Intent j62 = j6(build);
            ResolveInfo j63 = j6(context, j6, arrayList);
            if (j63 != null) {
                return j6(j6, j63);
            }
            if (j62 != null) {
                ResolveInfo j64 = j6(context, j62);
                if (j64 != null) {
                    Intent j65 = j6(j6, j64);
                    if (j6(context, j65) != null) {
                        return j65;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return j6;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return j6(j6, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? j6(j6, (ResolveInfo) arrayList.get(0)) : j6;
        }

        public Intent j6(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public Intent j6(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }

        public ResolveInfo j6(Context context, Intent intent) {
            return j6(context, intent, new ArrayList());
        }

        public ResolveInfo j6(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
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

    public cd(bz bzVar, zze com_google_android_gms_ads_internal_zze, dh dhVar) {
        this.j6 = bzVar;
        this.DW = com_google_android_gms_ads_internal_zze;
        this.FH = dhVar;
    }

    private static int DW(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return f.v5().DW();
            }
            if ("l".equalsIgnoreCase(str)) {
                return f.v5().j6();
            }
            if ("c".equalsIgnoreCase(str)) {
                return f.v5().FH();
            }
        }
        return -1;
    }

    private static void DW(fj fjVar, Map<String, String> map) {
        Context context = fjVar.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            b.Hw("Destination url cannot be empty.");
            return;
        }
        try {
            fjVar.J0().j6(new AdLauncherIntentInfoParcel(new a(fjVar).j6(context, (Map) map)));
        } catch (ActivityNotFoundException e) {
            b.Hw(e.getMessage());
        }
    }

    private void j6(boolean z) {
        if (this.FH != null) {
            this.FH.j6(z);
        }
    }

    private static boolean j6(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    public void j6(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            b.Hw("Action missing from an open GMSG.");
        } else if (this.DW == null || this.DW.j6()) {
            fk J0 = fjVar.J0();
            if ("expand".equalsIgnoreCase(str)) {
                if (fjVar.XL()) {
                    b.Hw("Cannot expand WebView that is already expanded.");
                    return;
                }
                j6(false);
                J0.j6(j6((Map) map), DW(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                j6(false);
                if (str != null) {
                    J0.j6(j6((Map) map), DW(map), str);
                } else {
                    J0.j6(j6((Map) map), DW(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.j6 == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.j6.j6(str, new ArrayList());
                } else {
                    this.j6.j6(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                j6(true);
                DW(fjVar, map);
            } else {
                j6(true);
                str = (String) map.get("u");
                J0.j6(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str) ? f.FH().j6(fjVar, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.DW.j6((String) map.get("u"));
        }
    }
}
