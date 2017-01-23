package com.jcraft.jsch;

import java.util.Vector;

class LocalIdentityRepository implements IdentityRepository {
    private JSch DW;
    private Vector j6;

    LocalIdentityRepository(JSch jSch) {
        this.j6 = new Vector();
        this.DW = jSch;
    }

    public synchronized Vector j6() {
        Vector vector;
        vector = new Vector();
        for (int i = 0; i < this.j6.size(); i++) {
            vector.addElement(this.j6.elementAt(i));
        }
        return vector;
    }

    public synchronized void j6(Identity identity) {
        if (!this.j6.contains(identity)) {
            this.j6.addElement(identity);
        }
    }

    public synchronized boolean j6(byte[] bArr) {
        boolean z;
        try {
            this.j6.addElement(IdentityFile.j6("from remote:", bArr, null, this.DW));
            z = true;
        } catch (JSchException e) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean DW(byte[] r5) {
        /*
        r4 = this;
        r1 = 0;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0007;
    L_0x0004:
        r0 = r1;
    L_0x0005:
        monitor-exit(r4);
        return r0;
    L_0x0007:
        r2 = r1;
    L_0x0008:
        r0 = r4.j6;	 Catch:{ all -> 0x0034 }
        r0 = r0.size();	 Catch:{ all -> 0x0034 }
        if (r2 < r0) goto L_0x0012;
    L_0x0010:
        r0 = r1;
        goto L_0x0005;
    L_0x0012:
        r0 = r4.j6;	 Catch:{ all -> 0x0034 }
        r0 = r0.elementAt(r2);	 Catch:{ all -> 0x0034 }
        r0 = (com.jcraft.jsch.Identity) r0;	 Catch:{ all -> 0x0034 }
        r3 = r0.j6();	 Catch:{ all -> 0x0034 }
        if (r3 == 0) goto L_0x0026;
    L_0x0020:
        r3 = com.jcraft.jsch.Util.DW(r5, r3);	 Catch:{ all -> 0x0034 }
        if (r3 != 0) goto L_0x002a;
    L_0x0026:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0008;
    L_0x002a:
        r1 = r4.j6;	 Catch:{ all -> 0x0034 }
        r1.removeElement(r0);	 Catch:{ all -> 0x0034 }
        r0.v5();	 Catch:{ all -> 0x0034 }
        r0 = 1;
        goto L_0x0005;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.LocalIdentityRepository.DW(byte[]):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void DW() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r2.j6;	 Catch:{ all -> 0x0021 }
        r0 = r0.size();	 Catch:{ all -> 0x0021 }
        if (r1 < r0) goto L_0x0012;
    L_0x000b:
        r0 = r2.j6;	 Catch:{ all -> 0x0021 }
        r0.removeAllElements();	 Catch:{ all -> 0x0021 }
        monitor-exit(r2);
        return;
    L_0x0012:
        r0 = r2.j6;	 Catch:{ all -> 0x0021 }
        r0 = r0.elementAt(r1);	 Catch:{ all -> 0x0021 }
        r0 = (com.jcraft.jsch.Identity) r0;	 Catch:{ all -> 0x0021 }
        r0.v5();	 Catch:{ all -> 0x0021 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0003;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.LocalIdentityRepository.DW():void");
    }
}
