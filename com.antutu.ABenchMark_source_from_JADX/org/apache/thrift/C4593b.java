package org.apache.thrift;

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

/* renamed from: org.apache.thrift.b */
public final class C4593b {
    private static final Comparator f16440a;

    /* renamed from: org.apache.thrift.b.a */
    private static class C4592a implements Comparator {
        private C4592a() {
        }

        public int compare(Object obj, Object obj2) {
            return (obj == null && obj2 == null) ? 0 : obj == null ? -1 : obj2 == null ? 1 : obj instanceof List ? C4593b.m19286a((List) obj, (List) obj2) : obj instanceof Set ? C4593b.m19288a((Set) obj, (Set) obj2) : obj instanceof Map ? C4593b.m19287a((Map) obj, (Map) obj2) : obj instanceof byte[] ? C4593b.m19291a((byte[]) obj, (byte[]) obj2) : C4593b.m19283a((Comparable) obj, (Comparable) obj2);
        }
    }

    static {
        f16440a = new C4592a();
    }

    public static int m19280a(byte b, byte b2) {
        return b < b2 ? -1 : b2 < b ? 1 : 0;
    }

    public static int m19281a(int i, int i2) {
        return i < i2 ? -1 : i2 < i ? 1 : 0;
    }

    public static int m19282a(long j, long j2) {
        return j < j2 ? -1 : j2 < j ? 1 : 0;
    }

    public static int m19283a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int m19284a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int m19285a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i, remaining);
        return remaining;
    }

    public static int m19286a(List list, List list2) {
        int a = C4593b.m19281a(list.size(), list2.size());
        if (a != 0) {
            return a;
        }
        for (a = 0; a < list.size(); a++) {
            int compare = f16440a.compare(list.get(a), list2.get(a));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int m19287a(Map map, Map map2) {
        int a = C4593b.m19281a(map.size(), map2.size());
        if (a != 0) {
            return a;
        }
        SortedMap treeMap = new TreeMap(f16440a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        treeMap = new TreeMap(f16440a);
        treeMap.putAll(map2);
        Iterator it2 = treeMap.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            int compare = f16440a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            a = f16440a.compare(entry.getValue(), entry2.getValue());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static int m19288a(Set set, Set set2) {
        int a = C4593b.m19281a(set.size(), set2.size());
        if (a != 0) {
            return a;
        }
        SortedSet treeSet = new TreeSet(f16440a);
        treeSet.addAll(set);
        SortedSet treeSet2 = new TreeSet(f16440a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            a = f16440a.compare(it.next(), it2.next());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static int m19289a(short s, short s2) {
        return s < s2 ? -1 : s2 < s ? 1 : 0;
    }

    public static int m19290a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int m19291a(byte[] bArr, byte[] bArr2) {
        int a = C4593b.m19281a(bArr.length, bArr2.length);
        if (a != 0) {
            return a;
        }
        for (a = 0; a < bArr.length; a++) {
            int a2 = C4593b.m19280a(bArr[a], bArr2[a]);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    public static String m19292a(byte b) {
        return Integer.toHexString((b | AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) & 511).toUpperCase().substring(1);
    }

    public static void m19293a(ByteBuffer byteBuffer, StringBuilder stringBuilder) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > SpdyProtocol.SLIGHTSSLV2 ? arrayOffset + SpdyProtocol.SLIGHTSSLV2 : limit;
        for (int i2 = arrayOffset; i2 < i; i2++) {
            if (i2 > arrayOffset) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(C4593b.m19292a(array[i2]));
        }
        if (limit != i) {
            stringBuilder.append("...");
        }
    }

    public static byte[] m19294a(ByteBuffer byteBuffer) {
        if (C4593b.m19295b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        C4593b.m19285a(byteBuffer, bArr, 0);
        return bArr;
    }

    public static boolean m19295b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static ByteBuffer m19296c(ByteBuffer byteBuffer) {
        return C4593b.m19295b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(C4593b.m19294a(byteBuffer));
    }
}
