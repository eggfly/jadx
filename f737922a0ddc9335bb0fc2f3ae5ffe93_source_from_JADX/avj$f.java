import java.io.InputStream;
import java.util.Map;

class avj$f extends atj {
    final /* synthetic */ avj J0;

    avj$f(avj avj, InputStream inputStream) {
        this.J0 = avj;
        super(avj);
        this.EQ = true;
        j6(inputStream, axl.j6);
        this.tp = false;
        VH();
    }

    protected void DW(aob aob, Map<String, aus> map) {
        avj$d avj_d = new avj$d(this.J0, "git-receive-pack");
        j6(avj_d.j6, avj_d.DW);
        super.DW(aob, map);
    }
}
