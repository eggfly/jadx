package p023b.p024a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.ax */
public final class ax {
    private static final Comparator f2724a;

    /* renamed from: b.a.ax.a */
    private static class C0838a implements Comparator {
        private C0838a() {
        }

        public int compare(Object obj, Object obj2) {
            return (obj == null && obj2 == null) ? 0 : obj == null ? -1 : obj2 == null ? 1 : obj instanceof List ? ax.m3462a((List) obj, (List) obj2) : obj instanceof Set ? ax.m3464a((Set) obj, (Set) obj2) : obj instanceof Map ? ax.m3463a((Map) obj, (Map) obj2) : obj instanceof byte[] ? ax.m3465a((byte[]) obj, (byte[]) obj2) : ax.m3461a((Comparable) obj, (Comparable) obj2);
        }
    }

    static {
        f2724a = new C0838a();
    }

    public static int m3459a(byte b, byte b2) {
        return b < b2 ? -1 : b2 < b ? 1 : 0;
    }

    public static int m3460a(int i, int i2) {
        return i < i2 ? -1 : i2 < i ? 1 : 0;
    }

    public static int m3461a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int m3462a(List list, List list2) {
        int a = ax.m3460a(list.size(), list2.size());
        if (a != 0) {
            return a;
        }
        for (a = 0; a < list.size(); a++) {
            int compare = f2724a.compare(list.get(a), list2.get(a));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int m3463a(Map map, Map map2) {
        int a = ax.m3460a(map.size(), map2.size());
        if (a != 0) {
            return a;
        }
        SortedMap treeMap = new TreeMap(f2724a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        treeMap = new TreeMap(f2724a);
        treeMap.putAll(map2);
        Iterator it2 = treeMap.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            int compare = f2724a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            a = f2724a.compare(entry.getValue(), entry2.getValue());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static int m3464a(Set set, Set set2) {
        int a = ax.m3460a(set.size(), set2.size());
        if (a != 0) {
            return a;
        }
        SortedSet treeSet = new TreeSet(f2724a);
        treeSet.addAll(set);
        SortedSet treeSet2 = new TreeSet(f2724a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            a = f2724a.compare(it.next(), it2.next());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static int m3465a(byte[] bArr, byte[] bArr2) {
        int a = ax.m3460a(bArr.length, bArr2.length);
        if (a != 0) {
            return a;
        }
        for (a = 0; a < bArr.length; a++) {
            int a2 = ax.m3459a(bArr[a], bArr2[a]);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    public static String m3466a(byte b) {
        return Integer.toHexString((b | AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) & 511).toUpperCase().substring(1);
    }

    public static void m3467a(ByteBuffer byteBuffer, StringBuilder stringBuilder) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = arrayOffset + byteBuffer.position();
        int limit = byteBuffer.limit() + arrayOffset;
        arrayOffset = limit - position > SpdyProtocol.SLIGHTSSLV2 ? position + SpdyProtocol.SLIGHTSSLV2 : limit;
        for (int i = position; i < arrayOffset; i++) {
            if (i > position) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(ax.m3466a(array[i]));
        }
        if (limit != arrayOffset) {
            stringBuilder.append("...");
        }
    }
}
