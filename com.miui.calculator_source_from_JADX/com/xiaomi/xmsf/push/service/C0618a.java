package com.xiaomi.xmsf.push.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Map;

/* renamed from: com.xiaomi.xmsf.push.service.a */
public interface C0618a extends IInterface {

    /* renamed from: com.xiaomi.xmsf.push.service.a.a */
    public static abstract class C0620a extends Binder implements C0618a {

        /* renamed from: com.xiaomi.xmsf.push.service.a.a.a */
        private static class C0619a implements C0618a {
            private IBinder f4883a;

            C0619a(IBinder iBinder) {
                this.f4883a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4883a;
            }

            public String m6613a(String str, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.xmsf.push.service.IHttpService");
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.f4883a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0618a m6614a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.xmsf.push.service.IHttpService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0618a)) {
                return new C0619a(iBinder);
            }
            return (C0618a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    parcel.enforceInterface("com.xiaomi.xmsf.push.service.IHttpService");
                    String a = m6612a(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.xiaomi.xmsf.push.service.IHttpService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String m6612a(String str, Map map);
}
