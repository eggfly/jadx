package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public interface INotificationSideChannel extends IInterface {

    public static abstract class Stub extends Binder implements INotificationSideChannel {

        private static class Proxy implements INotificationSideChannel {
            private IBinder f290a;

            Proxy(IBinder iBinder) {
                this.f290a = iBinder;
            }

            public IBinder asBinder() {
                return this.f290a;
            }

            public void m419a(String str, int i, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f290a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m418a(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.f290a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m417a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    this.f290a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.app.INotificationSideChannel");
        }

        public static INotificationSideChannel m420a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof INotificationSideChannel)) {
                return new Proxy(iBinder);
            }
            return (INotificationSideChannel) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    Notification notification;
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                    } else {
                        notification = null;
                    }
                    m416a(readString, readInt, readString2, notification);
                    return true;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    m415a(parcel.readString(), parcel.readInt(), parcel.readString());
                    return true;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    m414a(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m414a(String str);

    void m415a(String str, int i, String str2);

    void m416a(String str, int i, String str2, Notification notification);
}
