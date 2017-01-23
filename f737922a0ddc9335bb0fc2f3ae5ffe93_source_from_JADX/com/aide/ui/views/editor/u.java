package com.aide.ui.views.editor;

class u {
    protected int DW;
    protected char[] j6;

    public u() {
        this(8);
    }

    public u(int i) {
        this.j6 = new char[i];
        this.DW = 0;
    }

    public u(char[] cArr) {
        this.j6 = cArr;
        this.DW = cArr.length;
    }

    protected void j6(int i) {
        int length = this.j6.length;
        if (length == 0) {
            length = 1;
        }
        while (length < i) {
            length *= 2;
        }
        if (length != this.j6.length) {
            Object obj = new char[length];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
    }

    protected void j6() {
        int length = this.j6.length;
        while (length > 8 && this.DW < length / 4) {
            length /= 2;
            if (length < 8) {
                length = 8;
            }
        }
        if (length != this.j6.length) {
            Object obj = new char[length];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
    }

    public char DW(int i) {
        return this.j6[i];
    }

    public void j6(int i, int i2, char[] cArr, int i3) {
        System.arraycopy(this.j6, i, cArr, i3, i2);
    }

    public char[] DW() {
        char[] cArr = new char[this.DW];
        j6(0, this.DW, cArr, 0);
        return cArr;
    }

    public void j6(char c, int i) {
        j6(i + 1);
        if (i == this.DW) {
            this.DW = i + 1;
        } else if (i > this.DW) {
            for (int i2 = this.DW; i2 < i; i2++) {
                this.j6[i2] = ' ';
            }
            this.DW = i + 1;
        }
        this.j6[i] = c;
    }

    public void j6(char[] cArr, int i) {
        int i2;
        j6(cArr.length + i);
        if (i > this.DW) {
            for (i2 = this.DW; i2 < i; i2++) {
                this.j6[i2] = ' ';
            }
        }
        if (cArr.length + i > this.DW) {
            this.DW = cArr.length + i;
        }
        for (i2 = 0; i2 < cArr.length; i2++) {
            this.j6[i + i2] = cArr[i2];
        }
    }

    public void j6(char[] cArr) {
        j6(this.DW + cArr.length);
        for (int i = 0; i < cArr.length; i++) {
            this.j6[this.DW + i] = cArr[i];
        }
        this.DW += cArr.length;
    }

    public void DW(char c, int i) {
        if (i >= this.DW) {
            j6(c, i);
            return;
        }
        j6(this.DW + 1);
        System.arraycopy(this.j6, i, this.j6, i + 1, this.DW - i);
        this.j6[i] = c;
        this.DW++;
    }

    public void DW(char[] cArr, int i) {
        if (i >= this.DW) {
            j6(cArr, i);
            return;
        }
        j6(this.DW + cArr.length);
        System.arraycopy(this.j6, i, this.j6, cArr.length + i, this.DW - i);
        System.arraycopy(cArr, 0, this.j6, i, cArr.length);
        this.DW += cArr.length;
    }

    public void FH(int i) {
        System.arraycopy(this.j6, i + 1, this.j6, i, (this.j6.length - i) - 1);
        this.DW--;
        j6();
    }

    public void j6(int i, int i2) {
        if (i2 + i > this.DW) {
            throw new ArrayIndexOutOfBoundsException("Trying to remove " + i + " characters at position " + i2 + " from a line containing " + this.DW + " characters");
        }
        System.arraycopy(this.j6, i2 + i, this.j6, i2, (this.j6.length - i2) - i);
        this.DW -= i;
        j6();
    }

    public int FH() {
        return this.DW;
    }
}
