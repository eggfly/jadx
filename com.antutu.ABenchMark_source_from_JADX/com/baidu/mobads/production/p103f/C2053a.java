package com.baidu.mobads.production.p103f;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.C2031d;
import com.igexin.download.Downloads;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.baidu.mobads.production.f.a */
public class C2053a extends C2031d {
    protected IXAdProd f7159a;

    public C2053a(Context context, Activity activity, SlotType slotType, IXAdProd iXAdProd) {
        super(context, activity, slotType);
        this.b = "http://mobads.baidu.com/cpro/ui/mads.php";
        this.f7159a = iXAdProd;
    }

    protected HashMap<String, String> m7722a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("slottype", this.f.getValue());
        hashMap.put(Downloads.COLUMN_MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
        hashMap.put("prod", "video");
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
        hashMap.put(IXAdRequestInfo.AD_TYPE, AgooConstants.ACK_REMOVE_PACKAGE);
        hashMap.put(IXAdRequestInfo.AD_COUNT, MessageService.MSG_DB_NOTIFY_REACHED);
        if (this.f7159a.getProdBase() == null) {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, "640");
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, "480");
        }
        return hashMap;
    }

    public String m7723b() {
        return super.m7616b();
    }
}
