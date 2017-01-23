package it.gmariotti.cardslib.library.internal;

import android.view.View;

public class ViewToClickToExpand {
    protected CardElementUI cardElementUIToClick;
    protected View viewToClick;
    protected boolean viewToSelect;

    public enum CardElementUI {
        CARD(0),
        HEADER(1),
        THUMBNAIL(2),
        MAIN_CONTENT(3);
        
        int mElement;

        private CardElementUI(int element) {
            this.mElement = element;
        }
    }

    protected ViewToClickToExpand() {
        this.viewToSelect = false;
    }

    public static ViewToClickToExpand builder() {
        return new ViewToClickToExpand();
    }

    public ViewToClickToExpand setupView(View viewToClick) {
        this.viewToClick = viewToClick;
        return this;
    }

    public ViewToClickToExpand highlightView(boolean highlight) {
        this.viewToSelect = highlight;
        return this;
    }

    public ViewToClickToExpand setupCardElement(CardElementUI cardElementUIToClick) {
        this.cardElementUIToClick = cardElementUIToClick;
        return this;
    }

    public View getViewToClick() {
        return this.viewToClick;
    }

    public boolean isViewToSelect() {
        return this.viewToSelect;
    }

    public CardElementUI getCardElementUIToClick() {
        return this.cardElementUIToClick;
    }
}
