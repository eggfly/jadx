package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR;
    private final CharSequence DW;
    private final CharSequence FH;
    private final CharSequence Hw;
    private final Bundle VH;
    private final Uri Zo;
    private final Uri gn;
    private final String j6;
    private Object u7;
    private final Bitmap v5;

    static class 1 implements Creator<MediaDescriptionCompat> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public MediaDescriptionCompat j6(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(null);
            }
            return MediaDescriptionCompat.j6(a.j6(parcel));
        }

        public MediaDescriptionCompat[] j6(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public static final class a {
        private CharSequence DW;
        private CharSequence FH;
        private CharSequence Hw;
        private Bundle VH;
        private Uri Zo;
        private Uri gn;
        private String j6;
        private Bitmap v5;

        public a j6(String str) {
            this.j6 = str;
            return this;
        }

        public a j6(CharSequence charSequence) {
            this.DW = charSequence;
            return this;
        }

        public a DW(CharSequence charSequence) {
            this.FH = charSequence;
            return this;
        }

        public a FH(CharSequence charSequence) {
            this.Hw = charSequence;
            return this;
        }

        public a j6(Bitmap bitmap) {
            this.v5 = bitmap;
            return this;
        }

        public a j6(Uri uri) {
            this.Zo = uri;
            return this;
        }

        public a j6(Bundle bundle) {
            this.VH = bundle;
            return this;
        }

        public a DW(Uri uri) {
            this.gn = uri;
            return this;
        }

        public MediaDescriptionCompat j6() {
            return new MediaDescriptionCompat(this.DW, this.FH, this.Hw, this.v5, this.Zo, this.VH, this.gn, null);
        }
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.j6 = str;
        this.DW = charSequence;
        this.FH = charSequence2;
        this.Hw = charSequence3;
        this.v5 = bitmap;
        this.Zo = uri;
        this.VH = bundle;
        this.gn = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.j6 = parcel.readString();
        this.DW = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.FH = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Hw = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.v5 = (Bitmap) parcel.readParcelable(null);
        this.Zo = (Uri) parcel.readParcelable(null);
        this.VH = parcel.readBundle();
        this.gn = (Uri) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.j6);
            TextUtils.writeToParcel(this.DW, parcel, i);
            TextUtils.writeToParcel(this.FH, parcel, i);
            TextUtils.writeToParcel(this.Hw, parcel, i);
            parcel.writeParcelable(this.v5, i);
            parcel.writeParcelable(this.Zo, i);
            parcel.writeBundle(this.VH);
            return;
        }
        a.j6(j6(), parcel, i);
    }

    public String toString() {
        return this.DW + ", " + this.FH + ", " + this.Hw;
    }

    public Object j6() {
        if (this.u7 != null || VERSION.SDK_INT < 21) {
            return this.u7;
        }
        Object j6 = android.support.v4.media.a.a.j6();
        android.support.v4.media.a.a.j6(j6, this.j6);
        android.support.v4.media.a.a.j6(j6, this.DW);
        android.support.v4.media.a.a.DW(j6, this.FH);
        android.support.v4.media.a.a.FH(j6, this.Hw);
        android.support.v4.media.a.a.j6(j6, this.v5);
        android.support.v4.media.a.a.j6(j6, this.Zo);
        android.support.v4.media.a.a.j6(j6, this.VH);
        if (VERSION.SDK_INT >= 23) {
            a.DW(j6, this.gn);
        }
        this.u7 = android.support.v4.media.a.a.j6(j6);
        return this.u7;
    }

    public static MediaDescriptionCompat j6(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        a aVar = new a();
        aVar.j6(a.j6(obj));
        aVar.j6(a.DW(obj));
        aVar.DW(a.FH(obj));
        aVar.FH(a.Hw(obj));
        aVar.j6(a.v5(obj));
        aVar.j6(a.Zo(obj));
        aVar.j6(a.VH(obj));
        if (VERSION.SDK_INT >= 23) {
            aVar.DW(b.gn(obj));
        }
        MediaDescriptionCompat j6 = aVar.j6();
        j6.u7 = obj;
        return j6;
    }

    static {
        CREATOR = new 1();
    }
}
