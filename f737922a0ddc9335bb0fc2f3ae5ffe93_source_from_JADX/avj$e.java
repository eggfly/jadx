import java.io.InputStream;
import java.util.Collection;
import java.util.Set;

class avj$e extends ati {
    final /* synthetic */ avj QX;

    avj$e(avj avj, InputStream inputStream) {
        this.QX = avj;
        super(avj);
        this.EQ = true;
        j6(inputStream, axl.j6);
        this.tp = false;
        VH();
    }

    protected void DW(aob aob, Collection<aoc> collection, Set<ans> set) {
        avj$d avj_d = new avj$d(this.QX, "git-upload-pack");
        j6(avj_d.j6, avj_d.DW);
        super.DW(aob, collection, set);
    }
}
