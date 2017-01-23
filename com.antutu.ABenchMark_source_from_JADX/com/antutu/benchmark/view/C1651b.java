package com.antutu.benchmark.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1521a;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.Utils;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.jni;
import com.antutu.utils.widget.WebBrowserActivity;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminateSingle;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.view.b */
public class C1651b extends RelativeLayout implements OnClickListener {
    private Context f5904a;
    private LinearLayout f5905b;
    private LinearLayout f5906c;
    private LinearLayout f5907d;
    private ImageView f5908e;
    private TextView f5909f;
    private Button f5910g;
    private ProgressBarCircularIndeterminateSingle f5911h;
    private C1518a f5912i;
    private BroadcastReceiver f5913j;

    /* renamed from: com.antutu.benchmark.view.b.1 */
    class C16481 extends BroadcastReceiver {
        final /* synthetic */ C1651b f5901a;

        C16481(C1651b c1651b) {
            this.f5901a = c1651b;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (DownloadsService.ACTION_DOWNLOAD_MESSAGE.equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra(PushConsts.CMD_ACTION);
                    DownloadInfos downloadInfos = (DownloadInfos) intent.getParcelableExtra("info");
                    if (downloadInfos != null && stringExtra != null) {
                        String url = downloadInfos.getUrl();
                        Object obj = -1;
                        switch (stringExtra.hashCode()) {
                            case -1974223744:
                                if (stringExtra.equals(DownloadsService.ACTION_DOWNLOAD_FINISHED)) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case -1232072738:
                                if (stringExtra.equals(DownloadsService.ACTION_DOWNLOAD_INTERRUPTTED)) {
                                    obj = 2;
                                    break;
                                }
                                break;
                            case 1115155188:
                                if (stringExtra.equals(DownloadsService.ACTION_DOWNLOAD_START)) {
                                    obj = null;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                                this.f5901a.m6502a(url, this.f5901a.f5904a.getString(C1082R.string.downloading_status));
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                this.f5901a.m6502a(url, this.f5901a.f5904a.getString(C1082R.string.install_status));
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                this.f5901a.m6502a(url, this.f5901a.f5904a.getString(C1082R.string.continue_status));
                            default:
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.b.2 */
    class C16492 implements DownloadJobListener {
        final /* synthetic */ C1651b f5902a;

        C16492(C1651b c1651b) {
            this.f5902a = c1651b;
        }

        public void downloadEnded(C1519k c1519k) {
            this.f5902a.setLoading(false);
            if (c1519k == null) {
                this.f5902a.m6503b();
                return;
            }
            List list = (List) ((C1521a) c1519k).m6045a().get("10001");
            if (list == null || list.size() <= 0) {
                this.f5902a.m6503b();
                return;
            }
            this.f5902a.f5912i = (C1518a) list.get(0);
            this.f5902a.m6498a();
        }
    }

    /* renamed from: com.antutu.benchmark.view.b.3 */
    class C16503 implements OnClickListener {
        final /* synthetic */ C1651b f5903a;

        C16503(C1651b c1651b) {
            this.f5903a = c1651b;
        }

        public void onClick(View view) {
            if (Methods.hasInstalled(this.f5903a.f5912i.f5205c)) {
                Methods.openApp(this.f5903a.f5904a, this.f5903a.f5912i.f5204b);
            } else if (!this.f5903a.f5904a.getString(C1082R.string.downloading_status).equals(this.f5903a.f5910g.getText().toString())) {
                MobclickAgent.onEvent(this.f5903a.f5904a, MobclickAgentConstants.click_3d_ad_download);
                WebBrowserActivity.openURL(this.f5903a.f5904a, this.f5903a.f5912i.f5209g, BuildConfig.FLAVOR);
            } else if (this.f5903a.f5912i.f5209g.startsWith("http://appdownloadwithtitle2.")) {
                String replace = this.f5903a.f5912i.f5209g.replace("appdownloadwithtitle2.", BuildConfig.FLAVOR);
                int indexOf = replace.indexOf(".");
                if (indexOf > 0) {
                    replace = "http://" + replace.substring(indexOf + 1);
                }
                DownloadsService.stopDownload(this.f5903a.f5904a, replace);
            } else if (this.f5903a.f5912i.f5209g.endsWith(".apk")) {
                DownloadsService.stopDownload(this.f5903a.f5904a, this.f5903a.f5912i.f5209g);
                this.f5903a.f5910g.setText(this.f5903a.f5904a.getString(C1082R.string.continue_status));
            } else {
                MobclickAgent.onEvent(this.f5903a.f5904a, MobclickAgentConstants.click_3d_ad_download);
                WebBrowserActivity.openURL(this.f5903a.f5904a, this.f5903a.f5912i.f5209g, BuildConfig.FLAVOR);
            }
        }
    }

    public C1651b(Context context) {
        super(context);
        this.f5913j = new C16481(this);
        m6499a(context, null, 0);
    }

    private void m6498a() {
        ImageUtil.displayImageNews(this.f5912i.f5206d, this.f5908e);
        this.f5909f.setText(this.f5912i.f5207e);
        this.f5910g.setText(this.f5912i.f5210h);
        this.f5910g.setOnClickListener(new C16503(this));
    }

    private void m6499a(Context context, AttributeSet attributeSet, int i) {
        this.f5904a = context;
        View.inflate(this.f5904a, C1082R.layout.item_home_3d_ad, this);
        this.f5905b = (LinearLayout) findViewById(C1082R.id.ll_loading);
        this.f5906c = (LinearLayout) findViewById(C1082R.id.ll_content);
        this.f5908e = (ImageView) findViewById(C1082R.id.iv_ad_img);
        this.f5909f = (TextView) findViewById(C1082R.id.tv_ad_name);
        this.f5910g = (Button) findViewById(C1082R.id.btn_ad_download);
        this.f5907d = (LinearLayout) findViewById(C1082R.id.ll_no_content);
        this.f5911h = (ProgressBarCircularIndeterminateSingle) findViewById(C1692R.id.progress);
        this.f5911h.setBackgroundColor(this.f5904a.getResources().getColor(C1082R.color.colorPrimary_day));
        setLoading(true);
        if (this.f5912i != null) {
            m6498a();
            return;
        }
        HashMap hashMap = new HashMap();
        String versionCode = Utils.getVersionCode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("oem=").append(String.valueOf(C1503b.m5915c().m5954k())).append("&lan=").append(C1523d.m6061b()).append("&softid=123").append("&adversion=" + Utils.getAdVersion(this.f5904a) + BuildConfig.FLAVOR).append("&aid=10").append("&format=json").append("&softversion=").append(versionCode).append("&imei=").append(C1503b.m5915c().m5925a(this.f5904a, false)).append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&device=").append(Build.DEVICE).append("&str1=").append(C1503b.m5915c().m5961n());
        hashMap.put("gpv", jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR));
        DownloadJob downloadJob = new DownloadJob(this.f5904a, "http://autovote.antutu.net/proMoudule/index.php?action=adinfo&data=1", new C1521a("10001"), hashMap, 20);
        downloadJob.setDownloadJobListener(new C16492(this));
        downloadJob.start();
    }

    private void m6502a(String str, String str2) {
        if (this.f5910g != null && this.f5912i != null) {
            if (this.f5912i.f5209g.contains(new String(str).substring(7))) {
                this.f5910g.setText(str2);
            }
        }
    }

    private void m6503b() {
        this.f5906c.setVisibility(8);
        this.f5905b.setVisibility(8);
        this.f5907d.setVisibility(0);
    }

    private void setLoading(boolean z) {
        if (z) {
            this.f5906c.setVisibility(8);
            this.f5905b.setVisibility(0);
            this.f5907d.setVisibility(8);
            return;
        }
        this.f5906c.setVisibility(0);
        this.f5905b.setVisibility(8);
        this.f5907d.setVisibility(8);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DownloadsService.ACTION_DOWNLOAD_MESSAGE);
            this.f5904a.registerReceiver(this.f5913j, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.f5904a.unregisterReceiver(this.f5913j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
