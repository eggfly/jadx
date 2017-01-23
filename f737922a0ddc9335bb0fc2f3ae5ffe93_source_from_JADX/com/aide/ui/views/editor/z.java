package com.aide.ui.views.editor;

import com.aide.common.w;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import qr;
import qt;

public class z {
    private Vector<b> DW;
    private int FH;
    private int Hw;
    private boolean VH;
    private qr Zo;
    private boolean gn;
    private int j6;
    private d tp;
    private boolean u7;
    private List<g> v5;

    public interface j {
    }

    abstract class b {
        final /* synthetic */ z FH;
        private qr j6;

        public abstract b j6();

        public abstract void j6(d dVar);

        public abstract boolean j6(b bVar);

        protected b(z zVar, qr qrVar) {
            this.FH = zVar;
            this.j6 = qrVar;
        }

        public qr DW() {
            return this.j6;
        }
    }

    class a extends b {
        final /* synthetic */ z DW;
        Vector<b> j6;

        public a(z zVar, qr qrVar) {
            this.DW = zVar;
            super(zVar, qrVar);
            this.j6 = new Vector();
        }

        public a(z zVar, qr qrVar, b bVar, b bVar2) {
            this.DW = zVar;
            super(zVar, qrVar);
            this.j6 = new Vector();
            this.j6.addElement(bVar);
            this.j6.addElement(bVar2);
        }

        public b j6() {
            b aVar = new a(this.DW, null);
            for (int size = this.j6.size() - 1; size >= 0; size--) {
                aVar.j6.addElement(((b) this.j6.elementAt(size)).j6());
            }
            return aVar;
        }

        public void j6(d dVar) {
            for (int i = 0; i < this.j6.size(); i++) {
                ((b) this.j6.elementAt(i)).j6(dVar);
            }
        }

        public boolean j6(b bVar) {
            if (this.j6.size() == 0) {
                this.j6.addElement(bVar);
            } else if (!((b) this.j6.lastElement()).j6(bVar)) {
                this.j6.addElement(bVar);
            }
            return true;
        }
    }

    abstract class i extends b {
        protected qt DW;
        protected StringBuffer Hw;
        final /* synthetic */ z v5;

        protected i(z zVar, qr qrVar, qt qtVar, String str) {
            this.v5 = zVar;
            super(zVar, qrVar);
            this.Hw = new StringBuffer(str);
            this.DW = qtVar;
        }

        protected i(z zVar, qr qrVar, qt qtVar, char c) {
            this.v5 = zVar;
            super(zVar, qrVar);
            this.Hw = new StringBuffer().append(c);
            this.DW = qtVar;
        }

        protected i(z zVar, i iVar) {
            this.v5 = zVar;
            super(zVar, null);
            this.DW = iVar.DW;
            this.Hw = iVar.Hw;
        }
    }

    class c extends i {
        final /* synthetic */ z j6;

        public c(z zVar, h hVar) {
            this.j6 = zVar;
            super(zVar, hVar);
        }

        public c(z zVar, qr qrVar, qt qtVar, String str) {
            this.j6 = zVar;
            super(zVar, qrVar, qtVar, str);
        }

        public c(z zVar, qr qrVar, qt qtVar, char c) {
            this.j6 = zVar;
            super(zVar, qrVar, qtVar, c);
        }

        public b j6() {
            return new h(this.j6, this);
        }

        public void j6(d dVar) {
            try {
                dVar.j6(this.DW.DW(), this.DW.j6(), new StringReader(this.Hw.toString()), this.j6);
            } catch (IOException e) {
            }
        }

        public boolean j6(b bVar) {
            if (bVar instanceof c) {
                c cVar = (c) bVar;
                if (cVar.DW.j6() == this.DW.FH() && cVar.DW.DW() == this.DW.Hw() + 1) {
                    this.Hw.append(cVar.Hw.toString());
                    this.DW.Hw(cVar.DW.Hw());
                    this.DW.FH(cVar.DW.FH());
                    return true;
                }
            } else if (bVar instanceof e) {
                e eVar = (e) bVar;
                if (eVar.FH() == this.DW.FH() && eVar.Hw() == this.DW.Hw() + 1) {
                    this.Hw.append('\n');
                    this.DW.Hw(-1);
                    this.DW.FH(this.DW.FH() + 1);
                    return true;
                }
            }
            return false;
        }
    }

    abstract class d extends b {
        int DW;
        final /* synthetic */ z Hw;
        int j6;

        protected d(z zVar, qr qrVar, int i, int i2) {
            this.Hw = zVar;
            super(zVar, qrVar);
            this.j6 = i;
            this.DW = i2;
        }

        protected d(z zVar, d dVar) {
            this.Hw = zVar;
            super(zVar, null);
            this.j6 = dVar.j6;
            this.DW = dVar.DW;
        }

        public int FH() {
            return this.DW;
        }

        public int Hw() {
            return this.j6;
        }
    }

    class e extends d {
        final /* synthetic */ z v5;

        public e(z zVar, f fVar) {
            this.v5 = zVar;
            super(zVar, fVar);
        }

        public e(z zVar, qr qrVar, int i, int i2) {
            this.v5 = zVar;
            super(zVar, qrVar, i, i2);
        }

        public b j6() {
            return new f(this.v5, this);
        }

        public void j6(d dVar) {
            dVar.DW(this.j6, this.DW, this.v5);
        }

        public boolean j6(b bVar) {
            return false;
        }
    }

    class f extends d {
        final /* synthetic */ z v5;

        public f(z zVar, e eVar) {
            this.v5 = zVar;
            super(zVar, eVar);
        }

        public f(z zVar, qr qrVar, int i, int i2) {
            this.v5 = zVar;
            super(zVar, qrVar, i, i2);
        }

        public b j6() {
            return new e(this.v5, this);
        }

        public boolean j6(b bVar) {
            return false;
        }

        public void j6(d dVar) {
            dVar.j6(this.DW, this.v5);
        }
    }

    private static class g {
        public j DW;
        public int j6;

        public g(int i, j jVar) {
            this.j6 = i;
            this.DW = jVar;
        }
    }

    class h extends i {
        final /* synthetic */ z j6;

        public h(z zVar, c cVar) {
            this.j6 = zVar;
            super(zVar, cVar);
        }

        public h(z zVar, qr qrVar, qt qtVar, String str) {
            this.j6 = zVar;
            super(zVar, qrVar, qtVar, str);
        }

        public h(z zVar, qr qrVar, qt qtVar, char c) {
            this.j6 = zVar;
            super(zVar, qrVar, qtVar, c);
        }

        public b j6() {
            return new c(this.j6, this);
        }

        public void j6(d dVar) {
            dVar.j6(this.DW, this.j6);
        }

        public boolean j6(b bVar) {
            if (bVar instanceof h) {
                h hVar = (h) bVar;
                int j6 = this.DW.j6();
                int DW = this.DW.DW();
                int FH = this.DW.FH();
                int Hw = this.DW.Hw();
                int j62 = hVar.DW.j6();
                int DW2 = hVar.DW.DW();
                int FH2 = hVar.DW.FH();
                int Hw2 = hVar.DW.Hw();
                if (j62 == j6 && DW2 == DW) {
                    this.Hw.append(hVar.Hw.toString());
                    if (j62 == FH2) {
                        this.DW.Hw(((Hw + Hw2) - DW2) + 1);
                        return true;
                    }
                    this.DW.Hw(Hw2);
                    this.DW.FH((FH + FH2) - j62);
                    return true;
                } else if (FH2 == j6 && Hw2 == DW - 1) {
                    this.Hw.insert(0, hVar.Hw);
                    if (j62 == FH2) {
                        this.DW.DW(DW2);
                        return true;
                    }
                    this.DW.DW(DW2);
                    this.DW.j6(j62);
                    return true;
                }
            } else if (bVar instanceof f) {
                f fVar = (f) bVar;
                if (fVar.FH() == this.DW.j6() && fVar.Hw() == this.DW.DW()) {
                    this.Hw.append('\n');
                    this.DW.Hw(-1);
                    this.DW.FH(this.DW.FH() + 1);
                    return true;
                } else if (fVar.FH() == this.DW.j6() - 1 && this.DW.DW() == 0) {
                    this.Hw.insert(0, '\n');
                    this.DW.DW(fVar.Hw());
                    this.DW.j6(this.DW.j6() - 1);
                    return true;
                }
            }
            return false;
        }
    }

    class k extends b {
        int DW;
        char[] Hw;
        final /* synthetic */ z Zo;
        int j6;
        char[] v5;

        public k(z zVar, k kVar) {
            this.Zo = zVar;
            super(zVar, null);
            this.Hw = kVar.v5;
            this.v5 = kVar.Hw;
            this.j6 = kVar.j6;
            this.DW = kVar.DW;
        }

        public k(z zVar, qr qrVar, int i, int i2, char[] cArr, char[] cArr2) {
            this.Zo = zVar;
            super(zVar, qrVar);
            this.j6 = i2;
            this.DW = i;
            this.v5 = cArr2;
            this.Hw = cArr;
        }

        public b j6() {
            return new k(this.Zo, this);
        }

        public void j6(d dVar) {
            dVar.j6(this.j6, this.DW, this.Hw.length, this.Zo);
            dVar.j6(this.j6, this.DW, this.v5, this.Zo);
        }

        private char[] j6(char[] cArr, char[] cArr2) {
            Object obj = new char[(cArr.length + cArr2.length)];
            if (cArr.length != 0) {
                System.arraycopy(cArr, 0, obj, 0, cArr.length);
            }
            if (cArr2.length != 0) {
                System.arraycopy(cArr2, 0, obj, cArr.length, cArr2.length);
            }
            return obj;
        }

        public boolean j6(b bVar) {
            if (bVar instanceof k) {
                k kVar = (k) bVar;
                if (kVar.DW == this.DW && kVar.j6 == this.j6 + this.v5.length) {
                    this.v5 = j6(this.v5, kVar.v5);
                    this.Hw = j6(this.Hw, kVar.Hw);
                    return true;
                }
            }
            return false;
        }
    }

    public z(d dVar, int i) {
        this.tp = dVar;
        this.v5 = new ArrayList(3);
        this.DW = new Vector();
        this.FH = 0;
        this.Hw = 0;
        j6(i);
    }

    public void j6(int i) {
        if (this.j6 != i) {
            this.j6 = i;
            if (this.DW.size() > i) {
                int size = this.DW.size() - i;
                if (size > this.FH) {
                    size = this.FH;
                }
                DW(size);
                this.FH -= size;
                if (this.DW.size() > i) {
                    this.DW.setSize(i);
                }
            }
        }
        gn();
    }

    public boolean j6() {
        return this.FH == this.Hw;
    }

    public void DW() {
        this.Hw = this.FH;
        this.VH = true;
    }

    private void DW(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < this.DW.size() - 1; i4++) {
                this.DW.setElementAt(this.DW.elementAt(i4 + 1), i4);
            }
        }
        this.DW.setSize(this.DW.size() - i);
        this.Hw -= i;
        if (this.Hw < 0) {
            this.Hw = -1;
        }
        while (i2 < this.v5.size()) {
            g gVar = (g) this.v5.get(i2);
            gVar.j6 -= i;
            if (gVar.j6 < 0) {
                this.v5.remove(gVar);
                i2--;
            }
            i2++;
        }
    }

    public void FH() {
        this.VH = true;
    }

    public void j6(j jVar) {
        this.v5.add(new g(this.FH, jVar));
        this.VH = true;
    }

    public List<j> Hw() {
        List<j> arrayList = new ArrayList(1);
        for (int i = 0; i < this.v5.size(); i++) {
            g gVar = (g) this.v5.get(i);
            if (gVar.j6 == this.FH) {
                arrayList.add(gVar.DW);
            }
        }
        return arrayList;
    }

    private void VH() {
        if (this.FH != this.DW.size()) {
            this.DW.setSize(this.FH);
            if (this.Hw > this.FH) {
                this.Hw = -1;
            }
            int i = 0;
            while (i < this.v5.size()) {
                g gVar = (g) this.v5.get(i);
                if (gVar.j6 > this.FH) {
                    this.v5.remove(gVar);
                    i--;
                }
                i++;
            }
        }
    }

    private qr j6(Object obj) {
        if (obj instanceof OConsole) {
            return ((OConsole) obj).getCaretPosition();
        }
        return null;
    }

    private void j6(b bVar) {
        if (this.VH || this.DW.size() == 0) {
            this.VH = false;
            if (this.DW.size() >= this.j6) {
                DW((this.DW.size() - this.j6) + 1);
            }
            this.DW.addElement(bVar);
            this.FH = this.DW.size();
            gn();
            return;
        }
        b bVar2 = (b) this.DW.lastElement();
        if (!bVar2.j6(bVar)) {
            this.DW.setElementAt(new a(this, bVar2.DW(), bVar2, bVar), this.DW.size() - 1);
        }
    }

    public void j6(int i, int i2, int i3, int i4, d dVar, Object obj) {
        if (obj != this) {
            VH();
            qt qtVar = new qt(i, i2, i3, i4);
            qr j6 = j6(obj);
            Reader j62 = dVar.j6(qtVar);
            Writer stringWriter = new StringWriter();
            try {
                w.j6(j62, stringWriter);
                j6(new c(this, j6, qtVar, stringWriter.toString()));
            } catch (IOException e) {
                throw new InternalError();
            }
        }
    }

    public void j6(int i, int i2, char c, d dVar, Object obj) {
        if (obj != this) {
            VH();
            j6(new c(this, j6(obj), new qt(i, i2, i, i2), c));
        }
    }

    public void j6(int i, int i2, d dVar, Object obj) {
        if (obj != this) {
            VH();
            j6(new e(this, j6(obj), i2, i));
        }
    }

    public void DW(int i, int i2, d dVar, Object obj) {
        if (obj != this) {
            VH();
            j6(new f(this, j6(obj), i2, i));
        }
    }

    public void DW(int i, int i2, int i3, int i4, d dVar, Object obj) {
        if (obj != this) {
            VH();
            qt qtVar = new qt(i, i2, i3, i4);
            qr j6 = j6(obj);
            Reader j62 = dVar.j6(qtVar);
            Writer stringWriter = new StringWriter();
            try {
                w.j6(j62, stringWriter);
                j6(new h(this, j6, qtVar, stringWriter.toString()));
            } catch (IOException e) {
                throw new InternalError();
            }
        }
    }

    public void DW(int i, int i2, char c, d dVar, Object obj) {
        if (obj != this) {
            VH();
            j6(new h(this, j6(obj), new qt(i, i2, i, i2), c));
        }
    }

    public void j6(int i, int i2, char[] cArr, char[] cArr2, d dVar, Object obj) {
        if (obj != this) {
            VH();
            j6(new k(this, j6(obj), i, i2, cArr, cArr2));
        }
    }

    public qr j6(d dVar, Object obj) {
        if (!this.gn) {
            return null;
        }
        if (this.FH == this.DW.size()) {
            this.Zo = j6(obj);
        }
        FH();
        Vector vector = this.DW;
        int i = this.FH - 1;
        this.FH = i;
        b bVar = (b) vector.elementAt(i);
        bVar.j6().j6(dVar);
        gn();
        return bVar.DW();
    }

    public qr j6(d dVar) {
        if (!this.u7) {
            return null;
        }
        Vector vector = this.DW;
        int i = this.FH;
        this.FH = i + 1;
        ((b) vector.elementAt(i)).j6(dVar);
        gn();
        if (this.FH < this.DW.size()) {
            return ((b) this.DW.elementAt(this.FH)).DW();
        }
        return this.Zo;
    }

    private void gn() {
        boolean z = true;
        boolean z2 = this.FH > 0;
        if (this.gn != z2) {
            this.gn = z2;
            this.tp.Hw(z2);
        }
        if (this.FH == this.DW.size()) {
            z = false;
        }
        if (this.u7 != z) {
            this.u7 = z;
            this.tp.FH(z);
        }
    }

    public boolean v5() {
        return this.gn;
    }

    public boolean Zo() {
        return this.u7;
    }
}
