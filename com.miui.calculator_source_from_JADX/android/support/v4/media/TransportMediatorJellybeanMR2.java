package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2 implements OnGetPlaybackPositionListener, OnPlaybackPositionUpdateListener {
    final Context f519a;
    final AudioManager f520b;
    final TransportMediatorCallback f521c;
    final IntentFilter f522d;
    final Intent f523e;
    final BroadcastReceiver f524f;
    OnAudioFocusChangeListener f525g;
    PendingIntent f526h;
    RemoteControlClient f527i;
    boolean f528j;
    int f529k;
    boolean f530l;

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.1 */
    class C00481 implements OnWindowAttachListener {
        final /* synthetic */ TransportMediatorJellybeanMR2 f515a;

        public void onWindowAttached() {
            this.f515a.m694a();
        }

        public void onWindowDetached() {
            this.f515a.m699f();
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.2 */
    class C00492 implements OnWindowFocusChangeListener {
        final /* synthetic */ TransportMediatorJellybeanMR2 f516a;

        public void onWindowFocusChanged(boolean z) {
            if (z) {
                this.f516a.m695b();
            } else {
                this.f516a.m698e();
            }
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.3 */
    class C00503 extends BroadcastReceiver {
        final /* synthetic */ TransportMediatorJellybeanMR2 f517a;

        public void onReceive(Context context, Intent intent) {
            try {
                this.f517a.f521c.m688a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (Throwable e) {
                Log.w("TransportController", e);
            }
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.4 */
    class C00514 implements OnAudioFocusChangeListener {
        final /* synthetic */ TransportMediatorJellybeanMR2 f518a;

        public void onAudioFocusChange(int i) {
            this.f518a.f521c.m686a(i);
        }
    }

    void m694a() {
        this.f519a.registerReceiver(this.f524f, this.f522d);
        this.f526h = PendingIntent.getBroadcast(this.f519a, 0, this.f523e, 268435456);
        this.f527i = new RemoteControlClient(this.f526h);
        this.f527i.setOnGetPlaybackPositionListener(this);
        this.f527i.setPlaybackPositionUpdateListener(this);
    }

    void m695b() {
        if (!this.f528j) {
            this.f528j = true;
            this.f520b.registerMediaButtonEventReceiver(this.f526h);
            this.f520b.registerRemoteControlClient(this.f527i);
            if (this.f529k == 3) {
                m696c();
            }
        }
    }

    void m696c() {
        if (!this.f530l) {
            this.f530l = true;
            this.f520b.requestAudioFocus(this.f525g, 3, 1);
        }
    }

    public long onGetPlaybackPosition() {
        return this.f521c.m685a();
    }

    public void onPlaybackPositionUpdate(long j) {
        this.f521c.m687a(j);
    }

    void m697d() {
        if (this.f530l) {
            this.f530l = false;
            this.f520b.abandonAudioFocus(this.f525g);
        }
    }

    void m698e() {
        m697d();
        if (this.f528j) {
            this.f528j = false;
            this.f520b.unregisterRemoteControlClient(this.f527i);
            this.f520b.unregisterMediaButtonEventReceiver(this.f526h);
        }
    }

    void m699f() {
        m698e();
        if (this.f526h != null) {
            this.f519a.unregisterReceiver(this.f524f);
            this.f526h.cancel();
            this.f526h = null;
            this.f527i = null;
        }
    }
}
