package android.support.v7.internal.view.menu;

import android.support.v4.view.ActionProvider.VisibilityListener;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class MenuItemWrapperJB extends MenuItemWrapperICS {

    class ActionProviderWrapperJB extends ActionProviderWrapper implements VisibilityListener {
        ActionProvider.VisibilityListener mListener;

        public ActionProviderWrapperJB(android.support.v4.view.ActionProvider inner) {
            super(inner);
        }

        public View onCreateActionView(MenuItem forItem) {
            return this.mInner.onCreateActionView(forItem);
        }

        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener listener) {
            VisibilityListener visibilityListener;
            this.mListener = listener;
            android.support.v4.view.ActionProvider actionProvider = this.mInner;
            if (listener == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public void onActionProviderVisibilityChanged(boolean isVisible) {
            if (this.mListener != null) {
                this.mListener.onActionProviderVisibilityChanged(isVisible);
            }
        }
    }

    MenuItemWrapperJB(MenuItem object) {
        super(object, false);
    }

    ActionProviderWrapper createActionProviderWrapper(android.support.v4.view.ActionProvider provider) {
        return new ActionProviderWrapperJB(provider);
    }
}
