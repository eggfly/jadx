package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4316c;
import com.xiaomi.channel.commonutils.network.C4317a;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.network.HostManager.HttpGet;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManagerV2 extends HostManager {
    private final int f14856a;
    private final int f14857b;
    private int f14858c;

    protected HostManagerV2(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
        this(context, hostFilter, httpGet, str, null, null);
    }

    protected HostManagerV2(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        super(context, hostFilter, httpGet, str, str2, str3);
        this.f14856a = 80;
        this.f14857b = 5222;
        this.f14858c = 80;
        HostManager.addReservedHost("resolver.msg.xiaomi.net", "resolver.msg.xiaomi.net:5222");
    }

    static String m17920a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(HttpRequest.f14548a);
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                if ((b & 240) != 240) {
                    bytes[i] = (byte) (((b & 15) ^ ((byte) (((b >> 4) + length) & 15))) | (b & 240));
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    protected JSONObject m17921a() {
        JSONObject jSONObject;
        synchronized (this.mHostsMapping) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            jSONObject.put(Constants.KEY_DATA, toJSON());
        }
        return jSONObject;
    }

    protected void m17922b(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(Constants.KEY_DATA);
            for (int i = 0; i < optJSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(optJSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    protected boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            try {
                Object loadHosts = loadHosts();
                if (!TextUtils.isEmpty(loadHosts)) {
                    m17922b(loadHosts);
                    C4302b.m17652b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                C4302b.m17649a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    protected String getHost() {
        return "resolver.msg.xiaomi.net";
    }

    protected String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        Iterator it;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        List<C4316c> arrayList4 = new ArrayList();
        arrayList4.add(new C4317a(C4233j.f14402y, str));
        if (str.equals("wap")) {
            arrayList4.add(new C4317a("conpt", m17920a(C4321d.m17712g(this.sAppContext))));
        }
        arrayList4.add(new C4317a("uuid", str2));
        arrayList4.add(new C4317a("list", HostManager.join((Collection) arrayList, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.msg.xiaomi.net");
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[]{"resolver.msg.xiaomi.net:" + this.f14858c});
        if (localFallback == null) {
            arrayList3.add(format);
            synchronized (mReservedHosts) {
                it = ((ArrayList) mReservedHosts.get("resolver.msg.xiaomi.net")).iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    arrayList3.add(String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[]{str3}));
                }
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = localFallback.m17893a(format);
        }
        Iterator it2 = arrayList2.iterator();
        IOException iOException = null;
        while (it2.hasNext()) {
            Builder buildUpon = Uri.parse((String) it2.next()).buildUpon();
            for (C4316c c4316c : arrayList4) {
                buildUpon.appendQueryParameter(c4316c.m17689a(), c4316c.m17690b());
            }
            try {
                return this.sHttpGetter == null ? C4321d.m17699a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.m17919a(buildUpon.toString());
            } catch (IOException e) {
                iOException = e;
            }
        }
        return iOException != null ? super.getRemoteFallbackJSON(arrayList, str, str2) : null;
    }

    public void persist() {
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                Object jSONObject = m17921a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                C4302b.m17649a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks purge : this.mHostsMapping.values()) {
                purge.purge(true);
            }
            Object obj = null;
            while (obj == null) {
                for (String str : this.mHostsMapping.keySet()) {
                    if (((Fallbacks) this.mHostsMapping.get(str)).getFallbacks().isEmpty()) {
                        this.mHostsMapping.remove(str);
                        obj = null;
                        break;
                    }
                }
                obj = 1;
            }
        }
    }
}
