package com.miui.support.internal.component.module;

import android.content.Context;
import com.miui.support.internal.util.DeviceHelper;
import java.io.File;

public class PrebuiltRepository extends LocalRepository {
    public PrebuiltRepository(Context context) {
        super(context);
    }

    protected File m3909a(Context context) {
        return new File((DeviceHelper.f2559k ? "/cust/prebuilts/" : "/data/miui/prebuilts/") + context.getPackageName());
    }

    protected File a_(File file, String str) {
        return new File(file, str + ".apk");
    }
}
