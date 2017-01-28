import android.app.Activity;
import com.aide.common.w;
import com.aide.ui.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class oz$a implements Callable<Void> {
    private Activity DW;
    private final String FH;
    private final List<String> Hw;
    private final List<Boolean> VH;
    private final List<Boolean> Zo;
    private Runnable gn;
    final /* synthetic */ oz j6;
    private final List<String> v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    public oz$a(oz ozVar, Activity activity, List<String> list, List<String> list2, List<Boolean> list3, List<Boolean> list4, String str, Runnable runnable) {
        this.j6 = ozVar;
        this.Hw = list;
        this.v5 = list2;
        this.Zo = list3;
        this.VH = list4;
        this.FH = str;
        this.DW = activity;
        this.gn = runnable;
    }

    public Void j6() {
        DW();
        return null;
    }

    public void DW() {
        if (new File(this.FH).isDirectory() || new File(this.FH).mkdirs()) {
            IOException iOException = null;
            int i = 0;
            while (i < this.Hw.size()) {
                IOException iOException2;
                try {
                    boolean z;
                    Object obj;
                    String str = (String) this.Hw.get(i);
                    String str2 = (String) this.v5.get(i);
                    if (this.Zo == null || !((Boolean) this.Zo.get(i)).booleanValue()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (this.VH == null || !((Boolean) this.VH.get(i)).booleanValue()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    File file = new File(new File(this.FH, str2).getPath() + ".tmp");
                    this.j6.j6("Downloading " + str2, (i * 100) / this.Hw.size(), 0);
                    this.j6.j6(str, file.getPath(), z);
                    if (obj != null) {
                        this.j6.j6("Extracting " + str2, (i * 100) / this.Hw.size(), 0);
                        DW(this.FH + "/" + str2, file.getPath());
                        file.delete();
                        this.j6.j6("Removing old libraries", (i * 100) / this.Hw.size(), 50);
                        j6(this.FH, str2);
                    }
                    iOException2 = iOException;
                } catch (IOException e) {
                    iOException2 = e;
                }
                i++;
                iOException = iOException2;
            }
            if (iOException != null) {
                throw iOException;
            }
            e.j6(new oz$a$1(this));
            return;
        }
        throw new IOException("Could not create directory: " + this.FH);
    }

    private void j6(String str, String str2) {
        CharSequence charSequence = "";
        for (CharSequence charSequence2 : oz.j6) {
            if (str2.contains(charSequence2)) {
                charSequence = charSequence2;
                break;
            }
        }
        if (!charSequence.isEmpty()) {
            for (String str3 : qh.Ws(str)) {
                if (str3.contains(charSequence) && !str3.contains(str2)) {
                    qh.j3(str3);
                }
            }
        }
    }

    private void DW(String str, String str2) {
        ZipFile zipFile = new ZipFile(str2);
        Enumeration entries = zipFile.entries();
        List arrayList = new ArrayList();
        while (entries.hasMoreElements()) {
            arrayList.add((ZipEntry) entries.nextElement());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ZipEntry zipEntry = (ZipEntry) arrayList.get(i);
            File file = new File(str, zipEntry.getName());
            if (zipEntry.isDirectory()) {
                file.mkdirs();
            } else {
                Object obj;
                if (file.exists() && zipEntry.getSize() != -1 && file.length() == zipEntry.getSize()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    FH(str, zipEntry.getName());
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        w.j6(inputStream, fileOutputStream, false);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        inputStream.close();
                    }
                    try {
                        inputStream.close();
                    } finally {
                        zipFile.close();
                    }
                } else {
                    continue;
                }
            }
            this.j6.j6((i * 100) / arrayList.size());
        }
        new File(str2).delete();
    }

    private void FH(String str, String str2) {
        new File(str, str2).getParentFile().mkdirs();
    }
}
