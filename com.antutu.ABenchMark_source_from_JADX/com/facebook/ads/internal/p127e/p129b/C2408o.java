package com.facebook.ads.internal.p127e.p129b;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4210b;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;

/* renamed from: com.facebook.ads.internal.e.b.o */
final class C2408o {
    public static File m9259a(Context context) {
        return new File(C2408o.m9260a(context, true), "video-cache");
    }

    private static File m9260a(Context context, boolean z) {
        Object externalStorageState;
        File file = null;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            externalStorageState = BuildConfig.FLAVOR;
        }
        if (z && "mounted".equals(r1)) {
            file = C2408o.m9261b(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        Log.w("ProxyCache", "Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    private static File m9261b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), C4210b.f14219D), Constants.KEY_DATA), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Log.w("ProxyCache", "Unable to create external cache directory");
        return null;
    }
}
