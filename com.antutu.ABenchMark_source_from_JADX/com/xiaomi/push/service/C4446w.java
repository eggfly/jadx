package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.C4304b;
import com.xiaomi.xmpush.thrift.C4519c;
import com.xiaomi.xmpush.thrift.C4520d;
import com.xiaomi.xmpush.thrift.C4522e;
import com.xiaomi.xmpush.thrift.C4525g;
import com.xiaomi.xmpush.thrift.C4544q;
import com.xiaomi.xmpush.thrift.C4546r;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.push.service.w */
public class C4446w {
    public static int m18377a(C4445v c4445v, C4519c c4519c) {
        int i = 0;
        String a = C4446w.m18378a(c4519c);
        switch (C4447x.f15167a[c4519c.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                i = 1;
                break;
        }
        return c4445v.f15166a.getInt(a, i);
    }

    private static String m18378a(C4519c c4519c) {
        return "oc_version_" + c4519c.m18796a();
    }

    private static List<Pair<Integer, Object>> m18379a(List<C4525g> list, boolean z) {
        if (C4304b.m17660a(list)) {
            return null;
        }
        List<Pair<Integer, Object>> arrayList = new ArrayList();
        for (C4525g c4525g : list) {
            int a = c4525g.m18811a();
            C4520d a2 = C4520d.m18797a(c4525g.m18819c());
            if (a2 != null) {
                if (z && c4525g.f15771c) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    Object obj;
                    Pair pair;
                    switch (C4447x.f15168b[a2.ordinal()]) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                            pair = new Pair(Integer.valueOf(a), Integer.valueOf(c4525g.m18825f()));
                            break;
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                            pair = new Pair(Integer.valueOf(a), Long.valueOf(c4525g.m18828h()));
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                            pair = new Pair(Integer.valueOf(a), c4525g.m18830j());
                            break;
                        case SpdyProtocol.QUIC /*4*/:
                            pair = new Pair(Integer.valueOf(a), Boolean.valueOf(c4525g.m18832l()));
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    public static void m18380a(C4445v c4445v, C4519c c4519c, int i) {
        c4445v.f15166a.edit().putInt(C4446w.m18378a(c4519c), i).commit();
    }

    public static void m18381a(C4445v c4445v, C4544q c4544q) {
        c4445v.m18376b(C4446w.m18379a(c4544q.m19029a(), true));
    }

    public static void m18382a(C4445v c4445v, C4546r c4546r) {
        for (C4522e c4522e : c4546r.m19037a()) {
            if (c4522e.m18799a() > C4446w.m18377a(c4445v, c4522e.m18807d())) {
                C4446w.m18380a(c4445v, c4522e.m18807d(), c4522e.m18799a());
                c4445v.m18374a(C4446w.m18379a(c4522e.f15718b, false));
            }
        }
    }
}
