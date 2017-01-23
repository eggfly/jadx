package it.gmariotti.cardslib.library.view.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class SwipeOnScrollListener implements OnScrollListener {
    private SwipeDismissListViewTouchListener mTouchListener;

    public void setTouchListener(SwipeDismissListViewTouchListener touchListener) {
        this.mTouchListener = touchListener;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        boolean z = true;
        if (this.mTouchListener != null) {
            SwipeDismissListViewTouchListener swipeDismissListViewTouchListener = this.mTouchListener;
            if (scrollState == 1) {
                z = false;
            }
            swipeDismissListViewTouchListener.setEnabled(z);
        }
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }
}
