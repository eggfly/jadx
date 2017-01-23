package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.engine.SourceEntity;
import com.aide.uidesigner.ProxyTextView;

public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        private static class a implements h {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(String str, long j, int i, int i2, SourceEntity sourceEntity) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.INavigationListener");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (sourceEntity != null) {
                        obtain.writeInt(1);
                        sourceEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, long j, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.INavigationListener");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.INavigationListener");
        }

        public static h j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.INavigationListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    SourceEntity sourceEntity;
                    parcel.enforceInterface("com.aide.engine.service.INavigationListener");
                    String readString = parcel.readString();
                    long readLong = parcel.readLong();
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        sourceEntity = (SourceEntity) SourceEntity.CREATOR.createFromParcel(parcel);
                    } else {
                        sourceEntity = null;
                    }
                    j6(readString, readLong, readInt, readInt2, sourceEntity);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.INavigationListener");
                    j6(parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.INavigationListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6(String str, long j, int i, int i2);

    void j6(String str, long j, int i, int i2, SourceEntity sourceEntity);
}
