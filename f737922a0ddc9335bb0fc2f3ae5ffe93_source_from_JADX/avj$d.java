import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import org.eclipse.jgit.JGitText;

class avj$d {
    final avj$d$b DW;
    HttpURLConnection FH;
    final /* synthetic */ avj Hw;
    private final String VH;
    private final String Zo;
    private final avj$d$a gn;
    final axu j6;
    private final String v5;

    avj$d(avj avj, String str) {
        this.Hw = avj;
        this.v5 = str;
        this.Zo = "application/x-" + str + "-request";
        this.VH = "application/x-" + str + "-result";
        this.gn = new avj$d$a(this);
        this.j6 = new axu(this.gn);
        this.DW = new avj$d$b(this);
    }

    void j6() {
        this.FH = this.Hw.j6("POST", new URL(this.Hw.u7, this.v5));
        this.FH.setInstanceFollowRedirects(false);
        this.FH.setDoOutput(true);
        this.FH.setRequestProperty("Content-Type", this.Zo);
        this.FH.setRequestProperty("Accept", this.VH);
    }

    void DW() {
        this.DW.close();
        if (this.FH == null) {
            if (this.DW.DW() == 0) {
                throw new amb(this.Hw.Hw, JGitText.j6().startingReadStageWithoutWrittenRequestDataPendingIsNotSupported);
            }
            OutputStream gZIPOutputStream;
            axj axj_c = new axj$c(this.Hw.EQ.j6);
            try {
                gZIPOutputStream = new GZIPOutputStream(axj_c);
                this.DW.j6(gZIPOutputStream, null);
                gZIPOutputStream.close();
                if (this.DW.DW() < axj_c.DW()) {
                    axj_c = this.DW;
                }
            } catch (IOException e) {
                axj_c = this.DW;
            }
            j6();
            if (axj_c != this.DW) {
                this.FH.setRequestProperty("Content-Encoding", "gzip");
            }
            this.FH.setFixedLengthStreamingMode((int) axj_c.DW());
            gZIPOutputStream = this.FH.getOutputStream();
            try {
                axj_c.j6(gZIPOutputStream, null);
            } finally {
                gZIPOutputStream.close();
            }
        }
        this.DW.v5();
        int j6 = aww.j6(this.FH);
        if (j6 != 200) {
            throw new amb(this.Hw.Hw, new StringBuilder(String.valueOf(j6)).append(" ").append(this.FH.getResponseMessage()).toString());
        }
        String contentType = this.FH.getContentType();
        if (this.VH.equals(contentType)) {
            this.j6.j6(this.Hw.j6(this.FH));
            this.j6.j6(this.gn);
            this.FH = null;
            return;
        }
        this.FH.getInputStream().close();
        throw this.Hw.j6(this.VH, contentType);
    }
}
