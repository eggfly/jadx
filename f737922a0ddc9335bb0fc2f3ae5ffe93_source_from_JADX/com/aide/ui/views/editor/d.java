package com.aide.ui.views.editor;

import com.aide.common.w;
import com.aide.ui.views.editor.z.j;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import qr;
import qt;

public class d extends b implements j {
    private Vector<d> DW;
    private List<e> EQ;
    private Vector<u> FH;
    private boolean Hw;
    private String J0;
    private long VH;
    private z Zo;
    private Set<q> gn;
    private Vector<f> j6;
    private a tp;
    private boolean u7;
    private boolean v5;
    private Set<qt> we;

    public interface d {
        void j6(d dVar, boolean z);
    }

    public interface f {
        void DW();

        void DW(d dVar, boolean z);

        void FH();

        void j6();

        void j6(d dVar, boolean z);

        void j6(List<j> list);
    }

    class 1 implements com.aide.ui.views.editor.v.a {
        final /* synthetic */ boolean DW;
        final /* synthetic */ int FH;
        final /* synthetic */ boolean Hw;
        final /* synthetic */ StringBuffer j6;
        final /* synthetic */ d v5;

        1(d dVar, StringBuffer stringBuffer, boolean z, int i, boolean z2) {
            this.v5 = dVar;
            this.j6 = stringBuffer;
            this.DW = z;
            this.FH = i;
            this.Hw = z2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean j6(int r8, char[] r9, int r10, int r11) {
            /*
            r7 = this;
            r6 = 9;
            r1 = 0;
            r0 = r7.j6;
            r0.setLength(r1);
            r0 = r7.DW;
            if (r0 == 0) goto L_0x0065;
        L_0x000c:
            r2 = r10;
            r3 = r1;
        L_0x000e:
            r0 = r10 + r11;
            if (r2 >= r0) goto L_0x0017;
        L_0x0012:
            r0 = r9[r2];
            switch(r0) {
                case 9: goto L_0x002c;
                case 32: goto L_0x0026;
                default: goto L_0x0017;
            };
        L_0x0017:
            r0 = r1;
        L_0x0018:
            r4 = r7.FH;
            r4 = r3 / r4;
            if (r0 >= r4) goto L_0x0039;
        L_0x001e:
            r4 = r7.j6;
            r4.append(r6);
            r0 = r0 + 1;
            goto L_0x0018;
        L_0x0026:
            r0 = r3 + 1;
        L_0x0028:
            r2 = r2 + 1;
            r3 = r0;
            goto L_0x000e;
        L_0x002c:
            r0 = r7.FH;
            r4 = r7.FH;
            r4 = r3 % r4;
            r0 = r0 - r4;
            if (r0 != 0) goto L_0x0037;
        L_0x0035:
            r0 = r7.FH;
        L_0x0037:
            r0 = r0 + r3;
            goto L_0x0028;
        L_0x0039:
            r0 = r1;
        L_0x003a:
            r4 = r7.FH;
            r4 = r3 % r4;
            if (r0 >= r4) goto L_0x004a;
        L_0x0040:
            r4 = r7.j6;
            r5 = 32;
            r4.append(r5);
            r0 = r0 + 1;
            goto L_0x003a;
        L_0x004a:
            r0 = r2;
        L_0x004b:
            r2 = r10 + r11;
            if (r0 >= r2) goto L_0x0080;
        L_0x004f:
            r2 = r9[r0];
            r2 = java.lang.Character.isISOControl(r2);
            if (r2 == 0) goto L_0x005b;
        L_0x0057:
            r2 = r9[r0];
            if (r2 != r6) goto L_0x0062;
        L_0x005b:
            r2 = r7.j6;
            r3 = r9[r0];
            r2.append(r3);
        L_0x0062:
            r0 = r0 + 1;
            goto L_0x004b;
        L_0x0065:
            r0 = r10;
        L_0x0066:
            r2 = r10 + r11;
            if (r0 >= r2) goto L_0x0080;
        L_0x006a:
            r2 = r9[r0];
            r2 = java.lang.Character.isISOControl(r2);
            if (r2 == 0) goto L_0x0076;
        L_0x0072:
            r2 = r9[r0];
            if (r2 != r6) goto L_0x007d;
        L_0x0076:
            r2 = r7.j6;
            r3 = r9[r0];
            r2.append(r3);
        L_0x007d:
            r0 = r0 + 1;
            goto L_0x0066;
        L_0x0080:
            r0 = r7.j6;
            r0 = r0.length();
            if (r0 == 0) goto L_0x00ac;
        L_0x0088:
            r0 = r7.j6;
            r0 = r0.length();
            r0 = new char[r0];
            r2 = r7.j6;
            r3 = r7.j6;
            r3 = r3.length();
            r2.getChars(r1, r3, r0, r1);
            r1 = r7.v5;
            r1 = r1.FH;
            r2 = r7.v5;
            r0 = r2.DW(r0);
            r1.addElement(r0);
        L_0x00aa:
            r0 = 1;
            return r0;
        L_0x00ac:
            r0 = r7.v5;
            r0 = r0.FH;
            r1 = r7.v5;
            r1 = r1.tp();
            r0.addElement(r1);
            goto L_0x00aa;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.views.editor.d.1.j6(int, char[], int, int):boolean");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void DW(int r8, char[] r9, int r10, int r11) {
            /*
            r7 = this;
            r6 = 9;
            r1 = 0;
            r0 = r7.j6;
            r0.setLength(r1);
            r0 = r7.DW;
            if (r0 == 0) goto L_0x0065;
        L_0x000c:
            r2 = r10;
            r3 = r1;
        L_0x000e:
            r0 = r10 + r11;
            if (r2 >= r0) goto L_0x0017;
        L_0x0012:
            r0 = r9[r2];
            switch(r0) {
                case 9: goto L_0x002c;
                case 32: goto L_0x0026;
                default: goto L_0x0017;
            };
        L_0x0017:
            r0 = r1;
        L_0x0018:
            r4 = r7.FH;
            r4 = r3 / r4;
            if (r0 >= r4) goto L_0x0039;
        L_0x001e:
            r4 = r7.j6;
            r4.append(r6);
            r0 = r0 + 1;
            goto L_0x0018;
        L_0x0026:
            r0 = r3 + 1;
        L_0x0028:
            r2 = r2 + 1;
            r3 = r0;
            goto L_0x000e;
        L_0x002c:
            r0 = r7.FH;
            r4 = r7.FH;
            r4 = r3 % r4;
            r0 = r0 - r4;
            if (r0 != 0) goto L_0x0037;
        L_0x0035:
            r0 = r7.FH;
        L_0x0037:
            r0 = r0 + r3;
            goto L_0x0028;
        L_0x0039:
            r0 = r1;
        L_0x003a:
            r4 = r7.FH;
            r4 = r3 % r4;
            if (r0 >= r4) goto L_0x004a;
        L_0x0040:
            r4 = r7.j6;
            r5 = 32;
            r4.append(r5);
            r0 = r0 + 1;
            goto L_0x003a;
        L_0x004a:
            r0 = r2;
        L_0x004b:
            r2 = r10 + r11;
            if (r0 >= r2) goto L_0x0080;
        L_0x004f:
            r2 = r9[r0];
            r2 = java.lang.Character.isISOControl(r2);
            if (r2 == 0) goto L_0x005b;
        L_0x0057:
            r2 = r9[r0];
            if (r2 != r6) goto L_0x0062;
        L_0x005b:
            r2 = r7.j6;
            r3 = r9[r0];
            r2.append(r3);
        L_0x0062:
            r0 = r0 + 1;
            goto L_0x004b;
        L_0x0065:
            r0 = r10;
        L_0x0066:
            r2 = r10 + r11;
            if (r0 >= r2) goto L_0x0080;
        L_0x006a:
            r2 = r9[r0];
            r2 = java.lang.Character.isISOControl(r2);
            if (r2 == 0) goto L_0x0076;
        L_0x0072:
            r2 = r9[r0];
            if (r2 != r6) goto L_0x007d;
        L_0x0076:
            r2 = r7.j6;
            r3 = r9[r0];
            r2.append(r3);
        L_0x007d:
            r0 = r0 + 1;
            goto L_0x0066;
        L_0x0080:
            r0 = r7.j6;
            r0 = r0.length();
            if (r0 == 0) goto L_0x00ab;
        L_0x0088:
            r0 = r7.j6;
            r0 = r0.length();
            r0 = new char[r0];
            r2 = r7.j6;
            r3 = r7.j6;
            r3 = r3.length();
            r2.getChars(r1, r3, r0, r1);
            r1 = r7.v5;
            r1 = r1.FH;
            r2 = r7.v5;
            r0 = r2.DW(r0);
            r1.addElement(r0);
        L_0x00aa:
            return;
        L_0x00ab:
            r0 = r7.v5;
            r0 = r0.FH;
            r1 = r7.v5;
            r1 = r1.tp();
            r0.addElement(r1);
            goto L_0x00aa;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.views.editor.d.1.DW(int, char[], int, int):void");
        }

        public void j6(String str) {
            if (!this.Hw) {
            }
        }
    }

    class 2 implements k {
        final /* synthetic */ d j6;

        2(d dVar) {
            this.j6 = dVar;
        }

        public void DW(j jVar, int i, int i2, int i3, int i4) {
            for (qt qtVar : this.j6.we) {
                Object obj;
                if (qtVar.j6(i2, i) && i == 0 && qtVar.DW() == 0 && qtVar.j6() == i2) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    qtVar.DW(i, i2, i3, i4);
                } else {
                    qtVar.j6(i, i2, i3, i4);
                }
            }
            if (this.j6.tp != null) {
                qt qtVar2 = null;
                for (qt qtVar3 : this.j6.tp.j6) {
                    if (this.j6.tp.DW != qtVar3) {
                        Object obj2;
                        qt DW;
                        boolean j6 = qtVar3.j6(i2, i);
                        if (j6 && i == 0 && qtVar3.DW() == 0 && qtVar3.j6() == i2) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (j6 && obj2 == null) {
                            if (i2 == i4) {
                                qtVar2 = qtVar3;
                            } else {
                                this.j6.FH(null);
                                return;
                            }
                        }
                        if (obj2 != null) {
                            DW = qtVar3.DW(i, i2, i3, i4);
                        } else {
                            DW = qtVar3.j6(i, i2, i3, i4);
                        }
                        if (DW != null) {
                            this.j6.j6(DW, qtVar3);
                        }
                    }
                    qtVar2 = qtVar2;
                }
                if (this.j6.tp.DW == null && !this.j6.tp.Hw) {
                    if (qtVar2 != null) {
                        this.j6.FH(qtVar2);
                    } else {
                        this.j6.FH(null);
                    }
                }
            }
        }

        public void j6(j jVar, int i, int i2, int i3, int i4) {
            for (qt qtVar : this.j6.we) {
                boolean z = qtVar.j6(i2, i) && !(i2 == qtVar.FH() && i == qtVar.Hw());
                if (z != qtVar.j6(i4, i3)) {
                    this.j6.FH(null);
                    return;
                }
                qtVar.FH(i, i2, i3, i4);
            }
            if (this.j6.tp != null) {
                qt qtVar2 = null;
                for (qt qtVar3 : this.j6.tp.j6) {
                    if (this.j6.tp.DW != qtVar3) {
                        boolean z2 = qtVar3.j6(i2, i) && !(i2 == qtVar3.FH() && i == qtVar3.Hw());
                        if (z2 != qtVar3.j6(i4, i3)) {
                            this.j6.FH(null);
                            return;
                        }
                        if (z2) {
                            if (i2 == i4) {
                                qtVar2 = qtVar3;
                            } else {
                                this.j6.FH(null);
                                return;
                            }
                        }
                        qt FH = qtVar3.FH(i, i2, i3, i4);
                        if (FH != null) {
                            this.j6.j6(FH, qtVar3);
                        }
                    }
                }
                if (this.j6.tp.DW == null && !this.j6.tp.Hw) {
                    if (qtVar2 != null) {
                        this.j6.FH(qtVar2);
                    } else {
                        this.j6.FH(null);
                    }
                }
            }
        }

        public void j6(j jVar, int i, int i2, int i3, char[] cArr) {
        }

        public void j6(j jVar) {
        }
    }

    class 3 implements f {
        final /* synthetic */ d j6;

        3(d dVar) {
            this.j6 = dVar;
        }

        public void j6(d dVar, boolean z) {
        }

        public void DW(d dVar, boolean z) {
        }

        public void j6(List<j> list) {
            if (this.j6.tp != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (((j) list.get(i)) == this.j6.tp.FH) {
                        this.j6.FH(null);
                        return;
                    }
                }
                this.j6.tp.Hw = true;
            }
        }

        public void FH() {
            if (this.j6.tp != null) {
                this.j6.tp.Hw = false;
            }
        }

        public void DW() {
            if (this.j6.tp != null) {
                this.j6.tp.Hw = true;
            }
        }

        public void j6() {
            if (this.j6.tp != null) {
                this.j6.tp.Hw = false;
            }
        }
    }

    private static class a {
        public qt DW;
        public b FH;
        public boolean Hw;
        public List<qt> j6;

        private a() {
            this.FH = new b();
        }
    }

    private static class b implements j {
        private b() {
        }
    }

    private class c implements com.aide.ui.views.editor.v.a {
        public int DW;
        public boolean FH;
        final /* synthetic */ d Hw;
        private StringBuffer VH;
        private int Zo;
        public int j6;
        private boolean v5;

        public c(d dVar, int i, int i2, boolean z, int i3) {
            this.Hw = dVar;
            this.j6 = i;
            this.DW = i2;
            this.VH = new StringBuffer();
            this.Zo = i3;
            this.v5 = z;
        }

        public boolean j6(int i, char[] cArr, int i2, int i3) {
            this.Hw.Hw = true;
            this.VH.setLength(0);
            int i4;
            if (this.v5) {
                int i5 = i2;
                int i6 = 0;
                while (i5 < i2 + i3) {
                    if (cArr[i5] == '\t') {
                        i4 = this.Zo - (i6 % this.Zo);
                        if (i4 == 0) {
                            i4 = this.Zo;
                        }
                        for (int i7 = 0; i7 < i4; i7++) {
                            this.VH.append(' ');
                        }
                        i4 += i6;
                    } else {
                        i4 = i6;
                    }
                    if (!Character.isISOControl(cArr[i5])) {
                        this.VH.append(cArr[i5]);
                        i4++;
                    }
                    i5++;
                    i6 = i4;
                }
            } else {
                i4 = i2;
                while (i4 < i2 + i3) {
                    if (!Character.isISOControl(cArr[i4]) || cArr[i4] == '\t') {
                        this.VH.append(cArr[i4]);
                    }
                    i4++;
                }
            }
            u uVar;
            char[] cArr2;
            if (this.VH.length() != 0) {
                char[] cArr3 = new char[this.VH.length()];
                this.VH.getChars(0, this.VH.length(), cArr3, 0);
                if (this.j6 == 0) {
                    this.Hw.FH.insertElementAt(new u(cArr3), this.DW);
                } else {
                    uVar = (u) this.Hw.FH.elementAt(this.DW);
                    uVar.DW(cArr3, this.j6);
                    this.j6 = cArr3.length + this.j6;
                    this.Hw.FH.insertElementAt(this.Hw.tp(), this.DW + 1);
                    cArr2 = new char[(uVar.FH() - this.j6)];
                    uVar.j6(this.j6, uVar.FH() - this.j6, cArr2, 0);
                    ((u) this.Hw.FH.elementAt(this.DW + 1)).j6(cArr2);
                    uVar.j6(uVar.FH() - this.j6, this.j6);
                }
            } else if (this.j6 == 0) {
                this.Hw.FH.insertElementAt(this.Hw.tp(), this.DW);
            } else {
                uVar = (u) this.Hw.FH.elementAt(this.DW);
                this.Hw.FH.insertElementAt(this.Hw.tp(), this.DW + 1);
                cArr2 = new char[(uVar.FH() - this.j6)];
                uVar.j6(this.j6, uVar.FH() - this.j6, cArr2, 0);
                ((u) this.Hw.FH.elementAt(this.DW + 1)).j6(cArr2);
                uVar.j6(uVar.FH() - this.j6, this.j6);
            }
            this.DW++;
            this.j6 = 0;
            return true;
        }

        public void DW(int i, char[] cArr, int i2, int i3) {
            this.FH = true;
            this.VH.setLength(0);
            int i4 = i2;
            while (i4 < i2 + i3) {
                if (!Character.isISOControl(cArr[i4]) || cArr[i4] == '\t') {
                    this.VH.append(cArr[i4]);
                }
                i4++;
            }
            if (this.VH.length() != 0) {
                this.Hw.Hw = true;
                char[] cArr2 = new char[this.VH.length()];
                this.VH.getChars(0, this.VH.length(), cArr2, 0);
                ((u) this.Hw.FH.elementAt(this.DW)).DW(cArr2, this.j6);
                this.j6 += this.VH.length();
            }
        }

        public void j6(String str) {
        }
    }

    public static class e {
        public int DW;
        public long FH;
        public char[] j6;

        private e(char[] cArr, int i, long j) {
            this.j6 = cArr;
            this.DW = i;
            this.FH = j;
        }
    }

    public d() {
        this.j6 = new Vector();
        this.DW = new Vector();
        this.FH = new Vector();
        this.gn = new HashSet();
        this.EQ = new ArrayList();
        this.we = new HashSet();
        this.J0 = System.getProperty("line.separator");
        this.VH = System.currentTimeMillis();
        this.FH.addElement(tp());
        j6();
    }

    public d(Reader reader, boolean z, boolean z2, int i) {
        this.j6 = new Vector();
        this.DW = new Vector();
        this.FH = new Vector();
        this.gn = new HashSet();
        this.EQ = new ArrayList();
        this.we = new HashSet();
        this.J0 = System.getProperty("line.separator");
        this.VH = System.currentTimeMillis();
        j6(reader, z, i, true);
        reader.close();
        j6();
    }

    private void j6(Reader reader, boolean z, int i, boolean z2) {
        v.j6(reader, new 1(this, new StringBuffer(), z, i, z2), new char[32768]);
        if (this.FH.size() == 0) {
            this.FH.addElement(tp());
        }
        reader.close();
        this.FH.trimToSize();
    }

    private void j6() {
        j6(new 2(this));
        j6(new 3(this));
        VH(100);
    }

    public void j6(e eVar) {
        if (!this.EQ.contains(eVar)) {
            this.EQ.add(eVar);
        }
    }

    private void DW() {
        J8();
        for (e j6 : this.EQ) {
            j6.j6(this, this.tp.j6);
        }
    }

    private void Zo() {
        J8();
        for (e j6 : this.EQ) {
            j6.j6(this);
        }
    }

    private void FH(qt qtVar) {
        Writer stringWriter = new StringWriter();
        try {
            w.j6(DW(qtVar.DW(), qtVar.j6(), qtVar.Hw() - 1, qtVar.FH(), false), stringWriter);
            String stringWriter2 = stringWriter.toString();
            DW(true);
            for (qt qtVar2 : this.tp.j6) {
                if (qtVar2 != qtVar) {
                    this.tp.DW = qtVar2;
                    qt qtVar3 = new qt(qtVar2);
                    qtVar3.Hw(qtVar3.Hw() - 1);
                    j6(qtVar3, (Object) this);
                    qr j6 = j6(qtVar2.DW(), qtVar2.j6(), new StringReader(stringWriter2), (Object) this);
                    qtVar2.Hw(j6.DW());
                    qtVar2.FH(j6.j6());
                    j6(qtVar3, qtVar2);
                    this.tp.DW = null;
                }
            }
            DW(false);
        } catch (IOException e) {
        }
    }

    public void FH(List<qt> list) {
        if (list != null || this.tp != null) {
            this.tp = null;
            Zo();
            if (list != null) {
                this.tp = new a();
                this.tp.j6 = list;
                lg();
                this.tp.FH = new b();
                j6(this.tp.FH);
                DW();
            }
        }
    }

    public List<qt> QX() {
        if (this.tp == null) {
            return Collections.emptyList();
        }
        return this.tp.j6;
    }

    public List<qt> XL() {
        return QX();
    }

    public void DW(boolean z) {
        this.u7 = z;
    }

    private void j6(List<j> list) {
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((f) it.next()).j6(list);
        }
    }

    private void VH() {
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((f) it.next()).FH();
        }
    }

    private void gn() {
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((f) it.next()).DW();
        }
    }

    private void u7() {
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((f) it.next()).j6();
        }
    }

    public void VH(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        } else if (this.Zo != null) {
            this.Zo.j6(i);
        } else {
            this.Zo = new z(this, i);
        }
    }

    public void aM() {
        this.Zo = null;
    }

    private u tp() {
        return new u();
    }

    private u DW(char[] cArr) {
        return new u(cArr);
    }

    public int FH() {
        return this.FH.size();
    }

    public int e_() {
        return -1;
    }

    public int Hw(int i) {
        if (this.FH.size() <= i) {
            return 0;
        }
        return ((u) this.FH.elementAt(i)).FH();
    }

    public char j6(int i, int i2) {
        return ((u) this.FH.elementAt(i2)).DW(i);
    }

    public char[] gn(int i) {
        u uVar = (u) this.FH.elementAt(i);
        char[] cArr = new char[uVar.FH()];
        uVar.j6(0, uVar.FH(), cArr, 0);
        return cArr;
    }

    public char[] DW(int i, int i2, int i3) {
        char[] cArr = new char[i3];
        ((u) this.FH.elementAt(i2)).j6(i, i3, cArr, 0);
        return cArr;
    }

    public void j6(int i, char[] cArr) {
        u uVar = (u) this.FH.elementAt(i);
        uVar.j6(0, uVar.FH(), cArr, 0);
    }

    public int DW(int i, int i2) {
        return 0;
    }

    public n Zo(int i) {
        return new n(g.Zo, null, 0);
    }

    public int v5() {
        return 1;
    }

    public boolean DW(int i) {
        return false;
    }

    public boolean EQ(int i, int i2) {
        return false;
    }

    public boolean Zo(int i, int i2) {
        return false;
    }

    public boolean VH(int i, int i2) {
        return false;
    }

    public int gn(int i, int i2) {
        return 0;
    }

    public boolean J8(int i, int i2) {
        return false;
    }

    public boolean tp(int i, int i2) {
        return false;
    }

    public boolean u7(int i) {
        return false;
    }

    public boolean tp(int i) {
        return false;
    }

    public boolean EQ(int i) {
        return false;
    }

    public boolean we(int i) {
        return false;
    }

    public boolean J0(int i) {
        return false;
    }

    public boolean J8(int i) {
        return false;
    }

    public boolean v5(int i) {
        return false;
    }

    public boolean we(int i, int i2) {
        return false;
    }

    public boolean c_(int i, int i2) {
        return false;
    }

    public boolean j6(int i) {
        return false;
    }

    public int j3() {
        return -1;
    }

    public qt Mr() {
        return null;
    }

    public qt U2() {
        return null;
    }

    public int a8() {
        return -1;
    }

    public boolean Ws(int i, int i2) {
        return false;
    }

    public void lg() {
        if (this.Zo != null) {
            this.Zo.FH();
        }
    }

    public void j6(j jVar) {
        if (this.Zo != null) {
            this.Zo.j6(jVar);
        }
    }

    public synchronized long rN() {
        return this.VH;
    }

    private synchronized void EQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.VH) {
            this.VH++;
        } else {
            this.VH = currentTimeMillis;
        }
    }

    public synchronized e j6(char[] cArr) {
        int i;
        Object obj;
        if (this.FH == null) {
            throw new IOException();
        }
        Object obj2;
        if (cArr == null) {
            obj2 = new char[32768];
        }
        int i2 = 0;
        i = 0;
        obj = obj2;
        while (i2 < this.FH.size()) {
            int length;
            u uVar = (u) this.FH.elementAt(i2);
            int FH = uVar.FH();
            if ((i + FH) + 1 > obj.length) {
                length = obj.length * 2;
                while ((i + FH) + 1 > length) {
                    length *= 2;
                }
                Object obj3 = new char[length];
                System.arraycopy(obj, 0, obj3, 0, i);
                obj = obj3;
            }
            if (FH > 0) {
                uVar.j6(0, FH, obj, i);
                i += FH;
            }
            length = i + 1;
            obj[i] = '\n';
            i2++;
            i = length;
        }
        return new e(i, this.VH, null);
    }

    public void j6(int i, int i2, char c, Object obj) {
        this.Hw = true;
        synchronized (this) {
            ((u) this.FH.elementAt(i2)).DW(c, i);
            if (this.Zo != null) {
                this.Zo.j6(i2, i, c, this, obj);
            }
            EQ();
        }
        j6(i, i2, i, i2);
        ei();
    }

    public void j6(int i, int i2, char[] cArr, Object obj) {
        this.Hw = true;
        synchronized (this) {
            ((u) this.FH.elementAt(i2)).DW(cArr, i);
            if (this.Zo != null) {
                this.Zo.j6(i2, i, i2, (cArr.length + i) - 1, this, obj);
            }
            EQ();
        }
        j6(i, i2, (cArr.length + i) - 1, i2);
        ei();
    }

    public void j6(Reader reader, Object obj) {
        lg();
        int FH = FH() - 1;
        int Hw = Hw(FH) - 1;
        if (!(Hw == -1 && FH == 0)) {
            j6(new qt(0, 0, FH, Hw), (Object) this);
        }
        char[] cArr = new char[32768];
        c cVar = new c(this, 0, 0, false, 0);
        IOException iOException = null;
        synchronized (this) {
            try {
                v.j6(reader, cVar, cArr);
            } catch (IOException e) {
                iOException = e;
            }
            try {
                reader.close();
            } catch (IOException e2) {
                if (iOException == null) {
                    iOException = e2;
                }
            }
            if (cVar.DW == 0 && cVar.j6 == 0 && iOException != null) {
                throw iOException;
            }
            if (this.Zo != null) {
                this.Zo.j6(0, 0, cVar.DW, cVar.j6 - 1, this, obj);
            }
            EQ();
        }
        j6(0, 0, cVar.j6 - 1, cVar.DW);
        if (!(iOException != null || cVar.FH || cVar.DW == 0)) {
            j6(cVar.DW - 1, obj);
        }
        gW();
        if (iOException != null) {
            throw iOException;
        }
    }

    public qr j6(int i, int i2, Reader reader, Object obj) {
        return j6(i, i2, false, 0, reader, obj);
    }

    public qr j6(int i, int i2, boolean z, int i3, Reader reader, Object obj) {
        if (i2 >= this.FH.size()) {
            throw new InternalError();
        }
        char[] cArr = new char[32768];
        c cVar = new c(this, i, i2, z, i3);
        IOException iOException = null;
        synchronized (this) {
            IOException iOException2;
            try {
                v.j6(reader, cVar, cArr);
            } catch (IOException e) {
                iOException = e;
            }
            try {
                reader.close();
                iOException2 = iOException;
            } catch (IOException e2) {
                if (iOException == null) {
                    iOException2 = e2;
                } else {
                    iOException2 = iOException;
                }
            }
            if (i2 != cVar.DW || i != cVar.j6) {
                if (this.Zo != null) {
                    this.Zo.j6(i2, i, cVar.DW, cVar.j6 - 1, this, obj);
                }
                EQ();
                j6(i, i2, cVar.j6 - 1, cVar.DW);
                ei();
                if (iOException2 == null) {
                    return new qr(cVar.DW, cVar.j6);
                }
                throw iOException2;
            } else if (iOException2 != null) {
                throw iOException2;
            } else {
                qr qrVar = new qr(cVar.DW, cVar.j6);
                return qrVar;
            }
        }
    }

    public void DW(int i, int i2, char c, Object obj) {
        char[] cArr;
        this.Hw = true;
        synchronized (this) {
            u uVar = (u) this.FH.elementAt(i2);
            cArr = i < uVar.FH() ? new char[]{uVar.DW(i)} : new char[0];
            char[] cArr2 = new char[]{c};
            uVar.j6(c, i);
            if (this.Zo != null) {
                this.Zo.j6(i2, i, cArr, cArr2, this, obj);
            }
            EQ();
        }
        FH(i2, i2 + 1);
        j6(i, i2, 1, cArr);
        ei();
    }

    public void j6(int i, int i2, Object obj) {
        this.Hw = true;
        synchronized (this) {
            u uVar = (u) this.FH.elementAt(i2);
            if (this.Zo != null) {
                this.Zo.DW(i2, i, uVar.DW(i), this, obj);
            }
            uVar.FH(i);
            EQ();
        }
        FH(i2, i2 + 1);
        DW(i, i2, i, i2);
        ei();
    }

    public void j6(int i, int i2, int i3, Object obj) {
        if (i3 > 0) {
            this.Hw = true;
            synchronized (this) {
                u uVar = (u) this.FH.elementAt(i2);
                if (this.Zo != null) {
                    this.Zo.DW(i2, i, i2, (i + i3) - 1, this, obj);
                }
                uVar.j6(i3, i);
                EQ();
            }
            FH(i2, i2 + 1);
            DW(i, i2, (i + i3) - 1, i2);
            ei();
        }
    }

    private void we() {
        for (q j6 : this.gn) {
            j6.j6(this);
        }
    }

    private void FH(int i, int i2) {
        for (q j6 : this.gn) {
            j6.j6(this, i, i2);
        }
    }

    public void j6(qt qtVar, Object obj) {
        int j6 = qtVar.j6();
        int DW = qtVar.DW();
        int FH = qtVar.FH();
        int Hw = qtVar.Hw();
        if (j6 <= FH) {
            if (j6 != FH || Hw >= DW) {
                if (FH >= FH()) {
                    FH = FH() - 1;
                    Hw = Hw(FH) - 1;
                } else if (Hw >= Hw(FH)) {
                    Hw = Hw(FH) - 1;
                }
                this.Hw = true;
                synchronized (this) {
                    if (this.Zo != null) {
                        this.Zo.DW(j6, DW, FH, Hw, this, obj);
                    }
                    if (j6 == FH) {
                        ((u) this.FH.elementAt(j6)).j6((Hw - DW) + 1, DW);
                    } else {
                        ((u) this.FH.elementAt(j6)).j6(((u) this.FH.elementAt(j6)).FH() - DW, DW);
                        for (int i = FH - 1; i > j6; i--) {
                            this.FH.removeElementAt(i);
                        }
                        ((u) this.FH.elementAt(j6 + 1)).j6(Hw + 1, 0);
                        ((u) this.FH.elementAt(j6)).j6(((u) this.FH.elementAt(j6 + 1)).DW());
                        this.FH.removeElementAt(j6 + 1);
                    }
                    EQ();
                }
                DW(qtVar.DW(), qtVar.j6(), qtVar.Hw(), qtVar.FH());
                ei();
            }
        }
    }

    public void DW(int i, int i2, Object obj) {
        this.Hw = true;
        synchronized (this) {
            u uVar = (u) this.FH.elementAt(i2);
            this.FH.insertElementAt(tp(), i2 + 1);
            char[] cArr = new char[(uVar.FH() - i)];
            uVar.j6(i, uVar.FH() - i, cArr, 0);
            ((u) this.FH.elementAt(i2 + 1)).j6(cArr);
            uVar.j6(uVar.FH() - i, i);
            if (this.Zo != null) {
                this.Zo.j6(i2, i, this, obj);
            }
            EQ();
        }
        we();
        j6(i, i2, -1, i2 + 1);
        ei();
    }

    public void j6(int i, Object obj) {
        int FH;
        synchronized (this) {
            u uVar = (u) this.FH.elementAt(i);
            FH = uVar.FH();
            uVar.j6(((u) this.FH.elementAt(i + 1)).DW());
            this.FH.removeElementAt(i + 1);
            if (this.Zo != null) {
                this.Zo.DW(i, FH, this, obj);
            }
            EQ();
        }
        we();
        DW(FH, i, -1, i + 1);
        ei();
    }

    public boolean er() {
        return true;
    }

    public boolean yS() {
        if (this.Zo == null) {
            return this.Hw;
        }
        return !this.Zo.j6();
    }

    public void gW() {
        this.Hw = false;
        if (this.Zo != null) {
            this.Zo.DW();
        }
        ei();
    }

    public qr j6(Object obj) {
        if (this.Zo == null) {
            return null;
        }
        j6(this.Zo.Hw());
        qr j6 = this.Zo.j6(this, obj);
        VH();
        return j6;
    }

    public qr BT() {
        if (this.Zo == null) {
            return null;
        }
        gn();
        qr j6 = this.Zo.j6(this);
        u7();
        return j6;
    }

    public boolean vy() {
        return this.Zo != null && this.Zo.v5();
    }

    public boolean P8() {
        return this.Zo != null && this.Zo.Zo();
    }

    public void j6(f fVar) {
        this.j6.addElement(fVar);
    }

    public void j6(d dVar) {
        if (!this.DW.contains(dVar)) {
            this.DW.addElement(dVar);
        }
    }

    void FH(boolean z) {
        Enumeration elements = this.j6.elements();
        while (elements.hasMoreElements()) {
            ((f) elements.nextElement()).DW(this, z);
        }
    }

    void Hw(boolean z) {
        Enumeration elements = this.j6.elements();
        while (elements.hasMoreElements()) {
            ((f) elements.nextElement()).j6(this, z);
        }
    }

    private void ei() {
        if (this.v5 != yS()) {
            Enumeration elements = this.DW.elements();
            while (elements.hasMoreElements()) {
                d dVar = (d) elements.nextElement();
                boolean yS = yS();
                this.v5 = yS;
                dVar.j6(this, yS);
            }
        }
    }

    public Reader DW(int i, int i2, int i3, int i4, boolean z) {
        return super.j6(i, i2, i3, i4, z, this.J0);
    }

    public Reader DW(qt qtVar) {
        return super.DW(qtVar, this.J0);
    }
}
