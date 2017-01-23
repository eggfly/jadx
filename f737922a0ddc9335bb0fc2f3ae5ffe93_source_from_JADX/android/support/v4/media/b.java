package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;

class b extends a {

    static class a extends android.support.v4.media.a.a {
        public static void DW(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri gn(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
