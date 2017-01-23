package com.google.android.gms.internal;

import agj;
import android.content.Context;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class j {
    private static final AtomicReference<j> j6;

    static {
        j6 = new AtomicReference();
    }

    j(Context context) {
    }

    public static j j6() {
        return (j) j6.get();
    }

    public static j j6(Context context) {
        j6.compareAndSet(null, new j(context));
        return (j) j6.get();
    }

    public Set<String> DW() {
        return Collections.emptySet();
    }

    public void j6(agj agj) {
    }
}
