package android.support.v7.app;

import android.content.Context;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.ActionModeWrapper.CallbackWrapper;
import android.support.v7.internal.view.ActionModeWrapperJB;
import android.support.v7.view.ActionMode.Callback;
import android.view.ActionMode;

class ActionBarActivityDelegateJB extends ActionBarActivityDelegateICS {
    ActionBarActivityDelegateJB(ActionBarActivity activity) {
        super(activity);
    }

    public ActionBar createSupportActionBar() {
        return new ActionBarImplJB(this.mActivity, this.mActivity);
    }

    CallbackWrapper createActionModeCallbackWrapper(Context context, Callback callback) {
        return new ActionModeWrapperJB.CallbackWrapper(context, callback);
    }

    ActionModeWrapper createActionModeWrapper(Context context, ActionMode frameworkMode) {
        return new ActionModeWrapperJB(context, frameworkMode);
    }
}
