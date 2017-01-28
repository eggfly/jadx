import java.util.Map;

public class r<K, V> {
    static Object[] DW;
    static int FH;
    static Object[] Hw;
    static int v5;
    Object[] VH;
    int[] Zo;
    int gn;

    int j6(Object obj, int i) {
        int i2 = this.gn;
        if (i2 == 0) {
            return -1;
        }
        int j6 = m.j6(this.Zo, i2, i);
        if (j6 < 0 || obj.equals(this.VH[j6 << 1])) {
            return j6;
        }
        int i3 = j6 + 1;
        while (i3 < i2 && this.Zo[i3] == i) {
            if (obj.equals(this.VH[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        j6--;
        while (j6 >= 0 && this.Zo[j6] == i) {
            if (obj.equals(this.VH[j6 << 1])) {
                return j6;
            }
            j6--;
        }
        return i3 ^ -1;
    }

    int j6() {
        int i = this.gn;
        if (i == 0) {
            return -1;
        }
        int j6 = m.j6(this.Zo, i, 0);
        if (j6 < 0 || this.VH[j6 << 1] == null) {
            return j6;
        }
        int i2 = j6 + 1;
        while (i2 < i && this.Zo[i2] == 0) {
            if (this.VH[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        j6--;
        while (j6 >= 0 && this.Zo[j6] == 0) {
            if (this.VH[j6 << 1] == null) {
                return j6;
            }
            j6--;
        }
        return i2 ^ -1;
    }

    private void v5(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (l.class) {
                if (Hw != null) {
                    objArr = Hw;
                    this.VH = objArr;
                    Hw = (Object[]) objArr[0];
                    this.Zo = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    v5--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (l.class) {
                if (DW != null) {
                    objArr = DW;
                    this.VH = objArr;
                    DW = (Object[]) objArr[0];
                    this.Zo = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    FH--;
                    return;
                }
            }
        }
        this.Zo = new int[i];
        this.VH = new Object[(i << 1)];
    }

    private static void j6(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (l.class) {
                if (v5 < 10) {
                    objArr[0] = Hw;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    Hw = objArr;
                    v5++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (l.class) {
                if (FH < 10) {
                    objArr[0] = DW;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    DW = objArr;
                    FH++;
                }
            }
        }
    }

    public r() {
        this.Zo = m.j6;
        this.VH = m.FH;
        this.gn = 0;
    }

    public r(int i) {
        if (i == 0) {
            this.Zo = m.j6;
            this.VH = m.FH;
        } else {
            v5(i);
        }
        this.gn = 0;
    }

    public void clear() {
        if (this.gn != 0) {
            j6(this.Zo, this.VH, this.gn);
            this.Zo = m.j6;
            this.VH = m.FH;
            this.gn = 0;
        }
    }

    public void j6(int i) {
        if (this.Zo.length < i) {
            Object obj = this.Zo;
            Object obj2 = this.VH;
            v5(i);
            if (this.gn > 0) {
                System.arraycopy(obj, 0, this.Zo, 0, this.gn);
                System.arraycopy(obj2, 0, this.VH, 0, this.gn << 1);
            }
            j6(obj, obj2, this.gn);
        }
    }

    public boolean containsKey(Object obj) {
        return j6(obj) >= 0;
    }

    public int j6(Object obj) {
        return obj == null ? j6() : j6(obj, obj.hashCode());
    }

    int DW(Object obj) {
        int i = 1;
        int i2 = this.gn * 2;
        Object[] objArr = this.VH;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return DW(obj) >= 0;
    }

    public V get(Object obj) {
        int j6 = j6(obj);
        return j6 >= 0 ? this.VH[(j6 << 1) + 1] : null;
    }

    public K DW(int i) {
        return this.VH[i << 1];
    }

    public V FH(int i) {
        return this.VH[(i << 1) + 1];
    }

    public V j6(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.VH[i2];
        this.VH[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.gn <= 0;
    }

    public V put(K k, V v) {
        int j6;
        int i;
        int i2 = 8;
        if (k == null) {
            j6 = j6();
            i = 0;
        } else {
            i = k.hashCode();
            j6 = j6((Object) k, i);
        }
        if (j6 >= 0) {
            int i3 = (j6 << 1) + 1;
            V v2 = this.VH[i3];
            this.VH[i3] = v;
            return v2;
        }
        j6 ^= -1;
        if (this.gn >= this.Zo.length) {
            if (this.gn >= 8) {
                i2 = this.gn + (this.gn >> 1);
            } else if (this.gn < 4) {
                i2 = 4;
            }
            Object obj = this.Zo;
            Object obj2 = this.VH;
            v5(i2);
            if (this.Zo.length > 0) {
                System.arraycopy(obj, 0, this.Zo, 0, obj.length);
                System.arraycopy(obj2, 0, this.VH, 0, obj2.length);
            }
            j6(obj, obj2, this.gn);
        }
        if (j6 < this.gn) {
            System.arraycopy(this.Zo, j6, this.Zo, j6 + 1, this.gn - j6);
            System.arraycopy(this.VH, j6 << 1, this.VH, (j6 + 1) << 1, (this.gn - j6) << 1);
        }
        this.Zo[j6] = i;
        this.VH[j6 << 1] = k;
        this.VH[(j6 << 1) + 1] = v;
        this.gn++;
        return null;
    }

    public void j6(r<? extends K, ? extends V> rVar) {
        int i = 0;
        int i2 = rVar.gn;
        j6(this.gn + i2);
        if (this.gn != 0) {
            while (i < i2) {
                put(rVar.DW(i), rVar.FH(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(rVar.Zo, 0, this.Zo, 0, i2);
            System.arraycopy(rVar.VH, 0, this.VH, 0, i2 << 1);
            this.gn = i2;
        }
    }

    public V remove(Object obj) {
        int j6 = j6(obj);
        if (j6 >= 0) {
            return Hw(j6);
        }
        return null;
    }

    public V Hw(int i) {
        int i2 = 8;
        V v = this.VH[(i << 1) + 1];
        if (this.gn <= 1) {
            j6(this.Zo, this.VH, this.gn);
            this.Zo = m.j6;
            this.VH = m.FH;
            this.gn = 0;
        } else if (this.Zo.length <= 8 || this.gn >= this.Zo.length / 3) {
            this.gn--;
            if (i < this.gn) {
                System.arraycopy(this.Zo, i + 1, this.Zo, i, this.gn - i);
                System.arraycopy(this.VH, (i + 1) << 1, this.VH, i << 1, (this.gn - i) << 1);
            }
            this.VH[this.gn << 1] = null;
            this.VH[(this.gn << 1) + 1] = null;
        } else {
            if (this.gn > 8) {
                i2 = this.gn + (this.gn >> 1);
            }
            Object obj = this.Zo;
            Object obj2 = this.VH;
            v5(i2);
            this.gn--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.Zo, 0, i);
                System.arraycopy(obj2, 0, this.VH, 0, i << 1);
            }
            if (i < this.gn) {
                System.arraycopy(obj, i + 1, this.Zo, i, this.gn - i);
                System.arraycopy(obj2, (i + 1) << 1, this.VH, i << 1, (this.gn - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.gn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.gn) {
            try {
                Object DW = DW(i);
                Object FH = FH(i);
                Object obj2 = map.get(DW);
                if (FH == null) {
                    if (obj2 != null || !map.containsKey(DW)) {
                        return false;
                    }
                } else if (!FH.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.Zo;
        Object[] objArr = this.VH;
        int i = this.gn;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.gn * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.gn; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            r DW = DW(i);
            if (DW != this) {
                stringBuilder.append(DW);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            DW = FH(i);
            if (DW != this) {
                stringBuilder.append(DW);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
