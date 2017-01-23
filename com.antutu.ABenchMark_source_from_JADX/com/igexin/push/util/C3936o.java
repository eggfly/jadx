package com.igexin.push.util;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.igexin.push.util.o */
final class C3936o implements IInterface {
    private IBinder f13217a;

    public C3936o(IBinder iBinder) {
        this.f13217a = iBinder;
    }

    public String m16189a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        String str = null;
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f13217a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Exception e) {
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
        return str;
    }

    public IBinder asBinder() {
        return this.f13217a;
    }
}
