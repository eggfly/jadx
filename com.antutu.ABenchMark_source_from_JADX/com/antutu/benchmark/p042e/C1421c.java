package com.antutu.benchmark.p042e;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.activity.ScoreBenchActivity;
import com.antutu.benchmark.e.c.AnonymousClass13;
import com.antutu.benchmark.e.c.AnonymousClass14;
import com.antutu.benchmark.e.c.AnonymousClass15;
import com.antutu.benchmark.e.c.AnonymousClass16;
import com.antutu.benchmark.modelreflact.HomeFlagModel;
import com.antutu.benchmark.modelreflact.HomeFlagResponseModel;
import com.antutu.benchmark.p036a.C1122k;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.benchmark.p042e.C1421c;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.benchmark.view.PromptView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1745b;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.NetUtils;
import com.antutu.utils.Utils;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.downloader.Stop3DPluginActivity;
import com.facebook.ads.C2279R;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.e.c */
public class C1421c extends C1338c implements OnRefreshListener, OnClickListener {
    private boolean f4902b;
    private View f4903c;
    private ListView f4904d;
    private C1122k f4905e;
    private RelativeLayout f4906f;
    private TextView f4907g;
    private TextView f4908h;
    private DownloadInfos f4909i;
    private PromptView f4910j;
    private C1371d f4911k;
    private C1420a f4912l;
    private BroadcastReceiver f4913m;
    private BroadcastReceiver f4914n;

    /* renamed from: com.antutu.benchmark.e.c.13 */
    static class AnonymousClass13 implements DialogInterface.OnClickListener {
        final /* synthetic */ Context f4875a;

        AnonymousClass13(Context context) {
            this.f4875a = context;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
            intent.setFlags(270532608);
            this.f4875a.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.14 */
    static class AnonymousClass14 implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity f4876a;
        final /* synthetic */ String[] f4877b;

        AnonymousClass14(Activity activity, String[] strArr) {
            this.f4876a = activity;
            this.f4877b = strArr;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Utils.getPermissions(this.f4876a, this.f4877b);
            String[] strArr = this.f4877b;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this.f4876a, strArr[i2])) {
                    i2++;
                } else {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + this.f4876a.getPackageName()));
                    this.f4876a.startActivity(intent);
                    if (VERSION.SDK_INT >= 19) {
                        C1421c.m5597d(this.f4876a);
                        return;
                    } else {
                        C1421c.m5601e(this.f4876a);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.15 */
    static class AnonymousClass15 implements OnClickListener {
        final /* synthetic */ Activity f4878a;
        final /* synthetic */ View f4879b;

        AnonymousClass15(Activity activity, View view) {
            this.f4878a = activity;
            this.f4879b = view;
        }

        public void onClick(View view) {
            C1421c.m5593b(this.f4878a, this.f4879b);
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.16 */
    static class AnonymousClass16 implements OnTouchListener {
        final /* synthetic */ LayoutParams f4880a;
        final /* synthetic */ View f4881b;
        final /* synthetic */ WindowManager f4882c;

        AnonymousClass16(LayoutParams layoutParams, View view, WindowManager windowManager) {
            this.f4880a = layoutParams;
            this.f4881b = view;
            this.f4882c = windowManager;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4880a.y = (((int) motionEvent.getRawY()) - (this.f4881b.getMeasuredHeight() / 2)) - 40;
            this.f4882c.updateViewLayout(this.f4881b, this.f4880a);
            return false;
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.1 */
    class C14111 extends BroadcastReceiver {
        final /* synthetic */ C1421c f4884a;

        C14111(C1421c c1421c) {
            this.f4884a = c1421c;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (DownloadsService.ACTION_DOWNLOAD_MESSAGE.equals(action)) {
                    String stringExtra = intent.getStringExtra(PushConsts.CMD_ACTION);
                    this.f4884a.f4909i = (DownloadInfos) intent.getParcelableExtra("info");
                    if (C1516b.f5191a.equals(this.f4884a.f4909i.getUrl())) {
                        Object obj = -1;
                        switch (stringExtra.hashCode()) {
                            case -1974223744:
                                if (stringExtra.equals(DownloadsService.ACTION_DOWNLOAD_FINISHED)) {
                                    int i = 1;
                                    break;
                                }
                                break;
                            case -1232072738:
                                if (stringExtra.equals(DownloadsService.ACTION_DOWNLOAD_INTERRUPTTED)) {
                                    obj = 2;
                                    break;
                                }
                                break;
                            case -277581230:
                                if (stringExtra.equals(DownloadsService.ACTION_DOWNLOAD_DOWNLOADING_PERCENT)) {
                                    obj = 3;
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
                                this.f4884a.f4902b = true;
                                this.f4884a.f4910j.setText((int) C1082R.string.downloading_3d_plugin_tips);
                                this.f4884a.f4910j.m6469a();
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                this.f4884a.f4902b = false;
                                C1503b.m5915c().m5929a(this.f4884a.f4909i.getDownloadFilepath());
                                this.f4884a.m5612k();
                                this.f4884a.f4910j.m6469a();
                                this.f4884a.m5614l();
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                this.f4884a.f4902b = false;
                                this.f4884a.f4910j.m6470b();
                                this.f4884a.m5614l();
                                this.f4884a.m5619d();
                                Methods.showToast(this.f4884a.a, (int) C1082R.string.canceled_download, 0);
                            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                                MLog.m6865d("Martin", "download persent " + this.f4884a.f4909i.lastPercent);
                                this.f4884a.f4907g.setText(this.f4884a.getString(C1082R.string.downloading, Integer.valueOf(this.f4884a.f4909i.lastPercent)));
                                if (!this.f4884a.f4910j.m6471c()) {
                                    this.f4884a.f4910j.setText((int) C1082R.string.downloading_3d_plugin_tips);
                                    this.f4884a.f4910j.m6469a();
                                }
                            default:
                        }
                    }
                } else if (action.equals("com.antutu.benchmark.update.DEVICE_INFO")) {
                    this.f4884a.m5615m();
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.2 */
    class C14122 implements OnClickListener {
        final /* synthetic */ C1421c f4885a;

        C14122(C1421c c1421c) {
            this.f4885a = c1421c;
        }

        public void onClick(View view) {
            try {
                Methods.editSharedPreferences("clickMarketDownload", true);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.antutu.benchmark.full"));
                if (Utils.hasMarket(ABenchmarkApplication.getContext(), intent)) {
                    Methods.showToast(ABenchmarkApplication.getContext(), (int) C1082R.string.not_have_market, 0);
                    return;
                }
                intent.addFlags(268435456);
                ABenchmarkApplication.getContext().startActivity(intent);
                if (this.f4885a.f4910j != null) {
                    this.f4885a.f4910j.setText((int) C1082R.string.download_and_install_to_test);
                    this.f4885a.f4910j.m6469a();
                }
            } catch (Exception e) {
                MLog.m6865d("hch", e.getMessage());
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.3 */
    class C14133 implements OnClickListener {
        final /* synthetic */ Dialog f4886a;
        final /* synthetic */ C1421c f4887b;

        C14133(C1421c c1421c, Dialog dialog) {
            this.f4887b = c1421c;
            this.f4886a = dialog;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(view.getContext(), 1);
            if (Utils.isNetworkConnected(this.f4887b.a)) {
                C1516b.m6009a(this.f4887b.getContext());
                Methods.showToast(ABenchmarkApplication.getContext(), (int) C1082R.string.now_downloading, 0);
                this.f4886a.dismiss();
                return;
            }
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.antutu_download_3dplugin);
            Methods.showToast(ABenchmarkApplication.getContext(), (int) C1692R.string.network_error, 1);
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.4 */
    class C14144 implements OnClickListener {
        final /* synthetic */ OnClickListener f4888a;
        final /* synthetic */ Dialog f4889b;
        final /* synthetic */ C1421c f4890c;

        C14144(C1421c c1421c, OnClickListener onClickListener, Dialog dialog) {
            this.f4890c = c1421c;
            this.f4888a = onClickListener;
            this.f4889b = dialog;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(view.getContext(), 1);
            Map hashMap = new HashMap();
            hashMap.put(this.f4890c.getString(C1082R.string.network_env), "WIFI");
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.market_download_3dplugin, hashMap);
            this.f4888a.onClick(view);
            this.f4889b.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.5 */
    class C14155 implements OnClickListener {
        final /* synthetic */ Dialog f4891a;
        final /* synthetic */ C1421c f4892b;

        C14155(C1421c c1421c, Dialog dialog) {
            this.f4892b = c1421c;
            this.f4891a = dialog;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(view.getContext(), 2);
            this.f4891a.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.6 */
    class C14166 implements OnClickListener {
        final /* synthetic */ OnClickListener f4893a;
        final /* synthetic */ Dialog f4894b;
        final /* synthetic */ C1421c f4895c;

        C14166(C1421c c1421c, OnClickListener onClickListener, Dialog dialog) {
            this.f4895c = c1421c;
            this.f4893a = onClickListener;
            this.f4894b = dialog;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(view.getContext(), 1);
            Map hashMap = new HashMap();
            hashMap.put(this.f4895c.getString(C1082R.string.network_env), "WIFI");
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.market_download_3dplugin, hashMap);
            this.f4893a.onClick(view);
            this.f4894b.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.7 */
    class C14177 implements OnClickListener {
        final /* synthetic */ OnClickListener f4896a;
        final /* synthetic */ Dialog f4897b;
        final /* synthetic */ C1421c f4898c;

        C14177(C1421c c1421c, OnClickListener onClickListener, Dialog dialog) {
            this.f4898c = c1421c;
            this.f4896a = onClickListener;
            this.f4897b = dialog;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(view.getContext(), 1);
            Map hashMap = new HashMap();
            hashMap.put(this.f4898c.getString(C1082R.string.network_env), "NOT WIFI");
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.market_download_3dplugin, hashMap);
            this.f4896a.onClick(view);
            this.f4897b.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.8 */
    class C14188 implements OnClickListener {
        final /* synthetic */ C1421c f4899a;

        C14188(C1421c c1421c) {
            this.f4899a = c1421c;
        }

        public void onClick(View view) {
            String a = C1503b.m5915c().m5923a();
            if (a != null) {
                Intent flags = new Intent("android.intent.action.VIEW").setFlags(268435456);
                flags.setDataAndType(Uri.fromFile(new File(a)), "application/vnd.android.package-archive");
                this.f4899a.startActivity(flags);
            }
            view.setVisibility(8);
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.9 */
    class C14199 implements C1095a<HomeFlagResponseModel> {
        final /* synthetic */ C1421c f4900a;

        C14199(C1421c c1421c) {
            this.f4900a = c1421c;
        }

        public void m5577a(HomeFlagResponseModel homeFlagResponseModel) {
            List data = homeFlagResponseModel.getData();
            HomeFlagModel homeFlagModel = null;
            if (this.f4900a.f4905e.getCount() > 1 && this.f4900a.f4905e.m4878a(1) != null && HomeFlagModel.IS_SHOW_JIASU.equals(this.f4900a.f4905e.m4878a(1).getLabel())) {
                homeFlagModel = this.f4900a.f4905e.m4878a(1);
            }
            this.f4900a.f4905e.m4882a(data);
            if (homeFlagModel != null) {
                this.f4900a.f4905e.m4881a(homeFlagModel, 1);
            }
            this.f4900a.f4905e.notifyDataSetChanged();
        }

        public void m5579a(String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.e.c.a */
    private class C1420a extends BroadcastReceiver {
        final /* synthetic */ C1421c f4901a;

        private C1420a(C1421c c1421c) {
            this.f4901a = c1421c;
        }

        public IntentFilter m5580a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            return intentFilter;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                this.f4901a.m5583a(C1745b.m6737a(context).m6741a(intent.getIntExtra("temperature", -1)));
            }
        }
    }

    public C1421c() {
        this.f4902b = false;
        this.f4912l = new C1420a();
        this.f4913m = new C14111(this);
        this.f4914n = new BroadcastReceiver() {
            final /* synthetic */ C1421c f4872a;

            {
                this.f4872a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                    if ("com.antutu.benchmark.full".equals(intent.getDataString().substring(8))) {
                        this.f4872a.m5614l();
                        this.f4872a.m5619d();
                    }
                }
            }
        };
    }

    private void m5583a(int i) {
        if (i > 0) {
            if (this.f4905e.getCount() > 1 && this.f4905e.m4878a(1) != null && HomeFlagModel.IS_SHOW_JIASU.equals(this.f4905e.m4878a(1).getLabel())) {
                this.f4905e.m4884b(1);
            }
            this.f4905e.m4881a(new HomeFlagModel(HomeFlagModel.IS_SHOW_JIASU, Integer.valueOf(i)), 1);
            this.f4905e.notifyDataSetChanged();
        }
    }

    private static void m5585a(Activity activity, String[] strArr) {
        new Builder(activity).setTitle(C1082R.string.permissions_waring_title).setMessage(C1082R.string.permissions_waring_info).setPositiveButton(C1692R.string.confirm, new AnonymousClass14(activity, strArr)).show();
    }

    private void m5586a(View view) {
        this.f4906f = (RelativeLayout) this.f4903c.findViewById(C1082R.id.start_test_region);
        this.f4907g = (TextView) this.f4903c.findViewById(C1082R.id.start_test_text);
        this.f4908h = (TextView) this.f4903c.findViewById(C1082R.id.device_model_text);
        this.f4904d = (ListView) view.findViewById(C1082R.id.lv_not_testlist);
        this.f4910j = (PromptView) view.findViewById(C1082R.id.pv_prompt);
    }

    public static boolean m5588a(Activity activity) {
        List arrayList = new ArrayList();
        if (!Utils.checkPermission(activity, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
            arrayList.add(MsgConstant.PERMISSION_READ_PHONE_STATE);
        }
        if (!Utils.checkPermission(activity, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
            arrayList.add(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE);
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        C1421c.m5585a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]));
        return false;
    }

    static boolean m5589a(Context context) {
        try {
            if (System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0) {
                C1421c.m5594b(context);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    private static void m5593b(Activity activity, View view) {
        if (view != null) {
            try {
                ((WindowManager) activity.getSystemService("window")).removeView(view);
            } catch (Exception e) {
            }
        }
    }

    private static void m5594b(Context context) {
        new Builder(context).setTitle(C1082R.string.always_finish_title).setMessage(C1082R.string.always_finish_info).setPositiveButton(C1692R.string.confirm, new AnonymousClass13(context)).show();
    }

    private static void m5597d(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(C1082R.layout.toast_view_close, null);
            ((TextView) inflate.findViewById(C2279R.id.info)).setText(activity.getString(C1082R.string.enable_permissions));
            ((Button) inflate.findViewById(C1082R.id.btn_close)).setOnClickListener(new AnonymousClass15(activity, inflate));
            WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
            ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.type = 2005;
            layoutParams.format = 1;
            layoutParams.gravity = 48;
            layoutParams.y = Constants.COMMAND_HANDSHAKE;
            layoutParams.flags = 40;
            inflate.setOnTouchListener(new AnonymousClass16(layoutParams, inflate, windowManager));
            layoutParams.width = -1;
            layoutParams.height = -2;
            windowManager.addView(inflate, layoutParams);
        } catch (Exception e) {
        }
    }

    private void m5600e() {
        this.f4905e.m4879a();
        this.f4905e.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_YANJI, Integer.valueOf(1)));
        this.f4905e.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_PINGLUN, Integer.valueOf(2)));
        this.f4905e.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_MORE_TEST, Integer.valueOf(3)));
        this.f4905e.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_LONG_TEST, Integer.valueOf(4)));
        this.f4905e.notifyDataSetChanged();
    }

    private static void m5601e(Activity activity) {
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(C1692R.layout.toast_view, null);
        ((TextView) inflate.findViewById(C2279R.id.info)).setText(activity.getString(C1082R.string.enable_permissions));
        Toast toast = new Toast(activity);
        toast.setGravity(48, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    private void m5603f() {
        this.f4907g.setOnClickListener(this);
        this.f4906f.setOnClickListener(this);
    }

    private void m5606h() {
        Dialog create = new Builder(this.a).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.setCancelable(true);
        create.setContentView(C1082R.layout.dialog_install_plugin);
        create.setOnCancelListener(new OnCancelListener() {
            final /* synthetic */ C1421c f4883a;

            {
                this.f4883a = r1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                InfocUtil.antutu_click_testtab(((Dialog) dialogInterface).getContext(), 2);
            }
        });
        int dpToPxInt = Utils.dpToPxInt(this.a, 320.0f);
        int dpToPxInt2 = Utils.dpToPxInt(this.a, 240.0f);
        Window window = create.getWindow();
        window.setLayout(dpToPxInt, dpToPxInt2);
        window.setGravity(17);
        TextView textView = (TextView) create.findViewById(C1082R.id.tv_button1);
        TextView textView2 = (TextView) create.findViewById(C1082R.id.tv_button2);
        TextView textView3 = (TextView) create.findViewById(C1082R.id.tv_title);
        TextView textView4 = (TextView) create.findViewById(C1082R.id.tv_message);
        OnClickListener c14122 = new C14122(this);
        if (NetUtils.getNetWorkType(this.a) == 4) {
            textView3.setText(C1082R.string.need_download3d_reason);
            textView4.setText(C1082R.string.need_download3d_content_new);
            if (!Methods.getSharedPreferencesBoolean("clickMarketDownload", false) || C1516b.m6022c(this.a)) {
                textView.setText(C1692R.string.cancel);
                textView.setOnClickListener(new C14155(this, create));
                textView2.setText(C1082R.string.download_3D);
                textView2.setOnClickListener(new C14166(this, c14122, create));
                return;
            }
            textView.setText(C1082R.string.download_3D_CDN);
            textView.setOnClickListener(new C14133(this, create));
            textView2.setText(C1082R.string.download_3D_market);
            textView2.setOnClickListener(new C14144(this, c14122, create));
            return;
        }
        textView3.setText(C1082R.string.not_wifi_environment);
        textView4.setText(C1082R.string.need_download3d_content_not_wifi);
        textView.setVisibility(4);
        textView2.setText(C1082R.string.market_download);
        textView2.setOnClickListener(new C14177(this, c14122, create));
    }

    private void m5608i() {
        Intent intent = new Intent(this.a, ScoreBenchActivity.class);
        intent.setFlags(335544320);
        intent.putExtra("startBench", true);
        this.a.startActivity(intent);
        this.a.overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
        if (!(this.a instanceof MainActivity)) {
            this.a.finish();
        }
    }

    private void m5610j() {
        try {
            IntentFilter intentFilter = new IntentFilter(DownloadsService.ACTION_DOWNLOAD_MESSAGE);
            intentFilter.addAction("com.antutu.benchmark.update.DEVICE_INFO");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addDataScheme(C4209a.f14200c);
            this.a.registerReceiver(this.f4913m, intentFilter);
            this.a.registerReceiver(this.f4914n, intentFilter2);
        } catch (Exception e) {
        }
    }

    private void m5612k() {
        this.f4910j.setText((int) C1082R.string.download_3d_plugin_tips_finished);
        this.f4910j.setOnClickListener(new C14188(this));
    }

    private void m5614l() {
        if (Methods.hasInstalled("com.antutu.benchmark.full")) {
            this.f4907g.setText(C1082R.string.start_str);
            this.f4910j.m6470b();
            return;
        }
        this.f4907g.setText(C1082R.string.install_and_test);
    }

    private void m5615m() {
        this.f4908h.setText(C1503b.m5915c().m5970w());
    }

    private void m5616n() {
        this.f4911k.m5431b(new C14199(this));
    }

    public void m5617a(Object obj) {
        try {
            if (C1503b.m5915c().m5923a() != null) {
                m5612k();
                this.f4910j.m6469a();
            }
        } catch (Exception e) {
        }
        m5615m();
        m5614l();
        m5616n();
    }

    public void m5618c() {
        try {
            if (!C1421c.m5589a(this.a) || !C1421c.m5588a(this.a)) {
                return;
            }
            if ((C1503b.f5113a & 2) == 0 || C1516b.m6022c(this.a)) {
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.startbench_has_plugin);
                m5608i();
                return;
            }
            C1516b.m6010a(this.a, 2);
            MobclickAgent.onEvent(this.a, MobclickAgentConstants.startbench_no_plugin);
            try {
                String a = C1503b.m5915c().m5923a();
                if (a != null) {
                    Intent flags = new Intent("android.intent.action.VIEW").setFlags(268435456);
                    flags.setDataAndType(Uri.fromFile(new File(a)), "application/vnd.android.package-archive");
                    startActivity(flags);
                } else if (this.f4902b) {
                    Intent intent = new Intent();
                    intent.setClass(this.a, Stop3DPluginActivity.class);
                    intent.setFlags(268435456);
                    intent.putExtra("info", this.f4909i);
                    startActivity(intent);
                } else if (C1503b.m5915c().m5954k() == 1) {
                    Builder builder = new Builder(this.a);
                    builder.setTitle(C1082R.string.gp_download_3dplugin_title);
                    builder.setMessage(C1082R.string.gp_download_3dplugin);
                    builder.setNegativeButton(C1082R.string.download, new DialogInterface.OnClickListener() {
                        final /* synthetic */ C1421c f4873a;

                        {
                            this.f4873a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (Utils.isNetworkConnected(this.f4873a.a)) {
                                Methods.downloadFromGP(this.f4873a.a, "market://details?id=com.antutu.benchmark.full");
                                InfocUtil.antutu_click_testtab(((Dialog) dialogInterface).getContext(), 1);
                                dialogInterface.dismiss();
                                return;
                            }
                            Methods.showToast(this.f4873a.a, (int) C1692R.string.network_error, 1);
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setOnCancelListener(new OnCancelListener() {
                        final /* synthetic */ C1421c f4874a;

                        {
                            this.f4874a = r1;
                        }

                        public void onCancel(DialogInterface dialogInterface) {
                            InfocUtil.antutu_click_testtab(((Dialog) dialogInterface).getContext(), 2);
                        }
                    });
                    builder.create().show();
                } else {
                    m5606h();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    public void m5619d() {
        if (!Methods.hasInstalled("com.antutu.benchmark.full") && Methods.getSharedPreferencesBoolean("clickMarketDownload", false)) {
            this.f4910j.setText((int) C1082R.string.download_and_install_to_test);
            this.f4910j.m6469a();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.start_test_region /*2131624370*/:
            case C1082R.id.start_test_text /*2131624372*/:
                MLog.m6865d("HomePageNotTestedFragment", "start test....");
                if (C1516b.m6022c(view.getContext())) {
                    InfocUtil.antutu_click_testtab(view.getContext(), 3);
                }
                m5618c();
            default:
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.home_page_not_tested, null);
        this.f4903c = layoutInflater.inflate(C1082R.layout.header_home_not_test, null);
        m5586a(inflate);
        this.f4904d.addHeaderView(this.f4903c);
        this.f4905e = new C1122k();
        m5600e();
        this.f4904d.setAdapter(this.f4905e);
        this.f4911k = new C1371d(this.a);
        m5610j();
        m5603f();
        m5617a(null);
        return inflate;
    }

    public void onDestroyView() {
        try {
            this.a.unregisterReceiver(this.f4913m);
            this.a.unregisterReceiver(this.f4914n);
        } catch (Exception e) {
        }
        super.onDestroyView();
    }

    public void onPause() {
        getContext().unregisterReceiver(this.f4912l);
        super.onPause();
    }

    public void onRefresh() {
        m5616n();
    }

    public void onResume() {
        super.onResume();
        getContext().registerReceiver(this.f4912l, this.f4912l.m5580a());
    }
}
