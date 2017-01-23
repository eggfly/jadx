package com.antutu.benchmark.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.ExposureActivity;
import com.antutu.benchmark.modelreflact.ExposureItemModel;
import com.antutu.benchmark.modelreflact.ExposureResponseModel.DataEntity;
import com.antutu.benchmark.p036a.C1122k;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminateSingle;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.umeng.analytics.MobclickAgent;
import org.android.agoo.message.MessageService;

/* renamed from: com.antutu.benchmark.view.e */
public class C1662e extends RelativeLayout {
    private C1371d f5940a;
    private Context f5941b;
    private TextView f5942c;
    private TextView f5943d;
    private ImageView f5944e;
    private TextView f5945f;
    private LinearLayout f5946g;
    private ImageView f5947h;
    private long f5948i;
    private ProgressBarCircularIndeterminateSingle f5949j;
    private LinearLayout f5950k;
    private DataEntity f5951l;
    private C1122k f5952m;

    /* renamed from: com.antutu.benchmark.view.e.1 */
    class C16601 implements C1095a<DataEntity> {
        final /* synthetic */ C1662e f5938a;

        /* renamed from: com.antutu.benchmark.view.e.1.1 */
        class C16591 implements ImageLoadingListener {
            final /* synthetic */ C16601 f5937a;

            C16591(C16601 c16601) {
                this.f5937a = c16601;
            }

            public void onLoadingCancelled(String str, View view) {
            }

            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                this.f5937a.f5938a.f5944e.setImageBitmap(bitmap);
            }

            public void onLoadingFailed(String str, View view, FailReason failReason) {
                this.f5937a.f5938a.f5944e.setImageResource(C1082R.drawable.exposure_bg);
            }

            public void onLoadingStarted(String str, View view) {
            }
        }

        C16601(C1662e c1662e) {
            this.f5938a = c1662e;
        }

        public void m6526a(DataEntity dataEntity) {
            this.f5938a.setLoading(false);
            long sharedPreferencesLong = Methods.getSharedPreferencesLong("exposure_list_size", 0);
            if (dataEntity.getModelist() == null) {
                this.f5938a.f5948i = 0;
                Methods.editSharedPreferences("exposure_list_size", MessageService.MSG_DB_READY_REPORT);
            } else {
                this.f5938a.f5948i = (long) dataEntity.getModelist().size();
            }
            if (this.f5938a.f5948i == sharedPreferencesLong) {
                this.f5938a.f5947h.setVisibility(8);
            } else {
                this.f5938a.f5947h.setVisibility(0);
            }
            ExposureItemModel index = dataEntity.getIndex();
            this.f5938a.f5942c.setText(index.getTitle());
            this.f5938a.f5943d.setText(index.getSubtitle());
            ImageLoader.getInstance().loadImage(index.getBanner(), new C16591(this));
            this.f5938a.f5951l = dataEntity;
        }

        public void m6528a(String str) {
            this.f5938a.m6532a();
        }
    }

    /* renamed from: com.antutu.benchmark.view.e.2 */
    class C16612 implements OnClickListener {
        final /* synthetic */ C1662e f5939a;

        C16612(C1662e c1662e) {
            this.f5939a = c1662e;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f5939a.f5941b, MobclickAgentConstants.click_exposure_phone);
            this.f5939a.f5947h.setVisibility(8);
            Methods.editSharedPreferences("exposure_list_size", this.f5939a.f5948i);
            Intent intent = new Intent(this.f5939a.f5941b, ExposureActivity.class);
            intent.putExtra("ExposureResponseModel", this.f5939a.f5951l);
            this.f5939a.f5941b.startActivity(intent);
        }
    }

    public C1662e(Context context) {
        super(context);
        this.f5948i = 0;
        m6533a(context, null, 0);
    }

    private void m6532a() {
        this.f5945f.setVisibility(0);
        this.f5950k.setVisibility(8);
        this.f5946g.setVisibility(8);
    }

    private void m6533a(Context context, AttributeSet attributeSet, int i) {
        this.f5941b = context;
        this.f5940a = new C1371d(this.f5941b);
        View.inflate(this.f5941b, C1082R.layout.item_home_exposure, this);
        m6536b();
        setLoading(true);
        this.f5940a.m5433c(new C16601(this));
        this.f5950k.setOnClickListener(new C16612(this));
    }

    private void m6536b() {
        this.f5942c = (TextView) findViewById(C1082R.id.tv_title);
        this.f5943d = (TextView) findViewById(C1082R.id.tv_subtitle);
        this.f5944e = (ImageView) findViewById(C1082R.id.iv_img);
        this.f5946g = (LinearLayout) findViewById(C1082R.id.ll_loading);
        this.f5949j = (ProgressBarCircularIndeterminateSingle) findViewById(C1082R.id.loading);
        this.f5949j.setBackgroundColor(this.f5941b.getResources().getColor(C1082R.color.colorPrimary_day));
        this.f5945f = (TextView) findViewById(C1082R.id.no_content);
        this.f5950k = (LinearLayout) findViewById(C1082R.id.ll_bg);
        this.f5947h = (ImageView) findViewById(C1082R.id.iv_red_point);
    }

    private void setLoading(boolean z) {
        if (z) {
            this.f5950k.setVisibility(8);
            this.f5946g.setVisibility(0);
            this.f5945f.setVisibility(8);
            return;
        }
        this.f5950k.setVisibility(0);
        this.f5946g.setVisibility(8);
        this.f5945f.setVisibility(8);
    }

    public void setParentAdapter(C1122k c1122k) {
        this.f5952m = c1122k;
    }
}
