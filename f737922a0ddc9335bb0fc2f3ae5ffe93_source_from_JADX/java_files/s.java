public class s<E> implements Cloneable {
    private static final Object j6;
    private boolean DW;
    private int[] FH;
    private Object[] Hw;
    private int v5;

    public /* synthetic */ Object clone() {
        return j6();
    }

    static {
        j6 = new Object();
    }

    public s() {
        this(10);
    }

    public s(int i) {
        this.DW = false;
        if (i == 0) {
            this.FH = m.j6;
            this.Hw = m.FH;
        } else {
            int j6 = m.j6(i);
            this.FH = new int[j6];
            this.Hw = new Object[j6];
        }
        this.v5 = 0;
    }

    public s<E> j6() {
        try {
            s<E> sVar = (s) super.clone();
            try {
                sVar.FH = (int[]) this.FH.clone();
                sVar.Hw = (Object[]) this.Hw.clone();
                return sVar;
            } catch (CloneNotSupportedException e) {
                return sVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E j6(int i) {
        return j6(i, null);
    }

    public E j6(int i, E e) {
        int j6 = m.j6(this.FH, this.v5, i);
        return (j6 < 0 || this.Hw[j6] == j6) ? e : this.Hw[j6];
    }

    public void DW(int i) {
        int j6 = m.j6(this.FH, this.v5, i);
        if (j6 >= 0 && this.Hw[j6] != j6) {
            this.Hw[j6] = j6;
            this.DW = true;
        }
    }

    public void FH(int i) {
        DW(i);
    }

    private void Hw() {
        int i = this.v5;
        int[] iArr = this.FH;
        Object[] objArr = this.Hw;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != j6) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.DW = false;
        this.v5 = i2;
    }

    public void DW(int i, E e) {
        int j6 = m.j6(this.FH, this.v5, i);
        if (j6 >= 0) {
            this.Hw[j6] = e;
            return;
        }
        j6 ^= -1;
        if (j6 >= this.v5 || this.Hw[j6] != j6) {
            if (this.DW && this.v5 >= this.FH.length) {
                Hw();
                j6 = m.j6(this.FH, this.v5, i) ^ -1;
            }
            if (this.v5 >= this.FH.length) {
                int j62 = m.j6(this.v5 + 1);
                Object obj = new int[j62];
                Object obj2 = new Object[j62];
                System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
                System.arraycopy(this.Hw, 0, obj2, 0, this.Hw.length);
                this.FH = obj;
                this.Hw = obj2;
            }
            if (this.v5 - j6 != 0) {
                System.arraycopy(this.FH, j6, this.FH, j6 + 1, this.v5 - j6);
                System.arraycopy(this.Hw, j6, this.Hw, j6 + 1, this.v5 - j6);
            }
            this.FH[j6] = i;
            this.Hw[j6] = e;
            this.v5++;
            return;
        }
        this.FH[j6] = i;
        this.Hw[j6] = e;
    }

    public int DW() {
        if (this.DW) {
            Hw();
        }
        return this.v5;
    }

    public int Hw(int i) {
        if (this.DW) {
            Hw();
        }
        return this.FH[i];
    }

    public E v5(int i) {
        if (this.DW) {
            Hw();
        }
        return this.Hw[i];
    }

    public void FH() {
        int i = this.v5;
        Object[] objArr = this.Hw;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.v5 = 0;
        this.DW = false;
    }

    public String toString() {
        if (DW() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.v5 * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.v5; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(Hw(i));
            stringBuilder.append('=');
            s v5 = v5(i);
            if (v5 != this) {
                stringBuilder.append(v5);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
