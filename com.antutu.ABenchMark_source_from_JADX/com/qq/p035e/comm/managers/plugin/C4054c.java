package com.qq.p035e.comm.managers.plugin;

import android.content.Context;
import com.qq.p035e.comm.util.C4068a;
import com.qq.p035e.comm.util.FileUtil;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.Md5Util;
import com.qq.p035e.comm.util.StringUtil;
import java.io.File;

/* renamed from: com.qq.e.comm.managers.plugin.c */
class C4054c {
    private final File f13469a;
    private final File f13470b;
    private String f13471c;
    private int f13472d;

    public C4054c(File file, File file2) {
        this.f13469a = file;
        this.f13470b = file2;
    }

    static File m16554a(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar");
    }

    static File m16555b(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next");
    }

    static File m16556c(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar.sig");
    }

    static File m16557d(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next.sig");
    }

    final boolean m16558a() {
        try {
            if (!this.f13470b.exists() || !this.f13469a.exists()) {
                return false;
            }
            String[] split = StringUtil.readAll(this.f13470b).split("#####");
            if (split.length != 2) {
                return false;
            }
            String str = split[1];
            int parseInteger = StringUtil.parseInteger(split[0], 0);
            C4068a a = C4068a.m16605a();
            File file = this.f13469a;
            boolean b = (file == null || !file.exists()) ? false : a.m16609b(str, Md5Util.encode(file));
            if (!b) {
                return false;
            }
            this.f13471c = str;
            this.f13472d = parseInteger;
            return true;
        } catch (Throwable th) {
            GDTLogger.report("Exception while checking plugin", th);
            return false;
        }
    }

    final boolean m16559a(File file, File file2) {
        return (file == null || file2 == null) ? false : (file.equals(this.f13469a) || FileUtil.renameTo(this.f13469a, file)) ? file2.equals(this.f13470b) || FileUtil.renameTo(this.f13470b, file2) : false;
    }

    final int m16560b() {
        return this.f13472d;
    }

    final String m16561c() {
        return this.f13471c;
    }
}
