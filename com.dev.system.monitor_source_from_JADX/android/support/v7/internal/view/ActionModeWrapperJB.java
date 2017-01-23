package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.view.ActionMode.Callback;
import android.view.ActionMode;

public class ActionModeWrapperJB extends ActionModeWrapper {

    public static class CallbackWrapper extends android.support.v7.internal.view.ActionModeWrapper.CallbackWrapper {
        public CallbackWrapper(Context context, Callback supportCallback) {
            super(context, supportCallback);
        }

        protected ActionModeWrapper createActionModeWrapper(Context context, ActionMode mode) {
            return new ActionModeWrapperJB(context, mode);
        }
    }

    public ActionModeWrapperJB(Context context, ActionMode frameworkActionMode) {
        super(context, frameworkActionMode);
    }

    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    public void setTitleOptionalHint(boolean titleOptional) {
        this.mWrappedObject.setTitleOptionalHint(titleOptional);
    }

    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }
}
