import java.io.ByteArrayOutputStream;
import java.io.InputStream;

final class avv$a {
    final long DW;
    final InputStream j6;

    avv$a(InputStream inputStream, long j) {
        this.j6 = inputStream;
        this.DW = j;
    }

    byte[] j6() {
        try {
            byte[] bArr;
            if (this.DW >= 0) {
                bArr = new byte[((int) this.DW)];
                awx.j6(this.j6, bArr, 0, bArr.length);
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[2048];
                while (true) {
                    int read = this.j6.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                this.j6.close();
            }
            return bArr;
        } finally {
            this.j6.close();
        }
    }
}
