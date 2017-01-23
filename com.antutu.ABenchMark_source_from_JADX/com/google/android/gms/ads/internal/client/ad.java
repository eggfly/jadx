package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.ads.C2279R;
import com.google.android.gms.ads.internal.client.C2769y.C2770a;
import com.google.android.gms.ads.internal.client.C2772z.C2773a;
import com.google.android.gms.ads.internal.client.af.C2748a;
import com.google.android.gms.ads.internal.client.ag.C2750a;
import com.google.android.gms.ads.internal.reward.client.C2956c;
import com.google.android.gms.ads.internal.reward.client.C2956c.C2958a;
import com.google.android.gms.p146b.bd;
import com.google.android.gms.p146b.bd.C3041a;
import com.google.android.gms.p146b.fc;
import com.google.android.gms.p146b.fc.C3090a;
import com.google.android.gms.p146b.fg;
import com.google.android.gms.p146b.fg.C3200a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

public interface ad extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.ad.a */
    public static abstract class C2729a extends Binder implements ad {

        /* renamed from: com.google.android.gms.ads.internal.client.ad.a.a */
        private static class C2744a implements ad {
            private IBinder f9354a;

            C2744a(IBinder iBinder) {
                this.f9354a = iBinder;
            }

            public void m10530a(AdSizeParcel adSizeParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9354a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10531a(af afVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(afVar != null ? afVar.asBinder() : null);
                    this.f9354a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10532a(ag agVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(agVar != null ? agVar.asBinder() : null);
                    this.f9354a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10533a(C2769y c2769y) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(c2769y != null ? c2769y.asBinder() : null);
                    this.f9354a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10534a(C2772z c2772z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(c2772z != null ? c2772z.asBinder() : null);
                    this.f9354a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10535a(C2956c c2956c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(c2956c != null ? c2956c.asBinder() : null);
                    this.f9354a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10536a(bd bdVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(bdVar != null ? bdVar.asBinder() : null);
                    this.f9354a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10537a(fc fcVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(fcVar != null ? fcVar.asBinder() : null);
                    this.f9354a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10538a(fg fgVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(fgVar != null ? fgVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f9354a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10539a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeString(str);
                    this.f9354a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10540a(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f9354a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m10541a(AdRequestParcel adRequestParcel) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9354a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9354a;
            }

            public void m10542b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m10543c() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10544d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10545e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10546f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C2687a f_() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C2687a a = C2689a.m10261a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10547h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AdSizeParcel m10548i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    AdSizeParcel a = obtain2.readInt() != 0 ? AdSizeParcel.CREATOR.m10729a(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return a;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m10549j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j_() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m10550k() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f9354a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2729a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static ad m10415a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) ? new C2744a(iBinder) : (ad) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AdSizeParcel adSizeParcel = null;
            int i3 = 0;
            boolean c;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    C2687a f_ = f_();
                    parcel2.writeNoException();
                    if (f_ != null) {
                        asBinder = f_.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10406b();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    c = m10407c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c ? 1 : 0);
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    AdRequestParcel a;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        a = AdRequestParcel.CREATOR.m10724a(parcel);
                    }
                    c = m10405a(a);
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10408d();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10409e();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10398a(C2773a.m10706a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10395a(C2748a.m10558a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10410f();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j_();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10411h();
                    parcel2.writeNoException();
                    return true;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    adSizeParcel = m10412i();
                    parcel2.writeNoException();
                    if (adSizeParcel != null) {
                        parcel2.writeInt(1);
                        adSizeParcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.m10729a(parcel);
                    }
                    m10394a(adSizeParcel);
                    parcel2.writeNoException();
                    return true;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10401a(C3090a.m12113a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10402a(C3200a.m12700a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    String j = m10413j();
                    parcel2.writeNoException();
                    parcel2.writeString(j);
                    return true;
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10400a(C3041a.m11879a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10397a(C2770a.m10699a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10396a(C2750a.m10561a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C4209a.f14215r /*22*/:
                    boolean z;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m10404a(z);
                    parcel2.writeNoException();
                    return true;
                case C2279R.styleable.Toolbar_titleTextColor /*23*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    c = m10414k();
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case C4209a.f14216s /*24*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10399a(C2958a.m11471a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C2279R.styleable.ActionBar_popupTheme /*25*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    m10403a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m10394a(AdSizeParcel adSizeParcel);

    void m10395a(af afVar);

    void m10396a(ag agVar);

    void m10397a(C2769y c2769y);

    void m10398a(C2772z c2772z);

    void m10399a(C2956c c2956c);

    void m10400a(bd bdVar);

    void m10401a(fc fcVar);

    void m10402a(fg fgVar, String str);

    void m10403a(String str);

    void m10404a(boolean z);

    boolean m10405a(AdRequestParcel adRequestParcel);

    void m10406b();

    boolean m10407c();

    void m10408d();

    void m10409e();

    void m10410f();

    C2687a f_();

    void m10411h();

    AdSizeParcel m10412i();

    String m10413j();

    void j_();

    boolean m10414k();
}
