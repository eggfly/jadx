package com.aide.ui.views.editor;

import java.io.Reader;

class l extends Reader {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private char Zo;
    private char[] gn;
    private j j6;
    private int v5;

    l(j jVar, int i, int i2, int i3, int i4, boolean z, String str) {
        this.j6 = jVar;
        this.DW = i;
        this.FH = i2;
        this.v5 = i4;
        this.Hw = i3;
        if (this.v5 > jVar.FH() - 1) {
            this.v5 = jVar.FH() - 1;
            this.Hw = jVar.Hw(this.v5);
        }
        if (this.Hw > jVar.Hw(this.v5)) {
            this.Hw = jVar.Hw(this.v5);
        }
        this.Zo = z ? ' ' : '\t';
        this.VH = 0;
        this.gn = str.toCharArray();
    }

    public int read() {
        int i = -1;
        synchronized (this.j6) {
            int FH = this.j6.FH();
            j jVar;
            char[] cArr;
            if (this.FH >= this.v5 || this.FH >= FH) {
                if (this.FH != this.v5 || this.FH >= FH) {
                } else if (this.DW > this.Hw || this.DW > this.j6.Hw(this.FH)) {
                } else if (this.DW < this.j6.Hw(this.FH)) {
                    jVar = this.j6;
                    FH = this.DW;
                    this.DW = FH + 1;
                    i = jVar.j6(FH, this.FH);
                    if (i != 9) {
                    } else {
                        i = this.Zo;
                    }
                } else if (this.VH < this.gn.length - 1) {
                    cArr = this.gn;
                    FH = this.VH;
                    this.VH = FH + 1;
                    i = cArr[FH];
                } else {
                    this.VH = 0;
                    this.DW = 0;
                    this.FH++;
                    i = this.gn[this.gn.length - 1];
                }
            } else if (this.DW < this.j6.Hw(this.FH)) {
                jVar = this.j6;
                FH = this.DW;
                this.DW = FH + 1;
                i = jVar.j6(FH, this.FH);
                if (i != 9) {
                } else {
                    i = this.Zo;
                }
            } else if (this.VH < this.gn.length - 1) {
                cArr = this.gn;
                FH = this.VH;
                this.VH = FH + 1;
                i = cArr[FH];
            } else {
                this.VH = 0;
                this.DW = 0;
                this.FH++;
                i = this.gn[this.gn.length - 1];
            }
        }
        return i;
    }

    public int read(char[] cArr, int i, int i2) {
        if (cArr == null) {
            throw new NullPointerException();
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 + i > cArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            int read = read();
            if (read == -1) {
                return -1;
            }
            int i3 = 1;
            int i4 = i + 1;
            cArr[i] = (char) read;
            while (i3 < i2) {
                int read2 = read();
                if (read2 == -1) {
                    break;
                }
                read = i4 + 1;
                cArr[i4] = (char) read2;
                i3++;
                i4 = read;
            }
            return i3;
        }
    }

    public void close() {
    }
}
