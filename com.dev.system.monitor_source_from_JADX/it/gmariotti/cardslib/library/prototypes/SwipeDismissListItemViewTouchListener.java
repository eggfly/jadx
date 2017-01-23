package it.gmariotti.cardslib.library.prototypes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.prototypes.CardWithList.ListObject;

public class SwipeDismissListItemViewTouchListener implements OnTouchListener {
    private View itemView;
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    private float mDownY;
    private ListObject mListObject;
    private LinearListView mListView;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mPaused;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;
    private int swipeDistanceDivisor;

    /* renamed from: it.gmariotti.cardslib.library.prototypes.SwipeDismissListItemViewTouchListener.1 */
    class C01881 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean val$dismissRight;
        final /* synthetic */ int val$position;
        final /* synthetic */ View val$view;

        C01881(View view, int i, boolean z) {
            this.val$view = view;
            this.val$position = i;
            this.val$dismissRight = z;
        }

        public void onAnimationEnd(Animator animation) {
            SwipeDismissListItemViewTouchListener.this.finalizeDismiss(this.val$view, this.val$position, this.val$dismissRight);
        }
    }

    public interface DismissCallbacks {
        boolean canDismiss(int i, Card card, ListObject listObject);

        void onDismiss(LinearListView linearListView, int i, boolean z);
    }

    public SwipeDismissListItemViewTouchListener(LinearListView listView, DismissCallbacks callbacks) {
        this.mViewWidth = 1;
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
                ListObject object;
                Rect rect = new Rect();
                int childCount = this.mListView.getChildCount();
                int[] listViewCoords = new int[2];
                this.mListView.getLocationOnScreen(listViewCoords);
                int x = ((int) motionEvent.getRawX()) - listViewCoords[0];
                int y = ((int) motionEvent.getRawY()) - listViewCoords[1];
                for (int i2 = 0; i2 < childCount - 0; i2++) {
                    View child = this.mListView.getChildAt(i2);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        this.mDownView = child;
                        if (this.mDownView != null) {
                            this.mDownX = motionEvent.getRawX();
                            this.mDownY = motionEvent.getRawY();
                            this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
                            object = (ListObject) this.mListView.getAdapter().getItem(this.mDownPosition);
                            if (this.mCallbacks.canDismiss(this.mDownPosition, object.getParentCard(), object)) {
                                this.mDownView = null;
                            } else {
                                this.mVelocityTracker = VelocityTracker.obtain();
                                this.mVelocityTracker.addMovement(motionEvent);
                            }
                        }
                        view.onTouchEvent(motionEvent);
                        return false;
                    }
                }
                if (this.mDownView != null) {
                    this.mDownX = motionEvent.getRawX();
                    this.mDownY = motionEvent.getRawY();
                    this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
                    object = (ListObject) this.mListView.getAdapter().getItem(this.mDownPosition);
                    if (this.mCallbacks.canDismiss(this.mDownPosition, object.getParentCard(), object)) {
                        this.mDownView = null;
                    } else {
                        this.mVelocityTracker = VelocityTracker.obtain();
                        this.mVelocityTracker.addMovement(motionEvent);
                    }
                }
                view.onTouchEvent(motionEvent);
                return false;
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
                    } else {
                        if (((float) this.mMinFlingVelocity) <= absVelocityX) {
                            if (absVelocityX <= ((float) this.mMaxFlingVelocity) && absVelocityY < absVelocityX && this.mSwiping) {
                                dismiss = ((velocityX > 0.0f ? 1 : (velocityX == 0.0f ? 0 : -1)) < 0 ? 1 : null) == ((deltaX > 0.0f ? 1 : (deltaX == 0.0f ? 0 : -1)) < 0 ? 1 : null);
                                dismissRight = this.mVelocityTracker.getXVelocity() > 0.0f;
                            }
                        }
                    }
                    if (dismiss) {
                        i = this.mDownPosition;
                        if (r0 != -1) {
                            dismiss(this.mDownView, this.mDownPosition, dismissRight);
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
                        this.mDownView.getParent().requestDisallowInterceptTouchEvent(true);
                        this.mListView.requestDisallowInterceptTouchEvent(true);
                        MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                        cancelEvent.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mDownView.onTouchEvent(cancelEvent);
                        cancelEvent.recycle();
                    }
                    if (this.mSwiping) {
                        this.mDownView.setTranslationX(deltaX - ((float) this.mSwipingSlop));
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
        if (view == null) {
            this.mCallbacks.onDismiss(this.mListView, position, dismissRight);
        } else {
            view.animate().translationX(dismissRight ? (float) this.mViewWidth : (float) (-this.mViewWidth)).alpha(0.0f).setDuration(this.mAnimationTime).setListener(new C01881(view, position, dismissRight));
        }
    }

    private void finalizeDismiss(View dismissView, int dismissPosition, boolean dismissRight) {
        this.mCallbacks.onDismiss(this.mListView, dismissPosition, dismissRight);
    }
}
