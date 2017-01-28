import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;

public abstract class aog {
    private final Collection<aoc> j6;

    protected abstract void j6(String str, byte[] bArr);

    public aog(Collection<aoc> collection) {
        this.j6 = aod.j6(collection);
    }

    public aog(axf<aoc> axf_aoc) {
        this.j6 = axf_aoc.DW();
    }

    public void j6() {
        Writer stringWriter = new StringWriter();
        char[] cArr = new char[40];
        for (aoc aoc : this.j6) {
            if (!"HEAD".equals(aoc.j6())) {
                aoc.v5().j6(cArr, stringWriter);
                stringWriter.write(9);
                stringWriter.write(aoc.j6());
                stringWriter.write(10);
                if (aoc.VH() != null) {
                    aoc.VH().j6(cArr, stringWriter);
                    stringWriter.write(9);
                    stringWriter.write(aoc.j6());
                    stringWriter.write("^{}\n");
                }
            }
        }
        j6("info/refs", anj.DW(stringWriter.toString()));
    }

    public void DW() {
        Object obj;
        for (aoc aoc : this.j6) {
            if (aoc.Zo().DW() && aoc.gn()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        Writer stringWriter = new StringWriter();
        if (obj != null) {
            stringWriter.write("# pack-refs with:");
            if (obj != null) {
                stringWriter.write(" peeled");
            }
            stringWriter.write(10);
        }
        char[] cArr = new char[40];
        for (aoc aoc2 : this.j6) {
            if (aoc2.Zo() == aoc$a.PACKED) {
                aoc2.v5().j6(cArr, stringWriter);
                stringWriter.write(32);
                stringWriter.write(aoc2.j6());
                stringWriter.write(10);
                if (aoc2.VH() != null) {
                    stringWriter.write(94);
                    aoc2.VH().j6(cArr, stringWriter);
                    stringWriter.write(10);
                }
            }
        }
        j6("packed-refs", anj.DW(stringWriter.toString()));
    }
}
