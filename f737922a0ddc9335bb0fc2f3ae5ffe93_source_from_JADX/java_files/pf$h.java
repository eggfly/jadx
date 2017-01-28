import android.os.Process;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

class pf$h {
    private boolean DW;
    private Thread FH;
    private JSONObject Hw;
    private Object j6;
    private boolean v5;

    public pf$h() {
        this.j6 = new Object();
        this.DW = false;
        this.v5 = false;
        this.FH = new Thread(new pf$h$1(this), "Subscription WS Client");
        this.FH.setDaemon(true);
        this.FH.setPriority(1);
        this.FH.start();
    }

    public void j6(JSONObject jSONObject, boolean z) {
        synchronized (this.j6) {
            if (!this.v5 && z) {
                this.v5 = true;
            }
            this.Hw = jSONObject;
            this.j6.notify();
        }
    }

    public void j6() {
        synchronized (this.j6) {
            this.DW = true;
            this.j6.notify();
        }
    }

    private static boolean FH(JSONObject jSONObject, boolean z) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpParams basicHttpParams = new BasicHttpParams();
            ConnManagerParams.setTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 50000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 50000);
            HttpUriRequest httpPost = new HttpPost(z ? "https://api.appfour.com/aideservices/subscriptions/v1/registerPurchase" : "https://api.appfour.com/aideservices/subscriptions/v1/registerStartAfterPurchase");
            httpPost.setParams(basicHttpParams);
            httpPost.setEntity(new StringEntity(jSONObject.toString()));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            Object execute = defaultHttpClient.execute(httpPost, new BasicResponseHandler());
            if (execute != null && (execute instanceof String)) {
                try {
                    if (!new JSONObject((String) execute).getBoolean("isGenuine")) {
                        Process.killProcess(Process.myPid());
                    }
                } catch (JSONException e) {
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}
