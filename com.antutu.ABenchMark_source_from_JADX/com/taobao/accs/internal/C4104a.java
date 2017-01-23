package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.UtilityImpl;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.taobao.accs.internal.a */
class C4104a implements Runnable {
    final /* synthetic */ Context f13744a;
    final /* synthetic */ ACCSManagerImpl f13745b;

    C4104a(ACCSManagerImpl aCCSManagerImpl, Context context) {
        this.f13745b = aCCSManagerImpl;
        this.f13744a = context;
    }

    public void run() {
        Intent intent = new Intent(Constants.ACTION_START_SERVICE);
        intent.putExtra(Constants.KEY_APP_KEY, UtilityImpl.getAppkey(this.f13744a));
        intent.putExtra(Constants.KEY_TTID, UtilityImpl.getTtId(this.f13744a));
        intent.putExtra(Constants.KEY_PACKAGE_NAME, this.f13744a.getPackageName());
        intent.putExtra(Constants.SP_APP_SECRET, GlobalClientInfo.getInstance(this.f13744a).getAppSecret());
        intent.setClassName(this.f13744a.getPackageName(), C4135a.channelService);
        this.f13744a.startService(intent);
        intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_REPORT);
        intent.setPackage(this.f13744a.getPackageName());
        intent.setClassName(this.f13744a.getPackageName(), C4085a.m16663b(this.f13744a.getPackageName()));
        this.f13744a.startService(intent);
    }
}
