package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.utils.Utils;
import com.antutu.utils.update.Update;

public class AboutUsActivity extends C1197a {
    private TextView f4029a;
    private ImageView f4030b;
    private TextView f4031c;

    /* renamed from: com.antutu.benchmark.activity.AboutUsActivity.1 */
    class C11951 implements OnClickListener {
        final /* synthetic */ AboutUsActivity f4027a;

        C11951(AboutUsActivity aboutUsActivity) {
            this.f4027a = aboutUsActivity;
        }

        public void onClick(View view) {
            Update.CheckUpdate(this.f4027a, true);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_aboutus);
        this.f4030b = (ImageView) findViewById(C1082R.id.tag_icon);
        this.f4031c = (TextView) findViewById(C1082R.id.tv_official_website);
        if (!"CN".equals(Utils.getLocalLanguage(this))) {
            this.f4030b.setImageResource(C1082R.drawable.logo_en);
            this.f4031c.setText("http://www.antutu.com/en/index.shtml");
        }
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.about), false, this.j, null));
        ((TextView) findViewById(C1082R.id.tv_termsofservice)).setMovementMethod(LinkMovementMethod.getInstance());
        this.f4029a = (TextView) findViewById(C1082R.id.tv_check_update);
        this.f4029a.setOnClickListener(new C11951(this));
    }
}
