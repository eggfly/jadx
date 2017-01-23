package it.gmariotti.cardslib.library.internal.overflowanimation;

import android.content.Context;
import android.view.View;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardHeader.CustomOverflowAnimation;
import it.gmariotti.cardslib.library.view.CardView;

public abstract class BaseOverflowAnimation implements CustomOverflowAnimation {
    protected static String TAG;
    private Card mCard;
    protected Context mContext;
    protected boolean selected;

    static {
        TAG = "BaseOverflowAnimation";
    }

    public BaseOverflowAnimation(Context context) {
        this.selected = false;
        this.mContext = context;
    }

    public void doAnimation(Card card, View imageOverflow) {
        if (card != null) {
            this.mCard = card;
            CardHeader header = card.getCardHeader();
            if (header != null) {
                this.selected = header.isOverflowSelected();
            }
        }
    }

    protected void selectOverflowIcon() {
        changeOverflowIconSelection(true);
    }

    protected void deselectOverflowIcon() {
        changeOverflowIconSelection(false);
    }

    protected void toggleOverflowIcon() {
        if (this.mCard != null) {
            changeOverflowIconSelection(!this.selected);
        }
    }

    protected void changeOverflowIconSelection(boolean selected) {
        if (this.mCard != null) {
            CardHeader header = this.mCard.getCardHeader();
            if (header != null) {
                this.selected = selected;
                header.setOverflowSelected(selected);
            }
            CardView cardView = this.mCard.getCardView();
            if (cardView != null && cardView.getInternalHeaderLayout() != null && cardView.getInternalHeaderLayout().getImageButtonOverflow() != null) {
                cardView.getInternalHeaderLayout().getImageButtonOverflow().setSelected(selected);
            }
        }
    }

    protected Context getContext() {
        return this.mContext;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Card getCard() {
        return this.mCard;
    }
}
