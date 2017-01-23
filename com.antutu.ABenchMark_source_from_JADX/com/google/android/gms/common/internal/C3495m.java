package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import anet.channel.p017a.C0646b;
import com.umeng.message.common.C4209a;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.google.android.gms.common.internal.m */
public class C3495m {
    private static final Uri f12110a;
    private static final Uri f12111b;

    static {
        f12110a = Uri.parse("http://plus.google.com/");
        f12111b = f12110a.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent m14414a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent m14415a(String str) {
        Uri fromParts = Uri.fromParts(C4209a.f14200c, str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent m14416a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(C3495m.m14417b(str, str2));
        intent.setPackage("com.android.vending");
        intent.addFlags(C0646b.MAX_POOL_SIZE);
        return intent;
    }

    private static Uri m14417b(String str, String str2) {
        Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(AgooConstants.MESSAGE_ID, str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        return appendQueryParameter.build();
    }
}
