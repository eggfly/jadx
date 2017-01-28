import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class aur implements Serializable {
    private List<avn> DW;
    private List<avn> FH;
    private List<auq> Hw;
    private String VH;
    private String Zo;
    private auz gn;
    private String j6;
    private int tp;
    private boolean u7;
    private List<auq> v5;

    public aur(ani ani, String str) {
        this.j6 = str;
        String[] DW = ani.DW("remote", this.j6, "url");
        this.DW = new ArrayList(DW.length);
        for (String avn : DW) {
            this.DW.add(new avn(avn));
        }
        DW = ani.DW("remote", this.j6, "pushurl");
        this.FH = new ArrayList(DW.length);
        for (String avn2 : DW) {
            this.FH.add(new avn(avn2));
        }
        DW = ani.DW("remote", this.j6, "fetch");
        this.Hw = new ArrayList(DW.length);
        for (String avn22 : DW) {
            this.Hw.add(new auq(avn22));
        }
        DW = ani.DW("remote", this.j6, "push");
        this.v5 = new ArrayList(DW.length);
        for (String avn222 : DW) {
            this.v5.add(new auq(avn222));
        }
        String j6 = ani.j6("remote", this.j6, "uploadpack");
        if (j6 == null) {
            j6 = "git-upload-pack";
        }
        this.Zo = j6;
        j6 = ani.j6("remote", this.j6, "receivepack");
        if (j6 == null) {
            j6 = "git-receive-pack";
        }
        this.VH = j6;
        this.gn = auz.j6(ani.j6("remote", this.j6, "tagopt"));
        this.u7 = ani.j6("remote", this.j6, "mirror", false);
        this.tp = ani.j6("remote", this.j6, "timeout", 0);
    }

    public void j6(ani ani) {
        List arrayList = new ArrayList();
        arrayList.clear();
        for (avn gn : DW()) {
            arrayList.add(gn.gn());
        }
        ani.j6("remote", j6(), "url", arrayList);
        arrayList.clear();
        for (avn gn2 : FH()) {
            arrayList.add(gn2.gn());
        }
        ani.j6("remote", j6(), "pushurl", arrayList);
        arrayList.clear();
        for (auq auq : Hw()) {
            arrayList.add(auq.toString());
        }
        ani.j6("remote", j6(), "fetch", arrayList);
        arrayList.clear();
        for (auq auq2 : v5()) {
            arrayList.add(auq2.toString());
        }
        ani.j6("remote", j6(), "push", arrayList);
        j6(ani, "uploadpack", Zo(), "git-upload-pack");
        j6(ani, "receivepack", VH(), "git-receive-pack");
        j6(ani, "tagopt", gn().j6(), auz.AUTO_FOLLOW.j6());
        j6(ani, "mirror", this.u7, false);
        j6(ani, "timeout", this.tp, 0);
    }

    private void j6(ani ani, String str, String str2, String str3) {
        if (str3.equals(str2)) {
            j6(ani, str);
        } else {
            ani.j6("remote", j6(), str, str2);
        }
    }

    private void j6(ani ani, String str, boolean z, boolean z2) {
        if (z2 == z) {
            j6(ani, str);
        } else {
            ani.DW("remote", j6(), str, z);
        }
    }

    private void j6(ani ani, String str, int i, int i2) {
        if (i2 == i) {
            j6(ani, str);
        } else {
            ani.DW("remote", j6(), str, i);
        }
    }

    private void j6(ani ani, String str) {
        ani.FH("remote", j6(), str);
    }

    public String j6() {
        return this.j6;
    }

    public List<avn> DW() {
        return Collections.unmodifiableList(this.DW);
    }

    public boolean j6(avn avn) {
        if (this.DW.contains(avn)) {
            return false;
        }
        return this.DW.add(avn);
    }

    public List<avn> FH() {
        return Collections.unmodifiableList(this.FH);
    }

    public List<auq> Hw() {
        return Collections.unmodifiableList(this.Hw);
    }

    public boolean j6(auq auq) {
        if (this.Hw.contains(auq)) {
            return false;
        }
        return this.Hw.add(auq);
    }

    public List<auq> v5() {
        return Collections.unmodifiableList(this.v5);
    }

    public String Zo() {
        return this.Zo;
    }

    public String VH() {
        return this.VH;
    }

    public auz gn() {
        return this.gn;
    }

    public int u7() {
        return this.tp;
    }
}
