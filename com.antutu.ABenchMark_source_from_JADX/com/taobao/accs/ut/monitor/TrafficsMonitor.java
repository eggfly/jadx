package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.p192c.C4083a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public class TrafficsMonitor {
    private Map<String, List<C4129a>> f13841a;
    private Map<String, String> f13842b;
    private int f13843c;
    private Context f13844d;
    private String f13845e;

    /* renamed from: com.taobao.accs.ut.monitor.TrafficsMonitor.1 */
    class C41281 extends HashMap<String, String> {
        final /* synthetic */ TrafficsMonitor f13834a;

        C41281(TrafficsMonitor trafficsMonitor) {
            this.f13834a = trafficsMonitor;
            put(IXAdRequestInfo.IMSI, "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    }

    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {
        @Dimension
        public String bizId;
        @Dimension
        public String date;
        @Dimension
        public String host;
        @Dimension
        public boolean isBackground;
        @Dimension
        public String serviceId;
        @Measure
        public long size;
    }

    /* renamed from: com.taobao.accs.ut.monitor.TrafficsMonitor.a */
    public static class C4129a {
        String f13835a;
        String f13836b;
        String f13837c;
        boolean f13838d;
        String f13839e;
        long f13840f;

        public C4129a(String str, String str2, String str3, boolean z, String str4, long j) {
            this.f13835a = str;
            this.f13836b = str2;
            this.f13837c = str3;
            this.f13838d = z;
            this.f13839e = str4;
            this.f13840f = j;
        }

        public C4129a(String str, boolean z, String str2, long j) {
            this.f13837c = str;
            this.f13838d = z;
            this.f13839e = str2;
            this.f13840f = j;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("date:" + this.f13835a);
            stringBuilder.append(" ");
            stringBuilder.append("bizId:" + this.f13836b);
            stringBuilder.append(" ");
            stringBuilder.append("serviceId:" + this.f13837c);
            stringBuilder.append(" ");
            stringBuilder.append("host:" + this.f13839e);
            stringBuilder.append(" ");
            stringBuilder.append("isBackground:" + this.f13838d);
            stringBuilder.append(" ");
            stringBuilder.append("size:" + this.f13840f);
            return stringBuilder.toString();
        }
    }

    public TrafficsMonitor(Context context) {
        this.f13841a = new HashMap();
        this.f13842b = new C41281(this);
        this.f13843c = 0;
        this.f13845e = BuildConfig.FLAVOR;
        this.f13844d = context;
    }

    private void m16891b() {
        synchronized (this.f13841a) {
            Object obj;
            String str;
            String formatDay = UtilityImpl.formatDay(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f13845e) || this.f13845e.equals(formatDay)) {
                obj = null;
                str = formatDay;
            } else {
                str = this.f13845e;
                obj = 1;
            }
            for (String str2 : this.f13841a.keySet()) {
                for (C4129a c4129a : (List) this.f13841a.get(str2)) {
                    if (c4129a != null) {
                        C4083a.m16655a(this.f13844d).m16660a(c4129a.f13839e, c4129a.f13837c, (String) this.f13842b.get(c4129a.f13837c), c4129a.f13838d, c4129a.f13840f, str);
                    }
                }
            }
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.f13841a.toString(), new Object[0]);
            }
            if (obj != null) {
                this.f13841a.clear();
                m16892c();
            } else if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f13845e + " currday:" + formatDay, new Object[0]);
            }
            this.f13845e = formatDay;
            this.f13843c = 0;
        }
    }

    private void m16892c() {
        List<C4129a> a = C4083a.m16655a(this.f13844d).m16658a(false);
        if (a != null) {
            try {
                for (C4129a c4129a : a) {
                    if (c4129a != null) {
                        StatObject statTrafficMonitor = new StatTrafficMonitor();
                        statTrafficMonitor.bizId = c4129a.f13836b;
                        statTrafficMonitor.date = c4129a.f13835a;
                        statTrafficMonitor.host = c4129a.f13839e;
                        statTrafficMonitor.isBackground = c4129a.f13838d;
                        statTrafficMonitor.size = c4129a.f13840f;
                        AppMonitor.getInstance().commitStat(statTrafficMonitor);
                    }
                }
                C4083a.m16655a(this.f13844d).m16659a();
            } catch (Throwable th) {
                ALog.m16903e(BuildConfig.FLAVOR, th.toString(), new Object[0]);
                th.printStackTrace();
            }
        }
    }

    public void m16893a() {
        try {
            synchronized (this.f13841a) {
                this.f13841a.clear();
            }
            List<C4129a> a = C4083a.m16655a(this.f13844d).m16658a(true);
            if (a != null) {
                for (C4129a a2 : a) {
                    m16894a(a2);
                }
            }
        } catch (Exception e) {
            ALog.m16906w("TrafficsMonitor", e.toString(), new Object[0]);
        }
    }

    public void m16894a(C4129a c4129a) {
        if (c4129a != null && c4129a.f13839e != null && c4129a.f13840f > 0) {
            c4129a.f13837c = TextUtils.isEmpty(c4129a.f13837c) ? "accsSelf" : c4129a.f13837c;
            synchronized (this.f13841a) {
                String str = (String) this.f13842b.get(c4129a.f13837c);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Object arrayList;
                c4129a.f13836b = str;
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d("TrafficsMonitor", "addTrafficInfo count:" + this.f13843c + " " + c4129a.toString(), new Object[0]);
                }
                Object<C4129a> obj = (List) this.f13841a.get(str);
                if (obj != null) {
                    Object obj2;
                    for (C4129a c4129a2 : obj) {
                        if (c4129a2.f13838d == c4129a.f13838d && c4129a2.f13839e != null && c4129a2.f13839e.equals(c4129a.f13839e)) {
                            c4129a2.f13840f += c4129a.f13840f;
                            obj2 = null;
                            break;
                        }
                    }
                    int i = 1;
                    if (obj2 != null) {
                        obj.add(c4129a);
                    }
                } else {
                    arrayList = new ArrayList();
                    arrayList.add(c4129a);
                }
                this.f13841a.put(str, arrayList);
                this.f13843c++;
                if (this.f13843c >= 10) {
                    m16891b();
                }
            }
        }
    }
}
