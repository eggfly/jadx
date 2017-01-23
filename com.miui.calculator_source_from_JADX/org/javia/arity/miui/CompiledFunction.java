package org.javia.arity.miui;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Random;

public class CompiledFunction extends ContextFunction {
    private static final IsComplexException f4892b;
    private static final Random f4893c;
    private static final double[] f4894d;
    private static final Function[] f4895e;
    private final double[] f4896f;
    private final double[] f4897g;
    private final Function[] f4898h;
    private final byte[] f4899i;
    private final int f4900j;

    /* renamed from: org.javia.arity.miui.CompiledFunction.1 */
    class C06241 extends Function {
        public int m6635a() {
            return 1;
        }

        C06241() {
        }

        public double m6634a(double d) {
            if (d > 0.0d) {
                return 1.0d;
            }
            return d < 0.0d ? -1.0d : 0.0d;
        }
    }

    static {
        f4892b = new IsComplexException();
        f4893c = new Random();
        f4894d = new double[0];
        f4895e = new Function[0];
    }

    CompiledFunction(int i, byte[] bArr, double[] dArr, double[] dArr2, Function[] functionArr) {
        this.f4900j = i;
        this.f4899i = bArr;
        this.f4896f = dArr;
        this.f4897g = dArr2;
        this.f4898h = functionArr;
    }

    static Function m6651a(int i) {
        if (VM.f5022b[i] != (byte) 1) {
            throw new Error("makeOpFunction expects arity 1, found " + VM.f5022b[i]);
        }
        Function compiledFunction = new CompiledFunction(VM.f5022b[i], new byte[]{(byte) 38, (byte) i}, f4894d, f4894d, f4895e);
        if (i == 29) {
            compiledFunction.m6629a(new C06241());
        }
        return compiledFunction;
    }

    public int m6656a() {
        return this.f4900j;
    }

    public String toString() {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f4900j != 0) {
            stringBuffer.append("arity ").append(this.f4900j).append("; ");
        }
        int i2 = 0;
        int i3 = 0;
        while (i < this.f4899i.length) {
            byte b = this.f4899i[i];
            stringBuffer.append(VM.f5021a[b]);
            if (b == 1) {
                stringBuffer.append(' ');
                if (this.f4897g == null) {
                    stringBuffer.append(this.f4896f[i3]);
                } else {
                    stringBuffer.append('(').append(this.f4896f[i3]).append(", ").append(this.f4897g[i3]).append(')');
                }
                i3++;
            } else if (b == 2) {
                i2++;
            }
            stringBuffer.append("; ");
            i++;
        }
        if (i3 != this.f4896f.length) {
            stringBuffer.append("\nuses only ").append(i3).append(" consts out of ").append(this.f4896f.length);
        }
        if (i2 != this.f4898h.length) {
            stringBuffer.append("\nuses only ").append(i2).append(" funcs out of ").append(this.f4898h.length);
        }
        return stringBuffer.toString();
    }

    public double m6655a(double[] dArr, EvalContext evalContext) {
        if (this.f4897g != null) {
            return m6653c(dArr, evalContext);
        }
        m6631b(dArr.length);
        System.arraycopy(dArr, 0, evalContext.f4929a, evalContext.f4931c, dArr.length);
        try {
            m6652b(evalContext, (evalContext.f4931c + dArr.length) - 1);
            return evalContext.f4929a[evalContext.f4931c];
        } catch (IsComplexException e) {
            return m6653c(dArr, evalContext);
        }
    }

    private double m6653c(double[] dArr, EvalContext evalContext) {
        return m6659a(m6649b(dArr, evalContext), evalContext).m6667a();
    }

    public Complex m6659a(Complex[] complexArr, EvalContext evalContext) {
        m6631b(complexArr.length);
        Complex[] complexArr2 = evalContext.f4930b;
        int i = evalContext.f4931c;
        for (int i2 = 0; i2 < complexArr.length; i2++) {
            complexArr2[i2 + i].m6670a(complexArr[i2]);
        }
        m6654c(evalContext, (complexArr.length + i) - 1);
        return complexArr2[i];
    }

    private int m6652b(EvalContext evalContext, int i) {
        int i2 = i + 1;
        int a = m6657a(evalContext, i);
        if (a != i2) {
            throw new Error("Stack pointer after exec: expected " + i2 + ", got " + a);
        }
        evalContext.f4929a[a - this.f4900j] = evalContext.f4929a[a];
        return a - this.f4900j;
    }

    private int m6654c(EvalContext evalContext, int i) {
        int i2 = i + 1;
        int a = m6658a(evalContext, i, -2);
        if (a != i2) {
            throw new Error("Stack pointer after exec: expected " + i2 + ", got " + a);
        }
        evalContext.f4930b[a - this.f4900j].m6670a(evalContext.f4930b[a]);
        return a - this.f4900j;
    }

    int m6657a(EvalContext evalContext, int i) {
        if (this.f4897g != null) {
            throw f4892b;
        }
        Object obj = evalContext.f4929a;
        int i2 = i - this.f4900j;
        int i3 = 0;
        int i4 = 0;
        int length = this.f4899i.length;
        int i5 = -2;
        int i6 = 0;
        int i7 = i;
        while (i6 < length) {
            int i8;
            int i9;
            byte b = this.f4899i[i6];
            int i10;
            double c;
            double d;
            switch (b) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    i8 = i7 + 1;
                    i9 = i3 + 1;
                    obj[i8] = this.f4896f[i3];
                    int i11 = i5;
                    i5 = i9;
                    i9 = i11;
                    int i12 = i4;
                    i4 = i8;
                    i8 = i12;
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    i10 = i4 + 1;
                    Function function = this.f4898h[i4];
                    if (!(function instanceof CompiledFunction)) {
                        i8 = function.m6625a();
                        i4 = i7 - i8;
                        i7 = evalContext.f4931c;
                        evalContext.f4931c = i4 + 1;
                        switch (i8) {
                            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                                try {
                                    c = function.m6632c();
                                    break;
                                } catch (Throwable th) {
                                    evalContext.f4931c = i7;
                                }
                            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                                c = function.m6622a(obj[i4 + 1]);
                                break;
                            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                                c = function.m6623a(obj[i4 + 1], obj[i4 + 2]);
                                break;
                            default:
                                double[] dArr = new double[i8];
                                System.arraycopy(obj, i4 + 1, dArr, 0, i8);
                                c = function.m6624a(dArr);
                                break;
                        }
                        evalContext.f4931c = i7;
                        i4++;
                        obj[i4] = c;
                        i9 = i5;
                        i8 = i10;
                        i5 = i3;
                        break;
                    }
                    i8 = i10;
                    i4 = ((CompiledFunction) function).m6652b(evalContext, i7);
                    i9 = i5;
                    i5 = i3;
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    i10 = i7 - 1;
                    d = obj[i10];
                    c = (i5 == i6 + -1 ? obj[i10] * obj[i10 + 1] : obj[i10 + 1]) + d;
                    if (Math.abs(c) < Math.ulp(d) * 1024.0d) {
                        c = 0.0d;
                    }
                    obj[i10] = c;
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i10;
                    break;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    i10 = i7 - 1;
                    d = obj[i10];
                    c = d - (i5 == i6 + -1 ? obj[i10] * obj[i10 + 1] : obj[i10 + 1]);
                    if (Math.abs(c) < Math.ulp(d) * 1024.0d) {
                        c = 0.0d;
                    }
                    obj[i10] = c;
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i10;
                    break;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    i9 = i7 - 1;
                    obj[i9] = obj[i9] * obj[i9 + 1];
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    i9 = i7 - 1;
                    obj[i9] = obj[i9] / obj[i9 + 1];
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    i9 = i7 - 1;
                    obj[i9] = obj[i9] % obj[i9 + 1];
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    i9 = i7 + 1;
                    obj[i9] = f4893c.nextDouble();
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    obj[i7] = -obj[i7];
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                    i9 = i7 - 1;
                    obj[i9] = Math.pow(obj[i9], obj[i9 + 1]);
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                    obj[i7] = MoreMath.m6735e(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                    obj[i7] = obj[i7] * 0.01d;
                    i9 = i6;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                    c = obj[i7];
                    if (c >= 0.0d) {
                        obj[i7] = Math.sqrt(c);
                        i9 = i5;
                        i8 = i4;
                        i5 = i3;
                        i4 = i7;
                        break;
                    }
                    throw f4892b;
                case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                    obj[i7] = Math.cbrt(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_windowLayoutMode /*15*/:
                    obj[i7] = Math.exp(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                    obj[i7] = Math.log(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_contentHeaderBackground /*17*/:
                    obj[i7] = MoreMath.m6737g(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionMenuEnabled /*18*/:
                    obj[i7] = MoreMath.m6738h(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionMenuLayout /*19*/:
                    obj[i7] = MoreMath.m6739i(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionButtonMoreBackground /*20*/:
                    c = obj[i7];
                    if (c >= -1.0d && c <= 1.0d) {
                        obj[i7] = Math.asin(c);
                        i9 = i5;
                        i8 = i4;
                        i5 = i3;
                        i4 = i7;
                        break;
                    }
                    throw f4892b;
                case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
                    c = obj[i7];
                    if (c >= -1.0d && c <= 1.0d) {
                        obj[i7] = Math.acos(c);
                        i9 = i5;
                        i8 = i4;
                        i5 = i3;
                        i4 = i7;
                        break;
                    }
                    throw f4892b;
                    break;
                case C0264R.styleable.Window_immersionWindowBackground /*22*/:
                    obj[i7] = Math.atan(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionWindowFooterBackground /*23*/:
                    obj[i7] = Math.sinh(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionViewItemBackground /*24*/:
                    obj[i7] = Math.cosh(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionTextColor /*25*/:
                    obj[i7] = Math.tanh(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionBlurMask /*26*/:
                    obj[i7] = MoreMath.m6728a(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case C0264R.styleable.Window_immersionStatusBarStyle /*27*/:
                    obj[i7] = MoreMath.m6730b(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case (byte) 28:
                    obj[i7] = MoreMath.m6732c(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case (byte) 29:
                    obj[i7] = Math.abs(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case (byte) 30:
                    obj[i7] = Math.floor(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case (byte) 31:
                    obj[i7] = Math.ceil(obj[i7]);
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case (byte) 32:
                    long j = obj[i7] > 0.0d ? 4607182418800017408L : obj[i7] < 0.0d ? -4616189618054758400L : 0;
                    obj[i7] = j;
                    i9 = i5;
                    i8 = i4;
                    i5 = i3;
                    i4 = i7;
                    break;
                case (byte) 33:
                    i9 = i7 - 1;
                    obj[i9] = Math.min(obj[i9], obj[i9 + 1]);
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case (byte) 34:
                    i9 = i7 - 1;
                    obj[i9] = Math.min(obj[i9], obj[i9 + 1]);
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case (byte) 35:
                    i9 = i7 - 1;
                    obj[i9] = MoreMath.m6729a(obj[i9], obj[i9 + 1]);
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case (byte) 36:
                    i9 = i7 - 1;
                    obj[i9] = MoreMath.m6731b(obj[i9], obj[i9 + 1]);
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case (byte) 37:
                    i9 = i7 - 1;
                    obj[i9] = MoreMath.m6733c(obj[i9], obj[i9 + 1]);
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                case (byte) 38:
                case (byte) 39:
                case (byte) 40:
                case (byte) 41:
                case (byte) 42:
                    i9 = i7 + 1;
                    obj[i9] = obj[(b + i2) - 37];
                    i8 = i4;
                    i4 = i9;
                    i9 = i5;
                    i5 = i3;
                    break;
                default:
                    throw new Error("Unknown opcode " + b);
            }
            i6++;
            i3 = i5;
            i7 = i4;
            i5 = i9;
            i4 = i8;
        }
        return i7;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int m6658a(org.javia.arity.miui.EvalContext r20, int r21, int r22) {
        /*
        r19 = this;
        r0 = r20;
        r10 = r0.f4930b;
        r0 = r19;
        r2 = r0.f4900j;
        r11 = r21 - r2;
        r6 = 0;
        r4 = 0;
        r0 = r19;
        r2 = r0.f4899i;
        r12 = r2.length;
        r8 = 0;
        r7 = r22;
        r9 = r21;
    L_0x0016:
        if (r8 >= r12) goto L_0x0346;
    L_0x0018:
        r0 = r19;
        r2 = r0.f4899i;
        r3 = r2[r8];
        switch(r3) {
            case 1: goto L_0x003a;
            case 2: goto L_0x0062;
            case 3: goto L_0x00ef;
            case 4: goto L_0x010f;
            case 5: goto L_0x012f;
            case 6: goto L_0x0140;
            case 7: goto L_0x0151;
            case 8: goto L_0x00d8;
            case 9: goto L_0x0173;
            case 10: goto L_0x0162;
            case 11: goto L_0x017e;
            case 12: goto L_0x0189;
            case 13: goto L_0x0233;
            case 14: goto L_0x023e;
            case 15: goto L_0x021d;
            case 16: goto L_0x0228;
            case 17: goto L_0x0199;
            case 18: goto L_0x01a4;
            case 19: goto L_0x01af;
            case 20: goto L_0x01db;
            case 21: goto L_0x01e6;
            case 22: goto L_0x01f1;
            case 23: goto L_0x01ba;
            case 24: goto L_0x01c5;
            case 25: goto L_0x01d0;
            case 26: goto L_0x01fc;
            case 27: goto L_0x0207;
            case 28: goto L_0x0212;
            case 29: goto L_0x0257;
            case 30: goto L_0x026c;
            case 31: goto L_0x0283;
            case 32: goto L_0x029a;
            case 33: goto L_0x02bf;
            case 34: goto L_0x02e0;
            case 35: goto L_0x0301;
            case 36: goto L_0x0312;
            case 37: goto L_0x0323;
            case 38: goto L_0x0334;
            case 39: goto L_0x0334;
            case 40: goto L_0x0334;
            case 41: goto L_0x0334;
            case 42: goto L_0x0334;
            default: goto L_0x0021;
        };
    L_0x0021:
        r2 = new java.lang.Error;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Unknown opcode ";
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x003a:
        r5 = r9 + 1;
        r9 = r10[r5];
        r0 = r19;
        r2 = r0.f4896f;
        r14 = r2[r6];
        r0 = r19;
        r2 = r0.f4897g;
        if (r2 != 0) goto L_0x005b;
    L_0x004a:
        r2 = 0;
    L_0x004c:
        r9.m6669a(r14, r2);
        r2 = r6 + 1;
        r3 = r2;
        r2 = r4;
        r4 = r7;
    L_0x0054:
        r8 = r8 + 1;
        r6 = r3;
        r7 = r4;
        r9 = r5;
        r4 = r2;
        goto L_0x0016;
    L_0x005b:
        r0 = r19;
        r2 = r0.f4897g;
        r2 = r2[r6];
        goto L_0x004c;
    L_0x0062:
        r0 = r19;
        r2 = r0.f4898h;
        r5 = r4 + 1;
        r2 = r2[r4];
        r3 = r2 instanceof org.javia.arity.miui.CompiledFunction;
        if (r3 == 0) goto L_0x007e;
    L_0x006e:
        r2 = (org.javia.arity.miui.CompiledFunction) r2;
        r0 = r20;
        r2 = r2.m6654c(r0, r9);
        r3 = r6;
        r4 = r7;
        r18 = r5;
        r5 = r2;
        r2 = r18;
        goto L_0x0054;
    L_0x007e:
        r3 = r2.m6625a();
        r4 = r9 - r3;
        r0 = r20;
        r9 = r0.f4931c;
        r13 = r4 + 1;
        r0 = r20;
        r0.f4931c = r13;	 Catch:{ all -> 0x00d2 }
        switch(r3) {
            case 0: goto L_0x00ad;
            case 1: goto L_0x00bc;
            case 2: goto L_0x00c5;
            default: goto L_0x0091;
        };	 Catch:{ all -> 0x00d2 }
    L_0x0091:
        r13 = new org.javia.arity.miui.Complex[r3];	 Catch:{ all -> 0x00d2 }
        r14 = r4 + 1;
        r15 = 0;
        java.lang.System.arraycopy(r10, r14, r13, r15, r3);	 Catch:{ all -> 0x00d2 }
        r2 = r2.m6628a(r13);	 Catch:{ all -> 0x00d2 }
    L_0x009d:
        r0 = r20;
        r0.f4931c = r9;
        r3 = r4 + 1;
        r4 = r10[r3];
        r4.m6670a(r2);
        r2 = r5;
        r4 = r7;
        r5 = r3;
        r3 = r6;
        goto L_0x0054;
    L_0x00ad:
        r3 = new org.javia.arity.miui.Complex;	 Catch:{ all -> 0x00d2 }
        r14 = r2.m6632c();	 Catch:{ all -> 0x00d2 }
        r16 = 0;
        r0 = r16;
        r3.<init>(r14, r0);	 Catch:{ all -> 0x00d2 }
        r2 = r3;
        goto L_0x009d;
    L_0x00bc:
        r3 = r4 + 1;
        r3 = r10[r3];	 Catch:{ all -> 0x00d2 }
        r2 = r2.m6626a(r3);	 Catch:{ all -> 0x00d2 }
        goto L_0x009d;
    L_0x00c5:
        r3 = r4 + 1;
        r3 = r10[r3];	 Catch:{ all -> 0x00d2 }
        r13 = r4 + 2;
        r13 = r10[r13];	 Catch:{ all -> 0x00d2 }
        r2 = r2.m6627a(r3, r13);	 Catch:{ all -> 0x00d2 }
        goto L_0x009d;
    L_0x00d2:
        r2 = move-exception;
        r0 = r20;
        r0.f4931c = r9;
        throw r2;
    L_0x00d8:
        r2 = r9 + 1;
        r3 = r10[r2];
        r5 = f4893c;
        r14 = r5.nextDouble();
        r16 = 0;
        r0 = r16;
        r3.m6669a(r14, r0);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x00ef:
        r3 = r9 + -1;
        r5 = r10[r3];
        r2 = r8 + -1;
        if (r7 != r2) goto L_0x010a;
    L_0x00f7:
        r2 = r3 + 1;
        r2 = r10[r2];
        r9 = r10[r3];
        r2 = r2.m6675d(r9);
    L_0x0101:
        r5.m6672b(r2);
        r2 = r4;
        r5 = r3;
        r4 = r7;
        r3 = r6;
        goto L_0x0054;
    L_0x010a:
        r2 = r3 + 1;
        r2 = r10[r2];
        goto L_0x0101;
    L_0x010f:
        r3 = r9 + -1;
        r5 = r10[r3];
        r2 = r8 + -1;
        if (r7 != r2) goto L_0x012a;
    L_0x0117:
        r2 = r3 + 1;
        r2 = r10[r2];
        r9 = r10[r3];
        r2 = r2.m6675d(r9);
    L_0x0121:
        r5.m6674c(r2);
        r2 = r4;
        r5 = r3;
        r4 = r7;
        r3 = r6;
        goto L_0x0054;
    L_0x012a:
        r2 = r3 + 1;
        r2 = r10[r2];
        goto L_0x0121;
    L_0x012f:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6675d(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0140:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6677e(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0151:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6679f(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0162:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6684h(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0173:
        r2 = r10[r9];
        r2.m6673c();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x017e:
        r2 = r10[r9];
        r2.m6693o();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0189:
        r2 = r10[r9];
        r14 = 4576918229304087675; // 0x3f847ae147ae147b float:89128.96 double:0.01;
        r2.m6668a(r14);
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r8;
        goto L_0x0054;
    L_0x0199:
        r2 = r10[r9];
        r2.m6694p();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01a4:
        r2 = r10[r9];
        r2.m6696r();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01af:
        r2 = r10[r9];
        r2.m6698t();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01ba:
        r2 = r10[r9];
        r2.m6695q();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01c5:
        r2 = r10[r9];
        r2.m6697s();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01d0:
        r2 = r10[r9];
        r2.m6699u();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01db:
        r2 = r10[r9];
        r2.m6700v();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01e6:
        r2 = r10[r9];
        r2.m6701w();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01f1:
        r2 = r10[r9];
        r2.m6702x();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x01fc:
        r2 = r10[r9];
        r2.m6703y();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0207:
        r2 = r10[r9];
        r2.m6704z();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0212:
        r2 = r10[r9];
        r2.m6666A();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x021d:
        r2 = r10[r9];
        r2.m6690l();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0228:
        r2 = r10[r9];
        r2.m6689k();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0233:
        r2 = r10[r9];
        r2.m6687j();
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x023e:
        r2 = r10[r9];
        r3 = new org.javia.arity.miui.Complex;
        r14 = 4614688418178968235; // 0x400aaaaaaaaaaaab float:-3.031649E-13 double:3.3333333333333335;
        r16 = 0;
        r0 = r16;
        r3.<init>(r14, r0);
        r2.m6684h(r3);
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0257:
        r2 = r10[r9];
        r3 = r10[r9];
        r14 = r3.m6683h();
        r16 = 0;
        r0 = r16;
        r2.m6669a(r14, r0);
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x026c:
        r2 = r10[r9];
        r3 = r10[r9];
        r14 = r3.f4908a;
        r14 = java.lang.Math.floor(r14);
        r16 = 0;
        r0 = r16;
        r2.m6669a(r14, r0);
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x0283:
        r2 = r10[r9];
        r3 = r10[r9];
        r14 = r3.f4908a;
        r14 = java.lang.Math.ceil(r14);
        r16 = 0;
        r0 = r16;
        r2.m6669a(r14, r0);
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x029a:
        r2 = r10[r9];
        r2 = r2.f4908a;
        r5 = r10[r9];
        r14 = 0;
        r13 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r13 <= 0) goto L_0x02b3;
    L_0x02a6:
        r2 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
    L_0x02a8:
        r14 = 0;
        r5.m6669a(r2, r14);
        r2 = r4;
        r3 = r6;
        r5 = r9;
        r4 = r7;
        goto L_0x0054;
    L_0x02b3:
        r14 = 0;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 >= 0) goto L_0x02bc;
    L_0x02b9:
        r2 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        goto L_0x02a8;
    L_0x02bc:
        r2 = 0;
        goto L_0x02a8;
    L_0x02bf:
        r2 = r9 + -1;
        r3 = r2 + 1;
        r3 = r10[r3];
        r14 = r3.f4908a;
        r3 = r10[r2];
        r0 = r3.f4908a;
        r16 = r0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 >= 0) goto L_0x0347;
    L_0x02d1:
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6670a(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x02e0:
        r2 = r9 + -1;
        r3 = r10[r2];
        r14 = r3.f4908a;
        r3 = r2 + 1;
        r3 = r10[r3];
        r0 = r3.f4908a;
        r16 = r0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 >= 0) goto L_0x0347;
    L_0x02f2:
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6670a(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0301:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6682g(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0312:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6686i(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0323:
        r2 = r9 + -1;
        r3 = r10[r2];
        r5 = r2 + 1;
        r5 = r10[r5];
        r3.m6688j(r5);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0334:
        r2 = r9 + 1;
        r5 = r10[r2];
        r3 = r3 + r11;
        r3 = r3 + -37;
        r3 = r10[r3];
        r5.m6670a(r3);
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
    L_0x0346:
        return r9;
    L_0x0347:
        r3 = r6;
        r5 = r2;
        r2 = r4;
        r4 = r7;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.javia.arity.miui.CompiledFunction.a(org.javia.arity.miui.EvalContext, int, int):int");
    }
}
