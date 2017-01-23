package com.baidu.mobads.interfaces;

import java.util.HashMap;

public interface IXAdContainerFactory {
    IXAdContainer createXAdContainer(IXAdContainerContext iXAdContainerContext, HashMap<String, String> hashMap);

    Boolean getDebugMode();

    String getFullProxyVersion();

    double getProxyVersion();

    double getRemoteVersion();

    double handleShakeVersion(double d, String str);

    void setDebugMode(Boolean bool);
}
