package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ActionModeWrapper extends ActionMode {
    final MenuInflater mInflater;
    final android.view.ActionMode mWrappedObject;

    public static class CallbackWrapper implements Callback {
        final Context mContext;
        private ActionModeWrapper mLastStartedActionMode;
        final ActionMode.Callback mWrappedCallback;

        public CallbackWrapper(Context context, ActionMode.Callback supportCallback) {
            this.mContext = context;
            this.mWrappedCallback = supportCallback;
        }

        public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(mode), MenuWrapperFactory.createMenuWrapper(menu));
        }

        public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(mode), MenuWrapperFactory.createMenuWrapper(menu));
        }

        public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(mode), MenuWrapperFactory.createMenuItemWrapper(item));
        }

        public void onDestroyActionMode(android.view.ActionMode mode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(mode));
        }

        public void setLastStartedActionMode(ActionModeWrapper modeWrapper) {
            this.mLastStartedActionMode = modeWrapper;
        }

        private ActionMode getActionModeWrapper(android.view.ActionMode mode) {
            if (this.mLastStartedActionMode == null || this.mLastStartedActionMode.mWrappedObject != mode) {
                return createActionModeWrapper(this.mContext, mode);
            }
            return this.mLastStartedActionMode;
        }

        protected ActionModeWrapper createActionModeWrapper(Context context, android.view.ActionMode mode) {
            return new ActionModeWrapper(context, mode);
        }
    }

    public ActionModeWrapper(Context context, android.view.ActionMode frameworkActionMode) {
        this.mWrappedObject = frameworkActionMode;
        this.mInflater = new SupportMenuInflater(context);
    }

    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    public void setTag(Object tag) {
        this.mWrappedObject.setTag(tag);
    }

    public void setTitle(CharSequence title) {
        this.mWrappedObject.setTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mWrappedObject.setSubtitle(subtitle);
    }

    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    public void finish() {
        this.mWrappedObject.finish();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.createMenuWrapper(this.mWrappedObject.getMenu());
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public void setTitle(int resId) {
        this.mWrappedObject.setTitle(resId);
    }

    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    public void setSubtitle(int resId) {
        this.mWrappedObject.setSubtitle(resId);
    }

    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    public void setCustomView(View view) {
        this.mWrappedObject.setCustomView(view);
    }

    public MenuInflater getMenuInflater() {
        return this.mInflater;
    }
}
