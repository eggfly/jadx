import java.io.Serializable;

public abstract class aen implements Serializable {
    public final String DW;
    public final String j6;

    public aen(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("'key' must be non-null");
        } else if (str.contains("|")) {
            throw new IllegalArgumentException("'key' must not contain a \"|\" character: \"" + str + "\"");
        } else if (str2 == null) {
            throw new IllegalArgumentException("'secret' must be non-null");
        } else {
            this.j6 = str;
            this.DW = str2;
        }
    }

    public int hashCode() {
        return this.j6.hashCode() ^ (this.DW.hashCode() << 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof aen) && j6((aen) obj);
    }

    public boolean j6(aen aen) {
        return this.j6.equals(aen.j6) && this.DW.equals(aen.DW);
    }

    public String toString() {
        return "{key=\"" + this.j6 + "\", secret=\"" + this.DW.charAt(0) + "...\"}";
    }
}
