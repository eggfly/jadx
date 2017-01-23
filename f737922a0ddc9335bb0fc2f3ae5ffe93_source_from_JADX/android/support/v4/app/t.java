package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public abstract class t {

    public interface a<D> {
        Loader<D> j6(int i, Bundle bundle);

        void j6(Loader<D> loader);

        void j6(Loader<D> loader, D d);
    }

    public boolean j6() {
        return false;
    }
}
