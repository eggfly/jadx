import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Toast;
import com.aide.common.r;
import com.aide.common.w;
import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.engine.SyntaxError;
import com.aide.ui.R;
import com.aide.ui.build.android.d;
import com.aide.ui.build.android.m;
import com.aide.ui.build.c;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.ui.htmluidesigner.PhonegapDesignActivity;
import com.aide.ui.trainer.c.a;
import com.aide.ui.trainer.c.b;
import com.aide.uidesigner.XmlLayoutDesignActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ok implements og {
    public pn$a[] j6() {
        boolean z;
        pn$b pn_b;
        String str;
        boolean z2;
        pn$b pn_b2;
        pn$a[] pn_aArr;
        String str2 = "Android App";
        String str3 = "Gradle/Android SDK/Java/Xml";
        String str4 = "MyApp";
        String str5 = "com.aide.ui";
        String str6 = "ANDROID";
        String str7 = "course_android";
        boolean z3 = e.Hw() || e.j6.equals("com.aide.ui");
        pn$b pn_b3 = new pn$b(this, 1, str2, str3, str4, true, false, str5, str6, str7, z3);
        str3 = "Android App";
        str4 = "Eclipse/Android SDK/Java/Xml";
        String str8 = "MyApp";
        str6 = "com.aide.ui";
        str7 = "ANDROID";
        String str9 = "course_android";
        boolean z4 = e.Hw() || e.j6.equals("com.aide.ui");
        pn$b pn_b4 = new pn$b(this, 1, str3, str4, str8, true, false, str6, str7, str9, z4);
        str3 = "Wearable App";
        str4 = "Gradle/Android SDK/Java/Xml";
        str8 = "MyWearApp";
        str6 = "com.aide.ui";
        str7 = "ANDROID";
        str9 = "course_wear";
        z4 = e.Hw() || e.j6.equals("com.aide.ui");
        pn_b4 = new pn$b(this, 1, str3, str4, str8, true, false, str6, str7, str9, z4);
        str4 = "Mobile Game";
        str8 = "libGDX/Java";
        String str10 = "MyGame";
        str7 = "com.aide.ui";
        str9 = "GAME";
        String str11 = "course_game";
        boolean z5 = e.Hw() || e.j6.equals("com.aide.ui");
        pn$b pn_b5 = new pn$b(this, 2, str4, str8, str10, true, false, str7, str9, str11, z5);
        str8 = "Native Android App";
        str10 = "Android NDK/C/Java/Xml";
        str5 = "MyNDKApp";
        str9 = "com.aide.ui";
        str11 = "ANDROID_NATIVE";
        String str12 = "course_ndk";
        boolean z6 = e.Hw() || e.j6.equals("com.aide.ui");
        pn$b pn_b6 = new pn$b(this, 4, str8, str10, str5, true, false, str9, str11, str12, z6);
        str10 = "PhoneGap App";
        str5 = "PhoneGap/Html/Css/JavaScript";
        str6 = "MyPhoneGapApp";
        str11 = "com.aide.phonegap";
        str12 = "PHONEGAP";
        if (!e.Hw()) {
            if (!e.j6.equals("com.aide.phonegap")) {
                z = false;
                pn_b = new pn$b(this, 5, str10, str5, str6, true, false, str11, str12, null, z);
                str5 = "Hybrid App";
                str6 = "Html/Css/JavaScript + Java/Xml";
                str7 = "MyHybridApp";
                str12 = "com.aide.phonegap";
                str = "PHONEGAP_PLUGIN";
                if (!e.Hw()) {
                    if (!e.j6.equals("com.aide.phonegap")) {
                        z2 = false;
                        pn_b2 = new pn$b(this, 6, str5, str6, str7, true, false, str12, str, null, z2);
                        pn_aArr = new pn$a[5];
                        pn_aArr[0] = new pn$a("Android App", pn_b3, R.drawable.ic_launcher, "GradleApp.zip", new String[]{"main.xml", "MainActivity.java"}, "app");
                        pn_aArr[1] = new pn$a("Wearable App", pn_b4, R.drawable.ic_launcher_wear, "WearApp.zip", new String[]{"activity_wearable.xml", "activity_phone.xml"}, "Application");
                        pn_aArr[2] = new pn$a("Mobile Game", pn_b5, R.drawable.ic_launcher_game, "course_game_libgdx_project.zip", new String[]{"MyGdxGame.java"}, "gdx-game-android");
                        pn_aArr[3] = new pn$a("Native Android App", pn_b6, R.drawable.ic_launcher, "JniHelloWorld.zip", new String[]{"HelloJni.java", "hello-jni.c"}, null);
                        pn_aArr[4] = new pn$a("PhoneGap App", pn_b, R.drawable.ic_launcher_phonegap, "PhoneGapAppNew.zip", new String[]{"index.html", "index.js", "index.css"}, "app");
                        return pn_aArr;
                    }
                }
                z2 = true;
                pn_b2 = new pn$b(this, 6, str5, str6, str7, true, false, str12, str, null, z2);
                pn_aArr = new pn$a[5];
                pn_aArr[0] = new pn$a("Android App", pn_b3, R.drawable.ic_launcher, "GradleApp.zip", new String[]{"main.xml", "MainActivity.java"}, "app");
                pn_aArr[1] = new pn$a("Wearable App", pn_b4, R.drawable.ic_launcher_wear, "WearApp.zip", new String[]{"activity_wearable.xml", "activity_phone.xml"}, "Application");
                pn_aArr[2] = new pn$a("Mobile Game", pn_b5, R.drawable.ic_launcher_game, "course_game_libgdx_project.zip", new String[]{"MyGdxGame.java"}, "gdx-game-android");
                pn_aArr[3] = new pn$a("Native Android App", pn_b6, R.drawable.ic_launcher, "JniHelloWorld.zip", new String[]{"HelloJni.java", "hello-jni.c"}, null);
                pn_aArr[4] = new pn$a("PhoneGap App", pn_b, R.drawable.ic_launcher_phonegap, "PhoneGapAppNew.zip", new String[]{"index.html", "index.js", "index.css"}, "app");
                return pn_aArr;
            }
        }
        z = true;
        pn_b = new pn$b(this, 5, str10, str5, str6, true, false, str11, str12, null, z);
        str5 = "Hybrid App";
        str6 = "Html/Css/JavaScript + Java/Xml";
        str7 = "MyHybridApp";
        str12 = "com.aide.phonegap";
        str = "PHONEGAP_PLUGIN";
        if (e.Hw()) {
            if (e.j6.equals("com.aide.phonegap")) {
                z2 = false;
                pn_b2 = new pn$b(this, 6, str5, str6, str7, true, false, str12, str, null, z2);
                pn_aArr = new pn$a[5];
                pn_aArr[0] = new pn$a("Android App", pn_b3, R.drawable.ic_launcher, "GradleApp.zip", new String[]{"main.xml", "MainActivity.java"}, "app");
                pn_aArr[1] = new pn$a("Wearable App", pn_b4, R.drawable.ic_launcher_wear, "WearApp.zip", new String[]{"activity_wearable.xml", "activity_phone.xml"}, "Application");
                pn_aArr[2] = new pn$a("Mobile Game", pn_b5, R.drawable.ic_launcher_game, "course_game_libgdx_project.zip", new String[]{"MyGdxGame.java"}, "gdx-game-android");
                pn_aArr[3] = new pn$a("Native Android App", pn_b6, R.drawable.ic_launcher, "JniHelloWorld.zip", new String[]{"HelloJni.java", "hello-jni.c"}, null);
                pn_aArr[4] = new pn$a("PhoneGap App", pn_b, R.drawable.ic_launcher_phonegap, "PhoneGapAppNew.zip", new String[]{"index.html", "index.js", "index.css"}, "app");
                return pn_aArr;
            }
        }
        z2 = true;
        pn_b2 = new pn$b(this, 6, str5, str6, str7, true, false, str12, str, null, z2);
        pn_aArr = new pn$a[5];
        pn_aArr[0] = new pn$a("Android App", pn_b3, R.drawable.ic_launcher, "GradleApp.zip", new String[]{"main.xml", "MainActivity.java"}, "app");
        pn_aArr[1] = new pn$a("Wearable App", pn_b4, R.drawable.ic_launcher_wear, "WearApp.zip", new String[]{"activity_wearable.xml", "activity_phone.xml"}, "Application");
        pn_aArr[2] = new pn$a("Mobile Game", pn_b5, R.drawable.ic_launcher_game, "course_game_libgdx_project.zip", new String[]{"MyGdxGame.java"}, "gdx-game-android");
        pn_aArr[3] = new pn$a("Native Android App", pn_b6, R.drawable.ic_launcher, "JniHelloWorld.zip", new String[]{"HelloJni.java", "hello-jni.c"}, null);
        pn_aArr[4] = new pn$a("PhoneGap App", pn_b, R.drawable.ic_launcher_phonegap, "PhoneGapAppNew.zip", new String[]{"index.html", "index.js", "index.css"}, "app");
        return pn_aArr;
    }

    public List<b> DW() {
        b[] bVarArr = new b[4];
        bVarArr[0] = new b("course_android", 30, new String[]{"com.aide.ui"});
        bVarArr[1] = new b("course_game", 31, new String[]{"com.aide.ui"});
        bVarArr[2] = new b("course_wear", 32, new String[]{"com.aide.ui"});
        bVarArr[3] = new b("course_ndk", 33, new String[]{"com.aide.ui"});
        return Arrays.asList(bVarArr);
    }

    public int v5(String str) {
        if (oh.v5(str)) {
            return R.f.command_files_open_phonegap_project;
        }
        return R.f.command_files_open_android_project;
    }

    public boolean DW(String str) {
        return P8(str);
    }

    public String Hw(String str) {
        if (e.Hw()) {
            return null;
        }
        if (FH(str)) {
            if (e.j6.equals("com.aide.ui") && ei(str)) {
                return "com.aide.phonegap";
            }
            return null;
        } else if (ei(str)) {
            return "com.aide.phonegap";
        } else {
            return "com.aide.ui";
        }
    }

    public boolean FH(String str) {
        if (e.Hw() || e.j6.equals("com.aide.ui")) {
            return true;
        }
        if (e.j6.equals("com.aide.phonegap")) {
            return ei(str);
        }
        return false;
    }

    public EngineSolution Zo() {
        return oi.j6();
    }

    public void j6(String str, Map<String, List<String>> map, List<String> list) {
        e.dx().j6();
        j6(str, new HashSet());
        list.add(str);
        DW(str, (Map) map, (List) list);
    }

    private void j6(String str, HashSet<String> hashSet) {
        if (!hashSet.contains(hashSet)) {
            hashSet.add(str);
            if (oh.Hw(str)) {
                for (iw$b iw_b : nw(str)) {
                    if (iw_b instanceof iw$g) {
                        e.dx().j6((iw$g) iw_b);
                    }
                }
                for (iw$b iw_b2 : nw(str)) {
                    if (iw_b2 instanceof iw$h) {
                        String j6 = ((iw$h) iw_b2).j6(str, (jc) new jc().J0(oh.P8(str)));
                        if (qh.we(j6)) {
                            j6(j6, (HashSet) hashSet);
                        }
                    }
                }
            }
        }
    }

    private void DW(String str, Map<String, List<String>> map, List<String> list) {
        if (!map.containsKey(str)) {
            map.put(str, new ArrayList());
            j6(str, (Map) map);
            for (String DW : (List) map.get(str)) {
                DW(DW, (Map) map, (List) list);
            }
            for (String DW2 : ro(str)) {
                list.add(DW2);
                DW(DW2, (Map) map, (List) list);
            }
        }
    }

    private static void j6(String str, Map<String, List<String>> map) {
        List list = (List) map.get(str);
        String j6;
        if (oh.j6(str)) {
            for (String j62 : e.dx().j6(str)) {
                if (!(!j62.endsWith(".aar") || str.equals(j62) || list.contains(j62))) {
                    list.add(j62);
                }
            }
        } else if (oh.Hw(str)) {
            List<String> arrayList = new ArrayList();
            for (iw$b iw_b : nw(str)) {
                if (iw_b instanceof iw$g) {
                    iw$g iw_g = (iw$g) iw_b;
                    Map cn = cn(str);
                    for (String j622 : e.dx().DW(cn, iw_g)) {
                        if (j622.endsWith(".aar") && !list.contains(j622)) {
                            list.add(j622);
                            for (String FH : cn.values()) {
                                if (qh.FH(FH, j622)) {
                                    arrayList.add(j622);
                                }
                            }
                        }
                    }
                } else if (iw_b instanceof iw$h) {
                    j622 = ((iw$h) iw_b).j6(str, (jc) new jc().J0(oh.P8(str)));
                    if (qh.we(j622) && !list.contains(j622)) {
                        list.add(j622);
                    }
                }
            }
            for (String str2 : arrayList) {
                if (!map.containsKey(str2)) {
                    map.put(str2, new ArrayList());
                }
                for (String j6222 : arrayList) {
                    if (!(str2.equals(j6222) || ((List) map.get(str2)).contains(j6222))) {
                        ((List) map.get(str2)).add(j6222);
                    }
                }
            }
        } else {
            for (ol$a j63 : ((ol) new ol().J0(oh.Zo(str))).j6) {
                j6222 = j63.j6(str);
                if (qh.we(j6222) && !list.contains(j6222)) {
                    list.add(j6222);
                }
            }
            if (qh.VH(oh.VH(str))) {
                for (od$a od_a : ((od) new od().J0(oh.VH(str))).j6) {
                    if (od_a.FH()) {
                        j6222 = od_a.j6(str);
                        if (qh.we(j6222) && !list.contains(j6222)) {
                            list.add(j6222);
                        }
                    }
                }
            }
        }
    }

    private static List<iw$b> nw(String str) {
        iw iwVar = (iw) new iw().J0(oh.BT(str));
        String vy = oh.vy(str);
        if (qh.J0(vy)) {
            iw iwVar2 = (iw) new iw().J0(vy);
            if (iwVar2.EQ.size() > 0 || iwVar2.we.size() > 0) {
                List<iw$b> arrayList = new ArrayList();
                for (iw$b iw_b : iwVar2.EQ) {
                    if (iw_b instanceof iw$g) {
                        arrayList.add(iw_b);
                    }
                }
                for (iw$b iw_b2 : iwVar2.we) {
                    if (iw_b2 instanceof iw$g) {
                        arrayList.add(iw_b2);
                    }
                }
                arrayList.addAll(iwVar.tp);
                return arrayList;
            }
        }
        return iwVar.tp;
    }

    private List<iw$m> SI(String str) {
        List<iw$m> arrayList = new ArrayList();
        if (oh.Hw(str)) {
            for (iw$i iw_i : ((iw) new iw().J0(oh.BT(str))).Zo) {
                if (iw_i instanceof iw$m) {
                    arrayList.add((iw$m) iw_i);
                }
            }
            String vy = oh.vy(str);
            if (qh.J0(vy)) {
                iw iwVar = (iw) new iw().J0(vy);
                for (iw$i iw_i2 : iwVar.VH) {
                    if (iw_i2 instanceof iw$m) {
                        arrayList.add((iw$m) iw_i2);
                    }
                }
                for (iw$i iw_i3 : iwVar.gn) {
                    if (iw_i3 instanceof iw$m) {
                        arrayList.add((iw$m) iw_i3);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<iw$g> J8() {
        List<iw$g> arrayList = new ArrayList();
        for (String str : e.a8().EQ().keySet()) {
            if (oh.Hw(str)) {
                for (iw$b iw_b : nw(str)) {
                    if (iw_b instanceof iw$g) {
                        for (iw$g add : e.dx().FH(cn(str), (iw$g) iw_b)) {
                            arrayList.add(add);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static void Ws() {
        Map hashMap = new HashMap();
        String u7 = e.a8().u7();
        if (oh.Hw(u7)) {
            String vy = oh.vy(u7);
            if (qh.J0(vy)) {
                iw iwVar = (iw) new iw().J0(vy);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(iwVar.we);
                arrayList.addAll(iwVar.EQ);
                List arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    iw$b iw_b = (iw$b) it.next();
                    SyntaxError syntaxError;
                    if (iw_b instanceof iw$g) {
                        iw$g iw_g = (iw$g) iw_b;
                        if (!e.dx().j6(cn(u7), iw_g)) {
                            syntaxError = new SyntaxError();
                            syntaxError.FH = iw_g.FH;
                            syntaxError.Hw = 1;
                            syntaxError.v5 = iw_g.FH;
                            syntaxError.Zo = 1000;
                            syntaxError.VH = "Dependency '" + iw_g.Zo + "' not found";
                            arrayList2.add(syntaxError);
                        }
                    } else {
                        syntaxError = new SyntaxError();
                        syntaxError.FH = iw_b.FH;
                        syntaxError.Hw = 1;
                        syntaxError.v5 = iw_b.FH;
                        syntaxError.Zo = 1000;
                        syntaxError.VH = "Unexpected dependency";
                        arrayList2.add(syntaxError);
                    }
                }
                if (arrayList2.size() > 0) {
                    hashMap.put(vy, arrayList2);
                }
            }
        }
        for (String str : e.a8().EQ().keySet()) {
            if (oh.Hw(str)) {
                List arrayList3 = new ArrayList();
                String BT = oh.BT(str);
                for (iw$b iw_b2 : ((iw) new iw().J0(BT)).tp) {
                    SyntaxError syntaxError2;
                    if (iw_b2 instanceof iw$g) {
                        iw$g iw_g2 = (iw$g) iw_b2;
                        if (!e.dx().j6(cn(str), iw_g2)) {
                            syntaxError2 = new SyntaxError();
                            syntaxError2.FH = iw_g2.FH;
                            syntaxError2.Hw = 1;
                            syntaxError2.v5 = iw_g2.FH;
                            syntaxError2.Zo = 1000;
                            syntaxError2.VH = "Dependency '" + iw_g2.Zo + "' not found";
                            arrayList3.add(syntaxError2);
                        }
                    }
                    if (iw_b2 instanceof iw$c) {
                        iw$c iw_c = (iw$c) iw_b2;
                        if (!qh.VH(iw_c.j6(str))) {
                            syntaxError2 = new SyntaxError();
                            syntaxError2.FH = iw_c.FH;
                            syntaxError2.Hw = 1;
                            syntaxError2.v5 = iw_c.FH;
                            syntaxError2.Zo = 1000;
                            syntaxError2.VH = "File dependency '" + iw_c.j6 + "' not found";
                            arrayList3.add(syntaxError2);
                        }
                    }
                    if (iw_b2 instanceof iw$h) {
                        iw$h iw_h = (iw$h) iw_b2;
                        if (!oh.Hw(iw_h.j6(str, (jc) new jc().J0(oh.P8(str))))) {
                            syntaxError2 = new SyntaxError();
                            syntaxError2.FH = iw_h.FH;
                            syntaxError2.Hw = 1;
                            syntaxError2.v5 = iw_h.FH;
                            syntaxError2.Zo = 1000;
                            syntaxError2.VH = "Project dependency '" + iw_h.j6 + "' not found";
                            arrayList3.add(syntaxError2);
                        }
                    }
                    if (iw_b2 instanceof iw$l) {
                        SyntaxError syntaxError3 = new SyntaxError();
                        syntaxError3.FH = iw_b2.FH;
                        syntaxError3.Hw = 1;
                        syntaxError3.v5 = iw_b2.FH;
                        syntaxError3.Zo = 1000;
                        syntaxError3.VH = "Unknown dependency";
                        arrayList3.add(syntaxError3);
                    }
                }
                if (arrayList3.size() > 0) {
                    hashMap.put(BT, arrayList3);
                }
            }
        }
        e.aM().j6("Gradle", hashMap);
    }

    private boolean KD(String str) {
        return ((List) e.a8().EQ().get(e.a8().u7())).contains(str);
    }

    private static boolean u7(String str, String str2) {
        for (od$a od_a : gn(str, null)) {
            if (od_a.v5() && od_a.j6(str).equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean Zo(String str) {
        Map EQ = e.a8().EQ();
        for (String FH : EQ.keySet()) {
            if (qh.FH(FH, str)) {
                return true;
            }
        }
        for (String FH2 : j6(EQ, e.a8().v5())) {
            if (qh.FH(FH2, str)) {
                return true;
            }
        }
        return false;
    }

    public static String[] j6(Map<String, List<String>> map, String str) {
        List arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            if (!oh.j6(str2)) {
                for (od$a od_a : gn(str2, str)) {
                    if (od_a.Hw()) {
                        arrayList.add(od_a.j6(str2));
                    }
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private static List<String> ro(String str) {
        List<String> arrayList = new ArrayList();
        if (oh.Hw(str)) {
            iw iwVar = (iw) new iw().J0(oh.BT(str));
            if (iwVar.J0 != null) {
                String j6 = iwVar.J0.j6(str, (jc) new jc().J0(oh.P8(str)));
                if (qh.we(j6)) {
                    arrayList.add(j6);
                }
            }
        }
        return arrayList;
    }

    private static Map<String, String> cn(String str) {
        Map<String, String> hashMap = new HashMap();
        for (iw$i iw_i : ((iw) new iw().J0(oh.BT(str))).Zo) {
            if (iw_i instanceof iw$e) {
                hashMap.put(((iw$e) iw_i).j6(str), oh.XL(str));
            }
        }
        return hashMap;
    }

    public static String DW(String str, String str2) {
        iw iwVar = null;
        if (oh.Hw(str)) {
            iwVar = (iw) new iw().J0(oh.BT(str));
        }
        return iv.j6(oh.j6(str, str2), iwVar, str2);
    }

    public static int FH(String str, String str2) {
        iw iwVar = null;
        if (oh.Hw(str)) {
            iwVar = (iw) new iw().J0(oh.BT(str));
        }
        return iv.DW(oh.j6(str, str2), iwVar, str2);
    }

    public List<String> j6(String str) {
        if (oh.FH(str)) {
            return oh.EQ(str);
        }
        if (oh.Hw(str)) {
            ArrayList arrayList = new ArrayList(((iw) new iw().J0(oh.BT(str))).v5.keySet());
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public static List<String> Hw(String str, String str2) {
        List<String> arrayList = new ArrayList();
        for (od$a od_a : gn(str, str2)) {
            if (od_a.Hw()) {
                arrayList.add(od_a.j6(str));
            }
        }
        return arrayList;
    }

    public static boolean v5(String str, String str2) {
        if (FH(str, str2) >= 21) {
            return true;
        }
        return ((iw) new iw().J0(oh.BT(str))).Zo(str2);
    }

    public static String[] j6(Map<String, List<String>> map) {
        Map hashMap = new HashMap();
        for (String str : map.keySet()) {
            for (od$a od_a : gn(str, null)) {
                if (od_a.v5() && !hashMap.containsKey(od_a.DW())) {
                    hashMap.put(od_a.DW(), od_a.j6(str));
                }
            }
        }
        String[] strArr = new String[hashMap.size()];
        hashMap.values().toArray(strArr);
        return strArr;
    }

    public static String[] j6(Map<String, List<String>> map, String str, String str2) {
        List arrayList = new ArrayList();
        for (String j6 : map.keySet()) {
            arrayList.addAll(oh.j6(j6, po.BT(str), str2));
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String[] j6(Map<String, List<String>> map, boolean z) {
        List arrayList = new ArrayList();
        for (String j6 : map.keySet()) {
            arrayList.add(oh.j6(j6, z));
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String[] Mr(String str) {
        Map hashMap = new HashMap();
        List<od$a> gn = gn(str, null);
        if (gn != null) {
            for (od$a od_a : gn) {
                if (od_a.v5() && !hashMap.containsKey(od_a.DW())) {
                    hashMap.put(od_a.DW(), od_a.j6(str));
                }
            }
        }
        String[] strArr = new String[hashMap.size()];
        hashMap.values().toArray(strArr);
        return strArr;
    }

    public static Map<String, List<String>> DW(Map<String, List<String>> map, String str) {
        Map<String, List<String>> hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (P8(str2)) {
                List Hw = Hw(str2, str);
                if (!Hw.isEmpty()) {
                    hashMap.put(oh.Ws(str2), Hw);
                }
            }
        }
        return hashMap;
    }

    public static Map<String, String> FH(Map<String, List<String>> map, String str) {
        Map<String, String> hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (P8(str2)) {
                hashMap.put(oh.Ws(str2), DW(str2, str));
            }
        }
        return hashMap;
    }

    public static Map<String, String> Hw(Map<String, List<String>> map, String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry key : map.entrySet()) {
            String str2 = (String) key.getKey();
            if (P8(str2)) {
                hashMap.put(oh.we(str2), oh.er(str2));
                String Mr = oh.Mr(str2);
                if (Mr != null) {
                    hashMap.put(Mr, oh.er(str2));
                }
                Mr = oh.FH(str2, str);
                if (Mr != null) {
                    hashMap.put(Mr, oh.er(str2));
                }
            }
        }
        return hashMap;
    }

    public static String U2(String str) {
        return oh.we(str) + "/values/strings.xml";
    }

    public static void v5(Map<String, List<String>> map, String str) {
        for (Entry key : map.entrySet()) {
            String str2 = (String) key.getKey();
            if (oh.Hw(str2)) {
                iw iwVar = (iw) new iw().J0(oh.BT(str2));
                if (iwVar.J0 != null) {
                    String j6 = iwVar.J0.j6(str2, (jc) new jc().J0(oh.P8(str2)));
                    if (qh.we(j6)) {
                        String j62 = oh.j6(j6, str);
                        String Mr = oh.Mr(str2);
                        iwVar = null;
                        if (oh.Hw(j6)) {
                            iwVar = (iw) new iw().J0(oh.BT(j6));
                        }
                        iv.j6(j62, Mr, iwVar, str);
                    }
                }
                new d().j6(str2, DW(str2, str), oh.Mr(str2));
            }
        }
    }

    public static List<String> Zo(String str, String str2) {
        List<String> arrayList = new ArrayList();
        if (oh.DW(str)) {
            String DW = oh.DW(str, str2);
            if (DW != null) {
                arrayList.add(DW);
            }
        }
        return arrayList;
    }

    public static List<String> a8(String str) {
        List<String> arrayList = new ArrayList();
        if (oh.Hw(str)) {
            for (String str2 : (List) e.a8().EQ().get(str)) {
                if (oh.Hw(str2) || oh.j6(str2)) {
                    arrayList.add(oh.Ws(str2));
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> Zo(Map<String, List<String>> map, String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry key : map.entrySet()) {
            String str2 = (String) key.getKey();
            if (oh.Hw(str2)) {
                hashMap.put(oh.j6(str2, str), oh.aM(str2));
            }
        }
        return hashMap;
    }

    public static Map<String, String> VH(Map<String, List<String>> map, String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry key : map.entrySet()) {
            String str2 = (String) key.getKey();
            if (oh.Hw(str2)) {
                hashMap.put(oh.Ws(str2), oh.j3(str2));
            }
        }
        return hashMap;
    }

    public static Map<String, String> j6(String str, Map<String, List<String>> map, String str2) {
        Map<String, String> hashMap = new HashMap();
        for (Entry key : map.entrySet()) {
            String str3 = (String) key.getKey();
            if (P8(str3)) {
                String aM;
                if (oh.j6(str3)) {
                    String j6 = oh.j6(str3, str2);
                    aM = oh.aM(str3);
                    if (iv.j6(j6, aM, null, DW(str, str2), str2)) {
                        hashMap.put(oh.Ws(str3), aM);
                    } else {
                        hashMap.put(oh.Ws(str3), j6);
                    }
                } else if (oh.Hw(str3)) {
                    iw iwVar = (iw) new iw().J0(oh.BT(str3));
                    aM = oh.j6(str3, str2);
                    String aM2 = oh.aM(str3);
                    if (iv.j6(aM, aM2, iwVar, DW(str, str2), str2)) {
                        hashMap.put(oh.Ws(str3), aM2);
                    } else {
                        hashMap.put(oh.Ws(str3), aM);
                    }
                } else {
                    hashMap.put(oh.Ws(str3), oh.j6(str3, str2));
                }
            }
        }
        return hashMap;
    }

    public static Map<String, List<String>> gn(Map<String, List<String>> map, String str) {
        Map<String, List<String>> hashMap = new HashMap();
        for (Entry key : map.entrySet()) {
            String str2 = (String) key.getKey();
            if (P8(str2)) {
                List arrayList = new ArrayList();
                j6(of.j6(str2, map), str, arrayList);
                hashMap.put(oh.Ws(str2), arrayList);
            }
        }
        return hashMap;
    }

    public static String VH(String str, String str2) {
        return oh.j6(str, str2);
    }

    private static void j6(List<String> list, String str, List<String> list2) {
        for (String str2 : list) {
            String Mr = oh.Mr(str2);
            if (Mr != null) {
                list2.add(Mr);
            }
            Mr = oh.FH(str2, str);
            if (Mr != null) {
                list2.add(Mr);
            }
            list2.add(oh.we(str2));
        }
    }

    public static String DW(Map<String, List<String>> map, String str, String str2) {
        for (String str3 : j6((Map) map, str)) {
            if (qh.FH(str3, str2)) {
                return qh.DW(str3, str2).replace('/', '.');
            }
        }
        return null;
    }

    public static String lg(String str) {
        return oh.Ws(str);
    }

    public static List<String> j6(String str, String str2, String str3) {
        List<String> arrayList = new ArrayList();
        for (String DW : of.j6(str, e.a8().EQ())) {
            arrayList.addAll(oh.DW(DW, po.BT(str2), str3));
        }
        return arrayList;
    }

    public static String rN(String str) {
        return oh.yS(str);
    }

    public static String er(String str) {
        String sh = sh(str);
        if (sh != null) {
            return jd.j6(oh.Mr(sh));
        }
        return oh.lg(str);
    }

    public static boolean QX() {
        return e.a8().tp().size() == 2;
    }

    private static String sh(String str) {
        List tp = e.a8().tp();
        if (tp.size() == 2 && ((String) tp.get(1)).equals(str)) {
            return (String) tp.get(0);
        }
        return null;
    }

    public static String yS(String str) {
        return oh.a8(str);
    }

    public static String gW(String str) {
        return oh.U2(str);
    }

    public static String j6(String str, boolean z) {
        return oh.j6(str, z);
    }

    public static String BT(String str) {
        return oh.QX(str);
    }

    public static String vy(String str) {
        return oh.rN(str);
    }

    public static boolean P8(String str) {
        return oh.DW(str);
    }

    public static boolean ei(String str) {
        return oh.v5(str);
    }

    public void Hw() {
        e.Mr().j6(e.u7(), (int) R.f.shop_feature_premium_projects, "large_project");
    }

    public boolean FH() {
        if (e.j6.equals("com.aide.phonegap") || e.Hw() || e.Mr().FH()) {
            return false;
        }
        return aM();
    }

    private boolean aM() {
        if (e.a8().EQ().size() > 1) {
            return true;
        }
        int j6;
        int i = 0;
        for (String j62 : j6(e.a8().EQ(), null)) {
            i += qh.j6(j62, XL(), ".java");
            if (i >= XL()) {
                return true;
            }
        }
        if (m.Zo()) {
            for (String str : e.a8().we()) {
                if (j3(str)) {
                    j6 = qh.j6(str, XL(), ".c", ".cpp", ".cc", ".h", ".hpp") + i;
                    if (j6 >= XL()) {
                        return true;
                    }
                } else {
                    j6 = i;
                }
                i = j6;
            }
        }
        return false;
    }

    public int XL() {
        if (e.u7().Hw() <= 103) {
            return 25;
        }
        return 5;
    }

    public String v5() {
        List<String> we = e.a8().we();
        List tp = e.a8().tp();
        String str = "";
        for (String str2 : we) {
            String str22;
            if (!str22.endsWith(".aar")) {
                String str3;
                int i;
                if (tp.contains(str22)) {
                    str = str + "<b>App " + str22 + "</b><br/><br/>";
                } else {
                    str = str + "<b>Library " + str22 + "</b><br/><br/>";
                }
                str = str + "<i>Library Projects:</i><br/><br/>";
                String[] Mr = e.a8().Mr(str22);
                int length = Mr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4;
                    String str4 = Mr[i2];
                    if (str4.endsWith(".aar")) {
                        i4 = i3;
                        str3 = str;
                        i = i4;
                    } else {
                        if (!qh.VH(str4)) {
                            str = str + "(NOT FOUND) ";
                        }
                        str3 = str + str4 + "<br/><br/>";
                        i = 1;
                    }
                    i2++;
                    i4 = i;
                    str = str3;
                    i3 = i4;
                }
                if (i3 == 0) {
                    str = str + "&lt;none&gt;<br/><br/>";
                }
                str = str + "<i>Libraries:</i><br/><br/>";
                String[] Mr2 = Mr(str22);
                length = Mr2.length;
                i3 = 0;
                str22 = str;
                i = 0;
                while (i < length) {
                    str3 = Mr2[i];
                    if (!qh.VH(str3)) {
                        str22 = str22 + "(NOT FOUND) ";
                    }
                    i++;
                    str22 = str22 + str3 + "<br/><br/>";
                    i3 = 1;
                }
                length = Mr.length;
                i2 = 0;
                while (i2 < length) {
                    int i5;
                    str = Mr[i2];
                    if (str.endsWith(".aar")) {
                        if (!qh.VH(str)) {
                            str22 = str22 + "(NOT FOUND) ";
                        }
                        if (str.endsWith(".exploded.aar")) {
                            str = str.substring(0, str.length() - ".exploded.aar".length()) + ".aar";
                        }
                        str = str22 + str + "<br/><br/>";
                        i5 = 1;
                    } else {
                        str = str22;
                        i5 = i3;
                    }
                    i2++;
                    i3 = i5;
                    str22 = str;
                }
                if (i3 == 0) {
                    str22 = str22 + "&lt;none&gt;<br/><br/>";
                }
                str = str22 + "<br/>";
            }
        }
        return str;
    }

    public static List<od$a> gn(String str, String str2) {
        boolean z = true;
        List<od$a> arrayList = new ArrayList();
        String j6;
        if (oh.j6(str)) {
            arrayList.add(new od$a("lib", oh.gW(str), false, true, true));
            j6(oh.tp(str), str, (List) arrayList, true);
            for (String j62 : e.dx().j6(str)) {
                if (j62.endsWith(".jar")) {
                    arrayList.add(new od$a("lib", j62, false, true));
                }
            }
            j6((List) arrayList);
        } else if (qh.VH(oh.VH(str))) {
            arrayList.addAll(((od) new od().J0(oh.VH(str))).j6);
            if (P8(str)) {
                j6(oh.tp(str), str, (List) arrayList, false);
            }
            j6((List) arrayList);
            String Zo = qh.Zo(str, oh.Ws(str));
            for (od$a od_a : arrayList) {
                if (od_a.Hw() && od_a.Hw != null && od_a.Hw.equals(Zo)) {
                    break;
                }
            }
            z = false;
            if (!z) {
                arrayList.add(new od$a("src", qh.Zo(str, oh.Ws(str)), false));
            }
        } else if (oh.Hw(str)) {
            for (String Zo2 : oh.Hw(str, str2)) {
                arrayList.add(new od$a("src", qh.Zo(str, Zo2), false));
            }
            arrayList.add(new od$a("src", qh.Zo(str, oh.Ws(str)), false));
            arrayList.add(od$a.j6);
            arrayList.add(od$a.DW);
            for (iw$b iw_b : nw(str)) {
                if (iw_b instanceof iw$g) {
                    for (String j622 : e.dx().DW(cn(str), (iw$g) iw_b)) {
                        if (j622.endsWith(".jar")) {
                            arrayList.add(new od$a("lib", j622, false, true));
                        }
                    }
                } else if (iw_b instanceof iw$d) {
                    j622 = ((iw$d) iw_b).j6(str);
                    if (j622 != null) {
                        j6(j622, str, (List) arrayList, false);
                    }
                } else if (iw_b instanceof iw$c) {
                    arrayList.add(new od$a("lib", ((iw$c) iw_b).j6(str), false, true));
                }
            }
            arrayList.add(new od$a("output", qh.Zo(str, oh.QX(str)), false));
        } else {
            j6(str, (List) arrayList);
            for (String Zo3 : oh.Hw(str, str2)) {
                arrayList.add(new od$a("src", qh.Zo(str, Zo3), false));
            }
            arrayList.add(new od$a("src", qh.Zo(str, oh.Ws(str)), false));
            arrayList.add(od$a.j6);
            arrayList.add(od$a.DW);
            arrayList.add(new od$a("output", qh.Zo(str, oh.QX(str)), false));
            j6(oh.tp(str), str, (List) arrayList, false);
        }
        return arrayList;
    }

    private static void j6(String str, List<od$a> list) {
        for (ol$a j6 : ((ol) new ol().J0(oh.Zo(str))).DW) {
            String j62 = j6.j6(str);
            if (qh.we(j62)) {
                list.add(new od$a("src", j62, false));
            }
        }
    }

    private static void j6(List<od$a> list) {
        for (od$a j6 : list) {
            if (j6.j6()) {
                return;
            }
        }
        list.add(od$a.j6);
    }

    private static void j6(String str, String str2, List<od$a> list, boolean z) {
        if (qh.lg(str).equals("jar")) {
            for (od$a j6 : list) {
                if (j6.j6(str2).equals(str)) {
                    return;
                }
            }
            list.add(new od$a("lib", str, false, true, z));
        } else if (qh.we(str)) {
            try {
                List<String> QX = qh.QX(str);
                Collections.sort(QX);
                for (String j62 : QX) {
                    j6(j62, str2, (List) list, z);
                }
            } catch (Throwable e) {
                com.aide.common.e.j6(e);
            }
        }
    }

    public boolean EQ(String str) {
        return oj.j6(str);
    }

    public void j6(String str, y<String> yVar) {
        oj.j6(str, yVar);
    }

    public int we(String str) {
        return oj.DW(str);
    }

    public int J0(String str) {
        return oj.FH(str);
    }

    public boolean VH() {
        return j3();
    }

    private boolean j3() {
        return j6("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip", null, new ok$1(this));
    }

    private boolean j6(String str, String str2, r<Boolean> rVar) {
        Object obj;
        for (iw$g iw_g : J8()) {
            if (iu.j6(str, iw_g.j6, iw_g.DW, iw_g.Hw)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null || iu.FH(str)) {
            return ((Boolean) rVar.j6()).booleanValue();
        }
        e.KD().j6(e.tp(), str, str2, new ok$2(this), new ok$3(this, rVar));
        return true;
    }

    private boolean Mr() {
        List arrayList = new ArrayList();
        for (iw$g iw_g : J8()) {
            if (!(iu.j6("https://dl-ssl.google.com/android/repository/google_m2repository_gms_v8_rc42_wear_2b1_rc4.zip", iw_g.j6, iw_g.DW, iw_g.Hw) || iu.j6("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip", iw_g.j6, iw_g.DW, iw_g.Hw))) {
                arrayList.add(iw_g);
            }
        }
        if (arrayList.isEmpty()) {
            return U2();
        }
        e.KD().j6(e.tp(), arrayList, SI(e.a8().u7()), new ok$4(this));
        return true;
    }

    private boolean U2() {
        if (!m.Zo()) {
            for (String j3 : e.a8().we()) {
                if (j3(j3)) {
                    e.KD().j6(e.tp(), "This project contains native code.");
                    return true;
                }
            }
        }
        return false;
    }

    public void j6(List<String> list, boolean z) {
        boolean z2;
        List list2;
        boolean z3;
        if (list == null) {
            z2 = false;
            list2 = null;
            z3 = true;
        } else {
            List arrayList = new ArrayList();
            z3 = false;
            z2 = false;
            for (String str : list) {
                boolean z4;
                if (sG(str)) {
                    z4 = z3;
                    z3 = true;
                } else if (dx(str)) {
                    arrayList.add(str);
                    z4 = true;
                    z3 = z2;
                } else if (cb(str)) {
                    z4 = true;
                    z3 = z2;
                } else {
                    z4 = z3;
                    z3 = z2;
                }
                z2 = z3;
                z3 = z4;
            }
            list2 = arrayList;
        }
        if (z2) {
            if (z) {
                e.a8().aM();
                return;
            }
            e.a8().j3();
            c.j6.j6(true, list2);
        } else if (z3) {
            c.j6.j6(true, list2);
        }
    }

    private boolean cb(String str) {
        if (str.endsWith(".xml")) {
            String j3 = e.a8().j3(str);
            if (j3 != null) {
                return e.a8().EQ().keySet().contains(j3);
            }
        }
        return false;
    }

    private boolean dx(String str) {
        if (str.endsWith(".aidl")) {
            String j3 = e.a8().j3(str);
            if (j3 != null) {
                return e.a8().EQ().keySet().contains(j3);
            }
        }
        return false;
    }

    private boolean sG(String str) {
        if (e.a8().J0() && (qh.Zo(str).equals(".classpath") || qh.Zo(str).equals("project.properties") || qh.Zo(str).equals("build.gradle"))) {
            return true;
        }
        return false;
    }

    public boolean gn() {
        return oh.DW(e.a8().u7());
    }

    public void j6(boolean z) {
        c.j6.j6(z, e.a8().Hw(), e.a8().v5());
    }

    public boolean QX(String str) {
        if ((e.Hw() || e.j6.equals("com.aide.phonegap")) && str.toLowerCase().endsWith(".html")) {
            if (qh.gn(str, "www") != null) {
                return true;
            }
            return false;
        } else if ((!e.Hw() && !e.j6.equals("com.aide.ui")) || !str.toLowerCase().endsWith(".xml")) {
            return false;
        } else {
            if (!qh.Zo(qh.v5(str)).startsWith("layout") || qh.gn(str, "res") == null) {
                return false;
            }
            return true;
        }
    }

    public void XL(String str) {
        boolean z = true;
        if ((e.Hw() || e.j6.equals("com.aide.phonegap")) && str.toLowerCase().endsWith(".html")) {
            PhonegapDesignActivity.j6(e.u7(), qh.gn(str, "www"), str);
        } else if ((!e.Hw() && !e.j6.equals("com.aide.ui")) || !str.toLowerCase().endsWith(".xml")) {
        } else {
            Activity u7;
            String vJ;
            if (e.VH()) {
                a er = e.QX().er();
                u7 = e.u7();
                vJ = e.vJ();
                String[] VH = er.VH();
                String j6 = e.QX().gW().j6();
                String J0 = e.QX().gW().J0();
                String aM = e.QX().aM();
                String lg = e.QX().lg();
                String a8 = e.QX().a8();
                if (!(e.QX().gW().we() && h.QX())) {
                    z = false;
                }
                XmlLayoutDesignActivity.j6(u7, vJ, str, 13, VH, j6, J0, aM, lg, a8, z, h.XL());
                return;
            }
            u7 = e.u7();
            vJ = e.vJ();
            if (e.Mr().j3()) {
                z = false;
            }
            XmlLayoutDesignActivity.j6(u7, vJ, str, z, false);
        }
    }

    public boolean tp() {
        if (e.a8().J0() && aM() && !DW(e.a8().u7(), null).contains(".mycompany.")) {
            return true;
        }
        return false;
    }

    public List<String> aM(String str) {
        List<String> arrayList = new ArrayList();
        arrayList.add(e.j6((int) R.f.dialog_add_to_project_existing_library_project, new Object[0]));
        arrayList.add(e.j6((int) R.f.dialog_add_to_project_existing_jar_file, new Object[0]));
        if (oh.Hw(str)) {
            arrayList.add(e.j6((int) R.f.dialog_add_to_project_new_library_project, new Object[0]));
            arrayList.add(e.j6((int) R.f.dialog_add_to_project_new_product_flavor, new Object[0]));
            arrayList.addAll(iu.Hw("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip"));
            arrayList.addAll(iu.Hw("https://dl-ssl.google.com/android/repository/google_m2repository_gms_v8_rc42_wear_2b1_rc4.zip"));
        }
        return arrayList;
    }

    public void j6(String str, String str2) {
        if (e.j6((int) R.f.dialog_add_to_project_existing_jar_file, new Object[0]).equals(str2)) {
            e.u7().rN();
            com.aide.common.m.j6(e.u7(), e.j6((int) R.f.dialog_add_to_project_existing_jar_file, new Object[0]), e.j6((int) R.f.dialog_add_to_project_existing_jar_file_message, new Object[0]), null);
        } else if (e.j6((int) R.f.dialog_add_to_project_new_library_project, new Object[0]).endsWith(str2)) {
            ef(str);
        } else if (e.j6((int) R.f.dialog_add_to_project_existing_library_project, new Object[0]).endsWith(str2)) {
            e.u7().rN();
            com.aide.common.m.j6(e.u7(), e.j6((int) R.f.dialog_add_to_project_existing_library_project, new Object[0]), e.j6((int) R.f.dialog_add_to_project_existing_library_project_message, new Object[0]), null);
        } else if (e.j6((int) R.f.dialog_add_to_project_new_product_flavor, new Object[0]).endsWith(str2)) {
            Sf(str);
        } else {
            com.aide.common.m.DW(e.u7(), e.j6((int) R.f.dialog_add_to_project_new_library, new Object[0]), e.j6((int) R.f.dialog_add_to_project_new_library_message, str2), new ok$5(this, str, str2), null);
        }
    }

    private void ef(String str) {
        String str2 = "Library";
        String str3 = "Android Library";
        String str4 = "Gradle/Android SDK/Java/Xml";
        String str5 = "library";
        String str6 = "com.aide.ui";
        String str7 = "ANDROID";
        String str8 = "course_android";
        boolean z = e.Hw() || e.j6.equals("com.aide.ui");
        com.aide.common.m.j6(e.u7(), new nn(qh.v5(str), new pn$a(str2, new pn$b(this, 1, str3, str4, str5, true, true, str6, str7, str8, z), R.drawable.ic_launcher, "GradleLibrary.zip", new String[]{"AndroidManifest.xml", "LibraryActivity.java"}, ""), new ok$6(this, str)));
    }

    private void Sf(String str) {
        String str2 = "Flavor";
        String str3 = "Android Flavor";
        String str4 = "Gradle/Android SDK/Java/Xml";
        String str5 = "flavor";
        String str6 = "com.aide.ui";
        String str7 = "ANDROID";
        String str8 = "course_android";
        boolean z = e.Hw() || e.j6.equals("com.aide.ui");
        com.aide.common.m.j6(e.u7(), (int) R.f.dialog_add_to_project_new_product_flavor, (int) R.f.dialog_create_message, "flavor", new ok$7(this, str, new pn$a(str2, new pn$b(this, 1, str3, str4, str5, true, true, str6, str7, str8, z), R.drawable.ic_launcher, "GradleFlavor.zip", new String[]{"AndroidManifest.xml", "strings.xml"}, "")));
    }

    private void vJ(String str) {
        String[] split = str.split(":");
        if (split.length >= 3) {
            iw$g iw_g = new iw$g(1);
            iw_g.j6 = split[0];
            iw_g.DW = split[1];
            iw_g.Hw = split[2];
            String DW = e.dx().DW(iw_g);
            if (DW != null && DW.endsWith(".jar")) {
                try {
                    File file = new File(oh.tp(e.a8().u7()));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    w.j6(new FileInputStream(DW), new FileOutputStream(new File(file, qh.Zo(DW))));
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
                e.a8().aM();
            } else if (DW != null && DW.endsWith(".aar")) {
                e.a8().gn(DW);
            }
            Toast.makeText(e.u7(), "Library has been added", 0).show();
        }
    }

    public boolean VH(String str) {
        String u7 = e.a8().u7();
        return (str.toLowerCase().endsWith(".jar") && !u7(u7, str)) || !(!oh.DW(str) || u7.equals(str) || KD(str));
    }

    public boolean gn(String str) {
        return KD(str) || u7(e.a8().u7(), str);
    }

    public void u7(String str) {
        String u7 = e.a8().u7();
        if (oh.Hw(u7)) {
            if (!str.toLowerCase().endsWith(".jar")) {
                ((iw) new iw().J0(oh.BT(u7))).we(str);
                e.a8().aM();
                Toast.makeText(e.u7(), "Library has been added", 0).show();
            }
        } else if (str.toLowerCase().endsWith(".jar")) {
            List gn = gn(u7, null);
            gn.add(new od$a("lib", qh.Zo(u7, str), false));
            od.j6(oh.VH(u7), gn);
        } else {
            ol.DW(oh.Zo(u7), u7, str);
        }
    }

    public void tp(String str) {
        String u7 = e.a8().u7();
        if (!oh.Hw(u7)) {
            if (str.toLowerCase().endsWith(".jar")) {
                List<od$a> gn = gn(u7, null);
                for (od$a od_a : gn) {
                    if (od_a.v5() && od_a.j6(u7).equals(str)) {
                        gn.remove(od_a);
                        break;
                    }
                }
                od.j6(oh.VH(u7), gn);
            } else if (qh.VH(oh.Zo(u7))) {
                ol.j6(oh.Zo(u7), u7, str);
            }
        }
    }

    public boolean EQ() {
        return true;
    }

    public void we() {
        if (e.Mr().DW(e.tp(), "export_apk")) {
            e.j3().j6(false, false);
            Collection DW = e.a8().DW();
            if (DW == null) {
                com.aide.common.m.j6(e.u7(), new ns(null));
                return;
            }
            List arrayList = new ArrayList(DW);
            arrayList.add(0, "main");
            com.aide.common.m.j6(e.u7(), "Choose Flavor", arrayList, new ok$8(this));
        }
    }

    public void J0() {
        if ((e.j6.equals("com.aide.phonegap") || !(e.Mr().gn() || e.Mr().FH() || com.aide.common.d.j6())) && j6(e.gn(), e.a8().u7(), null)) {
            e.u7().j6(e.j6((int) R.f.dialog_community_rate_title, new Object[0]), e.j6((int) R.f.dialog_community_rate_app_message, new Object[0]), null);
        }
    }

    private static boolean j6(Context context, String str, String str2) {
        try {
            context.getPackageManager().getPackageInfo(DW(str, str2), 128);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public String u7() {
        return DW(e.a8().u7(), e.a8().v5());
    }

    public String J8(String str) {
        String[] j6 = j6(e.a8().EQ(), e.a8().v5());
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        for (String str2 : j6) {
            String str22 = str22 + str;
            if (qh.VH(str22)) {
                return str22;
            }
        }
        return null;
    }

    public String Ws(String str) {
        String DW = DW(e.a8().EQ(), e.a8().v5(), qh.v5(str));
        if (DW == null) {
            return str;
        }
        return DW.replace('.', '/') + "/" + qh.Zo(str);
    }

    public boolean j3(String str) {
        return oh.gn(str);
    }

    public static iw$j DW(String str, String str2, String str3) {
        return ((iw) new iw().J0(oh.BT(str))).gn(po.BT(str2));
    }
}
