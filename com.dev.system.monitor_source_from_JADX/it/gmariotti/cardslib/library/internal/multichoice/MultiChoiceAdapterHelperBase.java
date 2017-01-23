package it.gmariotti.cardslib.library.internal.multichoice;

import android.app.Activity;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;

public class MultiChoiceAdapterHelperBase implements OnItemLongClickListener, OnItemClickListener {
    protected static final String TAG;
    protected ActionMode actionMode;
    private boolean ignoreCheckedListener;
    protected AbsListView mAdapterView;
    protected MultiChoiceModeListener mMultiChoiceModeListener;
    protected BaseAdapter owner;

    /* renamed from: it.gmariotti.cardslib.library.internal.multichoice.MultiChoiceAdapterHelperBase.1 */
    class C01801 implements OnClickListener {
        final /* synthetic */ MultiChoiceAdapter val$adapter;

        C01801(MultiChoiceAdapter multiChoiceAdapter) {
            this.val$adapter = multiChoiceAdapter;
        }

        public void onClick(View v) {
            int position = this.val$adapter.getPosition(((CardView) v).getCard());
            MultiChoiceAdapterHelperBase.this.onItemClick(MultiChoiceAdapterHelperBase.this.mAdapterView, v, position, this.val$adapter.getItemId(position));
        }
    }

    static {
        TAG = MultiChoiceAdapterHelperBase.class.getSimpleName();
    }

    public MultiChoiceAdapterHelperBase(BaseAdapter owner) {
        this.owner = owner;
    }

    public void setAdapterView(AbsListView adapterView) {
        this.mAdapterView = adapterView;
        this.mAdapterView.setMultiChoiceModeListener(this.mMultiChoiceModeListener);
    }

    public void setupMultichoice(View view, Card mCard, CardView mCardView, long position) {
        OnClickListener advanceClickListener = new C01801(this.owner);
        if (mCard.isCheckable()) {
            mCardView.setOnClickListener(advanceClickListener);
        } else if (mCard.getOnClickListener() != null) {
            mCardView.setOnClickListener(advanceClickListener);
        }
    }

    protected void setItemChecked(long handle, boolean checked) {
        if (checked) {
            checkItem(handle);
        } else {
            uncheckItem(handle);
        }
    }

    protected void checkItem(long handle) {
        this.mAdapterView.setItemChecked((int) handle, true);
    }

    protected void uncheckItem(long handle) {
        this.mAdapterView.setItemChecked((int) handle, false);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        boolean z = false;
        if (!isCardCheckable(position)) {
            return false;
        }
        long handle = positionToSelectionHandle(correctPositionAccountingForHeader(adapterView, position));
        boolean wasChecked = this.mAdapterView.isItemChecked((int) handle);
        setItemChecked(handle, !wasChecked);
        if (!wasChecked) {
            z = true;
        }
        view.setActivated(z);
        if (this.actionMode != null) {
        }
        return true;
    }

    private int correctPositionAccountingForHeader(AdapterView<?> adapterView, int position) {
        ListView listView = adapterView instanceof ListView ? (ListView) adapterView : null;
        if ((listView == null ? 0 : listView.getHeaderViewsCount()) > 0) {
            return position - listView.getHeaderViewsCount();
        }
        return position;
    }

    protected long positionToSelectionHandle(int position) {
        return (long) position;
    }

    public boolean isCardCheckable(int position) {
        Card card = this.owner.getItem(position);
        if (card != null) {
            return card.isCheckable();
        }
        return false;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MultiChoiceAdapter adapter = this.owner;
        if (!adapter.getOptionMultiChoice().isSelectItemClickInActionMode()) {
            internal_onItemClick(parent, view, position, id);
        } else if (adapter.isActionModeStarted()) {
            onItemLongClick(parent, view, position, id);
        } else {
            internal_onItemClick(parent, view, position, id);
        }
    }

    public void internal_onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Card mCard = this.owner.getItem(position);
        if (mCard != null && mCard.getOnClickListener() != null) {
            mCard.getOnClickListener().onClick(mCard, view);
        }
    }

    public boolean startActionMode(Activity activity) {
        if (!(activity == null || isActionModeStarted())) {
            activity.startActionMode(this.mMultiChoiceModeListener);
        }
        return false;
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        this.actionMode = mode;
        onItemSelectedStateChanged(mode);
        return false;
    }

    public void onDestroyActionMode(ActionMode mode) {
        this.actionMode = null;
    }

    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        onItemSelectedStateChanged(mode);
        MultiChoiceAdapter adapter = this.owner;
        Card card = adapter.getItem(position);
        adapter.onItemCheckedStateChanged(mode, position, id, checked, card.getCardView(), card);
    }

    protected void onItemSelectedStateChanged(ActionMode mode) {
        int count = this.mAdapterView.getCheckedItemCount();
        if (count > 0) {
            mode.setTitle(this.mAdapterView.getResources().getQuantityString(C0173R.plurals.card_selected_items, count, new Object[]{Integer.valueOf(count)}));
        }
    }

    public boolean isActionModeStarted() {
        if (this.actionMode != null) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getSelectedCards() {
        SparseBooleanArray checked = this.mAdapterView.getCheckedItemPositions();
        ArrayList<Card> items = new ArrayList();
        MultiChoiceAdapter adapter = this.owner;
        for (int i = checked.size() - 1; i >= 0; i--) {
            if (checked.valueAt(i)) {
                items.add(adapter.getItem(checked.keyAt(i)));
            }
        }
        return items;
    }

    public MultiChoiceModeListener getMultiChoiceModeListener() {
        return this.mMultiChoiceModeListener;
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        this.mMultiChoiceModeListener = multiChoiceModeListener;
    }
}
