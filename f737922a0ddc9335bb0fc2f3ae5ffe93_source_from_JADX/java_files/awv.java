import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class awv {
    public static void j6(File file) {
        j6(file, 0);
    }

    public static void j6(File file, int i) {
        if ((i & 4) == 0 || file.exists()) {
            int i2;
            if ((i & 1) != 0 && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File j6 : listFiles) {
                        j6(j6, i);
                    }
                }
            }
            if (!file.delete()) {
                if ((i & 2) != 0 && file.exists()) {
                    i2 = 1;
                    while (i2 < 10) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                        if (!file.delete()) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
                throw new IOException(MessageFormat.format(JGitText.j6().deleteFileFailed, new Object[]{file.getAbsolutePath()}));
            }
        }
    }

    public static void DW(File file) {
        j6(file, false);
    }

    public static void j6(File file, boolean z) {
        if (!file.mkdir()) {
            if (!z || !file.isDirectory()) {
                throw new IOException(MessageFormat.format(JGitText.j6().mkDirFailed, new Object[]{file.getAbsolutePath()}));
            }
        }
    }

    public static void FH(File file) {
        DW(file, false);
    }

    public static void DW(File file, boolean z) {
        if (!file.mkdirs()) {
            if (!z || !file.isDirectory()) {
                throw new IOException(MessageFormat.format(JGitText.j6().mkDirsFailed, new Object[]{file.getAbsolutePath()}));
            }
        }
    }
}
