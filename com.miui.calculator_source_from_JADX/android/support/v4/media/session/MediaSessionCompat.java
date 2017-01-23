package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.IMediaSession.Stub;
import android.support.v4.media.session.PlaybackStateCompat.Builder;
import android.view.KeyEvent;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class MediaSessionCompat {

    public static abstract class Callback {
        final Object f562a;

        private class StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi21.Callback {
            final /* synthetic */ Callback f560a;

            private StubApi21(Callback callback) {
                this.f560a = callback;
            }

            public void m857a(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f560a.m875a(str, bundle, resultReceiver);
            }

            public boolean m858a(Intent intent) {
                return this.f560a.m876a(intent);
            }

            public void m853a() {
                this.f560a.m870a();
            }

            public void m856a(String str, Bundle bundle) {
                this.f560a.m874a(str, bundle);
            }

            public void m861b(String str, Bundle bundle) {
                this.f560a.m879b(str, bundle);
            }

            public void m854a(long j) {
                this.f560a.m871a(j);
            }

            public void m859b() {
                this.f560a.m877b();
            }

            public void m862c() {
                this.f560a.m880c();
            }

            public void m864d() {
                this.f560a.m882d();
            }

            public void m865e() {
                this.f560a.m883e();
            }

            public void m866f() {
                this.f560a.m884f();
            }

            public void m867g() {
                this.f560a.m885g();
            }

            public void m860b(long j) {
                this.f560a.m878b(j);
            }

            public void m855a(Object obj) {
                this.f560a.m873a(RatingCompat.m676a(obj));
            }

            public void m863c(String str, Bundle bundle) {
                this.f560a.m881c(str, bundle);
            }
        }

        private class StubApi23 extends StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback f561b;

            private StubApi23(Callback callback) {
                this.f561b = callback;
                super(null);
            }

            public void m869a(Uri uri, Bundle bundle) {
                this.f561b.m872a(uri, bundle);
            }
        }

        public Callback() {
            if (VERSION.SDK_INT >= 23) {
                this.f562a = MediaSessionCompatApi23.m959a(new StubApi23());
            } else if (VERSION.SDK_INT >= 21) {
                this.f562a = MediaSessionCompatApi21.m958a(new StubApi21());
            } else {
                this.f562a = null;
            }
        }

        public void m875a(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public boolean m876a(Intent intent) {
            return false;
        }

        public void m870a() {
        }

        public void m874a(String str, Bundle bundle) {
        }

        public void m879b(String str, Bundle bundle) {
        }

        public void m872a(Uri uri, Bundle bundle) {
        }

        public void m871a(long j) {
        }

        public void m877b() {
        }

        public void m880c() {
        }

        public void m882d() {
        }

        public void m883e() {
        }

        public void m884f() {
        }

        public void m885g() {
        }

        public void m878b(long j) {
        }

        public void m873a(RatingCompat ratingCompat) {
        }

        public void m881c(String str, Bundle bundle) {
        }
    }

    interface MediaSessionImpl {
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        private final MessageHandler f569a;
        private final String f570b;
        private final String f571c;
        private final AudioManager f572d;
        private final Object f573e;
        private final RemoteCallbackList<IMediaControllerCallback> f574f;
        private boolean f575g;
        private Callback f576h;
        private int f577i;
        private MediaMetadataCompat f578j;
        private PlaybackStateCompat f579k;
        private PendingIntent f580l;
        private List<QueueItem> f581m;
        private CharSequence f582n;
        private int f583o;
        private Bundle f584p;
        private int f585q;
        private int f586r;
        private VolumeProviderCompat f587s;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.1 */
        class C00561 extends android.support.v4.media.VolumeProviderCompat.Callback {
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.2 */
        class C00572 implements android.support.v4.media.session.MediaSessionCompatApi14.Callback {
            final /* synthetic */ Callback f563a;

            public void m889a(Object obj) {
                this.f563a.m873a(RatingCompat.m676a(obj));
            }

            public void m888a(long j) {
                this.f563a.m878b(j);
            }
        }

        private static final class Command {
            public final String f564a;
            public final Bundle f565b;
            public final ResultReceiver f566c;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f564a = str;
                this.f565b = bundle;
                this.f566c = resultReceiver;
            }
        }

        class MediaSessionStub extends Stub {
            final /* synthetic */ MediaSessionImplBase f567a;

            public void m896a(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                this.f567a.f569a.m924a(15, new Command(str, bundle, resultReceiverWrapper.f590a));
            }

            public boolean m898a(KeyEvent keyEvent) {
                boolean z = (this.f567a.f577i & 1) != 0;
                if (z) {
                    this.f567a.f569a.m924a(14, keyEvent);
                }
                return z;
            }

            public void m894a(IMediaControllerCallback iMediaControllerCallback) {
                if (this.f567a.f575g) {
                    try {
                        iMediaControllerCallback.m729a();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                this.f567a.f574f.register(iMediaControllerCallback);
            }

            public void m902b(IMediaControllerCallback iMediaControllerCallback) {
                this.f567a.f574f.unregister(iMediaControllerCallback);
            }

            public String m899b() {
                return this.f567a.f570b;
            }

            public String m904c() {
                return this.f567a.f571c;
            }

            public PendingIntent m906d() {
                PendingIntent k;
                synchronized (this.f567a.f573e) {
                    k = this.f567a.f580l;
                }
                return k;
            }

            public long m907e() {
                long e;
                synchronized (this.f567a.f573e) {
                    e = (long) this.f567a.f577i;
                }
                return e;
            }

            public ParcelableVolumeInfo m908f() {
                int b;
                int c;
                int c2;
                int a;
                int i = 2;
                synchronized (this.f567a.f573e) {
                    b = this.f567a.f585q;
                    c = this.f567a.f586r;
                    VolumeProviderCompat a2 = this.f567a.f587s;
                    if (b == 2) {
                        i = a2.m715b();
                        c2 = a2.m717c();
                        a = a2.m713a();
                    } else {
                        c2 = this.f567a.f572d.getStreamMaxVolume(c);
                        a = this.f567a.f572d.getStreamVolume(c);
                    }
                }
                return new ParcelableVolumeInfo(b, c, i, c2, a);
            }

            public void m890a(int i, int i2, String str) {
                this.f567a.m928a(i, i2);
            }

            public void m900b(int i, int i2, String str) {
                this.f567a.m931b(i, i2);
            }

            public void m909g() {
                this.f567a.f569a.m923a(1);
            }

            public void m895a(String str, Bundle bundle) {
                this.f567a.f569a.m925a(2, str, bundle);
            }

            public void m903b(String str, Bundle bundle) {
                this.f567a.f569a.m925a(3, str, bundle);
            }

            public void m892a(Uri uri, Bundle bundle) {
                this.f567a.f569a.m925a(18, uri, bundle);
            }

            public void m891a(long j) {
                this.f567a.f569a.m924a(4, Long.valueOf(j));
            }

            public void m910h() {
                this.f567a.f569a.m923a(5);
            }

            public void m911i() {
                this.f567a.f569a.m923a(6);
            }

            public void m912j() {
                this.f567a.f569a.m923a(7);
            }

            public void m913k() {
                this.f567a.f569a.m923a(8);
            }

            public void m914l() {
                this.f567a.f569a.m923a(9);
            }

            public void m915m() {
                this.f567a.f569a.m923a(10);
            }

            public void m901b(long j) {
                this.f567a.f569a.m924a(11, Long.valueOf(j));
            }

            public void m893a(RatingCompat ratingCompat) {
                this.f567a.f569a.m924a(12, ratingCompat);
            }

            public void m905c(String str, Bundle bundle) {
                this.f567a.f569a.m925a(13, str, bundle);
            }

            public MediaMetadataCompat m916n() {
                return this.f567a.f578j;
            }

            public PlaybackStateCompat m917o() {
                return this.f567a.m927a();
            }

            public List<QueueItem> m918p() {
                List<QueueItem> o;
                synchronized (this.f567a.f573e) {
                    o = this.f567a.f581m;
                }
                return o;
            }

            public CharSequence m919q() {
                return this.f567a.f582n;
            }

            public Bundle m920r() {
                Bundle q;
                synchronized (this.f567a.f573e) {
                    q = this.f567a.f584p;
                }
                return q;
            }

            public int m921s() {
                return this.f567a.f583o;
            }

            public boolean m897a() {
                return (this.f567a.f577i & 2) != 0;
            }
        }

        private class MessageHandler extends Handler {
            final /* synthetic */ MediaSessionImplBase f568a;

            public void m925a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }

            public void m924a(int i, Object obj) {
                obtainMessage(i, obj).sendToTarget();
            }

            public void m923a(int i) {
                m924a(i, null);
            }

            public void handleMessage(Message message) {
                if (this.f568a.f576h != null) {
                    switch (message.what) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            this.f568a.f576h.m870a();
                        case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                            this.f568a.f576h.m874a((String) message.obj, message.getData());
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            this.f568a.f576h.m879b((String) message.obj, message.getData());
                        case C0264R.styleable.Window_windowDisablePreview /*4*/:
                            this.f568a.f576h.m871a(((Long) message.obj).longValue());
                        case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                            this.f568a.f576h.m877b();
                        case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                            this.f568a.f576h.m885g();
                        case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                            this.f568a.f576h.m880c();
                        case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                            this.f568a.f576h.m882d();
                        case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                            this.f568a.f576h.m883e();
                        case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                            this.f568a.f576h.m884f();
                        case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                            this.f568a.f576h.m878b(((Long) message.obj).longValue());
                        case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                            this.f568a.f576h.m873a((RatingCompat) message.obj);
                        case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                            this.f568a.f576h.m881c((String) message.obj, message.getData());
                        case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!this.f568a.f576h.m876a(intent)) {
                                m922a(keyEvent);
                            }
                        case C0264R.styleable.Window_windowLayoutMode /*15*/:
                            Command command = (Command) message.obj;
                            this.f568a.f576h.m875a(command.f564a, command.f565b, command.f566c);
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            this.f568a.m928a(((Integer) message.obj).intValue(), 0);
                        case C0264R.styleable.Window_contentHeaderBackground /*17*/:
                            this.f568a.m931b(((Integer) message.obj).intValue(), 0);
                        case C0264R.styleable.Window_immersionMenuEnabled /*18*/:
                            this.f568a.f576h.m872a((Uri) message.obj, message.getData());
                        default:
                    }
                }
            }

            private void m922a(KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    long d = this.f568a.f579k == null ? 0 : this.f568a.f579k.m983d();
                    switch (keyEvent.getKeyCode()) {
                        case 79:
                        case 85:
                            Object obj;
                            if (this.f568a.f579k == null || this.f568a.f579k.m980a() != 3) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            Object obj2;
                            if ((516 & d) != 0) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            Object obj3;
                            if ((d & 514) != 0) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (obj != null && r0 != null) {
                                this.f568a.f576h.m877b();
                            } else if (obj == null && r6 != null) {
                                this.f568a.f576h.m870a();
                            }
                        case 86:
                            if ((d & 1) != 0) {
                                this.f568a.f576h.m885g();
                            }
                        case 87:
                            if ((d & 32) != 0) {
                                this.f568a.f576h.m880c();
                            }
                        case 88:
                            if ((d & 16) != 0) {
                                this.f568a.f576h.m882d();
                            }
                        case 89:
                            if ((d & 8) != 0) {
                                this.f568a.f576h.m884f();
                            }
                        case 90:
                            if ((d & 64) != 0) {
                                this.f568a.f576h.m883e();
                            }
                        case 126:
                            if ((d & 4) != 0) {
                                this.f568a.f576h.m870a();
                            }
                        case 127:
                            if ((d & 2) != 0) {
                                this.f568a.f576h.m877b();
                            }
                        default:
                    }
                }
            }
        }

        private void m928a(int i, int i2) {
            if (this.f585q != 2) {
                this.f572d.adjustStreamVolume(i, this.f586r, i2);
            } else if (this.f587s != null) {
                this.f587s.m716b(i);
            }
        }

        private void m931b(int i, int i2) {
            if (this.f585q != 2) {
                this.f572d.setStreamVolume(this.f586r, i, i2);
            } else if (this.f587s != null) {
                this.f587s.m714a(i);
            }
        }

        private PlaybackStateCompat m927a() {
            PlaybackStateCompat a;
            long j = -1;
            synchronized (this.f573e) {
                PlaybackStateCompat playbackStateCompat = this.f579k;
                if (this.f578j != null && this.f578j.m664a("android.media.metadata.DURATION")) {
                    j = this.f578j.m665b("android.media.metadata.DURATION");
                }
            }
            if (playbackStateCompat != null && (playbackStateCompat.m980a() == 3 || playbackStateCompat.m980a() == 4 || playbackStateCompat.m980a() == 5)) {
                long e = playbackStateCompat.m984e();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (e > 0) {
                    e = ((long) (playbackStateCompat.m982c() * ((float) (elapsedRealtime - e)))) + playbackStateCompat.m981b();
                    if (j < 0 || e <= j) {
                        if (e < 0) {
                            j = 0;
                        } else {
                            j = e;
                        }
                    }
                    Builder builder = new Builder(playbackStateCompat);
                    builder.m964a(playbackStateCompat.m980a(), j, playbackStateCompat.m982c(), elapsedRealtime);
                    a = builder.m965a();
                    return a != null ? playbackStateCompat : a;
                }
            }
            a = null;
            if (a != null) {
            }
        }
    }

    public interface OnActiveChangeListener {
    }

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR;
        private final MediaDescriptionCompat f588a;
        private final long f589b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.QueueItem.1 */
        final class C00581 implements Creator<QueueItem> {
            C00581() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m951a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m952a(i);
            }

            public QueueItem m951a(Parcel parcel) {
                return new QueueItem(null);
            }

            public QueueItem[] m952a(int i) {
                return new QueueItem[i];
            }
        }

        private QueueItem(Parcel parcel) {
            this.f588a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f589b = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f588a.writeToParcel(parcel, i);
            parcel.writeLong(this.f589b);
        }

        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new C00581();
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f588a + ", Id=" + this.f589b + " }";
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR;
        private ResultReceiver f590a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1 */
        final class C00591 implements Creator<ResultReceiverWrapper> {
            C00591() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m953a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m954a(i);
            }

            public ResultReceiverWrapper m953a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] m954a(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f590a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        static {
            CREATOR = new C00591();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f590a.writeToParcel(parcel, i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR;
        private final Object f591a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.Token.1 */
        final class C00601 implements Creator<Token> {
            C00601() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m956a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m957a(i);
            }

            public Token m956a(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new Token(readParcelable);
            }

            public Token[] m957a(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this.f591a = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f591a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f591a);
            }
        }

        static {
            CREATOR = new C00601();
        }
    }
}
