import java.net.URLEncoder;
import java.util.Locale;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public abstract class aej implements aem {
    private final ael DW;
    private aek FH;
    private String Hw;
    private final aem$a j6;
    private HttpClient v5;

    public aej(ael ael, aem$a aem_a) {
        this(ael, aem_a, null);
    }

    public aej(ael ael, aem$a aem_a, aek aek) {
        this.FH = null;
        this.Hw = null;
        this.v5 = null;
        if (ael == null) {
            throw new IllegalArgumentException("'appKeyPair' must be non-null");
        } else if (aem_a == null) {
            throw new IllegalArgumentException("'type' must be non-null");
        } else {
            this.DW = ael;
            this.j6 = aem_a;
            this.FH = aek;
        }
    }

    public void j6(aek aek) {
        if (aek == null) {
            throw new IllegalArgumentException("'oauth1AccessToken' must be non-null");
        }
        this.FH = aek;
        this.Hw = null;
    }

    public void j6(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'oauth2AccessToken' must be non-null");
        }
        this.Hw = str;
        this.FH = null;
    }

    public ael Hw() {
        return this.DW;
    }

    public aek v5() {
        return this.FH;
    }

    public aem$a Zo() {
        return this.j6;
    }

    public Locale VH() {
        return Locale.ENGLISH;
    }

    public boolean gn() {
        return (this.FH == null && this.Hw == null) ? false : true;
    }

    public void FH() {
        this.FH = null;
        this.Hw = null;
    }

    public void j6(HttpRequest httpRequest) {
        String str;
        if (this.Hw != null) {
            str = "Bearer " + this.Hw;
        } else {
            str = j6(this.DW, this.FH);
        }
        httpRequest.addHeader("Authorization", str);
    }

    private static String j6(ael ael, aek aek) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth oauth_version=\"1.0\"");
        stringBuilder.append(", oauth_signature_method=\"PLAINTEXT\"");
        stringBuilder.append(", oauth_consumer_key=\"").append(DW(ael.j6)).append("\"");
        if (aek != null) {
            stringBuilder.append(", oauth_token=\"").append(DW(aek.j6)).append("\"");
            str = DW(ael.DW) + "&" + DW(aek.DW);
        } else {
            str = DW(ael.DW) + "&";
        }
        stringBuilder.append(", oauth_signature=\"").append(str).append("\"");
        return stringBuilder.toString();
    }

    private static String DW(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("UTF-8 isn't available");
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public synchronized aem$b u7() {
        return null;
    }

    public synchronized HttpClient tp() {
        if (this.v5 == null) {
            HttpParams basicHttpParams = new BasicHttpParams();
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new aej$1(this));
            ConnManagerParams.setMaxTotalConnections(basicHttpParams, 20);
            try {
                SocketFactory adz = new adz();
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                schemeRegistry.register(new Scheme("https", adz, 443));
                ClientConnectionManager aej_a = new aej$a(basicHttpParams, schemeRegistry);
                basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
                HttpProtocolParams.setUserAgent(basicHttpParams, "OfficialDropboxJavaSDK/" + adv.j6);
                HttpClient aej_2 = new aej$2(this, aej_a, basicHttpParams);
                aej_2.addRequestInterceptor(new aej$3(this));
                aej_2.addResponseInterceptor(new aej$4(this));
                this.v5 = aej_2;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            } catch (Throwable e22222) {
                throw new RuntimeException(e22222);
            }
        }
        return this.v5;
    }

    public void j6(HttpUriRequest httpUriRequest) {
        HttpParams params = httpUriRequest.getParams();
        HttpConnectionParams.setSoTimeout(params, 30000);
        HttpConnectionParams.setConnectionTimeout(params, 30000);
    }

    public String EQ() {
        return "api.dropbox.com";
    }

    public String we() {
        return "api-content.dropbox.com";
    }
}
