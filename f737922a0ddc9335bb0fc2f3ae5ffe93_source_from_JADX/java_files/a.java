import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class a {
    static final a$b j6;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            j6 = new a$h();
        } else if (i >= 22) {
            j6 = new a$g();
        } else if (i >= 21) {
            j6 = new a$f();
        } else if (i >= 19) {
            j6 = new a$e();
        } else if (i >= 17) {
            j6 = new a$d();
        } else if (i >= 11) {
            j6 = new a$c();
        } else {
            j6 = new a$a();
        }
    }

    public static boolean j6(Drawable drawable) {
        return j6.j6(drawable);
    }

    public static void j6(Drawable drawable, int i) {
        j6.j6(drawable, i);
    }
}
