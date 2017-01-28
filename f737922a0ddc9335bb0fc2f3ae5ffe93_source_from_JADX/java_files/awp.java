import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class awp {
    public static final awp j6;
    private volatile awp$a<File> DW;
    private volatile awp$a<File> FH;

    public abstract ProcessBuilder DW(String str, String[] strArr);

    public abstract boolean DW();

    public abstract boolean Hw();

    protected abstract File VH();

    public abstract boolean j6(File file);

    public abstract boolean j6(File file, boolean z);

    static {
        j6 = j6();
    }

    public static awp j6() {
        return j6(null);
    }

    public static awp j6(Boolean bool) {
        if (awt.gn()) {
            if (bool == null) {
                bool = Boolean.valueOf(awu.u7());
            }
            if (bool.booleanValue()) {
                return new awu();
            }
            return new awt();
        } else if (aws.gn()) {
            return new aws();
        } else {
            return new awr();
        }
    }

    protected awp() {
    }

    public File j6(File file, String str) {
        File file2 = new File(str);
        return file2.isAbsolute() ? file2 : new File(file, str);
    }

    public File FH() {
        awp$a awp_a = this.DW;
        if (awp_a == null) {
            awp_a = new awp$a(v5());
            this.DW = awp_a;
        }
        return (File) awp_a.j6;
    }

    public awp DW(File file) {
        this.DW = new awp$a(file);
        return this;
    }

    protected File v5() {
        String str = (String) AccessController.doPrivileged(new awp$1(this));
        if (str == null || str.length() == 0) {
            return null;
        }
        return new File(str).getAbsoluteFile();
    }

    static File j6(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(File.pathSeparator)) {
            for (String file : strArr) {
                File file2 = new File(str2, file);
                if (file2.isFile()) {
                    return file2.getAbsoluteFile();
                }
            }
        }
        return null;
    }

    protected static String j6(File file, String[] strArr, String str) {
        boolean parseBoolean = Boolean.parseBoolean(axi.FH().DW("jgit.fs.debug"));
        if (parseBoolean) {
            try {
                System.err.println("readpipe " + Arrays.asList(strArr) + "," + file);
            } catch (IOException e) {
                if (parseBoolean) {
                    System.err.println(e);
                }
            } catch (Throwable th) {
                r3.getErrorStream().close();
                r4.close();
            }
        }
        Process exec = Runtime.getRuntime().exec(strArr, null, file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), str));
        exec.getOutputStream().close();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Thread awp_2 = new awp$2(exec, parseBoolean, atomicBoolean);
        awp_2.start();
        String readLine = bufferedReader.readLine();
        if (parseBoolean) {
            System.err.println("readpipe may return '" + readLine + "'");
            System.err.println("(ignoring remaing output:");
        }
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                break;
            } else if (parseBoolean) {
                System.err.println(readLine2);
            }
        }
        exec.getErrorStream().close();
        bufferedReader.close();
        while (true) {
            try {
                int waitFor = exec.waitFor();
                awp_2.join();
                if (waitFor != 0 || readLine == null || readLine.length() <= 0 || atomicBoolean.get()) {
                    if (!parseBoolean) {
                        break;
                    }
                    System.err.println("readpipe rc=" + waitFor);
                    break;
                }
                return readLine;
            } catch (InterruptedException e2) {
            }
        }
        if (!parseBoolean) {
            return null;
        }
        System.err.println("readpipe returns null");
        return null;
    }

    public File Zo() {
        awp$a awp_a = this.FH;
        if (awp_a == null) {
            String DW = axi.FH().DW("jgit.gitprefix");
            if (DW != null) {
                awp_a = new awp$a(new File(DW));
            } else {
                awp_a = new awp$a(VH());
            }
            this.FH = awp_a;
        }
        return (File) awp_a.j6;
    }
}
