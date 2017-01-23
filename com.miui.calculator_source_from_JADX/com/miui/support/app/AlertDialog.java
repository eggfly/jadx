package com.miui.support.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.AlertControllerWrapper;
import com.miui.support.internal.variable.AlertControllerWrapper.AlertParams;

public class AlertDialog extends Dialog implements DialogInterface {
    private AlertControllerWrapper f1614a;

    public static class Builder {
        private AlertParams f1905a;
        private int f1906b;

        public Builder(Context context) {
            this(context, AlertDialog.m2967a(context, 0));
        }

        public Builder(Context context, int i) {
            this.f1905a = new AlertParams(new ContextThemeWrapper(context, AlertDialog.m2967a(context, i)));
            this.f1905a.mEditMode = i >= 4;
            this.f1906b = i;
        }

        public Builder m3260a(int i) {
            this.f1905a.mTitle = this.f1905a.mContext.getText(i);
            return this;
        }

        public Builder m3266a(CharSequence charSequence) {
            this.f1905a.mTitle = charSequence;
            return this;
        }

        public Builder m3269b(int i) {
            this.f1905a.mMessage = this.f1905a.mContext.getText(i);
            return this;
        }

        public Builder m3271b(CharSequence charSequence) {
            this.f1905a.mMessage = charSequence;
            return this;
        }

        public Builder m3262a(int i, OnClickListener onClickListener) {
            this.f1905a.mPositiveButtonText = this.f1905a.mContext.getText(i);
            this.f1905a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder m3270b(int i, OnClickListener onClickListener) {
            this.f1905a.mNegativeButtonText = this.f1905a.mContext.getText(i);
            this.f1905a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder m3263a(OnCancelListener onCancelListener) {
            this.f1905a.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder m3264a(OnKeyListener onKeyListener) {
            this.f1905a.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder m3261a(int i, int i2, OnClickListener onClickListener) {
            this.f1905a.mItems = this.f1905a.mContext.getResources().getTextArray(i);
            this.f1905a.mOnClickListener = onClickListener;
            this.f1905a.mCheckedItem = i2;
            this.f1905a.mIsSingleChoice = true;
            return this;
        }

        public Builder m3267a(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f1905a.mItems = charSequenceArr;
            this.f1905a.mOnClickListener = onClickListener;
            this.f1905a.mCheckedItem = i;
            this.f1905a.mIsSingleChoice = true;
            return this;
        }

        public Builder m3265a(View view) {
            this.f1905a.mView = view;
            return this;
        }

        public AlertDialog m3268a() {
            AlertDialog alertDialog = new AlertDialog(this.f1905a.mContext, this.f1906b);
            this.f1905a.apply(alertDialog.f1614a);
            alertDialog.setCancelable(this.f1905a.mCancelable);
            if (this.f1905a.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1905a.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f1905a.mOnDismissListener);
            alertDialog.setOnShowListener(this.f1905a.mOnShowListener);
            if (this.f1905a.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f1905a.mOnKeyListener);
            }
            return alertDialog;
        }

        public AlertDialog m3272b() {
            AlertDialog a = m3268a();
            a.show();
            return a;
        }
    }

    protected AlertDialog(Context context) {
        this(context, m2967a(context, 0));
    }

    protected AlertDialog(Context context, int i) {
        super(context, m2967a(context, i));
        this.f1614a = new AlertControllerWrapper(context, this, getWindow());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1614a.installContent();
    }

    static int m2967a(Context context, int i) {
        switch (i) {
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return C0234R.style.Theme_Dark_Dialog_Alert;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                return C0234R.style.Theme_Light_Dialog_Alert;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                return C0264R.style.Theme_Dark_Dialog_Edit;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                return C0264R.style.Theme_Light_Dialog_Edit;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return C0264R.style.Theme_Dark_Dialog_Edit_Default;
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                return C0264R.style.Theme_Light_Dialog_Edit_Default;
            default:
                if (i >= 16777216) {
                    return i;
                }
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16843529, typedValue, true);
                return typedValue.resourceId;
        }
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1614a.setTitle(charSequence);
    }

    public void m2971a(CharSequence charSequence) {
        this.f1614a.setMessage(charSequence);
    }

    public void m2970a(View view) {
        this.f1614a.setView(view);
    }

    public void m2969a(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.f1614a.setButton(i, charSequence, onClickListener, null);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1614a.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1614a.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }
}
