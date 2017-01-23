package it.gmariotti.cardslib.library.internal.base;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CursorAdapter;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;

public abstract class BaseCardCursorAdapter extends CursorAdapter {
    protected int innerviewTypeCount;
    protected Context mContext;
    protected int mRowLayoutId;

    protected abstract Card getCardFromCursor(Cursor cursor);

    protected BaseCardCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.mRowLayoutId = C0173R.layout.list_card_layout;
        this.innerviewTypeCount = 1;
        this.mContext = context;
    }

    protected BaseCardCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.mRowLayoutId = C0173R.layout.list_card_layout;
        this.innerviewTypeCount = 1;
        this.mContext = context;
    }

    public int getViewTypeCount() {
        return this.innerviewTypeCount;
    }

    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public boolean isEnabled(int position) {
        Card card = getItem(position);
        if (card.isClickable() || card.isLongClickable()) {
            return true;
        }
        return false;
    }

    protected void setupMultichoice(View view, Card mCard, CardView mCardView, long position) {
    }

    public Card getItem(int position) {
        Object obj = super.getItem(position);
        if (obj instanceof Cursor) {
            return getCardFromCursor((Cursor) obj);
        }
        return null;
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
}
