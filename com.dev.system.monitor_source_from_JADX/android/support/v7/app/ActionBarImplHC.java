package android.support.v7.app;

import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class ActionBarImplHC extends ActionBarImplBase implements OnActionModeForChildListener {
    private ActionMode mCurActionMode;
    final NativeActionModeAwareLayout mNativeActionModeAwareLayout;

    private class CallbackWrapper implements Callback {
        private final Callback mWrappedCallback;

        CallbackWrapper(Callback callback) {
            this.mWrappedCallback = callback;
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            boolean wrappedResult = this.mWrappedCallback.onCreateActionMode(mode, menu);
            if (wrappedResult) {
                ActionBarImplHC.this.mCurActionMode = mode;
                ActionBarImplHC.this.showForActionMode();
            }
            return wrappedResult;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(mode, menu);
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mWrappedCallback.onActionItemClicked(mode, item);
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.mWrappedCallback.onDestroyActionMode(mode);
            ActionBarImplHC.this.hideForActionMode();
            ActionBarImplHC.this.mCurActionMode = null;
        }
    }

    public ActionBarImplHC(ActionBarActivity activity, Callback callback) {
        super(activity, callback);
        this.mNativeActionModeAwareLayout = (NativeActionModeAwareLayout) activity.findViewById(C0056R.id.action_bar_root);
        if (this.mNativeActionModeAwareLayout != null) {
            this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    public Callback onActionModeForChild(Callback callback) {
        return new CallbackWrapper(callback);
    }

    public void show() {
        super.show();
        if (this.mCurActionMode != null) {
            this.mCurActionMode.finish();
        }
    }

    public void hide() {
        super.hide();
        if (this.mCurActionMode != null) {
            this.mCurActionMode.finish();
        }
    }

    boolean isShowHideAnimationEnabled() {
        return this.mCurActionMode == null && super.isShowHideAnimationEnabled();
    }
}
