package org.codehaus.groovy.control;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;

public class ClassNodeResolver {
    protected static final ClassNode j6;
    private Map<String, ClassNode> DW;

    static class 1 extends ClassNode {
        1(String str, int i, ClassNode classNode) {
            super(str, i, classNode);
        }

        public void DW(ClassNode classNode) {
            throw new GroovyBugError("This is a dummy class node only! Never use it for real classes.");
        }
    }

    public static class LookupResult {
    }

    public ClassNodeResolver() {
        this.DW = new HashMap();
    }

    static {
        j6 = new 1("NO_CLASS", 1, ClassHelper.DW);
    }
}
