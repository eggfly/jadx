import com.aide.engine.EngineSolution;
import com.aide.engine.EngineSolution.File;
import com.aide.engine.EngineSolutionProject;
import com.aide.engine.service.l;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

public class om {
    public static EngineSolution j6(String str, String str2, String str3) {
        List<od$a> list = ((od) new od().J0(oo.Mr(str))).j6;
        List arrayList = new ArrayList();
        arrayList.add(j6(str, list));
        if (str3 != null) {
            arrayList.add(j6(str3));
        } else {
            arrayList.add(DW(str2));
        }
        for (od$a od_a : list) {
            if (od_a.v5()) {
                arrayList.add(j6(str, od_a, (List) list));
            }
        }
        return new EngineSolution(arrayList, null, l.j6(e.DW()), e.DW());
    }

    private static EngineSolutionProject j6(String str, List<od$a> list) {
        String j6 = oo.j6(str, true);
        String j62 = oo.j6(str, false);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (od$a od_a : list) {
            if (od_a.Hw()) {
                arrayList.add(new File(od_a.j6(str), "Java", null, false, false));
            }
            if (od_a.v5()) {
                arrayList2.add(od_a.DW());
            }
            if (od_a.Zo()) {
                String j63 = od_a.j6(str);
                j6 = j63 + "/debug";
                j62 = j63 + "/release";
            }
        }
        arrayList2.add(str);
        arrayList2.add("rt.jar");
        return new EngineSolutionProject(str, str, str, arrayList, arrayList2, true, "", j6, j62, "1.5", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private static EngineSolutionProject j6(String str, od$a od_a, List<od$a> list) {
        List arrayList = new ArrayList();
        String j6 = od_a.j6(str);
        arrayList.add(new File(j6, "Java Binary", "", false, true));
        List arrayList2 = new ArrayList();
        for (od$a od_a2 : list) {
            if (od_a2.v5()) {
                arrayList2.add(od_a2.DW());
            }
        }
        arrayList2.add("rt.jar");
        List arrayList3 = new ArrayList();
        return new EngineSolutionProject(od_a.DW(), j6, j6, arrayList, arrayList2, false, "", "", "", "", false, false, false, false, "", new ArrayList(), arrayList3, new ArrayList());
    }

    private static EngineSolutionProject j6(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new File(str, "Java Binary", "", false, true));
        List arrayList3 = new ArrayList();
        arrayList3.add("rt.jar");
        return new EngineSolutionProject("rt.jar", str, "rt.jar", arrayList, arrayList3, false, "", "", "", "", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private static EngineSolutionProject DW(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(str + "/java", "Java Binary", "", false, true));
        arrayList.add(new File(str + "/javax", "Java Binary", "", false, true));
        arrayList.add(new File(str + "/org", "Java Binary", "", false, true));
        List arrayList2 = new ArrayList();
        arrayList2.add("rt.jar");
        return new EngineSolutionProject("rt.jar", str, "rt.jar", arrayList, arrayList2, false, "", "", "", "", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }
}
