import java.io.Serializable;

public class qt implements Serializable {
    private int DW;
    private int FH;
    private int Hw;
    private int j6;

    public qt(qt qtVar) {
        this.j6 = qtVar.j6();
        this.DW = qtVar.DW();
        this.FH = qtVar.FH();
        this.Hw = qtVar.Hw();
    }

    public qt(int i, int i2, int i3, int i4) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = i4;
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public int FH() {
        return this.FH;
    }

    public int Hw() {
        return this.Hw;
    }

    public void j6(int i) {
        this.j6 = i;
    }

    public void DW(int i) {
        this.DW = i;
    }

    public void FH(int i) {
        this.FH = i;
    }

    public void Hw(int i) {
        this.Hw = i;
    }

    public boolean j6(int i, int i2) {
        if (this.j6 == this.FH) {
            if (i != this.j6) {
                return false;
            }
            if (i2 < this.DW || i2 > this.Hw) {
                return false;
            }
            return true;
        } else if (i == this.j6) {
            if (i2 < this.DW) {
                return false;
            }
            return true;
        } else if (i == this.FH) {
            if (i2 > this.Hw) {
                return false;
            }
            return true;
        } else if (this.j6 >= i || i >= this.FH) {
            return false;
        } else {
            return true;
        }
    }

    public qt j6(int i, int i2, int i3, int i4) {
        qt qtVar = null;
        if (i2 < this.j6 && i2 != i4) {
            qtVar = new qt(this);
            this.j6 = (this.j6 + i4) - i2;
        } else if (i2 == this.j6 && i < this.DW) {
            qtVar = new qt(this);
            if (i2 == i4) {
                this.DW = ((this.DW + i3) - i) + 1;
            } else {
                this.DW = ((this.DW + i3) - i) + 1;
                this.j6 = (this.j6 + i4) - i2;
            }
        }
        if (i2 < this.FH && i2 != i4) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            this.FH = (this.FH + i4) - i2;
        } else if (i2 == this.FH && i <= this.Hw) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            if (i2 == i4) {
                this.Hw = ((this.Hw + i3) - i) + 1;
            } else {
                this.Hw = ((this.Hw + i3) - i) + 1;
                this.FH = (this.FH + i4) - i2;
            }
        }
        return qtVar;
    }

    public qt DW(int i, int i2, int i3, int i4) {
        qt qtVar = null;
        if (i2 < this.j6 && i2 != i4) {
            qtVar = new qt(this);
            this.j6 = (this.j6 + i4) - i2;
        } else if (i2 == this.j6 && i <= this.DW) {
            qtVar = new qt(this);
            if (i2 == i4) {
                this.DW = ((this.DW + i3) - i) + 1;
            } else {
                this.DW = ((this.DW + i3) - i) + 1;
                this.j6 = (this.j6 + i4) - i2;
            }
        }
        if (i2 < this.FH && i2 != i4) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            this.FH = (this.FH + i4) - i2;
        } else if (i2 == this.FH && i < this.Hw) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            if (i2 == i4) {
                this.Hw = ((this.Hw + i3) - i) + 1;
            } else {
                this.Hw = ((this.Hw + i3) - i) + 1;
                this.FH = (this.FH + i4) - i2;
            }
        }
        return qtVar;
    }

    public qt FH(int i, int i2, int i3, int i4) {
        qt qtVar = null;
        if (i2 == i4) {
            if (i4 == this.j6 && i < this.DW) {
                qtVar = new qt(this);
                this.DW = Math.max(i, this.DW - ((i3 - i) + 1));
            }
        } else if ((this.j6 == i2 && i < this.DW) || ((this.j6 > i2 && this.j6 < i4) || (this.j6 == i4 && this.DW < i3))) {
            qtVar = new qt(this);
            this.DW = i;
            this.j6 = i2;
        } else if (this.j6 == i4) {
            qtVar = new qt(this);
            this.DW = ((this.DW + i) - i3) - 1;
        } else if (this.j6 > i4) {
            qtVar = new qt(this);
            this.j6 -= i4 - i2;
        }
        if (i2 == i4) {
            if (i4 == this.FH && i < this.Hw) {
                if (qtVar == null) {
                    qtVar = new qt(this);
                }
                this.Hw = Math.max(i, this.Hw - ((i3 - i) + 1));
            }
        } else if ((this.FH == i2 && i < this.Hw) || ((this.FH > i2 && this.FH < i4) || (this.FH == i4 && this.Hw < i3))) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            this.Hw = i;
            this.FH = i2;
        } else if (this.FH == i4) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            this.Hw = ((this.Hw + i) - i3) - 1;
        } else if (this.FH > i4) {
            if (qtVar == null) {
                qtVar = new qt(this);
            }
            this.FH -= i4 - i2;
        }
        return qtVar;
    }

    public String toString() {
        return (((this.j6 + ",") + this.DW + ",") + this.FH + ",") + this.Hw;
    }
}
