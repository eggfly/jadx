package org.codehaus.groovy.tools.javac;

import java.io.File;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation;
import org.codehaus.groovy.control.CompilerConfiguration;

public class JavaAwareCompilationUnit extends CompilationUnit {

    class 1 extends PrimaryClassNodeOperation {
    }

    class 2 extends PrimaryClassNodeOperation {
    }

    public void j6(CompilerConfiguration compilerConfiguration) {
        super.j6(compilerConfiguration);
        File j6 = compilerConfiguration.j6();
        if (j6 != null) {
            DW().addClasspath(j6.getAbsolutePath());
        }
    }
}
