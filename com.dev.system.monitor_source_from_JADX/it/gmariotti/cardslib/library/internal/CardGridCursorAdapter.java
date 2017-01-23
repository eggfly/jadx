package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCardCursorAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.HashMap;

public abstract class CardGridCursorAdapter extends BaseCardCursorAdapter {
    protected static String TAG;
    protected CardGridView mCardGridView;
    protected HashMap<String, Card> mInternalObjects;
    private boolean recycle;

    static {
        TAG = "CardGridCursorAdapter";
    }

    public CardGridCursorAdapter(Context context) {
        super(context, null, 0);
        this.recycle = false;
    }

    protected CardGridCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.recycle = false;
    }

    protected CardGridCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.recycle = false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            this.recycle = false;
        } else {
            this.recycle = true;
        }
        return super.getView(position, convertView, parent);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.mRowLayoutId, parent, false);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        Card mCard = getCardFromCursor(cursor);
        if (mCard != null) {
            CardView mCardView = (CardView) view.findViewById(C0173R.id.list_cardId);
            if (mCardView != null) {
                mCardView.setForceReplaceInnerLayout(Card.equalsInnerLayout(mCardView.getCard(), mCard));
                mCardView.setRecycle(this.recycle);
                boolean origianlSwipeable = mCard.isSwipeable();
                mCard.setSwipeable(false);
                mCardView.setCard(mCard);
                if (origianlSwipeable) {
                    Log.d(TAG, "Swipe action not enabled in this type of view");
                }
                if (mCard.getCardHeader() != null && mCard.getCardHeader().isButtonExpandVisible()) {
                    Log.d(TAG, "Expand action not enabled in this type of view");
                }
                setupSwipeableAnimation(mCard, mCardView);
            }
        }
    }

    protected void setupSwipeableAnimation(Card card, CardView cardView) {
        cardView.setOnTouchListener(null);
    }

    public CardGridView getCardGridView() {
        return this.mCardGridView;
    }

    public void setCardGridView(CardGridView cardGridView) {
        this.mCardGridView = cardGridView;
    }
}
