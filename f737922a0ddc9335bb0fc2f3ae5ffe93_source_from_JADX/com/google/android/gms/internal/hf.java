package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.b;
import java.lang.ref.WeakReference;

public class hf<R extends e> extends i<R> implements f<R> {
    private hf<? extends e> DW;
    private volatile g<? super R> FH;
    private c<R> Hw;
    private final WeakReference<GoogleApiClient> VH;
    private Status Zo;
    private final a gn;
    private h<? super R, ? extends e> j6;
    private boolean u7;
    private final Object v5;

    class 1 implements Runnable {
        final /* synthetic */ hf DW;
        final /* synthetic */ e j6;

        1(hf hfVar, e eVar) {
            this.DW = hfVar;
            this.j6 = eVar;
        }

        public void run() {
            GoogleApiClient googleApiClient;
            try {
                gs.j6.set(Boolean.valueOf(true));
                this.DW.gn.sendMessage(this.DW.gn.obtainMessage(0, this.DW.j6.j6(this.j6)));
                gs.j6.set(Boolean.valueOf(false));
                this.DW.DW(this.j6);
                googleApiClient = (GoogleApiClient) this.DW.VH.get();
                if (googleApiClient != null) {
                    googleApiClient.DW(this.DW);
                }
            } catch (RuntimeException e) {
                this.DW.gn.sendMessage(this.DW.gn.obtainMessage(1, e));
                gs.j6.set(Boolean.valueOf(false));
                this.DW.DW(this.j6);
                googleApiClient = (GoogleApiClient) this.DW.VH.get();
                if (googleApiClient != null) {
                    googleApiClient.DW(this.DW);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                gs.j6.set(Boolean.valueOf(false));
                this.DW.DW(this.j6);
                googleApiClient = (GoogleApiClient) this.DW.VH.get();
                if (googleApiClient != null) {
                    googleApiClient.DW(this.DW);
                }
            }
        }
    }

    private final class a extends Handler {
        final /* synthetic */ hf j6;

        public void handleMessage(Message message) {
            switch (message.what) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    c cVar = (c) message.obj;
                    synchronized (this.j6.v5) {
                        if (cVar != null) {
                            if (cVar instanceof hd) {
                                this.j6.DW.j6(((hd) cVar).DW());
                            } else {
                                this.j6.DW.j6(cVar);
                            }
                            break;
                        }
                        this.j6.DW.j6(new Status(13, "Transform returned null"));
                        break;
                    }
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
            }
        }
    }

    private void DW(Status status) {
        synchronized (this.v5) {
            if (this.j6 != null) {
                Status j6 = this.j6.j6(status);
                b.j6((Object) j6, (Object) "onFailure must not return null");
                this.DW.j6(j6);
            } else if (DW()) {
                this.FH.j6(status);
            }
        }
    }

    private void DW(e eVar) {
        if (eVar instanceof d) {
            try {
                ((d) eVar).j6();
            } catch (Throwable e) {
                String valueOf = String.valueOf(eVar);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean DW() {
        return (this.FH == null || ((GoogleApiClient) this.VH.get()) == null) ? false : true;
    }

    private void j6() {
        if (this.j6 != null || this.FH != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.VH.get();
            if (!(this.u7 || this.j6 == null || googleApiClient == null)) {
                googleApiClient.j6(this);
                this.u7 = true;
            }
            if (this.Zo != null) {
                DW(this.Zo);
            } else if (this.Hw != null) {
                this.Hw.j6(this);
            }
        }
    }

    private void j6(Status status) {
        synchronized (this.v5) {
            this.Zo = status;
            DW(this.Zo);
        }
    }

    public void j6(c<?> cVar) {
        synchronized (this.v5) {
            this.Hw = cVar;
            j6();
        }
    }

    public void j6(R r) {
        synchronized (this.v5) {
            if (!r.DW().v5()) {
                j6(r.DW());
                DW((e) r);
            } else if (this.j6 != null) {
                hc.j6().submit(new 1(this, r));
            } else if (DW()) {
                this.FH.DW(r);
            }
        }
    }
}
