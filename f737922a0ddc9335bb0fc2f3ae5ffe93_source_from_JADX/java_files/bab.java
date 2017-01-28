import java.text.ParseException;
import java.util.TimeZone;

public class bab extends ayv {
    private byte[] j6;

    public bab(String str) {
        this.j6 = bhl.FH(str);
        try {
            Hw();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    bab(byte[] bArr) {
        this.j6 = bArr;
    }

    public String FH() {
        String DW = bhl.DW(this.j6);
        if (DW.charAt(DW.length() - 1) == 'Z') {
            return DW.substring(0, DW.length() - 1) + "GMT+00:00";
        }
        int length = DW.length() - 5;
        char charAt = DW.charAt(length);
        if (charAt == '-' || charAt == '+') {
            return DW.substring(0, length) + "GMT" + DW.substring(length, length + 3) + ":" + DW.substring(length + 3);
        }
        length = DW.length() - 3;
        charAt = DW.charAt(length);
        if (charAt == '-' || charAt == '+') {
            return DW.substring(0, length) + "GMT" + DW.substring(length) + ":00";
        }
        return new StringBuilder(String.valueOf(DW)).append(v5()).toString();
    }

    private String v5() {
        String str = "+";
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            str = "-";
            rawOffset = -rawOffset;
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(Hw())) {
                rawOffset = (str.equals("+") ? 1 : -1) + i;
                return "GMT" + str + j6(rawOffset) + ":" + j6(i2);
            }
            rawOffset = i;
            return "GMT" + str + j6(rawOffset) + ":" + j6(i2);
        } catch (ParseException e) {
            rawOffset = i;
        }
    }

    private String j6(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return Integer.toString(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date Hw() {
        /*
        r10 = this;
        r3 = 1;
        r8 = 14;
        r7 = 0;
        r0 = r10.j6;
        r1 = bhl.DW(r0);
        r0 = "Z";
        r0 = r1.endsWith(r0);
        if (r0 == 0) goto L_0x0082;
    L_0x0013:
        r0 = r10.tp();
        if (r0 == 0) goto L_0x0079;
    L_0x0019:
        r0 = new java.text.SimpleDateFormat;
        r2 = "yyyyMMddHHmmss.SSS'Z'";
        r0.<init>(r2);
    L_0x0021:
        r2 = new java.util.SimpleTimeZone;
        r4 = "Z";
        r2.<init>(r7, r4);
        r0.setTimeZone(r2);
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x002f:
        r2 = r10.tp();
        if (r2 == 0) goto L_0x0074;
    L_0x0035:
        r4 = r0.substring(r8);
        r2 = r3;
    L_0x003a:
        r5 = r4.length();
        if (r2 < r5) goto L_0x00e9;
    L_0x0040:
        r5 = r2 + -1;
        r6 = 3;
        if (r5 <= r6) goto L_0x00f9;
    L_0x0045:
        r3 = new java.lang.StringBuilder;
        r5 = 4;
        r5 = r4.substring(r7, r5);
        r5 = java.lang.String.valueOf(r5);
        r3.<init>(r5);
        r2 = r4.substring(r2);
        r2 = r3.append(r2);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder;
        r0 = r0.substring(r7, r8);
        r0 = java.lang.String.valueOf(r0);
        r3.<init>(r0);
        r0 = r3.append(r2);
        r0 = r0.toString();
    L_0x0074:
        r0 = r1.parse(r0);
        return r0;
    L_0x0079:
        r0 = new java.text.SimpleDateFormat;
        r2 = "yyyyMMddHHmmss'Z'";
        r0.<init>(r2);
        goto L_0x0021;
    L_0x0082:
        r0 = 45;
        r0 = r1.indexOf(r0);
        if (r0 > 0) goto L_0x0092;
    L_0x008a:
        r0 = 43;
        r0 = r1.indexOf(r0);
        if (r0 <= 0) goto L_0x00bd;
    L_0x0092:
        r1 = r10.FH();
        r0 = r10.tp();
        if (r0 == 0) goto L_0x00b4;
    L_0x009c:
        r0 = new java.text.SimpleDateFormat;
        r2 = "yyyyMMddHHmmss.SSSz";
        r0.<init>(r2);
    L_0x00a4:
        r2 = new java.util.SimpleTimeZone;
        r4 = "Z";
        r2.<init>(r7, r4);
        r0.setTimeZone(r2);
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x002f;
    L_0x00b4:
        r0 = new java.text.SimpleDateFormat;
        r2 = "yyyyMMddHHmmssz";
        r0.<init>(r2);
        goto L_0x00a4;
    L_0x00bd:
        r0 = r10.tp();
        if (r0 == 0) goto L_0x00e0;
    L_0x00c3:
        r0 = new java.text.SimpleDateFormat;
        r2 = "yyyyMMddHHmmss.SSS";
        r0.<init>(r2);
    L_0x00cb:
        r2 = new java.util.SimpleTimeZone;
        r4 = java.util.TimeZone.getDefault();
        r4 = r4.getID();
        r2.<init>(r7, r4);
        r0.setTimeZone(r2);
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x002f;
    L_0x00e0:
        r0 = new java.text.SimpleDateFormat;
        r2 = "yyyyMMddHHmmss";
        r0.<init>(r2);
        goto L_0x00cb;
    L_0x00e9:
        r5 = r4.charAt(r2);
        r6 = 48;
        if (r6 > r5) goto L_0x0040;
    L_0x00f1:
        r6 = 57;
        if (r5 > r6) goto L_0x0040;
    L_0x00f5:
        r2 = r2 + 1;
        goto L_0x003a;
    L_0x00f9:
        r5 = r2 + -1;
        if (r5 != r3) goto L_0x0134;
    L_0x00fd:
        r3 = new java.lang.StringBuilder;
        r5 = r4.substring(r7, r2);
        r5 = java.lang.String.valueOf(r5);
        r3.<init>(r5);
        r5 = "00";
        r3 = r3.append(r5);
        r2 = r4.substring(r2);
        r2 = r3.append(r2);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder;
        r0 = r0.substring(r7, r8);
        r0 = java.lang.String.valueOf(r0);
        r3.<init>(r0);
        r0 = r3.append(r2);
        r0 = r0.toString();
        goto L_0x0074;
    L_0x0134:
        r3 = r2 + -1;
        r5 = 2;
        if (r3 != r5) goto L_0x0074;
    L_0x0139:
        r3 = new java.lang.StringBuilder;
        r5 = r4.substring(r7, r2);
        r5 = java.lang.String.valueOf(r5);
        r3.<init>(r5);
        r5 = "0";
        r3 = r3.append(r5);
        r2 = r4.substring(r2);
        r2 = r3.append(r2);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder;
        r0 = r0.substring(r7, r8);
        r0 = java.lang.String.valueOf(r0);
        r3.<init>(r0);
        r0 = r3.append(r2);
        r0 = r0.toString();
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: bab.Hw():java.util.Date");
    }

    private boolean tp() {
        int i = 0;
        while (i != this.j6.length) {
            if (this.j6[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
        return false;
    }

    boolean gn() {
        return false;
    }

    int u7() {
        int length = this.j6.length;
        return length + (bbg.j6(length) + 1);
    }

    void j6(ayt ayt) {
        ayt.j6(24, this.j6);
    }

    boolean j6(ayv ayv) {
        if (ayv instanceof bab) {
            return bhf.j6(this.j6, ((bab) ayv).j6);
        }
        return false;
    }

    public int hashCode() {
        return bhf.j6(this.j6);
    }
}
