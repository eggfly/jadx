package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import cn.sharesdk.framework.utils.C0979d;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.data.Message;
import java.io.ByteArrayOutputStream;

public class WebpageObject implements Parcelable {
    public static final Creator<WebpageObject> CREATOR;
    public static final String EXTRA_KEY_DEFAULTTEXT;
    public String actionUrl;
    public String defaultText;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    /* renamed from: com.sina.weibo.sdk.api.WebpageObject.1 */
    static class C40711 implements Creator<WebpageObject> {
        C40711() {
        }

        public WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        public WebpageObject[] newArray(int i) {
            return new WebpageObject[i];
        }
    }

    static {
        EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
        CREATOR = new C40711();
    }

    public WebpageObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    public boolean checkArgs() {
        if (this.actionUrl == null || this.actionUrl.length() > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            C0979d.m4390a().m4375d("checkArgs fail, actionUrl is invalid", new Object[0]);
            return false;
        } else if (this.identify == null || this.identify.length() > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            C0979d.m4390a().m4375d("checkArgs fail, identify is invalid", new Object[0]);
            return false;
        } else if (this.thumbData == null || this.thumbData.length > Message.FLAG_DATA_TYPE) {
            new Throwable("checkArgs fail, thumbData is invalid,size is " + (this.thumbData != null ? this.thumbData.length : -1) + "! more then 32768.").printStackTrace();
            return false;
        } else if (this.title == null || this.title.length() > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            C0979d.m4390a().m4375d("checkArgs fail, title is invalid", new Object[0]);
            return false;
        } else if (this.description != null && this.description.length() <= IXAdIOUtils.BUFFER_SIZE) {
            return true;
        } else {
            C0979d.m4390a().m4375d("checkArgs fail, description is invalid", new Object[0]);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 5;
    }

    public final void setThumbImage(Bitmap bitmap) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.thumbData = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        C0979d.m4390a().m4376d(th2);
                    }
                }
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    C0979d.m4390a().m4376d(th2);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th22) {
                            C0979d.m4390a().m4376d(th22);
                        }
                    }
                } catch (Throwable th4) {
                    th22 = th4;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th5) {
                            C0979d.m4390a().m4376d(th5);
                        }
                    }
                    throw th22;
                }
            }
        } catch (Throwable th6) {
            th22 = th6;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th22;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }
}
