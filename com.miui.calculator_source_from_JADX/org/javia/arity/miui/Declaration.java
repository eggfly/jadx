package org.javia.arity.miui;

class Declaration {
    private static final String[] f4911e;
    String f4912a;
    String[] f4913b;
    int f4914c;
    String f4915d;

    Declaration() {
    }

    static {
        f4911e = new String[0];
    }

    void m6708a(String str, Lexer lexer, DeclarationParser declarationParser) {
        int indexOf = str.indexOf(61);
        if (indexOf == -1) {
            this.f4915d = str;
            this.f4912a = null;
            this.f4913b = f4911e;
            this.f4914c = -2;
            return;
        }
        String substring = str.substring(0, indexOf);
        this.f4915d = str.substring(indexOf + 1);
        lexer.m6727a(substring, declarationParser);
        this.f4912a = declarationParser.f4917b;
        this.f4913b = declarationParser.m6713b();
        this.f4914c = declarationParser.f4918c;
    }
}
