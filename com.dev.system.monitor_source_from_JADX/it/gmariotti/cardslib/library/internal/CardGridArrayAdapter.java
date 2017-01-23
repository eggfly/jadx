package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardView;
import it.gmariotti.cardslib.library.view.listener.SwipeDismissListViewTouchListener;
import java.util.List;

public class CardGridArrayAdapter extends BaseCardArrayAdapter {
    protected static String TAG;
    protected CardGridView mCardGridView;
    protected SwipeDismissListViewTouchListener mOnTouchListener;

    static {
        TAG = "CardGridArrayAdapter";
    }

    public CardGridArrayAdapter(Context context, List<Card> cards) {
        super(context, cards);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        Card mCard = (Card) getItem(position);
        if (mCard != null) {
            boolean recycle;
            int layout = this.mRowLayoutId;
            if (view == null) {
                recycle = false;
                view = mInflater.inflate(layout, parent, false);
            } else {
                recycle = true;
            }
            CardView mCardView = (CardView) view.findViewById(C0173R.id.list_cardId);
            if (mCardView != null) {
                mCardView.setForceReplaceInnerLayout(Card.equalsInnerLayout(mCardView.getCard(), mCard));
                mCardView.setRecycle(recycle);
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
                setupMultichoice(view, mCard, mCardView, (long) position);
            }
        }
        return view;
    }

    protected void setupSwipeableAnimation(Card card, CardView cardView) {
        cardView.setOnTouchListener(null);
    }

    protected void setupExpandCollapseListAnimation(CardView cardView) {
        if (cardView != null) {
            cardView.setOnExpandListAnimatorListener(this.mCardGridView);
        }
    }

    public CardGridView getCardGridView() {
        return this.mCardGridView;
    }

    public void setCardGridView(CardGridView cardGridView) {
        this.mCardGridView = cardGridView;
    }
}
