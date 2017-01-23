package org.codehaus.groovy.control;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.codehaus.groovy.ast.ClassCodeExpressionTransformer;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.GenericsType;
import org.codehaus.groovy.ast.ImportNode;

public class ResolveVisitor extends ClassCodeExpressionTransformer {
    public static final String[] j6;
    private CompilationUnit DW;
    private boolean FH;
    private boolean Hw;
    private Set<FieldNode> VH;
    private Map<String, GenericsType> Zo;
    private boolean gn;
    private ClassNodeResolver tp;
    private ImportNode u7;
    private boolean v5;

    private static class ConstructedClassWithPackage extends ClassNode {
        String gn;
        String u7;

        public String tp() {
            if (Zo() != this) {
                return super.tp();
            }
            return this.gn + this.u7;
        }
    }

    private static class LowerCaseClass extends ClassNode {
        String gn;

        public String tp() {
            if (Zo() != this) {
                return super.tp();
            }
            return this.gn;
        }
    }

    static {
        j6 = new String[]{"java.lang.", "java.io.", "java.net.", "java.util.", "groovy.lang.", "groovy.util."};
    }

    public ResolveVisitor(CompilationUnit compilationUnit) {
        this.FH = true;
        this.Hw = false;
        this.v5 = false;
        this.Zo = new HashMap();
        this.VH = new HashSet();
        this.gn = false;
        this.u7 = null;
        this.DW = compilationUnit;
        this.tp = new ClassNodeResolver();
    }
}
