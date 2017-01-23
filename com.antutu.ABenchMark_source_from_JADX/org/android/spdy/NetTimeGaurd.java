package org.android.spdy;

import android.util.Log;

public class NetTimeGaurd {
    public static final int CREATE = 0;
    public static final int ERROR = 2;
    public static final int PING = 1;
    public static final int STREAM = 3;
    private static final long calltime = 10;
    private static final long total = 50;
    private static long[] totaltime;

    static {
        totaltime = new long[4];
    }

    static long begin() {
        return SpdyAgent.enableTimeGaurd ? System.currentTimeMillis() : 0;
    }

    static void end(String str, int i, long j) {
        if (SpdyAgent.enableTimeGaurd) {
            long currentTimeMillis = System.currentTimeMillis() - j;
            totaltime[i] = totaltime[i] + currentTimeMillis;
            Log.i("NetTimeGaurd", "NetTimeGaurd[end]" + str + " time=" + currentTimeMillis + " total=" + totaltime[i]);
            if (currentTimeMillis > calltime) {
                throw new SpdyErrorException("CallBack:" + str + " timeconsuming:" + currentTimeMillis + "  mustlessthan:" + calltime, -1);
            }
        }
    }

    static void finish(int i) {
        if (SpdyAgent.enableTimeGaurd) {
            Log.i("NetTimeGaurd", "NetTimeGaurd[finish]:time=" + totaltime[i]);
            if (totaltime[i] > total) {
                throw new SpdyErrorException("CallBack totaltimeconsuming:" + totaltime[i] + "  mustlessthan:" + total, -1);
            }
        }
    }

    static void start(int i) {
        if (SpdyAgent.enableTimeGaurd) {
            totaltime[i] = 0;
        }
    }
}
