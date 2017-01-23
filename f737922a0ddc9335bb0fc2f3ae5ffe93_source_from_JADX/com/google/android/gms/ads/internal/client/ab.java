package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface ab extends IInterface {

    public static abstract class a extends Binder implements ab {

        private static class a implements ab {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public String DW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(AdRequestParcel adRequestParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean j6() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
        }

        public static ab j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ab)) ? new a(iBinder) : (ab) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    j6(parcel.readInt() != 0 ? (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    String DW = DW();
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean j6 = j6();
                    parcel2.writeNoException();
                    parcel2.writeInt(j6 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String DW();

    void j6(AdRequestParcel adRequestParcel);

    boolean j6();
}
