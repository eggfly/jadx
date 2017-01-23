package it.gmariotti.cardslib.library.view.listener;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwipeDismissListViewTouchListener implements OnTouchListener {
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private int mDismissAnimationRefCount;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    private float mDownY;
    private ListView mListView;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mPaused;
    private List<PendingDismissData> mPendingDismisses;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;
    private int swipeDistanceDivisor;

    /* renamed from: it.gmariotti.cardslib.library.view.listener.SwipeDismissListViewTouchListener.1 */
    class C02061 extends AnimatorListenerAdapter {
        final /* synthetic */ int val$position;
        final /* synthetic */ View val$view;

        C02061(View view, int i) {
            this.val$view = view;
            this.val$position = i;
        }

        public void onAnimationEnd(Animator animation) {
            SwipeDismissListViewTouchListener.this.performDismiss(this.val$view, this.val$position);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.listener.SwipeDismissListViewTouchListener.2 */
    class C02072 extends AnimatorListenerAdapter {
        C02072() {
        }

        public void onAnimationEnd(Animator animation) {
            SwipeDismissListViewTouchListener.access$106(SwipeDismissListViewTouchListener.this);
            if (SwipeDismissListViewTouchListener.this.mDismissAnimationRefCount == 0) {
                Collections.sort(SwipeDismissListViewTouchListener.this.mPendingDismisses);
                int[] dismissPositions = new int[SwipeDismissListViewTouchListener.this.mPendingDismisses.size()];
                for (int i = SwipeDismissListViewTouchListener.this.mPendingDismisses.size() - 1; i >= 0; i--) {
                    dismissPositions[i] = ((PendingDismissData) SwipeDismissListViewTouchListener.this.mPendingDismisses.get(i)).position;
                }
                SwipeDismissListViewTouchListener.this.mCallbacks.onDismiss(SwipeDismissListViewTouchListener.this.mListView, dismissPositions);
                SwipeDismissListViewTouchListener.this.mDownPosition = -1;
                for (PendingDismissData pendingDismiss : SwipeDismissListViewTouchListener.this.mPendingDismisses) {
                    pendingDismiss.view.setAlpha(1.0f);
                    pendingDismiss.view.setTranslationX(0.0f);
                    LayoutParams lp = pendingDismiss.view.getLayoutParams();
                    lp.height = 0;
                    pendingDismiss.view.setLayoutParams(lp);
                }
                long time = SystemClock.uptimeMillis();
                SwipeDismissListViewTouchListener.this.mListView.dispatchTouchEvent(MotionEvent.obtain(time, time, 3, 0.0f, 0.0f, 0));
                SwipeDismissListViewTouchListener.this.mPendingDismisses.clear();
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.listener.SwipeDismissListViewTouchListener.3 */
    class C02083 implements AnimatorUpdateListener {
        final /* synthetic */ View val$dismissView;
        final /* synthetic */ LayoutParams val$lp;

        C02083(LayoutParams layoutParams, View view) {
            this.val$lp = layoutParams;
            this.val$dismissView = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$lp.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.val$dismissView.setLayoutParams(this.val$lp);
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

    static /* synthetic */ int access$106(SwipeDismissListViewTouchListener x0) {
        int i = x0.mDismissAnimationRefCount - 1;
        x0.mDismissAnimationRefCount = i;
        return i;
    }

    public SwipeDismissListViewTouchListener(ListView listView, DismissCallbacks callbacks) {
        this.mViewWidth = 1;
        this.mPendingDismisses = new ArrayList();
        this.mDismissAnimationRefCount = 0;
        this.swipeDistanceDivisor = 2;
        ViewConfiguration vc = ViewConfiguration.get(listView.getContext());
        this.mSlop = vc.getScaledTouchSlop();
        this.mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long) listView.getContext().getResources().getInteger(17694720);
        this.mListView = listView;
        this.mCallbacks = callbacks;
        this.swipeDistanceDivisor = listView.getContext().getResources().getInteger(C0173R.integer.list_card_swipe_distance_divisor);
    }

    public void setEnabled(boolean enabled) {
        this.mPaused = !enabled;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = this.mViewWidth;
        if (r0 < 2) {
            this.mViewWidth = this.mListView.getWidth();
        }
        float deltaX;
        switch (motionEvent.getActionMasked()) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                if (this.mPaused) {
                    return false;
                }
                if (this.mSwiping) {
                    return true;
                }
                Rect rect = new Rect();
                int childCount = this.mListView.getChildCount();
                int headerCount = this.mListView.getHeaderViewsCount();
                int footerCount = this.mListView.getFooterViewsCount();
                int[] listViewCoords = new int[2];
                this.mListView.getLocationOnScreen(listViewCoords);
                int x = ((int) motionEvent.getRawX()) - listViewCoords[0];
                int y = ((int) motionEvent.getRawY()) - listViewCoords[1];
                for (int i2 = headerCount; i2 < childCount - footerCount; i2++) {
                    View child = this.mListView.getChildAt(i2);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        this.mDownView = child;
                        if (this.mDownView != null) {
                            this.mDownX = motionEvent.getRawX();
                            this.mDownY = motionEvent.getRawY();
                            this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
                            if (this.mListView.getAdapter().getItem(this.mDownPosition) instanceof Card) {
                                this.mDownView = null;
                            } else {
                                if (this.mCallbacks.canDismiss(this.mDownPosition, (Card) this.mListView.getAdapter().getItem(this.mDownPosition))) {
                                    this.mDownView = null;
                                } else {
                                    this.mVelocityTracker = VelocityTracker.obtain();
                                    this.mVelocityTracker.addMovement(motionEvent);
                                }
                            }
                        }
                        view.onTouchEvent(motionEvent);
                        return true;
                    }
                }
                if (this.mDownView != null) {
                    this.mDownX = motionEvent.getRawX();
                    this.mDownY = motionEvent.getRawY();
                    this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
                    if (this.mListView.getAdapter().getItem(this.mDownPosition) instanceof Card) {
                        this.mDownView = null;
                    } else {
                        if (this.mCallbacks.canDismiss(this.mDownPosition, (Card) this.mListView.getAdapter().getItem(this.mDownPosition))) {
                            this.mDownView = null;
                        } else {
                            this.mVelocityTracker = VelocityTracker.obtain();
                            this.mVelocityTracker.addMovement(motionEvent);
                        }
                    }
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
                    if (Math.abs(deltaX) <= ((float) (this.mViewWidth / this.swipeDistanceDivisor)) || !this.mSwiping) {
                        if (((float) this.mMinFlingVelocity) <= absVelocityX) {
                            if (absVelocityX <= ((float) this.mMaxFlingVelocity) && absVelocityY < absVelocityX && this.mSwiping) {
                                dismiss = ((velocityX > 0.0f ? 1 : (velocityX == 0.0f ? 0 : -1)) < 0 ? 1 : null) == ((deltaX > 0.0f ? 1 : (deltaX == 0.0f ? 0 : -1)) < 0 ? 1 : null);
                                dismissRight = this.mVelocityTracker.getXVelocity() > 0.0f;
                            }
                        }
                    } else {
                        dismiss = true;
                        dismissRight = deltaX > 0.0f;
                    }
                    if (dismiss) {
                        i = this.mDownPosition;
                        if (r0 != -1) {
                            dismiss(this.mDownView, this.mDownPosition - this.mListView.getHeaderViewsCount(), dismissRight);
                            this.mVelocityTracker.recycle();
                            this.mVelocityTracker = null;
                            this.mDownX = 0.0f;
                            this.mDownY = 0.0f;
                            this.mDownView = null;
                            this.mDownPosition = -1;
                            if (this.mSwiping) {
                                this.mSwiping = false;
                                break;
                            }
                            this.mSwiping = false;
                            return true;
                        }
                    }
                    this.mDownView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mDownX = 0.0f;
                    this.mDownY = 0.0f;
                    this.mDownView = null;
                    this.mDownPosition = -1;
                    if (this.mSwiping) {
                        this.mSwiping = false;
                    } else {
                        this.mSwiping = false;
                        return true;
                    }
                }
                break;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                if (!(this.mVelocityTracker == null || this.mPaused)) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    deltaX = motionEvent.getRawX() - this.mDownX;
                    float deltaY = motionEvent.getRawY() - this.mDownY;
                    if (Math.abs(deltaX) > ((float) this.mSlop) && Math.abs(deltaY) < Math.abs(deltaX) / 2.0f) {
                        this.mSwiping = true;
                        if (deltaX > 0.0f) {
                            i = this.mSlop;
                        } else {
                            i = -this.mSlop;
                        }
                        this.mSwipingSlop = i;
                        this.mListView.requestDisallowInterceptTouchEvent(true);
                        MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                        cancelEvent.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mListView.onTouchEvent(cancelEvent);
                        view.onTouchEvent(cancelEvent);
                        cancelEvent.recycle();
                    }
                    if (this.mSwiping) {
                        this.mDownView.setTranslationX(deltaX - ((float) this.mSwipingSlop));
                        this.mDownView.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((2.0f * Math.abs(deltaX)) / ((float) this.mViewWidth)))));
                        return true;
                    }
                }
                break;
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                if (this.mVelocityTracker != null) {
                    if (this.mDownView != null) {
                        this.mDownView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
                    }
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mDownX = 0.0f;
                    this.mDownY = 0.0f;
                    this.mDownView = null;
                    this.mDownPosition = -1;
                    this.mSwiping = false;
                    break;
                }
                break;
        }
        return false;
    }

    private void dismiss(View view, int position, boolean dismissRight) {
        this.mDismissAnimationRefCount++;
        if (view == null) {
            this.mCallbacks.onDismiss(this.mListView, new int[]{position});
        } else {
            view.animate().translationX(dismissRight ? (float) this.mViewWidth : (float) (-this.mViewWidth)).alpha(0.0f).setDuration(this.mAnimationTime).setListener(new C02061(view, position));
        }
    }

    private void performDismiss(View dismissView, int dismissPosition) {
        LayoutParams lp = dismissView.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{dismissView.getHeight(), 1}).setDuration(this.mAnimationTime);
        animator.addListener(new C02072());
        animator.addUpdateListener(new C02083(lp, dismissView));
        this.mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
