package com.qq.p035e.comm.pi;

import android.view.ViewGroup;
import com.qq.p035e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.NSPVI */
public interface NSPVI {
    void fetchAndShowIn(ViewGroup viewGroup);

    void setAdListener(ADListener aDListener);

    void setFetchDelay(int i);
}
