package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import cn.sharesdk.framework.utils.C0979d;
import cn.sharesdk.wechat.utils.WXMediaMessage.C1040a;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.data.Message;

/* renamed from: cn.sharesdk.wechat.utils.d */
public class C1046d extends C1042j {
    public WXMediaMessage f3524a;
    public int f3525b;

    public int m4679a() {
        return 2;
    }

    public void m4680a(Bundle bundle) {
        super.m4668a(bundle);
        bundle.putAll(C1040a.m4632a(this.f3524a));
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.f3525b);
    }

    public boolean m4681b() {
        if (this.f3524a.getType() == 8 && (this.f3524a.thumbData == null || this.f3524a.thumbData.length <= 0)) {
            C0979d.m4390a().m4375d("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
            return false;
        } else if (this.f3524a.thumbData != null && this.f3524a.thumbData.length > Message.FLAG_DATA_TYPE) {
            C0979d.m4390a().m4375d("checkArgs fail, thumbData is invalid", new Object[0]);
            return false;
        } else if (this.f3524a.title == null || this.f3524a.title.length() <= AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            if (this.f3524a.description != null && this.f3524a.description.length() > IXAdIOUtils.BUFFER_SIZE) {
                this.f3524a.description = this.f3524a.description.substring(0, 1021) + "...";
            }
            if (this.f3524a.mediaObject != null) {
                return this.f3524a.mediaObject.checkArgs();
            }
            C0979d.m4390a().m4375d("checkArgs fail, mediaObject is null", new Object[0]);
            return false;
        } else {
            C0979d.m4390a().m4375d("checkArgs fail, title is invalid", new Object[0]);
            return false;
        }
    }
}
