import java.util.ArrayList;

public class ajw extends ArrayList<ajv> {
    public static ajw j6(ajv ajv) {
        ajw ajw = new ajw(1);
        ajw.add(ajv);
        return ajw;
    }

    public ajw() {
        super(16);
    }

    public ajw(int i) {
        super(i);
    }

    public String toString() {
        return "EditList" + super.toString();
    }
}
