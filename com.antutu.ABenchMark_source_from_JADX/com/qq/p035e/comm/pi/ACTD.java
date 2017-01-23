package com.qq.p035e.comm.pi;

import android.content.res.Configuration;
import android.os.Bundle;

/* renamed from: com.qq.e.comm.pi.ACTD */
public interface ACTD {
    public static final String APPID_KEY = "appid";
    public static final String DELEGATE_NAME_KEY = "gdt_activity_delegate_name";

    void onAfterCreate(Bundle bundle);

    void onBackPressed();

    void onBeforeCreate(Bundle bundle);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onResume();

    void onStop();
}
