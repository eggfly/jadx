package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback.Stub;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.List;

public final class MediaControllerCompat {

    public static abstract class Callback implements DeathRecipient {
        private final Object f551a;
        private MessageHandler f552b;
        private boolean f553c;

        private class MessageHandler extends Handler {
            final /* synthetic */ Callback f548a;

            public void handleMessage(Message message) {
                if (this.f548a.f553c) {
                    switch (message.what) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            this.f548a.m835a((String) message.obj, message.getData());
                        case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                            this.f548a.m833a((PlaybackStateCompat) message.obj);
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            this.f548a.m831a((MediaMetadataCompat) message.obj);
                        case C0264R.styleable.Window_windowDisablePreview /*4*/:
                            this.f548a.m832a((PlaybackInfo) message.obj);
                        case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                            this.f548a.m836a((List) message.obj);
                        case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                            this.f548a.m834a((CharSequence) message.obj);
                        case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                            this.f548a.m830a((Bundle) message.obj);
                        case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                            this.f548a.m829a();
                        default:
                    }
                }
            }

            public void m810a(int i, Object obj, Bundle bundle) {
                obtainMessage(i, obj).sendToTarget();
            }
        }

        private class StubApi21 implements android.support.v4.media.session.MediaControllerCompatApi21.Callback {
            final /* synthetic */ Callback f549a;

            private StubApi21(Callback callback) {
                this.f549a = callback;
            }

            public void m815a() {
                this.f549a.m829a();
            }

            public void m817a(String str, Bundle bundle) {
                this.f549a.m835a(str, bundle);
            }

            public void m816a(Object obj) {
                this.f549a.m833a(PlaybackStateCompat.m970a(obj));
            }

            public void m818b(Object obj) {
                this.f549a.m831a(MediaMetadataCompat.m662a(obj));
            }
        }

        private class StubCompat extends Stub {
            final /* synthetic */ Callback f550a;

            private StubCompat(Callback callback) {
                this.f550a = callback;
            }

            public void m825a(String str, Bundle bundle) {
                this.f550a.f552b.m810a(1, str, bundle);
            }

            public void m819a() {
                this.f550a.f552b.m810a(8, null, null);
            }

            public void m823a(PlaybackStateCompat playbackStateCompat) {
                this.f550a.f552b.m810a(2, playbackStateCompat, null);
            }

            public void m821a(MediaMetadataCompat mediaMetadataCompat) {
                this.f550a.f552b.m810a(3, mediaMetadataCompat, null);
            }

            public void m826a(List<QueueItem> list) {
                this.f550a.f552b.m810a(5, list, null);
            }

            public void m824a(CharSequence charSequence) {
                this.f550a.f552b.m810a(6, charSequence, null);
            }

            public void m820a(Bundle bundle) {
                this.f550a.f552b.m810a(7, bundle, null);
            }

            public void m822a(ParcelableVolumeInfo parcelableVolumeInfo) {
                Object playbackInfo;
                if (parcelableVolumeInfo != null) {
                    playbackInfo = new PlaybackInfo(parcelableVolumeInfo.f595a, parcelableVolumeInfo.f596b, parcelableVolumeInfo.f597c, parcelableVolumeInfo.f598d, parcelableVolumeInfo.f599e);
                } else {
                    playbackInfo = null;
                }
                this.f550a.f552b.m810a(4, playbackInfo, null);
            }
        }

        public Callback() {
            this.f553c = false;
            if (VERSION.SDK_INT >= 21) {
                this.f551a = MediaControllerCompatApi21.m837a(new StubApi21());
            } else {
                this.f551a = new StubCompat();
            }
        }

        public void m829a() {
        }

        public void m835a(String str, Bundle bundle) {
        }

        public void m833a(PlaybackStateCompat playbackStateCompat) {
        }

        public void m831a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void m836a(List<QueueItem> list) {
        }

        public void m834a(CharSequence charSequence) {
        }

        public void m830a(Bundle bundle) {
        }

        public void m832a(PlaybackInfo playbackInfo) {
        }
    }

    interface MediaControllerImpl {
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {
    }

    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
    }

    static class MediaControllerImplBase implements MediaControllerImpl {
    }

    public static final class PlaybackInfo {
        private final int f554a;
        private final int f555b;
        private final int f556c;
        private final int f557d;
        private final int f558e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f554a = i;
            this.f555b = i2;
            this.f556c = i3;
            this.f557d = i4;
            this.f558e = i5;
        }
    }

    public static abstract class TransportControls {
        TransportControls() {
        }
    }

    static class TransportControlsApi21 extends TransportControls {
    }

    static class TransportControlsApi23 extends TransportControlsApi21 {
    }

    static class TransportControlsBase extends TransportControls {
    }
}
