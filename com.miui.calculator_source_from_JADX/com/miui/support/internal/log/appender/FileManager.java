package com.miui.support.internal.log.appender;

import com.miui.support.util.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileManager {
    protected String f2511a;
    protected String f2512b;
    protected File f2513c;
    private FileOutputStream f2514d;
    private OutputStreamWriter f2515e;
    private int f2516f;
    private long f2517g;

    public FileManager(String str, String str2) {
        this.f2511a = str;
        this.f2512b = str2;
    }

    public synchronized void m4201a() {
        this.f2513c = null;
        this.f2516f = 0;
        this.f2514d = null;
        IOUtils.m5390a(this.f2515e);
        this.f2515e = null;
        this.f2517g = 0;
    }
}
