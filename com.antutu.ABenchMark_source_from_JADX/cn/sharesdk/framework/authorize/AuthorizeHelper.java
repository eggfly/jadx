package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;

public interface AuthorizeHelper {
    AuthorizeListener getAuthorizeListener();

    String getAuthorizeUrl();

    C0920b getAuthorizeWebviewClient(C0942e c0942e);

    Platform getPlatform();

    String getRedirectUri();

    SSOListener getSSOListener();

    C0916d getSSOProcessor(C0937c c0937c);
}
