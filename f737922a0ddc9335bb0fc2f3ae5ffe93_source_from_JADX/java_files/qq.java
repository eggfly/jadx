import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

public class qq<T> implements Serializable {
    private boolean DW;
    private Vector<qq$b<T>> j6;

    public qq() {
        this.DW = false;
        DW();
    }

    public qr j6() {
        return j6(0, -1);
    }

    public qr j6(int i, int i2) {
        int i3 = i;
        while (i3 < this.j6.size()) {
            qq$b qq_b = (qq$b) this.j6.elementAt(i3);
            if (qq_b != null) {
                qq$a j6 = qq_b.j6;
                int i4 = -1;
                while (j6 != null) {
                    if ((i3 != i || j6.j6 > r9) && ((i4 == -1 || i4 > j6.j6) && !(j6.j6 == 0 && i3 != 0 && DW(j6.FH, i3 - 1, Integer.MAX_VALUE)))) {
                        i4 = j6.j6;
                    }
                    j6 = j6.Hw;
                }
                if (i4 != -1) {
                    return new qr(i3, i4);
                }
            }
            i2 = -1;
            i3++;
        }
        throw new qo();
    }

    public qr j6(qr qrVar) {
        return j6(qrVar.j6(), qrVar.DW());
    }

    public final void j6(T t, int i, int i2) {
        j6((Object) t, i, i2, i, i2);
    }

    public final void j6(T t, int i, int i2, int i3, int i4) {
        int i5;
        if (i < 0) {
            i5 = 0;
        } else {
            i5 = i;
        }
        if (i5 <= i3) {
            if (this.j6.size() <= i3) {
                this.j6.setSize(i3 + 1);
            }
            if (i5 == i3) {
                j6((Object) t, i5, i2, i4, false);
                DW(i5);
                return;
            }
            j6((Object) t, i5, i2, Integer.MAX_VALUE, false);
            DW(i5);
            for (i5++; i5 < i3; i5++) {
                j6((Object) t, i5, 0, Integer.MAX_VALUE, false);
                DW(i5);
            }
            j6((Object) t, i3, 0, i4, false);
            DW(i3);
        }
    }

    public final Enumeration<T> DW(int i, int i2) {
        if (i < 0) {
            return new qq$c(null, i2);
        }
        if (i >= this.j6.size()) {
            return new qq$c(null, i2);
        }
        qq$b qq_b = (qq$b) this.j6.elementAt(i);
        if (qq_b == null) {
            return new qq$c(null, i2);
        }
        return new qq$c(qq_b.j6, i2);
    }

    public final boolean FH(int i, int i2) {
        if (i < 0) {
            return false;
        }
        if (i >= this.j6.size()) {
            return false;
        }
        qq$b qq_b = (qq$b) this.j6.elementAt(i);
        if (qq_b == null) {
            return false;
        }
        qq$a j6 = qq_b.j6;
        while (j6 != null) {
            if (j6.j6 <= i2 && i2 <= j6.DW) {
                return true;
            }
            j6 = j6.Hw;
        }
        return false;
    }

    public final boolean DW(Object obj, int i, int i2) {
        if (i < 0) {
            return false;
        }
        if (i >= this.j6.size()) {
            return false;
        }
        qq$b qq_b = (qq$b) this.j6.elementAt(i);
        if (qq_b == null) {
            return false;
        }
        qq$a j6 = qq_b.j6;
        while (j6 != null) {
            if (j6.j6 <= i2 && i2 <= j6.DW && j6.FH.equals(obj)) {
                return true;
            }
            j6 = j6.Hw;
        }
        return false;
    }

    public final boolean j6(int i) {
        if (i < 0) {
            return false;
        }
        if (i >= this.j6.size()) {
            return false;
        }
        qq$b qq_b = (qq$b) this.j6.elementAt(i);
        if (qq_b == null) {
            return false;
        }
        if (qq_b.j6 == null) {
            return false;
        }
        return true;
    }

    public final void DW() {
        this.j6 = new Vector();
        this.j6.setSize(1);
    }

    public final void j6(int i, int i2, int i3, int i4) {
        if (i > i3 || i3 < 0) {
            return;
        }
        if (i != i3 || i2 <= i4) {
            if (i < 0) {
                i2 = 0;
                i = 0;
            }
            if (i3 >= this.j6.size()) {
                i3 = this.j6.size() - 1;
                if (i <= i3) {
                    i4 = Integer.MAX_VALUE;
                } else {
                    return;
                }
            }
            if (i == i3) {
                FH(i, i2, i4);
                return;
            }
            FH(i, i2, Integer.MAX_VALUE);
            for (int i5 = i + 1; i5 < i3; i5++) {
                FH(i5, 0, Integer.MAX_VALUE);
            }
            FH(i3, 0, i4);
        }
    }

    public final void Hw(int i, int i2) {
        if (i2 >= 0 && i >= 0 && i < this.j6.size() - 1) {
            qq$b qq_b = (qq$b) this.j6.elementAt(i);
            if (qq_b == null) {
                this.j6.removeElementAt(i);
                qq_b = (qq$b) this.j6.elementAt(i);
                if (qq_b != null) {
                    for (qq$a j6 = qq_b.j6; j6 != null; j6 = j6.Hw) {
                        if (j6.j6 > (Integer.MAX_VALUE - i2) + 0) {
                            j6.j6 = Integer.MAX_VALUE;
                        } else {
                            j6.j6 = (j6.j6 + 0) + i2;
                        }
                        if (j6.DW > (Integer.MAX_VALUE - i2) + 0) {
                            j6.DW = Integer.MAX_VALUE;
                        } else {
                            j6.DW = (j6.DW + 0) + i2;
                        }
                    }
                    return;
                }
                return;
            }
            qq$b qq_b2 = (qq$b) this.j6.elementAt(i + 1);
            this.j6.removeElementAt(i + 1);
            if (qq_b2 != null) {
                qq$a qq_a = null;
                for (qq$a j62 = qq_b.j6; j62 != null; j62 = j62.Hw) {
                    if (j62.j6 >= i2 || i2 == 0) {
                        if (qq_a == null) {
                            qq_b.j6 = j62.Hw;
                        } else {
                            qq_a.Hw = j62.Hw;
                        }
                    } else if (j62.DW >= i2) {
                        j62.DW = i2 - 1;
                        qq_a = j62;
                    } else {
                        qq_a = j62;
                    }
                }
                for (qq$a j63 = qq_b2.j6; j63 != null; j63 = j63.Hw) {
                    int i3;
                    int i4;
                    if (j63.j6 > (Integer.MAX_VALUE - i2) + 0) {
                        i3 = Integer.MAX_VALUE;
                    } else {
                        i3 = (j63.j6 + 0) + i2;
                    }
                    if (j63.DW > (Integer.MAX_VALUE - i2) + 0) {
                        i4 = Integer.MAX_VALUE;
                    } else {
                        i4 = (j63.DW + 0) + i2;
                    }
                    j6(j63.FH, i, i3, i4, true);
                }
                DW(i);
            }
        }
    }

    public final void j6(int i, int i2, int i3) {
        if (i >= 0 && i < this.j6.size()) {
            qq$b qq_b = (qq$b) this.j6.elementAt(i);
            if (qq_b != null) {
                qq$a j6 = qq_b.j6;
                while (j6 != null) {
                    if (i2 <= j6.j6 || j6.DW < i2) {
                        if (i2 == j6.j6 && (this.DW || (i2 == 0 && DW(j6.FH, i - 1, Integer.MAX_VALUE)))) {
                            if (j6.DW > Integer.MAX_VALUE - i3) {
                                j6.DW = Integer.MAX_VALUE;
                            } else {
                                j6.DW = j6.DW + i3;
                            }
                        } else if (i2 <= j6.j6) {
                            if (j6.j6 > Integer.MAX_VALUE - i3) {
                                j6.j6 = Integer.MAX_VALUE;
                            } else {
                                j6.j6 = j6.j6 + i3;
                            }
                            if (j6.DW > Integer.MAX_VALUE - i3) {
                                j6.DW = Integer.MAX_VALUE;
                            } else {
                                j6.DW = j6.DW + i3;
                            }
                        }
                    } else if (j6.DW > Integer.MAX_VALUE - i3) {
                        j6.DW = Integer.MAX_VALUE;
                    } else {
                        j6.DW = j6.DW + i3;
                    }
                    j6 = j6.Hw;
                }
            }
        }
    }

    private void v5(int i, int i2) {
        if (i < 0 || i >= this.j6.size()) {
            return;
        }
        if (i2 <= 0) {
            this.j6.setElementAt(null, i);
            return;
        }
        qq$b qq_b = (qq$b) this.j6.elementAt(i);
        if (qq_b != null) {
            qq$a j6 = qq_b.j6;
            qq$a qq_a = null;
            while (j6 != null) {
                if (i2 <= j6.j6) {
                    if (qq_a == null) {
                        qq_b.j6 = j6.Hw;
                    } else {
                        qq_a.Hw = j6.Hw;
                    }
                } else if (i2 <= j6.j6 || j6.DW < i2) {
                    qq_a = j6;
                } else {
                    if (j6.DW != Integer.MAX_VALUE) {
                        j6.DW = i2 - 1;
                    }
                    qq_a = j6;
                }
                j6 = j6.Hw;
            }
            if (qq_b.j6 == null) {
                this.j6.setElementAt(null, i);
            }
        }
    }

    public final void DW(int i, int i2, int i3) {
        if (i >= 0 && i < this.j6.size()) {
            qq$b qq_b = (qq$b) this.j6.elementAt(i);
            if (qq_b != null) {
                int i4 = (i2 + i3) - 1;
                qq$a j6 = qq_b.j6;
                qq$a qq_a = null;
                while (j6 != null) {
                    if (i2 < j6.j6 && i4 < j6.j6) {
                        if (j6.DW != Integer.MAX_VALUE) {
                            j6.DW = j6.DW - i3;
                        }
                        j6.j6 = j6.j6 - i3;
                        qq_a = j6;
                    } else if (i2 > j6.j6 || j6.DW > i4) {
                        if (i2 > j6.j6 && j6.DW > i4) {
                            if (j6.DW != Integer.MAX_VALUE) {
                                j6.DW = j6.DW - i3;
                            }
                            qq_a = j6;
                        } else if (i2 <= j6.j6 && j6.j6 <= i4) {
                            j6.j6 = i2;
                            if (j6.DW != Integer.MAX_VALUE) {
                                j6.DW = j6.DW - i3;
                            }
                            qq_a = j6;
                        } else if (i2 > j6.DW || j6.DW > i4) {
                            qq_a = j6;
                        } else {
                            if (j6.DW != Integer.MAX_VALUE) {
                                j6.DW = i2 - 1;
                            }
                            qq_a = j6;
                        }
                    } else if (qq_a == null) {
                        qq_b.j6 = j6.Hw;
                    } else {
                        qq_a.Hw = j6.Hw;
                    }
                    j6 = j6.Hw;
                }
                if (qq_b.j6 == null) {
                    this.j6.setElementAt(null, i);
                }
            }
        }
    }

    public final void DW(int i, int i2, int i3, int i4) {
        if (i == i3) {
            j6(i, i2, (i4 - i2) + 1);
            return;
        }
        int i5;
        qq$a j6;
        qq$b qq_b;
        if (i + 1 <= this.j6.size()) {
            for (i5 = i + 1; i5 <= i3; i5++) {
                this.j6.insertElementAt(null, i + 1);
            }
        }
        qq$b qq_b2 = null;
        if (i3 < this.j6.size()) {
            qq_b2 = (qq$b) this.j6.elementAt(i3);
        }
        if (qq_b2 != null) {
            j6 = qq_b2.j6;
            if (i4 + 1 > 0) {
                i5 = i4;
                for (qq$a qq_a = j6; qq_a != null; qq_a = qq_a.Hw) {
                    i2 += i5 + 1;
                    if (i5 != Integer.MAX_VALUE) {
                        i5 += i5 + 1;
                    }
                }
                i4 = i5;
            }
        }
        if (i < this.j6.size()) {
            qq_b = (qq$b) this.j6.elementAt(i);
        } else {
            qq_b = null;
        }
        if (qq_b != null) {
            qq$a j62 = qq_b.j6;
            qq$a qq_a2 = null;
            while (j62 != null) {
                if (j62.j6 >= i2 || i2 > j62.DW) {
                    if (j62.j6 >= i2) {
                        if (j62.DW == Integer.MAX_VALUE) {
                            j6(j62.FH, i3, ((i4 + 1) + j62.j6) - i2, Integer.MAX_VALUE, false);
                        } else {
                            j6(j62.FH, i3, ((i4 + 1) + j62.j6) - i2, ((((i4 + 1) + j62.j6) - i2) + j62.DW) - j62.j6, false);
                        }
                        if (qq_a2 == null) {
                            qq_b.j6 = j62.Hw;
                            j6 = qq_a2;
                        } else {
                            qq_a2.Hw = j62.Hw;
                        }
                    }
                    j6 = qq_a2;
                } else {
                    for (int i6 = i + 1; i6 < i3; i6++) {
                        j6(j62.FH, i6, 0, Integer.MAX_VALUE, false);
                    }
                    if (j62.DW == Integer.MAX_VALUE) {
                        j6(j62.FH, i3, 0, Integer.MAX_VALUE, false);
                    } else {
                        j6(j62.FH, i3, 0, (((j62.DW + 0) - i2) + 1) + i4, false);
                    }
                    j62.DW = Integer.MAX_VALUE;
                    j6 = j62;
                }
                j62 = j62.Hw;
                qq_a2 = j6;
            }
            if (qq_b.j6 == null) {
                this.j6.setElementAt(null, i);
            }
        }
    }

    public final void FH(int i, int i2, int i3, int i4) {
        if (i == i3) {
            DW(i, i2, (i4 - i2) + 1);
            return;
        }
        for (int i5 = i + 1; i5 < i3; i5++) {
            if (i + 1 < this.j6.size()) {
                this.j6.removeElementAt(i + 1);
            }
        }
        v5(i, i2);
        if (i4 >= 0) {
            DW(i + 1, 0, (i4 + 0) + 1);
        }
        Hw(i, i2);
    }

    public String toString() {
        int i = 0;
        String str = "{\n";
        while (i < this.j6.size()) {
            String str2 = str + i + ": ";
            qq$b qq_b = (qq$b) this.j6.elementAt(i);
            if (qq_b != null) {
                qq$a j6 = qq_b.j6;
                str = str2;
                qq$a qq_a = j6;
                while (qq_a != null) {
                    String str3 = str + "(" + qq_a.j6 + "|" + qq_a.DW + "), ";
                    qq_a = qq_a.Hw;
                    str = str3;
                }
            } else {
                str = str2;
            }
            i++;
            str = str + "\n";
        }
        return str + "}";
    }

    private void FH(int i, int i2, int i3) {
        qq$b qq_b = (qq$b) this.j6.elementAt(i);
        if (qq_b != null) {
            qq$a j6 = qq_b.j6;
            qq$a qq_a = null;
            while (j6 != null) {
                if (i2 > j6.j6 || j6.DW > i3) {
                    if (i2 > j6.j6 && j6.DW > i3) {
                        qq$a qq_a2 = new qq$a();
                        if (qq_a == null) {
                            qq_b.j6 = qq_a2;
                        } else {
                            qq_a.Hw = qq_a2;
                        }
                        qq_a2.Hw = j6;
                        qq_a2.FH = j6.FH;
                        qq_a2.j6 = j6.j6;
                        qq_a2.DW = i2 - 1;
                        j6.j6 = i3 + 1;
                        qq_a = j6;
                    } else if (i2 <= j6.j6 && j6.j6 <= i3) {
                        j6.j6 = i3 + 1;
                        qq_a = j6;
                    } else if (i2 > j6.DW || j6.DW > i3) {
                        qq_a = j6;
                    } else {
                        j6.DW = i2 - 1;
                        qq_a = j6;
                    }
                } else if (qq_a == null) {
                    qq_b.j6 = j6.Hw;
                } else {
                    qq_a.Hw = j6.Hw;
                }
                j6 = j6.Hw;
            }
            if (qq_b.j6 == null) {
                this.j6.setElementAt(null, i);
            }
        }
    }

    private void j6(T t, int i, int i2, int i3, boolean z) {
        qq$b qq_b;
        if (this.j6.size() <= i) {
            this.j6.setSize(i + 1);
        }
        qq$b qq_b2 = (qq$b) this.j6.elementAt(i);
        if (qq_b2 == null) {
            Vector vector = this.j6;
            qq_b2 = new qq$b();
            vector.setElementAt(qq_b2, i);
            qq_b = qq_b2;
        } else {
            qq_b = qq_b2;
        }
        qq$a j6;
        if (z) {
            qq$a qq_a = null;
            for (j6 = qq_b.j6; j6 != null; j6 = j6.Hw) {
                qq_a = j6;
            }
            j6 = new qq$a();
            j6.j6 = i2;
            j6.DW = i3;
            j6.FH = t;
            if (qq_a == null) {
                qq_b.j6 = j6;
            } else {
                qq_a.Hw = j6;
            }
            j6.Hw = null;
            return;
        }
        j6 = new qq$a();
        j6.j6 = i2;
        j6.DW = i3;
        j6.FH = t;
        j6.Hw = qq_b.j6;
        qq_b.j6 = j6;
    }

    private void DW(int i) {
        if (this.j6.size() > i) {
            qq$b qq_b = (qq$b) this.j6.elementAt(i);
            if (qq_b != null) {
                qq$b qq_b2 = new qq$b();
                qq$a j6 = qq_b.j6;
                qq$a qq_a = null;
                while (j6 != null) {
                    if (j6.DW >= 0) {
                        qq$a FH = j6.Hw;
                        while (FH != null) {
                            if (j6.FH.equals(FH.FH)) {
                                if (FH.j6 < j6.j6 || j6.DW < FH.DW) {
                                    if (FH.j6 > j6.j6 || j6.DW > FH.DW) {
                                        if (FH.j6 > j6.j6 || j6.j6 > FH.DW) {
                                            if (FH.j6 <= j6.DW && j6.DW <= FH.DW) {
                                                j6.DW = FH.DW;
                                                FH.DW = -1;
                                                break;
                                            } else if (j6.DW == FH.j6 - 1) {
                                                j6.DW = FH.DW;
                                                FH.DW = -1;
                                                break;
                                            } else if (j6.j6 == FH.DW + 1) {
                                                j6.j6 = FH.j6;
                                                FH.DW = -1;
                                                break;
                                            }
                                        } else {
                                            j6.j6 = FH.j6;
                                            FH.DW = -1;
                                            break;
                                        }
                                    }
                                    j6.j6 = FH.j6;
                                    j6.DW = FH.DW;
                                    FH.DW = -1;
                                    break;
                                }
                                FH.DW = -1;
                                break;
                            }
                            FH = FH.Hw;
                        }
                        FH = j6.Hw;
                        if (qq_a == null) {
                            qq_b2.j6 = j6;
                        } else {
                            qq_a.Hw = j6;
                        }
                        j6.Hw = null;
                        qq_a = j6;
                        j6 = FH;
                    } else {
                        j6 = j6.Hw;
                    }
                }
                this.j6.setElementAt(qq_b2, i);
            }
        }
    }
}
