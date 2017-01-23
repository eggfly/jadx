package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;
import it.gmariotti.cardslib.library.internal.Card;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplBase extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private ActionBarActivity mActivity;
    private Callback mCallback;
    private ActionBarContainer mContainerView;
    private View mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    ActionMode mDeferredDestroyActionMode;
    Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    final Handler mHandler;
    private boolean mHasEmbeddedTabs;
    private boolean mHiddenByApp;
    private boolean mHiddenBySystem;
    private boolean mLastMenuVisibility;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners;
    private boolean mNowShowing;
    private ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    private boolean mShowingForMode;
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<TabImpl> mTabs;
    private Context mThemedContext;
    private ViewGroup mTopVisibilityView;

    class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private Callback mCallback;
        private WeakReference<View> mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(Callback callback) {
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(ActionBarImplBase.this.getThemedContext()).setDefaultShowAsAction(ActionBarImplBase.CONTEXT_DISPLAY_SPLIT);
            this.mMenu.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(ActionBarImplBase.this.getThemedContext());
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public void finish() {
            if (ActionBarImplBase.this.mActionMode == this) {
                if (ActionBarImplBase.checkShowingFlags(ActionBarImplBase.this.mHiddenByApp, ActionBarImplBase.this.mHiddenBySystem, false)) {
                    this.mCallback.onDestroyActionMode(this);
                } else {
                    ActionBarImplBase.this.mDeferredDestroyActionMode = this;
                    ActionBarImplBase.this.mDeferredModeDestroyCallback = this.mCallback;
                }
                this.mCallback = null;
                ActionBarImplBase.this.animateToMode(false);
                ActionBarImplBase.this.mContextView.closeMode();
                ActionBarImplBase.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImplBase.this.mActionMode = null;
            }
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                boolean onCreateActionMode = this.mCallback.onCreateActionMode(this, this.mMenu);
                return onCreateActionMode;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void setCustomView(View view) {
            ActionBarImplBase.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        public void setSubtitle(CharSequence subtitle) {
            ActionBarImplBase.this.mContextView.setSubtitle(subtitle);
        }

        public void setTitle(CharSequence title) {
            ActionBarImplBase.this.mContextView.setTitle(title);
        }

        public void setTitle(int resId) {
            setTitle(ActionBarImplBase.this.mContext.getResources().getString(resId));
        }

        public void setSubtitle(int resId) {
            setSubtitle(ActionBarImplBase.this.mContext.getResources().getString(resId));
        }

        public CharSequence getTitle() {
            return ActionBarImplBase.this.mContextView.getTitle();
        }

        public CharSequence getSubtitle() {
            return ActionBarImplBase.this.mContextView.getSubtitle();
        }

        public void setTitleOptionalHint(boolean titleOptional) {
            super.setTitleOptionalHint(titleOptional);
            ActionBarImplBase.this.mContextView.setTitleOptional(titleOptional);
        }

        public boolean isTitleOptional() {
            return ActionBarImplBase.this.mContextView.isTitleOptional();
        }

        public View getCustomView() {
            return this.mCustomView != null ? (View) this.mCustomView.get() : null;
        }

        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            if (this.mCallback != null) {
                return this.mCallback.onActionItemClicked(this, item);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menu) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImplBase.this.mContextView.showOverflowMenu();
            }
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            if (this.mCallback == null) {
                return false;
            }
            return !subMenu.hasVisibleItems() ? true : true;
        }

        public void onCloseSubMenu(SubMenuBuilder menu) {
        }

        public void onMenuModeChange(Menu menu) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImplBase.this.mContextView.showOverflowMenu();
            }
        }
    }

    public class TabImpl extends Tab {
        private TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
            this.mPosition = ActionBarImplBase.INVALID_POSITION;
        }

        public Object getTag() {
            return this.mTag;
        }

        public Tab setTag(Object tag) {
            this.mTag = tag;
            return this;
        }

        public TabListener getCallback() {
            return this.mCallback;
        }

        public Tab setTabListener(TabListener callback) {
            this.mCallback = callback;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setCustomView(int layoutResId) {
            return setCustomView(LayoutInflater.from(ActionBarImplBase.this.getThemedContext()).inflate(layoutResId, null));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public void setPosition(int position) {
            this.mPosition = position;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Tab setIcon(Drawable icon) {
            this.mIcon = icon;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setIcon(int resId) {
            return setIcon(ActionBarImplBase.this.mContext.getResources().getDrawable(resId));
        }

        public Tab setText(CharSequence text) {
            this.mText = text;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setText(int resId) {
            return setText(ActionBarImplBase.this.mContext.getResources().getText(resId));
        }

        public void select() {
            ActionBarImplBase.this.selectTab(this);
        }

        public Tab setContentDescription(int resId) {
            return setContentDescription(ActionBarImplBase.this.mContext.getResources().getText(resId));
        }

        public Tab setContentDescription(CharSequence contentDesc) {
            this.mContentDesc = contentDesc;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
    }

    public ActionBarImplBase(ActionBarActivity activity, Callback callback) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = INVALID_POSITION;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mHandler = new Handler();
        this.mCurWindowVisibility = CONTEXT_DISPLAY_NORMAL;
        this.mNowShowing = true;
        this.mActivity = activity;
        this.mContext = activity;
        this.mCallback = callback;
        init(this.mActivity);
    }

    private void init(ActionBarActivity activity) {
        boolean z = false;
        this.mOverlayLayout = (ActionBarOverlayLayout) activity.findViewById(C0056R.id.action_bar_overlay_layout);
        if (this.mOverlayLayout != null) {
            this.mOverlayLayout.setActionBar(this);
        }
        this.mActionView = (ActionBarView) activity.findViewById(C0056R.id.action_bar);
        this.mContextView = (ActionBarContextView) activity.findViewById(C0056R.id.action_context_bar);
        this.mContainerView = (ActionBarContainer) activity.findViewById(C0056R.id.action_bar_container);
        this.mTopVisibilityView = (ViewGroup) activity.findViewById(C0056R.id.top_action_bar);
        if (this.mTopVisibilityView == null) {
            this.mTopVisibilityView = this.mContainerView;
        }
        this.mSplitView = (ActionBarContainer) activity.findViewById(C0056R.id.split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        int i;
        boolean homeAsUp;
        this.mActionView.setContextView(this.mContextView);
        if (this.mActionView.isSplitActionBar()) {
            i = CONTEXT_DISPLAY_SPLIT;
        } else {
            i = CONTEXT_DISPLAY_NORMAL;
        }
        this.mContextDisplayMode = i;
        if ((this.mActionView.getDisplayOptions() & 4) != 0) {
            homeAsUp = true;
        } else {
            homeAsUp = false;
        }
        if (homeAsUp) {
            this.mDisplayHomeAsUpSet = true;
        }
        ActionBarPolicy abp = ActionBarPolicy.get(this.mContext);
        if (abp.enableHomeButtonByDefault() || homeAsUp) {
            z = true;
        }
        setHomeButtonEnabled(z);
        setHasEmbeddedTabs(abp.hasEmbeddedTabs());
        setTitle(this.mActivity.getTitle());
    }

    public void onConfigurationChanged(Configuration newConfig) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    private void setHasEmbeddedTabs(boolean hasEmbeddedTabs) {
        boolean isInTabMode;
        boolean z = true;
        this.mHasEmbeddedTabs = hasEmbeddedTabs;
        if (this.mHasEmbeddedTabs) {
            this.mContainerView.setTabContainer(null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
        } else {
            this.mActionView.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        if (getNavigationMode() == 2) {
            isInTabMode = true;
        } else {
            isInTabMode = false;
        }
        if (this.mTabScrollView != null) {
            if (isInTabMode) {
                this.mTabScrollView.setVisibility(CONTEXT_DISPLAY_NORMAL);
            } else {
                this.mTabScrollView.setVisibility(8);
            }
        }
        ActionBarView actionBarView = this.mActionView;
        if (this.mHasEmbeddedTabs || !isInTabMode) {
            z = false;
        }
        actionBarView.setCollapsable(z);
    }

    public boolean hasNonEmbeddedTabs() {
        return !this.mHasEmbeddedTabs && getNavigationMode() == 2;
    }

    public void setCustomView(View view) {
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, this.mActionView, false));
    }

    public void setIcon(int resId) {
        this.mActionView.setIcon(resId);
    }

    public void setIcon(Drawable icon) {
        this.mActionView.setIcon(icon);
    }

    public void setLogo(int resId) {
        this.mActionView.setLogo(resId);
    }

    public void setLogo(Drawable logo) {
        this.mActionView.setLogo(logo);
    }

    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        this.mActionView.setDropdownAdapter(adapter);
        this.mActionView.setCallback(callback);
    }

    public void setSelectedNavigationItem(int position) {
        switch (this.mActionView.getNavigationMode()) {
            case CONTEXT_DISPLAY_SPLIT /*1*/:
                this.mActionView.setDropdownSelectedPosition(position);
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                selectTab((Tab) this.mTabs.get(position));
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            case CONTEXT_DISPLAY_SPLIT /*1*/:
                return this.mActionView.getDropdownSelectedPosition();
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                if (this.mSelectedTab != null) {
                    return this.mSelectedTab.getPosition();
                }
                return INVALID_POSITION;
            default:
                return INVALID_POSITION;
        }
    }

    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
            case CONTEXT_DISPLAY_SPLIT /*1*/:
                SpinnerAdapter adapter = this.mActionView.getDropdownAdapter();
                return adapter != null ? adapter.getCount() : CONTEXT_DISPLAY_NORMAL;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                return this.mTabs.size();
            default:
                return CONTEXT_DISPLAY_NORMAL;
        }
    }

    public void setTitle(CharSequence title) {
        this.mActionView.setTitle(title);
    }

    public void setTitle(int resId) {
        setTitle(this.mContext.getString(resId));
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mActionView.setSubtitle(subtitle);
    }

    public void setSubtitle(int resId) {
        setSubtitle(this.mContext.getString(resId));
    }

    public void setDisplayOptions(int options) {
        if ((options & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mActionView.setDisplayOptions(options);
    }

    public void setDisplayOptions(int options, int mask) {
        int current = this.mActionView.getDisplayOptions();
        if ((mask & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mActionView.setDisplayOptions((options & mask) | ((mask ^ INVALID_POSITION) & current));
    }

    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL, CONTEXT_DISPLAY_SPLIT);
    }

    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? 2 : CONTEXT_DISPLAY_NORMAL, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? 4 : CONTEXT_DISPLAY_NORMAL, 4);
    }

    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? 8 : CONTEXT_DISPLAY_NORMAL, 8);
    }

    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? 16 : CONTEXT_DISPLAY_NORMAL, 16);
    }

    public void setHomeButtonEnabled(boolean enable) {
        this.mActionView.setHomeButtonEnabled(enable);
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mContainerView.setPrimaryBackground(d);
    }

    public void setStackedBackgroundDrawable(Drawable d) {
        this.mContainerView.setStackedBackground(d);
    }

    public void setSplitBackgroundDrawable(Drawable d) {
        this.mContainerView.setSplitBackground(d);
    }

    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }

    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }

    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }

    public void setNavigationMode(int mode) {
        boolean z = false;
        switch (this.mActionView.getNavigationMode()) {
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                this.mTabScrollView.setVisibility(8);
                break;
        }
        this.mActionView.setNavigationMode(mode);
        switch (mode) {
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                ensureTabsExist();
                this.mTabScrollView.setVisibility(CONTEXT_DISPLAY_NORMAL);
                if (this.mSavedTabPosition != INVALID_POSITION) {
                    setSelectedNavigationItem(this.mSavedTabPosition);
                    this.mSavedTabPosition = INVALID_POSITION;
                    break;
                }
                break;
        }
        ActionBarView actionBarView = this.mActionView;
        if (mode == 2 && !this.mHasEmbeddedTabs) {
            z = true;
        }
        actionBarView.setCollapsable(z);
    }

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public Tab newTab() {
        return new TabImpl();
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, this.mTabs.size());
        if (setSelected) {
            selectTab(tab);
        }
    }

    public void addTab(Tab tab, int position) {
        addTab(tab, position, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        if (setSelected) {
            selectTab(tab);
        }
    }

    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int position) {
        if (this.mTabScrollView != null) {
            int selectedTabPosition = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(position);
            TabImpl removedTab = (TabImpl) this.mTabs.remove(position);
            if (removedTab != null) {
                removedTab.setPosition(INVALID_POSITION);
            }
            int newTabCount = this.mTabs.size();
            for (int i = position; i < newTabCount; i += CONTEXT_DISPLAY_SPLIT) {
                ((TabImpl) this.mTabs.get(i)).setPosition(i);
            }
            if (selectedTabPosition == position) {
                Tab tab;
                if (this.mTabs.isEmpty()) {
                    tab = null;
                } else {
                    TabImpl tabImpl = (TabImpl) this.mTabs.get(Math.max(CONTEXT_DISPLAY_NORMAL, position + INVALID_POSITION));
                }
                selectTab(tab);
            }
        }
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void selectTab(Tab tab) {
        int i = INVALID_POSITION;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.mSavedTabPosition = i;
            return;
        }
        FragmentTransaction trans = this.mActivity.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        if (this.mSelectedTab != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, trans);
            }
            this.mSelectedTab = (TabImpl) tab;
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, trans);
            }
        } else if (this.mSelectedTab != null) {
            this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, trans);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (!trans.isEmpty()) {
            trans.commit();
        }
    }

    public Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public Tab getTabAt(int index) {
        return (Tab) this.mTabs.get(index);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue outValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0056R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, targetThemeRes);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        this.mActionView.setHomeAsUpIndicator(indicator);
    }

    public void setHomeAsUpIndicator(int resId) {
        this.mActionView.setHomeAsUpIndicator(resId);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            updateVisibility(false);
        }
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            updateVisibility(false);
        }
    }

    public boolean isShowing() {
        return this.mNowShowing;
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.add(listener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.remove(listener);
    }

    public ActionMode startActionMode(Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        this.mContextView.killMode();
        ActionModeImpl mode = new ActionModeImpl(callback);
        if (!mode.dispatchOnCreate()) {
            return null;
        }
        mode.invalidate();
        this.mContextView.initForMode(mode);
        animateToMode(true);
        if (!(this.mSplitView == null || this.mContextDisplayMode != CONTEXT_DISPLAY_SPLIT || this.mSplitView.getVisibility() == 0)) {
            this.mSplitView.setVisibility(CONTEXT_DISPLAY_NORMAL);
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = mode;
        return mode;
    }

    void animateToMode(boolean toActionMode) {
        int i;
        int i2 = 8;
        if (toActionMode) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        ActionBarView actionBarView = this.mActionView;
        if (toActionMode) {
            i = 4;
        } else {
            i = CONTEXT_DISPLAY_NORMAL;
        }
        actionBarView.animateToVisibility(i);
        ActionBarContextView actionBarContextView = this.mContextView;
        if (toActionMode) {
            i = CONTEXT_DISPLAY_NORMAL;
        } else {
            i = 8;
        }
        actionBarContextView.animateToVisibility(i);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (!toActionMode) {
                i2 = CONTEXT_DISPLAY_NORMAL;
            }
            scrollingTabContainerView.setVisibility(i2);
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                tabScroller.setVisibility(CONTEXT_DISPLAY_NORMAL);
                this.mActionView.setEmbeddedTabView(tabScroller);
            } else {
                if (getNavigationMode() == 2) {
                    tabScroller.setVisibility(CONTEXT_DISPLAY_NORMAL);
                } else {
                    tabScroller.setVisibility(8);
                }
                this.mContainerView.setTabContainer(tabScroller);
            }
            this.mTabScrollView = tabScroller;
        }
    }

    private void configureTab(Tab tab, int position) {
        TabImpl tabi = (TabImpl) tab;
        if (tabi.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabi.setPosition(position);
        this.mTabs.add(position, tabi);
        int count = this.mTabs.size();
        for (int i = position + CONTEXT_DISPLAY_SPLIT; i < count; i += CONTEXT_DISPLAY_SPLIT) {
            ((TabImpl) this.mTabs.get(i)).setPosition(i);
        }
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = INVALID_POSITION;
    }

    private static boolean checkShowingFlags(boolean hiddenByApp, boolean hiddenBySystem, boolean showingForMode) {
        if (showingForMode) {
            return true;
        }
        if (hiddenByApp || hiddenBySystem) {
            return false;
        }
        return true;
    }

    private void updateVisibility(boolean fromSystem) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(fromSystem);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(fromSystem);
        }
    }

    public void setShowHideAnimationEnabled(boolean enabled) {
        this.mShowHideAnimationEnabled = enabled;
        if (!enabled) {
            this.mTopVisibilityView.clearAnimation();
            if (this.mSplitView != null) {
                this.mSplitView.clearAnimation();
            }
        }
    }

    public void doShow(boolean fromSystem) {
        this.mTopVisibilityView.clearAnimation();
        if (this.mTopVisibilityView.getVisibility() != 0) {
            boolean animate;
            if (isShowHideAnimationEnabled() || fromSystem) {
                animate = true;
            } else {
                animate = false;
            }
            if (animate) {
                this.mTopVisibilityView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0056R.anim.abc_slide_in_top));
            }
            this.mTopVisibilityView.setVisibility(CONTEXT_DISPLAY_NORMAL);
            if (this.mSplitView != null && this.mSplitView.getVisibility() != 0) {
                if (animate) {
                    this.mSplitView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0056R.anim.abc_slide_in_bottom));
                }
                this.mSplitView.setVisibility(CONTEXT_DISPLAY_NORMAL);
            }
        }
    }

    public void doHide(boolean fromSystem) {
        this.mTopVisibilityView.clearAnimation();
        if (this.mTopVisibilityView.getVisibility() != 8) {
            boolean animate = isShowHideAnimationEnabled() || fromSystem;
            if (animate) {
                this.mTopVisibilityView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0056R.anim.abc_slide_out_top));
            }
            this.mTopVisibilityView.setVisibility(8);
            if (this.mSplitView != null && this.mSplitView.getVisibility() != 8) {
                if (animate) {
                    this.mSplitView.startAnimation(AnimationUtils.loadAnimation(this.mContext, C0056R.anim.abc_slide_out_bottom));
                }
                this.mSplitView.setVisibility(8);
            }
        }
    }

    boolean isShowHideAnimationEnabled() {
        return this.mShowHideAnimationEnabled;
    }
}
