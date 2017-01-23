package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCard;

public class CardHeader extends BaseCard {
    public static int NO_POPUP_MENU;
    protected CustomOverflowAnimation mCustomOverflowAnimation;
    protected boolean mIsButtonExpandVisible;
    protected boolean mIsButtonOverflowVisible;
    protected boolean mIsOtherButtonVisible;
    protected boolean mIsOverflowSelected;
    protected OnClickCardHeaderOtherButtonListener mOtherButtonClickListener;
    protected int mOtherButtonDrawable;
    protected int mPopupMenu;
    protected OnClickCardHeaderPopupMenuListener mPopupMenuListener;
    protected OnPrepareCardHeaderPopupMenuListener mPopupMenuPrepareListener;

    public interface CustomOverflowAnimation {
        void doAnimation(Card card, View view);
    }

    public interface OnClickCardHeaderOtherButtonListener {
        void onButtonItemClick(Card card, View view);
    }

    public interface OnClickCardHeaderPopupMenuListener {
        void onMenuItemClick(BaseCard baseCard, MenuItem menuItem);
    }

    public interface OnClickExpandListener {
        void onButtonExpandClick(BaseCard baseCard, MenuItem menuItem);
    }

    public interface OnPrepareCardHeaderPopupMenuListener {
        boolean onPreparePopupMenu(BaseCard baseCard, PopupMenu popupMenu);
    }

    static {
        NO_POPUP_MENU = -1;
    }

    public CardHeader(Context context) {
        this(context, C0173R.layout.inner_base_header);
    }

    public CardHeader(Context context, int innerLayout) {
        super(context);
        this.mIsButtonExpandVisible = false;
        this.mIsButtonOverflowVisible = false;
        this.mIsOtherButtonVisible = false;
        this.mPopupMenu = NO_POPUP_MENU;
        this.mOtherButtonDrawable = 0;
        this.mCustomOverflowAnimation = null;
        this.mIsOverflowSelected = false;
        this.mInnerLayout = innerLayout;
    }

    public void setPopupMenu(int menuRes, OnClickCardHeaderPopupMenuListener listener, OnPrepareCardHeaderPopupMenuListener prepareListener) {
        this.mPopupMenu = menuRes;
        this.mPopupMenuListener = listener;
        this.mPopupMenuPrepareListener = prepareListener;
        if (menuRes == NO_POPUP_MENU) {
            this.mIsButtonOverflowVisible = false;
        } else {
            this.mIsButtonOverflowVisible = true;
        }
    }

    public void setPopupMenu(int menuRes, OnClickCardHeaderPopupMenuListener listener) {
        setPopupMenu(menuRes, listener, null);
    }

    public CustomOverflowAnimation getCustomOverflowAnimation() {
        return this.mCustomOverflowAnimation;
    }

    public void setCustomOverflowAnimation(CustomOverflowAnimation customAnimation) {
        this.mCustomOverflowAnimation = customAnimation;
        if (this.mCustomOverflowAnimation == null) {
            this.mIsButtonOverflowVisible = false;
        } else {
            this.mIsButtonOverflowVisible = true;
        }
    }

    public boolean isOverflowSelected() {
        return this.mIsOverflowSelected;
    }

    public void setOverflowSelected(boolean isOverflowSelected) {
        this.mIsOverflowSelected = isOverflowSelected;
    }

    public View getInnerView(Context context, ViewGroup parent) {
        View view = super.getInnerView(context, parent);
        if (view != null) {
            parent.addView(view);
            if (this.mInnerLayout > -1) {
                setupInnerViewElements(parent, view);
            }
        }
        return view;
    }

    public void setupInnerViewElements(ViewGroup parent, View view) {
        if (view != null) {
            TextView mTitleView = (TextView) view.findViewById(C0173R.id.card_header_inner_simple_title);
            if (mTitleView != null) {
                mTitleView.setText(this.mTitle);
            }
        }
    }

    public OnClickCardHeaderPopupMenuListener getPopupMenuListener() {
        return this.mPopupMenuListener;
    }

    public OnPrepareCardHeaderPopupMenuListener getPopupMenuPrepareListener() {
        return this.mPopupMenuPrepareListener;
    }

    public void setPopupMenuListener(OnClickCardHeaderPopupMenuListener popupMenuListener) {
        this.mPopupMenuListener = popupMenuListener;
    }

    public void setPopupMenuPrepareListener(OnPrepareCardHeaderPopupMenuListener popupMenuListener) {
        this.mPopupMenuPrepareListener = popupMenuListener;
    }

    public boolean isButtonExpandVisible() {
        return this.mIsButtonExpandVisible;
    }

    public void setButtonExpandVisible(boolean buttonExpandVisible) {
        this.mIsButtonExpandVisible = buttonExpandVisible;
    }

    public boolean isButtonOverflowVisible() {
        return this.mIsButtonOverflowVisible;
    }

    public void setButtonOverflowVisible(boolean buttonOverflowVisible) {
        this.mIsButtonOverflowVisible = buttonOverflowVisible;
    }

    public int getPopupMenu() {
        return this.mPopupMenu;
    }

    public boolean isOtherButtonVisible() {
        if (this.mOtherButtonClickListener != null) {
            return this.mIsOtherButtonVisible;
        }
        if (this.mIsOtherButtonVisible) {
            Log.w("CardHeader", "You set visible=true to other button menu, but you don't add any listener");
        }
        return false;
    }

    public void setOtherButtonVisible(boolean isOtherButtonVisible) {
        this.mIsOtherButtonVisible = isOtherButtonVisible;
    }

    public OnClickCardHeaderOtherButtonListener getOtherButtonClickListener() {
        return this.mOtherButtonClickListener;
    }

    public void setOtherButtonClickListener(OnClickCardHeaderOtherButtonListener otherButtonClickListener) {
        this.mOtherButtonClickListener = otherButtonClickListener;
    }

    public int getOtherButtonDrawable() {
        return this.mOtherButtonDrawable;
    }

    public void setOtherButtonDrawable(int otherButtonDrawable) {
        this.mOtherButtonDrawable = otherButtonDrawable;
    }
}
