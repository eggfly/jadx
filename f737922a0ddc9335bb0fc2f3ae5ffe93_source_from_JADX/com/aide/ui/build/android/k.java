package com.aide.ui.build.android;

import android.app.Activity;
import bht;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.e;
import com.aide.ui.h;
import iw$j;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import nl;
import nl$a;
import qh;

public class k {

    public interface a {
        void j6(String str, String str2, String str3, String str4);
    }

    class 1 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ k FH;
        final /* synthetic */ String j6;

        1(k kVar, String str, a aVar) {
            this.FH = kVar;
            this.j6 = str;
            this.DW = aVar;
        }

        public void run() {
            this.FH.j6(this.j6, this.DW);
        }
    }

    class 2 implements y<String> {
        final /* synthetic */ String DW;
        final /* synthetic */ a FH;
        final /* synthetic */ k Hw;
        final /* synthetic */ String j6;

        2(k kVar, String str, String str2, a aVar) {
            this.Hw = kVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = aVar;
        }

        public void j6(String str) {
            this.Hw.j6(this.j6, this.DW, str, this.FH);
        }
    }

    class 3 implements y<String> {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ a Hw;
        final /* synthetic */ String j6;
        final /* synthetic */ k v5;

        3(k kVar, String str, String str2, String str3, a aVar) {
            this.v5 = kVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = str3;
            this.Hw = aVar;
        }

        public void j6(String str) {
            this.v5.j6(this.j6, this.DW, this.FH, str, this.Hw);
        }
    }

    class 4 implements nl$a {
        final /* synthetic */ k DW;
        final /* synthetic */ Activity j6;

        4(k kVar, Activity activity) {
            this.DW = kVar;
            this.j6 = activity;
        }

        public void j6(boolean z, String str) {
            if (z) {
                h.FH(str);
                m.j6(this.j6, "Create keystore", "Keystore file " + str + " has been created and set as default.", null);
                return;
            }
            m.j6(this.j6, "Create keystore", "Failed to create keystore file " + str);
        }
    }

    public void j6(String str, iw$j iw_j, a aVar) {
        if (iw_j != null) {
            try {
                String j6 = iw_j.j6();
                KeyStore iVar = new i();
                iVar.load(new FileInputStream(j6), iw_j.Hw.toCharArray());
                if (iVar.getKey(iw_j.DW, iw_j.FH.toCharArray()) == null) {
                    throw new Exception("can not read keystore");
                }
                aVar.j6(j6, iw_j.Hw, iw_j.DW, iw_j.FH);
                return;
            } catch (Exception e) {
                m.DW(e.u7(), "Build Error", "Failed to open signingConfig from build.gradle. Use alternative signing?", new 1(this, str, aVar), null);
                return;
            }
        }
        j6(str, aVar);
    }

    public void j6(String str, a aVar) {
        if (str == null || str.length() <= 0) {
            aVar.j6("", "", "", "");
        } else if (qh.J0(str)) {
            try {
                KeyStore iVar = new i();
                iVar.load(new FileInputStream(str), "android".toCharArray());
                if (iVar.getKey("androiddebugkey", "android".toCharArray()) == null) {
                    throw new Exception("no androiddebugkey");
                }
                aVar.j6(str, "android", "androiddebugkey", "android");
            } catch (Exception e) {
                if (e.Mr().DW(e.tp(), "custom_keystore")) {
                    j6(str, "", aVar);
                }
            }
        } else {
            m.j6(e.u7(), "Build Error", "Keystore file " + str + " does not exist!");
        }
    }

    private void j6(String str, String str2, a aVar) {
        try {
            KeyStore iVar = new i();
            iVar.load(new FileInputStream(str), str2.toCharArray());
            List list = Collections.list(iVar.aliases());
            if (list.size() == 1) {
                j6(str, str2, (String) list.get(0), aVar);
            } else {
                m.j6(e.u7(), "Select keystore alias", list, new 2(this, str, str2, aVar));
            }
        } catch (Exception e) {
            m.j6(e.u7(), "Build Error", "Invalid keystore credentials!");
        }
    }

    private void j6(String str, String str2, String str3, a aVar) {
        m.j6(e.u7(), null, "Enter password for keystore alias '" + str3 + "':", new 3(this, str, str2, str3, aVar));
    }

    private void j6(String str, String str2, String str3, String str4, a aVar) {
        try {
            KeyStore iVar = new i();
            iVar.load(new FileInputStream(str), str2.toCharArray());
            if (iVar.getKey(str3, str4.toCharArray()) == null) {
                throw new Exception("no alias");
            }
            aVar.j6(str, str2, str3, str4);
        } catch (Exception e) {
            m.j6(e.u7(), "Build Error", "Invalid keystore credentials!");
        }
    }

    public void j6(Activity activity) {
        m.j6(activity, new nl(qh.j6() + "/debug.keystore", "androiddebugkey", "android", new 4(this, activity)));
    }

    public boolean j6(String str, String str2, String str3, String str4, Date date, Date date2, BigInteger bigInteger, String str5, String str6, String str7, String str8, String str9, String str10) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "BC");
            instance.initialize(1024);
            KeyPair generateKeyPair = instance.generateKeyPair();
            PublicKey publicKey = generateKeyPair.getPublic();
            PrivateKey privateKey = generateKeyPair.getPrivate();
            bht bht = new bht();
            String str11 = "CN=" + str5;
            if (str6.length() > 0) {
                str11 = str11 + ", O=" + str6;
            }
            if (str7.length() > 0) {
                str11 = str11 + ", OU=" + str7;
            }
            if (str8.length() > 0) {
                str11 = str11 + ", L=" + str8;
            }
            if (str9.length() > 0) {
                str11 = str11 + ", ST=" + str9;
            }
            if (str10.length() > 0) {
                str11 = str11 + ", C=" + str10;
            }
            X500Principal x500Principal = new X500Principal(str11);
            bht.j6(bigInteger);
            bht.j6(x500Principal);
            bht.DW(x500Principal);
            bht.j6(date);
            bht.DW(date2);
            bht.j6(publicKey);
            bht.j6("SHA256WithRSAEncryption");
            X509Certificate j6 = bht.j6(privateKey, "BC");
            KeyStore iVar = new i();
            iVar.load(null, null);
            iVar.setKeyEntry(str3, privateKey, str4.toCharArray(), new Certificate[]{j6});
            iVar.store(new FileOutputStream(str), str2.toCharArray());
            return true;
        } catch (Throwable th) {
            com.aide.common.e.j6(th);
            return false;
        }
    }
}
