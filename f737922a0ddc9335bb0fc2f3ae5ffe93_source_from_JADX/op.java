import com.aide.engine.EngineSolution;
import com.aide.engine.EngineSolution.File;
import com.aide.engine.EngineSolutionProject;
import com.aide.engine.service.l;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

class op {
    public static EngineSolution j6(String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(j6(str));
        arrayList.add(DW(str2));
        return new EngineSolution(arrayList, null, l.j6(e.DW()), e.DW());
    }

    private static EngineSolutionProject j6(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new File(str, "JavaScript", null, false, false));
        List arrayList3 = new ArrayList();
        arrayList3.add(str);
        return new EngineSolutionProject(str, str, str, arrayList, arrayList3, true, "", "", "", "1.5", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private static EngineSolutionProject DW(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new File(str, "JavaScript", null, false, false));
        List arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        return new EngineSolutionProject(str, str, str, arrayList, arrayList3, false, "", "", "", "1.5", false, false, false, false, "", new ArrayList(), new ArrayList(), new ArrayList());
    }
}
