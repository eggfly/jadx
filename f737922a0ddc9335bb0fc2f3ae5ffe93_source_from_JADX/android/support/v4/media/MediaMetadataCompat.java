package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import l;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR;
    private static final String[] DW;
    private static final String[] FH;
    private static final String[] Hw;
    private static final l<String, Integer> j6;
    private final Bundle v5;

    static class 1 implements Creator<MediaMetadataCompat> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public MediaMetadataCompat j6(Parcel parcel) {
            return new MediaMetadataCompat(null);
        }

        public MediaMetadataCompat[] j6(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    static {
        j6 = new l();
        j6.put("android.media.metadata.TITLE", Integer.valueOf(1));
        j6.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        j6.put("android.media.metadata.DURATION", Integer.valueOf(0));
        j6.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        j6.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        j6.put("android.media.metadata.WRITER", Integer.valueOf(1));
        j6.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        j6.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        j6.put("android.media.metadata.DATE", Integer.valueOf(1));
        j6.put("android.media.metadata.YEAR", Integer.valueOf(0));
        j6.put("android.media.metadata.GENRE", Integer.valueOf(1));
        j6.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        j6.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        j6.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        j6.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        j6.put("android.media.metadata.ART", Integer.valueOf(2));
        j6.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        j6.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        j6.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        j6.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        j6.put("android.media.metadata.RATING", Integer.valueOf(3));
        j6.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        j6.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        j6.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        j6.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        j6.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        j6.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        DW = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        FH = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        Hw = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new 1();
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.v5 = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.v5);
    }
}
