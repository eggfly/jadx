package com.antutu.benchmark.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1521a;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.p036a.C1133m;
import com.antutu.benchmark.p036a.C1133m.C1131a;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.MLog;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreTestAdActivity extends C1197a {
    private List<C1131a> f4340a;
    private GridView f4341b;
    private C1133m f4342c;

    /* renamed from: com.antutu.benchmark.activity.MoreTestAdActivity.1 */
    class C12701 implements OnClickListener {
        final /* synthetic */ MoreTestAdActivity f4338a;

        C12701(MoreTestAdActivity moreTestAdActivity) {
            this.f4338a = moreTestAdActivity;
        }

        public void onClick(View view) {
            this.f4338a.m4960a(new Intent(this.f4338a, ScreenEntryActivity.class));
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MoreTestAdActivity.2 */
    class C12712 implements DownloadJobListener {
        final /* synthetic */ MoreTestAdActivity f4339a;

        C12712(MoreTestAdActivity moreTestAdActivity) {
            this.f4339a = moreTestAdActivity;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                try {
                    Map a = ((C1521a) c1519k).m6045a();
                    if (a.size() != 0) {
                        List list = (List) a.get("11001");
                        if (list != null && list.size() > 0) {
                            this.f4339a.m5195a(list);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public MoreTestAdActivity() {
        this.f4340a = new ArrayList();
    }

    private void m5192a() {
        this.f4340a.add(new C1131a(C1082R.drawable.more_test_screen, C1082R.string.screen_test, new C12701(this)));
    }

    private void m5195a(List<C1518a> list) {
        if (list != null) {
            this.f4340a.clear();
            m5192a();
            for (int i = 0; i < list.size(); i++) {
                this.f4340a.add(new C1131a((C1518a) list.get(i)));
            }
            this.f4342c.notifyDataSetChanged();
        }
    }

    private void m5196b() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("oem=").append(C1503b.m5915c().m5954k()).append("&lan=").append(C1523d.m6061b()).append("&softid=123").append("&adversion=" + Utils.getAdVersion(this) + BuildConfig.FLAVOR).append("&aid=11").append("&format=json").append("&imei=").append(C1503b.m5915c().m5925a((Context) this, false)).append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&device=").append(Build.DEVICE).append("&str1=").append(C1503b.m5915c().m5961n()).append("&softversion=").append(C1503b.m5915c().m5958m());
            MLog.m6864d("hzd, loadAds, parms: " + stringBuilder.toString());
            String dataSafe = jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR);
            HashMap hashMap = new HashMap();
            hashMap.put("gpv", dataSafe);
            DownloadJob downloadJob = new DownloadJob(this, "http://autovote.antutu.net/proMoudule/index.php?action=adinfo&data=1", new C1521a("11001"), hashMap);
            downloadJob.setDownloadJobListener(new C12712(this));
            downloadJob.start(false);
        } catch (Exception e) {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_more_test_ad);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.more), false, this.j, null));
        m5192a();
        this.f4341b = (GridView) findViewById(C1082R.id.list);
        this.f4342c = new C1133m(this, this.f4340a);
        this.f4341b.setAdapter(this.f4342c);
        m5196b();
    }
}
