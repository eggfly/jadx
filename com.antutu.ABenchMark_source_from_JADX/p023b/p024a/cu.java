package p023b.p024a;

import android.content.Context;
import com.antutu.utils.PointMark;

/* renamed from: b.a.cu */
public class cu extends cn {
    private Context f2904a;

    public cu(Context context) {
        super(PointMark.T_MAC);
        this.f2904a = context;
    }

    public String m3832a() {
        String str = null;
        try {
            str = am.m3357o(this.f2904a);
        } catch (Exception e) {
        }
        return str;
    }
}
