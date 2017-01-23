package com.antutu.benchmark.platform.p054e;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.platform.e.a */
public class C1576a {
    public static String m6239b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                byteArrayOutputStream.close();
                bufferedInputStream.close();
            }
        }
        return byteArrayOutputStream.toString(HttpRequest.f14548a);
    }

    public List<Map> m6240a(InputStream inputStream) {
        List<Map> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(C1576a.m6239b(inputStream));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Map hashMap = new HashMap();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if ("user".equals(str)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                        Iterator keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            str = (String) keys2.next();
                            hashMap.put("user." + str, jSONObject2.get(str));
                        }
                    } else {
                        hashMap.put(str, jSONObject.get(str));
                    }
                }
                arrayList.add(hashMap);
            }
        } catch (Exception e) {
        }
        return arrayList;
    }
}
