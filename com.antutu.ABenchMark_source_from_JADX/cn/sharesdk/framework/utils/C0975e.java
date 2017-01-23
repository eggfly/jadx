package cn.sharesdk.framework.utils;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;

/* renamed from: cn.sharesdk.framework.utils.e */
public abstract class C0975e implements Escaper {
    private static final ThreadLocal<char[]> f3345a;

    /* renamed from: cn.sharesdk.framework.utils.e.1 */
    class C09801 implements Appendable {
        int f3355a;
        char[] f3356b;
        final /* synthetic */ Appendable f3357c;
        final /* synthetic */ C0975e f3358d;

        C09801(C0975e c0975e, Appendable appendable) {
            this.f3358d = c0975e;
            this.f3357c = appendable;
            this.f3355a = -1;
            this.f3356b = new char[2];
        }

        private void m4392a(char[] cArr, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                this.f3357c.append(cArr[i2]);
            }
        }

        public Appendable append(char c) {
            char[] a;
            if (this.f3355a != -1) {
                if (Character.isLowSurrogate(c)) {
                    a = this.f3358d.m4369a(Character.toCodePoint((char) this.f3355a, c));
                    if (a != null) {
                        m4392a(a, a.length);
                    } else {
                        this.f3357c.append((char) this.f3355a);
                        this.f3357c.append(c);
                    }
                    this.f3355a = -1;
                } else {
                    throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + c);
                }
            } else if (Character.isHighSurrogate(c)) {
                this.f3355a = c;
            } else if (Character.isLowSurrogate(c)) {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + c);
            } else {
                a = this.f3358d.m4369a(c);
                if (a != null) {
                    m4392a(a, a.length);
                } else {
                    this.f3357c.append(c);
                }
            }
            return this;
        }

        public Appendable append(CharSequence charSequence) {
            return append(charSequence, 0, charSequence.length());
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Appendable append(java.lang.CharSequence r6, int r7, int r8) {
            /*
            r5 = this;
            r4 = -1;
            if (r7 >= r8) goto L_0x0052;
        L_0x0003:
            r0 = r5.f3355a;
            if (r0 == r4) goto L_0x008c;
        L_0x0007:
            r0 = r7 + 1;
            r1 = r6.charAt(r7);
            r2 = java.lang.Character.isLowSurrogate(r1);
            if (r2 != 0) goto L_0x002c;
        L_0x0013:
            r0 = new java.lang.IllegalArgumentException;
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Expected low surrogate character but got ";
            r2 = r2.append(r3);
            r1 = r2.append(r1);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x002c:
            r2 = r5.f3358d;
            r3 = r5.f3355a;
            r3 = (char) r3;
            r1 = java.lang.Character.toCodePoint(r3, r1);
            r1 = r2.m4369a(r1);
            if (r1 == 0) goto L_0x0053;
        L_0x003b:
            r2 = r1.length;
            r5.m4392a(r1, r2);
            r7 = r7 + 1;
        L_0x0041:
            r5.f3355a = r4;
        L_0x0043:
            r1 = r5.f3358d;
            r1 = r1.m4367a(r6, r0, r8);
            if (r1 <= r7) goto L_0x0050;
        L_0x004b:
            r0 = r5.f3357c;
            r0.append(r6, r7, r1);
        L_0x0050:
            if (r1 != r8) goto L_0x005c;
        L_0x0052:
            return r5;
        L_0x0053:
            r1 = r5.f3357c;
            r2 = r5.f3355a;
            r2 = (char) r2;
            r1.append(r2);
            goto L_0x0041;
        L_0x005c:
            r0 = cn.sharesdk.framework.utils.C0975e.m4366b(r6, r1, r8);
            if (r0 >= 0) goto L_0x0066;
        L_0x0062:
            r0 = -r0;
            r5.f3355a = r0;
            goto L_0x0052;
        L_0x0066:
            r2 = r5.f3358d;
            r2 = r2.m4369a(r0);
            if (r2 == 0) goto L_0x007d;
        L_0x006e:
            r3 = r2.length;
            r5.m4392a(r2, r3);
        L_0x0072:
            r0 = java.lang.Character.isSupplementaryCodePoint(r0);
            if (r0 == 0) goto L_0x008a;
        L_0x0078:
            r0 = 2;
        L_0x0079:
            r7 = r1 + r0;
            r0 = r7;
            goto L_0x0043;
        L_0x007d:
            r2 = r5.f3356b;
            r3 = 0;
            r2 = java.lang.Character.toChars(r0, r2, r3);
            r3 = r5.f3356b;
            r5.m4392a(r3, r2);
            goto L_0x0072;
        L_0x008a:
            r0 = 1;
            goto L_0x0079;
        L_0x008c:
            r0 = r7;
            goto L_0x0043;
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.e.1.append(java.lang.CharSequence, int, int):java.lang.Appendable");
        }
    }

    /* renamed from: cn.sharesdk.framework.utils.e.2 */
    static class C09812 extends ThreadLocal<char[]> {
        C09812() {
        }

        protected char[] m4393a() {
            return new char[IXAdIOUtils.BUFFER_SIZE];
        }

        protected /* synthetic */ Object initialValue() {
            return m4393a();
        }
    }

    static {
        f3345a = new C09812();
    }

    private static final char[] m4365a(char[] cArr, int i, int i2) {
        Object obj = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, obj, 0, i);
        }
        return obj;
    }

    protected static final int m4366b(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < '\ud800' || charAt > '\udfff') {
                return charAt;
            }
            if (charAt > '\udbff') {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + charAt + " at index " + (i3 - 1));
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i3);
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected int m4367a(java.lang.CharSequence r3, int r4, int r5) {
        /*
        r2 = this;
    L_0x0000:
        if (r4 >= r5) goto L_0x000e;
    L_0x0002:
        r0 = cn.sharesdk.framework.utils.C0975e.m4366b(r3, r4, r5);
        if (r0 < 0) goto L_0x000e;
    L_0x0008:
        r1 = r2.m4369a(r0);
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        return r4;
    L_0x000f:
        r0 = java.lang.Character.isSupplementaryCodePoint(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x0015:
        r0 = 2;
    L_0x0016:
        r4 = r4 + r0;
        goto L_0x0000;
    L_0x0018:
        r0 = 1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.e.a(java.lang.CharSequence, int, int):int");
    }

    protected final String m4368a(String str, int i) {
        int b;
        int length = str.length();
        int i2 = 0;
        char[] cArr = (char[]) f3345a.get();
        int i3 = 0;
        while (i < length) {
            b = C0975e.m4366b(str, i, length);
            if (b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            Object a = m4369a(b);
            if (a != null) {
                int i4 = i - i2;
                int length2 = (i3 + i4) + a.length;
                if (cArr.length < length2) {
                    cArr = C0975e.m4365a(cArr, i3, (length2 + (length - i)) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArr, i3);
                    i3 += i4;
                }
                if (a.length > 0) {
                    System.arraycopy(a, 0, cArr, i3, a.length);
                    i3 += a.length;
                }
            }
            b = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + i;
            i = m4367a((CharSequence) str, b, length);
            i2 = b;
        }
        b = length - i2;
        if (b > 0) {
            b += i3;
            if (cArr.length < b) {
                cArr = C0975e.m4365a(cArr, i3, b);
            }
            str.getChars(i2, length, cArr, i3);
            i3 = b;
        }
        return new String(cArr, 0, i3);
    }

    protected abstract char[] m4369a(int i);

    public Appendable escape(Appendable appendable) {
        C0977c.m4373a(appendable);
        return new C09801(this, appendable);
    }

    public String escape(String str) {
        int length = str.length();
        int a = m4367a((CharSequence) str, 0, length);
        return a == length ? str : m4368a(str, a);
    }
}
