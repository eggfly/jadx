package org.javia.arity.miui;

import com.miui.support.internal.C0264R;
import java.util.Stack;

class RPN extends TokenConsumer {
    Stack f4982a;
    int f4983b;
    TokenConsumer f4984c;
    SyntaxException f4985d;

    RPN(SyntaxException syntaxException) {
        this.f4982a = new Stack();
        this.f4983b = 0;
        this.f4985d = syntaxException;
    }

    void m6756a(TokenConsumer tokenConsumer) {
        this.f4984c = tokenConsumer;
    }

    void m6754a() {
        this.f4982a.removeAllElements();
        this.f4983b = 0;
        this.f4984c.m6709a();
    }

    private Token m6752b() {
        return this.f4982a.empty() ? null : (Token) this.f4982a.peek();
    }

    private void m6753b(int i) {
        Token b = m6752b();
        while (b != null && b.f5010a >= i) {
            this.f4984c.m6710a(b);
            this.f4982a.pop();
            b = m6752b();
        }
    }

    static final boolean m6751a(int i) {
        return i == 8 || i == 14 || i == 9 || i == 10 || i == 17;
    }

    void m6755a(Token token) {
        int i = 1;
        int i2 = token.f5010a;
        int i3 = token.f5012c;
        Token b;
        switch (i3) {
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                if (m6751a(this.f4983b)) {
                    m6755a(Lexer.f4945c);
                }
                this.f4984c.m6710a(token);
                break;
            case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                if (m6751a(this.f4983b)) {
                    m6753b(i2);
                    b = m6752b();
                    if (b != null && b.f5012c == 11) {
                        b.f5016g++;
                        break;
                    }
                    throw this.f4985d.m6773a("COMMA not inside CALL", token.f5017h);
                }
                throw this.f4985d.m6773a("misplaced COMMA", token.f5017h);
                break;
            case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                if (this.f4983b == 11) {
                    b = m6752b();
                    b.f5016g--;
                } else if (!m6751a(this.f4983b)) {
                    throw this.f4985d.m6773a("unexpected ) or END", token.f5017h);
                }
                m6753b(i2);
                b = m6752b();
                if (b != null) {
                    if (b.f5012c == 11) {
                        this.f4984c.m6710a(b);
                    } else if (b != Lexer.f4953k) {
                        throw this.f4985d.m6773a("expected LPAREN or CALL", token.f5017h);
                    }
                    this.f4982a.pop();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowLayoutMode /*15*/:
                b = Lexer.f4954l;
                b.f5017h = token.f5017h;
                do {
                    m6755a(b);
                } while (m6752b() != null);
                break;
            default:
                if (token.f5011b != 1) {
                    if (m6751a(this.f4983b)) {
                        if (token.f5011b != 3) {
                            i = 0;
                        }
                        m6753b(i + i2);
                        this.f4982a.push(token);
                        break;
                    } else if (i3 == 2) {
                        token = Lexer.f4948f;
                        this.f4982a.push(token);
                        break;
                    } else if (i3 != 1) {
                        throw this.f4985d.m6773a("operator without operand", token.f5017h);
                    } else {
                        return;
                    }
                }
                if (m6751a(this.f4983b)) {
                    m6755a(Lexer.f4945c);
                }
                this.f4982a.push(token);
                break;
        }
        this.f4983b = token.f5012c;
    }
}
