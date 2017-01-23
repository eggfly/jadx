package it.gmariotti.cardslib.library.internal.overflowanimation;

import android.content.Context;
import android.view.View;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;

public abstract class BaseCardOverlayAnimation extends BaseOverflowAnimation {
    protected int mAnimationDuration;
    protected Card originalCard;

    public interface CardInfo {
        int[] getLayoutsIdToAdd();

        void setupLayoutsIdToRemove(int[] iArr);
    }

    public abstract class CardInfoToAnimate implements CardInfo {
        protected int[] mLayoutsIdToRemove;

        public abstract int[] getLayoutsIdToAdd();

        public CardInfoToAnimate() {
            defaultIdToRemove();
        }

        private void defaultIdToRemove() {
            this.mLayoutsIdToRemove = new int[]{C0173R.id.card_header_inner_frame, C0173R.id.card_thumbnail_layout, C0173R.id.card_main_content_layout};
        }

        public void setupLayoutsIdToRemove(int[] layoutId) {
            this.mLayoutsIdToRemove = layoutId;
        }

        protected boolean isWithNavigator() {
            if (getLayoutsIdToAdd() == null || getLayoutsIdToAdd().length <= 1) {
                return false;
            }
            return true;
        }
    }

    protected abstract void doOverFirstAnimation(Card card, CardInfoToAnimate cardInfoToAnimate, View view);

    protected abstract void doOverOtherAnimation(Card card, CardInfoToAnimate cardInfoToAnimate, View view);

    protected abstract CardInfoToAnimate setCardToAnimate(Card card);

    public BaseCardOverlayAnimation(Context context, Card card) {
        super(context);
        this.originalCard = card;
    }

    public void doAnimation(Card card, View imageOverflow) {
        super.doAnimation(card, imageOverflow);
        if (card != null && card.getCardView() != null) {
            CardInfoToAnimate infoAnimation = setCardToAnimate(card);
            if (infoAnimation != null) {
                if (this.selected) {
                    doOverOtherAnimation(card, infoAnimation, imageOverflow);
                } else {
                    doOverFirstAnimation(card, infoAnimation, imageOverflow);
                }
                toggleOverflowIcon();
            }
        }
    }

    protected int getAnimationDuration() {
        int integer = this.mContext.getResources().getInteger(17694720);
        this.mAnimationDuration = integer;
        return integer;
    }
}
