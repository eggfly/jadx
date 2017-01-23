package org.android.spdy;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int MODE_QUIC = 256;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-3.1.7";
    private static Object domainHashLock;
    private static HashMap<String, Integer> domainHashMap;
    public static volatile boolean enableDebug;
    public static volatile boolean enableTimeGaurd;
    private static volatile SpdyAgent gSingleInstance;
    private static volatile boolean loadSucc;
    private static Object lock;
    private static final Lock f16438r;
    private static final ReentrantReadWriteLock rwLock;
    private static int totalDomain;
    private static final Lock f16439w;
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private AtomicBoolean closed;
    private String proxyPassword;
    private String proxyUsername;
    private HashMap<String, SpdySession> sessionMgr;
    private LinkedList<SpdySession> sessionQueue;

    static {
        enableDebug = HAVE_CLOSE;
        enableTimeGaurd = HAVE_CLOSE;
        rwLock = new ReentrantReadWriteLock();
        f16438r = rwLock.readLock();
        f16439w = rwLock.writeLock();
        loadSucc = HAVE_CLOSE;
        gSingleInstance = null;
        lock = new Object();
        domainHashLock = new Object();
        domainHashMap = new HashMap();
        totalDomain = ACCS_TEST_SERVER;
    }

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) {
        this.sessionMgr = new HashMap(5);
        this.sessionQueue = new LinkedList();
        this.closed = new AtomicBoolean();
        this.proxyUsername = null;
        this.proxyPassword = null;
        try {
            SoInstallMgrSdk.init(context);
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, ACCS_ONLINE_SERVER);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        this.closed.set(HAVE_CLOSE);
    }

    static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        int i = ACCS_TEST_SERVER;
        int i2 = ACCS_TEST_SERVER;
        while (i2 < bArr.length) {
            if ((bArr[i2] & MotionEventCompat.ACTION_MASK) < 32 || (bArr[i2] & MotionEventCompat.ACTION_MASK) > TransportMediator.KEYCODE_MEDIA_PLAY) {
                bArr[i2] = (byte) 63;
            }
            i2 += ACCS_ONLINE_SERVER;
        }
        while (i < bArr2.length) {
            if ((bArr2[i] & MotionEventCompat.ACTION_MASK) < 32 || (bArr2[i] & MotionEventCompat.ACTION_MASK) > TransportMediator.KEYCODE_MEDIA_PLAY) {
                bArr2[i] = (byte) 63;
            }
            i += ACCS_ONLINE_SERVER;
        }
    }

    private void agentIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", (int) TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
        checkLoadSo();
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.bioPingRecvCallback(spdySession, i);
        }
    }

    private void checkLoadSo() {
        if (!loadSucc) {
            try {
                synchronized (lock) {
                    if (loadSucc) {
                        return;
                    }
                    loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, ACCS_ONLINE_SERVER);
                    this.agentNativePtr = initAgent(ACCS_TEST_SERVER, ACCS_TEST_SERVER, ACCS_TEST_SERVER);
                    if (!loadSucc) {
                        throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", (int) TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    private native int closeSessionN(long j);

    public static int configIpStackMode(int i) {
        spduLog.Logi("tnet-jni", "[configIpStackMode] - " + i);
        return configIpStackModeN(i);
    }

    private static native int configIpStackModeN(int i);

    private native int configLogFileN(String str, int i, int i2);

    private native int configLogFileN(String str, int i, int i2, int i3);

    private static void crashReporter(int i) {
    }

    private native long createSessionN(long j, SpdySession spdySession, int i, byte[] bArr, char c, byte[] bArr2, char c2, byte[] bArr3, byte[] bArr4, Object obj, int i2, int i3, int i4);

    static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        String mapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        byte[] bytes = mapBodyToString != null ? mapBodyToString.getBytes() : spdyDataProvider.data;
        if (bytes == null || bytes.length < MB5) {
            return bytes;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bytes.length, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int freeAgent(long j);

    private int getDomainHashIndex(String str) {
        Integer num;
        synchronized (domainHashLock) {
            num = (Integer) domainHashMap.get(str);
            if (num == null) {
                HashMap hashMap = domainHashMap;
                int i = totalDomain + ACCS_ONLINE_SERVER;
                totalDomain = i;
                hashMap.put(str, Integer.valueOf(i));
                num = Integer.valueOf(totalDomain);
            }
        }
        return num.intValue();
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, null);
                }
            }
        }
        return gSingleInstance;
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, accsSSLCallback);
                }
            }
        }
        return gSingleInstance;
    }

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        } else if (spdySession.intenalcb != null) {
            return spdySession.intenalcb.getSSLMeta(spdySession);
        } else {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
            return null;
        }
    }

    private byte[] getSSLPublicKey(int i, byte[] bArr) {
        if (this.accsSSLCallback != null) {
            return this.accsSSLCallback.getSSLPublicKey(i, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return null;
    }

    private native long getSession(long j, byte[] bArr, char c);

    static void headJudge(Map<String, String> map) {
        if (map != null) {
            int i = ACCS_TEST_SERVER;
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                InvlidCharJudge(str.getBytes(), str2.getBytes());
                int length = ((str.length() + ACCS_ONLINE_SERVER) + str2.length()) + i;
                securityCheck(length, str2.length());
                i = length;
            }
        }
    }

    private native long initAgent(int i, int i2, int i3);

    @Deprecated
    public static void inspect(String str) {
    }

    private native void logFileCloseN();

    private native void logFileFlushN();

    static String mapBodyToString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map == null) {
            return null;
        }
        int i = ACCS_TEST_SERVER;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            stringBuilder.append(str).append('=').append(str2).append('&');
            int length = (str2.length() + (str.length() + ACCS_ONLINE_SERVER)) + i;
            tableListJudge(length);
            i = length;
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[(map.size() * 2)];
        int i = ACCS_TEST_SERVER;
        for (Entry entry : map.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr[i + ACCS_ONLINE_SERVER] = (String) entry.getValue();
            i += 2;
        }
        return strArr;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        } else if (spdySession.intenalcb != null) {
            return spdySession.intenalcb.putSSLMeta(spdySession, bArr);
        } else {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
            return -1;
        }
    }

    static void securityCheck(int i, int i2) {
        if (i >= KB32) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        } else if (i2 >= KB8) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i2, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    private native int setConTimeout(long j, int i);

    private native int setSessionKind(long j, int i);

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i, i2);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i, i2, i3, i4, bArr);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i, SpdyByteArray spdyByteArray, int i2) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, i2);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataRecvCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataSendCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyPingRecvCallback(spdySession, (long) i, obj);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i, int i2) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyRequestRecvCallback(spdySession, j, i2);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
            }
            spdySession.cleanUp();
        } catch (Throwable th) {
            spdySession.cleanUp();
        }
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionFailedError(spdySession, i, obj);
            }
            spdySession.cleanUp();
        } catch (Throwable th) {
            spdySession.cleanUp();
        }
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionOnWritable(spdySession, obj, i);
            }
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "[spdySessionOnWritable] - exception:" + th);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i, int i2, int i3, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j = 4294967295L & ((long) i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyStreamCloseCallback(spdySession, j, i2, i3, superviseData);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i, String[] strArr, int i2) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map stringArrayToMap = stringArrayToMap(strArr);
        long j = 4294967295L & ((long) i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyOnStreamResponse(spdySession, j, stringArrayToMap, i2);
        }
    }

    static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap(5);
        int i = ACCS_TEST_SERVER;
        while (i + 2 <= strArr.length) {
            if (strArr[i] == null || strArr[i + ACCS_ONLINE_SERVER] == null) {
                return null;
            }
            List list = (List) hashMap.get(strArr[i]);
            if (list == null) {
                list = new ArrayList(ACCS_ONLINE_SERVER);
                hashMap.put(strArr[i], list);
            }
            list.add(strArr[i + ACCS_ONLINE_SERVER]);
            i += 2;
        }
        return hashMap;
    }

    static void tableListJudge(int i) {
        if (i >= MB5) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    void clearSpdySession(String str, String str2, int i) {
        if (str != null) {
            f16439w.lock();
            if (str != null) {
                try {
                    this.sessionMgr.remove(str + str2 + i);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                } finally {
                    f16439w.unlock();
                }
            }
            f16439w.unlock();
        }
    }

    public void close() {
    }

    int closeSession(long j) {
        return closeSessionN(j);
    }

    public int configLogFile(String str, int i, int i2) {
        return loadSucc ? configLogFileN(str, i, i2) : -1;
    }

    public int configLogFile(String str, int i, int i2, int i3) {
        return loadSucc ? configLogFileN(str, i, i2, i3) : -1;
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i) {
        return createSession(str, BuildConfig.FLAVOR, obj, sessionCb, null, i, ACCS_TEST_SERVER);
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i) {
        return createSession(str, BuildConfig.FLAVOR, obj, sessionCb, sslCertcb, i, ACCS_TEST_SERVER);
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i) {
        return createSession(str, str2, obj, sessionCb, null, i, ACCS_TEST_SERVER);
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, -1);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2, int i3) {
        if (str == null) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        String str3;
        String[] split = str.split("/");
        String[] split2 = split[ACCS_TEST_SERVER].split(":");
        byte[] bytes = "0.0.0.0".getBytes();
        char c = '\u0000';
        if (split.length != ACCS_ONLINE_SERVER) {
            split = split[ACCS_ONLINE_SERVER].split(":");
            bytes = split[ACCS_TEST_SERVER].getBytes();
            c = (char) Integer.parseInt(split[ACCS_ONLINE_SERVER]);
            str3 = str;
        } else {
            str3 = str + "/0.0.0.0:0";
        }
        agentIsOpen();
        Object obj2 = null;
        f16438r.lock();
        try {
            SpdySession spdySession = (SpdySession) this.sessionMgr.get(str3 + str2 + i);
            if (this.sessionMgr.size() >= MAX_SPDY_SESSION_COUNT) {
                obj2 = ACCS_ONLINE_SERVER;
            }
            f16438r.unlock();
            if (obj2 != null) {
                throw new SpdyErrorException("SPDY_SESSION_EXCEED_MAXED: session count exceed max", (int) TnetStatusCode.TNET_SESSION_EXCEED_MAXED);
            } else if (spdySession != null) {
                spdySession.increRefCount();
                return spdySession;
            } else {
                f16439w.lock();
                try {
                    spdySession = (SpdySession) this.sessionMgr.get(str3 + str2 + i);
                } catch (Throwable th) {
                    spdySession = null;
                }
                if (spdySession != null) {
                    f16439w.unlock();
                    spdySession.increRefCount();
                    return spdySession;
                }
                try {
                    long createSessionN;
                    long j;
                    int i4;
                    SpdySession spdySession2 = new SpdySession(0, this, str3, str2, sessionCb, i, i2, obj);
                    int domainHashIndex = getDomainHashIndex(str2 + i);
                    if (this.proxyUsername == null || this.proxyPassword == null) {
                        createSessionN = createSessionN(this.agentNativePtr, spdySession2, domainHashIndex, split2[ACCS_TEST_SERVER].getBytes(), (char) Integer.parseInt(split2[ACCS_ONLINE_SERVER]), bytes, c, null, null, obj, i, i2, i3);
                    } else {
                        createSessionN = createSessionN(this.agentNativePtr, spdySession2, domainHashIndex, split2[ACCS_TEST_SERVER].getBytes(), (char) Integer.parseInt(split2[ACCS_ONLINE_SERVER]), bytes, c, this.proxyUsername.getBytes(), this.proxyPassword.getBytes(), obj, i, i2, i3);
                    }
                    spduLog.Logi("tnet-jni", " create new session: " + str);
                    if ((1 & createSessionN) == 1) {
                        j = 0;
                        i4 = (int) (createSessionN >> ACCS_ONLINE_SERVER);
                    } else {
                        i4 = ACCS_TEST_SERVER;
                        j = createSessionN;
                    }
                    if (j != 0) {
                        spdySession2.setSessionNativePtr(j);
                        this.sessionMgr.put(str3 + str2 + i, spdySession2);
                        this.sessionQueue.add(spdySession2);
                    } else if (i4 != 0) {
                        throw new SpdyErrorException("create session error: " + i4, i4);
                    } else {
                        spdySession2 = null;
                    }
                    f16439w.unlock();
                    return spdySession2;
                } catch (Throwable th2) {
                    f16439w.unlock();
                }
            }
        } catch (Throwable th3) {
            f16438r.unlock();
        }
    }

    public SpdySession createSession(SessionInfo sessionInfo) {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs());
    }

    public HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    public void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    public void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    void removeSession(SpdySession spdySession) {
        f16439w.lock();
        try {
            this.sessionQueue.remove(spdySession);
        } finally {
            f16439w.unlock();
        }
    }

    public void setAccsSslCallback(AccsSSLCallback accsSSLCallback) {
        spduLog.Logi("tnet-jni", "[setAccsSslCallback] - " + accsSSLCallback.getClass());
        this.accsSSLCallback = accsSSLCallback;
    }

    @Deprecated
    public int setConnectTimeOut(int i) {
        int i2 = ACCS_TEST_SERVER;
        agentIsOpen();
        try {
            i2 = setConTimeout(this.agentNativePtr, i);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        return i2;
    }

    public void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    @Deprecated
    public int setSessionKind(SpdySessionKind spdySessionKind) {
        int i = -1;
        agentIsOpen();
        try {
            i = setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        return i;
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i) {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i);
    }

    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i, int i2) {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i, i2);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i) {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, ACCS_TEST_SERVER, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, i2, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public void switchAccsServer(int i) {
    }
}
