package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

public class MediaDescriptionCompatApi21 {

    public static class Builder {
        public static Object m635a() {
            return new android.media.MediaDescription.Builder();
        }

        public static void m641a(Object obj, String str) {
            ((android.media.MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void m640a(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setTitle(charSequence);
        }

        public static void m642b(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void m643c(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void m637a(Object obj, Bitmap bitmap) {
            ((android.media.MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void m638a(Object obj, Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void m639a(Object obj, Bundle bundle) {
            ((android.media.MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static Object m636a(Object obj) {
            return ((android.media.MediaDescription.Builder) obj).build();
        }
    }

    public static String m645a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence m647b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m648c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m649d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m650e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m651f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m652g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void m646a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object m644a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
