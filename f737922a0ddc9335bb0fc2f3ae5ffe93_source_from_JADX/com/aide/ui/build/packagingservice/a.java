package com.aide.ui.build.packagingservice;

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

            public void j6(b bVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeStringArray(strArr3);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeStringArray(strArr4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeString(str7);
                    obtain.writeString(str8);
                    obtain.writeString(str9);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.ui.build.packagingservice.IExternalPackagingService");
        }

        public static a j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.ui.build.packagingservice.IExternalPackagingService");
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
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    j6(com.aide.ui.build.packagingservice.b.a.j6(parcel.readStrongBinder()));
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    j6(parcel.readString(), parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    j6();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.ui.build.packagingservice.IExternalPackagingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6();

    void j6(b bVar);

    void j6(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3);
}
