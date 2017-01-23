package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable<String> {
    public static final u CREATOR;
    private final Bundle DW;
    public final int j6;

    class 1 implements Iterator<String> {
        final /* synthetic */ EventParams DW;
        Iterator<String> j6;

        1(EventParams eventParams) {
            this.DW = eventParams;
            this.j6 = this.DW.DW.keySet().iterator();
        }

        public boolean hasNext() {
            return this.j6.hasNext();
        }

        public String j6() {
            return (String) this.j6.next();
        }

        public /* synthetic */ Object next() {
            return j6();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    static {
        CREATOR = new u();
    }

    EventParams(int i, Bundle bundle) {
        this.j6 = i;
        this.DW = bundle;
    }

    EventParams(Bundle bundle) {
        b.j6((Object) bundle);
        this.DW = bundle;
        this.j6 = 1;
    }

    public Bundle DW() {
        return new Bundle(this.DW);
    }

    public Iterator<String> iterator() {
        return new 1(this);
    }

    public int j6() {
        return this.DW.size();
    }

    Object j6(String str) {
        return this.DW.get(str);
    }

    public String toString() {
        return this.DW.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        u.j6(this, parcel, i);
    }
}
