package com.baidu.mobads.p080j;

import java.io.File;

/* renamed from: com.baidu.mobads.j.h */
class C1987h implements Runnable {
    final /* synthetic */ String f6935a;
    final /* synthetic */ C1986g f6936b;

    C1987h(C1986g c1986g, String str) {
        this.f6936b = c1986g;
        this.f6935a = str;
    }

    public void run() {
        String[] list = new File(this.f6935a).list();
        if (list != null && list.length > 0) {
            for (String file : list) {
                File file2 = new File(file);
                long currentTimeMillis = System.currentTimeMillis() - file2.lastModified();
                if (file2.exists() && currentTimeMillis > 604800000) {
                    file2.delete();
                }
            }
        }
    }
}
