package org.codehaus.groovy.antlr.treewalker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class CompositeVisitor implements Visitor {
    final List DW;
    private final Stack FH;
    final List j6;

    public CompositeVisitor(List list) {
        this.j6 = list;
        this.FH = new Stack();
        this.DW = new ArrayList();
        this.DW.addAll(list);
        Collections.reverse(this.DW);
    }

    private Iterator j6(int i) {
        Iterator it = this.j6.iterator();
        if (i == 4) {
            return this.DW.iterator();
        }
        return it;
    }

    public void DW() {
        for (Visitor DW : this.j6) {
            DW.DW();
        }
    }

    public void FH(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).FH(groovySourceAST, i);
        }
    }

    public void Hw(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Hw(groovySourceAST, i);
        }
    }

    public void v5(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).v5(groovySourceAST, i);
        }
    }

    public void Zo(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Zo(groovySourceAST, i);
        }
    }

    public void VH(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).VH(groovySourceAST, i);
        }
    }

    public void gn(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).gn(groovySourceAST, i);
        }
    }

    public void u7(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).u7(groovySourceAST, i);
        }
    }

    public void tp(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).tp(groovySourceAST, i);
        }
    }

    public void EQ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).EQ(groovySourceAST, i);
        }
    }

    public void we(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).we(groovySourceAST, i);
        }
    }

    public void J0(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).J0(groovySourceAST, i);
        }
    }

    public void J8(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).J8(groovySourceAST, i);
        }
    }

    public void Ws(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Ws(groovySourceAST, i);
        }
    }

    public void QX(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).QX(groovySourceAST, i);
        }
    }

    public void XL(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).XL(groovySourceAST, i);
        }
    }

    public void aM(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).aM(groovySourceAST, i);
        }
    }

    public void j3(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).j3(groovySourceAST, i);
        }
    }

    public void Mr(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Mr(groovySourceAST, i);
        }
    }

    public void U2(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).U2(groovySourceAST, i);
        }
    }

    public void a8(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).a8(groovySourceAST, i);
        }
    }

    public void lg(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).lg(groovySourceAST, i);
        }
    }

    public void rN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).rN(groovySourceAST, i);
        }
    }

    public void j6(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).j6(groovySourceAST, i);
        }
    }

    public void er(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).er(groovySourceAST, i);
        }
    }

    public void yS(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).yS(groovySourceAST, i);
        }
    }

    public void gW(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).gW(groovySourceAST, i);
        }
    }

    public void BT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).BT(groovySourceAST, i);
        }
    }

    public void vy(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).vy(groovySourceAST, i);
        }
    }

    public void P8(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).P8(groovySourceAST, i);
        }
    }

    public void ei(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ei(groovySourceAST, i);
        }
    }

    public void nw(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).nw(groovySourceAST, i);
        }
    }

    public void SI(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).SI(groovySourceAST, i);
        }
    }

    public void KD(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).KD(groovySourceAST, i);
        }
    }

    public void ro(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ro(groovySourceAST, i);
        }
    }

    public void cn(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).cn(groovySourceAST, i);
        }
    }

    public void sh(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sh(groovySourceAST, i);
        }
    }

    public void cb(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).cb(groovySourceAST, i);
        }
    }

    public void dx(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).dx(groovySourceAST, i);
        }
    }

    public void sG(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sG(groovySourceAST, i);
        }
    }

    public void ef(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ef(groovySourceAST, i);
        }
    }

    public void Sf(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Sf(groovySourceAST, i);
        }
    }

    public void vJ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).vJ(groovySourceAST, i);
        }
    }

    public void g3(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).g3(groovySourceAST, i);
        }
    }

    public void Mz(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Mz(groovySourceAST, i);
        }
    }

    public void I(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).I(groovySourceAST, i);
        }
    }

    public void ca(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ca(groovySourceAST, i);
        }
    }

    public void x9(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).x9(groovySourceAST, i);
        }
    }

    public void Qq(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Qq(groovySourceAST, i);
        }
    }

    public void sy(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sy(groovySourceAST, i);
        }
    }

    public void aj(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).aj(groovySourceAST, i);
        }
    }

    public void lp(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).lp(groovySourceAST, i);
        }
    }

    public void OW(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).OW(groovySourceAST, i);
        }
    }

    public void br(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).br(groovySourceAST, i);
        }
    }

    public void XX(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).XX(groovySourceAST, i);
        }
    }

    public void kQ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).kQ(groovySourceAST, i);
        }
    }

    public void yO(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).yO(groovySourceAST, i);
        }
    }

    public void XG(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).XG(groovySourceAST, i);
        }
    }

    public void jJ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).jJ(groovySourceAST, i);
        }
    }

    public void wc(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).wc(groovySourceAST, i);
        }
    }

    public void et(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).et(groovySourceAST, i);
        }
    }

    public void CU(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).CU(groovySourceAST, i);
        }
    }

    public void Xa(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Xa(groovySourceAST, i);
        }
    }

    public void Eq(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Eq(groovySourceAST, i);
        }
    }

    public void hz(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).hz(groovySourceAST, i);
        }
    }

    public void aq(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).aq(groovySourceAST, i);
        }
    }

    public void FN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).FN(groovySourceAST, i);
        }
    }

    public void jO(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).jO(groovySourceAST, i);
        }
    }

    public void oY(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).oY(groovySourceAST, i);
        }
    }

    public void ko(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ko(groovySourceAST, i);
        }
    }

    public void Ev(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Ev(groovySourceAST, i);
        }
    }

    public void ye(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ye(groovySourceAST, i);
        }
    }

    public void WB(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).WB(groovySourceAST, i);
        }
    }

    public void mb(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).mb(groovySourceAST, i);
        }
    }

    public void jw(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).jw(groovySourceAST, i);
        }
    }

    public void fY(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).fY(groovySourceAST, i);
        }
    }

    public void qp(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).qp(groovySourceAST, i);
        }
    }

    public void k2(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).k2(groovySourceAST, i);
        }
    }

    public void zh(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).zh(groovySourceAST, i);
        }
    }

    public void AL(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).AL(groovySourceAST, i);
        }
    }

    public void w9(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).w9(groovySourceAST, i);
        }
    }

    public void hK(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).hK(groovySourceAST, i);
        }
    }

    public void cT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).cT(groovySourceAST, i);
        }
    }

    public void q7(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).q7(groovySourceAST, i);
        }
    }

    public void Z1(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Z1(groovySourceAST, i);
        }
    }

    public void n5(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).n5(groovySourceAST, i);
        }
    }

    public void Q6(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Q6(groovySourceAST, i);
        }
    }

    public void kf(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).kf(groovySourceAST, i);
        }
    }

    public void Jl(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Jl(groovySourceAST, i);
        }
    }

    public void iW(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).iW(groovySourceAST, i);
        }
    }

    public void eU(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).eU(groovySourceAST, i);
        }
    }

    public void e3(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).e3(groovySourceAST, i);
        }
    }

    public void sE(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sE(groovySourceAST, i);
        }
    }

    public void sg(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sg(groovySourceAST, i);
        }
    }

    public void pO(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).pO(groovySourceAST, i);
        }
    }

    public void fN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).fN(groovySourceAST, i);
        }
    }

    public void Gj(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Gj(groovySourceAST, i);
        }
    }

    public void Cz(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Cz(groovySourceAST, i);
        }
    }

    public void pN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).pN(groovySourceAST, i);
        }
    }

    public void oy(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).oy(groovySourceAST, i);
        }
    }

    public void aX(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).aX(groovySourceAST, i);
        }
    }

    public void e9(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).e9(groovySourceAST, i);
        }
    }

    public void QO(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).QO(groovySourceAST, i);
        }
    }

    public void sM(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sM(groovySourceAST, i);
        }
    }

    public void a5(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).a5(groovySourceAST, i);
        }
    }

    public void ys(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ys(groovySourceAST, i);
        }
    }

    public void IS(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).IS(groovySourceAST, i);
        }
    }

    public void gG(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).gG(groovySourceAST, i);
        }
    }

    public void Nh(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Nh(groovySourceAST, i);
        }
    }

    public void BR(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).BR(groovySourceAST, i);
        }
    }

    public void AE(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).AE(groovySourceAST, i);
        }
    }

    public void Za(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Za(groovySourceAST, i);
        }
    }

    public void An(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).An(groovySourceAST, i);
        }
    }

    public void Pa(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Pa(groovySourceAST, i);
        }
    }

    public void ce(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ce(groovySourceAST, i);
        }
    }

    public void Jm(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Jm(groovySourceAST, i);
        }
    }

    public void Bx(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Bx(groovySourceAST, i);
        }
    }

    public void oa(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).oa(groovySourceAST, i);
        }
    }

    public void qP(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).qP(groovySourceAST, i);
        }
    }

    public void MP(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).MP(groovySourceAST, i);
        }
    }

    public void Of(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Of(groovySourceAST, i);
        }
    }

    public void PT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).PT(groovySourceAST, i);
        }
    }

    public void b1(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).b1(groovySourceAST, i);
        }
    }

    public void AR(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).AR(groovySourceAST, i);
        }
    }

    public void TI(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).TI(groovySourceAST, i);
        }
    }

    public void ct(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ct(groovySourceAST, i);
        }
    }

    public void Fd(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Fd(groovySourceAST, i);
        }
    }

    public void Lz(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Lz(groovySourceAST, i);
        }
    }

    public void sT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sT(groovySourceAST, i);
        }
    }

    public void E4(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).E4(groovySourceAST, i);
        }
    }

    public void xg(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).xg(groovySourceAST, i);
        }
    }

    public void hp(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).hp(groovySourceAST, i);
        }
    }

    public void PH(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).PH(groovySourceAST, i);
        }
    }

    public void GK(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).GK(groovySourceAST, i);
        }
    }

    public void dW(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).dW(groovySourceAST, i);
        }
    }

    public void Yi(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Yi(groovySourceAST, i);
        }
    }

    public void GT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).GT(groovySourceAST, i);
        }
    }

    public void Hl(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Hl(groovySourceAST, i);
        }
    }

    public void pl(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).pl(groovySourceAST, i);
        }
    }

    public void oh(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).oh(groovySourceAST, i);
        }
    }

    public void Ej(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Ej(groovySourceAST, i);
        }
    }

    public void T6(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).T6(groovySourceAST, i);
        }
    }

    public void cc(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).cc(groovySourceAST, i);
        }
    }

    public void Od(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Od(groovySourceAST, i);
        }
    }

    public void om(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).om(groovySourceAST, i);
        }
    }

    public void wE(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).wE(groovySourceAST, i);
        }
    }

    public void d8(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).d8(groovySourceAST, i);
        }
    }

    public void N0(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).N0(groovySourceAST, i);
        }
    }

    public void eN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).eN(groovySourceAST, i);
        }
    }

    public void zf(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).zf(groovySourceAST, i);
        }
    }

    public void fP(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).fP(groovySourceAST, i);
        }
    }

    public void b(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).b(groovySourceAST, i);
        }
    }

    public void ba(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ba(groovySourceAST, i);
        }
    }

    public void u9(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).u9(groovySourceAST, i);
        }
    }

    public void Ak(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Ak(groovySourceAST, i);
        }
    }

    public void nl(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).nl(groovySourceAST, i);
        }
    }

    public void ti(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ti(groovySourceAST, i);
        }
    }

    public void k1(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).k1(groovySourceAST, i);
        }
    }

    public void iK(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).iK(groovySourceAST, i);
        }
    }

    public void fh(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).fh(groovySourceAST, i);
        }
    }

    public void sv(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).sv(groovySourceAST, i);
        }
    }

    public void HT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).HT(groovySourceAST, i);
        }
    }

    public void oT(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).oT(groovySourceAST, i);
        }
    }

    public void hx(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).hx(groovySourceAST, i);
        }
    }

    public void qU(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).qU(groovySourceAST, i);
        }
    }

    public void uC(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).uC(groovySourceAST, i);
        }
    }

    public void ep(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ep(groovySourceAST, i);
        }
    }

    public void HO(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).HO(groovySourceAST, i);
        }
    }

    public void qI(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).qI(groovySourceAST, i);
        }
    }

    public void DY(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).DY(groovySourceAST, i);
        }
    }

    public void tj(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).tj(groovySourceAST, i);
        }
    }

    public void pn(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).pn(groovySourceAST, i);
        }
    }

    public void x6(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).x6(groovySourceAST, i);
        }
    }

    public void k4(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).k4(groovySourceAST, i);
        }
    }

    public void RW(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).RW(groovySourceAST, i);
        }
    }

    public void Vq(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Vq(groovySourceAST, i);
        }
    }

    public void cX(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).cX(groovySourceAST, i);
        }
    }

    public void ya(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ya(groovySourceAST, i);
        }
    }

    public void ir(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ir(groovySourceAST, i);
        }
    }

    public void uD(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).uD(groovySourceAST, i);
        }
    }

    public void HE(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).HE(groovySourceAST, i);
        }
    }

    public void h2(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).h2(groovySourceAST, i);
        }
    }

    public void gy(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).gy(groovySourceAST, i);
        }
    }

    public void F3(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).F3(groovySourceAST, i);
        }
    }

    public void S4(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).S4(groovySourceAST, i);
        }
    }

    public void tv(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).tv(groovySourceAST, i);
        }
    }

    public void gM(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).gM(groovySourceAST, i);
        }
    }

    public void tR(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).tR(groovySourceAST, i);
        }
    }

    public void ji(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ji(groovySourceAST, i);
        }
    }

    public void ME(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ME(groovySourceAST, i);
        }
    }

    public void C(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).C(groovySourceAST, i);
        }
    }

    public void dH(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).dH(groovySourceAST, i);
        }
    }

    public void BN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).BN(groovySourceAST, i);
        }
    }

    public void jn(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).jn(groovySourceAST, i);
        }
    }

    public void DP(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).DP(groovySourceAST, i);
        }
    }

    public void ee(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).ee(groovySourceAST, i);
        }
    }

    public void K3(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).K3(groovySourceAST, i);
        }
    }

    public void OM(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).OM(groovySourceAST, i);
        }
    }

    public void Qs(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Qs(groovySourceAST, i);
        }
    }

    public void g0(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).g0(groovySourceAST, i);
        }
    }

    public void fd(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).fd(groovySourceAST, i);
        }
    }

    public void Lx(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Lx(groovySourceAST, i);
        }
    }

    public void wC(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).wC(groovySourceAST, i);
        }
    }

    public void hG(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).hG(groovySourceAST, i);
        }
    }

    public void s0(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).s0(groovySourceAST, i);
        }
    }

    public void zg(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).zg(groovySourceAST, i);
        }
    }

    public void J1(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).J1(groovySourceAST, i);
        }
    }

    public void N2(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).N2(groovySourceAST, i);
        }
    }

    public void NZ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).NZ(groovySourceAST, i);
        }
    }

    public void IM(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).IM(groovySourceAST, i);
        }
    }

    public void jg(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).jg(groovySourceAST, i);
        }
    }

    public void eQ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).eQ(groovySourceAST, i);
        }
    }

    public void BJ(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).BJ(groovySourceAST, i);
        }
    }

    public void Sc(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).Sc(groovySourceAST, i);
        }
    }

    public void jD(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).jD(groovySourceAST, i);
        }
    }

    public void UF(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).UF(groovySourceAST, i);
        }
    }

    public void rB(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).rB(groovySourceAST, i);
        }
    }

    public void CN(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).CN(groovySourceAST, i);
        }
    }

    public void oC(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).oC(groovySourceAST, i);
        }
    }

    public void DW(GroovySourceAST groovySourceAST, int i) {
        Iterator j6 = j6(i);
        while (j6.hasNext()) {
            ((Visitor) j6.next()).DW(groovySourceAST, i);
        }
    }

    public void FH() {
        for (Visitor FH : this.DW) {
            FH.FH();
        }
    }

    public void DW(GroovySourceAST groovySourceAST) {
        for (Visitor DW : this.j6) {
            DW.DW(groovySourceAST);
        }
    }

    public GroovySourceAST j6() {
        GroovySourceAST groovySourceAST = null;
        for (Visitor j6 : this.DW) {
            groovySourceAST = j6.j6();
        }
        return groovySourceAST;
    }
}
