package org.codehaus.groovy.antlr.treewalker;

import org.codehaus.groovy.antlr.GroovySourceAST;

public class PreOrderTraversal extends TraversalHelper {
    public PreOrderTraversal(Visitor visitor) {
        super(visitor);
    }

    public void j6(GroovySourceAST groovySourceAST) {
        Hw(groovySourceAST);
        yS(groovySourceAST);
        rN(groovySourceAST);
        vy(groovySourceAST);
        j6();
    }
}
