package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c {
    static final String[] DW;
    private static final Pattern FH;
    public static final Object j6;
    private final ConcurrentHashMap<b, Integer> Hw;
    private final LinkedList<Map<String, Object>> VH;
    private final ReentrantLock Zo;
    private final c gn;
    private final CountDownLatch u7;
    private final Map<String, Object> v5;

    interface c {

        public interface a {
            void j6(List<a> list);
        }

        void j6(a aVar);

        void j6(List<a> list, long j);
    }

    class 1 implements c {
        1() {
        }

        public void j6(a aVar) {
            aVar.j6(new ArrayList());
        }

        public void j6(List<a> list, long j) {
        }
    }

    class 2 implements a {
        final /* synthetic */ c j6;

        2(c cVar) {
            this.j6 = cVar;
        }

        public void j6(List<a> list) {
            for (a aVar : list) {
                this.j6.DW(this.j6.j6(aVar.j6, aVar.DW));
            }
            this.j6.u7.countDown();
        }
    }

    static final class a {
        public final Object DW;
        public final String j6;

        a(String str, Object obj) {
            this.j6 = str;
            this.DW = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.j6.equals(aVar.j6) && this.DW.equals(aVar.DW);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.j6.hashCode()), Integer.valueOf(this.DW.hashCode())});
        }

        public String toString() {
            String str = this.j6;
            String valueOf = String.valueOf(this.DW.toString());
            return new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Key: ").append(str).append(" value: ").append(valueOf).toString();
        }
    }

    interface b {
        void j6(Map<String, Object> map);
    }

    static {
        j6 = new Object();
        DW = "gtm.lifetime".toString().split("\\.");
        FH = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }

    c() {
        this(new 1());
    }

    c(c cVar) {
        this.gn = cVar;
        this.Hw = new ConcurrentHashMap();
        this.v5 = new HashMap();
        this.Zo = new ReentrantLock();
        this.VH = new LinkedList();
        this.u7 = new CountDownLatch(1);
        j6();
    }

    private void DW() {
        int i = 0;
        while (true) {
            Map map = (Map) this.VH.poll();
            if (map != null) {
                VH(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    break;
                }
                i = i2;
            } else {
                return;
            }
        }
        this.VH.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    private void DW(Map<String, Object> map) {
        this.Zo.lock();
        try {
            this.VH.offer(map);
            if (this.Zo.getHoldCount() == 1) {
                DW();
            }
            FH(map);
        } finally {
            this.Zo.unlock();
        }
    }

    private void FH(Map<String, Object> map) {
        Long Hw = Hw(map);
        if (Hw != null) {
            List Zo = Zo(map);
            Zo.remove("gtm.lifetime");
            this.gn.j6(Zo, Hw.longValue());
        }
    }

    private Long Hw(Map<String, Object> map) {
        Object v5 = v5(map);
        return v5 == null ? null : j6(v5.toString());
    }

    private void VH(Map<String, Object> map) {
        synchronized (this.v5) {
            for (String str : map.keySet()) {
                j6(j6(str, map.get(str)), this.v5);
            }
        }
        gn(map);
    }

    private List<a> Zo(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        j6(map, "", arrayList);
        return arrayList;
    }

    private void gn(Map<String, Object> map) {
        for (b j6 : this.Hw.keySet()) {
            j6.j6(map);
        }
    }

    static Long j6(String str) {
        Matcher matcher = FH.matcher(str);
        String str2;
        String valueOf;
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                str2 = "illegal number in _lifetime value: ";
                valueOf = String.valueOf(str);
                r.DW(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                parseLong = 0;
            }
            if (parseLong <= 0) {
                str2 = "non-positive _lifetime: ";
                valueOf = String.valueOf(str);
                r.FH(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
            valueOf = matcher.group(2);
            if (valueOf.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (valueOf.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case 'h':
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    str2 = "unknown units in _lifetime: ";
                    valueOf = String.valueOf(str);
                    r.DW(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
            }
        }
        str2 = "unknown _lifetime: ";
        valueOf = String.valueOf(str);
        r.FH(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return null;
    }

    private void j6() {
        this.gn.j6(new 2(this));
    }

    private void j6(Map<String, Object> map, String str, Collection<a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String str3 = (String) entry.getKey();
            str3 = new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(str2).append(str3).toString();
            if (entry.getValue() instanceof Map) {
                j6((Map) entry.getValue(), str3, collection);
            } else if (!str3.equals("gtm.lifetime")) {
                collection.add(new a(str3, entry.getValue()));
            }
        }
    }

    private Object v5(Map<String, Object> map) {
        String[] strArr = DW;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    Map<String, Object> j6(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void j6(b bVar) {
        this.Hw.put(bVar, Integer.valueOf(0));
    }

    void j6(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                j6((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                j6((Map) obj, (Map) list2.get(i));
            } else if (obj != j6) {
                list2.set(i, obj);
            }
        }
    }

    public void j6(Map<String, Object> map) {
        try {
            this.u7.await();
        } catch (InterruptedException e) {
            r.DW("DataLayer.push: unexpected InterruptedException");
        }
        DW(map);
    }

    void j6(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                j6((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                j6((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.v5) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.v5.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
