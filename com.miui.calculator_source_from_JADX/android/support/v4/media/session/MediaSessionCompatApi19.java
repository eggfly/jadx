package android.support.v4.media.session;

import android.media.Rating;
import android.support.v4.media.session.MediaSessionCompatApi14.Callback;

public class MediaSessionCompatApi19 {

    static class OnMetadataUpdateListener<T extends Callback> implements android.media.RemoteControlClient.OnMetadataUpdateListener {
        protected final T f593a;

        public void onMetadataUpdate(int i, Object obj) {
            if (i == 268435457 && (obj instanceof Rating)) {
                this.f593a.m887a(obj);
            }
        }
    }
}
