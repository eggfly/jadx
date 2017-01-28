import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class arh extends ask {
    private final Set<ans> DW;
    private final String[] FH;
    private aro[] Hw;
    private final arl j6;

    arh(arl arl, Set<ans> set, List<String> list) {
        this.j6 = arl;
        if (set.size() == 1) {
            this.DW = Collections.singleton((ans) set.iterator().next());
        } else {
            this.DW = Collections.unmodifiableSet(set);
        }
        this.FH = (String[]) list.toArray(new String[list.size()]);
    }

    public Set<ans> j6() {
        return this.DW;
    }

    public long DW() {
        long j = 0;
        for (aro Hw : Hw()) {
            j += Hw.Hw();
        }
        return j;
    }

    void j6(asx asx, boolean z, asg asg) {
        for (aro j6 : Hw()) {
            j6.j6(asx, z, asg);
        }
    }

    public boolean j6(asv asv, asz asz) {
        try {
            ari ari = (ari) asz;
            for (aro aro : Hw()) {
                if (ari.j6 == aro) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    private aro[] Hw() {
        if (this.Hw == null) {
            aro[] aroArr = new aro[this.FH.length];
            for (int i = 0; i < this.FH.length; i++) {
                aroArr[i] = j6(this.FH[i]);
            }
            this.Hw = aroArr;
        }
        return this.Hw;
    }

    private aro j6(String str) {
        for (aro aro : this.j6.J8()) {
            if (str.equals(aro.DW())) {
                return aro;
            }
        }
        throw new FileNotFoundException(DW(str));
    }

    private String DW(String str) {
        return new File(new File(this.j6.gn(), "pack"), "pack-" + str + ".pack").getPath();
    }
}
