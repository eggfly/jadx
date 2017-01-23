import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class aww {
    public static void j6(StringBuilder stringBuilder, String str) {
        if (str != null && str.length() != 0) {
            try {
                stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
            } catch (Throwable e) {
                throw new RuntimeException(JGitText.j6().couldNotURLEncodeToUTF8, e);
            }
        }
    }

    public static int j6(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (ConnectException e) {
            String host = httpURLConnection.getURL().getHost();
            if ("Connection timed out: connect".equals(e.getMessage())) {
                throw new ConnectException(MessageFormat.format(JGitText.j6().connectionTimeOut, new Object[]{host}));
            }
            throw new ConnectException(e.getMessage() + " " + host);
        }
    }

    public static Proxy j6(ProxySelector proxySelector, URL url) {
        try {
            return (Proxy) proxySelector.select(url.toURI()).get(0);
        } catch (Throwable e) {
            ConnectException connectException = new ConnectException(MessageFormat.format(JGitText.j6().cannotDetermineProxyFor, new Object[]{url}));
            connectException.initCause(e);
            throw connectException;
        }
    }
}
