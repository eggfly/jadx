import java.io.IOException;

public class alu extends IOException {
    private final String j6;

    public alu(String str) {
        this.j6 = str;
    }

    public alu(String str, String str2) {
        super(str);
        this.j6 = str2;
    }

    public String toString() {
        return super.toString() + ":" + this.j6;
    }
}
