package com.aide.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.aide.ui.R;

public class t extends m {
    private String DW;
    private y<String> FH;
    private Runnable Hw;
    private boolean Zo;
    private String j6;
    private AlertDialog v5;

    class 1 implements OnSeekBarChangeListener {
        final /* synthetic */ SeekBar DW;
        final /* synthetic */ t FH;
        final /* synthetic */ EditText j6;

        1(t tVar, EditText editText, SeekBar seekBar) {
            this.FH = tVar;
            this.j6 = editText;
            this.DW = seekBar;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (!this.FH.Zo) {
                this.j6.setText(this.FH.j6(this.DW, this.j6.getText().toString()));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class 2 implements TextWatcher {
        final /* synthetic */ EditText DW;
        final /* synthetic */ t FH;
        final /* synthetic */ SeekBar j6;

        2(t tVar, SeekBar seekBar, EditText editText) {
            this.FH = tVar;
            this.j6 = seekBar;
            this.DW = editText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.FH.Zo = true;
            this.FH.DW(this.j6, this.DW.getText().toString());
            this.FH.Zo = false;
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ SeekBar DW;
        final /* synthetic */ t FH;
        final /* synthetic */ EditText j6;

        3(t tVar, EditText editText, SeekBar seekBar) {
            this.FH = tVar;
            this.j6 = editText;
            this.DW = seekBar;
        }

        public void onClick(View view) {
            this.j6.setText(this.FH.j6(this.j6.getText().toString()));
            this.FH.DW(this.DW, this.j6.getText().toString());
        }
    }

    class 4 implements OnClickListener {
        final /* synthetic */ SeekBar DW;
        final /* synthetic */ t FH;
        final /* synthetic */ EditText j6;

        4(t tVar, EditText editText, SeekBar seekBar) {
            this.FH = tVar;
            this.j6 = editText;
            this.DW = seekBar;
        }

        public void onClick(View view) {
            this.j6.setText(this.FH.DW(this.j6.getText().toString()));
            this.FH.DW(this.DW, this.j6.getText().toString());
        }
    }

    class 5 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditText DW;
        final /* synthetic */ t FH;
        final /* synthetic */ Activity j6;

        5(t tVar, Activity activity, EditText editText) {
            this.FH = tVar;
            this.j6 = activity;
            this.DW = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
            this.FH.Hw.run();
        }
    }

    class 6 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditText DW;
        final /* synthetic */ t FH;
        final /* synthetic */ Activity j6;

        6(t tVar, Activity activity, EditText editText) {
            this.FH = tVar;
            this.j6 = activity;
            this.DW = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
            dialogInterface.cancel();
        }
    }

    class 7 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditText DW;
        final /* synthetic */ t FH;
        final /* synthetic */ Activity j6;

        7(t tVar, Activity activity, EditText editText) {
            this.FH = tVar;
            this.j6 = activity;
            this.DW = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
            dialogInterface.dismiss();
            this.FH.FH.j6(this.DW.getText().toString().trim());
        }
    }

    class 8 implements OnEditorActionListener {
        final /* synthetic */ EditText DW;
        final /* synthetic */ t FH;
        final /* synthetic */ Activity j6;

        8(t tVar, Activity activity, EditText editText) {
            this.FH = tVar;
            this.j6 = activity;
            this.DW = editText;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                this.FH.v5.dismiss();
                this.FH.FH.j6(this.DW.getText().toString().trim());
            }
            return false;
        }
    }

    public t(String str, String str2, y<String> yVar, Runnable runnable) {
        this.j6 = str;
        this.DW = str2;
        this.FH = yVar;
        this.Hw = runnable;
    }

    protected Dialog j6(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.c.designer_sizedialog, null);
        EditText editText = (EditText) inflate.findViewById(R.b.designersizedialogEditText);
        editText.setText(this.DW);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.b.designersizedialogSeekBar);
        seekBar.setMax(100);
        DW(seekBar, this.DW);
        seekBar.setOnSeekBarChangeListener(new 1(this, editText, seekBar));
        editText.addTextChangedListener(new 2(this, seekBar, editText));
        ((TextView) inflate.findViewById(R.b.designersizedialogPlusButton)).setOnClickListener(new 3(this, editText, seekBar));
        ((TextView) inflate.findViewById(R.b.designersizedialogMinusButton)).setOnClickListener(new 4(this, editText, seekBar));
        Builder builder = new Builder(activity);
        builder.setView(inflate).setCancelable(true).setPositiveButton("Ok", new 7(this, activity, editText)).setNegativeButton("Cancel", new 6(this, activity, editText)).setNeutralButton("None", new 5(this, activity, editText));
        if (this.j6 != null) {
            builder.setTitle(this.j6);
        }
        this.v5 = builder.create();
        editText.setOnEditorActionListener(new 8(this, activity, editText));
        this.v5.setCanceledOnTouchOutside(true);
        this.v5.getWindow().setSoftInputMode(2);
        return this.v5;
    }

    private String j6(SeekBar seekBar, String str) {
        String FH = FH(str);
        if (FH == null) {
            FH = "";
        }
        return seekBar.getProgress() + FH;
    }

    private void DW(SeekBar seekBar, String str) {
        seekBar.setProgress(Math.max(0, Math.min(100, Hw(str))));
    }

    private String j6(String str) {
        String FH = FH(str);
        if (FH != null) {
            return (Hw(str) + 1) + FH;
        }
        return str;
    }

    private String DW(String str) {
        String FH = FH(str);
        if (FH != null) {
            return (Hw(str) - 1) + FH;
        }
        return str;
    }

    private String FH(String str) {
        int i = 0;
        if (str.length() == 0 || (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-')) {
            return null;
        }
        while (i < str.length() && (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-')) {
            i++;
        }
        return str.substring(i, str.length());
    }

    private int Hw(String str) {
        int i = 0;
        int i2 = i;
        while (i2 < str.length() && (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-')) {
            i2++;
        }
        try {
            i = Integer.parseInt(str.substring(0, i2));
        } catch (NumberFormatException e) {
        }
        return i;
    }
}
