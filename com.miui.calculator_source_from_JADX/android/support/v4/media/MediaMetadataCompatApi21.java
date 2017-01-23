package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import java.util.Set;

class MediaMetadataCompatApi21 {

    public static class Builder {
    }

    MediaMetadataCompatApi21() {
    }

    public static Set<String> m667a(Object obj) {
        return ((MediaMetadata) obj).keySet();
    }

    public static Bitmap m666a(Object obj, String str) {
        return ((MediaMetadata) obj).getBitmap(str);
    }

    public static long m668b(Object obj, String str) {
        return ((MediaMetadata) obj).getLong(str);
    }

    public static Object m669c(Object obj, String str) {
        return ((MediaMetadata) obj).getRating(str);
    }

    public static CharSequence m670d(Object obj, String str) {
        return ((MediaMetadata) obj).getText(str);
    }
}
