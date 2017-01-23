package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuView.ActionMenuChildView;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import java.util.ArrayList;

public class ActionMenuPresenter extends BaseMenuPresenter implements SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private OverflowPopup mOverflowPopup;
    final PopupPresenterCallback mPopupPresenterCallback;
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    private class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup popup) {
            this.mPopup = popup;
        }

        public void run() {
            ActionMenuPresenter.this.mMenu.changeMenuMode();
            View menuView = ActionMenuPresenter.this.mMenuView;
            if (!(menuView == null || menuView.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        public int openSubMenuId;

        /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.SavedState.1 */
        static class C00581 implements Creator<SavedState> {
            C00581() {
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        SavedState() {
        }

        SavedState(Parcel in) {
            this.openSubMenuId = in.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.openSubMenuId);
        }

        static {
            CREATOR = new C00581();
        }
    }

    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, C0056R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean needsDividerAfter() {
            return false;
        }
    }

    private class PopupPresenterCallback implements Callback {
        private PopupPresenterCallback() {
        }

        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (subMenu != null) {
                ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            if (menu instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menu).getRootMenu().close(false);
            }
        }
    }

    private class ActionButtonSubmenu extends MenuDialogHelper {
        public ActionButtonSubmenu(SubMenuBuilder subMenu) {
            super(subMenu);
            ActionMenuPresenter.this.setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        public void onDismiss(DialogInterface dialog) {
            super.onDismiss(dialog);
            ActionMenuPresenter.this.mActionButtonPopup = null;
            ActionMenuPresenter.this.mOpenSubMenuId = 0;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menu, View anchorView, boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly);
            setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        public void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter.this.mMenu.close();
            ActionMenuPresenter.this.mOverflowPopup = null;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0056R.layout.abc_action_menu_layout, C0056R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback();
    }

    public void initForMenu(Context context, MenuBuilder menu) {
        super.initForMenu(context, menu);
        Resources res = context.getResources();
        ActionBarPolicy abp = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = abp.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = abp.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = abp.getMaxActionButtons();
        }
        int width = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                int spec = MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(spec, spec);
            }
            width -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = width;
        this.mMinCellSize = (int) (56.0f * res.getDisplayMetrics().density);
        this.mScrapActionButtonView = null;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = this.mContext.getResources().getInteger(C0056R.integer.abc_max_action_buttons);
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }

    public void setWidthLimit(int width, boolean strict) {
        this.mWidthLimit = width;
        this.mStrictWidthLimit = strict;
        this.mWidthLimitSet = true;
    }

    public void setReserveOverflow(boolean reserveOverflow) {
        this.mReserveOverflow = reserveOverflow;
        this.mReserveOverflowSet = true;
    }

    public void setItemLimit(int itemCount) {
        this.mMaxItems = itemCount;
        this.mMaxItemsSet = true;
    }

    public void setExpandedActionViewsExclusive(boolean isExclusive) {
        this.mExpandedActionViewsExclusive = isExclusive;
    }

    public MenuView getMenuView(ViewGroup root) {
        MenuView result = super.getMenuView(root);
        ((ActionMenuView) result).setPresenter(this);
        return result;
    }

    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        View actionView = item.getActionView();
        if (actionView == null || item.hasCollapsibleActionView()) {
            if (!(convertView instanceof ActionMenuItemView)) {
                convertView = null;
            }
            actionView = super.getItemView(item, convertView, parent);
        }
        actionView.setVisibility(item.isActionViewExpanded() ? 8 : 0);
        ActionMenuView menuParent = (ActionMenuView) parent;
        LayoutParams lp = actionView.getLayoutParams();
        if (!menuParent.checkLayoutParams(lp)) {
            actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
        }
        return actionView;
    }

    public void bindItemView(MenuItemImpl item, ItemView itemView) {
        itemView.initialize(item, 0);
        ((ActionMenuItemView) itemView).setItemInvoker(this.mMenuView);
    }

    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        return item.isActionButton();
    }

    public void updateMenuView(boolean cleared) {
        super.updateMenuView(cleared);
        if (this.mMenuView != null) {
            int count;
            if (this.mMenu != null) {
                ArrayList<MenuItemImpl> actionItems = this.mMenu.getActionItems();
                count = actionItems.size();
                for (int i = 0; i < count; i++) {
                    ActionProvider provider = ((MenuItemImpl) actionItems.get(i)).getSupportActionProvider();
                    if (provider != null) {
                        provider.setSubUiVisibilityListener(this);
                    }
                }
            }
            ArrayList<MenuItemImpl> nonActionItems = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
            boolean hasOverflow = false;
            if (this.mReserveOverflow && nonActionItems != null) {
                count = nonActionItems.size();
                hasOverflow = count == 1 ? !((MenuItemImpl) nonActionItems.get(0)).isActionViewExpanded() : count > 0;
            }
            if (hasOverflow) {
                if (this.mOverflowButton == null) {
                    this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                }
                ViewGroup parent = (ViewGroup) this.mOverflowButton.getParent();
                if (parent != this.mMenuView) {
                    if (parent != null) {
                        parent.removeView(this.mOverflowButton);
                    }
                    ActionMenuView menuView = this.mMenuView;
                    menuView.addView(this.mOverflowButton, menuView.generateOverflowButtonLayoutParams());
                }
            } else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
                ((ViewGroup) this.mMenuView).removeView(this.mOverflowButton);
            }
            ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        }
    }

    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(parent, childIndex);
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder topSubMenu = subMenu;
        while (topSubMenu.getParentMenu() != this.mMenu) {
            topSubMenu = (SubMenuBuilder) topSubMenu.getParentMenu();
        }
        if (findViewForItem(topSubMenu.getItem()) == null) {
            if (this.mOverflowButton == null) {
                return false;
            }
            View anchor = this.mOverflowButton;
        }
        this.mOpenSubMenuId = subMenu.getItem().getItemId();
        this.mActionButtonPopup = new ActionButtonSubmenu(subMenu);
        this.mActionButtonPopup.show(null);
        super.onSubMenuSelected(subMenu);
        return true;
    }

    private View findViewForItem(MenuItem item) {
        ViewGroup parent = this.mMenuView;
        if (parent == null) {
            return null;
        }
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            if ((child instanceof ItemView) && ((ItemView) child).getItemData() == item) {
                return child;
            }
        }
        return null;
    }

    public boolean showOverflowMenu() {
        if (!this.mReserveOverflow || isOverflowMenuShowing() || this.mMenu == null || this.mMenuView == null || this.mPostedOpenRunnable != null) {
            return false;
        }
        this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        ((View) this.mMenuView).post(this.mPostedOpenRunnable);
        super.onSubMenuSelected(null);
        return true;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable == null || this.mMenuView == null) {
            MenuPopupHelper popup = this.mOverflowPopup;
            if (popup == null) {
                return false;
            }
            popup.dismiss();
            return true;
        }
        ((View) this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean hideSubMenus() {
        if (this.mActionButtonPopup == null) {
            return false;
        }
        this.mActionButtonPopup.dismiss();
        return true;
    }

    public boolean isOverflowMenuShowing() {
        return this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public boolean flagActionItems() {
        int i;
        ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        int itemsSize = visibleItems.size();
        int maxActions = this.mMaxItems;
        int widthLimit = this.mActionItemWidthLimit;
        int querySpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup parent = (ViewGroup) this.mMenuView;
        int requiredItems = 0;
        int requestedItems = 0;
        int firstActionWidth = 0;
        boolean hasOverflow = false;
        for (i = 0; i < itemsSize; i++) {
            MenuItemImpl item = (MenuItemImpl) visibleItems.get(i);
            if (item.requiresActionButton()) {
                requiredItems++;
            } else if (item.requestsActionButton()) {
                requestedItems++;
            } else {
                hasOverflow = true;
            }
            if (this.mExpandedActionViewsExclusive && item.isActionViewExpanded()) {
                maxActions = 0;
            }
        }
        if (this.mReserveOverflow && (hasOverflow || requiredItems + requestedItems > maxActions)) {
            maxActions--;
        }
        maxActions -= requiredItems;
        SparseBooleanArray seenGroups = this.mActionButtonGroups;
        seenGroups.clear();
        int cellSize = 0;
        int cellsRemaining = 0;
        if (this.mStrictWidthLimit) {
            cellsRemaining = widthLimit / this.mMinCellSize;
            cellSize = this.mMinCellSize + ((widthLimit % this.mMinCellSize) / cellsRemaining);
        }
        for (i = 0; i < itemsSize; i++) {
            item = (MenuItemImpl) visibleItems.get(i);
            View v;
            int measuredWidth;
            int groupId;
            if (item.requiresActionButton()) {
                v = getItemView(item, this.mScrapActionButtonView, parent);
                if (this.mScrapActionButtonView == null) {
                    this.mScrapActionButtonView = v;
                }
                if (this.mStrictWidthLimit) {
                    cellsRemaining -= ActionMenuView.measureChildForCells(v, cellSize, cellsRemaining, querySpec, 0);
                } else {
                    v.measure(querySpec, querySpec);
                }
                measuredWidth = v.getMeasuredWidth();
                widthLimit -= measuredWidth;
                if (firstActionWidth == 0) {
                    firstActionWidth = measuredWidth;
                }
                groupId = item.getGroupId();
                if (groupId != 0) {
                    seenGroups.put(groupId, true);
                }
                item.setIsActionButton(true);
            } else if (item.requestsActionButton()) {
                groupId = item.getGroupId();
                boolean inGroup = seenGroups.get(groupId);
                boolean isAction = (maxActions > 0 || inGroup) && widthLimit > 0 && (!this.mStrictWidthLimit || cellsRemaining > 0);
                if (isAction) {
                    v = getItemView(item, this.mScrapActionButtonView, parent);
                    if (this.mScrapActionButtonView == null) {
                        this.mScrapActionButtonView = v;
                    }
                    if (this.mStrictWidthLimit) {
                        int cells = ActionMenuView.measureChildForCells(v, cellSize, cellsRemaining, querySpec, 0);
                        cellsRemaining -= cells;
                        if (cells == 0) {
                            isAction = false;
                        }
                    } else {
                        v.measure(querySpec, querySpec);
                    }
                    measuredWidth = v.getMeasuredWidth();
                    widthLimit -= measuredWidth;
                    if (firstActionWidth == 0) {
                        firstActionWidth = measuredWidth;
                    }
                    if (this.mStrictWidthLimit) {
                        isAction &= widthLimit >= 0 ? 1 : 0;
                    } else {
                        isAction &= widthLimit + firstActionWidth > 0 ? 1 : 0;
                    }
                }
                if (isAction && groupId != 0) {
                    seenGroups.put(groupId, true);
                } else if (inGroup) {
                    seenGroups.put(groupId, false);
                    for (int j = 0; j < i; j++) {
                        MenuItemImpl areYouMyGroupie = (MenuItemImpl) visibleItems.get(j);
                        if (areYouMyGroupie.getGroupId() == groupId) {
                            if (areYouMyGroupie.isActionButton()) {
                                maxActions++;
                            }
                            areYouMyGroupie.setIsActionButton(false);
                        }
                    }
                }
                if (isAction) {
                    maxActions--;
                }
                item.setIsActionButton(isAction);
            }
        }
        return true;
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        dismissPopupMenus();
        super.onCloseMenu(menu, allMenusAreClosing);
    }

    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState();
        state.openSubMenuId = this.mOpenSubMenuId;
        return state;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState saved = (SavedState) state;
        if (saved.openSubMenuId > 0) {
            MenuItem item = this.mMenu.findItem(saved.openSubMenuId);
            if (item != null) {
                onSubMenuSelected((SubMenuBuilder) item.getSubMenu());
            }
        }
    }

    public void onSubUiVisibilityChanged(boolean isVisible) {
        if (isVisible) {
            super.onSubMenuSelected(null);
        } else {
            this.mMenu.close(false);
        }
    }
}
