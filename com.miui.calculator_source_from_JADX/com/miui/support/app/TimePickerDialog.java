package com.miui.support.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.miui.support.widget.TimePicker;

public class TimePickerDialog extends AlertDialog {
    private final TimePicker f1942a;
    private final OnTimeSetListener f1943b;

    /* renamed from: com.miui.support.app.TimePickerDialog.1 */
    class C02391 implements OnClickListener {
        final /* synthetic */ TimePickerDialog f1941a;

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1941a.m3327a();
        }
    }

    public interface OnTimeSetListener {
        void m3326a(TimePicker timePicker, int i, int i2);
    }

    private void m3327a() {
        if (this.f1943b != null) {
            this.f1942a.clearFocus();
            this.f1943b.m3326a(this.f1942a, this.f1942a.getCurrentHour().intValue(), this.f1942a.getCurrentMinute().intValue());
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("miui:hour", this.f1942a.getCurrentHour().intValue());
        onSaveInstanceState.putInt("miui:minute", this.f1942a.getCurrentMinute().intValue());
        onSaveInstanceState.putBoolean("miui:is24hour", this.f1942a.m6113a());
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("miui:hour");
        int i2 = bundle.getInt("miui:minute");
        this.f1942a.setIs24HourView(Boolean.valueOf(bundle.getBoolean("miui:is24hour")));
        this.f1942a.setCurrentHour(Integer.valueOf(i));
        this.f1942a.setCurrentMinute(Integer.valueOf(i2));
    }
}
