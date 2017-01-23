package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;

public class TextObject implements Parcelable {
    public static final Creator<TextObject> CREATOR;
    public String text;

    /* renamed from: com.sina.weibo.sdk.api.TextObject.1 */
    static class C40701 implements Creator<TextObject> {
        C40701() {
        }

        public TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        public TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    }

    static {
        CREATOR = new C40701();
    }

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }

    public boolean checkArgs() {
        return !TextUtils.isEmpty(this.text) && this.text.length() <= IXAdIOUtils.BUFFER_SIZE;
    }

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }
}
