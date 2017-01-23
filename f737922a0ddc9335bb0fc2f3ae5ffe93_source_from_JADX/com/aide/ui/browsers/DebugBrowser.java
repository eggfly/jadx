package com.aide.ui.browsers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.aide.ui.debugger.DebugView;

public class DebugBrowser extends LinearLayout implements a {
    private DebugView j6;

    public DebugBrowser(Context context) {
        super(context);
        Hw();
    }

    public DebugBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Hw();
    }

    private void Hw() {
        setLayoutParams(new LayoutParams(-1, -1));
        removeAllViews();
        View debugView = new DebugView(getContext());
        this.j6 = debugView;
        addView(debugView);
    }

    public void FH() {
        this.j6.j6();
    }

    public void j6() {
    }

    public void DW() {
    }
}
