package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class WebImage extends AbstractSafeParcelable {
    public static final Creator<WebImage> CREATOR;
    private final Uri DW;
    private final int FH;
    private final int Hw;
    private final int j6;

    static {
        CREATOR = new b();
    }

    WebImage(int i, Uri uri, int i2, int i3) {
        this.j6 = i;
        this.DW = uri;
        this.FH = i2;
        this.Hw = i3;
    }

    public Uri DW() {
        return this.DW;
    }

    public int FH() {
        return this.FH;
    }

    public int Hw() {
        return this.Hw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return ae.j6(this.DW, webImage.DW) && this.FH == webImage.FH && this.Hw == webImage.Hw;
    }

    public int hashCode() {
        return ae.j6(this.DW, Integer.valueOf(this.FH), Integer.valueOf(this.Hw));
    }

    int j6() {
        return this.j6;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.FH), Integer.valueOf(this.Hw), this.DW.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
