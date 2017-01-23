package com.cmcm.p074a.p075a.p115d;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.cmcm.a.a.d.c */
class C2163c implements C2162d {
    private IBinder f7522a;

    C2163c(IBinder iBinder) {
        this.f7522a = iBinder;
    }

    public String m8155a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f7522a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean m8156a(boolean r8) {
        /* JADX: method processing error */
/*
        Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r3 = android.os.Parcel.obtain();
        r4 = android.os.Parcel.obtain();
        r2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r3.writeInterfaceToken(r2);	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        if (r8 == 0) goto L_0x002c;	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
    L_0x0011:
        r2 = r0;	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
    L_0x0012:
        r3.writeInt(r2);	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r2 = r7.f7522a;	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r5 = 2;	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r6 = 0;	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r2.transact(r5, r3, r4, r6);	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r4.readException();	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        r2 = r4.readInt();	 Catch:{ SecurityException -> 0x0030, all -> 0x0039 }
        if (r2 == 0) goto L_0x002e;
    L_0x0025:
        r4.recycle();
        r3.recycle();
    L_0x002b:
        return r0;
    L_0x002c:
        r2 = r1;
        goto L_0x0012;
    L_0x002e:
        r0 = r1;
        goto L_0x0025;
    L_0x0030:
        r0 = move-exception;
        r4.recycle();
        r3.recycle();
        r0 = r1;
        goto L_0x002b;
    L_0x0039:
        r0 = move-exception;
        r4.recycle();
        r3.recycle();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmcm.a.a.d.c.a(boolean):boolean");
    }

    public IBinder asBinder() {
        return this.f7522a;
    }
}
