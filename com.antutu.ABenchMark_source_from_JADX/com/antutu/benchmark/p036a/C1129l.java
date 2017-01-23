package com.antutu.benchmark.p036a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.CpuInfoActivity;
import com.antutu.benchmark.activity.MultiTouchActivity;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.NetUtils;
import com.antutu.utils.PointMark;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.widget.WebBrowserActivity;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.l */
public class C1129l extends BaseAdapter {
    public ArrayList<String> f3801a;
    public ArrayList<String> f3802b;
    public List<String> f3803c;
    private String[] f3804d;
    private Context f3805e;
    private C1171r f3806f;

    /* renamed from: com.antutu.benchmark.a.l.1 */
    class C11231 implements OnClickListener {
        final /* synthetic */ C1129l f3780a;

        C11231(C1129l c1129l) {
            this.f3780a = c1129l;
        }

        public void onClick(View view) {
            try {
                PointMark.getInstance(this.f3780a.f3805e).pointThis("event_switch_cpudetail");
                Intent intent = new Intent();
                intent.setClass(this.f3780a.f3805e, CpuInfoActivity.class);
                this.f3780a.f3805e.startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.l.2 */
    class C11242 implements OnClickListener {
        final /* synthetic */ String f3781a;
        final /* synthetic */ boolean f3782b;
        final /* synthetic */ C1128b f3783c;
        final /* synthetic */ C1129l f3784d;

        C11242(C1129l c1129l, String str, boolean z, C1128b c1128b) {
            this.f3784d = c1129l;
            this.f3781a = str;
            this.f3782b = z;
            this.f3783c = c1128b;
        }

        public void onClick(View view) {
            if (NetUtils.isNetworkAvailable()) {
                PointMark.getInstance(this.f3784d.f3805e).pointThis(this.f3781a);
                C1127a c1127a = (C1127a) view.getTag();
                String str = c1127a.f3788b;
                InfocUtil.antutu_click_infotab(this.f3784d.f3805e, 1, str);
                if (this.f3782b) {
                    Methods.openApp(this.f3784d.f3805e, str);
                    return;
                } else if (!this.f3784d.f3805e.getString(C1082R.string.downloading_status).equals(this.f3783c.f3790a.getText().toString())) {
                    WebBrowserActivity.openURL(this.f3784d.f3805e, c1127a.f3787a, BuildConfig.FLAVOR);
                    return;
                } else if (c1127a.f3787a.startsWith("http://appdownloadwithtitle2.")) {
                    String replace = c1127a.f3787a.replace("appdownloadwithtitle2.", BuildConfig.FLAVOR);
                    int indexOf = replace.indexOf(".");
                    if (indexOf > 0) {
                        replace = "http://" + replace.substring(indexOf + 1);
                    }
                    DownloadsService.stopDownload(this.f3784d.f3805e, replace);
                    return;
                } else if (c1127a.f3787a.endsWith(".apk")) {
                    DownloadsService.stopDownload(this.f3784d.f3805e, c1127a.f3787a);
                    this.f3783c.f3790a.setText(this.f3784d.f3805e.getString(C1082R.string.continue_status));
                    return;
                } else {
                    WebBrowserActivity.openURL(this.f3784d.f3805e, c1127a.f3787a, BuildConfig.FLAVOR);
                    return;
                }
            }
            Methods.showToast(this.f3784d.f3805e, (int) C1082R.string.prompt_net, 0);
        }
    }

    /* renamed from: com.antutu.benchmark.a.l.3 */
    class C11253 implements OnClickListener {
        final /* synthetic */ C1129l f3785a;

        C11253(C1129l c1129l) {
            this.f3785a = c1129l;
        }

        public void onClick(View view) {
            PointMark.getInstance(this.f3785a.f3805e).pointThis("event_switch_cpudetail");
            Intent intent = new Intent();
            intent.setClass(this.f3785a.f3805e, CpuInfoActivity.class);
            this.f3785a.f3805e.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.a.l.4 */
    class C11264 implements OnClickListener {
        final /* synthetic */ C1129l f3786a;

        C11264(C1129l c1129l) {
            this.f3786a = c1129l;
        }

        public void onClick(View view) {
            PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_SCREEN_MONITOR);
            this.f3786a.f3805e.startActivity(new Intent(this.f3786a.f3805e, MultiTouchActivity.class));
        }
    }

    /* renamed from: com.antutu.benchmark.a.l.a */
    class C1127a {
        String f3787a;
        String f3788b;
        final /* synthetic */ C1129l f3789c;

        C1127a(C1129l c1129l, String str, String str2) {
            this.f3789c = c1129l;
            this.f3787a = str;
            this.f3788b = str2;
        }
    }

    /* renamed from: com.antutu.benchmark.a.l.b */
    class C1128b {
        public Button f3790a;
        RelativeLayout f3791b;
        TextView f3792c;
        TextView f3793d;
        ImageView f3794e;
        RelativeLayout f3795f;
        Button f3796g;
        View f3797h;
        View f3798i;
        View f3799j;
        final /* synthetic */ C1129l f3800k;

        C1128b(C1129l c1129l) {
            this.f3800k = c1129l;
        }
    }

    public C1129l() {
        this.f3801a = new ArrayList();
        this.f3802b = new ArrayList();
        this.f3803c = new ArrayList();
    }

    public C1129l(Context context, String[] strArr, String[] strArr2, C1171r c1171r) {
        this.f3801a = new ArrayList();
        this.f3802b = new ArrayList();
        this.f3803c = new ArrayList();
        this.f3805e = context;
        this.f3804d = strArr;
        this.f3801a = m4888b(strArr2);
        this.f3806f = c1171r;
    }

    private void m4886a(View view, C1128b c1128b, int i) {
        if (!(c1128b.f3793d == null || this.f3801a == null || !(this.f3801a.get(i) instanceof String))) {
            String str = (String) this.f3801a.get(i);
            if (str.equals("btn")) {
                c1128b.f3791b.setVisibility(8);
                c1128b.f3795f.setVisibility(0);
                c1128b.f3797h.setVisibility(8);
                c1128b.f3798i.setVisibility(8);
                c1128b.f3799j.setVisibility(8);
                c1128b.f3790a.setVisibility(8);
            } else if (str.equals("flag_ads")) {
                c1128b.f3791b.setVisibility(8);
                c1128b.f3795f.setVisibility(8);
                c1128b.f3797h.setVisibility(8);
                c1128b.f3798i.setVisibility(8);
                c1128b.f3799j.setVisibility(8);
                c1128b.f3790a.setVisibility(8);
            } else if (str.equals("flag_cpu")) {
                c1128b.f3791b.setVisibility(8);
                c1128b.f3795f.setVisibility(8);
                c1128b.f3797h.setVisibility(8);
                c1128b.f3798i.setVisibility(0);
                c1128b.f3799j.setVisibility(8);
                c1128b.f3790a.setVisibility(8);
                m4887a(c1128b);
            } else if (str.equals("flag_touch")) {
                c1128b.f3791b.setVisibility(8);
                c1128b.f3795f.setVisibility(8);
                c1128b.f3797h.setVisibility(8);
                c1128b.f3798i.setVisibility(8);
                c1128b.f3799j.setVisibility(0);
                c1128b.f3790a.setVisibility(8);
                m4889b(c1128b);
            } else {
                c1128b.f3791b.setVisibility(0);
                c1128b.f3795f.setVisibility(8);
                c1128b.f3797h.setVisibility(8);
                c1128b.f3798i.setVisibility(8);
                c1128b.f3799j.setVisibility(8);
                if (str.indexOf("|") != -1) {
                    CharSequence valueOf = String.valueOf(str.subSequence(0, str.indexOf("||")));
                    String valueOf2 = String.valueOf(str.subSequence(str.indexOf("||") + 2, str.lastIndexOf("||")));
                    InfocUtil.antutu_clickshow_infotab(this.f3805e, 1, valueOf2);
                    str = String.valueOf(str.subSequence(str.lastIndexOf("||") + 2, str.length()));
                    boolean hasInstalled = Methods.hasInstalled(valueOf2);
                    C1127a c1127a = new C1127a(this, str, valueOf2);
                    c1128b.f3790a.setVisibility(0);
                    c1128b.f3793d.setVisibility(8);
                    c1128b.f3790a.setTag(c1127a);
                    if (hasInstalled) {
                        c1128b.f3790a.setText(C1082R.string.open);
                    } else {
                        c1128b.f3790a.setText(valueOf);
                    }
                    try {
                        str = (String) this.f3803c.get(i);
                        if (!(str == null || str.equals(BuildConfig.FLAVOR))) {
                            c1128b.f3790a.setText(str);
                        }
                    } catch (Exception e) {
                    }
                    c1128b.f3790a.setOnClickListener(new C11242(this, valueOf2, hasInstalled, c1128b));
                } else {
                    c1128b.f3793d.setVisibility(0);
                    c1128b.f3793d.setText(str);
                    c1128b.f3790a.setVisibility(8);
                }
            }
        }
        try {
            c1128b.f3792c.setText((CharSequence) this.f3802b.get(i));
        } catch (Exception e2) {
        }
    }

    private void m4887a(C1128b c1128b) {
        ((Button) c1128b.f3798i.findViewById(C1082R.id.btn_core_detail)).setOnClickListener(new C11253(this));
    }

    private ArrayList<String> m4888b(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList();
        this.f3802b.clear();
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!(strArr[i] == null || strArr[i].equals(BuildConfig.FLAVOR))) {
                    arrayList.add(strArr[i]);
                    try {
                        this.f3802b.add(this.f3804d[i]);
                    } catch (Exception e) {
                    }
                }
                i++;
            }
        }
        return arrayList;
    }

    private void m4889b(C1128b c1128b) {
        ((Button) c1128b.f3799j.findViewById(C1082R.id.btn_multi)).setOnClickListener(new C11264(this));
    }

    public ArrayList<String> m4890a() {
        return this.f3801a;
    }

    public void m4891a(String str, String str2) {
        CharSequence substring = new String(str).substring(7);
        int i = 0;
        for (int i2 = 0; i2 < this.f3801a.size(); i2++) {
            String str3 = (String) this.f3801a.get(i2);
            if (str3.contains(substring)) {
                int indexOf = str3.indexOf("||");
                if (indexOf >= 0) {
                    this.f3801a.set(i2, str3.replaceFirst(String.valueOf(str3.subSequence(0, indexOf)), str2));
                    i = 1;
                }
            }
        }
        if (i != 0 && this.f3806f != null) {
            this.f3806f.notifyDataSetChanged();
        }
    }

    public void m4892a(String[] strArr) {
        this.f3801a.clear();
        this.f3801a = m4888b(strArr);
        notifyDataSetChanged();
    }

    public void m4893a(String[] strArr, String[] strArr2) {
        this.f3804d = strArr;
        this.f3801a = m4888b(strArr2);
    }

    public int getCount() {
        return this.f3801a.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1128b c1128b;
        LayoutInflater from = LayoutInflater.from(this.f3805e);
        if (view == null || !(view.getTag() instanceof C1128b)) {
            C1128b c1128b2 = new C1128b(this);
            view = from.inflate(C1082R.layout.detail_info_item, null);
            c1128b2.f3792c = (TextView) view.findViewById(C1082R.id.name);
            c1128b2.f3793d = (TextView) view.findViewById(C1082R.id.detail);
            c1128b2.f3790a = (Button) view.findViewById(C1082R.id.btn_adv_txt);
            c1128b2.f3794e = (ImageView) view.findViewById(C1082R.id.err_img);
            c1128b2.f3791b = (RelativeLayout) view.findViewById(C1082R.id.list_item_container);
            c1128b2.f3795f = (RelativeLayout) view.findViewById(C1082R.id.item_more);
            c1128b2.f3796g = (Button) view.findViewById(C1082R.id.more_info);
            c1128b2.f3796g.setId(i);
            c1128b2.f3798i = view.findViewById(C1082R.id.info_cpu);
            c1128b2.f3799j = view.findViewById(C1082R.id.info_touch);
            c1128b2.f3797h = view.findViewById(C1082R.id.root_tools);
            view.setTag(c1128b2);
            c1128b = c1128b2;
        } else {
            c1128b = (C1128b) view.getTag();
        }
        m4886a(view, c1128b, i);
        view.setPadding(0, 0, 0, 0);
        c1128b.f3796g.setOnClickListener(new C11231(this));
        return view;
    }
}
