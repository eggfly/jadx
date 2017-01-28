import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class br$e implements br$c {
    final /* synthetic */ br DW;
    final String j6;

    public br$e(br brVar, String str) {
        this.DW = brVar;
        this.j6 = str;
    }

    public void j6(OutputStream outputStream) {
        try {
            byte[] J8;
            InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.j6));
            if (this.DW.Zo != null) {
                J8 = this.DW.Zo;
                this.DW.Zo = null;
            } else {
                J8 = new byte[10000];
            }
            while (true) {
                int read = bufferedInputStream.read(J8);
                if (read != -1) {
                    outputStream.write(J8, 0, read);
                } else {
                    bufferedInputStream.close();
                    this.DW.Zo = J8;
                    return;
                }
            }
        } catch (IOException e) {
        }
    }
}
