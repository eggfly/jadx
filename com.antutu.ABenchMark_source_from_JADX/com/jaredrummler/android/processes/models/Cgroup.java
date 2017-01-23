package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;

public final class Cgroup extends ProcFile {
    public static final Creator<Cgroup> CREATOR;
    public final ArrayList<ControlGroup> f13301a;

    /* renamed from: com.jaredrummler.android.processes.models.Cgroup.1 */
    class C39661 implements Creator<Cgroup> {
        C39661() {
        }

        public Cgroup m16318a(Parcel parcel) {
            return new Cgroup(null);
        }

        public Cgroup[] m16319a(int i) {
            return new Cgroup[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16318a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16319a(i);
        }
    }

    static {
        CREATOR = new C39661();
    }

    private Cgroup(Parcel parcel) {
        super(parcel);
        this.f13301a = parcel.createTypedArrayList(ControlGroup.CREATOR);
    }

    private Cgroup(String str) {
        super(str);
        String[] split = this.b.split("\n");
        this.f13301a = new ArrayList();
        for (String controlGroup : split) {
            try {
                this.f13301a.add(new ControlGroup(controlGroup));
            } catch (Exception e) {
            }
        }
    }

    public static Cgroup m16321a(int i) {
        return new Cgroup(String.format("/proc/%d/cgroup", new Object[]{Integer.valueOf(i)}));
    }

    public ControlGroup m16322a(String str) {
        Iterator it = this.f13301a.iterator();
        while (it.hasNext()) {
            ControlGroup controlGroup = (ControlGroup) it.next();
            for (String equals : controlGroup.f13303b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (equals.equals(str)) {
                    return controlGroup;
                }
            }
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f13301a);
    }
}
