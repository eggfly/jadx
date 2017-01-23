package com.google.android.gms.internal;

import agg;
import agg$a;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface bd extends IInterface {

    public static abstract class a extends Binder implements bd {

        private static class a implements bd {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public Uri DW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return uri;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public double FH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    double readDouble = obtain2.readDouble();
                    return readDouble;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public agg j6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    agg j6 = agg$a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        }

        public static bd j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bd)) ? new a(iBinder) : (bd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    agg j6 = j6();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(j6 != null ? j6.asBinder() : null);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    Uri DW = DW();
                    parcel2.writeNoException();
                    if (DW != null) {
                        parcel2.writeInt(1);
                        DW.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    double FH = FH();
                    parcel2.writeNoException();
                    parcel2.writeDouble(FH);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Uri DW();

    double FH();

    agg j6();
}
