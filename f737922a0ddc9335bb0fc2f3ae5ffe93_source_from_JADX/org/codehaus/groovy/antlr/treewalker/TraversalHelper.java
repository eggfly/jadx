package org.codehaus.groovy.antlr.treewalker;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.collections.AST;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.antlr.AntlrASTProcessor;
import org.codehaus.groovy.antlr.GroovySourceAST;

public abstract class TraversalHelper implements AntlrASTProcessor {
    private final Visitor DW;
    protected List<GroovySourceAST> j6;

    protected abstract void j6(GroovySourceAST groovySourceAST);

    public TraversalHelper(Visitor visitor) {
        this.j6 = new ArrayList();
        this.DW = visitor;
    }

    protected void DW(GroovySourceAST groovySourceAST) {
        this.DW.DW();
    }

    protected void FH(GroovySourceAST groovySourceAST) {
        this.DW.FH();
    }

    protected void Hw(GroovySourceAST groovySourceAST) {
        this.DW.DW(groovySourceAST);
    }

    protected GroovySourceAST j6() {
        return this.DW.j6();
    }

    protected void j6(GroovySourceAST groovySourceAST, int i) {
        if (groovySourceAST != null) {
            switch (groovySourceAST.Hw()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.DW.g3(groovySourceAST, i);
                    return;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.DW.om(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    this.DW.QX(groovySourceAST, i);
                    return;
                case 5:
                    this.DW.pl(groovySourceAST, i);
                    return;
                case 6:
                    this.DW.b(groovySourceAST, i);
                    return;
                case 7:
                    this.DW.cX(groovySourceAST, i);
                    return;
                case 8:
                    this.DW.GK(groovySourceAST, i);
                    return;
                case 9:
                    this.DW.jD(groovySourceAST, i);
                    return;
                case 10:
                    this.DW.aq(groovySourceAST, i);
                    return;
                case 11:
                    this.DW.ME(groovySourceAST, i);
                    return;
                case 12:
                    this.DW.Lx(groovySourceAST, i);
                    return;
                case 13:
                    this.DW.j6(groovySourceAST, i);
                    return;
                case 14:
                    this.DW.FN(groovySourceAST, i);
                    return;
                case 15:
                    this.DW.g0(groovySourceAST, i);
                    return;
                case 16:
                    this.DW.Ak(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    this.DW.tp(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    this.DW.Qq(groovySourceAST, i);
                    return;
                case 19:
                    this.DW.et(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    this.DW.nl(groovySourceAST, i);
                    return;
                case 21:
                    this.DW.ti(groovySourceAST, i);
                    return;
                case 22:
                    this.DW.oY(groovySourceAST, i);
                    return;
                case 23:
                    this.DW.wC(groovySourceAST, i);
                    return;
                case 24:
                    this.DW.hz(groovySourceAST, i);
                    return;
                case 25:
                    this.DW.sv(groovySourceAST, i);
                    return;
                case 26:
                    this.DW.fh(groovySourceAST, i);
                    return;
                case 27:
                    this.DW.PH(groovySourceAST, i);
                    return;
                case 28:
                    this.DW.x9(groovySourceAST, i);
                    return;
                case 29:
                    this.DW.Xa(groovySourceAST, i);
                    return;
                case 30:
                    this.DW.IM(groovySourceAST, i);
                    return;
                case 31:
                    this.DW.jg(groovySourceAST, i);
                    return;
                case 32:
                    this.DW.rN(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    this.DW.sG(groovySourceAST, i);
                    return;
                case 34:
                    this.DW.br(groovySourceAST, i);
                    return;
                case 35:
                    this.DW.lp(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    this.DW.kQ(groovySourceAST, i);
                    return;
                case 37:
                    this.DW.ef(groovySourceAST, i);
                    return;
                case 38:
                    this.DW.sy(groovySourceAST, i);
                    return;
                case 39:
                    this.DW.FH(groovySourceAST, i);
                    return;
                case 40:
                    this.DW.Sc(groovySourceAST, i);
                    return;
                case 41:
                    this.DW.eQ(groovySourceAST, i);
                    return;
                case 42:
                    this.DW.BJ(groovySourceAST, i);
                    return;
                case 43:
                    this.DW.C(groovySourceAST, i);
                    return;
                case 44:
                    this.DW.Qs(groovySourceAST, i);
                    return;
                case 45:
                    this.DW.ei(groovySourceAST, i);
                    return;
                case 46:
                    this.DW.nw(groovySourceAST, i);
                    return;
                case 47:
                    this.DW.UF(groovySourceAST, i);
                    return;
                case 48:
                    this.DW.BN(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                    this.DW.DP(groovySourceAST, i);
                    return;
                case 50:
                    this.DW.er(groovySourceAST, i);
                    return;
                case 51:
                    this.DW.CU(groovySourceAST, i);
                    return;
                case 52:
                    this.DW.x6(groovySourceAST, i);
                    return;
                case 53:
                    this.DW.dx(groovySourceAST, i);
                    return;
                case 54:
                    this.DW.jO(groovySourceAST, i);
                    return;
                case 55:
                    this.DW.uD(groovySourceAST, i);
                    return;
                case 56:
                    this.DW.h2(groovySourceAST, i);
                    return;
                case 57:
                    this.DW.jw(groovySourceAST, i);
                    return;
                case 58:
                    this.DW.xg(groovySourceAST, i);
                    return;
                case 59:
                    this.DW.XX(groovySourceAST, i);
                    return;
                case 60:
                    this.DW.ji(groovySourceAST, i);
                    return;
                case 61:
                    this.DW.vJ(groovySourceAST, i);
                    return;
                case 62:
                    this.DW.Sf(groovySourceAST, i);
                    return;
                case 63:
                    this.DW.OW(groovySourceAST, i);
                    return;
                case 64:
                    this.DW.VH(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                    this.DW.v5(groovySourceAST, i);
                    return;
                case 66:
                    this.DW.Hw(groovySourceAST, i);
                    return;
                case 67:
                    this.DW.u7(groovySourceAST, i);
                    return;
                case 68:
                    this.DW.gn(groovySourceAST, i);
                    return;
                case 69:
                    this.DW.Zo(groovySourceAST, i);
                    return;
                case 70:
                    this.DW.s0(groovySourceAST, i);
                    return;
                case 71:
                    this.DW.hG(groovySourceAST, i);
                    return;
                case 72:
                    this.DW.N2(groovySourceAST, i);
                    return;
                case 73:
                    this.DW.J1(groovySourceAST, i);
                    return;
                case 74:
                    this.DW.CN(groovySourceAST, i);
                    return;
                case 75:
                    this.DW.NZ(groovySourceAST, i);
                    return;
                case 76:
                    this.DW.zg(groovySourceAST, i);
                    return;
                case 77:
                    this.DW.yS(groovySourceAST, i);
                    return;
                case 78:
                    this.DW.Ej(groovySourceAST, i);
                    return;
                case 79:
                    this.DW.T6(groovySourceAST, i);
                    return;
                case 80:
                    this.DW.RW(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                    this.DW.IS(groovySourceAST, i);
                    return;
                case 82:
                    this.DW.Cz(groovySourceAST, i);
                    return;
                case 83:
                    this.DW.An(groovySourceAST, i);
                    return;
                case 84:
                    this.DW.n5(groovySourceAST, i);
                    return;
                case 85:
                    this.DW.Ev(groovySourceAST, i);
                    return;
                case 86:
                    this.DW.qU(groovySourceAST, i);
                    return;
                case 87:
                    this.DW.wc(groovySourceAST, i);
                    return;
                case 88:
                    this.DW.K3(groovySourceAST, i);
                    return;
                case 89:
                    this.DW.E4(groovySourceAST, i);
                    return;
                case 90:
                    this.DW.cb(groovySourceAST, i);
                    return;
                case 91:
                    this.DW.sT(groovySourceAST, i);
                    return;
                case 92:
                    this.DW.q7(groovySourceAST, i);
                    return;
                case 93:
                    this.DW.e9(groovySourceAST, i);
                    return;
                case 94:
                    this.DW.iW(groovySourceAST, i);
                    return;
                case 96:
                    this.DW.we(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    this.DW.HT(groovySourceAST, i);
                    return;
                case 98:
                    this.DW.eU(groovySourceAST, i);
                    return;
                case 99:
                    this.DW.Pa(groovySourceAST, i);
                    return;
                case 100:
                    this.DW.XG(groovySourceAST, i);
                    return;
                case 101:
                    this.DW.vy(groovySourceAST, i);
                    return;
                case 102:
                    this.DW.gy(groovySourceAST, i);
                    return;
                case 103:
                    this.DW.Mr(groovySourceAST, i);
                    return;
                case 104:
                    this.DW.AR(groovySourceAST, i);
                    return;
                case 105:
                    this.DW.k2(groovySourceAST, i);
                    return;
                case 106:
                    this.DW.AL(groovySourceAST, i);
                    return;
                case 107:
                    this.DW.cT(groovySourceAST, i);
                    return;
                case 108:
                    this.DW.Za(groovySourceAST, i);
                    return;
                case 109:
                    this.DW.aX(groovySourceAST, i);
                    return;
                case 110:
                    this.DW.sg(groovySourceAST, i);
                    return;
                case 111:
                    this.DW.QO(groovySourceAST, i);
                    return;
                case 112:
                    this.DW.kf(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                    this.DW.S4(groovySourceAST, i);
                    return;
                case 114:
                    this.DW.fY(groovySourceAST, i);
                    return;
                case 115:
                    this.DW.gG(groovySourceAST, i);
                    return;
                case 116:
                    this.DW.BR(groovySourceAST, i);
                    return;
                case 117:
                    this.DW.Nh(groovySourceAST, i);
                    return;
                case 118:
                    this.DW.Of(groovySourceAST, i);
                    return;
                case 119:
                    this.DW.sM(groovySourceAST, i);
                    return;
                case 120:
                    this.DW.oa(groovySourceAST, i);
                    return;
                case 121:
                    this.DW.Jm(groovySourceAST, i);
                    return;
                case 122:
                    this.DW.TI(groovySourceAST, i);
                    return;
                case 123:
                    this.DW.pn(groovySourceAST, i);
                    return;
                case 124:
                    this.DW.EQ(groovySourceAST, i);
                    return;
                case 125:
                    this.DW.J0(groovySourceAST, i);
                    return;
                case 126:
                    this.DW.ye(groovySourceAST, i);
                    return;
                case 127:
                    this.DW.uC(groovySourceAST, i);
                    return;
                case 128:
                    this.DW.k4(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                    this.DW.Q6(groovySourceAST, i);
                    return;
                case 130:
                    this.DW.MP(groovySourceAST, i);
                    return;
                case 131:
                    this.DW.Gj(groovySourceAST, i);
                    return;
                case 132:
                    this.DW.Bx(groovySourceAST, i);
                    return;
                case 133:
                    this.DW.fd(groovySourceAST, i);
                    return;
                case 134:
                    this.DW.aM(groovySourceAST, i);
                    return;
                case 135:
                    this.DW.gW(groovySourceAST, i);
                    return;
                case 136:
                    this.DW.BT(groovySourceAST, i);
                    return;
                case 137:
                    this.DW.fN(groovySourceAST, i);
                    return;
                case 138:
                    this.DW.Jl(groovySourceAST, i);
                    return;
                case 139:
                    this.DW.ct(groovySourceAST, i);
                    return;
                case 140:
                    this.DW.ce(groovySourceAST, i);
                    return;
                case 141:
                    this.DW.pO(groovySourceAST, i);
                    return;
                case 142:
                    this.DW.pN(groovySourceAST, i);
                    return;
                case 143:
                    this.DW.AE(groovySourceAST, i);
                    return;
                case 144:
                    this.DW.zh(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                    this.DW.Z1(groovySourceAST, i);
                    return;
                case 146:
                    this.DW.qP(groovySourceAST, i);
                    return;
                case 147:
                    this.DW.qp(groovySourceAST, i);
                    return;
                case 148:
                    this.DW.k1(groovySourceAST, i);
                    return;
                case 149:
                    this.DW.dW(groovySourceAST, i);
                    return;
                case 150:
                    this.DW.w9(groovySourceAST, i);
                    return;
                case 151:
                    this.DW.b1(groovySourceAST, i);
                    return;
                case 152:
                    this.DW.sE(groovySourceAST, i);
                    return;
                case 153:
                    this.DW.hK(groovySourceAST, i);
                    return;
                case 154:
                    this.DW.HE(groovySourceAST, i);
                    return;
                case 155:
                    this.DW.u9(groovySourceAST, i);
                    return;
                case 156:
                    this.DW.hp(groovySourceAST, i);
                    return;
                case 157:
                    this.DW.e3(groovySourceAST, i);
                    return;
                case 158:
                    this.DW.oy(groovySourceAST, i);
                    return;
                case 159:
                    this.DW.a5(groovySourceAST, i);
                    return;
                case 160:
                    this.DW.ys(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    this.DW.PT(groovySourceAST, i);
                    return;
                case 162:
                    this.DW.iK(groovySourceAST, i);
                    return;
                case 163:
                    this.DW.Yi(groovySourceAST, i);
                    return;
                case 164:
                    this.DW.tv(groovySourceAST, i);
                    return;
                case 165:
                    this.DW.cn(groovySourceAST, i);
                    return;
                case 166:
                    this.DW.oh(groovySourceAST, i);
                    return;
                case 167:
                    this.DW.F3(groovySourceAST, i);
                    return;
                case 168:
                    this.DW.U2(groovySourceAST, i);
                    return;
                case 169:
                    this.DW.ya(groovySourceAST, i);
                    return;
                case 170:
                    this.DW.J8(groovySourceAST, i);
                    return;
                case 171:
                    this.DW.lg(groovySourceAST, i);
                    return;
                case 172:
                    this.DW.j3(groovySourceAST, i);
                    return;
                case 173:
                    this.DW.tR(groovySourceAST, i);
                    return;
                case 175:
                    this.DW.Lz(groovySourceAST, i);
                    return;
                case 176:
                    this.DW.ko(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                    this.DW.a8(groovySourceAST, i);
                    return;
                case 178:
                    this.DW.DY(groovySourceAST, i);
                    return;
                case 179:
                    this.DW.tj(groovySourceAST, i);
                    return;
                case 180:
                    this.DW.Od(groovySourceAST, i);
                    return;
                case 181:
                    this.DW.Mz(groovySourceAST, i);
                    return;
                case 184:
                    this.DW.P8(groovySourceAST, i);
                    return;
                case 185:
                    this.DW.WB(groovySourceAST, i);
                    return;
                case 186:
                    this.DW.yO(groovySourceAST, i);
                    return;
                case 187:
                    this.DW.Vq(groovySourceAST, i);
                    return;
                case 188:
                    this.DW.hx(groovySourceAST, i);
                    return;
                case 189:
                    this.DW.oT(groovySourceAST, i);
                    return;
                case 190:
                    this.DW.Eq(groovySourceAST, i);
                    return;
                case 191:
                    this.DW.ro(groovySourceAST, i);
                    return;
                case 192:
                    this.DW.Hl(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    this.DW.SI(groovySourceAST, i);
                    return;
                case 194:
                    this.DW.gM(groovySourceAST, i);
                    return;
                case 195:
                    this.DW.XL(groovySourceAST, i);
                    return;
                case 196:
                    this.DW.Fd(groovySourceAST, i);
                    return;
                case 197:
                    this.DW.ee(groovySourceAST, i);
                    return;
                case 198:
                    this.DW.jn(groovySourceAST, i);
                    return;
                case 199:
                    this.DW.zf(groovySourceAST, i);
                    return;
                case 200:
                    this.DW.eN(groovySourceAST, i);
                    return;
                case 201:
                    this.DW.fP(groovySourceAST, i);
                    return;
                case 202:
                    this.DW.N0(groovySourceAST, i);
                    return;
                case 203:
                    this.DW.d8(groovySourceAST, i);
                    return;
                case 204:
                    this.DW.wE(groovySourceAST, i);
                    return;
                case 205:
                    this.DW.cc(groovySourceAST, i);
                    return;
                case 206:
                    this.DW.sh(groovySourceAST, i);
                    return;
                case 207:
                    this.DW.oC(groovySourceAST, i);
                    return;
                case 208:
                    this.DW.ba(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                    this.DW.ir(groovySourceAST, i);
                    return;
                case 210:
                    this.DW.GT(groovySourceAST, i);
                    return;
                case 211:
                    this.DW.dH(groovySourceAST, i);
                    return;
                case 212:
                    this.DW.HO(groovySourceAST, i);
                    return;
                case 213:
                    this.DW.HO(groovySourceAST, i);
                    return;
                case 214:
                    this.DW.ep(groovySourceAST, i);
                    return;
                case 215:
                    this.DW.ep(groovySourceAST, i);
                    return;
                case 218:
                    this.DW.qI(groovySourceAST, i);
                    return;
                case 219:
                    this.DW.qI(groovySourceAST, i);
                    return;
                case 220:
                    this.DW.I(groovySourceAST, i);
                    return;
                case 221:
                    this.DW.OM(groovySourceAST, i);
                    return;
                case 222:
                    this.DW.jJ(groovySourceAST, i);
                    return;
                case 223:
                    this.DW.rB(groovySourceAST, i);
                    return;
                case 224:
                    this.DW.mb(groovySourceAST, i);
                    return;
                case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
                    this.DW.KD(groovySourceAST, i);
                    return;
                case 228:
                    this.DW.ca(groovySourceAST, i);
                    return;
                case 229:
                    this.DW.aj(groovySourceAST, i);
                    return;
                case 230:
                    this.DW.Ws(groovySourceAST, i);
                    return;
                default:
                    this.DW.DW(groovySourceAST, i);
                    return;
            }
        }
        this.DW.DW(null, i);
    }

    protected void v5(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        GroovySourceAST Hw = groovySourceAST.Hw(0);
        er(Hw);
        j6(Hw.Hw(0));
        vy(groovySourceAST);
        GroovySourceAST groovySourceAST2 = (GroovySourceAST) Hw.DW();
        int i = 1;
        while (groovySourceAST2 != null) {
            if (i == 0) {
                BT(groovySourceAST);
            }
            j6(groovySourceAST2);
            groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW();
            i = 0;
        }
    }

    protected void Zo(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        GroovySourceAST Hw = groovySourceAST.Hw(0);
        er(Hw);
        j6(Hw.Hw(0));
        vy(groovySourceAST);
        lg(Hw);
    }

    protected void VH(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(0));
        BT(groovySourceAST);
        j6(groovySourceAST.Hw(1));
    }

    protected void gn(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(1));
        yS(groovySourceAST);
        j6(groovySourceAST.Hw(2));
        vy(groovySourceAST);
    }

    protected void u7(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(0));
        yS(groovySourceAST);
        GroovySourceAST Hw = groovySourceAST.Hw(1);
        if (Hw != null) {
            rN(Hw);
        }
        vy(groovySourceAST);
    }

    protected void tp(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        j6(groovySourceAST.Hw(0));
        j6(groovySourceAST.Hw(1));
        BT(groovySourceAST);
        j6(groovySourceAST.Hw(2));
        vy(groovySourceAST);
    }

    protected void EQ(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(0));
        yS(groovySourceAST);
        j6(groovySourceAST.Hw(1));
        BT(groovySourceAST);
        j6(groovySourceAST.Hw(2));
        vy(groovySourceAST);
    }

    protected void we(GroovySourceAST groovySourceAST) {
        GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
        if (groovySourceAST2 != null) {
            j6(groovySourceAST2);
            groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW();
            if (groovySourceAST2 != null) {
                j6(groovySourceAST2);
                groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW();
                if (groovySourceAST2 != null) {
                    j6(groovySourceAST2);
                    yS(groovySourceAST);
                    groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW();
                    if (groovySourceAST2 != null) {
                        BT(groovySourceAST);
                        j6(groovySourceAST2);
                    }
                }
            }
        }
    }

    protected void J0(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
        if (groovySourceAST2 != null) {
            j6(groovySourceAST2);
            groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW();
            if (groovySourceAST2 != null) {
                gW(groovySourceAST);
                j6(groovySourceAST2);
                for (groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW(); groovySourceAST2 != null; groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW()) {
                    BT(groovySourceAST);
                    j6(groovySourceAST2);
                }
            }
        }
        vy(groovySourceAST);
    }

    protected void J8(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
        if (groovySourceAST2 != null) {
            j6(groovySourceAST2);
            for (groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW(); groovySourceAST2 != null; groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW()) {
                BT(groovySourceAST);
                j6(groovySourceAST2);
            }
        }
        vy(groovySourceAST);
    }

    protected void Ws(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        j6(groovySourceAST.Hw(0));
        vy(groovySourceAST);
    }

    protected void QX(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        lg(groovySourceAST);
        vy(groovySourceAST);
    }

    protected void XL(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        rN(groovySourceAST);
        vy(groovySourceAST);
    }

    protected void aM(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(0));
        yS(groovySourceAST);
        vy(groovySourceAST);
        lg(groovySourceAST.Hw(0));
    }

    protected void j3(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(0));
        int i = 1;
        yS(groovySourceAST);
        if (groovySourceAST.Hw(0) != null) {
            for (GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.Hw(0).DW(); groovySourceAST2 != null; groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW()) {
                if (i == groovySourceAST.VH() - 1) {
                    vy(groovySourceAST);
                }
                j6(groovySourceAST2);
                i++;
            }
        }
    }

    protected void Mr(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST.Hw(0));
        yS(groovySourceAST);
        lg(groovySourceAST.Hw(0));
        vy(groovySourceAST);
    }

    protected void U2(GroovySourceAST groovySourceAST) {
        Ws(groovySourceAST);
        lg(groovySourceAST.Hw(0));
    }

    protected void a8(GroovySourceAST groovySourceAST) {
        yS(groovySourceAST);
        j6(groovySourceAST.Hw(0));
        BT(groovySourceAST);
        lg(groovySourceAST.Hw(0));
        vy(groovySourceAST);
    }

    protected void lg(GroovySourceAST groovySourceAST) {
        if (groovySourceAST != null) {
            for (GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.DW(); groovySourceAST2 != null; groovySourceAST2 = (GroovySourceAST) groovySourceAST2.DW()) {
                j6(groovySourceAST2);
            }
        }
    }

    protected void rN(GroovySourceAST groovySourceAST) {
        if (groovySourceAST != null) {
            GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
            if (groovySourceAST2 != null) {
                j6(groovySourceAST2);
                lg(groovySourceAST2);
            }
        }
    }

    protected void er(GroovySourceAST groovySourceAST) {
        this.j6.remove(groovySourceAST);
    }

    protected void yS(GroovySourceAST groovySourceAST) {
        this.j6.remove(groovySourceAST);
        j6(groovySourceAST, 1);
    }

    protected void gW(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST, 2);
    }

    protected void BT(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST, 3);
    }

    protected void vy(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST, 4);
    }

    public AST j6(AST ast) {
        GroovySourceAST groovySourceAST = (GroovySourceAST) ast;
        DW(groovySourceAST);
        j6(groovySourceAST);
        lg(groovySourceAST);
        FH(groovySourceAST);
        return null;
    }
}
