package com.aide.ui.build.packagingservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        private static class a implements b {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    obtain.writeString(str);
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    this.j6.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
        }

        public static b j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    j6(parcel.readInt() != 0);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    j6(parcel.readString(), parcel.readInt());
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    j6(parcel.readString());
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    j6();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.ui.build.packagingservice.IExternalPackagingServiceListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6();

    void j6(String str);

    void j6(String str, int i);

    void j6(boolean z);
}
