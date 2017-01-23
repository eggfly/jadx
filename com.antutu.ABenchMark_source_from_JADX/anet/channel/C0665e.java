package anet.channel;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.session.AccsSession;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.strategy.C0734n;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/* renamed from: anet.channel.e */
public class C0665e {
    private final Map<SessionRequest, List<Session>> f2208a;
    private final ReentrantReadWriteLock f2209b;
    private final ReadLock f2210c;
    private final WriteLock f2211d;

    /* renamed from: anet.channel.e.a */
    private static class C0664a {
        public static C0665e f2207a;

        static {
            f2207a = new C0665e();
        }

        private C0664a() {
        }
    }

    private C0665e() {
        this.f2208a = new HashMap();
        this.f2209b = new ReentrantReadWriteLock();
        this.f2210c = this.f2209b.readLock();
        this.f2211d = this.f2209b.writeLock();
    }

    public Session m2789a(SessionRequest sessionRequest, TypeLevel typeLevel) {
        this.f2210c.lock();
        try {
            List<Session> list = (List) this.f2208a.get(sessionRequest);
            if (list == null || list.isEmpty()) {
                this.f2210c.unlock();
                return null;
            }
            Session session;
            for (Session session2 : list) {
                if (session2 != null && session2.isAvailable()) {
                    if (typeLevel == null || session2.mConnType.getTypeLevel() == typeLevel) {
                        session = session2;
                        break;
                    }
                }
            }
            session = null;
            String a = sessionRequest.m2746a();
            if (a != null && a.endsWith(C0734n.m2950a()) && list.size() > 1) {
                int i = 0;
                for (Session session22 : list) {
                    i = session22 instanceof AccsSession ? i + 1 : i;
                }
                if (i > 1) {
                    ALog.m2962e("awcn.SessionPool", "accs session count > 1", null, "sessions", list.toString());
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_DEPULICATE_ACCS_SESSION, null, "nw"));
                }
            }
            this.f2210c.unlock();
            return session;
        } catch (Throwable th) {
            this.f2210c.unlock();
        }
    }

    public List<SessionRequest> m2790a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f2210c.lock();
        try {
            if (!this.f2208a.isEmpty()) {
                list = new ArrayList(this.f2208a.keySet());
                this.f2210c.unlock();
            }
            return list;
        } finally {
            this.f2210c.unlock();
        }
    }

    public List<Session> m2791a(SessionRequest sessionRequest) {
        this.f2210c.lock();
        ArrayList arrayList;
        try {
            List list = (List) this.f2208a.get(sessionRequest);
            if (list != null) {
                arrayList = new ArrayList(list);
                return arrayList;
            }
            List<Session> list2 = Collections.EMPTY_LIST;
            this.f2210c.unlock();
            return list2;
        } finally {
            arrayList = this.f2210c;
            arrayList.unlock();
        }
    }

    public List<Session> m2792a(ConnType connType) {
        List<Session> list = Collections.EMPTY_LIST;
        this.f2210c.lock();
        try {
            if (this.f2208a.isEmpty()) {
                return list;
            }
            List<Session> arrayList = new ArrayList();
            for (List<Session> list2 : this.f2208a.values()) {
                if (!(list2 == null || list2.isEmpty())) {
                    for (Session session : list2) {
                        if (session != null && session.getConnType().equals(connType)) {
                            arrayList.add(session);
                        }
                    }
                }
            }
            this.f2210c.unlock();
            return arrayList;
        } finally {
            this.f2210c.unlock();
        }
    }

    public List<Session> m2793a(String str) {
        return m2791a(SessionRequest.m2736a(str));
    }

    public void m2794a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest != null && sessionRequest.m2746a() != null && session != null) {
            this.f2211d.lock();
            try {
                List list = (List) this.f2208a.get(sessionRequest);
                if (list == null) {
                    list = new ArrayList();
                    this.f2208a.put(sessionRequest, list);
                }
                if (list.indexOf(session) == -1) {
                    list.add(session);
                    Collections.sort(list);
                    this.f2211d.unlock();
                }
            } finally {
                this.f2211d.unlock();
            }
        }
    }

    public void m2795b(SessionRequest sessionRequest, Session session) {
        this.f2211d.lock();
        try {
            List list = (List) this.f2208a.get(sessionRequest);
            if (list != null) {
                list.remove(session);
                if (list.size() == 0) {
                    this.f2208a.remove(sessionRequest);
                    SessionRequest.m2741a(sessionRequest);
                }
                this.f2211d.unlock();
            }
        } finally {
            this.f2211d.unlock();
        }
    }

    public boolean m2796c(SessionRequest sessionRequest, Session session) {
        boolean z = false;
        this.f2210c.lock();
        try {
            List list = (List) this.f2208a.get(sessionRequest);
            if (list == null) {
                return z;
            }
            boolean z2 = list.indexOf(session) != -1;
            this.f2210c.unlock();
            return z2;
        } finally {
            z = this.f2210c;
            z.unlock();
        }
    }
}
