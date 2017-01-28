import java.util.HashSet;
import java.util.Set;

public enum gf implements bd {
    BLOCK_INDENT("Java indentation options", "Indent block contents", "public void f()\n{\n    int i;\n}", "public void f()\n{\nint i;\n}"),
    ARRAY_INDENT("Java indentation options", "Indent array initializer", "int[] arr = new int[]\n{\n    1\n};", "int[] arr = new int[]\n{\n1\n};"),
    BRACE_INDENT("Java indentation options", "Indent open and close brace", "public void f()\n    {\n        int i;\n    }", "public void f()\n{\n    int i;\n}"),
    CASE_INDENT("Java indentation options", "Indent case contents", "switch (x)\n{\n    case 10:\n        return 5;\n}", "switch (x)\n{\n    case 10:\n    return 5;\n}"),
    CASELABEL_INDENT("Java indentation options", "Indent case labels", "switch (x)\n{\n    case 10:\n        return 5;\n}", "switch (x)\n{\ncase 10:\n    return 5;\n}"),
    LABELLEFT_INDENT("Java indentation options", "Indent goto labels in leftmost column", "    goto L;\nL:\n    return;", "    goto L;\n    L:\n    return;"),
    NEXTLINE_INDENT("Java indentation options", "Indent lines in multi line statements", "int i = 10 +\n    20;", "int i = 10 +\n20;"),
    ARGUMENT_INDENT("Java indentation options", "Align arguments", "System.out.println(\"\",\n                  20);", "System.out.println(\"\",\n    20);"),
    PARAMETER_INDENT("Java indentation options", "Align parameters", "void foo(int i,\n         int j)\n{\n}", "void foo(int i,\n    int j)\n{\n}"),
    ADJUST_NEWLINES("Java new line options", "Adjust lines on autoformat", "", ""),
    TYPE_NEWLINE("Java new line options", "Place open brace on new line for types", "public class C\n{\n    //...\n}", "public class C {\n    //...\n}"),
    METHOD_NEWLINE("Java new line options", "Place open brace on new line for methods", "public void f()\n{\n    //...\n}", "public void f() {\n    //...\n}"),
    BLOCK_NEWLINE("Java new line options", "Place open brace on new line for control blocks", "public void f()\n{\n    if (a < b)\n    {\n    }\n}", "public void f()\n{\n    if (a < b) {\n    }\n}"),
    ELSE_NEWLINE("Java new line options", "Place \"else\" on new line", "if (i == 10) {\n    return 10;\n}\nelse {\n    return 0;\n}", "if (i == 10) {\n    return 10;\n} else {\n    return 0;\n}"),
    CATCH_NEWLINE("Java new line options", "Place \"catch\" on new line", "try {\n}\ncatch {\n}", "try {\n} catch {\n}"),
    FINALLY_NEWLINE("Java new line options", "Place \"finally\" on new line", "try {\n}\nfinally {\n}", "try {\n} finally {\n}"),
    STATEMENT_WRAP("Java wrapping options", "Place statement in a new line if it doesn't fit", "int i;\ni = 10;", "int i; i = 10;"),
    ADJUST_SPACES("Java spacing options", "Adjust spaces on autoformat", "", ""),
    BRACE_SPACE("Java spacing options", "Insert space before open brace", "public class C {\n    //...\n}", "public class C{\n    //...\n}"),
    METHODNAME_SPACE("Java spacing options", "Insert space before parameters", "public void f ()\n{\n}", "public void f()\n{\n}"),
    PARAMETER_SPACE("Java spacing options", "Insert space within parameter parentheses", "public void f( int i )\n{\n}", "public void f(int i)\n{\n}"),
    PARAMETERCOMMA_SPACE("Java spacing options", "Insert space after each parameter", "public void f(int i, int j)\n{\n}", "public void f(int i,int j)\n{\n}"),
    KEYWORD_SPACE("Java spacing options", "Insert space after keywords", "if (a == b) return 0;", "if(a == b) return 0;"),
    CONDITION_SPACE("Java spacing options", "Insert space within statement parentheses", "if ( a == b ) return 0;", "if (a == b) return 0;"),
    PAREN_SPACE("Java spacing options", "Insert space within parentheses", "int i = ( 10 + 20 ) * 5;", "int i = (10 + 20) * 5;"),
    METHODCALL_SPACE("Java spacing options", "Insert space before arguments", "System.out.println (10);", "System.out.println(10);"),
    ARGUMENT_SPACE("Java spacing options", "Insert space within argument parentheses", "System.out.println( 10 );", "System.out.println(10);"),
    ARGUMENTCOMMA_SPACE("Java spacing options", "Insert space after each argument", "System.out.println(\"\", 20);", "System.out.println(\"\",20);"),
    ARRAYMETHODCALL_SPACE("Java spacing options", "Insert space before array brackets", "int i = ai [10];", "int i = ai[10];"),
    ARRAYARGUMENT_SPACE("Java spacing options", "Insert space within array brackets", "int i = ai[ 10 ];", "int i = ai[10];"),
    BINARYOPERATOR_SPACE("Java spacing options", "Insert space around binary operator ", "int i;\ni = 10 + 20;", "int i;\ni = 10+20;"),
    ASSIGNMENTOPERATOR_SPACE("Java spacing options", "Insert space around assignment operator ", "int i;\ni = 10;", "int i;\ni=10;");
    
    private final String KD;
    private final String SI;
    private final String cn;
    private final String ro;

    private gf(String str, String str2, String str3, String str4) {
        this.SI = str;
        this.KD = str2;
        this.ro = str3;
        this.cn = str4;
    }

    public String DW() {
        return "java_" + name();
    }

    public String FH() {
        return this.SI;
    }

    public String j6() {
        return this.KD;
    }

    public String j6(boolean z) {
        return z ? this.ro : this.cn;
    }

    public static Set<gf> Hw() {
        Set hashSet = new HashSet();
        hashSet.add(ADJUST_NEWLINES);
        hashSet.add(ADJUST_SPACES);
        hashSet.add(TYPE_NEWLINE);
        hashSet.add(METHOD_NEWLINE);
        hashSet.add(BLOCK_NEWLINE);
        hashSet.add(ELSE_NEWLINE);
        hashSet.add(CATCH_NEWLINE);
        hashSet.add(FINALLY_NEWLINE);
        hashSet.add(STATEMENT_WRAP);
        hashSet.add(PARAMETERCOMMA_SPACE);
        hashSet.add(KEYWORD_SPACE);
        hashSet.add(BRACE_SPACE);
        hashSet.add(ARGUMENTCOMMA_SPACE);
        hashSet.add(BINARYOPERATOR_SPACE);
        hashSet.add(ASSIGNMENTOPERATOR_SPACE);
        hashSet.add(BLOCK_INDENT);
        hashSet.add(ARRAY_INDENT);
        hashSet.add(CASE_INDENT);
        hashSet.add(CASELABEL_INDENT);
        hashSet.add(ARGUMENT_INDENT);
        hashSet.add(PARAMETER_INDENT);
        hashSet.add(NEXTLINE_INDENT);
        return hashSet;
    }
}
