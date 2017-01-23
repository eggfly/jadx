package org.codehaus.groovy.control;

import groovy.lang.GroovyClassLoader;
import java.util.HashSet;
import java.util.Set;

public class ASTTransformationsContext {
    protected final CompilationUnit DW;
    protected final Set<String> FH;
    protected final GroovyClassLoader j6;

    public ASTTransformationsContext(CompilationUnit compilationUnit, GroovyClassLoader groovyClassLoader) {
        this.FH = new HashSet();
        this.DW = compilationUnit;
        this.j6 = groovyClassLoader;
    }
}
