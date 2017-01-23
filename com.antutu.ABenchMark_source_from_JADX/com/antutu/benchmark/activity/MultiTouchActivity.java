package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.utils.widget.MultiButton;
import com.antutu.utils.widget.SystemBarTintManager;

public class MultiTouchActivity extends C1197a implements OnClickListener {
    public void onClick(View view) {
        if (view.getId() == C1082R.id.menu_back_img) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.touch);
        SystemBarTintManager.setSystemBar(this, C1082R.color.status_bar_color, true);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.multi_touch_page), false, this.j, null));
        ((MultiButton) findViewById(C1082R.id.touch)).init(this);
    }
}
