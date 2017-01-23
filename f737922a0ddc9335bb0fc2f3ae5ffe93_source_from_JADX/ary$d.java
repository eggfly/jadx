import java.io.File;
import java.io.IOException;
import java.util.Arrays;

class ary$d {
    axf$a<ary$c> DW;
    final /* synthetic */ ary FH;
    private final axf<ary$c> Hw;
    final axf$a<aoc> j6;
    private int v5;

    ary$d(ary ary, axf<ary$c> axf_ary_c) {
        this.FH = ary;
        this.j6 = new axf$a(4);
        this.Hw = axf_ary_c;
    }

    void j6(String str) {
        if ("".equals(str)) {
            DW("HEAD");
            j6("refs/", this.FH.v5);
            if (this.DW == null && this.v5 < this.Hw.FH()) {
                this.DW = this.Hw.DW(this.v5);
            }
        } else if (str.startsWith("refs/") && str.endsWith("/")) {
            this.v5 = -(this.Hw.j6(str) + 1);
            j6(str, new File(this.FH.v5, str.substring("refs/".length())));
            while (this.v5 < this.Hw.FH() && ((ary$c) this.Hw.j6(this.v5)).j6().startsWith(str)) {
                if (this.DW == null) {
                    this.DW = this.Hw.DW(this.v5);
                }
                this.v5++;
            }
            if (this.DW != null) {
                while (this.v5 < this.Hw.FH()) {
                    axf$a axf_a = this.DW;
                    axf axf = this.Hw;
                    int i = this.v5;
                    this.v5 = i + 1;
                    axf_a.j6((ary$c) axf.j6(i));
                }
            }
        }
    }

    private boolean j6(String str, File file) {
        int i = 0;
        String[] list = file.list(ark.j6);
        if (list == null) {
            return false;
        }
        if (list.length > 0) {
            int i2;
            for (i2 = 0; i2 < list.length; i2++) {
                if (new File(file, list[i2]).isDirectory()) {
                    list[i2] = list[i2] + '/';
                }
            }
            Arrays.sort(list);
            i2 = list.length;
            while (i < i2) {
                String str2 = list[i];
                if (str2.charAt(str2.length() - 1) == '/') {
                    j6(new StringBuilder(String.valueOf(str)).append(str2).toString(), new File(file, str2));
                } else {
                    DW(new StringBuilder(String.valueOf(str)).append(str2).toString());
                }
                i++;
            }
        }
        return true;
    }

    private void DW(String str) {
        aoc aoc;
        ary$c ary_c;
        if (this.v5 < this.Hw.FH()) {
            do {
                aoc = (ary$c) this.Hw.j6(this.v5);
                int j6 = aod.j6(aoc, str);
                if (j6 < 0) {
                    if (this.DW == null) {
                        this.DW = this.Hw.DW(this.v5);
                    }
                    this.v5++;
                } else if (j6 > 0) {
                    ary_c = null;
                } else {
                    aoc aoc2 = aoc;
                }
            } while (this.v5 < this.Hw.FH());
            ary_c = null;
        } else {
            ary_c = null;
        }
        try {
            aoc = this.FH.j6(ary_c, str);
        } catch (IOException e) {
            aoc = null;
        }
        if (aoc != null) {
            if (ary_c != aoc && this.DW == null) {
                this.DW = this.Hw.DW(this.v5);
            }
            if (this.DW != null) {
                this.DW.j6(aoc);
            }
            if (aoc.DW()) {
                this.j6.j6(aoc);
            }
        } else if (ary_c != null && this.DW == null) {
            this.DW = this.Hw.DW(this.v5);
        }
        if (ary_c != null) {
            this.v5++;
        }
    }
}
