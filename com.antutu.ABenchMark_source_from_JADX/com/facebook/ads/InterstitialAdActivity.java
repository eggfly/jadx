package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.antutu.utils.widget.SystemBarTintManager;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.internal.C2471g;
import com.facebook.ads.internal.p121f.C2455i;
import com.facebook.ads.internal.p121f.C2455i.C2257a;
import com.facebook.ads.internal.p121f.C2456g;
import com.facebook.ads.internal.p121f.C2468o;
import org.android.spdy.SpdyProtocol;

public class InterstitialAdActivity extends Activity {
    public static final String AUTOPLAY = "autoplay";
    public static final String PREDEFINED_ORIENTATION_KEY = "predefinedOrientationKey";
    public static final String VIDEO_PLAY_REPORT_MS = "videoPlayReportMS";
    public static final String VIDEO_PLAY_REPORT_URL = "videoPlayReportURL";
    public static final String VIDEO_TIME_REPORT_URL = "videoTimeReportURL";
    public static final String VIDEO_URL = "videoURL";
    public static final String VIEW_TYPE = "viewType";
    private RelativeLayout f7791a;
    private C2471g f7792b;
    private int f7793c;
    private String f7794d;
    private C2455i f7795e;

    /* renamed from: com.facebook.ads.InterstitialAdActivity.1 */
    class C22561 implements OnClickListener {
        final /* synthetic */ InterstitialAdActivity f7786a;

        C22561(InterstitialAdActivity interstitialAdActivity) {
            this.f7786a = interstitialAdActivity;
        }

        public void onClick(View view) {
            this.f7786a.finish();
        }
    }

    /* renamed from: com.facebook.ads.InterstitialAdActivity.2 */
    class C22582 implements C2257a {
        final /* synthetic */ InterstitialAdActivity f7787a;

        C22582(InterstitialAdActivity interstitialAdActivity) {
            this.f7787a = interstitialAdActivity;
        }

        public void m8552a(View view) {
            this.f7787a.f7791a.addView(view);
            if (this.f7787a.f7792b != null) {
                this.f7787a.f7791a.addView(this.f7787a.f7792b);
            }
        }

        public void m8553a(String str) {
            this.f7787a.m8559a(str);
        }
    }

    /* renamed from: com.facebook.ads.InterstitialAdActivity.3 */
    class C22593 implements C2257a {
        final /* synthetic */ InterstitialAdActivity f7788a;

        C22593(InterstitialAdActivity interstitialAdActivity) {
            this.f7788a = interstitialAdActivity;
        }

        public void m8554a(View view) {
            this.f7788a.f7791a.addView(view);
            if (this.f7788a.f7792b != null) {
                this.f7788a.f7791a.addView(this.f7788a.f7792b);
            }
        }

        public void m8555a(String str) {
            this.f7788a.m8559a(str);
        }
    }

    /* renamed from: com.facebook.ads.InterstitialAdActivity.4 */
    static /* synthetic */ class C22604 {
        static final /* synthetic */ int[] f7789a;

        static {
            f7789a = new int[Type.values().length];
            try {
                f7789a[Type.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7789a[Type.DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum Type {
        DISPLAY,
        VIDEO
    }

    public InterstitialAdActivity() {
        this.f7793c = -1;
    }

    private void m8557a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f7793c = bundle.getInt(PREDEFINED_ORIENTATION_KEY, -1);
            this.f7794d = bundle.getString("adInterstitialUniqueId");
            this.f7795e.m9355a(intent, bundle);
            return;
        }
        this.f7793c = intent.getIntExtra(PREDEFINED_ORIENTATION_KEY, -1);
        this.f7794d = intent.getStringExtra("adInterstitialUniqueId");
        this.f7795e.m9355a(intent, bundle);
    }

    private void m8559a(String str) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(str + ":" + this.f7794d));
    }

    public void finish() {
        this.f7791a.removeAllViews();
        this.f7795e.m9358c();
        m8559a("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        this.f7791a = new RelativeLayout(this);
        this.f7791a.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        setContentView(this.f7791a, new LayoutParams(-1, -1));
        Intent intent = getIntent();
        if (intent.getBooleanExtra("useNativeCloseButton", false)) {
            this.f7792b = new C2471g(this);
            this.f7792b.setId(100002);
            this.f7792b.setOnClickListener(new C22561(this));
        }
        switch (C22604.f7789a[((Type) intent.getSerializableExtra(VIEW_TYPE)).ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f7795e = new C2468o(this, new C22582(this));
                break;
            default:
                this.f7795e = new C2456g(this, new C22593(this));
                break;
        }
        m8557a(intent, bundle);
        m8559a("com.facebook.ads.interstitial.displayed");
    }

    public void onPause() {
        super.onPause();
        this.f7795e.m9354a();
    }

    public void onRestart() {
        super.onRestart();
    }

    public void onResume() {
        super.onResume();
        this.f7795e.m9357b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f7795e.m9356a(bundle);
        bundle.putInt(PREDEFINED_ORIENTATION_KEY, this.f7793c);
        bundle.putString("adInterstitialUniqueId", this.f7794d);
    }

    public void onStart() {
        super.onStart();
        if (this.f7793c != -1) {
            setRequestedOrientation(this.f7793c);
        }
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
    }
}
