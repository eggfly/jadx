import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

class aej$2 extends DefaultHttpClient {
    final /* synthetic */ aej j6;

    aej$2(aej aej, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.j6 = aej;
        super(clientConnectionManager, httpParams);
    }

    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new aej$c();
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new aej$b();
    }
}
