package org.codehaus.groovy.antlr.treewalker;

import groovyjarjarantlr.collections.AST;
import java.io.PrintStream;
import java.util.Stack;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class SourcePrinter extends VisitorAdapter {
    private final String[] DW;
    private int FH;
    private int Hw;
    private final Stack VH;
    private String Zo;
    private int gn;
    protected final PrintStream j6;
    private final boolean v5;

    public SourcePrinter(PrintStream printStream, String[] strArr) {
        this(printStream, strArr, true);
    }

    public SourcePrinter(PrintStream printStream, String[] strArr, boolean z) {
        this.DW = strArr;
        this.FH = 0;
        this.Hw = 0;
        this.j6 = printStream;
        this.v5 = z;
        this.VH = new Stack();
    }

    public void FH(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "abstract ", null, null);
    }

    public void Hw(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            j6(groovySourceAST, i, "@");
        }
        if (i == 2) {
            j6(groovySourceAST, i, "(");
        }
        if (i == 3) {
            j6(groovySourceAST, i, ", ");
        }
        if (i != 4) {
            return;
        }
        if (groovySourceAST.VH() > 1) {
            j6(groovySourceAST, i, ") ");
        } else {
            j6(groovySourceAST, i, " ");
        }
    }

    public void v5(GroovySourceAST groovySourceAST, int i) {
    }

    public void VH(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "@interface ", null, null);
    }

    public void gn(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "() ", "default ", null);
    }

    public void u7(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " = ", null, null);
    }

    public void tp(GroovySourceAST groovySourceAST, int i) {
        if (Hw().Hw() == 12 || Hw().Hw() == 23) {
            DW(groovySourceAST, i, null, null, "[]");
            return;
        }
        DW(groovySourceAST, i, "[", null, "]");
    }

    public void EQ(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " = ", null, null);
    }

    public void J0(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " & ", null, null);
    }

    public void J8(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " &= ", null, null);
    }

    public void XL(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "~", null, null);
    }

    public void aM(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " | ", null, null);
    }

    public void j3(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " |= ", null, null);
    }

    public void Mr(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " >>> ", null, null);
    }

    public void U2(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " >>>= ", null, null);
    }

    public void a8(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " ^ ", null, null);
    }

    public void lg(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " ^= ", null, null);
    }

    public void rN(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.FH++;
        }
        if (i == 4) {
            this.FH--;
        }
    }

    public void j6(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "class ", null, null);
        if (i == 1) {
            this.Zo = groovySourceAST.v5(87).FH();
        }
    }

    public void er(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "{", "-> ", "}");
    }

    public void yS(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "(", "; ", ")");
    }

    public void P8(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " <=> ", null, null);
    }

    public void ei(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "this(", " ", ")");
    }

    public void nw(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, this.Zo, null, null);
    }

    public void SI(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "--", null, null);
    }

    public void ro(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " / ", null, null);
    }

    public void cn(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " /= ", null, null);
    }

    public void cb(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, ".", null, null);
    }

    public void dx(GroovySourceAST groovySourceAST, int i) {
        if (groovySourceAST.v5(48) == null) {
            j6(groovySourceAST, i, "(", null, ")");
        }
    }

    public void sG(GroovySourceAST groovySourceAST, int i) {
        if (Hw().Hw() == 62) {
            DW(groovySourceAST, i, "(", ", ", ")");
            return;
        }
        DW(groovySourceAST, i, null, ", ", null);
    }

    public void Sf(GroovySourceAST groovySourceAST, int i) {
        GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.DW();
        if (groovySourceAST2 != null && groovySourceAST2.Hw() == 62) {
            DW(groovySourceAST, i, null, null, ", ");
        }
    }

    public void vJ(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "enum ", null, null);
    }

    public void Mz(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " == ", null, null);
    }

    public void x9(GroovySourceAST groovySourceAST, int i) {
    }

    public void Qq(GroovySourceAST groovySourceAST, int i) {
        if (i == 1 && groovySourceAST.VH() != 0) {
            j6(groovySourceAST, i, " extends ");
        }
    }

    public void sy(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "final ", null, null);
    }

    public void lp(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " ; ", null, null);
    }

    public void br(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "(", null, null);
    }

    public void XX(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "(", " in ", ") ");
    }

    public void kQ(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " ; ", null, ")");
    }

    public void yO(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " >= ", null, null);
    }

    public void XG(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " > ", null, null);
    }

    public void wc(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void et(GroovySourceAST groovySourceAST, int i) {
        if (i == 1 && groovySourceAST.VH() != 0) {
            j6(groovySourceAST, i, " implements ");
        }
        if (i == 4) {
            j6(groovySourceAST, i, " ");
        }
    }

    public void CU(GroovySourceAST groovySourceAST, int i) {
    }

    public void Xa(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "import ", null, null);
    }

    public void Eq(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "++", null, null);
    }

    public void hz(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "[", null, "]");
    }

    public void FN(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "interface ", null, null);
    }

    public void aq(GroovySourceAST groovySourceAST, int i) {
    }

    public void jO(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, ":", null, null);
    }

    public void oY(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, ":", null, null);
    }

    public void ko(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " && ", null, null);
    }

    public void WB(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " <= ", null, null);
    }

    public void jw(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "[", null, "]");
    }

    public void fY(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " as ", null, null);
    }

    public void qp(GroovySourceAST groovySourceAST, int i) {
        if (groovySourceAST.VH() > 1) {
            DW(groovySourceAST, i, "assert ", null, " : ");
            return;
        }
        DW(groovySourceAST, i, "assert ", null, null);
    }

    public void k2(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "boolean", null, null);
    }

    public void zh(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "break ", null, null);
    }

    public void AL(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "byte", null, null);
    }

    public void w9(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "case ", null, ":");
    }

    public void hK(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, " catch (", null, ") ");
    }

    public void cT(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "char", null, null);
    }

    public void Z1(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "continue ", null, null);
    }

    public void Q6(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "default", null, ":");
    }

    public void kf(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "double", null, null);
    }

    public void e3(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "false", null, null);
    }

    public void sE(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "finally ", null, null);
    }

    public void sg(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "float", null, null);
    }

    public void pO(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "for ", null, null);
    }

    public void fN(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "if (", " else ", ") ");
    }

    public void pN(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " in ", null, null);
    }

    public void oy(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " instanceof ", null, null);
    }

    public void aX(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "int", null, null);
    }

    public void QO(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "long", null, null);
    }

    public void sM(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "native ", null, null);
    }

    public void a5(GroovySourceAST groovySourceAST, int i) {
        if (groovySourceAST.v5(17) == null) {
            DW(groovySourceAST, i, "new ", "(", ")");
            return;
        }
        DW(groovySourceAST, i, "new ", null, null);
    }

    public void ys(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "null", null, null);
    }

    public void gG(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "private ", null, null);
    }

    public void Nh(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "protected ", null, null);
    }

    public void BR(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "public ", null, null);
    }

    public void AE(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "return ", null, null);
    }

    public void Za(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "short", null, null);
    }

    public void An(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "static ", null, null);
    }

    public void Pa(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "super", null, null);
    }

    public void ce(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            j6(groovySourceAST, i, "switch (");
            this.FH++;
        }
        if (i == 3) {
            j6(groovySourceAST, i, ") {");
        }
        if (i == 4) {
            this.FH--;
            j6(groovySourceAST, i, "}");
        }
    }

    public void Jm(GroovySourceAST groovySourceAST, int i) {
        if (groovySourceAST.VH() > 0) {
            DW(groovySourceAST, i, "synchronized (", null, ") ");
            return;
        }
        DW(groovySourceAST, i, "synchronized ", null, null);
    }

    public void Bx(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "this", null, null);
    }

    public void oa(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "threadsafe ", null, null);
    }

    public void qP(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "throw ", null, null);
    }

    public void MP(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "throws ", null, null);
    }

    public void Of(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "transient ", null, null);
    }

    public void PT(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "true", null, null);
    }

    public void b1(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "try ", null, null);
    }

    public void AR(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "void", null, null);
    }

    public void TI(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "volatile ", null, null);
    }

    public void ct(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "while (", null, ") ");
    }

    public void Fd(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "!", null, null);
    }

    public void Lz(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " || ", null, null);
    }

    public void E4(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " < ", null, null);
    }

    public void xg(GroovySourceAST groovySourceAST, int i) {
        if (groovySourceAST.VH() == 0) {
            DW(groovySourceAST, i, "[:]", null, null);
            return;
        }
        j6(groovySourceAST, i, "[", null, "]");
    }

    public void hp(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, ".&", null, null);
    }

    public void PH(GroovySourceAST groovySourceAST, int i) {
        if ("<command>".equals(groovySourceAST.FH())) {
            j6(groovySourceAST, i, " ", " ", null);
            return;
        }
        j6(groovySourceAST, i, "(", " ", ")");
    }

    public void GK(GroovySourceAST groovySourceAST, int i) {
    }

    public void dW(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " - ", null, null);
    }

    public void Yi(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " -= ", null, null);
    }

    public void Hl(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " % ", null, null);
    }

    public void pl(GroovySourceAST groovySourceAST, int i) {
    }

    public void oh(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " %= ", null, null);
    }

    public void Ej(GroovySourceAST groovySourceAST, int i) {
        if (i == 4) {
            AST j6 = groovySourceAST.j6();
            if ("MULTICATCH_TYPES".equals(j6.FH())) {
                DW(groovySourceAST, i, null, null, " " + j6.DW().FH());
                return;
            }
            DW(groovySourceAST, i, null, null, " " + j6.j6().FH());
        }
    }

    public void T6(GroovySourceAST groovySourceAST, int i) {
    }

    public void Od(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " != ", null, null);
    }

    public void wE(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void d8(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void N0(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void zf(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void eN(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void fP(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, groovySourceAST.FH(), null, null);
    }

    public void b(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.FH++;
            j6(groovySourceAST, i, "{");
            return;
        }
        this.FH--;
        j6(groovySourceAST, i, "}");
    }

    public void u9(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "?.", null, null);
    }

    public void Ak(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "package ", null, null);
    }

    public void ti(GroovySourceAST groovySourceAST, int i) {
    }

    public void nl(GroovySourceAST groovySourceAST, int i) {
        if (Hw().Hw() == 50) {
            j6(groovySourceAST, i, null, ",", " ");
            return;
        }
        j6(groovySourceAST, i, "(", ", ", ") ");
    }

    public void k1(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " + ", null, null);
    }

    public void iK(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " += ", null, null);
    }

    public void fh(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, null, null, "--");
    }

    public void sv(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, null, null, "++");
    }

    public void HT(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "?", ":", null);
    }

    public void oT(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "..<", null, null);
    }

    public void hx(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "..", null, null);
    }

    public void DY(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " =~ ", null, null);
    }

    public void tj(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " ==~ ", null, null);
    }

    public void x6(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "@", null, null);
    }

    public void Vq(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " << ", null, null);
    }

    public void ya(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " <<= ", null, null);
    }

    public void cX(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.FH++;
            j6(groovySourceAST, i, "{");
            return;
        }
        this.FH--;
        j6(groovySourceAST, i, "}");
    }

    public void uD(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "*", null, null);
    }

    public void HE(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "*.", null, null);
    }

    public void h2(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "*:", null, null);
    }

    public void gy(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " >> ", null, null);
    }

    public void F3(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " >>= ", null, null);
    }

    public void S4(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "*", null, null);
    }

    public void tv(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " *= ", null, null);
    }

    public void gM(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "**", null, null);
    }

    public void tR(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " **= ", null, null);
    }

    public void ME(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "static ", null, null);
    }

    public void ji(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "import static ", null, null);
    }

    public void C(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "strictfp ", null, null);
    }

    public void BN(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            this.gn = 0;
            j6(groovySourceAST, i, "\"");
        }
        if (i == 3) {
            if (this.gn % 2 == 0) {
                j6(groovySourceAST, i, "$");
            }
            this.gn++;
        }
        if (i == 4) {
            j6(groovySourceAST, i, "\"");
        }
    }

    public void K3(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            String j6 = j6(groovySourceAST.FH());
            if (!(Hw().Hw() == 54 || Hw().Hw() == 48)) {
                j6 = "\"" + j6 + "\"";
            }
            j6(groovySourceAST, i, j6);
        }
    }

    private String j6(String str) {
        return str.replaceAll("\n", "\\\\<<REMOVE>>n").replaceAll("<<REMOVE>>", "");
    }

    public void Qs(GroovySourceAST groovySourceAST, int i) {
        j6(groovySourceAST, i, "super(", " ", ")");
    }

    public void g0(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "trait ", null, null);
        if (i == 1) {
            this.Zo = groovySourceAST.v5(87).FH();
        }
    }

    public void Lx(GroovySourceAST groovySourceAST, int i) {
        GroovySourceAST Hw = Hw();
        GroovySourceAST v5 = Hw.v5(5);
        if (v5 == null || v5.VH() == 0) {
            if (i == 1 && groovySourceAST.VH() == 0 && Hw.Hw() != 21) {
                j6(groovySourceAST, i, "def");
            }
            if (i != 4) {
                return;
            }
            if (Hw.Hw() == 9 || Hw.Hw() == 8 || Hw.Hw() == 68 || (Hw.Hw() == 21 && groovySourceAST.VH() != 0)) {
                j6(groovySourceAST, i, " ");
            }
        } else if (i == 4 && groovySourceAST.VH() != 0) {
            j6(groovySourceAST, i, " ");
        }
    }

    public void hG(GroovySourceAST groovySourceAST, int i) {
    }

    public void s0(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "<", ", ", ">");
    }

    public void wC(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "(", null, ")");
    }

    public void zg(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " super ", " & ", null);
    }

    public void J1(GroovySourceAST groovySourceAST, int i) {
    }

    public void N2(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "<", ", ", ">");
    }

    public void NZ(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, " extends ", " & ", null);
    }

    public void IM(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "-", null, null);
    }

    public void jg(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "+", null, null);
    }

    public void jD(GroovySourceAST groovySourceAST, int i) {
    }

    public void UF(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, null, "... ", null);
    }

    public void CN(GroovySourceAST groovySourceAST, int i) {
        DW(groovySourceAST, i, "?", null, null);
    }

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i == 1) {
            j6(groovySourceAST, i, "<" + this.DW[groovySourceAST.Hw()] + ">");
        } else {
            j6(groovySourceAST, i, "</" + this.DW[groovySourceAST.Hw()] + ">");
        }
    }

    protected void j6(GroovySourceAST groovySourceAST, int i, String str, String str2, String str3) {
        if (i == 1 && str != null) {
            j6(groovySourceAST, i, str);
            this.FH++;
        }
        if (i == 3 && str2 != null) {
            j6(groovySourceAST, i, str2);
        }
        if (i == 4 && str3 != null) {
            this.FH--;
            j6(groovySourceAST, i, str3);
        }
    }

    protected void DW(GroovySourceAST groovySourceAST, int i, String str, String str2, String str3) {
        if (i == 1 && str != null) {
            j6(groovySourceAST, i, str);
        }
        if (i == 3 && str2 != null) {
            j6(groovySourceAST, i, str2);
        }
        if (i == 4 && str3 != null) {
            j6(groovySourceAST, i, str3);
        }
    }

    protected void j6(GroovySourceAST groovySourceAST, int i, String str) {
        if (i == 1) {
            Dm(groovySourceAST, i);
        }
        if (i == 4) {
            Dm(groovySourceAST, i);
        }
        this.j6.print(str);
    }

    protected void Dm(GroovySourceAST groovySourceAST, int i) {
        int v5 = groovySourceAST.v5();
        if (this.Hw == 0) {
            this.Hw = v5;
        }
        if (this.Hw != v5) {
            if (this.v5 && !(i == 1 && groovySourceAST.Hw() == 7)) {
                int i2;
                for (i2 = this.Hw; i2 < v5; i2++) {
                    this.j6.println();
                }
                if (this.Hw > v5) {
                    this.j6.println();
                    this.Hw = v5;
                }
                if (i == 1 || (i == 4 && this.Hw > v5)) {
                    for (i2 = 0; i2 < this.FH; i2++) {
                        this.j6.print("    ");
                    }
                }
            }
            this.Hw = Math.max(v5, this.Hw);
        }
    }

    public void DW(GroovySourceAST groovySourceAST) {
        this.VH.push(groovySourceAST);
    }

    public GroovySourceAST j6() {
        if (this.VH.empty()) {
            return null;
        }
        return (GroovySourceAST) this.VH.pop();
    }

    private GroovySourceAST Hw() {
        Object pop = this.VH.pop();
        Object peek = this.VH.peek();
        this.VH.push(pop);
        return (GroovySourceAST) peek;
    }
}
