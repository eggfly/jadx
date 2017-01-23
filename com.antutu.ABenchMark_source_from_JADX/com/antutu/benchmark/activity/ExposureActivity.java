package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.widget.ListView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.ExposureListModel;
import com.antutu.benchmark.modelreflact.ExposureResponseModel.DataEntity;
import com.antutu.benchmark.p036a.C1119i;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import java.util.ArrayList;
import java.util.List;

public class ExposureActivity extends C1197a {
    private ListView f4191a;
    private List<ExposureListModel> f4192b;
    private C1371d f4193c;
    private C1119i f4194d;

    /* renamed from: com.antutu.benchmark.activity.ExposureActivity.1 */
    class C12351 implements C1095a<DataEntity> {
        final /* synthetic */ ExposureActivity f4190a;

        C12351(ExposureActivity exposureActivity) {
            this.f4190a = exposureActivity;
        }

        public void m5063a(DataEntity dataEntity) {
            this.f4190a.f4192b.clear();
            this.f4190a.f4192b.addAll(dataEntity.getModelist());
            this.f4190a.f4194d.notifyDataSetChanged();
        }

        public void m5065a(String str) {
        }
    }

    public ExposureActivity() {
        this.f4192b = new ArrayList();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_exposure);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.new_phone_exposure), false, this.j, null));
        this.f4193c = new C1371d(this);
        this.f4191a = (ListView) findViewById(C1082R.id.lv_exposurelist);
        this.f4194d = new C1119i(this, this.f4192b);
        this.f4191a.setAdapter(this.f4194d);
        DataEntity dataEntity = (DataEntity) getIntent().getSerializableExtra("ExposureResponseModel");
        if (dataEntity != null) {
            this.f4192b.clear();
            this.f4192b.addAll(dataEntity.getModelist());
            this.f4194d.notifyDataSetChanged();
            return;
        }
        this.f4193c.m5433c(new C12351(this));
    }
}
