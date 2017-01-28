import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class qc {
    private Map<String, String> DW;
    private InputStream EQ;
    private OutputStream FH;
    private OutputStream Hw;
    private qc$a$a J0;
    private File J8;
    private int VH;
    private boolean Ws;
    private boolean Zo;
    private boolean gn;
    private String[] j6;
    private Process tp;
    private int u7;
    private Object v5;
    private InputStream we;

    public qc(String[] strArr, Map<String, String> map, String str, boolean z) {
        this(strArr);
        synchronized (this) {
            this.DW = map;
            this.Ws = z;
            if (str != null) {
                this.J8 = new File(str);
                if (!(this.J8.exists() && this.J8.isDirectory())) {
                    this.J8 = null;
                }
            }
        }
    }

    public qc(String[] strArr) {
        this.Zo = false;
        synchronized (this) {
            this.j6 = strArr;
            this.u7 = -1;
            this.gn = false;
            this.VH = 0;
            this.FH = null;
            this.Hw = null;
            this.tp = null;
            this.DW = null;
            this.v5 = new Object();
        }
    }

    public synchronized OutputStream j6() {
        if (this.gn) {
            throw new IOException("Process has already been started.");
        }
        this.gn = true;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(this.j6);
            processBuilder.redirectErrorStream(this.Ws);
            processBuilder.directory(this.J8);
            if (this.DW != null) {
                Map environment = processBuilder.environment();
                Map hashMap = new HashMap();
                for (String str : environment.keySet()) {
                    hashMap.put(str.toUpperCase(Locale.US), str);
                }
                for (Entry entry : this.DW.entrySet()) {
                    try {
                        String toUpperCase = ((String) entry.getKey()).toUpperCase(Locale.US);
                        if (hashMap.containsKey(toUpperCase)) {
                            environment.put(hashMap.get(toUpperCase), entry.getValue());
                        } else {
                            environment.put(entry.getKey(), entry.getValue());
                        }
                    } catch (UnsupportedOperationException e) {
                    } catch (IllegalArgumentException e2) {
                    }
                }
            }
            this.tp = processBuilder.start();
            this.EQ = this.tp.getInputStream();
            this.we = this.tp.getErrorStream();
            this.VH = 3;
            Thread qc_1 = new qc$1(this, "Process Exit Value [" + this.j6[0] + "]");
            Thread qc_2 = new qc$2(this, "Process Out [" + this.j6[0] + "]");
            Thread qc_3 = new qc$3(this, "Process Err [" + this.j6[0] + "]");
            qc$a qc_a = new qc$a(this, this.tp.getOutputStream());
            this.J0 = qc_a.j6();
            qc_1.setDaemon(true);
            qc_1.setPriority(5);
            qc_1.start();
            qc_2.setDaemon(true);
            qc_2.setPriority(5);
            qc_2.start();
            qc_3.setDaemon(true);
            qc_3.setPriority(5);
            qc_3.start();
            qc_a.setDaemon(true);
            qc_a.setPriority(5);
            qc_a.start();
        } catch (IOException e3) {
            throw new IOException("Process could not be started.");
        }
        return this.J0;
    }

    public synchronized void DW() {
        if (this.gn) {
            if (this.VH > 0) {
                if (this.tp != null) {
                    this.tp.destroy();
                }
                this.VH = 0;
                try {
                    this.J0.j6();
                } catch (IOException e) {
                }
                synchronized (this.v5) {
                    this.Zo = true;
                }
                notifyAll();
            }
        }
    }

    public synchronized void FH() {
        if (!(this.gn && this.VH == 0)) {
            wait();
        }
    }

    public synchronized void j6(OutputStream outputStream) {
        this.FH = outputStream;
    }

    public synchronized void DW(OutputStream outputStream) {
        this.Hw = outputStream;
    }

    public synchronized int Hw() {
        return this.u7;
    }

    protected void finalize() {
        if (this.gn && this.VH > 0 && this.tp != null) {
            this.tp.destroy();
        }
    }
}
