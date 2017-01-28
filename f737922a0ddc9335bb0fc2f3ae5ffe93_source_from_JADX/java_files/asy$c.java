import java.text.MessageFormat;
import java.util.Collection;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public class asy$c {
    Set<ans> DW;
    long EQ;
    Collection<ask> FH;
    int Hw;
    long J0;
    long J8;
    long QX;
    long VH;
    long Ws;
    long XL;
    int Zo;
    asy$c$a[] aM;
    long gn;
    Set<ans> j6;
    long tp;
    long u7;
    int v5;
    long we;

    public asy$c() {
        this.aM = new asy$c$a[5];
        this.aM[1] = new asy$c$a();
        this.aM[2] = new asy$c$a();
        this.aM[3] = new asy$c$a();
        this.aM[4] = new asy$c$a();
    }

    public long j6() {
        return this.XL;
    }

    public String DW() {
        return MessageFormat.format(JGitText.j6().packWriterStatistics, new Object[]{Long.valueOf(this.VH), Long.valueOf(this.gn), Long.valueOf(this.u7), Long.valueOf(this.tp)});
    }
}
