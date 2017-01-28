import android.app.Activity;
import com.aide.common.m;
import com.aide.common.w;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.trainer.c.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class pp {
    public void j6(Activity activity, j jVar, Runnable runnable) {
        if (j6(jVar)) {
            m.j6(activity, jVar.FH(), activity.getResources().getString(R.f.trainer_sample_overwrite_message), activity.getResources().getString(R.f.trainer_sample_overwrite_overwrite), new pp$1(this, activity, jVar, runnable), activity.getResources().getString(R.f.trainer_sample_overwrite_continue), new pp$2(this, activity, jVar, runnable), null);
            return;
        }
        m.j6(activity, jVar.FH(), activity.getResources().getString(R.f.trainer_sample_mode_message), new pp$3(this, activity, jVar, runnable));
    }

    public boolean j6(j jVar) {
        return new File(FH(jVar)).isDirectory();
    }

    private void j6(Activity activity, j jVar, boolean z, Runnable runnable) {
        e.j6(activity, "Expanding sample...", new pp$4(this, jVar, z, runnable), null);
    }

    protected List<String> DW(j jVar) {
        int i = 0;
        List arrayList = new ArrayList();
        String[] strArr = new String[]{"AIDESamples", "AIDEWebSamples"};
        int length = strArr.length;
        while (i < length) {
            j6(jVar, arrayList, strArr[i]);
            i++;
        }
        return arrayList;
    }

    private void j6(j jVar, List<String> list, String str) {
        try {
            InputStream open = e.gn().getAssets().open(str + ".zip");
            String FH = FH(jVar);
            InputStream zipInputStream = new ZipInputStream(open);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    String str2 = str + "/" + jVar.j6().gn() + "/" + jVar.DW() + "/";
                    if (name.startsWith(str2)) {
                        str2 = FH + "/" + name.substring(str2.length(), name.length());
                        com.aide.common.e.j6("Extract " + name + " to " + str2);
                        for (String name2 : jVar.gn()) {
                            if (str2.endsWith("/" + name2)) {
                                list.add(str2);
                            }
                        }
                        try {
                            if (nextEntry.isDirectory()) {
                                new File(str2).mkdirs();
                            } else {
                                new File(str2).getParentFile().mkdirs();
                                name2 = str2.toLowerCase(Locale.ENGLISH);
                                if (name2.endsWith("build.gradle") || name2.endsWith(".java") || name2.endsWith(".xml") || name2.endsWith(".c") || name2.endsWith(".cpp") || name2.endsWith(".cc") || name2.endsWith(".h") || name2.endsWith(".hpp") || name2.endsWith(".html") || name2.endsWith(".htm") || name2.endsWith(".css") || name2.endsWith(".js")) {
                                    name2 = w.j6(new BufferedReader(new InputStreamReader(zipInputStream))).replace("\r\n", "\n");
                                    Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str2));
                                    outputStreamWriter.write(name2);
                                    outputStreamWriter.close();
                                } else {
                                    OutputStream fileOutputStream = new FileOutputStream(str2);
                                    w.j6(zipInputStream, fileOutputStream, false);
                                    fileOutputStream.close();
                                }
                            }
                        } catch (Throwable e) {
                            com.aide.common.e.j6(e);
                        }
                    }
                } else {
                    open.close();
                    return;
                }
            }
        } catch (IOException e2) {
        }
    }

    private String FH(j jVar) {
        return e.er().DW() + "/Samples/" + jVar.DW();
    }
}
