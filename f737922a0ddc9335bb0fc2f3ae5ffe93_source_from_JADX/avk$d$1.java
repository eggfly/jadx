import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class avk$d$1 extends Thread {
    private final /* synthetic */ PipedInputStream DW;
    private final /* synthetic */ PipedOutputStream FH;
    private final /* synthetic */ aoh Hw;
    final /* synthetic */ avk$d j6;

    avk$d$1(avk$d avk_d, String str, PipedInputStream pipedInputStream, PipedOutputStream pipedOutputStream, aoh aoh) {
        this.j6 = avk_d;
        this.DW = pipedInputStream;
        this.FH = pipedOutputStream;
        this.Hw = aoh;
        super(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = r4.j6;	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r0 = r0.J0;	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r1 = r4.Hw;	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r0 = r0.DW(r1);	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r1 = r4.DW;	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r2 = r4.FH;	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r3 = java.lang.System.err;	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r0.j6(r1, r2, r3);	 Catch:{ IOException -> 0x0025, RuntimeException -> 0x0036, all -> 0x0047 }
        r0 = r4.DW;	 Catch:{ IOException -> 0x005a }
        r0.close();	 Catch:{ IOException -> 0x005a }
    L_0x001a:
        r0 = r4.FH;	 Catch:{ IOException -> 0x0058 }
        r0.close();	 Catch:{ IOException -> 0x0058 }
    L_0x001f:
        r0 = r4.Hw;
        r0.tp();
    L_0x0024:
        return;
    L_0x0025:
        r0 = move-exception;
        r0 = r4.DW;	 Catch:{ IOException -> 0x0066 }
        r0.close();	 Catch:{ IOException -> 0x0066 }
    L_0x002b:
        r0 = r4.FH;	 Catch:{ IOException -> 0x0064 }
        r0.close();	 Catch:{ IOException -> 0x0064 }
    L_0x0030:
        r0 = r4.Hw;
        r0.tp();
        goto L_0x0024;
    L_0x0036:
        r0 = move-exception;
        r0 = r4.DW;	 Catch:{ IOException -> 0x0062 }
        r0.close();	 Catch:{ IOException -> 0x0062 }
    L_0x003c:
        r0 = r4.FH;	 Catch:{ IOException -> 0x0060 }
        r0.close();	 Catch:{ IOException -> 0x0060 }
    L_0x0041:
        r0 = r4.Hw;
        r0.tp();
        goto L_0x0024;
    L_0x0047:
        r0 = move-exception;
        r1 = r4.DW;	 Catch:{ IOException -> 0x005e }
        r1.close();	 Catch:{ IOException -> 0x005e }
    L_0x004d:
        r1 = r4.FH;	 Catch:{ IOException -> 0x005c }
        r1.close();	 Catch:{ IOException -> 0x005c }
    L_0x0052:
        r1 = r4.Hw;
        r1.tp();
        throw r0;
    L_0x0058:
        r0 = move-exception;
        goto L_0x001f;
    L_0x005a:
        r0 = move-exception;
        goto L_0x001a;
    L_0x005c:
        r1 = move-exception;
        goto L_0x0052;
    L_0x005e:
        r1 = move-exception;
        goto L_0x004d;
    L_0x0060:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0062:
        r0 = move-exception;
        goto L_0x003c;
    L_0x0064:
        r0 = move-exception;
        goto L_0x0030;
    L_0x0066:
        r0 = move-exception;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: avk$d$1.run():void");
    }
}
