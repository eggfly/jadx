package org.codehaus.groovy.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.ast.ClassCodeExpressionTransformer;
import org.codehaus.groovy.ast.FieldNode;

public class OptimizerVisitor extends ClassCodeExpressionTransformer {
    private List<FieldNode> DW;
    private Map j6;

    public OptimizerVisitor(CompilationUnit compilationUnit) {
        this.j6 = new HashMap();
        this.DW = new LinkedList();
    }
}
