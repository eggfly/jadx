package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.view.CardExpandableListView;
import it.gmariotti.cardslib.library.view.CardView;

public class CardExpandableListAdapter<T> extends BaseExpandableListAdapter {
    protected final SparseArray<BaseGroupExpandableCard<T>> cards;
    protected CardExpandableListView mCardListView;
    protected int mChildLayoutId;
    protected Context mContext;
    protected int mGroupLayoutId;
    public LayoutInflater mInflater;

    /* renamed from: it.gmariotti.cardslib.library.internal.CardExpandableListAdapter.1 */
    class C01741 implements OnClickListener {
        final /* synthetic */ Object val$children;

        C01741(Object obj) {
            this.val$children = obj;
        }

        public void onClick(View v) {
            Toast.makeText(CardExpandableListAdapter.this.mContext, this.val$children.toString(), 0).show();
        }
    }

    public CardExpandableListAdapter(Context context, SparseArray<BaseGroupExpandableCard<T>> cards) {
        this.mGroupLayoutId = C0173R.layout.list_card_layout;
        this.mChildLayoutId = C0173R.layout.base_list_expandable_children_layout;
        this.cards = cards;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public int getGroupCount() {
        return this.cards.size();
    }

    public int getChildrenCount(int groupPosition) {
        return ((BaseGroupExpandableCard) this.cards.get(groupPosition)).children.size();
    }

    public Card getGroup(int groupPosition) {
        return (Card) this.cards.get(groupPosition);
    }

    public T getChild(int groupPosition, int childPosition) {
        return ((BaseGroupExpandableCard) this.cards.get(groupPosition)).children.get(childPosition);
    }

    public long getGroupId(int groupPosition) {
        if (getGroup(groupPosition).getId() != null) {
            return (long) getGroup(groupPosition).getId().hashCode();
        }
        return (long) groupPosition;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long) childPosition;
    }

    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        Card mCard = getGroup(groupPosition);
        if (mCard != null) {
            boolean recycle;
            int layout = this.mGroupLayoutId;
            if (view == null) {
                recycle = false;
                view = this.mInflater.inflate(layout, parent, false);
            } else {
                recycle = true;
            }
            CardView mCardView = (CardView) view.findViewById(C0173R.id.list_cardId);
            if (mCardView != null) {
                mCardView.setForceReplaceInnerLayout(Card.equalsInnerLayout(mCardView.getCard(), mCard));
                mCardView.setRecycle(recycle);
                mCard.setSwipeable(false);
                mCardView.setCard(mCard);
            }
        }
        return view;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        T obj = getChild(groupPosition, childPosition);
        if (obj != null && (obj instanceof String)) {
            String children = (String) obj;
            if (convertView == null) {
                convertView = this.mInflater.inflate(this.mChildLayoutId, null);
            }
            ((TextView) convertView.findViewById(C0173R.id.card_children_simple_title)).setText(children);
            registerClickListener(convertView, obj, groupPosition, childPosition);
        }
        return convertView;
    }

    protected void registerClickListener(View convertView, T obj, int groupPosition, int childPosition) {
        if (isChildSelectable(groupPosition, childPosition)) {
            convertView.setOnClickListener(new C01741(obj));
        }
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setGroupLayoutId(int groupLayoutId) {
        this.mGroupLayoutId = groupLayoutId;
    }

    public CardExpandableListView getCardListView() {
        return this.mCardListView;
    }

    public void setCardListView(CardExpandableListView cardListView) {
        this.mCardListView = cardListView;
    }
}
