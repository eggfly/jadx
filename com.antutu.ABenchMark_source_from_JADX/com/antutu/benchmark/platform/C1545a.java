package com.antutu.benchmark.platform;

import android.content.Context;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.jni;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.platform.a */
public class C1545a {
    private static C1545a f5380a;
    private String f5381b;
    private List<C1543a> f5382c;
    private List<C1543a> f5383d;

    /* renamed from: com.antutu.benchmark.platform.a.1 */
    class C15401 extends Thread {
        final /* synthetic */ C1545a f5366a;

        C15401(C1545a c1545a) {
            this.f5366a = c1545a;
        }

        public void run() {
            super.run();
            try {
                String httpGet = Methods.httpGet("http://autovote.antutu.net/proMoudule/index.php?action=getmore&act=android1&data=1");
                if (httpGet.length() > 20) {
                    Methods.writeToFile(httpGet.getBytes(), this.f5366a.f5381b);
                    httpGet = jni.getStringSafe(httpGet, BuildConfig.FLAVOR);
                    if (httpGet != null && httpGet.length() > 10) {
                        this.f5366a.m6121a(httpGet);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.platform.a.2 */
    static class C15412 extends Thread {
        C15412() {
        }

        public void run() {
            super.run();
            try {
                Methods.httpGet("http://certtime.antutu.net/test_time.html");
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.platform.a.3 */
    class C15423 extends Thread {
        final /* synthetic */ C1545a f5367a;

        C15423(C1545a c1545a) {
            this.f5367a = c1545a;
        }

        public void run() {
            super.run();
            try {
                String httpGet = Methods.httpGet("http://autovote.antutu.net/proMoudule/index.php?action=getmore&act=android2&data=1");
                if (httpGet.length() > 20) {
                    Methods.writeToFile(httpGet.getBytes(), this.f5367a.f5381b);
                    httpGet = jni.getStringSafe(httpGet, BuildConfig.FLAVOR);
                    if (httpGet != null && httpGet.length() > 10) {
                        this.f5367a.m6125b(httpGet);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.platform.a.a */
    private class C1543a {
        public String f5368a;
        public String f5369b;
        public String f5370c;
        public String f5371d;
        public String f5372e;
        public String f5373f;
        public String f5374g;
        public String f5375h;
        final /* synthetic */ C1545a f5376i;

        private C1543a(C1545a c1545a) {
            this.f5376i = c1545a;
            this.f5368a = BuildConfig.FLAVOR;
            this.f5369b = BuildConfig.FLAVOR;
            this.f5370c = BuildConfig.FLAVOR;
            this.f5371d = BuildConfig.FLAVOR;
            this.f5372e = BuildConfig.FLAVOR;
            this.f5373f = BuildConfig.FLAVOR;
            this.f5374g = BuildConfig.FLAVOR;
            this.f5375h = BuildConfig.FLAVOR;
        }

        private boolean m6103a(String str) {
            try {
                if (str.equals(this.f5369b)) {
                    return true;
                }
                if (this.f5369b.equals("*") && !str.isEmpty()) {
                    return true;
                }
                return false;
            } catch (Exception e) {
            }
        }

        private boolean m6104b(String str) {
            try {
                if (str.equals(this.f5368a)) {
                    return true;
                }
                if (this.f5368a.equals("*") && !str.isEmpty()) {
                    return true;
                }
                return false;
            } catch (Exception e) {
            }
        }

        private boolean m6105c(String str) {
            try {
                if (str.equals(this.f5370c) || str.equals(this.f5371d) || this.f5370c.equals("*")) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        private boolean m6106d(String str) {
            try {
                if (str.equals(this.f5372e) || this.f5372e.equals("*")) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        private boolean m6107e(String str) {
            try {
                if (str.contains(this.f5374g) || this.f5374g.equals("*")) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        private boolean m6108f(String str) {
            try {
                if (str.contains(this.f5373f) || this.f5373f.equals("*")) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        private boolean m6109g(String str) {
            try {
                if (str.contains(this.f5375h) || this.f5375h.equals("*")) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        public boolean m6110a(String str, String str2) {
            try {
                if (m6104b(str) && m6103a(str2)) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        public boolean m6111a(String str, String str2, String str3, String str4) {
            try {
                if (m6104b(str) && m6103a(str2) && m6105c(str3) && m6106d(str4)) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        public boolean m6112a(String str, String str2, String str3, String str4, String str5) {
            try {
                if (m6104b(str) && m6103a(str2) && m6108f(str3) && m6107e(str4) && m6109g(str5)) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }
    }

    static {
        f5380a = null;
    }

    public C1545a() {
        this.f5381b = BuildConfig.FLAVOR;
        this.f5382c = new ArrayList();
        this.f5383d = new ArrayList();
    }

    public static C1545a m6117a() {
        if (f5380a == null) {
            f5380a = new C1545a();
        }
        return f5380a;
    }

    public static void m6119b(Context context) {
        try {
            if (Methods.isWifi(ABenchmarkApplication.getContext()) == 1) {
                new C15412().start();
                String httpGet = Methods.httpGet("http://autovote.antutu.net/antuapi.php?m=more&c=prevent&a=theseed");
                if (httpGet.length() > 10) {
                    Methods.writeToFile(httpGet.getBytes(), context.getFilesDir().getAbsolutePath() + "/test_683data_v2.gz");
                }
            }
        } catch (Exception e) {
        }
    }

    public void m6120a(Context context) {
        try {
            this.f5381b = context.getFilesDir().getAbsolutePath() + "/" + "73ksdnf_data.gz";
            Object obj = null;
            if (new File(this.f5381b).isFile()) {
                String convertStreamToString = Methods.convertStreamToString(new FileInputStream(this.f5381b));
                if (convertStreamToString.length() > 20) {
                    convertStreamToString = jni.getStringSafe(convertStreamToString, BuildConfig.FLAVOR);
                    if (convertStreamToString != null && convertStreamToString.length() > 10) {
                        m6121a(convertStreamToString);
                        if (this.f5382c.size() > 0) {
                            obj = 1;
                        }
                    }
                }
            }
            if (obj == null) {
                String convertStreamToString2 = Methods.convertStreamToString(context.getAssets().open("devices.json"));
                if (convertStreamToString2 != null) {
                    m6121a(convertStreamToString2);
                }
            }
        } catch (Exception e) {
        }
        if (Methods.isWifi(ABenchmarkApplication.getContext()) == 1) {
            new C15401(this).start();
        }
        m6126c(context);
    }

    public void m6121a(String str) {
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    C1543a c1543a = new C1543a();
                    c1543a.f5369b = jSONObject.getString(Constants.KEY_MODEL);
                    c1543a.f5368a = jSONObject.getString(Constants.KEY_BRAND);
                    c1543a.f5372e = jSONObject.getString("cpuHard");
                    c1543a.f5370c = jSONObject.getString("cpuid");
                    c1543a.f5371d = jSONObject.getString("cpuid2");
                    if (c1543a.f5370c == null) {
                        c1543a.f5370c = BuildConfig.FLAVOR;
                    }
                    if (c1543a.f5371d == null) {
                        c1543a.f5371d = BuildConfig.FLAVOR;
                    }
                    if (c1543a.f5372e == null) {
                        c1543a.f5372e = BuildConfig.FLAVOR;
                    }
                    if (!(c1543a.f5369b == null || c1543a.f5368a == null || c1543a.f5369b.isEmpty() || c1543a.f5368a.isEmpty())) {
                        arrayList.add(c1543a);
                        MLog.m6871i("device", c1543a.f5369b + C4233j.f14398u + c1543a.f5368a + C4233j.f14398u + c1543a.f5370c + C4233j.f14398u + c1543a.f5371d + C4233j.f14398u + c1543a.f5372e);
                    }
                } catch (Exception e) {
                }
            }
            if (arrayList.size() > 0) {
                this.f5382c = arrayList;
            }
        } catch (Exception e2) {
        }
    }

    public boolean m6122a(String str, String str2) {
        for (C1543a a : this.f5382c) {
            if (a.m6110a(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m6123a(String str, String str2, String str3, String str4) {
        for (C1543a a : this.f5382c) {
            if (a.m6111a(str, str2, str3, str4)) {
                return true;
            }
        }
        return false;
    }

    public boolean m6124a(String str, String str2, String str3, String str4, String str5) {
        String toUpperCase = str3.toUpperCase();
        String toUpperCase2 = str4.toUpperCase();
        String toUpperCase3 = str5.toUpperCase();
        for (C1543a a : this.f5383d) {
            if (a.m6112a(str, str2, toUpperCase, toUpperCase2, toUpperCase3)) {
                return true;
            }
        }
        return false;
    }

    public void m6125b(String str) {
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    C1543a c1543a = new C1543a();
                    c1543a.f5369b = jSONObject.getString(Constants.KEY_MODEL);
                    c1543a.f5368a = jSONObject.getString(Constants.KEY_BRAND);
                    c1543a.f5374g = jSONObject.getString("gpuRender");
                    c1543a.f5373f = jSONObject.getString("gpuVendor");
                    c1543a.f5375h = jSONObject.getString("glVersion");
                    if (c1543a.f5374g == null) {
                        c1543a.f5374g = BuildConfig.FLAVOR;
                    }
                    if (c1543a.f5373f == null) {
                        c1543a.f5373f = BuildConfig.FLAVOR;
                    }
                    if (c1543a.f5375h == null) {
                        c1543a.f5375h = BuildConfig.FLAVOR;
                    }
                    c1543a.f5373f = c1543a.f5373f.toUpperCase();
                    c1543a.f5374g = c1543a.f5374g.toUpperCase();
                    c1543a.f5375h = c1543a.f5375h.toUpperCase();
                    if (!(c1543a.f5369b == null || c1543a.f5368a == null || c1543a.f5369b.isEmpty() || c1543a.f5368a.isEmpty())) {
                        arrayList.add(c1543a);
                        MLog.m6871i("device2", c1543a.f5369b + C4233j.f14398u + c1543a.f5368a + C4233j.f14398u + c1543a.f5373f + C4233j.f14398u + c1543a.f5374g + C4233j.f14398u + c1543a.f5375h);
                    }
                } catch (Exception e) {
                }
            }
            if (arrayList.size() > 0) {
                this.f5383d = arrayList;
            }
        } catch (Exception e2) {
        }
    }

    public void m6126c(Context context) {
        try {
            this.f5381b = context.getFilesDir().getAbsolutePath() + "/" + "se375sn_data.gz";
            Object obj = null;
            if (new File(this.f5381b).isFile()) {
                String convertStreamToString = Methods.convertStreamToString(new FileInputStream(this.f5381b));
                if (convertStreamToString.length() > 20) {
                    convertStreamToString = jni.getStringSafe(convertStreamToString, BuildConfig.FLAVOR);
                    if (convertStreamToString != null && convertStreamToString.length() > 10) {
                        m6125b(convertStreamToString);
                        if (this.f5383d.size() > 0) {
                            obj = 1;
                        }
                    }
                }
            }
            if (obj == null) {
                String convertStreamToString2 = Methods.convertStreamToString(context.getAssets().open("devices2.json"));
                if (convertStreamToString2 != null) {
                    m6125b(convertStreamToString2);
                }
            }
        } catch (Exception e) {
        }
        if (Methods.isWifi(ABenchmarkApplication.getContext()) == 1) {
            new C15423(this).start();
        }
    }
}
