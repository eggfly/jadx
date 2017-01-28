import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class aa {
    private static final aa$a j6;
    private final Object DW;

    static {
        if (VERSION.SDK_INT >= 19) {
            j6 = new aa$c();
        } else if (VERSION.SDK_INT >= 16) {
            j6 = new aa$b();
        } else {
            j6 = new aa$d();
        }
    }

    public aa() {
        this.DW = j6.j6(this);
    }

    public aa(Object obj) {
        this.DW = obj;
    }

    public Object j6() {
        return this.DW;
    }

    public v j6(int i) {
        return null;
    }

    public boolean j6(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<v> j6(String str, int i) {
        return null;
    }

    public v DW(int i) {
        return null;
    }
}
