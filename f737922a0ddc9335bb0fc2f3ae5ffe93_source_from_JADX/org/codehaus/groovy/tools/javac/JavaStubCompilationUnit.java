package org.codehaus.groovy.tools.javac;

import java.io.File;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation;
import org.codehaus.groovy.control.CompilerConfiguration;

public class JavaStubCompilationUnit extends CompilationUnit {
    static final /* synthetic */ boolean rN;

    class 1 extends PrimaryClassNodeOperation {
    }

    class 2 extends PrimaryClassNodeOperation {
    }

    static {
        rN = !JavaStubCompilationUnit.class.desiredAssertionStatus();
    }

    public void j6(CompilerConfiguration compilerConfiguration) {
        super.j6(compilerConfiguration);
        File j6 = compilerConfiguration.j6();
        if (j6 != null) {
            DW().addClasspath(j6.getAbsolutePath());
        }
    }
}
