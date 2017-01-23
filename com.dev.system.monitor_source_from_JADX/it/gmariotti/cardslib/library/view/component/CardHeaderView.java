package it.gmariotti.cardslib.library.view.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardHeader.CustomOverflowAnimation;
import it.gmariotti.cardslib.library.view.base.CardViewInterface;

public class CardHeaderView extends FrameLayout implements CardViewInterface {
    protected int card_header_layout_resourceID;
    protected CardHeader mCardHeader;
    protected boolean mForceReplaceInnerLayout;
    protected ViewGroup mFrameButton;
    protected ViewGroup mFrameInner;
    protected ImageButton mImageButtonExpand;
    protected ImageButton mImageButtonOther;
    protected ImageButton mImageButtonOverflow;
    protected View mInternalInnerView;
    protected View mInternalOuterView;
    protected boolean mIsRecycle;
    protected OnClickListener mOnClickExpandCollapseActionListener;
    protected PopupMenu mPopupMenu;

    /* renamed from: it.gmariotti.cardslib.library.view.component.CardHeaderView.1 */
    class C02011 implements OnClickListener {
        final /* synthetic */ CustomOverflowAnimation val$animation;

        C02011(CustomOverflowAnimation customOverflowAnimation) {
            this.val$animation = customOverflowAnimation;
        }

        public void onClick(View v) {
            this.val$animation.doAnimation(CardHeaderView.this.mCardHeader.getParentCard(), v);
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.component.CardHeaderView.2 */
    class C02022 implements OnClickListener {
        C02022() {
        }

        public void onClick(View v) {
            if (CardHeaderView.this.mCardHeader.getOtherButtonClickListener() != null) {
                CardHeaderView.this.mCardHeader.getOtherButtonClickListener().onButtonItemClick(CardHeaderView.this.mCardHeader.getParentCard(), v);
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.component.CardHeaderView.3 */
    class C02033 implements OnClickListener {
        C02033() {
        }

        public void onClick(View v) {
            if (CardHeaderView.this.mPopupMenu == null) {
                CardHeaderView.this.mPopupMenu = CardHeaderView.this._buildPopupMenu();
            }
            if (CardHeaderView.this.mPopupMenu != null) {
                CardHeaderView.this.mPopupMenu.show();
            }
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.view.component.CardHeaderView.4 */
    class C02044 implements OnMenuItemClickListener {
        C02044() {
        }

        public boolean onMenuItemClick(MenuItem item) {
            if (CardHeaderView.this.mCardHeader.getPopupMenuListener() != null) {
                CardHeaderView.this.mCardHeader.getPopupMenuListener().onMenuItemClick(CardHeaderView.this.mCardHeader.getParentCard(), item);
            }
            return false;
        }
    }

    public CardHeaderView(Context context) {
        super(context);
        this.card_header_layout_resourceID = C0173R.layout.base_header_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        init(null, 0);
    }

    public CardHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.card_header_layout_resourceID = C0173R.layout.base_header_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        init(attrs, 0);
    }

    public CardHeaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.card_header_layout_resourceID = C0173R.layout.base_header_layout;
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
            this.card_header_layout_resourceID = a.getResourceId(C0173R.styleable.card_options_card_header_layout_resourceID, this.card_header_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    protected void initView() {
        this.mInternalOuterView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.card_header_layout_resourceID, this, true);
        this.mImageButtonExpand = (ImageButton) findViewById(C0173R.id.card_header_button_expand);
        this.mImageButtonOverflow = (ImageButton) findViewById(C0173R.id.card_header_button_overflow);
        this.mImageButtonOther = (ImageButton) findViewById(C0173R.id.card_header_button_other);
        this.mFrameInner = (FrameLayout) findViewById(C0173R.id.card_header_inner_frame);
        this.mFrameButton = (FrameLayout) findViewById(C0173R.id.card_header_button_frame);
    }

    public View getInternalOuterView() {
        return this.mInternalOuterView;
    }

    public void addCardHeader(CardHeader cardHeader) {
        this.mCardHeader = cardHeader;
        buildUI();
    }

    protected void buildUI() {
        if (this.mCardHeader != null) {
            setupButtons();
            setupInnerView();
        }
    }

    @SuppressLint({"NewApi"})
    protected void setupButtons() {
        if (this.mCardHeader.isButtonOverflowVisible()) {
            visibilityButtonHelper(0, 8, 8);
            addPopup();
            if (this.mPopupMenu == null && this.mCardHeader.getCustomOverflowAnimation() != null) {
                addCustomOverflowAnimation();
            }
        } else if (this.mCardHeader.isButtonExpandVisible()) {
            visibilityButtonHelper(8, 0, 8);
        } else if (!this.mCardHeader.isOtherButtonVisible() || this.mImageButtonOther == null) {
            visibilityButtonHelper(8, 8, 8);
        } else {
            visibilityButtonHelper(8, 8, 0);
            if (this.mImageButtonOther != null) {
                if (this.mCardHeader.getOtherButtonDrawable() > 0) {
                    if (VERSION.SDK_INT >= 16) {
                        this.mImageButtonOther.setBackground(getResources().getDrawable(this.mCardHeader.getOtherButtonDrawable()));
                    } else {
                        this.mImageButtonOther.setBackgroundDrawable(getResources().getDrawable(this.mCardHeader.getOtherButtonDrawable()));
                    }
                }
                addOtherListener();
            }
        }
    }

    private void addCustomOverflowAnimation() {
        CustomOverflowAnimation animation = this.mCardHeader.getCustomOverflowAnimation();
        if (animation != null && this.mImageButtonOverflow != null) {
            this.mImageButtonOverflow.setOnClickListener(new C02011(animation));
        } else if (this.mImageButtonOverflow != null) {
            this.mImageButtonOverflow.setVisibility(8);
        }
    }

    protected void addOtherListener() {
        if (this.mCardHeader.getOtherButtonClickListener() != null) {
            if (this.mImageButtonOther != null) {
                this.mImageButtonOther.setOnClickListener(new C02022());
            }
        } else if (this.mImageButtonOther != null) {
            this.mImageButtonOther.setClickable(false);
        }
    }

    protected void setupInnerView() {
        if (this.mFrameInner == null) {
            return;
        }
        if (!isRecycle() || isForceReplaceInnerLayout()) {
            if (!(!isForceReplaceInnerLayout() || this.mFrameInner == null || this.mInternalInnerView == null)) {
                this.mFrameInner.removeView(this.mInternalInnerView);
            }
            this.mInternalInnerView = this.mCardHeader.getInnerView(getContext(), this.mFrameInner);
        } else if (this.mCardHeader.getInnerLayout() > -1) {
            this.mCardHeader.setupInnerViewElements(this.mFrameInner, this.mInternalInnerView);
        }
    }

    protected void visibilityButtonHelper(int overflowButtonVisibility, int expandButtonVisibility, int otherButtonVisibility) {
        if ((overflowButtonVisibility == 0 || overflowButtonVisibility == 8) && this.mImageButtonOverflow != null) {
            this.mImageButtonOverflow.setVisibility(overflowButtonVisibility);
        }
        if ((expandButtonVisibility == 0 || expandButtonVisibility == 8) && this.mImageButtonExpand != null) {
            this.mImageButtonExpand.setVisibility(expandButtonVisibility);
        }
        if ((otherButtonVisibility == 0 || otherButtonVisibility == 8) && this.mImageButtonOther != null) {
            this.mImageButtonOther.setVisibility(otherButtonVisibility);
        }
    }

    protected void addPopup() {
        this.mPopupMenu = null;
        if (this.mImageButtonOverflow != null) {
            boolean prepareMenu = this.mCardHeader.getPopupMenu() > CardHeader.NO_POPUP_MENU;
            if (this.mCardHeader.getPopupMenuPrepareListener() != null) {
                this.mPopupMenu = _buildPopupMenu();
                prepareMenu = this.mCardHeader.getPopupMenuPrepareListener().onPreparePopupMenu(this.mCardHeader.getParentCard(), this.mPopupMenu);
                if (this.mPopupMenu.getMenu() == null || !this.mPopupMenu.getMenu().hasVisibleItems()) {
                    prepareMenu = false;
                }
            }
            if (prepareMenu) {
                this.mImageButtonOverflow.setOnClickListener(new C02033());
            } else if (this.mCardHeader.getCustomOverflowAnimation() == null) {
                this.mImageButtonOverflow.setVisibility(8);
            }
        } else if (this.mImageButtonOverflow != null) {
            this.mImageButtonOverflow.setVisibility(8);
        }
    }

    private PopupMenu _buildPopupMenu() {
        PopupMenu popup = new PopupMenu(getContext(), this.mImageButtonOverflow);
        if (this.mCardHeader.getPopupMenu() > CardHeader.NO_POPUP_MENU) {
            popup.getMenuInflater().inflate(this.mCardHeader.getPopupMenu(), popup.getMenu());
        }
        popup.setOnMenuItemClickListener(new C02044());
        return popup;
    }

    public OnClickListener getOnClickExpandCollapseActionListener() {
        return this.mOnClickExpandCollapseActionListener;
    }

    public void setOnClickExpandCollapseActionListener(OnClickListener onClickExpandCollapseActionListener) {
        this.mOnClickExpandCollapseActionListener = onClickExpandCollapseActionListener;
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

    public ImageButton getImageButtonOverflow() {
        return this.mImageButtonOverflow;
    }

    public ImageButton getImageButtonExpand() {
        return this.mImageButtonExpand;
    }

    public ImageButton getImageButtonOther() {
        return this.mImageButtonOther;
    }

    public ViewGroup getFrameButton() {
        return this.mFrameButton;
    }
}
