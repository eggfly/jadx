import java.io.File;

public class awa extends awd {
    protected final awp DW;
    protected final File j6;

    public awa(aoh aoh) {
        this(aoh.Mr(), aoh.gn(), (awe) aoh.VH().j6(awe.j6));
        j6(aoh);
    }

    public awa(File file, awp awp, awe awe) {
        super(awe);
        this.j6 = file;
        this.DW = awp;
        j6(rN());
    }

    protected awa(awa awa, File file, awp awp) {
        super((awd) awa);
        this.j6 = file;
        this.DW = awp;
        j6(rN());
    }

    public avx j6(any any) {
        return new awa(this, ((awa$a) Mr()).j6, this.DW);
    }

    private awd$a[] rN() {
        File[] listFiles = this.j6.listFiles();
        if (listFiles == null) {
            return FH;
        }
        awd$a[] awd_aArr = new awd$a[listFiles.length];
        for (int i = 0; i < awd_aArr.length; i++) {
            awd_aArr[i] = new awa$a(listFiles[i], this.DW);
        }
        return awd_aArr;
    }

    public File tp() {
        return this.j6;
    }

    protected byte[] j6(awd$a awd_a) {
        if (this.Hw == null) {
            return j6(tp(), awd_a);
        }
        return super.j6(awd_a);
    }
}
