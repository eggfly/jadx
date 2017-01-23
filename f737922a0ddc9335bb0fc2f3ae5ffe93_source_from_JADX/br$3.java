import java.util.Comparator;

class br$3 implements Comparator<String> {
    final /* synthetic */ br j6;

    br$3(br brVar) {
        this.j6 = brVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((String) obj, (String) obj2);
    }

    public int j6(String str, String str2) {
        int length = str.length() - 6;
        int length2 = str2.length() - 6;
        int i = length < length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            char charAt = str.charAt(i2);
            char charAt2 = str2.charAt(i2);
            if (charAt == '$' && charAt != charAt2) {
                return -1;
            }
            if (charAt2 == '$' && charAt != charAt2) {
                return 1;
            }
            if (charAt == '+' && charAt != charAt2) {
                return -1;
            }
            if (charAt2 == '+' && charAt != charAt2) {
                return 1;
            }
            int i3 = charAt - charAt2;
            if (i3 < 0) {
                return -1;
            }
            if (i3 > 0) {
                return 1;
            }
        }
        if (length < length2) {
            return -1;
        }
        return length > length2 ? 1 : 0;
    }
}
