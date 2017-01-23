package org.codehaus.groovy.antlr.treewalker;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class NodeCollector extends VisitorAdapter {
    private List j6;

    public NodeCollector() {
        this.j6 = new ArrayList();
    }

    public List Hw() {
        return this.j6;
    }

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.j6.add(groovySourceAST);
        }
    }
}
