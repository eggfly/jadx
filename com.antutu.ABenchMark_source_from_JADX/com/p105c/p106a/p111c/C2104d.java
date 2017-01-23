package com.p105c.p106a.p111c;

import android.content.Context;
import android.provider.Settings.System;
import com.p105c.p106a.p107a.p108a.C2088b;
import com.p105c.p106a.p107a.p108a.C2089c;
import com.p105c.p106a.p107a.p108a.C2090d;
import com.p105c.p106a.p107a.p108a.C2091e;
import com.p105c.p106a.p109b.p110a.C2096c;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.c.a.c.d */
public class C2104d {
    private static final Object f7390b;
    private static C2104d f7391c;
    private static final String f7392j;
    private Context f7393a;
    private String f7394d;
    private C2105e f7395e;
    private String f7396f;
    private String f7397g;
    private C2096c f7398h;
    private C2096c f7399i;
    private Pattern f7400k;

    static {
        f7390b = new Object();
        f7391c = null;
        f7392j = ".UTSystemConfig" + File.separator + "Global";
    }

    public C2104d(Context context) {
        this.f7393a = null;
        this.f7394d = null;
        this.f7395e = null;
        this.f7396f = "xx_utdid_key";
        this.f7397g = "xx_utdid_domain";
        this.f7398h = null;
        this.f7399i = null;
        this.f7400k = Pattern.compile("[^0-9a-zA-Z=/+]+");
        this.f7393a = context;
        this.f7399i = new C2096c(context, f7392j, "Alvin2", false, true);
        this.f7398h = new C2096c(context, ".DataStorage", "ContextData", false, true);
        this.f7395e = new C2105e();
        this.f7396f = String.format("K_%d", new Object[]{Integer.valueOf(C2091e.m7810b(this.f7396f))});
        this.f7397g = String.format("D_%d", new Object[]{Integer.valueOf(C2091e.m7810b(this.f7397g))});
    }

    public static C2104d m7897a(Context context) {
        if (context != null && f7391c == null) {
            synchronized (f7390b) {
                if (f7391c == null) {
                    f7391c = new C2104d(context);
                    f7391c.m7900b();
                }
            }
        }
        return f7391c;
    }

    private static String m7898a(byte[] bArr) {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        return C2088b.m7802b(instance.doFinal(bArr), 2);
    }

    private void m7899a(String str) {
        if (m7907f(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && this.f7399i != null) {
                this.f7399i.m7839a("UTDID2", str);
                this.f7399i.m7840a();
            }
        }
    }

    private void m7900b() {
        Object obj = 1;
        if (this.f7399i != null) {
            if (C2091e.m7809a(this.f7399i.m7841b("UTDID2"))) {
                String b = this.f7399i.m7841b("UTDID");
                if (!C2091e.m7809a(b)) {
                    m7899a(b);
                }
            }
            Object obj2 = null;
            if (!C2091e.m7809a(this.f7399i.m7841b("DID"))) {
                this.f7399i.m7838a("DID");
                obj2 = 1;
            }
            if (!C2091e.m7809a(this.f7399i.m7841b("EI"))) {
                this.f7399i.m7838a("EI");
                obj2 = 1;
            }
            if (C2091e.m7809a(this.f7399i.m7841b("SI"))) {
                obj = obj2;
            } else {
                this.f7399i.m7838a("SI");
            }
            if (obj != null) {
                this.f7399i.m7840a();
            }
        }
    }

    private void m7901b(String str) {
        if (str != null && this.f7398h != null && !str.equals(this.f7398h.m7841b(this.f7396f))) {
            this.f7398h.m7839a(this.f7396f, str);
            this.f7398h.m7840a();
        }
    }

    private String m7902c() {
        if (this.f7399i != null) {
            String b = this.f7399i.m7841b("UTDID2");
            if (!(C2091e.m7809a(b) || this.f7395e.m7909a(b) == null)) {
                return b;
            }
        }
        return null;
    }

    private void m7903c(String str) {
        if (this.f7393a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && m7907f(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = System.getString(this.f7393a.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception e) {
                }
                if (!m7907f(str2)) {
                    try {
                        System.putString(this.f7393a.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }

    private void m7904d(String str) {
        Object obj = null;
        try {
            obj = System.getString(this.f7393a.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception e) {
        }
        if (!str.equals(obj)) {
            try {
                System.putString(this.f7393a.getContentResolver(), "dxCRMxhQkdGePGnp", str);
            } catch (Exception e2) {
            }
        }
    }

    private final byte[] m7905d() {
        String a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = C2089c.m7805a(currentTimeMillis);
        byte[] a3 = C2089c.m7805a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            a = C2090d.m7807a(this.f7393a);
        } catch (Exception e) {
            a = BuildConfig.FLAVOR + new Random().nextInt();
        }
        byteArrayOutputStream.write(C2089c.m7805a(C2091e.m7810b(a)), 0, 4);
        a = BuildConfig.FLAVOR;
        byteArrayOutputStream.write(C2089c.m7805a(C2091e.m7810b(C2104d.m7898a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private void m7906e(String str) {
        if (this.f7393a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null) {
            m7904d(str);
        }
    }

    private boolean m7907f(String str) {
        if (str == null) {
            return false;
        }
        CharSequence substring;
        if (str.endsWith("\n")) {
            substring = str.substring(0, str.length() - 1);
        }
        return 24 == substring.length() && !this.f7400k.matcher(substring).find();
    }

    public synchronized String m7908a() {
        String str;
        if (this.f7394d != null) {
            str = this.f7394d;
        } else {
            str = BuildConfig.FLAVOR;
            try {
                str = System.getString(this.f7393a.getContentResolver(), "mqBRboGZkQPcAkyk");
            } catch (Exception e) {
            }
            if (!m7907f(str)) {
                String string;
                C2106f c2106f = new C2106f();
                Object obj = null;
                try {
                    string = System.getString(this.f7393a.getContentResolver(), "dxCRMxhQkdGePGnp");
                } catch (Exception e2) {
                    string = null;
                }
                if (C2091e.m7809a(string)) {
                    obj = 1;
                } else {
                    str = c2106f.m7913b(string);
                    if (m7907f(str)) {
                        m7903c(str);
                    } else {
                        str = c2106f.m7912a(string);
                        if (m7907f(str)) {
                            str = this.f7395e.m7909a(str);
                            if (!C2091e.m7809a(str)) {
                                m7906e(str);
                                try {
                                    str = System.getString(this.f7393a.getContentResolver(), "dxCRMxhQkdGePGnp");
                                } catch (Exception e3) {
                                    str = string;
                                }
                                string = this.f7395e.m7911b(str);
                                if (m7907f(string)) {
                                    this.f7394d = string;
                                    m7899a(string);
                                    m7901b(str);
                                    m7903c(this.f7394d);
                                    str = this.f7394d;
                                }
                            }
                        }
                        str = string;
                        string = this.f7395e.m7911b(str);
                        if (m7907f(string)) {
                            this.f7394d = string;
                            m7899a(string);
                            m7901b(str);
                            m7903c(this.f7394d);
                            str = this.f7394d;
                        }
                    }
                }
                str = m7902c();
                if (m7907f(str)) {
                    String a = this.f7395e.m7909a(str);
                    if (obj != null) {
                        m7906e(a);
                    }
                    m7903c(str);
                    m7901b(a);
                    this.f7394d = str;
                } else {
                    string = this.f7398h.m7841b(this.f7396f);
                    if (!C2091e.m7809a(string)) {
                        str = c2106f.m7912a(string);
                        if (!m7907f(str)) {
                            str = this.f7395e.m7911b(string);
                        }
                        if (m7907f(str)) {
                            string = this.f7395e.m7909a(str);
                            if (!C2091e.m7809a(str)) {
                                this.f7394d = str;
                                if (obj != null) {
                                    m7906e(string);
                                }
                                m7899a(this.f7394d);
                                str = this.f7394d;
                            }
                        }
                    }
                    try {
                        byte[] d = m7905d();
                        if (d != null) {
                            this.f7394d = C2088b.m7802b(d, 2);
                            m7899a(this.f7394d);
                            str = this.f7395e.m7910a(d);
                            if (str != null) {
                                if (obj != null) {
                                    m7906e(str);
                                }
                                m7901b(str);
                            }
                            str = this.f7394d;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    str = null;
                }
            }
        }
        return str;
    }
}
