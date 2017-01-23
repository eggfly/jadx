package com.miui.support.internal.webkit;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;

public class DeviceAccountLogin {
    protected Activity f2834a;
    protected AccountManager f2835b;
    private AccountManagerCallback<Bundle> f2836c;

    private static class LoginCallback implements AccountManagerCallback<Bundle> {
        private WeakReference<DeviceAccountLogin> f2840a;

        public LoginCallback(DeviceAccountLogin deviceAccountLogin) {
            this.f2840a = new WeakReference(deviceAccountLogin);
        }

        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            DeviceAccountLogin deviceAccountLogin = (DeviceAccountLogin) this.f2840a.get();
            if (deviceAccountLogin != null) {
                try {
                    String string = ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
                    if (string == null) {
                        deviceAccountLogin.m4594b();
                    } else {
                        deviceAccountLogin.m4592a(string);
                    }
                } catch (Throwable e) {
                    Log.e("DeviceAccountLogin", "Fail to login", e);
                    deviceAccountLogin.m4594b();
                }
            }
        }
    }

    public DeviceAccountLogin(Activity activity) {
        this.f2834a = activity;
        this.f2835b = AccountManager.get(this.f2834a.getApplicationContext());
        this.f2836c = new LoginCallback(this);
    }

    public void m4593a(String str, String str2, String str3) {
        int i = 0;
        Account[] accountsByType = this.f2835b.getAccountsByType(str);
        if (accountsByType.length == 0) {
            m4595c();
            return;
        }
        Account account;
        if (TextUtils.isEmpty(str2)) {
            account = accountsByType[0];
        } else {
            int length = accountsByType.length;
            while (i < length) {
                account = accountsByType[i];
                if (account.name.equals(str2)) {
                    break;
                }
                i++;
            }
            account = null;
        }
        if (account != null) {
            m4591a();
            this.f2835b.getAuthToken(account, "weblogin:" + str3, null, null, this.f2836c, null);
            return;
        }
        m4595c();
    }

    public void m4591a() {
    }

    public void m4595c() {
    }

    public void m4592a(String str) {
    }

    public void m4594b() {
    }

    public void m4596d() {
    }
}
