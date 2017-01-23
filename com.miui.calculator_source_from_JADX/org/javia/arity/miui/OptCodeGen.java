package org.javia.arity.miui;

import com.miui.support.internal.C0264R;

class OptCodeGen extends SimpleCodeGen {
    EvalContext f4972a;
    int f4973b;
    Complex[] f4974c;
    double[] f4975d;
    double[] f4976e;
    Function[] f4977f;
    byte[] f4978g;
    CompiledFunction f4979h;
    int f4980i;
    private boolean f4981p;

    OptCodeGen(SyntaxException syntaxException) {
        super(syntaxException);
        this.f4972a = new EvalContext();
        this.f4974c = this.f4972a.f4930b;
        this.f4975d = new double[1];
        this.f4976e = new double[1];
        this.f4977f = new Function[1];
        this.f4978g = new byte[1];
        this.f4979h = new CompiledFunction(0, this.f4978g, this.f4975d, this.f4976e, this.f4977f);
    }

    void m6749a() {
        super.m6744a();
        this.f4973b = -1;
        this.f4980i = 0;
        this.f4981p = false;
    }

    void m6750a(Token token) {
        byte b;
        boolean z = this.f4981p;
        this.f4981p = false;
        switch (token.f5012c) {
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                this.f4975d[0] = token.f5014e;
                this.f4976e[0] = 0.0d;
                b = (byte) 1;
                break;
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                Symbol b2 = m6747b(token);
                if (!token.m6776a()) {
                    if (b2.f4989a <= null) {
                        if (b2.f4990b == null) {
                            this.f4975d[0] = b2.f4991c;
                            this.f4976e[0] = b2.f4992d;
                            b = (byte) 1;
                            break;
                        }
                        this.f4977f[0] = b2.f4990b;
                        b = (byte) 2;
                        break;
                    }
                    b = b2.f4989a;
                    if (b >= 38 && b <= 42) {
                        int i = b - 38;
                        if (i + 1 > this.f4980i) {
                            this.f4980i = i + 1;
                        }
                        Complex[] complexArr = this.f4974c;
                        int i2 = this.f4973b + 1;
                        this.f4973b = i2;
                        complexArr[i2].f4908a = Double.NaN;
                        this.f4974c[this.f4973b].f4909b = 0.0d;
                        this.k.m6619a(b);
                        return;
                    }
                }
                this.f4977f[0] = b2.f4990b.m6633d();
                b = (byte) 2;
                break;
            default:
                b = token.f5013d;
                if (b > null) {
                    if (b == 12) {
                        this.f4981p = true;
                        break;
                    }
                }
                throw new Error("wrong vmop: " + b);
                break;
        }
        int i3 = this.f4973b;
        this.f4978g[0] = b;
        if (b != 8) {
            this.f4973b = this.f4979h.m6658a(this.f4972a, this.f4973b, z ? -1 : -2);
        } else {
            Complex[] complexArr2 = this.f4974c;
            i3 = this.f4973b + 1;
            this.f4973b = i3;
            complexArr2[i3].f4908a = Double.NaN;
            this.f4974c[this.f4973b].f4909b = 0.0d;
        }
        if (!this.f4974c[this.f4973b].m6680f() || b == (byte) 1) {
            int a = b == (byte) 2 ? this.f4977f[0].m6625a() : VM.f5022b[b];
            while (a > 0) {
                byte b3 = this.k.m6620b();
                if (b3 == (byte) 1) {
                    this.l.m6718b();
                } else if (b3 == (byte) 2) {
                    a += this.m.m6723b().m6625a() - 1;
                } else {
                    a += VM.f5022b[b3];
                }
                a--;
            }
            this.l.m6717a(this.f4974c[this.f4973b].f4908a, this.f4974c[this.f4973b].f4909b);
            b = (byte) 1;
        } else if (b == (byte) 2) {
            this.m.m6722a(this.f4977f[0]);
        }
        this.k.m6619a(b);
    }

    CompiledFunction m6748a(int i) {
        return new CompiledFunction(i, this.k.m6621c(), this.l.m6719c(), this.l.m6720d(), this.m.m6724c());
    }
}
