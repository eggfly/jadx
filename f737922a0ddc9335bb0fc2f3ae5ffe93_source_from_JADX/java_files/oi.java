import com.aide.engine.EngineSolution;
import com.aide.engine.EngineSolution.File;
import com.aide.engine.EngineSolutionProject;
import com.aide.engine.service.l;
import com.aide.ui.build.android.m;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class oi {
    public static EngineSolution j6() {
        String VH = e.a8().VH();
        String v5 = e.Ws().v5();
        String Hw = e.Ws().Hw();
        String v52 = e.a8().v5();
        List arrayList = new ArrayList();
        int i = 0;
        for (String str : e.a8().tp()) {
            i |= oh.v5(str);
            j6(arrayList, str, v52, i, false, e.a8().EQ(str), new HashSet());
        }
        if (i != 0) {
            arrayList.add(j6(Hw));
        }
        arrayList.add(j6(VH, v5));
        return new EngineSolution(arrayList, null, l.j6(e.DW()), e.DW());
    }

    private static void j6(List<EngineSolutionProject> list, String str, String str2, boolean z, boolean z2, Map<String, List<String>> map, Set<String> set) {
        if (!set.contains(str)) {
            set.add(str);
            List<od$a> gn = ok.gn(str, str2);
            list.add(j6(str, str2, z, z2, gn, map));
            for (od$a od_a : gn) {
                if (od_a.v5()) {
                    for (EngineSolutionProject engineSolutionProject : list) {
                        if (engineSolutionProject.j6.equals(od_a.DW())) {
                            break;
                        }
                    }
                    list.add(j6(str, str2, od_a, gn, map));
                }
            }
            for (String j6 : (List) map.get(str)) {
                j6(list, j6, str2, z, true, map, set);
            }
        }
    }

    private static EngineSolutionProject j6(String str, String str2, od$a od_a, List<od$a> list, Map<String, List<String>> map) {
        List arrayList = new ArrayList();
        String j6 = od_a.j6(str);
        arrayList.add(new File(j6, "Java Binary", "", false, true));
        List arrayList2 = new ArrayList();
        for (od$a od_a2 : list) {
            if (od_a2.v5()) {
                arrayList2.add(od_a2.DW());
            }
            if (od_a2.j6()) {
                arrayList2.add("android.jar");
            }
        }
        for (String str3 : (List) map.get(str)) {
            arrayList2.add(str3);
            for (od$a od_a22 : ok.gn(str3, str2)) {
                if (od_a22.v5()) {
                    arrayList2.add(od_a22.DW());
                }
                if (od_a22.j6()) {
                    arrayList2.add("android.jar");
                }
            }
        }
        List arrayList3 = new ArrayList();
        return new EngineSolutionProject(od_a.DW(), j6, j6, arrayList, arrayList2, false, "", "", "", "", false, false, false, false, "", new ArrayList(), arrayList3, new ArrayList());
    }

    private static EngineSolutionProject j6(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new File(str, "Java Binary", "", false, true));
        arrayList2 = arrayList;
        arrayList2.add(new File(str2, "Java Binary", "", false, true));
        List arrayList3 = new ArrayList();
        arrayList3.add("android.jar");
        return new EngineSolutionProject("android.jar", str, "android.jar", arrayList, arrayList3, false, "", "", "", "", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private static EngineSolutionProject j6(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new File(str, "JavaScript", null, false, false));
        List arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        return new EngineSolutionProject(str, str, str, arrayList, arrayList3, false, "", "", "", "1.5", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private static EngineSolutionProject j6(String str, String str2, boolean z, boolean z2, List<od$a> list, Map<String, List<String>> map) {
        String j6;
        ArrayList arrayList = new ArrayList();
        for (od$a od_a : list) {
            if (od_a.Hw()) {
                j6 = od_a.j6(str);
                arrayList.add(new File(j6, "Java", null, false, false));
                arrayList.add(new File(j6, "AIDL", null, false, false));
            }
        }
        arrayList.add(new File(oh.j6(str, str2), "XML", null, false, false));
        j6 = oh.DW(str, str2);
        if (j6 != null) {
            arrayList.add(new File(j6, "XML", null, false, false));
        }
        if (oh.Hw(str)) {
            arrayList.add(new File(oh.BT(str), "C++", null, false, false));
        }
        j6 = oh.FH(str, str2);
        if (j6 != null) {
            arrayList.add(new File(j6, "XML", null, false, false));
        }
        arrayList.add(new File(oh.we(str), "XML", null, false, false));
        if (oh.gn(str) && m.Zo()) {
            arrayList.add(new File(oh.u7(str), "C++", null, false, false));
        }
        if (z) {
            arrayList.add(new File(oh.J8(str), "Css", null, false, false));
            arrayList.add(new File(oh.J8(str), "HTML", null, false, false));
            arrayList.add(new File(oh.J8(str), "JavaScript", null, false, false));
        }
        List arrayList2 = new ArrayList();
        arrayList2.add(str);
        for (od$a od_a2 : list) {
            if (od_a2.v5()) {
                arrayList2.add(od_a2.DW());
            }
            if (od_a2.j6()) {
                arrayList2.add("android.jar");
            }
        }
        List<String> arrayList3 = new ArrayList();
        j6(of.j6(str, map), str2, arrayList3);
        for (String add : arrayList3) {
            arrayList2.add(add);
        }
        List arrayList4 = new ArrayList();
        List arrayList5 = new ArrayList();
        List arrayList6 = new ArrayList();
        return new EngineSolutionProject(str, str, str, arrayList, arrayList2, !oh.j6(str), "", ok.j6(str, true), ok.j6(str, false), "1.5", false, false, false, z2, "", arrayList5, arrayList4, arrayList6);
    }

    private static void j6(List<String> list, String str, List<String> list2) {
        for (String str2 : list) {
            if (!list2.contains(str2)) {
                list2.add(str2);
            }
            for (od$a od_a : ok.gn(str2, str)) {
                if (od_a.v5()) {
                    list2.add(od_a.DW());
                }
            }
        }
    }
}
