package org.codehaus.groovy.tools.javac;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.classgen.Verifier;

public class JavaStubGenerator {
    private static final ClassNode j6;

    class 1 extends Verifier {
    }

    static {
        j6 = ClassHelper.DW(RuntimeException.class);
    }
}
