package com.jaredrummler.android.processes;

import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.jaredrummler.android.processes.models.AndroidAppProcess.C3964a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jaredrummler.android.processes.a */
public class C3962a {
    public static List<AndroidAppProcess> m16308a() {
        List<AndroidAppProcess> arrayList = new ArrayList();
        for (File file : new File("/proc").listFiles()) {
            if (file.isDirectory()) {
                try {
                    try {
                        arrayList.add(new AndroidAppProcess(Integer.parseInt(file.getName())));
                    } catch (C3964a e) {
                    } catch (IOException e2) {
                    }
                } catch (NumberFormatException e3) {
                }
            }
        }
        return arrayList;
    }
}
