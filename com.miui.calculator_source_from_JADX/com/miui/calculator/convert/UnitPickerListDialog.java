package com.miui.calculator.convert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.miui.calculator.convert.units.UnitsDataBase;
import com.miui.support.app.AlertDialog;
import com.miui.support.internal.C0264R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitPickerListDialog extends AlertDialog {
    List<Map<String, String>> f1615a;
    private UnitsDataBase f1616b;
    private OnUnitSelectListener f1617c;
    private ListView f1618d;
    private ListAdapter f1619e;

    public interface OnUnitSelectListener {
        void m2931a(String str);
    }

    /* renamed from: com.miui.calculator.convert.UnitPickerListDialog.1 */
    class C01881 implements OnDismissListener {
        final /* synthetic */ UnitPickerListDialog f1609a;

        C01881(UnitPickerListDialog unitPickerListDialog) {
            this.f1609a = unitPickerListDialog;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f1609a.f1617c != null) {
                this.f1609a.f1617c.m2931a(null);
            }
        }
    }

    /* renamed from: com.miui.calculator.convert.UnitPickerListDialog.2 */
    class C01892 implements OnClickListener {
        final /* synthetic */ UnitPickerListDialog f1610a;

        C01892(UnitPickerListDialog unitPickerListDialog) {
            this.f1610a = unitPickerListDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1610a.dismiss();
        }
    }

    class UnitAdapter extends SimpleAdapter {
        final /* synthetic */ UnitPickerListDialog f1613a;

        /* renamed from: com.miui.calculator.convert.UnitPickerListDialog.UnitAdapter.1 */
        class C01901 implements View.OnClickListener {
            final /* synthetic */ String f1611a;
            final /* synthetic */ UnitAdapter f1612b;

            C01901(UnitAdapter unitAdapter, String str) {
                this.f1612b = unitAdapter;
                this.f1611a = str;
            }

            public void onClick(View view) {
                if (this.f1612b.f1613a.f1617c != null) {
                    this.f1612b.f1613a.f1617c.m2931a(this.f1611a);
                    this.f1612b.f1613a.dismiss();
                }
            }
        }

        public UnitAdapter(UnitPickerListDialog unitPickerListDialog, Context context, List<? extends Map<String, ?>> list, int i, String[] strArr, int[] iArr) {
            this.f1613a = unitPickerListDialog;
            super(context, list, i, strArr, iArr);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            ImageView imageView = (ImageView) view2.findViewById(C0264R.id.unit_icon);
            String str = (String) ((Map) getItem(i)).get("unitName");
            if (imageView != null) {
                if (this.f1613a.f1616b.m2998h(str) > 0) {
                    imageView.setImageResource(this.f1613a.f1616b.m2998h(str));
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            view2.setOnClickListener(new C01901(this, str));
            return view2;
        }
    }

    protected UnitPickerListDialog(Context context, UnitsDataBase unitsDataBase, String str, OnUnitSelectListener onUnitSelectListener) {
        super(context);
        this.f1615a = new ArrayList();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.layout_unit_picker_list, null);
        m2970a(inflate);
        this.f1618d = (ListView) inflate.findViewById(C0264R.id.unit_list);
        m2973a(unitsDataBase);
        this.f1617c = onUnitSelectListener;
        setOnDismissListener(new C01881(this));
        m2969a(-2, context.getString(17039360), new C01892(this));
    }

    private void m2973a(UnitsDataBase unitsDataBase) {
        this.f1616b = unitsDataBase;
        for (String str : this.f1616b.m2996f()) {
            Map hashMap = new HashMap();
            hashMap.put("unitName", this.f1616b.m2997g(str));
            hashMap.put("unitDisplay", this.f1616b.m2995f(str));
            this.f1615a.add(hashMap);
        }
        this.f1619e = new UnitAdapter(this, getContext(), this.f1615a, C0264R.layout.unit_picker_list_item_view, new String[]{"unitDisplay"}, new int[]{C0264R.id.unit_display});
        this.f1618d.setAdapter(this.f1619e);
    }
}
