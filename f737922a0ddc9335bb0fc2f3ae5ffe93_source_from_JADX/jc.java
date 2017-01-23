import groovyjarjarantlr.CharScanner;
import groovyjarjarantlr.collections.AST;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.groovy.antlr.SourceBuffer;
import org.codehaus.groovy.antlr.UnicodeEscapingReader;
import org.codehaus.groovy.antlr.parser.GroovyLexer;
import org.codehaus.groovy.antlr.parser.GroovyRecognizer;

public class jc extends oe<jc> {
    private String DW;
    private Map<String, String> j6;

    protected /* synthetic */ oe DW(String str) {
        return j6(str);
    }

    public String j6(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        if (this.j6.containsKey(str2)) {
            return qh.VH(this.DW, (String) this.j6.get(str2));
        }
        return qh.VH(str, str2.replace(":", "/"));
    }

    public jc() {
        this.j6 = new HashMap();
    }

    protected jc j6(String str) {
        return new jc(str);
    }

    private jc(String str) {
        this.j6 = new HashMap();
        try {
            this.DW = qh.v5(str);
            Reader fileReader = new FileReader(str);
            SourceBuffer sourceBuffer = new SourceBuffer();
            Reader unicodeEscapingReader = new UnicodeEscapingReader(fileReader, sourceBuffer);
            GroovyLexer groovyLexer = new GroovyLexer(unicodeEscapingReader);
            unicodeEscapingReader.j6((CharScanner) groovyLexer);
            GroovyRecognizer j6 = GroovyRecognizer.j6(groovyLexer);
            j6.j6(sourceBuffer);
            j6.VH();
            fileReader.close();
            for (AST FH = j6.FH(); FH != null; FH = FH.DW()) {
                if (v5(FH)) {
                    AST Hw = Hw(FH);
                    AST FH2 = FH(FH);
                    if (j6(Hw, "projectDir") && DW(j6(Hw), "project") && DW(FH2, "file")) {
                        String DW = DW(j6(Hw));
                        String DW2 = DW(FH2);
                        if (!(DW == null || DW2 == null)) {
                            this.j6.put(DW, DW2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean j6(AST ast, String str) {
        return Zo(ast) == 90 && str.equals(u7(gn(VH(ast))));
    }

    private AST j6(AST ast) {
        return VH(ast);
    }

    private boolean DW(AST ast, String str) {
        return Zo(ast) == 27 && str.equals(u7(VH(ast)));
    }

    private String DW(AST ast) {
        return u7(VH(VH(gn(VH(ast)))));
    }

    private AST FH(AST ast) {
        return gn(VH(VH(ast)));
    }

    private AST Hw(AST ast) {
        return VH(VH(ast));
    }

    private boolean v5(AST ast) {
        return Zo(ast) == 28 && Zo(VH(ast)) == 124;
    }

    private static int Zo(AST ast) {
        if (ast == null) {
            return 0;
        }
        return ast.Hw();
    }

    private static AST VH(AST ast) {
        if (ast == null) {
            return null;
        }
        return ast.j6();
    }

    private static AST gn(AST ast) {
        if (ast == null) {
            return null;
        }
        return ast.DW();
    }

    private static String u7(AST ast) {
        if (ast == null) {
            return null;
        }
        return ast.FH();
    }
}
