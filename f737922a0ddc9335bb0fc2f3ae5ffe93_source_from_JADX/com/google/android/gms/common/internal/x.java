package com.google.android.gms.common.internal;

import agg;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface x extends IInterface {

    public static abstract class a extends Binder implements x {
        public a() {
            attachInterface(this, "com.google.android.gms.common.internal.ICertData");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                    agg j6 = j6();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(j6 != null ? j6.asBinder() : null);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                    int DW = DW();
                    parcel2.writeNoException();
                    parcel2.writeInt(DW);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.ICertData");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int DW();

    agg j6();
}
