package com.xiaomi.xmsf.push.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

/* renamed from: com.xiaomi.xmsf.push.service.b */
public interface C0621b extends IInterface {

    /* renamed from: com.xiaomi.xmsf.push.service.b.a */
    public static abstract class C0623a extends Binder implements C0621b {

        /* renamed from: com.xiaomi.xmsf.push.service.b.a.a */
        private static class C0622a implements C0621b {
            private IBinder f4884a;

            C0622a(IBinder iBinder) {
                this.f4884a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4884a;
            }

            public void m6616a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.xmsf.push.service.IStatService");
                    obtain.writeString(str);
                    this.f4884a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0621b m6617a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.xmsf.push.service.IStatService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0621b)) {
                return new C0622a(iBinder);
            }
            return (C0621b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    parcel.enforceInterface("com.xiaomi.xmsf.push.service.IStatService");
                    m6615a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.xiaomi.xmsf.push.service.IStatService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m6615a(String str);
}
