package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR;
    private static final ArrayMap<String, Integer> f502a;
    private static final String[] f503b;
    private static final String[] f504c;
    private static final String[] f505d;
    private final Bundle f506e;
    private Object f507f;

    /* renamed from: android.support.v4.media.MediaMetadataCompat.1 */
    final class C00441 implements Creator<MediaMetadataCompat> {
        C00441() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m655a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m656a(i);
        }

        public MediaMetadataCompat m655a(Parcel parcel) {
            return new MediaMetadataCompat(null);
        }

        public MediaMetadataCompat[] m656a(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final Bundle f501a;

        public Builder() {
            this.f501a = new Bundle();
        }

        public Builder m660a(String str, CharSequence charSequence) {
            if (!MediaMetadataCompat.f502a.containsKey(str) || ((Integer) MediaMetadataCompat.f502a.get(str)).intValue() == 1) {
                this.f501a.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }

        public Builder m657a(String str, long j) {
            if (!MediaMetadataCompat.f502a.containsKey(str) || ((Integer) MediaMetadataCompat.f502a.get(str)).intValue() == 0) {
                this.f501a.putLong(str, j);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public Builder m659a(String str, RatingCompat ratingCompat) {
            if (!MediaMetadataCompat.f502a.containsKey(str) || ((Integer) MediaMetadataCompat.f502a.get(str)).intValue() == 3) {
                this.f501a.putParcelable(str, ratingCompat);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public Builder m658a(String str, Bitmap bitmap) {
            if (!MediaMetadataCompat.f502a.containsKey(str) || ((Integer) MediaMetadataCompat.f502a.get(str)).intValue() == 2) {
                this.f501a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public MediaMetadataCompat m661a() {
            return new MediaMetadataCompat(null);
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
        f502a = new ArrayMap();
        f502a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f502a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f502a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f502a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f502a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f502a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f502a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f502a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f502a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f502a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f502a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f502a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f502a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f502a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f502a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f502a.put("android.media.metadata.ART", Integer.valueOf(2));
        f502a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f502a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f502a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f502a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f502a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f502a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f502a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f502a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f502a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f502a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f502a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f503b = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        f504c = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        f505d = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new C00441();
    }

    private MediaMetadataCompat(Bundle bundle) {
        this.f506e = new Bundle(bundle);
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.f506e = parcel.readBundle();
    }

    public boolean m664a(String str) {
        return this.f506e.containsKey(str);
    }

    public long m665b(String str) {
        return this.f506e.getLong(str, 0);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f506e);
    }

    public static MediaMetadataCompat m662a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        for (String str : MediaMetadataCompatApi21.m667a(obj)) {
            Integer num = (Integer) f502a.get(str);
            if (num != null) {
                switch (num.intValue()) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                        builder.m657a(str, MediaMetadataCompatApi21.m668b(obj, str));
                        break;
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        builder.m660a(str, MediaMetadataCompatApi21.m670d(obj, str));
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        builder.m658a(str, MediaMetadataCompatApi21.m666a(obj, str));
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        builder.m659a(str, RatingCompat.m676a(MediaMetadataCompatApi21.m669c(obj, str)));
                        break;
                    default:
                        break;
                }
            }
        }
        MediaMetadataCompat a = builder.m661a();
        a.f507f = obj;
        return a;
    }
}
