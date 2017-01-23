package com.miui.support.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.miui.support.widget.DateTimePicker;

public class DateTimePickerDialog extends AlertDialog {
    private DateTimePicker f1915a;
    private OnTimeSetListener f1916b;

    /* renamed from: com.miui.support.app.DateTimePickerDialog.1 */
    class C02371 implements OnClickListener {
        final /* synthetic */ DateTimePickerDialog f1914a;

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f1914a.f1916b != null) {
                this.f1914a.f1916b.m3280a(this.f1914a, this.f1914a.f1915a.getTimeInMillis());
            }
        }
    }

    public interface OnTimeSetListener {
        void m3280a(DateTimePickerDialog dateTimePickerDialog, long j);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }
}
