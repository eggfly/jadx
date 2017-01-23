package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.xiaomi.channel.commonutils.file.b */
final class C4299b implements FileFilter {
    C4299b() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
