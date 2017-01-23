package com.baidu.mobads.openad.p096e;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.openad.p079d.C1912c;
import com.baidu.mobads.openad.p095b.C2006a;
import com.baidu.mobads.openad.p095b.C2007b;
import com.baidu.mobads.openad.p095b.C2009d;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.openad.e.a */
public class C2021a extends C1912c {
    public static int f7042a;
    protected static C2006a f7043b;
    private String f7044d;
    private AtomicBoolean f7045e;
    private Boolean f7046f;
    private HttpURLConnection f7047g;
    private AtomicBoolean f7048h;

    static {
        f7042a = IXAdIOUtils.BUFFER_SIZE;
        try {
            f7043b = new C2007b();
        } catch (ClassNotFoundException e) {
            f7043b = new C2009d();
        }
        f7043b.m7484a();
    }

    public C2021a() {
        this(null);
    }

    public C2021a(String str) {
        this.f7045e = new AtomicBoolean(false);
        this.f7046f = Boolean.valueOf(false);
        this.f7048h = new AtomicBoolean();
        this.f7044d = str;
    }

    private static String m7538b(InputStream inputStream) {
        String str = BuildConfig.FLAVOR;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str2 = BuildConfig.FLAVOR;
        while (true) {
            str2 = bufferedReader.readLine();
            if (str2 == null) {
                return str;
            }
            str = str + str2 + "\n";
        }
    }

    public void m7543a() {
        new Thread(new C2023c(this)).start();
    }

    public void m7544a(C2006a c2006a) {
        f7043b = c2006a;
    }

    public void m7545a(C2024d c2024d) {
        m7546a(c2024d, 20000.0d);
    }

    public void m7546a(C2024d c2024d, double d) {
        new C2022b(this, c2024d, d).start();
    }

    public void m7547a(C2024d c2024d, Boolean bool) {
        this.f7046f = bool;
        m7546a(c2024d, 20000.0d);
    }

    public void dispose() {
        this.f7048h.set(true);
        m7543a();
        super.dispose();
    }
}
