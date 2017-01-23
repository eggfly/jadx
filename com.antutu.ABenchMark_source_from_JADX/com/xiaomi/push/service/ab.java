package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManager.HostManagerFactory;
import com.xiaomi.network.HostManager.HttpGet;
import com.xiaomi.network.HostManagerV2;
import com.xiaomi.push.protobuf.C4378a.C4377a;
import com.xiaomi.push.protobuf.C4380b.C4379a;
import com.xiaomi.push.service.ah.C4402a;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.smack.C4461a;
import com.xiaomi.smack.util.C4496g;
import com.xiaomi.stats.C4509f;
import com.xiaomi.stats.C4512h;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.message.MessageService;

public class ab extends C4402a implements HostManagerFactory {
    private XMPushService f15003a;
    private long f15004b;

    /* renamed from: com.xiaomi.push.service.ab.a */
    static class C4400a implements HttpGet {
        C4400a() {
        }

        public String m18108a(String str) {
            Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(21));
            buildUpon.appendQueryParameter("osver", String.valueOf(VERSION.SDK_INT));
            buildUpon.appendQueryParameter(Constants.KEY_OS_VERSION, C4496g.m18647a(Build.MODEL + ":" + VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C4297i.m17628c()));
            String builder = buildUpon.toString();
            C4302b.m17653c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = C4321d.m17699a(C4297i.m17624a(), url);
                C4512h.m18711a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a;
            } catch (Exception e) {
                C4512h.m18711a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.ab.b */
    static class C4401b extends HostManagerV2 {
        protected C4401b(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
            super(context, hostFilter, httpGet, str);
        }

        protected String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
            try {
                if (C4509f.m18692a().m18700c()) {
                    str2 = ah.m18140e();
                }
                return super.getRemoteFallbackJSON(arrayList, str, str2);
            } catch (IOException e) {
                IOException iOException = e;
                C4512h.m18708a(0, C4452a.GSLB_ERR.m18407a(), 1, null, C4321d.m17709d(this.sAppContext) ? 1 : 0);
                throw iOException;
            }
        }
    }

    ab(XMPushService xMPushService) {
        this.f15003a = xMPushService;
    }

    public static void m18111a(XMPushService xMPushService) {
        C4402a abVar = new ab(xMPushService);
        ah.m18136a().m18146a(abVar);
        HostManager.setHostManagerFactory(abVar);
        HostManager.init(xMPushService, null, new C4400a(), MessageService.MSG_DB_READY_REPORT, "push", "2.2");
    }

    public HostManager m18112a(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
        return new C4401b(context, hostFilter, httpGet, str);
    }

    public void m18113a(C4377a c4377a) {
    }

    public void m18114a(C4379a c4379a) {
        if (c4379a.m18007d() && c4379a.m18006c() && System.currentTimeMillis() - this.f15004b > C4156a.f13949k) {
            C4302b.m17649a("fetch bucket :" + c4379a.m18006c());
            this.f15004b = System.currentTimeMillis();
            HostManager instance = HostManager.getInstance();
            instance.clear();
            instance.refreshFallbacks();
            C4461a g = this.f15003a.m18103g();
            if (g != null) {
                Fallback fallbacksByHost = instance.getFallbacksByHost(g.m18455a().m18165f());
                if (fallbacksByHost != null) {
                    boolean z;
                    ArrayList d = fallbacksByHost.m17910d();
                    Iterator it = d.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equals(g.m18470c())) {
                            z = false;
                            break;
                        }
                    }
                    z = true;
                    if (z && !d.isEmpty()) {
                        C4302b.m17649a("bucket changed, force reconnect");
                        this.f15003a.m18079a(0, null);
                        this.f15003a.m18090a(false);
                    }
                }
            }
        }
    }
}
