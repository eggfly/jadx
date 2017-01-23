package com.aide.uidesigner;

import android.view.ViewGroup.MarginLayoutParams;

public class ProxyMarginLayoutParams {
    private MarginLayoutParams params;

    public ProxyMarginLayoutParams(Object obj) {
        this.params = (MarginLayoutParams) obj;
    }

    public void setMargin(int i) {
        this.params.setMargins(i, i, i, i);
    }
}
