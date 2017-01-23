package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class n {

    public interface a {
        void j6();
    }

    public abstract boolean DW();

    public abstract boolean FH();

    public abstract List<Fragment> Hw();

    public abstract SavedState j6(Fragment fragment);

    public abstract Fragment j6(Bundle bundle, String str);

    public abstract Fragment j6(String str);

    public abstract q j6();

    public abstract void j6(int i, int i2);

    public abstract void j6(Bundle bundle, String str, Fragment fragment);

    public abstract void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
