package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.PlaybackState;
import android.os.Bundle;

class MediaControllerCompatApi21 {

    public interface Callback {
        void m811a();

        void m812a(Object obj);

        void m813a(String str, Bundle bundle);

        void m814b(Object obj);
    }

    static class CallbackProxy<T extends Callback> extends android.media.session.MediaController.Callback {
        protected final T f559a;

        public CallbackProxy(T t) {
            this.f559a = t;
        }

        public void onSessionDestroyed() {
            this.f559a.m811a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f559a.m813a(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f559a.m812a(playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f559a.m814b(mediaMetadata);
        }
    }

    public static class PlaybackInfo {
    }

    public static class TransportControls {
    }

    MediaControllerCompatApi21() {
    }

    public static Object m837a(Callback callback) {
        return new CallbackProxy(callback);
    }
}
