package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface SocketFactory {
    OutputStream DW(Socket socket);

    InputStream j6(Socket socket);

    Socket j6(String str, int i);
}
