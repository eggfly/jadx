package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR;
        private final long DW;
        private final MediaDescriptionCompat j6;

        static class 1 implements Creator<QueueItem> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public QueueItem j6(Parcel parcel) {
                return new QueueItem(null);
            }

            public QueueItem[] j6(int i) {
                return new QueueItem[i];
            }
        }

        private QueueItem(Parcel parcel) {
            this.j6 = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.DW = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.j6.writeToParcel(parcel, i);
            parcel.writeLong(this.DW);
        }

        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new 1();
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.j6 + ", Id=" + this.DW + " }";
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR;
        private ResultReceiver j6;

        static class 1 implements Creator<ResultReceiverWrapper> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public ResultReceiverWrapper j6(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] j6(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.j6 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        static {
            CREATOR = new 1();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.j6.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR;
        private final Object j6;

        static class 1 implements Creator<Token> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public Token j6(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new Token(readParcelable);
            }

            public Token[] j6(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this.j6 = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.j6, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.j6);
            }
        }

        static {
            CREATOR = new 1();
        }
    }
}
