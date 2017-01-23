package it.gmariotti.cardslib.library.view.listener;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UndoCard implements Parcelable {
    public static final Creator<UndoCard> CREATOR;
    public String[] itemId;
    public int[] itemPosition;

    /* renamed from: it.gmariotti.cardslib.library.view.listener.UndoCard.1 */
    static class C02151 implements Creator<UndoCard> {
        C02151() {
        }

        public UndoCard createFromParcel(Parcel in) {
            return new UndoCard(in);
        }

        public UndoCard[] newArray(int size) {
            return new UndoCard[size];
        }
    }

    public UndoCard(int[] itemPosition, String[] itemId) {
        this.itemPosition = itemPosition;
        this.itemId = itemId;
    }

    protected UndoCard(Parcel in) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    static {
        CREATOR = new C02151();
    }
}
