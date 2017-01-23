package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class MenuPopupHelper implements OnItemClickListener, OnKeyListener, OnGlobalLayoutListener, OnDismissListener, MenuPresenter {
    static final int ITEM_LAYOUT;
    private static final String TAG = "MenuPopupHelper";
    private MenuAdapter mAdapter;
    private View mAnchorView;
    private Context mContext;
    boolean mForceShowIcon;
    private LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private MenuBuilder mMenu;
    private boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private int mPopupMaxWidth;
    private Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    private class MenuAdapter extends BaseAdapter {
        private MenuBuilder mAdapterMenu;
        private int mExpandedIndex;

        public MenuAdapter(MenuBuilder menu) {
            this.mExpandedIndex = -1;
            this.mAdapterMenu = menu;
            findExpandedIndex();
        }

        public int getCount() {
            ArrayList<MenuItemImpl> items = MenuPopupHelper.this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
            if (this.mExpandedIndex < 0) {
                return items.size();
            }
            return items.size() - 1;
        }

        public MenuItemImpl getItem(int position) {
            ArrayList<MenuItemImpl> items = MenuPopupHelper.this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
            if (this.mExpandedIndex >= 0 && position >= this.mExpandedIndex) {
                position++;
            }
            return (MenuItemImpl) items.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = MenuPopupHelper.this.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, parent, false);
            }
            ItemView itemView = (ItemView) convertView;
            if (MenuPopupHelper.this.mForceShowIcon) {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            }
            itemView.initialize(getItem(position), MenuPopupHelper.ITEM_LAYOUT);
            return convertView;
        }

        void findExpandedIndex() {
            MenuItemImpl expandedItem = MenuPopupHelper.this.mMenu.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> items = MenuPopupHelper.this.mMenu.getNonActionItems();
                int count = items.size();
                for (int i = MenuPopupHelper.ITEM_LAYOUT; i < count; i++) {
                    if (((MenuItemImpl) items.get(i)) == expandedItem) {
                        this.mExpandedIndex = i;
                        return;
                    }
                }
            }
            this.mExpandedIndex = -1;
        }

        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }

    static {
        ITEM_LAYOUT = C0056R.layout.abc_popup_menu_item_layout;
    }

    public MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView, boolean overflowOnly) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = menu;
        this.mOverflowOnly = overflowOnly;
        Resources res = context.getResources();
        this.mPopupMaxWidth = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(C0056R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = anchorView;
        menu.addMenuPresenter(this);
    }

    public void setAnchorView(View anchor) {
        this.mAnchorView = anchor;
    }

    public void setForceShowIcon(boolean forceShow) {
        this.mForceShowIcon = forceShow;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        boolean addGlobalListener = false;
        this.mPopup = new ListPopupWindow(this.mContext, null, C0056R.attr.popupMenuStyle);
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mAdapter = new MenuAdapter(this.mMenu);
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.setModal(true);
        View anchor = this.mAnchorView;
        if (anchor == null) {
            return false;
        }
        if (this.mTreeObserver == null) {
            addGlobalListener = true;
        }
        this.mTreeObserver = anchor.getViewTreeObserver();
        if (addGlobalListener) {
            this.mTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.mPopup.setAnchorView(anchor);
        this.mPopup.setContentWidth(Math.min(measureContentWidth(this.mAdapter), this.mPopupMaxWidth));
        this.mPopup.setInputMethodMode(2);
        this.mPopup.show();
        this.mPopup.getListView().setOnKeyListener(this);
        return true;
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void onDismiss() {
        this.mPopup = null;
        this.mMenu.close();
        if (this.mTreeObserver != null) {
            if (!this.mTreeObserver.isAlive()) {
                this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this);
            this.mTreeObserver = null;
        }
    }

    public boolean isShowing() {
        return this.mPopup != null && this.mPopup.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        MenuAdapter adapter = this.mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), ITEM_LAYOUT);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 1 || keyCode != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    private int measureContentWidth(ListAdapter adapter) {
        int width = ITEM_LAYOUT;
        View itemView = null;
        int itemType = ITEM_LAYOUT;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(ITEM_LAYOUT, ITEM_LAYOUT);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(ITEM_LAYOUT, ITEM_LAYOUT);
        int count = adapter.getCount();
        for (int i = ITEM_LAYOUT; i < count; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            if (this.mMeasureParent == null) {
                this.mMeasureParent = new FrameLayout(this.mContext);
            }
            itemView = adapter.getView(i, itemView, this.mMeasureParent);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        return width;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View anchor = this.mAnchorView;
            if (anchor == null || !anchor.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.mPopup.show();
            }
        }
    }

    public void initForMenu(Context context, MenuBuilder menu) {
    }

    public MenuView getMenuView(ViewGroup root) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public void updateMenuView(boolean cleared) {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setCallback(Callback cb) {
        this.mPresenterCallback = cb;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        MenuPopupHelper subPopup = new MenuPopupHelper(this.mContext, subMenu, this.mAnchorView, false);
        subPopup.setCallback(this.mPresenterCallback);
        boolean preserveIconSpacing = false;
        int count = subMenu.size();
        for (int i = ITEM_LAYOUT; i < count; i++) {
            MenuItem childItem = subMenu.getItem(i);
            if (childItem.isVisible() && childItem.getIcon() != null) {
                preserveIconSpacing = true;
                break;
            }
        }
        subPopup.setForceShowIcon(preserveIconSpacing);
        if (!subPopup.tryShow()) {
            return false;
        }
        if (this.mPresenterCallback != null) {
            this.mPresenterCallback.onOpenSubMenu(subMenu);
        }
        return true;
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (menu == this.mMenu) {
            dismiss();
            if (this.mPresenterCallback != null) {
                this.mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    public int getId() {
        return ITEM_LAYOUT;
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable state) {
    }
}
