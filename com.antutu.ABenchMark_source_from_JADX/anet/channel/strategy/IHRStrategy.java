package anet.channel.strategy;

public interface IHRStrategy {
    long getHRInterval();

    String getHRStrategy();

    int getHrNum();

    long getLastHRTime();

    int getParallelConnNum();

    String getUrlPath();
}
