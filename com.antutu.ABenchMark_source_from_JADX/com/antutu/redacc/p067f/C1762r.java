package com.antutu.redacc.p067f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.redacc.p068b.C1718a;
import com.antutu.redacc.p068b.C1718a.C1717a;
import com.antutu.redacc.p072e.C1737a;
import com.antutu.redacc.p072e.C1741d;
import com.antutu.redacc.p072e.C1743e;
import com.jaredrummler.android.processes.C3962a;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.p029a.p030a.p031b.C1054a;
import com.p029a.p030a.p031b.C1071b;
import com.p029a.p033b.C1073a;
import com.taobao.accs.common.Constants;
import com.tools.utility.JNILIB;
import com.umeng.message.common.C4209a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.redacc.f.r */
public class C1762r {
    private static final C1762r f6196a;
    private boolean f6197b;
    private boolean f6198c;
    private boolean f6199d;
    private boolean f6200e;
    private boolean f6201f;
    private String f6202g;
    private String f6203h;
    private String f6204i;
    private String f6205j;
    private boolean f6206k;
    private List<C1737a> f6207l;
    private List<C1737a> f6208m;
    private List<String> f6209n;
    private List<String> f6210o;
    private List<String> f6211p;
    private List<C1737a> f6212q;
    private long f6213r;

    /* renamed from: com.antutu.redacc.f.r.1 */
    class C17611 implements C1717a {
        final /* synthetic */ C1762r f6195a;

        C17611(C1762r c1762r) {
            this.f6195a = c1762r;
        }

        public void m6769a(List<String> list) {
            this.f6195a.f6209n = list;
        }
    }

    static {
        f6196a = new C1762r();
    }

    private C1762r() {
        this.f6197b = false;
        this.f6198c = false;
        this.f6199d = false;
        this.f6200e = false;
        this.f6201f = false;
        this.f6202g = BuildConfig.FLAVOR;
        this.f6203h = BuildConfig.FLAVOR;
        this.f6204i = BuildConfig.FLAVOR;
        this.f6205j = BuildConfig.FLAVOR;
        this.f6206k = false;
        this.f6207l = new ArrayList();
        this.f6208m = new ArrayList();
        this.f6209n = new ArrayList();
        this.f6210o = new ArrayList();
        this.f6211p = new ArrayList();
        this.f6212q = new ArrayList();
        this.f6213r = 0;
        this.f6197b = false;
    }

    public static String m6770a(long j) {
        if (j < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return j + " B";
        }
        long j2 = j / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return j2 + " KB";
        }
        j2 /= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return j2 + " MB";
        }
        return ((double) (j2 / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) + " GB";
    }

    private void m6772a(Context context, C1071b c1071b, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4);
            for (String str2 : this.f6211p) {
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if (str2.equals(serviceInfo.name)) {
                        C1073a.m4795a(c1071b, new C1054a(0, this.f6204i + " " + new ComponentName(str, str2).flattenToString()));
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void m6773a(Context context, C1071b c1071b, List<String> list, List<String> list2) {
        for (String a : list2) {
            m6787a(context, c1071b, (List) list, a);
        }
    }

    private void m6774b(Context context, String str) {
        try {
            C1762r.m6776e().m6790a(true);
            Uri fromParts = Uri.fromParts(C4209a.f14200c, str, null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(335544320);
            intent.setData(fromParts);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    private void m6775c(Context context, String str) {
        try {
            m6774b(context, str);
            for (int i = 30; i > 0 && m6795b(); i--) {
                Thread.sleep(200);
            }
        } catch (Exception e) {
        }
    }

    public static C1762r m6776e() {
        return f6196a;
    }

    public static String m6777h(Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        return (language == null || !language.contains("zh")) ? language : (country == null || country.contains("CN")) ? "CN" : "TW";
    }

    private static List<UsageStats> m6778i(Context context) {
        if (VERSION.SDK_INT >= 21) {
            UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
            try {
                long currentTimeMillis = System.currentTimeMillis();
                return usageStatsManager.queryUsageStats(4, currentTimeMillis - 30000, currentTimeMillis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void m6779n() {
        this.f6212q.clear();
        for (C1737a c1737a : this.f6207l) {
            if (c1737a.m6717e()) {
                this.f6212q.add(c1737a);
            }
        }
    }

    public int m6780a(Context context, int i) {
        C1071b c1071b;
        int i2 = 0;
        this.f6213r = 0;
        m6779n();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        C1071b c1071b2 = null;
        try {
            if (this.f6197b) {
                c1071b2 = C1073a.m4792a(true);
            }
            c1071b = c1071b2;
        } catch (Exception e) {
            c1071b = null;
        }
        List arrayList = new ArrayList();
        int i3 = 0;
        while (i2 < this.f6212q.size()) {
            C1737a c1737a = (C1737a) this.f6212q.get(i2);
            if (c1737a.m6717e()) {
                this.f6213r += c1737a.m6708b();
                i3++;
                if (c1071b != null) {
                    try {
                        context.sendBroadcast(new Intent().setAction("MSG_BR_ON_KILL_APP").setPackage(context.getPackageName()).putExtra(Constants.KEY_ELECTION_PKG, c1737a.m6721i()).putExtra("index", (i2 + 1) + "/" + this.f6212q.size()));
                    } catch (Exception e2) {
                    }
                    try {
                        C1073a.m4795a(c1071b, new C1054a(0, this.f6203h + " " + c1737a.m6721i()));
                        arrayList.add(c1737a.m6721i());
                        m6772a(context, c1071b, c1737a.m6721i());
                        if (i > 100) {
                            try {
                                Thread.sleep((long) i);
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Exception e4) {
                        activityManager.killBackgroundProcesses(c1737a.m6721i());
                    }
                } else {
                    activityManager.killBackgroundProcesses(c1737a.m6721i());
                }
            }
            i2++;
        }
        if (c1071b != null) {
            try {
                m6773a(context, c1071b, arrayList, this.f6210o.subList(1, this.f6210o.size()));
                c1071b.m4786a();
            } catch (Exception e5) {
            }
        }
        if (i > 100) {
            try {
                context.sendBroadcast(new Intent().setAction("MSG_BR_ON_KILL_APP").setPackage(context.getPackageName()).putExtra(Constants.KEY_ELECTION_PKG, "com.android.settings").putExtra("index", this.f6212q.size() + "/" + this.f6212q.size()));
                Thread.sleep(600);
            } catch (Exception e6) {
            }
        }
        return i3;
    }

    public int m6781a(Context context, boolean z) {
        this.f6213r = 0;
        m6779n();
        int i = 0;
        int i2 = 0;
        while (i < this.f6212q.size()) {
            int i3;
            C1737a c1737a = (C1737a) this.f6212q.get(i);
            if (c1737a.m6717e()) {
                this.f6213r += c1737a.m6708b();
                i2++;
                try {
                    context.sendBroadcast(new Intent().setAction("MSG_BR_ON_KILL_APP").setPackage(context.getPackageName()).putExtra(Constants.KEY_ELECTION_PKG, c1737a.m6721i()).putExtra("index", (i + 1) + "/" + this.f6212q.size()));
                } catch (Exception e) {
                }
                try {
                    m6775c(context, c1737a.m6721i());
                    i3 = i2;
                } catch (Exception e2) {
                }
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 > 0) {
            m6775c(context, "com.android.settings");
            try {
                context.sendBroadcast(new Intent().setAction("MSG_BR_ON_KILL_APP").setPackage(context.getPackageName()).putExtra(Constants.KEY_ELECTION_PKG, "com.android.settings").putExtra("index", this.f6212q.size() + "/" + this.f6212q.size()));
            } catch (Exception e3) {
            }
            if (z) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setFlags(268435456);
                intent.addCategory("android.intent.category.HOME");
                context.startActivity(intent);
            }
        } else if (i2 <= 0) {
            context.sendBroadcast(new Intent().setAction("MSG_BR_ON_KILL_APP").setPackage(context.getPackageName()).putExtra(Constants.KEY_ELECTION_PKG, "com.android.settings").putExtra("index", this.f6212q.size() + "/" + this.f6212q.size()));
        }
        return i2;
    }

    public int m6782a(Context context, boolean z, boolean z2) {
        C1741d c1741d;
        String f;
        List<String> arrayList;
        List list;
        List i;
        List<C1737a> f2;
        int i2;
        ApplicationInfo a;
        Object obj;
        C1737a c1737a;
        int size;
        this.f6207l.clear();
        PackageManager packageManager = context.getPackageManager();
        C1746c c1746c = new C1746c(context);
        List<AndroidAppProcess> a2 = C3962a.m16308a();
        if (a2.isEmpty() || a2.size() == 0) {
            return -1;
        }
        List arrayList2 = new ArrayList();
        C1741d c1741d2;
        try {
            c1741d2 = new C1741d(context);
            try {
                c1741d2.m6731a();
                c1741d = c1741d2;
            } catch (Exception e) {
                c1741d = c1741d2;
                f = m6802f(context);
                arrayList = new ArrayList();
                for (InputMethodInfo packageName : ((InputMethodManager) context.getSystemService("input_method")).getEnabledInputMethodList()) {
                    arrayList.add(packageName.getPackageName());
                }
                list = null;
                i = C1762r.m6778i(context);
                m6804g(context);
                f2 = m6803f();
                for (AndroidAppProcess androidAppProcess : a2) {
                    i2 = androidAppProcess.d;
                    a = c1746c.m6743a(androidAppProcess.m16314a());
                    if (a == null) {
                        try {
                            if (androidAppProcess.m16314a().equals(context.getPackageName())) {
                                obj = null;
                                for (String equals : arrayList) {
                                    if (equals.equals(androidAppProcess.m16314a())) {
                                        obj = 1;
                                        break;
                                        if (c1741d != null) {
                                            try {
                                                if (c1741d.m6730a(androidAppProcess.m16314a()) == 1) {
                                                }
                                            } catch (Exception e2) {
                                            }
                                        }
                                        c1737a = new C1737a();
                                        c1737a.m6709b(i2);
                                        c1737a.m6712b(false);
                                        c1737a.m6715c((a.flags & 1) == 0);
                                        c1737a.m6711b(androidAppProcess.m16314a());
                                        c1737a.m6714c(a.processName);
                                        c1737a.m6705a(context);
                                        if (z) {
                                            c1737a.m6706a(a.loadLabel(packageManager).toString());
                                            c1737a.m6703a(a.icon);
                                        }
                                        if (!arrayList2.contains(androidAppProcess.m16314a())) {
                                            if (c1737a.m6720h()) {
                                                if (!!f.isEmpty()) {
                                                }
                                                if (obj != null) {
                                                    c1737a.m6707a(true);
                                                } else {
                                                    c1737a.m6707a(false);
                                                }
                                            } else {
                                                c1737a.m6707a(false);
                                            }
                                            for (C1737a i3 : f2) {
                                                if (i3.m6721i().equals(androidAppProcess.m16314a())) {
                                                    c1737a.m6707a(false);
                                                }
                                            }
                                            if (z2) {
                                            }
                                            arrayList2.add(androidAppProcess.m16314a());
                                            this.f6207l.add(c1737a);
                                        }
                                    }
                                }
                                if (c1741d != null) {
                                    if (c1741d.m6730a(androidAppProcess.m16314a()) == 1) {
                                    }
                                }
                                c1737a = new C1737a();
                                c1737a.m6709b(i2);
                                c1737a.m6712b(false);
                                if ((a.flags & 1) == 0) {
                                }
                                c1737a.m6715c((a.flags & 1) == 0);
                                c1737a.m6711b(androidAppProcess.m16314a());
                                c1737a.m6714c(a.processName);
                                c1737a.m6705a(context);
                                if (z) {
                                    c1737a.m6706a(a.loadLabel(packageManager).toString());
                                    c1737a.m6703a(a.icon);
                                }
                                if (!arrayList2.contains(androidAppProcess.m16314a())) {
                                    if (c1737a.m6720h()) {
                                        c1737a.m6707a(false);
                                    } else {
                                        if (!f.isEmpty()) {
                                        }
                                        if (obj != null) {
                                            c1737a.m6707a(false);
                                        } else {
                                            c1737a.m6707a(true);
                                        }
                                    }
                                    while (r6.hasNext()) {
                                        if (i3.m6721i().equals(androidAppProcess.m16314a())) {
                                            c1737a.m6707a(false);
                                        }
                                    }
                                    if (z2) {
                                    }
                                    arrayList2.add(androidAppProcess.m16314a());
                                    this.f6207l.add(c1737a);
                                }
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                size = this.f6207l.size();
                for (C1737a c1737a2 : this.f6207l) {
                    for (UsageStats usageStats : r5) {
                        if (c1737a2.m6721i() != null) {
                        }
                    }
                }
                if (c1741d != null) {
                    c1741d.m6733b();
                }
                if (z) {
                    Collections.sort(this.f6207l, C1743e.m6734a());
                }
                return size;
            }
        } catch (Exception e4) {
            c1741d2 = null;
            c1741d = c1741d2;
            f = m6802f(context);
            arrayList = new ArrayList();
            while (r3.hasNext()) {
                arrayList.add(packageName.getPackageName());
            }
            list = null;
            i = C1762r.m6778i(context);
            m6804g(context);
            f2 = m6803f();
            for (AndroidAppProcess androidAppProcess2 : a2) {
                i2 = androidAppProcess2.d;
                a = c1746c.m6743a(androidAppProcess2.m16314a());
                if (a == null) {
                    if (androidAppProcess2.m16314a().equals(context.getPackageName())) {
                        obj = null;
                        while (r17.hasNext()) {
                            if (equals.equals(androidAppProcess2.m16314a())) {
                                obj = 1;
                                break;
                                if (c1741d != null) {
                                    if (c1741d.m6730a(androidAppProcess2.m16314a()) == 1) {
                                    }
                                }
                                c1737a = new C1737a();
                                c1737a.m6709b(i2);
                                c1737a.m6712b(false);
                                if ((a.flags & 1) == 0) {
                                }
                                c1737a.m6715c((a.flags & 1) == 0);
                                c1737a.m6711b(androidAppProcess2.m16314a());
                                c1737a.m6714c(a.processName);
                                c1737a.m6705a(context);
                                if (z) {
                                    c1737a.m6706a(a.loadLabel(packageManager).toString());
                                    c1737a.m6703a(a.icon);
                                }
                                if (!arrayList2.contains(androidAppProcess2.m16314a())) {
                                    if (c1737a.m6720h()) {
                                        if (!f.isEmpty()) {
                                        }
                                        if (obj != null) {
                                            c1737a.m6707a(true);
                                        } else {
                                            c1737a.m6707a(false);
                                        }
                                    } else {
                                        c1737a.m6707a(false);
                                    }
                                    while (r6.hasNext()) {
                                        if (i3.m6721i().equals(androidAppProcess2.m16314a())) {
                                            c1737a.m6707a(false);
                                        }
                                    }
                                    if (z2) {
                                    }
                                    arrayList2.add(androidAppProcess2.m16314a());
                                    this.f6207l.add(c1737a);
                                }
                            }
                        }
                        if (c1741d != null) {
                            if (c1741d.m6730a(androidAppProcess2.m16314a()) == 1) {
                            }
                        }
                        c1737a = new C1737a();
                        c1737a.m6709b(i2);
                        c1737a.m6712b(false);
                        if ((a.flags & 1) == 0) {
                        }
                        c1737a.m6715c((a.flags & 1) == 0);
                        c1737a.m6711b(androidAppProcess2.m16314a());
                        c1737a.m6714c(a.processName);
                        c1737a.m6705a(context);
                        if (z) {
                            c1737a.m6706a(a.loadLabel(packageManager).toString());
                            c1737a.m6703a(a.icon);
                        }
                        if (!arrayList2.contains(androidAppProcess2.m16314a())) {
                            if (c1737a.m6720h()) {
                                c1737a.m6707a(false);
                            } else {
                                if (!f.isEmpty()) {
                                }
                                if (obj != null) {
                                    c1737a.m6707a(false);
                                } else {
                                    c1737a.m6707a(true);
                                }
                            }
                            while (r6.hasNext()) {
                                if (i3.m6721i().equals(androidAppProcess2.m16314a())) {
                                    c1737a.m6707a(false);
                                }
                            }
                            if (z2) {
                            }
                            arrayList2.add(androidAppProcess2.m16314a());
                            this.f6207l.add(c1737a);
                        }
                    }
                }
            }
            size = this.f6207l.size();
            for (C1737a c1737a22 : this.f6207l) {
                for (UsageStats usageStats2 : r5) {
                    if (c1737a22.m6721i() != null) {
                    }
                }
            }
            if (c1741d != null) {
                c1741d.m6733b();
            }
            if (z) {
                Collections.sort(this.f6207l, C1743e.m6734a());
            }
            return size;
        }
        f = m6802f(context);
        arrayList = new ArrayList();
        try {
            while (r3.hasNext()) {
                arrayList.add(packageName.getPackageName());
            }
        } catch (Exception e5) {
        }
        list = null;
        try {
            i = C1762r.m6778i(context);
        } catch (Exception e6) {
            e6.printStackTrace();
            i = list;
        }
        m6804g(context);
        f2 = m6803f();
        for (AndroidAppProcess androidAppProcess22 : a2) {
            i2 = androidAppProcess22.d;
            a = c1746c.m6743a(androidAppProcess22.m16314a());
            if (a == null) {
                if (androidAppProcess22.m16314a().equals(context.getPackageName())) {
                    obj = null;
                    while (r17.hasNext()) {
                        if (equals.equals(androidAppProcess22.m16314a())) {
                            obj = 1;
                            break;
                        }
                    }
                    if (c1741d != null) {
                        if (c1741d.m6730a(androidAppProcess22.m16314a()) == 1) {
                        }
                    }
                    c1737a = new C1737a();
                    c1737a.m6709b(i2);
                    c1737a.m6712b(false);
                    if ((a.flags & 1) == 0) {
                    }
                    c1737a.m6715c((a.flags & 1) == 0);
                    c1737a.m6711b(androidAppProcess22.m16314a());
                    c1737a.m6714c(a.processName);
                    c1737a.m6705a(context);
                    if (z) {
                        c1737a.m6706a(a.loadLabel(packageManager).toString());
                        c1737a.m6703a(a.icon);
                    }
                    if (!arrayList2.contains(androidAppProcess22.m16314a())) {
                        if (c1737a.m6720h()) {
                            c1737a.m6707a(false);
                        } else if (!f.isEmpty() && f.equals(c1737a.m6721i())) {
                            c1737a.m6707a(false);
                        } else if (obj != null) {
                            c1737a.m6707a(false);
                        } else {
                            c1737a.m6707a(true);
                        }
                        while (r6.hasNext()) {
                            if (i3.m6721i().equals(androidAppProcess22.m16314a())) {
                                c1737a.m6707a(false);
                            }
                        }
                        if (z2) {
                            if (!c1737a.m6719g() && c1737a.m6717e()) {
                                if (!f.isEmpty() && f.equals(c1737a.m6721i())) {
                                }
                            }
                        }
                        arrayList2.add(androidAppProcess22.m16314a());
                        this.f6207l.add(c1737a);
                    }
                }
            }
        }
        size = this.f6207l.size();
        if (r5 != null && VERSION.SDK_INT >= 21) {
            for (C1737a c1737a222 : this.f6207l) {
                for (UsageStats usageStats22 : r5) {
                    if (c1737a222.m6721i() != null && c1737a222.m6721i().equals(usageStats22.getPackageName())) {
                        c1737a222.m6704a(usageStats22.getLastTimeUsed());
                        break;
                    }
                }
            }
        }
        if (c1741d != null) {
            c1741d.m6733b();
        }
        if (z) {
            Collections.sort(this.f6207l, C1743e.m6734a());
        }
        return size;
    }

    public int m6783a(Context context, boolean z, boolean z2, boolean z3) {
        C1741d c1741d;
        C1741d c1741d2;
        String f;
        List<String> arrayList;
        List list;
        List i;
        List<C1737a> f2;
        int i2;
        PackageInfo packageInfo;
        boolean z4;
        Object obj;
        C1737a c1737a;
        int indexOf;
        C1737a c1737a2;
        int size;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        PackageManager packageManager = context.getPackageManager();
        this.f6207l.clear();
        List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        List arrayList2 = new ArrayList();
        try {
            c1741d = new C1741d(context);
            try {
                c1741d.m6731a();
                c1741d2 = c1741d;
            } catch (Exception e) {
                c1741d2 = c1741d;
                f = m6802f(context);
                arrayList = new ArrayList();
                for (InputMethodInfo packageName : ((InputMethodManager) context.getSystemService("input_method")).getEnabledInputMethodList()) {
                    arrayList.add(packageName.getPackageName());
                }
                list = null;
                try {
                    i = C1762r.m6778i(context);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i = list;
                }
                m6804g(context);
                f2 = m6803f();
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    i2 = runningAppProcessInfo.pid;
                    try {
                        packageInfo = packageManager.getPackageInfo(runningAppProcessInfo.pkgList[0], 0);
                        if (runningAppProcessInfo.importance != Constants.COMMAND_HANDSHAKE) {
                        }
                        if (packageInfo.packageName.equals(context.getPackageName())) {
                            obj = null;
                            for (String equals : arrayList) {
                                if (equals.equals(packageInfo.packageName)) {
                                    obj = 1;
                                    break;
                                    if (c1741d2 != null) {
                                        try {
                                            if (c1741d2.m6730a(packageInfo.packageName) == 1) {
                                            }
                                        } catch (Exception e3) {
                                        }
                                    }
                                    c1737a = new C1737a();
                                    c1737a.m6709b(i2);
                                    c1737a.m6712b(z4);
                                    c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                                    c1737a.m6711b(packageInfo.packageName);
                                    c1737a.m6714c(runningAppProcessInfo.processName);
                                    c1737a.m6705a(context);
                                    if (z2) {
                                        c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                                        c1737a.m6703a(packageInfo.applicationInfo.icon);
                                    }
                                    if (!arrayList2.contains(packageInfo.packageName)) {
                                        if (c1737a.m6720h()) {
                                            if (!!f.isEmpty()) {
                                            }
                                            if (obj != null) {
                                                c1737a.m6707a(true);
                                            } else {
                                                c1737a.m6707a(false);
                                            }
                                        } else {
                                            c1737a.m6707a(false);
                                        }
                                        for (C1737a i3 : f2) {
                                            if (i3.m6721i().equals(packageInfo.packageName)) {
                                                c1737a.m6707a(false);
                                            }
                                        }
                                        if (z3) {
                                        }
                                        arrayList2.add(packageInfo.packageName);
                                        this.f6207l.add(c1737a);
                                    } else if (z4) {
                                        indexOf = arrayList2.indexOf(packageInfo.packageName);
                                        if (c1737a.m6720h()) {
                                            c1737a2 = (C1737a) this.f6207l.get(indexOf);
                                            if (c1737a2.m6722j().equalsIgnoreCase(runningAppProcessInfo.processName)) {
                                                c1737a2.m6707a(true);
                                            }
                                        } else {
                                            ((C1737a) this.f6207l.get(indexOf)).m6707a(false);
                                        }
                                    }
                                }
                            }
                            if (c1741d2 != null) {
                                if (c1741d2.m6730a(packageInfo.packageName) == 1) {
                                }
                            }
                            c1737a = new C1737a();
                            c1737a.m6709b(i2);
                            c1737a.m6712b(z4);
                            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            }
                            c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                            c1737a.m6711b(packageInfo.packageName);
                            c1737a.m6714c(runningAppProcessInfo.processName);
                            c1737a.m6705a(context);
                            if (z2) {
                                c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                                c1737a.m6703a(packageInfo.applicationInfo.icon);
                            }
                            if (!arrayList2.contains(packageInfo.packageName)) {
                                if (c1737a.m6720h()) {
                                    c1737a.m6707a(false);
                                } else {
                                    if (!f.isEmpty()) {
                                    }
                                    if (obj != null) {
                                        c1737a.m6707a(false);
                                    } else {
                                        c1737a.m6707a(true);
                                    }
                                }
                                while (r3.hasNext()) {
                                    if (i3.m6721i().equals(packageInfo.packageName)) {
                                        c1737a.m6707a(false);
                                    }
                                }
                                if (z3) {
                                }
                                arrayList2.add(packageInfo.packageName);
                                this.f6207l.add(c1737a);
                            } else if (z4) {
                                indexOf = arrayList2.indexOf(packageInfo.packageName);
                                if (c1737a.m6720h()) {
                                    ((C1737a) this.f6207l.get(indexOf)).m6707a(false);
                                } else {
                                    c1737a2 = (C1737a) this.f6207l.get(indexOf);
                                    if (c1737a2.m6722j().equalsIgnoreCase(runningAppProcessInfo.processName)) {
                                        c1737a2.m6707a(true);
                                    }
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                size = this.f6207l.size();
                for (C1737a i32 : this.f6207l) {
                    for (UsageStats usageStats : r7) {
                        if (i32.m6721i() != null) {
                        }
                    }
                }
                if (c1741d2 != null) {
                    c1741d2.m6733b();
                }
                if (z2) {
                    Collections.sort(this.f6207l, C1743e.m6734a());
                }
                return size;
            }
        } catch (Exception e5) {
            c1741d = null;
            c1741d2 = c1741d;
            f = m6802f(context);
            arrayList = new ArrayList();
            while (r3.hasNext()) {
                arrayList.add(packageName.getPackageName());
            }
            list = null;
            i = C1762r.m6778i(context);
            m6804g(context);
            f2 = m6803f();
            for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                i2 = runningAppProcessInfo2.pid;
                packageInfo = packageManager.getPackageInfo(runningAppProcessInfo2.pkgList[0], 0);
                if (runningAppProcessInfo2.importance != Constants.COMMAND_HANDSHAKE) {
                }
                if (packageInfo.packageName.equals(context.getPackageName())) {
                    obj = null;
                    while (r17.hasNext()) {
                        if (equals.equals(packageInfo.packageName)) {
                            obj = 1;
                            break;
                            if (c1741d2 != null) {
                                if (c1741d2.m6730a(packageInfo.packageName) == 1) {
                                }
                            }
                            c1737a = new C1737a();
                            c1737a.m6709b(i2);
                            c1737a.m6712b(z4);
                            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            }
                            c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                            c1737a.m6711b(packageInfo.packageName);
                            c1737a.m6714c(runningAppProcessInfo2.processName);
                            c1737a.m6705a(context);
                            if (z2) {
                                c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                                c1737a.m6703a(packageInfo.applicationInfo.icon);
                            }
                            if (!arrayList2.contains(packageInfo.packageName)) {
                                if (c1737a.m6720h()) {
                                    if (!f.isEmpty()) {
                                    }
                                    if (obj != null) {
                                        c1737a.m6707a(true);
                                    } else {
                                        c1737a.m6707a(false);
                                    }
                                } else {
                                    c1737a.m6707a(false);
                                }
                                while (r3.hasNext()) {
                                    if (i32.m6721i().equals(packageInfo.packageName)) {
                                        c1737a.m6707a(false);
                                    }
                                }
                                if (z3) {
                                }
                                arrayList2.add(packageInfo.packageName);
                                this.f6207l.add(c1737a);
                            } else if (z4) {
                                indexOf = arrayList2.indexOf(packageInfo.packageName);
                                if (c1737a.m6720h()) {
                                    c1737a2 = (C1737a) this.f6207l.get(indexOf);
                                    if (c1737a2.m6722j().equalsIgnoreCase(runningAppProcessInfo2.processName)) {
                                        c1737a2.m6707a(true);
                                    }
                                } else {
                                    ((C1737a) this.f6207l.get(indexOf)).m6707a(false);
                                }
                            }
                        }
                    }
                    if (c1741d2 != null) {
                        if (c1741d2.m6730a(packageInfo.packageName) == 1) {
                        }
                    }
                    c1737a = new C1737a();
                    c1737a.m6709b(i2);
                    c1737a.m6712b(z4);
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    }
                    c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                    c1737a.m6711b(packageInfo.packageName);
                    c1737a.m6714c(runningAppProcessInfo2.processName);
                    c1737a.m6705a(context);
                    if (z2) {
                        c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                        c1737a.m6703a(packageInfo.applicationInfo.icon);
                    }
                    if (!arrayList2.contains(packageInfo.packageName)) {
                        if (c1737a.m6720h()) {
                            c1737a.m6707a(false);
                        } else {
                            if (!f.isEmpty()) {
                            }
                            if (obj != null) {
                                c1737a.m6707a(false);
                            } else {
                                c1737a.m6707a(true);
                            }
                        }
                        while (r3.hasNext()) {
                            if (i32.m6721i().equals(packageInfo.packageName)) {
                                c1737a.m6707a(false);
                            }
                        }
                        if (z3) {
                        }
                        arrayList2.add(packageInfo.packageName);
                        this.f6207l.add(c1737a);
                    } else if (z4) {
                        indexOf = arrayList2.indexOf(packageInfo.packageName);
                        if (c1737a.m6720h()) {
                            ((C1737a) this.f6207l.get(indexOf)).m6707a(false);
                        } else {
                            c1737a2 = (C1737a) this.f6207l.get(indexOf);
                            if (c1737a2.m6722j().equalsIgnoreCase(runningAppProcessInfo2.processName)) {
                                c1737a2.m6707a(true);
                            }
                        }
                    }
                }
            }
            size = this.f6207l.size();
            for (C1737a i322 : this.f6207l) {
                for (UsageStats usageStats2 : r7) {
                    if (i322.m6721i() != null) {
                    }
                }
            }
            if (c1741d2 != null) {
                c1741d2.m6733b();
            }
            if (z2) {
                Collections.sort(this.f6207l, C1743e.m6734a());
            }
            return size;
        }
        try {
            f = m6802f(context);
            arrayList = new ArrayList();
            try {
                while (r3.hasNext()) {
                    arrayList.add(packageName.getPackageName());
                }
            } catch (Exception e6) {
            }
            list = null;
            i = C1762r.m6778i(context);
            m6804g(context);
            f2 = m6803f();
            for (RunningAppProcessInfo runningAppProcessInfo22 : runningAppProcesses) {
                i2 = runningAppProcessInfo22.pid;
                packageInfo = packageManager.getPackageInfo(runningAppProcessInfo22.pkgList[0], 0);
                z4 = runningAppProcessInfo22.importance != Constants.COMMAND_HANDSHAKE || runningAppProcessInfo22.importance == SpdyProtocol.CDN || runningAppProcessInfo22.importance == 100;
                if (packageInfo.packageName.equals(context.getPackageName())) {
                    obj = null;
                    while (r17.hasNext()) {
                        if (equals.equals(packageInfo.packageName)) {
                            obj = 1;
                            break;
                        }
                    }
                    if (c1741d2 != null) {
                        if (c1741d2.m6730a(packageInfo.packageName) == 1) {
                        }
                    }
                    c1737a = new C1737a();
                    c1737a.m6709b(i2);
                    c1737a.m6712b(z4);
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    }
                    c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                    c1737a.m6711b(packageInfo.packageName);
                    c1737a.m6714c(runningAppProcessInfo22.processName);
                    c1737a.m6705a(context);
                    if (z2) {
                        c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                        c1737a.m6703a(packageInfo.applicationInfo.icon);
                    }
                    if (!arrayList2.contains(packageInfo.packageName)) {
                        if (c1737a.m6720h()) {
                            c1737a.m6707a(false);
                        } else if (!f.isEmpty() && f.equals(c1737a.m6721i())) {
                            c1737a.m6707a(false);
                        } else if (obj != null) {
                            c1737a.m6707a(false);
                        } else {
                            c1737a.m6707a(true);
                        }
                        while (r3.hasNext()) {
                            if (i322.m6721i().equals(packageInfo.packageName)) {
                                c1737a.m6707a(false);
                            }
                        }
                        if (z3) {
                            if (!c1737a.m6719g() && c1737a.m6717e()) {
                                if (!f.isEmpty() && f.equals(c1737a.m6721i())) {
                                }
                            }
                        }
                        arrayList2.add(packageInfo.packageName);
                        this.f6207l.add(c1737a);
                    } else if (z4) {
                        indexOf = arrayList2.indexOf(packageInfo.packageName);
                        if (c1737a.m6720h()) {
                            ((C1737a) this.f6207l.get(indexOf)).m6707a(false);
                        } else {
                            c1737a2 = (C1737a) this.f6207l.get(indexOf);
                            if (c1737a2.m6722j().equalsIgnoreCase(runningAppProcessInfo22.processName)) {
                                c1737a2.m6707a(true);
                            }
                        }
                    }
                }
            }
            size = this.f6207l.size();
            if (r7 != null && VERSION.SDK_INT >= 21) {
                for (C1737a i3222 : this.f6207l) {
                    for (UsageStats usageStats22 : r7) {
                        if (i3222.m6721i() != null && i3222.m6721i().equals(usageStats22.getPackageName())) {
                            i3222.m6704a(usageStats22.getLastTimeUsed());
                            break;
                        }
                    }
                }
            }
            if (c1741d2 != null) {
                c1741d2.m6733b();
            }
            if (z2) {
                Collections.sort(this.f6207l, C1743e.m6734a());
            }
            return size;
        } catch (Exception e7) {
            return 0;
        }
    }

    public Uri m6784a(String str, int i) {
        return Uri.parse("android.resource://" + str + "/" + i);
    }

    public void m6785a(Context context) {
        if (!this.f6206k) {
            this.f6202g = JNILIB.getKey(context, "14f8d53a6dee563e9bbf319c4aaac1f6e7e030201765f1b220b1dfe1e2825f51a530d8367");
            this.f6203h = JNILIB.getString("60c06d84788d08372e38077e7ef6707dc9eb2281e", this.f6202g);
            this.f6204i = JNILIB.getString("81afc962d0075e561de2603dd61d1794af858ce52", this.f6202g);
            m6796c(context);
            m6799d(context);
            m6792b(context);
            m6801e(context);
            this.f6206k = true;
        }
    }

    public void m6786a(Context context, View view) {
        if (!this.f6200e && VERSION.SDK_INT >= 16) {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.addFlags(268435456);
            context.startActivity(intent);
            m6793b(context, view);
        }
    }

    public void m6787a(Context context, C1071b c1071b, List<String> list, String str) {
        try {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(str), 0)) {
                try {
                    String str2 = resolveInfo.activityInfo.packageName;
                    if (list.contains(str2)) {
                        String flattenToString = new ComponentName(str2, resolveInfo.activityInfo.name).flattenToString();
                        C1073a.m4795a(c1071b, new C1054a(0, this.f6204i + " " + flattenToString));
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
    }

    public void m6788a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.addFlags(268435456);
            context.startActivity(launchIntentForPackage);
        } catch (Exception e) {
        }
    }

    public void m6789a(Context context, String str, String str2, boolean z) {
        try {
            C1741d c1741d = new C1741d(context);
            c1741d.m6731a();
            c1741d.m6732a(str, str2, z ? 1 : 0);
            c1741d.m6733b();
        } catch (Exception e) {
        }
    }

    public void m6790a(boolean z) {
        this.f6198c = z;
    }

    public boolean m6791a() {
        return this.f6197b;
    }

    public void m6792b(Context context) {
        try {
            InputStream open = context.getResources().getAssets().open("oemid", 3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            String readLine = bufferedReader.readLine();
            if (!(readLine == null || readLine.isEmpty())) {
                this.f6205j = readLine;
            }
            open.close();
            bufferedReader.close();
        } catch (Exception e) {
        }
    }

    public void m6793b(Context context, View view) {
        if (view != null) {
            Toast toast = new Toast(context);
            toast.setGravity(55, 0, 0);
            toast.setDuration(1);
            toast.setView(view);
            toast.show();
        }
    }

    public void m6794b(boolean z) {
        this.f6199d = z;
    }

    public boolean m6795b() {
        return this.f6198c;
    }

    public void m6796c(Context context) {
        this.f6209n.clear();
        try {
            new C1718a(context).m6664a(new C17611(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m6797c(boolean z) {
        this.f6200e = z;
        this.f6201f = false;
    }

    public boolean m6798c() {
        return this.f6199d;
    }

    public void m6799d(Context context) {
        if (this.f6202g.isEmpty()) {
            this.f6202g = JNILIB.getKey(context, "14f8d53a6dee563e9bbf319c4aaac1f6e7e030201765f1b220b1dfe1e2825f51a530d8367");
        }
        this.f6210o.clear();
        try {
            InputStream open = context.getResources().getAssets().open("intent_list", 3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    open.close();
                    bufferedReader.close();
                    return;
                } else if (!readLine.isEmpty()) {
                    try {
                        String str = new String(JNILIB.getBytes(readLine, this.f6202g), HttpRequest.f14548a);
                        if (!str.isEmpty()) {
                            this.f6210o.add(str);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public boolean m6800d() {
        return this.f6200e;
    }

    public void m6801e(Context context) {
        if (this.f6202g.isEmpty()) {
            this.f6202g = JNILIB.getKey(context, "14f8d53a6dee563e9bbf319c4aaac1f6e7e030201765f1b220b1dfe1e2825f51a530d8367");
        }
        this.f6211p.clear();
        try {
            InputStream open = context.getResources().getAssets().open("service_list", 3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    open.close();
                    bufferedReader.close();
                    return;
                } else if (!readLine.isEmpty()) {
                    try {
                        String str = new String(JNILIB.getBytes(readLine, this.f6202g), HttpRequest.f14548a);
                        if (!str.isEmpty()) {
                            this.f6211p.add(str);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public String m6802f(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (!(resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals(C0714a.ANDROID))) {
                return resolveActivity.activityInfo.packageName;
            }
        } catch (Exception e) {
        }
        return BuildConfig.FLAVOR;
    }

    public List<C1737a> m6803f() {
        return this.f6208m;
    }

    public int m6804g(Context context) {
        C1741d c1741d;
        C1741d c1741d2;
        List<C1737a> arrayList;
        PackageInfo packageInfo;
        C1737a c1737a;
        Object obj;
        int a;
        try {
            List<String> arrayList2 = new ArrayList();
            arrayList2.addAll(this.f6209n);
            PackageManager packageManager = context.getPackageManager();
            try {
                c1741d = new C1741d(context);
                try {
                    c1741d.m6731a();
                    c1741d2 = c1741d;
                } catch (Exception e) {
                    c1741d2 = c1741d;
                    arrayList = new ArrayList();
                    arrayList.addAll(this.f6208m);
                    this.f6208m.clear();
                    for (String packageInfo2 : arrayList2) {
                        try {
                            packageInfo = packageManager.getPackageInfo(packageInfo2, 0);
                            c1737a = new C1737a();
                            for (C1737a c1737a2 : arrayList) {
                                if (c1737a2.m6721i().equals(packageInfo.packageName)) {
                                    c1737a.m6715c(c1737a2.m6720h());
                                    c1737a.m6711b(c1737a2.m6721i());
                                    c1737a.m6706a(c1737a2.m6718f());
                                    c1737a.m6703a(c1737a2.m6713c());
                                    obj = 1;
                                    break;
                                    if (obj == null) {
                                        try {
                                            c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                                            c1737a.m6711b(packageInfo.packageName);
                                            c1737a.m6703a(packageInfo.applicationInfo.icon);
                                            c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                                        } catch (Exception e2) {
                                        }
                                    }
                                    if (c1741d2 != null) {
                                        try {
                                            a = c1741d2.m6730a(c1737a.m6721i());
                                            if (a == 1) {
                                                c1737a.m6707a(true);
                                            } else if (a == 0) {
                                                c1737a.m6707a(false);
                                            }
                                        } catch (Exception e3) {
                                        }
                                    }
                                    this.f6208m.add(c1737a);
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                                }
                                c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                                c1737a.m6711b(packageInfo.packageName);
                                c1737a.m6703a(packageInfo.applicationInfo.icon);
                                c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                            }
                            if (c1741d2 != null) {
                                a = c1741d2.m6730a(c1737a.m6721i());
                                if (a == 1) {
                                    c1737a.m6707a(true);
                                } else if (a == 0) {
                                    c1737a.m6707a(false);
                                }
                            }
                            this.f6208m.add(c1737a);
                        } catch (Exception e4) {
                        }
                    }
                    a = this.f6208m.size();
                    if (c1741d2 != null) {
                        return a;
                    }
                    try {
                        c1741d2.m6733b();
                        return a;
                    } catch (Exception e5) {
                        return a;
                    }
                }
            } catch (Exception e6) {
                c1741d = null;
                c1741d2 = c1741d;
                arrayList = new ArrayList();
                arrayList.addAll(this.f6208m);
                this.f6208m.clear();
                while (r4.hasNext()) {
                    packageInfo = packageManager.getPackageInfo(packageInfo2, 0);
                    c1737a = new C1737a();
                    for (C1737a c1737a22 : arrayList) {
                        if (c1737a22.m6721i().equals(packageInfo.packageName)) {
                            c1737a.m6715c(c1737a22.m6720h());
                            c1737a.m6711b(c1737a22.m6721i());
                            c1737a.m6706a(c1737a22.m6718f());
                            c1737a.m6703a(c1737a22.m6713c());
                            obj = 1;
                            break;
                            if (obj == null) {
                                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                                }
                                c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                                c1737a.m6711b(packageInfo.packageName);
                                c1737a.m6703a(packageInfo.applicationInfo.icon);
                                c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                            }
                            if (c1741d2 != null) {
                                a = c1741d2.m6730a(c1737a.m6721i());
                                if (a == 1) {
                                    c1737a.m6707a(true);
                                } else if (a == 0) {
                                    c1737a.m6707a(false);
                                }
                            }
                            this.f6208m.add(c1737a);
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        }
                        c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                        c1737a.m6711b(packageInfo.packageName);
                        c1737a.m6703a(packageInfo.applicationInfo.icon);
                        c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    }
                    if (c1741d2 != null) {
                        a = c1741d2.m6730a(c1737a.m6721i());
                        if (a == 1) {
                            c1737a.m6707a(true);
                        } else if (a == 0) {
                            c1737a.m6707a(false);
                        }
                    }
                    this.f6208m.add(c1737a);
                }
                a = this.f6208m.size();
                if (c1741d2 != null) {
                    return a;
                }
                c1741d2.m6733b();
                return a;
            }
            arrayList = new ArrayList();
            arrayList.addAll(this.f6208m);
            this.f6208m.clear();
            while (r4.hasNext()) {
                packageInfo = packageManager.getPackageInfo(packageInfo2, 0);
                c1737a = new C1737a();
                for (C1737a c1737a222 : arrayList) {
                    if (c1737a222.m6721i().equals(packageInfo.packageName)) {
                        c1737a.m6715c(c1737a222.m6720h());
                        c1737a.m6711b(c1737a222.m6721i());
                        c1737a.m6706a(c1737a222.m6718f());
                        c1737a.m6703a(c1737a222.m6713c());
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    }
                    c1737a.m6715c((packageInfo.applicationInfo.flags & 1) == 0);
                    c1737a.m6711b(packageInfo.packageName);
                    c1737a.m6703a(packageInfo.applicationInfo.icon);
                    c1737a.m6706a(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                }
                if (c1741d2 != null) {
                    a = c1741d2.m6730a(c1737a.m6721i());
                    if (a == 1) {
                        c1737a.m6707a(true);
                    } else if (a == 0) {
                        c1737a.m6707a(false);
                    }
                }
                this.f6208m.add(c1737a);
            }
            a = this.f6208m.size();
            if (c1741d2 != null) {
                return a;
            }
            c1741d2.m6733b();
            return a;
        } catch (Exception e7) {
            return 0;
        }
    }

    public List<C1737a> m6805g() {
        return this.f6207l;
    }

    public String m6806h() {
        return this.f6205j;
    }

    public void m6807i() {
        if (C1073a.m4797b()) {
            this.f6197b = C1073a.m4796a();
        }
    }

    public C1737a m6808j() {
        try {
            for (C1737a c1737a : this.f6208m) {
                if (c1737a.m6717e()) {
                    return c1737a;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String m6809k() {
        String str = BuildConfig.FLAVOR;
        try {
            for (C1737a c1737a : this.f6208m) {
                if (c1737a.m6717e()) {
                    return c1737a.m6721i();
                }
            }
        } catch (Exception e) {
        }
        return str;
    }

    public boolean m6810l() {
        return this.f6201f;
    }

    public void m6811m() {
        this.f6201f = true;
    }
}
