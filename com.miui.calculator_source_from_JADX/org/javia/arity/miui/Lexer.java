package org.javia.arity.miui;

class Lexer {
    static final Token f4943a;
    static final Token f4944b;
    static final Token f4945c;
    static final Token f4946d;
    static final Token f4947e;
    static final Token f4948f;
    static final Token f4949g;
    static final Token f4950h;
    static final Token f4951i;
    static final Token f4952j;
    static final Token f4953k;
    static final Token f4954l;
    static final Token f4955m;
    static final Token f4956n;
    static final Token f4957o;
    static final Token f4958p;
    private char[] f4959q;
    private int f4960r;
    private SyntaxException f4961s;

    static {
        f4943a = new Token(1, 4, 2, 3);
        f4944b = new Token(2, 4, 2, 4);
        f4945c = new Token(3, 5, 2, 5);
        f4946d = new Token(4, 5, 2, 6);
        f4947e = new Token(5, 5, 2, 7);
        f4948f = new Token(6, 6, 1, 9);
        f4949g = new Token(7, 7, 3, 10);
        f4950h = new Token(8, 8, 4, 11);
        f4951i = new Token(17, 9, 4, 12);
        f4952j = new Token(16, 10, 1, 13);
        f4953k = new Token(13, 1, 1, 0);
        f4954l = new Token(14, 3, 0, 0);
        f4955m = new Token(12, 2, 0, 0);
        f4956n = new Token(15, 0, 0, 0);
        f4957o = new Token(9, 20, 0, 0);
        f4958p = new Token(10, 20, 0, 0);
    }

    Lexer(SyntaxException syntaxException) {
        this.f4959q = new char[32];
        this.f4961s = syntaxException;
    }

    void m6727a(String str, TokenConsumer tokenConsumer) {
        this.f4961s.f5003a = str;
        if (str.indexOf(36) != -1) {
            throw this.f4961s.m6773a("Invalid character '$'", str.indexOf(36));
        }
        m6725a(str);
        tokenConsumer.m6709a();
        Token a;
        do {
            int i = this.f4960r;
            a = m6726a();
            a.f5017h = i;
            tokenConsumer.m6710a(a);
        } while (a != f4956n);
    }

    private void m6725a(String str) {
        int length = str.length();
        if (this.f4959q.length < length + 1) {
            this.f4959q = new char[(length + 1)];
        }
        str.getChars(0, length, this.f4959q, 0);
        this.f4959q[length] = '$';
        this.f4960r = 0;
    }

    Token m6726a() {
        int i = 0;
        while (" \n\r\t".indexOf(this.f4959q[this.f4960r]) != -1) {
            this.f4960r++;
        }
        char c = this.f4959q[this.f4960r];
        int i2 = this.f4960r;
        this.f4960r = i2 + 1;
        switch (c) {
            case '!':
                return f4950h;
            case '#':
                return f4947e;
            case '$':
                return f4956n;
            case '%':
                return f4951i;
            case '(':
                return f4953k;
            case ')':
                return f4954l;
            case '*':
                return f4945c;
            case '+':
                return f4943a;
            case ',':
                return f4955m;
            case '-':
                return f4944b;
            case '/':
                return f4946d;
            default:
                int i3 = this.f4960r;
                int i4;
                char c2;
                int i5;
                if (('0' <= c && c <= '9') || c == '.') {
                    String valueOf;
                    if (c == '0') {
                        char toLowerCase = Character.toLowerCase(this.f4959q[i3]);
                        if (toLowerCase == 'x') {
                            i = 16;
                        } else if (toLowerCase == 'b') {
                            i = 2;
                        } else if (toLowerCase == 'o') {
                            i = 8;
                        }
                        if (i > 0) {
                            i3++;
                            while (true) {
                                i4 = i3 + 1;
                                c2 = this.f4959q[i3];
                                if (('a' > c2 || c2 > 'z') && (('A' > c2 || c2 > 'Z') && ('0' > c2 || c2 > '9'))) {
                                    valueOf = String.valueOf(this.f4959q, i2 + 2, (i4 - 3) - i2);
                                    this.f4960r = i4 - 1;
                                    try {
                                        return f4957o.m6774a((double) Integer.parseInt(valueOf, i));
                                    } catch (NumberFormatException e) {
                                        throw this.f4961s.m6773a("invalid number '" + String.valueOf(this.f4959q, i2, (i4 - 1) - i2) + "'", i2);
                                    }
                                }
                                i3 = i4;
                            }
                        }
                    }
                    while (true) {
                        if (('0' <= c && c <= '9') || c == '.' || c == 'E' || c == 'e') {
                            if ((c == 'E' || c == 'e') && (this.f4959q[i3] == '-' || this.f4959q[i3] == '\u2212')) {
                                this.f4959q[i3] = '-';
                                i3++;
                            }
                            i5 = i3 + 1;
                            c = this.f4959q[i3];
                            i3 = i5;
                        } else {
                            this.f4960r = i3 - 1;
                            valueOf = String.valueOf(this.f4959q, i2, (i3 - 1) - i2);
                            try {
                                if (valueOf.equals(".")) {
                                    return f4957o.m6774a(0.0d);
                                }
                                return f4957o.m6774a(Double.parseDouble(valueOf));
                            } catch (NumberFormatException e2) {
                                throw this.f4961s.m6773a("invalid number '" + valueOf + "'", i2);
                            }
                        }
                    }
                } else if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                    while (true) {
                        i4 = i3 + 1;
                        i3 = this.f4959q[i3];
                        if (('a' > i3 || i3 > 'z') && (('A' > i3 || i3 > 'Z') && ('0' > i3 || i3 > '9'))) {
                            if (i3 == '\'') {
                                i5 = i4 + 1;
                                i3 = this.f4959q[i4];
                                i4 = i5;
                            }
                            String valueOf2 = String.valueOf(this.f4959q, i2, (i4 - 1) - i2);
                            while (" \n\r\t".indexOf(i3) != -1) {
                                i5 = i4 + 1;
                                c2 = this.f4959q[i4];
                                i4 = i5;
                            }
                            if (i3 == 40) {
                                this.f4960r = i4;
                                return new Token(11, 0, 1, 0).m6775a(valueOf2);
                            }
                            this.f4960r = i4 - 1;
                            return f4958p.m6775a(valueOf2);
                        }
                        i3 = i4;
                    }
                } else if ((c >= '\u0391' && c <= '\u03a9') || ((c >= '\u03b1' && c <= '\u03c9') || c == '\u221e')) {
                    return f4958p.m6775a("" + c);
                } else {
                    switch (c) {
                        case '^':
                            return f4949g;
                        case '\u00d7':
                            return f4945c;
                        case '\u00f7':
                            return f4946d;
                        case '\u2212':
                            return f4944b;
                        case '\u221a':
                            return f4952j;
                        default:
                            throw this.f4961s.m6773a("invalid character '" + c + "'", i2);
                    }
                }
                break;
        }
    }
}
