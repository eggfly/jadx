package it.gmariotti.cardslib.library.internal.base;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import it.gmariotti.cardslib.library.view.listener.UndoBarController.UndoBarUIElements;
import java.util.List;

public abstract class BaseCardArrayAdapter extends ArrayAdapter<Card> {
    protected int innerviewTypeCount;
    protected Context mContext;
    protected int mRowLayoutId;
    protected UndoBarUIElements mUndoBarUIElements;

    public BaseCardArrayAdapter(Context context, List<Card> cards) {
        super(context, 0, cards);
        this.mRowLayoutId = C0173R.layout.list_card_layout;
        this.innerviewTypeCount = 1;
        this.mContext = context;
    }

    public int getViewTypeCount() {
        return this.innerviewTypeCount;
    }

    public int getItemViewType(int position) {
        return ((Card) getItem(position)).getType();
    }

    public boolean isEnabled(int position) {
        Card card = (Card) getItem(position);
        if (card.isClickable() || card.isLongClickable()) {
            return true;
        }
        return false;
    }

    protected void setupMultichoice(View view, Card mCard, CardView mCardView, long position) {
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setRowLayoutId(int rowLayoutId) {
        this.mRowLayoutId = rowLayoutId;
    }

    public void setInnerViewTypeCount(int viewTypeCount) {
        this.innerviewTypeCount = viewTypeCount;
    }

    public void setUndoBarUIElements(UndoBarUIElements undoBarUIElements) {
        this.mUndoBarUIElements = undoBarUIElements;
    }
}
