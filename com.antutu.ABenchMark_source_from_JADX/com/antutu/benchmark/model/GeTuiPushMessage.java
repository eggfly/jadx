package com.antutu.benchmark.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeTuiPushMessage implements Parcelable {
    public static final Creator<GeTuiPushMessage> CREATOR;
    private String picture;
    private String share_url;
    private String summary;
    private String target;
    private String title;
    private String url;

    /* renamed from: com.antutu.benchmark.model.GeTuiPushMessage.1 */
    static class C15171 implements Creator<GeTuiPushMessage> {
        C15171() {
        }

        public GeTuiPushMessage m6039a(Parcel parcel) {
            return new GeTuiPushMessage(parcel);
        }

        public GeTuiPushMessage[] m6040a(int i) {
            return new GeTuiPushMessage[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6039a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6040a(i);
        }
    }

    static {
        CREATOR = new C15171();
    }

    protected GeTuiPushMessage(Parcel parcel) {
        this.target = parcel.readString();
        this.title = parcel.readString();
        this.summary = parcel.readString();
        this.picture = parcel.readString();
        this.url = parcel.readString();
        this.share_url = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getShare_url() {
        return this.share_url;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTarget() {
        return this.target;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setShare_url(String str) {
        this.share_url = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.target);
        parcel.writeString(this.title);
        parcel.writeString(this.summary);
        parcel.writeString(this.picture);
        parcel.writeString(this.url);
        parcel.writeString(this.share_url);
    }
}
