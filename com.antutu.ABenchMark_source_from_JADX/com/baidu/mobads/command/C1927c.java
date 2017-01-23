package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.baidu.mobads.command.c */
final class C1927c implements Creator<XAdLandingPageExtraInfo> {
    C1927c() {
    }

    public XAdLandingPageExtraInfo m7263a(Parcel parcel) {
        return new XAdLandingPageExtraInfo(null);
    }

    public XAdLandingPageExtraInfo[] m7264a(int i) {
        return new XAdLandingPageExtraInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7263a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7264a(i);
    }
}
