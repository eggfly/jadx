package com.miui.support.internal.component.module;

import android.content.Context;
import java.io.File;

public class BuiltinRepository extends LocalRepository {
    public BuiltinRepository(Context context) {
        super(context);
    }

    protected File m3881a(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    protected File a_(File file, String str) {
        return new File(file, "libmodule_" + str + ".so");
    }
}
