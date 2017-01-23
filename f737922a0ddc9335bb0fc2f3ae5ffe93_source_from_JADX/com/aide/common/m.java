package com.aide.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Typeface;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.aide.ui.R;
import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class m {
    private static m DW;
    private static Dialog FH;
    private static int j6;

    static class 10 extends m {
        final /* synthetic */ y DW;
        final /* synthetic */ String FH;
        final /* synthetic */ List j6;

        class 1 implements OnClickListener {
            final /* synthetic */ 10 j6;

            1(10 10) {
                this.j6 = 10;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.j6.DW.j6(Integer.valueOf(i));
            }
        }

        10(List list, y yVar, String str) {
            this.j6 = list;
            this.DW = yVar;
            this.FH = str;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setCancelable(true).setItems((CharSequence[]) this.j6.toArray(new CharSequence[0]), new 1(this));
            if (this.FH != null) {
                builder.setTitle(this.FH);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    static class 11 extends m {
        final /* synthetic */ y DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Runnable Hw;
        final /* synthetic */ List j6;
        final /* synthetic */ String v5;

        class 1 implements OnClickListener {
            final /* synthetic */ 11 j6;

            1(11 11) {
                this.j6 = 11;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.j6.Hw.run();
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 11 j6;

            2(11 11) {
                this.j6 = 11;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.j6.DW.j6(Integer.valueOf(i));
            }
        }

        11(List list, y yVar, String str, Runnable runnable, String str2) {
            this.j6 = list;
            this.DW = yVar;
            this.FH = str;
            this.Hw = runnable;
            this.v5 = str2;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setCancelable(true).setItems((CharSequence[]) this.j6.toArray(new CharSequence[0]), new 2(this)).setPositiveButton(this.FH, new 1(this));
            if (this.v5 != null) {
                builder.setTitle(this.v5);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    static class 1 extends m {
        final /* synthetic */ String DW;
        final /* synthetic */ Runnable FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ String j6;

        class 1 implements OnClickListener {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 1 j6;

            2(1 1) {
                this.j6 = 1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.j6.FH.run();
            }
        }

        1(String str, String str2, Runnable runnable, String str3) {
            this.j6 = str;
            this.DW = str2;
            this.FH = runnable;
            this.Hw = str3;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setMessage(this.j6).setCancelable(true).setPositiveButton(activity.getResources().getString(R.f.dialog_ok), new 1(this));
            if (this.DW != null) {
                builder = builder.setNegativeButton(this.DW, new 2(this));
            }
            if (this.Hw != null) {
                builder = builder.setTitle(this.Hw);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    static class 2 extends m {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Runnable Hw;
        final /* synthetic */ String VH;
        final /* synthetic */ Runnable Zo;
        final /* synthetic */ boolean gn;
        final /* synthetic */ y j6;
        final /* synthetic */ String v5;

        class 1 extends EditText {
            final /* synthetic */ AlertDialog[] DW;
            final /* synthetic */ 2 FH;
            final /* synthetic */ Activity j6;

            1(2 2, Context context, Activity activity, AlertDialog[] alertDialogArr) {
                this.FH = 2;
                this.j6 = activity;
                this.DW = alertDialogArr;
                super(context);
            }

            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (i == 66) {
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            }

            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                if (i != 66) {
                    return super.onKeyUp(i, keyEvent);
                }
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
                this.DW[0].dismiss();
                this.FH.j6.j6(getText().toString().trim());
                return true;
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ EditText DW;
            final /* synthetic */ 2 FH;
            final /* synthetic */ Activity j6;

            2(2 2, Activity activity, EditText editText) {
                this.FH = 2;
                this.j6 = activity;
                this.DW = editText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                dialogInterface.cancel();
            }
        }

        class 3 implements OnClickListener {
            final /* synthetic */ EditText DW;
            final /* synthetic */ 2 FH;
            final /* synthetic */ Activity j6;

            3(2 2, Activity activity, EditText editText) {
                this.FH = 2;
                this.j6 = activity;
                this.DW = editText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                dialogInterface.dismiss();
                this.FH.j6.j6(this.DW.getText().toString().trim());
            }
        }

        class 4 implements OnClickListener {
            final /* synthetic */ EditText DW;
            final /* synthetic */ 2 FH;
            final /* synthetic */ Activity j6;

            4(2 2, Activity activity, EditText editText) {
                this.FH = 2;
                this.j6 = activity;
                this.DW = editText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                this.FH.Hw.run();
            }
        }

        class 5 implements OnCancelListener {
            final /* synthetic */ 2 j6;

            5(2 2) {
                this.j6 = 2;
            }

            public void onCancel(DialogInterface dialogInterface) {
                if (this.j6.Zo != null) {
                    this.j6.Zo.run();
                }
            }
        }

        class 6 implements OnShowListener {
            final /* synthetic */ EditText DW;
            final /* synthetic */ 2 FH;
            final /* synthetic */ Activity j6;

            6(2 2, Activity activity, EditText editText) {
                this.FH = 2;
                this.j6 = activity;
                this.DW = editText;
            }

            public void onShow(DialogInterface dialogInterface) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).showSoftInput(this.DW, 1);
                this.DW.selectAll();
            }
        }

        class 7 implements OnEditorActionListener {
            final /* synthetic */ EditText DW;
            final /* synthetic */ AlertDialog[] FH;
            final /* synthetic */ 2 Hw;
            final /* synthetic */ Activity j6;

            7(2 2, Activity activity, EditText editText, AlertDialog[] alertDialogArr) {
                this.Hw = 2;
                this.j6 = activity;
                this.DW = editText;
                this.FH = alertDialogArr;
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                    this.FH[0].dismiss();
                    this.Hw.j6.j6(this.DW.getText().toString().trim());
                }
                return false;
            }
        }

        2(y yVar, String str, String str2, Runnable runnable, String str3, Runnable runnable2, String str4, boolean z) {
            this.j6 = yVar;
            this.DW = str;
            this.FH = str2;
            this.Hw = runnable;
            this.v5 = str3;
            this.Zo = runnable2;
            this.VH = str4;
            this.gn = z;
        }

        public Dialog j6(Activity activity) {
            AlertDialog[] alertDialogArr = new AlertDialog[1];
            View 1 = new 1(this, activity, activity, alertDialogArr);
            Builder builder = new Builder(activity);
            builder.setView(1).setMessage(this.DW).setCancelable(true).setPositiveButton(activity.getResources().getString(R.f.dialog_ok), new 3(this, activity, 1)).setNegativeButton(activity.getResources().getString(R.f.dialog_cancel), new 2(this, activity, 1));
            if (this.FH != null) {
                builder.setNeutralButton(this.FH, new 4(this, activity, 1));
            }
            if (this.v5 != null) {
                builder.setTitle(this.v5);
            }
            builder.setOnCancelListener(new 5(this));
            alertDialogArr[0] = builder.create();
            alertDialogArr[0].setOnShowListener(new 6(this, activity, 1));
            1.setText(this.VH);
            1.setImeOptions(268435456);
            if (this.gn) {
                1.setInputType(ProxyTextView.INPUTTYPE_textPassword);
            } else {
                1.setInputType(ProxyTextView.INPUTTYPE_textVisiblePassword);
            }
            1.setTypeface(Typeface.DEFAULT);
            1.setOnEditorActionListener(new 7(this, activity, 1, alertDialogArr));
            alertDialogArr[0].setCanceledOnTouchOutside(true);
            return alertDialogArr[0];
        }
    }

    static class 3 implements y<List<Integer>> {
        final /* synthetic */ List DW;
        final /* synthetic */ y j6;

        3(y yVar, List list) {
            this.j6 = yVar;
            this.DW = list;
        }

        public void j6(List<Integer> list) {
            if (list.size() == 0) {
                this.j6.j6(null);
                return;
            }
            String str = "";
            for (Integer intValue : list) {
                String str2;
                int intValue2 = intValue.intValue();
                if (str.length() > 0) {
                    str2 = str + "|";
                } else {
                    str2 = str;
                }
                str = str2 + ((String) this.DW.get(intValue2));
            }
            this.j6.j6(str);
        }
    }

    static class 4 extends m {
        final /* synthetic */ boolean DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Runnable Hw;
        final /* synthetic */ String VH;
        final /* synthetic */ Runnable Zo;
        final /* synthetic */ String j6;
        final /* synthetic */ String v5;

        class 1 implements OnClickListener {
            final /* synthetic */ 4 j6;

            1(4 4) {
                this.j6 = 4;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.j6.Hw != null) {
                    this.j6.Hw.run();
                }
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 4 j6;

            2(4 4) {
                this.j6 = 4;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.j6.Zo != null) {
                    this.j6.Zo.run();
                }
            }
        }

        class 3 implements OnCancelListener {
            final /* synthetic */ 4 j6;

            3(4 4) {
                this.j6 = 4;
            }

            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                if (this.j6.Zo != null) {
                    this.j6.Zo.run();
                }
            }
        }

        4(String str, boolean z, String str2, Runnable runnable, String str3, Runnable runnable2, String str4) {
            this.j6 = str;
            this.DW = z;
            this.FH = str2;
            this.Hw = runnable;
            this.v5 = str3;
            this.Zo = runnable2;
            this.VH = str4;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setMessage(this.j6).setCancelable(this.DW);
            builder.setPositiveButton(this.FH, new 1(this));
            if (this.v5 != null) {
                builder.setNegativeButton(this.v5, new 2(this));
            }
            builder.setOnCancelListener(new 3(this));
            if (this.VH != null) {
                builder.setTitle(this.VH);
            }
            Dialog create = builder.create();
            if (this.DW) {
                create.setCanceledOnTouchOutside(true);
            }
            return create;
        }
    }

    static class 5 extends m {
        final /* synthetic */ String DW;
        final /* synthetic */ Runnable FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ String VH;
        final /* synthetic */ Runnable Zo;
        final /* synthetic */ String j6;
        final /* synthetic */ Runnable v5;

        class 1 implements OnClickListener {
            final /* synthetic */ 5 j6;

            1(5 5) {
                this.j6 = 5;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.j6.v5 != null) {
                    this.j6.v5.run();
                }
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 5 j6;

            2(5 5) {
                this.j6 = 5;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.j6.FH != null) {
                    this.j6.FH.run();
                }
            }
        }

        class 3 implements OnCancelListener {
            final /* synthetic */ 5 j6;

            3(5 5) {
                this.j6 = 5;
            }

            public void onCancel(DialogInterface dialogInterface) {
                if (this.j6.Zo != null) {
                    this.j6.Zo.run();
                }
            }
        }

        5(String str, String str2, Runnable runnable, String str3, Runnable runnable2, Runnable runnable3, String str4) {
            this.j6 = str;
            this.DW = str2;
            this.FH = runnable;
            this.Hw = str3;
            this.v5 = runnable2;
            this.Zo = runnable3;
            this.VH = str4;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setMessage(this.j6).setCancelable(true).setPositiveButton(this.DW, new 2(this)).setNegativeButton(this.Hw, new 1(this));
            builder.setOnCancelListener(new 3(this));
            if (this.VH != null) {
                builder.setTitle(this.VH);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    static class 6 extends m {
        final /* synthetic */ y DW;
        final /* synthetic */ String FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ k j6;

        class 1 implements OnEditorActionListener {
            final /* synthetic */ KeyStrokeEditText DW;
            final /* synthetic */ 6 FH;
            final /* synthetic */ Activity j6;

            1(6 6, Activity activity, KeyStrokeEditText keyStrokeEditText) {
                this.FH = 6;
                this.j6 = activity;
                this.DW = keyStrokeEditText;
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                    this.FH.DW.j6(this.DW.getKeyStroke());
                }
                return false;
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ KeyStrokeEditText DW;
            final /* synthetic */ 6 FH;
            final /* synthetic */ Activity j6;

            2(6 6, Activity activity, KeyStrokeEditText keyStrokeEditText) {
                this.FH = 6;
                this.j6 = activity;
                this.DW = keyStrokeEditText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                dialogInterface.cancel();
                this.FH.DW.j6(null);
            }
        }

        class 3 implements OnClickListener {
            final /* synthetic */ KeyStrokeEditText DW;
            final /* synthetic */ 6 FH;
            final /* synthetic */ Activity j6;

            3(6 6, Activity activity, KeyStrokeEditText keyStrokeEditText) {
                this.FH = 6;
                this.j6 = activity;
                this.DW = keyStrokeEditText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                dialogInterface.cancel();
            }
        }

        class 4 implements OnClickListener {
            final /* synthetic */ KeyStrokeEditText DW;
            final /* synthetic */ 6 FH;
            final /* synthetic */ Activity j6;

            4(6 6, Activity activity, KeyStrokeEditText keyStrokeEditText) {
                this.FH = 6;
                this.j6 = activity;
                this.DW = keyStrokeEditText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).hideSoftInputFromWindow(this.DW.getWindowToken(), 0);
                this.FH.DW.j6(this.DW.getKeyStroke());
            }
        }

        class 5 implements OnShowListener {
            final /* synthetic */ KeyStrokeEditText DW;
            final /* synthetic */ 6 FH;
            final /* synthetic */ Activity j6;

            5(6 6, Activity activity, KeyStrokeEditText keyStrokeEditText) {
                this.FH = 6;
                this.j6 = activity;
                this.DW = keyStrokeEditText;
            }

            public void onShow(DialogInterface dialogInterface) {
                ((InputMethodManager) this.j6.getSystemService("input_method")).showSoftInput(this.DW, 1);
                this.DW.selectAll();
            }
        }

        6(k kVar, y yVar, String str, String str2) {
            this.j6 = kVar;
            this.DW = yVar;
            this.FH = str;
            this.Hw = str2;
        }

        public Dialog j6(Activity activity) {
            View keyStrokeEditText = new KeyStrokeEditText(activity);
            keyStrokeEditText.setKeyStroke(this.j6);
            keyStrokeEditText.setOnEditorActionListener(new 1(this, activity, keyStrokeEditText));
            Builder builder = new Builder(activity);
            builder.setView(keyStrokeEditText).setMessage(this.FH).setCancelable(true).setPositiveButton(activity.getResources().getString(R.f.dialog_ok), new 4(this, activity, keyStrokeEditText)).setNegativeButton(activity.getResources().getString(R.f.dialog_cancel), new 3(this, activity, keyStrokeEditText)).setNeutralButton("Default", new 2(this, activity, keyStrokeEditText));
            if (this.Hw != null) {
                builder.setTitle(this.Hw);
            }
            Dialog create = builder.create();
            create.setOnShowListener(new 5(this, activity, keyStrokeEditText));
            return create;
        }
    }

    static class 7 extends m {
        final /* synthetic */ List DW;
        final /* synthetic */ y FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ boolean j6;

        class 1 implements OnClickListener {
            final /* synthetic */ 7 j6;

            1(7 7) {
                this.j6 = 7;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.j6.FH.j6(this.j6.DW.get(i));
            }
        }

        7(boolean z, List list, y yVar, String str) {
            this.j6 = z;
            this.DW = list;
            this.FH = yVar;
            this.Hw = str;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setCancelable(this.j6).setItems((CharSequence[]) this.DW.toArray(new CharSequence[0]), new 1(this));
            if (this.Hw != null) {
                builder.setTitle(this.Hw);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(this.j6);
            return create;
        }
    }

    static class 8 extends m {
        final /* synthetic */ String DW;
        final /* synthetic */ y FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ List j6;

        class 1 implements OnClickListener {
            final /* synthetic */ 8 j6;

            1(8 8) {
                this.j6 = 8;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                SparseBooleanArray checkedItemPositions = ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions();
                if (checkedItemPositions != null) {
                    for (int i2 = 0; i2 < this.j6.j6.size(); i2++) {
                        if (checkedItemPositions.get(i2)) {
                            this.j6.FH.j6(this.j6.j6.get(i2));
                        }
                    }
                }
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 8 j6;

            2(8 8) {
                this.j6 = 8;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        8(List list, String str, y yVar, String str2) {
            this.j6 = list;
            this.DW = str;
            this.FH = yVar;
            this.Hw = str2;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            builder.setCancelable(true).setSingleChoiceItems((CharSequence[]) this.j6.toArray(new CharSequence[0]), this.j6.indexOf(this.DW), new 2(this)).setPositiveButton(activity.getResources().getString(R.f.dialog_ok), new 1(this));
            if (this.Hw != null) {
                builder.setTitle(this.Hw);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    static class 9 extends m {
        final /* synthetic */ List DW;
        final /* synthetic */ y FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ List j6;

        class 1 implements OnClickListener {
            final /* synthetic */ 9 j6;

            1(9 9) {
                this.j6 = 9;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                List arrayList = new ArrayList();
                SparseBooleanArray checkedItemPositions = ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions();
                if (checkedItemPositions != null) {
                    for (int i2 = 0; i2 < this.j6.DW.size(); i2++) {
                        if (checkedItemPositions.get(i2)) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                }
                this.j6.FH.j6(arrayList);
            }
        }

        class 2 implements OnMultiChoiceClickListener {
            final /* synthetic */ 9 j6;

            2(9 9) {
                this.j6 = 9;
            }

            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            }
        }

        9(List list, List list2, y yVar, String str) {
            this.j6 = list;
            this.DW = list2;
            this.FH = yVar;
            this.Hw = str;
        }

        public Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            boolean[] zArr = new boolean[this.j6.size()];
            for (int i = 0; i < zArr.length; i++) {
                zArr[i] = ((Boolean) this.j6.get(i)).booleanValue();
            }
            builder.setCancelable(true).setMultiChoiceItems((CharSequence[]) this.DW.toArray(new CharSequence[0]), zArr, new 2(this)).setPositiveButton(activity.getResources().getString(R.f.dialog_ok), new 1(this));
            if (this.Hw != null) {
                builder.setTitle(this.Hw);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    protected abstract Dialog j6(Activity activity);

    static {
        j6 = 123456;
    }

    public static void j6(Activity activity, m mVar) {
        DW = mVar;
        if (FH == null || !FH.isShowing()) {
            activity.removeDialog(j6);
            activity.showDialog(j6);
        }
    }

    public static void j6() {
        if (FH != null) {
            FH.dismiss();
        }
    }

    public static void j6(Activity activity, String str, Throwable th) {
        j6(activity, str, th.getMessage());
    }

    public static void j6(Activity activity, String str, String str2) {
        j6(activity, str, str2, null, null);
    }

    public static void j6(Activity activity, String str, String str2, String str3, Runnable runnable) {
        j6(activity, new 1(str2, str3, runnable, str));
    }

    public static void j6(Activity activity, String str, String str2, Runnable runnable) {
        j6(activity, str, str2, runnable, null);
    }

    public static void j6(Activity activity, String str, String str2, Runnable runnable, Runnable runnable2) {
        j6(activity, str, str2, true, runnable, runnable2);
    }

    public static void j6(Activity activity, String str, String str2, boolean z, Runnable runnable, Runnable runnable2) {
        j6(activity, str, str2, z, activity.getResources().getString(R.f.dialog_ok), runnable, null, runnable2);
    }

    public static void j6(Activity activity, String str, String str2, boolean z, String str3, Runnable runnable, String str4, Runnable runnable2) {
        j6(activity, new 4(str2, z, str3, runnable, str4, runnable2, str));
    }

    public static void j6(Activity activity, int i, int i2, List<String> list, Runnable runnable, Runnable runnable2) {
        String str = "\n";
        for (String str2 : list) {
            str = (str + "\n") + str2;
        }
        j6(activity, activity.getResources().getString(i), activity.getResources().getString(i2) + str, activity.getResources().getString(R.f.dialog_no), runnable2, activity.getResources().getString(R.f.dialog_yes), runnable, null);
    }

    public static void j6(Activity activity, int i, int i2, Runnable runnable, Runnable runnable2) {
        j6(activity, activity.getResources().getString(i), activity.getResources().getString(i2), activity.getResources().getString(R.f.dialog_yes), runnable, activity.getResources().getString(R.f.dialog_no), runnable2, null);
    }

    public static void DW(Activity activity, String str, String str2, Runnable runnable, Runnable runnable2) {
        j6(activity, str, str2, runnable, runnable2, null);
    }

    public static void j6(Activity activity, String str, String str2, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        j6(activity, str, str2, activity.getResources().getString(R.f.dialog_yes), runnable, activity.getResources().getString(R.f.dialog_no), runnable2, runnable3);
    }

    public static void j6(Activity activity, String str, String str2, String str3, Runnable runnable, String str4, Runnable runnable2, Runnable runnable3) {
        j6(activity, new 5(str2, str3, runnable, str4, runnable2, runnable3, str));
    }

    public static void j6(Activity activity, String str, String str2, k kVar, y<k> yVar) {
        j6(activity, new 6(kVar, yVar, str2, str));
    }

    public static void j6(Activity activity, String str, List<String> list, y<String> yVar) {
        j6(activity, str, (List) list, true, (y) yVar);
    }

    private static void j6(Activity activity, String str, List<String> list, boolean z, y<String> yVar) {
        j6(activity, new 7(z, list, yVar, str));
    }

    public static void j6(Activity activity, String str, List<String> list, String str2, y<String> yVar) {
        j6(activity, new 8(list, str2, yVar, str));
    }

    public static void j6(Activity activity, String str, List<String> list, List<Boolean> list2, y<List<Integer>> yVar) {
        j6(activity, new 9(list2, list, yVar, str));
    }

    public static void DW(Activity activity, String str, List<String> list, y<Integer> yVar) {
        j6(activity, new 10(list, yVar, str));
    }

    public static void j6(Activity activity, String str, List<String> list, String str2, y<Integer> yVar, Runnable runnable) {
        j6(activity, new 11(list, yVar, str2, runnable, str));
    }

    public static void j6(Activity activity, String str, String str2, y<String> yVar, Runnable runnable) {
        j6(activity, str, str2, null, "", true, yVar, runnable, null);
    }

    public static void j6(Activity activity, String str, String str2, y<String> yVar) {
        j6(activity, str, str2, null, "", true, yVar, null, null);
    }

    public static void j6(Activity activity, String str, String str2, String str3, y<String> yVar, Runnable runnable) {
        j6(activity, str, str2, null, str3, false, yVar, runnable, null);
    }

    public static void j6(Activity activity, int i, int i2, String str, y<String> yVar) {
        j6(activity, activity.getResources().getString(i), activity.getResources().getString(i2), null, str, false, yVar, null, null);
    }

    public static void j6(Activity activity, String str, String str2, String str3, y<String> yVar) {
        j6(activity, str, str2, null, str3, false, yVar, null, null);
    }

    public static void j6(Activity activity, String str, String str2, String str3, String str4, y<String> yVar, Runnable runnable) {
        j6(activity, str, str2, str3, str4, false, yVar, null, runnable);
    }

    private static void j6(Activity activity, String str, String str2, String str3, String str4, boolean z, y<String> yVar, Runnable runnable, Runnable runnable2) {
        j6(activity, new 2(yVar, str2, str3, runnable2, str, runnable, str4, z));
    }

    public static Dialog j6(Activity activity, int i) {
        if (DW == null || i != j6) {
            return null;
        }
        FH = DW.j6(activity);
        DW = null;
        return FH;
    }

    public static void j6(Activity activity, String str, List<String> list, List<String> list2, String str2, y<String> yVar) {
        List arrayList = new ArrayList();
        List arrayList2 = str2 == null ? new ArrayList() : Arrays.asList(str2.split("\\|"));
        for (String contains : list) {
            arrayList.add(Boolean.valueOf(arrayList2.contains(contains)));
        }
        j6(activity, str, (List) list2, arrayList, new 3(yVar, list));
    }
}
