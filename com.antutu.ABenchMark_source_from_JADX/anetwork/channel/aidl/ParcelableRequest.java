package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import anetwork.channel.C0750a;
import anetwork.channel.C0767c;
import anetwork.channel.C0768d;
import anetwork.channel.entity.C0769a;
import anetwork.channel.entity.C0772d;
import java.util.ArrayList;
import java.util.List;

public class ParcelableRequest implements Parcelable {
    public static final Creator<ParcelableRequest> CREATOR;
    public long f2457a;
    private C0768d f2458b;
    private BodyEntry f2459c;
    private int f2460d;
    private String f2461e;
    private String f2462f;
    private boolean f2463g;
    private List<C0750a> f2464h;
    private String f2465i;
    private List<C0767c> f2466j;
    private int f2467k;
    private int f2468l;
    private int f2469m;
    private String f2470n;
    private boolean f2471o;
    private boolean f2472p;

    static {
        CREATOR = new C0764h();
    }

    public ParcelableRequest() {
        this.f2464h = new ArrayList();
        this.f2466j = new ArrayList();
        this.f2472p = true;
    }

    public static ParcelableRequest m2995a(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            int i;
            String str;
            int indexOf;
            parcelableRequest.f2460d = parcel.readInt();
            parcelableRequest.f2461e = parcel.readString();
            parcelableRequest.f2462f = parcel.readString();
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            parcelableRequest.f2463g = zArr[0];
            parcelableRequest.f2465i = parcel.readString();
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, ParcelableRequest.class.getClassLoader());
            if (arrayList != null) {
                for (i = 0; i < arrayList.size(); i++) {
                    str = (String) arrayList.get(i);
                    if (str != null) {
                        indexOf = str.indexOf("&");
                        if (!(indexOf == -1 || indexOf == str.length() - 1)) {
                            parcelableRequest.f2464h.add(new C0769a(str.substring(0, indexOf), str.substring(indexOf + 1)));
                        }
                    }
                }
            }
            List readArrayList = parcel.readArrayList(ParcelableRequest.class.getClassLoader());
            if (readArrayList != null) {
                for (i = 0; i < readArrayList.size(); i++) {
                    str = (String) readArrayList.get(i);
                    if (str != null) {
                        indexOf = str.indexOf("&");
                        if (!(indexOf == -1 || indexOf == str.length() - 1)) {
                            parcelableRequest.f2466j.add(new C0772d(str.substring(0, indexOf), str.substring(indexOf + 1)));
                        }
                    }
                }
            }
            parcelableRequest.f2459c = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.f2457a = parcel.readLong();
            parcelableRequest.f2467k = parcel.readInt();
            parcelableRequest.f2468l = parcel.readInt();
            parcelableRequest.f2469m = parcel.readInt();
            parcelableRequest.f2470n = parcel.readString();
            parcelableRequest.f2471o = parcel.readInt() == 1;
            parcelableRequest.f2472p = parcel.readInt() == 1;
        } catch (Throwable th) {
            ALog.m2964w("ANet.ParcelableRequest", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableRequest;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f2458b != null) {
            try {
                int i2;
                parcel.writeInt(this.f2458b.m3042d());
                parcel.writeString(this.f2461e.toString());
                parcel.writeString(this.f2458b.m3044f());
                parcel.writeBooleanArray(new boolean[]{this.f2458b.m3039a()});
                parcel.writeString(this.f2458b.m3041c());
                List arrayList = new ArrayList();
                if (this.f2458b.m3040b() != null) {
                    for (i2 = 0; i2 < this.f2458b.m3040b().size(); i2++) {
                        if (this.f2458b.m3040b().get(i2) != null) {
                            arrayList.add(((C0750a) this.f2458b.m3040b().get(i2)).m2988a() + "&" + ((C0750a) this.f2458b.m3040b().get(i2)).m2989b());
                        }
                    }
                }
                parcel.writeList(arrayList);
                arrayList = this.f2458b.m3043e();
                List arrayList2 = new ArrayList();
                if (arrayList != null) {
                    for (i2 = 0; i2 < arrayList.size(); i2++) {
                        C0767c c0767c = (C0767c) arrayList.get(i2);
                        if (c0767c != null) {
                            arrayList2.add(c0767c.m3037a() + "&" + c0767c.m3038b());
                        }
                    }
                }
                parcel.writeList(arrayList2);
                parcel.writeParcelable(this.f2459c, 0);
                parcel.writeLong(this.f2457a);
                parcel.writeInt(this.f2458b.m3045g());
                parcel.writeInt(this.f2458b.m3046h());
                parcel.writeInt(this.f2458b.m3047i());
                parcel.writeString(this.f2458b.m3048j());
                parcel.writeInt(this.f2471o ? 1 : 0);
                parcel.writeInt(this.f2472p ? 1 : 0);
            } catch (Throwable th) {
                ALog.m2964w("ANet.ParcelableRequest", "[writeToParcel]", null, th, new Object[0]);
            }
        }
    }
}
