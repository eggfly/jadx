package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.string.C4326a;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4532k;
import com.xiaomi.xmpush.thrift.C4534l;
import com.xiaomi.xmpush.thrift.C4540o;
import com.xiaomi.xmpush.thrift.C4542p;
import com.xiaomi.xmpush.thrift.C4548s;
import com.xiaomi.xmpush.thrift.C4552u;
import com.xiaomi.xmpush.thrift.C4556w;
import com.xiaomi.xmpush.thrift.C4558x;
import com.xiaomi.xmpush.thrift.C4562z;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ae;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;

/* renamed from: com.xiaomi.mipush.sdk.k */
public class C4355k {
    private static final byte[] f14815a;

    static {
        f14815a = new byte[]{(byte) 100, (byte) 23, (byte) 84, (byte) 114, (byte) 72, (byte) 0, (byte) 4, (byte) 97, (byte) 73, (byte) 97, (byte) 2, (byte) 52, (byte) 84, (byte) 102, (byte) 18, (byte) 32};
    }

    protected static <T extends C4454a<T, ?>> C4542p m17834a(Context context, T t, C4513a c4513a) {
        return C4355k.m17835a(context, t, c4513a, !c4513a.equals(C4513a.Registration), context.getPackageName(), C4343a.m17800a(context).m17810c());
    }

    protected static <T extends C4454a<T, ?>> C4542p m17835a(Context context, T t, C4513a c4513a, boolean z, String str, String str2) {
        byte[] a = ae.m18793a(t);
        if (a == null) {
            C4302b.m17649a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        C4542p c4542p = new C4542p();
        if (z) {
            String f = C4343a.m17800a(context).m17813f();
            if (TextUtils.isEmpty(f)) {
                C4302b.m17649a("regSecret is empty, return null");
                return null;
            }
            try {
                a = C4355k.m17840b(C4326a.m17731a(f), a);
            } catch (Exception e) {
                C4302b.m17654d("encryption error. ");
            }
        }
        C4532k c4532k = new C4532k();
        c4532k.f15872a = 5;
        c4532k.f15873b = "fakeid";
        c4542p.m19002a(c4532k);
        c4542p.m19004a(ByteBuffer.wrap(a));
        c4542p.m19000a(c4513a);
        c4542p.m19013c(true);
        c4542p.m19009b(str);
        c4542p.m19005a(z);
        c4542p.m19003a(str2);
        return c4542p;
    }

    private static Cipher m17836a(byte[] bArr, int i) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(f14815a);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance;
    }

    public static C4454a m17837a(Context context, C4542p c4542p) {
        if (c4542p.m19014c()) {
            try {
                byte[] a = C4355k.m17839a(C4326a.m17731a(C4343a.m17800a(context).m17813f()), c4542p.m19018f());
            } catch (Throwable e) {
                throw new C4345c("the aes decrypt failed.", e);
            }
        }
        a = c4542p.m19018f();
        C4454a a2 = C4355k.m17838a(c4542p.m18999a());
        if (a2 != null) {
            ae.m18792a(a2, a);
        }
        return a2;
    }

    private static C4454a m17838a(C4513a c4513a) {
        switch (C4356l.f14816a[c4513a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return new C4552u();
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return new ab();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return new C4562z();
            case SpdyProtocol.QUIC /*4*/:
                return new ad();
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return new C4558x();
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return new C4534l();
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return new C4540o();
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return new C4556w();
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return new C4548s();
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return new C4540o();
            default:
                return null;
        }
    }

    public static byte[] m17839a(byte[] bArr, byte[] bArr2) {
        return C4355k.m17836a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] m17840b(byte[] bArr, byte[] bArr2) {
        return C4355k.m17836a(bArr, 1).doFinal(bArr2);
    }
}
