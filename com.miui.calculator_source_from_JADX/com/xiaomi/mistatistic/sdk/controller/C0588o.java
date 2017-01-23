package com.xiaomi.mistatistic.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.data.C0600a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.o */
public class C0588o {
    private static C0588o f4786d;
    private long f4787a;
    private boolean f4788b;
    private C0587a f4789c;
    private Handler f4790e;
    private boolean f4791f;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.o.1 */
    class C05851 extends Handler {
        final /* synthetic */ C0588o f4781a;

        C05851(C0588o c0588o, Looper looper) {
            this.f4781a = c0588o;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    if (this.f4781a.m6504h()) {
                        C0566h.m6414a("handle shaking....");
                        this.f4781a.m6495c(this.f4781a.f4789c.m6488a());
                        this.f4781a.m6503g();
                    }
                default:
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.o.2 */
    class C05862 implements C0523a {
        final /* synthetic */ Activity f4782a;
        final /* synthetic */ C0588o f4783b;

        C05862(C0588o c0588o, Activity activity) {
            this.f4783b = c0588o;
            this.f4782a = activity;
        }

        public void m6487a() {
            int i = 0;
            try {
                int i2;
                File b = this.f4783b.m6497b(this.f4782a);
                JSONObject jSONObject = new JSONObject();
                DisplayMetrics displayMetrics = C0551c.m6352a().getResources().getDisplayMetrics();
                if (displayMetrics != null) {
                    i2 = displayMetrics.widthPixels;
                    i = displayMetrics.heightPixels;
                } else {
                    i2 = 0;
                }
                jSONObject.put("height", Integer.toString(i));
                jSONObject.put("width", Integer.toString(i2));
                C0598r c0598r = new C0598r();
                c0598r.m6539a(this.f4782a);
                List<C0600a> a = c0598r.m6538a();
                JSONArray jSONArray = new JSONArray();
                for (C0600a a2 : a) {
                    jSONArray.put(a2.m6553a());
                }
                jSONObject.put("clickable_views", jSONArray);
                Map hashMap = new HashMap();
                hashMap.put("appId", C0551c.m6354b());
                hashMap.put("appKey", C0551c.m6355c());
                hashMap.put("deviceId", new C0557e().m6372a());
                hashMap.put("meta", jSONObject.toString());
                String a3 = C0571j.m6430a("https://dev.mi.com/mistats/xmstats/event/dynamic/upload", hashMap, b, "test");
                C0566h.m6414a("upload snapshot with clickable views " + a.size());
                C0566h.m6414a(a3);
            } catch (Throwable e) {
                C0566h.m6418a("uploadSnapShot task exception: ", e);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.o.a */
    class C0587a implements SensorEventListener {
        final /* synthetic */ C0588o f4784a;
        private SoftReference<Activity> f4785b;

        public C0587a(C0588o c0588o) {
            this.f4784a = c0588o;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (Math.abs(f) > ((float) 19) || Math.abs(f2) > ((float) 19) || Math.abs(f3) > ((float) 19)) {
                this.f4784a.f4790e.sendEmptyMessage(100);
                C0566h.m6414a("shaking...");
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void m6489a(Activity activity) {
            this.f4785b = new SoftReference(activity);
        }

        public Activity m6488a() {
            return (Activity) this.f4785b.get();
        }

        public void m6490b() {
            try {
                if (this.f4785b != null) {
                    this.f4785b.clear();
                }
            } catch (Throwable e) {
                C0566h.m6418a("clearActivity exception: ", e);
            }
        }
    }

    public static C0588o m6492a() {
        if (f4786d == null) {
            f4786d = new C0588o();
        }
        return f4786d;
    }

    private C0588o() {
        this.f4787a = 0;
        this.f4791f = false;
        this.f4788b = false;
        this.f4789c = new C0587a(this);
        this.f4790e = new C05851(this, Looper.getMainLooper());
    }

    public boolean m6498b() {
        return this.f4788b;
    }

    public void m6499c() {
        this.f4788b = true;
    }

    public void m6500d() {
        this.f4788b = false;
        if (m6501e()) {
            m6502f();
        }
    }

    public boolean m6501e() {
        return this.f4791f;
    }

    public void m6496a(Activity activity) {
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        sensorManager.registerListener(this.f4789c, sensorManager.getDefaultSensor(1), 3);
        this.f4789c.m6489a(activity);
        this.f4791f = true;
        C0566h.m6414a("enable AcceleroMeterSensor...");
    }

    public void m6502f() {
        SensorManager sensorManager = (SensorManager) C0551c.m6352a().getSystemService("sensor");
        sensorManager.unregisterListener(this.f4789c, sensorManager.getDefaultSensor(1));
        this.f4791f = false;
        this.f4789c.m6490b();
        C0566h.m6414a("disable AcceleroMeterSensor...");
    }

    @SuppressLint({"NewApi"})
    public File m6497b(Activity activity) {
        View rootView = activity.getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        File file = new File(activity.getExternalCacheDir(), "snapshot.jpg");
        OutputStream fileOutputStream = new FileOutputStream(file);
        createBitmap.compress(CompressFormat.JPEG, 90, fileOutputStream);
        fileOutputStream.close();
        return file;
    }

    public void m6503g() {
        this.f4787a = System.currentTimeMillis();
    }

    public boolean m6504h() {
        return System.currentTimeMillis() > this.f4787a + 5000;
    }

    private void m6495c(Activity activity) {
        C0555d.m6364b().m6365a(new C05862(this, activity));
    }
}
