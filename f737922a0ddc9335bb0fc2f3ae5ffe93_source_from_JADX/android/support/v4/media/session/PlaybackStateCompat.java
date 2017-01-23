package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR;
    private final long DW;
    private final long FH;
    private final float Hw;
    private final long VH;
    private final CharSequence Zo;
    private List<CustomAction> gn;
    private final int j6;
    private final Bundle tp;
    private final long u7;
    private final long v5;

    static class 1 implements Creator<PlaybackStateCompat> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public PlaybackStateCompat j6(Parcel parcel) {
            return new PlaybackStateCompat(null);
        }

        public PlaybackStateCompat[] j6(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR;
        private final CharSequence DW;
        private final int FH;
        private final Bundle Hw;
        private final String j6;

        static class 1 implements Creator<CustomAction> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public CustomAction j6(Parcel parcel) {
                return new CustomAction(null);
            }

            public CustomAction[] j6(int i) {
                return new CustomAction[i];
            }
        }

        private CustomAction(Parcel parcel) {
            this.j6 = parcel.readString();
            this.DW = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.FH = parcel.readInt();
            this.Hw = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.j6);
            TextUtils.writeToParcel(this.DW, parcel, i);
            parcel.writeInt(this.FH);
            parcel.writeBundle(this.Hw);
        }

        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new 1();
        }

        public String toString() {
            return "Action:mName='" + this.DW + ", mIcon=" + this.FH + ", mExtras=" + this.Hw;
        }
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.j6 = parcel.readInt();
        this.DW = parcel.readLong();
        this.Hw = parcel.readFloat();
        this.VH = parcel.readLong();
        this.FH = parcel.readLong();
        this.v5 = parcel.readLong();
        this.Zo = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.gn = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.u7 = parcel.readLong();
        this.tp = parcel.readBundle();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.j6);
        stringBuilder.append(", position=").append(this.DW);
        stringBuilder.append(", buffered position=").append(this.FH);
        stringBuilder.append(", speed=").append(this.Hw);
        stringBuilder.append(", updated=").append(this.VH);
        stringBuilder.append(", actions=").append(this.v5);
        stringBuilder.append(", error=").append(this.Zo);
        stringBuilder.append(", custom actions=").append(this.gn);
        stringBuilder.append(", active item id=").append(this.u7);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j6);
        parcel.writeLong(this.DW);
        parcel.writeFloat(this.Hw);
        parcel.writeLong(this.VH);
        parcel.writeLong(this.FH);
        parcel.writeLong(this.v5);
        TextUtils.writeToParcel(this.Zo, parcel, i);
        parcel.writeTypedList(this.gn);
        parcel.writeLong(this.u7);
        parcel.writeBundle(this.tp);
    }

    static {
        CREATOR = new 1();
    }
}
