package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class FragmentTransaction {

    @Retention(RetentionPolicy.SOURCE)
    private @interface Transit {
    }

    public abstract int m86a();

    public abstract FragmentTransaction m87a(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract FragmentTransaction m88a(Fragment fragment);

    public abstract int m89b();

    public abstract FragmentTransaction m90b(Fragment fragment);

    public abstract FragmentTransaction m91c(Fragment fragment);
}
