package org.codehaus.groovy.antlr;

import groovyjarjarantlr.collections.AST;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AntlrASTProcessSnippets implements AntlrASTProcessor {
    public AST j6(AST ast) {
        List arrayList = new ArrayList();
        j6((GroovySourceAST) ast, arrayList, null);
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next();
        }
        j6((GroovySourceAST) ast, null, it);
        return ast;
    }

    private void j6(GroovySourceAST groovySourceAST, List list, Iterator it) {
        while (groovySourceAST != null) {
            if (list != null) {
                list.add(new LineColumn(groovySourceAST.v5(), groovySourceAST.Zo()));
            }
            if (it != null && it.hasNext()) {
                LineColumn lineColumn = (LineColumn) it.next();
                if (groovySourceAST.gn() == 0) {
                    int j6 = lineColumn.j6();
                    int DW = lineColumn.DW();
                    if (j6 < groovySourceAST.v5() || (j6 == groovySourceAST.v5() && DW < groovySourceAST.Zo())) {
                        j6 = groovySourceAST.v5();
                        DW = groovySourceAST.Zo();
                    }
                    groovySourceAST.DW(j6);
                    groovySourceAST.FH(DW);
                }
            }
            GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
            if (groovySourceAST2 != null) {
                j6(groovySourceAST2, list, it);
            }
            groovySourceAST = (GroovySourceAST) groovySourceAST.DW();
        }
    }
}
