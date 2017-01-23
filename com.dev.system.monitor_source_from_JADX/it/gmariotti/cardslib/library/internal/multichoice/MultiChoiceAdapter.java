package it.gmariotti.cardslib.library.internal.multichoice;

import android.view.ActionMode;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;

public interface MultiChoiceAdapter {
    Card getItem(int i);

    long getItemId(int i);

    OptionMultiChoice getOptionMultiChoice();

    int getPosition(Card card);

    boolean isActionModeStarted();

    void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z, CardView cardView, Card card);
}
