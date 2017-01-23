package com.aide.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.aide.uidesigner.ProxyTextView;
import qg;

public class o implements TextWatcher, OnEditorActionListener {
    private a DW;
    private MainActivity j6;

    class 1 implements Runnable {
        final /* synthetic */ o DW;
        final /* synthetic */ EditText j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.requestFocus();
            }
        }

        1(o oVar, EditText editText) {
            this.DW = oVar;
            this.j6 = editText;
        }

        public void run() {
            ((InputMethodManager) this.DW.j6.getSystemService("input_method")).showSoftInput(this.j6, 1);
            this.j6.postDelayed(new 1(this), 300);
        }
    }

    static /* synthetic */ class 2 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[a.values().length];
            try {
                j6[a.GotoLine.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[a.SearchText.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private enum a {
        SearchText,
        GotoLine
    }

    public o(MainActivity mainActivity) {
        this.j6 = mainActivity;
    }

    private View v5() {
        return this.j6.findViewById(R.b.mainSearchBarNoTabs);
    }

    private EditText Zo() {
        return (EditText) this.j6.findViewById(R.b.mainSearchBox);
    }

    private TextView VH() {
        return (TextView) this.j6.findViewById(R.b.mainSearchLabel);
    }

    public void j6() {
        j6(a.SearchText);
    }

    public void DW() {
        j6(a.GotoLine);
    }

    private void j6(a aVar) {
        this.DW = aVar;
        v5().setVisibility(0);
        TextView VH = VH();
        switch (2.j6[aVar.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                VH.setText("Line:");
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                VH.setText("Search:");
                break;
        }
        EditText Zo = Zo();
        switch (2.j6[aVar.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                Zo.setText(this.j6.sh().getCurrentFileSpan().DW + "");
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                Zo.setText("");
                break;
        }
        Zo.requestFocus();
        Zo.selectAll();
        switch (2.j6[aVar.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                Zo.setImeOptions(268435456);
                Zo.setInputType(2);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                Zo.setImeOptions(268435461);
                Zo.setInputType(ProxyTextView.INPUTTYPE_textVisiblePassword);
                break;
        }
        Zo.setOnEditorActionListener(this);
        Zo.removeTextChangedListener(this);
        Zo.addTextChangedListener(this);
        Zo.postDelayed(new 1(this, Zo), 100);
    }

    public void FH() {
        v5().setVisibility(8);
        this.j6.sh().j3();
    }

    public boolean Hw() {
        return v5().getVisibility() == 0;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        switch (2.j6[this.DW.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                try {
                    int parseInt = Integer.parseInt(gn());
                    this.j6.sh().j6(parseInt, 1, parseInt, 1);
                } catch (NumberFormatException e) {
                }
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                this.j6.sh().j6(1, 1, gn());
            default:
        }
    }

    private String gn() {
        return Zo().getText().toString().trim();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getAction() == 0) {
            switch (2.j6[this.DW.ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    FH();
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    AIDEEditorPager sh = this.j6.sh();
                    qg currentFileSpan = sh.getCurrentFileSpan();
                    if (!sh.j6(currentFileSpan.DW, currentFileSpan.FH + 1, gn())) {
                        this.j6.sh().j6(1, 1, gn());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
