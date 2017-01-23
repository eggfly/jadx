package com.miui.support.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.miui.support.date.Calendar;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.widget.DatePicker;
import com.miui.support.widget.DatePicker.OnDateChangedListener;

public class DatePickerDialog extends AlertDialog {
    private final DatePicker f1909a;
    private final OnDateSetListener f1910b;
    private final Calendar f1911c;
    private boolean f1912d;
    private OnDateChangedListener f1913e;

    public interface OnDateSetListener {
        void m3084a(DatePicker datePicker, int i, int i2, int i3);
    }

    /* renamed from: com.miui.support.app.DatePickerDialog.1 */
    class C02351 implements OnDateChangedListener {
        final /* synthetic */ DatePickerDialog f1907a;

        C02351(DatePickerDialog datePickerDialog) {
            this.f1907a = datePickerDialog;
        }

        public void m3274a(DatePicker datePicker, int i, int i2, int i3, boolean z) {
            if (this.f1907a.f1912d) {
                this.f1907a.m3276a(i, i2, i3);
            }
        }
    }

    /* renamed from: com.miui.support.app.DatePickerDialog.2 */
    class C02362 implements OnClickListener {
        final /* synthetic */ DatePickerDialog f1908a;

        C02362(DatePickerDialog datePickerDialog) {
            this.f1908a = datePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1908a.m3275a();
        }
    }

    public DatePickerDialog(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    public DatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i);
        this.f1912d = true;
        this.f1913e = new C02351(this);
        this.f1910b = onDateSetListener;
        this.f1911c = new Calendar();
        Context context2 = getContext();
        m2969a(-1, context2.getText(17039370), new C02362(this));
        m2969a(-2, getContext().getText(17039360), (OnClickListener) null);
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(C0264R.layout.date_picker_dialog, null);
        m2970a(inflate);
        this.f1909a = (DatePicker) inflate.findViewById(C0264R.id.datePicker);
        this.f1909a.m5746a(i2, i3, i4, this.f1913e);
        m3276a(i2, i3, i4);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1912d = false;
    }

    public void setTitle(int i) {
        super.setTitle(i);
        this.f1912d = false;
    }

    private void m3275a() {
        if (this.f1910b != null) {
            this.f1909a.clearFocus();
            this.f1910b.m3084a(this.f1909a, this.f1909a.getYear(), this.f1909a.getMonth(), this.f1909a.getDayOfMonth());
        }
    }

    private void m3276a(int i, int i2, int i3) {
        this.f1911c.m3383a(1, i);
        this.f1911c.m3383a(5, i2);
        this.f1911c.m3383a(9, i3);
        super.setTitle(DateUtils.m3428a(this.f1911c.m3382a(), 14208));
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("miui:year", this.f1909a.getYear());
        onSaveInstanceState.putInt("miui:month", this.f1909a.getMonth());
        onSaveInstanceState.putInt("miui:day", this.f1909a.getDayOfMonth());
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f1909a.m5746a(bundle.getInt("miui:year"), bundle.getInt("miui:month"), bundle.getInt("miui:day"), this.f1913e);
    }
}
