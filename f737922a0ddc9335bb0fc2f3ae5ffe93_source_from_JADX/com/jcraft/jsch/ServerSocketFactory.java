package com.jcraft.jsch;

import java.net.InetAddress;
import java.net.ServerSocket;

public interface ServerSocketFactory {
    ServerSocket j6(int i, int i2, InetAddress inetAddress);
}
