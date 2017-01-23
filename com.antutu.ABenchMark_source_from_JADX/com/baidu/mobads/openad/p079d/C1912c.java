package com.baidu.mobads.openad.p079d;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.baidu.mobads.openad.d.c */
public class C1912c implements IOAdEventDispatcher {
    private Handler f6687a;
    protected Map<String, ArrayList<IOAdEventListener>> f6688c;

    public C1912c() {
        removeAllListeners();
        this.f6687a = new Handler(Looper.getMainLooper());
    }

    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str != null && iOAdEventListener != null) {
            removeEventListener(str, iOAdEventListener);
            ArrayList arrayList = (ArrayList) this.f6688c.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f6688c.put(str, arrayList);
            }
            arrayList.add(iOAdEventListener);
        }
    }

    public void dispatchEvent(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            iOAdEvent.setTarget(this);
            ArrayList arrayList = (ArrayList) this.f6688c.get(iOAdEvent.getType());
            if (arrayList != null) {
                IOAdEventListener[] iOAdEventListenerArr = new IOAdEventListener[arrayList.size()];
                arrayList.toArray(iOAdEventListenerArr);
                for (IOAdEventListener run : iOAdEventListenerArr) {
                    run.run(iOAdEvent);
                }
            }
        }
    }

    public void dispose() {
        removeAllListeners();
    }

    public boolean hasEventListener(String str) {
        ArrayList arrayList = (ArrayList) this.f6688c.get(str);
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public void removeAllListeners() {
        this.f6688c = new ConcurrentHashMap();
    }

    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str != null && iOAdEventListener != null) {
            ArrayList arrayList = (ArrayList) this.f6688c.get(str);
            if (arrayList != null) {
                arrayList.remove(iOAdEventListener);
                if (arrayList.isEmpty()) {
                    this.f6688c.remove(str);
                }
            }
        }
    }

    public void removeEventListeners(String str) {
        this.f6688c.remove(str);
    }
}
