package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.widget.AdapterViewICS.OnItemClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class SpinnerICS extends AbsSpinnerICS implements OnClickListener {
    private static final int MAX_ITEMS_MEASURED = 15;
    static final int MODE_DIALOG = 0;
    static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "Spinner";
    int mDropDownWidth;
    private int mGravity;
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    private Rect mTempRect;

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            if (adapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) adapter;
            }
        }

        public int getCount() {
            return this.mAdapter == null ? SpinnerICS.MODE_DIALOG : this.mAdapter.getCount();
        }

        public Object getItem(int position) {
            return this.mAdapter == null ? null : this.mAdapter.getItem(position);
        }

        public long getItemId(int position) {
            return this.mAdapter == null ? -1 : this.mAdapter.getItemId(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return this.mAdapter == null ? null : this.mAdapter.getDropDownView(position, convertView, parent);
        }

        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver observer) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(observer);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(observer);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter adapter = this.mListAdapter;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int position) {
            ListAdapter adapter = this.mListAdapter;
            if (adapter != null) {
                return adapter.isEnabled(position);
            }
            return true;
        }

        public int getItemViewType(int position) {
            return SpinnerICS.MODE_DIALOG;
        }

        public int getViewTypeCount() {
            return SpinnerICS.MODE_DROPDOWN;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private interface SpinnerPopup {
        void dismiss();

        CharSequence getHintText();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setPromptText(CharSequence charSequence);

        void show();
    }

    private class DialogPopup implements SpinnerPopup, OnClickListener {
        private ListAdapter mListAdapter;
        private AlertDialog mPopup;
        private CharSequence mPrompt;

        private DialogPopup() {
        }

        public void dismiss() {
            this.mPopup.dismiss();
            this.mPopup = null;
        }

        public boolean isShowing() {
            return this.mPopup != null ? this.mPopup.isShowing() : false;
        }

        public void setAdapter(ListAdapter adapter) {
            this.mListAdapter = adapter;
        }

        public void setPromptText(CharSequence hintText) {
            this.mPrompt = hintText;
        }

        public CharSequence getHintText() {
            return this.mPrompt;
        }

        public void show() {
            Builder builder = new Builder(SpinnerICS.this.getContext());
            if (this.mPrompt != null) {
                builder.setTitle(this.mPrompt);
            }
            this.mPopup = builder.setSingleChoiceItems(this.mListAdapter, SpinnerICS.this.getSelectedItemPosition(), this).show();
        }

        public void onClick(DialogInterface dialog, int which) {
            SpinnerICS.this.setSelection(which);
            if (SpinnerICS.this.mOnItemClickListener != null) {
                SpinnerICS.this.performItemClick(null, which, this.mListAdapter.getItemId(which));
            }
            dismiss();
        }
    }

    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private ListAdapter mAdapter;
        private CharSequence mHintText;

        /* renamed from: android.support.v7.internal.widget.SpinnerICS.DropdownPopup.1 */
        class C02391 implements OnItemClickListener {
            final /* synthetic */ SpinnerICS val$this$0;

            C02391(SpinnerICS spinnerICS) {
                this.val$this$0 = spinnerICS;
            }

            public void onItemClick(AdapterViewICS parent, View v, int position, long id) {
                SpinnerICS.this.setSelection(position);
                if (SpinnerICS.this.mOnItemClickListener != null) {
                    SpinnerICS.this.performItemClick(v, position, DropdownPopup.this.mAdapter.getItemId(position));
                }
                DropdownPopup.this.dismiss();
            }
        }

        public DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, defStyleRes);
            setAnchorView(SpinnerICS.this);
            setModal(true);
            setPromptPosition(SpinnerICS.MODE_DIALOG);
            setOnItemClickListener(new OnItemClickListenerWrapper(new C02391(SpinnerICS.this)));
        }

        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            this.mAdapter = adapter;
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public void setPromptText(CharSequence hintText) {
            this.mHintText = hintText;
        }

        public void show() {
            int spinnerPaddingLeft = SpinnerICS.this.getPaddingLeft();
            int spinnerWidth;
            if (SpinnerICS.this.mDropDownWidth == -2) {
                spinnerWidth = SpinnerICS.this.getWidth();
                setContentWidth(Math.max(SpinnerICS.this.measureContentWidth((SpinnerAdapter) this.mAdapter, getBackground()), (spinnerWidth - spinnerPaddingLeft) - SpinnerICS.this.getPaddingRight()));
            } else if (SpinnerICS.this.mDropDownWidth == SpinnerICS.MODE_THEME) {
                spinnerWidth = SpinnerICS.this.getWidth();
                setContentWidth((spinnerWidth - spinnerPaddingLeft) - SpinnerICS.this.getPaddingRight());
            } else {
                setContentWidth(SpinnerICS.this.mDropDownWidth);
            }
            Drawable background = getBackground();
            int bgOffset = SpinnerICS.MODE_DIALOG;
            if (background != null) {
                background.getPadding(SpinnerICS.this.mTempRect);
                bgOffset = -SpinnerICS.this.mTempRect.left;
            }
            setHorizontalOffset(bgOffset + spinnerPaddingLeft);
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(SpinnerICS.MODE_DROPDOWN);
            setSelection(SpinnerICS.this.getSelectedItemPosition());
        }
    }

    SpinnerICS(Context context) {
        this(context, null);
    }

    SpinnerICS(Context context, int mode) {
        this(context, null, C0056R.attr.spinnerStyle, mode);
    }

    SpinnerICS(Context context, AttributeSet attrs) {
        this(context, attrs, C0056R.attr.spinnerStyle);
    }

    SpinnerICS(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
    }

    SpinnerICS(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        this.mTempRect = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, C0056R.styleable.Spinner, defStyle, MODE_DIALOG);
        if (mode == MODE_THEME) {
            mode = a.getInt(7, MODE_DIALOG);
        }
        switch (mode) {
            case MODE_DIALOG /*0*/:
                this.mPopup = new DialogPopup();
                break;
            case MODE_DROPDOWN /*1*/:
                DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);
                this.mDropDownWidth = a.getLayoutDimension(3, -2);
                popup.setBackgroundDrawable(a.getDrawable(2));
                int verticalOffset = a.getDimensionPixelOffset(5, MODE_DIALOG);
                if (verticalOffset != 0) {
                    popup.setVerticalOffset(verticalOffset);
                }
                int horizontalOffset = a.getDimensionPixelOffset(4, MODE_DIALOG);
                if (horizontalOffset != 0) {
                    popup.setHorizontalOffset(horizontalOffset);
                }
                this.mPopup = popup;
                break;
        }
        this.mGravity = a.getInt(MODE_DIALOG, 17);
        this.mPopup.setPromptText(a.getString(6));
        a.recycle();
        if (this.mTempAdapter != null) {
            this.mPopup.setAdapter(this.mTempAdapter);
            this.mTempAdapter = null;
        }
    }

    public void setGravity(int gravity) {
        if (this.mGravity != gravity) {
            if ((gravity & 7) == 0) {
                gravity |= 3;
            }
            this.mGravity = gravity;
            requestLayout();
        }
    }

    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);
        if (this.mPopup != null) {
            this.mPopup.setAdapter(new DropDownAdapter(adapter));
        } else {
            this.mTempAdapter = new DropDownAdapter(adapter);
        }
    }

    public int getBaseline() {
        View child = null;
        if (getChildCount() > 0) {
            child = getChildAt(MODE_DIALOG);
        } else if (this.mAdapter != null && this.mAdapter.getCount() > 0) {
            child = makeAndAddView(MODE_DIALOG);
            this.mRecycler.put(MODE_DIALOG, child);
            removeAllViewsInLayout();
        }
        if (child == null) {
            return MODE_THEME;
        }
        int childBaseline = child.getBaseline();
        if (childBaseline >= 0) {
            return child.getTop() + childBaseline;
        }
        return MODE_THEME;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    void setOnItemClickListenerInt(OnItemClickListener l) {
        super.setOnItemClickListener(l);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == ExploreByTouchHelper.INVALID_ID) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.mInLayout = true;
        layout(MODE_DIALOG, false);
        this.mInLayout = false;
    }

    void layout(int delta, boolean animate) {
        int childrenLeft = this.mSpinnerPadding.left;
        int childrenWidth = ((getRight() - getLeft()) - this.mSpinnerPadding.left) - this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        removeAllViewsInLayout();
        this.mFirstPosition = this.mSelectedPosition;
        View sel = makeAndAddView(this.mSelectedPosition);
        int width = sel.getMeasuredWidth();
        int selectedOffset = childrenLeft;
        switch (this.mGravity & 7) {
            case MODE_DROPDOWN /*1*/:
                selectedOffset = ((childrenWidth / 2) + childrenLeft) - (width / 2);
                break;
            case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
                selectedOffset = (childrenLeft + childrenWidth) - width;
                break;
        }
        sel.offsetLeftAndRight(selectedOffset);
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
    }

    private View makeAndAddView(int position) {
        View child;
        if (!this.mDataChanged) {
            child = this.mRecycler.get(position);
            if (child != null) {
                setUpChild(child);
                return child;
            }
        }
        child = this.mAdapter.getView(position, null, this);
        setUpChild(child);
        return child;
    }

    private void setUpChild(View child) {
        LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }
        addViewInLayout(child, MODE_DIALOG, lp);
        child.setSelected(hasFocus());
        child.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, lp.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, lp.height));
        int childTop = this.mSpinnerPadding.top + ((((getMeasuredHeight() - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - child.getMeasuredHeight()) / 2);
        child.layout(MODE_DIALOG, childTop, MODE_DIALOG + child.getMeasuredWidth(), childTop + child.getMeasuredHeight());
    }

    public boolean performClick() {
        boolean handled = super.performClick();
        if (!handled) {
            handled = true;
            if (!this.mPopup.isShowing()) {
                this.mPopup.show();
            }
        }
        return handled;
    }

    public void onClick(DialogInterface dialog, int which) {
        setSelection(which);
        dialog.dismiss();
    }

    public void setPrompt(CharSequence prompt) {
        this.mPopup.setPromptText(prompt);
    }

    public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
    }

    public CharSequence getPrompt() {
        return this.mPopup.getHintText();
    }

    int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return MODE_DIALOG;
        }
        int width = MODE_DIALOG;
        View itemView = null;
        int itemType = MODE_DIALOG;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(MODE_DIALOG, MODE_DIALOG);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(MODE_DIALOG, MODE_DIALOG);
        int start = Math.max(MODE_DIALOG, getSelectedItemPosition());
        int end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        for (int i = Math.max(MODE_DIALOG, start - (15 - (end - start))); i < end; i += MODE_DROPDOWN) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        if (background == null) {
            return width;
        }
        background.getPadding(this.mTempRect);
        return width + (this.mTempRect.left + this.mTempRect.right);
    }
}
