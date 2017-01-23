package com.miui.support.date;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.SimpleNumberFormatter;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.Pools;
import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

public class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    private static final byte[] f1953a;
    private static final int[] f1954b;
    private static final String[] f1955f;
    private static final int[] f1956g;
    private static final int[] f1957h;
    private static final int[] f1958i;
    private static final int[] f1959j;
    private static final byte[] f1960k;
    private static final byte[] f1961l;
    private long f1962c;
    private TimeZone f1963d;
    private int[] f1964e;
    private transient long f1965m;
    private transient int f1966n;
    private transient int f1967o;
    private transient int f1968p;
    private transient int f1969q;
    private transient int f1970r;

    public /* synthetic */ int compareTo(Object obj) {
        return m3381a((Calendar) obj);
    }

    static {
        f1953a = new byte[]{(byte) 31, (byte) 28, (byte) 31, (byte) 30, (byte) 31, (byte) 30, (byte) 31, (byte) 31, (byte) 30, (byte) 31, (byte) 30, (byte) 31};
        f1954b = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        f1955f = new String[]{"ERA", "YEAR", "CHINESE_YEAR", "CHINESE_YEAR_SYMBOL_ANIMAL", "CHINESE_ERA_YEAR", "MONTH", "CHINESE_MONTH", "CHINESE_ERA_MONTH", "CHINESE_MONTH_IS_LEAP", "DAY_OF_MONTH", "DAY_OF_CHINESE_MONTH", "CHINESE_ERA_DAY", "DAY_OF_YEAR", "DAY_OF_CHINESE_YEAR", "DAY_OF_WEEK", "SOLAR_TERM", "DETAIL_AM_PM", "AM_PM", "HOUR", "CHINESE_ERA_HOUR", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET"};
        f1956g = new int[]{3, -1, -1, 12, 14, 26, 0, 18, 19, -1, 18, 5, 5, 7, -1, -1, -1, -1, 22, -1, -1, -1, 26, -1, 4, 25, -1, -1, -1, -1, -1, -1, 16, -1, 14, 9, 7, -1, -1, 18, -1, -1, 18, -1, 20, -1, -1, -1, -1, -1, 21, 15, -1, -1, 26, -1, 1, 25};
        f1957h = new int[]{0, 384, 738, 1093, 1476, 1830, 2185, 2569, 2923, 3278, 3662, 4016, 4400, 4754, 5108, 5492, 5846, 6201, 6585, 6940, 7324, 7678, 8032, 8416, 8770, 9124, 9509, 9863, 10218, 10602, 10956, 11339, 11693, 12048, 12432, 12787, 13141, 13525, 13879, 14263, 14617, 14971, 15355, 15710, 16064, 16449, 16803, 17157, 17541, 17895, 18279, 18633, 18988, 19372, 19726, 20081, 20465, 20819, 21202, 21557, 21911, 22295, 22650, 23004, 23388, 23743, 24096, 24480, 24835, 25219, 25573, 25928, 26312, 26666, 27020, 27404, 27758, 28142, 28496, 28851, 29235, 29590, 29944, 30328, 30682, 31066, 31420, 31774, 32158, 32513, 32868, 33252, 33606, 33960, 34343, 34698, 35082, 35436, 35791, 36175, 36529, 36883, 37267, 37621, 37976, 38360, 38714, 39099, 39453, 39807, 40191, 40545, 40899, 41283, 41638, 42022, 42376, 42731, 43115, 43469, 43823, 44207, 44561, 44916, 45300, 45654, 46038, 46392, 46746, 47130, 47485, 47839, 48223, 48578, 48962, 49316, 49670, 50054, 50408, 50762, 51146, 51501, 51856, 52240, 52594, 52978, 53332, 53686, 54070, 54424, 54779, 55163, 55518, 55902, 56256, 56610, 56993, 57348, 57702, 58086, 58441, 58795, 59179, 59533, 59917, 60271, 60626, 61010, 61364, 61719, 62103, 62457, 62841, 63195, 63549, 63933, 64288, 64642, 65026, 65381, 65735, 66119, 66473, 66857, 67211, 67566, 67950, 68304, 68659, 69042, 69396, 69780, 70134, 70489, 70873, 71228, 71582, 71966, 72320, 72674, 73058, 73412};
        f1958i = new int[]{19416, 19168, 42352, 21717, 53856, 55632, 21844, 22191, 39632, 21970, 19168, 42422, 42192, 53840, 53909, 46415, 54944, 44450, 38320, 18807, 18815, 42160, 46261, 27216, 27968, 43860, 11119, 38256, 21234, 18800, 25958, 54432, 59984, 27285, 23263, 11104, 34531, 37615, 51415, 51551, 54432, 55462, 46431, 22176, 42420, 9695, 37584, 53938, 43344, 46423, 27808, 46416, 21333, 19887, 42416, 17779, 21183, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 38310, 38335, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 20854, 21183, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 53430, 53855, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 45653, 27951, 44448, 19299, 37759, 18936, 18800, 25776, 26790, 59999, 27424, 42692, 43759, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 19285, 19311, 42352, 21732, 53856, 59752, 54560, 55968, 27302, 22239, 19168, 43476, 42192, 53584, 62034, 54560};
        f1959j = new int[]{4, 19, 3, 18, 4, 19, 4, 19, 4, 20, 4, 20, 6, 22, 6, 22, 6, 22, 7, 22, 6, 21, 6, 21};
        f1960k = "0123415341536789:;<9:=<>:=1>?012@015@015@015AB78CDE8CD=1FD01GH01GH01IH01IJ0KLMN;LMBEOPDQRST0RUH0RVH0RWH0RWM0XYMNZ[MB\\]PT^_ST`_WH`_WH`_WM`_WM`aYMbc[Mde]Sfe]gfh_gih_Wih_WjhaWjka[jkl[jmn]ope]qph_qrh_sth_W".getBytes();
        f1961l = "211122112122112121222211221122122222212222222221222122222232222222222222222233223232223232222222322222112122112121222211222122222222222222222222322222112122112121222111211122122222212221222221221122122222222222222222222223222232222232222222222222112122112121122111211122122122212221222221221122122222222222222221211122112122212221222211222122222232222232222222222222112122112121111111222222112121112121111111222222111121112121111111211122112122112121122111222212111121111121111111111122112122112121122111211122112122212221222221222211111121111121111111222111111121111111111111111122112121112121111111222111111111111111111111111122111121112121111111221122122222212221222221222111011111111111111111111122111121111121111111211122112122112121122211221111011111101111111111111112111121111121111111211122112122112221222211221111011111101111111110111111111121111111111111111122112121112121122111111011111121111111111111111011111111112111111111111011111111111111111111221111011111101110111110111011011111111111111111221111011011101110111110111011011111101111111111211111001011101110111110110011011111101111111111211111001011001010111110110011011111101111111110211111001011001010111100110011011011101110111110211111001011001010011100110011001011101110111110211111001010001010011000100011001011001010111110111111001010001010011000111111111111111111111111100011001011001010111100111111001010001010000000111111000010000010000000100011001011001010011100110011001011001110111110100011001010001010011000110011001011001010111110111100000010000000000000000011001010001010011000111100000000000000000000000011001010001010000000111000000000000000000000000011001010000010000000".getBytes();
    }

    public Calendar() {
        this(null);
    }

    public Calendar(TimeZone timeZone) {
        this.f1964e = new int[25];
        this.f1965m = -12219292800000L;
        this.f1966n = 1582;
        this.f1967o = ((this.f1966n / 100) - (this.f1966n / 400)) - 2;
        this.f1968p = (((this.f1966n - 2000) / 400) + this.f1967o) - ((this.f1966n - 2000) / 100);
        this.f1969q = 10;
        this.f1970r = 0;
        this.f1962c = System.currentTimeMillis();
        m3386a(timeZone);
    }

    public Calendar m3386a(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (this.f1963d == null || !this.f1963d.getID().equals(timeZone.getID())) {
            this.f1963d = timeZone;
            m3375g();
        }
        return this;
    }

    public long m3382a() {
        return this.f1962c;
    }

    public Calendar m3385a(long j) {
        this.f1962c = j;
        m3375g();
        return this;
    }

    public Calendar m3384a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < 0 || i2 > 11) {
            throw new IllegalArgumentException("Year " + i + " has no month " + i2);
        } else if (i3 <= 0 || i3 > m3357a(m3399d(i), i2)) {
            throw new IllegalArgumentException("Year " + i + " month " + i2 + " has no day " + i3);
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException("Invalid hour " + i4);
        } else if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException("Invalid minute " + i5);
        } else if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException("Invalid second " + i6);
        } else if (i7 < 0 || i7 > 999) {
            throw new IllegalArgumentException("Invalid millisecond " + i7);
        } else {
            this.f1964e[1] = i;
            this.f1964e[5] = i2;
            this.f1964e[9] = i3;
            this.f1964e[18] = i4;
            this.f1964e[20] = i5;
            this.f1964e[21] = i6;
            this.f1964e[22] = i7;
            m3371e();
            return this;
        }
    }

    public Calendar m3383a(int i, int i2) {
        if (i == 6) {
            int f;
            if (i2 < 0) {
                i2 = -i2;
                if (i2 != m3376h(this.f1964e[2])) {
                    throw new IllegalArgumentException("year " + this.f1964e[2] + " has no such leap month:" + i2);
                }
                this.f1964e[8] = 1;
            } else if (i2 >= m3395c(i) || i2 <= m3391b(i)) {
                this.f1964e[8] = 0;
            } else {
                throw new IllegalArgumentException("value is out of date range [" + m3395c(i) + "-" + m3391b(i) + "]: " + i2);
            }
            this.f1964e[6] = i2;
            if (this.f1964e[8] == 1) {
                f = m3372f(this.f1964e[2]);
            } else {
                f = m3366c(this.f1964e[2], this.f1964e[6]);
            }
            if (this.f1964e[10] > f) {
                this.f1964e[10] = f;
            }
            m3373f();
        } else if (i2 >= m3395c(i) || i2 <= m3391b(i)) {
            try {
                m3392b(i, i2 - this.f1964e[i]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("unsupported set field:" + f1955f[i]);
            }
        } else {
            throw new IllegalArgumentException("value is out of date range [" + m3395c(i) + "-" + m3391b(i) + "]: " + i2);
        }
        return this;
    }

    public Calendar m3392b(int i, int i2) {
        int i3 = 1;
        if (i < 0 || i >= 25) {
            throw new IllegalArgumentException("Field out of range [0-25]: " + i);
        }
        int[] iArr;
        int a;
        int i4;
        long j;
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                if (!(i2 == 0 || this.f1964e[0] == (this.f1964e[0] + i2) % 2 || this.f1964e[0] != 0)) {
                    this.f1964e[1] = -1 - this.f1964e[1];
                    m3371e();
                    break;
                }
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (i2 != 0) {
                    if (this.f1964e[0] == 0) {
                        this.f1964e[1] = -1 - this.f1964e[1];
                    }
                    iArr = this.f1964e;
                    iArr[1] = iArr[1] + i2;
                    a = m3357a(m3399d(this.f1964e[1]), this.f1964e[5]);
                    if (this.f1964e[9] > a) {
                        this.f1964e[9] = a;
                    }
                    m3371e();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (i2 != 0) {
                    a = this.f1964e[2] + i2;
                    if (!m3393b() && a >= 1900 && a <= 2100) {
                        this.f1964e[2] = a;
                        if (this.f1964e[8] == 1 && this.f1964e[6] == m3376h(this.f1964e[2])) {
                            this.f1964e[8] = 0;
                        }
                        if (this.f1964e[8] == 1) {
                            a = m3372f(this.f1964e[2]);
                        } else {
                            a = m3366c(this.f1964e[2], this.f1964e[6]);
                        }
                        if (this.f1964e[10] > a) {
                            this.f1964e[10] = a;
                        }
                        m3373f();
                        break;
                    }
                    throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                }
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                if (i2 != 0) {
                    i4 = i2 + this.f1964e[5];
                    a = i4 / 12;
                    i4 %= 12;
                    if (i4 < 0) {
                        i4 += 12;
                        a--;
                    }
                    this.f1964e[5] = i4;
                    if (a != 0) {
                        m3392b(1, a);
                        break;
                    }
                    if (this.f1964e[0] == 0) {
                        this.f1964e[1] = -1 - this.f1964e[1];
                    }
                    a = m3357a(m3399d(this.f1964e[1]), this.f1964e[5]);
                    if (this.f1964e[9] > a) {
                        this.f1964e[9] = a;
                    }
                    m3371e();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                if (i2 != 0) {
                    if (!m3393b()) {
                        int[] iArr2;
                        a = m3376h(this.f1964e[2]);
                        i4 = i2;
                        while (i4 > 0) {
                            if (this.f1964e[6] == a && this.f1964e[8] == 0) {
                                this.f1964e[8] = 1;
                            } else {
                                iArr2 = this.f1964e;
                                iArr2[6] = iArr2[6] + 1;
                                this.f1964e[8] = 0;
                                if (this.f1964e[6] > 11) {
                                    this.f1964e[6] = 0;
                                    iArr = this.f1964e;
                                    iArr[2] = iArr[2] + 1;
                                    if (this.f1964e[2] > 2100) {
                                        throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                    }
                                    a = m3376h(this.f1964e[2]);
                                } else {
                                    continue;
                                }
                            }
                            i4--;
                        }
                        while (i4 < 0) {
                            if (this.f1964e[6] == a && this.f1964e[8] == 1) {
                                this.f1964e[8] = 0;
                            } else {
                                iArr2 = this.f1964e;
                                iArr2[6] = iArr2[6] - 1;
                                if (this.f1964e[6] < 0) {
                                    this.f1964e[6] = 11;
                                    iArr = this.f1964e;
                                    iArr[6] = iArr[6] - 1;
                                    if (this.f1964e[2] < 1900) {
                                        throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                    }
                                    a = m3376h(this.f1964e[1]);
                                }
                                if (this.f1964e[6] == a) {
                                    this.f1964e[8] = 1;
                                }
                            }
                            i4++;
                        }
                        if (this.f1964e[8] == 1) {
                            a = m3372f(this.f1964e[2]);
                        } else {
                            a = m3366c(this.f1964e[2], this.f1964e[6]);
                        }
                        if (this.f1964e[10] > a) {
                            this.f1964e[10] = a;
                        }
                        m3373f();
                        break;
                    }
                    throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                }
                break;
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
            case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
            case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                if (i2 != 0) {
                    j = (((long) i2) * 86400000) + this.f1962c;
                    if (i2 > 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (j <= this.f1962c) {
                        i3 = 0;
                    }
                    if (a == i3) {
                        this.f1962c = j;
                        m3375g();
                        break;
                    }
                    throw new IllegalArgumentException("out of range");
                }
                break;
            case C0264R.styleable.Window_immersionMenuEnabled /*18*/:
                if (i2 != 0) {
                    j = (((long) i2) * 3600000) + this.f1962c;
                    if (i2 > 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (j <= this.f1962c) {
                        i3 = 0;
                    }
                    if (a == i3) {
                        this.f1962c = j;
                        m3375g();
                        break;
                    }
                    throw new IllegalArgumentException("out of range");
                }
                break;
            case C0264R.styleable.Window_immersionButtonMoreBackground /*20*/:
                if (i2 != 0) {
                    j = (((long) i2) * 60000) + this.f1962c;
                    if (i2 > 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (j <= this.f1962c) {
                        i3 = 0;
                    }
                    if (a == i3) {
                        this.f1962c = j;
                        m3375g();
                        break;
                    }
                    throw new IllegalArgumentException("out of range");
                }
                break;
            case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
                if (i2 != 0) {
                    j = (((long) i2) * 1000) + this.f1962c;
                    if (i2 > 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (j <= this.f1962c) {
                        i3 = 0;
                    }
                    if (a == i3) {
                        this.f1962c = j;
                        m3375g();
                        break;
                    }
                    throw new IllegalArgumentException("out of range");
                }
                break;
            case C0264R.styleable.Window_immersionWindowBackground /*22*/:
                if (i2 != 0) {
                    j = ((long) i2) + this.f1962c;
                    if (i2 > 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (j <= this.f1962c) {
                        i3 = 0;
                    }
                    if (a == i3) {
                        this.f1962c = j;
                        m3375g();
                        break;
                    }
                    throw new IllegalArgumentException("out of range");
                }
                break;
            default:
                throw new IllegalArgumentException("unsupported set field:" + f1955f[i]);
        }
        return this;
    }

    private void m3371e() {
        int i = this.f1964e[1];
        int i2 = this.f1964e[5];
        int i3 = this.f1964e[9];
        long b = ((long) ((m3364b(m3399d(i), i2) + i3) - 1)) + m3369d((long) i);
        int a = m3356a(b - 3, 7) + 1;
        this.f1964e[14] = a;
        int i4 = this.f1964e[22] + (((this.f1964e[18] * 3600000) + (this.f1964e[20] * 60000)) + (this.f1964e[21] * 1000));
        this.f1962c = (b * 86400000) + ((long) i4);
        long offset = (long) this.f1963d.getOffset(1, i, i2, i3, a, i4);
        if (this.f1963d.inDaylightTime(new Date(this.f1962c))) {
            offset -= (long) m3378i(i4);
        }
        long j = this.f1962c;
        if (i <= 0) {
            offset = 0;
        }
        this.f1962c = j - offset;
        m3375g();
    }

    private void m3373f() {
        int i;
        long j = ((long) f1957h[this.f1964e[2] - 1900]) - 25537;
        for (i = 0; i < this.f1964e[6]; i++) {
            j += (long) m3366c(this.f1964e[2], i);
        }
        if (this.f1964e[8] == 1) {
            j += (long) m3366c(this.f1964e[2], this.f1964e[6]);
        } else {
            i = m3376h(this.f1964e[2]);
            if (i >= 0 && i < this.f1964e[6]) {
                j += (long) m3372f(this.f1964e[2]);
            }
        }
        m3358a(((long) (this.f1964e[10] - 1)) + j, 0);
        m3371e();
    }

    public int m3380a(int i) {
        if (i >= 0 && i < 25) {
            return this.f1964e[i];
        }
        throw new IllegalArgumentException("Field out of range [0-25]: " + i);
    }

    private void m3375g() {
        long i = m3379i();
        if (!m3393b()) {
            m3367c(i);
            m3377h();
            m3365b(i);
        }
    }

    public boolean m3393b() {
        return this.f1962c < (-2206396800000L - ((long) this.f1964e[23])) - ((long) this.f1964e[24]) || this.f1962c >= (4136400000000L - ((long) this.f1964e[23])) - ((long) this.f1964e[24]);
    }

    private void m3365b(long j) {
        int i = this.f1964e[1];
        if (this.f1964e[5] < 2) {
            i--;
        }
        if (this.f1964e[5] == 1 && this.f1964e[9] >= (m3368d(this.f1964e[1], 1) >> 8)) {
            i = this.f1964e[1];
        }
        this.f1964e[3] = m3356a((long) ((i - 1900) + 12), 12);
        this.f1964e[4] = m3356a((long) ((i - 1900) + 36), 60);
        i = ((this.f1964e[1] - 1900) * 12) + this.f1964e[5];
        if (this.f1964e[9] >= (m3368d(this.f1964e[1], this.f1964e[5]) >> 8)) {
            i++;
        }
        this.f1964e[7] = m3356a((long) (i + 12), 60);
        i = (int) (j - -25537);
        this.f1964e[11] = m3356a((long) (i + 40), 60);
        this.f1964e[19] = m3356a((long) ((i * 12) + (((this.f1964e[18] + 1) % 24) / 2)), 60);
    }

    private void m3377h() {
        int d = m3368d(this.f1964e[1], this.f1964e[5]);
        if (this.f1964e[9] == (d >> 8)) {
            this.f1964e[15] = (this.f1964e[5] * 2) + 1;
        } else if (this.f1964e[9] == (d & 255)) {
            this.f1964e[15] = (this.f1964e[5] * 2) + 2;
        } else {
            this.f1964e[15] = 0;
        }
    }

    private void m3367c(long j) {
        int i = 2100;
        int i2 = 0;
        int i3 = (int) (j - -25537);
        if (this.f1964e[1] < 2100) {
            i = this.f1964e[1] + 1;
        }
        i3 -= f1957h[i - 1900];
        if (i3 < 0) {
            i--;
            i3 += m3370e(i);
        }
        if (i3 < 0) {
            i--;
            i3 += m3370e(i);
        }
        this.f1964e[2] = i;
        this.f1964e[13] = i3 + 1;
        int h = m3376h(i);
        int i4 = 0;
        int i5 = 0;
        int i6 = i3;
        i3 = 0;
        while (i3 < 12 && i6 > 0) {
            if (h >= 0 && i3 == h + 1 && i5 == 0) {
                i3--;
                i4 = m3372f(i);
                i5 = i3;
                i3 = 1;
            } else {
                i4 = m3366c(i, i3);
                int i7 = i3;
                i3 = i5;
                i5 = i7;
            }
            if (i3 != 0 && i5 == h + 1) {
                i3 = 0;
            }
            int i8 = i6 - i4;
            i6 = i5 + 1;
            i5 = i3;
            i3 = i6;
            i6 = i8;
        }
        if (i6 != 0 || h <= 0 || i3 != h + 1) {
            i = i3;
        } else if (i5 != 0) {
            i = i3;
            i5 = 0;
        } else {
            i = i3 - 1;
            i5 = 1;
        }
        if (i6 < 0) {
            i3 = i6 + i4;
            i--;
        } else {
            i3 = i6;
        }
        int[] iArr = this.f1964e;
        if (i5 != 0) {
            i2 = 1;
        }
        iArr[8] = i2;
        this.f1964e[6] = i;
        this.f1964e[10] = i3 + 1;
    }

    private long m3379i() {
        this.f1964e[23] = this.f1963d.getRawOffset();
        long j = this.f1962c / 86400000;
        int i = (int) (this.f1962c % 86400000);
        if (i < 0) {
            i += 86400000;
            j--;
        }
        long j2 = j;
        int i2 = i + this.f1964e[23];
        while (i2 < 0) {
            i2 += 86400000;
            j2--;
        }
        while (i2 >= 86400000) {
            i2 -= 86400000;
            j2++;
        }
        int i3 = this.f1964e[23];
        long j3 = this.f1962c + ((long) i3);
        if (this.f1962c > 0 && j3 < 0 && i3 > 0) {
            j3 = Long.MAX_VALUE;
        } else if (this.f1962c < 0 && j3 > 0 && i3 < 0) {
            j3 = Long.MIN_VALUE;
        }
        m3358a(j2, j3);
        i = m3378i(i2);
        this.f1964e[24] = i;
        if (i != 0) {
            long j4;
            i2 += i;
            if (i2 < 0) {
                i2 += 86400000;
                j4 = j2 - 1;
            } else if (i2 >= 86400000) {
                i2 -= 86400000;
                j4 = j2 + 1;
            } else {
                j4 = j2;
            }
            if (j2 != j4) {
                i3 = this.f1964e[24] - this.f1964e[23];
                j3 = this.f1962c + ((long) i3);
                if (this.f1962c > 0 && j3 < 0 && i3 > 0) {
                    j3 = Long.MAX_VALUE;
                } else if (this.f1962c < 0 && j3 > 0 && i3 < 0) {
                    j3 = Long.MIN_VALUE;
                }
                m3358a(j4, j3);
            }
            i = i2;
            j = j4;
        } else {
            i = i2;
            j = j2;
        }
        if (this.f1964e[1] <= 0) {
            this.f1964e[0] = 0;
            this.f1964e[1] = 1 - this.f1964e[1];
        } else {
            this.f1964e[0] = 1;
        }
        this.f1964e[22] = i % 1000;
        i /= 1000;
        this.f1964e[21] = i % 60;
        i /= 60;
        this.f1964e[20] = i % 60;
        this.f1964e[18] = (i / 60) % 24;
        this.f1964e[17] = this.f1964e[18] > 11 ? 1 : 0;
        switch (this.f1964e[18]) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f1964e[16] = 0;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                this.f1964e[16] = 1;
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                this.f1964e[16] = 2;
                break;
            case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                this.f1964e[16] = 3;
                break;
            case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
            case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
            case C0264R.styleable.Window_windowLayoutMode /*15*/:
            case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
            case C0264R.styleable.Window_contentHeaderBackground /*17*/:
                this.f1964e[16] = 4;
                break;
            case C0264R.styleable.Window_immersionMenuEnabled /*18*/:
                this.f1964e[16] = 5;
                break;
            case C0264R.styleable.Window_immersionMenuLayout /*19*/:
            case C0264R.styleable.Window_immersionButtonMoreBackground /*20*/:
            case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
            case C0264R.styleable.Window_immersionWindowBackground /*22*/:
            case C0264R.styleable.Window_immersionWindowFooterBackground /*23*/:
                this.f1964e[16] = 6;
                break;
        }
        return j;
    }

    public boolean m3396c() {
        return this.f1964e[8] == 1;
    }

    public int m3398d() {
        return m3376h(this.f1964e[2]);
    }

    public int m3381a(Calendar calendar) {
        if (this.f1962c < calendar.f1962c) {
            return -1;
        }
        return this.f1962c == calendar.f1962c ? 0 : 1;
    }

    public int hashCode() {
        return (int) (this.f1962c ^ (this.f1962c >>> 32));
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Calendar) && this.f1962c == ((Calendar) obj).f1962c);
    }

    public String toString() {
        StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
        stringBuilder.append(getClass().getName());
        stringBuilder.append("[time");
        stringBuilder.append(this.f1962c);
        stringBuilder.append(",zone=");
        stringBuilder.append(this.f1963d.getID());
        for (int i = 0; i < 25; i++) {
            stringBuilder.append(',');
            stringBuilder.append(f1955f[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.f1964e[i]);
        }
        stringBuilder.append(']');
        String stringBuilder2 = stringBuilder.toString();
        Pools.m5430a().m5401b(stringBuilder);
        return stringBuilder2;
    }

    public final Object clone() {
        try {
            Calendar calendar = (Calendar) super.clone();
            calendar.f1964e = (int[]) this.f1964e.clone();
            calendar.f1963d = (TimeZone) this.f1963d.clone();
            return calendar;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public boolean m3394b(Calendar calendar) {
        return m3382a() > calendar.m3382a();
    }

    public boolean m3397c(Calendar calendar) {
        return m3382a() < calendar.m3382a();
    }

    public int m3391b(int i) {
        if (i < 0 || i >= 25) {
            throw new IllegalArgumentException("Field out of range [0-25]: " + i);
        }
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return 1;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return this.f1964e[0] == 1 ? 292278994 : 292269055;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return 2100;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                return 11;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
            case C0264R.styleable.Window_immersionMenuLayout /*19*/:
                return 59;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return 11;
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                return 1;
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                return m3357a(m3399d(this.f1964e[1]), this.f1964e[5]);
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                if (m3393b()) {
                    return 0;
                }
                return m3396c() ? m3372f(this.f1964e[2]) : m3366c(this.f1964e[2], this.f1964e[6]);
            case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                return m3374g(this.f1964e[1]);
            case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                if (m3393b()) {
                    return 0;
                }
                return m3370e(this.f1964e[2]);
            case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                return 7;
            case C0264R.styleable.Window_windowLayoutMode /*15*/:
                return 24;
            case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                return 6;
            case C0264R.styleable.Window_contentHeaderBackground /*17*/:
                return 1;
            case C0264R.styleable.Window_immersionMenuEnabled /*18*/:
                return 23;
            case C0264R.styleable.Window_immersionButtonMoreBackground /*20*/:
                return 59;
            case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
                return 59;
            case C0264R.styleable.Window_immersionWindowBackground /*22*/:
                return 999;
            default:
                throw new IllegalArgumentException("unsupported field: " + f1955f[i]);
        }
    }

    public int m3395c(int i) {
        if (i < 0 || i >= 25) {
            throw new IllegalArgumentException("Field out of range [0-25]: " + i);
        }
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
            case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
            case C0264R.styleable.Window_windowLayoutMode /*15*/:
            case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
            case C0264R.styleable.Window_contentHeaderBackground /*17*/:
            case C0264R.styleable.Window_immersionMenuEnabled /*18*/:
            case C0264R.styleable.Window_immersionMenuLayout /*19*/:
            case C0264R.styleable.Window_immersionButtonMoreBackground /*20*/:
            case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
            case C0264R.styleable.Window_immersionWindowBackground /*22*/:
                return 0;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return 1;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return 1900;
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                return 1;
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                if (m3393b()) {
                    return 0;
                }
                return 1;
            case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                return 1;
            case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                if (m3393b()) {
                    return 0;
                }
                return 1;
            case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                return 1;
            default:
                throw new IllegalArgumentException("unsupported field: " + f1955f[i]);
        }
    }

    public boolean m3399d(int i) {
        if (i > this.f1966n) {
            if (i % 4 != 0 || (i % 100 == 0 && i % 400 != 0)) {
                return false;
            }
            return true;
        } else if (i % 4 != 0) {
            return false;
        } else {
            return true;
        }
    }

    private void m3358a(long j, long j2) {
        int b = m3363b(j, j2);
        this.f1964e[12] = b;
        if (this.f1964e[1] == this.f1966n && this.f1965m <= j2) {
            b += this.f1969q;
        }
        int i = b / 32;
        boolean d = m3399d(this.f1964e[1]);
        b -= m3364b(d, i);
        if (b > m3357a(d, i)) {
            b -= m3357a(d, i);
            i++;
        }
        this.f1964e[5] = i;
        this.f1964e[9] = b;
        this.f1964e[14] = m3356a(j - 3, 7) + 1;
    }

    private int m3363b(long j, long j2) {
        long j3;
        int i = 1970;
        if (j2 < this.f1965m) {
            j3 = j - ((long) this.f1968p);
        } else {
            j3 = j;
        }
        while (true) {
            int i2 = (int) (j3 / 365);
            if (i2 == 0) {
                break;
            }
            i += i2;
            j3 = j - m3369d((long) i);
        }
        if (j3 < 0) {
            i--;
            j3 += (long) m3374g(i);
        }
        this.f1964e[1] = i;
        return ((int) j3) + 1;
    }

    private long m3369d(long j) {
        if (j >= 1970) {
            long j2 = ((j - 1970) * 365) + ((j - 1969) / 4);
            if (j > ((long) this.f1966n)) {
                return j2 - (((j - 1901) / 100) - ((j - 1601) / 400));
            }
            if (j == ((long) this.f1966n)) {
                return j2 + ((long) this.f1969q);
            }
            if (j == ((long) (this.f1966n - 1))) {
                return j2 + ((long) this.f1970r);
            }
            return j2 + ((long) this.f1968p);
        } else if (j <= ((long) this.f1966n)) {
            return (((j - 1970) * 365) + ((j - 1972) / 4)) + ((long) this.f1968p);
        } else {
            return ((((j - 1970) * 365) + ((j - 1972) / 4)) - ((j - 2000) / 100)) + ((j - 2000) / 400);
        }
    }

    private static int m3357a(boolean z, int i) {
        if (z && i == 1) {
            return f1953a[i] + 1;
        }
        return f1953a[i];
    }

    private int m3374g(int i) {
        int i2 = m3399d(i) ? 366 : 365;
        if (i == this.f1966n) {
            i2 -= this.f1969q;
        }
        if (i == this.f1966n - 1) {
            return i2 - this.f1970r;
        }
        return i2;
    }

    private static int m3364b(boolean z, int i) {
        if (!z || i <= 1) {
            return f1954b[i];
        }
        return f1954b[i] + 1;
    }

    private static int m3356a(long j, int i) {
        int i2 = (int) (j % ((long) i));
        if (j >= 0 || i2 >= 0) {
            return i2;
        }
        return i2 + i;
    }

    static int m3366c(int i, int i2) {
        return (f1958i[i + -1900] & (65536 >> (i2 + 1))) != 0 ? 30 : 29;
    }

    static int m3370e(int i) {
        return f1957h[(i - 1900) + 1] - f1957h[i - 1900];
    }

    static int m3372f(int i) {
        if (m3376h(i) >= 0) {
            return (f1958i[(i + -1900) + 1] & 15) == 15 ? 30 : 29;
        } else {
            return 0;
        }
    }

    private static int m3376h(int i) {
        int i2 = f1958i[i - 1900] & 15;
        return i2 == 15 ? -1 : i2 - 1;
    }

    static int m3368d(int i, int i2) {
        if (i > 2100) {
            return 0;
        }
        int i3 = i2 * 2;
        int i4 = ((f1960k[i - 1900] - 48) * 24) + i3;
        int i5 = i4 + 1;
        return (((f1961l[i4] - 48) + f1959j[i3]) << 8) + (f1959j[i3 + 1] + (f1961l[i5] - 48));
    }

    public String m3387a(CharSequence charSequence) {
        return m3388a(charSequence, null);
    }

    public String m3388a(CharSequence charSequence, CalendarFormatSymbols calendarFormatSymbols) {
        StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
        String stringBuilder2 = m3390a(stringBuilder, charSequence, calendarFormatSymbols).toString();
        Pools.m5430a().m5401b(stringBuilder);
        return stringBuilder2;
    }

    public StringBuilder m3389a(StringBuilder stringBuilder, CharSequence charSequence) {
        return m3390a(stringBuilder, charSequence, null);
    }

    public StringBuilder m3390a(StringBuilder stringBuilder, CharSequence charSequence, CalendarFormatSymbols calendarFormatSymbols) {
        CalendarFormatSymbols a;
        if (calendarFormatSymbols == null) {
            a = CalendarFormatSymbols.m3401a();
        } else {
            a = calendarFormatSymbols;
        }
        int length = charSequence.length();
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2;
            char charAt = charSequence.charAt(i);
            if (obj != null) {
                if (charAt != '\'') {
                    stringBuilder.append(charAt);
                    obj2 = obj;
                } else if (i + 1 >= length || charSequence.charAt(i + 1) != charAt) {
                    obj2 = null;
                } else {
                    i++;
                    stringBuilder.append(charAt);
                    obj2 = obj;
                }
            } else if (charAt == '\'') {
                if (i + 1 >= length || charSequence.charAt(i + 1) != charAt) {
                    int i2 = 1;
                } else {
                    i++;
                    stringBuilder.append(charAt);
                    obj2 = obj;
                }
            } else if (charAt < 'A' || charAt > 'z' || f1956g[charAt - 65] < 0) {
                stringBuilder.append(charAt);
                obj2 = obj;
            } else {
                int i3 = 1;
                int i4 = i;
                while (i4 + 1 < length && charSequence.charAt(i4 + 1) == charAt) {
                    i4++;
                    i3++;
                }
                m3360a(stringBuilder, a, charAt, i3, f1956g[charAt - 65]);
                i = i4;
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        return stringBuilder;
    }

    private void m3360a(StringBuilder stringBuilder, CalendarFormatSymbols calendarFormatSymbols, char c, int i, int i2) {
        int i3;
        switch (c) {
            case 'A':
                stringBuilder.append(calendarFormatSymbols.m3415o()[this.f1964e[3]]);
            case 'D':
            case 'H':
            case 'S':
            case 'd':
            case 'm':
            case 's':
                m3359a(stringBuilder, i, this.f1964e[i2]);
            case 'E':
            case 'c':
                if (i == 4) {
                    stringBuilder.append(calendarFormatSymbols.m3419s()[this.f1964e[14] - 1]);
                } else if (i == 5) {
                    stringBuilder.append(calendarFormatSymbols.m3418r()[this.f1964e[14] - 1]);
                } else {
                    stringBuilder.append(calendarFormatSymbols.m3417q()[this.f1964e[14] - 1]);
                }
            case 'G':
                stringBuilder.append(calendarFormatSymbols.m3416p()[this.f1964e[0]]);
            case 'I':
                if (i == 2) {
                    stringBuilder.append(calendarFormatSymbols.m3414n()[this.f1964e[19] % 10]);
                }
                stringBuilder.append(calendarFormatSymbols.m3410j()[this.f1964e[19] % 12]);
            case 'K':
                m3359a(stringBuilder, i, this.f1964e[18] % 12);
            case 'L':
            case 'M':
                if (i < 3) {
                    m3359a(stringBuilder, i, this.f1964e[5] + 1);
                } else if (i == 4) {
                    stringBuilder.append(calendarFormatSymbols.m3413m()[this.f1964e[5]]);
                } else if (i == 5) {
                    stringBuilder.append(calendarFormatSymbols.m3412l()[this.f1964e[5]]);
                } else {
                    stringBuilder.append(calendarFormatSymbols.m3411k()[this.f1964e[5]]);
                }
            case 'N':
                if (i != 2) {
                    stringBuilder.append(calendarFormatSymbols.m3408h()[this.f1964e[8]]);
                    stringBuilder.append(calendarFormatSymbols.m3409i()[this.f1964e[6]]);
                    return;
                }
                stringBuilder.append(calendarFormatSymbols.m3414n()[this.f1964e[7] % 10]);
                stringBuilder.append(calendarFormatSymbols.m3410j()[this.f1964e[7] % 12]);
            case 'Y':
                if (i != 2) {
                    String[] g = calendarFormatSymbols.m3407g();
                    i3 = this.f1964e[2];
                    int length = stringBuilder.length();
                    while (i3 > 0) {
                        int i4 = i3 % 10;
                        i3 /= 10;
                        stringBuilder.insert(length, g[i4]);
                    }
                    return;
                }
                stringBuilder.append(calendarFormatSymbols.m3414n()[this.f1964e[4] % 10]);
                stringBuilder.append(calendarFormatSymbols.m3410j()[this.f1964e[4] % 12]);
            case 'Z':
                if (i == 4) {
                    m3362a(stringBuilder, true, true);
                } else if (i == 5) {
                    m3362a(stringBuilder, false, true);
                } else {
                    m3362a(stringBuilder, false, false);
                }
            case 'a':
                if (i != 2) {
                    stringBuilder.append(calendarFormatSymbols.m3406f()[this.f1964e[17]]);
                } else {
                    stringBuilder.append(calendarFormatSymbols.m3405e()[this.f1964e[16]]);
                }
            case 'e':
                if (i != 2) {
                    stringBuilder.append(calendarFormatSymbols.m3404d()[this.f1964e[10] - 1]);
                    return;
                }
                stringBuilder.append(calendarFormatSymbols.m3414n()[this.f1964e[11] % 10]);
                stringBuilder.append(calendarFormatSymbols.m3410j()[this.f1964e[11] % 12]);
            case 'h':
                i3 = this.f1964e[18] % 12;
                if (i3 == 0) {
                    i3 = 12;
                }
                m3359a(stringBuilder, i, i3);
            case 'k':
                m3359a(stringBuilder, i, this.f1964e[18]);
            case 't':
                stringBuilder.append(calendarFormatSymbols.m3403c()[this.f1964e[15]]);
            case 'y':
                if (i == 2) {
                    m3359a(stringBuilder, i, this.f1964e[1] % 100);
                } else {
                    m3359a(stringBuilder, i, this.f1964e[1]);
                }
            case 'z':
                m3361a(stringBuilder, calendarFormatSymbols, i);
            default:
        }
    }

    private static void m3359a(StringBuilder stringBuilder, int i, int i2) {
        stringBuilder.append(SimpleNumberFormatter.m4246a(i, i2));
    }

    private void m3361a(StringBuilder stringBuilder, CalendarFormatSymbols calendarFormatSymbols, int i) {
        int i2 = 1;
        TimeZone timeZone = this.f1963d;
        boolean z = this.f1964e[24] != 0;
        if (i != 4) {
            i2 = 0;
        }
        String displayName = timeZone.getDisplayName(z, i2, calendarFormatSymbols.m3402b());
        if (displayName != null) {
            stringBuilder.append(displayName);
        } else {
            m3362a(stringBuilder, false, false);
        }
    }

    private void m3362a(StringBuilder stringBuilder, boolean z, boolean z2) {
        int a = m3380a(24) + m3380a(23);
        char c = '+';
        if (a < 0) {
            c = '-';
            a = -a;
        }
        if (z) {
            stringBuilder.append("GMT");
        }
        stringBuilder.append(c);
        m3359a(stringBuilder, 2, a / 3600000);
        if (z2) {
            stringBuilder.append(':');
        }
        m3359a(stringBuilder, 2, (a % 3600000) / 60000);
    }

    private int m3378i(int i) {
        int offset = this.f1964e[1] <= 0 ? 0 : this.f1963d.getOffset(1, this.f1964e[1], this.f1964e[5], this.f1964e[9], this.f1964e[14], i);
        if (this.f1964e[1] > 0) {
            return offset - this.f1964e[23];
        }
        return 0;
    }
}
