package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProcFile extends File implements Parcelable {
    public static final Creator<ProcFile> CREATOR;
    public final String f13300b;

    /* renamed from: com.jaredrummler.android.processes.models.ProcFile.1 */
    class C39681 implements Creator<ProcFile> {
        C39681() {
        }

        public ProcFile m16325a(Parcel parcel) {
            return new ProcFile(parcel);
        }

        public ProcFile[] m16326a(int i) {
            return new ProcFile[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16325a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16326a(i);
        }
    }

    static {
        CREATOR = new C39681();
    }

    protected ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.f13300b = parcel.readString();
    }

    protected ProcFile(String str) {
        super(str);
        this.f13300b = m16320b(str);
    }

    protected static String m16320b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        stringBuilder.append(bufferedReader.readLine());
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append('\n').append(readLine);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public long length() {
        return (long) this.f13300b.length();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.f13300b);
    }
}
