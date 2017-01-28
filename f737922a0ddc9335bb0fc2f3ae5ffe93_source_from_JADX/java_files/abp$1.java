import java.util.Comparator;
import java.util.HashMap;

class abp$1 implements Comparator<aah> {
    final /* synthetic */ abp DW;
    final /* synthetic */ HashMap j6;

    abp$1(abp abp, HashMap hashMap) {
        this.DW = abp;
        this.j6 = hashMap;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((aah) obj, (aah) obj2);
    }

    public int j6(aah aah, aah aah2) {
        int intValue = ((Integer) this.j6.get(aah2)).intValue() - ((Integer) this.j6.get(aah)).intValue();
        if (intValue == 0) {
            return aah.j6(aah2);
        }
        return intValue;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
