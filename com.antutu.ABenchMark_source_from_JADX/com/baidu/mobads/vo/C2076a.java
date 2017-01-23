package com.baidu.mobads.vo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.baidu.mobads.vo.a */
final class C2076a implements Creator<XAdInstanceInfo> {
    C2076a() {
    }

    public XAdInstanceInfo m7760a(Parcel parcel) {
        return new XAdInstanceInfo(null);
    }

    public XAdInstanceInfo[] m7761a(int i) {
        return new XAdInstanceInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7760a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7761a(i);
    }
}
