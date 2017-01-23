import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class iu {
    public static String j6(String str) {
        return qh.j6() + "/.aide/" + str.substring(str.lastIndexOf(47) + 1);
    }

    public static String DW(String str) {
        return j6(str) + "/m2repository";
    }

    public static boolean FH(String str) {
        return new File(j6(str)).exists();
    }

    public static boolean j6(String str, String str2, String str3, String str4) {
        if (str.equals("https://dl-ssl.google.com/android/repository/google_m2repository_gms_v8_rc42_wear_2b1_rc4.zip") && ("com.google.android.gms".equals(str2) || "com.google.android.support".equals(str2) || "com.google.android.wearable".equals(str2) || "com.google.firebase".equals(str2))) {
            return true;
        }
        if (str.equals("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip") && "com.android.support".equals(str2)) {
            return true;
        }
        return false;
    }

    public static List<String> Hw(String str) {
        List<String> arrayList = new ArrayList();
        if (str.equals("https://dl-ssl.google.com/android/repository/google_m2repository_gms_v8_rc42_wear_2b1_rc4.zip")) {
            arrayList.add("com.google.android.gms:play-services:+");
            arrayList.add("com.google.android.gms:play-services-ads:+");
            arrayList.add("com.google.android.gms:play-services-ads-lite:+");
            arrayList.add("com.google.android.gms:play-services-all-wear:+");
            arrayList.add("com.google.android.gms:play-services-analytics:+");
            arrayList.add("com.google.android.gms:play-services-analytics-impl:+");
            arrayList.add("com.google.android.gms:play-services-appindexing:+");
            arrayList.add("com.google.android.gms:play-services-appinvite:+");
            arrayList.add("com.google.android.gms:play-services-appstate:+");
            arrayList.add("com.google.android.gms:play-services-auth:+");
            arrayList.add("com.google.android.gms:play-services-auth-base:+");
            arrayList.add("com.google.android.gms:play-services-awareness:+");
            arrayList.add("com.google.android.gms:play-services-base:+");
            arrayList.add("com.google.android.gms:play-services-basement:+");
            arrayList.add("com.google.android.gms:play-services-cast:+");
            arrayList.add("com.google.android.gms:play-services-cast-framework:+");
            arrayList.add("com.google.android.gms:play-services-clearcut:+");
            arrayList.add("com.google.android.gms:play-services-contextmanager:+");
            arrayList.add("com.google.android.gms:play-services-drive:+");
            arrayList.add("com.google.android.gms:play-services-fitness:+");
            arrayList.add("com.google.android.gms:play-services-games:+");
            arrayList.add("com.google.android.gms:play-services-gass:+");
            arrayList.add("com.google.android.gms:play-services-gcm:+");
            arrayList.add("com.google.android.gms:play-services-identity:+");
            arrayList.add("com.google.android.gms:play-services-iid:+");
            arrayList.add("com.google.android.gms:play-services-instantapps:+");
            arrayList.add("com.google.android.gms:play-services-location:+");
            arrayList.add("com.google.android.gms:play-services-maps:+");
            arrayList.add("com.google.android.gms:play-services-measurement:+");
            arrayList.add("com.google.android.gms:play-services-nearby:+");
            arrayList.add("com.google.android.gms:play-services-panorama:+");
            arrayList.add("com.google.android.gms:play-services-places:+");
            arrayList.add("com.google.android.gms:play-services-plus:+");
            arrayList.add("com.google.android.gms:play-services-safetynet:+");
            arrayList.add("com.google.android.gms:play-services-tagmanager:+");
            arrayList.add("com.google.android.gms:play-services-tagmanager-api:+");
            arrayList.add("com.google.android.gms:play-services-tasks:+");
            arrayList.add("com.google.android.gms:play-services-vision:+");
            arrayList.add("com.google.android.gms:play-services-wallet:+");
            arrayList.add("com.google.android.gms:play-services-wearable:+");
            arrayList.add("com.google.android.support:wearable:+");
            arrayList.add("com.google.android.wearable:wearable:+");
            arrayList.add("com.google.firebase:firebase-ads:+");
            arrayList.add("com.google.firebase:firebase-analytics:+");
            arrayList.add("com.google.firebase:firebase-analytics-impl:+");
            arrayList.add("com.google.firebase:firebase-auth:+");
            arrayList.add("com.google.firebase:firebase-auth-common:+");
            arrayList.add("com.google.firebase:firebase-auth-module:+");
            arrayList.add("com.google.firebase:firebase-common:+");
            arrayList.add("com.google.firebase:firebase-config:+");
            arrayList.add("com.google.firebase:firebase-core:+");
            arrayList.add("com.google.firebase:firebase-crash:+");
            arrayList.add("com.google.firebase:firebase-database:+");
            arrayList.add("com.google.firebase:firebase-database-connection:+");
            arrayList.add("com.google.firebase:firebase-iid:+");
            arrayList.add("com.google.firebase:firebase-invites:+");
            arrayList.add("com.google.firebase:firebase-messaging:+");
            arrayList.add("com.google.firebase:firebase-storage:+");
            arrayList.add("com.google.firebase:firebase-storage-common:+");
        }
        if (str.equals("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip")) {
            arrayList.add("com.android.databinding:adapters:+");
            arrayList.add("com.android.databinding:library:+");
            arrayList.add("com.android.support:animated-vector-drawable:+");
            arrayList.add("com.android.support:appcompat-v7:+");
            arrayList.add("com.android.support:cardview-v7:+");
            arrayList.add("com.android.support:customtabs:+");
            arrayList.add("com.android.support:design:+");
            arrayList.add("com.android.support:gridlayout-v7:+");
            arrayList.add("com.android.support:leanback-v17:+");
            arrayList.add("com.android.support:mediarouter-v7:+");
            arrayList.add("com.android.support:multidex:+");
            arrayList.add("com.android.support:multidex-instrumentation:+");
            arrayList.add("com.android.support:palette-v7:+");
            arrayList.add("com.android.support:percent:+");
            arrayList.add("com.android.support:preference-leanback-v17:+");
            arrayList.add("com.android.support:preference-v14:+");
            arrayList.add("com.android.support:preference-v7:+");
            arrayList.add("com.android.support:recommendation:+");
            arrayList.add("com.android.support:recyclerview-v7:+");
            arrayList.add("com.android.support:support-annotations:+");
            arrayList.add("com.android.support:support-compat:+");
            arrayList.add("com.android.support:support-core-ui:+");
            arrayList.add("com.android.support:support-core-utils:+");
            arrayList.add("com.android.support:support-fragment:+");
            arrayList.add("com.android.support:support-media-compat:+");
            arrayList.add("com.android.support:support-v13:+");
            arrayList.add("com.android.support:support-v4:+");
            arrayList.add("com.android.support:support-vector-drawable:+");
            arrayList.add("com.android.support:test:+");
            arrayList.add("com.android.support:transition:+");
        }
        return arrayList;
    }
}
