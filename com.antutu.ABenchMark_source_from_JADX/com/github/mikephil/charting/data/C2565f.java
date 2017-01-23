package com.github.mikephil.charting.data;

import android.support.v4.widget.AutoScrollHelper;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.f */
public abstract class C2565f<T extends Entry> extends C2564d<T> {
    protected List<T> f8941k;
    protected float f8942l;
    protected float f8943m;

    /* renamed from: com.github.mikephil.charting.data.f.a */
    public enum C2568a {
        UP,
        DOWN,
        CLOSEST
    }

    public C2565f(List<T> list, String str) {
        super(str);
        this.f8941k = null;
        this.f8942l = 0.0f;
        this.f8943m = 0.0f;
        this.f8941k = list;
        if (this.f8941k == null) {
            this.f8941k = new ArrayList();
        }
        m9813a(0, this.f8941k.size());
    }

    public int m9811a(Entry entry) {
        return this.f8941k.indexOf(entry);
    }

    public T m9812a(int i, C2568a c2568a) {
        int b = m9814b(i, c2568a);
        return b > -1 ? (Entry) this.f8941k.get(b) : null;
    }

    public void m9813a(int i, int i2) {
        if (this.f8941k != null) {
            int size = this.f8941k.size();
            if (size != 0) {
                if (i2 == 0 || i2 >= size) {
                    i2 = size - 1;
                }
                this.f8943m = AutoScrollHelper.NO_MAX;
                this.f8942l = -3.4028235E38f;
                while (i <= i2) {
                    Entry entry = (Entry) this.f8941k.get(i);
                    if (!(entry == null || Float.isNaN(entry.m9742b()))) {
                        if (entry.m9742b() < this.f8943m) {
                            this.f8943m = entry.m9742b();
                        }
                        if (entry.m9742b() > this.f8942l) {
                            this.f8942l = entry.m9742b();
                        }
                    }
                    i++;
                }
                if (this.f8943m == AutoScrollHelper.NO_MAX) {
                    this.f8943m = 0.0f;
                    this.f8942l = 0.0f;
                }
            }
        }
    }

    public int m9814b(int i, C2568a c2568a) {
        int i2;
        int i3 = 0;
        int size = this.f8941k.size() - 1;
        int i4 = -1;
        while (i3 <= size) {
            i4 = (size + i3) / 2;
            if (i == ((Entry) this.f8941k.get(i4)).m9743d()) {
                size = i4;
                while (size > 0 && ((Entry) this.f8941k.get(size - 1)).m9743d() == i) {
                    size--;
                }
                return size;
            }
            if (i > ((Entry) this.f8941k.get(i4)).m9743d()) {
                int i5 = size;
                size = i4 + 1;
                i2 = i5;
            } else {
                i2 = i4 - 1;
                size = i3;
            }
            i3 = size;
            size = i2;
        }
        if (i4 != -1) {
            i2 = ((Entry) this.f8941k.get(i4)).m9743d();
            if (c2568a == C2568a.UP) {
                if (i2 < i && i4 < this.f8941k.size() - 1) {
                    return i4 + 1;
                }
            } else if (c2568a == C2568a.DOWN && i2 > i && i4 > 0) {
                return i4 - 1;
            }
        }
        return i4;
    }

    public T m9815e(int i) {
        return m9812a(i, C2568a.CLOSEST);
    }

    public T m9816f(int i) {
        return (Entry) this.f8941k.get(i);
    }

    public float m9817g(int i) {
        Entry e = m9815e(i);
        return (e == null || e.m9743d() != i) ? Float.NaN : e.m9742b();
    }

    public int m9818m() {
        return this.f8941k.size();
    }

    public String m9819n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DataSet, label: " + (m9803e() == null ? BuildConfig.FLAVOR : m9803e()) + ", entries: " + this.f8941k.size() + "\n");
        return stringBuffer.toString();
    }

    public float m9820o() {
        return this.f8943m;
    }

    public float m9821p() {
        return this.f8942l;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m9819n());
        for (int i = 0; i < this.f8941k.size(); i++) {
            stringBuffer.append(((Entry) this.f8941k.get(i)).toString() + " ");
        }
        return stringBuffer.toString();
    }
}
