package p000a.p001a.p005c;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p000a.p001a.C0037c;

/* renamed from: a.a.c.d */
public final class C0027d {
    private static final ThreadLocal<DateFormat> f95a;
    private static final String[] f96b;
    private static final DateFormat[] f97c;

    /* renamed from: a.a.c.d.1 */
    static class C00261 extends ThreadLocal<DateFormat> {
        C00261() {
        }

        protected DateFormat m101a() {
            DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C0037c.f121f);
            return simpleDateFormat;
        }

        protected /* synthetic */ Object initialValue() {
            return m101a();
        }
    }

    static {
        f95a = new C00261();
        f96b = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f97c = new DateFormat[f96b.length];
    }

    public static String m102a(Date date) {
        return ((DateFormat) f95a.get()).format(date);
    }

    public static Date m103a(String str) {
        int i = 0;
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f95a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f96b) {
            int length = f96b.length;
            while (i < length) {
                DateFormat dateFormat = f97c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f96b[i], Locale.US);
                    dateFormat.setTimeZone(C0037c.f121f);
                    f97c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                parse = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse;
                }
                i++;
            }
            return null;
        }
    }
}
