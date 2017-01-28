import java.net.HttpURLConnection;

class atu$a extends atu {
    private String DW;
    private String FH;

    private atu$a() {
    }

    void j6(String str, String str2) {
        this.DW = str;
        this.FH = str2;
    }

    void DW(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Authorization", "Basic " + awm.j6((this.DW + ":" + this.FH).getBytes("UTF-8")));
    }
}
