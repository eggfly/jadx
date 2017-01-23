package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.fb.C2883a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.fc */
public interface fc extends IInterface {

    /* renamed from: com.google.android.gms.b.fc.a */
    public static abstract class C3090a extends Binder implements fc {

        /* renamed from: com.google.android.gms.b.fc.a.a */
        private static class C3194a implements fc {
            private IBinder f10904a;

            C3194a(IBinder iBinder) {
                this.f10904a = iBinder;
            }

            public void m12684a(fb fbVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    obtain.writeStrongBinder(fbVar != null ? fbVar.asBinder() : null);
                    this.f10904a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10904a;
            }
        }

        public C3090a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        public static fc m12113a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fc)) ? new C3194a(iBinder) : (fc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    m12112a(C2883a.m11218a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m12112a(fb fbVar);
}
