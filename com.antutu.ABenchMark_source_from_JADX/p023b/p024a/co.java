package p023b.p024a;

import android.content.Context;
import android.provider.Settings.Secure;

/* renamed from: b.a.co */
public class co extends cn {
    private Context f2856a;

    public co(Context context) {
        super("android_id");
        this.f2856a = context;
    }

    public String m3774a() {
        String str = null;
        try {
            str = Secure.getString(this.f2856a.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        return str;
    }
}
