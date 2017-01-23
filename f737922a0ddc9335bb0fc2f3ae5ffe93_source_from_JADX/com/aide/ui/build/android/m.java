package com.aide.ui.build.android;

import android.os.Build.VERSION;
import com.aide.ui.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qh;

public class m {
    public static File j6() {
        return new File(e.gn().getFilesDir(), QX());
    }

    public static File DW() {
        return new File(j6(), "bin");
    }

    public static boolean FH() {
        return !XL().isEmpty();
    }

    public static void Hw() {
        try {
            for (File path : XL()) {
                qh.j3(path.getPath());
            }
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
        }
    }

    public static List<String> j6(String str, int i) {
        List<String> arrayList = new ArrayList();
        arrayList.add(J8().getPath());
        arrayList.add(J0().getPath());
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        if (i > 1) {
            arrayList.add("-j" + i);
        }
        if (e.ef()) {
            arrayList.add("NDK_KNOWN_ABIS=armeabi-v7a armeabi-v7a-hard armeabi x86");
            arrayList.add("NDK_KNOWN_ARCHS=arm x86");
            arrayList.add("HOST_ARCH=x86");
        } else {
            arrayList.add("NDK_KNOWN_ABIS=armeabi-v7a armeabi-v7a-hard armeabi x86");
            arrayList.add("NDK_KNOWN_ARCHS=arm x86");
            arrayList.add("HOST_ARCH=arm");
        }
        arrayList.add("APP_PIE_REQUIRED=" + EQ());
        arrayList.add("SHELL=" + J8().getPath());
        arrayList.add("TARGET_AR=$(TOOLCHAIN_PREFIX)ar");
        arrayList.add("host-install=cp $1 $2");
        return arrayList;
    }

    private static boolean EQ() {
        return VERSION.SDK_INT >= 21;
    }

    public static Map<String, String> v5() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("PATH", DW().getPath());
        return hashMap;
    }

    public static boolean Zo() {
        return Ws().isFile();
    }

    private static File we() {
        return new File(j6(), "android-ndk-aide");
    }

    private static File J0() {
        return new File(we(), "ndk-build");
    }

    private static File J8() {
        return new File(DW(), "ash");
    }

    private static File Ws() {
        return new File(j6(), ".installed");
    }

    private static String QX() {
        return "ndksupport-" + (e.ef() ? "20150805" : "20160121");
    }

    private static List<File> XL() {
        List<File> arrayList = new ArrayList();
        File[] listFiles = e.gn().getFilesDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith("ndksupport-") && !file.getName().equals(QX())) {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    public static String VH() {
        return e.ef() ? "https://github.com/android-ide/aide_ndk/releases/download/v20150805/busybox-x86-20150805" : "https://github.com/android-ide/aide_ndk/releases/download/v20160121/busybox-arm-20160121";
    }

    public static String gn() {
        return "https://github.com/android-ide/aide_ndk/releases/download/v20160121/ndkinstall.sh-20160121";
    }

    public static String u7() {
        return e.ef() ? "android-ndk-aide-linux-x86-20150805.tar.bz2" : "android-ndk-aide-linux-arm-20160121.tar.bz2";
    }

    public static String tp() {
        return e.ef() ? "https://github.com/android-ide/aide_ndk/releases/download/v20150805/android-ndk-aide-linux-x86-20150805.tar.bz2" : "https://github.com/android-ide/aide_ndk/releases/download/v20160121/android-ndk-aide-linux-arm-20160121.tar.bz2";
    }
}
