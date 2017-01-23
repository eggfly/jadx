package it.gmariotti.cardslib.library.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.media.TransportMediator;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand.CardElementUI;
import it.gmariotti.cardslib.library.view.component.CardHeaderView;
import it.gmariotti.cardslib.library.view.component.CardThumbnailView;
import it.gmariotti.cardslib.library.view.listener.SwipeDismissViewTouchListener;
import it.gmariotti.cardslib.library.view.listener.SwipeDismissViewTouchListener.DismissCallbacks;
import java.util.HashMap;

public class CardView extends BaseCardView {
    protected CardExpand mCardExpand;
    protected CardHeader mCardHeader;
    protected CardThumbnail mCardThumbnail;
    protected Animator mExpandAnimator;
    protected View mInternalContentLayout;
    protected View mInternalExpandInnerView;
    protected View mInternalExpandLayout;
    protected View mInternalInnerView;
    protected View mInternalMainCardLayout;
    protected OnExpandListAnimatorListener mOnExpandListAnimatorListener;

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.1 */
    class C01931 implements OnPreDrawListener {
        C01931() {
        }

        public boolean onPreDraw() {
            CardView.this.mInternalExpandLayout.getViewTreeObserver().removeOnPreDrawListener(this);
            View parent = (View) CardView.this.mInternalExpandLayout.getParent();
            CardView.this.mInternalExpandLayout.measure(MeasureSpec.makeMeasureSpec((parent.getMeasuredWidth() - parent.getPaddingLeft()) - parent.getPaddingRight(), ExploreByTouchHelper.INVALID_ID), MeasureSpec.makeMeasureSpec(0, 0));
            CardView.this.mExpandAnimator = CardView.this.createSlideAnimator(0, CardView.this.mInternalExpandLayout.getMeasuredHeight());
            return true;
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.3 */
    class C01943 implements OnClickListener {
        C01943() {
        }

        public void onClick(View v) {
            if (CardView.this.mCard.getOnClickListener() != null) {
                CardView.this.mCard.getOnClickListener().onClick(CardView.this.mCard, v);
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.4 */
    class C01954 implements OnClickListener {
        final /* synthetic */ OnCardClickListener val$mListener;

        C01954(OnCardClickListener onCardClickListener) {
            this.val$mListener = onCardClickListener;
        }

        public void onClick(View v) {
            if (this.val$mListener != null) {
                this.val$mListener.onClick(CardView.this.mCard, v);
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.5 */
    class C01965 implements OnLongClickListener {
        C01965() {
        }

        public boolean onLongClick(View v) {
            if (CardView.this.mCard.getOnLongClickListener() != null) {
                return CardView.this.mCard.getOnLongClickListener().onLongClick(CardView.this.mCard, v);
            }
            return false;
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.6 */
    class C01976 implements AnimatorUpdateListener {
        C01976() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LayoutParams layoutParams = CardView.this.mInternalExpandLayout.getLayoutParams();
            layoutParams.height = value;
            CardView.this.mInternalExpandLayout.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.7 */
    static /* synthetic */ class C01987 {
        static final /* synthetic */ int[] f11x4707618c;

        static {
            f11x4707618c = new int[CardElementUI.values().length];
            try {
                f11x4707618c[CardElementUI.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11x4707618c[CardElementUI.HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11x4707618c[CardElementUI.THUMBNAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11x4707618c[CardElementUI.MAIN_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public interface OnExpandListAnimatorListener {
        void onCollapseStart(CardView cardView, View view);

        void onExpandStart(CardView cardView, View view);
    }

    protected class TitleViewOnClickListener implements OnClickListener {
        private Card mCard;
        private View mContentParent;
        private boolean viewToSelect;

        /* renamed from: it.gmariotti.cardslib.library.view.CardView.TitleViewOnClickListener.1 */
        class C01991 extends AnimatorListenerAdapter {
            C01991() {
            }

            public void onAnimationEnd(Animator animation) {
                TitleViewOnClickListener.this.mCard.setExpanded(true);
                if (TitleViewOnClickListener.this.mCard.getOnExpandAnimatorEndListener() != null) {
                    TitleViewOnClickListener.this.mCard.getOnExpandAnimatorEndListener().onExpandEnd(TitleViewOnClickListener.this.mCard);
                }
            }
        }

        /* renamed from: it.gmariotti.cardslib.library.view.CardView.TitleViewOnClickListener.2 */
        class C02002 implements AnimatorListener {
            C02002() {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                TitleViewOnClickListener.this.mContentParent.setVisibility(8);
                TitleViewOnClickListener.this.mCard.setExpanded(false);
                if (TitleViewOnClickListener.this.mCard.getOnCollapseAnimatorEndListener() != null) {
                    TitleViewOnClickListener.this.mCard.getOnCollapseAnimatorEndListener().onCollapseEnd(TitleViewOnClickListener.this.mCard);
                }
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        }

        private TitleViewOnClickListener(CardView this$0, View contentParent, Card card) {
            this(contentParent, card, true);
        }

        private TitleViewOnClickListener(View contentParent, Card card, boolean viewToSelect) {
            this.viewToSelect = true;
            this.mContentParent = contentParent;
            this.mCard = card;
            this.viewToSelect = viewToSelect;
        }

        public void onClick(View view) {
            boolean isVisible;
            if (this.mContentParent.getVisibility() == 0) {
                isVisible = true;
            } else {
                isVisible = false;
            }
            if (isVisible) {
                animateCollapsing();
                if (this.viewToSelect) {
                    view.setSelected(false);
                    return;
                }
                return;
            }
            animateExpanding();
            if (this.viewToSelect) {
                view.setSelected(true);
            }
        }

        private void animateExpanding() {
            if (CardView.this.getOnExpandListAnimatorListener() != null) {
                CardView.this.getOnExpandListAnimatorListener().onExpandStart(this.mCard.getCardView(), this.mContentParent);
                return;
            }
            this.mContentParent.setVisibility(0);
            CardView.this.mExpandAnimator.addListener(new C01991());
            CardView.this.mExpandAnimator.start();
        }

        private void animateCollapsing() {
            if (CardView.this.getOnExpandListAnimatorListener() != null) {
                CardView.this.getOnExpandListAnimatorListener().onCollapseStart(this.mCard.getCardView(), this.mContentParent);
                return;
            }
            ValueAnimator animator = CardView.this.createSlideAnimator(this.mContentParent.getHeight(), 0);
            animator.addListener(new C02002());
            animator.start();
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.CardView.2 */
    class C02522 implements DismissCallbacks {
        C02522() {
        }

        public boolean canDismiss(Card card) {
            return card.isSwipeable();
        }

        public void onDismiss(CardView cardView, Card card) {
            ViewGroup vg = (ViewGroup) cardView.getParent();
            if (vg != null) {
                vg.removeView(cardView);
                card.onSwipeCard();
            }
        }
    }

    public CardView(Context context) {
        super(context);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        this.card_layout_resourceID = C0173R.layout.card_layout;
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, C0173R.styleable.card_options, defStyle, defStyle);
        try {
            this.card_layout_resourceID = a.getResourceId(C0173R.styleable.card_options_card_layout_resourceID, this.card_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    public void setCard(Card card) {
        super.setCard(card);
        if (card != null) {
            this.mCardHeader = card.getCardHeader();
            this.mCardThumbnail = card.getCardThumbnail();
            this.mCardExpand = card.getCardExpand();
        }
        if (!isRecycle()) {
            retrieveLayoutIDs();
        }
        buildUI();
    }

    public void refreshCard(Card card) {
        this.mIsRecycle = true;
        setCard(card);
        this.mIsRecycle = false;
    }

    public void replaceCard(Card card) {
        this.mForceReplaceInnerLayout = true;
        refreshCard(card);
        this.mForceReplaceInnerLayout = false;
    }

    protected void buildUI() {
        super.buildUI();
        this.mCard.setCardView(this);
        setupHeaderView();
        setupMainView();
        setupThumbnailView();
        setupExpandView();
        setupListeners();
        setupExpandAction();
        setupDrawableResources();
    }

    protected void retrieveLayoutIDs() {
        super.retrieveLayoutIDs();
        this.mInternalMainCardLayout = findViewById(C0173R.id.card_main_layout);
        this.mInternalHeaderLayout = (CardHeaderView) findViewById(C0173R.id.card_header_layout);
        this.mInternalExpandLayout = findViewById(C0173R.id.card_content_expand_layout);
        this.mInternalContentLayout = findViewById(C0173R.id.card_main_content_layout);
        this.mInternalThumbnailLayout = (CardThumbnailView) findViewById(C0173R.id.card_thumbnail_layout);
    }

    protected void setupHeaderView() {
        if (this.mCardHeader != null) {
            if (this.mInternalHeaderLayout != null) {
                this.mInternalHeaderLayout.setVisibility(0);
                this.mInternalHeaderLayout.setRecycle(isRecycle());
                this.mInternalHeaderLayout.setForceReplaceInnerLayout(isForceReplaceInnerLayout());
                this.mInternalHeaderLayout.addCardHeader(this.mCardHeader);
            }
        } else if (this.mInternalHeaderLayout != null) {
            this.mInternalHeaderLayout.setVisibility(8);
            if (isForceReplaceInnerLayout()) {
                this.mInternalHeaderLayout.addCardHeader(null);
            }
        }
    }

    protected void setupMainView() {
        if (this.mInternalContentLayout != null) {
            ViewGroup mParentGroup = null;
            try {
                mParentGroup = (ViewGroup) this.mInternalContentLayout;
            } catch (Exception e) {
                setRecycle(false);
            }
            if (!isRecycle() || isForceReplaceInnerLayout()) {
                if (!(!isForceReplaceInnerLayout() || this.mInternalContentLayout == null || this.mInternalInnerView == null)) {
                    ((ViewGroup) this.mInternalContentLayout).removeView(this.mInternalInnerView);
                }
                this.mInternalInnerView = this.mCard.getInnerView(getContext(), (ViewGroup) this.mInternalContentLayout);
            } else if (this.mCard.getInnerLayout() > -1) {
                this.mCard.setupInnerViewElements(mParentGroup, this.mInternalInnerView);
            }
        }
    }

    protected void setupThumbnailView() {
        if (this.mInternalThumbnailLayout == null) {
            return;
        }
        if (this.mCardThumbnail != null) {
            this.mInternalThumbnailLayout.setVisibility(0);
            this.mInternalThumbnailLayout.setRecycle(isRecycle());
            this.mInternalThumbnailLayout.setForceReplaceInnerLayout(isForceReplaceInnerLayout());
            this.mInternalThumbnailLayout.addCardThumbnail(this.mCardThumbnail);
            return;
        }
        this.mInternalThumbnailLayout.setVisibility(8);
    }

    protected void setupDrawableResources() {
        if (this.mCard == null) {
            return;
        }
        if (this.mCard.getBackgroundResourceId() != 0) {
            changeBackgroundResourceId(this.mCard.getBackgroundResourceId());
        } else if (this.mCard.getBackgroundResource() != null) {
            changeBackgroundResource(this.mCard.getBackgroundResource());
        }
    }

    protected void setupExpandAction() {
        if (this.mInternalExpandLayout != null && ((this.mCardHeader != null && this.mCardHeader.isButtonExpandVisible()) || this.mCard.getViewToClickToExpand() != null)) {
            this.mInternalExpandLayout.getViewTreeObserver().addOnPreDrawListener(new C01931());
        }
        setupExpandCollapseActionListener();
    }

    @SuppressLint({"NewApi"})
    protected void setupListeners() {
        if (this.mCard.isSwipeable()) {
            setOnTouchListener(new SwipeDismissViewTouchListener(this, this.mCard, new C02522()));
        } else {
            setOnTouchListener(null);
        }
        resetPartialListeners();
        if (!this.mCard.isClickable()) {
            setClickable(false);
        } else if (!this.mCard.isMultiChoiceEnabled()) {
            if (this.mCard.getOnClickListener() != null) {
                setOnClickListener(new C01943());
            } else {
                HashMap<Integer, OnCardClickListener> mMultipleOnClickListner = this.mCard.getMultipleOnClickListener();
                if (mMultipleOnClickListner == null || mMultipleOnClickListner.isEmpty()) {
                    setClickable(false);
                } else {
                    for (Integer intValue : mMultipleOnClickListner.keySet()) {
                        int key = intValue.intValue();
                        View viewClickable = decodeAreaOnClickListener(key);
                        OnCardClickListener mListener = (OnCardClickListener) mMultipleOnClickListner.get(Integer.valueOf(key));
                        if (viewClickable != null) {
                            viewClickable.setOnClickListener(new C01954(mListener));
                            if (key > 0) {
                                if (VERSION.SDK_INT >= 16) {
                                    viewClickable.setBackground(getResources().getDrawable(C0173R.drawable.card_selector));
                                } else {
                                    viewClickable.setBackgroundDrawable(getResources().getDrawable(C0173R.drawable.card_selector));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.mCard.isLongClickable()) {
            setOnLongClickListener(new C01965());
        } else {
            setLongClickable(false);
        }
    }

    protected void resetPartialListeners() {
        View viewClickable = decodeAreaOnClickListener(2);
        if (viewClickable != null) {
            viewClickable.setClickable(false);
        }
        viewClickable = decodeAreaOnClickListener(1);
        if (viewClickable != null) {
            viewClickable.setClickable(false);
        }
        viewClickable = decodeAreaOnClickListener(10);
        if (viewClickable != null) {
            viewClickable.setClickable(false);
        }
    }

    protected View decodeAreaOnClickListener(int area) {
        if (area < 0 && area > 10) {
            return null;
        }
        switch (area) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                return this;
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                return this.mInternalThumbnailLayout;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                return this.mInternalHeaderLayout;
            case Card.CLICK_LISTENER_CONTENT_VIEW /*10*/:
                return this.mInternalContentLayout;
            default:
                return null;
        }
    }

    protected void setupExpandCollapseActionListener() {
        if (this.mInternalExpandLayout != null) {
            this.mInternalExpandLayout.setVisibility(8);
            ViewToClickToExpand viewToClickToExpand = null;
            if (this.mCardHeader != null && this.mCardHeader.isButtonExpandVisible()) {
                viewToClickToExpand = ViewToClickToExpand.builder().setupView(this.mInternalHeaderLayout.getImageButtonExpand()).highlightView(true);
            } else if (this.mCard.getViewToClickToExpand() != null) {
                viewToClickToExpand = this.mCard.getViewToClickToExpand();
            }
            if (viewToClickToExpand != null) {
                TitleViewOnClickListener titleViewOnClickListener = new TitleViewOnClickListener(this.mInternalExpandLayout, this.mCard, viewToClickToExpand.isViewToSelect(), null);
                if (!(this.mCardHeader == null || !this.mCardHeader.isButtonExpandVisible() || this.mInternalHeaderLayout == null)) {
                    this.mInternalHeaderLayout.setOnClickExpandCollapseActionListener(titleViewOnClickListener);
                }
                View viewToClick = viewToClickToExpand.getViewToClick();
                if (viewToClick != null) {
                    viewToClick.setOnClickListener(titleViewOnClickListener);
                } else {
                    CardElementUI cardElementUI = viewToClickToExpand.getCardElementUIToClick();
                    if (cardElementUI != null) {
                        switch (C01987.f11x4707618c[cardElementUI.ordinal()]) {
                            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                                viewToClick = this;
                                break;
                            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                                viewToClick = getInternalHeaderLayout();
                                break;
                            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                                viewToClick = getInternalThumbnailLayout();
                                break;
                            case TransportMediator.FLAG_KEY_MEDIA_PLAY /*4*/:
                                viewToClick = getInternalContentLayout();
                                break;
                        }
                        if (viewToClick != null) {
                            viewToClick.setOnClickListener(titleViewOnClickListener);
                        }
                    }
                }
                if (isExpanded()) {
                    this.mInternalExpandLayout.setVisibility(0);
                    if (viewToClick != null && viewToClickToExpand.isViewToSelect()) {
                        viewToClick.setSelected(true);
                        return;
                    }
                    return;
                }
                this.mInternalExpandLayout.setVisibility(8);
                if (viewToClick != null && viewToClickToExpand.isViewToSelect()) {
                    viewToClick.setSelected(false);
                }
            }
        }
    }

    protected void setupExpandView() {
        if (this.mInternalExpandLayout != null && this.mCardExpand != null) {
            if (!isRecycle() || isForceReplaceInnerLayout()) {
                if (!(!isForceReplaceInnerLayout() || this.mInternalExpandLayout == null || this.mInternalExpandInnerView == null)) {
                    ((ViewGroup) this.mInternalExpandLayout).removeView(this.mInternalExpandInnerView);
                }
                this.mInternalExpandInnerView = this.mCardExpand.getInnerView(getContext(), (ViewGroup) this.mInternalExpandLayout);
            } else if (this.mCardExpand.getInnerLayout() > -1) {
                this.mCardExpand.setupInnerViewElements((ViewGroup) this.mInternalExpandLayout, this.mInternalExpandInnerView);
            }
            LayoutParams layoutParams = this.mInternalExpandLayout.getLayoutParams();
            layoutParams.height = -2;
            this.mInternalExpandLayout.setLayoutParams(layoutParams);
        }
    }

    protected ValueAnimator createSlideAnimator(int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{start, end});
        animator.addUpdateListener(new C01976());
        return animator;
    }

    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);
    }

    public OnExpandListAnimatorListener getOnExpandListAnimatorListener() {
        return this.mOnExpandListAnimatorListener;
    }

    public void setOnExpandListAnimatorListener(OnExpandListAnimatorListener onExpandListAnimatorListener) {
        this.mOnExpandListAnimatorListener = onExpandListAnimatorListener;
    }

    public Bitmap createBitmap() {
        if (getWidth() <= 0 && getHeight() <= 0) {
            int spec = MeasureSpec.makeMeasureSpec(0, 0);
            measure(spec, spec);
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
        Bitmap b = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        draw(new Canvas(b));
        return b;
    }

    public View getInternalExpandLayout() {
        return this.mInternalExpandLayout;
    }

    public View getInternalContentLayout() {
        return this.mInternalContentLayout;
    }

    public View getInternalInnerView() {
        return this.mInternalInnerView;
    }

    public boolean isExpanded() {
        if (this.mCard != null) {
            return this.mCard.isExpanded();
        }
        return false;
    }

    public void setExpanded(boolean expanded) {
        if (this.mCard != null) {
            this.mCard.setExpanded(expanded);
        }
    }

    public View getInternalMainCardLayout() {
        return this.mInternalMainCardLayout;
    }

    public void changeBackgroundResourceId(int drawableResourceId) {
        if (drawableResourceId != 0 && this.mInternalMainCardLayout != null) {
            this.mInternalMainCardLayout.setBackgroundResource(drawableResourceId);
        }
    }

    public void changeBackgroundResource(Drawable drawableResource) {
        if (drawableResource != null && this.mInternalMainCardLayout != null) {
            if (VERSION.SDK_INT >= 16) {
                this.mInternalMainCardLayout.setBackground(drawableResource);
            } else {
                this.mInternalMainCardLayout.setBackgroundDrawable(drawableResource);
            }
        }
    }
}
