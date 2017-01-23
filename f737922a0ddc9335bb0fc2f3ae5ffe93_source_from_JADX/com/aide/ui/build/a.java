package com.aide.ui.build;

import com.aide.common.m;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;
import qh;

public class a {
    private b DW;
    private String FH;
    private int Hw;
    private String VH;
    private boolean Zo;
    private List<a> j6;
    private int v5;

    public interface a {
        void i_();
    }

    class 1 extends com.aide.engine.service.a.a {
        final /* synthetic */ a j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ boolean j6;

            1(1 1, boolean z) {
                this.DW = 1;
                this.j6 = z;
            }

            public void run() {
                if (this.DW.j6.DW != null) {
                    this.DW.j6.DW.j6(this.j6);
                }
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ String j6;

            2(1 1, String str) {
                this.DW = 1;
                this.j6 = str;
            }

            public void run() {
                if (this.DW.j6.DW != null) {
                    this.DW.j6.DW.j6(this.j6);
                }
            }
        }

        1(a aVar) {
            this.j6 = aVar;
        }

        public void j6(boolean z) {
            e.j6(new 1(this, z));
        }

        public void j6(String str) {
            e.j6(new 2(this, str));
        }
    }

    public a() {
        this.j6 = new ArrayList();
    }

    public void j6(a aVar) {
        this.j6.add(aVar);
    }

    public void DW(a aVar) {
        this.j6.remove(aVar);
    }

    public boolean j6() {
        return DW() && this.Zo;
    }

    public boolean DW() {
        return this.FH != null;
    }

    public String FH() {
        return this.FH;
    }

    public void j6(String str) {
        j6(null, null, 0, 0);
        if (!this.Zo) {
            if (e.VH()) {
                e.QX().Hw();
                return;
            }
            m.j6(e.u7(), "Build Error", str);
            e.u7().yS();
        }
    }

    public void j6(boolean z) {
        this.Zo = z;
    }

    public void j6(b bVar, boolean z) {
        this.DW = bVar;
        this.Zo = z;
        if (!z) {
            e.u7().dx();
        }
        e.u7().u7();
    }

    public void j6(String str, String str2, int i, int i2) {
        this.FH = str2;
        this.Hw = i;
        this.v5 = i2;
        this.VH = str != null ? qh.Zo(str) : null;
        for (a i_ : this.j6) {
            i_.i_();
        }
        if (str2 == null) {
            e.er().FH();
            e.u7().u7();
        }
    }

    public int Hw() {
        return this.Hw;
    }

    public int v5() {
        return this.v5;
    }

    public void Zo() {
        for (b FH : c.Zo) {
            FH.FH();
        }
    }

    public void VH() {
        for (b Hw : c.Zo) {
            Hw.Hw();
        }
    }

    public void gn() {
        for (b v5 : c.Zo) {
            v5.v5();
        }
    }

    public void u7() {
        e.XL().j6(new 1(this));
        if (this.DW != null) {
            this.DW.Zo();
        }
    }

    public String tp() {
        return this.VH;
    }
}
