package com.baidu.mobads.command;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p080j.C1991m;
import com.igexin.download.Downloads;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.command.a */
public class C1924a implements Serializable {
    private boolean f6729A;
    public String f6730a;
    public String f6731b;
    public String f6732c;
    public long f6733d;
    public int f6734e;
    public int f6735f;
    public DownloadStatus f6736g;
    public Object f6737h;
    public String f6738i;
    public String f6739j;
    public String f6740k;
    public boolean f6741l;
    public String f6742m;
    public String f6743n;
    public String f6744o;
    public String f6745p;
    public int f6746q;
    public boolean f6747r;
    public long f6748s;
    protected long f6749t;
    protected long f6750u;
    public boolean f6751v;
    public String f6752w;
    protected final IXAdLogger f6753x;
    private long f6754y;
    private long f6755z;

    public C1924a(String str, String str2) {
        this.f6733d = -1;
        this.f6734e = 0;
        this.f6736g = DownloadStatus.NONE;
        this.f6737h = null;
        this.f6746q = 0;
        this.f6747r = false;
        this.f6751v = false;
        this.f6752w = null;
        this.f6753x = C1991m.m7449a().m7457f();
        this.f6738i = str;
        this.f6730a = str2;
    }

    public static C1924a m7246a(Context context, String str) {
        Throwable th;
        C1924a c1924a = null;
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            return null;
        }
        try {
            String string = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getString(str + "#$#" + C1924a.m7248b(), null);
            if (string == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.getString(Downloads.COLUMN_TITLE);
            String optString = jSONObject.optString("url", jSONObject.getString("turl"));
            C1924a c1924a2 = new C1924a(str, string2);
            try {
                c1924a2.m7253a(jSONObject.optString("qk"), jSONObject.optString("adid"), optString, jSONObject.optBoolean("autoOpen"));
                c1924a2.m7252a(jSONObject.getString("filename"), jSONObject.getString("folder"));
                c1924a2.m7256b(jSONObject.optString("placeId"), jSONObject.optString("prod"));
                int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                DownloadStatus[] values = DownloadStatus.values();
                DownloadStatus downloadStatus = DownloadStatus.NONE;
                for (int i2 = 0; i2 < values.length; i2++) {
                    if (values[i2].getCode() == i) {
                        downloadStatus = values[i2];
                    }
                }
                c1924a2.f6736g = downloadStatus;
                c1924a2.f6747r = jSONObject.optBoolean("mnCfm");
                c1924a2.f6746q = jSONObject.getInt("dlCnt");
                c1924a2.f6748s = jSONObject.optLong("cts");
                c1924a2.f6749t = jSONObject.optLong(MsgConstant.KEY_TS);
                c1924a2.f6750u = (long) jSONObject.optInt("clickProcId");
                return c1924a2;
            } catch (Throwable e) {
                Throwable th2 = e;
                c1924a = c1924a2;
                th = th2;
                C1991m.m7449a().m7457f().m7395d(th);
                return c1924a;
            }
        } catch (Exception e2) {
            th = e2;
            C1991m.m7449a().m7457f().m7395d(th);
            return c1924a;
        }
    }

    public static List<String> m7247a(Context context, long j) {
        List<String> arrayList = new ArrayList();
        try {
            for (Entry entry : context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getAll().entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    if (str.contains("#$#" + C1924a.m7248b())) {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (jSONObject.getLong("cts") >= j) {
                            int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                            if (i == 0 || i == 1 || i == 4) {
                                arrayList.add(str.substring(0, str.indexOf("#$#")));
                            }
                        }
                    }
                } catch (Exception e) {
                    C1991m.m7449a().m7457f().m7393d("XAdDownloaderManager", e.getMessage());
                }
            }
        } catch (Throwable e2) {
            C1991m.m7449a().m7457f().m7395d(e2);
        }
        return arrayList;
    }

    public static String m7248b() {
        return C1991m.m7449a().m7465n().getCurrentProcessName(C1991m.m7449a().m7455d());
    }

    public JSONObject m7249a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, this.f6736g.getCode());
            jSONObject.put("filename", this.f6731b);
            jSONObject.put("folder", this.f6732c);
            jSONObject.put(Downloads.COLUMN_TITLE, this.f6730a);
            jSONObject.put("contentLength", this.f6733d);
            jSONObject.put(IXAdRequestInfo.PACKAGE, this.f6738i);
            jSONObject.put("qk", this.f6742m);
            jSONObject.put("autoOpen", this.f6741l);
            jSONObject.put("adid", this.f6743n);
            jSONObject.put("placeId", this.f6744o);
            jSONObject.put("prod", this.f6745p);
            jSONObject.put("dlTunnel", 4);
            if (this.f6740k == null || this.f6740k.length() <= 0) {
                jSONObject.put("url", this.f6739j);
            } else {
                jSONObject.put("turl", this.f6740k);
            }
            jSONObject.put("mnCfm", this.f6747r);
            jSONObject.put("dlCnt", this.f6746q);
            jSONObject.put("cts", this.f6748s);
            if (this.f6746q == 1) {
                this.f6749t = System.currentTimeMillis();
                this.f6750u = (long) Process.myPid();
            }
            jSONObject.put(MsgConstant.KEY_TS, this.f6749t);
            jSONObject.put("clickProcId", this.f6750u);
        } catch (Throwable e) {
            this.f6753x.m7395d(e);
        }
        return jSONObject;
    }

    public void m7250a(long j) {
        this.f6754y = j;
    }

    public void m7251a(Context context) {
        if (this.f6738i != null && !BuildConfig.FLAVOR.equals(this.f6738i)) {
            try {
                Editor edit = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).edit();
                edit.putString(this.f6738i + "#$#" + C1924a.m7248b(), m7249a().toString());
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Throwable e) {
                C1991m.m7449a().m7457f().m7394d("XAdAPKDownloadExtraInfo", e);
            }
        }
    }

    public void m7252a(String str, String str2) {
        this.f6731b = str;
        this.f6732c = str2;
    }

    public void m7253a(String str, String str2, String str3, boolean z) {
        this.f6742m = str;
        this.f6743n = str2;
        this.f6739j = str3;
        this.f6741l = z;
    }

    public void m7254a(boolean z) {
        this.f6729A = z;
    }

    public void m7255b(long j) {
        this.f6755z = j;
    }

    public void m7256b(String str, String str2) {
        this.f6744o = str;
        this.f6745p = str2;
    }

    public long m7257c() {
        return this.f6754y;
    }

    public String m7258d() {
        return this.f6738i;
    }

    public long m7259e() {
        return this.f6755z;
    }

    public boolean m7260f() {
        return this.f6729A;
    }
}
