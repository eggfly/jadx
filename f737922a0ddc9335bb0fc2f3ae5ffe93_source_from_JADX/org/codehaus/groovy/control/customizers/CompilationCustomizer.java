package org.codehaus.groovy.control.customizers;

import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation;
import org.codehaus.groovy.control.CompilePhase;

public abstract class CompilationCustomizer extends PrimaryClassNodeOperation {
    private final CompilePhase j6;

    public CompilationCustomizer(CompilePhase compilePhase) {
        this.j6 = compilePhase;
    }

    public CompilePhase DW() {
        return this.j6;
    }
}
