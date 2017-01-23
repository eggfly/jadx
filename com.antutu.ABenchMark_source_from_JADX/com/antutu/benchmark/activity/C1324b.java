package com.antutu.benchmark.activity;

import android.app.ActivityManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.ViewGroup.LayoutParams;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p047k.C1515a;
import com.antutu.benchmark.p047k.C1516b;

/* renamed from: com.antutu.benchmark.activity.b */
public class C1324b extends C1197a {
    private GLSurfaceView f4518a;

    /* renamed from: com.antutu.benchmark.activity.b.a */
    class C1323a implements Runnable {
        final /* synthetic */ C1324b f4517a;

        C1323a(C1324b c1324b) {
            this.f4517a = c1324b;
        }

        public void run() {
            this.f4517a.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f4518a = new GLSurfaceView(this);
            if (((ActivityManager) getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION) {
                this.f4518a.setEGLContextClientVersion(2);
                C1516b.m6012a(true);
            } else {
                C1516b.m6012a(false);
            }
            this.f4518a.setRenderer(new C1515a(this));
            this.f4518a.setRenderMode(0);
            this.f4518a.setLayoutParams(new LayoutParams(1, 1));
            addContentView(this.f4518a, new LayoutParams(1, 1));
        } catch (Exception e) {
        }
        new Handler().postDelayed(new C1323a(this), 300);
    }

    protected void onPause() {
        super.onPause();
        this.f4518a.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f4518a.onResume();
    }
}
