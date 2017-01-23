package org.codehaus.groovy.ast;

import org.codehaus.groovy.ast.stmt.Statement;

public class ConstructorNode extends MethodNode {
    public ConstructorNode(int i, Parameter[] parameterArr, ClassNode[] classNodeArr, Statement statement) {
        super("<init>", i, ClassHelper.FH, parameterArr, classNodeArr, statement);
        VariableScope variableScope = new VariableScope();
        for (Variable j6 : parameterArr) {
            variableScope.j6(j6);
        }
        j6(variableScope);
    }
}
