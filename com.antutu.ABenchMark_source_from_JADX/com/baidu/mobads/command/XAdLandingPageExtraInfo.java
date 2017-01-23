package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p080j.C1982d;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;

public class XAdLandingPageExtraInfo extends XAdCommandExtraInfo {
    public static final Creator<XAdLandingPageExtraInfo> CREATOR;
    public int e75;
    public int from;
    public boolean isFullScreen;
    public int orientation;
    public int os;
    public String prodType;
    public String sn;
    public String title;
    public String f6715v;

    static {
        CREATOR = new C1927c();
    }

    private XAdLandingPageExtraInfo(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
        this.url = parcel.readString();
        if (parcel.readByte() == null) {
            z = false;
        }
        this.isFullScreen = z;
        this.orientation = parcel.readInt();
        this.e75 = parcel.readInt();
        this.from = parcel.readInt();
        this.adid = parcel.readString();
        this.qk = parcel.readString();
        this.packageNameOfPubliser = parcel.readString();
        this.appsid = parcel.readString();
        this.appsec = parcel.readString();
        this.os = parcel.readInt();
        this.prodType = parcel.readString();
        this.f6715v = parcel.readString();
        this.sn = parcel.readString();
        this.title = parcel.readString();
    }

    public XAdLandingPageExtraInfo(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        super(str, iXAdInstanceInfo);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1982d m = C1991m.m7449a().m7464m();
        IXAdSystemUtils n = C1991m.m7449a().m7465n();
        super.writeToParcel(parcel, i);
        parcel.writeString(this.url);
        parcel.writeByte((byte) (this.isFullScreen ? 1 : 0));
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.e75);
        parcel.writeInt(this.from);
        parcel.writeString(this.adid);
        parcel.writeString(this.qk);
        parcel.writeString(this.packageNameOfPubliser);
        parcel.writeString(this.appsid);
        parcel.writeString(this.appsec);
        parcel.writeInt(1);
        parcel.writeString(this.mProdType);
        parcel.writeString(m.m7418a());
        parcel.writeString(n.getEncodedSN(C1991m.m7449a().m7455d()));
        this.title = TextUtils.isEmpty(this.title) ? BuildConfig.FLAVOR : this.title;
        parcel.writeString(this.title);
    }
}
