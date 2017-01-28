import java.io.ByteArrayOutputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class qe {
    public static qd j6(List<String> list, String str, Map<String, String> map, boolean z, OutputStream outputStream, byte[] bArr) {
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        qc qcVar = new qc(strArr, map, str, z);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        qcVar.j6(new qb(byteArrayOutputStream, outputStream));
        qcVar.DW(new qb(byteArrayOutputStream2, outputStream));
        OutputStream j6 = qcVar.j6();
        if (j6 != null) {
            if (!(bArr == null || bArr.length == 0)) {
                try {
                    j6.write(bArr);
                } catch (InterruptedIOException e) {
                }
                j6.flush();
            }
            j6.close();
        }
        try {
            qcVar.FH();
            return new qe$1(qcVar, byteArrayOutputStream, byteArrayOutputStream2);
        } catch (InterruptedException e2) {
            qcVar.DW();
            throw e2;
        }
    }
}
