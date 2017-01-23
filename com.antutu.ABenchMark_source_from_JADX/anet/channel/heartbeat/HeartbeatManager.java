package anet.channel.heartbeat;

import anet.channel.Session;

public class HeartbeatManager {
    private static volatile IHeartbeatFactory heartbeatFactory;

    /* renamed from: anet.channel.heartbeat.HeartbeatManager.1 */
    final class C06741 implements IHeartbeatFactory {
        C06741() {
        }

        public IHeartbeat createHeartbeat(Session session) {
            return (session == null || session.getConnStrategy() == null || session.getConnStrategy().getHeartbeat() <= 0) ? null : new DefaultHeartbeatImpl(session);
        }
    }

    static {
        heartbeatFactory = new C06741();
    }

    public static IHeartbeatFactory getHeartbeatFactory() {
        return heartbeatFactory;
    }

    public static void setHeartbeatFactory(IHeartbeatFactory iHeartbeatFactory) {
        heartbeatFactory = iHeartbeatFactory;
    }
}
