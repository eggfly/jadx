package org.codehaus.groovy.antlr.treewalker;

import com.aide.uidesigner.ProxyTextView;
import java.io.PrintStream;
import java.util.Stack;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class NodeAsHTMLPrinter extends VisitorAdapter {
    private final PrintStream DW;
    private final Stack FH;
    private final String[] j6;

    public NodeAsHTMLPrinter(PrintStream printStream, String[] strArr) {
        this.j6 = strArr;
        this.DW = printStream;
        this.FH = new Stack();
    }

    public void DW() {
        this.DW.println("<html><head></head><body><pre>");
    }

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.DW.print("<code title=" + j6(this.j6[groovySourceAST.Hw()]) + "><font color='#" + j6(groovySourceAST) + "'>");
        } else if (i == 4) {
            this.DW.print("</font></code>");
        }
    }

    private String j6(String str) {
        if (str.length() <= 0 || str.charAt(0) == '\'') {
            return "\"" + str + "\"";
        }
        return "'" + str + "'";
    }

    public void FH() {
        this.DW.println("</pre></body></html>");
    }

    private String j6(GroovySourceAST groovySourceAST) {
        String str = "000000";
        String str2 = "17178B";
        String str3 = "008000";
        switch (groovySourceAST.Hw()) {
            case 12:
            case 13:
            case 16:
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case 19:
            case 29:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 92:
            case 93:
            case 94:
            case 98:
            case 99:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 130:
            case 131:
            case 132:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 150:
            case 151:
            case 152:
            case 153:
            case 157:
            case 158:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                return str2;
            case 88:
            case 212:
            case 213:
                return str3;
            default:
                return str;
        }
    }

    public void DW(GroovySourceAST groovySourceAST) {
        this.FH.push(groovySourceAST);
    }

    public GroovySourceAST j6() {
        if (this.FH.empty()) {
            return null;
        }
        return (GroovySourceAST) this.FH.pop();
    }
}
