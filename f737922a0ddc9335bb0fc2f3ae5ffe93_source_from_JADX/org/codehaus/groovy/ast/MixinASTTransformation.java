package org.codehaus.groovy.ast;

import groovy.lang.Mixin;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.transform.AbstractASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

@Deprecated
@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class MixinASTTransformation extends AbstractASTTransformation {
    private static final ClassNode j6;

    static {
        j6 = ClassHelper.DW(Mixin.class);
    }
}
