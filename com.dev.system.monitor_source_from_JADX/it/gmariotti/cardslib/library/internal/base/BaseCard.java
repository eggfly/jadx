package it.gmariotti.cardslib.library.internal.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;

public abstract class BaseCard implements CardUIInferface {
    protected CardView mCardView;
    protected Context mContext;
    protected String mId;
    protected int mInnerLayout;
    protected View mInnerView;
    protected Card mParentCard;
    protected String mTitle;
    protected int type;

    public BaseCard(Context context) {
        this.mInnerLayout = -1;
        this.mId = null;
        this.type = 0;
        this.mContext = context;
    }

    public CardView getCardView() {
        return this.mCardView;
    }

    public View getInnerView(Context context, ViewGroup parent) {
        if (this.mInnerLayout <= -1) {
            return null;
        }
        this.mInnerView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.mInnerLayout, parent, false);
        return this.mInnerView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public int getInnerLayout() {
        return this.mInnerLayout;
    }

    public void setInnerLayout(int innerLayout) {
        this.mInnerLayout = innerLayout;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setCardView(CardView cardView) {
        this.mCardView = cardView;
    }

    public Card getParentCard() {
        return this.mParentCard;
    }

    public void setParentCard(Card parentCard) {
        this.mParentCard = parentCard;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
