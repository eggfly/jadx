package com.taobao.accs.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.io.Serializable;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public abstract class TaoBaseService extends Service implements AccsDataListener {
    private static final String TAG = "TaoBaseService";
    private AccsAbstractDataListener mDefaultDataListener;

    /* renamed from: com.taobao.accs.base.TaoBaseService.1 */
    class C40801 extends AccsAbstractDataListener {
        C40801() {
        }

        public void onBind(String str, int i, ExtraInfo extraInfo) {
        }

        public void onData(String str, String str2, String str3, byte[] bArr, ExtraInfo extraInfo) {
        }

        public void onResponse(String str, String str2, int i, byte[] bArr, ExtraInfo extraInfo) {
        }

        public void onSendData(String str, String str2, int i, ExtraInfo extraInfo) {
        }

        public void onUnbind(String str, int i, ExtraInfo extraInfo) {
        }
    }

    public static class ConnectInfo implements Serializable {
        private static final long serialVersionUID = 8974674111758240362L;
        public boolean connected;
        public int errorCode;
        public String errordetail;
        public String host;
        public boolean isCenterHost;
        public boolean isInapp;

        public ConnectInfo(String str, boolean z, boolean z2) {
            this.host = str;
            this.isInapp = z;
            this.isCenterHost = z2;
        }

        public ConnectInfo(String str, boolean z, boolean z2, int i, String str2) {
            this.host = str;
            this.isInapp = z;
            this.isCenterHost = z2;
            this.errorCode = i;
            this.errordetail = str2;
        }
    }

    public enum ExtHeaderType {
        TYPE_BUSINESS,
        TYPE_SID,
        TYPE_USERID,
        TYPE_COOKIE,
        TYPE_TAG,
        TYPE_STATUS,
        TYPE_DELAY,
        TYPE_EXPIRE,
        TYPE_LOCATION,
        TYPE_UNIT,
        TYPE_NEED_BUSINESS_ACK;

        public static ExtHeaderType valueOf(int i) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return TYPE_BUSINESS;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return TYPE_SID;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return TYPE_USERID;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return TYPE_COOKIE;
                case SpdyProtocol.QUIC /*4*/:
                    return TYPE_TAG;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    return TYPE_STATUS;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    return TYPE_DELAY;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    return TYPE_EXPIRE;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    return TYPE_LOCATION;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    return TYPE_UNIT;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    return TYPE_NEED_BUSINESS_ACK;
                default:
                    return null;
            }
        }
    }

    public static class ExtraInfo implements Serializable {
        public Map<ExtHeaderType, String> extHeader;
        public String fromHost;
        public String fromPackage;
    }

    public TaoBaseService() {
        this.mDefaultDataListener = new C40801();
    }

    public void onAntiBrush(boolean z, ExtraInfo extraInfo) {
        this.mDefaultDataListener.onAntiBrush(z, extraInfo);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onConnected(ConnectInfo connectInfo) {
        this.mDefaultDataListener.onConnected(connectInfo);
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDisconnected(ConnectInfo connectInfo) {
        this.mDefaultDataListener.onDisconnected(connectInfo);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return AccsAbstractDataListener.onReceiveData(this, intent, this);
    }
}
