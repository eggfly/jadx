package com.google.android.gms.tagmanager;

import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.internal.d;
import com.google.android.gms.internal.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ak {
    private static final ab<com.google.android.gms.internal.h.a> j6;
    private final h DW;
    private volatile String EQ;
    private final Map<String, i> FH;
    private final Map<String, i> Hw;
    private final av<String, b> VH;
    private final av<com.google.android.gms.internal.d.a, ab<com.google.android.gms.internal.h.a>> Zo;
    private final Set<com.google.android.gms.internal.d.b> gn;
    private final Map<String, c> tp;
    private final c u7;
    private final Map<String, i> v5;
    private int we;

    interface a {
        void j6(com.google.android.gms.internal.d.b bVar, Set<com.google.android.gms.internal.d.a> set, Set<com.google.android.gms.internal.d.a> set2, ai aiVar);
    }

    class 1 implements a {
        final /* synthetic */ Map DW;
        final /* synthetic */ Map FH;
        final /* synthetic */ Map Hw;
        final /* synthetic */ Map j6;
        final /* synthetic */ ak v5;

        1(ak akVar, Map map, Map map2, Map map3, Map map4) {
            this.v5 = akVar;
            this.j6 = map;
            this.DW = map2;
            this.FH = map3;
            this.Hw = map4;
        }

        public void j6(com.google.android.gms.internal.d.b bVar, Set<com.google.android.gms.internal.d.a> set, Set<com.google.android.gms.internal.d.a> set2, ai aiVar) {
            List list = (List) this.j6.get(bVar);
            List list2 = (List) this.DW.get(bVar);
            if (list != null) {
                set.addAll(list);
                aiVar.FH().j6(list, list2);
            }
            list = (List) this.FH.get(bVar);
            list2 = (List) this.Hw.get(bVar);
            if (list != null) {
                set2.addAll(list);
                aiVar.Hw().j6(list, list2);
            }
        }
    }

    class 2 implements a {
        final /* synthetic */ ak j6;

        2(ak akVar) {
            this.j6 = akVar;
        }

        public void j6(com.google.android.gms.internal.d.b bVar, Set<com.google.android.gms.internal.d.a> set, Set<com.google.android.gms.internal.d.a> set2, ai aiVar) {
            set.addAll(bVar.FH());
            set2.addAll(bVar.Hw());
            aiVar.v5().j6(bVar.FH(), bVar.Zo());
            aiVar.Zo().j6(bVar.Hw(), bVar.VH());
        }
    }

    private static class b {
        private com.google.android.gms.internal.h.a DW;
        private ab<com.google.android.gms.internal.h.a> j6;

        public b(ab<com.google.android.gms.internal.h.a> abVar, com.google.android.gms.internal.h.a aVar) {
            this.j6 = abVar;
            this.DW = aVar;
        }

        public com.google.android.gms.internal.h.a DW() {
            return this.DW;
        }

        public ab<com.google.android.gms.internal.h.a> j6() {
            return this.j6;
        }
    }

    private static class c {
        private final Map<com.google.android.gms.internal.d.b, List<com.google.android.gms.internal.d.a>> DW;
        private final Map<com.google.android.gms.internal.d.b, List<com.google.android.gms.internal.d.a>> FH;
        private final Map<com.google.android.gms.internal.d.b, List<String>> Hw;
        private com.google.android.gms.internal.d.a Zo;
        private final Set<com.google.android.gms.internal.d.b> j6;
        private final Map<com.google.android.gms.internal.d.b, List<String>> v5;

        public c() {
            this.j6 = new HashSet();
            this.DW = new HashMap();
            this.Hw = new HashMap();
            this.FH = new HashMap();
            this.v5 = new HashMap();
        }

        public Map<com.google.android.gms.internal.d.b, List<com.google.android.gms.internal.d.a>> DW() {
            return this.DW;
        }

        public Map<com.google.android.gms.internal.d.b, List<String>> FH() {
            return this.Hw;
        }

        public Map<com.google.android.gms.internal.d.b, List<String>> Hw() {
            return this.v5;
        }

        public com.google.android.gms.internal.d.a Zo() {
            return this.Zo;
        }

        public Set<com.google.android.gms.internal.d.b> j6() {
            return this.j6;
        }

        public Map<com.google.android.gms.internal.d.b, List<com.google.android.gms.internal.d.a>> v5() {
            return this.FH;
        }
    }

    static {
        j6 = new ab(as.j6(), true);
    }

    private ab<com.google.android.gms.internal.h.a> j6(com.google.android.gms.internal.h.a aVar, Set<String> set, at atVar) {
        if (!aVar.we) {
            return new ab(aVar, true);
        }
        com.google.android.gms.internal.h.a j6;
        int i;
        ab j62;
        String str;
        String valueOf;
        switch (aVar.j6) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6 = d.j6(aVar);
                j6.FH = new com.google.android.gms.internal.h.a[aVar.FH.length];
                for (i = 0; i < aVar.FH.length; i++) {
                    j62 = j6(aVar.FH[i], (Set) set, atVar.j6(i));
                    if (j62 == j6) {
                        return j6;
                    }
                    j6.FH[i] = (com.google.android.gms.internal.h.a) j62.j6();
                }
                return new ab(j6, false);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6 = d.j6(aVar);
                if (aVar.Hw.length != aVar.v5.length) {
                    str = "Invalid serving value: ";
                    valueOf = String.valueOf(aVar.toString());
                    r.j6(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return j6;
                }
                j6.Hw = new com.google.android.gms.internal.h.a[aVar.Hw.length];
                j6.v5 = new com.google.android.gms.internal.h.a[aVar.Hw.length];
                for (i = 0; i < aVar.Hw.length; i++) {
                    j62 = j6(aVar.Hw[i], (Set) set, atVar.DW(i));
                    ab j63 = j6(aVar.v5[i], (Set) set, atVar.FH(i));
                    if (j62 == j6 || j63 == j6) {
                        return j6;
                    }
                    j6.Hw[i] = (com.google.android.gms.internal.h.a) j62.j6();
                    j6.v5[i] = (com.google.android.gms.internal.h.a) j63.j6();
                }
                return new ab(j6, false);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                if (set.contains(aVar.Zo)) {
                    valueOf = String.valueOf(aVar.Zo);
                    str = String.valueOf(set.toString());
                    r.j6(new StringBuilder((String.valueOf(valueOf).length() + 79) + String.valueOf(str).length()).append("Macro cycle detected.  Current macro reference: ").append(valueOf).append(".  Previous macro references: ").append(str).append(".").toString());
                    return j6;
                }
                set.add(aVar.Zo);
                ab<com.google.android.gms.internal.h.a> j64 = au.j6(j6(aVar.Zo, (Set) set, atVar.j6()), aVar.EQ);
                set.remove(aVar.Zo);
                return j64;
            case 7:
                j6 = d.j6(aVar);
                j6.tp = new com.google.android.gms.internal.h.a[aVar.tp.length];
                for (i = 0; i < aVar.tp.length; i++) {
                    j62 = j6(aVar.tp[i], (Set) set, atVar.Hw(i));
                    if (j62 == j6) {
                        return j6;
                    }
                    j6.tp[i] = (com.google.android.gms.internal.h.a) j62.j6();
                }
                return new ab(j6, false);
            default:
                r.j6("Unknown type: " + aVar.j6);
                return j6;
        }
    }

    private ab<com.google.android.gms.internal.h.a> j6(String str, Set<String> set, t tVar) {
        this.we++;
        b bVar = (b) this.VH.j6(str);
        if (bVar == null || this.DW.j6()) {
            c cVar = (c) this.tp.get(str);
            String valueOf;
            if (cVar == null) {
                valueOf = String.valueOf(j6());
                r.j6(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(str).length()).append(valueOf).append("Invalid macro: ").append(str).toString());
                this.we--;
                return j6;
            }
            com.google.android.gms.internal.d.a Zo;
            ab j6 = j6(str, cVar.j6(), cVar.DW(), cVar.FH(), cVar.v5(), cVar.Hw(), set, tVar.DW());
            if (((Set) j6.j6()).isEmpty()) {
                Zo = cVar.Zo();
            } else {
                if (((Set) j6.j6()).size() > 1) {
                    valueOf = String.valueOf(j6());
                    r.DW(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str).length()).append(valueOf).append("Multiple macros active for macroName ").append(str).toString());
                }
                Zo = (com.google.android.gms.internal.d.a) ((Set) j6.j6()).iterator().next();
            }
            if (Zo == null) {
                this.we--;
                return j6;
            }
            ab j62 = j6(this.v5, Zo, (Set) set, tVar.j6());
            boolean z = j6.DW() && j62.DW();
            ab<com.google.android.gms.internal.h.a> abVar = j62 == j6 ? j6 : new ab((com.google.android.gms.internal.h.a) j62.j6(), z);
            com.google.android.gms.internal.h.a DW = Zo.DW();
            if (abVar.DW()) {
                this.VH.j6(str, new b(abVar, DW));
            }
            j6(DW, (Set) set);
            this.we--;
            return abVar;
        }
        j6(bVar.DW(), (Set) set);
        this.we--;
        return bVar.j6();
    }

    private ab<com.google.android.gms.internal.h.a> j6(Map<String, i> map, com.google.android.gms.internal.d.a aVar, Set<String> set, af afVar) {
        boolean z = true;
        com.google.android.gms.internal.h.a aVar2 = (com.google.android.gms.internal.h.a) aVar.j6().get(g.FUNCTION.toString());
        if (aVar2 == null) {
            r.j6("No function id in properties");
            return j6;
        }
        String str = aVar2.VH;
        i iVar = (i) map.get(str);
        if (iVar == null) {
            r.j6(String.valueOf(str).concat(" has no backing implementation."));
            return j6;
        }
        ab<com.google.android.gms.internal.h.a> abVar = (ab) this.Zo.j6(aVar);
        if (abVar != null && !this.DW.j6()) {
            return abVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : aVar.j6().entrySet()) {
            ab j6 = j6((com.google.android.gms.internal.h.a) entry.getValue(), (Set) set, afVar.j6((String) entry.getKey()).j6((com.google.android.gms.internal.h.a) entry.getValue()));
            if (j6 == j6) {
                return j6;
            }
            boolean z3;
            if (j6.DW()) {
                aVar.j6((String) entry.getKey(), (com.google.android.gms.internal.h.a) j6.j6());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put((String) entry.getKey(), (com.google.android.gms.internal.h.a) j6.j6());
            z2 = z3;
        }
        if (iVar.j6(hashMap.keySet())) {
            if (!(z2 && iVar.j6())) {
                z = false;
            }
            abVar = new ab(iVar.j6(hashMap), z);
            if (z) {
                this.Zo.j6(aVar, abVar);
            }
            afVar.j6((com.google.android.gms.internal.h.a) abVar.j6());
            return abVar;
        }
        String valueOf = String.valueOf(iVar.DW());
        String valueOf2 = String.valueOf(hashMap.keySet());
        r.j6(new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append("Incorrect keys for function ").append(str).append(" required ").append(valueOf).append(" had ").append(valueOf2).toString());
        return j6;
    }

    private ab<Set<com.google.android.gms.internal.d.a>> j6(Set<com.google.android.gms.internal.d.b> set, Set<String> set2, a aVar, aj ajVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (com.google.android.gms.internal.d.b bVar : set) {
            ai j6 = ajVar.j6();
            ab j62 = j6(bVar, (Set) set2, j6);
            if (((Boolean) j62.j6()).booleanValue()) {
                aVar.j6(bVar, hashSet, hashSet2, j6);
            }
            boolean z2 = z && j62.DW();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        ajVar.j6(hashSet);
        return new ab(hashSet, z);
    }

    private String j6() {
        if (this.we <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.we));
        for (int i = 2; i < this.we; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    private void j6(com.google.android.gms.internal.h.a aVar, Set<String> set) {
        if (aVar != null) {
            ab j6 = j6(aVar, (Set) set, new aa());
            if (j6 != j6) {
                Object FH = as.FH((com.google.android.gms.internal.h.a) j6.j6());
                if (FH instanceof Map) {
                    this.u7.j6((Map) FH);
                } else if (FH instanceof List) {
                    for (Object FH2 : (List) FH2) {
                        if (FH2 instanceof Map) {
                            this.u7.j6((Map) FH2);
                        } else {
                            r.DW("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    r.DW("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    synchronized void DW(String str) {
        this.EQ = str;
    }

    ab<Boolean> j6(com.google.android.gms.internal.d.a aVar, Set<String> set, af afVar) {
        ab j6 = j6(this.Hw, aVar, (Set) set, afVar);
        Object DW = as.DW((com.google.android.gms.internal.h.a) j6.j6());
        afVar.j6(as.FH(DW));
        return new ab(DW, j6.DW());
    }

    ab<Boolean> j6(com.google.android.gms.internal.d.b bVar, Set<String> set, ai aiVar) {
        boolean z = true;
        for (com.google.android.gms.internal.d.a j6 : bVar.DW()) {
            ab j62 = j6(j6, (Set) set, aiVar.j6());
            if (((Boolean) j62.j6()).booleanValue()) {
                aiVar.j6(as.FH(Boolean.valueOf(false)));
                return new ab(Boolean.valueOf(false), j62.DW());
            }
            boolean z2 = z && j62.DW();
            z = z2;
        }
        for (com.google.android.gms.internal.d.a j63 : bVar.j6()) {
            j62 = j6(j63, (Set) set, aiVar.DW());
            if (((Boolean) j62.j6()).booleanValue()) {
                z = z && j62.DW();
            } else {
                aiVar.j6(as.FH(Boolean.valueOf(false)));
                return new ab(Boolean.valueOf(false), j62.DW());
            }
        }
        aiVar.j6(as.FH(Boolean.valueOf(true)));
        return new ab(Boolean.valueOf(true), z);
    }

    ab<Set<com.google.android.gms.internal.d.a>> j6(String str, Set<com.google.android.gms.internal.d.b> set, Map<com.google.android.gms.internal.d.b, List<com.google.android.gms.internal.d.a>> map, Map<com.google.android.gms.internal.d.b, List<String>> map2, Map<com.google.android.gms.internal.d.b, List<com.google.android.gms.internal.d.a>> map3, Map<com.google.android.gms.internal.d.b, List<String>> map4, Set<String> set2, aj ajVar) {
        return j6((Set) set, (Set) set2, new 1(this, map, map2, map3, map4), ajVar);
    }

    ab<Set<com.google.android.gms.internal.d.a>> j6(Set<com.google.android.gms.internal.d.b> set, aj ajVar) {
        return j6((Set) set, new HashSet(), new 2(this), ajVar);
    }

    public synchronized void j6(String str) {
        DW(str);
        g j6 = this.DW.j6(str);
        ay j62 = j6.j6();
        for (com.google.android.gms.internal.d.a j63 : (Set) j6(this.gn, j62.DW()).j6()) {
            j6(this.FH, j63, new HashSet(), j62.j6());
        }
        j6.DW();
        DW(null);
    }
}
