package com.jcraft.jsch;

class JSchAuthCancelException extends JSchException {
    String j6;

    JSchAuthCancelException() {
    }

    JSchAuthCancelException(String str) {
        super(str);
        this.j6 = str;
    }
}
