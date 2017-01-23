package com.google.android.gms.internal;

import agg;
import agg$a;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface bg extends IInterface {

    public static abstract class a extends Binder implements bg {

        private static class a implements bg {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public IBinder j6(agg agg, agg agg2, agg agg3, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    obtain.writeStrongBinder(agg2 != null ? agg2.asBinder() : null);
                    if (agg3 != null) {
                        iBinder = agg3.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static bg j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bg)) ? new a(iBinder) : (bg) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    IBinder j6 = j6(agg$a.j6(parcel.readStrongBinder()), agg$a.j6(parcel.readStrongBinder()), agg$a.j6(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(j6);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder j6(agg agg, agg agg2, agg agg3, int i);
}
