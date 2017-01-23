package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        private static class a implements i {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public long j6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IOpenFileInterface");
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long DW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IOpenFileInterface");
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int FH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IOpenFileInterface");
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CharArray j6(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    CharArray charArray;
                    obtain.writeInterfaceToken("com.aide.engine.service.IOpenFileInterface");
                    obtain.writeInt(i);
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        charArray = (CharArray) CharArray.CREATOR.createFromParcel(obtain2);
                    } else {
                        charArray = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return charArray;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.IOpenFileInterface");
        }

        public static i j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.IOpenFileInterface");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new a(iBinder);
            }
            return (i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            long j6;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.IOpenFileInterface");
                    j6 = j6();
                    parcel2.writeNoException();
                    parcel2.writeLong(j6);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.IOpenFileInterface");
                    j6 = DW();
                    parcel2.writeNoException();
                    parcel2.writeLong(j6);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.engine.service.IOpenFileInterface");
                    int FH = FH();
                    parcel2.writeNoException();
                    parcel2.writeInt(FH);
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.engine.service.IOpenFileInterface");
                    CharArray j62 = j6(parcel.readInt());
                    parcel2.writeNoException();
                    if (j62 != null) {
                        parcel2.writeInt(1);
                        j62.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.IOpenFileInterface");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    long DW();

    int FH();

    long j6();

    CharArray j6(int i);
}
