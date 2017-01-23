package com.antutu.benchmark.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.utils.SmartBarUtils;
import com.facebook.ads.C2279R;
import java.util.ArrayList;

public class WizardActivity extends C1197a {
    private final int f4508a;
    private int f4509b;
    private ArrayList<View> f4510c;
    private LayoutInflater f4511d;
    private LinearLayout f4512e;
    private Button f4513f;
    private C1320a f4514g;

    /* renamed from: com.antutu.benchmark.activity.WizardActivity.1 */
    class C13181 implements OnClickListener {
        final /* synthetic */ WizardActivity f4505a;

        C13181(WizardActivity wizardActivity) {
            this.f4505a = wizardActivity;
        }

        public void onClick(View view) {
            this.f4505a.finish();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.WizardActivity.2 */
    class C13192 implements OnPageChangeListener {
        final /* synthetic */ WizardActivity f4506a;

        C13192(WizardActivity wizardActivity) {
            this.f4506a = wizardActivity;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (this.f4506a.f4513f != null) {
                this.f4506a.f4513f.setBackgroundResource(C1082R.drawable.wizard_dot_normal);
            }
            Button button = (Button) this.f4506a.f4512e.getChildAt(i);
            button.setBackgroundResource(C1082R.drawable.wizard_dot_selected);
            this.f4506a.f4513f = button;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.WizardActivity.a */
    class C1320a extends PagerAdapter {
        final /* synthetic */ WizardActivity f4507a;

        C1320a(WizardActivity wizardActivity) {
            this.f4507a = wizardActivity;
        }

        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) this.f4507a.f4510c.get(i));
        }

        public int getCount() {
            return this.f4507a.f4510c.size();
        }

        public Object instantiateItem(View view, int i) {
            ((ViewPager) view).addView((View) this.f4507a.f4510c.get(i), 0);
            return this.f4507a.f4510c.get(i);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public WizardActivity() {
        this.f4508a = 10;
        this.f4509b = 0;
        this.f4510c = new ArrayList();
        this.f4511d = null;
        this.f4512e = null;
        this.f4513f = null;
        this.f4514g = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.wizard);
        try {
            int i;
            this.f4511d = getLayoutInflater();
            for (i = 0; i < 10; i++) {
                int identifier = getResources().getIdentifier("wizard_img" + i, "drawable", getPackageName());
                if (identifier <= 0) {
                    break;
                }
                View inflate = this.f4511d.inflate(C1082R.layout.wizard_page, null);
                try {
                    ((ImageView) inflate.findViewById(C2279R.id.image)).setBackgroundResource(identifier);
                    this.f4510c.add(inflate);
                    this.f4509b++;
                } catch (Exception e) {
                }
            }
            if (this.f4509b < 1) {
                finish();
                return;
            }
            View findViewById = ((View) this.f4510c.get(this.f4509b - 1)).findViewById(C1082R.id.btn_try);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new C13181(this));
            ViewPager viewPager = (ViewPager) findViewById(C1082R.id.pager);
            this.f4514g = new C1320a(this);
            viewPager.setAdapter(this.f4514g);
            if (this.f4509b > 1) {
                this.f4512e = (LinearLayout) findViewById(C1082R.id.l_pager_num);
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C1082R.drawable.wizard_dot_normal);
                for (i = 0; i < this.f4509b; i++) {
                    View button = new Button(this);
                    button.setLayoutParams(new LayoutParams(decodeResource.getWidth(), decodeResource.getHeight()));
                    button.setBackgroundResource(C1082R.drawable.wizard_dot_normal);
                    this.f4512e.addView(button);
                }
                Button button2 = (Button) this.f4512e.getChildAt(0);
                button2.setBackgroundResource(C1082R.drawable.wizard_dot_selected);
                this.f4513f = button2;
                viewPager.setOnPageChangeListener(new C13192(this));
            }
            try {
                if (VERSION.SDK_INT > 10) {
                    SmartBarUtils.InitActionBar(this, C1082R.drawable.main_title_icon_back);
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            finish();
        }
    }
}
