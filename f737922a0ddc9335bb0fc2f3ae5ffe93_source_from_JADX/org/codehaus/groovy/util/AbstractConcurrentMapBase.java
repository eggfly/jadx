package org.codehaus.groovy.util;

public abstract class AbstractConcurrentMapBase {
    final int Hw;
    protected final Segment[] Zo;
    final int v5;

    public static class Segment extends LockableObject {
        int DW;
        protected volatile Object[] FH;
        volatile int j6;

        protected Segment(int i) {
            j6(new Object[i]);
        }

        void j6(Object[] objArr) {
            this.DW = (int) (((float) objArr.length) * 0.75f);
            this.FH = objArr;
        }

        void j6() {
            Object[] objArr = this.FH;
            int length = objArr.length;
            if (length < 1073741824) {
                Object obj;
                int i;
                Object[] objArr2;
                int i2;
                int i3;
                Entry entry;
                int i4 = 0;
                for (int i5 = 0; i5 < length; i5++) {
                    obj = objArr[i5];
                    if (obj != null) {
                        if (obj instanceof Entry) {
                            if (((Entry) obj).EQ()) {
                                i = i4 + 1;
                            } else {
                                objArr[i5] = null;
                                i = i4;
                            }
                            i4 = i;
                        } else {
                            objArr2 = (Object[]) obj;
                            i2 = 0;
                            for (i3 = 0; i3 < objArr2.length; i3++) {
                                entry = (Entry) objArr2[i3];
                                if (entry == null || !entry.EQ()) {
                                    objArr2[i3] = null;
                                } else {
                                    i2++;
                                }
                            }
                            if (i2 == 0) {
                                objArr[i5] = null;
                            } else {
                                i4 += i2;
                            }
                        }
                    }
                }
                Object[] objArr3 = new Object[(i4 + 1 < this.DW ? length : length << 1)];
                int length2 = objArr3.length - 1;
                i2 = 0;
                int i6 = 0;
                while (i2 < length) {
                    obj = objArr[i2];
                    if (obj != null) {
                        if (obj instanceof Entry) {
                            Entry entry2 = (Entry) obj;
                            if (entry2.EQ()) {
                                j6(entry2, entry2.tp() & length2, objArr3);
                                i = i6 + 1;
                            }
                        } else {
                            objArr2 = (Object[]) obj;
                            i3 = i6;
                            for (Object obj2 : objArr2) {
                                entry = (Entry) obj2;
                                if (entry != null && entry.EQ()) {
                                    j6(entry, entry.tp() & length2, objArr3);
                                    i3++;
                                }
                            }
                            i = i3;
                        }
                        i2++;
                        i6 = i;
                    }
                    i = i6;
                    i2++;
                    i6 = i;
                }
                this.DW = (int) (((float) objArr3.length) * 0.75f);
                this.FH = objArr3;
                this.j6 = i6;
            }
        }

        private void j6(Entry entry, int i, Object[] objArr) {
            Object obj = objArr[i];
            if (obj == null) {
                objArr[i] = entry;
            } else if (obj instanceof Entry) {
                objArr[i] = new Object[]{entry, (Entry) obj};
            } else {
                Object[] objArr2 = (Object[]) obj;
                Object obj2 = new Object[(objArr2.length + 1)];
                obj2[0] = entry;
                System.arraycopy(objArr2, 0, obj2, 1, objArr2.length);
                objArr[i] = obj2;
            }
        }
    }

    public interface Entry<V> {
        boolean EQ();

        void j6(V v);

        int tp();

        V u7();
    }

    protected abstract Segment FH(Object obj, int i);

    public AbstractConcurrentMapBase(Object obj) {
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 < 16) {
            i2 <<= 1;
            i3++;
        }
        this.v5 = 32 - i3;
        this.Hw = i2 - 1;
        this.Zo = new Segment[i2];
        i3 = 512 / i2;
        if (i2 * i3 < 512) {
            i3++;
        }
        while (i < i3) {
            i <<= 1;
        }
        for (i3 = 0; i3 < this.Zo.length; i3++) {
            this.Zo[i3] = FH(obj, i);
        }
    }

    protected static <K> int DW(K k) {
        int identityHashCode = System.identityHashCode(k);
        identityHashCode += (identityHashCode << 9) ^ -1;
        identityHashCode ^= identityHashCode >>> 14;
        identityHashCode += identityHashCode << 4;
        return identityHashCode ^ (identityHashCode >>> 10);
    }

    public Segment DW(int i) {
        return this.Zo[(i >>> this.v5) & this.Hw];
    }
}
