package com.miui.support.internal.graphics.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Vector;

public class GifDecoder {
    protected int f2376A;
    protected int f2377B;
    protected int f2378C;
    protected boolean f2379D;
    protected int f2380E;
    protected int f2381F;
    protected short[] f2382G;
    protected byte[] f2383H;
    protected byte[] f2384I;
    protected byte[] f2385J;
    protected Vector<GifFrame> f2386K;
    private long f2387L;
    private long f2388M;
    private boolean f2389N;
    private int f2390O;
    private int f2391P;
    private int f2392Q;
    private int f2393R;
    private int[] f2394S;
    private boolean f2395T;
    private boolean f2396U;
    protected BufferedInputStream f2397a;
    protected int f2398b;
    protected boolean f2399c;
    protected int f2400d;
    protected int f2401e;
    protected int[] f2402f;
    protected int[] f2403g;
    protected int[] f2404h;
    protected int f2405i;
    protected int f2406j;
    protected int f2407k;
    protected int f2408l;
    protected boolean f2409m;
    protected boolean f2410n;
    protected int f2411o;
    protected int f2412p;
    protected int f2413q;
    protected int f2414r;
    protected int f2415s;
    protected int f2416t;
    protected int f2417u;
    protected int f2418v;
    protected int f2419w;
    protected Bitmap f2420x;
    protected Bitmap f2421y;
    protected byte[] f2422z;

    private static class GifFrame {
        public Bitmap f2374a;
        public int f2375b;

        public GifFrame(Bitmap bitmap, int i) {
            this.f2374a = bitmap;
            this.f2375b = i;
        }

        public void m3968a() {
            if (this.f2374a != null && !this.f2374a.isRecycled()) {
                this.f2374a.recycle();
            }
        }
    }

    public GifDecoder() {
        this.f2388M = 1048576;
        this.f2401e = 1;
        this.f2422z = new byte[256];
        this.f2376A = 0;
        this.f2377B = 0;
        this.f2378C = 0;
        this.f2379D = false;
        this.f2380E = 0;
        this.f2395T = false;
        this.f2396U = false;
    }

    public boolean m3972a() {
        return this.f2389N;
    }

    public void m3970a(int i) {
        this.f2391P = i;
    }

    public void m3974b() {
        if (this.f2386K != null) {
            int size = this.f2386K.size();
            for (int i = 0; i < size; i++) {
                ((GifFrame) this.f2386K.elementAt(i)).m3968a();
            }
        }
    }

    public void m3971a(long j) {
        this.f2388M = j;
    }

    public int m3973b(int i) {
        this.f2380E = -1;
        int c = m3975c();
        if (i >= 0 && i < c) {
            this.f2380E = ((GifFrame) this.f2386K.elementAt(i)).f2375b;
        }
        return this.f2380E;
    }

    public int m3975c() {
        return this.f2386K == null ? 0 : this.f2386K.size();
    }

    protected void m3977d() {
        int c;
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (this.f2394S == null) {
            this.f2394S = new int[(this.f2392Q * this.f2393R)];
        }
        if (this.f2378C > 0) {
            if (this.f2378C == 3) {
                c = m3975c() - 2;
                if (c > 0) {
                    Bitmap c2 = m3976c(c - 1);
                    if (!c2.equals(this.f2421y)) {
                        this.f2421y = c2;
                        this.f2421y.getPixels(this.f2394S, 0, this.f2392Q, 0, 0, this.f2392Q, this.f2393R);
                    }
                } else {
                    this.f2421y = null;
                    this.f2394S = new int[(this.f2392Q * this.f2393R)];
                }
            }
            if (this.f2421y != null && this.f2378C == 2) {
                if (this.f2379D) {
                    c = 0;
                } else {
                    c = this.f2407k;
                }
                i = (this.f2417u * this.f2392Q) + this.f2416t;
                for (i2 = 0; i2 < this.f2419w; i2++) {
                    i3 = i + this.f2418v;
                    for (i4 = i; i4 < i3; i4++) {
                        this.f2394S[i4] = c;
                    }
                    i += this.f2392Q;
                }
            }
        }
        i2 = 8;
        i = 1;
        c = 0;
        while (i5 < this.f2415s) {
            if (this.f2410n) {
                if (c >= this.f2415s) {
                    i++;
                    switch (i) {
                        case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                            c = 4;
                            break;
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            c = 2;
                            i2 = 4;
                            break;
                        case C0264R.styleable.Window_windowDisablePreview /*4*/:
                            c = 1;
                            i2 = 2;
                            break;
                    }
                }
                int i6 = c;
                c += i2;
                i4 = i6;
            } else {
                i4 = i5;
            }
            i4 += this.f2413q;
            if (i4 < this.f2393R) {
                i3 = this.f2392Q * i4;
                int i7 = i3 + this.f2412p;
                i4 = this.f2414r + i7;
                if (this.f2392Q + i3 < i4) {
                    i4 = this.f2392Q + i3;
                }
                i3 = this.f2414r * i5;
                int i8 = i7;
                while (i8 < i4) {
                    i7 = i3 + 1;
                    i3 = this.f2404h[this.f2385J[i3] & 255];
                    if (i3 != 0) {
                        this.f2394S[i8] = i3;
                    }
                    i8++;
                    i3 = i7;
                }
            }
            i5++;
        }
        if (!(this.f2390O > this.f2391P || this.f2420x == null || this.f2420x.isRecycled())) {
            this.f2420x.recycle();
        }
        this.f2420x = Bitmap.createBitmap(this.f2394S, this.f2392Q, this.f2393R, Config.ARGB_8888);
    }

    public Bitmap m3976c(int i) {
        int c = m3975c();
        if (c <= 0) {
            return null;
        }
        return ((GifFrame) this.f2386K.elementAt(i % c)).f2374a;
    }

    public int m3969a(InputStream inputStream) {
        this.f2389N = false;
        if (this.f2396U) {
            throw new IllegalStateException("decoder cannot be called more than once");
        }
        this.f2396U = true;
        m3981g();
        if (inputStream != null) {
            this.f2397a = new BufferedInputStream(inputStream);
            try {
                m3987m();
                if (!(this.f2395T || m3980f())) {
                    m3985k();
                    if (m3975c() < 0) {
                        this.f2398b = 1;
                    }
                }
            } catch (OutOfMemoryError e) {
                this.f2398b = 2;
                m3974b();
            }
        } else {
            this.f2398b = 2;
        }
        if (this.f2395T) {
            m3974b();
            this.f2398b = 3;
        }
        return this.f2398b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m3979e() {
        /*
        r24 = this;
        r15 = -1;
        r0 = r24;
        r1 = r0.f2414r;
        r0 = r24;
        r2 = r0.f2415s;
        r16 = r1 * r2;
        r0 = r24;
        r1 = r0.f2385J;
        if (r1 == 0) goto L_0x001a;
    L_0x0011:
        r0 = r24;
        r1 = r0.f2385J;
        r1 = r1.length;
        r0 = r16;
        if (r1 >= r0) goto L_0x0022;
    L_0x001a:
        r0 = r16;
        r1 = new byte[r0];
        r0 = r24;
        r0.f2385J = r1;
    L_0x0022:
        r0 = r24;
        r1 = r0.f2382G;
        if (r1 != 0) goto L_0x0030;
    L_0x0028:
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = new short[r1];
        r0 = r24;
        r0.f2382G = r1;
    L_0x0030:
        r0 = r24;
        r1 = r0.f2383H;
        if (r1 != 0) goto L_0x003e;
    L_0x0036:
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = new byte[r1];
        r0 = r24;
        r0.f2383H = r1;
    L_0x003e:
        r0 = r24;
        r1 = r0.f2384I;
        if (r1 != 0) goto L_0x004c;
    L_0x0044:
        r1 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        r1 = new byte[r1];
        r0 = r24;
        r0.f2384I = r1;
    L_0x004c:
        r17 = r24.m3982h();
        r1 = 1;
        r18 = r1 << r17;
        r19 = r18 + 1;
        r11 = r18 + 2;
        r4 = r17 + 1;
        r1 = 1;
        r1 = r1 << r4;
        r3 = r1 + -1;
        r1 = 0;
    L_0x005e:
        r0 = r18;
        if (r1 >= r0) goto L_0x0073;
    L_0x0062:
        r0 = r24;
        r2 = r0.f2382G;
        r5 = 0;
        r2[r1] = r5;
        r0 = r24;
        r2 = r0.f2383H;
        r5 = (byte) r1;
        r2[r1] = r5;
        r1 = r1 + 1;
        goto L_0x005e;
    L_0x0073:
        r5 = 0;
        r1 = 0;
        r14 = r1;
        r6 = r5;
        r7 = r5;
        r8 = r5;
        r12 = r5;
        r2 = r5;
        r10 = r15;
        r1 = r5;
    L_0x007d:
        r0 = r16;
        if (r14 >= r0) goto L_0x008d;
    L_0x0081:
        if (r8 != 0) goto L_0x016e;
    L_0x0083:
        if (r6 >= r4) goto L_0x00ae;
    L_0x0085:
        if (r1 != 0) goto L_0x009d;
    L_0x0087:
        r1 = r24.m3983i();
        if (r1 > 0) goto L_0x009c;
    L_0x008d:
        r1 = r12;
    L_0x008e:
        r0 = r16;
        if (r1 >= r0) goto L_0x0169;
    L_0x0092:
        r0 = r24;
        r2 = r0.f2385J;
        r3 = 0;
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x008e;
    L_0x009c:
        r2 = 0;
    L_0x009d:
        r0 = r24;
        r9 = r0.f2422z;
        r9 = r9[r2];
        r9 = r9 & 255;
        r9 = r9 << r6;
        r5 = r5 + r9;
        r6 = r6 + 8;
        r2 = r2 + 1;
        r1 = r1 + -1;
        goto L_0x007d;
    L_0x00ae:
        r9 = r5 & r3;
        r5 = r5 >> r4;
        r6 = r6 - r4;
        if (r9 > r11) goto L_0x008d;
    L_0x00b4:
        r0 = r19;
        if (r9 == r0) goto L_0x008d;
    L_0x00b8:
        r0 = r18;
        if (r9 != r0) goto L_0x00c6;
    L_0x00bc:
        r4 = r17 + 1;
        r3 = 1;
        r3 = r3 << r4;
        r3 = r3 + -1;
        r11 = r18 + 2;
        r10 = r15;
        goto L_0x007d;
    L_0x00c6:
        if (r10 != r15) goto L_0x00da;
    L_0x00c8:
        r0 = r24;
        r10 = r0.f2384I;
        r7 = r8 + 1;
        r0 = r24;
        r13 = r0.f2383H;
        r13 = r13[r9];
        r10[r8] = r13;
        r8 = r7;
        r10 = r9;
        r7 = r9;
        goto L_0x007d;
    L_0x00da:
        if (r9 != r11) goto L_0x016a;
    L_0x00dc:
        r0 = r24;
        r0 = r0.f2384I;
        r20 = r0;
        r13 = r8 + 1;
        r7 = (byte) r7;
        r20[r8] = r7;
        r7 = r10;
    L_0x00e8:
        r0 = r18;
        if (r7 <= r0) goto L_0x0106;
    L_0x00ec:
        r0 = r24;
        r0 = r0.f2384I;
        r20 = r0;
        r8 = r13 + 1;
        r0 = r24;
        r0 = r0.f2383H;
        r21 = r0;
        r21 = r21[r7];
        r20[r13] = r21;
        r0 = r24;
        r13 = r0.f2382G;
        r7 = r13[r7];
        r13 = r8;
        goto L_0x00e8;
    L_0x0106:
        r0 = r24;
        r8 = r0.f2383H;
        r7 = r8[r7];
        r7 = r7 & 255;
        r8 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        if (r11 >= r8) goto L_0x008d;
    L_0x0112:
        r0 = r24;
        r0 = r0.f2384I;
        r20 = r0;
        r8 = r13 + 1;
        r0 = (byte) r7;
        r21 = r0;
        r20[r13] = r21;
        r0 = r24;
        r13 = r0.f2382G;
        r10 = (short) r10;
        r13[r11] = r10;
        r0 = r24;
        r10 = r0.f2383H;
        r13 = (byte) r7;
        r10[r11] = r13;
        r10 = r11 + 1;
        r11 = r10 & r3;
        if (r11 != 0) goto L_0x013a;
    L_0x0133:
        r11 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        if (r10 >= r11) goto L_0x013a;
    L_0x0137:
        r4 = r4 + 1;
        r3 = r3 + r10;
    L_0x013a:
        r22 = r5;
        r5 = r7;
        r7 = r3;
        r3 = r22;
        r23 = r8;
        r8 = r4;
        r4 = r6;
        r6 = r23;
    L_0x0146:
        r11 = r6 + -1;
        r0 = r24;
        r6 = r0.f2385J;
        r13 = r12 + 1;
        r0 = r24;
        r0 = r0.f2384I;
        r20 = r0;
        r20 = r20[r11];
        r6[r12] = r20;
        r6 = r14 + 1;
        r14 = r6;
        r12 = r13;
        r6 = r4;
        r4 = r8;
        r8 = r11;
        r11 = r10;
        r10 = r9;
        r22 = r5;
        r5 = r3;
        r3 = r7;
        r7 = r22;
        goto L_0x007d;
    L_0x0169:
        return;
    L_0x016a:
        r13 = r8;
        r7 = r9;
        goto L_0x00e8;
    L_0x016e:
        r9 = r10;
        r10 = r11;
        r22 = r7;
        r7 = r3;
        r3 = r5;
        r5 = r22;
        r23 = r4;
        r4 = r6;
        r6 = r8;
        r8 = r23;
        goto L_0x0146;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.graphics.gif.GifDecoder.e():void");
    }

    protected boolean m3980f() {
        return this.f2398b != 0;
    }

    protected void m3981g() {
        this.f2398b = 0;
        this.f2386K = new Vector();
        this.f2402f = null;
        this.f2403g = null;
    }

    protected int m3982h() {
        int i = 0;
        try {
            i = this.f2397a.read();
        } catch (Exception e) {
            this.f2398b = 1;
        }
        return i;
    }

    protected int m3983i() {
        this.f2376A = m3982h();
        int i = 0;
        if (this.f2376A > 0) {
            while (i < this.f2376A) {
                try {
                    int read = this.f2397a.read(this.f2422z, i, this.f2376A - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.f2376A) {
                this.f2398b = 1;
            }
        }
        return i;
    }

    protected int[] m3978d(int i) {
        int read;
        int i2 = 0;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            read = this.f2397a.read(bArr, 0, bArr.length);
        } catch (Exception e) {
            e.printStackTrace();
            read = 0;
        }
        if (read < i3) {
            this.f2398b = 1;
        } else {
            iArr = new int[256];
            read = 0;
            while (i2 < i) {
                i3 = read + 1;
                int i4 = bArr[read] & 255;
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                read = i5 + 1;
                i3 = i2 + 1;
                iArr[i2] = (((i4 << 16) | -16777216) | (i6 << 8)) | (bArr[i5] & 255);
                i2 = i3;
            }
        }
        return iArr;
    }

    public int m3984j() {
        if (this.f2389N) {
            return this.f2390O;
        }
        return 0;
    }

    protected void m3985k() {
        this.f2390O = 0;
        int i = 0;
        while (i == 0 && !m3980f() && !this.f2395T) {
            int i2;
            switch (m3982h()) {
                case 33:
                    switch (m3982h()) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            m3993s();
                            break;
                        case 249:
                            m3986l();
                            break;
                        case 254:
                            m3993s();
                            break;
                        case 255:
                            m3983i();
                            String str = "";
                            for (i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.f2422z[i2]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                m3993s();
                                break;
                            } else {
                                m3990p();
                                break;
                            }
                        default:
                            m3993s();
                            break;
                    }
                case 44:
                    i2 = this.f2386K.size();
                    m3988n();
                    if (this.f2386K.size() > i2) {
                        this.f2387L += (long) (this.f2420x.getRowBytes() * this.f2420x.getHeight());
                    }
                    if (this.f2387L <= this.f2388M) {
                        break;
                    }
                    i = true;
                    break;
                case 59:
                    this.f2389N = true;
                    i = true;
                    break;
                default:
                    this.f2398b = 1;
                    break;
            }
        }
    }

    protected void m3986l() {
        boolean z = true;
        m3982h();
        int h = m3982h();
        this.f2377B = (h & 28) >> 2;
        if (this.f2377B == 0) {
            this.f2377B = 1;
        }
        if ((h & 1) == 0) {
            z = false;
        }
        this.f2379D = z;
        this.f2380E = m3991q() * 10;
        if (this.f2380E <= 0) {
            this.f2380E = 100;
        }
        this.f2381F = m3982h();
        m3982h();
    }

    protected void m3987m() {
        if (!this.f2395T) {
            String str = "";
            for (int i = 0; i < 6; i++) {
                str = str + ((char) m3982h());
            }
            if (str.startsWith("GIF")) {
                m3989o();
                if (this.f2399c && !m3980f()) {
                    this.f2402f = m3978d(this.f2400d);
                    this.f2406j = this.f2402f[this.f2405i];
                    return;
                }
                return;
            }
            this.f2398b = 1;
        }
    }

    protected void m3988n() {
        boolean z;
        int i = 0;
        this.f2412p = m3991q();
        this.f2413q = m3991q();
        this.f2414r = m3991q();
        this.f2415s = m3991q();
        int h = m3982h();
        this.f2409m = (h & 128) != 0;
        this.f2411o = 2 << (h & 7);
        if ((h & 64) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2410n = z;
        if (this.f2409m) {
            this.f2403g = m3978d(this.f2411o);
            this.f2404h = this.f2403g;
        } else {
            this.f2404h = this.f2402f;
            if (this.f2405i == this.f2381F) {
                this.f2406j = 0;
            }
        }
        if (this.f2379D) {
            int i2 = this.f2404h[this.f2381F];
            this.f2404h[this.f2381F] = 0;
            i = i2;
        }
        if (this.f2404h == null) {
            this.f2398b = 1;
        }
        if (!m3980f()) {
            m3979e();
            m3993s();
            if (!m3980f() && !this.f2395T) {
                m3977d();
                if (this.f2390O >= this.f2391P) {
                    this.f2386K.addElement(new GifFrame(this.f2420x, this.f2380E));
                }
                this.f2390O++;
                if (this.f2379D) {
                    this.f2404h[this.f2381F] = i;
                }
                m3992r();
            }
        }
    }

    protected void m3989o() {
        this.f2392Q = m3991q();
        this.f2393R = m3991q();
        int h = m3982h();
        this.f2399c = (h & 128) != 0;
        this.f2400d = 2 << (h & 7);
        this.f2405i = m3982h();
        this.f2408l = m3982h();
    }

    protected void m3990p() {
        do {
            m3983i();
            if (this.f2422z[0] == (byte) 1) {
                this.f2401e = (this.f2422z[1] & 255) | ((this.f2422z[2] & 255) << 8);
            }
            if (this.f2376A <= 0) {
                return;
            }
        } while (!m3980f());
    }

    protected int m3991q() {
        return m3982h() | (m3982h() << 8);
    }

    protected void m3992r() {
        this.f2378C = this.f2377B;
        this.f2416t = this.f2412p;
        this.f2417u = this.f2413q;
        this.f2418v = this.f2414r;
        this.f2419w = this.f2415s;
        this.f2421y = this.f2420x;
        this.f2407k = this.f2406j;
        this.f2377B = 0;
        this.f2379D = false;
        this.f2380E = 0;
        this.f2403g = null;
    }

    protected void m3993s() {
        do {
            m3983i();
            if (this.f2376A <= 0) {
                return;
            }
        } while (!m3980f());
    }
}
