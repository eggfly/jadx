package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4210b;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.IOException;

public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils() {
    }

    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean z) {
        File file = null;
        Object externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            externalStorageState = BuildConfig.FLAVOR;
        } catch (IncompatibleClassChangeError e2) {
            externalStorageState = BuildConfig.FLAVOR;
        }
        if (z && "mounted".equals(r1) && hasExternalStoragePermission(context)) {
            file = getExternalCacheDir(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        C4039L.m16509w("Can't define system cache directory! '%s' will be used.", "/data/data/" + context.getPackageName() + "/cache/");
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), C4210b.f14219D), Constants.KEY_DATA), context.getPackageName()), "cache");
        if (file.exists()) {
            return file;
        }
        if (file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                C4039L.m16508i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        C4039L.m16509w("Unable to create external cache directory", new Object[0]);
        return null;
    }

    public static File getIndividualCacheDirectory(Context context) {
        return getIndividualCacheDirectory(context, INDIVIDUAL_DIR_NAME);
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        File cacheDirectory = getCacheDirectory(context);
        File file = new File(cacheDirectory, str);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static File getOwnCacheDirectory(Context context, String str) {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            file = new File(Environment.getExternalStorageDirectory(), str);
        }
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    public static File getOwnCacheDirectory(Context context, String str, boolean z) {
        File file = null;
        if (z && "mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            file = new File(Environment.getExternalStorageDirectory(), str);
        }
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) == 0;
    }
}
