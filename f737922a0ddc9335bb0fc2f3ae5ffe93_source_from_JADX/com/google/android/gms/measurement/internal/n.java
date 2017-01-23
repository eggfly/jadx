package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.hr.a;
import com.google.android.gms.internal.hr.b;
import com.google.android.gms.internal.hr.c;
import com.google.android.gms.internal.hr.e;
import com.google.android.gms.internal.ht;
import com.google.android.gms.internal.ht.f;
import com.google.android.gms.internal.ht.g;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.d;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import l;

class n extends b {
    n(ai aiVar) {
        super(aiVar);
    }

    private Boolean j6(b bVar, ht.b bVar2, long j) {
        Boolean j6;
        if (bVar.v5 != null) {
            j6 = new ad(bVar.v5).j6(j);
            if (j6 == null) {
                return null;
            }
            if (!j6.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (c cVar : bVar.FH) {
            if (TextUtils.isEmpty(cVar.Hw)) {
                lg().yS().j6("null or empty param name in filter. event", bVar2.DW);
                return null;
            }
            hashSet.add(cVar.Hw);
        }
        Map lVar = new l();
        for (ht.c cVar2 : bVar2.j6) {
            if (hashSet.contains(cVar2.j6)) {
                if (cVar2.FH != null) {
                    lVar.put(cVar2.j6, cVar2.FH);
                } else if (cVar2.v5 != null) {
                    lVar.put(cVar2.j6, cVar2.v5);
                } else if (cVar2.DW != null) {
                    lVar.put(cVar2.j6, cVar2.DW);
                } else {
                    lg().yS().j6("Unknown value for param. event, param", bVar2.DW, cVar2.j6);
                    return null;
                }
            }
        }
        for (c cVar3 : bVar.FH) {
            boolean equals = Boolean.TRUE.equals(cVar3.FH);
            CharSequence charSequence = cVar3.Hw;
            if (TextUtils.isEmpty(charSequence)) {
                lg().yS().j6("Event has empty param name. event", bVar2.DW);
                return null;
            }
            Object obj = lVar.get(charSequence);
            if (obj instanceof Long) {
                if (cVar3.DW == null) {
                    lg().yS().j6("No number filter for long param. event, param", bVar2.DW, charSequence);
                    return null;
                }
                j6 = new ad(cVar3.DW).j6(((Long) obj).longValue());
                if (j6 == null) {
                    return null;
                }
                if (((!j6.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (cVar3.DW == null) {
                    lg().yS().j6("No number filter for double param. event, param", bVar2.DW, charSequence);
                    return null;
                }
                j6 = new ad(cVar3.DW).j6(((Double) obj).doubleValue());
                if (j6 == null) {
                    return null;
                }
                if (((!j6.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (cVar3.j6 == null) {
                    lg().yS().j6("No string filter for String param. event, param", bVar2.DW, charSequence);
                    return null;
                }
                j6 = new g(cVar3.j6).j6((String) obj);
                if (j6 == null) {
                    return null;
                }
                if (((!j6.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                lg().ei().j6("Missing param for filter. event, param", bVar2.DW, charSequence);
                return Boolean.valueOf(false);
            } else {
                lg().yS().j6("Unknown param type. event, param", bVar2.DW, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean j6(e eVar, g gVar) {
        Boolean bool = null;
        c cVar = eVar.FH;
        if (cVar == null) {
            lg().yS().j6("Missing property filter. property", gVar.DW);
            return bool;
        }
        boolean equals = Boolean.TRUE.equals(cVar.FH);
        if (gVar.Hw != null) {
            if (cVar.DW != null) {
                return j6(new ad(cVar.DW).j6(gVar.Hw.longValue()), equals);
            }
            lg().yS().j6("No number filter for long property. property", gVar.DW);
            return bool;
        } else if (gVar.Zo != null) {
            if (cVar.DW != null) {
                return j6(new ad(cVar.DW).j6(gVar.Zo.doubleValue()), equals);
            }
            lg().yS().j6("No number filter for double property. property", gVar.DW);
            return bool;
        } else if (gVar.FH == null) {
            lg().yS().j6("User property has no value, property", gVar.DW);
            return bool;
        } else if (cVar.j6 != null) {
            return j6(new g(cVar.j6).j6(gVar.FH), equals);
        } else {
            if (cVar.DW == null) {
                lg().yS().j6("No string or number filter defined. property", gVar.DW);
                return bool;
            }
            ad adVar = new ad(cVar.DW);
            if (cVar.DW.DW == null || !cVar.DW.DW.booleanValue()) {
                if (j6(gVar.FH)) {
                    try {
                        return j6(adVar.j6(Long.parseLong(gVar.FH)), equals);
                    } catch (NumberFormatException e) {
                        lg().yS().j6("User property value exceeded Long value range. property, value", gVar.DW, gVar.FH);
                        return bool;
                    }
                }
                lg().yS().j6("Invalid user property value for Long number filter. property, value", gVar.DW, gVar.FH);
                return bool;
            } else if (DW(gVar.FH)) {
                try {
                    double parseDouble = Double.parseDouble(gVar.FH);
                    if (!Double.isInfinite(parseDouble)) {
                        return j6(adVar.j6(parseDouble), equals);
                    }
                    lg().yS().j6("User property value exceeded Double value range. property, value", gVar.DW, gVar.FH);
                    return bool;
                } catch (NumberFormatException e2) {
                    lg().yS().j6("User property value exceeded Double value range. property, value", gVar.DW, gVar.FH);
                    return bool;
                }
            } else {
                lg().yS().j6("Invalid user property value for Double number filter. property, value", gVar.DW, gVar.FH);
                return bool;
            }
        }
    }

    static Boolean j6(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    boolean DW(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    void j6(String str, a[] aVarArr) {
        com.google.android.gms.common.internal.b.j6((Object) aVarArr);
        for (a aVar : aVarArr) {
            for (b bVar : aVar.FH) {
                String str2 = (String) AppMeasurement.a.j6.get(bVar.DW);
                if (str2 != null) {
                    bVar.DW = str2;
                }
                for (c cVar : bVar.FH) {
                    str2 = (String) d.j6.get(cVar.Hw);
                    if (str2 != null) {
                        cVar.Hw = str2;
                    }
                }
            }
            for (e eVar : aVar.DW) {
                str2 = (String) AppMeasurement.e.j6.get(eVar.DW);
                if (str2 != null) {
                    eVar.DW = str2;
                }
            }
        }
        aM().j6(str, aVarArr);
    }

    boolean j6(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    ht.a[] j6(String str, ht.b[] bVarArr, g[] gVarArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean j6;
        Object obj;
        com.google.android.gms.common.internal.b.j6(str);
        Set hashSet = new HashSet();
        l lVar = new l();
        Map lVar2 = new l();
        l lVar3 = new l();
        Map Zo = aM().Zo(str);
        if (Zo != null) {
            for (Integer intValue2 : Zo.keySet()) {
                intValue = intValue2.intValue();
                f fVar = (f) Zo.get(Integer.valueOf(intValue));
                bitSet = (BitSet) lVar2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) lVar3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    lVar2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    lVar3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < fVar.j6.length * 64; i++) {
                    if (l.j6(fVar.j6, i)) {
                        lg().ei().j6("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (l.j6(fVar.DW, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                ht.a aVar = new ht.a();
                lVar.put(Integer.valueOf(intValue), aVar);
                aVar.Hw = Boolean.valueOf(false);
                aVar.FH = fVar;
                aVar.DW = new f();
                aVar.DW.DW = l.j6(bitSet);
                aVar.DW.j6 = l.j6(bitSet2);
            }
        }
        if (bVarArr != null) {
            l lVar4 = new l();
            for (ht.b bVar : bVarArr) {
                t tVar;
                t j62 = aM().j6(str, bVar.DW);
                if (j62 == null) {
                    lg().yS().j6("Event aggregate wasn't created during raw event logging. event", bVar.DW);
                    tVar = new t(str, bVar.DW, 1, 1, bVar.FH.longValue());
                } else {
                    tVar = j62.j6();
                }
                aM().j6(tVar);
                long j = tVar.FH;
                map = (Map) lVar4.get(bVar.DW);
                if (map == null) {
                    map = aM().Hw(str, bVar.DW);
                    if (map == null) {
                        map = new l();
                    }
                    lVar4.put(bVar.DW, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                lg().ei().j6("event, affected audience count", bVar.DW, Integer.valueOf(map2.size()));
                for (Integer intValue22 : map2.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        lg().ei().j6("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) lVar2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) lVar3.get(Integer.valueOf(intValue3));
                        if (((ht.a) lVar.get(Integer.valueOf(intValue3))) == null) {
                            ht.a aVar2 = new ht.a();
                            lVar.put(Integer.valueOf(intValue3), aVar2);
                            aVar2.Hw = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            lVar2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            lVar3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (b bVar2 : (List) map2.get(Integer.valueOf(intValue3))) {
                            if (lg().j6(2)) {
                                lg().ei().j6("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), bVar2.j6, bVar2.DW);
                                lg().ei().j6("Filter definition", l.j6(bVar2));
                            }
                            if (bVar2.j6 == null || bVar2.j6.intValue() > 256) {
                                lg().yS().j6("Invalid event filter ID. id", String.valueOf(bVar2.j6));
                            } else if (bitSet.get(bVar2.j6.intValue())) {
                                lg().ei().j6("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), bVar2.j6);
                            } else {
                                j6 = j6(bVar2, bVar, j);
                                aa.a ei = lg().ei();
                                String str2 = "Event filter result";
                                if (j6 == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = j6;
                                }
                                ei.j6(str2, obj);
                                if (j6 == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(bVar2.j6.intValue());
                                    if (j6.booleanValue()) {
                                        bitSet.set(bVar2.j6.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (gVarArr != null) {
            Map lVar5 = new l();
            for (g gVar : gVarArr) {
                map = (Map) lVar5.get(gVar.DW);
                if (map == null) {
                    map = aM().v5(str, gVar.DW);
                    if (map == null) {
                        map = new l();
                    }
                    lVar5.put(gVar.DW, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                lg().ei().j6("property, affected audience count", gVar.DW, Integer.valueOf(map2.size()));
                for (Integer intValue222 : map2.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        lg().ei().j6("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) lVar2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) lVar3.get(Integer.valueOf(intValue4));
                        if (((ht.a) lVar.get(Integer.valueOf(intValue4))) == null) {
                            aVar2 = new ht.a();
                            lVar.put(Integer.valueOf(intValue4), aVar2);
                            aVar2.Hw = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            lVar2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            lVar3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (e eVar : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (lg().j6(2)) {
                                lg().ei().j6("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), eVar.j6, eVar.DW);
                                lg().ei().j6("Filter definition", l.j6(eVar));
                            }
                            if (eVar.j6 == null || eVar.j6.intValue() > 256) {
                                lg().yS().j6("Invalid property filter ID. id", String.valueOf(eVar.j6));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(eVar.j6.intValue())) {
                                lg().ei().j6("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), eVar.j6);
                            } else {
                                j6 = j6(eVar, gVar);
                                aa.a ei2 = lg().ei();
                                String str3 = "Property filter result";
                                if (j6 == null) {
                                    obj = "null";
                                } else {
                                    bool = j6;
                                }
                                ei2.j6(str3, obj);
                                if (j6 == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(eVar.j6.intValue());
                                    if (j6.booleanValue()) {
                                        bitSet.set(eVar.j6.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ht.a[] aVarArr = new ht.a[lVar2.size()];
        int i2 = 0;
        for (Integer intValue2222 : lVar2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                aVar2 = (ht.a) lVar.get(Integer.valueOf(intValue));
                aVar = aVar2 == null ? new ht.a() : aVar2;
                int i3 = i2 + 1;
                aVarArr[i2] = aVar;
                aVar.j6 = Integer.valueOf(intValue);
                aVar.DW = new f();
                aVar.DW.DW = l.j6((BitSet) lVar2.get(Integer.valueOf(intValue)));
                aVar.DW.j6 = l.j6((BitSet) lVar3.get(Integer.valueOf(intValue)));
                aM().j6(str, intValue, aVar.DW);
                i2 = i3;
            }
        }
        return (ht.a[]) Arrays.copyOf(aVarArr, i2);
    }

    protected void v5() {
    }
}
