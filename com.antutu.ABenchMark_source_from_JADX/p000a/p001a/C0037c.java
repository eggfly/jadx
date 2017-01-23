package p000a.p001a;

import com.umeng.message.proguard.C4218e;
import com.umeng.message.util.HttpRequest;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;
import p000a.C0130r;
import p000a.C0140y;
import p000a.aa;

/* renamed from: a.a.c */
public final class C0037c {
    public static final byte[] f116a;
    public static final String[] f117b;
    public static final aa f118c;
    public static final C0140y f119d;
    public static final Charset f120e;
    public static final TimeZone f121f;
    private static final ByteString f122g;
    private static final ByteString f123h;
    private static final ByteString f124i;
    private static final ByteString f125j;
    private static final ByteString f126k;
    private static final Charset f127l;
    private static final Charset f128m;
    private static final Charset f129n;
    private static final Charset f130o;
    private static final Pattern f131p;

    /* renamed from: a.a.c.1 */
    static class C00221 implements ThreadFactory {
        final /* synthetic */ String f91a;
        final /* synthetic */ boolean f92b;

        C00221(String str, boolean z) {
            this.f91a = str;
            this.f92b = z;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f91a);
            thread.setDaemon(this.f92b);
            return thread;
        }
    }

    static {
        f116a = new byte[0];
        f117b = new String[0];
        f118c = aa.m126a(null, f116a);
        f119d = C0140y.m670a(null, f116a);
        f122g = ByteString.decodeHex("efbbbf");
        f123h = ByteString.decodeHex("feff");
        f124i = ByteString.decodeHex("fffe");
        f125j = ByteString.decodeHex("0000ffff");
        f126k = ByteString.decodeHex("ffff0000");
        f120e = Charset.forName(HttpRequest.f14548a);
        f127l = Charset.forName(C4218e.f14339d);
        f128m = Charset.forName(C4218e.f14340e);
        f129n = Charset.forName("UTF-32BE");
        f130o = Charset.forName("UTF-32LE");
        f121f = TimeZone.getTimeZone("GMT");
        f131p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int m147a(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                case C4574a.ORDERED /*32*/:
                    i3++;
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int m148a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    public static int m149a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static <T> int m150a(T[] tArr, T t) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (C0037c.m163a(tArr[i], (Object) t)) {
                return i;
            }
        }
        return -1;
    }

    public static String m151a(C0130r c0130r, boolean z) {
        String f = c0130r.m598f().contains(":") ? "[" + c0130r.m598f() + "]" : c0130r.m598f();
        return (z || c0130r.m599g() != C0130r.m578a(c0130r.m592b())) ? f + ":" + c0130r.m599g() : f;
    }

    public static String m152a(String str) {
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            return (toLowerCase.isEmpty() || C0037c.m171c(toLowerCase)) ? null : toLowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static String m153a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset m154a(BufferedSource bufferedSource, Charset charset) {
        if (bufferedSource.rangeEquals(0, f122g)) {
            bufferedSource.skip((long) f122g.size());
            return f120e;
        } else if (bufferedSource.rangeEquals(0, f123h)) {
            bufferedSource.skip((long) f123h.size());
            return f127l;
        } else if (bufferedSource.rangeEquals(0, f124i)) {
            bufferedSource.skip((long) f124i.size());
            return f128m;
        } else if (bufferedSource.rangeEquals(0, f125j)) {
            bufferedSource.skip((long) f125j.size());
            return f129n;
        } else if (!bufferedSource.rangeEquals(0, f126k)) {
            return charset;
        } else {
            bufferedSource.skip((long) f126k.size());
            return f130o;
        }
    }

    public static <T> List<T> m155a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> m156a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    private static <T> List<T> m157a(T[] tArr, T[] tArr2) {
        List<T> arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static ThreadFactory m158a(String str, boolean z) {
        return new C00221(str, z);
    }

    public static void m159a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void m160a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void m161a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!C0037c.m162a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static boolean m162a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean m163a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean m164a(Source source, int i, TimeUnit timeUnit) {
        try {
            return C0037c.m169b(source, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static <T> T[] m165a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a = C0037c.m157a((Object[]) tArr, (Object[]) tArr2);
        return a.toArray((Object[]) Array.newInstance(cls, a.size()));
    }

    public static String[] m166a(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int m167b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                case C4574a.ORDERED /*32*/:
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static boolean m168b(String str) {
        return f131p.matcher(str).matches();
    }

    public static boolean m169b(okio.Source r12, int r13, java.util.concurrent.TimeUnit r14) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x006a in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = java.lang.System.nanoTime();
        r0 = r12.timeout();
        r0 = r0.hasDeadline();
        if (r0 == 0) goto L_0x0051;
    L_0x0013:
        r0 = r12.timeout();
        r0 = r0.deadlineNanoTime();
        r0 = r0 - r6;
    L_0x001c:
        r4 = r12.timeout();
        r8 = (long) r13;
        r8 = r14.toNanos(r8);
        r8 = java.lang.Math.min(r0, r8);
        r8 = r8 + r6;
        r4.deadlineNanoTime(r8);
        r4 = new okio.Buffer;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r4.<init>();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
    L_0x0032:
        r8 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r8 = r12.read(r4, r8);	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r10 = -1;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        if (r5 == 0) goto L_0x0053;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
    L_0x003e:
        r4.clear();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        goto L_0x0032;
    L_0x0042:
        r4 = move-exception;
        r4 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x006a;
    L_0x0048:
        r0 = r12.timeout();
        r0.clearDeadline();
    L_0x004f:
        r0 = r4;
    L_0x0050:
        return r0;
    L_0x0051:
        r0 = r2;
        goto L_0x001c;
    L_0x0053:
        r4 = 1;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0061;
    L_0x0058:
        r0 = r12.timeout();
        r0.clearDeadline();
    L_0x005f:
        r0 = r4;
        goto L_0x0050;
    L_0x0061:
        r2 = r12.timeout();
        r0 = r0 + r6;
        r2.deadlineNanoTime(r0);
        goto L_0x005f;
    L_0x006a:
        r2 = r12.timeout();
        r0 = r0 + r6;
        r2.deadlineNanoTime(r0);
        goto L_0x004f;
    L_0x0073:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0080;
    L_0x0078:
        r0 = r12.timeout();
        r0.clearDeadline();
    L_0x007f:
        throw r4;
    L_0x0080:
        r2 = r12.timeout();
        r0 = r0 + r6;
        r2.deadlineNanoTime(r0);
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.c.b(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static String m170c(String str, int i, int i2) {
        int a = C0037c.m147a(str, i, i2);
        return str.substring(a, C0037c.m167b(str, a, i2));
    }

    private static boolean m171c(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= '\u001f' || charAt >= '\u007f') {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }
}
