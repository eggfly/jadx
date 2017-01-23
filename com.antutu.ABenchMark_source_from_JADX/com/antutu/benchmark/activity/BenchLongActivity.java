package com.antutu.benchmark.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.BenchmarkService;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.service.BenchmarkLongService;
import com.antutu.benchmark.service.BenchmarkLongService.C1607c;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.benchmark.view.p065a.C1646b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Hash;
import com.antutu.utils.Utils;
import com.antutu.utils.library.Titanic;
import com.antutu.utils.library.TitanicTextView;
import com.facebook.ads.AdError;
import com.github.mikephil.charting.data.C2560e;
import com.github.mikephil.charting.data.C2569g;
import com.github.mikephil.charting.data.C2575h;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;
import org.json.JSONObject;

public class BenchLongActivity extends Activity {
    public static final int[] f4039a;
    ListView f4040b;
    View f4041c;
    View f4042d;
    TextView f4043e;
    TitanicTextView f4044f;
    Titanic f4045g;
    Animation f4046h;
    ImageView f4047i;
    TextView f4048j;
    private C1201b f4049k;
    private ArrayList<C1607c> f4050l;

    /* renamed from: com.antutu.benchmark.activity.BenchLongActivity.1 */
    class C11981 implements OnClickListener {
        final /* synthetic */ Button f4032a;
        final /* synthetic */ BenchLongActivity f4033b;

        C11981(BenchLongActivity benchLongActivity, Button button) {
            this.f4033b = benchLongActivity;
            this.f4032a = button;
        }

        public void onClick(View view) {
            this.f4032a.setClickable(false);
            this.f4033b.f4043e.setText(C1082R.string.stopping);
            BenchmarkLongService.m6326b(this.f4033b.getApplicationContext());
        }
    }

    /* renamed from: com.antutu.benchmark.activity.BenchLongActivity.2 */
    class C11992 implements OnClickListener {
        final /* synthetic */ BenchLongActivity f4034a;

        C11992(BenchLongActivity benchLongActivity) {
            this.f4034a = benchLongActivity;
        }

        public void onClick(View view) {
            this.f4034a.m4968a();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.BenchLongActivity.a */
    private class C1200a extends ArrayAdapter<C1646b> {
        final /* synthetic */ BenchLongActivity f4035a;

        public C1200a(BenchLongActivity benchLongActivity, Context context, List<C1646b> list) {
            this.f4035a = benchLongActivity;
            super(context, 0, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return ((C1646b) getItem(i)).m6493a(i, view, getContext());
        }
    }

    /* renamed from: com.antutu.benchmark.activity.BenchLongActivity.b */
    private class C1201b extends BroadcastReceiver {
        final /* synthetic */ BenchLongActivity f4036a;

        private C1201b(BenchLongActivity benchLongActivity) {
            this.f4036a = benchLongActivity;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action.equals("com.antutu.benchmark.update.UI_LONG")) {
                    try {
                        int intExtra = intent.getIntExtra("percent", -1);
                        if (intExtra >= 0) {
                            this.f4036a.f4044f.setText(BuildConfig.FLAVOR + intExtra);
                        }
                        if (intent.getIntExtra("left", -1) > 0) {
                            this.f4036a.f4043e.setText(this.f4036a.getString(C1082R.string.stress_testing, new Object[]{BuildConfig.FLAVOR + intExtra}));
                        }
                    } catch (Exception e) {
                    }
                } else if (action.equals("com.antutu.benchmark.test_long.STOP")) {
                    this.f4036a.getWindow().clearFlags(SpdyProtocol.SLIGHTSSLV2);
                    this.f4036a.finish();
                } else if (action.equals("com.antutu.benchmark.test_long.FINISHED_LONG")) {
                    this.f4036a.getWindow().clearFlags(SpdyProtocol.SLIGHTSSLV2);
                    this.f4036a.m4969b();
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.BenchLongActivity.c */
    public class C1203c implements C1202f {
        final /* synthetic */ BenchLongActivity f4037a;
        private DecimalFormat f4038b;

        public C1203c(BenchLongActivity benchLongActivity) {
            this.f4037a = benchLongActivity;
            this.f4038b = new DecimalFormat("###,###,##0.0");
        }

        public String m4964a(float f, Entry entry, int i, C2621g c2621g) {
            return this.f4038b.format((double) f);
        }
    }

    static {
        f4039a = new int[]{Color.rgb(Downloads.STATUS_RUNNING, MotionEventCompat.ACTION_MASK, Downloads.STATUS_PENDING), Color.rgb(205, 167, C1692R.styleable.AppCompatTheme_spinnerStyle), Color.rgb(MotionEventCompat.ACTION_MASK, 208, 140), Color.rgb(140, 234, MotionEventCompat.ACTION_MASK), Color.rgb(MotionEventCompat.ACTION_MASK, 140, 157), Color.rgb(Constants.COMMAND_ELECTION, 140, 157), Color.rgb(40, 234, MotionEventCompat.ACTION_MASK), Color.rgb(MotionEventCompat.ACTION_MASK, 40, 157), Color.rgb(205, 140, 57), Color.rgb(140, 34, MotionEventCompat.ACTION_MASK), Color.rgb(MotionEventCompat.ACTION_MASK, 140, 57), Color.rgb(5, 140, 157)};
    }

    public BenchLongActivity() {
        this.f4049k = null;
        this.f4050l = null;
        this.f4040b = null;
        this.f4041c = null;
        this.f4042d = null;
        this.f4043e = null;
        this.f4044f = null;
        this.f4045g = new Titanic();
        this.f4046h = null;
        this.f4047i = null;
        this.f4048j = null;
    }

    private String m4965a(int i) {
        String str = BuildConfig.FLAVOR;
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return getString(C1082R.string.stress_cpu_performance);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return getString(C1082R.string.stress_cpu_load);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return getString(C1082R.string.stress_cpu_core_load);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return getString(C1082R.string.stress_cpu_core_freq);
            case SpdyProtocol.QUIC /*4*/:
                return getString(C1082R.string.stress_bat_level);
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return getString(C1082R.string.stress_bat_tempe);
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return getString(C1082R.string.stress_bat_voltage);
            default:
                return str;
        }
    }

    private C2569g m4966b(int i) {
        int i2;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = this.f4050l.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            C1607c c1607c = (C1607c) it.next();
            String format = String.format("%d:%02d", new Object[]{Integer.valueOf(c1607c.f5613i / 60), Integer.valueOf(c1607c.f5613i % 60)});
            if (c1607c.f5613i - i3 >= 15) {
                i3 = c1607c.f5613i;
                arrayList4.add(Integer.valueOf(i3));
                arrayList2.add(format);
                if (c1607c.f5610f > 0) {
                    arrayList3.add(format);
                }
            }
            if (c1607c.f5614j > 0) {
                arrayList.add(format);
            }
        }
        int i4;
        Iterator it2;
        float f;
        int i5;
        C2575h c2575h;
        List arrayList5;
        List arrayList6;
        Iterator it3;
        float intValue;
        Iterator it4;
        float f2;
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                arrayList2 = new ArrayList();
                i4 = 0;
                it2 = this.f4050l.iterator();
                i3 = 0;
                while (it2.hasNext()) {
                    c1607c = (C1607c) it2.next();
                    i3 = c1607c.f5614j > i3 ? c1607c.f5614j : i3;
                }
                it2 = this.f4050l.iterator();
                while (it2.hasNext()) {
                    c1607c = (C1607c) it2.next();
                    if (c1607c.f5614j > 0) {
                        f = (float) ((c1607c.f5614j * 100) / i3);
                        i5 = i4 + 1;
                        arrayList2.add(new Entry(f, i4));
                    } else {
                        i5 = i4;
                    }
                    i4 = i5;
                }
                c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_cpu_performance));
                c2575h.m9843b(1.5f);
                c2575h.m9854a(1.6f);
                c2575h.m9855b(true);
                c2575h.m9824a(Color.rgb(244, 117, 117));
                c2575h.m9800c(f4039a[4]);
                c2575h.m9857i(f4039a[4]);
                c2575h.m9796a(false);
                arrayList5 = new ArrayList();
                arrayList5.add(c2575h);
                return new C2569g(arrayList, arrayList5);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                arrayList = new ArrayList();
                it2 = this.f4050l.iterator();
                i4 = 0;
                while (it2.hasNext()) {
                    c1607c = (C1607c) it2.next();
                    if (i4 >= arrayList4.size()) {
                        c2575h = new C2575h(arrayList, getString(C1082R.string.stress_cpu_load));
                        c2575h.m9843b(1.5f);
                        c2575h.m9854a(1.6f);
                        c2575h.m9855b(true);
                        c2575h.m9824a(Color.rgb(244, 117, 117));
                        c2575h.m9800c(f4039a[3]);
                        c2575h.m9857i(f4039a[3]);
                        c2575h.m9796a(false);
                        arrayList5 = new ArrayList();
                        arrayList5.add(c2575h);
                        return new C2569g(arrayList2, arrayList5);
                    }
                    if (((Integer) arrayList4.get(i4)).intValue() == c1607c.f5613i) {
                        f = (float) c1607c.f5605a;
                        i5 = i4 + 1;
                        arrayList.add(new Entry(f, i4));
                    } else {
                        i5 = i4;
                    }
                    i4 = i5;
                }
                c2575h = new C2575h(arrayList, getString(C1082R.string.stress_cpu_load));
                c2575h.m9843b(1.5f);
                c2575h.m9854a(1.6f);
                c2575h.m9855b(true);
                c2575h.m9824a(Color.rgb(244, 117, 117));
                c2575h.m9800c(f4039a[3]);
                c2575h.m9857i(f4039a[3]);
                c2575h.m9796a(false);
                arrayList5 = new ArrayList();
                arrayList5.add(c2575h);
                return new C2569g(arrayList2, arrayList5);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                arrayList3 = new ArrayList();
                i4 = 0;
                while (i4 < ((C1607c) this.f4050l.get(0)).f5607c.size()) {
                    arrayList6 = new ArrayList();
                    it3 = this.f4050l.iterator();
                    i2 = 0;
                    while (it3.hasNext()) {
                        c1607c = (C1607c) it3.next();
                        if (i2 >= arrayList4.size()) {
                            c2575h = i4 != 0 ? new C2575h(arrayList6, getString(C1082R.string.stress_cpu0_load)) : new C2575h(arrayList6, BuildConfig.FLAVOR + i4);
                            c2575h.m9843b(1.5f);
                            c2575h.m9854a(1.6f);
                            c2575h.m9855b(true);
                            c2575h.m9824a(Color.rgb(244, 117, 117));
                            c2575h.m9800c(f4039a[i4]);
                            c2575h.m9857i(f4039a[i4]);
                            c2575h.m9796a(false);
                            arrayList3.add(c2575h);
                            i4++;
                        } else {
                            if (((Integer) arrayList4.get(i2)).intValue() == c1607c.f5613i) {
                                try {
                                    intValue = (float) ((Integer) c1607c.f5607c.get(i4)).intValue();
                                    i5 = i2 + 1;
                                    try {
                                        arrayList6.add(new Entry(intValue, i2));
                                    } catch (Exception e) {
                                        i2 = i5;
                                    }
                                } catch (Exception e2) {
                                    i5 = i2 + 1;
                                    arrayList6.add(new Entry(0.0f, i2));
                                    i2 = i5;
                                }
                            } else {
                                i5 = i2;
                            }
                            i2 = i5;
                        }
                    }
                    if (i4 != 0) {
                    }
                    c2575h.m9843b(1.5f);
                    c2575h.m9854a(1.6f);
                    c2575h.m9855b(true);
                    c2575h.m9824a(Color.rgb(244, 117, 117));
                    c2575h.m9800c(f4039a[i4]);
                    c2575h.m9857i(f4039a[i4]);
                    c2575h.m9796a(false);
                    arrayList3.add(c2575h);
                    i4++;
                }
                return new C2569g(arrayList2, arrayList3);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                arrayList3 = new ArrayList();
                i4 = 0;
                while (i4 < ((C1607c) this.f4050l.get(0)).f5606b.size()) {
                    arrayList6 = new ArrayList();
                    it3 = this.f4050l.iterator();
                    i2 = 0;
                    while (it3.hasNext()) {
                        c1607c = (C1607c) it3.next();
                        if (i2 >= arrayList4.size()) {
                            c2575h = i4 != 0 ? new C2575h(arrayList6, getString(C1082R.string.stress_cpu0_freq)) : new C2575h(arrayList6, BuildConfig.FLAVOR + i4);
                            c2575h.m9843b(1.5f);
                            c2575h.m9854a(1.6f);
                            c2575h.m9855b(true);
                            c2575h.m9824a(Color.rgb(244, 117, 117));
                            c2575h.m9800c(f4039a[i4]);
                            c2575h.m9857i(f4039a[i4]);
                            c2575h.m9796a(false);
                            arrayList3.add(c2575h);
                            i4++;
                        } else {
                            if (((Integer) arrayList4.get(i2)).intValue() == c1607c.f5613i) {
                                try {
                                    intValue = (float) (((Integer) c1607c.f5606b.get(i4)).intValue() / AdError.NETWORK_ERROR_CODE);
                                    i5 = i2 + 1;
                                    try {
                                        arrayList6.add(new Entry(intValue, i2));
                                    } catch (Exception e3) {
                                        i2 = i5;
                                    }
                                } catch (Exception e4) {
                                    i5 = i2 + 1;
                                    arrayList6.add(new Entry(0.0f, i2));
                                    i2 = i5;
                                }
                            } else {
                                i5 = i2;
                            }
                            i2 = i5;
                        }
                    }
                    if (i4 != 0) {
                    }
                    c2575h.m9843b(1.5f);
                    c2575h.m9854a(1.6f);
                    c2575h.m9855b(true);
                    c2575h.m9824a(Color.rgb(244, 117, 117));
                    c2575h.m9800c(f4039a[i4]);
                    c2575h.m9857i(f4039a[i4]);
                    c2575h.m9796a(false);
                    arrayList3.add(c2575h);
                    i4++;
                }
                return new C2569g(arrayList2, arrayList3);
            case SpdyProtocol.QUIC /*4*/:
                arrayList2 = new ArrayList();
                it4 = this.f4050l.iterator();
                i4 = 0;
                i2 = 0;
                while (it4.hasNext()) {
                    c1607c = (C1607c) it4.next();
                    if (i2 >= arrayList4.size()) {
                        c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_bat_level));
                        c2575h.m9843b(1.5f);
                        c2575h.m9854a(1.6f);
                        c2575h.m9855b(true);
                        c2575h.m9795a(new C1203c(this));
                        c2575h.m9824a(Color.rgb(244, 117, 117));
                        c2575h.m9800c(f4039a[2]);
                        c2575h.m9857i(f4039a[2]);
                        c2575h.m9796a(false);
                        arrayList5 = new ArrayList();
                        arrayList5.add(c2575h);
                        return new C2569g(arrayList3, arrayList5);
                    }
                    if (((Integer) arrayList4.get(i2)).intValue() == c1607c.f5613i) {
                        if (c1607c.f5610f > 0) {
                            f2 = (float) c1607c.f5610f;
                            i5 = i4 + 1;
                            arrayList2.add(new Entry(f2, i4));
                            i4 = i5;
                        }
                        i3 = i2 + 1;
                        i5 = i4;
                    } else {
                        i5 = i4;
                        i3 = i2;
                    }
                    i4 = i5;
                    i2 = i3;
                }
                c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_bat_level));
                c2575h.m9843b(1.5f);
                c2575h.m9854a(1.6f);
                c2575h.m9855b(true);
                c2575h.m9795a(new C1203c(this));
                c2575h.m9824a(Color.rgb(244, 117, 117));
                c2575h.m9800c(f4039a[2]);
                c2575h.m9857i(f4039a[2]);
                c2575h.m9796a(false);
                arrayList5 = new ArrayList();
                arrayList5.add(c2575h);
                return new C2569g(arrayList3, arrayList5);
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                arrayList2 = new ArrayList();
                it4 = this.f4050l.iterator();
                i4 = 0;
                i2 = 0;
                while (it4.hasNext()) {
                    c1607c = (C1607c) it4.next();
                    if (i2 >= arrayList4.size()) {
                        c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_bat_tempe));
                        c2575h.m9843b(1.5f);
                        c2575h.m9854a(1.6f);
                        c2575h.m9855b(true);
                        c2575h.m9795a(new C1203c(this));
                        c2575h.m9824a(Color.rgb(244, 117, 117));
                        c2575h.m9800c(f4039a[1]);
                        c2575h.m9857i(f4039a[1]);
                        c2575h.m9796a(false);
                        arrayList5 = new ArrayList();
                        arrayList5.add(c2575h);
                        return new C2569g(arrayList3, arrayList5);
                    }
                    if (((Integer) arrayList4.get(i2)).intValue() == c1607c.f5613i) {
                        if (c1607c.f5610f > 0) {
                            f2 = ((float) c1607c.f5612h) / 10.0f;
                            i5 = i4 + 1;
                            arrayList2.add(new Entry(f2, i4));
                            i4 = i5;
                        }
                        i3 = i2 + 1;
                        i5 = i4;
                    } else {
                        i5 = i4;
                        i3 = i2;
                    }
                    i4 = i5;
                    i2 = i3;
                }
                c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_bat_tempe));
                c2575h.m9843b(1.5f);
                c2575h.m9854a(1.6f);
                c2575h.m9855b(true);
                c2575h.m9795a(new C1203c(this));
                c2575h.m9824a(Color.rgb(244, 117, 117));
                c2575h.m9800c(f4039a[1]);
                c2575h.m9857i(f4039a[1]);
                c2575h.m9796a(false);
                arrayList5 = new ArrayList();
                arrayList5.add(c2575h);
                return new C2569g(arrayList3, arrayList5);
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                arrayList2 = new ArrayList();
                it4 = this.f4050l.iterator();
                i4 = 0;
                i2 = 0;
                while (it4.hasNext()) {
                    c1607c = (C1607c) it4.next();
                    if (i2 >= arrayList4.size()) {
                        c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_bat_voltage));
                        c2575h.m9843b(1.5f);
                        c2575h.m9854a(1.6f);
                        c2575h.m9855b(true);
                        c2575h.m9795a(new C1203c(this));
                        c2575h.m9824a(Color.rgb(244, 117, 117));
                        c2575h.m9800c(f4039a[0]);
                        c2575h.m9857i(f4039a[0]);
                        c2575h.m9796a(false);
                        arrayList5 = new ArrayList();
                        arrayList5.add(c2575h);
                        return new C2569g(arrayList3, arrayList5);
                    }
                    if (((Integer) arrayList4.get(i2)).intValue() == c1607c.f5613i) {
                        if (c1607c.f5610f > 0) {
                            f2 = ((float) c1607c.f5611g) / 100.0f;
                            i5 = i4 + 1;
                            arrayList2.add(new Entry(f2, i4));
                            i4 = i5;
                        }
                        i3 = i2 + 1;
                        i5 = i4;
                    } else {
                        i5 = i4;
                        i3 = i2;
                    }
                    i4 = i5;
                    i2 = i3;
                }
                c2575h = new C2575h(arrayList2, getString(C1082R.string.stress_bat_voltage));
                c2575h.m9843b(1.5f);
                c2575h.m9854a(1.6f);
                c2575h.m9855b(true);
                c2575h.m9795a(new C1203c(this));
                c2575h.m9824a(Color.rgb(244, 117, 117));
                c2575h.m9800c(f4039a[0]);
                c2575h.m9857i(f4039a[0]);
                c2575h.m9796a(false);
                arrayList5 = new ArrayList();
                arrayList5.add(c2575h);
                return new C2569g(arrayList3, arrayList5);
            default:
                return null;
        }
    }

    private void m4967c() {
        this.f4048j.setText(C1503b.m5915c().m5970w());
        List arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            C2560e b = m4966b(i);
            String a = m4965a(i);
            if (b != null) {
                arrayList.add(new C1646b(b, a, getApplicationContext()));
            }
        }
        Object c1200a = new C1200a(this, getApplicationContext(), arrayList);
        this.f4045g.cancel();
        this.f4047i.clearAnimation();
        this.f4041c.setVisibility(4);
        this.f4042d.setVisibility(0);
        this.f4040b.setAdapter(c1200a);
        c1200a.notifyDataSetChanged();
    }

    void m4968a() {
        if (!BenchmarkLongService.m6332d() && !BenchmarkService.m4822g()) {
            getWindow().addFlags(SpdyProtocol.SLIGHTSSLV2);
            this.f4041c.setVisibility(0);
            this.f4042d.setVisibility(4);
            BenchmarkLongService.m6320a((Context) this);
            this.f4045g.start(this.f4044f);
            this.f4047i.startAnimation(this.f4046h);
        }
    }

    boolean m4969b() {
        try {
            String str = getFilesDir().getAbsolutePath() + "/last_stress_result.gz";
            if (!Hash.checkFileHashF(str, str + ".hash")) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(Utils.readStringFromFile(str));
            this.f4050l = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                C1607c c1607c = new C1607c();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                c1607c.f5614j = jSONObject.getInt("s");
                c1607c.f5613i = jSONObject.getInt(MsgConstant.KEY_TS);
                c1607c.f5610f = jSONObject.getInt("bl");
                c1607c.f5609e = jSONObject.getInt("bp");
                c1607c.f5608d = jSONObject.getInt("bs");
                c1607c.f5612h = jSONObject.getInt("bt");
                c1607c.f5611g = jSONObject.getInt("bv");
                int i2 = jSONObject.getInt("ct");
                c1607c.f5606b = new ArrayList();
                c1607c.f5607c = new ArrayList();
                if (i2 > 100) {
                    i2 = 100;
                } else if (i2 < 0) {
                    i2 = 0;
                }
                c1607c.f5605a = i2;
                JSONArray jSONArray2 = jSONObject.getJSONArray("cfs");
                for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                    c1607c.f5606b.add(Integer.valueOf(jSONArray2.getInt(i2)));
                }
                jSONArray2 = jSONObject.getJSONArray("cts");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    i2 = jSONArray2.getInt(i3);
                    if (i2 > 100) {
                        i2 = 100;
                    } else if (i2 < 0) {
                        i2 = 0;
                    }
                    c1607c.f5607c.add(Integer.valueOf(i2));
                }
                this.f4050l.add(c1607c);
            }
            if (this.f4050l.size() <= 1) {
                return false;
            }
            m4967c();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_bench_long);
        if (getResources().getConfiguration().orientation == 2) {
            if (((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
                setRequestedOrientation(8);
            } else {
                setRequestedOrientation(0);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(5);
        }
        this.f4040b = (ListView) findViewById(C1082R.id.listViewChart);
        this.f4041c = findViewById(C1082R.id.layout_test);
        this.f4042d = findViewById(C1082R.id.layout_result);
        this.f4043e = (TextView) findViewById(C1082R.id.text_info_testing);
        this.f4044f = (TitanicTextView) findViewById(C1082R.id.text_percent);
        this.f4047i = (ImageView) findViewById(C1082R.id.img_anim);
        this.f4048j = (TextView) findViewById(C1082R.id.device_name);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.antutu.benchmark.update.UI_LONG");
        intentFilter.addAction("com.antutu.benchmark.test_long.STOP");
        intentFilter.addAction("com.antutu.benchmark.test_long.FINISHED_LONG");
        this.f4049k = new C1201b();
        registerReceiver(this.f4049k, intentFilter);
        String string = getResources().getString(C4459R.string.app_name);
        try {
            str = string + " v" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
            str = string;
        }
        CommonTitleView commonTitleView = (CommonTitleView) findViewById(C1082R.id.title_layout);
        C1624a a = new C1625b().m6415a(false).m6418b(false).m6419c(true).m6420d(true).m6414a(str).m6411a();
        commonTitleView.setMode(a);
        ((CommonTitleView) findViewById(C1082R.id.title_layout_result)).setMode(a);
        try {
            Button button = (Button) findViewById(C1082R.id.btn_test_stop);
            button.setOnClickListener(new C11981(this, button));
        } catch (Exception e2) {
        }
        try {
            ((Button) findViewById(C1082R.id.btn_test_again)).setOnClickListener(new C11992(this));
        } catch (Exception e3) {
        }
        this.f4046h = AnimationUtils.loadAnimation(this, C1082R.anim.rotate_repeat);
        this.f4046h.setInterpolator(new LinearInterpolator());
        C2620f.m10060a((Context) this);
        if (!m4969b()) {
            m4968a();
        }
    }

    protected void onDestroy() {
        try {
            unregisterReceiver(this.f4049k);
        } catch (Exception e) {
        }
        BenchmarkLongService.m6326b((Context) this);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (i == 4 && BenchmarkLongService.m6332d()) ? true : super.onKeyDown(i, keyEvent);
    }
}
