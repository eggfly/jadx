package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentManager {

    public interface BackStackEntry {
    }

    public interface OnBackStackChangedListener {
        void m303a();
    }

    public abstract Fragment m304a(String str);

    public abstract FragmentTransaction m305a();

    public abstract void m306a(int i, int i2);

    public abstract void m307a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean m308b();

    public abstract boolean m309c();
}
