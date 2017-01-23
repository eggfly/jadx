package com.mob.tools.network;

import com.xiaomi.mipush.sdk.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class HttpConnectionImpl implements HttpConnection {
    private HttpResponse response;

    public HttpConnectionImpl(HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    public InputStream getErrorStream() {
        return this.response.getEntity().getContent();
    }

    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> map = null;
        Header[] allHeaders = this.response.getAllHeaders();
        if (allHeaders != null) {
            map = new HashMap();
            for (Header header : allHeaders) {
                List arrayList = new ArrayList();
                map.put(header.getName(), arrayList);
                String[] split = header.getValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null) {
                    for (String trim : split) {
                        arrayList.add(trim.trim());
                    }
                }
            }
        }
        return map;
    }

    public InputStream getInputStream() {
        return this.response.getEntity().getContent();
    }

    public int getResponseCode() {
        return this.response.getStatusLine().getStatusCode();
    }
}
