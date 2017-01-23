package com.aide.ui.views.editor;

import java.io.Reader;
import java.util.Vector;
import qt;

public abstract class b implements j {
    private Vector<m> DW;
    private Vector<k> j6;

    protected b() {
        this.j6 = new Vector();
        this.DW = new Vector();
    }

    public void j6(k kVar) {
        if (!this.j6.contains(kVar)) {
            this.j6.addElement(kVar);
        }
    }

    public void DW(k kVar) {
        this.j6.removeElement(kVar);
    }

    public void j6(m mVar) {
        if (!this.DW.contains(mVar)) {
            this.DW.addElement(mVar);
        }
    }

    public void DW(m mVar) {
        this.DW.removeElement(mVar);
    }

    protected void j6(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < this.j6.size(); i5++) {
            ((k) this.j6.elementAt(i5)).DW(this, i, i2, i3, i4);
        }
    }

    protected void J0() {
        for (int i = 0; i < this.j6.size(); i++) {
            ((k) this.j6.elementAt(i)).j6(this);
        }
    }

    protected void DW(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < this.j6.size(); i5++) {
            ((k) this.j6.elementAt(i5)).j6((j) this, i, i2, i3, i4);
        }
    }

    protected void FH(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < this.DW.size(); i5++) {
            ((m) this.DW.elementAt(i5)).FH(this, i, i2, i3, i4);
        }
    }

    protected void J0(int i, int i2) {
        for (int i3 = 0; i3 < this.DW.size(); i3++) {
            ((m) this.DW.elementAt(i3)).j6((j) this, i, i2);
        }
    }

    protected void j6(int i, int i2, int i3, char[] cArr) {
        for (int i4 = 0; i4 < this.j6.size(); i4++) {
            ((k) this.j6.elementAt(i4)).j6((j) this, i, i2, i3, cArr);
        }
    }

    protected void j6(qt qtVar, qt qtVar2) {
        for (int i = 0; i < this.DW.size(); i++) {
            ((m) this.DW.elementAt(i)).j6((j) this, qtVar, qtVar2);
        }
    }

    protected void J8() {
        for (int i = 0; i < this.DW.size(); i++) {
            ((m) this.DW.elementAt(i)).DW(this);
        }
    }

    public Reader j6(qt qtVar) {
        return j6(qtVar, false);
    }

    public Reader j6(qt qtVar, String str) {
        return new y(this, qtVar.DW(), qtVar.j6(), qtVar.Hw(), qtVar.FH(), false, str);
    }

    public Reader j6(qt qtVar, boolean z) {
        return j6(qtVar.DW(), qtVar.j6(), qtVar.Hw(), qtVar.FH(), z);
    }

    public Reader j6(int i, int i2, int i3, int i4, boolean z) {
        return new y(this, i, i2, i3, i4, z, System.getProperty("line.separator"));
    }

    public Reader Ws() {
        return j6(false);
    }

    public Reader j6(boolean z) {
        return DW(0, 0, 0, Integer.MAX_VALUE, z);
    }

    public Reader j6(int i, int i2, int i3, int i4, boolean z, String str) {
        return new l(this, i, i2, i3, i4, z, str);
    }

    public Reader DW(qt qtVar, String str) {
        return j6(qtVar, false, str);
    }

    public Reader j6(qt qtVar, boolean z, String str) {
        return new l(this, qtVar.DW(), qtVar.j6(), qtVar.Hw(), qtVar.FH(), z, str);
    }
}
