package com.p029a.p030a.p031b;

import android.os.Build.VERSION;
import com.igexin.download.Downloads;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.p029a.p030a.C1061a;
import com.p029a.p030a.C1061a.C1059a;
import com.p029a.p030a.p032a.C1060a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.a.a.b.b */
public class C1071b {
    public static C1068a f3592a;
    private static C1071b f3593e;
    private static C1071b f3594f;
    private static C1071b f3595g;
    private static String[] f3596h;
    private Runnable f3597A;
    public boolean f3598b;
    public boolean f3599c;
    public boolean f3600d;
    private int f3601i;
    private C1069b f3602j;
    private C1068a f3603k;
    private String f3604l;
    private final Process f3605m;
    private final BufferedReader f3606n;
    private final BufferedReader f3607o;
    private final OutputStreamWriter f3608p;
    private final List<C1054a> f3609q;
    private boolean f3610r;
    private Boolean f3611s;
    private int f3612t;
    private int f3613u;
    private int f3614v;
    private int f3615w;
    private int f3616x;
    private boolean f3617y;
    private Runnable f3618z;

    /* renamed from: com.a.a.b.b.1 */
    class C10651 implements Runnable {
        final /* synthetic */ C1071b f3574a;

        C10651(C1071b c1071b) {
            this.f3574a = c1071b;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r4 = this;
            r3 = 0;
        L_0x0001:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r0.f3609q;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            monitor-enter(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
        L_0x0008:
            r0 = r4.f3574a;	 Catch:{ all -> 0x0031 }
            r0 = r0.f3610r;	 Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x004f;
        L_0x0010:
            r0 = r4.f3574a;	 Catch:{ all -> 0x0031 }
            r0 = r0.f3614v;	 Catch:{ all -> 0x0031 }
            r2 = r4.f3574a;	 Catch:{ all -> 0x0031 }
            r2 = r2.f3609q;	 Catch:{ all -> 0x0031 }
            r2 = r2.size();	 Catch:{ all -> 0x0031 }
            if (r0 < r2) goto L_0x004f;
        L_0x0022:
            r0 = r4.f3574a;	 Catch:{ all -> 0x0031 }
            r2 = 0;
            r0.f3598b = r2;	 Catch:{ all -> 0x0031 }
            r0 = r4.f3574a;	 Catch:{ all -> 0x0031 }
            r0 = r0.f3609q;	 Catch:{ all -> 0x0031 }
            r0.wait();	 Catch:{ all -> 0x0031 }
            goto L_0x0008;
        L_0x0031:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0031 }
            throw r0;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
        L_0x0034:
            r0 = move-exception;
            r1 = r0.getMessage();	 Catch:{ all -> 0x0132 }
            r2 = com.p029a.p030a.C1061a.C1059a.ERROR;	 Catch:{ all -> 0x0132 }
            com.p029a.p030a.C1061a.m4739a(r1, r2, r0);	 Catch:{ all -> 0x0132 }
            r0 = r4.f3574a;
            r0.f3614v = r3;
            r0 = r4.f3574a;
            r1 = r4.f3574a;
            r1 = r1.f3608p;
            r0.m4760a(r1);
        L_0x004e:
            return;
        L_0x004f:
            monitor-exit(r1);	 Catch:{ all -> 0x0031 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3614v;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3612t;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            if (r0 < r1) goto L_0x0092;
        L_0x005e:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3613u;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3614v;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            if (r0 == r1) goto L_0x008d;
        L_0x006c:
            r0 = "Waiting for read and write to catch up before cleanup.";
            com.p029a.p030a.C1061a.m4746c(r0);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            goto L_0x005e;
        L_0x0072:
            r0 = move-exception;
            r1 = r0.getMessage();	 Catch:{ all -> 0x0132 }
            r2 = com.p029a.p030a.C1061a.C1059a.ERROR;	 Catch:{ all -> 0x0132 }
            com.p029a.p030a.C1061a.m4739a(r1, r2, r0);	 Catch:{ all -> 0x0132 }
            r0 = r4.f3574a;
            r0.f3614v = r3;
            r0 = r4.f3574a;
            r1 = r4.f3574a;
            r1 = r1.f3608p;
            r0.m4760a(r1);
            goto L_0x004e;
        L_0x008d:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.m4775i();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
        L_0x0092:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3614v;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3609q;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.size();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            if (r0 >= r1) goto L_0x0144;
        L_0x00a4:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = 1;
            r0.f3598b = r1;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3609q;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3614v;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.get(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = (com.p029a.p030a.p031b.C1054a) r0;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.m4728f();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1.<init>();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r2 = "Executing: ";
            r1 = r1.append(r2);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r2 = r0.m4724c();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.append(r2);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r2 = " with context: ";
            r1 = r1.append(r2);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r2 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r2 = r2.f3603k;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.append(r2);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.toString();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            com.p029a.p030a.C1061a.m4746c(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3608p;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.m4724c();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1.write(r0);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.<init>();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = "\necho F*D^W@#FGF ";
            r0 = r0.append(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3615w;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.append(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = " $?\n";
            r0 = r0.append(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.toString();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = r1.f3608p;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1.write(r0);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3608p;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.flush();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.f3614v = r0.f3614v + 1;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.f3615w = r0.f3615w + 1;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            goto L_0x0001;
        L_0x0132:
            r0 = move-exception;
            r1 = r4.f3574a;
            r1.f3614v = r3;
            r1 = r4.f3574a;
            r2 = r4.f3574a;
            r2 = r2.f3608p;
            r1.m4760a(r2);
            throw r0;
        L_0x0144:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3610r;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            if (r0 == 0) goto L_0x0001;
        L_0x014c:
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = 0;
            r0.f3598b = r1;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3608p;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r1 = "\nexit 0\n";
            r0.write(r1);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r0.f3608p;	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0.flush();	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = "Closing shell";
            com.p029a.p030a.C1061a.m4746c(r0);	 Catch:{ IOException -> 0x0034, InterruptedException -> 0x0072 }
            r0 = r4.f3574a;
            r0.f3614v = r3;
            r0 = r4.f3574a;
            r1 = r4.f3574a;
            r1 = r1.f3608p;
            r0.m4760a(r1);
            goto L_0x004e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.b.1.run():void");
        }
    }

    /* renamed from: com.a.a.b.b.2 */
    class C10662 extends Thread {
        final /* synthetic */ C1071b f3575a;

        C10662(C1071b c1071b) {
            this.f3575a = c1071b;
        }

        public void run() {
            synchronized (this.f3575a.f3609q) {
                this.f3575a.f3609q.notifyAll();
            }
        }
    }

    /* renamed from: com.a.a.b.b.3 */
    class C10673 implements Runnable {
        final /* synthetic */ C1071b f3576a;

        C10673(C1071b c1071b) {
            this.f3576a = c1071b;
        }

        public void run() {
            C1054a c1054a = null;
            while (true) {
                if (!this.f3576a.f3610r || this.f3576a.f3606n.ready() || this.f3576a.f3613u < this.f3576a.f3609q.size()) {
                    this.f3576a.f3599c = false;
                    String readLine = this.f3576a.f3606n.readLine();
                    this.f3576a.f3599c = true;
                    if (readLine != null) {
                        C1054a c1054a2;
                        if (c1054a != null) {
                            c1054a2 = c1054a;
                        } else if (this.f3576a.f3613u < this.f3576a.f3609q.size()) {
                            c1054a2 = (C1054a) this.f3576a.f3609q.get(this.f3576a.f3613u);
                        } else if (this.f3576a.f3610r) {
                            break;
                        }
                        int indexOf = readLine.indexOf("F*D^W@#FGF");
                        if (indexOf == -1) {
                            c1054a2.m4725c(c1054a2.f3556p, readLine);
                        } else if (indexOf > 0) {
                            c1054a2.m4725c(c1054a2.f3556p, readLine.substring(0, indexOf));
                        }
                        if (indexOf >= 0) {
                            String[] split = readLine.substring(indexOf).split(" ");
                            if (split.length >= 2 && split[1] != null) {
                                int parseInt;
                                try {
                                    indexOf = Integer.parseInt(split[1]);
                                } catch (NumberFormatException e) {
                                    indexOf = 0;
                                }
                                try {
                                    parseInt = Integer.parseInt(split[2]);
                                } catch (NumberFormatException e2) {
                                    parseInt = -1;
                                }
                                try {
                                    if (indexOf == this.f3576a.f3616x) {
                                        this.f3576a.m4789d(c1054a2);
                                        indexOf = 0;
                                        while (c1054a2.f3546f > c1054a2.f3547g) {
                                            if (indexOf == 0) {
                                                indexOf++;
                                                C1061a.m4746c("Waiting for output to be processed. " + c1054a2.f3547g + " Of " + c1054a2.f3546f);
                                            }
                                            int i = indexOf;
                                            try {
                                                synchronized (this) {
                                                    wait(2000);
                                                }
                                                indexOf = i;
                                            } catch (Exception e3) {
                                                C1061a.m4746c(e3.getMessage());
                                                indexOf = i;
                                            }
                                        }
                                        C1061a.m4746c("Read all output");
                                        c1054a2.m4717a(parseInt);
                                        c1054a2.m4716a();
                                        this.f3576a.f3613u = this.f3576a.f3613u + 1;
                                        this.f3576a.f3616x = this.f3576a.f3616x + 1;
                                        c1054a = null;
                                    }
                                } catch (Exception e32) {
                                    C1061a.m4739a(e32.getMessage(), C1059a.ERROR, e32);
                                } finally {
                                    this.f3576a.m4760a(this.f3576a.f3608p);
                                    this.f3576a.m4759a(this.f3576a.f3607o);
                                    this.f3576a.m4759a(this.f3576a.f3606n);
                                    C1061a.m4746c("Shell destroyed");
                                    this.f3576a.f3600d = true;
                                    this.f3576a.f3599c = false;
                                }
                            }
                        }
                        c1054a = c1054a2;
                    }
                }
                break;
            }
            try {
                break;
                this.f3576a.f3605m.waitFor();
                this.f3576a.f3605m.destroy();
            } catch (Exception e4) {
            }
            while (this.f3576a.f3613u < this.f3576a.f3609q.size()) {
                if (c1054a == null) {
                    c1054a = (C1054a) this.f3576a.f3609q.get(this.f3576a.f3613u);
                }
                if (c1054a.f3546f < c1054a.f3547g) {
                    c1054a.m4723b("All output not processed!");
                    c1054a.m4723b("Did you forget the super.commandOutput call or are you waiting on the command object?");
                } else {
                    c1054a.m4723b("Unexpected Termination.");
                }
                this.f3576a.f3613u = this.f3576a.f3613u + 1;
                c1054a = null;
            }
            this.f3576a.f3613u = 0;
        }
    }

    /* renamed from: com.a.a.b.b.a */
    public enum C1068a {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");
        
        private String f3585h;

        private C1068a(String str) {
            this.f3585h = str;
        }

        public String m4748a() {
            return this.f3585h;
        }
    }

    /* renamed from: com.a.a.b.b.b */
    public enum C1069b {
        NORMAL,
        ROOT,
        CUSTOM
    }

    /* renamed from: com.a.a.b.b.c */
    protected static class C1070c extends Thread {
        public int f3590a;
        public C1071b f3591b;

        private C1070c(C1071b c1071b) {
            this.f3590a = -911;
            this.f3591b = c1071b;
        }

        private void m4749a() {
            try {
                Field declaredField;
                try {
                    declaredField = this.f3591b.f3605m.getClass().getDeclaredField("pid");
                } catch (NoSuchFieldException e) {
                    declaredField = r0.getDeclaredField(AgooConstants.MESSAGE_ID);
                }
                declaredField.setAccessible(true);
                this.f3591b.f3608p.write("(echo -17 > /proc/" + ((Integer) declaredField.get(this.f3591b.f3605m)).intValue() + "/oom_adj) &> /dev/null\n");
                this.f3591b.f3608p.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.f3591b.f3608p.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void run() {
            try {
                this.f3591b.f3608p.write("echo Started\n");
                this.f3591b.f3608p.flush();
                while (true) {
                    String readLine = this.f3591b.f3606n.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!BuildConfig.FLAVOR.equals(readLine)) {
                        if ("Started".equals(readLine)) {
                            this.f3590a = 1;
                            m4749a();
                            return;
                        }
                        this.f3591b.f3604l = "unkown error occured.";
                    }
                }
                throw new EOFException();
            } catch (IOException e) {
                this.f3590a = -42;
                if (e.getMessage() != null) {
                    this.f3591b.f3604l = e.getMessage();
                } else {
                    this.f3591b.f3604l = "RootAccess denied?.";
                }
            }
        }
    }

    static {
        f3593e = null;
        f3594f = null;
        f3595g = null;
        f3596h = new String[]{null, null};
        f3592a = C1068a.NORMAL;
    }

    private C1071b(String str, C1069b c1069b, C1068a c1068a, int i) {
        this.f3601i = 25000;
        this.f3602j = null;
        this.f3603k = C1068a.NORMAL;
        this.f3604l = BuildConfig.FLAVOR;
        this.f3609q = new ArrayList();
        this.f3610r = false;
        this.f3611s = null;
        this.f3598b = false;
        this.f3599c = false;
        this.f3600d = false;
        this.f3612t = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f3613u = 0;
        this.f3614v = 0;
        this.f3615w = 0;
        this.f3616x = 0;
        this.f3617y = false;
        this.f3618z = new C10651(this);
        this.f3597A = new C10673(this);
        C1061a.m4746c("Starting shell: " + str);
        C1061a.m4746c("Context: " + c1068a.m4748a());
        C1061a.m4746c("Timeout: " + i);
        this.f3602j = c1069b;
        if (i <= 0) {
            i = this.f3601i;
        }
        this.f3601i = i;
        this.f3603k = c1068a;
        if (this.f3603k == C1068a.NORMAL) {
            this.f3605m = Runtime.getRuntime().exec(str);
        } else {
            String a = m4755a(false);
            String a2 = m4755a(true);
            if (!m4790f() || a == null || a2 == null || !a.endsWith("SUPERSU") || Integer.valueOf(a2).intValue() < Downloads.STATUS_PENDING) {
                C1061a.m4746c("Su binary --context switch not supported!");
                C1061a.m4746c("Su binary display version: " + a);
                C1061a.m4746c("Su binary internal version: " + a2);
                C1061a.m4746c("SELinuxEnforcing: " + m4790f());
            } else {
                str = str + " --context " + this.f3603k.m4748a();
            }
            this.f3605m = Runtime.getRuntime().exec(str);
        }
        this.f3606n = new BufferedReader(new InputStreamReader(this.f3605m.getInputStream(), HttpRequest.f14548a));
        this.f3607o = new BufferedReader(new InputStreamReader(this.f3605m.getErrorStream(), HttpRequest.f14548a));
        this.f3608p = new OutputStreamWriter(this.f3605m.getOutputStream(), HttpRequest.f14548a);
        C1070c c1070c = new C1070c();
        c1070c.start();
        try {
            c1070c.join((long) this.f3601i);
            if (c1070c.f3590a == -911) {
                try {
                    this.f3605m.destroy();
                } catch (Exception e) {
                }
                m4759a(this.f3606n);
                m4759a(this.f3607o);
                m4760a(this.f3608p);
                throw new TimeoutException(this.f3604l);
            } else if (c1070c.f3590a == -42) {
                try {
                    this.f3605m.destroy();
                } catch (Exception e2) {
                }
                m4759a(this.f3606n);
                m4759a(this.f3607o);
                m4760a(this.f3608p);
                throw new C1060a("Root Access Denied");
            } else {
                Thread thread = new Thread(this.f3618z, "Shell Input");
                thread.setPriority(5);
                thread.start();
                thread = new Thread(this.f3597A, "Shell Output");
                thread.setPriority(5);
                thread.start();
            }
        } catch (InterruptedException e3) {
            c1070c.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public static C1071b m4751a(int i) {
        try {
            if (f3594f == null) {
                C1061a.m4746c("Starting Shell!");
                f3594f = new C1071b("/system/bin/sh", C1069b.NORMAL, C1068a.NORMAL, i);
            } else {
                C1061a.m4746c("Using Existing Shell!");
            }
            return f3594f;
        } catch (C1060a e) {
            throw new IOException();
        }
    }

    public static C1071b m4752a(int i, int i2) {
        return C1071b.m4753a(i, f3592a, i2);
    }

    public static C1071b m4753a(int i, C1068a c1068a, int i2) {
        int i3;
        int i4 = 0;
        if (f3593e == null) {
            C1061a.m4746c("Starting Root Shell!");
            String str = "su";
            while (f3593e == null) {
                try {
                    C1061a.m4746c("Trying to open Root Shell, attempt #" + i4);
                    f3593e = new C1071b(str, C1069b.ROOT, c1068a, i);
                } catch (IOException e) {
                    IOException iOException = e;
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        C1061a.m4746c("IOException, could not start shell");
                        throw iOException;
                    }
                    i4 = i3;
                } catch (C1060a e2) {
                    C1060a c1060a = e2;
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        C1061a.m4746c("RootDeniedException, could not start shell");
                        throw c1060a;
                    }
                    i4 = i3;
                } catch (TimeoutException e3) {
                    TimeoutException timeoutException = e3;
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        C1061a.m4746c("TimeoutException, could not start shell");
                        throw timeoutException;
                    }
                    i4 = i3;
                }
            }
        } else if (f3593e.f3603k != c1068a) {
            try {
                C1061a.m4746c("Context is different than open shell, switching context... " + f3593e.f3603k + " VS " + c1068a);
                f3593e.m4785a(c1068a);
            } catch (IOException e4) {
                if (0 >= i2) {
                    C1061a.m4746c("IOException, could not switch context!");
                    throw e4;
                }
            } catch (C1060a e22) {
                if (0 >= i2) {
                    C1061a.m4746c("RootDeniedException, could not switch context!");
                    throw e22;
                }
            } catch (TimeoutException e32) {
                if (0 >= i2) {
                    C1061a.m4746c("TimeoutException, could not switch context!");
                    throw e32;
                }
            }
        } else {
            C1061a.m4746c("Using Existing Root Shell!");
        }
        return f3593e;
    }

    private synchronized String m4755a(boolean z) {
        String str;
        int i = z ? 0 : 1;
        if (f3596h[i] == null) {
            try {
                Process exec = Runtime.getRuntime().exec(z ? "su -V" : "su -v", null);
                exec.waitFor();
                List<String> arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        }
                    } catch (IOException e) {
                    }
                    try {
                        break;
                    } catch (IOException e2) {
                    }
                }
                bufferedReader.close();
                exec.destroy();
                if (arrayList != null) {
                    for (String str2 : arrayList) {
                        if (z) {
                            try {
                                if (Integer.parseInt(str2) > 0) {
                                    break;
                                }
                            } catch (NumberFormatException e3) {
                            }
                        } else if (str2.contains(".")) {
                            break;
                        }
                    }
                }
                str2 = null;
                f3596h[i] = str2;
            } catch (IOException e4) {
                e4.printStackTrace();
                str2 = null;
            } catch (InterruptedException e5) {
                e5.printStackTrace();
                str2 = null;
            }
        }
        str2 = f3596h[i];
        return str2;
    }

    private void m4759a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }

    private void m4760a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void m4762b() {
        C1061a.m4746c("Request to close custom shell!");
        if (f3595g != null) {
            f3595g.m4786a();
        }
    }

    public static void m4765c() {
        C1061a.m4746c("Request to close root shell!");
        if (f3593e != null) {
            f3593e.m4786a();
        }
    }

    public static void m4767d() {
        C1061a.m4746c("Request to close normal shell!");
        if (f3594f != null) {
            f3594f.m4786a();
        }
    }

    public static void m4769e() {
        C1061a.m4746c("Request to close all shells!");
        C1071b.m4767d();
        C1071b.m4765c();
        C1071b.m4762b();
    }

    public static C1071b m4772h() {
        return C1071b.m4752a(0, 3);
    }

    private void m4775i() {
        this.f3617y = true;
        int abs = Math.abs(this.f3612t - (this.f3612t / 4));
        C1061a.m4746c("Cleaning up: " + abs);
        for (int i = 0; i < abs; i++) {
            this.f3609q.remove(0);
        }
        this.f3613u = this.f3609q.size() - 1;
        this.f3614v = this.f3609q.size() - 1;
        this.f3617y = false;
    }

    public C1054a m4784a(C1054a c1054a) {
        if (this.f3610r) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        do {
        } while (this.f3617y);
        c1054a.m4729g();
        this.f3609q.add(c1054a);
        m4791g();
        return c1054a;
    }

    public C1071b m4785a(C1068a c1068a) {
        if (this.f3602j == C1069b.ROOT) {
            try {
                C1071b.m4765c();
            } catch (Exception e) {
                C1061a.m4746c("Problem closing shell while trying to switch context...");
            }
            return C1071b.m4753a(this.f3601i, c1068a, 3);
        }
        C1061a.m4746c("Can only switch context on a root shell!");
        return this;
    }

    public void m4786a() {
        C1061a.m4746c("Request to close shell!");
        int i = 0;
        while (this.f3598b) {
            C1061a.m4746c("Waiting on shell to finish executing before closing...");
            i++;
            if (i > 10000) {
                break;
            }
        }
        synchronized (this.f3609q) {
            this.f3610r = true;
            m4791g();
        }
        C1061a.m4746c("Shell Closed!");
        if (this == f3593e) {
            f3593e = null;
        } else if (this == f3594f) {
            f3594f = null;
        } else if (this == f3595g) {
            f3595g = null;
        }
    }

    public int m4787b(C1054a c1054a) {
        return this.f3609q.indexOf(c1054a);
    }

    public String m4788c(C1054a c1054a) {
        return "Command is in position " + m4787b(c1054a) + " currently executing command at position " + this.f3614v + " and the number of commands is " + this.f3609q.size();
    }

    public void m4789d(C1054a c1054a) {
        while (this.f3607o.ready() && c1054a != null) {
            try {
                String readLine = this.f3607o.readLine();
                if (readLine != null) {
                    c1054a.m4725c(c1054a.f3556p, readLine);
                } else {
                    return;
                }
            } catch (Exception e) {
                C1061a.m4739a(e.getMessage(), C1059a.ERROR, e);
                return;
            }
        }
    }

    public synchronized boolean m4790f() {
        if (this.f3611s == null) {
            Boolean valueOf;
            if (VERSION.SDK_INT >= 17) {
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    InputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        valueOf = Boolean.valueOf(fileInputStream.read() == 49);
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        valueOf = null;
                    } catch (Throwable th) {
                        fileInputStream.close();
                    }
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    valueOf = Boolean.valueOf(VERSION.SDK_INT >= 19);
                }
            } else {
                valueOf = null;
            }
            if (valueOf == null) {
                valueOf = Boolean.valueOf(false);
            }
            this.f3611s = valueOf;
        }
        return this.f3611s.booleanValue();
    }

    protected void m4791g() {
        new C10662(this).start();
    }
}
