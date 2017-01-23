package anet.channel.strategy;

import java.io.File;
import java.util.Comparator;

/* renamed from: anet.channel.strategy.m */
final class C0733m implements Comparator<File> {
    C0733m() {
    }

    public int m2949a(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2949a((File) obj, (File) obj2);
    }
}
