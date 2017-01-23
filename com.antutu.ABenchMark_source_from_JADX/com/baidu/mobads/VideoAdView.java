package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.p103f.C2054b;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.ErrorCode;

public class VideoAdView extends RelativeLayout {
    private C2054b f6650a;
    private IOAdEventListener f6651b;
    private VideoAdViewListener f6652c;

    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        
        private int f6646a;

        private VideoDuration(int i) {
            this.f6646a = i;
        }

        protected int getValue() {
            return this.f6646a;
        }
    }

    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(NetWorkError.STUB_NETWORK_ERROR, ErrorCode.APP_NOT_BIND);
        
        private int f6648a;
        private int f6649b;

        private VideoSize(int i, int i2) {
            this.f6648a = i;
            this.f6649b = i2;
        }

        protected int getHeight() {
            return this.f6649b;
        }

        protected int getWidth() {
            return this.f6648a;
        }
    }

    public VideoAdView(Context context) {
        super(context);
        this.f6651b = new ah(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.f6651b = new ah(this);
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.f6650a = new C2054b(getContext(), "TODO");
        this.f6650a.setActivity(getContext());
        this.f6650a.setAdSlotBase(this);
        this.f6650a.addEventListener(IXAdEvent.AD_CLICK_THRU, this.f6651b);
        this.f6650a.addEventListener(IXAdEvent.AD_LOADED, this.f6651b);
        this.f6650a.addEventListener(IXAdEvent.AD_STARTED, this.f6651b);
        this.f6650a.addEventListener(IXAdEvent.AD_STOPPED, this.f6651b);
        this.f6650a.addEventListener(IXAdEvent.AD_ERROR, this.f6651b);
        this.f6650a.request();
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.f6652c = videoAdViewListener;
    }

    public void startVideo() {
        this.f6650a.start();
    }
}
