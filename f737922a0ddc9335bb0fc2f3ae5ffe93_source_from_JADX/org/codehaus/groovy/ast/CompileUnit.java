package org.codehaus.groovy.ast;

import groovy.lang.GroovyClassLoader;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.messages.SyntaxErrorMessage;
import org.codehaus.groovy.syntax.SyntaxException;

public class CompileUnit {
    private Map<String, ClassNode> DW;
    private CompilerConfiguration FH;
    private GroovyClassLoader Hw;
    private Map<String, SourceUnit> VH;
    private Map<String, ClassNode> Zo;
    private Map<String, InnerClassNode> gn;
    private final List<ModuleNode> j6;
    private CodeSource v5;

    public CompileUnit(GroovyClassLoader groovyClassLoader, CodeSource codeSource, CompilerConfiguration compilerConfiguration) {
        this.j6 = new ArrayList();
        this.DW = new HashMap();
        this.Zo = new HashMap();
        this.VH = new HashMap();
        this.gn = new HashMap();
        this.Hw = groovyClassLoader;
        this.FH = compilerConfiguration;
        this.v5 = codeSource;
    }

    public ClassNode j6(String str) {
        ClassNode classNode = (ClassNode) this.DW.get(str);
        return classNode != null ? classNode : (ClassNode) this.Zo.get(str);
    }

    public void j6(ClassNode classNode) {
        ClassNode Zo = classNode.Zo();
        String tp = Zo.tp();
        ClassNode classNode2 = (ClassNode) this.DW.get(tp);
        if (!(classNode2 == null || classNode2 == Zo)) {
            String str;
            SourceUnit VH = Zo.J0().VH();
            SourceUnit VH2 = classNode2.J0().VH();
            String str2 = "Invalid duplicate class definition of class " + Zo.tp() + " : ";
            if (VH == VH2) {
                str = str2 + "The source " + VH.Hw() + " contains at least two definitions of the class " + Zo.tp() + ".\n";
                if (Zo.XL() || classNode2.XL()) {
                    str = str + "One of the classes is an explicit generated class using the class statement, the other is a class generated from the script body based on the file name. Solutions are to change the file name or to change the class name.\n";
                }
            } else {
                str = str2 + "The sources " + VH.Hw() + " and " + VH2.Hw() + " each contain a class with the name " + Zo.tp() + ".\n";
            }
            VH.FH().j6(new SyntaxErrorMessage(new SyntaxException(str, Zo.DW(), Zo.FH(), Zo.Hw(), Zo.v5()), VH));
        }
        this.DW.put(tp, Zo);
        if (this.Zo.containsKey(tp)) {
            ((ClassNode) this.Zo.get(tp)).DW(Zo);
            this.Zo.remove(tp);
        }
    }
}
