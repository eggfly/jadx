package com.aide.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class AIDEAnalysisProgressBar extends ProgressBar {
    private int j6;

    public AIDEAnalysisProgressBar(Context context) {
        super(context);
        this.j6 = -1;
        DW();
    }

    public AIDEAnalysisProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = -1;
        DW();
    }

    public AIDEAnalysisProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = -1;
        DW();
    }

    private void DW() {
        j6();
    }

    public void j6() {
        int Zo = e.aM().Zo();
        int v5 = e.aM().v5();
        if (Zo == 0) {
            v5 = 0;
        } else {
            v5 = (v5 * 100) / Zo;
        }
        v5 = (v5 / 5) * 5;
        if (!e.aM().Hw()) {
            v5 = 0;
        }
        if (Zo < 20) {
            v5 = 0;
        }
        if (this.j6 != v5) {
            this.j6 = v5;
            if (v5 != 0) {
                setVisibility(0);
                setProgress(v5);
                return;
            }
            setVisibility(4);
        }
    }
}
