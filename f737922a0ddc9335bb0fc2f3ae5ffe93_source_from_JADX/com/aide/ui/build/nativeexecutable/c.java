package com.aide.ui.build.nativeexecutable;

import com.aide.common.e;
import com.aide.common.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import qd;
import qe;
import qh;

public class c {
    private a DW;
    private a FH;
    private final ExecutorService j6;

    private class a extends FutureTask<Void> {
        private b DW;
        final /* synthetic */ c j6;

        public a(c cVar, b bVar) {
            this.j6 = cVar;
            super(bVar);
            this.DW = bVar;
        }

        protected void done() {
            if (!isCancelled()) {
                try {
                    get();
                    this.j6.j6();
                } catch (InterruptedException e) {
                    this.j6.DW();
                } catch (ExecutionException e2) {
                    this.j6.j6(e2.getCause());
                }
            }
        }
    }

    private class b implements Callable<Void> {
        private String DW;
        private String FH;
        final /* synthetic */ c j6;

        public /* synthetic */ Object call() {
            return j6();
        }

        public b(c cVar, String str, String str2) {
            this.j6 = cVar;
            this.DW = str;
            this.FH = str2;
        }

        public Void j6() {
            if (qh.VH(this.FH)) {
                qh.j3(this.FH);
            }
            qh.Mr(this.FH);
            File file = new File(this.FH, new File(this.DW).getName());
            w.j6(new FileInputStream(this.DW), new FileOutputStream(file));
            j6(file);
            return null;
        }

        private void j6(File file) {
            qd j6;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            try {
                j6 = qe.j6(Arrays.asList(new String[]{"/system/bin/chmod", "777", file.getPath()}), null, null, true, null, null);
                if (j6.j6() != 0) {
                    throw new IOException("Could not make " + file.getPath() + " executable - exit code " + j6.j6());
                }
            } catch (IOException e) {
                j6 = qe.j6(Arrays.asList(new String[]{"/system/xbin/chmod", "777", file.getPath()}), null, null, true, null, null);
                if (j6.j6() != 0) {
                    throw new IOException("Could not make " + file.getPath() + " executable - exit code " + j6.j6());
                }
            }
        }
    }

    public c() {
        this.j6 = Executors.newSingleThreadExecutor();
    }

    public void j6(String str, String str2) {
        ExecutorService executorService = this.j6;
        Runnable aVar = new a(this, new b(this, str, str2));
        this.DW = aVar;
        executorService.execute(aVar);
    }

    private void j6() {
        if (this.FH != null) {
            this.FH.j6();
        }
    }

    private void DW() {
        if (this.FH != null) {
            this.FH.DW();
        }
    }

    private void j6(Throwable th) {
        e.j6(th);
        if (this.FH != null) {
            this.FH.j6(th);
        }
    }

    public void j6(a aVar) {
        this.FH = aVar;
    }
}
