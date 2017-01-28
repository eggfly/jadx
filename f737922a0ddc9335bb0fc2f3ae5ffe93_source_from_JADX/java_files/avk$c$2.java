import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class avk$c$2 extends Thread {
    private final /* synthetic */ PipedInputStream DW;
    private final /* synthetic */ PipedOutputStream FH;
    private final /* synthetic */ aoh Hw;
    final /* synthetic */ avk$c j6;

    avk$c$2(avk$c avk_c, String str, PipedInputStream pipedInputStream, PipedOutputStream pipedOutputStream, aoh aoh) {
        this.j6 = avk_c;
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
        r0 = r4.j6;	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r0 = r0.QX;	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r1 = r4.Hw;	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r0 = r0.j6(r1);	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r1 = r4.DW;	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r2 = r4.FH;	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r3 = 0;
        r0.j6(r1, r2, r3);	 Catch:{ IOException -> 0x0024, RuntimeException -> 0x0038 }
        r0 = r4.DW;	 Catch:{ IOException -> 0x005f }
        r0.close();	 Catch:{ IOException -> 0x005f }
    L_0x0019:
        r0 = r4.FH;	 Catch:{ IOException -> 0x005d }
        r0.close();	 Catch:{ IOException -> 0x005d }
    L_0x001e:
        r0 = r4.Hw;
        r0.tp();
    L_0x0023:
        return;
    L_0x0024:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x004c }
        r0 = r4.DW;	 Catch:{ IOException -> 0x006b }
        r0.close();	 Catch:{ IOException -> 0x006b }
    L_0x002d:
        r0 = r4.FH;	 Catch:{ IOException -> 0x0069 }
        r0.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0032:
        r0 = r4.Hw;
        r0.tp();
        goto L_0x0023;
    L_0x0038:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x004c }
        r0 = r4.DW;	 Catch:{ IOException -> 0x0067 }
        r0.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0041:
        r0 = r4.FH;	 Catch:{ IOException -> 0x0065 }
        r0.close();	 Catch:{ IOException -> 0x0065 }
    L_0x0046:
        r0 = r4.Hw;
        r0.tp();
        goto L_0x0023;
    L_0x004c:
        r0 = move-exception;
        r1 = r4.DW;	 Catch:{ IOException -> 0x0063 }
        r1.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0052:
        r1 = r4.FH;	 Catch:{ IOException -> 0x0061 }
        r1.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0057:
        r1 = r4.Hw;
        r1.tp();
        throw r0;
    L_0x005d:
        r0 = move-exception;
        goto L_0x001e;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0061:
        r1 = move-exception;
        goto L_0x0057;
    L_0x0063:
        r1 = move-exception;
        goto L_0x0052;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0046;
    L_0x0067:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0069:
        r0 = move-exception;
        goto L_0x0032;
    L_0x006b:
        r0 = move-exception;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: avk$c$2.run():void");
    }
}
