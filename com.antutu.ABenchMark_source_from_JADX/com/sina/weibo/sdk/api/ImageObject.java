package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import cn.sharesdk.framework.utils.C0979d;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageObject implements Parcelable {
    public static final Creator<ImageObject> CREATOR;
    private static final int DATA_SIZE;
    public byte[] imageData;
    public String imagePath;

    /* renamed from: com.sina.weibo.sdk.api.ImageObject.1 */
    static class C40691 implements Creator<ImageObject> {
        C40691() {
        }

        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    }

    static {
        DATA_SIZE = AccessibilityNodeInfoCompat.ACTION_SET_TEXT;
        CREATOR = new C40691();
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            new Throwable("imageData and imagePath are null").printStackTrace();
            return false;
        } else if (this.imageData != null && this.imageData.length > DATA_SIZE) {
            new Throwable("imageData is too large").printStackTrace();
            return false;
        } else if (this.imagePath == null || this.imagePath.length() <= AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            if (this.imagePath != null) {
                try {
                    File file = new File(this.imagePath);
                    if (!file.exists() || file.length() == 0 || file.length() > 10485760) {
                        new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
                    return false;
                }
            }
            return true;
        } else {
            new Throwable("imagePath is too length").printStackTrace();
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 2;
    }

    public final void setImageObject(Bitmap bitmap) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.imageData = byteArrayOutputStream.toByteArray();
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
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }
}
