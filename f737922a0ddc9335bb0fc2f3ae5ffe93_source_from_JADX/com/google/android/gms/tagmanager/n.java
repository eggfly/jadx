package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class n extends Thread implements m {
    private static n Hw;
    private volatile boolean DW;
    private volatile boolean FH;
    private final Context Zo;
    private final LinkedBlockingQueue<Runnable> j6;
    private volatile o v5;

    class 1 implements Runnable {
        final /* synthetic */ long DW;
        final /* synthetic */ String FH;
        final /* synthetic */ n Hw;
        final /* synthetic */ m j6;

        1(n nVar, m mVar, long j, String str) {
            this.Hw = nVar;
            this.j6 = mVar;
            this.DW = j;
            this.FH = str;
        }

        public void run() {
            if (this.Hw.v5 == null) {
                an FH = an.FH();
                FH.j6(this.Hw.Zo, this.j6);
                this.Hw.v5 = FH.Hw();
            }
            this.Hw.v5.j6(this.DW, this.FH);
        }
    }

    private n(Context context) {
        super("GAThread");
        this.j6 = new LinkedBlockingQueue();
        this.DW = false;
        this.FH = false;
        if (context != null) {
            this.Zo = context.getApplicationContext();
        } else {
            this.Zo = context;
        }
        start();
    }

    static n j6(Context context) {
        if (Hw == null) {
            Hw = new n(context);
        }
        return Hw;
    }

    private String j6(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void j6(Runnable runnable) {
        this.j6.add(runnable);
    }

    public void j6(String str) {
        j6(str, System.currentTimeMillis());
    }

    void j6(String str, long j) {
        j6(new 1(this, this, j, str));
    }

    public void run() {
        while (!this.FH) {
            try {
                Runnable runnable = (Runnable) this.j6.take();
                if (!this.DW) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                r.FH(e.toString());
            } catch (Throwable th) {
                String str = "Error on Google TagManager Thread: ";
                String valueOf = String.valueOf(j6(th));
                r.j6(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                r.j6("Google TagManager is shutting down.");
                this.DW = true;
            }
        }
    }
}
