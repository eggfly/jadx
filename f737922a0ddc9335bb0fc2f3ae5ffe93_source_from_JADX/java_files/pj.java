import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import com.aide.ui.e;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.List;

public class pj {
    private static qf<String> tp;
    private pj$b DW;
    private List<RunningAppProcessInfo> FH;
    private long Hw;
    private boolean VH;
    private boolean Zo;
    private boolean gn;
    protected Process j6;
    private boolean u7;
    private Object v5;

    public pj() {
        this.v5 = new Object();
        this.Zo = false;
    }

    static {
        tp = new qf(1000);
    }

    public void j6(boolean z) {
        synchronized (this.v5) {
            boolean z2 = !z;
            if (this.Zo != z2) {
                this.Zo = z2;
                this.v5.notify();
            }
        }
    }

    public void j6() {
        if (this.j6 != null) {
            this.j6.destroy();
            this.j6 = null;
        }
    }

    public void j6(pj$b pj_b) {
        this.DW = pj_b;
    }

    public void DW() {
        if (!this.u7) {
            this.u7 = true;
            new Thread(new pj$1(this)).start();
        }
    }

    private Process DW(String str) {
        PrintStream printStream;
        Throwable th;
        if (v5()) {
            return Runtime.getRuntime().exec(str);
        }
        Process exec = Runtime.getRuntime().exec("su");
        try {
            printStream = new PrintStream(new BufferedOutputStream(exec.getOutputStream(), 8192));
            try {
                printStream.println(str);
                printStream.flush();
                if (printStream == null) {
                    return exec;
                }
                printStream.close();
                return exec;
            } catch (Throwable th2) {
                th = th2;
                if (printStream != null) {
                    printStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            printStream = null;
            if (printStream != null) {
                printStream.close();
            }
            throw th;
        }
    }

    public static void j6(String str) {
        if (e.J0()) {
            tp.j6((Object) str);
        } else {
            e.P8().FH(str);
        }
    }

    private void FH(String str) {
        if (!Hw()) {
            pj$a v5 = v5(str);
            if (v5 != null && this.DW != null) {
                this.DW.j6(v5);
            }
        }
    }

    private void Hw(String str) {
        pj$a v5 = v5(str);
        if (v5 != null) {
            this.gn = true;
            if (this.DW != null) {
                this.DW.j6(v5);
            }
        }
    }

    private pj$a v5(String str) {
        try {
            int j6 = j6(str, 0);
            if (j6 > 0) {
                j6 = j6(str, j6 + 1);
                if (j6 > 0) {
                    String trim = str.substring(0, j6).trim();
                    int j62 = j6(str, j6 + 1);
                    if (j62 > 0) {
                        int parseInt = Integer.parseInt(str.substring(j6 + 1, j62).trim());
                        j6 = j6(str, j62 + 1);
                        if (j6 > 0) {
                            j62 = Integer.parseInt(str.substring(j62 + 1, j6).trim());
                            int j63 = j6(str, j6 + 1);
                            if (j63 > 0) {
                                String trim2 = str.substring(j6 + 1, j63).trim();
                                j6 = str.indexOf(58, j63 + 1);
                                if (j6 > 0) {
                                    return new pj$a(trim, parseInt, j62, trim2, str.substring(j63 + 1, j6).trim(), j6(parseInt, false), str.substring(j6 + 1, str.length()).trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    private String j6(int i, boolean z) {
        if (this.FH == null || (z && System.currentTimeMillis() - this.Hw > 1000)) {
            this.FH = ((ActivityManager) e.gn().getSystemService("activity")).getRunningAppProcesses();
            this.Hw = System.currentTimeMillis();
        }
        for (int i2 = 0; i2 < this.FH.size(); i2++) {
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) this.FH.get(i2);
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        if (z) {
            return "";
        }
        return j6(i, true);
    }

    private int j6(String str, int i) {
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        while (i < str.length() && str.charAt(i) != ' ') {
            i++;
        }
        if (i >= str.length()) {
            return -1;
        }
        return i;
    }

    public void FH() {
        this.VH = VH();
    }

    public boolean Hw() {
        return v5() || this.gn;
    }

    public boolean v5() {
        return this.VH;
    }

    private static boolean VH() {
        if (VERSION.SDK_INT >= 16 && e.gn().getPackageManager().checkPermission("android.permission.READ_LOGS", e.gn().getPackageName()) != 0) {
            return false;
        }
        return true;
    }
}
