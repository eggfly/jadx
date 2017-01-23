import java.util.Arrays;

public final class yj implements Comparable<yj> {
    private final byte[] j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((yj) obj);
    }

    public yj(byte[] bArr) {
        this.j6 = bArr;
    }

    public acx j6() {
        return new acw(this.j6);
    }

    public void j6(yt$a yt_a) {
        yt_a.j6(this.j6);
    }

    public int j6(yj yjVar) {
        int min = Math.min(this.j6.length, yjVar.j6.length);
        for (int i = 0; i < min; i++) {
            if (this.j6[i] != yjVar.j6[i]) {
                return (this.j6[i] & 255) - (yjVar.j6[i] & 255);
            }
        }
        return this.j6.length - yjVar.j6.length;
    }

    public String toString() {
        return Integer.toHexString(this.j6[0] & 255) + "...(" + this.j6.length + ")";
    }

    public int hashCode() {
        return Arrays.hashCode(this.j6) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (Arrays.equals(this.j6, ((yj) obj).j6)) {
            return true;
        }
        return false;
    }
}
