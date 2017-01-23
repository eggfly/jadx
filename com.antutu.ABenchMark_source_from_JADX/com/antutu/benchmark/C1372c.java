package com.antutu.benchmark;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.c */
public class C1372c {
    private static List<C1343a> f4665a;

    /* renamed from: com.antutu.benchmark.c.a */
    public static class C1343a {
        private int f4609a;
        private int f4610b;
        private int f4611c;
        private boolean f4612d;

        public C1343a() {
            this.f4609a = 0;
            this.f4610b = 0;
            this.f4611c = 0;
            this.f4612d = false;
        }

        public int m5402a() {
            return this.f4609a;
        }

        public void m5403a(int i) {
            this.f4609a = i;
        }

        public void m5404a(boolean z) {
            this.f4612d = z;
        }

        public int m5405b() {
            return this.f4610b;
        }

        public void m5406b(int i) {
            this.f4610b = i;
        }

        public int m5407c() {
            return this.f4611c;
        }

        public void m5408c(int i) {
            this.f4611c = i;
        }

        public boolean m5409d() {
            return this.f4612d;
        }
    }

    static {
        f4665a = null;
    }

    public static C1343a m5437a() {
        try {
            for (C1343a c1343a : f4665a) {
                if (c1343a.m5407c() > 0 && !c1343a.m5409d()) {
                    return c1343a;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void m5438a(Context context) {
        try {
            f4665a = C1372c.m5440b(context);
        } catch (Exception e) {
        }
    }

    public static C1343a m5439b() {
        try {
            for (C1343a c1343a : f4665a) {
                if (c1343a.m5407c() > 0 && c1343a.m5409d()) {
                    return c1343a;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static List<C1343a> m5440b(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return C1381d.m5461a(context);
        }
        List<C1343a> arrayList = new ArrayList();
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            CameraInfo cameraInfo = new CameraInfo();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.getCameraInfo(i, cameraInfo);
                C1343a c1343a = new C1343a();
                if (cameraInfo.facing == 1) {
                    c1343a.m5404a(true);
                }
                Camera open = Camera.open(i);
                open.cancelAutoFocus();
                List<Size> supportedPictureSizes = open.getParameters().getSupportedPictureSizes();
                open.release();
                if (supportedPictureSizes.size() > 0) {
                    for (Size size : supportedPictureSizes) {
                        int i2 = size.width * size.height;
                        if (c1343a.m5407c() < i2) {
                            c1343a.m5408c(i2);
                            c1343a.m5403a(size.width);
                            c1343a.m5406b(size.height);
                        }
                    }
                    arrayList.add(c1343a);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }
}
