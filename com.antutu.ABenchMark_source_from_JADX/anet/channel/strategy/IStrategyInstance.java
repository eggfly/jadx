package anet.channel.strategy;

import anet.channel.entity.C0667d;
import anet.channel.entity.EventType;
import java.util.List;
import java.util.Map;

public interface IStrategyInstance {
    void forceRefreshStrategy(String str);

    String getCNameByHost(String str);

    String getClientIp();

    List<IConnStrategy> getConnStrategyListByHost(String str);

    String getFormalizeUrl(String str);

    @Deprecated
    String getFormalizeUrl(String str, String str2);

    Map<String, IHRStrategy> getHRStrategyMap();

    String getSchemeByHost(String str);

    String getUnitPrefix(String str, String str2);

    void initialize();

    void notifyConnEvent(String str, IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d);

    void saveData();

    void setUnitPrefix(String str, String str2, String str3);

    void switchEnv();
}
