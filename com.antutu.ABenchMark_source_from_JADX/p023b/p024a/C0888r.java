package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: b.a.r */
public class C0888r {
    public static SharedPreferences m3932a(Context context) {
        return context.getSharedPreferences("umeng_general_config", 0);
    }

    public static SharedPreferences m3933a(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }
}
