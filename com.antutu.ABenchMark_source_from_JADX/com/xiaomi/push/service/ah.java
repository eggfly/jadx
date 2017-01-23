package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.google.protobuf.micro.C3613a;
import com.google.protobuf.micro.C3615b;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;
import com.xiaomi.push.protobuf.C4378a.C4377a;
import com.xiaomi.push.protobuf.C4380b.C4379a;
import com.xiaomi.smack.util.C4497h;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ah {
    private static String f15021a;
    private static ah f15022e;
    private List<C4402a> f15023b;
    private C4377a f15024c;
    private C4311b f15025d;

    /* renamed from: com.xiaomi.push.service.ah.a */
    public static abstract class C4402a {
        public void m18109a(C4377a c4377a) {
        }

        public void m18110a(C4379a c4379a) {
        }
    }

    static {
        f15022e = new ah();
    }

    private ah() {
        this.f15023b = new ArrayList();
    }

    public static ah m18136a() {
        return f15022e;
    }

    public static synchronized String m18140e() {
        String str;
        synchronized (ah.class) {
            if (f15021a == null) {
                SharedPreferences sharedPreferences = C4297i.m17624a().getSharedPreferences("XMPushServiceConfig", 0);
                f15021a = sharedPreferences.getString("DeviceUUID", null);
                if (f15021a == null) {
                    f15021a = C4297i.m17626b();
                    if (f15021a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f15021a).commit();
                    }
                }
            }
            str = f15021a;
        }
        return str;
    }

    private void m18141f() {
        if (this.f15024c == null) {
            m18143h();
        }
    }

    private void m18142g() {
        if (this.f15025d == null) {
            this.f15025d = new ai(this);
            C4497h.m18653a(this.f15025d);
        }
    }

    private void m18143h() {
        InputStream bufferedInputStream;
        Exception e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(C4297i.m17624a().openFileInput("XMCloudCfg"));
            try {
                this.f15024c = C4377a.m17977c(C3613a.m14816a(bufferedInputStream));
                bufferedInputStream.close();
                C4298a.m17632a(bufferedInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4302b.m17649a("load config failure: " + e.getMessage());
                    C4298a.m17632a(bufferedInputStream);
                    if (this.f15024c != null) {
                        this.f15024c = new C4377a();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C4298a.m17632a(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
            C4302b.m17649a("load config failure: " + e.getMessage());
            C4298a.m17632a(bufferedInputStream);
            if (this.f15024c != null) {
                this.f15024c = new C4377a();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            C4298a.m17632a(bufferedInputStream);
            throw th;
        }
        if (this.f15024c != null) {
            this.f15024c = new C4377a();
        }
    }

    private void m18144i() {
        try {
            if (this.f15024c != null) {
                OutputStream bufferedOutputStream = new BufferedOutputStream(C4297i.m17624a().openFileOutput("XMCloudCfg", 0));
                C3615b a = C3615b.m14835a(bufferedOutputStream);
                this.f15024c.m17983a(a);
                a.m14848a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            C4302b.m17649a("save config failure: " + e.getMessage());
        }
    }

    void m18145a(C4379a c4379a) {
        if (c4379a.m18011h() && c4379a.m18010g() > m18148c()) {
            m18142g();
        }
        synchronized (this) {
        }
        for (C4402a a : (C4402a[]) this.f15023b.toArray(new C4402a[this.f15023b.size()])) {
            a.m18110a(c4379a);
        }
    }

    public synchronized void m18146a(C4402a c4402a) {
        this.f15023b.add(c4402a);
    }

    synchronized void m18147b() {
        this.f15023b.clear();
    }

    int m18148c() {
        m18141f();
        return this.f15024c != null ? this.f15024c.m17987c() : 0;
    }

    public C4377a m18149d() {
        m18141f();
        return this.f15024c;
    }
}
