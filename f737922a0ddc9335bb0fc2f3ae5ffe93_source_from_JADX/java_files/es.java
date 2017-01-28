public abstract class es {
    protected final bu DW;
    protected int[] EQ;
    protected final by FH;
    protected final bt Hw;
    protected int[] J0;
    protected int[] J8;
    private int Mr;
    protected int[] QX;
    protected int VH;
    protected int[] Ws;
    protected int XL;
    protected cj Zo;
    private boolean aM;
    protected int gn;
    private int j3;
    protected final bl j6;
    protected int[] tp;
    protected int u7;
    protected boolean v5;
    protected int[] we;

    protected abstract void Zo();

    public es(by byVar, bu buVar, bt btVar, bl blVar, int i, int i2) {
        this.QX = new int[10000];
        this.DW = buVar;
        this.FH = byVar;
        this.Hw = btVar;
        this.j6 = blVar;
        this.j3 = i;
        this.Mr = i2;
    }

    public void j6(cm cmVar, bv bvVar, boolean z, cj cjVar) {
        try {
            cjVar.j6(cmVar);
            this.tp = cmVar.j6;
            this.EQ = cmVar.DW;
            this.we = cmVar.FH;
            this.J0 = cmVar.Hw;
            this.J8 = cmVar.v5;
            this.Ws = cmVar.Zo;
            this.u7 = cmVar.u7 - 1;
            this.Zo = cjVar;
            this.v5 = z;
            this.aM = true;
            this.XL = -1;
            this.gn = 0;
            this.VH = this.tp[0];
            Zo();
            cjVar.j6(this.QX[0]);
            if (this.XL != 0) {
                throw new RuntimeException("Corrupted syntax tree " + this.XL + "  Bottom-most syntaxtag: " + cjVar.rN(this.QX[1]));
            }
        } catch (es$a e) {
            cjVar.j6(cjVar.j6(this.j3, true, new int[0], 0, 0, 1, 1));
        } finally {
            this.Zo = null;
            this.tp = null;
            this.EQ = null;
            this.we = null;
            this.J0 = null;
            this.J8 = null;
            this.Ws = null;
        }
    }

    protected void j6(String str) {
        if (this.v5) {
            int i;
            int i2;
            int i3;
            if (this.gn > 0) {
                i = this.J0[this.gn - 1];
                i2 = this.Ws[this.gn - 1] - 1;
                i3 = i2 + 2;
            } else {
                i = this.we[this.gn];
                i2 = this.J8[this.gn] - 1;
                i3 = i2 + 2;
            }
            this.DW.Zo(this.Zo.we(), this.Zo.tp(), i, i2, i, i3, str, 0);
        }
    }

    protected void j6(int i) {
        if (this.v5) {
            int i2;
            int i3;
            int i4;
            if (this.gn > 0) {
                i2 = this.J0[this.gn - 1];
                i3 = this.Ws[this.gn - 1] - 1;
                i4 = i3 + 2;
            } else {
                i2 = this.we[this.gn];
                i3 = this.J8[this.gn] - 1;
                i4 = i3 + 2;
            }
            String XL = this.j6.XL(i);
            this.DW.Zo(this.Zo.we(), this.Zo.tp(), i2, i3, i2, i4, "Missing </C>" + XL + "<//C>", 0);
            this.DW.j6(this.Zo.we(), this.Zo.tp(), i2, i3 + 1, i2, i3 + 1, XL, "Insert '" + XL + "'");
        }
    }

    protected void DW(int i) {
        if (this.v5) {
            int i2;
            int i3;
            int i4;
            if (this.gn > 0) {
                i2 = this.J0[this.gn - 1];
                i3 = this.Ws[this.gn - 1] - 1;
                i4 = i3 + 2;
            } else {
                i2 = this.we[this.gn];
                i3 = this.J8[this.gn] - 1;
                i4 = i3 + 2;
            }
            String XL = this.j6.XL(i);
            this.DW.Zo(this.Zo.we(), this.Zo.tp(), i2, i3, i2, i4, "Missing </C>" + XL + "<//C>", 1);
            this.DW.j6(this.Zo.we(), this.Zo.tp(), i2, i3 + 1, i2, i3 + 1, XL, "Insert '" + XL + "'");
        }
    }

    protected void j6() {
        if (this.v5) {
            int i = this.we[this.gn];
            int i2 = this.J8[this.gn];
            int i3 = this.Ws[this.gn];
            String XL = this.j6.XL(this.VH);
            this.DW.Zo(this.Zo.we(), this.Zo.tp(), i, i2, i, i3, "Unexpected </C>" + XL + "<//C>", 0);
        }
    }

    protected void FH(int i) {
        if (this.aM) {
            this.XL++;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL] = this.Zo.j6(i, true, this.we[this.gn], this.J8[this.gn], this.Ws[this.gn]);
        }
    }

    protected void j6(int i, int i2) {
        if (this.aM) {
            this.XL++;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL] = this.Zo.j6(i, true, i2, this.we[this.gn], this.J8[this.gn], this.J0[this.gn], this.Ws[this.gn]);
        }
    }

    protected void Hw(int i) {
        if (this.VH != i) {
            if (this.aM) {
                this.XL++;
                if (this.XL >= this.QX.length) {
                    Object obj = new int[((this.QX.length * 2) + 1)];
                    System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                    this.QX = obj;
                }
                if (this.j6.QX(i)) {
                    this.QX[this.XL] = this.Zo.j6(i, true, this.we[this.gn], this.J8[this.gn], this.J0[this.gn], this.Ws[this.gn]);
                } else {
                    this.QX[this.XL] = this.Zo.j6(i, true, this.we[this.gn], this.J8[this.gn], this.Ws[this.gn]);
                }
            }
            j6(i);
            return;
        }
        if (this.aM) {
            this.XL++;
            if (this.XL >= this.QX.length) {
                obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            if (this.j6.QX(this.VH)) {
                this.QX[this.XL] = this.Zo.j6(this.VH, false, this.we[this.gn], this.J8[this.gn], this.J0[this.gn], this.Ws[this.gn]);
            } else {
                this.QX[this.XL] = this.Zo.j6(this.VH, false, this.we[this.gn], this.J8[this.gn], this.Ws[this.gn]);
            }
        }
        if (this.gn < this.u7) {
            this.gn++;
            this.VH = this.tp[this.gn];
        }
    }

    protected void DW() {
        if (this.aM) {
            this.XL++;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            if (this.j6.J8(this.VH) || this.j6.gn(this.VH)) {
                this.QX[this.XL] = this.Zo.j6(this.VH, false, this.EQ[this.gn], this.we[this.gn], this.J8[this.gn], this.J0[this.gn], this.Ws[this.gn]);
            } else if (this.j6.QX(this.VH)) {
                this.QX[this.XL] = this.Zo.j6(this.VH, false, this.we[this.gn], this.J8[this.gn], this.J0[this.gn], this.Ws[this.gn]);
            } else {
                this.QX[this.XL] = this.Zo.j6(this.VH, false, this.we[this.gn], this.J8[this.gn], this.Ws[this.gn]);
            }
        }
        if (this.gn < this.u7) {
            this.gn++;
            this.VH = this.tp[this.gn];
        }
    }

    protected void v5(int i) {
        if (this.VH != i) {
            j6(i);
        } else if (this.gn < this.u7) {
            this.gn++;
            this.VH = this.tp[this.gn];
        }
    }

    protected void DW(int i, int i2) {
        if (this.aM) {
            int i3;
            int i4;
            if (this.gn > 0) {
                i3 = this.we[this.gn - 1];
                i4 = this.Ws[this.gn - 1];
            } else {
                i3 = this.we[this.gn];
                i4 = this.J8[this.gn];
            }
            this.XL++;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL] = this.Zo.j6(i, true, i2, i3, i4, i3, i4);
        }
    }

    protected int FH() {
        return this.QX[this.XL];
    }

    protected void FH(int i, int i2) {
        j6(i, false, i2);
    }

    protected void Hw(int i, int i2) {
        j6(i, true, i2);
    }

    protected void j6(int i, boolean z, int i2) {
        if (this.aM) {
            int i3;
            int i4;
            if (this.gn > 0) {
                i3 = this.J0[this.gn - 1];
                i4 = this.Ws[this.gn - 1];
            } else {
                i3 = this.we[this.gn];
                i4 = this.J8[this.gn];
            }
            int j6 = this.Zo.j6(i, z, this.QX, (this.XL - i2) + 1, i2, i3, i4);
            this.XL = (this.XL - i2) + 1;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL] = j6;
        }
    }

    protected void DW(int i, boolean z, int i2) {
        if (this.aM) {
            int i3 = this.we[this.gn];
            int i4 = this.J8[this.gn];
            int j6 = this.Zo.j6(i, z, this.QX, (this.XL - i2) + 1, i2, i3, i4);
            this.XL = (this.XL - i2) + 1;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL] = j6;
        }
    }

    protected void j6(int i, boolean z, int i2, int i3) {
        if (this.aM) {
            int i4;
            int i5;
            int j6;
            if (this.gn > 0) {
                i4 = this.we[this.gn - 1];
                i5 = this.Ws[this.gn - 1];
            } else {
                i4 = this.we[this.gn];
                i5 = this.J8[this.gn];
            }
            if (i3 != -1) {
                j6 = this.Zo.j6(i, z, this.QX, (this.XL - i2) + 1, i2, i4, i5, i3);
            } else {
                j6 = this.Zo.j6(i, z, this.QX, (this.XL - i2) + 1, i2, i4, i5);
            }
            this.XL = (this.XL - i2) + 1;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL] = j6;
        }
    }

    protected void j6(int i, int i2, int i3) {
        if (this.aM) {
            int i4;
            int i5;
            if (this.gn > 0) {
                i4 = this.we[this.gn - 1];
                i5 = this.Ws[this.gn - 1];
            } else {
                i4 = this.we[this.gn];
                i5 = this.J8[this.gn];
            }
            int j6 = this.Zo.j6(i, false, this.QX, ((this.XL - i3) - i2) + 1, i3, i4, i5);
            System.arraycopy(this.QX, (this.XL - i2) + 1, this.QX, ((this.XL - i2) - i3) + 2, i2);
            this.XL = (this.XL - i3) + 1;
            if (this.XL >= this.QX.length) {
                Object obj = new int[((this.QX.length * 2) + 1)];
                System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                this.QX = obj;
            }
            this.QX[this.XL - i2] = j6;
        }
    }

    protected void Hw() {
        if (this.gn < this.u7) {
            this.gn++;
            this.VH = this.tp[this.gn];
        }
    }

    protected int Zo(int i) {
        int i2 = this.gn + i;
        if (i2 < this.u7) {
            return this.tp[i2];
        }
        return this.Mr;
    }

    protected int v5() {
        return this.EQ[this.gn];
    }

    protected int VH(int i) {
        int i2 = this.gn + i;
        if (i2 < this.u7) {
            return this.EQ[i2];
        }
        return 0;
    }
}
