import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class axu extends InputStream {
    private static final InputStream j6;
    private final LinkedList<InputStream> DW;

    static {
        j6 = new axu$1();
    }

    public axu() {
        this.DW = new LinkedList();
    }

    public axu(InputStream... inputStreamArr) {
        this.DW = new LinkedList();
        for (InputStream j6 : inputStreamArr) {
            j6(j6);
        }
    }

    private InputStream j6() {
        return this.DW.isEmpty() ? j6 : (InputStream) this.DW.getFirst();
    }

    private void DW() {
        if (!this.DW.isEmpty()) {
            ((InputStream) this.DW.removeFirst()).close();
        }
    }

    public void j6(InputStream inputStream) {
        this.DW.add(inputStream);
    }

    public int read() {
        while (true) {
            InputStream j6 = j6();
            int read = j6.read();
            if (read >= 0) {
                return read;
            }
            if (j6 == j6) {
                return -1;
            }
            DW();
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > 0) {
            InputStream j6 = j6();
            int read = j6.read(bArr, i, i2);
            if (read > 0) {
                i3 += read;
                i += read;
                i2 -= read;
            } else if (j6 != j6) {
                DW();
                if (i3 > 0) {
                    return i3;
                }
            } else if (i3 <= 0) {
                return -1;
            } else {
                return i3;
            }
        }
        return i3;
    }

    public int available() {
        return j6().available();
    }

    public long skip(long j) {
        long j2 = 0;
        while (0 < j) {
            InputStream j6 = j6();
            long skip = j6.skip(j);
            if (0 < skip) {
                j2 += skip;
                j -= skip;
            } else if (j6 == j6) {
                break;
            } else if (j6.read() < 0) {
                DW();
                if (0 < j2) {
                    break;
                }
            } else {
                j2++;
                j--;
            }
        }
        return j2;
    }

    public void close() {
        IOException iOException = null;
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            IOException iOException2;
            try {
                ((InputStream) it.next()).close();
                iOException2 = iOException;
            } catch (IOException e) {
                iOException2 = e;
            }
            it.remove();
            iOException = iOException2;
        }
        if (iOException != null) {
            throw iOException;
        }
    }
}
