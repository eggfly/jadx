package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    class 1 implements OnClickListener {
        final /* synthetic */ PreviewActivity j6;

        1(PreviewActivity previewActivity) {
            this.j6 = previewActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void j6(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new 1(this));
        create.show();
    }

    public void onCreate(Bundle bundle) {
        String valueOf;
        String str;
        try {
            super.onCreate(bundle);
            r.FH("Preview activity");
            Uri data = getIntent().getData();
            if (!d.j6((Context) this).j6(data)) {
                valueOf = String.valueOf(data);
                valueOf = new StringBuilder(String.valueOf(valueOf).length() + 73).append("Cannot preview the app with the uri: ").append(valueOf).append(". Launching current version instead.").toString();
                r.DW(valueOf);
                j6("Preview failure", valueOf, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                String str2 = "Invoke the launch activity for package name: ";
                valueOf = String.valueOf(getPackageName());
                r.FH(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                startActivity(launchIntentForPackage);
                return;
            }
            str = "No launch activity found for package name: ";
            valueOf = String.valueOf(getPackageName());
            r.FH(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (Exception e) {
            str = "Calling preview threw an exception: ";
            valueOf = String.valueOf(e.getMessage());
            r.j6(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
