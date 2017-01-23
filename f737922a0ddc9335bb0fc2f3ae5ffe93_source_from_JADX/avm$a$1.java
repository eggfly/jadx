import java.util.Comparator;
import java.util.HashMap;

class avm$a$1 implements Comparator<String> {
    private final /* synthetic */ HashMap DW;
    final /* synthetic */ avm$a j6;

    avm$a$1(avm$a avm_a, HashMap hashMap) {
        this.j6 = avm_a;
        this.DW = hashMap;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((String) obj, (String) obj2);
    }

    public int j6(String str, String str2) {
        return ((Integer) this.DW.get(str2)).intValue() - ((Integer) this.DW.get(str)).intValue();
    }
}
