package com.baidu.mobads.p080j;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.p095b.C2007b;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p081a.C1908b;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.baidu.mobads.j.r */
class C1996r implements IXAdURIUitls {
    private C2007b f6972a;

    C1996r() {
    }

    private C2007b m7474a() {
        if (this.f6972a == null) {
            try {
                this.f6972a = new C2007b();
            } catch (ClassNotFoundException e) {
            }
        }
        return this.f6972a;
    }

    private Boolean m7475a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public Boolean m7476a(String str) {
        boolean z = m7475a(str, "sms:").booleanValue() || m7475a(str, "smsto:").booleanValue() || m7475a(str, "mms:").booleanValue();
        return Boolean.valueOf(z);
    }

    @Deprecated
    public String addParameter(String str, String str2, String str3) {
        String fixedString = getFixedString(str);
        String queryString = getQueryString(str);
        return fixedString + "?" + (!C1991m.m7449a().m7464m().isStringAvailable(queryString) ? str2 + "=" + str3 : queryString + "&" + str2 + "=" + str3);
    }

    public String addParameters(String str, HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (hashMap == null || hashMap.isEmpty()) {
            return stringBuilder.toString();
        }
        stringBuilder.append("?");
        for (Entry entry : hashMap.entrySet()) {
            try {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append("&");
            } catch (Throwable e) {
                C1989j.m7430a().m7439e(e);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.substring(0, stringBuilder2.length() - 1);
    }

    public String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, HttpRequest.f14548a);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public HashMap<String, String> getAllQueryParameters(String str) {
        HashMap<String, String> hashMap = new HashMap();
        Uri parse = Uri.parse(str);
        for (String str2 : getQueryParameterNames(parse)) {
            if (str2 != null && str2.length() > 0) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
        }
        return hashMap;
    }

    public String getFileName(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException e) {
            return BuildConfig.FLAVOR;
        }
    }

    public String getFixedString(String str) {
        return str == null ? null : (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        C2007b a = m7474a();
        if (a != null) {
            String a2 = a.m7487a(url.toString());
            if (a2 != null && a2.length() > 0) {
                httpURLConnection.setRequestProperty("Cookie", a2);
            }
        }
        return httpURLConnection;
    }

    @SuppressLint({"NewApi"})
    public Set<String> getQueryParameterNames(Uri uri) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return uri.getQueryParameterNames();
            }
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return Collections.emptySet();
            }
            Set linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                indexOf2 = indexOf + 1;
                if (indexOf2 >= encodedQuery.length()) {
                    return Collections.unmodifiableSet(linkedHashSet);
                }
                i = indexOf2;
            }
        } catch (Exception e) {
            return new HashSet();
        }
    }

    public String getQueryString(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
        return (split == null || split.length < 2) ? null : split[1];
    }

    public String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        String str2;
        C1991m a = C1991m.m7449a();
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str3 : hashMap.keySet()) {
                int i2 = i + 1;
                str2 = (String) hashMap.get(str3);
                if (i2 == 1) {
                    stringBuilder.append(str3).append("=").append(str2);
                } else {
                    stringBuilder.append("&").append(str3).append("=").append(str2);
                }
                i = i2;
            }
        }
        if (!C1908b.f6664a.booleanValue()) {
            return str + "?code2=" + a.m7456e().encode(stringBuilder.toString());
        }
        if (hashMap != null) {
            for (String str32 : hashMap.keySet()) {
                try {
                    str2 = (String) hashMap.get(str32);
                    if (str2 != null) {
                        hashMap.put(str32, URLEncoder.encode(str2, HttpRequest.f14548a));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return a.m7460i().addParameters(str, hashMap);
    }

    public Boolean isHttpProtocol(String str) {
        return m7475a(str, "http:");
    }

    public Boolean isHttpsProtocol(String str) {
        return m7475a(str, "https:");
    }

    public void pintHttpInNewThread(String str) {
        C2021a c2021a = new C2021a();
        C2024d c2024d = new C2024d(str, BuildConfig.FLAVOR);
        c2024d.f7057e = 1;
        c2021a.m7547a(c2024d, Boolean.valueOf(true));
    }
}
