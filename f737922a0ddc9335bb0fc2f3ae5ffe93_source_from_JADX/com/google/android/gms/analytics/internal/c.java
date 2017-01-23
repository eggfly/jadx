package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class c {
    private final List<Command> DW;
    private final long FH;
    private final long Hw;
    private final String VH;
    private final boolean Zo;
    private final Map<String, String> j6;
    private final int v5;

    public c(s sVar, Map<String, String> map, long j, boolean z) {
        this(sVar, map, j, z, 0, 0, null);
    }

    public c(s sVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(sVar, map, j, z, j2, i, null);
    }

    public c(s sVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        b.j6((Object) sVar);
        b.j6((Object) map);
        this.Hw = j;
        this.Zo = z;
        this.FH = j2;
        this.v5 = i;
        this.DW = list != null ? list : Collections.emptyList();
        this.VH = j6((List) list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String j6;
            if (j6(entry.getKey())) {
                j6 = j6(sVar, entry.getKey());
                if (j6 != null) {
                    hashMap.put(j6, DW(sVar, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!j6(entry2.getKey())) {
                j6 = j6(sVar, entry2.getKey());
                if (j6 != null) {
                    hashMap.put(j6, DW(sVar, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.VH)) {
            p.j6(hashMap, "_v", this.VH);
            if (this.VH.equals("ma4.0.0") || this.VH.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.j6 = Collections.unmodifiableMap(hashMap);
    }

    private static String DW(s sVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        sVar.FH("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    public static c j6(s sVar, c cVar, Map<String, String> map) {
        return new c(sVar, map, cVar.Hw(), cVar.Zo(), cVar.FH(), cVar.j6(), cVar.v5());
    }

    private static String j6(s sVar, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            sVar.FH("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private String j6(String str, String str2) {
        b.j6(str);
        b.DW(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.j6.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String j6(List<Command> list) {
        CharSequence DW;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.j6())) {
                    DW = command.DW();
                    break;
                }
            }
        }
        DW = null;
        return TextUtils.isEmpty(DW) ? null : DW;
    }

    private static boolean j6(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    public Map<String, String> DW() {
        return this.j6;
    }

    public long FH() {
        return this.FH;
    }

    public long Hw() {
        return this.Hw;
    }

    public long VH() {
        return p.j6(j6("_s", "0"));
    }

    public boolean Zo() {
        return this.Zo;
    }

    public String gn() {
        return j6("_m", "");
    }

    public int j6() {
        return this.v5;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.Hw);
        if (this.FH != 0) {
            stringBuffer.append(", dbId=").append(this.FH);
        }
        if (this.v5 != 0) {
            stringBuffer.append(", appUID=").append(this.v5);
        }
        List<String> arrayList = new ArrayList(this.j6.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.j6.get(str));
        }
        return stringBuffer.toString();
    }

    public List<Command> v5() {
        return this.DW;
    }
}
