package org.codehaus.groovy.control.customizers.builder;

import groovy.util.FactoryBuilderSupport;

public class CompilerCustomizationBuilder extends FactoryBuilderSupport {
    public static /* synthetic */ long DW;
    public static /* synthetic */ long j6;

    static {
        j6();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495628015L).longValue();
    }

    public static /* synthetic */ void j6() {
    }

    public CompilerCustomizationBuilder() {
        DW();
    }

    private void DW() {
        registerFactory("ast", new ASTTransformationCustomizerFactory());
        registerFactory("customizers", new CustomizersFactory());
        registerFactory("imports", new ImportCustomizerFactory());
        registerFactory("inline", new InlinedASTCustomizerFactory());
        registerFactory("secureAst", new SecureASTCustomizerFactory());
        registerFactory("source", new SourceAwareCustomizerFactory());
    }
}
