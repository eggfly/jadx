package org.javia.arity.miui;

import com.miui.support.internal.C0264R;

class Token {
    final int f5010a;
    final int f5011b;
    final int f5012c;
    final byte f5013d;
    double f5014e;
    String f5015f;
    int f5016g;
    int f5017h;

    Token(int i, int i2, int i3, int i4) {
        this.f5015f = null;
        this.f5012c = i;
        this.f5010a = i2;
        this.f5011b = i3;
        this.f5013d = (byte) i4;
        this.f5016g = i == 11 ? 1 : -3;
    }

    Token m6774a(double d) {
        this.f5014e = d;
        return this;
    }

    Token m6775a(String str) {
        this.f5015f = str;
        return this;
    }

    public boolean m6776a() {
        if (this.f5015f != null) {
            int length = this.f5015f.length();
            if (length > 0 && this.f5015f.charAt(length - 1) == '\'') {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        switch (this.f5012c) {
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                return "" + this.f5014e;
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                return this.f5015f;
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                return this.f5015f + '(' + this.f5016g + ')';
            default:
                return "" + this.f5012c;
        }
    }
}
