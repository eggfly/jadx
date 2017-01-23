package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.CustomerLogo;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import com.mob.tools.gui.MobViewPager;
import com.mob.tools.gui.ViewPagerAdapter;
import com.mob.tools.utils.C4021R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public abstract class PlatformPage extends OnekeySharePage {
    private Animation animHide;
    private Animation animShow;
    private Runnable beforeFinish;
    private boolean finished;
    private ClassicTheme impl;
    private LinearLayout llPanel;

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.1 */
    class C09891 implements OnClickListener {
        C09891() {
        }

        public void onClick(View view) {
            PlatformPage.this.finish();
        }
    }

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.2 */
    class C09902 implements Runnable {
        final /* synthetic */ Platform val$platform;

        C09902(Platform platform) {
            this.val$platform = platform;
        }

        public void run() {
            boolean access$000 = PlatformPage.this.isSilent();
            boolean z = this.val$platform instanceof CustomPlatform;
            boolean access$100 = PlatformPage.this.isUseClientToShare(this.val$platform);
            if (access$000 || z || access$100) {
                PlatformPage.this.shareSilently(this.val$platform);
                return;
            }
            ShareParams access$300 = PlatformPage.this.formateShareData(this.val$platform);
            if (access$300 != null) {
                ShareSDK.logDemoEvent(3, null);
                if (PlatformPage.this.getCustomizeCallback() != null) {
                    PlatformPage.this.getCustomizeCallback().onShare(this.val$platform, access$300);
                }
                PlatformPage.this.impl.showEditPage(PlatformPage.this.activity, this.val$platform, access$300);
            }
        }
    }

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.3 */
    class C09913 implements Runnable {
        final /* synthetic */ CustomerLogo val$logo;
        final /* synthetic */ View val$v;

        C09913(CustomerLogo customerLogo, View view) {
            this.val$logo = customerLogo;
            this.val$v = view;
        }

        public void run() {
            this.val$logo.listener.onClick(this.val$v);
        }
    }

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.4 */
    class C09924 implements AnimationListener {
        C09924() {
        }

        public void onAnimationEnd(Animation animation) {
            if (PlatformPage.this.beforeFinish == null) {
                ShareSDK.logDemoEvent(2, null);
            } else {
                PlatformPage.this.beforeFinish.run();
                PlatformPage.this.beforeFinish = null;
            }
            PlatformPage.this.finished = true;
            PlatformPage.this.finish();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public PlatformPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.impl = (ClassicTheme) C4021R.forceCast(onekeyShareThemeImpl);
    }

    private void initAnims() {
        this.animShow = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.animShow.setDuration(300);
        this.animHide = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.animHide.setDuration(300);
    }

    protected ArrayList<Object> collectCells() {
        int i = 0;
        ArrayList<Object> arrayList = new ArrayList();
        Platform[] platformList = ShareSDK.getPlatformList();
        if (platformList == null) {
            platformList = new Platform[0];
        }
        HashMap hiddenPlatforms = getHiddenPlatforms();
        if (hiddenPlatforms == null) {
            hiddenPlatforms = new HashMap();
        }
        int length = platformList.length;
        while (i < length) {
            Platform platform = platformList[i];
            if (!hiddenPlatforms.containsKey(platform.getName())) {
                arrayList.add(platform);
            }
            i++;
        }
        Collection customerLogos = getCustomerLogos();
        if (customerLogos != null && customerLogos.size() > 0) {
            arrayList.addAll(customerLogos);
        }
        return arrayList;
    }

    protected abstract PlatformPageAdapter newAdapter(ArrayList<Object> arrayList);

    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(1275068416));
        initAnims();
        View linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        this.activity.setContentView(linearLayout);
        View textView = new TextView(this.activity);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        textView.setOnClickListener(new C09891());
        linearLayout.addView(textView, layoutParams);
        this.llPanel = new LinearLayout(this.activity);
        this.llPanel.setOrientation(1);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.llPanel.setAnimation(this.animShow);
        linearLayout.addView(this.llPanel, layoutParams2);
        linearLayout = new MobViewPager(this.activity);
        ViewPagerAdapter newAdapter = newAdapter(collectCells());
        this.llPanel.addView(linearLayout, new LinearLayout.LayoutParams(-1, newAdapter.getPanelHeight()));
        View indicatorView = new IndicatorView(this.activity);
        this.llPanel.addView(indicatorView, new LinearLayout.LayoutParams(-1, newAdapter.getBottomHeight()));
        indicatorView.setScreenCount(newAdapter.getCount());
        indicatorView.onScreenChange(0, 0);
        newAdapter.setIndicator(indicatorView);
        linearLayout.setAdapter(newAdapter);
    }

    public boolean onFinish() {
        if (this.finished) {
            this.finished = false;
            return false;
        }
        this.animHide.setAnimationListener(new C09924());
        this.llPanel.clearAnimation();
        this.llPanel.setAnimation(this.animHide);
        this.llPanel.setVisibility(8);
        return true;
    }

    public final void performCustomLogoClick(View view, CustomerLogo customerLogo) {
        this.beforeFinish = new C09913(customerLogo, view);
        finish();
    }

    public final void showEditPage(Platform platform) {
        this.beforeFinish = new C09902(platform);
        finish();
    }
}
