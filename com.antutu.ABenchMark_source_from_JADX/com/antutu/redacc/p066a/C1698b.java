package com.antutu.redacc.p066a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p072e.C1737a;
import com.antutu.utils.widget.SystemBarTintManager;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.antutu.redacc.a.b */
public class C1698b extends BaseAdapter {
    private LayoutInflater f6052a;
    private List<C1737a> f6053b;

    /* renamed from: com.antutu.redacc.a.b.1 */
    class C16961 implements OnClickListener {
        final /* synthetic */ int f6046a;
        final /* synthetic */ C1698b f6047b;

        C16961(C1698b c1698b, int i) {
            this.f6047b = c1698b;
            this.f6046a = i;
        }

        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent();
            intent.setAction("MSG_BR_ON_BTN_OPT_CLICK");
            intent.putExtra(AgooConstants.MESSAGE_ID, this.f6046a);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: com.antutu.redacc.a.b.a */
    static class C1697a {
        TextView f6048a;
        ImageView f6049b;
        ImageView f6050c;
        Button f6051d;

        C1697a() {
        }
    }

    public C1698b(Context context, List<C1737a> list) {
        this.f6052a = null;
        this.f6053b = null;
        this.f6053b = list;
        this.f6052a = LayoutInflater.from(context);
    }

    public C1737a m6612a(int i) {
        return this.f6053b != null ? (C1737a) this.f6053b.get(i) : null;
    }

    public int getCount() {
        return this.f6053b == null ? 0 : this.f6053b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return m6612a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C1697a c1697a;
        if (view == null) {
            try {
                inflate = this.f6052a.inflate(C1692R.layout.app_item_grid, null);
                try {
                    c1697a = new C1697a();
                    c1697a.f6048a = (TextView) inflate.findViewById(C1692R.id.textName);
                    c1697a.f6050c = (ImageView) inflate.findViewById(C1692R.id.imageBg);
                    c1697a.f6049b = (ImageView) inflate.findViewById(C1692R.id.imageIcon);
                    c1697a.f6051d = (Button) inflate.findViewById(C1692R.id.btnOpt);
                    inflate.setTag(c1697a);
                } catch (Exception e) {
                    return inflate;
                }
            } catch (Exception e2) {
                return view;
            }
        }
        c1697a = (C1697a) view.getTag();
        inflate = view;
        C1737a c1737a = (C1737a) this.f6053b.get(i);
        c1697a.f6048a.setText(c1737a.m6718f());
        c1697a.f6049b.setImageURI(c1737a.m6716d());
        if (c1737a.m6717e()) {
            c1697a.f6050c.setImageResource(C1692R.drawable.bg_red_sel);
            c1697a.f6051d.setBackgroundResource(C1692R.drawable.btn_red_selector_ret);
            c1697a.f6051d.setTextColor(-1);
        } else {
            c1697a.f6050c.setImageResource(C1692R.drawable.bg_red_no);
            c1697a.f6051d.setBackgroundResource(C1692R.drawable.btn_red_selector);
            c1697a.f6051d.setTextColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        }
        c1697a.f6051d.setOnClickListener(new C16961(this, i));
        return inflate;
    }
}
