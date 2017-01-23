package com.miui.support.os;

import com.miui.support.internal.variable.Android_Os_Process_class;
import com.miui.support.internal.variable.Android_Os_Process_class.Factory;
import java.io.File;
import java.util.regex.Pattern;

public class Environment extends android.os.Environment {
    private static final Android_Os_Process_class f3480a;
    private static final File f3481b;
    private static final File f3482c;
    private static final File f3483d;
    private static final File f3484e;
    private static final File f3485f;
    private static int f3486g;

    protected Environment() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    static {
        f3480a = Factory.getInstance().get();
        f3481b = new File(getExternalStorageDirectory(), "MIUI");
        f3482c = new File("/data/miui/");
        f3483d = new File(m5176b(), "apps");
        f3484e = new File(m5176b(), "preset_apps");
        f3485f = new File(m5176b(), "current");
        f3486g = 0;
    }

    public static File m5175a() {
        if (!f3481b.exists() && getExternalStorageDirectory().exists()) {
            f3481b.mkdir();
        }
        return f3481b;
    }

    public static File m5176b() {
        return f3482c;
    }

    public static boolean m5177c() {
        return "mounted".equals(getExternalStorageState());
    }

    public static int m5178d() {
        int i = 0;
        if (f3486g == 0) {
            Pattern compile = Pattern.compile("cpu[0-9]*");
            for (CharSequence matcher : new File("/sys/devices/system/cpu/").list()) {
                if (compile.matcher(matcher).matches()) {
                    i++;
                }
            }
            f3486g = i;
        }
        return f3486g;
    }
}
