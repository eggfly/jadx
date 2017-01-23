package com.aide.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.aide.ui.R;

public class j extends m {
    private String DW;
    private int FH;
    private a Hw;
    private boolean VH;
    private String Zo;
    private boolean gn;
    private String j6;
    private boolean v5;

    class 1 implements com.aide.common.ColorPickerView.a {
        final /* synthetic */ j DW;
        final /* synthetic */ EditText j6;

        1(j jVar, EditText editText) {
            this.DW = jVar;
            this.j6 = editText;
        }

        public void j6(int i, String str) {
            if (!this.DW.gn) {
                this.DW.VH = true;
                this.j6.setText(str);
                this.DW.VH = false;
            }
            this.DW.DW = str;
            this.DW.FH = i;
        }
    }

    class 2 implements TextWatcher {
        final /* synthetic */ j DW;
        final /* synthetic */ ColorPickerView j6;

        2(j jVar, ColorPickerView colorPickerView) {
            this.DW = jVar;
            this.j6 = colorPickerView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.DW.VH) {
                this.DW.gn = true;
                this.j6.setCurrentColor(charSequence.toString());
                this.DW.gn = false;
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ j j6;

        3(j jVar) {
            this.j6 = jVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    class 4 implements OnClickListener {
        final /* synthetic */ j j6;

        4(j jVar) {
            this.j6 = jVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.j6.Hw.j6(this.j6.FH, this.j6.DW);
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ j j6;

        5(j jVar) {
            this.j6 = jVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.Hw.j6(0, null);
        }
    }

    public interface a {
        void j6(int i, String str);
    }

    public j(String str, String str2, a aVar) {
        if (str2 == null) {
            this.j6 = "#000000";
        } else {
            this.j6 = str2;
        }
        this.DW = this.j6;
        this.FH = ColorPickerView.j6(this.DW);
        this.Hw = aVar;
        this.v5 = true;
        this.Zo = str;
    }

    public j(String str, int i, a aVar) {
        this.j6 = ColorPickerView.j6(i);
        this.DW = this.j6;
        this.FH = i;
        this.Hw = aVar;
        this.Zo = str;
    }

    protected Dialog j6(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.c.colorpicker, null);
        ColorPickerView colorPickerView = (ColorPickerView) inflate.findViewById(R.b.colorpickerColorPickerView);
        EditText editText = (EditText) inflate.findViewById(R.b.colorpickerEditText);
        colorPickerView.setOnColorChangedListener(new 1(this, editText));
        colorPickerView.setInitialColor(this.j6);
        colorPickerView.setCurrentColor(this.j6);
        editText.setText(this.j6);
        editText.addTextChangedListener(new 2(this, colorPickerView));
        Builder builder = new Builder(activity);
        builder.setView(inflate).setCancelable(true).setPositiveButton("Ok", new 4(this)).setNegativeButton("Cancel", new 3(this));
        if (this.v5) {
            builder.setNeutralButton("None", new 5(this));
        }
        builder.setTitle(this.Zo);
        Dialog create = builder.create();
        create.getWindow().setSoftInputMode(2);
        return create;
    }
}
