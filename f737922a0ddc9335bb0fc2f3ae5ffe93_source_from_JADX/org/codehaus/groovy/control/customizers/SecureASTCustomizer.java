package org.codehaus.groovy.control.customizers;

import java.util.LinkedList;
import java.util.List;
import org.codehaus.groovy.ast.GroovyCodeVisitor;
import org.codehaus.groovy.control.CompilePhase;

public class SecureASTCustomizer extends CompilationCustomizer {
    private boolean DW;
    private boolean FH;
    private final List<StatementChecker> Hw;
    private boolean j6;
    private final List<ExpressionChecker> v5;

    public interface ExpressionChecker {
    }

    private class SecuringCodeVisitor implements GroovyCodeVisitor {
    }

    public interface StatementChecker {
    }

    public SecureASTCustomizer() {
        super(CompilePhase.CANONICALIZATION);
        this.j6 = true;
        this.DW = true;
        this.FH = true;
        this.Hw = new LinkedList();
        this.v5 = new LinkedList();
    }
}
