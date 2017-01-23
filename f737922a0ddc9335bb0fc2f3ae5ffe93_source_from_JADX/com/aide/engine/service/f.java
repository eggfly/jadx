package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.engine.SourceEntity;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        private static class a implements f {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IGotoSymbolListener");
                    obtain.writeString(str);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, List list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IGotoSymbolListener");
                    obtain.writeString(str);
                    obtain.writeList(list);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(SourceEntity sourceEntity) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IGotoSymbolListener");
                    if (sourceEntity != null) {
                        obtain.writeInt(1);
                        sourceEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.IGotoSymbolListener");
        }

        public static f j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.IGotoSymbolListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
                return new a(iBinder);
            }
            return (f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.IGotoSymbolListener");
                    j6(parcel.readString());
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.IGotoSymbolListener");
                    j6(parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    SourceEntity sourceEntity;
                    parcel.enforceInterface("com.aide.engine.service.IGotoSymbolListener");
                    if (parcel.readInt() != 0) {
                        sourceEntity = (SourceEntity) SourceEntity.CREATOR.createFromParcel(parcel);
                    } else {
                        sourceEntity = null;
                    }
                    j6(sourceEntity);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.IGotoSymbolListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6(SourceEntity sourceEntity);

    void j6(String str);

    void j6(String str, List list);
}
