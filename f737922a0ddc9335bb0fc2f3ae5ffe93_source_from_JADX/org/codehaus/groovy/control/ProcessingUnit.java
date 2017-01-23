package org.codehaus.groovy.control;

import groovy.lang.GroovyClassLoader;

public abstract class ProcessingUnit {
    protected int Mr;
    protected CompilerConfiguration U2;
    protected GroovyClassLoader a8;
    protected ErrorCollector lg;

    public ProcessingUnit(CompilerConfiguration compilerConfiguration, GroovyClassLoader groovyClassLoader, ErrorCollector errorCollector) {
        this.Mr = 1;
        this.U2 = compilerConfiguration;
        j6(groovyClassLoader);
        if (compilerConfiguration == null) {
            compilerConfiguration = new CompilerConfiguration();
        }
        j6(compilerConfiguration);
        if (errorCollector == null) {
            errorCollector = new ErrorCollector(j6());
        }
        this.lg = errorCollector;
    }

    public void j6(CompilerConfiguration compilerConfiguration) {
        this.U2 = compilerConfiguration;
    }

    public CompilerConfiguration j6() {
        return this.U2;
    }

    public GroovyClassLoader DW() {
        return this.a8;
    }

    public void j6(GroovyClassLoader groovyClassLoader) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ProcessingUnit.class.getClassLoader();
        }
        if (groovyClassLoader == null) {
            groovyClassLoader = new GroovyClassLoader(contextClassLoader, this.U2);
        }
        this.a8 = groovyClassLoader;
    }

    public ErrorCollector FH() {
        return this.lg;
    }
}
