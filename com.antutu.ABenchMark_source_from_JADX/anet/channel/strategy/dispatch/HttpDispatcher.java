package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ENV;
import anet.channel.strategy.C0734n;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class HttpDispatcher {
    private C0720e executor;
    private Set<String> initHosts;
    private volatile boolean isEnable;
    private AtomicBoolean isInitHostsFilled;
    private CopyOnWriteArraySet<IDispatchEventListener> listeners;
    private Set<String> uniqueIdSet;

    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    private static class Singleton {
        static HttpDispatcher instance;

        static {
            instance = new HttpDispatcher();
        }

        private Singleton() {
        }
    }

    private HttpDispatcher() {
        this.listeners = new CopyOnWriteArraySet();
        this.executor = new C0720e();
        this.isEnable = true;
        this.uniqueIdSet = Collections.newSetFromMap(new ConcurrentHashMap());
        this.initHosts = new TreeSet();
        this.isInitHostsFilled = new AtomicBoolean();
        fillInitHosts();
    }

    private void fillInitHosts() {
        if (!this.isInitHostsFilled.get() && GlobalAppRuntimeInfo.getContext() != null && GlobalAppRuntimeInfo.isTargetProcess() && this.isInitHostsFilled.compareAndSet(false, true)) {
            this.initHosts.addAll(Arrays.asList(C0714a.f2352a));
            this.initHosts.add(C0734n.m2950a());
            this.initHosts.add(C0714a.m2914a());
            if (GlobalAppRuntimeInfo.getEnv() == ENV.ONLINE) {
                this.initHosts.add(C0734n.f2417c);
                this.initHosts.add(C0734n.f2419e);
            }
        }
    }

    public static HttpDispatcher getInstance() {
        return Singleton.instance;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            C0714a.f2352a = (String[]) list.toArray(new String[0]);
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.initHosts.addAll(list);
            this.uniqueIdSet.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.listeners.add(iDispatchEventListener);
    }

    void fireEvent(DispatchEvent dispatchEvent) {
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((IDispatchEventListener) it.next()).onEvent(dispatchEvent);
        }
    }

    public synchronized Set<String> getInitHosts() {
        fillInitHosts();
        return new HashSet(this.initHosts);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.uniqueIdSet.contains(str);
        if (!contains) {
            this.uniqueIdSet.add(str);
        }
        return !contains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.listeners.remove(iDispatchEventListener);
    }

    public void sendHttpDispatchRequest(Set<String> set, String str, int i) {
        if (this.isEnable && set != null && !set.isEmpty()) {
            Map hashMap = new HashMap();
            hashMap.put(C0714a.HOSTS, set);
            hashMap.put(C0714a.PRE_IP, str);
            hashMap.put(C0714a.CONFIG_VERSION, String.valueOf(i));
            this.executor.m2933a(hashMap);
        }
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void switchENV() {
        this.uniqueIdSet.clear();
        this.initHosts.clear();
        this.isInitHostsFilled.set(false);
    }
}
