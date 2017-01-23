package com.miui.calculator.mortgage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.mortgage.MortgageCalculator.MortgageMonthly;
import com.miui.calculator.mortgage.MortgageCalculator.MortgageResult;
import com.miui.support.app.Activity;
import com.miui.support.date.Calendar;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import java.util.ArrayList;

public class MortgageDetailActivity extends Activity {
    private MortgageDetailAdapter f1705a;
    private ListView f1706b;

    private static class MonthlyItem {
        int f1680a;
        double f1681b;
        double f1682c;
        double f1683d;
        double f1684e;

        private MonthlyItem(int i, double d, double d2, double d3, double d4) {
            this.f1680a = i;
            this.f1681b = d;
            this.f1682c = d2;
            this.f1683d = d3;
            this.f1684e = d4;
        }
    }

    private class MortgageDetailAdapter extends BaseAdapter {
        final /* synthetic */ MortgageDetailActivity f1686a;
        private ArrayList<YearlyTitleItem> f1687b;
        private LayoutInflater f1688c;
        private Context f1689d;
        private final Calendar f1690e;
        private int f1691f;
        private int f1692g;

        /* renamed from: com.miui.calculator.mortgage.MortgageDetailActivity.MortgageDetailAdapter.1 */
        class C02031 implements OnClickListener {
            final /* synthetic */ MortgageDetailAdapter f1685a;

            C02031(MortgageDetailAdapter mortgageDetailAdapter) {
                this.f1685a = mortgageDetailAdapter;
            }

            public void onClick(View view) {
                int i = 0;
                ViewParent parent = view.getParent();
                while (parent != null && (parent instanceof View)) {
                    if (((View) parent).getTag() instanceof ViewHolder) {
                        break;
                    }
                }
                if (parent != null) {
                    ViewHolder viewHolder = (ViewHolder) ((View) parent).getTag();
                    boolean z = !((YearlyTitleItem) this.f1685a.f1687b.get(viewHolder.f1699g)).f1701b;
                    ((YearlyTitleItem) this.f1685a.f1687b.get(viewHolder.f1699g)).f1701b = z;
                    LinearLayout linearLayout = viewHolder.f1698f;
                    if (!z) {
                        i = 8;
                    }
                    linearLayout.setVisibility(i);
                    viewHolder.f1695c.setRotation(z ? 180.0f : 0.0f);
                    this.f1685a.f1686a.f1706b.setSelection(viewHolder.f1699g);
                }
            }
        }

        public /* synthetic */ Object getItem(int i) {
            return m3067a(i);
        }

        public MortgageDetailAdapter(MortgageDetailActivity mortgageDetailActivity, Context context, MortgageResult mortgageResult, long j) {
            this.f1686a = mortgageDetailActivity;
            this.f1690e = new Calendar();
            this.f1691f = this.f1690e.m3380a(1);
            this.f1692g = this.f1690e.m3380a(5);
            this.f1689d = context;
            m3068a(mortgageResult, j);
            this.f1688c = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public int getCount() {
            return this.f1687b.size();
        }

        public YearlyTitleItem m3067a(int i) {
            return (YearlyTitleItem) this.f1687b.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f1688c.inflate(C0264R.layout.mortgage_detail_list_item, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.f1693a = (LinearLayout) view.findViewById(C0264R.id.lyt_yearly_title);
                viewHolder.f1694b = (TextView) view.findViewById(C0264R.id.txv_year);
                viewHolder.f1695c = (ImageView) view.findViewById(C0264R.id.imv_arrow);
                viewHolder.f1696d = (TextView) view.findViewById(C0264R.id.txv_yearly_repayment);
                viewHolder.f1697e = (TextView) view.findViewById(C0264R.id.txv_yearly_interest);
                viewHolder.f1698f = (LinearLayout) view.findViewById(C0264R.id.lyt_monthly_item);
                for (int i2 = 0; i2 < 13; i2++) {
                    viewHolder.f1698f.addView(this.f1688c.inflate(C0264R.layout.mortgage_detail_monthly_item, null));
                }
                viewHolder.f1698f.setVisibility(8);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            YearlyTitleItem yearlyTitleItem = (YearlyTitleItem) this.f1687b.get(i);
            viewHolder2.f1693a.setOnClickListener(new C02031(this));
            viewHolder2.f1699g = i;
            if (yearlyTitleItem.f1701b) {
                viewHolder2.f1695c.setRotation(180.0f);
                viewHolder2.f1698f.setVisibility(0);
            } else {
                viewHolder2.f1695c.setRotation(0.0f);
                viewHolder2.f1698f.setVisibility(8);
            }
            viewHolder2.f1694b.setText(this.f1689d.getString(C0264R.string.unit_year_format, new Object[]{String.valueOf(yearlyTitleItem.f1700a)}));
            viewHolder2.f1696d.setText(NumberFormatUtils.m2884d(yearlyTitleItem.f1702c));
            viewHolder2.f1697e.setText(NumberFormatUtils.m2884d(yearlyTitleItem.f1703d));
            for (int i3 = 0; i3 < yearlyTitleItem.f1704e.size(); i3++) {
                int color;
                MonthlyItem monthlyItem = (MonthlyItem) yearlyTitleItem.f1704e.get(i3);
                View childAt = viewHolder2.f1698f.getChildAt(i3 + 1);
                childAt.setVisibility(0);
                Object obj = (yearlyTitleItem.f1700a == this.f1691f && monthlyItem.f1680a == this.f1692g) ? 1 : null;
                if (obj != null) {
                    color = this.f1689d.getResources().getColor(C0264R.color.item_high_light);
                } else {
                    color = this.f1689d.getResources().getColor(C0264R.color.detail_captital);
                }
                TextView textView = (TextView) childAt.findViewById(C0264R.id.txv_month);
                textView.setTextColor(color);
                this.f1690e.m3383a(5, monthlyItem.f1680a);
                textView.setText(DateUtils.m3428a(this.f1690e.m3382a(), 4352));
                textView = (TextView) childAt.findViewById(C0264R.id.txv_repayment);
                textView.setTextColor(color);
                textView.setText(NumberFormatUtils.m2884d(monthlyItem.f1681b));
                textView = (TextView) childAt.findViewById(C0264R.id.txv_principal);
                textView.setTextColor(color);
                textView.setText(NumberFormatUtils.m2884d(monthlyItem.f1682c));
                textView = (TextView) childAt.findViewById(C0264R.id.txv_interest);
                textView.setTextColor(color);
                textView.setText(NumberFormatUtils.m2884d(monthlyItem.f1683d));
                textView = (TextView) childAt.findViewById(C0264R.id.txv_remain);
                textView.setTextColor(color);
                textView.setText(NumberFormatUtils.m2884d(monthlyItem.f1684e));
            }
            for (int size = yearlyTitleItem.f1704e.size(); size + 1 < viewHolder2.f1698f.getChildCount(); size++) {
                viewHolder2.f1698f.getChildAt(size + 1).setVisibility(8);
            }
            return view;
        }

        public void m3068a(MortgageResult mortgageResult, long j) {
            this.f1690e.m3385a(j);
            int a = this.f1690e.m3380a(1);
            int a2 = this.f1690e.m3380a(5);
            this.f1687b = new ArrayList();
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            ArrayList arrayList = new ArrayList();
            int i2 = a;
            int i3 = a2;
            while (i < mortgageResult.f1679g.length) {
                ArrayList arrayList2;
                MortgageMonthly mortgageMonthly = mortgageResult.f1679g[i];
                double d3 = d + mortgageMonthly.f1669a;
                double d4 = d2 + mortgageMonthly.f1671c;
                arrayList.add(new MonthlyItem(mortgageMonthly.f1669a, mortgageMonthly.f1670b, mortgageMonthly.f1671c, mortgageMonthly.f1672d, null));
                this.f1690e.m3392b(5, 1);
                int a3 = this.f1690e.m3380a(5);
                int a4 = this.f1690e.m3380a(1);
                if (i2 < a4) {
                    this.f1687b.add(new YearlyTitleItem(d3, d4, arrayList, null));
                    d = 0.0d;
                    d2 = 0.0d;
                    arrayList2 = new ArrayList();
                    a2 = a4;
                } else {
                    arrayList2 = arrayList;
                    d2 = d4;
                    d = d3;
                    a2 = i2;
                }
                i++;
                arrayList = arrayList2;
                i2 = a2;
                i3 = a3;
            }
            this.f1687b.add(new YearlyTitleItem(d, d2, arrayList, null));
        }
    }

    private static class ViewHolder {
        LinearLayout f1693a;
        TextView f1694b;
        ImageView f1695c;
        TextView f1696d;
        TextView f1697e;
        LinearLayout f1698f;
        int f1699g;

        private ViewHolder() {
        }
    }

    private static class YearlyTitleItem {
        int f1700a;
        boolean f1701b;
        double f1702c;
        double f1703d;
        ArrayList<MonthlyItem> f1704e;

        private YearlyTitleItem(int i, double d, double d2, ArrayList<MonthlyItem> arrayList) {
            this.f1700a = i;
            this.f1702c = d;
            this.f1703d = d2;
            this.f1704e = arrayList;
            this.f1701b = false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.mortgage_detail_activity);
        this.f1705a = new MortgageDetailAdapter(this, this, (MortgageResult) getIntent().getParcelableExtra("extra_mortgage_result"), getIntent().getLongExtra("extra_start_time", 0));
        m3070a();
    }

    private void m3070a() {
        this.f1706b = (ListView) findViewById(C0264R.id.lsv_detail);
        this.f1706b.setAdapter(this.f1705a);
    }
}
