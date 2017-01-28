import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.eclipse.jgit.JGitText;

public class avj extends atv implements auc, avw {
    private static final String VH;
    static final avl Zo;
    private static final ani$b<avj$b> gn;
    static final avl v5;
    private final avj$b EQ;
    private boolean J0;
    private atu J8;
    private final URL tp;
    private final URL u7;
    private final ProxySelector we;

    static {
        VH = j6();
        v5 = new avj$1();
        Zo = new avj$2();
        gn = new avj$3();
    }

    private static String j6() {
        String str;
        Package packageR = avj.class.getPackage();
        if (packageR == null || packageR.getImplementationVersion() == null) {
            str = "unknown";
        } else {
            str = packageR.getImplementationVersion();
        }
        return "JGit/" + str;
    }

    avj(aoh aoh, avn avn) {
        super(aoh, avn);
        this.J0 = true;
        this.J8 = atu.j6;
        try {
            String avn2 = avn.toString();
            if (!avn2.endsWith("/")) {
                avn2 = new StringBuilder(String.valueOf(avn2)).append("/").toString();
            }
            this.u7 = new URL(avn2);
            this.tp = new URL(this.u7, "objects/");
            this.EQ = (avj$b) aoh.VH().j6(gn);
            this.we = ProxySelector.getDefault();
        } catch (Throwable e) {
            throw new alm(MessageFormat.format(JGitText.j6().invalidURL, new Object[]{avn}), e);
        }
    }

    public atq QX() {
        String str = "git-upload-pack";
        InputStream j6;
        try {
            atq avj_e;
            HttpURLConnection FH = FH("git-upload-pack");
            j6 = j6(FH);
            if (j6(FH, "git-upload-pack")) {
                j6(j6, "git-upload-pack");
                avj_e = new avj$e(this, j6);
                j6.close();
            } else {
                avj_e = j6(j6);
                j6.close();
            }
            return avj_e;
        } catch (alm e) {
            throw e;
        } catch (amb e2) {
            throw e2;
        } catch (Throwable e3) {
            throw new amb(this.Hw, JGitText.j6().errorReadingInfoRefs, e3);
        } catch (Throwable th) {
            j6.close();
        }
    }

    private atq j6(InputStream inputStream) {
        avv avj_c = new avj$c(this, this.tp);
        BufferedReader DW = DW(inputStream);
        try {
            Map j6 = avj_c.j6(DW);
            if (!j6.containsKey("HEAD")) {
                HttpURLConnection j62 = j6(new URL(this.u7, "HEAD"));
                switch (aww.j6(j62)) {
                    case 200:
                        BufferedReader DW2 = DW(j6(j62));
                        try {
                            String readLine = DW2.readLine();
                            aoc aom;
                            if (readLine != null && readLine.startsWith("ref: ")) {
                                String substring = readLine.substring("ref: ".length());
                                aoc aoc = (aoc) j6.get(substring);
                                if (aoc == null) {
                                    aoc = new anu$c(aoc$a.NEW, substring, null);
                                }
                                aom = new aom("HEAD", aoc);
                                j6.put(aom.j6(), aom);
                            } else if (readLine != null) {
                                if (ans.j6(readLine)) {
                                    aom = new anu$c(aoc$a.NETWORK, "HEAD", ans.DW(readLine));
                                    j6.put(aom.j6(), aom);
                                }
                            }
                            DW2.close();
                            break;
                        } catch (Throwable th) {
                            DW2.close();
                        }
                        break;
                    case 404:
                        break;
                    default:
                        throw new amb(this.Hw, MessageFormat.format(JGitText.j6().cannotReadHEAD, new Object[]{Integer.valueOf(r3), j62.getResponseMessage()}));
                }
            }
            atq avt = new avt(this, avj_c);
            avt.j6(j6);
            return avt;
        } finally {
            DW.close();
        }
    }

    private BufferedReader DW(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream, anj.DW));
    }

    public auj XL() {
        String str = "git-receive-pack";
        InputStream j6;
        try {
            HttpURLConnection FH = FH("git-receive-pack");
            j6 = j6(FH);
            if (j6(FH, "git-receive-pack")) {
                j6(j6, "git-receive-pack");
                auj avj_f = new avj$f(this, j6);
                j6.close();
                return avj_f;
            } else if (this.J0) {
                throw new alm(JGitText.j6().remoteDoesNotSupportSmartHTTPPush);
            } else {
                throw new alm(JGitText.j6().smartHTTPPushDisabled);
            }
        } catch (alm e) {
            throw e;
        } catch (amb e2) {
            throw e2;
        } catch (Throwable e3) {
            throw new amb(this.Hw, JGitText.j6().errorReadingInfoRefs, e3);
        } catch (Throwable th) {
            j6.close();
        }
    }

    public void DW() {
    }

    private HttpURLConnection FH(String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u7);
            if (stringBuilder.charAt(stringBuilder.length() - 1) != '/') {
                stringBuilder.append('/');
            }
            stringBuilder.append("info/refs");
            if (this.J0) {
                stringBuilder.append(stringBuilder.indexOf("?") < 0 ? '?' : '&');
                stringBuilder.append("service=");
                stringBuilder.append(str);
            }
            URL url = new URL(stringBuilder.toString());
            int i = 1;
            while (true) {
                try {
                    HttpURLConnection j6 = j6(url);
                    if (this.J0) {
                        j6.setRequestProperty("Accept", new StringBuilder(String.valueOf("application/x-" + str + "-advertisement")).append(", */*").toString());
                    } else {
                        j6.setRequestProperty("Accept", "*/*");
                    }
                    int j62 = aww.j6(j6);
                    switch (j62) {
                        case 200:
                            return j6;
                        case 401:
                            this.J8 = atu.j6(j6);
                            if (this.J8 == atu.j6) {
                                throw new amb(this.Hw, MessageFormat.format(JGitText.j6().authenticationNotSupported, new Object[]{this.Hw}));
                            } else if (1 < i || !this.J8.j6(this.Hw, Ws())) {
                                throw new amb(this.Hw, JGitText.j6().notAuthorized);
                            } else {
                                i++;
                            }
                            break;
                        case 403:
                            throw new amb(this.Hw, MessageFormat.format(JGitText.j6().serviceNotPermitted, new Object[]{str}));
                        case 404:
                            throw new alk(this.Hw, MessageFormat.format(JGitText.j6().uriNotFound, new Object[]{url}));
                        default:
                            throw new amb(this.Hw, new StringBuilder(String.valueOf(j62)).append(" ").append(j6.getResponseMessage()).toString());
                    }
                } catch (alm e) {
                    throw e;
                } catch (amb e2) {
                    throw e2;
                } catch (Throwable e3) {
                    throw new amb(this.Hw, MessageFormat.format(JGitText.j6().cannotOpenService, new Object[]{str}), e3);
                }
            }
        } catch (Throwable e32) {
            throw new alm(MessageFormat.format(JGitText.j6().invalidURL, new Object[]{this.Hw}), e32);
        }
    }

    final HttpURLConnection j6(URL url) {
        return j6("GET", url);
    }

    final HttpURLConnection j6(String str, URL url) {
        URLConnection uRLConnection = (HttpURLConnection) url.openConnection(aww.j6(this.we, url));
        if (!this.EQ.DW && "https".equals(url.getProtocol())) {
            j6(uRLConnection);
        }
        uRLConnection.setRequestMethod(str);
        uRLConnection.setUseCaches(false);
        uRLConnection.setRequestProperty("Accept-Encoding", "gzip");
        uRLConnection.setRequestProperty("Pragma", "no-cache");
        uRLConnection.setRequestProperty("User-Agent", VH);
        uRLConnection.setConnectTimeout(J0() * 1000);
        uRLConnection.setReadTimeout(J0() * 1000);
        this.J8.DW(uRLConnection);
        return uRLConnection;
    }

    private void j6(URLConnection uRLConnection) {
        TrustManager[] trustManagerArr = new TrustManager[]{new avj$a()};
        try {
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, null);
            ((HttpsURLConnection) uRLConnection).setSSLSocketFactory(instance.getSocketFactory());
        } catch (KeyManagementException e) {
            throw new IOException(e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    final InputStream j6(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        if ("gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    IOException j6(String str, String str2) {
        return new amb(this.Hw, MessageFormat.format(JGitText.j6().expectedReceivedContentType, new Object[]{str, str2}));
    }

    private boolean j6(HttpURLConnection httpURLConnection, String str) {
        return ("application/x-" + str + "-advertisement").equals(httpURLConnection.getContentType());
    }

    private void j6(InputStream inputStream, String str) {
        byte[] bArr = new byte[5];
        awx.j6(inputStream, bArr, 0, bArr.length);
        if (bArr[4] != 35) {
            throw new amb(this.Hw, MessageFormat.format(JGitText.j6().expectedPktLineWithService, new Object[]{axe.DW(bArr)}));
        }
        aue aue = new aue(new axu(new ByteArrayInputStream(bArr), inputStream));
        if (("# service=" + str).equals(aue.j6())) {
            do {
            } while (aue.j6() != aue.j6);
            return;
        }
        throw new amb(this.Hw, MessageFormat.format(JGitText.j6().expectedGot, new Object[]{r0, r2}));
    }
}
