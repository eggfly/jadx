package anet.channel;

import anet.channel.p017a.C0644a;
import anet.channel.statist.RequestStatistic;
import java.util.List;
import java.util.Map;

public interface RequestCb {
    void onDataReceive(C0644a c0644a, boolean z);

    void onFinish(int i, String str, RequestStatistic requestStatistic);

    void onResponseCode(int i, Map<String, List<String>> map);
}
