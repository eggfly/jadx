package p023b.p024a;

import android.content.Context;
import android.os.Environment;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: b.a.c */
public class C0844c extends cn {
    private static final Pattern f2799a;
    private Context f2800b;

    static {
        f2799a = Pattern.compile("UTDID\">([^<]+)");
    }

    public C0844c(Context context) {
        super(MsgConstant.KEY_UTDID);
        this.f2800b = context;
    }

    private String m3645b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f2799a.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    private String m3646g() {
        InputStream fileInputStream;
        File h = m3647h();
        if (h == null || !h.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(h);
            String b = m3645b(an.m3369a(fileInputStream));
            an.m3377c(fileInputStream);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            an.m3377c(fileInputStream);
        }
    }

    private File m3647h() {
        if (!am.m3336a(this.f2800b, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) || !Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        } catch (Exception e) {
            return null;
        }
    }

    public String m3648a() {
        try {
            return (String) Class.forName("com.d.a.a").getMethod("getUtdid", new Class[]{Context.class}).invoke(null, new Object[]{this.f2800b});
        } catch (Exception e) {
            return m3646g();
        }
    }
}
