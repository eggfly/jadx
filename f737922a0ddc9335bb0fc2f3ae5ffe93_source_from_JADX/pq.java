import com.aide.common.m;
import com.aide.engine.Modification;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.util.List;

public class pq {
    public void j6() {
        e.XL().j6(new pq$1(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(java.util.List<com.aide.engine.Modification> r7) {
        /*
        r6 = this;
        r0 = com.aide.ui.e.u7();
        r0.J0();
        if (r7 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r2 = new java.util.HashSet;
        r2.<init>();
        r0 = 0;
        r3 = r7.iterator();
        r1 = r0;
    L_0x0015:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0047;
    L_0x001b:
        r0 = r3.next();
        r0 = (com.aide.engine.Modification) r0;
        r4 = r0.FH();
        switch(r4) {
            case 0: goto L_0x002b;
            case 3: goto L_0x002b;
            case 7: goto L_0x002b;
            case 11: goto L_0x002b;
            case 12: goto L_0x002b;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r1 = r0;
        goto L_0x0015;
    L_0x002b:
        r4 = r0.Hw();
        r2.add(r4);
        r0 = r0.Hw();
        r4 = com.aide.ui.e.j3();
        r4 = r4.Hw();
        r0 = r0.equals(r4);
        if (r0 != 0) goto L_0x0028;
    L_0x0044:
        r1 = 1;
        r0 = r1;
        goto L_0x0029;
    L_0x0047:
        if (r1 != 0) goto L_0x004d;
    L_0x0049:
        r6.DW(r7);
        goto L_0x0009;
    L_0x004d:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r1 = r2.iterator();
    L_0x0056:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x006a;
    L_0x005c:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r0 = qh.Zo(r0);
        r3.add(r0);
        goto L_0x0056;
    L_0x006a:
        r0 = com.aide.ui.e.u7();
        r1 = 2131165604; // 0x7f0701a4 float:1.794543E38 double:1.0529357105E-314;
        r2 = 2131165603; // 0x7f0701a3 float:1.7945428E38 double:1.05293571E-314;
        r4 = new pq$2;
        r4.<init>(r6, r7);
        r5 = 0;
        com.aide.common.m.j6(r0, r1, r2, r3, r4, r5);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.j6(java.util.List):void");
    }

    private void DW(List<Modification> list) {
        e.XL().gn();
        int i = 0;
        Object obj = null;
        while (i < list.size()) {
            Object obj2;
            Modification modification = (Modification) list.get(i);
            switch (modification.FH()) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    try {
                        e.j3().FH(modification.Hw()).j6(modification.Zo(), modification.VH(), modification.gn(), modification.u7(), modification.v5(), modification.DW(), modification.Hw().equals(e.j3().Hw()));
                        obj2 = obj;
                        break;
                    } catch (Throwable e) {
                        m.j6(e.u7(), "Modify Files", e);
                        obj2 = obj;
                        break;
                    }
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    try {
                        String Hw = modification.Hw();
                        String str = qh.v5(Hw) + File.separator + modification.v5();
                        qh.Hw(Hw, str);
                        e.j3().j6(Hw, str);
                        e.nw().v5(qh.v5(Hw));
                        obj2 = 1;
                        break;
                    } catch (Throwable e2) {
                        m.j6(e.u7(), "Modify Files", e2);
                        obj2 = obj;
                        break;
                    }
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    e.XL().u7();
                    List j6 = e.XL().j6(modification.Hw(), modification.Zo(), modification.gn(), h.J0());
                    if (j6 != null) {
                        for (int size = j6.size() - 1; size >= 0; size--) {
                            list.add(i + 1, (Modification) j6.get(size));
                        }
                    }
                    e.XL().gn();
                    obj2 = obj;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    try {
                        e.j3().FH(modification.Hw()).j6(modification.Zo(), modification.VH(), modification.gn(), modification.u7(), modification.tp(), modification.EQ());
                        obj2 = obj;
                        break;
                    } catch (Throwable e22) {
                        m.j6(e.u7(), "Modify Files", e22);
                        obj2 = obj;
                        break;
                    }
                case 7:
                    try {
                        e.j3().FH(modification.Hw()).DW(modification.Zo(), modification.VH(), modification.gn(), modification.u7(), modification.tp(), modification.EQ());
                        obj2 = obj;
                        break;
                    } catch (Throwable e222) {
                        m.j6(e.u7(), "Modify Files", e222);
                        obj2 = obj;
                        break;
                    }
                case 8:
                    e.u7().j6(new qg(modification.Hw(), modification.Zo(), modification.VH(), modification.gn(), modification.u7()), false);
                    obj2 = obj;
                    break;
                case 11:
                    try {
                        e.j3().FH(modification.Hw()).b_(modification.Zo(), modification.j6());
                        obj2 = obj;
                        break;
                    } catch (Throwable e2222) {
                        m.j6(e.u7(), "Modify Files", e2222);
                        obj2 = obj;
                        break;
                    }
                case 12:
                    try {
                        qh.Mr(qh.v5(modification.Hw()));
                        qh.v5(modification.Hw(), modification.v5());
                        e.j3().FH(modification.Hw());
                        obj2 = obj;
                        break;
                    } catch (Throwable e22222) {
                        m.j6(e.u7(), "Modify Files", e22222);
                        obj2 = obj;
                        break;
                    } catch (Throwable e222222) {
                        try {
                            com.aide.common.e.DW(e222222);
                            return;
                        } finally {
                            e.XL().u7();
                        }
                    }
                default:
                    obj2 = obj;
                    break;
            }
            i++;
            obj = obj2;
        }
        try {
            e.j3().FH();
        } catch (Throwable e2222222) {
            m.j6(e.u7(), "Modify Files", e2222222);
        }
        if (obj != null) {
            e.a8().j3();
            e.er().FH();
        }
        e.XL().VH();
        e.XL().u7();
    }
}
