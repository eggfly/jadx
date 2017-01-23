package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {

        private static class a implements a {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.licensing.ILicenseResultListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
        }

        public static a j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicenseResultListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
                    j6(parcel.readInt(), parcel.readString(), parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6(int i, String str, String str2);
}
