package p023b.p024a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: b.a.br */
public class br {
    public static String m3618a(Context context) {
        return "/data/data/" + context.getPackageName() + "/databases/cc/";
    }

    public static String m3619a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> m3620a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }
}
