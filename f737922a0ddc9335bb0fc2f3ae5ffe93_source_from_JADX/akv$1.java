import java.util.Comparator;

class akv$1 implements Comparator<akv> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((akv) obj, (akv) obj2);
    }

    akv$1() {
    }

    public int j6(akv akv, akv akv2) {
        byte[] j6 = akv.v5;
        byte[] j62 = akv2.v5;
        int length = j6.length;
        int length2 = j62.length;
        int i = 0;
        while (i < length && i < length2) {
            int i2 = (j6[i] & 255) - (j62[i] & 255);
            if (i2 != 0) {
                return i2;
            }
            i++;
        }
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return 47 - (j62[i] & 255);
        }
        return (j6[i] & 255) - 47;
    }
}
