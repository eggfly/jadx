package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

public class a {

    public static class a {
        public static Object j6() {
            return new Builder();
        }

        public static void j6(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void j6(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void DW(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void FH(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }

        public static void j6(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void j6(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void j6(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static Object j6(Object obj) {
            return ((Builder) obj).build();
        }
    }

    public static String j6(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence DW(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence FH(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence Hw(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap v5(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri Zo(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle VH(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void j6(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object j6(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
