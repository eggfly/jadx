package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;

public interface ForwardedTCPIPDaemon extends Runnable {
    void j6(ChannelForwardedTCPIP channelForwardedTCPIP, InputStream inputStream, OutputStream outputStream);

    void j6(Object[] objArr);
}
