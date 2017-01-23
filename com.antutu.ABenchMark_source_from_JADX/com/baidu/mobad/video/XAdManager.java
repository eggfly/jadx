package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.p080j.C1991m;

public class XAdManager implements IXAdManager {
    private static IXAdManager f6543d;
    private String f6544a;
    private Location f6545b;
    private Context f6546c;

    private XAdManager(Context context) {
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        this.f6546c = context;
    }

    public static IXAdManager getInstance(Context context) {
        if (f6543d == null) {
            f6543d = new XAdManager(context);
        }
        return f6543d;
    }

    public String getVersion() {
        return "8.8";
    }

    public IXAdContext newAdContext() {
        return new XAdContext(this.f6546c, this.f6544a, this.f6545b);
    }

    public void setAppSid(String str) {
        this.f6544a = str;
        C1991m.m7449a().m7464m().setAppId(str);
    }

    public void setLocation(Location location) {
        this.f6545b = location;
    }
}
