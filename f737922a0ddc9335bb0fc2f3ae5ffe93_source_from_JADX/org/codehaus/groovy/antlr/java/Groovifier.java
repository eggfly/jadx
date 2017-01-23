package org.codehaus.groovy.antlr.java;

import org.codehaus.groovy.antlr.GroovySourceAST;
import org.codehaus.groovy.antlr.parser.GroovyTokenTypes;
import org.codehaus.groovy.antlr.treewalker.VisitorAdapter;

public class Groovifier extends VisitorAdapter implements GroovyTokenTypes {
    private boolean DW;
    private String j6;

    public void j6(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.j6 = groovySourceAST.v5(87).FH();
        }
    }

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            if (groovySourceAST.Hw() == 116 && this.DW) {
                groovySourceAST.j6(28);
            }
            if (groovySourceAST.Hw() == 8) {
                String FH = groovySourceAST.v5(87).FH();
                if (FH != null && FH.length() > 0 && FH.equals(this.j6)) {
                    groovySourceAST.j6(46);
                }
            }
        }
    }
}
