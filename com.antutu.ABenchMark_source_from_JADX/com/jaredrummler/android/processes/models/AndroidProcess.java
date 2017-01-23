package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.IOException;

public class AndroidProcess implements Parcelable {
    public static final Creator<AndroidProcess> CREATOR;
    public final String f13295c;
    public final int f13296d;

    /* renamed from: com.jaredrummler.android.processes.models.AndroidProcess.1 */
    class C39651 implements Creator<AndroidProcess> {
        C39651() {
        }

        public AndroidProcess m16316a(Parcel parcel) {
            return new AndroidProcess(parcel);
        }

        public AndroidProcess[] m16317a(int i) {
            return new AndroidProcess[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16316a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16317a(i);
        }
    }

    static {
        CREATOR = new C39651();
    }

    public AndroidProcess(int i) {
        this.f13296d = i;
        this.f13295c = m16311a(i);
    }

    protected AndroidProcess(Parcel parcel) {
        this.f13295c = parcel.readString();
        this.f13296d = parcel.readInt();
    }

    static String m16311a(int i) {
        Object obj = null;
        try {
            obj = ProcFile.m16320b(String.format("/proc/%d/cmdline", new Object[]{Integer.valueOf(i)})).trim();
        } catch (IOException e) {
        }
        return (TextUtils.isEmpty(obj) || "null".equals(obj)) ? Stat.m16329a(i).m16330a() : obj;
    }

    public Cgroup m16312b() {
        return Cgroup.m16321a(this.f13296d);
    }

    public Status m16313c() {
        return Status.m16333a(this.f13296d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13295c);
        parcel.writeInt(this.f13296d);
    }
}
