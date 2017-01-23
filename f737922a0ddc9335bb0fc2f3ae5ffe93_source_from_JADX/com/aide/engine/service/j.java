package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import java.util.Map;

public interface j extends IInterface {

    public static abstract class a extends Binder implements j {

        private static class a implements j {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(String str, Map map) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IRefactoringListener");
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IRefactoringListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IRefactoringListener");
                    obtain.writeString(str);
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(List list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IRefactoringListener");
                    obtain.writeList(list);
                    this.j6.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, List list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.IRefactoringListener");
                    obtain.writeString(str);
                    obtain.writeList(list);
                    this.j6.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.IRefactoringListener");
        }

        public static j j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.IRefactoringListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j)) {
                return new a(iBinder);
            }
            return (j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.IRefactoringListener");
                    j6(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.engine.service.IRefactoringListener");
                    j6(parcel.readString(), parcel.readString());
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.engine.service.IRefactoringListener");
                    j6(parcel.readString());
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.engine.service.IRefactoringListener");
                    j6(parcel.readArrayList(getClass().getClassLoader()));
                    return true;
                case 5:
                    parcel.enforceInterface("com.aide.engine.service.IRefactoringListener");
                    j6(parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.IRefactoringListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6(String str);

    void j6(String str, String str2);

    void j6(String str, List list);

    void j6(String str, Map map);

    void j6(List list);
}
