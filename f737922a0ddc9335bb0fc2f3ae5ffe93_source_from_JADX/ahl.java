import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class ahl {
    public static final String[] Hw;
    static agz j6;
    private static Pattern tp;
    Map<String, ahg> DW;
    ahg FH;
    ahl$a VH;
    Map<String, String> Zo;
    private boolean gn;
    private ahi u7;
    String v5;

    static {
        j6 = null;
        tp = Pattern.compile("^META-INF/(.*)[.](SF|RSA|DSA)$");
        Hw = new String[]{"auto-testkey", "auto", "auto-none", "media", "platform", "shared", "testkey", "none"};
    }

    public static agz j6() {
        if (j6 == null) {
            j6 = aha.j6(ahl.class.getName());
        }
        return j6;
    }

    public ahl() {
        this.gn = false;
        this.u7 = new ahi();
        this.DW = new HashMap();
        this.FH = null;
        this.v5 = "testkey";
        this.Zo = new HashMap();
        this.VH = new ahl$a();
        this.Zo.put("aa9852bc5a53272ac8031d49b65e4b0e", "media");
        this.Zo.put("e60418c4b638f20d0721e115674ca11f", "platform");
        this.Zo.put("3e24e49741b60c215c010dc6048fca7d", "shared");
        this.Zo.put("dab2cead827ef5313f28e22b6fa8479f", "testkey");
    }

    public void j6(String str) {
        if (j6().j6()) {
            j6().Hw("setKeymode: " + str);
        }
        this.v5 = str;
        if (this.v5.startsWith("auto")) {
            this.FH = null;
            return;
        }
        this.u7.j6();
        DW(this.v5);
    }

    protected String j6(String str, Map<String, ahn> map) {
        boolean j6 = j6().j6();
        if (!str.startsWith("auto")) {
            return str;
        }
        String str2 = null;
        for (Entry entry : map.entrySet()) {
            String str3;
            String str4 = (String) entry.getKey();
            if (str4.startsWith("META-INF/") && str4.endsWith(".RSA")) {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] FH = ((ahn) entry.getValue()).FH();
                if (FH.length < 1458) {
                    break;
                }
                instance.update(FH, 0, 1458);
                byte[] digest = instance.digest();
                StringBuilder stringBuilder = new StringBuilder();
                int length = digest.length;
                for (int i = 0; i < length; i++) {
                    stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                }
                str3 = (String) this.Zo.get(stringBuilder.toString());
                if (j6) {
                    if (str3 != null) {
                        j6().Hw(String.format("Auto-determined key=%s using md5=%s", new Object[]{str3, str4}));
                    } else {
                        j6().Hw(String.format("Auto key determination failed for md5=%s", new Object[]{str4}));
                    }
                }
                if (str3 != null) {
                    return str3;
                }
            } else {
                str3 = str2;
            }
            str2 = str3;
        }
        if (str.equals("auto-testkey")) {
            if (j6) {
                j6().Hw("Falling back to key=" + str2);
            }
            return "testkey";
        } else if (!str.equals("auto-none")) {
            return null;
        } else {
            if (j6) {
                j6().Hw("Unable to determine key, returning: none");
            }
            return "none";
        }
    }

    public void DW(String str) {
        this.FH = (ahg) this.DW.get(str);
        if (this.FH == null) {
            this.FH = new ahg();
            this.FH.j6(str);
            this.DW.put(str, this.FH);
            if (!"none".equals(str)) {
                this.u7.j6(1, "Loading certificate and private key");
                this.FH.j6(j6(getClass().getResource("/keys/" + str + ".pk8"), null));
                this.FH.j6(j6(getClass().getResource("/keys/" + str + ".x509.pem")));
                URL resource = getClass().getResource("/keys/" + str + ".sbt");
                if (resource != null) {
                    this.FH.j6(DW(resource));
                }
            }
        }
    }

    public void j6(String str, X509Certificate x509Certificate, PrivateKey privateKey, byte[] bArr) {
        this.FH = new ahg(str, x509Certificate, privateKey, bArr);
    }

    public X509Certificate j6(URL url) {
        InputStream openStream = url.openStream();
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(openStream);
            return x509Certificate;
        } finally {
            openStream.close();
        }
    }

    private KeySpec j6(byte[] bArr, String str) {
        try {
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(bArr);
            Key generateSecret = SecretKeyFactory.getInstance(encryptedPrivateKeyInfo.getAlgName()).generateSecret(new PBEKeySpec(str.toCharArray()));
            Cipher instance = Cipher.getInstance(encryptedPrivateKeyInfo.getAlgName());
            instance.init(2, generateSecret, encryptedPrivateKeyInfo.getAlgParameters());
            try {
                return encryptedPrivateKeyInfo.getKeySpec(instance);
            } catch (InvalidKeySpecException e) {
                j6().j6("signapk: Password for private key may be bad.");
                throw e;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public byte[] DW(URL url) {
        return j6(url.openStream());
    }

    public byte[] j6(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        int read = inputStream.read(bArr);
        while (read != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public PrivateKey j6(URL url, String str) {
        PrivateKey generatePrivate;
        InputStream dataInputStream = new DataInputStream(url.openStream());
        KeySpec j6;
        try {
            byte[] j62 = j6(dataInputStream);
            j6 = j6(j62, str);
            if (j6 == null) {
                j6 = new PKCS8EncodedKeySpec(j62);
            }
            generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(j6);
        } catch (InvalidKeySpecException e) {
            generatePrivate = KeyFactory.getInstance("DSA").generatePrivate(j6);
        } finally {
            dataInputStream.close();
        }
        return generatePrivate;
    }

    private Manifest j6(Map<String, ahn> map) {
        Manifest manifest;
        ahn ahn = (ahn) map.get("META-INF/MANIFEST.MF");
        if (ahn != null) {
            manifest = new Manifest();
            manifest.read(ahn.Hw());
        } else {
            manifest = null;
        }
        Manifest manifest2 = new Manifest();
        Attributes mainAttributes = manifest2.getMainAttributes();
        if (manifest != null) {
            mainAttributes.putAll(manifest.getMainAttributes());
        } else {
            mainAttributes.putValue("Manifest-Version", "1.0");
            mainAttributes.putValue("Created-By", "1.0 (Android SignApk)");
        }
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        byte[] bArr = new byte[512];
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        boolean j6 = j6().j6();
        if (j6) {
            j6().Hw("Manifest entries:");
        }
        for (ahn ahn2 : treeMap.values()) {
            if (this.gn) {
                break;
            }
            Object gn = ahn2.gn();
            if (j6) {
                j6().Hw(gn);
            }
            if (!(ahn2.VH() || gn.equals("META-INF/MANIFEST.MF") || gn.equals("META-INF/CERT.SF") || gn.equals("META-INF/CERT.RSA"))) {
                if (tp == null || !tp.matcher(gn).matches()) {
                    this.u7.j6(0, "Generating manifest");
                    InputStream Hw = ahn2.Hw();
                    while (true) {
                        int read = Hw.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                    if (manifest != null) {
                        Attributes attributes = manifest.getAttributes(gn);
                        if (attributes != null) {
                            mainAttributes = new Attributes(attributes);
                            if (mainAttributes == null) {
                                mainAttributes = new Attributes();
                            }
                            mainAttributes.putValue("SHA1-Digest", ahd.j6(instance.digest()));
                            manifest2.getEntries().put(gn, mainAttributes);
                        }
                    }
                    mainAttributes = null;
                    if (mainAttributes == null) {
                        mainAttributes = new Attributes();
                    }
                    mainAttributes.putValue("SHA1-Digest", ahd.j6(instance.digest()));
                    manifest2.getEntries().put(gn, mainAttributes);
                }
            }
        }
        return manifest2;
    }

    private void j6(Manifest manifest, OutputStream outputStream) {
        outputStream.write("Signature-Version: 1.0\r\n".getBytes());
        outputStream.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        OutputStream printStream = new PrintStream(new DigestOutputStream(new ByteArrayOutputStream(), instance), true, "UTF-8");
        manifest.write(printStream);
        printStream.flush();
        outputStream.write(("SHA1-Digest-Manifest: " + ahd.j6(instance.digest()) + "\r\n\r\n").getBytes());
        for (Entry entry : manifest.getEntries().entrySet()) {
            if (!this.gn) {
                this.u7.j6(0, "Generating signature file");
                String str = "Name: " + ((String) entry.getKey()) + "\r\n";
                printStream.print(str);
                for (Entry entry2 : ((Attributes) entry2.getValue()).entrySet()) {
                    printStream.print(entry2.getKey() + ": " + entry2.getValue() + "\r\n");
                }
                printStream.print("\r\n");
                printStream.flush();
                outputStream.write(str.getBytes());
                outputStream.write(("SHA1-Digest: " + ahd.j6(instance.digest()) + "\r\n\r\n").getBytes());
            } else {
                return;
            }
        }
    }

    private void j6(byte[] bArr, byte[] bArr2, X509Certificate x509Certificate, OutputStream outputStream) {
        if (bArr != null) {
            outputStream.write(bArr);
            outputStream.write(bArr2);
            return;
        }
        try {
            Method method = Class.forName("kellinwood.sigblock.SignatureBlockWriter").getMethod("writeSignatureBlock", new Class[]{new byte[1].getClass(), X509Certificate.class, OutputStream.class});
            if (method == null) {
                throw new IllegalStateException("writeSignatureBlock() method not found.");
            }
            method.invoke(null, new Object[]{bArr2, x509Certificate, outputStream});
        } catch (Throwable e) {
            j6().j6(e.getMessage(), e);
            throw new IllegalStateException("Failed to invoke writeSignatureBlock(): " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private void j6(Manifest manifest, Map<String, ahn> map, ahs ahs, long j) {
        List<String> arrayList = new ArrayList(manifest.getEntries().keySet());
        Collections.sort(arrayList);
        int i = 1;
        for (String str : arrayList) {
            if (!this.gn) {
                this.u7.j6(0, String.format("Copying zip entry %d of %d", new Object[]{Integer.valueOf(i), Integer.valueOf(arrayList.size())}));
                i++;
                ahn ahn = (ahn) map.get(str);
                ahn.j6(j);
                ahs.j6(ahn);
            } else {
                return;
            }
        }
    }

    private void j6(Map<String, ahn> map, ahs ahs) {
        int i = 1;
        for (ahn ahn : map.values()) {
            if (!this.gn) {
                this.u7.j6(0, String.format("Copying zip entry %d of %d", new Object[]{Integer.valueOf(i), Integer.valueOf(map.size())}));
                i++;
                ahs.j6(ahn);
            } else {
                return;
            }
        }
    }

    public void j6(String str, String str2) {
        if (new File(str).getCanonicalFile().equals(new File(str2).getCanonicalFile())) {
            throw new IllegalArgumentException("Input and output files are the same.  Specify a different name for the output.");
        }
        this.u7.j6();
        this.u7.j6(1, "Parsing the input's central directory");
        j6(ahq.j6(str).j6(), new FileOutputStream(str2), str2);
    }

    public void j6(Map<String, ahn> map, OutputStream outputStream, String str) {
        Throwable th;
        boolean j6 = j6().j6();
        this.u7.j6();
        if (this.FH == null) {
            if (this.v5.startsWith("auto")) {
                String j62 = j6(this.v5, (Map) map);
                if (j62 == null) {
                    throw new ahc("Unable to auto-select key for signing " + new File(str).getName());
                }
                this.VH.notifyObservers(j62);
                DW(j62);
            } else {
                throw new IllegalStateException("No keys configured for signing the file!");
            }
        }
        ahs ahs;
        try {
            ahs = new ahs(outputStream);
            try {
                if ("none".equals(this.FH.j6())) {
                    this.u7.j6(map.size());
                    this.u7.DW(0);
                    j6((Map) map, ahs);
                    ahs.j6();
                    if (this.gn && str != null) {
                        try {
                            new File(str).delete();
                            return;
                        } catch (Throwable th2) {
                            j6().DW(th2.getClass().getName() + ":" + th2.getMessage());
                            return;
                        }
                    }
                    return;
                }
                ahn ahn;
                int i = 0;
                for (ahn ahn2 : map.values()) {
                    int i2;
                    CharSequence gn = ahn2.gn();
                    if (ahn2.VH() || gn.equals("META-INF/MANIFEST.MF") || gn.equals("META-INF/CERT.SF") || gn.equals("META-INF/CERT.RSA") || (tp != null && tp.matcher(gn).matches())) {
                        i2 = i;
                    } else {
                        i2 = i + 3;
                    }
                    i = i2;
                }
                this.u7.j6(i + 1);
                this.u7.DW(0);
                long time = 3600000 + this.FH.DW().getNotBefore().getTime();
                Manifest j63 = j6((Map) map);
                if (this.gn) {
                    ahs.j6();
                    if (this.gn && str != null) {
                        try {
                            new File(str).delete();
                            return;
                        } catch (Throwable th22) {
                            j6().DW(th22.getClass().getName() + ":" + th22.getMessage());
                            return;
                        }
                    }
                    return;
                }
                ahn2 = new ahn("META-INF/MANIFEST.MF");
                ahn2.j6(time);
                j63.write(ahn2.v5());
                ahs.j6(ahn2);
                ahk ahk = new ahk();
                ahk.j6(this.FH.FH());
                ahn ahn3 = new ahn("META-INF/CERT.SF");
                ahn3.j6(time);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                j6(j63, byteArrayOutputStream);
                if (this.gn) {
                    ahs.j6();
                    if (this.gn && str != null) {
                        try {
                            new File(str).delete();
                            return;
                        } catch (Throwable th222) {
                            j6().DW(th222.getClass().getName() + ":" + th222.getMessage());
                            return;
                        }
                    }
                    return;
                }
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (j6) {
                    j6().Hw("Signature File: \n" + new String(toByteArray) + "\n" + ahe.j6(toByteArray));
                }
                ahn3.v5().write(toByteArray);
                ahs.j6(ahn3);
                ahk.j6(toByteArray);
                byte[] j64 = ahk.j6();
                if (j6) {
                    MessageDigest instance = MessageDigest.getInstance("SHA1");
                    instance.update(toByteArray);
                    j6().Hw("Sig File SHA1: \n" + ahe.j6(instance.digest()));
                    j6().Hw("Signature: \n" + ahe.j6(j64));
                    Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance2.init(2, this.FH.DW());
                    j6().Hw("Signature Decrypted: \n" + ahe.j6(instance2.doFinal(j64)));
                }
                this.u7.j6(0, "Generating signature block file");
                ahn ahn4 = new ahn("META-INF/CERT.RSA");
                ahn4.j6(time);
                j6(this.FH.Hw(), j64, this.FH.DW(), ahn4.v5());
                ahs.j6(ahn4);
                if (this.gn) {
                    ahs.j6();
                    if (this.gn && str != null) {
                        try {
                            new File(str).delete();
                            return;
                        } catch (Throwable th2222) {
                            j6().DW(th2222.getClass().getName() + ":" + th2222.getMessage());
                            return;
                        }
                    }
                    return;
                }
                j6(j63, (Map) map, ahs, time);
                if (this.gn) {
                    ahs.j6();
                    if (this.gn && str != null) {
                        try {
                            new File(str).delete();
                            return;
                        } catch (Throwable th22222) {
                            j6().DW(th22222.getClass().getName() + ":" + th22222.getMessage());
                            return;
                        }
                    }
                    return;
                }
                ahs.j6();
                if (this.gn && str != null) {
                    try {
                        new File(str).delete();
                    } catch (Throwable th222222) {
                        j6().DW(th222222.getClass().getName() + ":" + th222222.getMessage());
                    }
                }
            } catch (Throwable th3) {
                th222222 = th3;
                ahs.j6();
                try {
                    new File(str).delete();
                } catch (Throwable th4) {
                    j6().DW(th4.getClass().getName() + ":" + th4.getMessage());
                }
                throw th222222;
            }
        } catch (Throwable th5) {
            th222222 = th5;
            ahs = null;
            ahs.j6();
            if (this.gn && str != null) {
                new File(str).delete();
            }
            throw th222222;
        }
    }
}
