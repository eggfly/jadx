package org.javia.arity.miui;

class Compiler {
    private final SyntaxException f4901a;
    private final Lexer f4902b;
    private final RPN f4903c;
    private final DeclarationParser f4904d;
    private final OptCodeGen f4905e;
    private final SimpleCodeGen f4906f;
    private final Declaration f4907g;

    Compiler() {
        this.f4901a = new SyntaxException();
        this.f4902b = new Lexer(this.f4901a);
        this.f4903c = new RPN(this.f4901a);
        this.f4904d = new DeclarationParser(this.f4901a);
        this.f4905e = new OptCodeGen(this.f4901a);
        this.f4906f = new SimpleCodeGen(this.f4901a);
        this.f4907g = new Declaration();
    }

    Function m6660a(Symbols symbols, String str) {
        this.f4903c.m6756a(this.f4906f.m6743a(symbols));
        this.f4902b.m6727a(str, this.f4903c);
        return this.f4906f.m6746b();
    }

    Function m6661b(Symbols symbols, String str) {
        Function constant;
        int i;
        this.f4907g.m6708a(str, this.f4902b, this.f4904d);
        if (this.f4907g.f4914c == -2) {
            try {
                constant = new Constant(m6660a(symbols, this.f4907g.f4915d).m6630b());
            } catch (SyntaxException e) {
                if (e != SimpleCodeGen.f4966j) {
                    throw e;
                }
            }
            if (constant == null) {
                symbols.m6764a();
                symbols.m6769a(this.f4907g.f4913b);
                try {
                    this.f4903c.m6756a(this.f4905e.m6743a(symbols));
                    this.f4902b.m6727a(this.f4907g.f4915d, this.f4903c);
                    i = this.f4907g.f4914c;
                    if (i == -2) {
                        i = this.f4905e.f4980i;
                    }
                    constant = this.f4905e.m6748a(i);
                } finally {
                    symbols.m6771b();
                }
            }
            constant.f4887a = str;
            return constant;
        }
        constant = null;
        if (constant == null) {
            symbols.m6764a();
            symbols.m6769a(this.f4907g.f4913b);
            this.f4903c.m6756a(this.f4905e.m6743a(symbols));
            this.f4902b.m6727a(this.f4907g.f4915d, this.f4903c);
            i = this.f4907g.f4914c;
            if (i == -2) {
                i = this.f4905e.f4980i;
            }
            constant = this.f4905e.m6748a(i);
        }
        constant.f4887a = str;
        return constant;
    }

    FunctionAndName m6662c(Symbols symbols, String str) {
        return new FunctionAndName(m6661b(symbols, str), this.f4907g.f4912a);
    }
}
