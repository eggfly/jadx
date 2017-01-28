import java.util.Locale;
import java.util.Stack;

class ix implements Comparable<ix> {
    private String DW;
    private ix$c FH;
    private String j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ix) obj);
    }

    public ix(String str) {
        j6(str);
    }

    public final void j6(String str) {
        this.j6 = str;
        this.FH = new ix$c();
        String toLowerCase = str.toLowerCase(Locale.ENGLISH);
        ix$c ix_c = this.FH;
        Stack stack = new Stack();
        stack.push(ix_c);
        int i = 0;
        boolean z = false;
        ix$c ix_c2 = ix_c;
        int i2 = 0;
        while (i2 < toLowerCase.length()) {
            char charAt = toLowerCase.charAt(i2);
            if (charAt == '.') {
                if (i2 == i) {
                    ix_c2.add(ix$a.j6);
                } else {
                    ix_c2.add(j6(z, toLowerCase.substring(i, i2)));
                }
                i = i2 + 1;
            } else if (charAt == '-') {
                if (i2 == i) {
                    ix_c2.add(ix$a.j6);
                } else {
                    ix_c2.add(j6(z, toLowerCase.substring(i, i2)));
                }
                i = i2 + 1;
                ix$c ix_c3 = new ix$c();
                ix_c2.add(ix_c3);
                stack.push(ix_c3);
                ix_c2 = ix_c3;
            } else if (Character.isDigit(charAt)) {
                if (!z && i2 > i) {
                    ix_c2.add(new ix$d(toLowerCase.substring(i, i2), true));
                    r2 = new ix$c();
                    ix_c2.add(r2);
                    stack.push(r2);
                    ix_c2 = r2;
                    i = i2;
                }
                z = true;
            } else {
                if (z && i2 > i) {
                    ix_c2.add(j6(true, toLowerCase.substring(i, i2)));
                    r2 = new ix$c();
                    ix_c2.add(r2);
                    stack.push(r2);
                    ix_c2 = r2;
                    i = i2;
                }
                z = false;
            }
            i2++;
        }
        if (toLowerCase.length() > i) {
            ix_c2.add(j6(z, toLowerCase.substring(i)));
        }
        while (!stack.isEmpty()) {
            ((ix$c) stack.pop()).FH();
        }
        this.DW = this.FH.toString();
    }

    private static ix$b j6(boolean z, String str) {
        return z ? new ix$a(str) : new ix$d(str, false);
    }

    public int j6(ix ixVar) {
        return this.FH.j6(ixVar.FH);
    }

    public String toString() {
        return this.j6;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ix) && this.DW.equals(((ix) obj).DW);
    }

    public int hashCode() {
        return this.DW.hashCode();
    }
}
