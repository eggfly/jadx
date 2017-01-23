package p023b.p024a;

import android.util.Log;
import com.facebook.ads.AdError;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Formatter;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.ap */
public class ap {
    public static boolean f2680a;
    private static String f2681b;
    private static int f2682c;

    static {
        f2680a = false;
        f2681b = C4156a.f13942d;
        f2682c = AdError.SERVER_ERROR_CODE;
    }

    private static void m3380a(int i, String str, String str2, Throwable th) {
        int length = str2.length();
        int i2 = 0;
        int i3 = f2682c;
        int i4 = 0;
        while (i2 < 100) {
            if (length > i3) {
                switch (i) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        Log.v(str, str2.substring(i4, i3));
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        Log.d(str, str2.substring(i4, i3));
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        Log.i(str, str2.substring(i4, i3));
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        Log.w(str, str2.substring(i4, i3));
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        Log.e(str, str2.substring(i4, i3));
                        break;
                }
                int i5 = i3 + f2682c;
                if (th != null) {
                    for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                        switch (i) {
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                Log.v(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                Log.d(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                                Log.i(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case SpdyProtocol.QUIC /*4*/:
                                Log.w(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                                Log.e(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            default:
                                break;
                        }
                    }
                }
                i2++;
                i4 = i3;
                i3 = i5;
            } else {
                switch (i) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        Log.v(str, str2.substring(i4, length));
                        return;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        Log.d(str, str2.substring(i4, length));
                        return;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        Log.i(str, str2.substring(i4, length));
                        return;
                    case SpdyProtocol.QUIC /*4*/:
                        Log.w(str, str2.substring(i4, length));
                        return;
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        Log.e(str, str2.substring(i4, length));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void m3381a(String str) {
        ap.m3382a(f2681b, str, null);
    }

    public static void m3382a(String str, String str2, Throwable th) {
        if (f2680a) {
            ap.m3380a(2, str, str2, th);
        }
    }

    public static void m3383a(String str, Throwable th) {
        ap.m3392d(f2681b, str, th);
    }

    public static void m3384a(String str, Object... objArr) {
        try {
            String str2 = BuildConfig.FLAVOR;
            if (str.contains("%")) {
                ap.m3392d(f2681b, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            ap.m3392d(str, str2, null);
        } catch (Throwable th) {
            ap.m3385a(th);
        }
    }

    public static void m3385a(Throwable th) {
        ap.m3392d(f2681b, null, th);
    }

    public static void m3386b(String str) {
        ap.m3387b(f2681b, str, null);
    }

    public static void m3387b(String str, String str2, Throwable th) {
        if (f2680a) {
            ap.m3380a(3, str, str2, th);
        }
    }

    public static void m3388b(String str, Object... objArr) {
        try {
            String str2 = BuildConfig.FLAVOR;
            if (str.contains("%")) {
                ap.m3390c(f2681b, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            ap.m3390c(str, str2, null);
        } catch (Throwable th) {
            ap.m3385a(th);
        }
    }

    public static void m3389c(String str) {
        ap.m3390c(f2681b, str, null);
    }

    public static void m3390c(String str, String str2, Throwable th) {
        if (f2680a) {
            ap.m3380a(4, str, str2, th);
        }
    }

    public static void m3391d(String str) {
        ap.m3392d(f2681b, str, null);
    }

    public static void m3392d(String str, String str2, Throwable th) {
        if (f2680a) {
            ap.m3380a(5, str, str2, th);
        }
    }
}
