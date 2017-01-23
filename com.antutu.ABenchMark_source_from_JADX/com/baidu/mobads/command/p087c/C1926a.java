package com.baidu.mobads.command.p087c;

import android.content.Intent;
import android.os.Parcelable;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.command.C1921b;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.p080j.C1982d;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.command.c.a */
public class C1926a extends C1921b {
    private String f6757f;

    public C1926a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.f6757f = null;
        this.f6757f = str;
    }

    public void m7262a() {
        try {
            C1982d m = C1991m.m7449a().m7464m();
            IXAdActivityUtils o = C1991m.m7449a().m7466o();
            Parcelable xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.b.getProdInfo().getProdType(), this.c);
            xAdLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdLandingPageExtraInfo.url = this.f6757f;
            xAdLandingPageExtraInfo.e75 = 1;
            xAdLandingPageExtraInfo.from = 0;
            xAdLandingPageExtraInfo.adid = this.c.getAdId();
            xAdLandingPageExtraInfo.qk = this.c.getQueryKey();
            xAdLandingPageExtraInfo.packageNameOfPubliser = this.a.getPackageName();
            xAdLandingPageExtraInfo.appsid = m.getAppId(this.a);
            xAdLandingPageExtraInfo.appsec = m.getAppSec(this.a);
            xAdLandingPageExtraInfo.title = this.c.getTitle();
            Intent intent = new Intent(this.a, AppActivity.class);
            if (this.b.getActivity() != null) {
                xAdLandingPageExtraInfo.isFullScreen = o.isFullScreen(this.b.getActivity()).booleanValue();
            }
            xAdLandingPageExtraInfo.orientation = this.a.getResources().getConfiguration().orientation;
            intent.putExtra(AppActivity.EXTRA_DATA, xAdLandingPageExtraInfo);
            intent.addFlags(268435456);
            this.a.startActivity(intent);
        } catch (Exception e) {
        }
    }
}
