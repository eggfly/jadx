package it.gmariotti.cardslib.library.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardCursorAdapter;
import it.gmariotti.cardslib.library.view.CardView.OnExpandListAnimatorListener;
import it.gmariotti.cardslib.library.view.listener.SwipeOnScrollListener;

public class CardListView extends ListView implements OnExpandListAnimatorListener {
    protected static String TAG;
    protected int list_card_layout_resourceID;
    protected CardArrayAdapter mAdapter;
    protected CardCursorAdapter mCursorAdapter;
    protected SwipeOnScrollListener mOnScrollListener;

    private static class ExpandCollapseHelper {

        /* renamed from: it.gmariotti.cardslib.library.view.CardListView.ExpandCollapseHelper.1 */
        static class C01891 extends AnimatorListenerAdapter {
            final /* synthetic */ CardView val$cardView;
            final /* synthetic */ View val$expandingLayout;
            final /* synthetic */ AbsListView val$listView;

            C01891(View view, CardView cardView, AbsListView absListView) {
                this.val$expandingLayout = view;
                this.val$cardView = cardView;
                this.val$listView = absListView;
            }

            public void onAnimationEnd(Animator animator) {
                this.val$expandingLayout.setVisibility(8);
                this.val$cardView.setExpanded(false);
                ExpandCollapseHelper.notifyAdapter(this.val$listView);
                Card card = this.val$cardView.getCard();
                if (card.getOnCollapseAnimatorEndListener() != null) {
                    card.getOnCollapseAnimatorEndListener().onCollapseEnd(card);
                }
            }
        }

        /* renamed from: it.gmariotti.cardslib.library.view.CardListView.ExpandCollapseHelper.2 */
        static class C01902 implements AnimatorUpdateListener {
            final int listViewBottomPadding;
            final int listViewHeight;
            final View f10v;
            final /* synthetic */ View val$expandingLayout;
            final /* synthetic */ AbsListView val$listView;

            C01902(AbsListView absListView, View view) {
                this.val$listView = absListView;
                this.val$expandingLayout = view;
                this.listViewHeight = this.val$listView.getHeight();
                this.listViewBottomPadding = this.val$listView.getPaddingBottom();
                this.f10v = ExpandCollapseHelper.findDirectChild(this.val$expandingLayout, this.val$listView);
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int bottom = this.f10v.getBottom();
                if (bottom > this.listViewHeight) {
                    int top = this.f10v.getTop();
                    if (top > 0) {
                        this.val$listView.smoothScrollBy(Math.min((bottom - this.listViewHeight) + this.listViewBottomPadding, top), 0);
                    }
                }
            }
        }

        /* renamed from: it.gmariotti.cardslib.library.view.CardListView.ExpandCollapseHelper.3 */
        static class C01913 extends AnimatorListenerAdapter {
            final /* synthetic */ CardView val$cardView;
            final /* synthetic */ AbsListView val$listView;

            C01913(CardView cardView, AbsListView absListView) {
                this.val$cardView = cardView;
                this.val$listView = absListView;
            }

            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                this.val$cardView.setExpanded(true);
                ExpandCollapseHelper.notifyAdapter(this.val$listView);
                Card card = this.val$cardView.getCard();
                if (card.getOnExpandAnimatorEndListener() != null) {
                    card.getOnExpandAnimatorEndListener().onExpandEnd(card);
                }
            }
        }

        /* renamed from: it.gmariotti.cardslib.library.view.CardListView.ExpandCollapseHelper.4 */
        static class C01924 implements AnimatorUpdateListener {
            final /* synthetic */ View val$view;

            C01924(View view) {
                this.val$view = view;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LayoutParams layoutParams = this.val$view.getLayoutParams();
                layoutParams.height = value;
                this.val$view.setLayoutParams(layoutParams);
            }
        }

        private ExpandCollapseHelper() {
        }

        public static void animateCollapsing(View expandingLayout, CardView cardView, AbsListView listView) {
            ValueAnimator animator = createHeightAnimator(expandingLayout, expandingLayout.getHeight(), 0);
            animator.addListener(new C01891(expandingLayout, cardView, listView));
            animator.start();
        }

        public static void animateExpanding(View expandingLayout, CardView cardView, AbsListView listView) {
            expandingLayout.setVisibility(0);
            View parent = (View) expandingLayout.getParent();
            expandingLayout.measure(MeasureSpec.makeMeasureSpec((parent.getMeasuredWidth() - parent.getPaddingLeft()) - parent.getPaddingRight(), ExploreByTouchHelper.INVALID_ID), MeasureSpec.makeMeasureSpec(0, 0));
            ValueAnimator animator = createHeightAnimator(expandingLayout, 0, expandingLayout.getMeasuredHeight());
            animator.addUpdateListener(new C01902(listView, expandingLayout));
            animator.addListener(new C01913(cardView, listView));
            animator.start();
        }

        private static View findDirectChild(View view, AbsListView listView) {
            View result = view;
            View parent = (View) result.getParent();
            while (parent != listView) {
                result = parent;
                parent = (View) result.getParent();
            }
            return result;
        }

        public static ValueAnimator createHeightAnimator(View view, int start, int end) {
            ValueAnimator animator = ValueAnimator.ofInt(new int[]{start, end});
            animator.addUpdateListener(new C01924(view));
            return animator;
        }

        public static void notifyAdapter(AbsListView listView) {
            if (listView instanceof CardListView) {
                CardListView cardListView = (CardListView) listView;
                if (cardListView.mAdapter != null) {
                    cardListView.mAdapter.notifyDataSetChanged();
                } else if (cardListView.mCursorAdapter == null) {
                }
            }
        }
    }

    static {
        TAG = "CardListView";
    }

    public CardListView(Context context) {
        super(context);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(null, 0);
    }

    public CardListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.list_card_layout_resourceID = C0173R.layout.list_card_layout;
        init(attrs, 0);
    }

    public CardListView(Context context, AttributeSet attrs, int defStyle) {
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
        if (adapter instanceof CardArrayAdapter) {
            setAdapter((CardArrayAdapter) adapter);
        } else if (adapter instanceof CardCursorAdapter) {
            setAdapter((CardCursorAdapter) adapter);
        } else {
            Log.w(TAG, "You are using a generic adapter. Pay attention: your adapter has to call cardArrayAdapter#getView method");
            super.setAdapter(adapter);
        }
    }

    public void setAdapter(CardArrayAdapter adapter) {
        super.setAdapter(adapter);
        adapter.setRowLayoutId(this.list_card_layout_resourceID);
        adapter.setCardListView(this);
        this.mAdapter = adapter;
    }

    public void setAdapter(CardCursorAdapter adapter) {
        super.setAdapter(adapter);
        adapter.setRowLayoutId(this.list_card_layout_resourceID);
        adapter.setCardListView(this);
        this.mCursorAdapter = adapter;
    }

    public void setExternalAdapter(ListAdapter adapter, CardArrayAdapter cardArrayAdapter) {
        setAdapter(adapter);
        this.mAdapter = cardArrayAdapter;
        this.mAdapter.setCardListView(this);
        this.mAdapter.setRowLayoutId(this.list_card_layout_resourceID);
    }

    public void setExternalAdapter(ListAdapter adapter, CardCursorAdapter cardCursorAdapter) {
        setAdapter(adapter);
        this.mCursorAdapter = cardCursorAdapter;
        this.mCursorAdapter.setCardListView(this);
        this.mCursorAdapter.setRowLayoutId(this.list_card_layout_resourceID);
    }

    public OnScrollListener getOnScrollListener() {
        return this.mOnScrollListener;
    }

    public void setOnScrollListener(OnScrollListener mOnScrollListener) {
        super.setOnScrollListener(mOnScrollListener);
        if (mOnScrollListener instanceof SwipeOnScrollListener) {
            this.mOnScrollListener = (SwipeOnScrollListener) mOnScrollListener;
        }
    }

    public void onExpandStart(CardView viewCard, View expandingLayout) {
        boolean expandable = true;
        if (this.mCursorAdapter != null) {
            expandable = this.mCursorAdapter.onExpandStart(viewCard);
        }
        if (expandable) {
            ExpandCollapseHelper.animateExpanding(expandingLayout, viewCard, this);
        }
        if (this.mCursorAdapter != null) {
            this.mCursorAdapter.onExpandEnd(viewCard);
        }
    }

    public void onCollapseStart(CardView viewCard, View expandingLayout) {
        boolean collapsible = true;
        if (this.mCursorAdapter != null) {
            collapsible = this.mCursorAdapter.onCollapseStart(viewCard);
        }
        if (collapsible) {
            ExpandCollapseHelper.animateCollapsing(expandingLayout, viewCard, this);
        }
        if (this.mCursorAdapter != null) {
            this.mCursorAdapter.onCollapseEnd(viewCard);
        }
    }
}
