package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR;
    private static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    private static final int METADATA_TYPE_BITMAP = 2;
    private static final int METADATA_TYPE_LONG = 0;
    private static final int METADATA_TYPE_RATING = 3;
    private static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    private final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    /* renamed from: android.support.v4.media.MediaMetadataCompat.1 */
    static class C02391 implements Creator<MediaMetadataCompat> {
        C02391() {
        }

        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(null);
        }

        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            this.mBundle = new Bundle(mediaMetadataCompat.mBundle);
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(null);
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == MediaMetadataCompat.METADATA_TYPE_BITMAP) {
                this.mBundle.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public Builder putLong(String str, long j) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == 0) {
                this.mBundle.putLong(str, j);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == MediaMetadataCompat.METADATA_TYPE_RATING) {
                if (VERSION.SDK_INT >= 21) {
                    this.mBundle.putParcelable(str, (Parcelable) ratingCompat.getRating());
                } else {
                    this.mBundle.putParcelable(str, ratingCompat);
                }
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public Builder putString(String str, String str2) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == MediaMetadataCompat.METADATA_TYPE_TEXT) {
                this.mBundle.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public Builder putText(String str, CharSequence charSequence) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == MediaMetadataCompat.METADATA_TYPE_TEXT) {
                this.mBundle.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextKey {
    }

    static {
        METADATA_KEYS_TYPE = new ArrayMap();
        METADATA_KEYS_TYPE.put(METADATA_KEY_TITLE, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ARTIST, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DURATION, Integer.valueOf(METADATA_TYPE_LONG));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_AUTHOR, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_WRITER, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPOSER, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPILATION, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DATE, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_YEAR, Integer.valueOf(METADATA_TYPE_LONG));
        METADATA_KEYS_TYPE.put(METADATA_KEY_GENRE, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_TRACK_NUMBER, Integer.valueOf(METADATA_TYPE_LONG));
        METADATA_KEYS_TYPE.put(METADATA_KEY_NUM_TRACKS, Integer.valueOf(METADATA_TYPE_LONG));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISC_NUMBER, Integer.valueOf(METADATA_TYPE_LONG));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ARTIST, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART, Integer.valueOf(METADATA_TYPE_BITMAP));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART_URI, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART, Integer.valueOf(METADATA_TYPE_BITMAP));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART_URI, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_USER_RATING, Integer.valueOf(METADATA_TYPE_RATING));
        METADATA_KEYS_TYPE.put(METADATA_KEY_RATING, Integer.valueOf(METADATA_TYPE_RATING));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_TITLE, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_SUBTITLE, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_DESCRIPTION, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON, Integer.valueOf(METADATA_TYPE_BITMAP));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON_URI, Integer.valueOf(METADATA_TYPE_TEXT));
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_ID, Integer.valueOf(METADATA_TYPE_TEXT));
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        String[] strArr = new String[METADATA_TYPE_RATING];
        strArr[METADATA_TYPE_LONG] = METADATA_KEY_DISPLAY_ICON;
        strArr[METADATA_TYPE_TEXT] = METADATA_KEY_ART;
        strArr[METADATA_TYPE_BITMAP] = METADATA_KEY_ALBUM_ART;
        PREFERRED_BITMAP_ORDER = strArr;
        strArr = new String[METADATA_TYPE_RATING];
        strArr[METADATA_TYPE_LONG] = METADATA_KEY_DISPLAY_ICON_URI;
        strArr[METADATA_TYPE_TEXT] = METADATA_KEY_ART_URI;
        strArr[METADATA_TYPE_BITMAP] = METADATA_KEY_ALBUM_ART_URI;
        PREFERRED_URI_ORDER = strArr;
        CREATOR = new C02391();
    }

    private MediaMetadataCompat(Bundle bundle) {
        this.mBundle = new Bundle(bundle);
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle();
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(obj, obtain, METADATA_TYPE_LONG);
        obtain.setDataPosition(METADATA_TYPE_LONG);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.mMetadataObj = obj;
        return mediaMetadataCompat;
    }

    public boolean containsKey(String str) {
        return this.mBundle.containsKey(str);
    }

    public int describeContents() {
        return METADATA_TYPE_LONG;
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.mBundle.getParcelable(str);
        } catch (Throwable e) {
            Log.w(TAG, "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public MediaDescriptionCompat getDescription() {
        Uri uri = null;
        if (this.mDescription != null) {
            return this.mDescription;
        }
        int i;
        Bitmap bitmap;
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[METADATA_TYPE_RATING];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(text)) {
            i = METADATA_TYPE_LONG;
            int i2 = METADATA_TYPE_LONG;
            while (i2 < charSequenceArr.length && i < PREFERRED_DESCRIPTION_ORDER.length) {
                int i3 = i + METADATA_TYPE_TEXT;
                CharSequence text2 = getText(PREFERRED_DESCRIPTION_ORDER[i]);
                if (TextUtils.isEmpty(text2)) {
                    i = i2;
                } else {
                    i = i2 + METADATA_TYPE_TEXT;
                    charSequenceArr[i2] = text2;
                }
                i2 = i;
                i = i3;
            }
        } else {
            charSequenceArr[METADATA_TYPE_LONG] = text;
            charSequenceArr[METADATA_TYPE_TEXT] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[METADATA_TYPE_BITMAP] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        }
        for (i = METADATA_TYPE_LONG; i < PREFERRED_BITMAP_ORDER.length; i += METADATA_TYPE_TEXT) {
            Bitmap bitmap2 = getBitmap(PREFERRED_BITMAP_ORDER[i]);
            if (bitmap2 != null) {
                bitmap = bitmap2;
                break;
            }
        }
        bitmap = null;
        for (i3 = METADATA_TYPE_LONG; i3 < PREFERRED_URI_ORDER.length; i3 += METADATA_TYPE_TEXT) {
            Object string2 = getString(PREFERRED_URI_ORDER[i3]);
            if (!TextUtils.isEmpty(string2)) {
                uri = Uri.parse(string2);
                break;
            }
        }
        android.support.v4.media.MediaDescriptionCompat.Builder builder = new android.support.v4.media.MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[METADATA_TYPE_LONG]);
        builder.setSubtitle(charSequenceArr[METADATA_TYPE_TEXT]);
        builder.setDescription(charSequenceArr[METADATA_TYPE_BITMAP]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri);
        this.mDescription = builder.build();
        return this.mDescription;
    }

    public long getLong(String str) {
        return this.mBundle.getLong(str, 0);
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null || VERSION.SDK_INT < 21) {
            return this.mMetadataObj;
        }
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, METADATA_TYPE_LONG);
        obtain.setDataPosition(METADATA_TYPE_LONG);
        this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(obtain);
        obtain.recycle();
        return this.mMetadataObj;
    }

    public RatingCompat getRating(String str) {
        try {
            return VERSION.SDK_INT >= 21 ? RatingCompat.fromRating(this.mBundle.getParcelable(str)) : (RatingCompat) this.mBundle.getParcelable(str);
        } catch (Throwable e) {
            Log.w(TAG, "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public String getString(String str) {
        CharSequence charSequence = this.mBundle.getCharSequence(str);
        return charSequence != null ? charSequence.toString() : null;
    }

    public CharSequence getText(String str) {
        return this.mBundle.getCharSequence(str);
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mBundle);
    }
}
