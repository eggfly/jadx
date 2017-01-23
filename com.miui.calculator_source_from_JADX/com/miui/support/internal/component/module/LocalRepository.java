package com.miui.support.internal.component.module;

import android.content.Context;
import com.miui.support.module.Repository;
import java.io.File;
import java.lang.reflect.Field;

public abstract class LocalRepository extends Repository {
    private Context f2298a;

    protected abstract File m3878a(Context context);

    protected abstract File a_(File file, String str);

    public LocalRepository(Context context) {
        this.f2298a = context;
    }

    private boolean m3877a(File file, File file2) {
        try {
            Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            obj.getClass().getMethod("symlink", new Class[]{String.class, String.class}).invoke(obj, new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean m3880a(String str) {
        return a_(m3878a(this.f2298a), str).exists();
    }

    public String m3879a(File file, String str) {
        File a_ = a_(m3878a(this.f2298a), str);
        if (a_.exists()) {
            File file2 = new File(file, str + ".apk");
            file2.delete();
            if (m3877a(a_, file2)) {
                return file2.getName();
            }
        }
        return null;
    }
}
