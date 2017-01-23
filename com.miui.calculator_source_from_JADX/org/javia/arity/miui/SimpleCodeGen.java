package org.javia.arity.miui;

import com.miui.support.internal.C0264R;

class SimpleCodeGen extends TokenConsumer {
    static final SyntaxException f4966j;
    ByteStack f4967k;
    DoubleStack f4968l;
    FunctionStack f4969m;
    Symbols f4970n;
    SyntaxException f4971o;

    static {
        f4966j = new SyntaxException();
    }

    SimpleCodeGen(SyntaxException syntaxException) {
        this.f4967k = new ByteStack();
        this.f4968l = new DoubleStack();
        this.f4969m = new FunctionStack();
        this.f4971o = syntaxException;
    }

    SimpleCodeGen m6743a(Symbols symbols) {
        this.f4970n = symbols;
        return this;
    }

    void m6744a() {
        this.f4967k.m6618a();
        this.f4968l.m6716a();
        this.f4969m.m6721a();
    }

    Symbol m6747b(Token token) {
        String str = token.f5015f;
        boolean a = token.m6776a();
        if (a) {
            if (token.f5016g == 1) {
                str = str.substring(0, str.length() - 1);
            } else {
                throw this.f4971o.m6773a("Derivative expects arity 1 but found " + token.f5016g, token.f5017h);
            }
        }
        Symbol a2 = this.f4970n.m6763a(str, token.f5016g);
        if (a2 == null) {
            throw this.f4971o.m6773a("undefined '" + str + "' with arity " + token.f5016g, token.f5017h);
        }
        if (a && a2.f4989a > null && a2.f4990b == null) {
            a2.f4990b = CompiledFunction.m6651a(a2.f4989a);
        }
        if (!a || a2.f4990b != null) {
            return a2;
        }
        throw this.f4971o.m6773a("Invalid derivative " + str, token.f5017h);
    }

    void m6745a(Token token) {
        byte b = (byte) 1;
        switch (token.f5012c) {
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                this.f4968l.m6717a(token.f5014e, 0.0d);
                break;
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                Symbol b2 = m6747b(token);
                if (!token.m6776a()) {
                    if (b2.f4989a <= null) {
                        if (b2.f4990b == null) {
                            this.f4968l.m6717a(b2.f4991c, b2.f4992d);
                            break;
                        }
                        this.f4969m.m6722a(b2.f4990b);
                        b = (byte) 2;
                        break;
                    }
                    b = b2.f4989a;
                    if (b >= 38 && b <= 42) {
                        throw f4966j.m6773a("eval() on implicit function", this.f4971o.f5005c);
                    }
                }
                this.f4969m.m6722a(b2.f4990b.m6633d());
                b = (byte) 2;
                break;
            default:
                b = token.f5013d;
                if (b <= null) {
                    throw new Error("wrong vmop: " + b + ", id " + token.f5012c + " in \"" + this.f4971o.f5003a + '\"');
                }
                break;
        }
        this.f4967k.m6619a(b);
    }

    CompiledFunction m6746b() {
        return new CompiledFunction(0, this.f4967k.m6621c(), this.f4968l.m6719c(), this.f4968l.m6720d(), this.f4969m.m6724c());
    }
}
