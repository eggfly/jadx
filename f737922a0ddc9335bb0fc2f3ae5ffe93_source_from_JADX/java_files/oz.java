import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import com.aide.common.m;
import com.aide.common.w;
import com.aide.ui.activities.a;
import com.aide.ui.e;
import com.aide.ui.h;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class oz {
    private static final String[] j6;
    private List<oz$e> DW;
    private final ExecutorService FH;
    private oz$d Hw;
    private String VH;
    private int Zo;
    private String gn;
    private long u7;
    private int v5;

    static {
        j6 = new String[]{"google_m2repository", "android_m2repository"};
    }

    public oz() {
        this.DW = new ArrayList();
        this.FH = Executors.newSingleThreadExecutor();
    }

    public void j6(Activity activity) {
        if (e.Mr().DW(activity, "offline_docs")) {
            FH(activity);
        }
    }

    private void FH(Activity activity) {
        DW(activity, "Download Docs", new oz$1(this, activity));
    }

    private void Hw(Activity activity) {
        if (this.Hw != null) {
            m.j6(activity, new nq());
            return;
        }
        m.j6(activity, "Download Docs", "Directory path for storing the downloaded docs", qh.j6() + "/" + ".aide/docs", new oz$4(this, activity));
    }

    private void DW(Activity activity, String str) {
        File file = new File(str);
        if (file.isAbsolute()) {
            while (file != null && !file.exists()) {
                file = file.getParentFile();
            }
            if (file == null) {
                return;
            }
            if (j6(file, a.u7())) {
                FH(activity, str);
            } else {
                m.DW(activity, "Download Docs", "There does not seem to be enough space on that filesystem. At least " + ((a.u7() / 1000) / 1000) + "MB are temporarily required. Continue anyway?", new oz$5(this, activity, str), null);
            }
        }
    }

    private void FH(Activity activity, String str) {
        h.j6(str);
        if (this.Hw != null) {
            this.Hw.cancel(true);
            this.Hw = null;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        for (a aVar : a.gn()) {
            if (!(aVar.v5() == null || arrayList.contains(aVar.Zo()))) {
                arrayList.add(aVar.Zo());
                arrayList2.add(aVar.v5());
                arrayList3.add(Boolean.valueOf(aVar.FH()));
            }
        }
        this.Hw = new oz$d(this, activity, new oz$a(this, activity, arrayList, arrayList2, arrayList3, null, str, new oz$6(this)));
        this.VH = "Installing Docs";
        this.FH.execute(this.Hw);
        m.j6(activity, new nq());
    }

    public void DW(Activity activity) {
        if (com.aide.ui.build.android.m.Zo()) {
            m.DW(activity, "Support for native code (C/C++)", "Uninstall support for native code?", new oz$7(this, activity), null);
        } else {
            j6(activity, "");
        }
    }

    public void j6(Activity activity, List<iw$g> list, List<iw$m> list2, Runnable runnable) {
        DW(activity, "Download Maven Libraries", new oz$8(this, activity, list, list2, runnable));
    }

    public void j6(Activity activity, String str, String str2, Runnable runnable, Runnable runnable2) {
        DW(activity, "Download Android Libraries", new oz$9(this, str2, activity, str, runnable, runnable2));
    }

    private void j6(Activity activity, String str, Runnable runnable) {
        if (this.Hw != null) {
            m.j6(activity, new nq());
            return;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        arrayList.add(str);
        arrayList2.add(qh.Zo(iu.j6(str)));
        arrayList3.add(Boolean.valueOf(true));
        this.Hw = new oz$d(this, activity, new oz$a(this, activity, arrayList, arrayList2, null, arrayList3, qh.v5(iu.j6(str)), runnable));
        this.VH = "Downloading Android Libraries";
        this.FH.execute(this.Hw);
        m.j6(activity, new nq());
    }

    public void j6(Activity activity, String str) {
        m.DW(activity, "Download support for native code (C/C++)", str + "After installing support for native code you can build apps using native-code languages such as C and C++. The native code support takes about " + 750 + "MB of space on internal storage once installed.\n\nDownload native code support now (" + 200 + "MB)?", new oz$10(this, activity), null);
    }

    private void v5(Activity activity) {
        File externalCacheDir;
        String str;
        com.aide.ui.build.android.m.Hw();
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        if (equals) {
            externalCacheDir = activity.getExternalCacheDir();
        } else {
            externalCacheDir = activity.getCacheDir();
        }
        Object obj = (!equals || Environment.isExternalStorageEmulated()) ? 1 : null;
        String str2 = "";
        if (obj != null) {
            if (!j6(externalCacheDir, 950000000)) {
                str = "There does not seem to be enough space on the internal storage. At least " + ((950000000 / 1000) / 1000) + "MB are temporarily required. ";
            }
            str = str2;
        } else {
            if (!j6(externalCacheDir, 200000000)) {
                str2 = "There does not seem to be enough temporary space on the SD card. At least 200MB are temporarily required. ";
            }
            if (!j6(activity.getFilesDir(), 750000000)) {
                str = str2 + "There does not seem to be enough space on internal storage. At least 200MB are required. ";
            }
            str = str2;
        }
        if (str.length() != 0) {
            m.DW(activity, "Download support for native code (C/C++)", str + "Continue anyway?", new oz$11(this, activity, externalCacheDir), null);
        } else {
            j6(activity, externalCacheDir);
        }
    }

    private void j6(Activity activity, File file) {
        if (this.Hw != null) {
            this.Hw.cancel(true);
            this.Hw = null;
        }
        this.Hw = new oz$d(this, activity, new oz$c(this, activity, file));
        this.VH = "Installing support for native code (C/C++)";
        this.FH.execute(this.Hw);
        m.j6(activity, new nq());
    }

    private boolean j6(File file, long j) {
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
    }

    private void DW(Activity activity, String str, Runnable runnable) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            m.DW(activity, str, "There seems to be no active network connection. Continue anyway?", runnable, null);
        } else if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 7 || activeNetworkInfo.getType() == 9) {
            runnable.run();
        } else {
            m.DW(activity, str, "Do you really want to continue your download over mobile internet?", runnable, null);
        }
    }

    private void j6(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.u7 >= 1000) {
            this.u7 = currentTimeMillis;
            e.j6(new oz$2(this, i));
        }
    }

    private boolean DW(int i) {
        return i >= 200 && i < 300;
    }

    private void j6(String str, String str2, boolean z) {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Map headerFields;
        List list;
        File file = new File(str2);
        long j = 0;
        if (z && file.exists()) {
            j = file.length();
        }
        long j2 = -1;
        if (j > 0) {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                headerFields = httpURLConnection.getHeaderFields();
                if (DW(httpURLConnection.getResponseCode()) && headerFields != null) {
                    list = (List) headerFields.get("content-Length");
                    if (!(list == null || list.isEmpty())) {
                        try {
                            j2 = Long.parseLong((String) list.get(0));
                        } catch (NumberFormatException e) {
                            j2 = -1;
                        }
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                httpURLConnection.disconnect();
            }
        }
        if (j != j2) {
            int responseCode;
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            boolean z2 = false;
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            if (j2 <= 0 || j <= 0) {
                try {
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th2) {
                    httpURLConnection.disconnect();
                }
            } else {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
                int responseCode2 = httpURLConnection.getResponseCode();
                int i = responseCode2;
                z2 = responseCode2 == 206;
                responseCode = i;
            }
            if (DW(responseCode)) {
                long parseLong;
                long j3;
                byte[] bArr;
                long j4;
                long j5;
                long currentTimeMillis;
                int i2;
                long j6;
                long j7;
                if (j2 == -1) {
                    headerFields = httpURLConnection.getHeaderFields();
                    if (headerFields != null) {
                        list = (List) headerFields.get("content-Length");
                        if (!(list == null || list.isEmpty())) {
                            try {
                                parseLong = Long.parseLong((String) list.get(0));
                            } catch (NumberFormatException e2) {
                                parseLong = -1;
                            }
                            if (z2) {
                                j3 = 0;
                            } else {
                                j3 = j;
                            }
                            System.currentTimeMillis();
                            if (!z2) {
                                new File(str2).delete();
                            }
                            new File(str2).getParentFile().mkdirs();
                            fileOutputStream = new FileOutputStream(str2, z2);
                            bArr = new byte[32768];
                            j4 = 0;
                            j5 = 0;
                            currentTimeMillis = System.currentTimeMillis();
                            i2 = -1;
                            j6 = currentTimeMillis;
                            while (true) {
                                responseCode = httpURLConnection.getInputStream().read(bArr);
                                if (responseCode > 0) {
                                    fileOutputStream.close();
                                    httpURLConnection.disconnect();
                                    return;
                                } else if (Thread.interrupted()) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, responseCode);
                                    j5 += (long) responseCode;
                                    j = System.currentTimeMillis();
                                    j7 = j - j6;
                                    if (j7 <= 5000) {
                                        j6 = j5 - j4;
                                        j4 = j - currentTimeMillis;
                                        System.out.println("Last 5 secs Average input bytes/sec: " + ((((double) j6) * 1000.0d) / ((double) j7)));
                                        System.out.println("Total Average input bytes/sec: " + ((((double) j5) * 1000.0d) / ((double) j4)));
                                        j6 = j5;
                                    } else {
                                        j = j6;
                                        j6 = j4;
                                    }
                                    if (parseLong != -1) {
                                        responseCode = (int) (((j3 + j5) * 100) / parseLong);
                                        if (i2 != responseCode) {
                                            j6(responseCode);
                                            i2 = responseCode;
                                            j4 = j6;
                                            j6 = j;
                                        }
                                    }
                                    responseCode = i2;
                                    i2 = responseCode;
                                    j4 = j6;
                                    j6 = j;
                                }
                            }
                            throw new InterruptedException();
                        }
                    }
                }
                parseLong = j2;
                if (z2) {
                    j3 = j;
                } else {
                    j3 = 0;
                }
                System.currentTimeMillis();
                if (z2) {
                    new File(str2).delete();
                }
                new File(str2).getParentFile().mkdirs();
                fileOutputStream = new FileOutputStream(str2, z2);
                bArr = new byte[32768];
                j4 = 0;
                j5 = 0;
                currentTimeMillis = System.currentTimeMillis();
                i2 = -1;
                j6 = currentTimeMillis;
                while (true) {
                    responseCode = httpURLConnection.getInputStream().read(bArr);
                    if (responseCode > 0) {
                        fileOutputStream.close();
                        httpURLConnection.disconnect();
                        return;
                    } else if (Thread.interrupted()) {
                        break;
                        throw new InterruptedException();
                    } else {
                        fileOutputStream.write(bArr, 0, responseCode);
                        j5 += (long) responseCode;
                        j = System.currentTimeMillis();
                        j7 = j - j6;
                        if (j7 <= 5000) {
                            j = j6;
                            j6 = j4;
                        } else {
                            j6 = j5 - j4;
                            j4 = j - currentTimeMillis;
                            System.out.println("Last 5 secs Average input bytes/sec: " + ((((double) j6) * 1000.0d) / ((double) j7)));
                            System.out.println("Total Average input bytes/sec: " + ((((double) j5) * 1000.0d) / ((double) j4)));
                            j6 = j5;
                        }
                        if (parseLong != -1) {
                            responseCode = (int) (((j3 + j5) * 100) / parseLong);
                            if (i2 != responseCode) {
                                j6(responseCode);
                                i2 = responseCode;
                                j4 = j6;
                                j6 = j;
                            }
                        }
                        responseCode = i2;
                        i2 = responseCode;
                        j4 = j6;
                        j6 = j;
                    }
                }
            } else {
                throw new IOException("HTTP connection to " + str + " failed with response code " + responseCode);
            }
        }
    }

    private void j6(String str) {
        qd j6;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        try {
            j6 = qe.j6(Arrays.asList(new String[]{"/system/bin/chmod", "755", str}), null, null, true, null, null);
            if (j6.j6() != 0) {
                throw new IOException("Could not make " + str + " executable - exit code " + j6.j6());
            }
        } catch (IOException e) {
            j6 = qe.j6(Arrays.asList(new String[]{"/system/xbin/chmod", "755", str}), null, null, true, null, null);
            if (j6.j6() != 0) {
                throw new IOException("Could not make " + str + " executable - exit code " + j6.j6());
            }
        }
    }

    public String j6() {
        return this.VH;
    }

    public boolean DW() {
        return this.Hw != null;
    }

    public int FH() {
        return this.v5;
    }

    public int Hw() {
        return this.Zo;
    }

    public String v5() {
        return this.gn;
    }

    public void j6(oz$e oz_e) {
        this.DW.add(oz_e);
    }

    public void DW(oz$e oz_e) {
        this.DW.remove(oz_e);
    }

    public void Zo() {
        this.Hw.cancel(true);
    }

    private void gn() {
        for (oz$e J0 : this.DW) {
            J0.J0();
        }
    }

    private void u7() {
        for (oz$e J8 : this.DW) {
            J8.J8();
        }
    }

    private void j6(String str, int i, int i2) {
        this.u7 = System.currentTimeMillis();
        e.j6(new oz$3(this, str, i, i2));
    }

    private String j6(byte[] bArr, int i) {
        String str = "";
        try {
            str = w.j6(new InputStreamReader(new ByteArrayInputStream(bArr)));
        } catch (IOException e) {
        }
        str = str.trim();
        if (str.length() != 0) {
            str = str + '\n';
        }
        return str + " ### binary exited with code " + i;
    }
}
