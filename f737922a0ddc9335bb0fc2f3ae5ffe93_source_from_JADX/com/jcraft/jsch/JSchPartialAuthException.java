package com.jcraft.jsch;

class JSchPartialAuthException extends JSchException {
    String j6;

    public JSchPartialAuthException(String str) {
        super(str);
        this.j6 = str;
    }

    public String j6() {
        return this.j6;
    }
}
