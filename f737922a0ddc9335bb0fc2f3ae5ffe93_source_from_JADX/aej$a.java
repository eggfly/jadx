import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

class aej$a extends ThreadSafeClientConnManager {
    public aej$a(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        super(httpParams, schemeRegistry);
    }

    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        aej$e.j6(this, 20, 5);
        return super.requestConnection(httpRoute, obj);
    }
}
