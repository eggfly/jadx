package com.cmcm.p074a.p075a.p114c;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import com.cmcm.p074a.p075a.p112a.C2107a;
import com.cmcm.p074a.p075a.p112a.C2114h;
import com.cmcm.p074a.p075a.p112a.C2115i;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.cmcm.p074a.p075a.p112a.C2131x;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;
import com.cmcm.p074a.p075a.p115d.C2169j;
import com.umeng.message.common.C4209a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.cmcm.a.a.c.q */
public class C2152q implements C2114h {
    private HashMap f7508a;
    private Set f7509b;
    private BroadcastReceiver f7510c;

    private C2136b m8121a(String str) {
        if (this.f7508a == null) {
            return null;
        }
        C2136b c2136b = (C2136b) this.f7508a.get(str);
        return (c2136b == null || !c2136b.m8073e()) ? null : c2136b;
    }

    private void m8124a(Set set) {
        Exception e;
        FileOutputStream fileOutputStream = null;
        C2107a c2107a;
        try {
            c2107a = new C2107a(new File(C2126s.m8043d(), "receiver_history_list.dat"));
            try {
                fileOutputStream = c2107a.m7917b();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeInt(set.size());
                for (String writeUTF : set) {
                    objectOutputStream.writeUTF(writeUTF);
                }
                objectOutputStream.flush();
                c2107a.m7916a(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                if (C2133z.f7482a) {
                    ad.m7931a("ReceiverManager", "failed to writePackage" + e.getMessage(), new Object[0]);
                }
                if (c2107a != null) {
                    c2107a.m7918b(fileOutputStream);
                }
            }
        } catch (Exception e3) {
            e = e3;
            c2107a = null;
            if (C2133z.f7482a) {
                ad.m7931a("ReceiverManager", "failed to writePackage" + e.getMessage(), new Object[0]);
            }
            if (c2107a != null) {
                c2107a.m7918b(fileOutputStream);
            }
        }
    }

    private void m8125c() {
        for (C2136b c2136b : this.f7508a.values()) {
            c2136b.m8070a(C2126s.m8037a(c2136b.m8074f(), "is_enabled", true));
        }
    }

    private Set m8126d() {
        Closeable c;
        Exception e;
        try {
            c = new C2107a(new File(C2126s.m8043d(), "receiver_history_list.dat")).m7919c();
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(c);
                int readInt = objectInputStream.readInt();
                if (readInt > 0) {
                    Set hashSet = new HashSet(readInt);
                    for (int i = 0; i < readInt; i++) {
                        hashSet.add(objectInputStream.readUTF());
                    }
                    return hashSet;
                }
            } catch (Exception e2) {
                e = e2;
                if (C2133z.f7482a) {
                    ad.m7931a("ReceiverManager", "failed to readPackage" + e.getMessage(), new Object[0]);
                }
                C2115i.m7967a(c);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            c = null;
            if (C2133z.f7482a) {
                ad.m7931a("ReceiverManager", "failed to readPackage" + e.getMessage(), new Object[0]);
            }
            C2115i.m7967a(c);
            return null;
        }
        return null;
    }

    private void m8127e() {
        try {
            List<PackageInfo> installedPackages = C2126s.m8041c().getPackageManager().getInstalledPackages(0);
            this.f7509b = new HashSet(installedPackages.size());
            for (PackageInfo packageInfo : installedPackages) {
                this.f7509b.add(packageInfo.packageName);
            }
            Set<String> d = m8126d();
            if (d == null || d.isEmpty()) {
                m8124a(this.f7509b);
                return;
            }
            List<String> linkedList = new LinkedList();
            for (PackageInfo packageInfo2 : installedPackages) {
                if (!d.remove(packageInfo2.packageName)) {
                    linkedList.add(packageInfo2.packageName);
                }
            }
            if (!d.isEmpty() || !linkedList.isEmpty()) {
                C2136b a = m8121a("inst_app");
                C2136b a2 = m8121a("uninst_app");
                if ((a != null && a.m8073e()) || (a2 != null && a2.m8073e())) {
                    String c;
                    C2169j a3 = C2169j.m8169a();
                    if (a != null && a.m8073e()) {
                        for (String c2 : linkedList) {
                            c2 = C2148m.m8107c(c2);
                            if (c2 != null) {
                                a3.m8198a(10, "inst_app2", c2);
                            }
                        }
                    }
                    if (a2 != null && a2.m8073e()) {
                        for (String c22 : d) {
                            c22 = C2158w.m8141c(c22);
                            if (c22 != null) {
                                a3.m8198a(10, "uninst_app2", c22);
                            }
                        }
                    }
                }
                m8124a(this.f7509b);
            }
        } catch (Exception e) {
            if (C2133z.f7482a) {
                ad.m7931a("ReceiverManager", "failed to processPackage" + e.getMessage(), new Object[0]);
            }
        }
    }

    public void m8128a() {
        m8125c();
        for (C2136b a : this.f7508a.values()) {
            a.m8065a();
        }
    }

    public void m8129b() {
        if (C2133z.f7482a) {
            ad.m7931a("ReceiverManager", "init()", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        try {
            C2131x a = C2131x.m8050a();
            for (int i = 0; i < C2144i.f7501a.length; i += 2) {
                String str = (String) C2144i.f7501a[i];
                if (a.m8052a(str)) {
                    hashMap.put(str, (C2136b) ((Class) C2144i.f7501a[i + 1]).newInstance());
                }
            }
        } catch (Exception e) {
            if (C2133z.f7482a) {
                ad.m7931a("ReceiverManager", "failed to create receiver : " + e.getMessage(), new Object[0]);
            }
        }
        this.f7508a = hashMap;
        m8125c();
        C2126s.m8034a((C2114h) this);
        m8127e();
        this.f7510c = new C2153r(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(C4209a.f14200c);
        C2126s.m8031a(this.f7510c, intentFilter);
    }
}
