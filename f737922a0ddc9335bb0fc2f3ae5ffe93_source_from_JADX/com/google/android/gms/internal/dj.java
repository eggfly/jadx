package com.google.android.gms.internal;

import aeq$c;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.internal.f;
import java.util.Map;

@eh
public class dj extends dm {
    private final Context DW;
    private final Map<String, String> j6;

    class 1 implements OnClickListener {
        final /* synthetic */ String DW;
        final /* synthetic */ dj FH;
        final /* synthetic */ String j6;

        1(dj djVar, String str, String str2) {
            this.FH = djVar;
            this.j6 = str;
            this.DW = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) this.FH.DW.getSystemService("download")).enqueue(this.FH.j6(this.j6, this.DW));
            } catch (IllegalStateException e) {
                this.FH.DW("Could not store picture.");
            }
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ dj j6;

        2(dj djVar) {
            this.j6 = djVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.DW("User canceled the download.");
        }
    }

    public dj(fj fjVar, Map<String, String> map) {
        super(fjVar, "storePicture");
        this.j6 = map;
        this.DW = fjVar.VH();
    }

    Request j6(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        f.v5().j6(request);
        return request;
    }

    String j6(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void j6() {
        if (this.DW == null) {
            DW("Activity context is not available");
        } else if (f.FH().FH(this.DW).FH()) {
            String str = (String) this.j6.get("iurl");
            if (TextUtils.isEmpty(str)) {
                DW("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String j6 = j6(str);
                if (f.FH().DW(j6)) {
                    Resources Hw = f.Zo().Hw();
                    Builder DW = f.FH().DW(this.DW);
                    DW.setTitle(Hw != null ? Hw.getString(aeq$c.store_picture_title) : "Save image");
                    DW.setMessage(Hw != null ? Hw.getString(aeq$c.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                    DW.setPositiveButton(Hw != null ? Hw.getString(aeq$c.accept) : "Accept", new 1(this, str, j6));
                    DW.setNegativeButton(Hw != null ? Hw.getString(aeq$c.decline) : "Decline", new 2(this));
                    DW.create().show();
                    return;
                }
                r1 = "Image type not recognized: ";
                str = String.valueOf(j6);
                DW(str.length() != 0 ? r1.concat(str) : new String(r1));
            } else {
                r1 = "Invalid image url: ";
                str = String.valueOf(str);
                DW(str.length() != 0 ? r1.concat(str) : new String(r1));
            }
        } else {
            DW("Feature is not supported by the device.");
        }
    }
}
