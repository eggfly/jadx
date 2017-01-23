package android.support.v4.net;

import android.os.Build.VERSION;

public class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl f630a;

    interface TrafficStatsCompatImpl {
    }

    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> f629a;

        /* renamed from: android.support.v4.net.TrafficStatsCompat.BaseTrafficStatsCompatImpl.1 */
        class C00651 extends ThreadLocal<SocketTags> {
            final /* synthetic */ BaseTrafficStatsCompatImpl f627a;

            C00651(BaseTrafficStatsCompatImpl baseTrafficStatsCompatImpl) {
                this.f627a = baseTrafficStatsCompatImpl;
            }

            protected /* synthetic */ Object initialValue() {
                return m999a();
            }

            protected SocketTags m999a() {
                return new SocketTags();
            }
        }

        private static class SocketTags {
            public int f628a;

            private SocketTags() {
                this.f628a = -1;
            }
        }

        BaseTrafficStatsCompatImpl() {
            this.f629a = new C00651(this);
        }
    }

    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f630a = new IcsTrafficStatsCompatImpl();
        } else {
            f630a = new BaseTrafficStatsCompatImpl();
        }
    }
}
