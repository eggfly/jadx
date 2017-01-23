package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        private static class a implements e {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineListener");
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineListener");
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.IEngineListener");
        }

        public static e j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.IEngineListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.IEngineListener");
                    j6();
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.IEngineListener");
                    DW();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.IEngineListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void DW();

    void j6();
}
