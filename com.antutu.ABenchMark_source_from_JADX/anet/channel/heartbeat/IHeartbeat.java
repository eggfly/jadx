package anet.channel.heartbeat;

public interface IHeartbeat {
    long getInterval();

    void setNextHeartbeat(long j);

    void start();

    void stop();
}
