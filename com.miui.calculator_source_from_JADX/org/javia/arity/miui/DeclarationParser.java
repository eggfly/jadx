package org.javia.arity.miui;

import com.miui.support.internal.C0264R;
import java.util.Vector;

class DeclarationParser extends TokenConsumer {
    static final String[] f4916a;
    String f4917b;
    int f4918c;
    Vector f4919d;
    private SyntaxException f4920e;

    static {
        f4916a = new String[0];
    }

    DeclarationParser(SyntaxException syntaxException) {
        this.f4919d = new Vector();
        this.f4920e = syntaxException;
    }

    void m6711a() {
        this.f4917b = null;
        this.f4918c = -2;
        this.f4919d.setSize(0);
    }

    void m6712a(Token token) {
        switch (token.f5012c) {
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                if (this.f4917b == null) {
                    this.f4917b = token.f5015f;
                    this.f4918c = -2;
                } else if (this.f4918c >= 0) {
                    this.f4919d.addElement(token.f5015f);
                    this.f4918c++;
                    if (this.f4918c > 5) {
                        throw this.f4920e.m6773a("Arity too large " + this.f4918c, token.f5017h);
                    }
                } else {
                    throw this.f4920e.m6773a("Invalid declaration", token.f5017h);
                }
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                if (this.f4917b == null) {
                    this.f4917b = token.f5015f;
                    this.f4918c = 0;
                    return;
                }
                throw this.f4920e.m6773a("repeated CALL in declaration", token.f5017h);
            case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
            case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
            case C0264R.styleable.Window_windowLayoutMode /*15*/:
            default:
                throw this.f4920e.m6773a("invalid token in declaration", token.f5017h);
        }
    }

    String[] m6713b() {
        if (this.f4918c <= 0) {
            return f4916a;
        }
        String[] strArr = new String[this.f4918c];
        this.f4919d.copyInto(strArr);
        return strArr;
    }
}
