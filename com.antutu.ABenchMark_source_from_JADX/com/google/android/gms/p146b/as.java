package com.google.android.gms.p146b;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@gb
/* renamed from: com.google.android.gms.b.as */
public class as {
    BlockingQueue<az> f10319a;
    ExecutorService f10320b;
    LinkedHashMap<String, String> f10321c;
    Map<String, av> f10322d;
    String f10323e;
    final Context f10324f;
    final String f10325g;
    private AtomicBoolean f10326h;
    private File f10327i;

    /* renamed from: com.google.android.gms.b.as.1 */
    class C30321 implements Runnable {
        final /* synthetic */ as f10318a;

        C30321(as asVar) {
            this.f10318a = asVar;
        }

        public void run() {
            this.f10318a.m11821a();
        }
    }

    public as(Context context, String str, String str2, Map<String, String> map) {
        this.f10321c = new LinkedHashMap();
        this.f10322d = new HashMap();
        this.f10324f = context;
        this.f10325g = str;
        this.f10323e = str2;
        this.f10326h = new AtomicBoolean(false);
        this.f10326h.set(((Boolean) aq.f10269I.m11794c()).booleanValue());
        if (this.f10326h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f10327i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f10321c.put(entry.getKey(), entry.getValue());
        }
        this.f10319a = new ArrayBlockingQueue(30);
        this.f10320b = Executors.newSingleThreadExecutor();
        this.f10320b.execute(new C30321(this));
        this.f10322d.put(PushConsts.CMD_ACTION, av.f10329b);
        this.f10322d.put("ad_format", av.f10329b);
        this.f10322d.put("e", av.f10330c);
    }

    private void m11821a() {
        while (true) {
            try {
                az azVar = (az) this.f10319a.take();
                String c = azVar.m11857c();
                if (!TextUtils.isEmpty(c)) {
                    m11824a(m11827a(this.f10321c, azVar.m11858d()), c);
                }
            } catch (Throwable e) {
                C2972b.m11584d("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private void m11823a(File file, String str) {
        Throwable e;
        if (file != null) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (Throwable e2) {
                            C2972b.m11584d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                            return;
                        }
                    }
                    return;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        C2972b.m11584d("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                C2972b.m11584d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                C2972b.m11584d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                C2972b.m11584d("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        C2972b.m11583d("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void m11824a(Map<String, String> map, String str) {
        String a = m11826a(this.f10323e, map, str);
        if (this.f10326h.get()) {
            m11823a(this.f10327i, a);
        } else {
            C2968s.m11525e().m13035a(this.f10324f, this.f10325g, a);
        }
    }

    public av m11825a(String str) {
        av avVar = (av) this.f10322d.get(str);
        return avVar != null ? avVar : av.f10328a;
    }

    String m11826a(String str, Map<String, String> map, String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
        stringBuilder.append("&").append("it").append("=").append(str2);
        return stringBuilder.toString();
    }

    Map<String, String> m11827a(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, m11825a(str).m11835a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public void m11828a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f10321c.put("e", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list));
        }
    }

    public boolean m11829a(az azVar) {
        return this.f10319a.offer(azVar);
    }
}
