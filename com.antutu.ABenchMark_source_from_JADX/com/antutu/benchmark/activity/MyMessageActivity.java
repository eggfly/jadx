package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1539q;
import com.antutu.benchmark.p038b.C1220d;
import com.antutu.benchmark.p038b.C1340e;
import com.antutu.benchmark.p042e.C1482k;
import com.antutu.benchmark.p042e.C1490l;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.SPConstants;
import com.umeng.analytics.MobclickAgent;
import com.viewpagerindicator.TabPageIndicator;
import java.util.ArrayList;
import java.util.List;

public class MyMessageActivity extends C1220d {
    private TabPageIndicator f4346b;
    private ViewPager f4347c;
    private List<C1539q> f4348d;
    private C1340e f4349e;
    private ImageView f4350f;

    /* renamed from: com.antutu.benchmark.activity.MyMessageActivity.1 */
    class C12721 implements OnPageChangeListener {
        final /* synthetic */ MyMessageActivity f4343a;

        C12721(MyMessageActivity myMessageActivity) {
            this.f4343a = myMessageActivity;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (i == 0) {
                MobclickAgent.onEvent(this.f4343a, MobclickAgentConstants.click_my_receive);
            } else if (i == 1) {
                MobclickAgent.onEvent(this.f4343a, MobclickAgentConstants.click_my_send);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MyMessageActivity.2 */
    class C12732 implements OnClickListener {
        int f4344a;
        final /* synthetic */ MyMessageActivity f4345b;

        C12732(MyMessageActivity myMessageActivity) {
            this.f4345b = myMessageActivity;
            this.f4344a = 0;
        }

        public void onClick(View view) {
            if (this.f4344a == 0) {
                this.f4345b.f4350f.setImageResource(C1082R.drawable.help_my_send);
                this.f4344a++;
                return;
            }
            this.f4345b.f4350f.setVisibility(8);
        }
    }

    public MyMessageActivity() {
        this.f4346b = null;
        this.f4348d = new ArrayList();
        this.f4349e = null;
    }

    private void m5198b() {
        if (Methods.getSharedPreferencesBoolean(SPConstants.HELP_MY_MESSAGE, true)) {
            Methods.editSharedPreferences(SPConstants.HELP_MY_MESSAGE, false);
            this.f4350f.setVisibility(0);
            this.f4350f.setOnClickListener(new C12732(this));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_my_message);
        setTheme(C1082R.style.Theme_CustomPageIndicator);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.my_message), false, this.a, null));
        this.f4346b = (TabPageIndicator) findViewById(C1082R.id.indicator);
        this.f4347c = (ViewPager) findViewById(C1082R.id.viewpager);
        this.f4350f = (ImageView) findViewById(C1082R.id.help_layout);
        this.f4348d.add(new C1539q(new C1482k(), new Bundle(), getString(C1082R.string.my_receive)));
        this.f4348d.add(new C1539q(new C1490l(), new Bundle(), getString(C1082R.string.my_send)));
        this.f4349e = new C1340e(getSupportFragmentManager(), this.f4348d);
        this.f4347c.setAdapter(this.f4349e);
        this.f4347c.setOffscreenPageLimit(this.f4348d.size());
        this.f4346b.setViewPager(this.f4347c);
        this.f4346b.setOnPageChangeListener(this.f4349e);
        MobclickAgent.onEvent(this, MobclickAgentConstants.click_my_receive);
        this.f4347c.addOnPageChangeListener(new C12721(this));
        m5198b();
    }

    protected void onResume() {
        super.onResume();
    }
}
