public final class ua extends adc implements Comparable<ua> {
    public static final ua j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ua) obj);
    }

    static {
        j6 = new ua(0);
    }

    public ua(int i) {
        super(i);
    }

    public ua$a j6(int i) {
        return (ua$a) v5(i);
    }

    public String Hw() {
        return j6("", "");
    }

    public String j6(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(100);
        int m_ = m_();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("catch ");
        for (int i = 0; i < m_; i++) {
            ua$a j6 = j6(i);
            if (i != 0) {
                stringBuilder.append(",\n");
                stringBuilder.append(str);
                stringBuilder.append("  ");
            }
            if (i == m_ - 1 && v5()) {
                stringBuilder.append("<any>");
            } else {
                stringBuilder.append(j6.j6().Hw());
            }
            stringBuilder.append(" -> ");
            stringBuilder.append(add.Hw(j6.DW()));
        }
        return stringBuilder.toString();
    }

    public boolean v5() {
        int m_ = m_();
        if (m_ == 0) {
            return false;
        }
        return j6(m_ - 1).j6().equals(abf.j6);
    }

    public void j6(int i, abf abf, int i2) {
        j6(i, new ua$a(abf, i2));
    }

    public int j6(ua uaVar) {
        if (this == uaVar) {
            return 0;
        }
        int m_ = m_();
        int m_2 = uaVar.m_();
        int min = Math.min(m_, m_2);
        for (int i = 0; i < min; i++) {
            int j6 = j6(i).j6(uaVar.j6(i));
            if (j6 != 0) {
                return j6;
            }
        }
        if (m_ < m_2) {
            return -1;
        }
        if (m_ > m_2) {
            return 1;
        }
        return 0;
    }
}
