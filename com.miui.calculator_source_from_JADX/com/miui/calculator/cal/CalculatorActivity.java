package com.miui.calculator.cal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.miui.calculator.GridViewAdapter;
import com.miui.calculator.GridViewGroup;
import com.miui.calculator.GridViewGroup.OnItemMovedListener;
import com.miui.calculator.GridViewGroup.OnPageChangeListener;
import com.miui.calculator.PageIndicatorView;
import com.miui.calculator.bridge.NavigationBarBridge;
import com.miui.calculator.common.utils.AnimationUtils;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.calculator.convert.ConvertActivity;
import com.miui.calculator.convert.CurrencyActivity;
import com.miui.calculator.mortgage.MortgageActivity;
import com.miui.calculator.relationship.RelationshipActivity;
import com.miui.calculator.tax.TaxActivity;
import com.miui.calculator.wordfigure.WordFigureActivity;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import org.json.JSONArray;

public class CalculatorActivity extends Activity {
    public static String f1459a;
    public static String f1460b;
    public static String f1461c;
    public static String f1462d;
    public static String f1463e;
    public static String f1464f;
    public static String f1465g;
    private static String f1466h;
    private GridViewGroup f1467i;
    private GridViewAdapter f1468j;
    private PageIndicatorView f1469k;
    private int f1470l;
    private ActivityBackReceiver f1471m;
    private boolean f1472n;
    private OnPageChangeListener f1473o;

    /* renamed from: com.miui.calculator.cal.CalculatorActivity.1 */
    class C01581 implements OnPageChangeListener {
        final /* synthetic */ CalculatorActivity f1454a;

        C01581(CalculatorActivity calculatorActivity) {
            this.f1454a = calculatorActivity;
        }

        public void m2738a(int i) {
            if (this.f1454a.f1469k != null) {
                this.f1454a.f1469k.setSelectedPage(i);
            }
        }
    }

    /* renamed from: com.miui.calculator.cal.CalculatorActivity.2 */
    class C01592 implements OnItemMovedListener {
        final /* synthetic */ CalculatorActivity f1455a;

        C01592(CalculatorActivity calculatorActivity) {
            this.f1455a = calculatorActivity;
        }

        public void m2739a() {
            this.f1455a.m2750c();
        }
    }

    /* renamed from: com.miui.calculator.cal.CalculatorActivity.3 */
    class C01603 implements OnClickListener {
        final /* synthetic */ CalculatorActivity f1456a;

        C01603(CalculatorActivity calculatorActivity) {
            this.f1456a = calculatorActivity;
        }

        public void onClick(View view) {
            int a = this.f1456a.f1468j.m2574a(view);
            switch (a) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    this.f1456a.m2745a(this.f1456a, new Intent(this.f1456a, NormalCalculatorActivity.class), a);
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    Intent intent = new Intent(this.f1456a, AllInOneCalculatorActivity.class);
                    intent.putExtra("extra_is_scientific", true);
                    this.f1456a.m2745a(this.f1456a, intent, a);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f1456a.m2744a(this.f1456a, 1, a);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    this.f1456a.m2745a(this.f1456a, new Intent(this.f1456a, MortgageActivity.class), a);
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    this.f1456a.m2745a(this.f1456a, new Intent(this.f1456a, TaxActivity.class), a);
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    this.f1456a.m2744a(this.f1456a, 2, a);
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    this.f1456a.m2744a(this.f1456a, 3, a);
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    this.f1456a.m2744a(this.f1456a, 4, a);
                case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    this.f1456a.m2744a(this.f1456a, 8, a);
                case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                    this.f1456a.m2744a(this.f1456a, 5, a);
                case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                    this.f1456a.m2744a(this.f1456a, 6, a);
                case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                    this.f1456a.m2744a(this.f1456a, 7, a);
                case C0264R.styleable.Window_windowLayoutMode /*15*/:
                    this.f1456a.m2745a(this.f1456a, new Intent(this.f1456a, WordFigureActivity.class), a);
                case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                    this.f1456a.m2745a(this.f1456a, new Intent(this.f1456a, RelationshipActivity.class), a);
                default:
            }
        }
    }

    /* renamed from: com.miui.calculator.cal.CalculatorActivity.4 */
    class C01614 implements OnClickListener {
        final /* synthetic */ CalculatorActivity f1457a;

        C01614(CalculatorActivity calculatorActivity) {
            this.f1457a = calculatorActivity;
        }

        public void onClick(View view) {
            this.f1457a.m2751d();
        }
    }

    class ActivityBackReceiver extends BroadcastReceiver {
        final /* synthetic */ CalculatorActivity f1458a;

        ActivityBackReceiver(CalculatorActivity calculatorActivity) {
            this.f1458a = calculatorActivity;
        }

        public void onReceive(Context context, Intent intent) {
            Log.d(CalculatorActivity.f1466h, "ActivityBackReceiver onReceive");
            if (intent != null && TextUtils.equals(CalculatorActivity.f1465g, intent.getAction())) {
                this.f1458a.finish();
            }
        }
    }

    public CalculatorActivity() {
        this.f1470l = -1;
        this.f1471m = new ActivityBackReceiver(this);
        this.f1472n = true;
        this.f1473o = new C01581(this);
    }

    static {
        f1459a = "pref_item_position";
        f1460b = "pivot_x";
        f1461c = "pivot_y";
        f1462d = "disable_enter_anim";
        f1463e = "close_menu_when_back";
        f1464f = "first_start";
        f1466h = "Calculator:CalculatorActivity";
        f1465g = "com.miui.calculator.ActivityBack";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2747b();
        setContentView(C0264R.layout.activity_menu);
        NavigationBarBridge.m2614a(this, C0264R.color.grid_bg);
        this.f1467i = (GridViewGroup) findViewById(C0264R.id.grid_viewgroup);
        this.f1467i.m2612a((android.app.Activity) this);
        this.f1469k = (PageIndicatorView) findViewById(C0264R.id.indicator);
        this.f1468j = new GridViewAdapter(this);
        this.f1467i.setOnPageChangeListener(this.f1473o);
        this.f1467i.setOnItemExchangedListener(this.f1468j.f1310a);
        this.f1467i.setOnItemMovedListener(new C01592(this));
        this.f1467i.setItemOnClickListener(new C01603(this));
        this.f1467i.setAdapter(this.f1468j);
        if (this.f1469k != null) {
            this.f1469k.setIndicatorCount(this.f1467i.getPageCount());
        }
        this.f1472n = getIntent().getBooleanExtra(f1464f, true);
        if (this.f1472n) {
            m2746a(true);
            registerReceiver(this.f1471m, new IntentFilter(f1465g));
        }
        AnimationUtils.m2797a(this);
    }

    private void m2747b() {
        m2626e().setCustomView(C0264R.layout.home_title);
        View customView = m2626e().getCustomView();
        TextView textView = (TextView) customView.findViewById(C0264R.id.txv_title);
        if (textView != null) {
            textView.setText(C0264R.string.home_title_calculator);
        }
        View findViewById = customView.findViewById(C0264R.id.txv_settings);
        if (findViewById != null) {
            findViewById.setOnClickListener(new C01614(this));
        }
    }

    protected void onResume() {
        super.onResume();
        StatisticUtils.m2889a(getClass().getSimpleName());
    }

    protected void onPause() {
        super.onPause();
        StatisticUtils.m2897b(getClass().getSimpleName());
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f1472n) {
            unregisterReceiver(this.f1471m);
        }
    }

    public void onBackPressed() {
        if (this.f1472n) {
            m2746a(false);
        } else {
            super.onBackPressed();
        }
    }

    private void m2750c() {
        int i = 0;
        if (this.f1468j != null && this.f1468j.getCount() != 0) {
            SharedPreferences sharedPreferences = getSharedPreferences(f1459a, 0);
            int[] iArr = new int[this.f1468j.getCount()];
            for (int i2 = 0; i2 < this.f1468j.getCount(); i2++) {
                iArr[i2] = (int) this.f1468j.getItemId(i2);
            }
            JSONArray jSONArray = new JSONArray();
            int length = iArr.length;
            while (i < length) {
                int i3 = iArr[i];
                jSONArray.put(i3);
                Log.i(f1466h, "save position " + i3);
                i++;
            }
            Editor edit = sharedPreferences.edit();
            edit.putString(f1459a, jSONArray.toString());
            edit.apply();
        }
    }

    private void m2751d() {
        startActivity(new Intent(this, CalSettingsActivity.class));
    }

    private void m2744a(Activity activity, int i, int i2) {
        Intent intent;
        if (i == 1) {
            intent = new Intent(activity, CurrencyActivity.class);
        } else {
            intent = new Intent(activity, ConvertActivity.class);
        }
        intent.putExtra("extra_type", i);
        m2745a(activity, intent, i2);
    }

    private void m2746a(boolean z) {
        Intent intent = new Intent(this, NormalCalculatorActivity.class);
        this.f1470l = this.f1468j.m2573a();
        this.f1467i.m2613a(intent, this.f1470l, (android.app.Activity) this);
        intent.putExtra(f1462d, z);
        intent.putExtra(f1463e, true);
        startActivity(intent);
        m2753g();
    }

    private void m2745a(Activity activity, Intent intent, int i) {
        this.f1470l = this.f1468j.m2576b(i);
        this.f1467i.m2613a(intent, this.f1470l, (android.app.Activity) activity);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
        m2753g();
    }

    private void m2753g() {
        if (this.f1470l >= 0) {
            this.f1467i.m2609a(this.f1470l);
        }
    }
}
