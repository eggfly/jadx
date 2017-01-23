package org.codehaus.groovy.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnotatedNode extends ASTNode {
    private List<AnnotationNode> DW;
    private boolean FH;
    ClassNode j6;

    public AnnotatedNode() {
        this.DW = Collections.emptyList();
    }

    public void j6(AnnotationNode annotationNode) {
        Zo();
        this.DW.add(annotationNode);
    }

    private void Zo() {
        if (this.DW == Collections.EMPTY_LIST) {
            this.DW = new ArrayList(3);
        }
    }

    public void j6(boolean z) {
        this.FH = z;
    }

    public void j6(ClassNode classNode) {
        this.j6 = classNode;
    }
}
