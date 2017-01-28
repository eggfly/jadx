import java.io.IOException;

public abstract class ayv extends ayp {
    abstract boolean gn();

    public abstract int hashCode();

    abstract void j6(ayt ayt);

    abstract boolean j6(ayv ayv);

    abstract int u7();

    ayv() {
    }

    public static ayv j6(byte[] bArr) {
        try {
            return new aym(bArr).Hw();
        } catch (ClassCastException e) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ayh) && j6(((ayh) obj).w_())) {
            return true;
        }
        return false;
    }

    public ayv w_() {
        return this;
    }

    ayv Zo() {
        return this;
    }

    ayv VH() {
        return this;
    }
}
