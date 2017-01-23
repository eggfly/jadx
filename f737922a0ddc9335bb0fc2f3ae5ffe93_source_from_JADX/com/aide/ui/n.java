package com.aide.ui;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.aide.common.d;

public class n {
    private View DW;
    private String FH;
    private boolean Hw;
    private MainActivity j6;
    private KeyCharacterMap v5;

    class 1 implements OnClickListener {
        final /* synthetic */ n j6;

        1(n nVar) {
            this.j6 = nVar;
        }

        public void onClick(View view) {
            this.j6.DW(true);
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ n j6;

        2(n nVar) {
            this.j6 = nVar;
        }

        public void onClick(View view) {
            this.j6.DW(false);
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ n DW;
        final /* synthetic */ String j6;

        3(n nVar, String str) {
            this.DW = nVar;
            this.j6 = str;
        }

        public void onClick(View view) {
            int i = 0;
            if (this.DW.v5 == null) {
                this.DW.v5 = KeyCharacterMap.load(0);
            }
            KeyEvent[] events = this.DW.v5.getEvents(this.j6.toCharArray());
            if (events != null) {
                int length = events.length;
                while (i < length) {
                    this.DW.j6.dispatchKeyEvent(events[i]);
                    i++;
                }
            }
        }
    }

    public n(MainActivity mainActivity) {
        this.FH = "";
        this.j6 = mainActivity;
        this.DW = LayoutInflater.from(mainActivity).inflate(R.c.quickkeysbar, (ViewGroup) mainActivity.findViewById(R.b.mainQuickKeyBarContainer));
        boolean z = d.v5(mainActivity) >= 360.0f && d.Hw((Context) mainActivity);
        DW(z);
        this.DW.findViewById(R.b.quickKeyBarOpenButton).setOnClickListener(new 1(this));
        this.DW.findViewById(R.b.quickKeyBarCloseButton).setOnClickListener(new 2(this));
    }

    private void DW(boolean z) {
        this.Hw = z;
        if (z) {
            this.DW.findViewById(R.b.quickKeyBarOpenButtonContainer).setVisibility(8);
            this.DW.findViewById(R.b.quickKeyBarKeysContainer).setVisibility(0);
            return;
        }
        this.DW.findViewById(R.b.quickKeyBarOpenButtonContainer).setVisibility(0);
        this.DW.findViewById(R.b.quickKeyBarKeysContainer).setVisibility(8);
    }

    public int j6() {
        if (this.Hw) {
            return (int) (40.0f * this.j6.getResources().getDisplayMetrics().density);
        }
        return 0;
    }

    public void j6(String str) {
        if (this.DW != null && str != null && !this.FH.equals(str)) {
            int i;
            this.FH = str;
            LayoutInflater from = LayoutInflater.from(this.j6);
            if (d.v5(this.j6) >= 400.0f) {
                i = (int) (60.0f * this.j6.getResources().getDisplayMetrics().density);
            } else {
                i = (int) (30.0f * this.j6.getResources().getDisplayMetrics().density);
            }
            int i2 = (int) (40.0f * this.j6.getResources().getDisplayMetrics().density);
            ViewGroup viewGroup = (ViewGroup) this.DW.findViewById(R.b.quickKeyBarList);
            viewGroup.removeAllViews();
            for (String replace : str.split(" ")) {
                CharSequence replace2 = replace.replace("s", " ");
                TextView textView = (TextView) from.inflate(R.c.quickkeysbar_key, null);
                if (replace2.trim().length() == 0) {
                    textView.setText("\u21e5");
                } else {
                    textView.setText(replace2);
                }
                viewGroup.addView(textView, new LayoutParams(i, i2));
                textView.setOnClickListener(new 3(this, replace2));
            }
        }
    }

    public void j6(boolean z) {
        if (this.DW != null) {
            this.DW.findViewById(R.b.quickKeyBar).setVisibility(z ? 0 : 8);
        }
    }
}
