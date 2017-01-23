import java.util.Comparator;

class awd$1 implements Comparator<awd$a> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((awd$a) obj, (awd$a) obj2);
    }

    awd$1() {
    }

    public int j6(awd$a awd_a, awd$a awd_a2) {
        byte[] bArr = awd_a.DW;
        byte[] bArr2 = awd_a2.DW;
        int i = awd_a.FH;
        int i2 = awd_a2.FH;
        int i3 = 0;
        while (i3 < i && i3 < i2) {
            int i4 = (bArr[i3] & 255) - (bArr2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
            i3++;
        }
        if (i3 < i) {
            return (bArr[i3] & 255) - awd.DW(awd_a2);
        }
        if (i3 < i2) {
            return awd.DW(awd_a) - (bArr2[i3] & 255);
        }
        return awd.DW(awd_a) - awd.DW(awd_a2);
    }
}
