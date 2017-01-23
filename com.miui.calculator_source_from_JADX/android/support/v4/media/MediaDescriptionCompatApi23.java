package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {

    static class Builder extends android.support.v4.media.MediaDescriptionCompatApi21.Builder {
        Builder() {
        }

        public static void m653b(Object obj, Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    MediaDescriptionCompatApi23() {
    }

    public static Uri m654h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
