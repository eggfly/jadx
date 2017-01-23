package com.fortysevendeg.swipelistview;

public interface SwipeListViewListener {
    int onChangeSwipeMode(int i);

    void onChoiceChanged(int i, boolean z);

    void onChoiceEnded();

    void onChoiceStarted();

    void onClickBackView(int i);

    void onClickFrontView(int i);

    void onClosed(int i, boolean z);

    void onDismiss(int[] iArr);

    void onFirstListItem();

    void onLastListItem();

    void onListChanged();

    void onMove(int i, float f);

    void onOpened(int i, boolean z);

    void onStartClose(int i, boolean z);

    void onStartOpen(int i, int i2, boolean z);
}
