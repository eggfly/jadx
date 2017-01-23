package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR;
    private final String f492a;
    private final CharSequence f493b;
    private final CharSequence f494c;
    private final CharSequence f495d;
    private final Bitmap f496e;
    private final Uri f497f;
    private final Bundle f498g;
    private final Uri f499h;
    private Object f500i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat.1 */
    final class C00431 implements Creator<MediaDescriptionCompat> {
        C00431() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m622a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m623a(i);
        }

        public MediaDescriptionCompat m622a(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(null);
            }
            return MediaDescriptionCompat.m633a(MediaDescriptionCompatApi21.m644a(parcel));
        }

        public MediaDescriptionCompat[] m623a(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public static final class Builder {
        private String f484a;
        private CharSequence f485b;
        private CharSequence f486c;
        private CharSequence f487d;
        private Bitmap f488e;
        private Uri f489f;
        private Bundle f490g;
        private Uri f491h;

        public Builder m628a(@Nullable String str) {
            this.f484a = str;
            return this;
        }

        public Builder m627a(@Nullable CharSequence charSequence) {
            this.f485b = charSequence;
            return this;
        }

        public Builder m631b(@Nullable CharSequence charSequence) {
            this.f486c = charSequence;
            return this;
        }

        public Builder m632c(@Nullable CharSequence charSequence) {
            this.f487d = charSequence;
            return this;
        }

        public Builder m624a(@Nullable Bitmap bitmap) {
            this.f488e = bitmap;
            return this;
        }

        public Builder m625a(@Nullable Uri uri) {
            this.f489f = uri;
            return this;
        }

        public Builder m626a(@Nullable Bundle bundle) {
            this.f490g = bundle;
            return this;
        }

        public Builder m630b(@Nullable Uri uri) {
            this.f491h = uri;
            return this;
        }

        public MediaDescriptionCompat m629a() {
            return new MediaDescriptionCompat(this.f485b, this.f486c, this.f487d, this.f488e, this.f489f, this.f490g, this.f491h, null);
        }
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f492a = str;
        this.f493b = charSequence;
        this.f494c = charSequence2;
        this.f495d = charSequence3;
        this.f496e = bitmap;
        this.f497f = uri;
        this.f498g = bundle;
        this.f499h = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.f492a = parcel.readString();
        this.f493b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f494c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f495d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f496e = (Bitmap) parcel.readParcelable(null);
        this.f497f = (Uri) parcel.readParcelable(null);
        this.f498g = parcel.readBundle();
        this.f499h = (Uri) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f492a);
            TextUtils.writeToParcel(this.f493b, parcel, i);
            TextUtils.writeToParcel(this.f494c, parcel, i);
            TextUtils.writeToParcel(this.f495d, parcel, i);
            parcel.writeParcelable(this.f496e, i);
            parcel.writeParcelable(this.f497f, i);
            parcel.writeBundle(this.f498g);
            return;
        }
        MediaDescriptionCompatApi21.m646a(m634a(), parcel, i);
    }

    public String toString() {
        return this.f493b + ", " + this.f494c + ", " + this.f495d;
    }

    public Object m634a() {
        if (this.f500i != null || VERSION.SDK_INT < 21) {
            return this.f500i;
        }
        Object a = android.support.v4.media.MediaDescriptionCompatApi21.Builder.m635a();
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m641a(a, this.f492a);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m640a(a, this.f493b);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m642b(a, this.f494c);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m643c(a, this.f495d);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m637a(a, this.f496e);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m638a(a, this.f497f);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.m639a(a, this.f498g);
        if (VERSION.SDK_INT >= 23) {
            Builder.m653b(a, this.f499h);
        }
        this.f500i = android.support.v4.media.MediaDescriptionCompatApi21.Builder.m636a(a);
        return this.f500i;
    }

    public static MediaDescriptionCompat m633a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        builder.m628a(MediaDescriptionCompatApi21.m645a(obj));
        builder.m627a(MediaDescriptionCompatApi21.m647b(obj));
        builder.m631b(MediaDescriptionCompatApi21.m648c(obj));
        builder.m632c(MediaDescriptionCompatApi21.m649d(obj));
        builder.m624a(MediaDescriptionCompatApi21.m650e(obj));
        builder.m625a(MediaDescriptionCompatApi21.m651f(obj));
        builder.m626a(MediaDescriptionCompatApi21.m652g(obj));
        if (VERSION.SDK_INT >= 23) {
            builder.m630b(MediaDescriptionCompatApi23.m654h(obj));
        }
        MediaDescriptionCompat a = builder.m629a();
        a.f500i = obj;
        return a;
    }

    static {
        CREATOR = new C00431();
    }
}
