package org.codehaus.groovy.antlr.treewalker;

import com.aide.uidesigner.ProxyTextView;
import java.io.PrintStream;
import org.codehaus.groovy.antlr.GroovySourceAST;
import org.codehaus.groovy.antlr.LineColumn;
import org.codehaus.groovy.antlr.SourceBuffer;

public class MindMapPrinter extends VisitorAdapter {
    private final PrintStream DW;
    private int FH;
    private SourceBuffer Hw;
    private final String[] j6;

    public MindMapPrinter(PrintStream printStream, String[] strArr) {
        this.j6 = strArr;
        this.DW = printStream;
    }

    public MindMapPrinter(PrintStream printStream, String[] strArr, SourceBuffer sourceBuffer) {
        this.j6 = strArr;
        this.DW = printStream;
        this.Hw = sourceBuffer;
    }

    public void DW() {
        this.FH = 0;
        this.DW.println("<map version='0.7.1'><node TEXT='AST'>");
    }

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.FH++;
            String Hw = Hw(groovySourceAST);
            String FH = FH(groovySourceAST);
            this.DW.print("<node TEXT='" + Hw + "' POSITION='right'" + FH + j6(groovySourceAST) + ">");
        } else if (i == 4) {
            this.DW.println("</node>");
            this.FH--;
        }
    }

    public void FH() {
        this.DW.println("</node></map>");
    }

    private String j6(GroovySourceAST groovySourceAST) {
        if (this.FH > 2 && groovySourceAST.VH() > 0) {
            switch (groovySourceAST.Hw()) {
                case 8:
                case 9:
                case 28:
                    return " FOLDED='true'";
            }
        }
        if (groovySourceAST.Hw() == 29) {
            return " FOLDED='true'";
        }
        return "";
    }

    private String FH(GroovySourceAST groovySourceAST) {
        String str = "";
        String str2 = " COLOR=\"#000000\"";
        String str3 = " COLOR=\"#006699\"";
        String str4 = " COLOR=\"#17178B\"";
        str = " COLOR=\"#008000\"";
        switch (groovySourceAST.Hw()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 14:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 30:
            case 31:
            case 32:
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
            case 34:
            case 35:
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 80:
            case 85:
            case 86:
            case 89:
            case 90:
            case 91:
            case 96:
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
            case 100:
            case 101:
            case 102:
            case 103:
            case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 133:
            case 134:
            case 135:
            case 136:
            case 148:
            case 149:
            case 154:
            case 155:
            case 156:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 175:
            case 176:
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
            case 178:
            case 179:
            case 180:
            case 181:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
            case 210:
            case 211:
            case 214:
            case 218:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
            case 228:
            case 229:
            case 230:
                str = str2;
                break;
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
                str = str4;
                break;
            case 87:
                str = str3;
                break;
            case 88:
            case 212:
            case 213:
                break;
            default:
                str = str2;
                break;
        }
        if (str2.equals(str) && groovySourceAST.VH() == 0) {
            return str3;
        }
        return str;
    }

    private String Hw(GroovySourceAST groovySourceAST) {
        String str = this.j6[groovySourceAST.Hw()] + " <" + groovySourceAST.Hw() + ">";
        if (!j6(this.j6[groovySourceAST.Hw()]).equals(j6(groovySourceAST.FH()))) {
            str = str + " : " + groovySourceAST.FH();
        }
        switch (groovySourceAST.Hw()) {
            case 8:
            case 9:
                GroovySourceAST v5 = groovySourceAST.v5(87);
                if (v5 != null) {
                    str = str + " : " + v5.FH() + "";
                    break;
                }
                break;
        }
        str = j6(str);
        if (this.Hw == null) {
            return str;
        }
        return (((str + "&#xa;") + groovySourceAST.v5() + "," + groovySourceAST.Zo() + " - " + groovySourceAST.gn() + "," + groovySourceAST.u7()) + "&#xa;") + j6(this.Hw.j6(new LineColumn(groovySourceAST.v5(), groovySourceAST.Zo()), new LineColumn(groovySourceAST.gn(), groovySourceAST.u7())));
    }

    private String j6(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() > 200) {
            str = str.substring(0, 100) + " ..... " + str.substring(str.length() - 100);
        }
        return str.replace('\"', ' ').replace('\'', ' ').replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").trim();
    }
}
