package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public abstract class PullToRequestListAdapter extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableListView listView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    /* renamed from: com.mob.tools.gui.PullToRequestListAdapter.1 */
    class C40111 implements OnScrollListener {
        private int firstVisibleItem;
        private int visibleItemCount;

        C40111() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.firstVisibleItem = i;
            this.visibleItemCount = i2;
            View childAt = absListView.getChildAt(i2 - 1);
            PullToRequestListAdapter pullToRequestListAdapter = PullToRequestListAdapter.this;
            boolean z = i + i2 == i3 && childAt != null && childAt.getBottom() <= absListView.getBottom();
            pullToRequestListAdapter.pullUpReady = z;
            PullToRequestListAdapter.this.onScroll(PullToRequestListAdapter.this.listView, i, i2, i3);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            PullToRequestListAdapter.this.fling = i == 2;
            if (i != 0) {
                return;
            }
            if (PullToRequestListAdapter.this.osListener != null) {
                PullToRequestListAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
            } else if (PullToRequestListAdapter.this.adapter != null) {
                PullToRequestListAdapter.this.adapter.notifyDataSetChanged();
            }
        }
    }

    public PullToRequestListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.listView = onNewListView(getContext());
        this.listView.setOnScrollListener(new C40111());
        this.adapter = new PullToRequestBaseAdapter(this);
        this.listView.setAdapter(this.adapter);
    }

    public Scrollable getBodyView() {
        return this.listView;
    }

    public ListView getListView() {
        return this.listView;
    }

    public boolean isFling() {
        return this.fling;
    }

    public boolean isPullDownReady() {
        return this.listView.isReadyToPull();
    }

    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    protected ScrollableListView onNewListView(Context context) {
        return new ScrollableListView(context);
    }

    public void onScroll(Scrollable scrollable, int i, int i2, int i3) {
    }

    public void setDivider(Drawable drawable) {
        this.listView.setDivider(drawable);
    }

    public void setDividerHeight(int i) {
        this.listView.setDividerHeight(i);
    }
}
