package com.miui.support.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.miui.support.date.Calendar;
import com.miui.support.date.CalendarFormatSymbols;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.widget.NumberPicker.OnValueChangeListener;
import java.util.Locale;

public class TimePicker extends FrameLayout {
    private static final OnTimeChangedListener f4482a;
    private boolean f4483b;
    private boolean f4484c;
    private final NumberPicker f4485d;
    private final NumberPicker f4486e;
    private final NumberPicker f4487f;
    private final Button f4488g;
    private boolean f4489h;
    private OnTimeChangedListener f4490i;
    private Calendar f4491j;
    private Locale f4492k;

    public interface OnTimeChangedListener {
        void m6096a(TimePicker timePicker, int i, int i2);
    }

    /* renamed from: com.miui.support.widget.TimePicker.1 */
    final class C05101 implements OnTimeChangedListener {
        C05101() {
        }

        public void m6097a(TimePicker timePicker, int i, int i2) {
        }
    }

    /* renamed from: com.miui.support.widget.TimePicker.2 */
    class C05112 implements OnValueChangeListener {
        final /* synthetic */ TimePicker f4476a;

        C05112(TimePicker timePicker) {
            this.f4476a = timePicker;
        }

        public void m6098a(NumberPicker numberPicker, int i, int i2) {
            if (!this.f4476a.m6113a() && ((i == 11 && i2 == 12) || (i == 12 && i2 == 11))) {
                this.f4476a.f4484c = !this.f4476a.f4484c;
                this.f4476a.m6111d();
            }
            this.f4476a.m6112e();
        }
    }

    /* renamed from: com.miui.support.widget.TimePicker.3 */
    class C05123 implements OnValueChangeListener {
        final /* synthetic */ TimePicker f4477a;

        C05123(TimePicker timePicker) {
            this.f4477a = timePicker;
        }

        public void m6099a(NumberPicker numberPicker, int i, int i2) {
            this.f4477a.m6112e();
        }
    }

    /* renamed from: com.miui.support.widget.TimePicker.4 */
    class C05134 implements OnClickListener {
        final /* synthetic */ TimePicker f4478a;

        C05134(TimePicker timePicker) {
            this.f4478a = timePicker;
        }

        public void onClick(View view) {
            view.requestFocus();
            this.f4478a.f4484c = !this.f4478a.f4484c;
            this.f4478a.m6111d();
            this.f4478a.m6112e();
        }
    }

    /* renamed from: com.miui.support.widget.TimePicker.5 */
    class C05145 implements OnValueChangeListener {
        final /* synthetic */ TimePicker f4479a;

        C05145(TimePicker timePicker) {
            this.f4479a = timePicker;
        }

        public void m6100a(NumberPicker numberPicker, int i, int i2) {
            numberPicker.requestFocus();
            this.f4479a.f4484c = !this.f4479a.f4484c;
            this.f4479a.m6111d();
            this.f4479a.m6112e();
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        private final int f4480a;
        private final int f4481b;

        /* renamed from: com.miui.support.widget.TimePicker.SavedState.1 */
        final class C05151 implements Creator<SavedState> {
            C05151() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6101a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6102a(i);
            }

            public SavedState m6101a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m6102a(int i) {
                return new SavedState[i];
            }
        }

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.f4480a = i;
            this.f4481b = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4480a = parcel.readInt();
            this.f4481b = parcel.readInt();
        }

        public int m6103a() {
            return this.f4480a;
        }

        public int m6104b() {
            return this.f4481b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4480a);
            parcel.writeInt(this.f4481b);
        }

        static {
            CREATOR = new C05151();
        }
    }

    static {
        f4482a = new C05101();
    }

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4489h = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.time_picker, this, true);
        this.f4485d = (NumberPicker) findViewById(C0264R.id.hour);
        this.f4485d.setOnValueChangedListener(new C05112(this));
        ((EditText) this.f4485d.findViewById(C0264R.id.numberpicker_input)).setImeOptions(5);
        this.f4486e = (NumberPicker) findViewById(C0264R.id.minute);
        this.f4486e.setMinValue(0);
        this.f4486e.setMaxValue(59);
        this.f4486e.setOnLongPressUpdateInterval(100);
        this.f4486e.setFormatter(NumberPicker.f4254a);
        this.f4486e.setOnValueChangedListener(new C05123(this));
        ((EditText) this.f4486e.findViewById(C0264R.id.numberpicker_input)).setImeOptions(5);
        View findViewById = findViewById(C0264R.id.amPm);
        if (findViewById instanceof Button) {
            this.f4487f = null;
            this.f4488g = (Button) findViewById;
            this.f4488g.setOnClickListener(new C05134(this));
        } else {
            this.f4488g = null;
            this.f4487f = (NumberPicker) findViewById;
            this.f4487f.setMinValue(0);
            this.f4487f.setMaxValue(1);
            this.f4487f.setDisplayedValues(CalendarFormatSymbols.m3401a().m3406f());
            this.f4487f.setOnValueChangedListener(new C05145(this));
            ((EditText) this.f4487f.findViewById(C0264R.id.numberpicker_input)).setImeOptions(6);
        }
        if (m6108b()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(C0264R.id.timePickerLayout);
            viewGroup.removeView(findViewById);
            viewGroup.addView(findViewById, 0);
        }
        m6109c();
        m6111d();
        setOnTimeChangedListener(f4482a);
        setCurrentHour(Integer.valueOf(this.f4491j.m3380a(18)));
        setCurrentMinute(Integer.valueOf(this.f4491j.m3380a(20)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private boolean m6108b() {
        boolean startsWith = getContext().getString(C0264R.string.fmt_time_12hour_pm).startsWith("a");
        if (getResources().getConfiguration().getLayoutDirection() != 1) {
            return startsWith;
        }
        if (startsWith) {
            return false;
        }
        return true;
    }

    public void setEnabled(boolean z) {
        if (this.f4489h != z) {
            super.setEnabled(z);
            this.f4486e.setEnabled(z);
            this.f4485d.setEnabled(z);
            if (this.f4487f != null) {
                this.f4487f.setEnabled(z);
            } else {
                this.f4488g.setEnabled(z);
            }
            this.f4489h = z;
        }
    }

    public boolean isEnabled() {
        return this.f4489h;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.f4492k)) {
            this.f4492k = locale;
            if (this.f4491j == null) {
                this.f4491j = new Calendar();
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(getCurrentHour().intValue(), getCurrentMinute().intValue(), null);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.m6103a()));
        setCurrentMinute(Integer.valueOf(savedState.m6104b()));
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.f4490i = onTimeChangedListener;
    }

    public Integer getCurrentHour() {
        int value = this.f4485d.getValue();
        if (m6113a()) {
            return Integer.valueOf(value);
        }
        if (this.f4484c) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && !num.equals(getCurrentHour())) {
            if (!m6113a()) {
                if (num.intValue() >= 12) {
                    this.f4484c = false;
                    if (num.intValue() > 12) {
                        num = Integer.valueOf(num.intValue() - 12);
                    }
                } else {
                    this.f4484c = true;
                    if (num.intValue() == 0) {
                        num = Integer.valueOf(12);
                    }
                }
                m6111d();
            }
            this.f4485d.setValue(num.intValue());
            m6112e();
        }
    }

    public void setIs24HourView(Boolean bool) {
        if (this.f4483b != bool.booleanValue()) {
            this.f4483b = bool.booleanValue();
            int intValue = getCurrentHour().intValue();
            m6109c();
            setCurrentHour(Integer.valueOf(intValue));
            m6111d();
        }
    }

    public boolean m6113a() {
        return this.f4483b;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f4486e.getValue());
    }

    public void setCurrentMinute(Integer num) {
        if (!num.equals(getCurrentMinute())) {
            this.f4486e.setValue(num.intValue());
            m6112e();
        }
    }

    public int getBaseline() {
        return this.f4485d.getBaseline();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (this.f4483b) {
            i = 44;
        } else {
            i = 28;
        }
        this.f4491j.m3383a(18, getCurrentHour().intValue());
        this.f4491j.m3383a(20, getCurrentMinute().intValue());
        accessibilityEvent.getText().add(DateUtils.m3428a(this.f4491j.m3382a(), i));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TimePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    private void m6109c() {
        if (m6113a()) {
            this.f4485d.setMinValue(0);
            this.f4485d.setMaxValue(23);
            this.f4485d.setFormatter(NumberPicker.f4254a);
            return;
        }
        this.f4485d.setMinValue(1);
        this.f4485d.setMaxValue(12);
        this.f4485d.setFormatter(null);
    }

    private void m6111d() {
        if (!m6113a()) {
            int i = this.f4484c ? 0 : 1;
            if (this.f4487f != null) {
                this.f4487f.setValue(i);
                this.f4487f.setVisibility(0);
            } else {
                this.f4488g.setText(CalendarFormatSymbols.m3401a().m3406f()[i]);
                this.f4488g.setVisibility(0);
            }
        } else if (this.f4487f != null) {
            this.f4487f.setVisibility(8);
        } else {
            this.f4488g.setVisibility(8);
        }
        sendAccessibilityEvent(4);
    }

    private void m6112e() {
        sendAccessibilityEvent(4);
        if (this.f4490i != null) {
            this.f4490i.m6096a(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }
}
