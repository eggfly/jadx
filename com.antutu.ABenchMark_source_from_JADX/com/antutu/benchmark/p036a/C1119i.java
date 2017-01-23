package com.antutu.benchmark.p036a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.ExposureDetailActivity;
import com.antutu.benchmark.modelreflact.ExposureListModel;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.MobclickAgentConstants;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.antutu.benchmark.a.i */
public class C1119i extends BaseAdapter {
    private List<ExposureListModel> f3772a;
    private Activity f3773b;

    /* renamed from: com.antutu.benchmark.a.i.1 */
    class C11171 implements OnClickListener {
        final /* synthetic */ ExposureListModel f3765a;
        final /* synthetic */ C1119i f3766b;

        C11171(C1119i c1119i, ExposureListModel exposureListModel) {
            this.f3766b = c1119i;
            this.f3765a = exposureListModel;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap();
            hashMap.put("\u673a\u578b", this.f3765a.getModel());
            MobclickAgent.onEvent(this.f3766b.f3773b, MobclickAgentConstants.click_exposure_phone_detail, hashMap);
            Intent intent = new Intent(this.f3766b.f3773b, ExposureDetailActivity.class);
            intent.putExtra("ITEM", this.f3765a);
            this.f3766b.f3773b.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.a.i.a */
    static class C1118a {
        ImageView f3767a;
        TextView f3768b;
        TextView f3769c;
        TextView f3770d;
        TextView f3771e;

        C1118a() {
        }
    }

    public C1119i(Activity activity, List<ExposureListModel> list) {
        this.f3773b = activity;
        this.f3772a = list;
    }

    public int getCount() {
        return this.f3772a.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1118a c1118a;
        ExposureListModel exposureListModel = (ExposureListModel) this.f3772a.get(i);
        if (view == null) {
            view = View.inflate(this.f3773b, C1082R.layout.adapter_exposure_item, null);
            C1118a c1118a2 = new C1118a();
            c1118a2.f3767a = (ImageView) view.findViewById(C1082R.id.iv_img);
            c1118a2.f3768b = (TextView) view.findViewById(C1082R.id.tv_title);
            c1118a2.f3769c = (TextView) view.findViewById(C1082R.id.tv_score);
            c1118a2.f3770d = (TextView) view.findViewById(C1082R.id.tv_date);
            c1118a2.f3771e = (TextView) view.findViewById(C1082R.id.tv_hits);
            view.setTag(c1118a2);
            c1118a = c1118a2;
        } else {
            c1118a = (C1118a) view.getTag();
        }
        ImageUtil.displayImageNews(exposureListModel.getModelpic(), c1118a.f3767a);
        c1118a.f3768b.setText(exposureListModel.getModel());
        c1118a.f3769c.setText(exposureListModel.getScore());
        c1118a.f3770d.setText(exposureListModel.getDate());
        c1118a.f3771e.setText(exposureListModel.getClicks());
        view.setOnClickListener(new C11171(this, exposureListModel));
        return view;
    }
}
