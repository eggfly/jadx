package p000a;

import anet.channel.strategy.dispatch.C0714a;
import anet.channel.util.HttpConstant;
import com.facebook.ads.AdError;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.C0037c;
import p000a.p001a.p005c.C0027d;

/* renamed from: a.l */
public final class C0119l {
    private static final Pattern f498a;
    private static final Pattern f499b;
    private static final Pattern f500c;
    private static final Pattern f501d;
    private final String f502e;
    private final String f503f;
    private final long f504g;
    private final String f505h;
    private final String f506i;
    private final boolean f507j;
    private final boolean f508k;
    private final boolean f509l;
    private final boolean f510m;

    static {
        f498a = Pattern.compile("(\\d{2,4})[^\\d]*");
        f499b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f500c = Pattern.compile("(\\d{1,2})[^\\d]*");
        f501d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private C0119l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f502e = str;
        this.f503f = str2;
        this.f504g = j;
        this.f505h = str3;
        this.f506i = str4;
        this.f507j = z;
        this.f508k = z2;
        this.f510m = z3;
        this.f509l = z4;
    }

    private static int m512a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            Object obj = ((charAt >= ' ' || charAt == '\t') && charAt < '\u007f' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (obj == (!z ? 1 : null)) {
                return i3;
            }
        }
        return i2;
    }

    private static long m513a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong <= 0 ? Long.MIN_VALUE : parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return !str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? Long.MAX_VALUE : Long.MIN_VALUE;
            } else {
                throw e;
            }
        }
    }

    private static long m514a(String str, int i, int i2) {
        int a = C0119l.m512a(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        Matcher matcher = f501d.matcher(str);
        while (a < i2) {
            int a2 = C0119l.m512a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i3 == -1 && matcher.usePattern(f501d).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(f500c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f499b).matches()) {
                i7 = f499b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i8 == -1 && matcher.usePattern(f498a).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            }
            a = C0119l.m512a(str, a2 + 1, i2, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += 1900;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += AdError.SERVER_ERROR_CODE;
        }
        if (i8 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        } else {
            Calendar gregorianCalendar = new GregorianCalendar(C0037c.f121f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    static C0119l m515a(long j, C0130r c0130r, String str) {
        int length = str.length();
        int a = C0037c.m148a(str, 0, length, ';');
        int a2 = C0037c.m148a(str, 0, a, '=');
        if (a2 == a) {
            return null;
        }
        String c = C0037c.m170c(str, 0, a2);
        if (c.isEmpty()) {
            return null;
        }
        String substring;
        String c2 = C0037c.m170c(str, a2 + 1, a);
        long j2 = 253402300799999L;
        long j3 = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        a++;
        while (a < length) {
            long j4;
            int a3 = C0037c.m148a(str, a, length, ';');
            int a4 = C0037c.m148a(str, a, a3, '=');
            String c3 = C0037c.m170c(str, a, a4);
            String c4 = a4 < a3 ? C0037c.m170c(str, a4 + 1, a3) : BuildConfig.FLAVOR;
            if (c3.equalsIgnoreCase("expires")) {
                try {
                    j2 = C0119l.m514a(c4, 0, c4.length());
                    z4 = true;
                    c4 = str2;
                    j4 = j2;
                } catch (IllegalArgumentException e) {
                    c4 = str2;
                    j4 = j2;
                }
            } else {
                if (c3.equalsIgnoreCase("max-age")) {
                    try {
                        j3 = C0119l.m513a(c4);
                        z4 = true;
                        c4 = str2;
                        j4 = j2;
                    } catch (NumberFormatException e2) {
                        c4 = str2;
                        j4 = j2;
                    }
                } else {
                    if (c3.equalsIgnoreCase(C0714a.DOMAIN)) {
                        try {
                            c4 = C0119l.m518b(c4);
                            z3 = false;
                            j4 = j2;
                        } catch (IllegalArgumentException e3) {
                            c4 = str2;
                            j4 = j2;
                        }
                    } else {
                        if (c3.equalsIgnoreCase("path")) {
                            str3 = c4;
                            c4 = str2;
                            j4 = j2;
                        } else {
                            if (c3.equalsIgnoreCase("secure")) {
                                z = true;
                                c4 = str2;
                                j4 = j2;
                            } else {
                                if (c3.equalsIgnoreCase("httponly")) {
                                    z2 = true;
                                    c4 = str2;
                                    j4 = j2;
                                } else {
                                    c4 = str2;
                                    j4 = j2;
                                }
                            }
                        }
                    }
                }
            }
            String str4 = c4;
            a = a3 + 1;
            j2 = j4;
            str2 = str4;
        }
        if (j3 == Long.MIN_VALUE) {
            j3 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j3 = (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE) + j;
            if (j3 < j || j3 > 253402300799999L) {
                j3 = 253402300799999L;
            }
        } else {
            j3 = j2;
        }
        if (str2 == null) {
            str2 = c0130r.m598f();
        } else if (!C0119l.m519b(c0130r, str2)) {
            return null;
        }
        if (str3 == null || !str3.startsWith("/")) {
            str3 = c0130r.m600h();
            a = str3.lastIndexOf(47);
            substring = a != 0 ? str3.substring(0, a) : "/";
        } else {
            substring = str3;
        }
        return new C0119l(c, c2, j3, str2, substring, z, z2, z3, z4);
    }

    public static C0119l m516a(C0130r c0130r, String str) {
        return C0119l.m515a(System.currentTimeMillis(), c0130r, str);
    }

    public static List<C0119l> m517a(C0130r c0130r, C0127q c0127q) {
        List b = c0127q.m553b(HttpConstant.SET_COOKIE);
        List list = null;
        int size = b.size();
        for (int i = 0; i < size; i++) {
            C0119l a = C0119l.m516a(c0130r, (String) b.get(i));
            if (a != null) {
                List arrayList = list == null ? new ArrayList() : list;
                arrayList.add(a);
                list = arrayList;
            }
        }
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    private static String m518b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a = C0037c.m152a(str);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException();
    }

    private static boolean m519b(C0130r c0130r, String str) {
        String f = c0130r.m598f();
        return f.equals(str) ? true : f.endsWith(str) && f.charAt((f.length() - str.length()) - 1) == '.' && !C0037c.m168b(f);
    }

    public String m520a() {
        return this.f502e;
    }

    String m521a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f502e);
        stringBuilder.append('=');
        stringBuilder.append(this.f503f);
        if (this.f509l) {
            if (this.f504g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(C0027d.m102a(new Date(this.f504g)));
            }
        }
        if (!this.f510m) {
            stringBuilder.append("; domain=");
            if (z) {
                stringBuilder.append(".");
            }
            stringBuilder.append(this.f505h);
        }
        stringBuilder.append("; path=").append(this.f506i);
        if (this.f507j) {
            stringBuilder.append("; secure");
        }
        if (this.f508k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public String m522b() {
        return this.f503f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0119l)) {
            return false;
        }
        C0119l c0119l = (C0119l) obj;
        return c0119l.f502e.equals(this.f502e) && c0119l.f503f.equals(this.f503f) && c0119l.f505h.equals(this.f505h) && c0119l.f506i.equals(this.f506i) && c0119l.f504g == this.f504g && c0119l.f507j == this.f507j && c0119l.f508k == this.f508k && c0119l.f509l == this.f509l && c0119l.f510m == this.f510m;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f509l ? 0 : 1) + (((this.f508k ? 0 : 1) + (((this.f507j ? 0 : 1) + ((((((((((this.f502e.hashCode() + 527) * 31) + this.f503f.hashCode()) * 31) + this.f505h.hashCode()) * 31) + this.f506i.hashCode()) * 31) + ((int) (this.f504g ^ (this.f504g >>> 32)))) * 31)) * 31)) * 31)) * 31;
        if (!this.f510m) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return m521a(false);
    }
}
