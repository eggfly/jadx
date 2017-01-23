package com.cmcm.p074a.p075a.p112a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.cmcm.p074a.p075a.C1788a;
import com.cmcm.p074a.p075a.p115d.C2160a;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/* renamed from: com.cmcm.a.a.a.j */
public class C2116j implements C1788a {
    private Context f7432a;
    private Handler f7433b;
    private File f7434c;
    private C1788a f7435d;
    private volatile Map f7436e;
    private String f7437f;
    private String f7438g;
    private C2109c f7439h;
    private boolean f7440i;

    public C2116j(C1788a c1788a, File file, Context context, Handler handler) {
        this.f7435d = c1788a;
        if (this.f7435d == null) {
            this.f7432a = context;
            this.f7433b = handler;
            this.f7434c = new File(file, "cloud_config.dat");
            m8000d();
        }
    }

    private int m7984a(String str, String str2) {
        int i = 0;
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        while (i < split.length && i < split2.length) {
            try {
                long parseLong = Long.parseLong(split[i]);
                try {
                    long parseLong2 = Long.parseLong(split2[i]);
                    if (parseLong > parseLong2) {
                        return 1;
                    }
                    if (parseLong < parseLong2) {
                        return -1;
                    }
                    i++;
                } catch (NumberFormatException e) {
                    return 1;
                }
            } catch (NumberFormatException e2) {
                return -1;
            }
        }
        return split.length - split2.length;
    }

    private String m7985a(Integer num, String str, String str2) {
        Map map = this.f7436e;
        if (map != null) {
            map = (Map) map.get(num + str);
            if (map != null) {
                return (String) map.get(str2);
            }
        }
        return null;
    }

    private String m7986a(String str) {
        return TextUtils.isEmpty(str) ? null : str.trim();
    }

    private void m7990a(Map map) {
        Exception e;
        FileOutputStream fileOutputStream = null;
        C2107a c2107a;
        try {
            c2107a = new C2107a(this.f7434c);
            try {
                fileOutputStream = c2107a.m7917b();
                new ObjectOutputStream(fileOutputStream).writeObject(map);
                c2107a.m7916a(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            c2107a = null;
            if (c2107a != null) {
                c2107a.m7918b(fileOutputStream);
            }
            if (C2133z.f7482a) {
                ad.m7931a("CloudConfigProxy", "failed to save : " + e.getMessage(), new Object[0]);
            }
        }
    }

    private void m7994b(String str) {
        new C2124q().m8022a("https://ws.ksmobile.net/api/GetCloudMsgAdv" + this.f7438g + "&net=" + (C2115i.m7980i(this.f7432a) ? 1 : 2) + "&lan=" + C2115i.m7977f(this.f7432a), str);
    }

    private void m7995b(Map map) {
        this.f7433b.post(new C2119m(this, map));
    }

    private void m7997c() {
        C2131x a = C2131x.m8050a();
        if (!TextUtils.isEmpty(a.m8057f()) && !TextUtils.isEmpty(a.m8059h()) && !TextUtils.isEmpty(a.m8060i())) {
            StringBuilder stringBuilder = new StringBuilder();
            String[] a2 = C2115i.m7968a(this.f7432a);
            stringBuilder.append("?version=1");
            stringBuilder.append("&pkg=").append(m7986a(a.m8058g()));
            stringBuilder.append("&apkversion=").append(m7986a(a.m8059h()));
            stringBuilder.append("&channelid=").append(m7986a(a.m8060i()));
            stringBuilder.append("&mcc=").append(m7986a(a2[0]));
            stringBuilder.append("&mnc=").append(m7986a(a2[1]));
            stringBuilder.append("&aid=").append(m7986a(C2115i.m7970b(this.f7432a)));
            stringBuilder.append("&gaid=").append(m7986a(C2160a.m8150b().m8151a()));
            stringBuilder.append("&osversion=").append(m7986a(VERSION.RELEASE));
            if (TextUtils.isEmpty(Build.MODEL)) {
                stringBuilder.append("&device=null");
            } else {
                stringBuilder.append("&device=").append(Build.MODEL.replace(" ", "_"));
            }
            stringBuilder.append("&branch=").append(m7986a(C2115i.m7969b()));
            stringBuilder.append("&resolution=").append(m7986a(C2115i.m7972c(this.f7432a)));
            stringBuilder.append("&mem_size=").append(Math.round(((float) C2115i.m7975d(this.f7432a)) / 1048576.0f));
            stringBuilder.append("&dpi=").append(m7986a(C2115i.m7976e(this.f7432a)));
            this.f7438g = stringBuilder.toString();
            this.f7437f = String.format("https://ups.ksmobile.net/%s/getversions.php", new Object[]{a.m8057f()});
            long currentTimeMillis = System.currentTimeMillis();
            C2108b a3 = C2108b.m7936a();
            long b = a3.m7938b("config_update_timestamp");
            if (Math.abs(currentTimeMillis - b) >= 21600000) {
                long b2 = a3.m7938b("config_verion_timestamp");
                currentTimeMillis = Math.abs(currentTimeMillis - b2) >= 7200000 ? 0 : 7200000 - Math.abs(currentTimeMillis - b2);
            } else {
                currentTimeMillis = 21600000 - Math.abs(currentTimeMillis - b);
            }
            this.f7439h = new C2109c(1);
            this.f7439h.m7951a(new C2118l(this), Math.max(currentTimeMillis, 60000));
        } else if (C2133z.f7482a) {
            ad.m7931a("CloudConfigProxy", "invalid parameter", new Object[0]);
        }
    }

    private void m8000d() {
        Closeable objectInputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        try {
            objectInputStream = new ObjectInputStream(new C2107a(this.f7434c).m7919c());
            try {
                this.f7436e = (Map) objectInputStream.readObject();
                C2115i.m7967a(objectInputStream);
            } catch (FileNotFoundException e2) {
                closeable = objectInputStream;
                C2115i.m7967a(closeable);
            } catch (Exception e3) {
                e = e3;
                try {
                    if (C2133z.f7482a) {
                        ad.m7931a("CloudConfigProxy", "failed to load : " + e.getMessage(), new Object[0]);
                    }
                    C2115i.m7967a(objectInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    C2115i.m7967a(objectInputStream);
                    throw th;
                }
            }
        } catch (FileNotFoundException e4) {
            C2115i.m7967a(closeable);
        } catch (Exception e5) {
            Exception exception = e5;
            objectInputStream = null;
            e = exception;
            if (C2133z.f7482a) {
                ad.m7931a("CloudConfigProxy", "failed to load : " + e.getMessage(), new Object[0]);
            }
            C2115i.m7967a(objectInputStream);
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = null;
            th = th4;
            C2115i.m7967a(objectInputStream);
            throw th;
        }
    }

    private void m8002e() {
        if (C2133z.f7482a) {
            ad.m7931a("CloudConfigProxy", "begin to check version", new Object[0]);
        }
        if (!this.f7440i) {
            this.f7440i = true;
            this.f7439h.m7953b();
            new C2125r().m8016a(this.f7437f);
        } else if (C2133z.f7482a) {
            ad.m7931a("CloudConfigProxy", "is updating", new Object[0]);
        }
    }

    public void m8003a() {
        if (this.f7433b != null) {
            this.f7433b.post(new C2117k(this));
        }
    }

    public void m8004b() {
        if (this.f7438g != null && C2115i.m7979h(this.f7432a)) {
            long currentTimeMillis = System.currentTimeMillis();
            C2108b a = C2108b.m7936a();
            if (Math.abs(currentTimeMillis - a.m7938b("config_update_timestamp")) >= 21600000 && Math.abs(currentTimeMillis - a.m7938b("config_verion_timestamp")) >= 7200000) {
                m8002e();
            }
        }
    }

    public boolean getBoolValue(Integer num, String str, String str2, boolean z) {
        if (this.f7435d != null) {
            return this.f7435d.getBoolValue(num, str, str2, z);
        }
        try {
            String a = m7985a(num, str, str2);
            return a != null ? Boolean.parseBoolean(a) : z;
        } catch (Exception e) {
            if (!C2133z.f7482a) {
                return z;
            }
            ad.m7931a("CloudConfigProxy", "failed : " + e.getMessage(), new Object[0]);
            return z;
        }
    }

    public int getIntValue(Integer num, String str, String str2, int i) {
        if (this.f7435d != null) {
            return this.f7435d.getIntValue(num, str, str2, i);
        }
        try {
            String a = m7985a(num, str, str2);
            return a != null ? Integer.parseInt(a) : i;
        } catch (Exception e) {
            if (!C2133z.f7482a) {
                return i;
            }
            ad.m7931a("CloudConfigProxy", "failed : " + e.getMessage(), new Object[0]);
            return i;
        }
    }

    public String getStringValue(Integer num, String str, String str2, String str3) {
        if (this.f7435d != null) {
            return this.f7435d.getStringValue(num, str, str2, str3);
        }
        try {
            String a = m7985a(num, str, str2);
            return a != null ? a : str3;
        } catch (Exception e) {
            if (!C2133z.f7482a) {
                return str3;
            }
            ad.m7931a("CloudConfigProxy", "failed : " + e.getMessage(), new Object[0]);
            return str3;
        }
    }
}
