package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCard;

public class CardExpand extends BaseCard {
    public CardExpand(Context context) {
        this(context, C0173R.layout.inner_base_expand);
    }

    public CardExpand(Context context, int innerLayout) {
        super(context);
        this.mInnerLayout = innerLayout;
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
            TextView mTitleView = (TextView) view.findViewById(C0173R.id.card_expand_inner_simple_title);
            if (mTitleView != null) {
                mTitleView.setText(this.mTitle);
            }
        }
    }
}
