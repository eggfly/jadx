package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;

public class DiagnosticCodeGenerator extends CodeGenerator {
    protected boolean DW;
    protected int j6;

    public DiagnosticCodeGenerator() {
        this.j6 = 0;
        this.DW = false;
        this.Ws = new JavaCharFormatter();
    }

    public String j6(Vector vector) {
        return new StringBuffer().append("***Create an AST from a vector here***").append(System.getProperty("line.separator")).toString();
    }

    public String j6(GrammarAtom grammarAtom, String str) {
        return new StringBuffer().append("[").append(str).append("]").toString();
    }

    public String j6(String str, ActionTransInfo actionTransInfo) {
        return str;
    }
}
