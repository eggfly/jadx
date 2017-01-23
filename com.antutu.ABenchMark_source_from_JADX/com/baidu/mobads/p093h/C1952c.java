package com.baidu.mobads.p093h;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p093h.C1960g.C1957a;
import com.baidu.mobads.p093h.C1969o.C1953a;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* renamed from: com.baidu.mobads.h.c */
public class C1952c extends Thread {
    private static volatile C1952c f6812f;
    C1953a f6813a;
    private volatile String f6814b;
    private String f6815c;
    private double f6816d;
    private Handler f6817e;
    private final Context f6818g;
    private C1969o f6819h;
    private final C1955e f6820i;
    private IXAdLogger f6821j;

    private C1952c(Context context, C1955e c1955e, String str, Handler handler) {
        this.f6815c = null;
        this.f6819h = null;
        this.f6821j = C1991m.m7449a().m7457f();
        this.f6813a = new C1954d(this);
        this.f6818g = context;
        this.f6820i = c1955e;
        m7306a(c1955e.m7313c());
        this.f6817e = handler;
        this.f6815c = str;
    }

    public static C1952c m7300a(Context context, C1955e c1955e, String str, Handler handler) {
        if (f6812f == null) {
            f6812f = new C1952c(context, c1955e, str, handler);
        }
        return f6812f;
    }

    private String m7302a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f6815c + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f6819h.m7359a(this.f6815c, str);
            return str2;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    private void m7304a(String str, C1955e c1955e, String str2) {
        if (str.equals("OK") || str.equals("ERROR")) {
            Message obtainMessage = this.f6817e.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APK_INFO", c1955e);
            bundle.putString("CODE", str);
            obtainMessage.setData(bundle);
            this.f6817e.sendMessage(obtainMessage);
        }
    }

    private boolean m7305b() {
        try {
            this.f6819h = new C1969o(this.f6818g, new URL(this.f6814b), this.f6820i, this.f6813a);
        } catch (MalformedURLException e) {
            try {
                this.f6819h = new C1969o(this.f6818g, this.f6814b, this.f6820i, this.f6813a);
            } catch (Exception e2) {
                this.f6821j.m7400e("XAdApkDownloadThread", "parse apk failed, error:" + e2.toString());
                throw new C1957a("parse apk failed, error:" + e2.toString());
            }
        }
        double d = C1960g.f6833c != null ? C1960g.f6833c.f6800a : C1960g.f6832b != null ? C1960g.f6832b.f6800a > 0.0d ? C1960g.f6832b.f6800a : C1960g.f6832b.f6800a : 0.0d;
        this.f6821j.m7393d("XAdApkDownloadThread", "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.f6820i.m7312b());
        if (d > 0.0d) {
            if (this.f6820i.m7312b() > 0.0d) {
                this.f6821j.m7400e("XAdApkDownloadThread", "remote not null, local apk version is null, force upgrade");
                this.f6816d = this.f6820i.m7312b();
                return true;
            }
            this.f6821j.m7400e("XAdApkDownloadThread", "remote is null, local apk version is null, do not upgrade");
            return false;
        } else if (this.f6820i.m7312b() <= 0.0d) {
            this.f6821j.m7400e("XAdApkDownloadThread", "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
            return false;
        } else if (this.f6820i.m7312b() <= d) {
            return false;
        } else {
            this.f6816d = this.f6820i.m7312b();
            return true;
        }
    }

    public void m7306a(String str) {
        this.f6814b = str;
        interrupt();
    }

    public void run() {
        try {
            if (m7305b()) {
                m7302a();
                this.f6821j.m7393d("XAdApkDownloadThread", "download apk successfully, downloader exit");
                f6812f = null;
                this.f6821j.m7393d("XAdApkDownloadThread", "no newer apk, downloader exit");
                f6812f = null;
            }
        } catch (IOException e) {
            this.f6821j.m7400e("XAdApkDownloadThread", "create File or HTTP Get failed, exception: " + e.getMessage());
        } catch (Throwable th) {
        }
    }
}
