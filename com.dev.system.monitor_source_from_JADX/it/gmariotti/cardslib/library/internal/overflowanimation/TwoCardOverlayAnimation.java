package it.gmariotti.cardslib.library.internal.overflowanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.overflowanimation.BaseCardOverlayAnimation.CardInfoToAnimate;
import java.util.ArrayList;

public abstract class TwoCardOverlayAnimation extends BaseCardOverlayAnimation {

    /* renamed from: it.gmariotti.cardslib.library.internal.overflowanimation.TwoCardOverlayAnimation.1 */
    class C01811 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$viewOut;

        C01811(View view) {
            this.val$viewOut = view;
        }

        public void onAnimationEnd(Animator animation) {
            this.val$viewOut.setVisibility(8);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.internal.overflowanimation.TwoCardOverlayAnimation.2 */
    class C01822 extends AnimatorListenerAdapter {
        final /* synthetic */ Card val$card;
        final /* synthetic */ int val$layoutIdIn;
        final /* synthetic */ ViewGroup val$mInternalLayoutOverlay;

        C01822(int i, ViewGroup viewGroup, Card card) {
            this.val$layoutIdIn = i;
            this.val$mInternalLayoutOverlay = viewGroup;
            this.val$card = card;
        }

        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            View viewIn = ((LayoutInflater) TwoCardOverlayAnimation.this.mContext.getSystemService("layout_inflater")).inflate(this.val$layoutIdIn, this.val$mInternalLayoutOverlay, false);
            if (viewIn != null) {
                if (!(this.val$card.getCardView() == null || this.val$card.getCardView().getInternalMainCardLayout() == null || this.val$card.getCardView().getInternalHeaderLayout() == null || this.val$card.getCardView().getInternalHeaderLayout().getFrameButton() == null)) {
                    viewIn.setMinimumHeight(this.val$card.getCardView().getInternalMainCardLayout().getMeasuredHeight() - this.val$card.getCardView().getInternalHeaderLayout().getFrameButton().getMeasuredHeight());
                }
                this.val$mInternalLayoutOverlay.addView(viewIn);
                viewIn.setAlpha(0.0f);
                viewIn.setVisibility(0);
                viewIn.animate().alpha(1.0f).setDuration((long) TwoCardOverlayAnimation.this.getAnimationDuration()).setListener(null);
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.internal.overflowanimation.TwoCardOverlayAnimation.3 */
    class C01833 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup val$mInternalLayoutOverlay;
        final /* synthetic */ View val$viewLastIn;
        final /* synthetic */ View[] val$viewsLastOut;

        C01833(View view, View[] viewArr, ViewGroup viewGroup) {
            this.val$viewLastIn = view;
            this.val$viewsLastOut = viewArr;
            this.val$mInternalLayoutOverlay = viewGroup;
        }

        public void onAnimationEnd(Animator animation) {
            View viewOut;
            int i = 0;
            this.val$viewLastIn.setVisibility(8);
            for (View viewOut2 : this.val$viewsLastOut) {
                if (viewOut2 != null) {
                    viewOut2.setVisibility(0);
                }
            }
            if (this.val$mInternalLayoutOverlay != null) {
                this.val$mInternalLayoutOverlay.removeView(this.val$viewLastIn);
            }
            View[] viewArr = this.val$viewsLastOut;
            int length = viewArr.length;
            while (i < length) {
                viewOut2 = viewArr[i];
                if (viewOut2 != null) {
                    viewOut2.animate().alpha(1.0f).setDuration((long) TwoCardOverlayAnimation.this.getAnimationDuration());
                }
                i++;
            }
        }
    }

    public abstract class TwoCardToAnimate extends CardInfoToAnimate {
        public abstract int getLayoutIdToAdd();

        public TwoCardToAnimate() {
            super();
        }

        public int[] getLayoutsIdToAdd() {
            return new int[]{getLayoutIdToAdd()};
        }
    }

    public TwoCardOverlayAnimation(Context context, Card card) {
        super(context, card);
    }

    protected void doOverFirstAnimation(Card card, CardInfoToAnimate infoAnimation, View imageOverflow) {
        int i = 0;
        if (infoAnimation != null) {
            ViewGroup mInternalLayoutOverlay = (ViewGroup) card.getCardView().findViewById(C0173R.id.card_overlap);
            if (mInternalLayoutOverlay == null) {
                Log.e(TAG, "Overlap layout not found!");
            } else if (infoAnimation.getLayoutsIdToAdd() == null) {
                Log.e(TAG, "You have to specify layouts to add!");
            } else {
                View[] viewsOut = getOutViews(card, infoAnimation);
                int layoutIdIn = infoAnimation.getLayoutsIdToAdd()[0];
                AnimatorSet animAlpha = new AnimatorSet();
                if (viewsOut != null && layoutIdIn > 0) {
                    ArrayList<Animator> animators = new ArrayList();
                    int length = viewsOut.length;
                    while (i < length) {
                        View viewOut = viewsOut[i];
                        if (viewOut != null) {
                            ObjectAnimator anim = ObjectAnimator.ofFloat(viewOut, "alpha", new float[]{1.0f, 0.0f});
                            anim.setDuration((long) getAnimationDuration());
                            anim.addListener(new C01811(viewOut));
                            animators.add(anim);
                        }
                        i++;
                    }
                    animAlpha.playTogether(animators);
                }
                animAlpha.addListener(new C01822(layoutIdIn, mInternalLayoutOverlay, card));
                animAlpha.start();
            }
        }
    }

    protected void doOverOtherAnimation(Card card, CardInfoToAnimate infoAnimation, View imageOverflow) {
        if (infoAnimation != null) {
            ViewGroup mInternalLayoutOverlay = (ViewGroup) card.getCardView().findViewById(C0173R.id.card_overlap);
            if (mInternalLayoutOverlay == null) {
                Log.e(TAG, "Overlap layout not found!");
            } else if (infoAnimation.getLayoutsIdToAdd() == null) {
                Log.e(TAG, "You have to specify layouts to add!");
            } else {
                View[] viewsLastOut = getOutViews(card, infoAnimation);
                View viewLastIn = mInternalLayoutOverlay.getChildAt(0);
                View[] viewsFirstOut = getOutViews(card, infoAnimation);
                if (viewLastIn != null) {
                    viewLastIn.animate().alpha(0.0f).setDuration((long) getAnimationDuration()).setListener(new C01833(viewLastIn, viewsLastOut, mInternalLayoutOverlay));
                }
            }
        }
    }

    protected View[] getOutViews(Card card, CardInfoToAnimate infoAnimation) {
        View[] viewsOut = null;
        if (infoAnimation.mLayoutsIdToRemove != null) {
            viewsOut = new View[infoAnimation.mLayoutsIdToRemove.length];
            int i = 0;
            for (int layoutIdOut : infoAnimation.mLayoutsIdToRemove) {
                viewsOut[i] = card.getCardView().findViewById(layoutIdOut);
                i++;
            }
        }
        return viewsOut;
    }

    protected int getAnimationDuration() {
        int integer = this.mContext.getResources().getInteger(17694720);
        this.mAnimationDuration = integer;
        return integer;
    }
}
