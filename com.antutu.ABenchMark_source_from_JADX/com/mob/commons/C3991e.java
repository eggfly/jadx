package com.mob.commons;

import com.mob.tools.MobLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;

/* renamed from: com.mob.commons.e */
public class C3991e {
    public static final void m16442a(File file, Runnable runnable) {
        C3991e.m16443a(file, true, runnable);
    }

    public static final void m16443a(File file, boolean z, Runnable runnable) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileLocker fileLocker = new FileLocker();
            fileLocker.setLockFile(file.getAbsolutePath());
            if (fileLocker.lock(z)) {
                runnable.run();
                fileLocker.release();
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }
}
