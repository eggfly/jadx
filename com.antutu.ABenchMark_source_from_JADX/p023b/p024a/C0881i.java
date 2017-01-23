package p023b.p024a;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;
import p023b.p024a.C0909w.C0902i;

/* renamed from: b.a.i */
public class C0881i {
    private final int f2951a;
    private final int f2952b;
    private final int f2953c;
    private Context f2954d;
    private C0877g f2955e;
    private C0872f f2956f;
    private JSONObject f2957g;

    /* renamed from: b.a.i.1 */
    class C08801 extends as {
        final /* synthetic */ Map f2949a;
        final /* synthetic */ C0881i f2950b;

        /* renamed from: b.a.i.1.1 */
        class C08791 extends cd {
            final /* synthetic */ C08801 f2948a;

            C08791(C08801 c08801) {
                this.f2948a = c08801;
            }

            public void m3896a(Object obj, boolean z) {
                if (!obj.equals(MsgConstant.KEY_SUCCESS)) {
                }
            }
        }

        C08801(C0881i c0881i, Map map) {
            this.f2950b = c0881i;
            this.f2949a = map;
        }

        public void m3897a() {
            ci.m3705a(this.f2950b.f2954d).m3733a(new C08791(this), this.f2949a);
        }
    }

    public C0881i(Context context) {
        this.f2951a = SpdyProtocol.SLIGHTSSLV2;
        this.f2952b = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        this.f2953c = 10;
        this.f2955e = null;
        this.f2956f = null;
        this.f2957g = null;
        if (context == null) {
            try {
                throw new RuntimeException("Context is null, can't track event");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f2954d = context;
        this.f2955e = C0877g.m3887b(this.f2954d);
        this.f2956f = this.f2955e.m3888a(this.f2954d);
        if (this.f2957g == null) {
            m3900a(context);
        }
    }

    private void m3899a() {
        int i = 0;
        try {
            if (!TextUtils.isEmpty(this.f2956f.f2923a)) {
                String[] split = this.f2956f.f2923a.split("!");
                JSONObject jSONObject = new JSONObject();
                if (this.f2957g != null) {
                    for (String a : split) {
                        String a2 = an.m3371a(a2, (int) SpdyProtocol.SLIGHTSSLV2);
                        if (this.f2957g.has(a2)) {
                            jSONObject.put(a2, this.f2957g.get(a2));
                        }
                    }
                }
                this.f2957g = new JSONObject();
                if (split.length >= 10) {
                    while (i < 10) {
                        m3901a(split[i], jSONObject);
                        i++;
                    }
                } else {
                    while (i < split.length) {
                        m3901a(split[i], jSONObject);
                        i++;
                    }
                }
                m3905b(this.f2954d);
                this.f2956f.f2923a = null;
            }
        } catch (Exception e) {
        }
    }

    private void m3900a(Context context) {
        try {
            Object string = C0888r.m3932a(context).getString("fs_lc_tl", null);
            if (!TextUtils.isEmpty(string)) {
                this.f2957g = new JSONObject(string);
            }
            m3899a();
        } catch (Exception e) {
        }
    }

    private void m3901a(String str, JSONObject jSONObject) {
        String a = an.m3371a(str, (int) SpdyProtocol.SLIGHTSSLV2);
        if (jSONObject.has(a)) {
            m3902a(a, ((Boolean) jSONObject.get(a)).booleanValue());
        } else {
            m3902a(a, false);
        }
    }

    private void m3902a(String str, boolean z) {
        try {
            if (!"$st_fl".equals(str) && !"dplus_st".equals(str) && !"du".equals(str) && !AgooConstants.MESSAGE_ID.equals(str) && !MsgConstant.KEY_TS.equals(str) && !this.f2957g.has(str)) {
                this.f2957g.put(str, z);
            }
        } catch (Exception e) {
        }
    }

    private boolean m3903a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= SpdyProtocol.SLIGHTSSLV2) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        ap.m3391d("Event id is empty or too long in tracking Event");
        return false;
    }

    private boolean m3904a(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Entry entry : map.entrySet()) {
                        if (!m3903a((String) entry.getKey())) {
                            return false;
                        }
                        if (entry.getValue() == null) {
                            return false;
                        }
                        if ((entry.getValue() instanceof String) && !m3906b(entry.getValue().toString())) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
            }
        }
        ap.m3391d("map is null or empty in onEvent");
        return false;
    }

    private void m3905b(Context context) {
        try {
            if (this.f2957g != null) {
                C0888r.m3932a(this.f2954d).edit().putString("fs_lc_tl", this.f2957g.toString()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean m3906b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
                return true;
            }
            ap.m3391d("Event label or value is empty or too long in tracking Event");
            return false;
        } catch (Exception e) {
        }
    }

    public void m3907a(Context context, List<String> list) {
        try {
            if (this.f2954d == null && context != null) {
                this.f2954d = context;
            }
        } catch (Exception e) {
        }
    }

    public void m3908a(String str, String str2, long j, int i) {
        try {
            if (m3903a(str) && m3906b(str2)) {
                Object obj;
                Object obj2;
                Map hashMap = new HashMap();
                if (str2 == null) {
                    obj = BuildConfig.FLAVOR;
                } else {
                    String str3 = str2;
                }
                hashMap.put(str, obj);
                C0882k c0902i = new C0902i();
                c0902i.f3013c = str;
                c0902i.f3014d = System.currentTimeMillis();
                if (j > 0) {
                    c0902i.f3015e = j;
                }
                c0902i.f3011a = 1;
                hashMap = c0902i.f3017g;
                if (str2 == null) {
                    obj2 = BuildConfig.FLAVOR;
                }
                hashMap.put(str, obj2);
                if (c0902i.f3012b == null) {
                    c0902i.f3012b = C0891t.m3953g(this.f2954d);
                }
                c0902i.f3017g.put("_umpname", C0867e.f2910a);
                this.f2955e.m3890a(c0902i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m3909a(String str, Map<String, Object> map) {
        try {
            if (m3903a(str)) {
                C0882k c0902i = new C0902i();
                c0902i.f3013c = str;
                c0902i.f3014d = System.currentTimeMillis();
                c0902i.f3015e = 0;
                c0902i.f3011a = 2;
                Iterator it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Entry entry = (Entry) it.next();
                    if (!("$st_fl".equals(entry.getKey()) || "dplus_st".equals(entry.getKey()) || "du".equals(entry.getKey()) || AgooConstants.MESSAGE_ID.equals(entry.getKey()) || MsgConstant.KEY_TS.equals(entry.getKey()))) {
                        Object value = entry.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            c0902i.f3017g.put(entry.getKey(), value);
                        }
                    }
                }
                if (c0902i.f3012b == null) {
                    c0902i.f3012b = C0891t.m3953g(this.f2954d);
                }
                this.f2955e.m3890a(c0902i);
            }
        } catch (Exception e) {
        }
    }

    public void m3910a(String str, Map<String, Object> map, long j) {
        try {
            if (m3903a(str) && m3904a((Map) map)) {
                C0882k c0902i = new C0902i();
                c0902i.f3013c = str;
                c0902i.f3014d = System.currentTimeMillis();
                if (j > 0) {
                    c0902i.f3015e = j;
                }
                c0902i.f3011a = 1;
                Iterator it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Entry entry = (Entry) it.next();
                    if (!("$st_fl".equals(entry.getKey()) || "dplus_st".equals(entry.getKey()) || "du".equals(entry.getKey()) || AgooConstants.MESSAGE_ID.equals(entry.getKey()) || MsgConstant.KEY_TS.equals(entry.getKey()))) {
                        Object value = entry.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            c0902i.f3017g.put(entry.getKey(), value);
                        }
                    }
                }
                if (c0902i.f3012b == null) {
                    c0902i.f3012b = C0891t.m3953g(this.f2954d);
                }
                c0902i.f3017g.put("_umpname", C0867e.f2910a);
                this.f2955e.m3890a(c0902i);
            }
        } catch (Throwable e) {
            ap.m3383a("Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    public boolean m3911a(List<String> list, int i, String str) {
        int i2 = 0;
        try {
            cj a = cj.m3741a();
            if (list == null) {
                ap.m3391d("cklist is null!");
            } else if (list.size() <= 0) {
                ap.m3391d("the KeyList is null!");
                return false;
            } else {
                List arrayList = new ArrayList(list);
                if (a.m3746b((String) arrayList.get(0))) {
                    String str2;
                    String str3;
                    if (arrayList.size() > 8) {
                        str3 = (String) arrayList.get(0);
                        arrayList.clear();
                        arrayList.add(str3);
                        arrayList.add("__cc");
                        arrayList.add("illegal");
                    } else if (!a.m3744a(arrayList)) {
                        str3 = (String) arrayList.get(0);
                        arrayList.clear();
                        arrayList.add(str3);
                        arrayList.add("__cc");
                        arrayList.add("illegal");
                    } else if (a.m3747b(arrayList)) {
                        while (i2 < arrayList.size()) {
                            str3 = (String) arrayList.get(i2);
                            if (str3.length() > 16) {
                                arrayList.remove(i2);
                                arrayList.add(i2, str3.substring(0, 16));
                            }
                            i2++;
                        }
                    } else {
                        str3 = (String) arrayList.get(0);
                        arrayList.clear();
                        arrayList.add(str3);
                        arrayList.add("__cc");
                        arrayList.add("illegal");
                    }
                    if (a.m3743a(str)) {
                        str2 = str;
                    } else {
                        ap.m3391d("label  Invalid!");
                        str2 = "__illegal";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(arrayList, new ch(arrayList, (long) i, str2, System.currentTimeMillis()));
                    aq.m3396b(new C08801(this, hashMap));
                } else {
                    ap.m3391d("Primary key Invalid!");
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
}
