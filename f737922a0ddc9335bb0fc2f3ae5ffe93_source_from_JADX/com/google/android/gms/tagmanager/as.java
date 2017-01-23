package com.google.android.gms.tagmanager;

import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.internal.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class as {
    private static Long DW;
    private static Double FH;
    private static ar Hw;
    private static List<Object> VH;
    private static Boolean Zo;
    private static Map<Object, Object> gn;
    private static final Object j6;
    private static a u7;
    private static String v5;

    static {
        j6 = null;
        DW = new Long(0);
        FH = new Double(0.0d);
        Hw = ar.j6(0);
        v5 = new String("");
        Zo = new Boolean(false);
        VH = new ArrayList(0);
        gn = new HashMap();
        u7 = FH(v5);
    }

    public static Boolean DW(a aVar) {
        return DW(FH(aVar));
    }

    public static Boolean DW(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : j6(j6(obj));
    }

    public static a FH(Object obj) {
        boolean z = false;
        a aVar = new a();
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof String) {
            aVar.j6 = 1;
            aVar.DW = (String) obj;
        } else if (obj instanceof List) {
            aVar.j6 = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object FH : list) {
                a FH2 = FH(FH);
                if (FH2 == u7) {
                    return u7;
                }
                r0 = r1 || FH2.we;
                r5.add(FH2);
                r1 = r0;
            }
            aVar.FH = (a[]) r5.toArray(new a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            aVar.j6 = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                a FH3 = FH(entry.getKey());
                a FH4 = FH(entry.getValue());
                if (FH3 == u7 || FH4 == u7) {
                    return u7;
                }
                r0 = r1 || FH3.we || FH4.we;
                r5.add(FH3);
                arrayList.add(FH4);
                r1 = r0;
            }
            aVar.Hw = (a[]) r5.toArray(new a[0]);
            aVar.v5 = (a[]) arrayList.toArray(new a[0]);
            z = r1;
        } else if (Hw(obj)) {
            aVar.j6 = 1;
            aVar.DW = obj.toString();
        } else if (v5(obj)) {
            aVar.j6 = 6;
            aVar.gn = Zo(obj);
        } else if (obj instanceof Boolean) {
            aVar.j6 = 8;
            aVar.u7 = ((Boolean) obj).booleanValue();
        } else {
            String str = "Converting to Value from unknown object type: ";
            String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
            r.j6(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return u7;
        }
        aVar.we = z;
        return aVar;
    }

    public static Object FH(a aVar) {
        int i = 0;
        if (aVar == null) {
            return null;
        }
        a[] aVarArr;
        int length;
        switch (aVar.j6) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return aVar.DW;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                ArrayList arrayList = new ArrayList(aVar.FH.length);
                aVarArr = aVar.FH;
                length = aVarArr.length;
                while (i < length) {
                    Object FH = FH(aVarArr[i]);
                    if (FH == null) {
                        return null;
                    }
                    arrayList.add(FH);
                    i++;
                }
                return arrayList;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (aVar.Hw.length != aVar.v5.length) {
                    String str = "Converting an invalid value to object: ";
                    String valueOf = String.valueOf(aVar.toString());
                    r.j6(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return null;
                }
                Map hashMap = new HashMap(aVar.v5.length);
                while (i < aVar.Hw.length) {
                    Object FH2 = FH(aVar.Hw[i]);
                    Object FH3 = FH(aVar.v5[i]);
                    if (FH2 == null || FH3 == null) {
                        return null;
                    }
                    hashMap.put(FH2, FH3);
                    i++;
                }
                return hashMap;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                r.j6("Trying to convert a macro reference to object");
                return null;
            case 5:
                r.j6("Trying to convert a function id to object");
                return null;
            case 6:
                return Long.valueOf(aVar.gn);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                aVarArr = aVar.tp;
                length = aVarArr.length;
                while (i < length) {
                    String j6 = j6(aVarArr[i]);
                    if (j6 == v5) {
                        return null;
                    }
                    stringBuffer.append(j6);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.u7);
            default:
                r.j6("Failed to convert a value of type: " + aVar.j6);
                return null;
        }
    }

    private static boolean Hw(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof ar) && ((ar) obj).j6());
    }

    private static long Zo(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        r.j6("getInt64 received non-Number");
        return 0;
    }

    public static a j6() {
        return u7;
    }

    private static Boolean j6(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : Zo;
    }

    public static String j6(a aVar) {
        return j6(FH(aVar));
    }

    public static String j6(Object obj) {
        return obj == null ? v5 : obj.toString();
    }

    private static boolean v5(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof ar) && ((ar) obj).DW());
    }
}
