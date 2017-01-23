package groovyjarjarantlr;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrintWriterWithSMAP extends PrintWriter {
    private int DW;
    private Map FH;
    private boolean Hw;
    private boolean VH;
    private boolean Zo;
    private int j6;
    private boolean v5;

    protected void j6(boolean z) {
        if (this.v5 && this.VH) {
            Integer num = new Integer(this.DW);
            Integer num2 = new Integer(this.j6);
            List list = (List) this.FH.get(num);
            if (list == null) {
                list = new ArrayList();
                this.FH.put(num, list);
            }
            if (!list.contains(num2)) {
                list.add(num2);
            }
        }
        if (z) {
            this.j6++;
        }
        if (!this.Zo) {
            this.DW++;
        }
        this.VH = false;
    }

    public void write(char[] cArr, int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            j6(cArr[i4]);
        }
        super.write(cArr, i, i2);
    }

    public void j6(int i) {
        boolean z = true;
        if (this.Hw && i != 10) {
            j6(true);
        } else if (i == 10) {
            j6(true);
        } else if (!Character.isWhitespace((char) i)) {
            this.VH = true;
        }
        if (i != 13) {
            z = false;
        }
        this.Hw = z;
    }

    public void write(int i) {
        j6(i);
        super.write(i);
    }

    public void write(String str, int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            j6(str.charAt(i4));
        }
        super.write(str, i, i2);
    }

    public void println() {
        j6(true);
        super.println();
        this.Hw = false;
    }
}
