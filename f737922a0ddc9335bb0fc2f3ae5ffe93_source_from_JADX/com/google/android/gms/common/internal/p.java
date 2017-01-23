package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.gy;

public abstract class p implements OnClickListener {

    class 1 extends p {
        final /* synthetic */ Intent DW;
        final /* synthetic */ int FH;
        final /* synthetic */ Activity j6;

        1(Activity activity, Intent intent, int i) {
            this.j6 = activity;
            this.DW = intent;
            this.FH = i;
        }

        public void j6() {
            this.j6.startActivityForResult(this.DW, this.FH);
        }
    }

    class 2 extends p {
        final /* synthetic */ Intent DW;
        final /* synthetic */ int FH;
        final /* synthetic */ Fragment j6;

        2(Fragment fragment, Intent intent, int i) {
            this.j6 = fragment;
            this.DW = intent;
            this.FH = i;
        }

        public void j6() {
            this.j6.j6(this.DW, this.FH);
        }
    }

    class 3 extends p {
        final /* synthetic */ Intent DW;
        final /* synthetic */ int FH;
        final /* synthetic */ gy j6;

        3(gy gyVar, Intent intent, int i) {
            this.j6 = gyVar;
            this.DW = intent;
            this.FH = i;
        }

        @TargetApi(11)
        public void j6() {
            this.j6.startActivityForResult(this.DW, this.FH);
        }
    }

    public static p j6(Activity activity, Intent intent, int i) {
        return new 1(activity, intent, i);
    }

    public static p j6(Fragment fragment, Intent intent, int i) {
        return new 2(fragment, intent, i);
    }

    public static p j6(gy gyVar, Intent intent, int i) {
        return new 3(gyVar, intent, i);
    }

    public abstract void j6();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            j6();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
