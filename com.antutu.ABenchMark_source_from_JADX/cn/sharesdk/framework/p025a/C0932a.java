package cn.sharesdk.framework.p025a;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;

/* renamed from: cn.sharesdk.framework.a.a */
public class C0932a extends NetworkHelper {
    private static C0932a f3183a;

    static {
        f3183a = null;
    }

    private C0932a() {
    }

    public static C0932a m4083a() {
        if (f3183a == null) {
            f3183a = new C0932a();
        }
        return f3183a;
    }

    private void m4084a(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            ShareSDK.logApiEvent(str, i);
        }
    }

    public String m4085a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, String str2, int i) {
        return m4087a(str, (ArrayList) arrayList, (KVPair) kVPair, null, str2, i);
    }

    public String m4086a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, String str2, int i) {
        m4084a(str2, i);
        return super.httpPost(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    public String m4087a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, String str2, int i) {
        return m4086a(str, arrayList, kVPair, arrayList2, null, str2, i);
    }

    public String m4088a(String str, ArrayList<KVPair<String>> arrayList, String str2, int i) {
        return m4089a(str, (ArrayList) arrayList, null, null, str2, i);
    }

    public String m4089a(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, String str2, int i) {
        m4084a(str2, i);
        return super.httpGet(str, arrayList, arrayList2, networkTimeOut);
    }

    public void m4090a(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, String str2, int i) {
        m4084a(str2, i);
        super.rawPost(str, (ArrayList) arrayList, hTTPPart, rawNetworkCallback, null);
    }

    public String m4091b(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, String str2, int i) {
        m4084a(str2, i);
        return super.httpPut(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    public String m4092b(String str, ArrayList<KVPair<String>> arrayList, String str2, int i) {
        return m4085a(str, arrayList, null, str2, i);
    }

    public String m4093b(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, String str2, int i) {
        m4084a(str2, i);
        return super.jsonPost(str, arrayList, arrayList2, networkTimeOut);
    }
}
