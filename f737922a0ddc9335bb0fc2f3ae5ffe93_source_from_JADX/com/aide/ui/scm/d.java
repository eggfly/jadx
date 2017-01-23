package com.aide.ui.scm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
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

            public void j6(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeInt(i);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeInt(i);
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void FH() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    this.j6.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeString(str);
                    this.j6.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void v5() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    this.j6.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Hw() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    this.j6.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String DW(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeString(str);
                    this.j6.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String FH(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeString(str);
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String Hw(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeString(str);
                    this.j6.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void v5(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitServiceListener");
                    obtain.writeString(str);
                    this.j6.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.ui.scm.IExternalGitServiceListener");
        }

        public static d j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.ui.scm.IExternalGitServiceListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String DW;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    j6(parcel.readInt());
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    j6(parcel.readString(), parcel.readInt());
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    DW(parcel.readInt());
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    FH();
                    return true;
                case 5:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    j6(parcel.readString());
                    return true;
                case 6:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    v5();
                    return true;
                case 7:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    Hw();
                    return true;
                case 8:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    DW = DW(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case 9:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    DW = FH(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case 10:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    DW = Hw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case 11:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitServiceListener");
                    v5(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.ui.scm.IExternalGitServiceListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String DW(String str);

    void DW(int i);

    String FH(String str);

    void FH();

    String Hw(String str);

    void Hw();

    void j6(int i);

    void j6(String str);

    void j6(String str, int i);

    void v5();

    void v5(String str);
}
