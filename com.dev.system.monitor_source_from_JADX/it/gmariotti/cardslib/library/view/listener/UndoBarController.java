package it.gmariotti.cardslib.library.view.listener;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;

public class UndoBarController {
    private ViewPropertyAnimator mBarAnimator;
    private View mBarView;
    private Handler mHideHandler;
    private Runnable mHideRunnable;
    private TextView mMessageView;
    private UndoBarUIElements mUndoBarUIElements;
    private UndoListener mUndoListener;
    private CharSequence mUndoMessage;
    private Parcelable mUndoToken;

    /* renamed from: it.gmariotti.cardslib.library.view.listener.UndoBarController.1 */
    class C02121 implements OnClickListener {
        C02121() {
        }

        public void onClick(View view) {
            UndoBarController.this.hideUndoBar(false);
            UndoBarController.this.mUndoListener.onUndo(UndoBarController.this.mUndoToken);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.listener.UndoBarController.2 */
    class C02132 extends AnimatorListenerAdapter {
        C02132() {
        }

        public void onAnimationEnd(Animator animation) {
            UndoBarController.this.mBarView.setVisibility(8);
            UndoBarController.this.mUndoMessage = null;
            UndoBarController.this.mUndoToken = null;
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.listener.UndoBarController.3 */
    class C02143 implements Runnable {
        C02143() {
        }

        public void run() {
            UndoBarController.this.hideUndoBar(false);
        }
    }

    public interface UndoBarUIElements {
        String getMessageUndo(CardArrayAdapter cardArrayAdapter, String[] strArr, int[] iArr);

        int getUndoBarButtonId();

        int getUndoBarId();

        int getUndoBarMessageId();
    }

    public interface UndoListener {
        void onUndo(Parcelable parcelable);
    }

    public static class DefaultUndoBarUIElements implements UndoBarUIElements {
        public int getUndoBarId() {
            return C0173R.id.list_card_undobar;
        }

        public int getUndoBarMessageId() {
            return C0173R.id.list_card_undobar_message;
        }

        public int getUndoBarButtonId() {
            return C0173R.id.list_card_undobar_button;
        }

        public String getMessageUndo(CardArrayAdapter cardArrayAdapter, String[] itemIds, int[] itemPositions) {
            if (!(cardArrayAdapter == null || cardArrayAdapter.getContext() == null)) {
                Resources res = cardArrayAdapter.getContext().getResources();
                if (res != null) {
                    return res.getQuantityString(C0173R.plurals.list_card_undo_items, itemPositions.length, new Object[]{Integer.valueOf(itemPositions.length)});
                }
            }
            return null;
        }
    }

    public UndoBarController(View undoBarView, UndoListener undoListener) {
        this(undoBarView, undoListener, null);
    }

    public UndoBarController(View undoBarView, UndoListener undoListener, UndoBarUIElements undoBarUIElements) {
        this.mHideHandler = new Handler();
        this.mHideRunnable = new C02143();
        this.mBarView = undoBarView;
        this.mBarAnimator = this.mBarView.animate();
        this.mUndoListener = undoListener;
        if (undoBarUIElements == null) {
            undoBarUIElements = new DefaultUndoBarUIElements();
        }
        this.mUndoBarUIElements = undoBarUIElements;
        this.mMessageView = (TextView) this.mBarView.findViewById(this.mUndoBarUIElements.getUndoBarMessageId());
        this.mBarView.findViewById(this.mUndoBarUIElements.getUndoBarButtonId()).setOnClickListener(new C02121());
        hideUndoBar(true);
    }

    public void showUndoBar(boolean immediate, CharSequence message, Parcelable undoToken) {
        this.mUndoToken = undoToken;
        this.mUndoMessage = message;
        this.mMessageView.setText(this.mUndoMessage);
        this.mHideHandler.removeCallbacks(this.mHideRunnable);
        this.mHideHandler.postDelayed(this.mHideRunnable, (long) this.mBarView.getResources().getInteger(C0173R.integer.list_card_undobar_hide_delay));
        this.mBarView.setVisibility(0);
        if (immediate) {
            this.mBarView.setAlpha(1.0f);
            return;
        }
        this.mBarAnimator.cancel();
        this.mBarAnimator.alpha(1.0f).setDuration((long) this.mBarView.getResources().getInteger(17694720)).setListener(null);
    }

    public void hideUndoBar(boolean immediate) {
        this.mHideHandler.removeCallbacks(this.mHideRunnable);
        if (immediate) {
            this.mBarView.setVisibility(8);
            this.mBarView.setAlpha(0.0f);
            this.mUndoMessage = null;
            this.mUndoToken = null;
            return;
        }
        this.mBarAnimator.cancel();
        this.mBarAnimator.alpha(0.0f).setDuration((long) this.mBarView.getResources().getInteger(17694720)).setListener(new C02132());
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putCharSequence("undo_message", this.mUndoMessage);
        outState.putParcelable("undo_token", this.mUndoToken);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mUndoMessage = savedInstanceState.getCharSequence("undo_message");
            this.mUndoToken = savedInstanceState.getParcelable("undo_token");
            if (this.mUndoToken != null || !TextUtils.isEmpty(this.mUndoMessage)) {
                showUndoBar(true, this.mUndoMessage, this.mUndoToken);
            }
        }
    }

    public Parcelable getUndoToken() {
        return this.mUndoToken;
    }

    public UndoBarUIElements getUndoBarUIElements() {
        return this.mUndoBarUIElements;
    }

    public void setUndoBarUIElements(UndoBarUIElements undoBarUIElements) {
        this.mUndoBarUIElements = undoBarUIElements;
    }
}
