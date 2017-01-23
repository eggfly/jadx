package com.google.android.gms.common.api.p155a;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C3079e;
import com.google.android.gms.common.api.C3304d;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3441j;
import com.google.android.gms.common.api.C3442g;
import com.google.android.gms.common.api.C3448h;
import com.google.android.gms.common.api.C3449i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C3512u;
import java.lang.ref.WeakReference;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.common.api.a.s */
public class C3443s<R extends C3386f> extends C3441j<R> implements C3442g<R> {
    private C3449i<? super R, ? extends C3386f> f11964a;
    private C3443s<? extends C3386f> f11965b;
    private C3448h<? super R> f11966c;
    private C3304d<R> f11967d;
    private final Object f11968e;
    private Status f11969f;
    private final WeakReference<C3427c> f11970g;
    private final C3440a f11971h;

    /* renamed from: com.google.android.gms.common.api.a.s.1 */
    class C34391 implements Runnable {
        final /* synthetic */ C3386f f11961a;
        final /* synthetic */ C3443s f11962b;

        C34391(C3443s c3443s, C3386f c3386f) {
            this.f11962b = c3443s;
            this.f11961a = c3386f;
        }

        public void run() {
            C3427c c3427c;
            try {
                this.f11962b.f11971h.sendMessage(this.f11962b.f11971h.obtainMessage(0, this.f11962b.f11964a.m14257a(this.f11961a)));
                this.f11962b.m14230b(this.f11961a);
                c3427c = (C3427c) this.f11962b.f11970g.get();
                if (c3427c != null) {
                    c3427c.m14138b(this.f11962b);
                }
            } catch (RuntimeException e) {
                this.f11962b.f11971h.sendMessage(this.f11962b.f11971h.obtainMessage(1, e));
                this.f11962b.m14230b(this.f11961a);
                c3427c = (C3427c) this.f11962b.f11970g.get();
                if (c3427c != null) {
                    c3427c.m14138b(this.f11962b);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                this.f11962b.m14230b(this.f11961a);
                c3427c = (C3427c) this.f11962b.f11970g.get();
                if (c3427c != null) {
                    c3427c.m14138b(this.f11962b);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.s.a */
    private final class C3440a extends Handler {
        final /* synthetic */ C3443s f11963a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    C3304d c3304d = (C3304d) message.obj;
                    synchronized (this.f11963a.f11968e) {
                        if (c3304d != null) {
                            if (c3304d instanceof C3434p) {
                                this.f11963a.f11965b.m14224a(((C3434p) c3304d).m14199b());
                            } else {
                                this.f11963a.f11965b.m14236a(c3304d);
                            }
                            break;
                        }
                        this.f11963a.f11965b.m14224a(new Status(13, "Transform returned null"));
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + runtimeException.getMessage());
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
            }
        }
    }

    private void m14224a(Status status) {
        synchronized (this.f11968e) {
            this.f11969f = status;
            m14229b(this.f11969f);
        }
    }

    private void m14228b() {
        if (this.f11964a != null || this.f11966c != null) {
            C3427c c3427c = (C3427c) this.f11970g.get();
            if (!(this.f11964a == null || c3427c == null)) {
                c3427c.m14133a(this);
            }
            if (this.f11969f != null) {
                m14229b(this.f11969f);
            } else if (this.f11967d != null) {
                this.f11967d.m13437a((C3442g) this);
            }
        }
    }

    private void m14229b(Status status) {
        synchronized (this.f11968e) {
            if (this.f11964a != null) {
                Status a = this.f11964a.m14256a(status);
                C3512u.m14581a((Object) a, (Object) "onFailure must not return null");
                this.f11965b.m14224a(a);
            } else if (m14232c()) {
                this.f11966c.m14254a(status);
            }
        }
    }

    private void m14230b(C3386f c3386f) {
        if (c3386f instanceof C3079e) {
            try {
                ((C3079e) c3386f).m12076a();
            } catch (Throwable e) {
                Log.w("TransformedResultImpl", "Unable to release " + c3386f, e);
            }
        }
    }

    private boolean m14232c() {
        return (this.f11966c == null || ((C3427c) this.f11970g.get()) == null) ? false : true;
    }

    void m14235a() {
        synchronized (this.f11968e) {
            this.f11966c = null;
        }
    }

    public void m14236a(C3304d<?> c3304d) {
        synchronized (this.f11968e) {
            this.f11967d = c3304d;
            m14228b();
        }
    }

    public void m14237a(R r) {
        synchronized (this.f11968e) {
            if (!r.m13957a().m13963e()) {
                m14224a(r.m13957a());
                m14230b((C3386f) r);
            } else if (this.f11964a != null) {
                C3433o.m14195a().submit(new C34391(this, r));
            } else if (m14232c()) {
                this.f11966c.m14255b(r);
            }
        }
    }
}
