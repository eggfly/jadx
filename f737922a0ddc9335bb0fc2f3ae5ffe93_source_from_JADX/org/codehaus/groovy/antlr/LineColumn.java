package org.codehaus.groovy.antlr;

public class LineColumn {
    private int DW;
    private int j6;

    public LineColumn(int i, int i2) {
        this.j6 = i;
        this.DW = i2;
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineColumn lineColumn = (LineColumn) obj;
        if (this.DW != lineColumn.DW) {
            return false;
        }
        if (this.j6 != lineColumn.j6) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.j6 * 29) + this.DW;
    }

    public String toString() {
        return "[" + this.j6 + "," + this.DW + "]";
    }
}
