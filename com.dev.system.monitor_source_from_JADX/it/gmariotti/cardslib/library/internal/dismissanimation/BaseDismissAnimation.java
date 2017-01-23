package it.gmariotti.cardslib.library.internal.dismissanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.base.BaseCardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseDismissAnimation {
    protected int mAnimationTime;
    protected BaseCardArrayAdapter mBaseAdapter;
    DismissCallbacks mCallbacks;
    protected CardListView mCardListView;
    protected Context mContext;
    private int mDismissAnimationRefCount;
    protected boolean mDismissRight;
    private int mDownPosition;
    protected int mListWidth;
    private List<PendingDismissData> mPendingDismisses;

    /* renamed from: it.gmariotti.cardslib.library.internal.dismissanimation.BaseDismissAnimation.1 */
    class C01751 extends AnimatorListenerAdapter {
        C01751() {
        }

        public void onAnimationEnd(Animator animation) {
            BaseDismissAnimation.access$006(BaseDismissAnimation.this);
            if (BaseDismissAnimation.this.mDismissAnimationRefCount == 0) {
                Collections.sort(BaseDismissAnimation.this.mPendingDismisses);
                int[] dismissPositions = new int[BaseDismissAnimation.this.mPendingDismisses.size()];
                for (int i = BaseDismissAnimation.this.mPendingDismisses.size() - 1; i >= 0; i--) {
                    dismissPositions[i] = ((PendingDismissData) BaseDismissAnimation.this.mPendingDismisses.get(i)).position;
                }
                BaseDismissAnimation.this.mCallbacks.onDismiss(BaseDismissAnimation.this.mCardListView, dismissPositions);
                BaseDismissAnimation.this.mDownPosition = -1;
                for (PendingDismissData pendingDismiss : BaseDismissAnimation.this.mPendingDismisses) {
                    pendingDismiss.view.setAlpha(1.0f);
                    pendingDismiss.view.setTranslationX(0.0f);
                    LayoutParams lp = pendingDismiss.view.getLayoutParams();
                    lp.height = 0;
                    pendingDismiss.view.setLayoutParams(lp);
                }
                long time = SystemClock.uptimeMillis();
                BaseDismissAnimation.this.mCardListView.dispatchTouchEvent(MotionEvent.obtain(time, time, 3, 0.0f, 0.0f, 0));
                BaseDismissAnimation.this.mPendingDismisses.clear();
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.internal.dismissanimation.BaseDismissAnimation.2 */
    class C01762 implements AnimatorUpdateListener {
        final /* synthetic */ View val$dismissView;
        final /* synthetic */ LayoutParams val$lp;

        C01762(LayoutParams layoutParams, View view) {
            this.val$lp = layoutParams;
            this.val$dismissView = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$lp.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.val$dismissView.setLayoutParams(this.val$lp);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.internal.dismissanimation.BaseDismissAnimation.4 */
    class C01774 extends AnimatorListenerAdapter {
        final /* synthetic */ LayoutParams val$lp;
        final /* synthetic */ View val$view;

        C01774(LayoutParams layoutParams, View view) {
            this.val$lp = layoutParams;
            this.val$view = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.val$lp.height = 0;
            this.val$view.setLayoutParams(this.val$lp);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.internal.dismissanimation.BaseDismissAnimation.5 */
    class C01785 implements AnimatorUpdateListener {
        final /* synthetic */ LayoutParams val$lp;
        final /* synthetic */ View val$view;

        C01785(LayoutParams layoutParams, View view) {
            this.val$lp = layoutParams;
            this.val$view = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$lp.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.val$view.setLayoutParams(this.val$lp);
        }
    }

    public interface DismissCallbacks {
        boolean canDismiss(int i, Card card);

        void onDismiss(ListView listView, int[] iArr);
    }

    class PendingDismissData implements Comparable<PendingDismissData> {
        public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            this.position = position;
            this.view = view;
        }

        public int compareTo(PendingDismissData other) {
            return other.position - this.position;
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.internal.dismissanimation.BaseDismissAnimation.3 */
    class C02503 implements DismissCallbacks {
        C02503() {
        }

        public boolean canDismiss(int position, Card card) {
            return card.isSwipeable();
        }

        public void onDismiss(ListView listView, int[] reverseSortedPositions) {
            int[] itemPositions = new int[reverseSortedPositions.length];
            String[] itemIds = new String[reverseSortedPositions.length];
            int i = 0;
            for (int position : reverseSortedPositions) {
                Card card = (Card) BaseDismissAnimation.this.mBaseAdapter.getItem(position);
                if (card != null) {
                    itemPositions[i] = position;
                    itemIds[i] = card.getId();
                    i++;
                    BaseDismissAnimation.this.mBaseAdapter.remove(card);
                    if (card.getOnSwipeListener() != null) {
                        card.getOnSwipeListener().onSwipe(card);
                    }
                }
            }
            BaseDismissAnimation.this.mBaseAdapter.notifyDataSetChanged();
        }
    }

    public abstract void animate(Card card, CardView cardView);

    static /* synthetic */ int access$006(BaseDismissAnimation x0) {
        int i = x0.mDismissAnimationRefCount - 1;
        x0.mDismissAnimationRefCount = i;
        return i;
    }

    public BaseDismissAnimation(Context context) {
        this.mAnimationTime = 200;
        this.mDismissRight = true;
        this.mPendingDismisses = new ArrayList();
        this.mDismissAnimationRefCount = 0;
        this.mCallbacks = new C02503();
        this.mContext = context;
    }

    public BaseDismissAnimation setup(BaseCardArrayAdapter adapter) {
        this.mBaseAdapter = adapter;
        return this;
    }

    public void animateDismissPosition(int position) {
        if (position > -1) {
            animateDismissPosition(Arrays.asList(new Integer[]{Integer.valueOf(position)}));
        }
    }

    public void animateDismissPosition(Collection<Integer> positions) {
        if (this.mBaseAdapter == null) {
            throw new IllegalStateException("Call setup method before animate!");
        }
        prepareAnimation();
        for (CardView cardView : getVisibleViewsForPositions(new ArrayList(positions))) {
            dismissiCardWithAnimation(cardView);
        }
    }

    public void animateDismiss(Card card) {
        if (card != null) {
            animateDismiss(Arrays.asList(new Card[]{card}));
        }
    }

    public void animateDismiss(Collection<Card> cards) {
        if (this.mBaseAdapter == null) {
            throw new IllegalStateException("Call setup method before animate!");
        }
        prepareAnimation();
        for (CardView cardView : getVisibleViewsForCards(new ArrayList(cards))) {
            dismissiCardWithAnimation(cardView);
        }
    }

    private void prepareAnimation() {
        setupCardListView();
        if (this.mCardListView != null) {
            this.mListWidth = this.mCardListView.getWidth();
        }
    }

    private void setupCardListView() {
        if (this.mBaseAdapter != null && (this.mBaseAdapter instanceof CardArrayAdapter)) {
            this.mCardListView = ((CardArrayAdapter) this.mBaseAdapter).getCardListView();
        }
        if (this.mCardListView == null) {
            throw new IllegalStateException("BaseDismissAnimation works with a CardListView");
        }
    }

    private List<CardView> getVisibleViewsForPositions(Collection<Integer> positions) {
        List<CardView> views = new ArrayList();
        for (int i = 0; i < this.mCardListView.getChildCount(); i++) {
            View child = this.mCardListView.getChildAt(i);
            if (positions.contains(Integer.valueOf(this.mCardListView.getPositionForView(child)))) {
                views.add((CardView) child);
            }
        }
        return views;
    }

    private List<CardView> getVisibleViewsForCards(List<Card> cardsCopy) {
        List<CardView> originalViews = new ArrayList();
        for (Card card : cardsCopy) {
            originalViews.add(card.getCardView());
        }
        return originalViews;
    }

    private void dismissiCardWithAnimation(CardView cardView) {
        this.mDismissAnimationRefCount++;
        int mDownPosition = this.mCardListView.getPositionForView(cardView);
        animate(cardView.getCard(), cardView);
    }

    protected void invokeCallbak(View dismissView) {
        int dismissPosition = this.mBaseAdapter.getPosition(((CardView) dismissView).getCard());
        LayoutParams lp = dismissView.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{dismissView.getHeight(), 1}).setDuration((long) this.mAnimationTime);
        animator.addListener(new C01751());
        animator.addUpdateListener(new C01762(lp, dismissView));
        this.mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }

    private Animator createAnimatorForView(View view) {
        LayoutParams lp = view.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{view.getHeight(), 0});
        animator.addListener(new C01774(lp, view));
        animator.addUpdateListener(new C01785(lp, view));
        return animator;
    }

    public boolean isDismissRight() {
        return this.mDismissRight;
    }

    public void setDismissRight(boolean dismissRight) {
        this.mDismissRight = dismissRight;
    }

    public int getAnimationTime() {
        return this.mAnimationTime;
    }
}
