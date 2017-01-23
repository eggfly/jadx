package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper<MenuItem> implements SupportMenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private final boolean mEmulateProviderVisibilityOverride;
    private boolean mLastRequestVisible;
    private Method mSetExclusiveCheckableMethod;

    class ActionProviderWrapper extends ActionProvider {
        final android.support.v4.view.ActionProvider mInner;

        /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperICS.ActionProviderWrapper.1 */
        class C02371 implements VisibilityListener {
            final /* synthetic */ MenuItemWrapperICS val$this$0;

            C02371(MenuItemWrapperICS menuItemWrapperICS) {
                this.val$this$0 = menuItemWrapperICS;
            }

            public void onActionProviderVisibilityChanged(boolean isVisible) {
                if (ActionProviderWrapper.this.mInner.overridesItemVisibility() && MenuItemWrapperICS.this.mLastRequestVisible) {
                    MenuItemWrapperICS.this.wrappedSetVisible(isVisible);
                }
            }
        }

        public ActionProviderWrapper(android.support.v4.view.ActionProvider inner) {
            super(inner.getContext());
            this.mInner = inner;
            if (MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride) {
                this.mInner.setVisibilityListener(new C02371(MenuItemWrapperICS.this));
            }
        }

        public View onCreateActionView() {
            if (MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride) {
                MenuItemWrapperICS.this.checkActionProviderOverrideVisibility();
            }
            return this.mInner.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.support.v7.view.CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View actionView) {
            super(actionView.getContext());
            this.mWrappedView = (android.support.v7.view.CollapsibleActionView) actionView;
            addView(actionView);
        }

        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        View getWrappedView() {
            return (View) this.mWrappedView;
        }
    }

    private class OnActionExpandListenerWrapper extends BaseWrapper<OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        OnActionExpandListenerWrapper(OnActionExpandListener object) {
            super(object);
        }

        public boolean onMenuItemActionExpand(MenuItem item) {
            return ((OnActionExpandListener) this.mWrappedObject).onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(item));
        }

        public boolean onMenuItemActionCollapse(MenuItem item) {
            return ((OnActionExpandListener) this.mWrappedObject).onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(item));
        }
    }

    private class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
        OnMenuItemClickListenerWrapper(OnMenuItemClickListener object) {
            super(object);
        }

        public boolean onMenuItemClick(MenuItem item) {
            return ((OnMenuItemClickListener) this.mWrappedObject).onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(item));
        }
    }

    MenuItemWrapperICS(MenuItem object, boolean emulateProviderVisibilityOverride) {
        super(object);
        this.mLastRequestVisible = object.isVisible();
        this.mEmulateProviderVisibilityOverride = emulateProviderVisibilityOverride;
    }

    MenuItemWrapperICS(MenuItem object) {
        this(object, true);
    }

    public int getItemId() {
        return ((MenuItem) this.mWrappedObject).getItemId();
    }

    public int getGroupId() {
        return ((MenuItem) this.mWrappedObject).getGroupId();
    }

    public int getOrder() {
        return ((MenuItem) this.mWrappedObject).getOrder();
    }

    public MenuItem setTitle(CharSequence title) {
        ((MenuItem) this.mWrappedObject).setTitle(title);
        return this;
    }

    public MenuItem setTitle(int title) {
        ((MenuItem) this.mWrappedObject).setTitle(title);
        return this;
    }

    public CharSequence getTitle() {
        return ((MenuItem) this.mWrappedObject).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        ((MenuItem) this.mWrappedObject).setTitleCondensed(title);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((MenuItem) this.mWrappedObject).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable icon) {
        ((MenuItem) this.mWrappedObject).setIcon(icon);
        return this;
    }

    public MenuItem setIcon(int iconRes) {
        ((MenuItem) this.mWrappedObject).setIcon(iconRes);
        return this;
    }

    public Drawable getIcon() {
        return ((MenuItem) this.mWrappedObject).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((MenuItem) this.mWrappedObject).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((MenuItem) this.mWrappedObject).getIntent();
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        ((MenuItem) this.mWrappedObject).setShortcut(numericChar, alphaChar);
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        ((MenuItem) this.mWrappedObject).setNumericShortcut(numericChar);
        return this;
    }

    public char getNumericShortcut() {
        return ((MenuItem) this.mWrappedObject).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        ((MenuItem) this.mWrappedObject).setAlphabeticShortcut(alphaChar);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((MenuItem) this.mWrappedObject).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean checkable) {
        ((MenuItem) this.mWrappedObject).setCheckable(checkable);
        return this;
    }

    public boolean isCheckable() {
        return ((MenuItem) this.mWrappedObject).isCheckable();
    }

    public MenuItem setChecked(boolean checked) {
        ((MenuItem) this.mWrappedObject).setChecked(checked);
        return this;
    }

    public boolean isChecked() {
        return ((MenuItem) this.mWrappedObject).isChecked();
    }

    public MenuItem setVisible(boolean visible) {
        if (this.mEmulateProviderVisibilityOverride) {
            this.mLastRequestVisible = visible;
            if (checkActionProviderOverrideVisibility()) {
                return this;
            }
        }
        return wrappedSetVisible(visible);
    }

    public boolean isVisible() {
        return ((MenuItem) this.mWrappedObject).isVisible();
    }

    public MenuItem setEnabled(boolean enabled) {
        ((MenuItem) this.mWrappedObject).setEnabled(enabled);
        return this;
    }

    public boolean isEnabled() {
        return ((MenuItem) this.mWrappedObject).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((MenuItem) this.mWrappedObject).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return getSubMenuWrapper(((MenuItem) this.mWrappedObject).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        ((MenuItem) this.mWrappedObject).setOnMenuItemClickListener(menuItemClickListener != null ? new OnMenuItemClickListenerWrapper(menuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((MenuItem) this.mWrappedObject).getMenuInfo();
    }

    public void setShowAsAction(int actionEnum) {
        ((MenuItem) this.mWrappedObject).setShowAsAction(actionEnum);
    }

    public MenuItem setShowAsActionFlags(int actionEnum) {
        ((MenuItem) this.mWrappedObject).setShowAsActionFlags(actionEnum);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.support.v7.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((MenuItem) this.mWrappedObject).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int resId) {
        ((MenuItem) this.mWrappedObject).setActionView(resId);
        View actionView = ((MenuItem) this.mWrappedObject).getActionView();
        if (actionView instanceof android.support.v7.view.CollapsibleActionView) {
            ((MenuItem) this.mWrappedObject).setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((MenuItem) this.mWrappedObject).getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).getWrappedView();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider provider) {
        ((MenuItem) this.mWrappedObject).setActionProvider(provider);
        if (provider != null && this.mEmulateProviderVisibilityOverride) {
            checkActionProviderOverrideVisibility();
        }
        return this;
    }

    public ActionProvider getActionProvider() {
        return ((MenuItem) this.mWrappedObject).getActionProvider();
    }

    public boolean expandActionView() {
        return ((MenuItem) this.mWrappedObject).expandActionView();
    }

    public boolean collapseActionView() {
        return ((MenuItem) this.mWrappedObject).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((MenuItem) this.mWrappedObject).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        ((MenuItem) this.mWrappedObject).setOnActionExpandListener(listener);
        return this;
    }

    public SupportMenuItem setSupportOnActionExpandListener(OnActionExpandListener listener) {
        MenuItem.OnActionExpandListener onActionExpandListenerWrapper;
        MenuItem menuItem = (MenuItem) this.mWrappedObject;
        if (listener != null) {
            onActionExpandListenerWrapper = new OnActionExpandListenerWrapper(listener);
        } else {
            onActionExpandListenerWrapper = null;
        }
        menuItem.setOnActionExpandListener(onActionExpandListenerWrapper);
        return null;
    }

    public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider actionProvider) {
        ((MenuItem) this.mWrappedObject).setActionProvider(actionProvider != null ? createActionProviderWrapper(actionProvider) : null);
        return this;
    }

    public android.support.v4.view.ActionProvider getSupportActionProvider() {
        ActionProviderWrapper providerWrapper = (ActionProviderWrapper) ((MenuItem) this.mWrappedObject).getActionProvider();
        return providerWrapper != null ? providerWrapper.mInner : null;
    }

    public void setExclusiveCheckable(boolean checkable) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = ((MenuItem) this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(checkable)});
        } catch (Exception e) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        }
    }

    ActionProviderWrapper createActionProviderWrapper(android.support.v4.view.ActionProvider provider) {
        return new ActionProviderWrapper(provider);
    }

    final boolean checkActionProviderOverrideVisibility() {
        if (!this.mLastRequestVisible) {
            return false;
        }
        android.support.v4.view.ActionProvider provider = getSupportActionProvider();
        if (provider == null || !provider.overridesItemVisibility() || provider.isVisible()) {
            return false;
        }
        wrappedSetVisible(false);
        return true;
    }

    final MenuItem wrappedSetVisible(boolean visible) {
        return ((MenuItem) this.mWrappedObject).setVisible(visible);
    }
}
