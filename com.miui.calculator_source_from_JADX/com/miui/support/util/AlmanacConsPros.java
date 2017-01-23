package com.miui.support.util;

import android.util.Log;
import com.miui.support.internal.util.DirectIndexedFileExtractor;
import com.miui.support.util.DirectIndexedFile.Reader;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

public class AlmanacConsPros {
    private static final Long f3599a;
    private static final Long f3600b;
    private static final String[] f3601c;
    private Reader f3602d;

    static {
        f3599a = Long.valueOf(new GregorianCalendar(1901, 0, 1).getTimeInMillis());
        f3600b = Long.valueOf(new GregorianCalendar(2100, 11, 31).getTimeInMillis());
        f3601c = new String[]{"\u7acb\u7891", "\u796d\u7940", "\u8d77\u57fa", "\u79fb\u5f99", "\u5f00\u4ed3", "\u7834\u5c4b", "\u4f5c\u5395", "\u5408\u5e10", "\u5165\u5b66", "\u4ea4\u6613", "\u9020\u4ed3", "\u6302\u533e", "\u7834\u571f", "\u5408\u810a", "\u542f\u6512", "\u658b\u91ae", "\u6559\u725b\u9a6c", "\u6355\u6349", "\u5b89\u846c", "\u4f59\u4e8b\u52ff\u53d6", "\u5b89\u9999", "\u5b89\u95e8", "\u4e0a\u6881", "\u5408\u5bff\u6728", "\u884c\u4e27", "\u8ba2\u76df", "\u7ecf\u7edc", "\u7ed3\u7f51", "\u9020\u6865", "\u5b89\u5e8a", "\u53d6\u6e14", "\u6c90\u6d74", "\u79fb\u67e9", "\u9020\u755c\u6906\u6816", "\u916c\u795e", "\u8fdb\u4eba\u53e3", "\u5f00\u751f\u575f", "\u683d\u79cd", "\u4f5c\u6881", "\u666e\u6e21", "\u6398\u4e95", "\u8c22\u571f", "\u7acb\u5238", "\u5272\u871c", "\u4e58\u8239", "\u5165\u5b85", "\u5206\u5c45", "\u67b6\u9a6c", "\u5f52\u5b81", "\u5b89\u7893\u78d1", "\u96d5\u523b", "\u5851\u7ed8", "\u7948\u798f", "\u5f00\u5149", "\u65ad\u8681", "\u51fa\u706b", "\u5165\u6b93", "\u9020\u5c4b", "\u4fee\u9970\u57a3\u5899", "\u9020\u8f66\u5668", "\u51fa\u884c", "\u88c1\u8863", "\u6574\u624b\u8db3\u7532", "\u5e73\u6cbb\u9053\u6d82", "\u9020\u8239", "\u5f52\u5cab", "\u7eb3\u5a7f", "\u95ee\u540d", "\u96c7\u5eb8", "\u51a0\u7b04", "\u5f00\u67f1\u773c", "\u4fee\u95e8", "\u7406\u53d1", "\u4e60\u827a", "\u7eb3\u755c", "\u5f00\u6e20", "\u7f6e\u4ea7", "\u7eb3\u8d22", "\u5b89\u673a\u68b0", "\u51fa\u8d27\u8d22", "\u62c6\u5378", "\u7eb3\u91c7", "\u4fee\u575f", "\u626b\u820d", "\u6c42\u55e3", "\u653e\u6c34", "\u8865\u57a3", "\u63a2\u75c5", "\u6c42\u533b", "\u9488\u7078", "\u7ad6\u67f1", "\u6210\u670d", "\u5f00\u6c60", "\u4f10\u6728", "\u4f5c\u7076", "\u8bcd\u8bbc", "\u8d74\u4efb", "\u574f\u57a3", "\u585e\u7a74", "\u7b51\u5824", "\u4f1a\u4eb2\u53cb", "\u7267\u517b", "\u8bf8\u4e8b\u4e0d\u5b9c", "\u9020\u5e99", "\u89e3\u9664", "\u9664\u670d", "\u754b\u730e", "\u6cbb\u75c5", "\u5b9a\u78c9", "\u5f00\u5e02", "\u52a8\u571f", "\u5ac1\u5a36", "\u4fee\u9020"};
    }

    private AlmanacConsPros() {
        m5258a();
    }

    private void m5258a() {
        String a = DirectIndexedFileExtractor.m4222a(AppConstants.m4227a(), "huangli.idf");
        if (a != null && new File(a).exists()) {
            try {
                this.f3602d = DirectIndexedFile.m5369a(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f3602d == null) {
            try {
                this.f3602d = DirectIndexedFile.m5368a(AppConstants.m4227a().getResources().getAssets().open("huangli.idf", 1));
            } catch (IOException e2) {
                Log.w("AlmanacConsPros", "Can't read huangli.idf, NO huangli supported!");
            }
        }
    }

    protected void finalize() {
        if (this.f3602d != null) {
            this.f3602d.m5367b();
        }
        super.finalize();
    }
}
