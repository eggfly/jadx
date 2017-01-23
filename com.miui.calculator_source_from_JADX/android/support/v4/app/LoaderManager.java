package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> m428a(int i, Bundle bundle);

        void m429a(Loader<D> loader);

        void m430a(Loader<D> loader, D d);
    }

    public boolean m431a() {
        return false;
    }
}
