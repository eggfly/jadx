import java.util.EnumSet;

public class aca {
    private static aag DW;
    private static boolean j6;

    static {
        j6 = true;
    }

    public static boolean j6() {
        return j6;
    }

    public static aag DW() {
        return DW;
    }

    public static aaa j6(aaa aaa, int i, boolean z, boolean z2, aag aag) {
        return j6(aaa, i, z, z2, aag, EnumSet.allOf(aca$a.class));
    }

    public static aaa j6(aaa aaa, int i, boolean z, boolean z2, aag aag, EnumSet<aca$a> enumSet) {
        j6 = z2;
        DW = aag;
        acj j6 = ach.j6(aaa, i, z);
        j6(j6, enumSet);
        aaa j62 = acq.j6(j6, false);
        if (j62.j6().v5() > DW.j6()) {
            return j6(aaa, i, z, enumSet);
        }
        return j62;
    }

    private static aaa j6(aaa aaa, int i, boolean z, EnumSet<aca$a> enumSet) {
        acj j6 = ach.j6(aaa, i, z);
        EnumSet clone = enumSet.clone();
        clone.remove(aca$a.CONST_COLLECTOR);
        j6(j6, clone);
        return acq.j6(j6, true);
    }

    private static void j6(acj acj, EnumSet<aca$a> enumSet) {
        Object obj = null;
        Object obj2 = 1;
        if (enumSet.contains(aca$a.MOVE_PARAM_COMBINER)) {
            aby.j6(acj);
        }
        if (enumSet.contains(aca$a.SCCP)) {
            ace.j6(acj);
            abq.j6(acj);
            obj2 = null;
        }
        if (enumSet.contains(aca$a.LITERAL_UPGRADE)) {
            abv.j6(acj);
            abq.j6(acj);
            obj2 = null;
        }
        enumSet.remove(aca$a.ESCAPE_ANALYSIS);
        if (enumSet.contains(aca$a.ESCAPE_ANALYSIS)) {
            abt.j6(acj);
            abq.j6(acj);
            obj2 = null;
        }
        if (enumSet.contains(aca$a.CONST_COLLECTOR)) {
            abp.j6(acj);
            abq.j6(acj);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            abq.j6(acj);
        }
        acc.j6(acj);
    }
}
