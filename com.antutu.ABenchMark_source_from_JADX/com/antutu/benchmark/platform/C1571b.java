package com.antutu.benchmark.platform;

import android.content.Context;
import com.antutu.benchmark.platform.p048a.C1544a;
import com.antutu.benchmark.platform.p049b.p051b.C1570b;
import com.antutu.benchmark.platform.p052c.C1573b;
import com.antutu.benchmark.platform.p053d.C1575a;
import com.antutu.benchmark.platform.p054e.C1577b;
import com.antutu.benchmark.platform.p055f.C1578a;
import com.antutu.benchmark.platform.p055f.C1579b;
import com.antutu.benchmark.platform.p055f.C1580c;
import com.antutu.benchmark.platform.p056g.C1581a;
import com.antutu.benchmark.platform.p057h.p058a.C1595a;
import com.antutu.utils.jni;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.AdError;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.antutu.benchmark.platform.b */
public class C1571b {
    Runnable f5455a;
    Runnable f5456b;
    Runnable f5457c;
    private final int f5458d;
    private boolean f5459e;
    private double f5460f;

    /* renamed from: com.antutu.benchmark.platform.b.1 */
    class C15461 implements Runnable {
        final /* synthetic */ C1571b f5384a;

        C15461(C1571b c1571b) {
            this.f5384a = c1571b;
        }

        public void run() {
            try {
                C1578a c1578a = new C1578a();
                c1578a.m6248b();
                if (this.f5384a.f5460f <= 1.0d) {
                    this.f5384a.f5460f = c1578a.m6247a() / 100.0d;
                } else {
                    this.f5384a.f5460f = Math.sqrt((c1578a.m6247a() / 100.0d) * this.f5384a.f5460f);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.platform.b.2 */
    class C15472 implements Runnable {
        final /* synthetic */ C1571b f5385a;

        C15472(C1571b c1571b) {
            this.f5385a = c1571b;
        }

        public void run() {
            try {
                C1579b c1579b = new C1579b();
                c1579b.m6260b();
                if (this.f5385a.f5460f <= 1.0d) {
                    this.f5385a.f5460f = c1579b.m6258a();
                } else {
                    this.f5385a.f5460f = Math.sqrt(c1579b.m6258a() * this.f5385a.f5460f);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.platform.b.3 */
    class C15483 implements Runnable {
        final /* synthetic */ C1571b f5386a;

        C15483(C1571b c1571b) {
            this.f5386a = c1571b;
        }

        public void run() {
            try {
                C1580c c1580c = new C1580c();
                c1580c.m6265a(100);
                c1580c.m6267b(15);
                float f = 0.0f;
                float f2 = 0.0f;
                int i = 1;
                while (i <= 1) {
                    if (!this.f5386a.f5459e) {
                        float b = (float) (c1580c.m6266b() / 1000.0d);
                        f2 += (1000.0f * b) / ((float) c1580c.m6264a());
                        f += ((float) (c1580c.m6264a() * AdError.NETWORK_ERROR_CODE)) / b;
                        c1580c.m6268c(10);
                        i++;
                    } else {
                        return;
                    }
                }
                float f3 = f2 / ((float) 1);
                f3 = f / ((float) 1);
                if (this.f5386a.f5460f <= 1.0d) {
                    this.f5386a.f5460f = ((double) f3) / 100.0d;
                } else {
                    this.f5386a.f5460f = Math.sqrt((((double) f3) / 100.0d) * this.f5386a.f5460f);
                }
            } catch (Exception e) {
            }
        }
    }

    public C1571b() {
        this.f5458d = 1;
        this.f5459e = false;
        this.f5460f = 1.0d;
        this.f5455a = new C15461(this);
        this.f5456b = new C15472(this);
        this.f5457c = new C15483(this);
    }

    private void m6208a(Runnable runnable) {
        int i = 0;
        try {
            Thread[] threadArr = new Thread[1];
            int i2 = 0;
            while (i2 < 1) {
                if (!this.f5459e) {
                    threadArr[i2] = new Thread(runnable);
                    threadArr[i2].start();
                    i2++;
                } else {
                    return;
                }
            }
            while (i < 1) {
                if (threadArr[i].isAlive()) {
                    threadArr[i].join();
                }
                i++;
            }
        } catch (Exception e) {
        }
    }

    private boolean m6209a(Context context, int i, String str) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            OutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public double m6211a(Context context) {
        try {
            this.f5460f = new C1575a("database_test.db").m6238a(context);
        } catch (Exception e) {
        }
        return this.f5460f;
    }

    public double m6212a(Context context, String str) {
        m6213a();
        C1595a c1595a = new C1595a();
        c1595a.m6294a(context, str, 2, 1.0d);
        this.f5460f = c1595a.m6294a(context, str, 0, 2.0d);
        if (this.f5459e) {
            return 0.0d;
        }
        this.f5460f = c1595a.m6294a(context, str, 1, 2.0d) + this.f5460f;
        if (this.f5459e) {
            return 0.0d;
        }
        this.f5460f = c1595a.m6294a(context, str, 2, 2.0d) + this.f5460f;
        return this.f5460f;
    }

    public void m6213a() {
        this.f5459e = false;
        this.f5460f = 1.0d;
    }

    public void m6214a(Context context, int i) {
        try {
            String str = context.getFilesDir().getAbsolutePath() + "/test_img_fisheye.jpg";
            if (m6209a(context, i, str)) {
                jni.testImgFisheye(context, str);
            }
            new File(str).delete();
        } catch (Exception e) {
        }
    }

    public double m6215b() {
        m6213a();
        m6208a(this.f5457c);
        return this.f5460f;
    }

    public double m6216b(Context context, String str) {
        m6213a();
        C1577b c1577b = new C1577b();
        this.f5460f = c1577b.m6245a(context, str, 2.0d);
        if (this.f5459e) {
            return 0.0d;
        }
        this.f5460f += c1577b.m6245a(context, str, 2.0d);
        if (this.f5459e) {
            return 0.0d;
        }
        this.f5460f += c1577b.m6245a(context, str, 2.0d);
        this.f5460f /= 3.0d;
        return this.f5460f;
    }

    public void m6217b(Context context, int i) {
        try {
            String str = context.getFilesDir().getAbsolutePath() + "/test_img_blur.jpg";
            if (m6209a(context, i, str)) {
                double testImgBlur = (double) jni.testImgBlur(context, str);
            }
            new File(str).delete();
        } catch (Exception e) {
        }
    }

    public double m6218c() {
        m6213a();
        this.f5460f = new C1581a().m6273a();
        return this.f5460f;
    }

    public double m6219c(Context context, int i) {
        m6213a();
        this.f5460f = new C1544a(context).m6116b(i);
        return this.f5460f;
    }

    public double m6220d() {
        m6213a();
        this.f5460f = new C1570b().m6205a();
        return this.f5460f;
    }

    public double m6221e() {
        m6213a();
        this.f5460f = new C1573b().m6231a();
        return this.f5460f;
    }
}
