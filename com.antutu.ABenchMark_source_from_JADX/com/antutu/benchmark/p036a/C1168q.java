package com.antutu.benchmark.p036a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.ColorLineActivity;
import com.antutu.benchmark.activity.HuijieActivity;
import com.antutu.benchmark.activity.MultiTouchActivity;
import com.antutu.benchmark.activity.ScreenActivity;
import com.antutu.utils.PointMark;
import com.facebook.ads.C2279R;
import com.gc.materialdesign.C2513R;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.a.q */
public class C1168q extends BaseAdapter {
    private Context f3949a;
    private String[] f3950b;
    private String[] f3951c;
    private int[] f3952d;

    /* renamed from: com.antutu.benchmark.a.q.1 */
    class C11661 implements OnClickListener {
        final /* synthetic */ int f3943a;
        final /* synthetic */ C1168q f3944b;

        C11661(C1168q c1168q, int i) {
            this.f3944b = c1168q;
            this.f3943a = i;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (this.f3943a) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_SCREEN_MONITOR);
                    intent.setClass(this.f3944b.f3949a, ScreenActivity.class);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_SCREEN_HUIJIE);
                    intent.setClass(this.f3944b.f3949a, HuijieActivity.class);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_SCREEN_COLORLINE);
                    intent.setClass(this.f3944b.f3949a, ColorLineActivity.class);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_MULTI);
                    intent.setClass(this.f3944b.f3949a, MultiTouchActivity.class);
                    break;
            }
            this.f3944b.f3949a.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.a.q.a */
    class C1167a {
        Button f3945a;
        TextView f3946b;
        TextView f3947c;
        final /* synthetic */ C1168q f3948d;

        C1167a(C1168q c1168q) {
            this.f3948d = c1168q;
        }
    }

    public C1168q(Context context, String[] strArr, String[] strArr2, int[] iArr) {
        this.f3949a = context;
        this.f3950b = strArr;
        this.f3951c = strArr2;
        this.f3952d = iArr;
    }

    public int getCount() {
        return this.f3950b.length;
    }

    public Object getItem(int i) {
        return this.f3950b[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1167a c1167a;
        LayoutInflater from = LayoutInflater.from(this.f3949a);
        if (view == null) {
            C1167a c1167a2 = new C1167a(this);
            view = from.inflate(C1082R.layout.screen_entry_item, null);
            c1167a2.f3945a = (Button) view.findViewById(C2279R.id.icon);
            c1167a2.f3946b = (TextView) view.findViewById(C2513R.id.title);
            c1167a2.f3947c = (TextView) view.findViewById(C1082R.id.describe);
            view.setTag(c1167a2);
            c1167a = c1167a2;
        } else {
            c1167a = (C1167a) view.getTag();
        }
        c1167a.f3945a.setBackgroundDrawable(this.f3949a.getResources().getDrawable(this.f3952d[i]));
        c1167a.f3946b.setText(this.f3950b[i]);
        c1167a.f3947c.setText(this.f3951c[i]);
        view.setOnClickListener(new C11661(this, i));
        return view;
    }
}
