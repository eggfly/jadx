package org.codehaus.groovy.antlr.java;

import org.codehaus.groovy.antlr.GroovySourceAST;
import org.codehaus.groovy.antlr.treewalker.VisitorAdapter;

public class Java2GroovyConverter extends VisitorAdapter {
    private int[] j6;

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            groovySourceAST.j6(this.j6[groovySourceAST.Hw()]);
            if (groovySourceAST.Hw() == 88) {
                String FH = groovySourceAST.FH();
                if (j6(FH)) {
                    groovySourceAST.j6(FH.substring(1, FH.length() - 1));
                } else if (DW(FH)) {
                    groovySourceAST.j6(FH.substring(1, FH.length() - 1));
                }
            }
        }
    }

    private boolean j6(String str) {
        return str != null && str.length() > 2 && str.charAt(0) == '\'' && str.charAt(str.length() - 1) == '\'';
    }

    private boolean DW(String str) {
        return str != null && str.length() > 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"';
    }
}
