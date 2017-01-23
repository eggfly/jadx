package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.engine.SourceEntity;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        private static class a implements c {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(String str, long j, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeCompletionListener");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeCompletionListener");
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeCompletionListener");
                    obtain.writeList(list);
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(String str, long j, int i, int i2, int i3, SourceEntity sourceEntity, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeCompletionListener");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (sourceEntity != null) {
                        obtain.writeInt(1);
                        sourceEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.ICodeCompletionListener");
        }

        public static c j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.ICodeCompletionListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeCompletionListener");
                    j6(parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeCompletionListener");
                    j6();
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeCompletionListener");
                    j6(parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    SourceEntity sourceEntity;
                    parcel.enforceInterface("com.aide.engine.service.ICodeCompletionListener");
                    String readString = parcel.readString();
                    long readLong = parcel.readLong();
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        sourceEntity = (SourceEntity) SourceEntity.CREATOR.createFromParcel(parcel);
                    } else {
                        sourceEntity = null;
                    }
                    j6(readString, readLong, readInt, readInt2, readInt3, sourceEntity, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.ICodeCompletionListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6();

    void j6(String str, long j, int i, int i2);

    void j6(String str, long j, int i, int i2, int i3, SourceEntity sourceEntity, String str2);

    void j6(List list);
}
