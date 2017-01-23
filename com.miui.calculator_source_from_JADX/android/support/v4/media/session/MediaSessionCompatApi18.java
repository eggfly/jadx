package android.support.v4.media.session;

import android.support.v4.media.session.MediaSessionCompatApi14.Callback;

public class MediaSessionCompatApi18 {

    static class OnPlaybackPositionUpdateListener<T extends Callback> implements android.media.RemoteControlClient.OnPlaybackPositionUpdateListener {
        protected final T f592a;

        public void onPlaybackPositionUpdate(long j) {
            this.f592a.m886a(j);
        }
    }
}
