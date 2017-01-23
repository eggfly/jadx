import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

class atu$b extends atu {
    private static final Random DW;
    private static final char[] VH;
    private final Map<String, String> FH;
    private int Hw;
    private String Zo;
    private String v5;

    static {
        DW = new Random();
        VH = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    atu$b(String str) {
        this.FH = DW(str);
        if ("auth".equals((String) this.FH.get("qop"))) {
            byte[] bArr = new byte[8];
            DW.nextBytes(bArr);
            this.FH.put("cnonce", awm.j6(bArr));
        }
    }

    void j6(String str, String str2) {
        this.v5 = str;
        this.Zo = str2;
    }

    void DW(HttpURLConnection httpURLConnection) {
        Object DW;
        Object obj;
        Map linkedHashMap = new LinkedHashMap();
        String str = (String) this.FH.get("realm");
        String str2 = (String) this.FH.get("nonce");
        String str3 = (String) this.FH.get("cnonce");
        String j6 = j6(httpURLConnection.getURL());
        String str4 = (String) this.FH.get("qop");
        String requestMethod = httpURLConnection.getRequestMethod();
        String str5 = this.v5 + ":" + str + ":" + this.Zo;
        requestMethod = new StringBuilder(String.valueOf(requestMethod)).append(":").append(j6).toString();
        linkedHashMap.put("username", this.v5);
        linkedHashMap.put("realm", str);
        linkedHashMap.put("nonce", str2);
        linkedHashMap.put("uri", j6);
        if ("auth".equals(str4)) {
            Object[] objArr = new Object[1];
            int i = this.Hw + 1;
            this.Hw = i;
            objArr[0] = Integer.valueOf(i);
            str = String.format("%08x", objArr);
            String str6 = str;
            DW = DW(j6(str5), new StringBuilder(String.valueOf(str2)).append(":").append(str).append(":").append(str3).append(":").append(str4).append(":").append(j6(requestMethod)).toString());
            obj = str6;
        } else {
            str = DW(j6(str5), new StringBuilder(String.valueOf(str2)).append(":").append(j6(requestMethod)).toString());
            obj = null;
        }
        linkedHashMap.put("response", DW);
        if (this.FH.containsKey("algorithm")) {
            linkedHashMap.put("algorithm", "MD5");
        }
        if (!(str3 == null || str4 == null)) {
            linkedHashMap.put("cnonce", str3);
        }
        if (this.FH.containsKey("opaque")) {
            linkedHashMap.put("opaque", (String) this.FH.get("opaque"));
        }
        if (str4 != null) {
            linkedHashMap.put("qop", str4);
        }
        if (obj != null) {
            linkedHashMap.put("nc", obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : linkedHashMap.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append('=');
            stringBuilder.append('\"');
            stringBuilder.append((String) entry.getValue());
            stringBuilder.append('\"');
        }
        httpURLConnection.setRequestProperty("Authorization", "Digest " + stringBuilder);
    }

    private static String j6(URL url) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url.getProtocol());
        stringBuilder.append("://");
        stringBuilder.append(url.getHost());
        if (url.getPort() > 0 && !((url.getPort() == 80 && "http".equals(url.getProtocol())) || (url.getPort() == 443 && "https".equals(url.getProtocol())))) {
            stringBuilder.append(':').append(url.getPort());
        }
        stringBuilder.append(url.getPath());
        if (url.getQuery() != null) {
            stringBuilder.append('?').append(url.getQuery());
        }
        return stringBuilder.toString();
    }

    private static String j6(String str) {
        try {
            MessageDigest j6 = j6();
            j6.update(str.getBytes("UTF-8"));
            return j6(j6.digest());
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 encoding not available", e);
        }
    }

    private static String DW(String str, String str2) {
        try {
            MessageDigest j6 = j6();
            j6.update(str.getBytes("UTF-8"));
            j6.update((byte) 58);
            j6.update(str2.getBytes("UTF-8"));
            return j6(j6.digest());
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 encoding not available", e);
        }
    }

    private static MessageDigest j6() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            throw new RuntimeException("No MD5 available", e);
        }
    }

    private static String j6(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(VH[(b >>> 4) & 15]);
            stringBuilder.append(VH[b & 15]);
        }
        return stringBuilder.toString();
    }

    private static Map<String, String> DW(String str) {
        Map<String, String> hashMap = new HashMap();
        int i = 0;
        while (i < str.length()) {
            if (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
            int indexOf = str.indexOf(61, i);
            if (indexOf < 0 || indexOf + 1 == str.length()) {
                return Collections.emptyMap();
            }
            Object obj;
            String substring = str.substring(i, indexOf);
            int indexOf2;
            String substring2;
            if (str.charAt(indexOf + 1) == '\"') {
                indexOf2 = str.indexOf(34, indexOf + 2);
                if (indexOf2 < 0) {
                    return Collections.emptyMap();
                }
                substring2 = str.substring(indexOf + 2, indexOf2);
                i = indexOf2 + 1;
                obj = substring2;
            } else {
                indexOf2 = str.indexOf(32, indexOf + 1);
                i = str.indexOf(44, indexOf + 1);
                if (indexOf2 < 0) {
                    indexOf2 = str.length();
                }
                if (i < 0) {
                    i = str.length();
                }
                indexOf2 = Math.min(indexOf2, i);
                substring2 = str.substring(indexOf + 1, indexOf2);
                i = indexOf2 + 1;
                String str2 = substring2;
            }
            hashMap.put(substring, obj);
        }
        return hashMap;
    }
}
