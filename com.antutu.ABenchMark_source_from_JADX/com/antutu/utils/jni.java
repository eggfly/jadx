package com.antutu.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.xiaomi.pushsdk.BuildConfig;

public class jni {
    public static final int BID_2D_Physics = 8;
    public static final int BID_3D_Garden = 23;
    public static final int BID_3D_Marooned = 24;
    public static final int BID_3D_Physics = 9;
    public static final int BID_Chess = 18;
    public static final int BID_ChineseChess = 17;
    public static final int BID_Database = 13;
    public static final int BID_FFT = 3;
    public static final int BID_GEMM = 4;
    public static final int BID_Gobang = 19;
    public static final int BID_HASH = 6;
    public static final int BID_IMG_Blur = 22;
    public static final int BID_IMG_Decode = 20;
    public static final int BID_IMG_Fisheye = 21;
    public static final int BID_Json = 15;
    public static final int BID_MAP = 5;
    public static final int BID_MAX = 25;
    public static final int BID_MIN = 1;
    public static final int BID_MultiTask = 11;
    public static final int BID_MultiThread = 10;
    public static final int BID_PNG_Decode = 7;
    public static final int BID_RAM_Access = 2;
    public static final int BID_RAM_Speed = 1;
    public static final int BID_RandomIO = 25;
    public static final int BID_Secure = 16;
    public static final int BID_Storage = 12;
    public static final int BID_XML = 14;
    public static final int CPU_ARM = 1;
    public static final int CPU_ARM64 = 3;
    public static final int CPU_ARMv7 = 2;
    public static final int CPU_MIPS = 6;
    public static final int CPU_MIPS64 = 7;
    public static final int CPU_X64 = 5;
    public static final int CPU_X86 = 4;
    public static final int SID_3D_GARDEN = 39;
    public static final int SID_3D_MAROONED = 40;
    public static final int SID_ALL = 41;
    public static final int SID_CPU_APP = 32;
    public static final int SID_CPU_MATH = 31;
    public static final int SID_CPU_MULTI = 33;
    public static final int SID_MAX = 41;
    public static final int SID_MIN = 30;
    public static final int SID_RAM = 30;
    public static final int SID_UX_DATA = 35;
    public static final int SID_UX_GAME = 36;
    public static final int SID_UX_IMG = 37;
    public static final int SID_UX_IO = 38;
    public static final int SID_UX_SEC = 34;
    public static final int UID_UPDAE_UI = 50;

    static {
        System.loadLibrary("abenchmark");
    }

    public static native void Reset();

    public static native int benchmarkCleanup();

    public static native String benchmarkGetData(Context context, String str);

    public static native int benchmarkInit(Context context, AssetManager assetManager, int i);

    public static native int benchmarkProcess3D(Context context, String str);

    public static native int benchmarkProcessUX(Context context, int i, double d);

    public static native int benchmarkReset();

    public static native int benchmarkScore(Context context, int i);

    public static native void benchmarkStop();

    public static native int benchmarkTest(Context context, int i);

    public static native int benchmarkTest2(Context context, AssetManager assetManager);

    public static native int benchmarkUpdateScore(Context context);

    public static native int benchmarkV6(Context context, int i);

    public static native int checkAPK(String str);

    public static native int checkPackage(String str);

    public static native int checkResource(String str, String str2);

    public static native int checkTimer(Context context, int i, String str, String str2);

    public static native void chmodFile(String str);

    public static native int fastCheck();

    public static native int getCPUType();

    public static native int getCpuCount();

    public static native String getCpuInfo();

    public static native String getDURI(String str, String str2, String str3);

    private static native String getData(String str, String str2);

    public static String getDataSafe(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        return getData(str, str2);
    }

    public static native String getEData(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3);

    public static native String getHash(String str, String str2, String str3, String str4);

    public static native String getKURI(String str, String str2, String str3, int i);

    public static native String getKURI2(String str, String str2, String str3, int i);

    public static native String getKernelInfo();

    public static native int getLastScore();

    public static native int getMaxDef();

    public static native int getMaxSet();

    public static native int getMinDef();

    public static native int getMinSet();

    public static native String getOEMData(String str, String str2, String str3, String str4, int i, int i2);

    public static native String getScore();

    private static native String getString(String str, String str2);

    public static String getStringSafe(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        return getString(str, str2);
    }

    public static native String getURI();

    public static native String getUUID(Context context);

    public static native String getZipString(String str);

    public static native String getdKURI(String str);

    public static native void init(int i, int i2);

    public static native void initAssetManager(AssetManager assetManager);

    public static native void initPaths(String str);

    public static native int installResource(String str, String str2);

    public static native boolean isVerify();

    public static native int saveZipString(String str, String str2);

    public static native int setHostID(int i, int i2);

    public static native void step();

    public static native int testImgBlur(Context context, String str);

    public static native int testImgFisheye(Context context, String str);

    public static native int testPhysX(Context context);
}
