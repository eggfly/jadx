package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.engine.FileHighlightings;
import com.aide.uidesigner.ProxyTextView;

public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        private static class a implements g {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(FileHighlightings fileHighlightings) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IHighlightingListener");
                    if (fileHighlightings != null) {
                        obtain.writeInt(1);
                        fileHighlightings.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(FileHighlightings fileHighlightings) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IHighlightingListener");
                    if (fileHighlightings != null) {
                        obtain.writeInt(1);
                        fileHighlightings.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.IHighlightingListener");
        }

        public static g j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.IHighlightingListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                return new a(iBinder);
            }
            return (g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            FileHighlightings fileHighlightings = null;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.IHighlightingListener");
                    if (parcel.readInt() != 0) {
                        fileHighlightings = (FileHighlightings) FileHighlightings.CREATOR.createFromParcel(parcel);
                    }
                    j6(fileHighlightings);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.IHighlightingListener");
                    if (parcel.readInt() != 0) {
                        fileHighlightings = (FileHighlightings) FileHighlightings.CREATOR.createFromParcel(parcel);
                    }
                    DW(fileHighlightings);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.IHighlightingListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void DW(FileHighlightings fileHighlightings);

    void j6(FileHighlightings fileHighlightings);
}
