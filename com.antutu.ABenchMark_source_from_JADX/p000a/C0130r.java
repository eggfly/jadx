package p000a;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import anet.channel.util.HttpConstant;
import cn.sharesdk.framework.Platform;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4216d;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import p000a.p001a.C0037c;

/* renamed from: a.r */
public final class C0130r {
    private static final char[] f540d;
    final String f541a;
    final String f542b;
    final int f543c;
    private final String f544e;
    private final String f545f;
    private final List<String> f546g;
    private final List<String> f547h;
    private final String f548i;
    private final String f549j;

    /* renamed from: a.r.a */
    public static final class C0129a {
        String f532a;
        String f533b;
        String f534c;
        String f535d;
        int f536e;
        final List<String> f537f;
        List<String> f538g;
        String f539h;

        /* renamed from: a.r.a.a */
        enum C0128a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C0129a() {
            this.f533b = BuildConfig.FLAVOR;
            this.f534c = BuildConfig.FLAVOR;
            this.f536e = -1;
            this.f537f = new ArrayList();
            this.f537f.add(BuildConfig.FLAVOR);
        }

        private static String m554a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == null && bArr[i5 + 1] == null) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.writeByte(58);
                    i += i2;
                    if (i == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong((long) (((bArr[i] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 1] & MotionEventCompat.ACTION_MASK)));
                    i += 2;
                }
            }
            return buffer.readUtf8();
        }

        private void m555a(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f537f.clear();
                    this.f537f.add(BuildConfig.FLAVOR);
                    i++;
                } else {
                    this.f537f.set(this.f537f.size() - 1, BuildConfig.FLAVOR);
                }
                int i3 = i;
                while (i3 < i2) {
                    int a = C0037c.m149a(str, i3, i2, "/\\");
                    boolean z = a < i2;
                    m556a(str, i3, a, z, true);
                    if (z) {
                        a++;
                    }
                    i3 = a;
                }
            }
        }

        private void m556a(String str, int i, int i2, boolean z, boolean z2) {
            String a = C0130r.m579a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (!m564f(a)) {
                if (m566g(a)) {
                    m561d();
                    return;
                }
                if (((String) this.f537f.get(this.f537f.size() - 1)).isEmpty()) {
                    this.f537f.set(this.f537f.size() - 1, a);
                } else {
                    this.f537f.add(a);
                }
                if (z) {
                    this.f537f.add(BuildConfig.FLAVOR);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean m557a(java.lang.String r7, int r8, int r9, byte[] r10, int r11) {
            /*
            r1 = 0;
            r0 = r8;
            r4 = r11;
        L_0x0003:
            if (r0 >= r9) goto L_0x004a;
        L_0x0005:
            r2 = r10.length;
            if (r4 != r2) goto L_0x000a;
        L_0x0008:
            r0 = r1;
        L_0x0009:
            return r0;
        L_0x000a:
            if (r4 == r11) goto L_0x0018;
        L_0x000c:
            r2 = r7.charAt(r0);
            r3 = 46;
            if (r2 == r3) goto L_0x0016;
        L_0x0014:
            r0 = r1;
            goto L_0x0009;
        L_0x0016:
            r0 = r0 + 1;
        L_0x0018:
            r2 = r1;
            r3 = r0;
        L_0x001a:
            if (r3 >= r9) goto L_0x0028;
        L_0x001c:
            r5 = r7.charAt(r3);
            r6 = 48;
            if (r5 < r6) goto L_0x0028;
        L_0x0024:
            r6 = 57;
            if (r5 <= r6) goto L_0x002e;
        L_0x0028:
            r0 = r3 - r0;
            if (r0 != 0) goto L_0x0042;
        L_0x002c:
            r0 = r1;
            goto L_0x0009;
        L_0x002e:
            if (r2 != 0) goto L_0x0034;
        L_0x0030:
            if (r0 == r3) goto L_0x0034;
        L_0x0032:
            r0 = r1;
            goto L_0x0009;
        L_0x0034:
            r2 = r2 * 10;
            r2 = r2 + r5;
            r2 = r2 + -48;
            r5 = 255; // 0xff float:3.57E-43 double:1.26E-321;
            if (r2 <= r5) goto L_0x003f;
        L_0x003d:
            r0 = r1;
            goto L_0x0009;
        L_0x003f:
            r3 = r3 + 1;
            goto L_0x001a;
        L_0x0042:
            r0 = r4 + 1;
            r2 = (byte) r2;
            r10[r4] = r2;
            r4 = r0;
            r0 = r3;
            goto L_0x0003;
        L_0x004a:
            r0 = r11 + 4;
            if (r4 == r0) goto L_0x0050;
        L_0x004e:
            r0 = r1;
            goto L_0x0009;
        L_0x0050:
            r0 = 1;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.r.a.a(java.lang.String, int, int, byte[], int):boolean");
        }

        private static int m558b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            int i3 = i + 1;
            while (i3 < i2) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                    return charAt2 == ':' ? i3 : -1;
                } else {
                    i3++;
                }
            }
            return -1;
        }

        private static int m559c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m560d(java.lang.String r3, int r4, int r5) {
            /*
            r0 = r4;
        L_0x0001:
            if (r0 >= r5) goto L_0x001a;
        L_0x0003:
            r1 = r3.charAt(r0);
            switch(r1) {
                case 58: goto L_0x001b;
                case 91: goto L_0x000d;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r0 + 1;
            goto L_0x0001;
        L_0x000d:
            r0 = r0 + 1;
            if (r0 >= r5) goto L_0x000a;
        L_0x0011:
            r1 = r3.charAt(r0);
            r2 = 93;
            if (r1 != r2) goto L_0x000d;
        L_0x0019:
            goto L_0x000a;
        L_0x001a:
            r0 = r5;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.r.a.d(java.lang.String, int, int):int");
        }

        private void m561d() {
            if (!((String) this.f537f.remove(this.f537f.size() - 1)).isEmpty() || this.f537f.isEmpty()) {
                this.f537f.add(BuildConfig.FLAVOR);
            } else {
                this.f537f.set(this.f537f.size() - 1, BuildConfig.FLAVOR);
            }
        }

        private static String m562e(String str, int i, int i2) {
            String a = C0130r.m580a(str, i, i2, false);
            if (!a.contains(":")) {
                return C0037c.m152a(a);
            }
            InetAddress f = (a.startsWith("[") && a.endsWith("]")) ? C0129a.m563f(a, 1, a.length() - 1) : C0129a.m563f(a, 0, a.length());
            if (f == null) {
                return null;
            }
            byte[] address = f.getAddress();
            if (address.length == 16) {
                return C0129a.m554a(address);
            }
            throw new AssertionError();
        }

        private static InetAddress m563f(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = i;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            while (i3 < i2) {
                if (i6 == bArr.length) {
                    return null;
                }
                int a;
                if (i3 + 2 > i2 || !str.regionMatches(i3, "::", 0, 2)) {
                    if (i6 != 0) {
                        if (str.regionMatches(i3, ":", 0, 1)) {
                            i3++;
                        } else if (!str.regionMatches(i3, ".", 0, 1)) {
                            return null;
                        } else {
                            if (!C0129a.m557a(str, i4, i2, bArr, i6 - 2)) {
                                return null;
                            }
                            i6 += 2;
                        }
                    }
                } else if (i5 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    i5 = i6 + 2;
                    if (i3 == i2) {
                        i6 = i5;
                        break;
                    }
                    i6 = i5;
                }
                i4 = 0;
                int i7 = i3;
                while (i7 < i2) {
                    a = C0130r.m577a(str.charAt(i7));
                    if (a == -1) {
                        break;
                    }
                    i4 = (i4 << 4) + a;
                    i7++;
                }
                a = i7 - i3;
                if (a == 0 || a > 4) {
                    return null;
                }
                a = i6 + 1;
                bArr[i6] = (byte) ((i4 >>> 8) & MotionEventCompat.ACTION_MASK);
                i6 = a + 1;
                bArr[a] = (byte) (i4 & MotionEventCompat.ACTION_MASK);
                i4 = i3;
                i3 = i7;
            }
            if (i6 != bArr.length) {
                if (i5 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i5, bArr, bArr.length - (i6 - i5), i6 - i5);
                Arrays.fill(bArr, i5, (bArr.length - i6) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        private boolean m564f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static int m565g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C0130r.m579a(str, i, i2, BuildConfig.FLAVOR, false, false, false, true));
                return (parseInt <= 0 || parseInt > Platform.CUSTOMER_ACTION_MASK) ? -1 : parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        private boolean m566g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        int m567a() {
            return this.f536e != -1 ? this.f536e : C0130r.m578a(this.f532a);
        }

        C0128a m568a(C0130r c0130r, String str) {
            int d;
            int a = C0037c.m147a(str, 0, str.length());
            int b = C0037c.m167b(str, a, str.length());
            if (C0129a.m558b(str, a, b) != -1) {
                if (str.regionMatches(true, a, "https:", 0, 6)) {
                    this.f532a = HttpConstant.HTTPS;
                    a += "https:".length();
                } else {
                    if (!str.regionMatches(true, a, "http:", 0, 5)) {
                        return C0128a.UNSUPPORTED_SCHEME;
                    }
                    this.f532a = HttpConstant.HTTP;
                    a += "http:".length();
                }
            } else if (c0130r == null) {
                return C0128a.MISSING_SCHEME;
            } else {
                this.f532a = c0130r.f541a;
            }
            int c = C0129a.m559c(str, a, b);
            if (c >= 2 || c0130r == null || !c0130r.f541a.equals(this.f532a)) {
                Object obj = null;
                Object obj2 = null;
                int i = a + c;
                while (true) {
                    Object obj3;
                    Object obj4;
                    int a2 = C0037c.m149a(str, i, b, "@/\\?#");
                    switch (a2 != b ? str.charAt(a2) : '\uffff') {
                        case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                        case jni.SID_UX_DATA /*35*/:
                        case C1692R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                        case C1692R.styleable.AppCompatTheme_editTextBackground /*63*/:
                        case C1692R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                            d = C0129a.m560d(str, i, a2);
                            if (d + 1 < a2) {
                                this.f535d = C0129a.m562e(str, i, d);
                                this.f536e = C0129a.m565g(str, d + 1, a2);
                                if (this.f536e == -1) {
                                    return C0128a.INVALID_PORT;
                                }
                            }
                            this.f535d = C0129a.m562e(str, i, d);
                            this.f536e = C0130r.m578a(this.f532a);
                            if (this.f535d != null) {
                                a = a2;
                                break;
                            }
                            return C0128a.INVALID_HOST;
                        case C4216d.f14307c /*64*/:
                            if (obj == null) {
                                a = C0037c.m148a(str, i, a2, ':');
                                String a3 = C0130r.m579a(str, i, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (obj2 != null) {
                                    a3 = this.f533b + "%40" + a3;
                                }
                                this.f533b = a3;
                                if (a != a2) {
                                    obj = 1;
                                    this.f534c = C0130r.m579a(str, a + 1, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                obj2 = 1;
                            } else {
                                this.f534c += "%40" + C0130r.m579a(str, i, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            a = a2 + 1;
                            obj3 = obj;
                            obj4 = obj2;
                            continue;
                        default:
                            obj3 = obj;
                            a = i;
                            obj4 = obj2;
                            continue;
                    }
                    obj = obj3;
                    obj2 = obj4;
                    i = a;
                }
            } else {
                this.f533b = c0130r.m596d();
                this.f534c = c0130r.m597e();
                this.f535d = c0130r.f542b;
                this.f536e = c0130r.f543c;
                this.f537f.clear();
                this.f537f.addAll(c0130r.m601i());
                if (a == b || str.charAt(a) == '#') {
                    m576e(c0130r.m602j());
                }
            }
            d = C0037c.m149a(str, a, b, "?#");
            m555a(str, a, d);
            if (d >= b || str.charAt(d) != '?') {
                a = d;
            } else {
                a = C0037c.m148a(str, d, b, '#');
                this.f538g = C0130r.m588b(C0130r.m579a(str, d + 1, a, " \"'<>#", true, false, true, true));
            }
            if (a < b && str.charAt(a) == '#') {
                this.f539h = C0130r.m579a(str, a + 1, b, BuildConfig.FLAVOR, true, false, false, false);
            }
            return C0128a.SUCCESS;
        }

        public C0129a m569a(int i) {
            if (i <= 0 || i > Platform.CUSTOMER_ACTION_MASK) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f536e = i;
            return this;
        }

        public C0129a m570a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpConstant.HTTP)) {
                this.f532a = HttpConstant.HTTP;
            } else if (str.equalsIgnoreCase(HttpConstant.HTTPS)) {
                this.f532a = HttpConstant.HTTPS;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        C0129a m571b() {
            int size = this.f537f.size();
            for (int i = 0; i < size; i++) {
                this.f537f.set(i, C0130r.m581a((String) this.f537f.get(i), "[]", true, true, false, true));
            }
            if (this.f538g != null) {
                int size2 = this.f538g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) this.f538g.get(i2);
                    if (str != null) {
                        this.f538g.set(i2, C0130r.m581a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f539h != null) {
                this.f539h = C0130r.m581a(this.f539h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public C0129a m572b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f533b = C0130r.m581a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public C0129a m573c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f534c = C0130r.m581a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public C0130r m574c() {
            if (this.f532a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f535d != null) {
                return new C0130r(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public C0129a m575d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String e = C0129a.m562e(str, 0, str.length());
            if (e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f535d = e;
            return this;
        }

        public C0129a m576e(String str) {
            List b;
            if (str != null) {
                b = C0130r.m588b(C0130r.m581a(str, " \"'<>#", true, false, true, true));
            } else {
                b = null;
            }
            this.f538g = b;
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f532a);
            stringBuilder.append(HttpConstant.SCHEME_SPLIT);
            if (!(this.f533b.isEmpty() && this.f534c.isEmpty())) {
                stringBuilder.append(this.f533b);
                if (!this.f534c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f534c);
                }
                stringBuilder.append('@');
            }
            if (this.f535d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f535d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f535d);
            }
            int a = m567a();
            if (a != C0130r.m578a(this.f532a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            C0130r.m584a(stringBuilder, this.f537f);
            if (this.f538g != null) {
                stringBuilder.append('?');
                C0130r.m589b(stringBuilder, this.f538g);
            }
            if (this.f539h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f539h);
            }
            return stringBuilder.toString();
        }
    }

    static {
        f540d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    C0130r(C0129a c0129a) {
        String str = null;
        this.f541a = c0129a.f532a;
        this.f544e = C0130r.m582a(c0129a.f533b, false);
        this.f545f = C0130r.m582a(c0129a.f534c, false);
        this.f542b = c0129a.f535d;
        this.f543c = c0129a.m567a();
        this.f546g = m583a(c0129a.f537f, false);
        this.f547h = c0129a.f538g != null ? m583a(c0129a.f538g, true) : null;
        if (c0129a.f539h != null) {
            str = C0130r.m582a(c0129a.f539h, false);
        }
        this.f548i = str;
        this.f549j = c0129a.toString();
    }

    static int m577a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    public static int m578a(String str) {
        return str.equals(HttpConstant.HTTP) ? 80 : str.equals(HttpConstant.HTTPS) ? Constants.PORT : -1;
    }

    static String m579a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == TransportMediator.KEYCODE_MEDIA_PAUSE || ((codePointAt >= SpdyProtocol.SLIGHTSSLV2 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !C0130r.m587a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                C0130r.m585a(buffer, str, i3, i2, str2, z, z2, z3, z4);
                return buffer.readUtf8();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static String m580a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                C0130r.m586a(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    static String m581a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return C0130r.m579a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String m582a(String str, boolean z) {
        return C0130r.m580a(str, 0, str.length(), z);
    }

    private List<String> m583a(List<String> list, boolean z) {
        int size = list.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? C0130r.m582a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void m584a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    static void m585a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == TransportMediator.KEYCODE_MEDIA_PAUSE || ((codePointAt >= SpdyProtocol.SLIGHTSSLV2 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !C0130r.m587a(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & MotionEventCompat.ACTION_MASK;
                        buffer.writeByte(37);
                        buffer.writeByte(f540d[(readByte >> 4) & 15]);
                        buffer.writeByte(f540d[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void m586a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt != 37 || i3 + 2 >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int a = C0130r.m577a(str.charAt(i3 + 1));
                int a2 = C0130r.m577a(str.charAt(i3 + 2));
                if (!(a == -1 || a2 == -1)) {
                    buffer.writeByte((a << 4) + a2);
                    i3 += 2;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    static boolean m587a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && C0130r.m577a(str.charAt(i + 1)) != -1 && C0130r.m577a(str.charAt(i + 2)) != -1;
    }

    static List<String> m588b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void m589b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    public static C0130r m590e(String str) {
        C0129a c0129a = new C0129a();
        return c0129a.m568a(null, str) == C0128a.SUCCESS ? c0129a.m574c() : null;
    }

    public URI m591a() {
        String c0129a = m606n().m571b().toString();
        try {
            return new URI(c0129a);
        } catch (Throwable e) {
            try {
                return URI.create(c0129a.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String m592b() {
        return this.f541a;
    }

    public C0130r m593c(String str) {
        C0129a d = m595d(str);
        return d != null ? d.m574c() : null;
    }

    public boolean m594c() {
        return this.f541a.equals(HttpConstant.HTTPS);
    }

    public C0129a m595d(String str) {
        C0129a c0129a = new C0129a();
        return c0129a.m568a(this, str) == C0128a.SUCCESS ? c0129a : null;
    }

    public String m596d() {
        if (this.f544e.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f541a.length() + 3;
        return this.f549j.substring(length, C0037c.m149a(this.f549j, length, this.f549j.length(), ":@"));
    }

    public String m597e() {
        if (this.f545f.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return this.f549j.substring(this.f549j.indexOf(58, this.f541a.length() + 3) + 1, this.f549j.indexOf(64));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0130r) && ((C0130r) obj).f549j.equals(this.f549j);
    }

    public String m598f() {
        return this.f542b;
    }

    public int m599g() {
        return this.f543c;
    }

    public String m600h() {
        int indexOf = this.f549j.indexOf(47, this.f541a.length() + 3);
        return this.f549j.substring(indexOf, C0037c.m149a(this.f549j, indexOf, this.f549j.length(), "?#"));
    }

    public int hashCode() {
        return this.f549j.hashCode();
    }

    public List<String> m601i() {
        int indexOf = this.f549j.indexOf(47, this.f541a.length() + 3);
        int a = C0037c.m149a(this.f549j, indexOf, this.f549j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = C0037c.m148a(this.f549j, i, a, '/');
            arrayList.add(this.f549j.substring(i, indexOf));
        }
        return arrayList;
    }

    public String m602j() {
        if (this.f547h == null) {
            return null;
        }
        int indexOf = this.f549j.indexOf(63) + 1;
        return this.f549j.substring(indexOf, C0037c.m148a(this.f549j, indexOf + 1, this.f549j.length(), '#'));
    }

    public String m603k() {
        if (this.f547h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C0130r.m589b(stringBuilder, this.f547h);
        return stringBuilder.toString();
    }

    public String m604l() {
        if (this.f548i == null) {
            return null;
        }
        return this.f549j.substring(this.f549j.indexOf(35) + 1);
    }

    public String m605m() {
        return m595d("/...").m572b(BuildConfig.FLAVOR).m573c(BuildConfig.FLAVOR).m574c().toString();
    }

    public C0129a m606n() {
        C0129a c0129a = new C0129a();
        c0129a.f532a = this.f541a;
        c0129a.f533b = m596d();
        c0129a.f534c = m597e();
        c0129a.f535d = this.f542b;
        c0129a.f536e = this.f543c != C0130r.m578a(this.f541a) ? this.f543c : -1;
        c0129a.f537f.clear();
        c0129a.f537f.addAll(m601i());
        c0129a.m576e(m602j());
        c0129a.f539h = m604l();
        return c0129a;
    }

    public String toString() {
        return this.f549j;
    }
}
