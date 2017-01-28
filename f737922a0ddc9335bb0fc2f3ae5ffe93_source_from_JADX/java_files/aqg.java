public abstract class aqg extends ant$a {
    int we;

    abstract void DW(aql aql);

    abstract void j6(aql aql);

    public abstract int v_();

    aqg(anb anb) {
        super(anb);
    }

    public final ans XL() {
        return this;
    }

    public final boolean DW(aqe aqe) {
        return (this.we & aqe.Hw) != 0;
    }

    public final void FH(aqe aqe) {
        this.we |= aqe.Hw;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(anj.j6(v_()));
        stringBuilder.append(' ');
        stringBuilder.append(DW());
        stringBuilder.append(' ');
        j6(stringBuilder);
        return stringBuilder.toString();
    }

    protected void j6(StringBuilder stringBuilder) {
        char c;
        char c2 = '-';
        stringBuilder.append((this.we & 32) != 0 ? 'o' : '-');
        if ((this.we & 16) != 0) {
            c = 't';
        } else {
            c = '-';
        }
        stringBuilder.append(c);
        if ((this.we & 8) != 0) {
            c = 'r';
        } else {
            c = '-';
        }
        stringBuilder.append(c);
        if ((this.we & 4) != 0) {
            c = 'u';
        } else {
            c = '-';
        }
        stringBuilder.append(c);
        if ((this.we & 2) != 0) {
            c = 's';
        } else {
            c = '-';
        }
        stringBuilder.append(c);
        if ((this.we & 1) != 0) {
            c2 = 'p';
        }
        stringBuilder.append(c2);
    }
}
