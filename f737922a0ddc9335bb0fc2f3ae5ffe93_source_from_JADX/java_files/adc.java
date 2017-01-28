import java.util.Arrays;

public class adc extends adm implements adq {
    private Object[] j6;

    public adc(int i) {
        super(i != 0);
        try {
            this.j6 = new Object[i];
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.j6, ((adc) obj).j6);
    }

    public int hashCode() {
        return Arrays.hashCode(this.j6);
    }

    public String toString() {
        String name = getClass().getName();
        return j6(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", false);
    }

    public String Hw() {
        String name = getClass().getName();
        return j6(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", true);
    }

    public String j6(String str, String str2, String str3) {
        return j6(str, str2, str3, false);
    }

    public String DW(String str, String str2, String str3) {
        return j6(str, str2, str3, true);
    }

    public final int m_() {
        return this.j6.length;
    }

    public void u7() {
        int i = 0;
        int i2 = 0;
        for (Object obj : this.j6) {
            if (obj != null) {
                i2++;
            }
        }
        if (r3 != i2) {
            we();
            Object[] objArr = new Object[i2];
            for (Object obj2 : this.j6) {
                if (obj2 != null) {
                    objArr[i] = obj2;
                    i++;
                }
            }
            this.j6 = objArr;
            if (i2 == 0) {
                l_();
            }
        }
    }

    protected final Object v5(int i) {
        try {
            Object obj = this.j6[i];
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("unset: " + i);
        } catch (ArrayIndexOutOfBoundsException e) {
            return j6(i);
        }
    }

    protected final Object Zo(int i) {
        return this.j6[i];
    }

    protected final void j6(int i, Object obj) {
        we();
        try {
            this.j6[i] = obj;
        } catch (ArrayIndexOutOfBoundsException e) {
            j6(i);
        }
    }

    private Object j6(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("n < 0");
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    private String j6(String str, String str2, String str3, boolean z) {
        int length = this.j6.length;
        StringBuffer stringBuffer = new StringBuffer((length * 10) + 10);
        if (str != null) {
            stringBuffer.append(str);
        }
        for (int i = 0; i < length; i++) {
            if (!(i == 0 || str2 == null)) {
                stringBuffer.append(str2);
            }
            if (z) {
                stringBuffer.append(((adq) this.j6[i]).Hw());
            } else {
                stringBuffer.append(this.j6[i]);
            }
        }
        if (str3 != null) {
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }
}
