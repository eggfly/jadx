package com.mob.tools.gui;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;

public abstract class PullToRequestGridAdapter extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableGridView gridView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    /* renamed from: com.mob.tools.gui.PullToRequestGridAdapter.1 */
    class C40101 implements OnScrollListener {
        private int firstVisibleItem;
        private int visibleItemCount;

        C40101() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.firstVisibleItem = i;
            this.visibleItemCount = i2;
            View childAt = absListView.getChildAt(i2 - 1);
            PullToRequestGridAdapter pullToRequestGridAdapter = PullToRequestGridAdapter.this;
            boolean z = i + i2 == i3 && childAt != null && childAt.getBottom() <= absListView.getBottom();
            pullToRequestGridAdapter.pullUpReady = z;
            PullToRequestGridAdapter.this.onScroll(PullToRequestGridAdapter.this.gridView, i, i2, i3);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            PullToRequestGridAdapter.this.fling = i == 2;
            if (i != 0) {
                return;
            }
            if (PullToRequestGridAdapter.this.osListener != null) {
                PullToRequestGridAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
            } else if (PullToRequestGridAdapter.this.adapter != null) {
                PullToRequestGridAdapter.this.adapter.notifyDataSetChanged();
            }
        }
    }

    public PullToRequestGridAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.gridView = onNewGridView(getContext());
        this.gridView.setOnScrollListener(new C40101());
        this.adapter = new PullToRequestBaseAdapter(this);
        this.gridView.setAdapter(this.adapter);
    }

    public Scrollable getBodyView() {
        return this.gridView;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public boolean isFling() {
        return this.fling;
    }

    public boolean isPullDownReady() {
        return this.gridView.isReadyToPull();
    }

    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    protected ScrollableGridView onNewGridView(Context context) {
        return new ScrollableGridView(context);
    }

    public void onScroll(Scrollable scrollable, int i, int i2, int i3) {
    }

    public void setColumnWidth(int i) {
        this.gridView.setColumnWidth(i);
    }

    public void setHorizontalSpacing(int i) {
        this.gridView.setHorizontalSpacing(i);
    }

    public void setNumColumns(int i) {
        this.gridView.setNumColumns(i);
    }

    public void setStretchMode(int i) {
        this.gridView.setStretchMode(i);
    }

    public void setVerticalSpacing(int i) {
        this.gridView.setVerticalSpacing(i);
    }
}
