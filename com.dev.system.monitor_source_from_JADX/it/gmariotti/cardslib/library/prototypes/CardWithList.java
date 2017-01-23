package it.gmariotti.cardslib.library.prototypes;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnSwipeListener;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.prototypes.SwipeDismissListItemViewTouchListener.DismissCallbacks;
import java.util.ArrayList;
import java.util.List;

public abstract class CardWithList extends Card {
    protected int emptyViewId;
    protected int emptyViewViewStubLayoutId;
    protected int listViewId;
    protected CardHeader mCardHeader;
    protected int mChildLayoutId;
    private DataSetObserver mDataObserver;
    private View mEmptyView;
    protected LinearListAdapter mLinearListAdapter;
    private boolean mListShown;
    protected LinearListView mListView;
    private View mProgressView;
    private boolean observerRegistered;
    protected int progressBarId;
    protected int progressBarViewStubLayoutId;
    protected boolean useEmptyView;
    protected boolean useProgressBar;

    /* renamed from: it.gmariotti.cardslib.library.prototypes.CardWithList.1 */
    class C01841 extends DataSetObserver {
        C01841() {
        }

        public void onChanged() {
            CardWithList.this.internalSetupChildren();
        }

        public void onInvalidated() {
            CardWithList.this.internalSetupChildren();
        }
    }

    protected class LinearListAdapter extends ArrayAdapter<ListObject> {
        DismissCallbacks mCallback;
        LayoutInflater mLayoutInflater;
        protected SwipeDismissListItemViewTouchListener mOnTouchListener;

        /* renamed from: it.gmariotti.cardslib.library.prototypes.CardWithList.LinearListAdapter.1 */
        class C01851 implements OnClickListener {
            final /* synthetic */ ListObject val$object;
            final /* synthetic */ int val$position;
            final /* synthetic */ View val$viewChild;

            C01851(ListObject listObject, View view, int i) {
                this.val$object = listObject;
                this.val$viewChild = view;
                this.val$position = i;
            }

            public void onClick(View v) {
                CardWithList.this.mListView.playSoundEffect(0);
                this.val$object.getOnItemClickListener().onItemClick(CardWithList.this.mListView, this.val$viewChild, this.val$position, this.val$object);
            }
        }

        /* renamed from: it.gmariotti.cardslib.library.prototypes.CardWithList.LinearListAdapter.2 */
        class C02512 implements DismissCallbacks {
            C02512() {
            }

            public boolean canDismiss(int position, Card card, ListObject listObject) {
                return listObject.isSwipeable();
            }

            public void onDismiss(LinearListView listView, int position, boolean dismissRight) {
                ListObject object = (ListObject) LinearListAdapter.this.getItem(position);
                LinearListAdapter.this.remove(object);
                if (object.getOnItemSwipeListener() != null) {
                    object.getOnItemSwipeListener().onItemSwipe(object, dismissRight);
                }
            }
        }

        public LinearListAdapter(Context context, List<ListObject> objects) {
            super(context, 0, objects);
            this.mCallback = new C02512();
            this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ListObject object = (ListObject) getItem(position);
            View view = convertView;
            if (view == null) {
                view = this.mLayoutInflater.inflate(CardWithList.this.getChildLayoutId(), parent, false);
            }
            View viewChild = CardWithList.this.setupChildView(position, object, view, parent);
            if (!(viewChild == null || object.getOnItemClickListener() == null)) {
                view.setOnClickListener(new C01851(object, viewChild, position));
            }
            setupItemSwipeAnimation(object, viewChild);
            return viewChild;
        }

        public int getViewTypeCount() {
            return 1;
        }

        protected void setupItemSwipeAnimation(ListObject item, View itemView) {
            if (item.isSwipeable()) {
                if (this.mOnTouchListener == null) {
                    this.mOnTouchListener = new SwipeDismissListItemViewTouchListener(CardWithList.this.mListView, this.mCallback);
                }
                itemView.setOnTouchListener(this.mOnTouchListener);
            }
        }

        public String getChildId(int position) {
            return ((ListObject) getItem(position)).getObjectId();
        }

        public void registerDataSetObserver(DataSetObserver observer) {
            if (!CardWithList.this.observerRegistered) {
                super.registerDataSetObserver(observer);
            }
            CardWithList.this.observerRegistered = true;
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
            if (observer == null) {
                CardWithList.this.observerRegistered = false;
                return;
            }
            super.unregisterDataSetObserver(observer);
            CardWithList.this.observerRegistered = false;
        }
    }

    public interface ListObject {
        String getObjectId();

        OnItemClickListener getOnItemClickListener();

        OnItemSwipeListener getOnItemSwipeListener();

        Card getParentCard();

        boolean isSwipeable();

        void setOnItemClickListener(OnItemClickListener onItemClickListener);

        void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener);

        void setSwipeable(boolean z);
    }

    public interface OnItemClickListener {
        void onItemClick(LinearListView linearListView, View view, int i, ListObject listObject);
    }

    public interface OnItemSwipeListener {
        void onItemSwipe(ListObject listObject, boolean z);
    }

    public class DefaultListObject implements ListObject {
        protected boolean mItemSwipeable;
        protected String mObjectId;
        protected OnItemClickListener mOnItemClickListener;
        protected OnItemSwipeListener mOnItemSwipeListener;
        protected Card mParentCard;

        public DefaultListObject(Card parentCard) {
            this.mItemSwipeable = false;
            this.mParentCard = parentCard;
        }

        public String getObjectId() {
            return this.mObjectId;
        }

        public Card getParentCard() {
            return null;
        }

        public void setObjectId(String objectId) {
            this.mObjectId = objectId;
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        public OnItemClickListener getOnItemClickListener() {
            return this.mOnItemClickListener;
        }

        public boolean isSwipeable() {
            return this.mItemSwipeable;
        }

        public void setSwipeable(boolean isSwipeable) {
            this.mItemSwipeable = isSwipeable;
        }

        public OnItemSwipeListener getOnItemSwipeListener() {
            return this.mOnItemSwipeListener;
        }

        public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
            if (onItemSwipeListener != null) {
                this.mItemSwipeable = true;
            } else {
                this.mItemSwipeable = false;
            }
            this.mOnItemSwipeListener = onItemSwipeListener;
        }
    }

    public abstract int getChildLayoutId();

    protected abstract void initCard();

    protected abstract CardHeader initCardHeader();

    protected abstract List<ListObject> initChildren();

    public abstract View setupChildView(int i, ListObject listObject, View view, ViewGroup viewGroup);

    public CardWithList(Context context) {
        this(context, C0173R.layout.inner_base_main_cardwithlist);
    }

    public CardWithList(Context context, int innerLayout) {
        super(context, innerLayout);
        this.emptyViewId = C0173R.id.card_inner_base_empty_cardwithlist;
        this.emptyViewViewStubLayoutId = C0173R.layout.base_withlist_empty;
        this.progressBarId = C0173R.id.card_inner_base_progressbar_cardwithlist;
        this.progressBarViewStubLayoutId = C0173R.layout.base_withlist_progress;
        this.useEmptyView = true;
        this.useProgressBar = false;
        this.listViewId = C0173R.id.card_inner_base_main_cardwithlist;
        this.observerRegistered = false;
        this.mDataObserver = new C01841();
    }

    public void init() {
        this.mCardHeader = initCardHeader();
        if (this.mCardHeader != null) {
            addCardHeader(this.mCardHeader);
        }
        initCard();
        List<ListObject> mChildren = initChildren();
        if (mChildren == null) {
            mChildren = new ArrayList();
        }
        this.mLinearListAdapter = new LinearListAdapter(super.getContext(), mChildren);
        this.mChildLayoutId = getChildLayoutId();
    }

    protected int getListViewId() {
        return this.listViewId;
    }

    public void setupInnerViewElements(ViewGroup parent, View view) {
        this.mListView = (LinearListView) view.findViewById(getListViewId());
        if (this.mListView != null) {
            internalSetupProgressBar(parent, view);
            if (this.mLinearListAdapter != null) {
                internalSetupChildren();
                this.mLinearListAdapter.registerDataSetObserver(this.mDataObserver);
            }
        }
        internalSetupEmptyView(parent, view);
    }

    private void internalSetupChildren() {
        if (this.mListView != null) {
            this.mListView.removeAllViews();
            boolean z = this.mLinearListAdapter == null || this.mLinearListAdapter.isEmpty();
            updateEmptyStatus(z);
            if (this.mLinearListAdapter != null) {
                this.mListView.setAdapter(this.mLinearListAdapter);
            }
        }
    }

    private void internalSetupEmptyView(ViewGroup parent, View view) {
        if (this.useEmptyView) {
            this.mEmptyView = parent.findViewById(getEmptyViewId());
            if (this.mEmptyView != null) {
                if (this.mEmptyView instanceof ViewStub) {
                    ((ViewStub) this.mEmptyView).setLayoutResource(getEmptyViewViewStubLayoutId());
                }
                setEmptyView(this.mEmptyView);
            }
        }
    }

    private void internalSetupProgressBar(ViewGroup parent, View view) {
        if (this.useProgressBar) {
            this.mProgressView = parent.findViewById(getProgressBarId());
            this.mListShown = true;
            if (this.mProgressView != null) {
                if (this.mProgressView instanceof ViewStub) {
                    ((ViewStub) this.mProgressView).setLayoutResource(getProgressBarViewStubLayoutId());
                }
                setProgressView(this.mProgressView);
            }
        }
    }

    public void unregisterDataSetObserver() {
        if (this.mLinearListAdapter != null) {
            this.mLinearListAdapter.unregisterDataSetObserver(this.mDataObserver);
        }
    }

    public OnSwipeListener getOnSwipeListener() {
        return this.mOnSwipeListener;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        if (onSwipeListener != null) {
            this.mIsSwipeable = true;
        } else {
            this.mIsSwipeable = false;
        }
        this.mOnSwipeListener = onSwipeListener;
    }

    public void setEmptyView(View emptyView) {
        boolean z;
        boolean empty;
        this.mEmptyView = emptyView;
        if (emptyView != null) {
            z = true;
        } else {
            z = false;
        }
        this.useEmptyView = z;
        LinearListAdapter adapter = getLinearListAdapter();
        if (adapter == null || adapter.isEmpty()) {
            empty = true;
        } else {
            empty = false;
        }
        updateEmptyStatus(empty);
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    private void updateEmptyStatus(boolean empty) {
        if (!isUseEmptyView()) {
            return;
        }
        if (!empty) {
            if (this.mEmptyView != null) {
                this.mEmptyView.setVisibility(8);
            }
            this.mListView.setVisibility(0);
        } else if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(0);
            this.mListView.setVisibility(8);
        } else {
            this.mListView.setVisibility(0);
        }
    }

    public View getProgressView() {
        return this.mProgressView;
    }

    public void setProgressView(View progressView) {
        this.mProgressView = progressView;
        this.useProgressBar = progressView != null;
    }

    public void updateProgressBar(boolean shownList, boolean animate) {
        boolean empty = false;
        if (isUseProgressBar() && this.mListShown != shownList) {
            this.mListShown = shownList;
            if (shownList) {
                if (animate) {
                    this.mProgressView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.mListView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                    if (this.useEmptyView && this.mEmptyView != null) {
                        this.mEmptyView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                    }
                }
                this.mProgressView.setVisibility(8);
                LinearListAdapter adapter = getLinearListAdapter();
                if (adapter == null || adapter.isEmpty()) {
                    empty = true;
                }
                updateEmptyStatus(empty);
                return;
            }
            if (animate) {
                this.mProgressView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.mListView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                if (this.useEmptyView && this.mEmptyView != null) {
                    this.mEmptyView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                }
            }
            this.mProgressView.setVisibility(0);
            this.mListView.setVisibility(4);
            if (this.useEmptyView && this.mEmptyView != null) {
                this.mEmptyView.setVisibility(4);
            }
        }
    }

    public LinearListAdapter getLinearListAdapter() {
        return this.mLinearListAdapter;
    }

    public void setLinearListAdapter(LinearListAdapter linearListAdapter) {
        this.mLinearListAdapter = linearListAdapter;
    }

    public int getEmptyViewId() {
        return this.emptyViewId;
    }

    public void setEmptyViewId(int emptyViewId) {
        this.emptyViewId = emptyViewId;
    }

    public int getProgressBarId() {
        return this.progressBarId;
    }

    public void setProgressBarId(int progressBarId) {
        this.progressBarId = progressBarId;
    }

    private boolean isUseEmptyView() {
        if (this.mEmptyView != null) {
            return this.useEmptyView;
        }
        return false;
    }

    public void setUseEmptyView(boolean useEmptyView) {
        this.useEmptyView = useEmptyView;
    }

    private boolean isUseProgressBar() {
        if (this.mProgressView != null) {
            return this.useProgressBar;
        }
        return false;
    }

    public void setUseProgressBar(boolean useProgressBar) {
        this.useProgressBar = useProgressBar;
    }

    public void setListViewId(int listViewId) {
        this.listViewId = listViewId;
    }

    public int getEmptyViewViewStubLayoutId() {
        return this.emptyViewViewStubLayoutId;
    }

    public void setEmptyViewViewStubLayoutId(int emptyViewViewStubLayoutId) {
        this.emptyViewViewStubLayoutId = emptyViewViewStubLayoutId;
    }

    public int getProgressBarViewStubLayoutId() {
        return this.progressBarViewStubLayoutId;
    }

    public void setProgressBarViewStubLayoutId(int progressBarViewStubLayoutId) {
        this.progressBarViewStubLayoutId = progressBarViewStubLayoutId;
    }
}
