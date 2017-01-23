package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.engine.SyntaxError;
import com.aide.uidesigner.ProxyTextView;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        private static class a implements d {
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
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineErrorListener");
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineErrorListener");
                    obtain.writeString(str);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineErrorListener");
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, SyntaxError[] syntaxErrorArr, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineErrorListener");
                    obtain.writeString(str);
                    obtain.writeTypedArray(syntaxErrorArr, 0);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.j6.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IEngineErrorListener");
                    obtain.writeString(str);
                    this.j6.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.IEngineErrorListener");
        }

        public static d j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.IEngineErrorListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.IEngineErrorListener");
                    j6();
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.IEngineErrorListener");
                    j6(parcel.readString());
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.engine.service.IEngineErrorListener");
                    DW();
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.engine.service.IEngineErrorListener");
                    j6(parcel.readString(), (SyntaxError[]) parcel.createTypedArray(SyntaxError.CREATOR), parcel.readInt() != 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.aide.engine.service.IEngineErrorListener");
                    DW(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.IEngineErrorListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void DW();

    void DW(String str);

    void j6();

    void j6(String str);

    void j6(String str, SyntaxError[] syntaxErrorArr, boolean z);
}
