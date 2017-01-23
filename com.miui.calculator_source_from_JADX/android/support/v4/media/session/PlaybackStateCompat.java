package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR;
    private final int f615a;
    private final long f616b;
    private final long f617c;
    private final float f618d;
    private final long f619e;
    private final CharSequence f620f;
    private final long f621g;
    private List<CustomAction> f622h;
    private final long f623i;
    private final Bundle f624j;
    private Object f625k;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat.1 */
    final class C00621 implements Creator<PlaybackStateCompat> {
        C00621() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m962a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m963a(i);
        }

        public PlaybackStateCompat m962a(Parcel parcel) {
            return new PlaybackStateCompat(null);
        }

        public PlaybackStateCompat[] m963a(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    public static final class Builder {
        private final List<CustomAction> f600a;
        private int f601b;
        private long f602c;
        private long f603d;
        private float f604e;
        private long f605f;
        private CharSequence f606g;
        private long f607h;
        private long f608i;
        private Bundle f609j;

        public Builder() {
            this.f600a = new ArrayList();
            this.f608i = -1;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.f600a = new ArrayList();
            this.f608i = -1;
            this.f601b = playbackStateCompat.f615a;
            this.f602c = playbackStateCompat.f616b;
            this.f604e = playbackStateCompat.f618d;
            this.f607h = playbackStateCompat.f621g;
            this.f603d = playbackStateCompat.f617c;
            this.f605f = playbackStateCompat.f619e;
            this.f606g = playbackStateCompat.f620f;
            if (playbackStateCompat.f622h != null) {
                this.f600a.addAll(playbackStateCompat.f622h);
            }
            this.f608i = playbackStateCompat.f623i;
            this.f609j = playbackStateCompat.f624j;
        }

        public Builder m964a(int i, long j, float f, long j2) {
            this.f601b = i;
            this.f602c = j;
            this.f607h = j2;
            this.f604e = f;
            return this;
        }

        public PlaybackStateCompat m965a() {
            return new PlaybackStateCompat(this.f602c, this.f603d, this.f604e, this.f605f, this.f606g, this.f607h, this.f600a, this.f608i, this.f609j, null);
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR;
        private final String f610a;
        private final CharSequence f611b;
        private final int f612c;
        private final Bundle f613d;
        private Object f614e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1 */
        final class C00631 implements Creator<CustomAction> {
            C00631() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m966a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m967a(i);
            }

            public CustomAction m966a(Parcel parcel) {
                return new CustomAction(null);
            }

            public CustomAction[] m967a(int i) {
                return new CustomAction[i];
            }
        }

        public static final class Builder {
        }

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f610a = str;
            this.f611b = charSequence;
            this.f612c = i;
            this.f613d = bundle;
        }

        private CustomAction(Parcel parcel) {
            this.f610a = parcel.readString();
            this.f611b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f612c = parcel.readInt();
            this.f613d = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f610a);
            TextUtils.writeToParcel(this.f611b, parcel, i);
            parcel.writeInt(this.f612c);
            parcel.writeBundle(this.f613d);
        }

        public int describeContents() {
            return 0;
        }

        public static CustomAction m968a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(CustomAction.m985a(obj), CustomAction.m986b(obj), CustomAction.m987c(obj), CustomAction.m988d(obj));
            customAction.f614e = obj;
            return customAction;
        }

        static {
            CREATOR = new C00631();
        }

        public String toString() {
            return "Action:mName='" + this.f611b + ", mIcon=" + this.f612c + ", mExtras=" + this.f613d;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f615a = i;
        this.f616b = j;
        this.f617c = j2;
        this.f618d = f;
        this.f619e = j3;
        this.f620f = charSequence;
        this.f621g = j4;
        this.f622h = new ArrayList(list);
        this.f623i = j5;
        this.f624j = bundle;
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.f615a = parcel.readInt();
        this.f616b = parcel.readLong();
        this.f618d = parcel.readFloat();
        this.f621g = parcel.readLong();
        this.f617c = parcel.readLong();
        this.f619e = parcel.readLong();
        this.f620f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f622h = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f623i = parcel.readLong();
        this.f624j = parcel.readBundle();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f615a);
        stringBuilder.append(", position=").append(this.f616b);
        stringBuilder.append(", buffered position=").append(this.f617c);
        stringBuilder.append(", speed=").append(this.f618d);
        stringBuilder.append(", updated=").append(this.f621g);
        stringBuilder.append(", actions=").append(this.f619e);
        stringBuilder.append(", error=").append(this.f620f);
        stringBuilder.append(", custom actions=").append(this.f622h);
        stringBuilder.append(", active item id=").append(this.f623i);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f615a);
        parcel.writeLong(this.f616b);
        parcel.writeFloat(this.f618d);
        parcel.writeLong(this.f621g);
        parcel.writeLong(this.f617c);
        parcel.writeLong(this.f619e);
        TextUtils.writeToParcel(this.f620f, parcel, i);
        parcel.writeTypedList(this.f622h);
        parcel.writeLong(this.f623i);
        parcel.writeBundle(this.f624j);
    }

    public int m980a() {
        return this.f615a;
    }

    public long m981b() {
        return this.f616b;
    }

    public float m982c() {
        return this.f618d;
    }

    public long m983d() {
        return this.f619e;
    }

    public long m984e() {
        return this.f621g;
    }

    public static PlaybackStateCompat m970a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = PlaybackStateCompatApi21.m996h(obj);
        List list = null;
        if (h != null) {
            list = new ArrayList(h.size());
            for (Object a : h) {
                list.add(CustomAction.m968a(a));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.m989a(obj), PlaybackStateCompatApi21.m990b(obj), PlaybackStateCompatApi21.m991c(obj), PlaybackStateCompatApi21.m992d(obj), PlaybackStateCompatApi21.m993e(obj), PlaybackStateCompatApi21.m994f(obj), PlaybackStateCompatApi21.m995g(obj), list, PlaybackStateCompatApi21.m997i(obj), VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.m998a(obj) : null);
        playbackStateCompat.f625k = obj;
        return playbackStateCompat;
    }

    static {
        CREATOR = new C00621();
    }
}
