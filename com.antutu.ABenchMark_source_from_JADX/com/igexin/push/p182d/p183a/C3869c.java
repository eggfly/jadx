package com.igexin.push.p182d.p183a;

import android.support.v4.view.MotionEventCompat;
import com.igexin.download.Downloads;
import com.igexin.p158b.p159a.p160a.C3658a;
import com.igexin.p158b.p159a.p161b.C3667e;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p161b.C3686d;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p165d.p166a.C3664f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.p182d.p185c.C3878b;
import com.igexin.push.p182d.p185c.C3882g;
import com.igexin.push.p182d.p185c.C3883h;
import com.igexin.push.util.EncryptUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.android.agoo.intent.IntentUtil;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.a.c */
public class C3869c extends C3683b {
    public static final String f13018a;
    public static int f13019b;
    private byte[] f13020g;

    static {
        f13018a = C3869c.class.getName();
        f13019b = -1;
    }

    C3869c(String str) {
        super(str, true);
    }

    private int m15916a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = byteBuffer.get();
        }
        return i == 1 ? C3687f.m15076a(bArr, 0) : i == 2 ? C3687f.m15085b(bArr, 0) : i == 4 ? C3687f.m15091d(bArr, 0) : 0;
    }

    public static C3683b m15917a() {
        C3683b c3869c = new C3869c("socketProtocol");
        C3867a c3867a = new C3867a(IntentUtil.AGOO_COMMAND, c3869c);
        return c3869c;
    }

    private C3664f m15918a(C3667e c3667e, C3686d c3686d, C3868b c3868b, ByteBuffer byteBuffer) {
        int i;
        if (c3868b.f13011a == 0) {
            if (c3868b.f13014d == 0) {
                c3868b.f13016f = new byte[8];
            }
            while (byteBuffer.remaining() > 0) {
                byte b = byteBuffer.get();
                byte[] bArr = c3868b.f13016f;
                int i2 = c3868b.f13014d;
                c3868b.f13014d = i2 + 1;
                bArr[i2] = b;
                if (c3868b.f13014d == 4 && C3687f.m15091d(c3868b.f13016f, 0) != 1944742139) {
                    c3868b.f13014d = 0;
                }
                if (c3868b.f13014d >= 8) {
                    C3882g c3882g = new C3882g();
                    c3868b.f13017g = c3882g;
                    c3882g.f13071b = c3868b.f13016f[4] & MotionEventCompat.ACTION_MASK;
                    c3882g.f13072c = c3868b.f13016f[5] & MotionEventCompat.ACTION_MASK;
                    c3882g.m15971a(c3868b.f13016f[6]);
                    if (c3882g.f13077h == 48) {
                        return null;
                    }
                    byte b2 = byteBuffer.get();
                    for (b = (byte) 0; b < b2; b++) {
                        byteBuffer.get();
                    }
                    c3882g.f13074e = c3868b.f13016f[7] & MotionEventCompat.ACTION_MASK;
                    c3868b.m15915a(c3882g.f13074e);
                    c3882g.f13075f = byteBuffer.get();
                    c3882g.f13084o = byteBuffer.get();
                    if (c3882g.f13084o > 0) {
                        byte[] bArr2 = new byte[c3882g.f13084o];
                        for (i = 0; i < c3882g.f13084o; i++) {
                            bArr2[i] = byteBuffer.get();
                        }
                        c3882g.f13083n = bArr2;
                    }
                    c3868b.f13014d = 0;
                    c3868b.f13016f = null;
                    if (c3882g.f13074e > 0) {
                        c3868b.f13011a = 1;
                        return m15922b(c3667e, c3686d, byteBuffer);
                    }
                    C3685c.m15060b().m15055a((Object) new C3883h());
                    C3685c.m15060b().m15070c();
                    if (byteBuffer.remaining() > 0) {
                        return m15922b(c3667e, c3686d, byteBuffer);
                    }
                }
            }
            return null;
        }
        while (c3868b.f13011a == 1 && byteBuffer.remaining() > 0) {
            int a = m15916a(byteBuffer, 4);
            if (a <= f13019b) {
                f13019b = -1;
                throw new Exception("server packetId can't be less than previous");
            }
            f13019b = a;
            i2 = m15916a(byteBuffer, 4);
            c3868b.f13015e = m15916a(byteBuffer, 2);
            i = m15916a(byteBuffer, 1);
            int i3 = c3868b.f13015e;
            C3878b c3878b = new C3878b();
            c3878b.f13044a = i3;
            c3878b.f13045b = (byte) i;
            c3878b.f13049f = c3868b.f13017g.f13072c;
            c3878b.f13050g = c3868b.f13017g.f13077h;
            if (c3878b.f13044a > 0) {
                c3868b.f13016f = new byte[i3];
                for (i = 0; i < i3; i++) {
                    c3868b.f13016f[i] = byteBuffer.get();
                }
                if (c3868b.f13017g.f13077h == 16) {
                    c3868b.f13016f = EncryptUtils.aesDecSocket(c3868b.f13016f, EncryptUtils.getIV(C3687f.m15086b(i2)));
                } else if (c3868b.f13017g.f13077h == 32) {
                    if (c3878b.f13045b != 26) {
                        return null;
                    }
                    c3868b.f13016f = EncryptUtils.altAesDecSocket(c3868b.f13016f, C3687f.m15086b(i2));
                } else if (c3868b.f13017g.f13077h != null) {
                    return c3868b.f13017g.f13077h == 48 ? null : null;
                }
                if (c3868b.f13017g.f13076g == -128) {
                    c3868b.f13016f = C3687f.m15092d(c3868b.f13016f);
                } else if (c3868b.f13017g.f13076g != null) {
                    return null;
                }
                c3878b.m15955a(c3868b.f13016f);
                if (!Arrays.equals(c3868b.f13017g.f13083n, EncryptUtils.getSocketSignature(c3878b, a, i2))) {
                    C3688a.m15097b(f13018a + "|decode signature error!!!!");
                    return null;
                }
            } else if (c3878b.f13044a < 0) {
                C3688a.m15097b(f13018a + "|data len < 0, error");
                return null;
            }
            c3868b.f13015e = 0;
            c3868b.f13014d = 0;
            c3868b.f13016f = null;
            c3868b.f13017g = null;
            if (this.d != null) {
                C3685c.m15060b().m15055a(this.d.m15045c(c3667e, c3686d, c3878b));
            }
            c3868b.f13012b++;
            if (c3868b.f13012b == c3868b.f13013c) {
                c3868b.f13011a = 0;
            }
        }
        if (c3868b.f13012b > 0) {
            C3685c.m15060b().m15070c();
        }
        if (byteBuffer.remaining() > 0) {
            return m15922b(c3667e, c3686d, byteBuffer);
        }
        return null;
    }

    static C3882g m15919a(C3878b c3878b) {
        C3882g c3882g = new C3882g();
        c3882g.f13070a = 1944742139;
        c3882g.m15971a(c3878b.f13046c);
        c3882g.f13074e = c3878b.f13045b > null ? 1 : 0;
        c3882g.f13072c = 7;
        c3882g.f13071b = 11;
        c3882g.f13075f = c3878b.f13047d;
        c3882g.f13071b += EncryptUtils.getRSAKeyId().length;
        if (c3878b.f13044a > 0) {
            c3882g.f13085p = EncryptUtils.getPacketId();
            c3882g.f13086q = (int) (System.currentTimeMillis() / 1000);
            c3882g.f13083n = EncryptUtils.getSocketSignature(c3878b, c3882g.f13085p, c3882g.f13086q);
            c3882g.f13084o = c3882g.f13083n.length;
            c3882g.f13071b += c3882g.f13084o;
        } else if (c3882g.f13077h == null) {
            c3882g.f13084o = 0;
            c3882g.f13071b += c3882g.f13084o;
        }
        C3685c.m15061d();
        return c3882g;
    }

    private C3664f m15920b(C3667e c3667e, C3686d c3686d, C3868b c3868b, ByteBuffer byteBuffer) {
        byte b;
        if (c3868b.f13011a == 0) {
            if (c3868b.f13014d == 0) {
                c3868b.f13016f = new byte[8];
            }
            while (byteBuffer.remaining() > 0) {
                b = byteBuffer.get();
                byte[] bArr = c3868b.f13016f;
                int i = c3868b.f13014d;
                c3868b.f13014d = i + 1;
                bArr[i] = b;
                if (c3868b.f13014d == 4 && C3687f.m15091d(c3868b.f13016f, 0) != 1944742139) {
                    c3868b.f13014d = 0;
                }
                if (c3868b.f13014d >= 8) {
                    C3882g c3882g = new C3882g();
                    c3868b.f13017g = c3882g;
                    c3882g.f13071b = c3868b.f13016f[4] & MotionEventCompat.ACTION_MASK;
                    c3882g.f13072c = c3868b.f13016f[5] & MotionEventCompat.ACTION_MASK;
                    c3882g.m15971a(c3868b.f13016f[6]);
                    c3882g.f13074e = c3868b.f13016f[7] & MotionEventCompat.ACTION_MASK;
                    c3868b.m15915a(c3882g.f13074e);
                    if (c3882g.f13077h == 48) {
                        byte b2 = byteBuffer.get();
                        this.f13020g = new byte[b2];
                        for (b = (byte) 0; b < b2; b++) {
                            this.f13020g[b] = byteBuffer.get();
                        }
                    }
                    c3868b.f13014d = 0;
                    c3868b.f13016f = null;
                    if (c3882g.f13074e > 0) {
                        c3868b.f13011a = 1;
                        return m15922b(c3667e, c3686d, byteBuffer);
                    }
                    C3685c.m15060b().m15055a((Object) new C3883h());
                    C3685c.m15060b().m15070c();
                    if (byteBuffer.remaining() > 0) {
                        return m15922b(c3667e, c3686d, byteBuffer);
                    }
                }
            }
            return null;
        }
        while (c3868b.f13011a == 1 && byteBuffer.remaining() > 0) {
            b = byteBuffer.get();
            if (c3868b.f13014d == 0) {
                c3868b.f13016f = new byte[2];
            }
            bArr = c3868b.f13016f;
            i = c3868b.f13014d;
            c3868b.f13014d = i + 1;
            bArr[i] = b;
            if (c3868b.f13014d >= 2) {
                if (c3868b.f13014d == 2) {
                    c3868b.f13015e = C3687f.m15089c(c3868b.f13016f, 0);
                    c3868b.f13016f = null;
                    c3868b.f13016f = new byte[(c3868b.f13015e + 3)];
                    C3687f.m15084b(c3868b.f13015e, c3868b.f13016f, 0);
                } else if (c3868b.f13014d >= c3868b.f13015e + 3) {
                    C3878b c3878b = new C3878b();
                    c3878b.f13044a = c3868b.f13015e;
                    c3878b.f13045b = c3868b.f13016f[2];
                    c3878b.f13049f = c3868b.f13017g.f13072c;
                    if (c3878b.f13045b != 26) {
                        return null;
                    }
                    if (c3878b.f13044a > 0) {
                        byte[] a;
                        bArr = new byte[c3878b.f13044a];
                        C3687f.m15077a(c3868b.f13016f, 3, bArr, 0, c3878b.f13044a);
                        if (c3868b.f13017g.f13077h == 48) {
                            a = C3658a.m14935a(bArr, this.f13020g == null ? C3685c.m15060b().m15069a() : C3700a.m15134a(this.f13020g));
                        } else {
                            a = c3868b.f13017g.f13077h == null ? bArr : bArr;
                        }
                        if (c3868b.f13017g.f13076g == -128) {
                            a = C3687f.m15092d(a);
                        } else if (c3868b.f13017g.f13076g != null) {
                            return null;
                        }
                        c3878b.m15955a(a);
                    }
                    c3868b.f13015e = 0;
                    c3868b.f13014d = 0;
                    c3868b.f13016f = null;
                    c3868b.f13017g = null;
                    if (this.d != null) {
                        C3685c.m15060b().m15055a(this.d.m15045c(c3667e, c3686d, c3878b));
                    }
                    c3868b.f13012b++;
                    if (c3868b.f13012b == c3868b.f13013c) {
                        c3868b.f13011a = 0;
                    }
                } else {
                    continue;
                }
            }
        }
        if (c3868b.f13012b > 0) {
            C3685c.m15060b().m15070c();
        }
        if (byteBuffer.remaining() > 0) {
            return m15922b(c3667e, c3686d, byteBuffer);
        }
        return null;
    }

    public Object m15921a(C3667e c3667e, C3686d c3686d, Object obj) {
        if (!(obj instanceof C3878b)) {
            return null;
        }
        C3878b c3878b = (C3878b) obj;
        C3882g a = C3869c.m15919a(c3878b);
        if (c3878b.f13045b > null && c3878b.f13044a > 0) {
            if ((a.f13076g & Downloads.STATUS_RUNNING) == SpdyProtocol.SLIGHTSSLV2) {
                c3878b.m15955a(C3687f.m15090c(c3878b.f13048e));
            }
            if ((a.f13077h & 48) == 16) {
                byte[] iv = EncryptUtils.getIV(C3687f.m15086b(a.f13086q));
                if ((a.f13075f & 16) != 16) {
                    c3878b.m15955a(EncryptUtils.aesEncSocket(c3878b.f13048e, iv));
                }
            } else if ((a.f13077h & 48) != 0) {
                if ((a.f13077h & 48) == 48) {
                    C3688a.m15097b(f13018a + "|encry type = 0x30 not support");
                    return null;
                } else if ((a.f13077h & 48) == 32) {
                    C3688a.m15097b(f13018a + "|encry type = 0x20 reserved");
                } else {
                    C3688a.m15097b(f13018a + "|encry type = " + (a.f13077h & 48) + " not support");
                    return null;
                }
            }
        }
        Object obj2 = new byte[((c3878b.f13045b > null ? c3878b.f13044a + 11 : 0) + a.f13071b)];
        int a2 = C3687f.m15074a(1944742139, (byte[]) obj2, 0);
        a2 += C3687f.m15088c(a.f13071b, obj2, a2);
        a2 += C3687f.m15088c(a.f13072c, obj2, a2);
        a2 += C3687f.m15088c(a.m15970a(), obj2, a2);
        a2 += C3687f.m15088c(a.f13074e, obj2, a2);
        byte[] rSAKeyId = EncryptUtils.getRSAKeyId();
        a2 += C3687f.m15088c(rSAKeyId.length, obj2, a2);
        a2 += C3687f.m15077a(rSAKeyId, 0, obj2, a2, rSAKeyId.length);
        a2 += C3687f.m15088c(a.m15972b(), obj2, a2);
        if (c3878b.f13044a > 0) {
            a2 += C3687f.m15088c(a.f13084o, obj2, a2);
            a2 += C3687f.m15077a(a.f13083n, 0, obj2, a2, a.f13084o);
        } else {
            a2 += C3687f.m15088c(0, obj2, a2);
        }
        if (c3878b.f13045b > null) {
            a2 += C3687f.m15074a(a.f13085p, (byte[]) obj2, a2);
            a2 += C3687f.m15074a(a.f13086q, (byte[]) obj2, a2);
            a2 += C3687f.m15084b(c3878b.f13044a, obj2, a2);
            a2 += C3687f.m15088c(c3878b.f13045b, obj2, a2);
            if (c3878b.f13044a > 0) {
                a2 += C3687f.m15077a(c3878b.f13048e, 0, obj2, a2, c3878b.f13044a);
                return obj2;
            }
        }
        return obj2;
    }

    public C3664f m15922b(C3667e c3667e, C3686d c3686d, Object obj) {
        if (c3686d.m15071a() == null) {
            c3686d.m15072a(new C3868b());
        }
        C3868b c3868b = (C3868b) c3686d.m15071a();
        ByteBuffer wrap = obj instanceof byte[] ? ByteBuffer.wrap((byte[]) obj) : (ByteBuffer) obj;
        byte b = wrap.get(5);
        if (b == 7) {
            return m15918a(c3667e, c3686d, c3868b, wrap);
        }
        if (b == 1) {
            return m15920b(c3667e, c3686d, c3868b, wrap);
        }
        C3688a.m15097b(f13018a + "|server socket resp version = " + b + ", not support !!!");
        return null;
    }

    public /* synthetic */ Object m15923c(C3667e c3667e, C3686d c3686d, Object obj) {
        return m15922b(c3667e, c3686d, obj);
    }
}
