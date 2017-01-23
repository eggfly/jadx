package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.view.menu.ActionMenuView.ActionMenuChildView;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.widget.CompatTextView;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import java.util.Locale;

public class ActionMenuItemView extends CompatTextView implements ItemView, OnClickListener, OnLongClickListener, ActionMenuChildView {
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private Drawable mIcon;
    private MenuItemImpl mItemData;
    private ItemInvoker mItemInvoker;
    private int mMinWidth;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    private class AllCapsTransformationMethod implements TransformationMethod {
        private Locale mLocale;

        public AllCapsTransformationMethod() {
            this.mLocale = ActionMenuItemView.this.getContext().getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence source, View view) {
            return source != null ? source.toString().toUpperCase(this.mLocale) : null;
        }

        public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {
        }
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mAllowTextWithIcon = context.getResources().getBoolean(C0056R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs, C0056R.styleable.ActionMenuItemView, 0, 0);
        this.mMinWidth = a.getDimensionPixelSize(0, 0);
        a.recycle();
        setOnClickListener(this);
        setOnLongClickListener(this);
        setTransformationMethod(new AllCapsTransformationMethod());
        this.mSavedPaddingLeft = -1;
    }

    public void setPadding(int l, int t, int r, int b) {
        this.mSavedPaddingLeft = l;
        super.setPadding(l, t, r, b);
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public void initialize(MenuItemImpl itemData, int menuType) {
        this.mItemData = itemData;
        setIcon(itemData.getIcon());
        setTitle(itemData.getTitleForItemView(this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? 0 : 8);
        setEnabled(itemData.isEnabled());
    }

    public void onClick(View v) {
        if (this.mItemInvoker != null) {
            this.mItemInvoker.invokeItem(this.mItemData);
        }
    }

    public void setItemInvoker(ItemInvoker invoker) {
        this.mItemInvoker = invoker;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean checkable) {
    }

    public void setChecked(boolean checked) {
    }

    public void setExpandedFormat(boolean expandedFormat) {
        if (this.mExpandedFormat != expandedFormat) {
            this.mExpandedFormat = expandedFormat;
            if (this.mItemData != null) {
                this.mItemData.actionFormatChanged();
            }
        }
    }

    private void updateTextButtonVisibility() {
        boolean visible;
        int i = 0;
        if (TextUtils.isEmpty(this.mTitle)) {
            visible = false;
        } else {
            visible = true;
        }
        if (this.mIcon == null || (this.mItemData.showsTextAsAction() && (this.mAllowTextWithIcon || this.mExpandedFormat))) {
            i = 1;
        }
        setText(visible & i ? this.mTitle : null);
    }

    public void setIcon(Drawable icon) {
        this.mIcon = icon;
        setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        updateTextButtonVisibility();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setShortcut(boolean showShortcut, char shortcutKey) {
    }

    public void setTitle(CharSequence title) {
        this.mTitle = title;
        setContentDescription(this.mTitle);
        updateTextButtonVisibility();
    }

    public boolean showsIcon() {
        return true;
    }

    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean onLongClick(View v) {
        if (hasText()) {
            return false;
        }
        int[] screenPos = new int[2];
        Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int midy = screenPos[1] + (height / 2);
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        Toast cheatSheet = Toast.makeText(context, this.mItemData.getTitle(), 0);
        if (midy < displayFrame.height()) {
            cheatSheet.setGravity(53, (screenWidth - screenPos[0]) - (width / 2), height);
        } else {
            cheatSheet.setGravity(81, 0, height);
        }
        cheatSheet.show();
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean textVisible = hasText();
        if (textVisible && this.mSavedPaddingLeft >= 0) {
            super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth = getMeasuredWidth();
        int targetWidth = widthMode == ExploreByTouchHelper.INVALID_ID ? Math.min(widthSize, this.mMinWidth) : this.mMinWidth;
        if (widthMode != 1073741824 && this.mMinWidth > 0 && oldMeasuredWidth < targetWidth) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), heightMeasureSpec);
        }
        if (!textVisible && this.mIcon != null) {
            super.setPadding((getMeasuredWidth() - this.mIcon.getIntrinsicWidth()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
