import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class ee extends DataInputStream {
    public ee(String str, Inflater inflater) {
        super(new BufferedInputStream(new InflaterInputStream(new FileInputStream(str), inflater)));
    }
}
