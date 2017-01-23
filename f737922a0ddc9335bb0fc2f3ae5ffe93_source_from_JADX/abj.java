import java.util.HashMap;

public final class abj implements Comparable<abj> {
    private static final HashMap<String, abj> j6;
    private final String DW;
    private final abl FH;
    private final abk Hw;
    private abk v5;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((abj) obj);
    }

    static {
        j6 = new HashMap(500);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static abj j6(java.lang.String r7) {
        /*
        r3 = 0;
        if (r7 != 0) goto L_0x000c;
    L_0x0003:
        r0 = new java.lang.NullPointerException;
        r1 = "descriptor == null";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r1 = j6;
        monitor-enter(r1);
        r0 = j6;	 Catch:{ all -> 0x001b }
        r0 = r0.get(r7);	 Catch:{ all -> 0x001b }
        r0 = (abj) r0;	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x001e;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
    L_0x001e:
        r5 = DW(r7);
        r0 = 1;
        r2 = r3;
    L_0x0024:
        r1 = r7.charAt(r0);
        r4 = 41;
        if (r1 != r4) goto L_0x0084;
    L_0x002c:
        r0 = r0 + 1;
        r0 = r7.substring(r0);
        r0 = abl.DW(r0);
        r1 = new abk;
        r1.<init>(r2);
    L_0x003b:
        if (r3 >= r2) goto L_0x007a;
    L_0x003d:
        r4 = r5[r3];
        r1.j6(r3, r4);
        r3 = r3 + 1;
        goto L_0x003b;
    L_0x0045:
        r6 = 91;
        if (r1 != r6) goto L_0x0050;
    L_0x0049:
        r4 = r4 + 1;
        r1 = r7.charAt(r4);
        goto L_0x0045;
    L_0x0050:
        r6 = 76;
        if (r1 != r6) goto L_0x0077;
    L_0x0054:
        r1 = 59;
        r1 = r7.indexOf(r1, r4);
        r4 = -1;
        if (r1 != r4) goto L_0x0066;
    L_0x005d:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "bad descriptor";
        r0.<init>(r1);
        throw r0;
    L_0x0066:
        r1 = r1 + 1;
    L_0x0068:
        r0 = r7.substring(r0, r1);
        r0 = abl.j6(r0);
        r5[r2] = r0;
        r0 = r2 + 1;
        r2 = r0;
        r0 = r1;
        goto L_0x0024;
    L_0x0077:
        r1 = r4 + 1;
        goto L_0x0068;
    L_0x007a:
        r2 = new abj;
        r2.<init>(r7, r0, r1);
        r0 = DW(r2);
        goto L_0x001a;
    L_0x0084:
        r4 = r0;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: abj.j6(java.lang.String):abj");
    }

    private static abl[] DW(String str) {
        int length = str.length();
        if (str.charAt(0) != '(') {
            throw new IllegalArgumentException("bad descriptor");
        }
        int i = 1;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == ')') {
                break;
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                i2++;
            }
            i++;
        }
        i = 0;
        if (i == 0 || i == length - 1) {
            throw new IllegalArgumentException("bad descriptor");
        } else if (str.indexOf(41, i + 1) == -1) {
            return new abl[i2];
        } else {
            throw new IllegalArgumentException("bad descriptor");
        }
    }

    public static abj j6(String str, abl abl, boolean z, boolean z2) {
        abj j6 = j6(str);
        if (z) {
            return j6;
        }
        if (z2) {
            abl = abl.j6(Integer.MAX_VALUE);
        }
        return j6.j6(abl);
    }

    public static abj j6(abl abl, int i) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('(');
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append('I');
        }
        stringBuffer.append(')');
        stringBuffer.append(abl.gn());
        return j6(stringBuffer.toString());
    }

    private abj(String str, abl abl, abk abk) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        } else if (abl == null) {
            throw new NullPointerException("returnType == null");
        } else if (abk == null) {
            throw new NullPointerException("parameterTypes == null");
        } else {
            this.DW = str;
            this.FH = abl;
            this.Hw = abk;
            this.v5 = null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof abj) {
            return this.DW.equals(((abj) obj).DW);
        }
        return false;
    }

    public int hashCode() {
        return this.DW.hashCode();
    }

    public int j6(abj abj) {
        if (this == abj) {
            return 0;
        }
        int j6 = this.FH.j6(abj.FH);
        if (j6 != 0) {
            return j6;
        }
        int m_ = this.Hw.m_();
        int m_2 = abj.Hw.m_();
        int min = Math.min(m_, m_2);
        for (int i = 0; i < min; i++) {
            j6 = this.Hw.DW(i).j6(abj.Hw.DW(i));
            if (j6 != 0) {
                return j6;
            }
        }
        if (m_ < m_2) {
            return -1;
        }
        if (m_ > m_2) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return this.DW;
    }

    public String j6() {
        return this.DW;
    }

    public abl DW() {
        return this.FH;
    }

    public abk FH() {
        return this.Hw;
    }

    public abk Hw() {
        if (this.v5 == null) {
            int m_ = this.Hw.m_();
            abk abk = new abk(m_);
            Object obj = null;
            for (int i = 0; i < m_; i++) {
                abl DW = this.Hw.DW(i);
                if (DW.J0()) {
                    obj = 1;
                    DW = abl.Zo;
                }
                abk.j6(i, DW);
            }
            this.v5 = obj != null ? abk : this.Hw;
        }
        return this.v5;
    }

    public abj j6(abl abl) {
        String str = "(" + abl.gn() + this.DW.substring(1);
        abk FH = this.Hw.FH(abl);
        FH.l_();
        return DW(new abj(str, this.FH, FH));
    }

    private static abj DW(abj abj) {
        synchronized (j6) {
            String j6 = abj.j6();
            abj abj2 = (abj) j6.get(j6);
            if (abj2 != null) {
                return abj2;
            }
            j6.put(j6, abj);
            return abj;
        }
    }
}
