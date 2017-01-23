package org.codehaus.groovy.vmplugin;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.CompileUnit;

public interface VMPlugin {
    void j6(ClassNode classNode);

    void j6(CompileUnit compileUnit, ClassNode classNode);
}
