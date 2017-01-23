package com.antutu.benchmark.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p036a.C1168q;
import com.antutu.benchmark.p038b.C1197a;

public class ScreenEntryActivity extends C1197a {
    private ListView f4434a;
    private C1168q f4435b;
    private int[] f4436c;

    /* renamed from: com.antutu.benchmark.activity.ScreenEntryActivity.1 */
    class C12951 implements OnClickListener {
        final /* synthetic */ ScreenEntryActivity f4433a;

        C12951(ScreenEntryActivity screenEntryActivity) {
            this.f4433a = screenEntryActivity;
        }

        public void onClick(View view) {
            this.f4433a.finish();
        }
    }

    public ScreenEntryActivity() {
        this.f4436c = new int[]{C1082R.drawable.screen_huaidian, C1082R.drawable.screen_huijie, C1082R.drawable.screen_caitiao, C1082R.drawable.screen_duodian};
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.screen_entry);
        ((TextView) findViewById(C1082R.id.title_text)).setText(getString(C1082R.string.screen_entry_title));
        findViewById(C1082R.id.v_top_left).setOnClickListener(new C12951(this));
        this.f4434a = (ListView) findViewById(C1082R.id.list);
        Resources resources = getResources();
        this.f4435b = new C1168q(this, resources.getStringArray(C1082R.array.screen_entry_array), resources.getStringArray(C1082R.array.screen_entry_array_d), this.f4436c);
        this.f4434a.setAdapter(this.f4435b);
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        this.f4434a.setLayoutAnimation(new LayoutAnimationController(animationSet, 0.5f));
    }
}
