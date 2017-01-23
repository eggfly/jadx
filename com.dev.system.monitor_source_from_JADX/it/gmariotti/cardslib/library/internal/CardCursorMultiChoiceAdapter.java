package it.gmariotti.cardslib.library.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView.MultiChoiceModeListener;
import it.gmariotti.cardslib.library.internal.multichoice.DefaultOptionMultiChoice;
import it.gmariotti.cardslib.library.internal.multichoice.MultiChoiceAdapter;
import it.gmariotti.cardslib.library.internal.multichoice.MultiChoiceAdapterHelperBase;
import it.gmariotti.cardslib.library.internal.multichoice.OptionMultiChoice;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;

public abstract class CardCursorMultiChoiceAdapter extends CardCursorAdapter implements MultiChoiceAdapter, MultiChoiceModeListener {
    private MultiChoiceAdapterHelperBase mHelper;
    protected OptionMultiChoice mOptions;

    public CardCursorMultiChoiceAdapter(Context context) {
        this(context, new DefaultOptionMultiChoice());
    }

    public CardCursorMultiChoiceAdapter(Context context, OptionMultiChoice options) {
        super(context, null, true);
        this.mHelper = new MultiChoiceAdapterHelperBase(this);
        this.mOptions = options;
        this.mHelper.setMultiChoiceModeListener(this);
    }

    public void setCardListView(CardListView cardListView) {
        super.setCardListView(cardListView);
        this.mHelper.setAdapterView(cardListView);
    }

    protected void setupMultichoice(View view, Card mCard, CardView mCardView, long position) {
        super.setupMultichoice(view, mCard, mCardView, position);
        this.mHelper.setupMultichoice(view, mCard, mCardView, position);
    }

    public Card getItem(int position) {
        Card card = super.getItem(position);
        card.mMultiChoiceEnabled = true;
        return card;
    }

    public boolean startActionMode(Activity activity) {
        return this.mHelper.startActionMode(activity);
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return this.mHelper.onCreateActionMode(mode, menu);
    }

    public void onDestroyActionMode(ActionMode mode) {
        this.mHelper.onDestroyActionMode(mode);
    }

    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        this.mHelper.onItemCheckedStateChanged(mode, position, id, checked);
    }

    public boolean isActionModeStarted() {
        return this.mHelper.isActionModeStarted();
    }

    protected ArrayList<Card> getSelectedCards() {
        return this.mHelper.getSelectedCards();
    }

    public OptionMultiChoice getOptionMultiChoice() {
        return this.mOptions;
    }
}
