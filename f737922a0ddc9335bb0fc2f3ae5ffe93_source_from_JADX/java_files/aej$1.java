import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

class aej$1 implements ConnPerRoute {
    final /* synthetic */ aej j6;

    aej$1(aej aej) {
        this.j6 = aej;
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return 10;
    }
}
