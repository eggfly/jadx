import com.aide.engine.EngineSolution;
import com.aide.engine.EngineSolution.File;
import com.aide.engine.EngineSolutionProject;
import com.aide.engine.service.l;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

class ot {
    public static EngineSolution j6(String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(j6(str));
        arrayList.add(FH(str2));
        return new EngineSolution(arrayList, null, l.j6(e.DW()), e.DW());
    }

    private static EngineSolutionProject j6(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(DW(str), "Css", null, false, false));
        arrayList.add(new File(DW(str), "HTML", null, false, false));
        arrayList.add(new File(DW(str), "JavaScript", null, false, false));
        List arrayList2 = new ArrayList();
        arrayList2.add(str);
        return new EngineSolutionProject(str, str, str, arrayList, arrayList2, true, "", "", "", "1.5", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private static String DW(String str) {
        return str + "/www";
    }

    private static EngineSolutionProject FH(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new File(str, "JavaScript", null, false, false));
        List arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        return new EngineSolutionProject(str, str, str, arrayList, arrayList3, false, "", "", "", "1.5", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }
}
