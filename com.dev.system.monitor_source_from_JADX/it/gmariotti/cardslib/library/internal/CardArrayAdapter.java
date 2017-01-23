package it.gmariotti.cardslib.library.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.base.BaseCardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;
import it.gmariotti.cardslib.library.view.listener.SwipeDismissListViewTouchListener;
import it.gmariotti.cardslib.library.view.listener.SwipeDismissListViewTouchListener.DismissCallbacks;
import it.gmariotti.cardslib.library.view.listener.SwipeOnScrollListener;
import it.gmariotti.cardslib.library.view.listener.UndoBarController;
import it.gmariotti.cardslib.library.view.listener.UndoBarController.DefaultUndoBarUIElements;
import it.gmariotti.cardslib.library.view.listener.UndoBarController.UndoListener;
import it.gmariotti.cardslib.library.view.listener.UndoCard;
import java.util.HashMap;
import java.util.List;

public class CardArrayAdapter extends BaseCardArrayAdapter implements UndoListener {
    protected static String TAG;
    DismissCallbacks mCallback;
    protected CardListView mCardListView;
    protected boolean mEnableUndo;
    protected HashMap<String, Card> mInternalObjects;
    protected SwipeDismissListViewTouchListener mOnTouchListener;
    protected UndoBarController mUndoBarController;

    /* renamed from: it.gmariotti.cardslib.library.internal.CardArrayAdapter.1 */
    class C02491 implements DismissCallbacks {
        C02491() {
        }

        public boolean canDismiss(int position, Card card) {
            return card.isSwipeable();
        }

        public void onDismiss(ListView listView, int[] reverseSortedPositions) {
            int[] itemPositions = new int[reverseSortedPositions.length];
            String[] itemIds = new String[reverseSortedPositions.length];
            int i = 0;
            for (int position : reverseSortedPositions) {
                Card card = null;
                if (listView.getAdapter() != null && (listView.getAdapter().getItem(position) instanceof Card)) {
                    card = (Card) listView.getAdapter().getItem(position);
                }
                if (card != null) {
                    itemPositions[i] = position;
                    itemIds[i] = card.getId();
                    i++;
                    CardArrayAdapter.this.remove(card);
                    if (card.getOnSwipeListener() != null) {
                        card.getOnSwipeListener().onSwipe(card);
                    }
                } else {
                    Log.e(CardArrayAdapter.TAG, "Error on swipe action. Impossible to retrieve the card from position");
                }
            }
            CardArrayAdapter.this.notifyDataSetChanged();
            if (CardArrayAdapter.this.isEnableUndo() && CardArrayAdapter.this.mUndoBarController != null) {
                UndoCard itemUndo = new UndoCard(itemPositions, itemIds);
                String messageUndoBar = null;
                if (CardArrayAdapter.this.getUndoBarController().getUndoBarUIElements() != null) {
                    messageUndoBar = CardArrayAdapter.this.getUndoBarController().getUndoBarUIElements().getMessageUndo(CardArrayAdapter.this, itemIds, itemPositions);
                }
                if (messageUndoBar == null && CardArrayAdapter.this.getContext() != null) {
                    Resources res = CardArrayAdapter.this.getContext().getResources();
                    if (res != null) {
                        messageUndoBar = res.getQuantityString(C0173R.plurals.list_card_undo_items, reverseSortedPositions.length, new Object[]{Integer.valueOf(reverseSortedPositions.length)});
                    }
                }
                CardArrayAdapter.this.mUndoBarController.showUndoBar(false, messageUndoBar, itemUndo);
            }
        }
    }

    static {
        TAG = "CardArrayAdapter";
    }

    public CardArrayAdapter(Context context, List<Card> cards) {
        super(context, cards);
        this.mEnableUndo = false;
        this.mCallback = new C02491();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        Card mCard = (Card) getItem(position);
        if (mCard != null) {
            boolean recycle;
            int layout = this.mRowLayoutId;
            if (view == null) {
                recycle = false;
                view = mInflater.inflate(layout, parent, false);
            } else {
                recycle = true;
            }
            CardView mCardView = (CardView) view.findViewById(C0173R.id.list_cardId);
            if (mCardView != null) {
                mCardView.setForceReplaceInnerLayout(Card.equalsInnerLayout(mCardView.getCard(), mCard));
                mCardView.setRecycle(recycle);
                boolean origianlSwipeable = mCard.isSwipeable();
                mCard.setSwipeable(false);
                mCardView.setCard(mCard);
                mCard.setSwipeable(origianlSwipeable);
                if ((mCard.getCardHeader() != null && mCard.getCardHeader().isButtonExpandVisible()) || mCard.getViewToClickToExpand() != null) {
                    setupExpandCollapseListAnimation(mCardView);
                }
                setupSwipeableAnimation(mCard, mCardView);
                setupMultichoice(view, mCard, mCardView, (long) position);
            }
        }
        return view;
    }

    protected void setupSwipeableAnimation(Card card, CardView cardView) {
        if (card.isSwipeable()) {
            if (this.mOnTouchListener == null) {
                this.mOnTouchListener = new SwipeDismissListViewTouchListener(this.mCardListView, this.mCallback);
                if (this.mCardListView.getOnScrollListener() == null) {
                    SwipeOnScrollListener scrollListener = new SwipeOnScrollListener();
                    scrollListener.setTouchListener(this.mOnTouchListener);
                    this.mCardListView.setOnScrollListener(scrollListener);
                } else {
                    OnScrollListener onScrollListener = this.mCardListView.getOnScrollListener();
                    if (onScrollListener instanceof SwipeOnScrollListener) {
                        ((SwipeOnScrollListener) onScrollListener).setTouchListener(this.mOnTouchListener);
                    }
                }
                this.mCardListView.setOnTouchListener(this.mOnTouchListener);
            }
            cardView.setOnTouchListener(this.mOnTouchListener);
            return;
        }
        cardView.setOnTouchListener(null);
    }

    protected void setupExpandCollapseListAnimation(CardView cardView) {
        if (cardView != null) {
            cardView.setOnExpandListAnimatorListener(this.mCardListView);
        }
    }

    public void onUndo(Parcelable token) {
        if (token != null) {
            UndoCard item = (UndoCard) token;
            int[] itemPositions = item.itemPosition;
            String[] itemIds = item.itemId;
            if (itemPositions != null) {
                for (int i = itemPositions.length - 1; i >= 0; i--) {
                    int itemPosition = itemPositions[i];
                    String id = itemIds[i];
                    if (id == null) {
                        Log.w(TAG, "You have to set a id value to use the undo action");
                    } else {
                        Card card = (Card) this.mInternalObjects.get(id);
                        if (card != null) {
                            insert(card, itemPosition);
                            notifyDataSetChanged();
                            if (card.getOnUndoSwipeListListener() != null) {
                                card.getOnUndoSwipeListListener().onUndoSwipe(card);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isEnableUndo() {
        return this.mEnableUndo;
    }

    public void setEnableUndo(boolean enableUndo) {
        this.mEnableUndo = enableUndo;
        if (enableUndo) {
            this.mInternalObjects = new HashMap();
            for (int i = 0; i < getCount(); i++) {
                Card card = (Card) getItem(i);
                this.mInternalObjects.put(card.getId(), card);
            }
            if (this.mUndoBarController == null) {
                if (this.mUndoBarUIElements == null) {
                    this.mUndoBarUIElements = new DefaultUndoBarUIElements();
                }
                if (this.mContext == null || !(this.mContext instanceof Activity)) {
                    Log.e(TAG, "Undo Action requires a valid Activity context");
                    throw new IllegalArgumentException("Undo Action requires a valid Activity context");
                }
                View undobar = ((Activity) this.mContext).findViewById(this.mUndoBarUIElements.getUndoBarId());
                if (undobar != null) {
                    this.mUndoBarController = new UndoBarController(undobar, this, this.mUndoBarUIElements);
                    return;
                }
                return;
            }
            return;
        }
        this.mUndoBarController = null;
    }

    public CardListView getCardListView() {
        return this.mCardListView;
    }

    public void setCardListView(CardListView cardListView) {
        this.mCardListView = cardListView;
    }

    public UndoBarController getUndoBarController() {
        return this.mUndoBarController;
    }
}
