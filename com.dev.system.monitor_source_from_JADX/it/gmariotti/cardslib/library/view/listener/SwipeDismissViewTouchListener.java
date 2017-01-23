package it.gmariotti.cardslib.library.view.listener;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;

public class SwipeDismissViewTouchListener implements OnTouchListener {
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private CardView mCardView;
    private float mDownX;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mPaused;
    private int mSlop;
    private boolean mSwiping;
    private Card mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;
    private int swipeDistanceDivisor;

    /* renamed from: it.gmariotti.cardslib.library.view.listener.SwipeDismissViewTouchListener.1 */
    class C02091 extends AnimatorListenerAdapter {
        C02091() {
        }

        public void onAnimationEnd(Animator animation) {
            SwipeDismissViewTouchListener.this.performDismiss();
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.listener.SwipeDismissViewTouchListener.2 */
    class C02102 extends AnimatorListenerAdapter {
        final /* synthetic */ LayoutParams val$lp;
        final /* synthetic */ int val$originalHeight;

        C02102(LayoutParams layoutParams, int i) {
            this.val$lp = layoutParams;
            this.val$originalHeight = i;
        }

        public void onAnimationEnd(Animator animation) {
            SwipeDismissViewTouchListener.this.mCallbacks.onDismiss(SwipeDismissViewTouchListener.this.mCardView, SwipeDismissViewTouchListener.this.mToken);
            SwipeDismissViewTouchListener.this.mCardView.setAlpha(1.0f);
            SwipeDismissViewTouchListener.this.mCardView.setTranslationX(0.0f);
            this.val$lp.height = this.val$originalHeight;
            SwipeDismissViewTouchListener.this.mCardView.setLayoutParams(this.val$lp);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.listener.SwipeDismissViewTouchListener.3 */
    class C02113 implements AnimatorUpdateListener {
        final /* synthetic */ LayoutParams val$lp;

        C02113(LayoutParams layoutParams) {
            this.val$lp = layoutParams;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$lp.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SwipeDismissViewTouchListener.this.mCardView.setLayoutParams(this.val$lp);
        }
    }

    public interface DismissCallbacks {
        boolean canDismiss(Card card);

        void onDismiss(CardView cardView, Card card);
    }

    public SwipeDismissViewTouchListener(CardView cardView, Card card, DismissCallbacks callbacks) {
        this.mViewWidth = 1;
        this.swipeDistanceDivisor = 2;
        ViewConfiguration vc = ViewConfiguration.get(cardView.getContext());
        this.mSlop = vc.getScaledTouchSlop();
        this.mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long) cardView.getContext().getResources().getInteger(17694720);
        this.mCardView = cardView;
        this.mToken = card;
        this.mCallbacks = callbacks;
        this.swipeDistanceDivisor = cardView.getContext().getResources().getInteger(C0173R.integer.list_card_swipe_distance_divisor);
    }

    public void setEnabled(boolean enabled) {
        this.mPaused = !enabled;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        motionEvent.offsetLocation(this.mTranslationX, 0.0f);
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mCardView.getWidth();
        }
        float deltaX;
        switch (motionEvent.getActionMasked()) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                if (this.mPaused) {
                    return false;
                }
                this.mDownX = motionEvent.getRawX();
                if (this.mCallbacks.canDismiss(this.mToken)) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                    this.mVelocityTracker.addMovement(motionEvent);
                }
                view.onTouchEvent(motionEvent);
                return true;
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                if (this.mVelocityTracker != null) {
                    deltaX = motionEvent.getRawX() - this.mDownX;
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float velocityX = this.mVelocityTracker.getXVelocity();
                    float absVelocityX = Math.abs(velocityX);
                    float absVelocityY = Math.abs(this.mVelocityTracker.getYVelocity());
                    boolean dismiss = false;
                    boolean dismissRight = false;
                    if (Math.abs(deltaX) > ((float) (this.mViewWidth / this.swipeDistanceDivisor))) {
                        dismiss = true;
                        dismissRight = deltaX > 0.0f;
                    } else if (((float) this.mMinFlingVelocity) <= absVelocityX && absVelocityX <= ((float) this.mMaxFlingVelocity) && absVelocityY < absVelocityX) {
                        dismiss = ((velocityX > 0.0f ? 1 : (velocityX == 0.0f ? 0 : -1)) < 0 ? 1 : null) == ((deltaX > 0.0f ? 1 : (deltaX == 0.0f ? 0 : -1)) < 0 ? 1 : null);
                        dismissRight = this.mVelocityTracker.getXVelocity() > 0.0f;
                    }
                    if (dismiss) {
                        float f;
                        ViewPropertyAnimator animate = this.mCardView.animate();
                        if (dismissRight) {
                            f = (float) this.mViewWidth;
                        } else {
                            f = (float) (-this.mViewWidth);
                        }
                        animate.translationX(f).alpha(0.0f).setDuration(this.mAnimationTime).setListener(new C02091());
                    } else {
                        this.mCardView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
                    }
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mDownX = 0.0f;
                    this.mSwiping = false;
                    break;
                }
                break;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                if (!(this.mVelocityTracker == null || this.mPaused)) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    deltaX = motionEvent.getRawX() - this.mDownX;
                    if (Math.abs(deltaX) > ((float) this.mSlop)) {
                        this.mSwiping = true;
                        this.mCardView.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                        cancelEvent.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mCardView.onTouchEvent(cancelEvent);
                        cancelEvent.recycle();
                    }
                    if (this.mSwiping) {
                        this.mTranslationX = deltaX;
                        this.mCardView.setTranslationX(deltaX);
                        this.mCardView.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((2.0f * Math.abs(deltaX)) / ((float) this.mViewWidth)))));
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    private void performDismiss() {
        LayoutParams lp = this.mCardView.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{this.mCardView.getHeight(), 1}).setDuration(this.mAnimationTime);
        animator.addListener(new C02102(lp, originalHeight));
        animator.addUpdateListener(new C02113(lp));
        animator.start();
    }
}
