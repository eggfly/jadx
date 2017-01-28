import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ano extends anb {
    public void Zo() {
        this.j6 = 0;
        this.DW = 0;
        this.FH = 0;
        this.Hw = 0;
        this.v5 = 0;
    }

    public void Hw(byte[] bArr, int i) {
        this.j6 = axb.DW(bArr, i);
        this.DW = axb.DW(bArr, i + 4);
        this.FH = axb.DW(bArr, i + 8);
        this.Hw = axb.DW(bArr, i + 12);
        this.v5 = axb.DW(bArr, i + 16);
    }

    public void v5(byte[] bArr, int i) {
        Zo(bArr, i);
    }

    public void j6(String str) {
        if (str.length() != 40) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidId, new Object[]{str}));
        }
        Zo(anj.j6(str), 0);
    }

    private void Zo(byte[] bArr, int i) {
        try {
            this.j6 = axe.DW(bArr, i);
            this.DW = axe.DW(bArr, i + 8);
            this.FH = axe.DW(bArr, i + 16);
            this.Hw = axe.DW(bArr, i + 24);
            this.v5 = axe.DW(bArr, i + 32);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ald(bArr, i, 40);
        }
    }

    public ans v5() {
        return new ans(this);
    }
}
