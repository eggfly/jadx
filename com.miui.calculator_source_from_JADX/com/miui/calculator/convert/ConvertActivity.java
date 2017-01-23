package com.miui.calculator.convert;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.calculator.common.widget.NumberPad;
import com.miui.calculator.common.widget.NumberPad.OnNumberClickListener;
import com.miui.calculator.convert.UnitPickerListDialog.OnUnitSelectListener;
import com.miui.calculator.convert.UnitView.OnItemClickListener;
import com.miui.calculator.convert.units.UnitsDataBase;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class ConvertActivity extends BaseActivity {
    protected int f1593a;
    private NumberPad f1594b;
    private UnitsDataBase f1595c;
    private int f1596d;
    private UnitDiplay[] f1597e;
    private Dialog f1598f;
    private boolean f1599g;
    private OnNumberClickListener f1600h;
    private OnItemClickListener f1601i;

    /* renamed from: com.miui.calculator.convert.ConvertActivity.1 */
    class C01811 extends Thread {
        final /* synthetic */ ConvertActivity f1584a;

        /* renamed from: com.miui.calculator.convert.ConvertActivity.1.1 */
        class C01801 implements Runnable {
            final /* synthetic */ C01811 f1583a;

            C01801(C01811 c01811) {
                this.f1583a = c01811;
            }

            public void run() {
                this.f1583a.f1584a.m2952a(false);
                this.f1583a.f1584a.m2947g();
            }
        }

        C01811(ConvertActivity convertActivity) {
            this.f1584a = convertActivity;
        }

        public void run() {
            this.f1584a.f1595c.m2992d();
            this.f1584a.runOnUiThread(new C01801(this));
        }
    }

    /* renamed from: com.miui.calculator.convert.ConvertActivity.2 */
    class C01822 implements OnUnitSelectListener {
        final /* synthetic */ int f1585a;
        final /* synthetic */ ConvertActivity f1586b;

        C01822(ConvertActivity convertActivity, int i) {
            this.f1586b = convertActivity;
            this.f1585a = i;
        }

        public void m2932a(String str) {
            this.f1586b.m2950a(this.f1586b.f1593a, 2);
            if (str != null) {
                this.f1586b.m2938a(this.f1585a, str);
                StatisticUtils.m2898b(this.f1586b.m2954b(), str);
            }
        }
    }

    /* renamed from: com.miui.calculator.convert.ConvertActivity.3 */
    class C01833 implements OnNumberClickListener {
        final /* synthetic */ ConvertActivity f1587a;

        C01833(ConvertActivity convertActivity) {
            this.f1587a = convertActivity;
        }

        public void m2933a(NumberPad numberPad, int i) {
            String str = this.f1587a.f1597e[this.f1587a.f1593a].f1591c;
            String b = NumberPad.m2910b(i);
            if (!(this.f1587a.f1599g && NumberPad.m2909a(i) && !String.valueOf('.').equals(b))) {
                b = numberPad.m2921a(str, i, true);
            }
            this.f1587a.f1599g = false;
            this.f1587a.m2951a(b);
        }
    }

    /* renamed from: com.miui.calculator.convert.ConvertActivity.4 */
    class C01844 implements OnItemClickListener {
        final /* synthetic */ ConvertActivity f1588a;

        C01844(ConvertActivity convertActivity) {
            this.f1588a = convertActivity;
        }

        public void m2935a(UnitView unitView, int i) {
            int i2 = 0;
            while (i2 < this.f1588a.f1597e.length && this.f1588a.f1597e[i2].f1589a != unitView) {
                i2++;
            }
            if (i2 >= this.f1588a.f1597e.length || i2 < 0) {
                i2 = 0;
            }
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    this.f1588a.m2950a(i2, 1);
                    this.f1588a.m2946e(i2);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f1588a.m2949a(i2);
                default:
            }
        }
    }

    private class UnitDiplay {
        UnitView f1589a;
        String f1590b;
        String f1591c;
        final /* synthetic */ ConvertActivity f1592d;

        private UnitDiplay(ConvertActivity convertActivity) {
            this.f1592d = convertActivity;
        }

        void m2936a() {
            if (TextUtils.isEmpty(this.f1590b)) {
                this.f1589a.setVisibility(8);
                return;
            }
            this.f1589a.m2977a(this.f1592d.f1595c.m2989b(this.f1590b), this.f1592d.f1595c.m2990c(this.f1590b));
            this.f1589a.setValue(this.f1591c);
            this.f1589a.setUnitIcon(this.f1592d.f1595c.m2998h(this.f1590b));
        }
    }

    public ConvertActivity() {
        this.f1593a = 0;
        this.f1600h = new C01833(this);
        this.f1601i = new C01844(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.convert_activity);
        findViewById(C0264R.id.conversion_layout).setLayoutDirection(0);
        this.f1596d = getIntent().getIntExtra("extra_type", 0);
        this.f1595c = m2953b(this.f1596d);
        m2952a(true);
        new C01811(this).start();
        this.f1599g = true;
        super.m2642a();
    }

    protected void m2948a() {
    }

    protected void onPause() {
        super.onPause();
        m2955c();
    }

    protected String m2954b() {
        return this.f1595c.getClass().getSimpleName();
    }

    protected void m2955c() {
        for (int i = 0; i < this.f1597e.length; i++) {
            this.f1595c.m2985a(i, this.f1597e[i].f1590b);
        }
    }

    protected void m2951a(String str) {
        UnitDiplay unitDiplay = this.f1597e[this.f1593a];
        unitDiplay.f1591c = str;
        unitDiplay.m2936a();
        m2956d();
    }

    protected void m2956d() {
        UnitDiplay unitDiplay = this.f1597e[this.f1593a];
        for (int i = 0; i < this.f1597e.length; i++) {
            if (i != this.f1593a) {
                UnitDiplay unitDiplay2 = this.f1597e[i];
                if (unitDiplay2.f1590b != null) {
                    unitDiplay2.f1591c = this.f1595c.m2983a(unitDiplay.f1590b, unitDiplay.f1591c, unitDiplay2.f1590b);
                    unitDiplay2.m2936a();
                }
            }
        }
    }

    protected void m2950a(int i, int i2) {
        for (UnitDiplay unitDiplay : this.f1597e) {
            unitDiplay.f1589a.m2976a(1, false);
            unitDiplay.f1589a.m2976a(2, false);
        }
        this.f1597e[i].f1589a.m2976a(i2, true);
    }

    private void m2938a(int i, String str) {
        UnitDiplay unitDiplay = this.f1597e[i];
        if (!str.equals(unitDiplay.f1590b)) {
            unitDiplay.f1590b = str;
            unitDiplay.m2936a();
        }
        m2956d();
    }

    protected void m2949a(int i) {
        if (this.f1593a != i) {
            this.f1593a = i;
            m2950a(i, 2);
        }
    }

    private void m2944d(int i) {
        this.f1597e = new UnitDiplay[3];
        for (int i2 = 0; i2 < this.f1597e.length; i2++) {
            this.f1597e[i2] = new UnitDiplay();
            this.f1597e[i2].f1590b = this.f1595c.m2982a(i2);
        }
        switch (i) {
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                setTitle((int) C0264R.string.convertion_unit_length);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                setTitle((int) C0264R.string.convertion_unit_area);
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                setTitle((int) C0264R.string.convertion_unit_volume);
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                setTitle((int) C0264R.string.convertion_unit_temperature);
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                setTitle((int) C0264R.string.convertion_unit_velocity);
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                setTitle((int) C0264R.string.convertion_unit_time);
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                setTitle((int) C0264R.string.convertion_unit_weight);
            default:
        }
    }

    protected UnitsDataBase m2953b(int i) {
        return UnitsDataBase.m2979a((Context) this, i);
    }

    protected void m2952a(boolean z) {
        m2944d(this.f1596d);
        this.f1594b = (NumberPad) findViewById(C0264R.id.nbp_pad);
        this.f1594b.setPadType(this.f1596d == 5 ? 2 : 1);
        this.f1594b.setOnNumberClickListener(z ? null : this.f1600h);
        this.f1597e[0].f1589a = (UnitView) findViewById(C0264R.id.unv_1);
        this.f1597e[1].f1589a = (UnitView) findViewById(C0264R.id.unv_2);
        this.f1597e[2].f1589a = (UnitView) findViewById(C0264R.id.unv_3);
        for (UnitDiplay unitDiplay : this.f1597e) {
            unitDiplay.f1589a.setOnItemClickListner(z ? null : this.f1601i);
            unitDiplay.m2936a();
        }
    }

    private void m2947g() {
        this.f1593a = -1;
        m2949a(0);
        m2951a("1");
    }

    private void m2946e(int i) {
        if (this.f1598f != null) {
            this.f1598f.cancel();
            this.f1598f = null;
        }
        Dialog unitPickerListDialog = new UnitPickerListDialog(this, this.f1595c, this.f1597e[i].f1590b, new C01822(this, i));
        unitPickerListDialog.setTitle(this.f1596d == 1 ? C0264R.string.choose_currency : C0264R.string.choose_unit);
        unitPickerListDialog.show();
        this.f1598f = unitPickerListDialog;
    }
}
