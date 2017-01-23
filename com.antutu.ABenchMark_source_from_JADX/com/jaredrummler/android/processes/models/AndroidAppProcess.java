package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xiaomi.pushsdk.BuildConfig;

public class AndroidAppProcess extends AndroidProcess {
    public static final Creator<AndroidAppProcess> CREATOR;
    public boolean f13297a;
    public int f13298b;
    private final Cgroup f13299e;

    /* renamed from: com.jaredrummler.android.processes.models.AndroidAppProcess.1 */
    class C39631 implements Creator<AndroidAppProcess> {
        C39631() {
        }

        public AndroidAppProcess m16309a(Parcel parcel) {
            return new AndroidAppProcess(parcel);
        }

        public AndroidAppProcess[] m16310a(int i) {
            return new AndroidAppProcess[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16309a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16310a(i);
        }
    }

    /* renamed from: com.jaredrummler.android.processes.models.AndroidAppProcess.a */
    public static final class C3964a extends Exception {
        public C3964a(int i) {
            super(String.format("The process %d does not belong to any application", new Object[]{Integer.valueOf(i)}));
        }
    }

    static {
        CREATOR = new C39631();
    }

    public AndroidAppProcess(int i) {
        boolean z = true;
        super(i);
        this.f13299e = super.m16312b();
        ControlGroup a = this.f13299e.m16322a("cpuacct");
        ControlGroup a2 = this.f13299e.m16322a("cpu");
        if (a2 == null || a == null || !a.f13304c.contains("pid_")) {
            throw new C3964a(i);
        }
        if (a2.f13304c.contains("bg_non_interactive")) {
            z = false;
        }
        this.f13297a = z;
        try {
            this.f13298b = Integer.parseInt(a.f13304c.split("/")[1].replace("uid_", BuildConfig.FLAVOR));
        } catch (Exception e) {
            this.f13298b = m16313c().m16334a();
        }
    }

    protected AndroidAppProcess(Parcel parcel) {
        super(parcel);
        this.f13299e = (Cgroup) parcel.readParcelable(Cgroup.class.getClassLoader());
        this.f13297a = parcel.readByte() != null;
    }

    public String m16314a() {
        return this.c.split(":")[0];
    }

    public Cgroup m16315b() {
        return this.f13299e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f13299e, i);
        parcel.writeByte((byte) (this.f13297a ? 1 : 0));
    }
}
