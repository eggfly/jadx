package com.baidu.mobads.p093h;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Base64;
import android.util.Log;
import anet.channel.security.ISecurity;
import com.antutu.utils.RSAUtil;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p093h.C1960g.C1957a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.baidu.mobads.h.b */
public class C1951b extends File {
    private C1955e f6807a;
    private Class<?> f6808b;
    private Context f6809c;
    private PublicKey f6810d;
    private IXAdLogger f6811e;

    /* renamed from: com.baidu.mobads.h.b.a */
    class C1950a implements FilenameFilter {
        final /* synthetic */ C1951b f6806a;

        C1950a(C1951b c1951b) {
            this.f6806a = c1951b;
        }

        public boolean accept(File file, String str) {
            return true;
        }
    }

    public C1951b(String str, Context context) {
        this(str, context, null);
    }

    public C1951b(String str, Context context, C1955e c1955e) {
        super(str);
        this.f6808b = null;
        this.f6809c = null;
        this.f6811e = C1991m.m7449a().m7457f();
        this.f6809c = context;
        this.f6807a = c1955e;
        if (c1955e != null) {
            try {
                String str2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB";
                this.f6810d = C1951b.m7294c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception e) {
                this.f6810d = null;
            }
        }
    }

    private String m7291a(File file) {
        Exception e;
        Throwable th;
        String str = BuildConfig.FLAVOR;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
                do {
                } while (new DigestInputStream(fileInputStream, instance).read(new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE]) != -1);
                byte[] digest = instance.digest();
                int i = 0;
                while (i < digest.length) {
                    String str2 = str + Integer.toString((digest[i] & MotionEventCompat.ACTION_MASK) + AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 16).substring(1);
                    i++;
                    str = str2;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        this.f6811e.m7400e("XAdLocalApkFile", e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    this.f6811e.m7400e("XAdLocalApkFile", e.getMessage());
                    str = BuildConfig.FLAVOR;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e22) {
                            this.f6811e.m7400e("XAdLocalApkFile", e22.getMessage());
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e222) {
                            this.f6811e.m7400e("XAdLocalApkFile", e222.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            this.f6811e.m7400e("XAdLocalApkFile", e.getMessage());
            str = BuildConfig.FLAVOR;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str;
    }

    @TargetApi(14)
    private Class<?> m7292b(File file) {
        String absolutePath;
        Class<?> cls;
        this.f6811e.m7393d("XAdLocalApkFile", "Android version:" + VERSION.RELEASE);
        try {
            synchronized (C1960g.class) {
                absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.f6809c.getFilesDir().getAbsolutePath();
                String str = "com.baidu.mobads.container.AllInOneXAdContainerFactory";
                ClassLoader dexClassLoader = new DexClassLoader(absolutePath, absolutePath2, null, classLoader);
                this.f6811e.m7402i("XAdLocalApkFile", "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", loader=" + dexClassLoader + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName("com.baidu.mobads.container.AllInOneXAdContainerFactory", true, dexClassLoader);
            }
            m7295d();
        } catch (Exception e) {
            try {
                absolutePath = e.getMessage();
                this.f6811e.m7400e("XAdLocalApkFile", absolutePath);
                cls = null;
            } finally {
                m7295d();
            }
        }
        this.f6811e.m7402i("XAdLocalApkFile", "jar.path=" + file.getAbsolutePath() + ", clz=" + cls);
        return cls;
    }

    private String m7293b(String str) {
        if (this.f6810d != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance(RSAUtil.RSA_ALGORITHM);
                instance.init(2, this.f6810d);
                return new String(instance.doFinal(decode), HttpRequest.f14548a).trim();
            } catch (Throwable e) {
                this.f6811e.m7398e("ErrorWhileVerifySigNature", e);
            }
        }
        return null;
    }

    private static PublicKey m7294c(String str) {
        try {
            return KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("InvalidKeySpecException");
        } catch (NullPointerException e3) {
            throw new Exception("NullPointerException");
        }
    }

    private void m7295d() {
        File[] listFiles = this.f6809c.getFilesDir().listFiles(new C1950a(this));
        int i = 0;
        while (listFiles != null && i < listFiles.length) {
            if (listFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                Log.i("XAdLocalApkFile", "clearDexCacheFiles-->" + i + "--" + listFiles[i].getAbsolutePath());
                listFiles[i].delete();
            }
            i++;
        }
    }

    protected void m7296a() {
        if (this.f6807a != null) {
            String a = m7291a(new File(getAbsolutePath()));
            String b = m7293b(this.f6807a.m7314d());
            if (!b.equalsIgnoreCase(a)) {
                throw new C1957a("doCheckApkIntegrity failed, md5sum: " + a + ", checksum in json info: " + b);
            }
            return;
        }
        Log.i("XAdLocalApkFile", "built-in apk, no need to check");
    }

    protected void m7297a(String str) {
        renameTo(new File(str));
    }

    protected Class<?> m7298b() {
        if (this.f6808b == null) {
            File file = new File(getAbsolutePath());
            try {
                this.f6808b = m7292b(file);
            } finally {
                file.delete();
            }
        }
        return this.f6808b;
    }

    protected double m7299c() {
        return this.f6807a == null ? 0.0d : this.f6807a.m7312b();
    }
}
