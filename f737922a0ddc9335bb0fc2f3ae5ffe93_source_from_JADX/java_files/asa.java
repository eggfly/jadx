import java.io.Serializable;
import org.eclipse.jgit.JGitText;

public class asa implements Serializable {
    private ans DW;
    private aoa FH;
    private String Hw;
    private ans j6;

    asa(byte[] bArr, int i) {
        this.j6 = ans.v5(bArr, i);
        int i2 = i + 40;
        int i3 = i2 + 1;
        if (bArr[i2] != (byte) 32) {
            throw new IllegalArgumentException(JGitText.j6().rawLogMessageDoesNotParseAsLogEntry);
        }
        this.DW = ans.v5(bArr, i3);
        i2 = i3 + 40;
        i3 = i2 + 1;
        if (bArr[i2] != (byte) 32) {
            throw new IllegalArgumentException(JGitText.j6().rawLogMessageDoesNotParseAsLogEntry);
        }
        this.FH = axe.tp(bArr, i3);
        i2 = axe.j6(bArr, i3, '\t');
        if (i2 >= bArr.length) {
            this.Hw = "";
            return;
        }
        i3 = axe.Hw(bArr, i2);
        this.Hw = i3 > i2 ? axe.FH(bArr, i2, i3 - 1) : "";
    }

    public ans j6() {
        return this.DW;
    }

    public aoa DW() {
        return this.FH;
    }

    public String FH() {
        return this.Hw;
    }

    public String toString() {
        return "Entry[" + this.j6.DW() + ", " + this.DW.DW() + ", " + DW() + ", " + FH() + "]";
    }
}
