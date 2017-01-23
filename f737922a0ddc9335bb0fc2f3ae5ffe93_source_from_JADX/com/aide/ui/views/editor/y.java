package com.aide.ui.views.editor;

import java.io.Reader;

class y extends Reader {
    private int DW;
    private int FH;
    private int Hw;
    private char VH;
    private int Zo;
    private int gn;
    private j j6;
    private char[] u7;
    private int v5;

    y(j jVar, int i, int i2, int i3, int i4, boolean z, String str) {
        this.j6 = jVar;
        this.DW = i;
        this.FH = i2;
        if (i4 < jVar.FH()) {
            this.v5 = i4;
            if (i3 >= jVar.Hw(this.v5)) {
                i3 = jVar.Hw(this.v5) - 1;
            }
            this.Hw = i3;
        } else {
            this.v5 = jVar.FH() - 1;
            this.Hw = jVar.Hw(this.v5) - 1;
        }
        this.Zo = i2 == this.v5 ? this.Hw + 1 : jVar.Hw(i2);
        this.VH = z ? ' ' : '\t';
        this.gn = 0;
        this.u7 = str.toCharArray();
    }

    public int read() {
        int i;
        if (this.DW < this.Zo) {
            j jVar = this.j6;
            i = this.DW;
            this.DW = i + 1;
            char j6 = jVar.j6(i, this.FH);
            if (j6 != '\t') {
                return j6;
            }
            return this.VH;
        } else if (this.FH == this.v5) {
            return -1;
        } else {
            if (this.gn < this.u7.length - 1) {
                char[] cArr = this.u7;
                i = this.gn;
                this.gn = i + 1;
                return cArr[i];
            }
            this.gn = 0;
            this.DW = 0;
            this.FH++;
            this.Zo = this.FH == this.v5 ? this.Hw + 1 : this.j6.Hw(this.FH);
            return this.u7[this.u7.length - 1];
        }
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
