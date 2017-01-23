package org.codehaus.groovy.ast.stmt;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.Parameter;

public class ForStatement extends Statement implements LoopingStatement {
    public static final Parameter j6;

    static {
        j6 = new Parameter(ClassHelper.DW, "forLoopDummyParameter");
    }
}
