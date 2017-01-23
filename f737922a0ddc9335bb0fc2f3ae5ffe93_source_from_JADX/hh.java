import java.util.HashSet;
import java.util.Set;

public enum hh implements bd {
    BLOCK_INDENT("JavaScript indentation options", "Indent block contents", "{\n    foo();\n}", "{\nfoo();\n}"),
    ARRAY_INDENT("JavaScript indentation options", "Indent array/object initializer", "[\n    1\n];", "[\n1\n];"),
    BRACE_INDENT("JavaScript indentation options", "Indent open and close brace", "    {\n        foo();\n    }", "{\n    foo();\n}"),
    CASE_INDENT("JavaScript indentation options", "Indent case contents", "switch (x)\n{\n    case 10:\n        return 5;\n}", "switch (x)\n{\n    case 10:\n    return 5;\n}"),
    CASELABEL_INDENT("JavaScript indentation options", "Indent case labels", "switch (x)\n{\n    case 10:\n        return 5;\n}", "switch (x)\n{\ncase 10:\n    return 5;\n}"),
    LABELLEFT_INDENT("JavaScript indentation options", "Indent goto labels in leftmost column", "    goto L;\nL:\n    return;", "    goto L;\n    L:\n    return;"),
    NEXTLINE_INDENT("JavaScript indentation options", "Indent lines in multi line statements", "i = 10 +\n    20;", "i = 10 +\n20;"),
    ARGUMENT_INDENT("JavaScript indentation options", "Align arguments", "println(\"\",\n                  20);", "println(\"\",\n    20);"),
    PARAMETER_INDENT("JavaScript indentation options", "Align parameters", "foo(i,\n         j)\n{\n}", "foo(i,\n    j)\n{\n}"),
    ADJUST_NEWLINES("JavaScript new line options", "Adjust lines on autoformat", "", ""),
    BLOCK_NEWLINE("JavaScript new line options", "Place open brace on new line for control blocks", "{\n    if (a < b)\n    {\n    }\n}", "{\n    if (a < b) {\n    }\n}"),
    FUNCTION_NEWLINE("JavaScript new line options", "Place open brace on new line for functions", "function()\n{\n}", "function() {\n}"),
    ELSE_NEWLINE("JavaScript new line options", "Place \"else\" on new line", "if (i == 10) {\n    return 10;\n}\nelse {\n    return 0;\n}", "if (i == 10) {\n    return 10;\n} else {\n    return 0;\n}"),
    CATCH_NEWLINE("JavaScript new line options", "Place \"catch\" on new line", "try {\n}\ncatch {\n}", "try {\n} catch {\n}"),
    FINALLY_NEWLINE("JavaScript new line options", "Place \"finally\" on new line", "try {\n}\nfinally {\n}", "try {\n} finally {\n}"),
    STATEMENT_WRAP("JavaScript wrapping options", "Place statement in a new line if it doesn't fit", "var i = 0;\ni = 10;", "var i = 0; i = 10;"),
    ADJUST_SPACES("JavaScript spacing options", "Adjust spaces on autoformat", "", ""),
    BRACE_SPACE("JavaScript spacing options", "Insert space before open brace", "if (true) {\n    //...\n}", "if (true){\n    //...\n}"),
    PARAMETER_SPACE("JavaScript spacing options", "Insert space within parameter parentheses", "function f( i )\n{\n}", "function f(i)\n{\n}"),
    PARAMETERCOMMA_SPACE("JavaScript spacing options", "Insert space after each parameter", "function f(i, j)\n{\n}", "function f(i,j)\n{\n}"),
    KEYWORD_SPACE("JavaScript spacing options", "Insert space after keywords", "if (a == b) return 0;", "if(a == b) return 0;"),
    CONDITION_SPACE("JavaScript spacing options", "Insert space within statement parentheses", "if ( a == b ) return 0;", "if (a == b) return 0;"),
    PAREN_SPACE("JavaScript spacing options", "Insert space within parentheses", "i = ( 10 + 20 ) * 5;", "i = (10 + 20) * 5;"),
    METHODCALL_SPACE("JavaScript spacing options", "Insert space before arguments", "println (10);", "println(10);"),
    ARGUMENT_SPACE("JavaScript spacing options", "Insert space within argument parentheses", "println( 10 );", "println(10);"),
    ARGUMENTCOMMA_SPACE("JavaScript spacing options", "Insert space after each argument", "println(\"\", 20);", "println(\"\",20);"),
    ARRAYMETHODCALL_SPACE("JavaScript spacing options", "Insert space before array brackets", "i = ai [10];", "i = ai[10];"),
    ARRAYARGUMENT_SPACE("JavaScript spacing options", "Insert space within array brackets", "i = ai[ 10 ];", "i = ai[10];"),
    BINARYOPERATOR_SPACE("JavaScript spacing options", "Insert space around binary operator ", "i = 10 + 20;", "i = 10+20;"),
    ASSIGNMENTOPERATOR_SPACE("JavaScript spacing options", "Insert space around assignment operator ", "i = 10;", "i=10;");
    
    private final String KD;
    private final String SI;
    private final String ei;
    private final String nw;

    private hh(String str, String str2, String str3, String str4) {
        this.ei = str;
        this.nw = str2;
        this.SI = str3;
        this.KD = str4;
    }

    public String DW() {
        return "js_" + name();
    }

    public String FH() {
        return this.ei;
    }

    public String j6() {
        return this.nw;
    }

    public String j6(boolean z) {
        return z ? this.SI : this.KD;
    }

    public static Set<hh> Hw() {
        Set hashSet = new HashSet();
        hashSet.add(ADJUST_NEWLINES);
        hashSet.add(ADJUST_SPACES);
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
