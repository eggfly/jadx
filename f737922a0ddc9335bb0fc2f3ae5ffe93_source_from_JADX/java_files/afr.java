import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class afr {
    public static <K, V> Map<K, V> DW() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> DW(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <T> Set<T> DW(T t) {
        return Collections.singleton(t);
    }

    private static <K, V> void DW(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }

    public static <T> List<T> j6(T t) {
        return Collections.singletonList(t);
    }

    public static <K, V> Map<K, V> j6(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map lVar = new l(6);
        lVar.put(k, v);
        lVar.put(k2, v2);
        lVar.put(k3, v3);
        lVar.put(k4, v4);
        lVar.put(k5, v5);
        lVar.put(k6, v6);
        return Collections.unmodifiableMap(lVar);
    }

    public static <K, V> Map<K, V> j6(K[] kArr, V[] vArr) {
        int i = 0;
        DW((Object[]) kArr, (Object[]) vArr);
        int length = kArr.length;
        switch (length) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return DW();
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return DW(kArr[0], vArr[0]);
            default:
                Map lVar = length <= 32 ? new l(length) : new HashMap(length, 1.0f);
                while (i < length) {
                    lVar.put(kArr[i], vArr[i]);
                    i++;
                }
                return Collections.unmodifiableMap(lVar);
        }
    }

    public static <T> Set<T> j6() {
        return Collections.emptySet();
    }

    public static <T> Set<T> j6(T t, T t2) {
        Set afm = new afm(2);
        afm.add(t);
        afm.add(t2);
        return Collections.unmodifiableSet(afm);
    }

    public static <T> Set<T> j6(T t, T t2, T t3) {
        Set afm = new afm(3);
        afm.add(t);
        afm.add(t2);
        afm.add(t3);
        return Collections.unmodifiableSet(afm);
    }

    public static <T> Set<T> j6(T t, T t2, T t3, T t4) {
        Set afm = new afm(4);
        afm.add(t);
        afm.add(t2);
        afm.add(t3);
        afm.add(t4);
        return Collections.unmodifiableSet(afm);
    }

    public static <T> Set<T> j6(T... tArr) {
        switch (tArr.length) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return j6();
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return DW(tArr[0]);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return j6(tArr[0], tArr[1]);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return j6(tArr[0], tArr[1], tArr[2]);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return j6(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new afm(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }
}
