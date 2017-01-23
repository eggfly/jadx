package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import org.android.agoo.control.BaseIntentService;

public abstract class TaobaoBaseIntentService extends BaseIntentService {
    protected abstract void onError(Context context, String str);

    protected abstract void onMessage(Context context, Intent intent);

    protected abstract void onRegistered(Context context, String str);

    protected abstract void onUnregistered(Context context, String str);

    protected void onUserCommand(Context context, Intent intent) {
    }
}
