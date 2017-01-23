package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.TimeUtils;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.C0056R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.Locale;

public class ListPopupWindow {
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int FILL_PARENT = -1;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private boolean mForceIgnoreOutsideTouch;
    private Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private OnItemClickListener mItemClickListener;
    private OnItemSelectedListener mItemSelectedListener;
    private int mLayoutDirection;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow.1 */
    class C00711 implements Runnable {
        C00711() {
        }

        public void run() {
            View view = ListPopupWindow.this.getAnchorView();
            if (view != null && view.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow.2 */
    class C00722 implements OnItemSelectedListener {
        C00722() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (position != ListPopupWindow.FILL_PARENT) {
                DropDownListView dropDownList = ListPopupWindow.this.mDropDownList;
                if (dropDownList != null) {
                    dropDownList.mListSelectionHidden = ListPopupWindow.DEBUG;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class DropDownListView extends ListView {
        public static final int INVALID_POSITION = -1;
        static final int NO_POSITION = -1;
        private static final String TAG = "ListPopupWindow.DropDownListView";
        private boolean mHijackFocus;
        private boolean mListSelectionHidden;

        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, C0056R.attr.dropDownListViewStyle);
            this.mHijackFocus = hijackFocus;
            setCacheColorHint(ListPopupWindow.POSITION_PROMPT_ABOVE);
        }

        private int lookForSelectablePosition(int position, boolean lookDown) {
            ListAdapter adapter = getAdapter();
            if (adapter == null || isInTouchMode()) {
                return NO_POSITION;
            }
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (lookDown) {
                    position = Math.max(ListPopupWindow.POSITION_PROMPT_ABOVE, position);
                    while (position < count && !adapter.isEnabled(position)) {
                        position += ListPopupWindow.POSITION_PROMPT_BELOW;
                    }
                } else {
                    position = Math.min(position, count + NO_POSITION);
                    while (position >= 0 && !adapter.isEnabled(position)) {
                        position += NO_POSITION;
                    }
                }
                if (position < 0 || position >= count) {
                    return NO_POSITION;
                }
                return position;
            } else if (position < 0 || position >= count) {
                return NO_POSITION;
            } else {
                return position;
            }
        }

        public boolean isInTouchMode() {
            return ((this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean hasWindowFocus() {
            return (this.mHijackFocus || super.hasWindowFocus()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean isFocused() {
            return (this.mHijackFocus || super.isFocused()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean hasFocus() {
            return (this.mHijackFocus || super.hasFocus()) ? true : ListPopupWindow.DEBUG;
        }

        final int measureHeightOfChildrenCompat(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
            int paddingTop = getListPaddingTop();
            int paddingBottom = getListPaddingBottom();
            int paddingLeft = getListPaddingLeft();
            int paddingRight = getListPaddingRight();
            int reportedDividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return paddingTop + paddingBottom;
            }
            int returnedHeight = paddingTop + paddingBottom;
            int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? ListPopupWindow.POSITION_PROMPT_ABOVE : reportedDividerHeight;
            int prevHeightWithoutPartialChild = ListPopupWindow.POSITION_PROMPT_ABOVE;
            View child = null;
            int viewType = ListPopupWindow.POSITION_PROMPT_ABOVE;
            int count = adapter.getCount();
            int i = ListPopupWindow.POSITION_PROMPT_ABOVE;
            while (i < count) {
                int heightMeasureSpec;
                int newType = adapter.getItemViewType(i);
                if (newType != viewType) {
                    child = null;
                    viewType = newType;
                }
                child = adapter.getView(i, child, this);
                LayoutParams childLp = child.getLayoutParams();
                if (childLp == null || childLp.height <= 0) {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(ListPopupWindow.POSITION_PROMPT_ABOVE, ListPopupWindow.POSITION_PROMPT_ABOVE);
                } else {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(childLp.height, 1073741824);
                }
                child.measure(widthMeasureSpec, heightMeasureSpec);
                if (i > 0) {
                    returnedHeight += dividerHeight;
                }
                returnedHeight += child.getMeasuredHeight();
                if (returnedHeight < maxHeight) {
                    if (disallowPartialChildPosition >= 0 && i >= disallowPartialChildPosition) {
                        prevHeightWithoutPartialChild = returnedHeight;
                    }
                    i += ListPopupWindow.POSITION_PROMPT_BELOW;
                } else if (disallowPartialChildPosition < 0 || i <= disallowPartialChildPosition || prevHeightWithoutPartialChild <= 0 || returnedHeight == maxHeight) {
                    return maxHeight;
                } else {
                    return prevHeightWithoutPartialChild;
                }
            }
            return returnedHeight;
        }
    }

    private class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == ListPopupWindow.POSITION_PROMPT_BELOW && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250);
            } else if (action == ListPopupWindow.POSITION_PROMPT_BELOW) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
            }
            return ListPopupWindow.DEBUG;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
                ListPopupWindow.this.show();
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, C0056R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, C0056R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mDropDownHeight = WRAP_CONTENT;
        this.mDropDownWidth = WRAP_CONTENT;
        this.mDropDownAlwaysVisible = DEBUG;
        this.mForceIgnoreOutsideTouch = DEBUG;
        this.mListItemExpandMaximum = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = POSITION_PROMPT_ABOVE;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mPopup = new PopupWindow(context, attrs, defStyleAttr);
        this.mPopup.setInputMethodMode(POSITION_PROMPT_BELOW);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public void setAdapter(ListAdapter adapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            adapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int position) {
        this.mPromptPosition = position;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public void setModal(boolean modal) {
        this.mModal = true;
        this.mPopup.setFocusable(modal);
    }

    public boolean isModal() {
        return this.mModal;
    }

    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        this.mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        this.mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public void setSoftInputMode(int mode) {
        this.mPopup.setSoftInputMode(mode);
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public void setListSelector(Drawable selector) {
        this.mDropDownListHighlight = selector;
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mPopup.setBackgroundDrawable(d);
    }

    public void setAnimationStyle(int animationStyle) {
        this.mPopup.setAnimationStyle(animationStyle);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public void setAnchorView(View anchor) {
        this.mDropDownAnchorView = anchor;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public void setHorizontalOffset(int offset) {
        this.mDropDownHorizontalOffset = offset;
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet) {
            return this.mDropDownVerticalOffset;
        }
        return POSITION_PROMPT_ABOVE;
    }

    public void setVerticalOffset(int offset) {
        this.mDropDownVerticalOffset = offset;
        this.mDropDownVerticalOffsetSet = true;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public void setWidth(int width) {
        this.mDropDownWidth = width;
    }

    public void setContentWidth(int width) {
        Drawable popupBackground = this.mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.mTempRect);
            this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right) + width;
            return;
        }
        setWidth(width);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public void setHeight(int height) {
        this.mDropDownHeight = height;
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.mItemClickListener = clickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener selectedListener) {
        this.mItemSelectedListener = selectedListener;
    }

    public void setPromptView(View prompt) {
        boolean showing = isShowing();
        if (showing) {
            removePromptView();
        }
        this.mPromptView = prompt;
        if (showing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void show() {
        boolean z = true;
        boolean z2 = DEBUG;
        int i = FILL_PARENT;
        int height = buildDropDown();
        int widthSpec = POSITION_PROMPT_ABOVE;
        int heightSpec = POSITION_PROMPT_ABOVE;
        boolean noInputMethod = isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            if (this.mDropDownWidth == FILL_PARENT) {
                widthSpec = FILL_PARENT;
            } else if (this.mDropDownWidth == WRAP_CONTENT) {
                widthSpec = getAnchorView().getWidth();
            } else {
                widthSpec = this.mDropDownWidth;
            }
            if (this.mDropDownHeight == FILL_PARENT) {
                if (noInputMethod) {
                    heightSpec = height;
                } else {
                    heightSpec = FILL_PARENT;
                }
                if (noInputMethod) {
                    PopupWindow popupWindow = this.mPopup;
                    if (this.mDropDownWidth != FILL_PARENT) {
                        i = POSITION_PROMPT_ABOVE;
                    }
                    popupWindow.setWindowLayoutMode(i, POSITION_PROMPT_ABOVE);
                } else {
                    this.mPopup.setWindowLayoutMode(this.mDropDownWidth == FILL_PARENT ? FILL_PARENT : POSITION_PROMPT_ABOVE, FILL_PARENT);
                }
            } else if (this.mDropDownHeight == WRAP_CONTENT) {
                heightSpec = height;
            } else {
                heightSpec = this.mDropDownHeight;
            }
            PopupWindow popupWindow2 = this.mPopup;
            if (!(this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, widthSpec, heightSpec);
            return;
        }
        if (this.mDropDownWidth == FILL_PARENT) {
            widthSpec = FILL_PARENT;
        } else if (this.mDropDownWidth == WRAP_CONTENT) {
            this.mPopup.setWidth(getAnchorView().getWidth());
        } else {
            this.mPopup.setWidth(this.mDropDownWidth);
        }
        if (this.mDropDownHeight == FILL_PARENT) {
            heightSpec = FILL_PARENT;
        } else if (this.mDropDownHeight == WRAP_CONTENT) {
            this.mPopup.setHeight(height);
        } else {
            this.mPopup.setHeight(this.mDropDownHeight);
        }
        this.mPopup.setWindowLayoutMode(widthSpec, heightSpec);
        popupWindow = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            z = DEBUG;
        }
        popupWindow.setOutsideTouchable(z);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        this.mPopup.showAsDropDown(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
        this.mDropDownList.setSelection(FILL_PARENT);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.mPopup.setOnDismissListener(listener);
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    public void setInputMethodMode(int mode) {
        this.mPopup.setInputMethodMode(mode);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public void setSelection(int position) {
        DropDownListView list = this.mDropDownList;
        if (isShowing() && list != null) {
            list.mListSelectionHidden = DEBUG;
            list.setSelection(position);
            if (list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    public void clearListSelection() {
        DropDownListView list = this.mDropDownList;
        if (list != null) {
            list.mListSelectionHidden = true;
            list.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED ? true : DEBUG;
    }

    public boolean performItemClick(int position) {
        if (!isShowing()) {
            return DEBUG;
        }
        if (this.mItemClickListener != null) {
            DropDownListView list = this.mDropDownList;
            int i = position;
            this.mItemClickListener.onItemClick(list, list.getChildAt(position - list.getFirstVisiblePosition()), i, list.getAdapter().getItemId(position));
        }
        return true;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItem();
        }
        return null;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemPosition();
        }
        return FILL_PARENT;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedView();
        }
        return null;
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    void setListItemExpandMax(int max) {
        this.mListItemExpandMaximum = max;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isShowing() && keyCode != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !(keyCode == 66 || keyCode == 23))) {
            boolean below;
            int curIndex = this.mDropDownList.getSelectedItemPosition();
            if (this.mPopup.isAboveAnchor()) {
                below = DEBUG;
            } else {
                below = true;
            }
            ListAdapter adapter = this.mAdapter;
            int firstItem = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int lastItem = ExploreByTouchHelper.INVALID_ID;
            if (adapter != null) {
                boolean allEnabled = adapter.areAllItemsEnabled();
                firstItem = allEnabled ? POSITION_PROMPT_ABOVE : this.mDropDownList.lookForSelectablePosition(POSITION_PROMPT_ABOVE, true);
                if (allEnabled) {
                    lastItem = adapter.getCount() + FILL_PARENT;
                } else {
                    lastItem = this.mDropDownList.lookForSelectablePosition(adapter.getCount() + FILL_PARENT, DEBUG);
                }
            }
            if (!(below && keyCode == 19 && curIndex <= firstItem) && (below || keyCode != 20 || curIndex < lastItem)) {
                this.mDropDownList.mListSelectionHidden = DEBUG;
                if (this.mDropDownList.onKeyDown(keyCode, event)) {
                    this.mPopup.setInputMethodMode(INPUT_METHOD_NOT_NEEDED);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    switch (keyCode) {
                        case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                        case 20:
                        case 23:
                        case 66:
                            return true;
                    }
                } else if (below && keyCode == 20) {
                    if (curIndex == lastItem) {
                        return true;
                    }
                } else if (!below && keyCode == 19 && curIndex == firstItem) {
                    return true;
                }
            }
            clearListSelection();
            this.mPopup.setInputMethodMode(POSITION_PROMPT_BELOW);
            show();
            return true;
        }
        return DEBUG;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return DEBUG;
        }
        boolean consumed = this.mDropDownList.onKeyUp(keyCode, event);
        if (!consumed) {
            return consumed;
        }
        switch (keyCode) {
            case 23:
            case 66:
                dismiss();
                return consumed;
            default:
                return consumed;
        }
    }

    private int buildDropDown() {
        int otherHeights = POSITION_PROMPT_ABOVE;
        ViewGroup dropDownView;
        LinearLayout.LayoutParams hintParams;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new C00711();
            this.mDropDownList = new DropDownListView(context, !this.mModal ? true : DEBUG);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new C00722());
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            dropDownView = this.mDropDownList;
            View hintView = this.mPromptView;
            if (hintView != null) {
                ViewGroup hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(POSITION_PROMPT_BELOW);
                hintParams = new LinearLayout.LayoutParams(FILL_PARENT, POSITION_PROMPT_ABOVE, 1.0f);
                switch (this.mPromptPosition) {
                    case POSITION_PROMPT_ABOVE /*0*/:
                        hintContainer.addView(hintView);
                        hintContainer.addView(dropDownView, hintParams);
                        break;
                    case POSITION_PROMPT_BELOW /*1*/:
                        hintContainer.addView(dropDownView, hintParams);
                        hintContainer.addView(hintView);
                        break;
                    default:
                        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
                        break;
                }
                hintView.measure(MeasureSpec.makeMeasureSpec(this.mDropDownWidth, ExploreByTouchHelper.INVALID_ID), POSITION_PROMPT_ABOVE);
                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = (hintView.getMeasuredHeight() + hintParams.topMargin) + hintParams.bottomMargin;
                dropDownView = hintContainer;
            }
            this.mPopup.setContentView(dropDownView);
        } else {
            dropDownView = (ViewGroup) this.mPopup.getContentView();
            View view = this.mPromptView;
            if (view != null) {
                hintParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = (view.getMeasuredHeight() + hintParams.topMargin) + hintParams.bottomMargin;
            }
        }
        int padding = POSITION_PROMPT_ABOVE;
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            padding = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
        } else {
            this.mTempRect.setEmpty();
        }
        int maxHeight = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, this.mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED ? true : DEBUG);
        if (this.mDropDownAlwaysVisible || this.mDropDownHeight == FILL_PARENT) {
            return maxHeight + padding;
        }
        int childWidthSpec;
        switch (this.mDropDownWidth) {
            case WRAP_CONTENT /*-2*/:
                childWidthSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), ExploreByTouchHelper.INVALID_ID);
                break;
            case FILL_PARENT /*-1*/:
                childWidthSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                break;
            default:
                childWidthSpec = MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
                break;
        }
        int listContent = this.mDropDownList.measureHeightOfChildrenCompat(childWidthSpec, POSITION_PROMPT_ABOVE, FILL_PARENT, maxHeight - otherHeights, FILL_PARENT);
        if (listContent > 0) {
            otherHeights += padding;
        }
        return listContent + otherHeights;
    }

    public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        int[] anchorPos = new int[INPUT_METHOD_NOT_NEEDED];
        anchor.getLocationOnScreen(anchorPos);
        int bottomEdge = displayFrame.bottom;
        if (ignoreBottomDecorations) {
            bottomEdge = anchor.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int returnedHeight = Math.max((bottomEdge - (anchorPos[POSITION_PROMPT_BELOW] + anchor.getHeight())) - yOffset, (anchorPos[POSITION_PROMPT_BELOW] - displayFrame.top) + yOffset);
        if (this.mPopup.getBackground() == null) {
            return returnedHeight;
        }
        this.mPopup.getBackground().getPadding(this.mTempRect);
        return returnedHeight - (this.mTempRect.top + this.mTempRect.bottom);
    }
}
