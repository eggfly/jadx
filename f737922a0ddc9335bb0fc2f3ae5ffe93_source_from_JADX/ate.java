import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestOutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.jgit.JGitText;

public class ate {
    private static final Set<String> j6;
    private final String DW;
    private final SecretKeySpec FH;
    private final ProxySelector Hw;
    private final avs VH;
    private final int Zo;
    private final String v5;

    static {
        j6 = new HashSet();
        j6.add("content-type");
        j6.add("content-md5");
        j6.add("date");
    }

    private static boolean j6(String str) {
        String j6 = axh.j6(str);
        return j6.contains(j6) || j6.startsWith("x-amz-");
    }

    private static String j6(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(str.replaceAll("\n", "").trim());
        }
        return stringBuilder.toString();
    }

    private static String j6(Map<String, String> map, String str) {
        String str2 = (String) map.remove(str);
        return str2 != null ? str2 : "";
    }

    private static String j6() {
        String str = "GMT";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date()) + " " + "GMT";
    }

    private static MessageDigest DW() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            throw new RuntimeException(JGitText.j6().JRELacksMD5Implementation, e);
        }
    }

    public ate(Properties properties) {
        this.DW = properties.getProperty("accesskey");
        if (this.DW == null) {
            throw new IllegalArgumentException(JGitText.j6().missingAccesskey);
        }
        String property = properties.getProperty("secretkey");
        if (property == null) {
            throw new IllegalArgumentException(JGitText.j6().missingSecretkey);
        }
        this.FH = new SecretKeySpec(anj.j6(property), "HmacSHA1");
        property = properties.getProperty("acl", "PRIVATE");
        if (axh.j6("PRIVATE", property)) {
            this.v5 = "private";
        } else if (axh.j6("PUBLIC", property)) {
            this.v5 = "public-read";
        } else if (axh.j6("PUBLIC-READ", property)) {
            this.v5 = "public-read";
        } else if (axh.j6("PUBLIC_READ", property)) {
            this.v5 = "public-read";
        } else {
            throw new IllegalArgumentException("Invalid acl: " + property);
        }
        try {
            String property2 = properties.getProperty("password");
            if (property2 != null) {
                property = properties.getProperty("crypto.algorithm");
                if (property == null) {
                    property = "PBEWithMD5AndDES";
                }
                this.VH = new avs$b(property, property2);
            } else {
                this.VH = avs.j6;
            }
            this.Zo = Integer.parseInt(properties.getProperty("httpclient.retry-max", "3"));
            this.Hw = ProxySelector.getDefault();
        } catch (Throwable e) {
            throw new IllegalArgumentException(JGitText.j6().invalidEncryption, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException(JGitText.j6().invalidEncryption, e2);
        }
    }

    public URLConnection j6(String str, String str2) {
        int i = 0;
        while (i < this.Zo) {
            HttpURLConnection j6 = j6("GET", str, str2);
            j6(j6);
            switch (aww.j6(j6)) {
                case 200:
                    this.VH.DW(j6, "x-amz-meta-");
                    return j6;
                case 404:
                    throw new FileNotFoundException(str2);
                case 500:
                    i++;
                default:
                    throw j6("Reading", str2, j6);
            }
        }
        throw Hw("Reading", str2);
    }

    public InputStream j6(URLConnection uRLConnection) {
        return this.VH.j6(uRLConnection.getInputStream());
    }

    public List<String> DW(String str, String str2) {
        if (str2.length() > 0 && !str2.endsWith("/")) {
            str2 = new StringBuilder(String.valueOf(str2)).append("/").toString();
        }
        ate$a ate_a = new ate$a(this, str, str2);
        do {
            ate_a.j6();
        } while (ate_a.DW);
        return ate_a.j6;
    }

    public void FH(String str, String str2) {
        int i = 0;
        while (i < this.Zo) {
            HttpURLConnection j6 = j6("DELETE", str, str2);
            j6(j6);
            switch (aww.j6(j6)) {
                case 204:
                    return;
                case 500:
                    i++;
                default:
                    throw j6("Deletion", str2, j6);
            }
        }
        throw Hw("Deletion", str2);
    }

    public void j6(String str, String str2, byte[] bArr) {
        if (this.VH != avs.j6) {
            OutputStream j6 = j6(str, str2, null, null);
            j6.write(bArr);
            j6.close();
            return;
        }
        String j62 = awm.j6(DW().digest(bArr));
        String valueOf = String.valueOf(bArr.length);
        int i = 0;
        while (i < this.Zo) {
            HttpURLConnection j63 = j6("PUT", str, str2);
            j63.setRequestProperty("Content-Length", valueOf);
            j63.setRequestProperty("Content-MD5", j62);
            j63.setRequestProperty("x-amz-acl", this.v5);
            j6(j63);
            j63.setDoOutput(true);
            j63.setFixedLengthStreamingMode(bArr.length);
            OutputStream outputStream = j63.getOutputStream();
            try {
                outputStream.write(bArr);
                switch (aww.j6(j63)) {
                    case 200:
                        return;
                    case 500:
                        i++;
                    default:
                        throw j6("Writing", str2, j63);
                }
            } finally {
                outputStream.close();
            }
        }
        throw Hw("Writing", str2);
    }

    public OutputStream j6(String str, String str2, aob aob, String str3) {
        MessageDigest DW = DW();
        return this.VH.j6(new DigestOutputStream(new ate$1(this, str, str2, DW, aob, str3), DW));
    }

    private void j6(String str, String str2, byte[] bArr, axj axj, aob aob, String str3) {
        int i = 0;
        if (aob == null) {
            aob = anp.j6;
        }
        if (str3 == null) {
            str3 = MessageFormat.format(JGitText.j6().progressMonUploading, new Object[]{str2});
        }
        String j6 = awm.j6(bArr);
        long DW = axj.DW();
        String valueOf = String.valueOf(DW);
        while (i < this.Zo) {
            HttpURLConnection j62 = j6("PUT", str, str2);
            j62.setRequestProperty("Content-Length", valueOf);
            j62.setRequestProperty("Content-MD5", j6);
            j62.setRequestProperty("x-amz-acl", this.v5);
            this.VH.j6(j62, "x-amz-meta-");
            j6(j62);
            j62.setDoOutput(true);
            j62.setFixedLengthStreamingMode((int) DW);
            aob.j6(str3, (int) (DW / 1024));
            OutputStream outputStream = j62.getOutputStream();
            try {
                axj.j6(outputStream, aob);
                switch (aww.j6(j62)) {
                    case 200:
                        return;
                    case 500:
                        i++;
                    default:
                        throw j6("Writing", str2, j62);
                }
            } finally {
                aob.DW();
                outputStream.close();
            }
        }
        throw Hw("Writing", str2);
    }

    private IOException j6(String str, String str2, HttpURLConnection httpURLConnection) {
        IOException iOException = new IOException(MessageFormat.format(JGitText.j6().amazonS3ActionFailed, new Object[]{str, str2, Integer.valueOf(aww.j6(httpURLConnection)), httpURLConnection.getResponseMessage()}));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = httpURLConnection.getErrorStream().read(bArr);
            if (read < 0) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        if (toByteArray.length > 0) {
            iOException.initCause(new IOException("\n" + new String(toByteArray)));
        }
        return iOException;
    }

    private IOException Hw(String str, String str2) {
        return new IOException(MessageFormat.format(JGitText.j6().amazonS3ActionFailedGivingUp, new Object[]{str, str2, Integer.valueOf(this.Zo)}));
    }

    private HttpURLConnection j6(String str, String str2, String str3) {
        return j6(str, str2, str3, Collections.emptyMap());
    }

    private HttpURLConnection j6(String str, String str2, String str3, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(str2);
        stringBuilder.append('.');
        stringBuilder.append("s3.amazonaws.com");
        stringBuilder.append('/');
        if (str3.length() > 0) {
            aww.j6(stringBuilder, str3);
        }
        if (!map.isEmpty()) {
            stringBuilder.append('?');
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append('=');
                aww.j6(stringBuilder, (String) entry.getValue());
                if (it.hasNext()) {
                    stringBuilder.append('&');
                }
            }
        }
        URL url = new URL(stringBuilder.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(aww.j6(this.Hw, url));
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setRequestProperty("User-Agent", "jgit/1.0");
        httpURLConnection.setRequestProperty("Date", j6());
        return httpURLConnection;
    }

    private void j6(HttpURLConnection httpURLConnection) {
        Map requestProperties = httpURLConnection.getRequestProperties();
        Map treeMap = new TreeMap();
        for (Entry entry : requestProperties.entrySet()) {
            String str = (String) entry.getKey();
            if (j6(str)) {
                treeMap.put(axh.j6(str), j6((List) entry.getValue()));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpURLConnection.getRequestMethod());
        stringBuilder.append('\n');
        stringBuilder.append(j6(treeMap, "content-md5"));
        stringBuilder.append('\n');
        stringBuilder.append(j6(treeMap, "content-type"));
        stringBuilder.append('\n');
        stringBuilder.append(j6(treeMap, "date"));
        stringBuilder.append('\n');
        for (Entry entry2 : treeMap.entrySet()) {
            stringBuilder.append((String) entry2.getKey());
            stringBuilder.append(':');
            stringBuilder.append((String) entry2.getValue());
            stringBuilder.append('\n');
        }
        String host = httpURLConnection.getURL().getHost();
        stringBuilder.append('/');
        stringBuilder.append(host.substring(0, (host.length() - "s3.amazonaws.com".length()) - 1));
        stringBuilder.append(httpURLConnection.getURL().getPath());
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(this.FH);
            httpURLConnection.setRequestProperty("Authorization", "AWS " + this.DW + ":" + awm.j6(instance.doFinal(stringBuilder.toString().getBytes("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(MessageFormat.format(JGitText.j6().noHMACsupport, new Object[]{"HmacSHA1", e.getMessage()}));
        } catch (InvalidKeyException e2) {
            throw new IOException(MessageFormat.format(JGitText.j6().invalidKey, new Object[]{e2.getMessage()}));
        }
    }

    static Properties j6(File file) {
        Properties properties = new Properties();
        InputStream fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            return properties;
        } finally {
            fileInputStream.close();
        }
    }
}
