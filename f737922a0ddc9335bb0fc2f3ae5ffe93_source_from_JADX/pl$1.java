import com.aide.engine.FileHighlightings;
import com.aide.engine.service.g.a;

class pl$1 extends a {
    final /* synthetic */ pl j6;

    pl$1(pl plVar) {
        this.j6 = plVar;
    }

    public void j6(FileHighlightings fileHighlightings) {
        if (fileHighlightings.gn > 0) {
            for (pl$c j6 : this.j6.v5) {
                j6.j6(fileHighlightings);
            }
            return;
        }
        pl$a DW = this.j6.DW(fileHighlightings.j6);
        if (DW != null) {
            DW.DW(fileHighlightings);
        }
    }

    public void DW(FileHighlightings fileHighlightings) {
        pl$a DW = this.j6.DW(fileHighlightings.j6);
        if (DW != null) {
            DW.j6(fileHighlightings);
        }
    }
}
