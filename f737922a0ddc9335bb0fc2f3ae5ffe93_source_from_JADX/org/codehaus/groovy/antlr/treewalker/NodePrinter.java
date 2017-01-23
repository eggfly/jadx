package org.codehaus.groovy.antlr.treewalker;

import java.io.PrintStream;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class NodePrinter extends VisitorAdapter {
    private PrintStream DW;
    private String[] j6;

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.DW.print("<" + this.j6[groovySourceAST.Hw()] + ">");
        } else {
            this.DW.print("</" + this.j6[groovySourceAST.Hw()] + ">");
        }
    }
}
