package com.google.android.gms.common.api.p155a;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.internal.C3512u;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.common.api.a.r */
public class C3438r extends Fragment implements OnCancelListener {
    protected C3425l f11954a;
    private boolean f11955b;
    private boolean f11956c;
    private int f11957d;
    private ConnectionResult f11958e;
    private final Handler f11959f;
    private final SparseArray<C3436a> f11960g;

    /* renamed from: com.google.android.gms.common.api.a.r.a */
    private class C3436a implements C2922c {
        public final int f11947a;
        public final C3427c f11948b;
        public final C2922c f11949c;
        final /* synthetic */ C3438r f11950d;

        public C3436a(C3438r c3438r, int i, C3427c c3427c, C2922c c2922c) {
            this.f11950d = c3438r;
            this.f11947a = i;
            this.f11948b = c3427c;
            this.f11949c = c2922c;
            c3427c.m14134a((C2922c) this);
        }

        public void m14201a() {
            this.f11948b.m14139b((C2922c) this);
            this.f11948b.m14140c();
        }

        public void m14202a(ConnectionResult connectionResult) {
            this.f11950d.f11959f.post(new C3437b(this.f11950d, this.f11947a, connectionResult));
        }

        public void m14203a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.f11947a);
            printWriter.println(":");
            this.f11948b.m14135a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.r.b */
    private class C3437b implements Runnable {
        final /* synthetic */ C3438r f11951a;
        private final int f11952b;
        private final ConnectionResult f11953c;

        public C3437b(C3438r c3438r, int i, ConnectionResult connectionResult) {
            this.f11951a = c3438r;
            this.f11952b = i;
            this.f11953c = connectionResult;
        }

        public void run() {
            if (this.f11951a.f11955b && !this.f11951a.f11956c) {
                this.f11951a.f11956c = true;
                this.f11951a.f11957d = this.f11952b;
                this.f11951a.f11958e = this.f11953c;
                if (this.f11953c.m13951a()) {
                    try {
                        this.f11953c.m13950a(this.f11951a.getActivity(), ((this.f11951a.getActivity().getSupportFragmentManager().getFragments().indexOf(this.f11951a) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        this.f11951a.m14216a();
                    }
                } else if (this.f11951a.m14220b().m14273a(this.f11953c.m13953c())) {
                    this.f11951a.m14218a(this.f11952b, this.f11953c);
                } else if (this.f11953c.m13953c() == 18) {
                    this.f11951a.m14221b(this.f11952b, this.f11953c);
                } else {
                    this.f11951a.m14215c(this.f11952b, this.f11953c);
                }
            }
        }
    }

    public C3438r() {
        this.f11957d = -1;
        this.f11959f = new Handler(Looper.getMainLooper());
        this.f11960g = new SparseArray();
    }

    public static C3438r m14206a(FragmentActivity fragmentActivity) {
        C3512u.m14587b("Must be called from main thread of process");
        try {
            C3438r c3438r = (C3438r) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            return (c3438r == null || c3438r.isRemoving()) ? null : c3438r;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    private static String m14207a(ConnectionResult connectionResult) {
        return connectionResult.m13955e() + " (" + connectionResult.m13953c() + ": " + C3465h.m14287a(connectionResult.m13953c()) + ')';
    }

    public static C3438r m14211b(FragmentActivity fragmentActivity) {
        C3438r a = C3438r.m14206a(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (a == null) {
            a = C3438r.m14214c();
            if (a == null) {
                Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                a = new C3438r();
            }
            supportFragmentManager.beginTransaction().add((Fragment) a, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.common.api.p155a.C3438r m14214c() {
        /*
        r1 = 0;
        r4 = 3;
        r0 = "com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0011, LinkageError -> 0x003b, SecurityException -> 0x003d }
    L_0x0008:
        if (r0 == 0) goto L_0x0033;
    L_0x000a:
        r0 = r0.newInstance();	 Catch:{ IllegalAccessException -> 0x0037, InstantiationException -> 0x0023, ExceptionInInitializerError -> 0x0039, RuntimeException -> 0x0035 }
        r0 = (com.google.android.gms.common.api.p155a.C3438r) r0;	 Catch:{ IllegalAccessException -> 0x0037, InstantiationException -> 0x0023, ExceptionInInitializerError -> 0x0039, RuntimeException -> 0x0035 }
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = move-exception;
    L_0x0012:
        r2 = "GmsSupportLifecycleFrag";
        r2 = android.util.Log.isLoggable(r2, r4);
        if (r2 == 0) goto L_0x0021;
    L_0x001a:
        r2 = "GmsSupportLifecycleFrag";
        r3 = "Unable to find SupportLifecycleFragmentImpl class";
        android.util.Log.d(r2, r3, r0);
    L_0x0021:
        r0 = r1;
        goto L_0x0008;
    L_0x0023:
        r0 = move-exception;
    L_0x0024:
        r2 = "GmsSupportLifecycleFrag";
        r2 = android.util.Log.isLoggable(r2, r4);
        if (r2 == 0) goto L_0x0033;
    L_0x002c:
        r2 = "GmsSupportLifecycleFrag";
        r3 = "Unable to instantiate SupportLifecycleFragmentImpl class";
        android.util.Log.d(r2, r3, r0);
    L_0x0033:
        r0 = r1;
        goto L_0x0010;
    L_0x0035:
        r0 = move-exception;
        goto L_0x0024;
    L_0x0037:
        r0 = move-exception;
        goto L_0x0024;
    L_0x0039:
        r0 = move-exception;
        goto L_0x0024;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0012;
    L_0x003d:
        r0 = move-exception;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.r.c():com.google.android.gms.common.api.a.r");
    }

    private void m14215c(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        C3436a c3436a = (C3436a) this.f11960g.get(i);
        if (c3436a != null) {
            m14217a(i);
            C2922c c2922c = c3436a.f11949c;
            if (c2922c != null) {
                c2922c.m11339a(connectionResult);
            }
        }
        m14216a();
    }

    protected void m14216a() {
        this.f11956c = false;
        this.f11957d = -1;
        this.f11958e = null;
        if (this.f11954a != null) {
            this.f11954a.m14126b();
            this.f11954a = null;
        }
        for (int i = 0; i < this.f11960g.size(); i++) {
            ((C3436a) this.f11960g.valueAt(i)).f11948b.m14137b();
        }
    }

    public void m14217a(int i) {
        C3436a c3436a = (C3436a) this.f11960g.get(i);
        this.f11960g.remove(i);
        if (c3436a != null) {
            c3436a.m14201a();
        }
    }

    protected void m14218a(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + C3438r.m14207a(connectionResult));
        m14215c(i, connectionResult);
    }

    public void m14219a(int i, C3427c c3427c, C2922c c2922c) {
        C3512u.m14581a((Object) c3427c, (Object) "GoogleApiClient instance cannot be null");
        C3512u.m14585a(this.f11960g.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.f11960g.put(i, new C3436a(this, i, c3427c, c2922c));
        if (this.f11955b && !this.f11956c) {
            c3427c.m14137b();
        }
    }

    protected C3457f m14220b() {
        return C3457f.m14269a();
    }

    protected void m14221b(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        m14215c(i, connectionResult);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.f11960g.size(); i++) {
            ((C3436a) this.f11960g.valueAt(i)).m14203a(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        switch(r5) {
            case 1: goto L_0x001b;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x002b;
    L_0x0008:
        r4.m14216a();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r4.m14220b();
        r3 = r4.getActivity();
        r2 = r2.m14271a(r3);
        if (r2 != 0) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r2 = -1;
        if (r6 == r2) goto L_0x0006;
    L_0x001e:
        if (r6 != 0) goto L_0x0005;
    L_0x0020:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r3 = 0;
        r0.<init>(r2, r3);
        r4.f11958e = r0;
        goto L_0x0005;
    L_0x002b:
        r0 = r4.f11957d;
        r1 = r4.f11958e;
        r4.m14215c(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.r.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        m14215c(this.f11957d, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11956c = bundle.getBoolean("resolving_error", false);
            this.f11957d = bundle.getInt("failed_client_id", -1);
            if (this.f11957d >= 0) {
                this.f11958e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f11956c);
        if (this.f11957d >= 0) {
            bundle.putInt("failed_client_id", this.f11957d);
            bundle.putInt("failed_status", this.f11958e.m13953c());
            bundle.putParcelable("failed_resolution", this.f11958e.m13954d());
        }
    }

    public void onStart() {
        super.onStart();
        this.f11955b = true;
        if (!this.f11956c) {
            for (int i = 0; i < this.f11960g.size(); i++) {
                ((C3436a) this.f11960g.valueAt(i)).f11948b.m14137b();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.f11955b = false;
        for (int i = 0; i < this.f11960g.size(); i++) {
            ((C3436a) this.f11960g.valueAt(i)).f11948b.m14140c();
        }
    }
}
