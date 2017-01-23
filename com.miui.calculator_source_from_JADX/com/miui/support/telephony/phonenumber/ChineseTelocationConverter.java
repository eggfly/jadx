package com.miui.support.telephony.phonenumber;

import android.util.Log;
import com.miui.support.internal.util.DirectIndexedFileExtractor;
import com.miui.support.util.AppConstants;
import com.miui.support.util.DirectIndexedFile;
import com.miui.support.util.DirectIndexedFile.Reader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class ChineseTelocationConverter {
    private static final HashSet<CharSequence> f3550a;
    private static ChineseTelocationConverter f3551b;
    private HashMap<String, String> f3552c;
    private HashMap<CharSequence, String> f3553d;
    private HashSet<CharSequence> f3554e;
    private Reader f3555f;

    private interface DatFileRawReadListener {
    }

    /* renamed from: com.miui.support.telephony.phonenumber.ChineseTelocationConverter.1 */
    class C04171 implements DatFileRawReadListener {
    }

    /* renamed from: com.miui.support.telephony.phonenumber.ChineseTelocationConverter.2 */
    class C04182 implements DatFileRawReadListener {
    }

    static {
        f3550a = new HashSet();
        f3551b = new ChineseTelocationConverter();
        f3550a.add("170");
        f3550a.add("171");
    }

    private ChineseTelocationConverter() {
        this.f3552c = new HashMap();
        this.f3553d = new HashMap();
        this.f3554e = new HashSet();
        String a = DirectIndexedFileExtractor.m4222a(AppConstants.m4227a(), "telocation.idf");
        if (a != null && new File(a).exists()) {
            try {
                this.f3555f = DirectIndexedFile.m5369a(a);
                Log.v("ChineseTelocation", "Read Telocation from " + a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f3555f == null) {
            try {
                this.f3555f = DirectIndexedFile.m5368a(AppConstants.m4227a().getResources().getAssets().open("telocation.idf", 1));
                Log.v("ChineseTelocation", "Read Telocation from assets");
            } catch (IOException e2) {
                Log.w("ChineseTelocation", "Can't read telocation.idf, NO mobile telocation supported!");
            }
        }
    }

    protected void finalize() {
        if (this.f3555f != null) {
            this.f3555f.m5367b();
        }
        super.finalize();
    }
}
