package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi23 {

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi21.Callback {
        void m868a(Uri uri, Bundle bundle);
    }

    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.a).m868a(uri, bundle);
        }
    }

    MediaSessionCompatApi23() {
    }

    public static Object m959a(Callback callback) {
        return new CallbackProxy(callback);
    }
}
