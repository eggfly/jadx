import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class oh {
    public static boolean j6(String str) {
        return qh.VH(gW(str)) && qh.VH(j6(str, null));
    }

    public static boolean DW(String str) {
        return FH(str) || Hw(str);
    }

    public static boolean FH(String str) {
        return new File(new StringBuilder().append(str).append("/AndroidManifest.xml").toString()).exists() && !ei(str);
    }

    private static boolean ei(String str) {
        return "src".equals(qh.Zo(qh.v5(str))) && Hw(qh.v5(qh.v5(str)));
    }

    public static boolean Hw(String str) {
        return new File(new StringBuilder().append(str).append("/src").toString()).exists() && new File(str + "/build.gradle").exists() && !FH(str);
    }

    public static boolean v5(String str) {
        return DW(str) && qh.VH(J8(str));
    }

    public static String Zo(String str) {
        if (Hw(str)) {
            return "";
        }
        return str + "/project.properties";
    }

    public static String VH(String str) {
        if (Hw(str)) {
            return "";
        }
        return str + "/.classpath";
    }

    public static List<String> j6(String str, String str2, String str3) {
        if (j6(str)) {
            return Collections.singletonList(str + "/jni");
        }
        if (!Hw(str)) {
            return Collections.singletonList(str + "/libs");
        }
        List<String> arrayList = new ArrayList();
        arrayList.add(str + "/src/main/jniLibs");
        if (!(str3 == null || "main".equals(str3))) {
            arrayList.add(str + "/src/" + str3 + "/jniLibs");
        }
        if (str2 == null) {
            return arrayList;
        }
        arrayList.add(str + "/src/" + str2 + "/jniLibs");
        return arrayList;
    }

    public static boolean gn(String str) {
        if (Hw(str)) {
            return false;
        }
        return qh.J0(str + "/jni/Android.mk");
    }

    public static String u7(String str) {
        if (Hw(str)) {
            return str + "/src/main/jni";
        }
        return str + "/jni";
    }

    public static String tp(String str) {
        if (j6(str)) {
            return str + "/libs";
        }
        if (Hw(str)) {
            return str + "/libs";
        }
        return str + "/libs";
    }

    public static List<String> EQ(String str) {
        if (qh.we(str + "/flavors")) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str2 : qh.QX(str + "/flavors")) {
                    if (qh.J8(str2 + "/AndroidManifest.xml")) {
                        arrayList.add(qh.Zo(str2));
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static String j6(String str, String str2) {
        if (Hw(str)) {
            return str + "/src/main/AndroidManifest.xml";
        }
        if (!(str2 == null || "main".equals(str2))) {
            String str3 = str + "/flavors/" + str2 + "/AndroidManifest.xml";
            if (qh.J0(str3)) {
                return str3;
            }
        }
        return str + "/AndroidManifest.xml";
    }

    public static String DW(String str, String str2) {
        if (!(!Hw(str) || str2 == null || "main".equals(str2))) {
            String str3 = str + "/src/" + str2 + "/AndroidManifest.xml";
            if (qh.J0(str3)) {
                return str3;
            }
        }
        return null;
    }

    public static String we(String str) {
        if (Hw(str)) {
            return str + "/src/main/res";
        }
        return str + "/res";
    }

    public static String FH(String str, String str2) {
        if (!(!Hw(str) || str2 == null || "main".equals(str2))) {
            String str3 = str + "/src/" + str2 + "/res";
            if (qh.we(str3)) {
                return str3;
            }
        }
        return null;
    }

    public static List<String> DW(String str, String str2, String str3) {
        if (!Hw(str)) {
            return Collections.singletonList(J0(str));
        }
        List<String> arrayList = new ArrayList();
        arrayList.add(J0(str));
        if (!(str3 == null || "main".equals(str3))) {
            arrayList.add(str + "/src/" + str3 + "/assets");
        }
        if (str2 == null) {
            return arrayList;
        }
        arrayList.add(str + "/src/" + str2 + "/assets");
        return arrayList;
    }

    public static String J0(String str) {
        if (Hw(str)) {
            return str + "/src/main/assets";
        }
        return str + "/assets";
    }

    public static String J8(String str) {
        return J0(str) + "/www";
    }

    public static String[] Hw(String str, String str2) {
        if (Hw(str)) {
            if (!(str2 == null || "main".equals(str2))) {
                if (qh.we(str + "/src/" + str2 + "/java")) {
                    return new String[]{str + "/src/main/java", str + "/src/main/aidl", str + "/src/" + str2 + "/java"};
                }
            }
            return new String[]{str + "/src/main/java", str + "/src/main/aidl"};
        }
        return new String[]{str + "/src"};
    }

    public static String Ws(String str) {
        if (Hw(str)) {
            return str + "/build/gen";
        }
        return str + "/gen";
    }

    public static String QX(String str) {
        if (Hw(str)) {
            return str + "/build/bin";
        }
        return str + "/bin";
    }

    public static String XL(String str) {
        return QX(str) + "/exploded-aar";
    }

    public static String aM(String str) {
        return QX(str) + "/injected/AndroidManifest.xml";
    }

    public static String j3(String str) {
        return QX(str) + "/merged/AndroidManifest.xml";
    }

    public static String Mr(String str) {
        if (Hw(str)) {
            return QX(str) + "/generated";
        }
        return null;
    }

    public static String U2(String str) {
        return QX(str);
    }

    public static String a8(String str) {
        return QX(str) + "/jardex";
    }

    public static String lg(String str) {
        return QX(str) + "/" + qh.Zo(str) + ".apk";
    }

    public static String rN(String str) {
        return qh.Zo(str) + ".apk";
    }

    public static String j6(String str, boolean z) {
        if (z) {
            return QX(str) + "/classesdebug";
        }
        return QX(str) + "/classesrelease";
    }

    public static String er(String str) {
        return QX(str) + "/res";
    }

    public static String yS(String str) {
        return QX(str) + "/resources.ap_";
    }

    public static String gW(String str) {
        return str + "/classes.jar";
    }

    public static String BT(String str) {
        return str + "/build.gradle";
    }

    public static String vy(String str) {
        return qh.VH(str, "../build.gradle");
    }

    public static String P8(String str) {
        return qh.VH(str, "../settings.gradle");
    }
}
