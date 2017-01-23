package org.codehaus.groovy.antlr.treewalker;

import groovyjarjarantlr.collections.AST;
import java.util.List;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class FlatNodeListTraversal extends TraversalHelper {
    public AST j6(AST ast) {
        GroovySourceAST groovySourceAST = (GroovySourceAST) ast;
        Object nodeCollector = new NodeCollector();
        new PreOrderTraversal(nodeCollector).j6(ast);
        List<GroovySourceAST> Hw = nodeCollector.Hw();
        DW(groovySourceAST);
        for (GroovySourceAST j6 : Hw) {
            j6(j6);
        }
        FH(groovySourceAST);
        return null;
    }

    protected void j6(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        vy(groovySourceAST);
    }
}
