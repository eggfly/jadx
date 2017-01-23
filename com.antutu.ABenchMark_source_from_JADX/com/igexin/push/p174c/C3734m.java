package com.igexin.push.p174c;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.C0714a;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.core.p176a.C3777e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.c.m */
public abstract class C3734m {
    private static final String f12599e;
    protected long f12600a;
    protected final Map f12601b;
    protected final Map f12602c;
    protected C3722a f12603d;
    private final Object f12604f;
    private final Object f12605g;
    private int f12606h;
    private AtomicBoolean f12607i;
    private final Comparator f12608j;
    private int f12609k;

    static {
        f12599e = C3734m.class.getName();
    }

    public C3734m(String str, String str2) {
        this.f12601b = new LinkedHashMap();
        this.f12602c = new HashMap();
        this.f12604f = new Object();
        this.f12605g = new Object();
        this.f12607i = new AtomicBoolean(false);
        this.f12603d = new C3722a();
        this.f12608j = new C3737n(this);
        this.f12609k = m15318s();
        if (C3730i.f12580a) {
            m15312a(false);
            return;
        }
        m15313b(str);
        m15315c(str2);
    }

    private C3731j m15308a(JSONObject jSONObject) {
        if (!jSONObject.has(C0714a.DOMAIN)) {
            return null;
        }
        C3731j c3731j = new C3731j();
        c3731j.m15287a(jSONObject.getString(C0714a.DOMAIN));
        if (jSONObject.has("port")) {
            c3731j.m15285a(jSONObject.getInt("port"));
        }
        if (jSONObject.has("ip")) {
            c3731j.m15294b(jSONObject.getString("ip"));
        }
        if (jSONObject.has("consumeTime")) {
            c3731j.m15286a(jSONObject.getLong("consumeTime"));
        }
        if (jSONObject.has("detectSuccessTime")) {
            c3731j.m15293b(jSONObject.getLong("detectSuccessTime"));
        }
        if (jSONObject.has("isDomain")) {
            c3731j.m15289a(jSONObject.getBoolean("isDomain"));
        }
        if (!jSONObject.has("connectTryCnt")) {
            return c3731j;
        }
        c3731j.m15292b(jSONObject.getInt("connectTryCnt"));
        return c3731j;
    }

    private List m15309a() {
        String[] xfrAddress = SDKUrlConfig.getXfrAddress();
        List arrayList = new ArrayList();
        for (Object obj : xfrAddress) {
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private List m15310a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(jSONArray.getJSONObject(i).getString(C0714a.DOMAIN));
                i++;
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    private void m15311a(C3731j c3731j) {
        C3666d c3738p = new C3738p();
        c3738p.m15365a(m15323c());
        c3738p.m15364a(c3731j);
        synchronized (this.f12605g) {
            this.f12601b.put(c3731j.m15284a(), c3738p);
        }
        C3685c.m15060b().m15053a(c3738p, true, true);
    }

    private void m15312a(boolean z) {
        if (m15319t()) {
            if (C3855g.aw != null) {
                C3799f.m15623a().m15652b("null", true);
            }
        } else if (C3855g.ax != null) {
            C3799f.m15623a().m15652b("null", false);
        }
        List<String> a = m15309a();
        List arrayList = new ArrayList();
        for (String str : a) {
            C3731j c3731j = new C3731j(str, Integer.parseInt(C3687f.m15083a(str)[2]));
            if (z) {
                m15311a(c3731j);
            }
            arrayList.add(c3731j);
        }
        this.f12603d.m15260b(arrayList);
        a.clear();
    }

    private void m15313b(String str) {
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(str)) {
            m15312a(true);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            Object obj = jSONArray;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            m15312a(true);
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.f12600a = jSONObject.getLong("lastDetectTime");
            } catch (JSONException e2) {
            }
        }
        if (Math.abs(System.currentTimeMillis() - this.f12600a) >= C3727f.f12571a) {
            m15312a(true);
            return;
        }
        if (jSONObject.has("list")) {
            try {
                jSONArray = jSONObject.getJSONArray("list");
            } catch (JSONException e3) {
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            m15312a(true);
            return;
        }
        List a = m15310a(jSONArray);
        if (a == null || a.isEmpty()) {
            m15312a(true);
            return;
        }
        Object a2 = m15309a();
        List arrayList = new ArrayList(a2);
        arrayList.retainAll(a);
        if (arrayList.size() != a.size()) {
            C3688a.m15097b(f12599e + " | db cache xfr != default, use default");
            arrayList.clear();
            a2.clear();
            a.clear();
            m15312a(true);
            return;
        }
        C3688a.m15097b(f12599e + " | db cache xfr == default, use cache");
        m15314b(jSONArray);
    }

    private void m15314b(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C3731j a = m15308a(jSONObject);
                if (a != null) {
                    this.f12602c.put(a.m15284a(), a);
                } else {
                    try {
                        a = m15316d(jSONObject.getString(C0714a.DOMAIN));
                    } catch (Exception e) {
                        C3688a.m15097b(f12599e + "|initWithCacheData exception " + e.toString());
                        this.f12602c.clear();
                        m15312a(true);
                        return;
                    }
                }
                if (a != null) {
                    m15311a(a);
                    arrayList.add(a);
                }
                i++;
            } catch (Exception e2) {
                C3688a.m15097b(f12599e + "|initWithCacheData exception " + e2.toString());
                return;
            }
        }
        this.f12603d.m15260b(arrayList);
    }

    private void m15315c(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                jSONObject = null;
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                if (jSONObject.has("detectFailedCnt")) {
                    try {
                        this.f12606h = jSONObject.getInt("detectFailedCnt");
                    } catch (JSONException e2) {
                    }
                }
                if (jSONObject.has("loginFailedlCnt")) {
                    try {
                        this.f12603d.f12549c = jSONObject.getInt("loginFailedlCnt");
                    } catch (JSONException e3) {
                    }
                }
                if (jSONObject.has("lastChange2BackupTime")) {
                    try {
                        this.f12603d.f12550d = jSONObject.getLong("lastChange2BackupTime");
                    } catch (JSONException e4) {
                    }
                }
                if (jSONObject.has("lastOfflineTime")) {
                    try {
                        this.f12603d.f12551e = jSONObject.getLong("lastOfflineTime");
                    } catch (JSONException e5) {
                    }
                }
                if (jSONObject.has("domainType")) {
                    try {
                        this.f12603d.f12547a = C3725d.m15270a(jSONObject.getInt("domainType"));
                        if (this.f12603d.f12547a == C3725d.BACKUP) {
                            this.f12603d.f12548b.set(true);
                        }
                    } catch (JSONException e6) {
                    }
                }
            }
        }
    }

    private C3731j m15316d(String str) {
        C3731j c3731j = new C3731j();
        String[] a = C3687f.m15083a(str);
        c3731j.m15287a(str);
        c3731j.m15285a(Integer.parseInt(a[2]));
        return c3731j;
    }

    private void m15317r() {
        synchronized (this.f12604f) {
            this.f12602c.clear();
        }
    }

    private int m15318s() {
        return m15309a().size();
    }

    private boolean m15319t() {
        return m15321b() == C3729h.MOBILE;
    }

    protected C3738p m15320a(String str) {
        C3738p c3738p;
        synchronized (this.f12605g) {
            for (Entry entry : this.f12601b.entrySet()) {
                if (((String) entry.getKey()).equals(str)) {
                    c3738p = (C3738p) entry.getValue();
                    break;
                }
            }
            c3738p = null;
        }
        return c3738p;
    }

    public abstract C3729h m15321b();

    protected void m15322b(C3731j c3731j) {
        synchronized (this.f12604f) {
            this.f12602c.put(c3731j.m15284a(), c3731j);
        }
        this.f12603d.m15262d();
    }

    public abstract C3735o m15323c();

    protected String m15324c(C3731j c3731j) {
        return c3731j.m15284a() + "[" + c3731j.m15295c() + "] ";
    }

    public void m15325d() {
        if (m15334m()) {
            C3688a.m15097b(f12599e + "|startDetect detect = true, start detect !!!");
            this.f12607i.set(true);
            m15331j();
            return;
        }
        C3688a.m15097b(f12599e + "|startDetect detect = false, return !!!");
    }

    public void m15326e() {
        synchronized (this.f12605g) {
            for (Entry entry : this.f12601b.entrySet()) {
                ((C3738p) entry.getValue()).m15365a(null);
                ((C3738p) entry.getValue()).m15370g();
            }
        }
    }

    public void m15327f() {
        this.f12607i.set(true);
        synchronized (this.f12605g) {
            for (Entry entry : this.f12601b.entrySet()) {
                ((C3738p) entry.getValue()).m15365a(m15323c());
                ((C3738p) entry.getValue()).m15366a(true);
            }
        }
    }

    public C3731j m15328g() {
        C3731j c3731j;
        synchronized (this.f12604f) {
            if (this.f12602c.isEmpty()) {
                c3731j = null;
            } else {
                Object arrayList = new ArrayList(this.f12602c.entrySet());
                Collections.sort(arrayList, this.f12608j);
                c3731j = (C3731j) ((Entry) arrayList.get(0)).getValue();
            }
        }
        return c3731j;
    }

    public void m15329h() {
        int i = 0;
        m15326e();
        m15317r();
        List a = m15309a();
        synchronized (this.f12605g) {
            int size = this.f12601b.size();
            if (a.size() < size) {
                int size2 = size - a.size();
                Iterator it = this.f12601b.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext() && i2 < size2) {
                    ((C3738p) ((Entry) it.next()).getValue()).m15371h();
                    it.remove();
                    i2++;
                }
            }
            List arrayList = new ArrayList(this.f12601b.values());
            this.f12601b.clear();
            List arrayList2 = new ArrayList();
            while (i < a.size()) {
                C3731j c3731j = new C3731j();
                String[] a2 = C3687f.m15083a((String) a.get(i));
                c3731j.m15287a((String) a.get(i));
                c3731j.m15285a(Integer.parseInt(a2[2]));
                if (i < size) {
                    C3738p c3738p = (C3738p) arrayList.get(i);
                    c3738p.m15364a(c3731j);
                    this.f12601b.put(c3731j.m15284a(), c3738p);
                } else {
                    m15311a(c3731j);
                }
                arrayList2.add(c3731j);
                i++;
            }
            this.f12603d.m15260b(arrayList2);
        }
    }

    public void m15330i() {
        m15326e();
        m15317r();
        List a = m15309a();
        synchronized (this.f12605g) {
            for (Entry value : this.f12601b.entrySet()) {
                ((C3738p) value.getValue()).m15371h();
            }
            this.f12601b.clear();
            List arrayList = new ArrayList();
            C3731j c3731j = new C3731j();
            String[] a2 = C3687f.m15083a((String) a.get(0));
            c3731j.m15287a((String) a.get(0));
            c3731j.m15285a(Integer.parseInt(a2[2]));
            arrayList.add(c3731j);
            this.f12603d.m15260b(arrayList);
            arrayList.clear();
        }
    }

    public void m15331j() {
        this.f12600a = System.currentTimeMillis();
        synchronized (this.f12605g) {
            for (Entry entry : this.f12601b.entrySet()) {
                ((C3738p) entry.getValue()).m15365a(m15323c());
                if (((C3738p) entry.getValue()).c_() != null) {
                    ((C3738p) entry.getValue()).c_().m15291b();
                }
                ((C3738p) entry.getValue()).m15372i();
            }
        }
    }

    public synchronized void m15332k() {
        this.f12600a = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f12605g) {
            try {
                jSONObject.put("lastDetectTime", this.f12600a);
                jSONObject.put("list", jSONArray);
                for (Entry value : this.f12601b.entrySet()) {
                    JSONObject i = ((C3738p) value.getValue()).c_().m15301i();
                    if (i != null) {
                        jSONArray.put(i);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (jSONObject.length() > 0) {
            if (m15319t()) {
                C3799f.m15623a().m15652b(jSONObject.toString(), true);
            } else {
                C3799f.m15623a().m15652b(jSONObject.toString(), false);
            }
        }
    }

    protected void m15333l() {
        C3799f.m15623a().m15652b("null", true);
        C3799f.m15623a().m15652b("null", false);
    }

    protected boolean m15334m() {
        long abs = Math.abs(System.currentTimeMillis() - this.f12600a);
        if (abs >= C3727f.f12571a - 3600) {
            C3688a.m15097b(f12599e + "|current time - last detect time > " + (C3727f.f12571a / 1000) + " s, detect = true");
            C3733k.f12595a.set(true);
            return true;
        }
        if (!C3733k.f12595a.getAndSet(true)) {
            long abs2 = Math.abs(C3727f.f12571a - abs);
            C3733k.b_().m15305a(abs2);
            C3688a.m15097b(f12599e + "|set next detect time = " + abs2);
        }
        return false;
    }

    protected synchronized void m15335n() {
        if (!C3855g.f12976n && this.f12607i.getAndSet(false)) {
            C3688a.m15097b(f12599e + "|online = false, reconnect");
            C3777e.m15491a().m15553d(true);
        }
        if (this.f12606h != 0) {
            this.f12606h = 0;
            m15337p();
        }
        this.f12603d.m15263e();
    }

    protected synchronized void m15336o() {
        this.f12606h++;
        C3688a.m15097b(f12599e + "|detect failed cnt = " + (this.f12606h / this.f12609k));
        int i = this.f12606h / this.f12609k;
        if (i <= C3754m.f12647A) {
            m15337p();
        }
        if (i >= C3754m.f12647A && !this.f12603d.f12548b.get()) {
            C3688a.m15097b(f12599e + "|detect failed cnt = " + (this.f12606h / this.f12609k) + ", enter backup ++++++++");
            this.f12603d.m15264f();
        }
    }

    protected synchronized void m15337p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("detectFailedCnt", this.f12606h);
            jSONObject.put("loginFailedlCnt", this.f12603d.f12549c);
            jSONObject.put("lastChange2BackupTime", this.f12603d.f12550d);
            jSONObject.put("lastOfflineTime", this.f12603d.f12551e);
            jSONObject.put("domainType", this.f12603d.f12547a.m15272b());
        } catch (Exception e) {
        }
        if (jSONObject.length() > 0) {
            if (m15319t()) {
                C3799f.m15623a().m15646a(jSONObject.toString(), true);
            } else {
                C3799f.m15623a().m15646a(jSONObject.toString(), false);
            }
        }
    }

    protected boolean m15338q() {
        boolean z;
        synchronized (this.f12604f) {
            for (Entry value : this.f12602c.entrySet()) {
                if (((C3731j) value.getValue()).m15297e() != 2147483647L) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
