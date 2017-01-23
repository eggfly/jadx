package it.gmariotti.cardslib.library.internal.dismissanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;

public class SwipeDismissAnimation extends BaseDismissAnimation {

    /* renamed from: it.gmariotti.cardslib.library.internal.dismissanimation.SwipeDismissAnimation.1 */
    class C01791 extends AnimatorListenerAdapter {
        final /* synthetic */ CardView val$cardView;

        C01791(CardView cardView) {
            this.val$cardView = cardView;
        }

        public void onAnimationEnd(Animator animation) {
            SwipeDismissAnimation.this.invokeCallbak(this.val$cardView);
        }
    }

    public SwipeDismissAnimation(Context context) {
        this(context, true);
    }

    public SwipeDismissAnimation(Context context, boolean dismissRight) {
        super(context);
        this.mDismissRight = dismissRight;
    }

    public void animate(Card card, CardView cardView) {
        cardView.animate().translationX(this.mDismissRight ? (float) this.mListWidth : (float) (-this.mListWidth)).alpha(0.0f).setDuration((long) this.mAnimationTime).setListener(new C01791(cardView));
    }
}
