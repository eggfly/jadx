package org.codehaus.groovy.antlr.treewalker;

import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Collections;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class SourceCodeTraversal extends TraversalHelper {
    public SourceCodeTraversal(Visitor visitor) {
        super(visitor);
    }

    public void DW(GroovySourceAST groovySourceAST) {
        super.DW(groovySourceAST);
        this.j6 = new ArrayList();
        P8(groovySourceAST);
        Collections.sort(this.j6);
    }

    private void P8(GroovySourceAST groovySourceAST) {
        if (groovySourceAST != null) {
            if (this.j6 != null) {
                this.j6.add(groovySourceAST);
            }
            GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
            if (groovySourceAST2 != null) {
                P8(groovySourceAST2);
            }
            groovySourceAST2 = (GroovySourceAST) groovySourceAST.DW();
            if (groovySourceAST2 != null) {
                P8(groovySourceAST2);
            }
        }
    }

    protected void j6(GroovySourceAST groovySourceAST) {
        if (groovySourceAST != null && this.j6 != null && this.j6.size() > 0 && this.j6.contains(groovySourceAST)) {
            Hw(groovySourceAST);
            switch (groovySourceAST.Hw()) {
                case 5:
                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                case 121:
                case 147:
                case 151:
                case 153:
                    U2(groovySourceAST);
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 21:
                case 28:
                case 29:
                case 60:
                case 62:
                    XL(groovySourceAST);
                    break;
                case 13:
                case 14:
                case 15:
                case 16:
                case 22:
                case 46:
                case 54:
                case 61:
                case 64:
                case 89:
                case 90:
                case 100:
                case 102:
                case 103:
                case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                case 114:
                case 125:
                case 134:
                case 142:
                case 148:
                case 149:
                case 154:
                case 155:
                case 156:
                case 175:
                case 176:
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 191:
                case 192:
                case 194:
                    aM(groovySourceAST);
                    break;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                case 48:
                case 70:
                case 72:
                case 73:
                case 75:
                case 77:
                    J8(groovySourceAST);
                    break;
                case 23:
                case 139:
                    Zo(groovySourceAST);
                    break;
                case 24:
                    gn(groovySourceAST);
                    break;
                case 27:
                case 45:
                    if (groovySourceAST.VH() != 2 || groovySourceAST.Hw(1) == null || groovySourceAST.Hw(1).Hw() != 50) {
                        GroovySourceAST Hw = groovySourceAST.Hw(groovySourceAST.VH() - 1);
                        if (Hw != null && Hw.Hw() == 50) {
                            j3(groovySourceAST);
                            break;
                        } else {
                            Mr(groovySourceAST);
                            break;
                        }
                    }
                    VH(groovySourceAST);
                    break;
                    break;
                case 32:
                case 158:
                    u7(groovySourceAST);
                    break;
                case 47:
                    tp(groovySourceAST);
                    break;
                case 50:
                    if (groovySourceAST.Hw(0) != null && groovySourceAST.Hw(0).Hw() == 51) {
                        XL(groovySourceAST);
                        break;
                    } else {
                        a8(groovySourceAST);
                        break;
                    }
                case 59:
                case 140:
                case 141:
                case 159:
                    a8(groovySourceAST);
                    break;
                case 66:
                    J0(groovySourceAST);
                    break;
                case 67:
                case 124:
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
                case 178:
                case 179:
                case 180:
                case 181:
                case 184:
                    if (groovySourceAST.Hw(1) == null) {
                        U2(groovySourceAST);
                        break;
                    } else {
                        aM(groovySourceAST);
                        break;
                    }
                case 68:
                    we(groovySourceAST);
                    break;
                case 74:
                    QX(groovySourceAST);
                    break;
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    EQ(groovySourceAST);
                    break;
                case 137:
                    v5(groovySourceAST);
                    break;
                default:
                    Ws(groovySourceAST);
                    break;
            }
            j6();
        }
    }
}
