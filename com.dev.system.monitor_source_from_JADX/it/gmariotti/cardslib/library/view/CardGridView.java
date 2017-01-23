package it.gmariotti.cardslib.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardGridCursorAdapter;
import it.gmariotti.cardslib.library.view.CardView.OnExpandListAnimatorListener;

public class CardGridView extends GridView implements OnExpandListAnimatorListener {
    protected static String TAG;
    protected int list_card_layout_resourceID;
    protected CardGridArrayAdapter mAdapter;
    protected CardGridCursorAdapter mCursorAdapter;

    static {
        TAG = "CardGridView";
    }

    public CardGridView(Context context) {
        super(context);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(null, 0);
    }

    public CardGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(attrs, 0);
    }

    public CardGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {
        initAttrs(attrs, defStyle);
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
        if (adapter instanceof CardGridArrayAdapter) {
            setAdapter((CardGridArrayAdapter) adapter);
        } else if (adapter instanceof CardGridCursorAdapter) {
            setAdapter((CardGridCursorAdapter) adapter);
        } else {
            Log.w(TAG, "You are using a generic adapter. Pay attention: your adapter has to call cardGridArrayAdapter#getView method.");
            super.setAdapter(adapter);
        }
    }

    public void setAdapter(CardGridArrayAdapter adapter) {
        super.setAdapter(adapter);
        adapter.setRowLayoutId(this.list_card_layout_resourceID);
        adapter.setCardGridView(this);
        this.mAdapter = adapter;
    }

    public void setAdapter(CardGridCursorAdapter adapter) {
        super.setAdapter(adapter);
        adapter.setRowLayoutId(this.list_card_layout_resourceID);
        adapter.setCardGridView(this);
        this.mCursorAdapter = adapter;
    }

    public void setExternalAdapter(ListAdapter adapter, CardGridArrayAdapter cardGridArrayAdapter) {
        setAdapter(adapter);
        this.mAdapter = cardGridArrayAdapter;
        this.mAdapter.setCardGridView(this);
        this.mAdapter.setRowLayoutId(this.list_card_layout_resourceID);
    }

    public void setExternalAdapter(ListAdapter adapter, CardGridCursorAdapter cardCursorAdapter) {
        setAdapter(adapter);
        this.mCursorAdapter = cardCursorAdapter;
        this.mCursorAdapter.setCardGridView(this);
        this.mCursorAdapter.setRowLayoutId(this.list_card_layout_resourceID);
    }

    public void onExpandStart(CardView viewCard, View expandingLayout) {
        Log.w(TAG, "Don't use this kind of animation in a grid");
    }

    public void onCollapseStart(CardView viewCard, View expandingLayout) {
        Log.w(TAG, "Don't use this kind of animation in a grid");
    }
}
