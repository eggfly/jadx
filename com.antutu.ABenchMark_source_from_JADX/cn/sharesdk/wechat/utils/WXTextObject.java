package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0979d;
import cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject;

public class WXTextObject implements IMediaObject {
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    public boolean checkArgs() {
        if (this.text != null && this.text.length() != 0 && this.text.length() <= 10240) {
            return true;
        }
        C0979d.m4390a().m4375d("checkArgs fail, text is invalid", new Object[0]);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    public int type() {
        return 1;
    }

    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}
