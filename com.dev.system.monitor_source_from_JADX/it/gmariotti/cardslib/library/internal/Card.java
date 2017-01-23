package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCard;
import java.util.HashMap;

public class Card extends BaseCard {
    public static final int CLICK_LISTENER_ALL_VIEW = 0;
    public static final int CLICK_LISTENER_CONTENT_VIEW = 10;
    public static final int CLICK_LISTENER_HEADER_VIEW = 2;
    public static final int CLICK_LISTENER_THUMBNAIL_VIEW = 1;
    protected static String TAG;
    private Drawable mBackgroundResource;
    private int mBackgroundResourceId;
    protected CardExpand mCardExpand;
    protected CardHeader mCardHeader;
    protected CardThumbnail mCardThumbnail;
    private boolean mCheckable;
    protected boolean mIsClickable;
    protected boolean mIsExpanded;
    protected boolean mIsLongClickable;
    protected boolean mIsSwipeable;
    protected boolean mMultiChoiceEnabled;
    protected HashMap<Integer, OnCardClickListener> mMultipleOnClickListener;
    protected OnCardClickListener mOnClickListener;
    protected OnCollapseAnimatorEndListener mOnCollapseAnimatorEndListener;
    protected OnExpandAnimatorEndListener mOnExpandAnimatorEndListener;
    protected OnLongCardClickListener mOnLongClickListener;
    protected OnSwipeListener mOnSwipeListener;
    protected OnUndoSwipeListListener mOnUndoSwipeListListener;
    protected boolean mShadow;
    protected ViewToClickToExpand viewToClickToExpand;

    public interface OnCardClickListener {
        void onClick(Card card, View view);
    }

    public interface OnCollapseAnimatorEndListener {
        void onCollapseEnd(Card card);
    }

    public interface OnExpandAnimatorEndListener {
        void onExpandEnd(Card card);
    }

    public interface OnLongCardClickListener {
        boolean onLongClick(Card card, View view);
    }

    public interface OnSwipeListener {
        void onSwipe(Card card);
    }

    public interface OnUndoSwipeListListener {
        void onUndoSwipe(Card card);
    }

    static {
        TAG = "Card";
    }

    public Card(Context context) {
        this(context, C0173R.layout.inner_base_main);
    }

    public Card(Context context, int innerLayout) {
        super(context);
        this.mIsClickable = false;
        this.mIsLongClickable = false;
        this.mIsSwipeable = false;
        this.mShadow = true;
        this.mIsExpanded = false;
        this.mBackgroundResourceId = CLICK_LISTENER_ALL_VIEW;
        this.mBackgroundResource = null;
        this.mCheckable = true;
        this.mMultiChoiceEnabled = false;
        this.viewToClickToExpand = null;
        this.mParentCard = null;
        this.mInnerLayout = innerLayout;
    }

    public View getInnerView(Context context, ViewGroup parent) {
        View view = super.getInnerView(context, parent);
        if (view != null) {
            if (parent != null) {
                parent.addView(view);
            }
            if (this.mInnerLayout > -1) {
                setupInnerViewElements(parent, view);
            }
        }
        return view;
    }

    public void setupInnerViewElements(ViewGroup parent, View view) {
        if (view != null) {
            TextView mTitleView = (TextView) view.findViewById(C0173R.id.card_main_inner_simple_title);
            if (mTitleView != null) {
                mTitleView.setText(this.mTitle);
            }
        }
    }

    public void addCardThumbnail(CardThumbnail cardThumbnail) {
        this.mCardThumbnail = cardThumbnail;
        if (this.mCardThumbnail != null) {
            this.mCardThumbnail.setParentCard(this);
        }
    }

    public CardThumbnail getCardThumbnail() {
        return this.mCardThumbnail;
    }

    public void addCardHeader(CardHeader cardHeader) {
        this.mCardHeader = cardHeader;
        if (this.mCardHeader != null) {
            this.mCardHeader.setParentCard(this);
        }
    }

    public CardHeader getCardHeader() {
        return this.mCardHeader;
    }

    public void addCardExpand(CardExpand cardExpand) {
        this.mCardExpand = cardExpand;
        if (this.mCardExpand != null) {
            this.mCardExpand.setParentCard(this);
        }
    }

    public CardExpand getCardExpand() {
        return this.mCardExpand;
    }

    public void onSwipeCard() {
        if (isSwipeable() && this.mOnSwipeListener != null) {
            this.mOnSwipeListener.onSwipe(this);
        }
    }

    public OnSwipeListener getOnSwipeListener() {
        return this.mOnSwipeListener;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        if (onSwipeListener != null) {
            this.mIsSwipeable = true;
        } else {
            this.mIsSwipeable = false;
        }
        this.mOnSwipeListener = onSwipeListener;
    }

    public void onUndoSwipeListCard() {
        if (isSwipeable() && this.mOnUndoSwipeListListener != null) {
            this.mOnUndoSwipeListListener.onUndoSwipe(this);
        }
    }

    public OnUndoSwipeListListener getOnUndoSwipeListListener() {
        return this.mOnUndoSwipeListListener;
    }

    public void setOnUndoSwipeListListener(OnUndoSwipeListListener onUndoSwipeListListener) {
        this.mOnUndoSwipeListListener = onUndoSwipeListListener;
    }

    public OnCardClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public void setOnClickListener(OnCardClickListener onClickListener) {
        if (onClickListener != null) {
            this.mIsClickable = true;
        } else {
            this.mIsClickable = false;
        }
        this.mOnClickListener = onClickListener;
    }

    public OnLongCardClickListener getOnLongClickListener() {
        return this.mOnLongClickListener;
    }

    public void setOnLongClickListener(OnLongCardClickListener onLongClickListener) {
        if (onLongClickListener != null) {
            this.mIsLongClickable = true;
        } else {
            this.mIsLongClickable = false;
        }
        this.mOnLongClickListener = onLongClickListener;
    }

    public void onExpandEnd() {
        if (this.mOnExpandAnimatorEndListener != null) {
            this.mOnExpandAnimatorEndListener.onExpandEnd(this);
        }
    }

    public OnExpandAnimatorEndListener getOnExpandAnimatorEndListener() {
        return this.mOnExpandAnimatorEndListener;
    }

    public void setOnExpandAnimatorEndListener(OnExpandAnimatorEndListener onExpandAnimatorEndListener) {
        this.mOnExpandAnimatorEndListener = onExpandAnimatorEndListener;
    }

    public void onCollapseEnd() {
        if (this.mOnCollapseAnimatorEndListener != null) {
            this.mOnCollapseAnimatorEndListener.onCollapseEnd(this);
        }
    }

    public OnCollapseAnimatorEndListener getOnCollapseAnimatorEndListener() {
        return this.mOnCollapseAnimatorEndListener;
    }

    public void setOnCollapseAnimatorEndListener(OnCollapseAnimatorEndListener onCollapseAnimatorEndListener) {
        this.mOnCollapseAnimatorEndListener = onCollapseAnimatorEndListener;
    }

    public boolean hasHeader() {
        if (getCardHeader() != null) {
            return true;
        }
        return false;
    }

    public boolean isShadow() {
        return this.mShadow;
    }

    public void setShadow(boolean shadow) {
        this.mShadow = shadow;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public boolean isClickable() {
        if (!this.mIsClickable || this.mOnClickListener != null || (this.mMultipleOnClickListener != null && !this.mMultipleOnClickListener.isEmpty())) {
            return this.mIsClickable;
        }
        Log.w(TAG, "Clickable set to true without onClickListener");
        return false;
    }

    public void setClickable(boolean isClickable) {
        this.mIsClickable = isClickable;
    }

    public boolean isSwipeable() {
        return this.mIsSwipeable;
    }

    public void setSwipeable(boolean isSwipeable) {
        this.mIsSwipeable = isSwipeable;
    }

    public boolean isLongClickable() {
        if (this.mOnLongClickListener != null) {
            return this.mIsLongClickable;
        }
        if (this.mIsLongClickable) {
            Log.w(TAG, "LongClickable set to true without onLongClickListener");
        }
        return false;
    }

    public void setLongClickable(boolean isLongClickable) {
        this.mIsLongClickable = isLongClickable;
    }

    public void addPartialOnClickListener(int area, OnCardClickListener onClickListener) {
        if (area < 0 && area > CLICK_LISTENER_CONTENT_VIEW) {
            Log.w(TAG, "area value not valid in addPartialOnClickListner");
        }
        HashMap multipleOnClickListener = getMultipleOnClickListener();
        if (onClickListener != null) {
            multipleOnClickListener.put(Integer.valueOf(area), onClickListener);
            this.mIsClickable = true;
            return;
        }
        removePartialOnClickListener(area);
    }

    public void removePartialOnClickListener(int area) {
        HashMap multipleOnClickListener = getMultipleOnClickListener();
        multipleOnClickListener.remove(Integer.valueOf(area));
        if (this.mOnClickListener == null && multipleOnClickListener.isEmpty()) {
            this.mIsClickable = false;
        }
    }

    public HashMap<Integer, OnCardClickListener> getMultipleOnClickListener() {
        if (this.mMultipleOnClickListener != null) {
            return this.mMultipleOnClickListener;
        }
        HashMap<Integer, OnCardClickListener> hashMap = new HashMap();
        this.mMultipleOnClickListener = hashMap;
        return hashMap;
    }

    public boolean isExpanded() {
        return this.mIsExpanded;
    }

    public void setExpanded(boolean expanded) {
        this.mIsExpanded = expanded;
    }

    public static boolean equalsInnerLayout(Card oldCard, Card newCard) {
        if (oldCard == null || newCard == null) {
            return false;
        }
        if (oldCard.getInnerLayout() != newCard.getInnerLayout()) {
            return true;
        }
        if (oldCard.getCardHeader() != null) {
            if (newCard.getCardHeader() == null || oldCard.getCardHeader().getInnerLayout() != newCard.getCardHeader().getInnerLayout()) {
                return true;
            }
        } else if (newCard.getCardHeader() != null) {
            return true;
        }
        if (oldCard.getCardThumbnail() != null) {
            if (newCard.getCardThumbnail() == null || oldCard.getCardThumbnail().getInnerLayout() != newCard.getCardThumbnail().getInnerLayout()) {
                return true;
            }
        } else if (newCard.getCardThumbnail() != null) {
            return true;
        }
        if (oldCard.getCardExpand() != null) {
            if (newCard.getCardExpand() == null || oldCard.getCardExpand().getInnerLayout() != newCard.getCardExpand().getInnerLayout()) {
                return true;
            }
        } else if (newCard.getCardExpand() != null) {
            return true;
        }
        return false;
    }

    public void setBackgroundResourceId(int drawableResourceId) {
        this.mBackgroundResourceId = drawableResourceId;
    }

    public int getBackgroundResourceId() {
        return this.mBackgroundResourceId;
    }

    public Drawable getBackgroundResource() {
        return this.mBackgroundResource;
    }

    public void setBackgroundResource(Drawable drawableResource) {
        this.mBackgroundResource = drawableResource;
    }

    public void changeBackgroundResourceId(int drawableResourceId) {
        if (this.mCardView != null) {
            this.mCardView.changeBackgroundResourceId(drawableResourceId);
        }
    }

    public void changeBackgroundResource(Drawable drawableResource) {
        if (this.mCardView != null) {
            this.mCardView.changeBackgroundResource(drawableResource);
        }
    }

    public boolean isCheckable() {
        return this.mCheckable;
    }

    public void setCheckable(boolean checkable) {
        this.mCheckable = checkable;
    }

    public boolean isMultiChoiceEnabled() {
        return this.mMultiChoiceEnabled;
    }

    public ViewToClickToExpand getViewToClickToExpand() {
        return this.viewToClickToExpand;
    }

    public void setViewToClickToExpand(ViewToClickToExpand viewToClickToExpand) {
        this.viewToClickToExpand = viewToClickToExpand;
    }
}
