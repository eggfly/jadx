package com.antutu.benchmark.p042e;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.C1372c;
import com.antutu.benchmark.activity.C1324b;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.model.C1526g;
import com.antutu.benchmark.model.C1528h;
import com.antutu.benchmark.p036a.C1129l;
import com.antutu.benchmark.p036a.C1171r;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p041d.C1378d;
import com.antutu.benchmark.p041d.C1378d.C1377a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.benchmark.view.DragListView;
import com.antutu.benchmark.view.DragListView.C1385a;
import com.antutu.redacc.C1692R;
import com.antutu.utils.BuildProperties;
import com.antutu.utils.DevAdvFactor;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.IO;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.NetUtils;
import com.antutu.utils.SpecialHelper;
import com.antutu.utils.StringUtil;
import com.antutu.utils.Utils;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.jni;
import com.antutu.utils.widget.AdWebView;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.C2279R;
import com.handmark.pulltorefresh.library.C3628R;
import com.igexin.sdk.PushConsts;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.e.a */
public class C1409a extends C1338c {
    private C1400j f4818A;
    private C1404n f4819B;
    private C1399i f4820C;
    private C1394d f4821D;
    private C1401k f4822E;
    private C1392b f4823F;
    private C1402l f4824G;
    private C1403m f4825H;
    private C1405o f4826I;
    private ConnectivityManager f4827J;
    private NetworkInfo f4828K;
    private int[] f4829L;
    private List<C1129l> f4830M;
    private C1129l f4831N;
    private C1129l f4832O;
    private C1129l f4833P;
    private C1129l f4834Q;
    private C1129l f4835R;
    private C1129l f4836S;
    private C1129l f4837T;
    private C1129l f4838U;
    private C1129l f4839V;
    private C1129l f4840W;
    private C1129l f4841X;
    private ArrayList<C1377a> f4842Y;
    private final int f4843Z;
    private final int aa;
    private String ab;
    private BroadcastReceiver ac;
    private BroadcastReceiver ad;
    private List<C1396f> ae;
    private C1406p af;
    private C1407q ag;
    private Runnable ah;
    List<C1398h> f4844b;
    String[] f4845c;
    String[] f4846d;
    String[] f4847e;
    String[] f4848f;
    String[] f4849g;
    String[] f4850h;
    String[] f4851i;
    String[] f4852j;
    String[] f4853k;
    String[] f4854l;
    String[] f4855m;
    String[] f4856n;
    C1171r f4857o;
    private int f4858p;
    private int f4859q;
    private boolean f4860r;
    private boolean f4861s;
    private SimpleAdapter f4862t;
    private boolean f4863u;
    private C1528h f4864v;
    private DragListView f4865w;
    private C1393c f4866x;
    private C1395e f4867y;
    private C1397g f4868z;

    /* renamed from: com.antutu.benchmark.e.a.1 */
    class C13821 extends BroadcastReceiver {
        final /* synthetic */ C1409a f4693a;

        C13821(C1409a c1409a) {
            this.f4693a = c1409a;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                this.f4693a.f4824G.f4789c = String.valueOf((intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100)) + "%";
                double intExtra = ((double) intent.getIntExtra("temperature", 0)) * 0.1d;
                this.f4693a.f4824G.f4790d = StringUtil.formatTempToCAndF(intExtra);
                Methods.editSharedPreferences("temperature", String.valueOf(intExtra));
                this.f4693a.m5540h();
            } else if (action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                action = BuildConfig.FLAVOR;
                this.f4693a.m5542i();
                action = (this.f4693a.f4828K == null || !this.f4693a.f4828K.isAvailable()) ? "No Access" : this.f4693a.f4828K.getTypeName();
                this.f4693a.m5522a(action);
            } else if (action.equals("com.antutu.device_loc_action")) {
                this.f4693a.ab = intent.getStringExtra("loc");
                if (this.f4693a.isAdded()) {
                    this.f4693a.m5537f();
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.2 */
    class C13832 extends BroadcastReceiver {
        final /* synthetic */ C1409a f4694a;

        C13832(C1409a c1409a) {
            this.f4694a = c1409a;
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
                                this.f4694a.m5571a(url, this.f4694a.a.getString(C1082R.string.downloading_status));
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                this.f4694a.m5571a(url, this.f4694a.a.getString(C1082R.string.install_status));
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                this.f4694a.m5571a(url, this.f4694a.a.getString(C1082R.string.continue_status));
                            default:
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.3 */
    class C13843 extends C1171r {
        final /* synthetic */ C1409a f4695a;

        C13843(C1409a c1409a) {
            this.f4695a = c1409a;
        }

        public View m5462a(String str, int i, View view, ViewGroup viewGroup) {
            C1408r c1408r;
            if (view == null || !(view.getTag() instanceof C1408r)) {
                c1408r = new C1408r();
                view = this.f4695a.getActivity().getLayoutInflater().inflate(C1082R.layout.list_header, null);
                c1408r.f4817a = (TextView) view.findViewById(C1082R.id.tv_header);
                view.setTag(c1408r);
            } else {
                c1408r = (C1408r) view.getTag();
            }
            c1408r.f4817a = (TextView) view.findViewById(C1082R.id.tv_header);
            c1408r.f4817a.setText(str);
            return view;
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.4 */
    class C13864 implements C1385a {
        final /* synthetic */ C1409a f4696a;

        C13864(C1409a c1409a) {
            this.f4696a = c1409a;
        }

        public void m5464a() {
            if (Utils.isNetworkConnected(this.f4696a.getActivity()) && this.f4696a.f4864v == null) {
                this.f4696a.m5573d();
            } else {
                this.f4696a.f4865w.m6425a();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.5 */
    class C13875 extends Thread {
        final /* synthetic */ C1409a f4697a;

        C13875(C1409a c1409a) {
            this.f4697a = c1409a;
        }

        public void run() {
            super.run();
            try {
                this.f4697a.m5553o();
                this.f4697a.m5552n();
                this.f4697a.m5547l();
                this.f4697a.af.sendEmptyMessage(1);
                this.f4697a.m5573d();
                this.f4697a.m5542i();
                this.f4697a.m5544j();
                this.f4697a.af.sendEmptyMessage(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.6 */
    class C13886 implements DownloadJobListener {
        final /* synthetic */ C1409a f4698a;

        C13886(C1409a c1409a) {
            this.f4698a = c1409a;
        }

        public void downloadEnded(C1519k c1519k) {
            if (!this.f4698a.isAdded()) {
                return;
            }
            if (c1519k == null) {
                try {
                    if (this.f4698a.f4865w != null) {
                        this.f4698a.f4865w.m6425a();
                    }
                    Methods.showToast(this.f4698a.a, (int) C1692R.string.network_error, 0);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            if (this.f4698a.f4865w != null) {
                this.f4698a.f4865w.m6425a();
            }
            this.f4698a.f4864v = (C1528h) c1519k;
            if (this.f4698a.f4864v == null || this.f4698a.f4864v.f5296a == null || this.f4698a.f4864v.f5296a.f5268K != 1) {
                this.f4698a.m5512J();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.7 */
    class C13897 implements DownloadJobListener {
        final /* synthetic */ C1409a f4699a;

        C13897(C1409a c1409a) {
            this.f4699a = c1409a;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                this.f4699a.m5521a((C1526g) c1519k);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.8 */
    class C13908 implements Runnable {
        final /* synthetic */ C1409a f4700a;

        C13908(C1409a c1409a) {
            this.f4700a = c1409a;
        }

        public void run() {
            if (this.f4700a.f4863u) {
                this.f4700a.m5574e();
                this.f4700a.ag.postDelayed(this, 5000);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.a */
    public class C1391a {
        List<DevAdvFactor> f4701a;
        final /* synthetic */ C1409a f4702b;

        public C1391a(C1409a c1409a) {
            this.f4702b = c1409a;
            this.f4701a = new ArrayList();
        }

        public String m5465a(DevAdvFactor devAdvFactor) {
            String pn = devAdvFactor.getPn();
            return devAdvFactor.getBtnTxt() + "||" + pn + "||" + devAdvFactor.getUrl();
        }

        public String[] m5466a(String[] strArr, List<String> list) {
            String[] strArr2 = new String[(strArr.length + list.size())];
            int i = 0;
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                if (i2 < strArr.length) {
                    strArr2[i2] = strArr[i2];
                } else {
                    strArr2[i2] = (String) list.get(i);
                    i++;
                }
            }
            return strArr2;
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.b */
    class C1392b extends C1391a {
        String f4703c;
        String f4704d;
        String f4705e;
        String f4706f;
        String f4707g;
        String f4708h;
        String f4709i;
        String f4710j;
        List<String> f4711k;
        String[] f4712l;
        final /* synthetic */ C1409a f4713m;

        C1392b(C1409a c1409a) {
            this.f4713m = c1409a;
            super(c1409a);
            this.f4711k = new ArrayList();
        }

        public void m5467a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4711k.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4713m.f4856n = this.f4713m.m5524a(this.f4713m.f4856n, advDescription);
            }
        }

        public String[] m5468a() {
            this.f4712l = new String[]{this.f4703c, this.f4704d, this.f4705e, this.f4706f, this.f4707g, this.f4708h, this.f4709i, this.f4710j};
            this.f4712l = m5466a(this.f4712l, this.f4711k);
            return this.f4712l;
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.c */
    class C1393c extends C1391a {
        String f4714c;
        String f4715d;
        String f4716e;
        String f4717f;
        String f4718g;
        String f4719h;
        String f4720i;
        List<String> f4721j;
        String[] f4722k;
        final /* synthetic */ C1409a f4723l;

        C1393c(C1409a c1409a) {
            this.f4723l = c1409a;
            super(c1409a);
            this.f4714c = BuildConfig.FLAVOR;
            this.f4715d = BuildConfig.FLAVOR;
            this.f4716e = BuildConfig.FLAVOR;
            this.f4717f = BuildConfig.FLAVOR;
            this.f4718g = BuildConfig.FLAVOR;
            this.f4719h = BuildConfig.FLAVOR;
            this.f4720i = BuildConfig.FLAVOR;
            this.f4721j = new ArrayList();
        }

        private String[] m5470b() {
            if (this.f4716e == null || !this.f4716e.contains("MT")) {
                int indexOf = this.f4714c.indexOf("@");
                if (indexOf != -1) {
                    this.f4714c = this.f4714c.substring(0, indexOf);
                }
                this.f4722k = new String[]{this.f4714c, this.f4720i, this.f4719h, this.f4718g, "flag_cpu"};
                this.f4722k = m5466a(this.f4722k, this.f4721j);
                return this.f4722k;
            }
            this.f4722k = new String[]{this.f4716e, this.f4720i, this.f4719h, this.f4718g, "flag_cpu"};
            return this.f4722k;
        }

        public String m5471a() {
            return (this.f4716e == null || !this.f4716e.contains("MT")) ? this.f4714c : this.f4716e;
        }

        public void m5472a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4721j.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4723l.f4847e = this.f4723l.m5524a(this.f4723l.f4847e, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.d */
    class C1394d extends C1391a {
        String f4724c;
        String f4725d;
        String f4726e;
        String f4727f;
        String f4728g;
        List<String> f4729h;
        String[] f4730i;
        final /* synthetic */ C1409a f4731j;

        C1394d(C1409a c1409a) {
            this.f4731j = c1409a;
            super(c1409a);
            this.f4729h = new ArrayList();
        }

        private String[] m5473a() {
            this.f4730i = new String[]{this.f4725d, this.f4724c, this.f4726e, this.f4727f, this.f4728g};
            this.f4730i = m5466a(this.f4730i, this.f4729h);
            return this.f4730i;
        }

        public void m5475a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4729h.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4731j.f4853k = this.f4731j.m5524a(this.f4731j.f4853k, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.e */
    class C1395e extends C1391a {
        String f4732c;
        String f4733d;
        String f4734e;
        List<String> f4735f;
        final /* synthetic */ C1409a f4736g;

        C1395e(C1409a c1409a) {
            this.f4736g = c1409a;
            super(c1409a);
            this.f4735f = new ArrayList();
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.f */
    public class C1396f implements SensorEventListener {
        String f4737a;
        SensorManager f4738b;
        int f4739c;
        final /* synthetic */ C1409a f4740d;

        public C1396f(C1409a c1409a, int i) {
            this.f4740d = c1409a;
            this.f4737a = "-1";
            this.f4739c = 0;
            this.f4739c = i;
        }

        public String m5476a() {
            return this.f4737a;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent != null) {
                try {
                    if (sensorEvent.sensor != null) {
                        String vendor = sensorEvent.sensor.getVendor();
                        if (!(vendor == null || BuildConfig.FLAVOR.equals(vendor))) {
                            this.f4737a = vendor;
                        }
                    }
                } catch (Throwable th) {
                    if (this.f4738b != null) {
                        this.f4738b.unregisterListener(this);
                    }
                }
            }
            if (this.f4738b != null) {
                this.f4738b.unregisterListener(this);
            }
            if (this.f4738b != null) {
                this.f4738b.unregisterListener(this);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.g */
    class C1397g extends C1391a {
        String f4741c;
        String f4742d;
        String f4743e;
        String f4744f;
        String f4745g;
        String f4746h;
        String f4747i;
        String f4748j;
        String f4749k;
        List<String> f4750l;
        String[] f4751m;
        final /* synthetic */ C1409a f4752n;

        C1397g(C1409a c1409a) {
            this.f4752n = c1409a;
            super(c1409a);
            this.f4750l = new ArrayList();
        }

        private String[] m5477a() {
            this.f4751m = new String[]{this.f4742d, this.f4741c, this.f4743e, this.f4749k, this.f4744f, this.f4747i, this.f4746h, this.f4748j, "flag_touch"};
            this.f4751m = m5466a(this.f4751m, this.f4750l);
            return this.f4751m;
        }

        public void m5479a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4750l.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4752n.f4848f = this.f4752n.m5524a(this.f4752n.f4848f, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.h */
    class C1398h {
        public String[] f4753a;
        public C1129l f4754b;
        public String f4755c;
        final /* synthetic */ C1409a f4756d;
        private int f4757e;

        public C1398h(C1409a c1409a, String[] strArr, C1129l c1129l) {
            this.f4756d = c1409a;
            this.f4753a = strArr;
            this.f4754b = c1129l;
        }

        public int m5480a() {
            return this.f4757e;
        }

        public void m5481a(int i) {
            this.f4757e = i;
        }

        public void m5482a(String str) {
            this.f4755c = str;
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.i */
    class C1399i extends C1391a {
        String f4758c;
        List<String> f4759d;
        String[] f4760e;
        final /* synthetic */ C1409a f4761f;

        C1399i(C1409a c1409a) {
            this.f4761f = c1409a;
            super(c1409a);
            this.f4759d = new ArrayList();
        }

        private String[] m5483a() {
            this.f4760e = new String[]{this.f4758c};
            this.f4760e = m5466a(this.f4760e, this.f4759d);
            return this.f4760e;
        }

        public void m5485a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4759d.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4761f.f4852j = this.f4761f.m5524a(this.f4761f.f4852j, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.j */
    class C1400j extends C1391a {
        String f4762c;
        String f4763d;
        String f4764e;
        List<String> f4765f;
        String[] f4766g;
        final /* synthetic */ C1409a f4767h;

        C1400j(C1409a c1409a) {
            this.f4767h = c1409a;
            super(c1409a);
            this.f4765f = new ArrayList();
        }

        private String[] m5486a() {
            this.f4766g = new String[]{this.f4762c, this.f4763d, this.f4764e};
            this.f4766g = m5466a(this.f4766g, this.f4765f);
            return this.f4766g;
        }

        public void m5488a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4765f.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4767h.f4846d = this.f4767h.m5524a(this.f4767h.f4846d, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.k */
    class C1401k extends C1391a {
        String f4768c;
        String f4769d;
        String f4770e;
        String f4771f;
        String f4772g;
        String f4773h;
        String f4774i;
        String f4775j;
        String f4776k;
        String f4777l;
        String f4778m;
        String f4779n;
        String f4780o;
        String f4781p;
        String f4782q;
        String f4783r;
        String f4784s;
        String f4785t;
        String f4786u;
        String f4787v;
        final /* synthetic */ C1409a f4788w;

        public C1401k(C1409a c1409a, FragmentActivity fragmentActivity) {
            this.f4788w = c1409a;
            super(c1409a);
            String string = fragmentActivity.getString(C1082R.string.nonsupport);
            this.f4768c = string;
            this.f4769d = string;
            this.f4770e = string;
            this.f4771f = string;
            this.f4772g = string;
            this.f4773h = string;
            this.f4774i = string;
            this.f4775j = string;
            this.f4776k = string;
            this.f4777l = string;
            this.f4778m = string;
            this.f4779n = string;
            this.f4780o = string;
            this.f4781p = string;
            this.f4782q = string;
            this.f4783r = string;
            this.f4784s = string;
            this.f4785t = string;
            this.f4786u = string;
            this.f4787v = string;
        }

        private String[] m5489a() {
            return new String[]{this.f4768c, this.f4769d, this.f4770e, this.f4771f, this.f4772g, this.f4773h, this.f4774i, this.f4775j, this.f4776k, this.f4777l, this.f4778m, this.f4779n, this.f4780o, this.f4781p, this.f4782q, this.f4783r, this.f4784s, this.f4785t, this.f4786u, this.f4787v};
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.l */
    class C1402l extends C1391a {
        String f4789c;
        String f4790d;
        List<String> f4791e;
        String[] f4792f;
        final /* synthetic */ C1409a f4793g;

        C1402l(C1409a c1409a) {
            this.f4793g = c1409a;
            super(c1409a);
            this.f4791e = new ArrayList();
        }

        private String[] m5491a() {
            if (this.f4789c == null) {
                this.f4789c = "loading";
            }
            if (this.f4790d == null) {
                this.f4790d = "loading";
            }
            this.f4792f = new String[]{this.f4789c, this.f4790d};
            this.f4792f = m5466a(this.f4792f, this.f4791e);
            return this.f4792f;
        }

        public void m5493a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4791e.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4793g.f4855m = this.f4793g.m5524a(this.f4793g.f4855m, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.m */
    class C1403m extends C1391a {
        String f4794c;
        String f4795d;
        String f4796e;
        List<String> f4797f;
        String[] f4798g;
        final /* synthetic */ C1409a f4799h;

        C1403m(C1409a c1409a) {
            this.f4799h = c1409a;
            super(c1409a);
            this.f4797f = new ArrayList();
        }

        private String[] m5494a() {
            this.f4798g = new String[]{this.f4794c, this.f4795d, this.f4796e};
            this.f4798g = m5466a(this.f4798g, this.f4797f);
            return this.f4798g;
        }

        public void m5496a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4797f.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4799h.f4849g = this.f4799h.m5524a(this.f4799h.f4849g, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.n */
    class C1404n extends C1391a {
        String f4800c;
        String f4801d;
        String f4802e;
        String f4803f;
        List<String> f4804g;
        String[] f4805h;
        final /* synthetic */ C1409a f4806i;

        C1404n(C1409a c1409a) {
            this.f4806i = c1409a;
            super(c1409a);
            this.f4804g = new ArrayList();
        }

        private String[] m5497a() {
            this.f4805h = new String[]{this.f4801d, this.f4800c, this.f4802e, this.f4803f};
            this.f4805h = m5466a(this.f4805h, this.f4804g);
            return this.f4805h;
        }

        public void m5499a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4804g.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4806i.f4851i = this.f4806i.m5524a(this.f4806i.f4851i, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.o */
    class C1405o extends C1391a {
        String f4807c;
        String f4808d;
        String f4809e;
        String f4810f;
        String f4811g;
        List<String> f4812h;
        String[] f4813i;
        final /* synthetic */ C1409a f4814j;

        C1405o(C1409a c1409a) {
            this.f4814j = c1409a;
            super(c1409a);
            this.f4812h = new ArrayList();
        }

        private String[] m5500a() {
            this.f4813i = new String[]{this.f4807c, this.f4811g, this.f4808d, this.f4809e, this.f4810f};
            this.f4813i = m5466a(this.f4813i, this.f4812h);
            return this.f4813i;
        }

        public void m5502a(List<String> list, DevAdvFactor devAdvFactor) {
            if (devAdvFactor != null) {
                this.f4812h.add(m5465a(devAdvFactor));
                this.a.add(devAdvFactor);
                String advDescription = devAdvFactor.getAdvDescription();
                this.f4814j.f4850h = this.f4814j.m5524a(this.f4814j.f4850h, advDescription);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.p */
    static class C1406p extends Handler {
        WeakReference<C1409a> f4815a;

        C1406p(C1409a c1409a) {
            this.f4815a = new WeakReference(c1409a);
        }

        public void handleMessage(Message message) {
            try {
                ((C1409a) this.f4815a.get()).m5527b(message.what);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.q */
    static class C1407q extends Handler {
        WeakReference<C1409a> f4816a;

        C1407q(C1409a c1409a) {
            this.f4816a = new WeakReference(c1409a);
        }

        public void handleMessage(Message message) {
            try {
                ((C1409a) this.f4816a.get()).m5531c(message.what);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.a.r */
    static class C1408r {
        TextView f4817a;

        C1408r() {
        }
    }

    public C1409a() {
        this.f4858p = -1;
        this.f4859q = -1;
        this.f4860r = false;
        this.f4861s = false;
        this.f4862t = null;
        this.f4863u = false;
        this.f4864v = null;
        this.f4824G = new C1402l(this);
        this.f4829L = new int[]{C1082R.string.dvm, C1082R.string.info_os, C1082R.string.info_cpu, C1082R.string.display, C1082R.string.info_appearance, C1082R.string.info_trans, C1082R.string.storage, C1082R.string.info_net, C1082R.string.info_camera, C1082R.string.info_others, C1082R.string.battery, C1082R.string.basic_info};
        this.f4830M = new ArrayList();
        this.f4843Z = C1082R.string.support;
        this.aa = C1082R.string.nonsupport;
        this.ab = null;
        this.f4844b = new ArrayList();
        this.ac = new C13821(this);
        this.ad = new C13832(this);
        this.ae = new ArrayList();
        this.af = new C1406p(this);
        this.f4857o = new C13843(this);
        this.ag = new C1407q(this);
        this.ah = new C13908(this);
    }

    private void m5503A() {
        for (int i = 0; i < this.ae.size(); i++) {
            String a = ((C1396f) this.ae.get(i)).m5476a();
            int i2 = ((C1396f) this.ae.get(i)).f4739c;
            if (!a.equals("-1")) {
                String a2 = ((C1396f) this.ae.get(i)).m5476a();
                switch (i) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        this.f4822E.f4768c = a2;
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        this.f4822E.f4772g = a2;
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        this.f4822E.f4773h = a2;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        this.f4822E.f4774i = a2;
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        this.f4822E.f4778m = a2;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        this.f4822E.f4780o = a2;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                        this.f4822E.f4781p = a2;
                        break;
                    case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                        this.f4822E.f4782q = a2;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                        this.f4822E.f4769d = a2;
                        break;
                    case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                        this.f4822E.f4783r = a2;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                        this.f4822E.f4777l = a2;
                        break;
                    case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                        this.f4822E.f4784s = a2;
                        break;
                    case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                        this.f4822E.f4770e = a2;
                        break;
                    case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                        this.f4822E.f4771f = a2;
                        break;
                    case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                        this.f4822E.f4787v = a2;
                        break;
                    case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                        this.f4822E.f4786u = a2;
                        break;
                    case SpdyProtocol.CUSTOM /*16*/:
                        this.f4822E.f4775j = a2;
                        break;
                    case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                        this.f4822E.f4779n = a2;
                        break;
                    case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                        this.f4822E.f4785t = a2;
                        break;
                    default:
                        break;
                }
            }
            m5504B();
        }
    }

    private void m5504B() {
        for (int i = 0; i < this.f4842Y.size(); i++) {
            C1377a c1377a = (C1377a) this.f4842Y.get(i);
            if (c1377a.f4682a.equals(Build.MODEL) && c1377a.f4685d.equals(MessageService.MSG_DB_READY_REPORT)) {
                this.f4822E.f4775j = getString(C1082R.string.support);
            }
        }
    }

    private void m5505C() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object equals : this.f4822E.m5489a()) {
            if (getActivity().getString(C1082R.string.nonsupport).equals(equals)) {
                stringBuilder.append(0);
            } else {
                stringBuilder.append(1);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        MLog.m6870i("hzd, cacheSensors, value=" + stringBuilder2);
        Methods.editSharedPreferences("share_pref_support_sensors", stringBuilder2);
    }

    private void m5506D() {
        for (int i = 0; i < this.f4842Y.size(); i++) {
            C1377a c1377a = (C1377a) this.f4842Y.get(i);
            if (c1377a.f4682a.equals(Build.MODEL) && c1377a.f4684c == 0) {
                this.f4822E.f4772g = getString(C1082R.string.support);
            }
        }
    }

    private void m5507E() {
        this.f4868z = new C1397g(this);
        try {
            if (C1516b.m6013a()) {
                startActivity(new Intent(getActivity(), C1324b.class));
                int i = 0;
                while (C1516b.m6013a() && i <= 30) {
                    Thread.sleep(100);
                    i++;
                }
            }
        } catch (Exception e) {
        }
        if (!C1516b.m6013a()) {
            this.f4868z.f4741c = C1516b.m6035i();
            this.f4868z.f4742d = C1516b.m6036j();
            this.f4868z.f4743e = C1516b.m6037k();
            this.f4868z.f4746h = null;
            this.f4868z.f4747i = null;
            this.f4868z.f4748j = m5568y();
            this.f4868z.f4749k = C1516b.m6031g();
            this.f4868z.f4744f = m5567x();
        }
        this.f4868z.f4745g = getString(C1082R.string.support);
    }

    private void m5508F() {
        String format;
        String localLanguage = Utils.getLocalLanguage(getActivity());
        this.f4819B = new C1404n(this);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long blockSize = (long) statFs.getBlockSize();
        long availableBlocks = ((long) statFs.getAvailableBlocks()) * blockSize;
        blockSize *= (long) statFs.getBlockCount();
        if (localLanguage.equalsIgnoreCase("TW") || localLanguage.equalsIgnoreCase("CN")) {
            format = String.format("%.02f / %.02f GB", new Object[]{Double.valueOf((((double) (availableBlocks >> 10)) / 1024.0d) / 1024.0d), Double.valueOf((((double) (blockSize >> 10)) / 1024.0d) / 1024.0d)});
        } else {
            format = String.format("Total:%.02fGB\nAvailable:%.02fGB", new Object[]{Double.valueOf((((double) (blockSize >> 10)) / 1024.0d) / 1024.0d), Double.valueOf((((double) (availableBlocks >> 10)) / 1024.0d) / 1024.0d)});
        }
        this.f4819B.f4800c = format;
        ((ActivityManager) getActivity().getSystemService("activity")).getMemoryInfo(new MemoryInfo());
        if (localLanguage.equalsIgnoreCase("TW") || localLanguage.equalsIgnoreCase("CN")) {
            format = String.format("%d / %d MB", new Object[]{Integer.valueOf(((int) (r2.availMem >> 10)) / IXAdIOUtils.BUFFER_SIZE), Integer.valueOf(IO.getRamTotalSize() / IXAdIOUtils.BUFFER_SIZE)});
        } else {
            format = String.format("Total:%dMB\nAvailable:%dMB", new Object[]{Integer.valueOf(IO.getRamTotalSize() / IXAdIOUtils.BUFFER_SIZE), Integer.valueOf(((int) (r2.availMem >> 10)) / IXAdIOUtils.BUFFER_SIZE)});
        }
        this.f4819B.f4801d = format;
        if (localLanguage.equalsIgnoreCase("TW") || localLanguage.equalsIgnoreCase("CN")) {
            format = String.format("%.02f / %.02f GB", new Object[]{Double.valueOf(IO.GetSDCardAvailableSize() / 1024.0d), Double.valueOf(IO.GetSDCardTotalSize() / 1024.0d)});
        } else {
            format = String.format("Total:%.02fGB\nAvailable:%.02fGB", new Object[]{Double.valueOf(IO.GetSDCardTotalSize() / 1024.0d), Double.valueOf(IO.GetSDCardAvailableSize() / 1024.0d)});
        }
        this.f4819B.f4802e = format;
        this.f4861s = C1503b.m5915c().m5964q();
        if (this.f4861s) {
            if (localLanguage.equalsIgnoreCase("TW") || localLanguage.equalsIgnoreCase("CN")) {
                format = String.format("%.02f / %.02f GB", new Object[]{Double.valueOf(IO.GetSDCardExAvailableSize() / 1024.0d), Double.valueOf(IO.GetSDCardExTotalSize() / 1024.0d)});
            } else {
                format = String.format("Total:%.02fGB\nAvailable:%.02fGB", new Object[]{Double.valueOf(IO.GetSDCardExTotalSize() / 1024.0d), Double.valueOf(IO.GetSDCardExAvailableSize() / 1024.0d)});
            }
            this.f4819B.f4803f = format;
        }
    }

    private void m5509G() {
        this.f4818A = new C1400j(this);
        C1503b c = C1503b.m5915c();
        this.f4818A.f4762c = VERSION.RELEASE + " (" + (c.m5948g() ? getString(C1082R.string.bit64) : getString(C1082R.string.bit32)) + C4233j.f14397t;
        BuildProperties instance = BuildProperties.getInstance();
        if (instance.containsKey("ro.yunos.version")) {
            this.f4818A.f4762c = instance.getProperty("ro.yunos.version", BuildConfig.FLAVOR);
            if (this.f4846d.length > 0) {
                this.f4846d[0] = getString(C1082R.string.yunos);
            }
        }
        this.f4818A.f4763d = m5534d(VERSION.SDK_INT);
        this.f4818A.f4764e = c.m5950i();
    }

    private void m5510H() {
        this.f4821D = new C1394d(this);
        try {
            if (C1372c.m5437a().m5407c() > 0) {
                new HashMap().put("TITLE", getString(C1082R.string.camera));
                this.f4821D.f4725d = String.format("%.1f %s   %dx%d", new Object[]{Float.valueOf(((float) r0.m5407c()) / 1000000.0f), getString(C1082R.string.mega_pixel), Integer.valueOf(r0.m5402a()), Integer.valueOf(r0.m5405b())});
            }
            if (C1372c.m5439b().m5407c() > 0) {
                this.f4821D.f4724c = String.format("%.1f %s   %dx%d", new Object[]{Float.valueOf(((float) r0.m5407c()) / 1000000.0f), getString(C1082R.string.mega_pixel), Integer.valueOf(r0.m5402a()), Integer.valueOf(r0.m5405b())});
            }
        } catch (Exception e) {
        }
    }

    private void m5511I() {
        if (Methods.getSharedPreferencesBoolean("pre_dev_tag", false)) {
            if (this.f4823F != null) {
                this.f4823F.f4704d = Methods.getSharedPreferencesString("pre_dev_model", BuildConfig.FLAVOR);
                this.f4823F.f4703c = Methods.getSharedPreferencesString("pre_dev_brand", BuildConfig.FLAVOR);
                this.f4823F.f4706f = Methods.getSharedPreferencesString("pre_dev_cpu_model", BuildConfig.FLAVOR);
            }
            if (this.f4866x != null) {
                this.f4866x.f4714c = Methods.getSharedPreferencesString("pre_dev_cpu_processor", BuildConfig.FLAVOR);
                this.f4866x.f4716e = Methods.getSharedPreferencesString("pre_dev_cpu_hardware", BuildConfig.FLAVOR);
            }
            if (this.f4821D != null) {
                this.f4821D.f4726e = Methods.getSharedPreferencesString("pre_dev_videocapture", BuildConfig.FLAVOR);
                this.f4821D.f4727f = Methods.getSharedPreferencesString("pre_dev_video_photograph", BuildConfig.FLAVOR);
                this.f4821D.f4728g = Methods.getSharedPreferencesString("pre_dev_camerasensor", BuildConfig.FLAVOR);
            }
            if (this.f4826I != null) {
                this.f4826I.f4809e = Methods.getSharedPreferencesString("pre_dev_bluetooth", BuildConfig.FLAVOR);
                this.f4826I.f4807c = Methods.getSharedPreferencesString("pre_dev_transgps", BuildConfig.FLAVOR);
                this.f4826I.f4808d = Methods.getSharedPreferencesString("pre_dev_WIFI", BuildConfig.FLAVOR);
            }
            if (this.f4825H != null) {
                this.f4825H.f4795d = Methods.getSharedPreferencesString("pre_dev_sfspecification", BuildConfig.FLAVOR);
                this.f4825H.f4794c = Methods.getSharedPreferencesString("pre_dev_sf_weight", BuildConfig.FLAVOR);
            }
            if (this.f4868z != null) {
                this.f4868z.f4747i = Methods.getSharedPreferencesString("pre_dev_gpusize", BuildConfig.FLAVOR);
                this.f4868z.f4746h = Methods.getSharedPreferencesString("pre_dev_gpu_material", BuildConfig.FLAVOR);
            }
        }
    }

    private void m5512J() {
        Object obj = 1;
        try {
            if (!this.f4864v.f5296a.f5265H.equals(BuildConfig.FLAVOR)) {
                if (!(this.f4866x.f4714c.contains("Intel") && this.f4866x.f4714c.contains("Atom"))) {
                    obj = null;
                }
                if (obj == null) {
                    this.f4866x.f4714c = this.f4864v.f5296a.f5265H;
                    this.f4866x.f4716e = this.f4864v.f5296a.f5265H;
                    this.f4823F.f4706f = this.f4864v.f5296a.f5265H;
                }
            }
            if (!(this.f4864v.f5296a.f5275f == null || this.f4864v.f5296a.f5275f.equals(BuildConfig.FLAVOR) || Build.BRAND.equalsIgnoreCase(this.f4864v.f5296a.f5275f))) {
                this.f4823F.f4703c = this.f4864v.f5296a.f5275f + C4233j.f14396s + Build.BRAND + C4233j.f14397t;
            }
            if (!(Build.MODEL.equalsIgnoreCase(this.f4864v.f5296a.f5274e) || this.f4864v.f5296a.f5274e == null)) {
                if ((Build.MANUFACTURER + " " + this.f4864v.f5296a.f5274e).equalsIgnoreCase(Build.MODEL)) {
                    this.f4823F.f4704d = Build.MODEL;
                } else {
                    this.f4823F.f4704d = Build.MANUFACTURER + " " + this.f4864v.f5296a.f5274e + C4233j.f14396s + Build.MODEL + C4233j.f14397t;
                }
            }
            if (!(this.f4864v.f5296a.f5273d == null || this.f4864v.f5296a.f5273d.equals(BuildConfig.FLAVOR))) {
                this.f4868z.f4747i = this.f4864v.f5296a.f5273d + getString(C1082R.string.size_panel);
            }
            this.f4868z.f4746h = this.f4864v.f5296a.f5276g;
            if (this.f4864v.f5296a.f5276g != null && this.f4864v.f5296a.f5276g.equals(BuildConfig.FLAVOR)) {
                this.f4868z.f4746h = null;
            }
            this.f4825H = new C1403m(this);
            if (!(this.f4864v.f5296a.f5277h == null || this.f4864v.f5296a.f5277h.equals(BuildConfig.FLAVOR))) {
                this.f4825H.f4794c = this.f4864v.f5296a.f5277h + getActivity().getString(C1082R.string.ke);
            }
            this.f4825H.f4795d = this.f4864v.f5296a.f5279j;
            if (this.f4826I == null) {
                this.f4826I = new C1405o(this);
            }
            this.f4826I.f4809e = this.f4864v.f5296a.f5282m;
            this.f4826I.f4807c = this.f4864v.f5296a.f5280k;
            this.f4826I.f4808d = this.f4864v.f5296a.f5281l;
            if (getActivity().getPackageManager().hasSystemFeature("android.hardware.nfc")) {
                this.f4826I.f4810f = getString(C1082R.string.support);
            } else {
                this.f4826I.f4810f = getString(C1082R.string.nonsupport);
            }
            this.f4821D.f4726e = this.f4864v.f5296a.f5287r;
            this.f4821D.f4727f = this.f4864v.f5296a.f5288s;
            this.f4821D.f4728g = this.f4864v.f5296a.f5289t;
            Methods.editSharedPreferences("pre_dev_tag", true);
            Methods.editSharedPreferences("pre_dev_brand", this.f4823F.f4703c);
            Methods.editSharedPreferences("pre_dev_model", this.f4823F.f4704d);
            Methods.editSharedPreferences("pre_dev_cpu_model", this.f4823F.f4706f);
            Methods.editSharedPreferences("pre_dev_cpu_processor", this.f4866x.f4714c);
            Methods.editSharedPreferences("pre_dev_cpu_hardware", this.f4866x.f4716e);
            Methods.editSharedPreferences("pre_dev_videocapture", this.f4821D.f4726e);
            Methods.editSharedPreferences("pre_dev_video_photograph", this.f4821D.f4727f);
            Methods.editSharedPreferences("pre_dev_camerasensor", this.f4821D.f4728g);
            Methods.editSharedPreferences("pre_dev_bluetooth", this.f4826I.f4809e);
            Methods.editSharedPreferences("pre_dev_transgps", this.f4826I.f4807c);
            Methods.editSharedPreferences("pre_dev_WIFI", this.f4826I.f4808d);
            Methods.editSharedPreferences("pre_dev_sfspecification", this.f4825H.f4795d);
            Methods.editSharedPreferences("pre_dev_sf_weight", this.f4825H.f4794c);
            Methods.editSharedPreferences("pre_dev_gpusize", this.f4868z.f4747i);
            Methods.editSharedPreferences("pre_dev_gpu_material", this.f4868z.f4746h);
            Methods.sendInnerBroadcast(getContext(), "com.antutu.benchmark.update.DEVICE_INFO");
            m5513K();
        } catch (Exception e) {
        }
    }

    private void m5513K() {
        this.f4844b.clear();
        m5572c();
        m5547l();
        m5549m();
        this.f4857o.notifyDataSetChanged();
    }

    private void m5516a(int i) {
        ((C1398h) this.f4844b.get(i)).f4754b.m4892a(this.f4824G.m5491a());
        this.f4857o.notifyDataSetChanged();
    }

    private void m5517a(int i, String str) {
        C1129l c1129l = ((C1398h) this.f4844b.get(i)).f4754b;
        this.f4820C.f4758c = str;
        c1129l.m4892a(this.f4820C.m5483a());
        this.f4857o.notifyDataSetChanged();
    }

    private void m5521a(C1526g c1526g) {
        ArrayList a = c1526g.m6071a();
        for (int i = 0; i < a.size(); i++) {
            DevAdvFactor devAdvFactor = (DevAdvFactor) a.get(i);
            devAdvFactor.getType();
            String softaid = devAdvFactor.getSoftaid();
            devAdvFactor = (DevAdvFactor) a.get(i);
            if (C1523d.f5230a[0].equals(softaid)) {
                this.f4823F.m5467a(null, devAdvFactor);
            } else if (C1523d.f5230a[1].equals(softaid)) {
                this.f4819B.m5499a(null, devAdvFactor);
            } else if (C1523d.f5230a[2].equals(softaid)) {
                this.f4866x.m5472a(null, devAdvFactor);
            } else if (C1523d.f5230a[3].equals(softaid)) {
                this.f4868z.m5479a(null, devAdvFactor);
            } else if (C1523d.f5230a[4].equals(softaid)) {
                this.f4821D.m5475a(null, devAdvFactor);
            } else if (C1523d.f5230a[5].equals(softaid)) {
                this.f4824G.m5493a(null, devAdvFactor);
            } else if (C1523d.f5230a[6].equals(softaid)) {
                this.f4825H.m5496a(null, devAdvFactor);
            } else if (C1523d.f5230a[7].equals(softaid)) {
                this.f4818A.m5488a(null, devAdvFactor);
            } else if (C1523d.f5230a[8].equals(softaid)) {
                this.f4826I.m5502a(null, devAdvFactor);
            } else if (C1523d.f5230a[9].equals(softaid)) {
                this.f4820C.m5485a(null, devAdvFactor);
            } else if (C1523d.f5230a[10].equals(softaid)) {
            }
        }
        m5513K();
    }

    private void m5522a(String str) {
        int size = this.f4844b.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (((C1398h) this.f4844b.get(i)).m5480a() == 10) {
                    m5517a(i, str);
                }
            }
        }
    }

    private String[] m5524a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        for (int i = 0; i < strArr2.length; i++) {
            if (i < strArr.length) {
                strArr2[i] = strArr[i];
            } else {
                strArr2[i] = str;
            }
        }
        return strArr2;
    }

    private String m5526b(String str) {
        try {
            return (str.equals("pyramid") && Build.DEVICE.equals("pyramid") && Build.MANUFACTURER.equals("HTC") && Build.PRODUCT.equals("htc_pyramid")) ? "Snapdragon MSM8260 (Cortex A8)" : str.equals("Tegra 2 Development System") ? "NVIDIA Tegra 2 (Dual-Core Cortex A9)" : str.startsWith("OMAP4430 ") ? "TI OMAP4430 (Cortex A9)" : str.startsWith("OMAP4460 ") ? "TI OMAP4460 (Cortex A9)" : str;
        } catch (Exception e) {
            return str;
        }
    }

    private void m5527b(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                try {
                    this.f4857o.notifyDataSetChanged();
                } catch (Exception e) {
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m5549m();
                this.f4857o.notifyDataSetChanged();
            default:
        }
    }

    private String m5530c(String str) {
        for (int i = 0; i < this.f4842Y.size(); i++) {
            C1377a c1377a = (C1377a) this.f4842Y.get(i);
            if (c1377a.f4682a.equals(Build.MODEL)) {
                if (c1377a.f4683b == 1) {
                    this.f4866x.f4719h = "4+4";
                } else if (c1377a.f4683b == 2) {
                    this.f4866x.f4719h = MessageService.MSG_DB_NOTIFY_CLICK;
                }
            }
        }
        return this.f4866x.f4719h;
    }

    private void m5531c(int i) {
        try {
            if (this.f4862t != null) {
                if (i == 0) {
                    this.f4863u = true;
                    this.ag.postDelayed(this.ah, 5000);
                } else if (i == 1) {
                    this.f4862t.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
        }
    }

    private String m5534d(int i) {
        String str = i + " ";
        switch (i) {
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return str + " (Android 2.3.3)";
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return str + " (Android 3.0)";
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                return str + " (Android 3.1)";
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return str + " (Android 3.2)";
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return str + " (Android 4.0)";
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return str + " (Android 4.0.3)";
            case SpdyProtocol.CUSTOM /*16*/:
                return str + " (Android 4.1.x)";
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return str + " (Android 4.2.x)";
            case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                return str + " (Android 4.3.x)";
            case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
            case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                return str + " (Android 4.4.x)";
            case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                return str + " (Android 5.0)";
            default:
                return str;
        }
    }

    private void m5537f() {
        this.f4826I.f4811g = this.ab;
        m5513K();
    }

    private void m5540h() {
        int size = this.f4844b.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (((C1398h) this.f4844b.get(i)).m5480a() == 6) {
                    m5516a(i);
                }
            }
        }
    }

    private void m5542i() {
        if (isAdded()) {
            try {
                this.f4827J = (ConnectivityManager) getActivity().getSystemService("connectivity");
                this.f4828K = this.f4827J.getActiveNetworkInfo();
            } catch (Exception e) {
                this.f4820C.f4758c = "No Access";
            }
        }
    }

    private void m5544j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("com.antutu.device_loc_action");
        getActivity().getApplicationContext().registerReceiver(this.ac, intentFilter);
    }

    private C1392b m5545k() {
        this.f4823F = new C1392b(this);
        this.f4823F.f4709i = this.f4821D.f4725d;
        this.f4823F.f4703c = Build.BRAND;
        this.f4823F.f4706f = this.f4866x.m5471a();
        int indexOf = this.f4823F.f4706f.indexOf("@");
        if (indexOf != -1) {
            this.f4823F.f4706f = this.f4823F.f4706f.substring(0, indexOf);
        }
        this.f4823F.f4707g = this.f4868z.f4742d;
        this.f4823F.f4705e = this.f4818A.f4762c;
        if (BuildProperties.getInstance().containsKey("ro.yunos.version") && this.f4856n.length >= 3) {
            this.f4856n[2] = getString(C1082R.string.yunos);
        }
        this.f4823F.f4708h = this.f4868z.f4744f;
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        MLog.m6865d("SSSSSSSS", "brand:" + str + "---modelTemp:" + str2);
        if (str.equals("Xiaomi") && (str2.equals("2013022") || str2.equals("2013023"))) {
            this.f4823F.f4704d = "HongMi";
        } else {
            this.f4823F.f4704d = Build.MODEL;
        }
        this.f4823F.f4710j = Utils.getImeiCode(getActivity());
        return this.f4823F;
    }

    private void m5547l() {
        C1398h c1398h = new C1398h(this, this.f4856n, this.f4831N);
        c1398h.m5482a(getString(this.f4829L[11]));
        c1398h.m5481a(0);
        this.f4844b.add(c1398h);
        c1398h = new C1398h(this, this.f4851i, this.f4832O);
        c1398h.m5482a(getString(this.f4829L[6]));
        c1398h.m5481a(2);
        this.f4844b.add(c1398h);
        int indexOf = this.f4866x.f4716e.indexOf("@");
        if (indexOf != -1) {
            this.f4866x.f4716e = this.f4866x.f4716e.substring(0, indexOf);
        }
        c1398h = new C1398h(this, this.f4847e, this.f4833P);
        c1398h.m5482a(getString(this.f4829L[2]));
        c1398h.m5481a(3);
        this.f4844b.add(c1398h);
        c1398h = new C1398h(this, this.f4848f, this.f4834Q);
        c1398h.m5482a(getString(this.f4829L[3]));
        c1398h.m5481a(4);
        this.f4844b.add(c1398h);
        c1398h = new C1398h(this, this.f4853k, this.f4835R);
        c1398h.m5482a(getString(this.f4829L[8]));
        c1398h.m5481a(5);
        this.f4844b.add(c1398h);
        c1398h = new C1398h(this, this.f4855m, this.f4836S);
        c1398h.m5482a(getString(this.f4829L[10]));
        c1398h.m5481a(6);
        this.f4844b.add(c1398h);
        if (this.f4825H != null) {
            c1398h = new C1398h(this, this.f4849g, this.f4837T);
            c1398h.m5482a(getString(this.f4829L[4]));
            c1398h.m5481a(7);
            this.f4844b.add(c1398h);
        }
        c1398h = new C1398h(this, this.f4846d, this.f4838U);
        c1398h.m5482a(getString(this.f4829L[1]));
        c1398h.m5481a(8);
        this.f4844b.add(c1398h);
        if (this.f4826I != null) {
            c1398h = new C1398h(this, this.f4850h, this.f4839V);
            c1398h.m5482a(getString(this.f4829L[5]));
            c1398h.m5481a(9);
            this.f4844b.add(c1398h);
        }
        c1398h = new C1398h(this, this.f4852j, this.f4840W);
        c1398h.m5482a(getString(this.f4829L[7]));
        c1398h.m5481a(10);
        this.f4844b.add(c1398h);
        c1398h = new C1398h(this, this.f4854l, this.f4841X);
        c1398h.m5482a(getString(this.f4829L[9]));
        c1398h.m5481a(11);
        this.f4844b.add(c1398h);
    }

    private void m5549m() {
        this.f4857o.m4933a();
        for (int i = 0; i < this.f4844b.size(); i++) {
            if (((C1398h) this.f4844b.get(i)).f4754b.f3801a.size() != 0) {
                this.f4857o.m4934a(((C1398h) this.f4844b.get(i)).f4755c, ((C1398h) this.f4844b.get(i)).f4754b);
            }
        }
    }

    private void m5552n() {
        this.f4831N = new C1129l(this.a, this.f4856n, this.f4823F.m5468a(), this.f4857o);
        this.f4832O = new C1129l(this.a, this.f4851i, this.f4819B.m5497a(), this.f4857o);
        this.f4833P = new C1129l(this.a, this.f4847e, this.f4866x.m5470b(), this.f4857o);
        this.f4834Q = new C1129l(this.a, this.f4848f, this.f4868z.m5477a(), this.f4857o);
        this.f4835R = new C1129l(this.a, this.f4853k, this.f4821D.m5473a(), this.f4857o);
        this.f4836S = new C1129l(this.a, this.f4855m, this.f4824G.m5491a(), this.f4857o);
        if (this.f4825H != null) {
            this.f4837T = new C1129l(this.a, this.f4849g, this.f4825H.m5494a(), this.f4857o);
            this.f4830M.add(this.f4837T);
        }
        this.f4838U = new C1129l(this.a, this.f4846d, this.f4818A.m5486a(), this.f4857o);
        if (this.f4826I != null) {
            this.f4839V = new C1129l(this.a, this.f4850h, this.f4826I.m5500a(), this.f4857o);
            this.f4830M.add(this.f4839V);
        }
        this.f4840W = new C1129l(this.a, this.f4852j, this.f4820C.m5483a(), this.f4857o);
        this.f4841X = new C1129l(this.a, this.f4854l, this.f4822E.m5489a(), this.f4857o);
        this.f4830M.add(this.f4831N);
        this.f4830M.add(this.f4832O);
        this.f4830M.add(this.f4833P);
        this.f4830M.add(this.f4834Q);
        this.f4830M.add(this.f4835R);
        this.f4830M.add(this.f4836S);
        this.f4830M.add(this.f4838U);
        this.f4830M.add(this.f4840W);
        this.f4830M.add(this.f4841X);
    }

    private void m5553o() {
        this.f4845c = getResources().getStringArray(C1082R.array.device);
        this.f4846d = getResources().getStringArray(C1082R.array.dev_os);
        this.f4847e = getResources().getStringArray(C1082R.array.dev_cpu);
        this.f4848f = getResources().getStringArray(C1082R.array.dev_gpu);
        this.f4849g = getResources().getStringArray(C1082R.array.dev_surface);
        this.f4850h = getResources().getStringArray(C1082R.array.dev_transfer);
        this.f4851i = getResources().getStringArray(C1082R.array.dev_storager);
        this.f4852j = getResources().getStringArray(C1082R.array.dev_net);
        this.f4853k = getResources().getStringArray(C1082R.array.dev_camera);
        this.f4854l = getResources().getStringArray(C1082R.array.dev_others);
        this.f4855m = getResources().getStringArray(C1082R.array.dev_power);
        this.f4856n = getResources().getStringArray(C1082R.array.dev_basic);
        this.f4844b.clear();
        try {
            m5563t();
            m5507E();
            m5510H();
            m5509G();
            m5556p();
            m5564u();
            m5508F();
            m5545k();
            m5569z();
            this.f4820C = m5557q();
        } catch (IOException e) {
        }
        m5511I();
    }

    private void m5556p() {
        this.f4826I = new C1405o(this);
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.nfc")) {
            this.f4826I.f4810f = getString(C1082R.string.support);
        } else {
            this.f4826I.f4810f = getString(C1082R.string.nonsupport);
        }
        if (isAdded()) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MsgConstant.KEY_LOCATION_PARAMS, 0);
            this.f4826I.f4811g = sharedPreferences.getString("loc", null);
        }
    }

    private C1399i m5557q() {
        C1399i c1399i = new C1399i(this);
        try {
            this.f4827J = (ConnectivityManager) getActivity().getSystemService("connectivity");
            this.f4828K = this.f4827J.getActiveNetworkInfo();
            String str = BuildConfig.FLAVOR;
            str = (this.f4828K == null || !this.f4828K.isAvailable()) ? "No Access" : this.f4828K.getTypeName();
            c1399i.f4758c = str;
        } catch (Exception e) {
        }
        return c1399i;
    }

    private void m5559r() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DownloadsService.ACTION_DOWNLOAD_MESSAGE);
            this.a.registerReceiver(this.ad, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m5562s() {
        new C13875(this).start();
    }

    private void m5563t() {
        this.f4866x = new C1393c(this);
        try {
            float maxDef;
            float minDef;
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            String j = C1503b.m5915c().m5952j();
            Object obj = null;
            int i = 0;
            for (int i2 = 1; i2 < 100; i2++) {
                CharSequence readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("Processor")) {
                    this.f4866x.f4714c = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("BogoMIPS")) {
                    this.f4866x.f4715d = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("Hardware")) {
                    this.f4866x.f4716e = m5526b(readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim());
                }
                if (readLine.contains("vendor_id")) {
                    this.f4866x.f4717f = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (this.f4866x.f4717f.equals("GenuineIntel") && readLine.contains("model name")) {
                    this.f4866x.f4716e = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("cpu cores")) {
                    i = Integer.parseInt(readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim());
                }
                if (readLine.contains("CPU part")) {
                    obj = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("model name")) {
                    this.f4866x.f4714c = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (!this.f4860r && readLine.contains("CPU architecture")) {
                    String toLowerCase = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim().toLowerCase();
                    if (toLowerCase.toLowerCase().contains("arch64")) {
                        this.f4860r = true;
                    } else if (toLowerCase.trim().equals(MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                        this.f4860r = true;
                    }
                }
                if (!this.f4860r && readLine.startsWith(com.taobao.accs.common.Constants.KEY_FLAGS) && Pattern.matches("^flags\\s+:\\s+.*\\slm\\s.*", readLine)) {
                    this.f4860r = true;
                }
            }
            lineNumberReader.close();
            StringBuilder stringBuilder;
            C1393c c1393c;
            if (this.f4860r) {
                stringBuilder = new StringBuilder();
                c1393c = this.f4866x;
                c1393c.f4720i = stringBuilder.append(c1393c.f4720i).append(getString(C1082R.string.bit64)).toString();
                if (j.contains("ARMv6")) {
                    j = j.replace("ARMv6", "ARMv8");
                }
            } else {
                stringBuilder = new StringBuilder();
                c1393c = this.f4866x;
                c1393c.f4720i = stringBuilder.append(c1393c.f4720i).append(getString(C1082R.string.bit32)).toString();
            }
            if (!this.f4860r && ("0xd07".equals(r4) || "0xd03".equals(r4))) {
                this.f4866x.f4720i = getString(C1082R.string.bit64);
            }
            if (j.length() > 1) {
                if (this.f4866x.f4714c.contains("Intel") && this.f4866x.f4714c.contains("Atom")) {
                    this.f4866x.f4719h = i + BuildConfig.FLAVOR;
                } else {
                    this.f4866x.f4719h = jni.getCpuCount() + BuildConfig.FLAVOR;
                    this.f4866x.f4714c = j;
                }
            }
            long cPUFrequency = Utils.getCPUFrequency(true);
            long cPUFrequency2 = Utils.getCPUFrequency(false);
            if (cPUFrequency == 0 && cPUFrequency == 0) {
                maxDef = ((float) jni.getMaxDef()) / 1000.0f;
                minDef = ((float) jni.getMinDef()) / 1000.0f;
            } else {
                maxDef = ((float) cPUFrequency) / 1000.0f;
                minDef = ((float) cPUFrequency2) / 1000.0f;
            }
            if (maxDef <= 0.0f || minDef <= 0.0f) {
                if (this.f4866x.f4715d.length() > 0) {
                    this.f4866x.f4718g = this.f4866x.f4715d + " MHz";
                }
            } else if (minDef < maxDef) {
                this.f4866x.f4718g = minDef + " ~ " + maxDef + " MHz";
            } else {
                this.f4866x.f4718g = maxDef + " MHz";
            }
            this.f4866x.f4719h = m5530c(this.f4866x.f4714c);
            j = SpecialHelper.updateFilterCoreNum(getActivity(), this.f4866x.f4716e);
            if (j != null) {
                this.f4866x.f4719h = j;
            }
        } catch (FileNotFoundException e) {
            this.f4866x = null;
        }
    }

    private void m5564u() {
        this.f4867y = new C1395e(this);
        this.f4867y.f4734e = m5566w();
        this.f4867y.f4732c = m5565v();
        this.f4867y.f4733d = Utils.getImeiText(getActivity());
    }

    private String m5565v() {
        return Build.MODEL;
    }

    private String m5566w() {
        return Build.BRAND;
    }

    private String m5567x() {
        return C1516b.m6034h();
    }

    private String m5568y() {
        return C1516b.m6029f() + " dpi";
    }

    private void m5569z() {
        this.f4822E = new C1401k(this, getActivity());
        List sensorList = ((SensorManager) getActivity().getSystemService("sensor")).getSensorList(-1);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = (Sensor) sensorList.get(i);
            String str = sensor.getVendor() + " " + sensor.getName();
            switch (sensor.getType()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f4822E.f4768c = str;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f4822E.f4778m = str;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f4822E.f4780o = str;
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    this.f4822E.f4773h = str;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    this.f4822E.f4776k = str;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    this.f4822E.f4781p = str;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    this.f4822E.f4782q = str;
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    this.f4822E.f4772g = str;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    this.f4822E.f4777l = str;
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    this.f4822E.f4784s = str;
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    this.f4822E.f4783r = str;
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    this.f4822E.f4769d = str;
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    this.f4822E.f4779n = str;
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    this.f4822E.f4770e = str;
                    break;
                case SpdyProtocol.CUSTOM /*16*/:
                    this.f4822E.f4774i = str;
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    this.f4822E.f4785t = str;
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    this.f4822E.f4787v = str;
                    break;
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    this.f4822E.f4786u = str;
                    break;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    this.f4822E.f4771f = str;
                    break;
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                    this.f4822E.f4775j = str;
                    break;
                default:
                    break;
            }
        }
        m5503A();
        m5506D();
        m5505C();
    }

    public void m5570a(Object obj) {
        super.m5396a(obj);
    }

    public void m5571a(String str, String str2) {
        for (int i = 0; i < this.f4830M.size(); i++) {
            try {
                ((C1129l) this.f4830M.get(i)).m4891a(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m5572c() {
        this.f4831N.m4893a(this.f4856n, this.f4823F.m5468a());
        this.f4832O.m4893a(this.f4851i, this.f4819B.m5497a());
        this.f4833P.m4893a(this.f4847e, this.f4866x.m5470b());
        this.f4834Q.m4893a(this.f4848f, this.f4868z.m5477a());
        this.f4835R.m4893a(this.f4853k, this.f4821D.m5473a());
        this.f4836S.m4893a(this.f4855m, this.f4824G.m5491a());
        if (this.f4825H != null) {
            if (this.f4837T == null) {
                this.f4837T = new C1129l(this.a, this.f4849g, this.f4825H.m5494a(), this.f4857o);
            } else {
                this.f4837T.m4893a(this.f4849g, this.f4825H.m5494a());
            }
        }
        this.f4838U.m4893a(this.f4846d, this.f4818A.m5486a());
        if (this.f4826I != null) {
            if (this.f4839V == null) {
                this.f4839V = new C1129l(this.a, this.f4850h, this.f4826I.m5500a(), this.f4857o);
            } else {
                this.f4839V.m4893a(this.f4850h, this.f4826I.m5500a());
            }
        }
        this.f4840W.m4893a(this.f4852j, this.f4820C.m5483a());
        this.f4841X.m4893a(this.f4854l, this.f4822E.m5489a());
    }

    public void m5573d() {
        try {
            if (NetUtils.isNetworkAvailable()) {
                String str = Build.BRAND;
                String str2 = Build.MODEL;
                String language = getResources().getConfiguration().locale.getLanguage();
                String country = getResources().getConfiguration().locale.getCountry();
                country = (language == null || !language.contains("zh")) ? language : (country == null || country.contains("CN")) ? "cn" : "tw";
                String h = C1516b.m6034h();
                String i = C1516b.m6035i();
                String j = C1516b.m6036j();
                String str3 = Build.DEVICE;
                String str4 = Build.MANUFACTURER;
                String j2 = C1503b.m5915c().m5952j();
                String cPUSerial = Utils.getCPUSerial();
                String versionCode = Utils.getVersionCode();
                String g = C1516b.m6031g();
                String cPURev = IO.getCPURev();
                String localMacAddressFromIp = Utils.getLocalMacAddressFromIp(getActivity());
                String valueOf = String.valueOf(IO.getRamTotalSize());
                int maxSet = jni.getMaxSet();
                if (maxSet == 0) {
                    maxSet = jni.getMaxDef();
                }
                language = maxSet + BuildConfig.FLAVOR;
                String str5 = this.f4866x.f4716e;
                MLog.m6864d("cpuid--------" + cPUSerial);
                HashMap hashMap = new HashMap();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("format=").append("json").append("&").append("brand=").append(str).append("&").append("model=").append(str2).append("&").append("lan=").append(country).append("&").append("resolution=").append(h).append("&").append("glVendor=").append(i).append("&").append("glRenderer=").append(j).append("&").append("device=").append(str3).append("&").append("manufacturer=").append(str4).append("&").append("cpuinfo=").append(j2).append("&").append("cupid=").append(cPUSerial).append("&").append("softversion=").append(versionCode).append("&").append("cpuMax=").append(language).append("&").append("ramsize=").append(valueOf).append("&").append("str10=").append(localMacAddressFromIp).append("&").append("str2=").append(str5 + cPURev);
                if (g != null) {
                    stringBuilder.append("&gpufrequency=").append(g);
                }
                hashMap.put("gpv", jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR));
                DownloadJob downloadJob = new DownloadJob(this.a, "http://autovote.antutu.net/proMoudule/index.php?action=rvAntuModelUrlnew&data=1", new C1528h(), hashMap, 20);
                downloadJob.setDownloadJobListener(new C13886(this));
                downloadJob.start();
                hashMap = new HashMap();
                language = Utils.getVersionCode();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("oem=").append(String.valueOf(C1503b.m5915c().m5954k())).append("&lan=").append(C1523d.m6061b()).append("&softid=123").append("&adversion=" + Utils.getAdVersion(this.a) + BuildConfig.FLAVOR).append("&aid=7").append("&format=json").append("&softversion=").append(language).append("&imei=").append(C1503b.m5915c().m5925a(getActivity(), false)).append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&device=").append(Build.DEVICE).append("&str1=").append(C1503b.m5915c().m5961n());
                hashMap.put("gpv", jni.getDataSafe(stringBuilder2.toString(), BuildConfig.FLAVOR));
                downloadJob = new DownloadJob(this.a, "http://autovote.antutu.net/proMoudule/index.php?action=adinfo&data=1", new C1526g(), hashMap, 20);
                downloadJob.setDownloadJobListener(new C13897(this));
                downloadJob.start();
            }
        } catch (Exception e) {
        }
    }

    public void m5574e() {
        if (this.f4858p > 0) {
            try {
                float maxDef;
                float minDef;
                Map map = (Map) this.f4862t.getItem(this.f4858p);
                int maxSet = jni.getMaxSet();
                int minSet = jni.getMinSet();
                if (maxSet == 0 && maxSet == 0) {
                    maxDef = ((float) jni.getMaxDef()) / 1000.0f;
                    minDef = ((float) jni.getMinDef()) / 1000.0f;
                } else {
                    maxDef = ((float) maxSet) / 1000.0f;
                    minDef = ((float) minSet) / 1000.0f;
                }
                if (maxDef <= 0.0f || minDef <= 0.0f) {
                    LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
                    String str = BuildConfig.FLAVOR;
                    int i = 1;
                    while (i < 100) {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains("BogoMIPS")) {
                            str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                            break;
                        } else {
                            i++;
                        }
                    }
                    lineNumberReader.close();
                    map.put("CONTENT", str + " MHz");
                } else if (minDef < maxDef) {
                    map.put("CONTENT", minDef + " ~ " + maxDef + " MHz");
                } else {
                    map.put("CONTENT", maxDef + " MHz");
                }
            } catch (Exception e) {
            }
        }
        try {
            ((ActivityManager) getActivity().getSystemService("activity")).getMemoryInfo(new MemoryInfo());
            ((Map) this.f4862t.getItem(this.f4859q)).put("CONTENT", String.format("%.01f / %.01f MB", new Object[]{Double.valueOf(((double) (r1.availMem >> 10)) / 1024.0d), Double.valueOf(((double) IO.getRamTotalSize()) / 1024.0d)}));
            ((Map) this.f4862t.getItem(this.f4859q + 1)).put("CONTENT", String.format("%.01f / %.01f MB", new Object[]{Double.valueOf(IO.GetSDCardAvailableSize()), Double.valueOf(IO.GetSDCardTotalSize())}));
            if (this.f4861s) {
                ((Map) this.f4862t.getItem(this.f4859q + 2)).put("CONTENT", String.format("%.01f / %.01f MB", new Object[]{Double.valueOf(IO.GetSDCardExAvailableSize()), Double.valueOf(IO.GetSDCardExTotalSize())}));
            }
        } catch (Exception e2) {
        }
        this.ag.sendEmptyMessage(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MLog.m6871i(BuildConfig.FLAVOR, "hzd, DeviceInfoFragment, onCreate...");
        this.f4860r = C1503b.m5915c().m5946f();
        this.f4842Y = C1378d.m5455a(ABenchmarkApplication.getContext()).m5456a();
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService("sensor");
        int[] iArr = new int[]{1, 9, 4, 5, 2, 3, 6, 8, 13, 12, 10, 11, 15, 20, 18, 19, 21, 14, 17};
        this.ae.clear();
        int i = 0;
        while (i < iArr.length) {
            try {
                SensorEventListener c1396f = new C1396f(this, i);
                this.ae.add(c1396f);
                sensorManager.registerListener(c1396f, sensorManager.getDefaultSensor(iArr[i]), 3);
                i++;
            } catch (Exception e) {
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.list, null);
        this.f4865w = (DragListView) inflate.findViewById(C1082R.id.list);
        this.f4865w.setonRefreshListener(new C13864(this));
        this.f4865w.setAdapter(this.f4857o);
        m5562s();
        try {
            View inflate2 = layoutInflater.inflate(C1082R.layout.ad_layout, null);
            ((ViewGroup) inflate2.findViewById(C1082R.id.layoutAD)).addView(new AdWebView(getActivity(), "4201", C1692R.xml.default_settings));
            this.f4865w.addHeaderView(inflate2);
        } catch (Exception e) {
        }
        m5559r();
        return inflate;
    }

    public void onDestroyView() {
        try {
            this.a.unregisterReceiver(this.ad);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }

    public void onStop() {
        super.onStop();
    }
}
