package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface Proxy {
    OutputStream DW();

    Socket FH();

    void Hw();

    InputStream j6();

    void j6(SocketFactory socketFactory, String str, int i, int i2);
}
