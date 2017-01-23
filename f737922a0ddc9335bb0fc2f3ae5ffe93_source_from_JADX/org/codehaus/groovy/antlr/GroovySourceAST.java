package org.codehaus.groovy.antlr;

import groovyjarjarantlr.CommonAST;
import groovyjarjarantlr.Token;
import groovyjarjarantlr.collections.AST;
import java.util.ArrayList;
import java.util.List;

public class GroovySourceAST extends CommonAST implements Comparable, SourceInfo {
    private int VH;
    private int Zo;
    private int gn;
    private int v5;

    public void DW(AST ast) {
        super.DW(ast);
        this.v5 = ast.v5();
        this.Zo = ast.Zo();
        if (ast instanceof GroovySourceAST) {
            GroovySourceAST groovySourceAST = (GroovySourceAST) ast;
            this.VH = groovySourceAST.gn();
            this.gn = groovySourceAST.u7();
        }
    }

    public void j6(Token token) {
        super.j6(token);
        this.v5 = token.v5();
        this.Zo = token.Zo();
        if (token instanceof SourceInfo) {
            SourceInfo sourceInfo = (SourceInfo) token;
            this.VH = sourceInfo.gn();
            this.gn = sourceInfo.u7();
        }
    }

    public int gn() {
        return this.VH;
    }

    public void DW(int i) {
        this.VH = i;
    }

    public int u7() {
        return this.gn;
    }

    public void FH(int i) {
        this.gn = i;
    }

    public int v5() {
        return this.v5;
    }

    public int Zo() {
        return this.Zo;
    }

    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof AST)) {
            return 0;
        }
        AST ast = (AST) obj;
        if (v5() < ast.v5()) {
            return -1;
        }
        if (v5() > ast.v5()) {
            return 1;
        }
        if (Zo() < ast.Zo()) {
            return -1;
        }
        if (Zo() > ast.Zo()) {
            return 1;
        }
        return 0;
    }

    public GroovySourceAST Hw(int i) {
        List arrayList = new ArrayList();
        for (AST j6 = j6(); j6 != null; j6 = j6.DW()) {
            arrayList.add(j6);
        }
        try {
            return (GroovySourceAST) arrayList.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public GroovySourceAST v5(int i) {
        for (AST j6 = j6(); j6 != null; j6 = j6.DW()) {
            if (j6.Hw() == i) {
                return (GroovySourceAST) j6;
            }
        }
        return null;
    }
}
