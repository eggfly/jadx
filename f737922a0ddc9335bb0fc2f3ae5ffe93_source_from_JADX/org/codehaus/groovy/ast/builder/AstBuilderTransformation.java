package org.codehaus.groovy.ast.builder;

import org.codehaus.groovy.ast.CodeVisitorSupport;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
public class AstBuilderTransformation implements ASTTransformation {

    private static class AstBuilderInvocationTrap extends CodeVisitorSupport {
    }
}
