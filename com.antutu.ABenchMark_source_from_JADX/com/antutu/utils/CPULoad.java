package com.antutu.utils;

import com.facebook.ads.AdError;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPULoad {
    public long m_lIdle;
    public long m_lTotal;
    public long m_lUsage;

    public CPULoad() {
        this.m_lIdle = 0;
        this.m_lTotal = 0;
        this.m_lUsage = 0;
        ReadUsage();
    }

    private void ReadUsage() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), AdError.NETWORK_ERROR_CODE);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            long parseLong = ((((Long.parseLong(split[2]) + Long.parseLong(split[3])) + Long.parseLong(split[4])) + Long.parseLong(split[6])) + Long.parseLong(split[7])) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split[5]);
            this.m_lUsage = (long) ((100.0f * ((float) (parseLong - this.m_lTotal))) / ((float) (((parseLong - this.m_lTotal) + parseLong2) - this.m_lIdle)));
            this.m_lTotal = parseLong;
            this.m_lIdle = parseLong2;
        } catch (IOException e) {
        }
    }

    public long getUsage() {
        ReadUsage();
        if (this.m_lUsage < 0) {
            this.m_lUsage = 0;
        }
        if (this.m_lUsage > 100) {
            this.m_lUsage = 100;
        }
        return this.m_lUsage;
    }
}
