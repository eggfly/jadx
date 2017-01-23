import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class un$c {
    private int DW;
    private zy FH;
    private int[] Hw;
    private final ArrayList<un$b> j6;
    private int v5;

    public un$c(int i) {
        this.j6 = new ArrayList(i);
        this.DW = 0;
        this.FH = null;
        this.Hw = null;
        this.v5 = 0;
    }

    private void j6(int i, int i2) {
        int i3 = this.Hw == null ? 1 : 0;
        if (i != this.v5 || i3 != 0) {
            if (i < this.v5) {
                throw new RuntimeException("shouldn't happen");
            } else if (i3 != 0 || i2 >= this.Hw.length) {
                int i4 = i2 + 1;
                zy zyVar = new zy(i4);
                Object obj = new int[i4];
                Arrays.fill(obj, -1);
                if (i3 == 0) {
                    zyVar.j6(this.FH);
                    System.arraycopy(this.Hw, 0, obj, 0, this.Hw.length);
                }
                this.FH = zyVar;
                this.Hw = obj;
            }
        }
    }

    public void j6(int i, zy zyVar) {
        int DW = zyVar.DW();
        j6(i, DW - 1);
        for (int i2 = 0; i2 < DW; i2++) {
            zw j6 = this.FH.j6(i2);
            zw j62 = j6(zyVar.j6(i2));
            if (j6 == null) {
                if (j62 != null) {
                    j6(i, j62);
                }
            } else if (j62 == null) {
                DW(i, j6);
            } else if (!j62.j6(j6)) {
                DW(i, j6);
                j6(i, j62);
            }
        }
    }

    public void j6(int i, zw zwVar) {
        int VH = zwVar.VH();
        zw j6 = j6(zwVar);
        j6(i, VH);
        zw j62 = this.FH.j6(VH);
        if (!j6.j6(j62)) {
            zw DW = this.FH.DW(j6);
            if (DW != null) {
                DW(i, un$a.END_MOVED, DW);
            }
            int i2 = this.Hw[VH];
            if (j62 != null) {
                j6(i, un$a.END_REPLACED, j62);
            } else if (i2 >= 0) {
                un$b un_b = (un$b) this.j6.get(i2);
                if (un_b.j6() == i) {
                    if (un_b.j6(j6)) {
                        this.j6.set(i2, null);
                        this.DW++;
                        this.FH.Hw(j6);
                        this.Hw[VH] = -1;
                        return;
                    }
                    this.j6.set(i2, un_b.j6(un$a.END_REPLACED));
                }
            }
            if (VH > 0) {
                j62 = this.FH.j6(VH - 1);
                if (j62 != null && j62.we()) {
                    DW(i, un$a.END_CLOBBERED_BY_NEXT, j62);
                }
            }
            if (j6.we()) {
                j62 = this.FH.j6(VH + 1);
                if (j62 != null) {
                    DW(i, un$a.END_CLOBBERED_BY_PREV, j62);
                }
            }
            j6(i, un$a.START, j6);
        }
    }

    public void DW(int i, zw zwVar) {
        j6(i, zwVar, un$a.END_SIMPLY);
    }

    public void j6(int i, zw zwVar, un$a un_a) {
        int VH = zwVar.VH();
        zw j6 = j6(zwVar);
        j6(i, VH);
        if (this.Hw[VH] < 0 && !FH(i, j6)) {
            j6(i, un_a, j6);
        }
    }

    private boolean FH(int i, zw zwVar) {
        un$b un_b;
        Object obj = null;
        int size = this.j6.size() - 1;
        while (size >= 0) {
            un_b = (un$b) this.j6.get(size);
            if (un_b != null) {
                if (un_b.j6() != i) {
                    return false;
                }
                if (un_b.j6(zwVar)) {
                    break;
                }
            }
            size--;
        }
        this.FH.FH(zwVar);
        this.j6.set(size, null);
        this.DW++;
        int VH = zwVar.VH();
        int i2 = size - 1;
        un_b = null;
        while (i2 >= 0) {
            un_b = (un$b) this.j6.get(i2);
            if (un_b != null && un_b.gn().VH() == VH) {
                obj = 1;
                break;
            }
            i2--;
        }
        if (obj != null) {
            this.Hw[VH] = i2;
            if (un_b.j6() == i) {
                this.j6.set(i2, un_b.j6(un$a.END_SIMPLY));
            }
        }
        return true;
    }

    private static zw j6(zw zwVar) {
        if (zwVar == null || zwVar.j6() != abl.tp) {
            return zwVar;
        }
        return zwVar.j6(abl.Ws);
    }

    private void j6(int i, un$a un_a, zw zwVar) {
        int VH = zwVar.VH();
        this.j6.add(new un$b(i, un_a, zwVar));
        if (un_a == un$a.START) {
            this.FH.Hw(zwVar);
            this.Hw[VH] = -1;
            return;
        }
        this.FH.FH(zwVar);
        this.Hw[VH] = this.j6.size() - 1;
    }

    private void DW(int i, un$a un_a, zw zwVar) {
        if (un_a == un$a.START) {
            throw new RuntimeException("shouldn't happen");
        }
        int i2 = this.Hw[zwVar.VH()];
        if (i2 >= 0) {
            un$b un_b = (un$b) this.j6.get(i2);
            if (un_b.j6() == i && un_b.gn().equals(zwVar)) {
                this.j6.set(i2, un_b.j6(un_a));
                this.FH.FH(zwVar);
                return;
            }
        }
        j6(i, zwVar, un_a);
    }

    public un j6() {
        int i = 0;
        j6(Integer.MAX_VALUE, 0);
        int size = this.j6.size();
        int i2 = size - this.DW;
        if (i2 == 0) {
            return un.j6;
        }
        un$b[] un_bArr = new un$b[i2];
        if (size == i2) {
            this.j6.toArray(un_bArr);
        } else {
            Iterator it = this.j6.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                un$b un_b = (un$b) it.next();
                if (un_b != null) {
                    int i4 = i3 + 1;
                    un_bArr[i3] = un_b;
                    size = i4;
                } else {
                    size = i3;
                }
                i3 = size;
            }
        }
        Arrays.sort(un_bArr);
        un unVar = new un(i2);
        while (i < i2) {
            unVar.j6(i, un_bArr[i]);
            i++;
        }
        unVar.l_();
        return unVar;
    }
}
