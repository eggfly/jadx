package com.miui.calculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.calculator.GridViewGroup.OnItemExchangedListener;
import com.miui.calculator.cal.CalculatorActivity;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;

public class GridViewAdapter extends BaseAdapter {
    private static String f1308b;
    private static final ArrayList<Integer> f1309c;
    public OnItemExchangedListener f1310a;
    private ArrayList<CalculatorItem> f1311d;
    private Context f1312e;

    /* renamed from: com.miui.calculator.GridViewAdapter.1 */
    class C01341 implements OnItemExchangedListener {
        final /* synthetic */ GridViewAdapter f1301a;

        C01341(GridViewAdapter gridViewAdapter) {
            this.f1301a = gridViewAdapter;
        }

        public void m2562a(int i, int i2) {
            Collections.swap(this.f1301a.f1311d, i, i2);
        }
    }

    private static class CalculatorItem {
        private int f1302a;
        private int f1303b;
        private int f1304c;

        public CalculatorItem(int i, int i2, int i3) {
            this.f1302a = i2;
            this.f1303b = i;
            this.f1304c = i3;
        }

        public int m2567a() {
            return this.f1302a;
        }

        public int m2568b() {
            return this.f1303b;
        }

        private static CalculatorItem m2566b(Context context, int i) {
            int i2;
            int i3;
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    i2 = C0264R.drawable.menu_icon_calculator;
                    i3 = C0264R.string.item_title_calculator;
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    i2 = C0264R.drawable.menu_icon_scientific_calculator;
                    i3 = C0264R.string.item_title_scientific_calculator;
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    i3 = C0264R.string.item_title_currency;
                    i2 = CalculatorUtils.m2821b() ? C0264R.drawable.menu_icon_conversion_currency_g : C0264R.drawable.menu_icon_conversion_currency;
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    i2 = C0264R.drawable.menu_icon_mortgage;
                    i3 = C0264R.string.item_title_mortgage;
                    break;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    i2 = C0264R.drawable.menu_icon_tax;
                    i3 = C0264R.string.item_title_tax;
                    break;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    i2 = C0264R.drawable.menu_icon_tip_calculate;
                    i3 = C0264R.string.item_title_tip;
                    break;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    i2 = C0264R.drawable.menu_icon_conversion_length;
                    i3 = C0264R.string.item_title_length_conversion;
                    break;
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    i2 = C0264R.drawable.menu_icon_conversion_area;
                    i3 = C0264R.string.item_title_area_conversion;
                    break;
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    i2 = C0264R.drawable.menu_icon_conversion_volume;
                    i3 = C0264R.string.item_title_volume_conversion;
                    break;
                case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    i2 = C0264R.drawable.menu_icon_conversion_weight;
                    i3 = C0264R.string.item_title_weight_conversion;
                    break;
                case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                    i2 = C0264R.drawable.menu_icon_conversion_temprature;
                    i3 = C0264R.string.item_title_temprature_conversion;
                    break;
                case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                    i2 = C0264R.drawable.menu_icon_conversion_velocity;
                    i3 = C0264R.string.item_title_vel_conversion;
                    break;
                case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                    i2 = C0264R.drawable.menu_icon_conversion_time;
                    i3 = C0264R.string.item_title_time_conversion;
                    break;
                case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                    i2 = C0264R.drawable.menu_icon_dress_size;
                    i3 = C0264R.string.item_title_dress_size;
                    break;
                case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                    i2 = C0264R.drawable.menu_icon_aa;
                    i3 = C0264R.string.item_title_aa_payment;
                    break;
                case C0264R.styleable.Window_windowLayoutMode /*15*/:
                    i2 = C0264R.drawable.menu_icon_word_figure;
                    i3 = C0264R.string.wf_word_figure;
                    break;
                case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                    i2 = C0264R.drawable.relationship_calculator_icon;
                    i3 = C0264R.string.item_title_relationship;
                    break;
                default:
                    i3 = 0;
                    i2 = 0;
                    break;
            }
            if (i2 != 0 && i3 != 0) {
                return new CalculatorItem(i3, i2, i);
            }
            Log.e(GridViewAdapter.f1308b, "Unknown itemId: " + i);
            return null;
        }
    }

    class ViewHolder {
        ImageView f1305a;
        TextView f1306b;
        final /* synthetic */ GridViewAdapter f1307c;

        ViewHolder(GridViewAdapter gridViewAdapter) {
            this.f1307c = gridViewAdapter;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m2575a(i);
    }

    static {
        f1308b = "Calculator:GridViewAdapter";
        f1309c = new ArrayList();
        f1309c.add(Integer.valueOf(2));
        f1309c.add(Integer.valueOf(3));
        if (!CalculatorUtils.m2821b()) {
            f1309c.add(Integer.valueOf(4));
        }
        if (CalculatorUtils.m2824d()) {
            f1309c.add(Integer.valueOf(15));
        }
        f1309c.add(Integer.valueOf(0));
        f1309c.add(Integer.valueOf(1));
        f1309c.add(Integer.valueOf(6));
        f1309c.add(Integer.valueOf(7));
        f1309c.add(Integer.valueOf(8));
        f1309c.add(Integer.valueOf(10));
        f1309c.add(Integer.valueOf(11));
        f1309c.add(Integer.valueOf(12));
        f1309c.add(Integer.valueOf(9));
        if (CalculatorUtils.m2826e()) {
            f1309c.add(Integer.valueOf(16));
        }
    }

    public GridViewAdapter(Context context) {
        this.f1310a = new C01341(this);
        this.f1312e = context;
        m2572c();
    }

    public int getCount() {
        return this.f1311d.size();
    }

    public CalculatorItem m2575a(int i) {
        return (CalculatorItem) this.f1311d.get(i);
    }

    public long getItemId(int i) {
        return (long) ((CalculatorItem) this.f1311d.get(i)).f1304c;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f1312e).inflate(C0264R.layout.grid_item, null);
            ViewHolder viewHolder = new ViewHolder(this);
            viewHolder.f1305a = (ImageView) view.findViewById(C0264R.id.imv_icon);
            viewHolder.f1306b = (TextView) view.findViewById(C0264R.id.txv_title);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder2 = (ViewHolder) view.getTag();
        CalculatorItem a = m2575a(i);
        viewHolder2.f1305a.setImageResource(a.m2567a());
        viewHolder2.f1306b.setText(a.m2568b());
        return view;
    }

    public int m2574a(View view) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        for (int i = 0; i < getCount(); i++) {
            if (this.f1312e.getResources().getString(((CalculatorItem) this.f1311d.get(i)).f1303b).equals(viewHolder.f1306b.getText().toString())) {
                return ((CalculatorItem) this.f1311d.get(i)).f1304c;
            }
        }
        return -1;
    }

    private void m2572c() {
        int i = 0;
        this.f1311d = new ArrayList();
        int[] a = m2570a(this.f1312e);
        if (a == null) {
            for (int i2 = 0; i2 < f1309c.size(); i2++) {
                this.f1311d.add(CalculatorItem.m2566b(this.f1312e, ((Integer) f1309c.get(i2)).intValue()));
            }
            return;
        }
        while (i < a.length) {
            this.f1311d.add(CalculatorItem.m2566b(this.f1312e, a[i]));
            i++;
        }
    }

    private int[] m2570a(Context context) {
        int[] iArr = null;
        int i = 0;
        String string = context.getSharedPreferences(CalculatorActivity.f1459a, 0).getString(CalculatorActivity.f1459a, null);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                iArr = new int[jSONArray.length()];
                while (i < jSONArray.length()) {
                    iArr[i] = jSONArray.getInt(i);
                    Log.i(f1308b, " initItemposition  not null position " + jSONArray.getInt(i));
                    i++;
                }
            } catch (Throwable e) {
                Log.e(f1308b, "Exception", e);
            }
        }
        return iArr;
    }

    public int m2576b(int i) {
        int[] a = m2570a(CalculatorApplication.m2559b());
        if (a != null) {
            for (int i2 = 0; i2 < a.length; i2++) {
                if (a[i2] == i) {
                    return i2;
                }
            }
        }
        for (int i3 = 0; i3 < f1309c.size(); i3++) {
            if (((Integer) f1309c.get(i3)).intValue() == i) {
                return i3;
            }
        }
        return 0;
    }

    public int m2573a() {
        return m2576b(0);
    }
}
