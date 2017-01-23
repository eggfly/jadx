package com.antutu.utils.widget;

import com.antutu.utils.widget.ViewFlow.ViewSwitchListener;

public interface FlowIndicator extends ViewSwitchListener {
    void onScrolled(int i, int i2, int i3, int i4);

    void setViewFlow(ViewFlow viewFlow);
}
