import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.eclipse.jgit.JGitText;

class akk {
    private List<ajt> DW;
    private List<ajt> FH;
    private long[] Hw;
    private List<ajt> VH;
    private boolean Zo;
    private ajq$c j6;
    private int v5;

    akk(ajq$c ajq_c, List<ajt> list, List<ajt> list2) {
        this.v5 = 60;
        this.j6 = ajq_c;
        this.DW = list;
        this.FH = list2;
    }

    void j6(int i) {
        this.v5 = i;
    }

    void j6(aob aob) {
        if (aob == null) {
            aob = anp.j6;
        }
        aob.j6(JGitText.j6().renamesFindingByContent, (this.DW.size() * 2) * this.FH.size());
        int DW = DW(aob);
        this.VH = new ArrayList(Math.min(DW, this.FH.size()));
        for (int i = DW - 1; i >= 0; i--) {
            long j = this.Hw[i];
            DW = j6(j);
            int DW2 = DW(j);
            ajt ajt = (ajt) this.DW.get(DW);
            ajt ajt2 = (ajt) this.FH.get(DW2);
            if (ajt2 == null) {
                aob.j6(1);
            } else {
                ajt$a ajt_a;
                if (ajt.Zo == ajt$a.DELETE) {
                    ajt.Zo = ajt$a.RENAME;
                    ajt_a = ajt$a.RENAME;
                } else {
                    ajt_a = ajt$a.COPY;
                }
                this.VH.add(ajt.j6(ajt_a, ajt, ajt2, FH(j)));
                this.FH.set(DW2, null);
                aob.j6(1);
            }
        }
        this.DW = j6(this.DW);
        this.FH = DW(this.FH);
        aob.DW();
    }

    List<ajt> j6() {
        return this.VH;
    }

    List<ajt> DW() {
        return this.DW;
    }

    List<ajt> FH() {
        return this.FH;
    }

    boolean Hw() {
        return this.Zo;
    }

    private static List<ajt> j6(List<ajt> list) {
        List arrayList = new ArrayList(list.size());
        for (ajt ajt : list) {
            if (ajt.Zo == ajt$a.DELETE) {
                arrayList.add(ajt);
            }
        }
        return arrayList;
    }

    private static List<ajt> DW(List<ajt> list) {
        List arrayList = new ArrayList(list.size());
        for (ajt ajt : list) {
            if (ajt != null) {
                arrayList.add(ajt);
            }
        }
        return arrayList;
    }

    private int DW(aob aob) {
        this.Hw = new long[(this.DW.size() * this.FH.size())];
        long[] jArr = new long[this.DW.size()];
        long[] jArr2 = new long[this.FH.size()];
        BitSet bitSet = null;
        int i = 0;
        for (int i2 = 0; i2 < this.DW.size(); i2++) {
            ajt ajt = (ajt) this.DW.get(i2);
            if (j6(ajt.Hw)) {
                akj akj = null;
                int i3 = 0;
                while (i3 < this.FH.size()) {
                    akj akj2;
                    BitSet bitSet2;
                    int i4;
                    ajt ajt2 = (ajt) this.FH.get(i3);
                    if (!j6(ajt2.v5)) {
                        aob.j6(1);
                        akj2 = akj;
                        bitSet2 = bitSet;
                        i4 = i;
                    } else if (!akg.j6(ajt.Hw, ajt2.v5)) {
                        aob.j6(1);
                        akj2 = akj;
                        bitSet2 = bitSet;
                        i4 = i;
                    } else if (bitSet == null || !bitSet.get(i3)) {
                        long j = jArr[i2];
                        if (j == 0) {
                            j = DW(ajt$b.OLD, ajt) + 1;
                            jArr[i2] = j;
                        }
                        long j2 = jArr2[i3];
                        if (j2 == 0) {
                            j2 = DW(ajt$b.NEW, ajt2) + 1;
                            jArr2[i3] = j2;
                        }
                        if ((Math.min(j, j2) * 100) / Math.max(j, j2) < ((long) this.v5)) {
                            aob.j6(1);
                            akj2 = akj;
                            bitSet2 = bitSet;
                            i4 = i;
                        } else {
                            if (akj == null) {
                                try {
                                    akj = j6(ajt$b.OLD, ajt);
                                } catch (akj$a e) {
                                    this.Zo = true;
                                }
                            }
                            akj akj3;
                            try {
                                int j6 = akj.j6(j6(ajt$b.NEW, ajt2), 10000);
                                j6 = (((j6(ajt.DW, ajt2.FH) * 100) * 1) + (j6 * 99)) / 10000;
                                if (j6 < this.v5) {
                                    aob.j6(1);
                                    akj2 = akj;
                                    bitSet2 = bitSet;
                                    i4 = i;
                                } else {
                                    int i5 = i + 1;
                                    this.Hw[i] = j6(j6, i2, i3);
                                    aob.j6(1);
                                    akj3 = akj;
                                    bitSet2 = bitSet;
                                    i4 = i5;
                                    akj2 = akj3;
                                }
                            } catch (akj$a e2) {
                                BitSet bitSet3;
                                if (bitSet == null) {
                                    bitSet3 = new BitSet(this.FH.size());
                                } else {
                                    bitSet3 = bitSet;
                                }
                                bitSet3.set(i3);
                                this.Zo = true;
                                aob.j6(1);
                                i4 = i;
                                akj3 = akj;
                                bitSet2 = bitSet3;
                                akj2 = akj3;
                            }
                        }
                    } else {
                        aob.j6(1);
                        akj2 = akj;
                        bitSet2 = bitSet;
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                    bitSet = bitSet2;
                    akj = akj2;
                }
            } else {
                aob.j6(this.FH.size());
            }
        }
        Arrays.sort(this.Hw, 0, i);
        return i;
    }

    static int j6(String str, String str2) {
        int i;
        int i2 = 0;
        int i3 = 100;
        int lastIndexOf = str.lastIndexOf("/") + 1;
        int lastIndexOf2 = str2.lastIndexOf("/") + 1;
        int min = Math.min(lastIndexOf, lastIndexOf2);
        int max = Math.max(lastIndexOf, lastIndexOf2);
        if (max == 0) {
            i = 100;
        } else {
            i = 0;
            while (i < min && str.charAt(i) == str2.charAt(i)) {
                i++;
            }
            i = (i * 100) / max;
            if (i != 100) {
                i3 = 0;
                while (i3 < min && str.charAt((lastIndexOf - 1) - i3) == str2.charAt((lastIndexOf2 - 1) - i3)) {
                    i3++;
                }
                i3 = (i3 * 100) / max;
            }
        }
        min = Math.min(str.length() - lastIndexOf, str2.length() - lastIndexOf2);
        lastIndexOf = Math.max(str.length() - lastIndexOf, str2.length() - lastIndexOf2);
        while (i2 < min && str.charAt((str.length() - 1) - i2) == str2.charAt((str2.length() - 1) - i2)) {
            i2++;
        }
        return (((i3 + i) * 25) + (((i2 * 100) / lastIndexOf) * 50)) / 100;
    }

    private akj j6(ajt$b ajt_b, ajt ajt) {
        akj akj = new akj();
        akj.j6(this.j6.DW(ajt_b, ajt));
        akj.j6();
        return akj;
    }

    private long DW(ajt$b ajt_b, ajt ajt) {
        return this.j6.j6(ajt_b, ajt);
    }

    private static int FH(long j) {
        return (int) (j >>> 56);
    }

    static int j6(long j) {
        return FH(((int) (j >>> 28)) & 268435455);
    }

    static int DW(long j) {
        return FH(((int) j) & 268435455);
    }

    static long j6(int i, int i2, int i3) {
        return ((((long) i) << 56) | (DW(i2) << 28)) | DW(i3);
    }

    private static long DW(int i) {
        return (long) (268435455 - i);
    }

    private static int FH(int i) {
        return 268435455 - i;
    }

    private static boolean j6(anl anl) {
        return (anl.FH() & 61440) == 32768;
    }
}
