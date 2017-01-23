package com.miui.support.util;

import java.text.SimpleDateFormat;

public class DropBoxLog {
    private static final SoftReferenceSingleton<SimpleDateFormat> f3668a;
    private StringBuilder f3669b;

    /* renamed from: com.miui.support.util.DropBoxLog.1 */
    final class C04271 extends SoftReferenceSingleton<SimpleDateFormat> {
        C04271() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5371a();
        }

        protected SimpleDateFormat m5371a() {
            return new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        }
    }

    static {
        f3668a = new C04271();
    }

    public DropBoxLog() {
        this.f3669b = new StringBuilder();
    }
}
