package com.google.android.gms.p146b;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C2686R;
import com.google.android.gms.ads.internal.C2968s;
import com.umeng.message.util.HttpRequest;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.en */
public class en extends eq {
    private final Map<String, String> f10798a;
    private final Context f10799b;

    /* renamed from: com.google.android.gms.b.en.1 */
    class C31681 implements OnClickListener {
        final /* synthetic */ String f10794a;
        final /* synthetic */ String f10795b;
        final /* synthetic */ en f10796c;

        C31681(en enVar, String str, String str2) {
            this.f10796c = enVar;
            this.f10794a = str;
            this.f10795b = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) this.f10796c.f10799b.getSystemService("download")).enqueue(this.f10796c.m12611a(this.f10794a, this.f10795b));
            } catch (IllegalStateException e) {
                this.f10796c.m12589b("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.b.en.2 */
    class C31692 implements OnClickListener {
        final /* synthetic */ en f10797a;

        C31692(en enVar) {
            this.f10797a = enVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10797a.m12589b("User canceled the download.");
        }
    }

    public en(ii iiVar, Map<String, String> map) {
        super(iiVar, "storePicture");
        this.f10798a = map;
        this.f10799b = iiVar.m13243f();
    }

    Request m12611a(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        C2968s.m11527g().m13084a(request);
        return request;
    }

    String m12612a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void m12613a() {
        if (this.f10799b == null) {
            m12589b("Activity context is not available");
        } else if (C2968s.m11525e().m13066e(this.f10799b).m11779c()) {
            String str = (String) this.f10798a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                m12589b("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String a = m12612a(str);
                if (C2968s.m11525e().m13061c(a)) {
                    Builder d = C2968s.m11525e().m13063d(this.f10799b);
                    d.setTitle(C2968s.m11528h().m12932a(C2686R.string.store_picture_title, "Save image"));
                    d.setMessage(C2968s.m11528h().m12932a(C2686R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    d.setPositiveButton(C2968s.m11528h().m12932a(C2686R.string.accept, HttpRequest.f14552e), new C31681(this, str, a));
                    d.setNegativeButton(C2968s.m11528h().m12932a(C2686R.string.decline, "Decline"), new C31692(this));
                    d.create().show();
                    return;
                }
                m12589b("Image type not recognized: " + a);
            } else {
                m12589b("Invalid image url: " + str);
            }
        } else {
            m12589b("Feature is not supported by the device.");
        }
    }
}
