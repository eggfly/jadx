package it.gmariotti.cardslib.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.base.CardViewInterface;
import it.gmariotti.cardslib.library.view.component.CardHeaderView;
import it.gmariotti.cardslib.library.view.component.CardShadowView;
import it.gmariotti.cardslib.library.view.component.CardThumbnailView;

public class BaseCardView extends LinearLayout implements CardViewInterface {
    protected static String TAG;
    protected int card_layout_resourceID;
    protected Card mCard;
    protected boolean mForceReplaceInnerLayout;
    protected CardHeaderView mInternalHeaderLayout;
    protected View mInternalOuterView;
    protected CardShadowView mInternalShadowLayout;
    protected CardThumbnailView mInternalThumbnailLayout;
    protected boolean mIsRecycle;

    static {
        TAG = "BaseCardView";
    }

    public BaseCardView(Context context) {
        super(context);
        this.card_layout_resourceID = C0173R.layout.card_base_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        init(null, 0);
    }

    public BaseCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.card_layout_resourceID = C0173R.layout.card_base_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        init(attrs, 0);
    }

    public BaseCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.card_layout_resourceID = C0173R.layout.card_base_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {
        initAttrs(attrs, defStyle);
        if (!isInEditMode()) {
            initView();
        }
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, C0173R.styleable.card_options, defStyle, defStyle);
        try {
            this.card_layout_resourceID = a.getResourceId(C0173R.styleable.card_options_card_layout_resourceID, this.card_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    protected void initView() {
        this.mInternalOuterView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.card_layout_resourceID, this, true);
    }

    public void setCard(Card card) {
        this.mCard = card;
    }

    protected void buildUI() {
        if (this.mCard == null) {
            Log.e(TAG, "No card model found. Please use setCard(card) to set all values.");
        } else {
            setupShadowView();
        }
    }

    protected void setupShadowView() {
        if (this.mInternalShadowLayout != null && this.mCard != null) {
            if (this.mCard.isShadow()) {
                this.mInternalShadowLayout.setVisibility(0);
            } else {
                this.mInternalShadowLayout.setVisibility(8);
            }
        }
    }

    protected void retrieveLayoutIDs() {
        this.mInternalShadowLayout = (CardShadowView) findViewById(C0173R.id.card_shadow_layout);
    }

    public View getInternalOuterView() {
        return this.mInternalOuterView;
    }

    public Card getCard() {
        return this.mCard;
    }

    public CardShadowView getInternalShadowLayout() {
        return this.mInternalShadowLayout;
    }

    public CardHeaderView getInternalHeaderLayout() {
        return this.mInternalHeaderLayout;
    }

    public CardThumbnailView getInternalThumbnailLayout() {
        return this.mInternalThumbnailLayout;
    }

    public boolean isRecycle() {
        return this.mIsRecycle;
    }

    public void setRecycle(boolean isRecycle) {
        this.mIsRecycle = isRecycle;
    }

    public boolean isForceReplaceInnerLayout() {
        return this.mForceReplaceInnerLayout;
    }

    public void setForceReplaceInnerLayout(boolean forceReplaceInnerLayout) {
        this.mForceReplaceInnerLayout = forceReplaceInnerLayout;
    }
}
