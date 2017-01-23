package com.baidu.mobads.p093h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p080j.C1991m;
import com.taobao.accs.common.Constants;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.h.o */
public class C1969o implements Observer {
    private Context f6854a;
    private URL f6855b;
    private String f6856c;
    private final C1955e f6857d;
    private C1953a f6858e;
    private SharedPreferences f6859f;
    private OnSharedPreferenceChangeListener f6860g;

    /* renamed from: com.baidu.mobads.h.o.a */
    public interface C1953a {
        void m7307a(C1955e c1955e);

        void m7308b(C1955e c1955e);
    }

    public C1969o(Context context, String str, C1955e c1955e, C1953a c1953a) {
        this.f6855b = null;
        this.f6856c = null;
        this.f6860g = new C1970p(this);
        this.f6856c = str;
        this.f6857d = c1955e;
        m7358a(context, c1953a);
    }

    public C1969o(Context context, URL url, C1955e c1955e, C1953a c1953a) {
        this.f6855b = null;
        this.f6856c = null;
        this.f6860g = new C1970p(this);
        this.f6855b = url;
        this.f6857d = c1955e;
        m7358a(context, c1953a);
    }

    private void m7358a(Context context, C1953a c1953a) {
        this.f6854a = context;
        this.f6858e = c1953a;
        this.f6859f = this.f6854a.getSharedPreferences("__xadsdk_downloaded__version__", 0);
        this.f6859f.registerOnSharedPreferenceChangeListener(this.f6860g);
    }

    public void m7359a(String str, String str2) {
        IOAdDownloader createSimpleFileDownloader = C1991m.m7449a().m7453b(this.f6854a).createSimpleFileDownloader(this.f6856c != null ? new URL(this.f6856c) : this.f6855b, str, str2, false);
        createSimpleFileDownloader.addObserver(this);
        createSimpleFileDownloader.start();
        Editor edit = this.f6859f.edit();
        edit.putString(Constants.SP_KEY_VERSION, this.f6857d.toString());
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
            this.f6858e.m7307a(new C1955e(this.f6857d, iOAdDownloader.getOutputPath(), Boolean.valueOf(true)));
        }
        if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
            this.f6858e.m7308b(new C1955e(this.f6857d, iOAdDownloader.getOutputPath(), Boolean.valueOf(false)));
        }
    }
}
