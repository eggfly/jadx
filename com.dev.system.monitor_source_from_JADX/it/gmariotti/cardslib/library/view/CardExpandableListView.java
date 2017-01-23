package it.gmariotti.cardslib.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.CardExpandableListAdapter;

public class CardExpandableListView extends ExpandableListView {
    protected static String TAG;
    protected int list_card_layout_resourceID;
    protected CardExpandableListAdapter mAdapter;

    static {
        TAG = "CardExpandableListView";
    }

    public CardExpandableListView(Context context) {
        super(context);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(null, 0);
    }

    public CardExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(attrs, 0);
    }

    public CardExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {
        initAttrs(attrs, defStyle);
        setDividerHeight(0);
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, C0173R.styleable.card_options, defStyle, defStyle);
        try {
            this.list_card_layout_resourceID = a.getResourceId(C0173R.styleable.card_options_list_card_layout_resourceID, this.list_card_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    public void setAdapter(ListAdapter adapter) {
        if (adapter instanceof CardExpandableListAdapter) {
            setAdapter(adapter);
            return;
        }
        Log.w(TAG, "You are using a generic adapter. Pay attention: your adapter has to call cardArrayAdapter#getView method");
        super.setAdapter(adapter);
    }

    public void setAdapter(CardExpandableListAdapter adapter) {
        super.setAdapter(adapter);
        adapter.setGroupLayoutId(this.list_card_layout_resourceID);
        adapter.setCardListView(this);
        this.mAdapter = adapter;
    }
}
