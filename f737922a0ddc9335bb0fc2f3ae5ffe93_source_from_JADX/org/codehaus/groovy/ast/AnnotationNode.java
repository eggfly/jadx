package org.codehaus.groovy.ast;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.groovy.ast.expr.Expression;

public class AnnotationNode extends ASTNode {
    private Map<String, Expression> DW;
    private boolean FH;
    private boolean Hw;
    private int Zo;
    private final ClassNode j6;
    private boolean v5;

    public AnnotationNode(ClassNode classNode) {
        this.DW = new HashMap();
        this.FH = false;
        this.Hw = false;
        this.v5 = false;
        this.Zo = 255;
        this.j6 = classNode;
    }

    public void j6(String str, Expression expression) {
        this.DW.put(str, expression);
    }

    public void j6(boolean z) {
        this.FH = z;
    }

    public void DW(boolean z) {
        this.Hw = z;
    }

    public void FH(boolean z) {
        this.v5 = z;
    }
}
