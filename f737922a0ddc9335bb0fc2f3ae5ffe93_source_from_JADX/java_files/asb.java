import java.io.File;
import java.io.FileNotFoundException;

public class asb {
    private File j6;

    public asb(aoh aoh, String str) {
        this.j6 = new File(aoh.DW(), "logs/" + str);
    }

    public asa j6(int i) {
        int i2 = 0;
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        try {
            byte[] j6 = awx.j6(this.j6);
            int v5 = axe.v5(j6, j6.length);
            int i3 = 0;
            while (v5 >= 0) {
                v5 = axe.v5(j6, v5);
                if (i == i3) {
                    if (v5 >= 0) {
                        i2 = v5 + 2;
                    }
                    return new asa(j6, i2);
                }
                i3++;
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
