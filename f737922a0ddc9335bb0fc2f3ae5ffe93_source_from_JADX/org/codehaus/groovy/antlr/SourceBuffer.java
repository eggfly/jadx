package org.codehaus.groovy.antlr;

import java.util.ArrayList;
import java.util.List;

public class SourceBuffer {
    private StringBuffer DW;
    private final List j6;

    public SourceBuffer() {
        this.j6 = new ArrayList();
        this.DW = new StringBuffer();
        this.j6.add(this.DW);
    }

    public String j6(LineColumn lineColumn, LineColumn lineColumn2) {
        if (lineColumn == null || lineColumn2 == null || lineColumn.equals(lineColumn2)) {
            return null;
        }
        if (this.j6.size() == 1 && this.DW.length() == 0) {
            return null;
        }
        int j6 = lineColumn.j6();
        int DW = lineColumn.DW();
        int j62 = lineColumn2.j6();
        int DW2 = lineColumn2.DW();
        if (j6 < 1) {
            j6 = 1;
        }
        if (j62 < 1) {
            j62 = 1;
        }
        if (DW < 1) {
            DW = 1;
        }
        if (DW2 < 1) {
            DW2 = 1;
        }
        if (j6 > this.j6.size()) {
            j6 = this.j6.size();
        }
        if (j62 > this.j6.size()) {
            j62 = this.j6.size();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = DW2;
        for (int i2 = j6 - 1; i2 < j62; i2++) {
            String substring;
            String stringBuffer2 = ((StringBuffer) this.j6.get(i2)).toString();
            if (j6 == j62) {
                if (DW > stringBuffer2.length()) {
                    DW2 = stringBuffer2.length();
                } else {
                    DW2 = DW;
                }
                if (DW2 < 1) {
                    DW2 = 1;
                }
                if (i > stringBuffer2.length()) {
                    i = stringBuffer2.length() + 1;
                }
                if (i < 1) {
                    i = 1;
                }
                DW = DW2;
                substring = stringBuffer2.substring(DW2 - 1, i - 1);
            } else {
                if (i2 != j6 - 1 || DW - 1 >= stringBuffer2.length()) {
                    substring = stringBuffer2;
                } else {
                    substring = stringBuffer2.substring(DW - 1);
                }
                if (i2 == j62 - 1 && i - 1 < substring.length()) {
                    substring = substring.substring(0, i - 1);
                }
            }
            stringBuffer.append(substring);
        }
        return stringBuffer.toString();
    }

    public void j6(int i) {
        if (i != -1) {
            this.DW.append((char) i);
        }
        if (i == 10) {
            this.DW = new StringBuffer();
            this.j6.add(this.DW);
        }
    }
}
