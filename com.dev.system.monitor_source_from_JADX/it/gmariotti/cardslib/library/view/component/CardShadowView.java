package it.gmariotti.cardslib.library.view.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.view.base.CardViewInterface;

public class CardShadowView extends FrameLayout implements CardViewInterface {
    protected int card_shadow_layout_resourceID;
    protected View mInternalOuterView;

    public CardShadowView(Context context) {
        super(context);
        this.card_shadow_layout_resourceID = C0173R.layout.base_shadow_layout;
        init(null, 0);
    }

    public CardShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.card_shadow_layout_resourceID = C0173R.layout.base_shadow_layout;
        init(attrs, 0);
    }

    public CardShadowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.card_shadow_layout_resourceID = C0173R.layout.base_shadow_layout;
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
            this.card_shadow_layout_resourceID = a.getResourceId(C0173R.styleable.card_options_card_shadow_layout_resourceID, this.card_shadow_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    protected void initView() {
        this.mInternalOuterView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.card_shadow_layout_resourceID, this, true);
    }

    public View getInternalOuterView() {
        return this.mInternalOuterView;
    }
}
