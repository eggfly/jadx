package com.baidu.mobads.p080j;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.p088c.C2014d;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.j.g */
public class C1986g {
    protected final long f6933a;
    private Context f6934b;

    /* renamed from: com.baidu.mobads.j.g.a */
    class C1985a implements Observer {
        final /* synthetic */ C1986g f6930a;
        private final Handler f6931b;
        private final String f6932c;

        public C1985a(C1986g c1986g, Handler handler, String str) {
            this.f6930a = c1986g;
            this.f6931b = handler;
            this.f6932c = str;
        }

        public void update(Observable observable, Object obj) {
            IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
            if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
                this.f6930a.m7425a(this.f6931b, iOAdDownloader.getOutputPath());
                this.f6930a.m7428a(this.f6932c);
            }
            if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
                this.f6930a.m7423a(this.f6931b);
                this.f6930a.m7428a(this.f6932c);
            }
        }
    }

    public C1986g(Context context) {
        this.f6933a = 604800000;
        this.f6934b = context;
    }

    private void m7423a(Handler handler) {
        m7424a(handler, Boolean.valueOf(false), null);
    }

    private void m7424a(Handler handler, Boolean bool, String str) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_result", bool.booleanValue());
            bundle.putString("local_creative_url", str);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Throwable e) {
            C1989j.m7430a().m7435d(e);
        }
    }

    private void m7425a(Handler handler, String str) {
        m7424a(handler, Boolean.valueOf(true), str);
    }

    public void m7428a(String str) {
        new Thread(new C1987h(this, str)).start();
    }

    public void m7429a(String str, String str2, String str3, Handler handler) {
        File file = new File(str2 + str3);
        if (file.exists()) {
            m7425a(handler, file.getAbsolutePath());
            return;
        }
        try {
            IOAdDownloader createSimpleFileDownloader = C2014d.m7517a(this.f6934b).createSimpleFileDownloader(new URL(str), str2, str3, false);
            createSimpleFileDownloader.addObserver(new C1985a(this, handler, str2));
            createSimpleFileDownloader.start();
        } catch (MalformedURLException e) {
            m7423a(handler);
        }
    }
}
