package p023b.p024a;

/* renamed from: b.a.av */
public class av {
    private short[] f2722a;
    private int f2723b;

    public av(int i) {
        this.f2723b = -1;
        this.f2722a = new short[i];
    }

    private void m3455c() {
        Object obj = new short[(this.f2722a.length * 2)];
        System.arraycopy(this.f2722a, 0, obj, 0, this.f2722a.length);
        this.f2722a = obj;
    }

    public short m3456a() {
        short[] sArr = this.f2722a;
        int i = this.f2723b;
        this.f2723b = i - 1;
        return sArr[i];
    }

    public void m3457a(short s) {
        if (this.f2722a.length == this.f2723b + 1) {
            m3455c();
        }
        short[] sArr = this.f2722a;
        int i = this.f2723b + 1;
        this.f2723b = i;
        sArr[i] = s;
    }

    public void m3458b() {
        this.f2723b = -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ShortStack vector:[");
        for (int i = 0; i < this.f2722a.length; i++) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            if (i == this.f2723b) {
                stringBuilder.append(">>");
            }
            stringBuilder.append(this.f2722a[i]);
            if (i == this.f2723b) {
                stringBuilder.append("<<");
            }
        }
        stringBuilder.append("]>");
        return stringBuilder.toString();
    }
}
