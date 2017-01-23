package com.cmcm.p074a.p075a.p114c;

import com.cmcm.p074a.p075a.p112a.C2107a;
import com.cmcm.p074a.p075a.p112a.C2109c;
import com.cmcm.p074a.p075a.p112a.C2111e;
import com.cmcm.p074a.p075a.p112a.C2112f;
import com.cmcm.p074a.p075a.p112a.C2115i;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import java.io.Closeable;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.c */
public class C2138c extends C2136b implements C2111e {
    private C2112f f7489a;
    private C2109c f7490b;
    private boolean f7491c;
    private long f7492d;
    private Map f7493e;

    private void m8084c() {
        Closeable c;
        Closeable objectInputStream;
        Throwable th;
        Throwable th2;
        Closeable closeable = null;
        try {
            c = m8087k().m7919c();
            try {
                objectInputStream = new ObjectInputStream(c);
                try {
                    this.f7492d = objectInputStream.readLong();
                    this.f7493e = (Map) objectInputStream.readObject();
                    C2115i.m7967a(objectInputStream);
                    C2115i.m7967a(c);
                } catch (Exception e) {
                    closeable = objectInputStream;
                    objectInputStream = c;
                    try {
                        m8088l();
                        C2115i.m7967a(closeable);
                        C2115i.m7967a(objectInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        c = objectInputStream;
                        objectInputStream = closeable;
                        th2 = th;
                        C2115i.m7967a(objectInputStream);
                        C2115i.m7967a(c);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    C2115i.m7967a(objectInputStream);
                    C2115i.m7967a(c);
                    throw th2;
                }
            } catch (Exception e2) {
                objectInputStream = c;
                m8088l();
                C2115i.m7967a(closeable);
                C2115i.m7967a(objectInputStream);
            } catch (Throwable th5) {
                th = th5;
                objectInputStream = null;
                th2 = th;
                C2115i.m7967a(objectInputStream);
                C2115i.m7967a(c);
                throw th2;
            }
        } catch (Exception e3) {
            objectInputStream = null;
            m8088l();
            C2115i.m7967a(closeable);
            C2115i.m7967a(objectInputStream);
        } catch (Throwable th52) {
            c = null;
            th2 = th52;
            objectInputStream = null;
            C2115i.m7967a(objectInputStream);
            C2115i.m7967a(c);
            throw th2;
        }
    }

    private void m8085i() {
        Closeable b;
        Closeable objectOutputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        if (this.f7491c) {
            C2107a k = m8087k();
            try {
                b = k.m7917b();
                try {
                    objectOutputStream = new ObjectOutputStream(b);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = null;
                    closeable = b;
                    try {
                        e.printStackTrace();
                        k.m7918b(closeable);
                        C2115i.m7967a(objectOutputStream);
                        C2115i.m7967a(closeable);
                    } catch (Throwable th2) {
                        th = th2;
                        b = closeable;
                        C2115i.m7967a(objectOutputStream);
                        C2115i.m7967a(b);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = null;
                    C2115i.m7967a(objectOutputStream);
                    C2115i.m7967a(b);
                    throw th;
                }
                try {
                    objectOutputStream.writeLong(this.f7492d);
                    objectOutputStream.writeObject(this.f7493e);
                    k.m7916a(b);
                    this.f7491c = false;
                    C2115i.m7967a(objectOutputStream);
                    C2115i.m7967a(b);
                } catch (Exception e3) {
                    e = e3;
                    closeable = b;
                    e.printStackTrace();
                    k.m7918b(closeable);
                    C2115i.m7967a(objectOutputStream);
                    C2115i.m7967a(closeable);
                } catch (Throwable th4) {
                    th = th4;
                    C2115i.m7967a(objectOutputStream);
                    C2115i.m7967a(b);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                objectOutputStream = null;
                e.printStackTrace();
                k.m7918b(closeable);
                C2115i.m7967a(objectOutputStream);
                C2115i.m7967a(closeable);
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
                b = null;
                C2115i.m7967a(objectOutputStream);
                C2115i.m7967a(b);
                throw th;
            }
        }
    }

    private void m8086j() {
        if (this.f7493e != null && !this.f7493e.isEmpty() && System.currentTimeMillis() >= this.f7492d + 43200000) {
            m8087k().m7915a();
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("begin_time", this.f7492d / 1000);
                jSONObject.put("end_time", currentTimeMillis / 1000);
                JSONObject jSONObject2 = new JSONObject();
                for (String str : this.f7493e.keySet()) {
                    Map map = (Map) this.f7493e.get(str);
                    JSONObject jSONObject3 = new JSONObject();
                    for (Object next : map.keySet()) {
                        jSONObject3.put(next.toString(), map.get(next));
                    }
                    jSONObject2.put(str, jSONObject3);
                }
                jSONObject.put(Constants.KEY_DATA, jSONObject2);
                m8069a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m8088l();
        }
    }

    private C2107a m8087k() {
        return new C2107a(new File(C2126s.m8043d(), "running_app_list.dat"));
    }

    private void m8088l() {
        this.f7491c = false;
        this.f7492d = System.currentTimeMillis();
        this.f7493e = new HashMap();
    }

    public void m8089a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() / C4156a.f13949k;
        Map map = (Map) this.f7493e.get(str2);
        if (map == null) {
            map = new HashMap();
            map.put(Long.valueOf(currentTimeMillis), Integer.valueOf(1));
            this.f7493e.put(str2, map);
        } else {
            Integer num = (Integer) map.get(Long.valueOf(currentTimeMillis));
            if (num == null) {
                map.put(Long.valueOf(currentTimeMillis), Integer.valueOf(1));
            } else {
                map.put(Long.valueOf(currentTimeMillis), Integer.valueOf(num.intValue() + 1));
            }
        }
        this.f7491c = true;
    }

    public void m8090b() {
        this.f7489a = new C2112f();
        if (this.f7489a.m7962b()) {
            this.f7489a.m7960a((C2111e) this);
            m8084c();
            m8086j();
            this.f7490b = new C2109c();
            this.f7490b.m7951a(new C2139d(this), 60000);
        }
    }

    public String m8091f() {
        return "running_app_list";
    }

    public void m8092g() {
        if (this.f7489a.m7962b()) {
            m8085i();
            m8088l();
            this.f7490b.m7953b();
            this.f7489a.m7959a();
        }
    }
}
