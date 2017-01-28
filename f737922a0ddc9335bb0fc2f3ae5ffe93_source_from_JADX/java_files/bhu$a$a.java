import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import tv.ouya.console.api.Purchasable;

class bhu$a$a implements bhu {
    private IBinder j6;

    bhu$a$a(IBinder iBinder) {
        this.j6 = iBinder;
    }

    public IBinder asBinder() {
        return this.j6;
    }

    public void j6() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            this.j6.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void j6(String str, List<Purchasable> list, bhv bhv) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            obtain.writeString(str);
            obtain.writeTypedList(list);
            obtain.writeStrongBinder(bhv != null ? bhv.asBinder() : null);
            this.j6.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void j6(String str, Purchasable purchasable, bhw bhw) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            obtain.writeString(str);
            if (purchasable != null) {
                obtain.writeInt(1);
                purchasable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(bhw != null ? bhw.asBinder() : null);
            this.j6.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void j6(String str, bhw bhw) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            obtain.writeString(str);
            obtain.writeStrongBinder(bhw != null ? bhw.asBinder() : null);
            this.j6.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void DW(String str, bhw bhw) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            obtain.writeString(str);
            obtain.writeStrongBinder(bhw != null ? bhw.asBinder() : null);
            this.j6.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void j6(String str, int i, List<Purchasable> list, bhv bhv) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeTypedList(list);
            obtain.writeStrongBinder(bhv != null ? bhv.asBinder() : null);
            this.j6.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void FH(String str, bhw bhw) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("tv.ouya.console.internal.IIapServiceDefinition");
            obtain.writeString(str);
            obtain.writeStrongBinder(bhw != null ? bhw.asBinder() : null);
            this.j6.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
