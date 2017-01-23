package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR;
    private final int f508a;
    private final float f509b;
    private Object f510c;

    /* renamed from: android.support.v4.media.RatingCompat.1 */
    final class C00451 implements Creator<RatingCompat> {
        C00451() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m671a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m672a(i);
        }

        public RatingCompat m671a(Parcel parcel) {
            return new RatingCompat(parcel.readFloat(), null);
        }

        public RatingCompat[] m672a(int i) {
            return new RatingCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    private RatingCompat(int i, float f) {
        this.f508a = i;
        this.f509b = f;
    }

    public String toString() {
        return "Rating:style=" + this.f508a + " rating=" + (this.f509b < 0.0f ? "unrated" : String.valueOf(this.f509b));
    }

    public int describeContents() {
        return this.f508a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f508a);
        parcel.writeFloat(this.f509b);
    }

    static {
        CREATOR = new C00451();
    }

    public static RatingCompat m674a(int i) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat m677a(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat m678b(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat m675a(int i, float f) {
        float f2;
        switch (i) {
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                f2 = 3.0f;
                break;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                f2 = 4.0f;
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                f2 = 5.0f;
                break;
            default:
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f >= 0.0f && f <= r1) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat m673a(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat m676a(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && VERSION.SDK_INT >= 21) {
            int b = RatingCompatApi21.m680b(obj);
            if (RatingCompatApi21.m679a(obj)) {
                switch (b) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        ratingCompat = m677a(RatingCompatApi21.m681c(obj));
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        ratingCompat = m678b(RatingCompatApi21.m682d(obj));
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        ratingCompat = m675a(b, RatingCompatApi21.m683e(obj));
                        break;
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                        ratingCompat = m673a(RatingCompatApi21.m684f(obj));
                        break;
                    default:
                        break;
                }
            }
            ratingCompat = m674a(b);
            ratingCompat.f510c = obj;
        }
        return ratingCompat;
    }
}
