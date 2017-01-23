package com.qq.p035e.comm.services;

import anet.channel.strategy.dispatch.C0714a;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.managers.status.SDKStatus;
import com.qq.p035e.comm.net.NetworkClient.Priority;
import com.qq.p035e.comm.net.NetworkClientImpl;
import com.qq.p035e.comm.net.rr.PlainRequest;
import com.qq.p035e.comm.net.rr.Request;
import com.qq.p035e.comm.net.rr.Request.Method;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;

/* renamed from: com.qq.e.comm.services.RetCodeService */
public class RetCodeService {
    private final Random f13550a;

    /* renamed from: com.qq.e.comm.services.RetCodeService.Holder */
    static class Holder {
        static final RetCodeService f13538a;

        static {
            f13538a = new RetCodeService();
        }

        private Holder() {
        }
    }

    /* renamed from: com.qq.e.comm.services.RetCodeService.RetCodeInfo */
    public static class RetCodeInfo {
        final String f13539a;
        final String f13540b;
        final String f13541c;
        final int f13542d;
        final int f13543e;
        final int f13544f;
        final int f13545g;
        final int f13546h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f13539a = str;
            this.f13540b = str2;
            this.f13541c = str3;
            this.f13542d = i;
            this.f13543e = i2;
            this.f13544f = i3;
            this.f13545g = i4;
            this.f13546h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f13539a + ", commandid=" + this.f13540b + ", releaseversion=" + this.f13541c + ", resultcode=" + this.f13542d + ", tmcost=" + this.f13543e + ", reqsize=" + this.f13544f + ", rspsize=" + this.f13545g + "]";
        }
    }

    /* renamed from: com.qq.e.comm.services.RetCodeService.SendTask */
    class SendTask implements Runnable {
        private RetCodeInfo f13547a;
        private int f13548b;
        private /* synthetic */ RetCodeService f13549c;

        SendTask(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
            this.f13549c = retCodeService;
            this.f13547a = retCodeInfo;
            this.f13548b = 100;
        }

        public void run() {
            RetCodeService.m16592a(this.f13549c, this.f13547a, this.f13548b);
        }
    }

    private RetCodeService() {
        this.f13550a = new Random(System.currentTimeMillis());
    }

    private static String m16591a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return "0.0.0.0";
        }
    }

    static /* synthetic */ void m16592a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        Request plainRequest;
        if (retCodeService.m16593a(i)) {
            plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Method.GET, null);
            plainRequest.addQuery(ACTD.APPID_KEY, "1000162");
            plainRequest.addQuery("apn", String.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue()));
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f13542d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", BuildConfig.FLAVOR);
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f13543e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f13544f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f13545g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                String encode = URLEncoder.encode(GDTADManager.getInstance().getDeviceStatus().model, "utf-8");
                plainRequest.addQuery("deviceinfo", encode);
                plainRequest.addQuery("device", encode);
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f13540b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f13541c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(RetCodeService.m16591a(retCodeInfo.f13539a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, Priority.Low);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (retCodeService.m16593a(i)) {
            plainRequest = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Method.GET, null);
            plainRequest.addQuery(C0714a.DOMAIN, retCodeInfo.f13539a);
            plainRequest.addQuery("cgi", retCodeInfo.f13540b);
            plainRequest.addQuery(C4233j.f14402y, String.valueOf(retCodeInfo.f13546h));
            plainRequest.addQuery(Constants.KEY_HTTP_CODE, String.valueOf(retCodeInfo.f13542d));
            plainRequest.addQuery(C4233j.f14377D, String.valueOf(retCodeInfo.f13543e));
            plainRequest.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest, Priority.Low);
        }
    }

    private boolean m16593a(int i) {
        return this.f13550a.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f13538a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(this, retCodeInfo, 100)).start();
    }
}
