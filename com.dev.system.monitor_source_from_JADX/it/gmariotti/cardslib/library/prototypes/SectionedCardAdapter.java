package it.gmariotti.cardslib.library.prototypes;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import java.util.Arrays;
import java.util.Comparator;

public class SectionedCardAdapter extends BaseAdapter {
    private BaseAdapter mBaseAdapter;
    private SparseArray<CardSection> mCardSections;
    private LayoutInflater mLayoutInflater;
    private int mSectionResourceId;
    private boolean mValid;

    /* renamed from: it.gmariotti.cardslib.library.prototypes.SectionedCardAdapter.1 */
    class C01861 extends DataSetObserver {
        C01861() {
        }

        public void onChanged() {
            SectionedCardAdapter.this.mValid = !SectionedCardAdapter.this.mBaseAdapter.isEmpty();
            SectionedCardAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            SectionedCardAdapter.this.mValid = false;
            SectionedCardAdapter.this.notifyDataSetInvalidated();
        }
    }

    /* renamed from: it.gmariotti.cardslib.library.prototypes.SectionedCardAdapter.2 */
    class C01872 implements Comparator<CardSection> {
        C01872() {
        }

        public int compare(CardSection o, CardSection o1) {
            if (o.firstPosition == o1.firstPosition) {
                return 0;
            }
            return o.firstPosition < o1.firstPosition ? -1 : 1;
        }
    }

    public SectionedCardAdapter(Context context, CardArrayAdapter cardArrayAdapter) {
        this(context, C0173R.layout.base_section_layout, cardArrayAdapter);
    }

    public SectionedCardAdapter(Context context, int sectionResourceId, CardArrayAdapter cardArrayAdapter) {
        this.mValid = true;
        this.mSectionResourceId = C0173R.layout.base_section_layout;
        this.mCardSections = new SparseArray();
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mBaseAdapter = cardArrayAdapter;
        this.mSectionResourceId = sectionResourceId;
        this.mBaseAdapter.registerDataSetObserver(new C01861());
    }

    public void setCardSections(CardSection[] cardSections) {
        this.mCardSections.clear();
        Arrays.sort(cardSections, new C01872());
        int offset = 0;
        for (CardSection cardSection : cardSections) {
            cardSection.sectionedPosition = cardSection.firstPosition + offset;
            this.mCardSections.append(cardSection.sectionedPosition, cardSection);
            offset++;
        }
        notifyDataSetChanged();
    }

    public int positionToSectionedPosition(int position) {
        int offset = 0;
        int i = 0;
        while (i < this.mCardSections.size() && ((CardSection) this.mCardSections.valueAt(i)).firstPosition <= position) {
            offset++;
            i++;
        }
        return position + offset;
    }

    public int sectionedPositionToPosition(int sectionedPosition) {
        if (isSectionHeaderPosition(sectionedPosition)) {
            return -1;
        }
        int offset = 0;
        int i = 0;
        while (i < this.mCardSections.size() && ((CardSection) this.mCardSections.valueAt(i)).sectionedPosition <= sectionedPosition) {
            offset--;
            i++;
        }
        return sectionedPosition + offset;
    }

    public boolean isSectionHeaderPosition(int position) {
        return this.mCardSections.get(position) != null;
    }

    public int getCount() {
        return this.mValid ? this.mBaseAdapter.getCount() + this.mCardSections.size() : 0;
    }

    public Object getItem(int position) {
        if (isSectionHeaderPosition(position)) {
            return this.mCardSections.get(position);
        }
        return this.mBaseAdapter.getItem(sectionedPositionToPosition(position));
    }

    public long getItemId(int position) {
        if (isSectionHeaderPosition(position)) {
            return (long) (ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - this.mCardSections.indexOfKey(position));
        }
        return this.mBaseAdapter.getItemId(sectionedPositionToPosition(position));
    }

    public int getItemViewType(int position) {
        if (isSectionHeaderPosition(position)) {
            return getViewTypeCount() - 1;
        }
        return this.mBaseAdapter.getItemViewType(sectionedPositionToPosition(position));
    }

    public boolean isEnabled(int position) {
        if (isSectionHeaderPosition(position)) {
            return false;
        }
        return this.mBaseAdapter.isEnabled(sectionedPositionToPosition(position));
    }

    public int getViewTypeCount() {
        return this.mBaseAdapter.getViewTypeCount() + 1;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean hasStableIds() {
        return this.mBaseAdapter.hasStableIds();
    }

    public boolean isEmpty() {
        return this.mBaseAdapter.isEmpty();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (isSectionHeaderPosition(position)) {
            return internalSectionView(position, convertView, parent);
        }
        return this.mBaseAdapter.getView(sectionedPositionToPosition(position), convertView, parent);
    }

    protected View internalSectionView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = this.mLayoutInflater.inflate(this.mSectionResourceId, parent, false);
        }
        getSectionView(position, view, parent);
        return view;
    }

    protected View getSectionView(int position, View view, ViewGroup parent) {
        TextView textView = (TextView) view.findViewById(C0173R.id.card_section_simple_title);
        if (textView != null) {
            textView.setText(((CardSection) this.mCardSections.get(position)).title);
        }
        return view;
    }

    public SparseArray<CardSection> getCardSections() {
        return this.mCardSections;
    }
}
