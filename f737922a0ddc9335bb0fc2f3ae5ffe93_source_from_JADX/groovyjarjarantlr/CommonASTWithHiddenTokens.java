package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;

public class CommonASTWithHiddenTokens extends CommonAST {
    protected CommonHiddenStreamToken Zo;
    protected CommonHiddenStreamToken v5;

    public CommonHiddenStreamToken gn() {
        return this.Zo;
    }

    public CommonHiddenStreamToken u7() {
        return this.v5;
    }

    public void DW(AST ast) {
        this.v5 = ((CommonASTWithHiddenTokens) ast).u7();
        this.Zo = ((CommonASTWithHiddenTokens) ast).gn();
        super.DW(ast);
    }

    public void j6(Token token) {
        token = (CommonHiddenStreamToken) token;
        super.j6(token);
        this.v5 = token.DW();
        this.Zo = token.j6();
    }
}
