package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCardCursorAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CardCursorAdapter extends BaseCardCursorAdapter {
    protected static String TAG;
    protected CardListView mCardListView;
    protected final List<String> mExpandedIds;
    protected HashMap<String, Card> mInternalObjects;
    protected boolean recycle;

    static {
        TAG = "CardCursorAdapter";
    }

    public CardCursorAdapter(Context context) {
        super(context, null, 0);
        this.recycle = false;
        this.mExpandedIds = new ArrayList();
    }

    protected CardCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.recycle = false;
        this.mExpandedIds = new ArrayList();
    }

    protected CardCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.recycle = false;
        this.mExpandedIds = new ArrayList();
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
                mCard.setExpanded(isExpanded(mCard));
                mCardView.setCard(mCard);
                if (origianlSwipeable) {
                    Log.d(TAG, "Swipe action not enabled in this type of view");
                }
                if ((mCard.getCardHeader() != null && mCard.getCardHeader().isButtonExpandVisible()) || mCard.getViewToClickToExpand() != null) {
                    setupExpandCollapseListAnimation(mCardView);
                }
                setupSwipeableAnimation(mCard, mCardView);
                setupMultichoice(view, mCard, mCardView, (long) cursor.getPosition());
            }
        }
    }

    protected void setupSwipeableAnimation(Card card, CardView cardView) {
        cardView.setOnTouchListener(null);
    }

    protected void setupExpandCollapseListAnimation(CardView cardView) {
        if (cardView != null) {
            cardView.setOnExpandListAnimatorListener(this.mCardListView);
        }
    }

    public void setExpanded(Card card) {
        if (card != null) {
            setExpanded(card.getId());
        }
    }

    public void setExpanded(String id) {
        if (this.mExpandedIds != null && !this.mExpandedIds.contains(id)) {
            this.mExpandedIds.add(id);
        }
    }

    public void setCollapsed(Card card) {
        if (card != null) {
            setCollapsed(card.getId());
        }
    }

    public void setCollapsed(String id) {
        if (this.mExpandedIds != null && this.mExpandedIds.contains(id)) {
            this.mExpandedIds.remove(id);
        }
    }

    public boolean isExpanded(Card card) {
        return this.mExpandedIds.contains(card.getId());
    }

    public boolean onExpandStart(CardView viewCard) {
        Card card = viewCard.getCard();
        if (card != null) {
            if (!this.mExpandedIds.contains(card.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean onCollapseStart(CardView viewCard) {
        Card card = viewCard.getCard();
        if (card != null) {
            if (this.mExpandedIds.contains(card.getId())) {
                return true;
            }
        }
        return false;
    }

    public void onExpandEnd(CardView viewCard) {
        Card card = viewCard.getCard();
        if (card != null) {
            setExpanded(card);
        }
    }

    public void onCollapseEnd(CardView viewCard) {
        Card card = viewCard.getCard();
        if (card != null) {
            setCollapsed(card);
        }
    }

    public CardListView getCardListView() {
        return this.mCardListView;
    }

    public void setCardListView(CardListView cardListView) {
        this.mCardListView = cardListView;
    }

    public List<String> getExpandedIds() {
        return this.mExpandedIds;
    }
}
