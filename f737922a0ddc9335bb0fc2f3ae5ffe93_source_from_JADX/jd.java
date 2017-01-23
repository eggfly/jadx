import com.aide.common.n;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class jd {
    public static boolean j6(String str, String str2, String str3, String str4) {
        String str5 = (((("<wearableApp package=\"" + str2 + "\">\n") + "\t<versionCode>" + str3 + "</versionCode>\n") + "\t<versionName>" + str4 + "</versionName>\n") + "\t<rawPathResId>wearable_app</rawPathResId>\n") + "</wearableApp>";
        try {
            Writer outputStreamWriter = new OutputStreamWriter(new n(str + "/xml/" + "wearable_app_desc" + ".xml"));
            outputStreamWriter.write(str5);
            outputStreamWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String j6(String str) {
        return str + "/raw/" + "wearable_app" + ".apk";
    }
}
